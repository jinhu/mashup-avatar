package dev.game.legend.svgandroid;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.RectF;
import android.graphics.Shader;

import com.google.android.Util;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/*

   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */

/**
 * Entry point for parsing SVG files for Android.
 * Use one of the various static methods for parsing SVGs by resource, asset or input stream.
 * Optionally, a single color can be searched and replaced in the SVG while parsing.
 * You can also parse an svg path directly.
 *
 * @author Larva Labs, LLC
 * @see #getSVGFromResource(android.content.res.Resources, int)
 * @see #getSVGFromAsset(android.content.res.AssetManager, String)
 * @see #getSVGFromString(String)
 * @see #getSVGFromInputStream(java.io.InputStream)
 * @see #parsePath(String)
 */
public class SVGParser {

    static final String TAG = "SVGAndroid";

    /**
     * Parse SVG data from an input stream.
     *
     * @param svgData the input stream, with SVG XML data in UTF-8 character encoding.
     * @return the parsed SVG.
     * @throws SVGParseException if there is an error while parsing.
     */
    public static SVG getSVGFromInputStream(InputStream svgData) throws SVGParseException {
        return SVGParser.parse(svgData, 0, 0, false);
    }

    /**
     * Parse SVG data from a string.
     *
     * @param svgData the string containing SVG XML data.
     * @return the parsed SVG.
     * @throws SVGParseException if there is an error while parsing.
     */
    public static SVG getSVGFromString(String svgData) throws SVGParseException {
        return SVGParser.parse(new ByteArrayInputStream(svgData.getBytes()), 0, 0, false);
    }

    /**
     * Parse SVG data from an Android application resource.
     *
     * @param resources the Android context resources.
     * @param resId     the ID of the raw resource SVG.
     * @return the parsed SVG.
     * @throws SVGParseException if there is an error while parsing.
     */
    public static SVG getSVGFromResource(Resources resources, int resId) throws SVGParseException {
        return SVGParser.parse(resources.openRawResource(resId), 0, 0, false);
    }

    /**
     * Parse SVG data from an Android application asset.
     *
     * @param assetMngr the Android asset manager.
     * @param svgPath   the path to the SVG file in the application's assets.
     * @return the parsed SVG.
     * @throws SVGParseException if there is an error while parsing.
     * @throws IOException       if there was a problem reading the file.
     */
    public static SVG getSVGFromAsset(AssetManager assetMngr, String svgPath) throws SVGParseException, IOException {
        InputStream inputStream = assetMngr.open(svgPath);
        SVG svg = getSVGFromInputStream(inputStream);
        inputStream.close();
        return svg;
    }

    /**
     * Parse SVG data from an input stream, replacing a single color with another color.
     *
     * @param svgData      the input stream, with SVG XML data in UTF-8 character encoding.
     * @param searchColor  the color in the SVG to replace.
     * @param replaceColor the color with which to replace the search color.
     * @return the parsed SVG.
     * @throws SVGParseException if there is an error while parsing.
     */
    public static SVG getSVGFromInputStream(InputStream svgData, int searchColor, int replaceColor) throws SVGParseException {
        return SVGParser.parse(svgData, searchColor, replaceColor, false);
    }

    /**
     * Parse SVG data from a string.
     *
     * @param svgData      the string containing SVG XML data.
     * @param searchColor  the color in the SVG to replace.
     * @param replaceColor the color with which to replace the search color.
     * @return the parsed SVG.
     * @throws SVGParseException if there is an error while parsing.
     */
    public static SVG getSVGFromString(String svgData, int searchColor, int replaceColor) throws SVGParseException {
        return SVGParser.parse(new ByteArrayInputStream(svgData.getBytes()), searchColor, replaceColor, false);
    }

    /**
     * Parse SVG data from an Android application resource.
     *
     * @param resources    the Android context
     * @param resId        the ID of the raw resource SVG.
     * @param searchColor  the color in the SVG to replace.
     * @param replaceColor the color with which to replace the search color.
     * @return the parsed SVG.
     * @throws SVGParseException if there is an error while parsing.
     */
    public static SVG getSVGFromResource(Resources resources, int resId, int searchColor, int replaceColor) throws SVGParseException {
        return SVGParser.parse(resources.openRawResource(resId), searchColor, replaceColor, false);
    }

    /**
     * Parse SVG data from an Android application asset.
     *
     * @param assetMngr    the Android asset manager.
     * @param svgPath      the path to the SVG file in the application's assets.
     * @param searchColor  the color in the SVG to replace.
     * @param replaceColor the color with which to replace the search color.
     * @return the parsed SVG.
     * @throws SVGParseException if there is an error while parsing.
     * @throws IOException       if there was a problem reading the file.
     */
    public static SVG getSVGFromAsset(AssetManager assetMngr, String svgPath, int searchColor, int replaceColor) throws SVGParseException, IOException {
        InputStream inputStream = assetMngr.open(svgPath);
        SVG svg = getSVGFromInputStream(inputStream, searchColor, replaceColor);
        inputStream.close();
        return svg;
    }

    /**
     * Parses a single SVG path and returns it as a <code>android.graphics.Path</code> object.
     * An example path is <code>M250,150L150,350L350,350Z</code>, which draws a triangle.
     *
     * @param pathString the SVG path, see the specification <a href="http://www.w3.org/TR/SVG/paths.html">here</a>.
     */
    public static Path parsePath(String pathString) {
        return doPath(pathString);
    }

    public static SVG parse(InputStream inputStream, Integer aSearchColor, Integer aReplaceColor, boolean aWhiteMode) {
        return SVGParser.parse(inputStream, aSearchColor, aReplaceColor, null, null, aWhiteMode);
    }

    public static SVG parse(InputStream inputStream, Integer searchColor, Integer replaceColor, Integer aSecondarySearchColor, Integer aSecondaryReplaceColor, boolean whiteMode) throws SVGParseException {
        Util.debug("Parsing SVG...");
        try {
            long start = System.currentTimeMillis();
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
            XMLReader xMLReader = sp.getXMLReader();
            final Picture picture = new Picture();
            SVGHandler handler = new SVGHandler(picture);
            if (!(searchColor == null || replaceColor == null)) {
                handler.swapPrimaryColor(searchColor, replaceColor);
            }
            if (!(aSecondarySearchColor == null || aSecondaryReplaceColor == null)) {
                handler.swapSecondaryColor(aSecondarySearchColor, aSecondaryReplaceColor);
            }
            handler.setWhiteMode(whiteMode);
            xMLReader.setContentHandler(handler);
            xMLReader.parse(new InputSource(inputStream));

            
        Util.debug("Parsing complete in " + (System.currentTimeMillis() - start) + " millis.");
            SVG result = new SVG(picture, handler.mBounds);
            // Skip bounds if it was an empty pic
            if (!Float.isInfinite(handler.mLimits.top)) {
                result.setLimits(handler.mLimits);
            }
            return result;
        } catch (Exception e) {
            throw new SVGParseException(e);
        }
    }
   
    private static NumberParse parseNumbers(String s) {
        //Util.debug("Parsing numbers from: '" + s + "'");
        int n = s.length();
        int p = 0;
        ArrayList<Float> numbers = new ArrayList<Float>();
        boolean skipChar = false;
        for (int i = 1; i < n; i++) {
            if (skipChar) {
                skipChar = false;
                continue;
            }
            char c = s.charAt(i);
            switch (c) {
                // This ends the parsing, as we are on the next element
                case 'M':
                case 'm':
                case 'Z':
                case 'z':
                case 'L':
                case 'l':
                case 'H':
                case 'h':
                case 'V':
                case 'v':
                case 'C':
                case 'c':
                case 'S':
                case 's':
                case 'Q':
                case 'q':
                case 'T':
                case 't':
                case 'a':
                case 'A':
                case ')': {
                    String str = s.substring(p, i);
                    if (str.trim().length() > 0) {
                        //Util.debug("  Last: " + str);
                        Float f = Float.parseFloat(str);
                        numbers.add(f);
                    }
                    p = i;
                    return new NumberParse(numbers, p);
                }
                case '\n':
                case '\t':
                case ' ':
                case ',':
                case '-': {
                    String str = s.substring(p, i);
                    // Just keep moving if multiple whitespace
                    if (str.trim().length() > 0) {
                        //Util.debug("  Next: " + str);
                        Float f = Float.parseFloat(str);
                        numbers.add(f);
                        if (c == '-') {
                            p = i;
                        } else {
                            p = i + 1;
                            skipChar = true;
                        }
                    } else {
                        p++;
                    }
                    break;
                }
            }
        }
        String last = s.substring(p);
        if (last.length() > 0) {
            //Util.debug("  Last: " + last);
            try {
                numbers.add(Float.parseFloat(last));
            } catch (NumberFormatException nfe) {
                // Just white-space, forget it
            }
            p = s.length();
        }
        return new NumberParse(numbers, p);
    }

    private static Matrix parseTransform(String s) {
        if (s.startsWith("matrix(")) {
            NumberParse np = parseNumbers(s.substring("matrix(".length()));
            if (np.numbers.size() == 6) {
                Matrix matrix = new Matrix();
                matrix.setValues(new float[]{
                        // Row 1
                        np.numbers.get(0),
                        np.numbers.get(2),
                        np.numbers.get(4),
                        // Row 2
                        np.numbers.get(1),
                        np.numbers.get(3),
                        np.numbers.get(5),
                        // Row 3
                        0,
                        0,
                        1,
                });
                return matrix;
            }
        } else if (s.startsWith("translate(")) {
            NumberParse np = parseNumbers(s.substring("translate(".length()));
            if (np.numbers.size() > 0) {
                float tx = np.numbers.get(0);
                float ty = 0;
                if (np.numbers.size() > 1) {
                    ty = np.numbers.get(1);
                }
                Matrix matrix = new Matrix();
                matrix.postTranslate(tx, ty);
                return matrix;
            }
        } else if (s.startsWith("scale(")) {
            NumberParse np = parseNumbers(s.substring("scale(".length()));
            if (np.numbers.size() > 0) {
                float sx = np.numbers.get(0);
                float sy = 0;
                if (np.numbers.size() > 1) {
                    sy = np.numbers.get(1);
                }
                Matrix matrix = new Matrix();
                matrix.postScale(sx, sy);
                return matrix;
            }
        } else if (s.startsWith("skewX(")) {
            NumberParse np = parseNumbers(s.substring("skewX(".length()));
            if (np.numbers.size() > 0) {
                float angle = np.numbers.get(0);
                Matrix matrix = new Matrix();
                matrix.postSkew((float) Math.tan(angle), 0);
                return matrix;
            }
        } else if (s.startsWith("skewY(")) {
            NumberParse np = parseNumbers(s.substring("skewY(".length()));
            if (np.numbers.size() > 0) {
                float angle = np.numbers.get(0);
                Matrix matrix = new Matrix();
                matrix.postSkew(0, (float) Math.tan(angle));
                return matrix;
            }
        } else if (s.startsWith("rotate(")) {
            NumberParse np = parseNumbers(s.substring("rotate(".length()));
            if (np.numbers.size() > 0) {
                float angle = np.numbers.get(0);
                float cx = 0;
                float cy = 0;
                if (np.numbers.size() > 2) {
                    cx = np.numbers.get(1);
                    cy = np.numbers.get(2);
                }
                Matrix matrix = new Matrix();
                matrix.postTranslate(cx, cy);
                matrix.postRotate(angle);
                matrix.postTranslate(-cx, -cy);
                return matrix;
            }
        }
        return null;
    }

    /**
     * This is where the hard-to-parse paths are handled.
     * Uppercase rules are absolute positions, lowercase are relative.
     * Types of path rules:
     * <p/>
     * <ol>
     * <li>M/m - (x y)+ - Move to (without drawing)
     * <li>Z/z - (no params) - Close path (back to starting point)
     * <li>L/l - (x y)+ - Line to
     * <li>H/h - x+ - Horizontal ine to
     * <li>V/v - y+ - Vertical line to
     * <li>C/c - (x1 y1 x2 y2 x y)+ - Cubic bezier to
     * <li>S/s - (x2 y2 x y)+ - Smooth cubic bezier to (shorthand that assumes the x2, y2 from previous C/S is the x1, y1 of this bezier)
     * <li>Q/q - (x1 y1 x y)+ - Quadratic bezier to
     * <li>T/t - (x y)+ - Smooth quadratic bezier to (assumes previous control point is "reflection" of last one w.r.t. to current point)
     * </ol>
     * <p/>
     * Numbers are separate by whitespace, comma or nothing at all (!) if they are self-delimiting, (ie. begin with a - sign)
     *
     * @param s the path string from the XML
     */
    private static Path doPath(String s) {
        int n = s.length();
        ParserHelper ph = new ParserHelper(s, 0);
        ph.skipWhitespace();
        Path p = new Path();
        float lastX = 0;
        float lastY = 0;
        float lastX1 = 0;
        float lastY1 = 0;
        float subPathStartX = 0;
        float subPathStartY = 0;
        char prevCmd = 0;
        while (ph.pos < n) {
            char cmd = s.charAt(ph.pos);
            switch (cmd) {
                case '-':
                case '+':
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    if (prevCmd == 'm' || prevCmd == 'M') {
                        cmd = (char) (((int) prevCmd) - 1);
                        break;
                    } else if (prevCmd == 'c' || prevCmd == 'C') {
                        cmd = prevCmd;
                        break;
                    } else if (prevCmd == 'l' || prevCmd == 'L') {
                        cmd = prevCmd;
                        break;
                    }
                default: {
                    ph.advance();
                    prevCmd = cmd;
                }
            }

            boolean wasCurve = false;
            switch (cmd) {
                case 'M':
                case 'm': {
                    float x = ph.nextFloat();
                    float y = ph.nextFloat();
                    if (cmd == 'm') {
                        subPathStartX += x;
                        subPathStartY += y;
                        p.rMoveTo(x, y);
                        lastX += x;
                        lastY += y;
                    } else {
                        subPathStartX = x;
                        subPathStartY = y;
                        p.moveTo(x, y);
                        lastX = x;
                        lastY = y;
                    }
                    break;
                }
                case 'Z':
                case 'z': {
                    p.close();
                    p.moveTo(subPathStartX, subPathStartY);
                    lastX = subPathStartX;
                    lastY = subPathStartY;
                    lastX1 = subPathStartX;
                    lastY1 = subPathStartY;
                    wasCurve = true;
                    break;
                }
                case 'L':
                case 'l': {
                    float x = ph.nextFloat();
                    float y = ph.nextFloat();
                    if (cmd == 'l') {
                        p.rLineTo(x, y);
                        lastX += x;
                        lastY += y;
                    } else {
                        p.lineTo(x, y);
                        lastX = x;
                        lastY = y;
                    }
                    break;
                }
                case 'H':
                case 'h': {
                    float x = ph.nextFloat();
                    if (cmd == 'h') {
                        p.rLineTo(x, 0);
                        lastX += x;
                    } else {
                        p.lineTo(x, lastY);
                        lastX = x;
                    }
                    break;
                }
                case 'V':
                case 'v': {
                    float y = ph.nextFloat();
                    if (cmd == 'v') {
                        p.rLineTo(0, y);
                        lastY += y;
                    } else {
                        p.lineTo(lastX, y);
                        lastY = y;
                    }
                    break;
                }
                case 'C':
                case 'c': {
                    wasCurve = true;
                    float x1 = ph.nextFloat();
                    float y1 = ph.nextFloat();
                    float x2 = ph.nextFloat();
                    float y2 = ph.nextFloat();
                    float x = ph.nextFloat();
                    float y = ph.nextFloat();
                    if (cmd == 'c') {
                        x1 += lastX;
                        x2 += lastX;
                        x += lastX;
                        y1 += lastY;
                        y2 += lastY;
                        y += lastY;
                    }
                    p.cubicTo(x1, y1, x2, y2, x, y);
                    lastX1 = x2;
                    lastY1 = y2;
                    lastX = x;
                    lastY = y;
                    break;
                }
                case 'S':
                case 's': {
                    wasCurve = true;
                    float x2 = ph.nextFloat();
                    float y2 = ph.nextFloat();
                    float x = ph.nextFloat();
                    float y = ph.nextFloat();
                    if (cmd == 's') {
                        x2 += lastX;
                        x += lastX;
                        y2 += lastY;
                        y += lastY;
                    }
                    float x1 = 2 * lastX - lastX1;
                    float y1 = 2 * lastY - lastY1;
                    p.cubicTo(x1, y1, x2, y2, x, y);
                    lastX1 = x2;
                    lastY1 = y2;
                    lastX = x;
                    lastY = y;
                    break;
                }
                case 'A':
                case 'a': {
                    float rx = ph.nextFloat();
                    float ry = ph.nextFloat();
                    float theta = ph.nextFloat();
                    int largeArc = (int) ph.nextFloat();
                    int sweepArc = (int) ph.nextFloat();
                    float x = ph.nextFloat();
                    float y = ph.nextFloat();
                    drawArc(p, lastX, lastY, x, y, rx, ry, theta, largeArc, sweepArc);
                    lastX = x;
                    lastY = y;
                    break;
                }
            }
            if (!wasCurve) {
                lastX1 = lastX;
                lastY1 = lastY;
            }
            ph.skipWhitespace();
        }
        return p;
    }

    private static void drawArc(Path p, float lastX, float lastY, float x, float y, float rx, float ry, float theta, int largeArc, int sweepArc) {
        // todo - not implemented yet, may be very hard to do using Android drawing facilities.
    }

    private static NumberParse getNumberParseAttr(String name, Attributes attributes) {
        int n = attributes.getLength();
        for (int i = 0; i < n; i++) {
            if (attributes.getLocalName(i).equals(name)) {
                return parseNumbers(attributes.getValue(i));
            }
        }
        return null;
    }

    private static String getStringAttr(String name, Attributes attributes) {
        int n = attributes.getLength();
        for (int i = 0; i < n; i++) {
            if (attributes.getLocalName(i).equals(name)) {
                return attributes.getValue(i);
            }
        }
        return null;
    }

    private static Float getFloatAttr(String name, Attributes attributes) {
        return getFloatAttr(name, attributes, null);
    }

    private static Float getFloatAttr(String name, Attributes attributes, Float defaultValue) {
        String v = getStringAttr(name, attributes);
        if (v == null) {
            return defaultValue;
        } else {
            if (v.endsWith("px")) {
                v = v.substring(0, v.length() - 2);
            }
//            Log.d(TAG, "Float parsing '" + name + "=" + v + "'");
            return Float.parseFloat(v);
        }
    }

    private static Integer getHexAttr(String name, Attributes attributes) {
        String v = getStringAttr(name, attributes);
        //Util.debug("Hex parsing '" + name + "=" + v + "'");
        if (v == null) {
            return null;
        } else {
            try {
                return Integer.parseInt(v.substring(1), 16);
            } catch (NumberFormatException nfe) {
                // todo - parse word-based color here
                return null;
            }
        }
    }
    
    private static class NumberParse {
        private ArrayList<Float> numbers;
        private int nextCmd;

        public NumberParse(ArrayList<Float> numbers, int nextCmd) {
            this.numbers = numbers;
            this.nextCmd = nextCmd;
        }

        public int getNextCmd() {
            return nextCmd;
        }

        public float getNumber(int index) {
            return numbers.get(index);
        }

    }

    private static class Gradient {
        String id;
        String xlink;
        boolean isLinear;
        float x1, y1, x2, y2;
        float x, y, radius;
        ArrayList<Float> positions = new ArrayList<Float>();
        ArrayList<Integer> colors = new ArrayList<Integer>();
        Matrix matrix = null;

        public Gradient createChild(Gradient g) {
            Gradient child = new Gradient();
            child.id = g.id;
            child.xlink = id;
            child.isLinear = g.isLinear;
            child.x1 = g.x1;
            child.x2 = g.x2;
            child.y1 = g.y1;
            child.y2 = g.y2;
            child.x = g.x;
            child.y = g.y;
            child.radius = g.radius;
            child.positions = positions;
            child.colors = colors;
            child.matrix = matrix;
            if (g.matrix != null) {
                if (matrix == null) {
                    child.matrix = g.matrix;
                } else {
                    Matrix m = new Matrix(matrix);
                    m.preConcat(g.matrix);
                    child.matrix = m;
                }
            }
            return child;
        }
    }

    private static class StyleSet {
        HashMap<String, String> styleMap = new HashMap<String, String>();

        private StyleSet(String string) {
            String[] styles = string.split(";");
            for (String s : styles) {
                String[] style = s.split(":");
                if (style.length == 2) {
                    styleMap.put(style[0], style[1]);
                }
            }
        }

        public String getStyle(String name) {
            return styleMap.get(name);
        }
    }

    private static class Properties {
        StyleSet styles = null;
        Attributes atts;

        private Properties(Attributes atts) {
            this.atts = atts;
            String styleAttr = getStringAttr("style", atts);
            if (styleAttr != null) {
                styles = new StyleSet(styleAttr);
            }
        }

        public String getAttr(String name) {
            String v = null;
            if (styles != null) {
                v = styles.getStyle(name);
            }
            if (v == null) {
                v = getStringAttr(name, atts);
            }
            return v;
        }

        public String getString(String name) {
            return getAttr(name);
        }

        public Integer getHex(String name) {
            String v = getAttr(name);
            if (v == null || !v.startsWith("#")) {
                return null;
            } else {
                try {
                    return Integer.parseInt(v.substring(1), 16);
                } catch (NumberFormatException nfe) {
                    // todo - parse word-based color here
                    return null;
                }
            }
        }

        public Float getFloat(String name, float defaultValue) {
            Float v = getFloat(name);
            if (v == null) {
                return defaultValue;
            } else {
                return v;
            }
        }

        public Float getFloat(String name) {
            String v = getAttr(name);
            if (v == null) {
                return null;
            } else {
                try {
                    return Float.parseFloat(v);
                } catch (NumberFormatException nfe) {
                    return null;
                }
            }
        }
    }

    /* renamed from: com.google.android.apps.b.f */
    static class SVGHandler extends DefaultHandler {
        Picture mPicture;
        Canvas mCanvas;
        Paint mPaint;
        RectF mRect = new RectF();
        RectF mBounds;
        RectF mLimits= new RectF(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
        Integer mPrimarySearchColor;
        Integer mPrimaryReplaceColor;
        Integer mSecondarySearchColor;
        Integer mSecondaryReplaceColor;
        private boolean mHidden = false;
        private int mHideLevel= 0;
        private boolean mBoundsMode = false;
        private Float f1727o;
        private boolean mPushed;
        boolean mWhiteMode = false;
        HashMap<String, Shader> gradientMap = new HashMap<String, Shader>();
        HashMap<String, Gradient> gradientRefMap = new HashMap<String, Gradient>();
        Gradient gradient = null;
        
        private SVGHandler(Picture picture) {
            this.mRect = new RectF();
            this.mBounds = null;
            this.mLimits = new RectF(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
            this.mPrimarySearchColor = null;
            this.mPrimaryReplaceColor = null;
            this.mSecondarySearchColor = null;
            this.mSecondaryReplaceColor = null;
            this.mWhiteMode = false;
            this.mHidden = false;
            this.mHideLevel = 0;
            this.mBoundsMode = false;
            this.f1727o = null;
            this.mPushed = false;
            this.mPicture = picture;
            this.mPaint = new Paint();
            this.mPaint.setAntiAlias(true);
        }

        private void popTransition() {
            if (this.mPushed) {
                this.mCanvas.restore();
            }
        }

        private void doLimits(float x, float y) {
            if (x < this.mLimits.left) {
                this.mLimits.left = x;
            }
            if (x > this.mLimits.right) {
                this.mLimits.right = x;
            }
            if (y < this.mLimits.top) {
                this.mLimits.top = y;
            }
            if (y > this.mLimits.bottom) {
                this.mLimits.bottom = y;
            }
        }

        private void doLimits(float left, float top, float right, float bottom) {
            doLimits(left, top);
            doLimits(left + right, top + bottom);
        }

        private void doLimits(Path path) {
            path.computeBounds(this.mRect, false);
            doLimits(this.mRect.left, this.mRect.top);
            doLimits(this.mRect.right, this.mRect.bottom);
        }

        private void doAlpha(Float f) {
            if (f == null) {
                this.mPaint.setAlpha(255);
            } else {
                this.mPaint.setAlpha((int) (255.0f * f.floatValue()));
            }
        }

        private void doColor(Attributes attributes, Integer num, boolean aFillMode) {
            int intValue = (16777215 & num.intValue()) | -16777216;
            if (this.mPrimarySearchColor != null && this.mPrimaryReplaceColor != null && this.mPrimarySearchColor.intValue() == intValue) {
                intValue = this.mPrimaryReplaceColor.intValue();
            } else if (!(this.mSecondarySearchColor == null || this.mSecondaryReplaceColor == null || this.mSecondarySearchColor.intValue() != intValue)) {
                intValue = this.mSecondaryReplaceColor.intValue();
            }
            this.mPaint.setColor(intValue);
            Float opacity =getFloatAttr("opacity",attributes);
            if (opacity == null) {
                opacity = getFloatAttr(aFillMode ? "fill-opacity" : "stroke-opacity", attributes );
            }
            if (opacity == null) {
                mPaint.setAlpha(255);
            } else {
                mPaint.setAlpha((int) (255 * opacity));
            }
        }

        private boolean doFill(Attributes attributes) {
            boolean z = true;
            if ("none".equals(getStringAttr("display", attributes))) {
                return false;
            }
            if (this.mWhiteMode) {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(-1);
                return true;
            }
            Integer b = getHexAttr("fill", attributes);
            if (b != null) {
                doColor(attributes, b, true);
                this.mPaint.setStyle(Paint.Style.FILL);
            } else if (getStringAttr("fill", attributes) == null && getStringAttr("stroke", attributes) == null) {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(-16777216);
            } else {
                z = false;
            }
            Float c = getFloatAttr("opacity", attributes);
            if (c != null) {
                doAlpha(c);
                return z;
            } else if (this.f1727o == null) {
                return z;
            } else {
                doAlpha(this.f1727o);
                return z;
            }
        }

        private boolean doStroke(Attributes attributes) {
            if (this.mWhiteMode || "none".equals(getStringAttr("display", attributes))) {
                return false;
            }
            Integer b = getHexAttr("stroke", attributes);
            if (b == null) {
                return false;
            }
            doColor(attributes, b, false);
            Float c = getFloatAttr("stroke-width", attributes);
            if (c != null) {
                this.mPaint.setStrokeWidth(c.floatValue());
            }
            String a = getStringAttr("stroke-linecap", attributes);
            if ("round".equals(a)) {
                this.mPaint.setStrokeCap(Paint.Cap.ROUND);
            } else if ("square".equals(a)) {
                this.mPaint.setStrokeCap(Paint.Cap.SQUARE);
            } else if ("butt".equals(a)) {
                this.mPaint.setStrokeCap(Paint.Cap.BUTT);
            }
            a = getStringAttr("stroke-linejoin", attributes);
            if ("miter".equals(a)) {
                this.mPaint.setStrokeJoin(Paint.Join.MITER);
            } else if ("round".equals(a)) {
                this.mPaint.setStrokeJoin(Paint.Join.ROUND);
            } else if ("bevel".equals(a)) {
                this.mPaint.setStrokeJoin(Paint.Join.BEVEL);
            }
            this.mPaint.setStyle(Paint.Style.STROKE);
            return true;
        }

        private void pushTransform(Attributes attributes) {
            String stringAttr = getStringAttr("transform", attributes);
            this.mPushed = stringAttr != null;
            if (this.mPushed) {
                Matrix matrix = parseTransform(stringAttr);
                this.mCanvas.save();
                this.mCanvas.concat(matrix);
            }
        }

        public void swapPrimaryColor(Integer num, Integer num2) {
            this.mPrimarySearchColor = num;
            this.mPrimaryReplaceColor = num2;
        }

        public void setWhiteMode(boolean z) {
            this.mWhiteMode = z;
        }

        public void swapSecondaryColor(Integer num, Integer num2) {
            this.mSecondarySearchColor = num;
            this.mSecondaryReplaceColor = num2;
        }

        public void characters(char[] cArr, int i, int i2) {
        }

        public void endDocument() {
        }

        public void endElement(String str, String str2, String str3) {
            if (str2.equals("svg")) {
                this.mPicture.endRecording();
            } else if (str2.equals("g")) {
                if (this.mBoundsMode) {
                    this.mBoundsMode = false;
                }
                if (this.mHidden) {
                    this.mHideLevel--;
                    if (this.mHideLevel == 0) {
                        this.mHidden = false;
                    }
                }
                this.f1727o = null;
            }
        }

        public void startDocument() {
        }

        public void startElement(String str, String elementName, String str3, Attributes attributes) {
            int i = 2;
            int i2 = 0;
            Float x;
            Float y;
            Float width;
            Float height;
            if (this.mBoundsMode) {
                if (elementName.equals("rect")) {
                    x = getFloatAttr("x", attributes);
                    if (x == null) {
                        x = Float.valueOf(0.0f);
                    }
                    y = getFloatAttr("y", attributes);
                    if (y == null) {
                        y = Float.valueOf(0.0f);
                    }
                    width = getFloatAttr("width", attributes);
                    height =getFloatAttr("height", attributes);
                    this.mBounds = new RectF(x.floatValue(), y.floatValue(), x.floatValue() + width.floatValue(), y.floatValue() + width.floatValue());
                }
            } else if (elementName.equals("svg")) {
                width = getFloatAttr("width", attributes);
                height = getFloatAttr("height", attributes);
                if (width == null || height == null) {
                    String viewBox = getStringAttr("viewBox", attributes);
                    if (viewBox != null) {
                        String[] split = viewBox.split("\\s+");
                        if (split.length == 4) {
                            i = (int) Float.parseFloat(split[2]);
                            i2 = (int) Float.parseFloat(split[3]);
                        }
                    }
                    i = 0;
                } else {
                    i = (int) Math.ceil((double) width.floatValue());
                    i2 = (int) Math.ceil((double) height.floatValue());
                }
                this.mCanvas = this.mPicture.beginRecording(i, i2);
            } else if (!elementName.equals("defs")) {
                if (elementName.equals("g")) {
                    String a2 = getStringAttr("id", attributes);
                    if (a2 != null && a2.toLowerCase().startsWith("bounds")) {
                        this.mBoundsMode = true;
                    }
                    if (this.mHidden) {
                        this.mHideLevel++;
                    }
                    if ("none".equals(getStringAttr("display", attributes)) && !this.mHidden) {
                        this.mHidden = true;
                        this.mHideLevel = 1;
                    }
                    x = getFloatAttr("opacity", attributes);
                    if (x != null) {
                        this.f1727o = x;
                    }
                } else if (!this.mHidden && elementName.equals("rect")) {
                    x = getFloatAttr("x", attributes);
                    Float valueOf = x == null ? Float.valueOf(0.0f) : x;
                    x = getFloatAttr("y", attributes);
                    Float valueOf2 = x == null ? Float.valueOf(0.0f) : x;
                    Float c4 = getFloatAttr("width", attributes);
                    Float c5 = getFloatAttr("height", attributes);
                    pushTransform(attributes);
                    if (doFill(attributes)) {
                        doLimits(valueOf.floatValue(), valueOf2.floatValue(), c4.floatValue(), c5.floatValue());
                        this.mCanvas.drawRect(valueOf.floatValue(), valueOf2.floatValue(), valueOf.floatValue() + c4.floatValue(), valueOf2.floatValue() + c5.floatValue(), this.mPaint);
                    }
                    if (doStroke(attributes)) {
                        this.mCanvas.drawRect(valueOf.floatValue(), valueOf2.floatValue(), valueOf.floatValue() + c4.floatValue(), valueOf2.floatValue() + c5.floatValue(), this.mPaint);
                    }
                    popTransition();
                } else if (!this.mHidden && elementName.equals("line")) {
                    y = getFloatAttr("x1", attributes);
                    height = getFloatAttr("x2", attributes);
                    width = getFloatAttr("y1", attributes);
                    Float c6 = getFloatAttr("y2", attributes);
                    if (doStroke(attributes)) {
                        pushTransform(attributes);
                        doLimits(y.floatValue(), width.floatValue());
                        doLimits(height.floatValue(), c6.floatValue());
                        this.mCanvas.drawLine(y.floatValue(), width.floatValue(), height.floatValue(), c6.floatValue(), this.mPaint);
                        popTransition();
                    }
                } else if (!this.mHidden && elementName.equals("circle")) {
                    x = getFloatAttr("cx", attributes);
                    y = getFloatAttr("cy", attributes);
                    width = getFloatAttr("r", attributes);
                    if (x != null && y != null && width != null) {
                        pushTransform(attributes);
                        if (doFill(attributes)) {
                            doLimits(x.floatValue() - width.floatValue(), y.floatValue() - width.floatValue());
                            doLimits(x.floatValue() + width.floatValue(), y.floatValue() + width.floatValue());
                            this.mCanvas.drawCircle(x.floatValue(), y.floatValue(), width.floatValue(), this.mPaint);
                        }
                        if (doStroke(attributes)) {
                            this.mCanvas.drawCircle(x.floatValue(), y.floatValue(), width.floatValue(), this.mPaint);
                        }
                        popTransition();
                    }
                } else if (!this.mHidden && elementName.equals("ellipse")) {
                    x = getFloatAttr("cx", attributes);
                    y = getFloatAttr("cy", attributes);
                    width = getFloatAttr("rx", attributes);
                    height = getFloatAttr("ry", attributes);
                    if (x != null && y != null && width != null && height != null) {
                        pushTransform(attributes);
                        this.mRect.set(x.floatValue() - width.floatValue(), y.floatValue() - height.floatValue(), x.floatValue() + width.floatValue(), y.floatValue() + height.floatValue());
                        if (doFill(attributes)) {
                            doLimits(x.floatValue() - width.floatValue(), y.floatValue() - height.floatValue());
                            doLimits(x.floatValue() + width.floatValue(), y.floatValue() + height.floatValue());
                            this.mCanvas.drawOval(this.mRect, this.mPaint);
                        }
                        if (doStroke(attributes)) {
                            this.mCanvas.drawOval(this.mRect, this.mPaint);
                        }
                        popTransition();
                    }
                } else if (!this.mHidden && (elementName.equals("polygon") || elementName.equals("polyline"))) {
                    NumberParse numberParse = getNumberParseAttr("points", attributes);
                    if (numberParse != null) {
                        Path path = new Path();
                        ArrayList numbers = numberParse.numbers;
                        if (numbers.size() > 1) {
                            pushTransform(attributes);
                            path.moveTo(((Float) numbers.get(0)).floatValue(), ((Float) numbers.get(1)).floatValue());
                            while (i < numbers.size()) {
                                path.lineTo(((Float) numbers.get(i)).floatValue(), ((Float) numbers.get(i + 1)).floatValue());
                                i += 2;
                            }
                            if (elementName.equals("polygon")) {
                                path.close();
                            }
                            if (doFill(attributes)) {
                                doLimits(path);
                                this.mCanvas.drawPath(path, this.mPaint);
                            }
                            if (doStroke(attributes)) {
                                this.mCanvas.drawPath(path, this.mPaint);
                            }
                            popTransition();
                        }
                    }
                } else if (!this.mHidden && elementName.equals("path")) {
                    Path path2 = parsePath(getStringAttr("d", attributes));
                    pushTransform(attributes);
                    if (doFill(attributes)) {
                        doLimits(path2);
                        this.mCanvas.drawPath(path2, this.mPaint);
                    }
                    if (doStroke(attributes)) {
                        this.mCanvas.drawPath(path2, this.mPaint);
                    }
                    popTransition();
                } else if (!this.mHidden) {
                    Util.debug("UNRECOGNIZED SVG COMMAND: " + elementName);
                }
            }
        }
    }

}
