//package com.google.android.apps.svg;
//
//import android.graphics.Canvas;
//import android.graphics.Matrix;
//import android.graphics.Paint;
//import android.graphics.Paint.Cap;
//import android.graphics.Paint.Join;
//import android.graphics.Paint.Style;
//import android.graphics.Path;
//import android.graphics.Picture;
//import android.graphics.RectF;
//import com.google.android.Util;
//import java.util.ArrayList;
//import org.xml.sax.Attributes;
//import org.xml.sax.helpers.DefaultHandler;
//
///* renamed from: com.google.android.apps.b.f */
//class C0253f extends DefaultHandler {
//    Picture f1713a;
//    Canvas f1714b;
//    Paint f1715c;
//    RectF f1716d;
//    RectF f1717e;
//    RectF f1718f;
//    Integer f1719g;
//    Integer f1720h;
//    Integer f1721i;
//    Integer f1722j;
//    boolean f1723k;
//    private boolean f1724l;
//    private int f1725m;
//    private boolean f1726n;
//    private Float f1727o;
//    private boolean f1728p;
//
//    private C0253f(Picture picture) {
//        this.f1716d = new RectF();
//        this.f1717e = null;
//        this.f1718f = new RectF(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
//        this.f1719g = null;
//        this.f1720h = null;
//        this.f1721i = null;
//        this.f1722j = null;
//        this.f1723k = false;
//        this.f1724l = false;
//        this.f1725m = 0;
//        this.f1726n = false;
//        this.f1727o = null;
//        this.f1728p = false;
//        this.f1713a = picture;
//        this.f1715c = new Paint();
//        this.f1715c.setAntiAlias(true);
//    }
//
//    private void m2033a() {
//        if (this.f1728p) {
//            this.f1714b.restore();
//        }
//    }
//
//    private void m2034a(float f, float f2) {
//        if (f < this.f1718f.left) {
//            this.f1718f.left = f;
//        }
//        if (f > this.f1718f.right) {
//            this.f1718f.right = f;
//        }
//        if (f2 < this.f1718f.top) {
//            this.f1718f.top = f2;
//        }
//        if (f2 > this.f1718f.bottom) {
//            this.f1718f.bottom = f2;
//        }
//    }
//
//    private void m2035a(float f, float f2, float f3, float f4) {
//        m2034a(f, f2);
//        m2034a(f + f3, f2 + f4);
//    }
//
//    private void m2036a(Path path) {
//        path.computeBounds(this.f1716d, false);
//        m2034a(this.f1716d.left, this.f1716d.top);
//        m2034a(this.f1716d.right, this.f1716d.bottom);
//    }
//
//    private void m2037a(Float f) {
//        if (f == null) {
//            this.f1715c.setAlpha(255);
//        } else {
//            this.f1715c.setAlpha((int) (255.0f * f.floatValue()));
//        }
//    }
//
//    private void m2038a(Attributes attributes, Integer num) {
//        int intValue = (16777215 & num.intValue()) | -16777216;
//        if (this.f1719g != null && this.f1720h != null && this.f1719g.intValue() == intValue) {
//            intValue = this.f1720h.intValue();
//        } else if (!(this.f1721i == null || this.f1722j == null || this.f1721i.intValue() != intValue)) {
//            intValue = this.f1722j.intValue();
//        }
//        this.f1715c.setColor(intValue);
//    }
//
//    private boolean m2039a(Attributes attributes) {
//        boolean z = true;
//        if ("none".equals(SVGParserEx.m2028f("display", attributes))) {
//            return false;
//        }
//        if (this.f1723k) {
//            this.f1715c.setStyle(Style.FILL);
//            this.f1715c.setColor(-1);
//            return true;
//        }
//        Integer b = SVGParserEx.m2031h("fill", attributes);
//        if (b != null) {
//            m2038a(attributes, b);
//            this.f1715c.setStyle(Style.FILL);
//        } else if (SVGParserEx.m2028f("fill", attributes) == null && SVGParserEx.m2028f("stroke", attributes) == null) {
//            this.f1715c.setStyle(Style.FILL);
//            this.f1715c.setColor(-16777216);
//        } else {
//            z = false;
//        }
//        Float c = SVGParserEx.parseString("opacity", attributes);
//        if (c != null) {
//            m2037a(c);
//            return z;
//        } else if (this.f1727o == null) {
//            return z;
//        } else {
//            m2037a(this.f1727o);
//            return z;
//        }
//    }
//
//    private boolean m2040b(Attributes attributes) {
//        if (this.f1723k || "none".equals(SVGParserEx.m2028f("display", attributes))) {
//            return false;
//        }
//        Integer b = SVGParserEx.m2031h("stroke", attributes);
//        if (b == null) {
//            return false;
//        }
//        m2038a(attributes, b);
//        Float c = SVGParserEx.parseString("stroke-width", attributes);
//        if (c != null) {
//            this.f1715c.setStrokeWidth(c.floatValue());
//        }
//        String a = SVGParserEx.m2028f("stroke-linecap", attributes);
//        if ("round".equals(a)) {
//            this.f1715c.setStrokeCap(Cap.ROUND);
//        } else if ("square".equals(a)) {
//            this.f1715c.setStrokeCap(Cap.SQUARE);
//        } else if ("butt".equals(a)) {
//            this.f1715c.setStrokeCap(Cap.BUTT);
//        }
//        a = SVGParserEx.m2028f("stroke-linejoin", attributes);
//        if ("miter".equals(a)) {
//            this.f1715c.setStrokeJoin(Join.MITER);
//        } else if ("round".equals(a)) {
//            this.f1715c.setStrokeJoin(Join.ROUND);
//        } else if ("bevel".equals(a)) {
//            this.f1715c.setStrokeJoin(Join.BEVEL);
//        }
//        this.f1715c.setStyle(Style.STROKE);
//        return true;
//    }
//
//    private void m2041c(Attributes attributes) {
//        String a = SVGParserEx.m2028f("transform", attributes);
//        this.f1728p = a != null;
//        if (this.f1728p) {
//            Matrix b = SVGParserEx.m2027f(a);
//            this.f1714b.save();
//            this.f1714b.concat(b);
//        }
//    }
//
//    public void m2042a(Integer num, Integer num2) {
//        this.f1719g = num;
//        this.f1720h = num2;
//    }
//
//    public void m2043a(boolean z) {
//        this.f1723k = z;
//    }
//
//    public void m2044b(Integer num, Integer num2) {
//        this.f1721i = num;
//        this.f1722j = num2;
//    }
//
//    public void characters(char[] cArr, int i, int i2) {
//    }
//
//    public void endDocument() {
//    }
//
//    public void endElement(String str, String str2, String str3) {
//        if (str2.equals("svg")) {
//            this.f1713a.endRecording();
//        } else if (str2.equals("g")) {
//            if (this.f1726n) {
//                this.f1726n = false;
//            }
//            if (this.f1724l) {
//                this.f1725m--;
//                if (this.f1725m == 0) {
//                    this.f1724l = false;
//                }
//            }
//            this.f1727o = null;
//        }
//    }
//
//    public void startDocument() {
//    }
//
//    public void startElement(String str, String str2, String str3, Attributes attributes) {
//        int i = 2;
//        int i2 = 0;
//        Float c;
//        Float c2;
//        Float c3;
//        if (this.f1726n) {
//            if (str2.equals("rect")) {
//                c = SVGParserEx.parseString("x", attributes);
//                if (c == null) {
//                    c = Float.valueOf(0.0f);
//                }
//                c2 = SVGParserEx.parseString("y", attributes);
//                if (c2 == null) {
//                    c2 = Float.valueOf(0.0f);
//                }
//                c3 = SVGParserEx.parseString("width", attributes);
//                SVGParserEx.parseString("height", attributes);
//                this.f1717e = new RectF(c.floatValue(), c2.floatValue(), c.floatValue() + c3.floatValue(), c2.floatValue() + c3.floatValue());
//            }
//        } else if (str2.equals("svg")) {
//            c3 = SVGParserEx.parseString("width", attributes);
//            r3 = SVGParserEx.parseString("height", attributes);
//            if (c3 == null || r3 == null) {
//                String a = SVGParserEx.parseString("viewBox", attributes);
//                if (a != null) {
//                    String[] split = a.split("\\s+");
//                    if (split.length == 4) {
//                        i = (int) Float.parseFloat(split[2]);
//                        i2 = (int) Float.parseFloat(split[3]);
//                    }
//                }
//                i = 0;
//            } else {
//                i = (int) Math.ceil((double) c3.floatValue());
//                i2 = (int) Math.ceil((double) r3.floatValue());
//            }
//            this.f1714b = this.f1713a.beginRecording(i, i2);
//        } else if (!str2.equals("defs")) {
//            if (str2.equals("g")) {
//                String a2 = SVGParserEx.parseString("id", attributes);
//                if (a2 != null && a2.toLowerCase().startsWith("bounds")) {
//                    this.f1726n = true;
//                }
//                if (this.f1724l) {
//                    this.f1725m++;
//                }
//                if ("none".equals(SVGParserEx.parseString("display", attributes)) && !this.f1724l) {
//                    this.f1724l = true;
//                    this.f1725m = 1;
//                }
//                c = SVGParserEx.parseString("opacity", attributes);
//                if (c != null) {
//                    this.f1727o = c;
//                }
//            } else if (!this.f1724l && str2.equals("rect")) {
//                c = SVGParserEx.parseString("x", attributes);
//                Float valueOf = c == null ? Float.valueOf(0.0f) : c;
//                c = SVGParserEx.parseString("y", attributes);
//                Float valueOf2 = c == null ? Float.valueOf(0.0f) : c;
//                Float c4 = SVGParserEx.parseString("width", attributes);
//                Float c5 = SVGParserEx.parseString("height", attributes);
//                m2041c(attributes);
//                if (m2039a(attributes)) {
//                    m2035a(valueOf.floatValue(), valueOf2.floatValue(), c4.floatValue(), c5.floatValue());
//                    this.f1714b.drawRect(valueOf.floatValue(), valueOf2.floatValue(), valueOf.floatValue() + c4.floatValue(), valueOf2.floatValue() + c5.floatValue(), this.f1715c);
//                }
//                if (m2040b(attributes)) {
//                    this.f1714b.drawRect(valueOf.floatValue(), valueOf2.floatValue(), valueOf.floatValue() + c4.floatValue(), valueOf2.floatValue() + c5.floatValue(), this.f1715c);
//                }
//                m2033a();
//            } else if (!this.f1724l && str2.equals("line")) {
//                c2 = SVGParserEx.parseString("x1", attributes);
//                r3 = SVGParserEx.parseString("x2", attributes);
//                c3 = SVGParserEx.parseString("y1", attributes);
//                Float c6 = SVGParserEx.parseString("y2", attributes);
//                if (m2040b(attributes)) {
//                    m2041c(attributes);
//                    m2034a(c2.floatValue(), c3.floatValue());
//                    m2034a(r3.floatValue(), c6.floatValue());
//                    this.f1714b.drawLine(c2.floatValue(), c3.floatValue(), r3.floatValue(), c6.floatValue(), this.f1715c);
//                    m2033a();
//                }
//            } else if (!this.f1724l && str2.equals("circle")) {
//                c = SVGParserEx.parseString("cx", attributes);
//                c2 = SVGParserEx.parseString("cy", attributes);
//                c3 = SVGParserEx.parseString("r", attributes);
//                if (c != null && c2 != null && c3 != null) {
//                    m2041c(attributes);
//                    if (m2039a(attributes)) {
//                        m2034a(c.floatValue() - c3.floatValue(), c2.floatValue() - c3.floatValue());
//                        m2034a(c.floatValue() + c3.floatValue(), c2.floatValue() + c3.floatValue());
//                        this.f1714b.drawCircle(c.floatValue(), c2.floatValue(), c3.floatValue(), this.f1715c);
//                    }
//                    if (m2040b(attributes)) {
//                        this.f1714b.drawCircle(c.floatValue(), c2.floatValue(), c3.floatValue(), this.f1715c);
//                    }
//                    m2033a();
//                }
//            } else if (!this.f1724l && str2.equals("ellipse")) {
//                c = SVGParserEx.parseString("cx", attributes);
//                c2 = SVGParserEx.parseString("cy", attributes);
//                c3 = SVGParserEx.parseString("rx", attributes);
//                r3 = SVGParserEx.parseString("ry", attributes);
//                if (c != null && c2 != null && c3 != null && r3 != null) {
//                    m2041c(attributes);
//                    this.f1716d.set(c.floatValue() - c3.floatValue(), c2.floatValue() - r3.floatValue(), c.floatValue() + c3.floatValue(), c2.floatValue() + r3.floatValue());
//                    if (m2039a(attributes)) {
//                        m2034a(c.floatValue() - c3.floatValue(), c2.floatValue() - r3.floatValue());
//                        m2034a(c.floatValue() + c3.floatValue(), c2.floatValue() + r3.floatValue());
//                        this.f1714b.drawOval(this.f1716d, this.f1715c);
//                    }
//                    if (m2040b(attributes)) {
//                        this.f1714b.drawOval(this.f1716d, this.f1715c);
//                    }
//                    m2033a();
//                }
//            } else if (!this.f1724l && (str2.equals("polygon") || str2.equals("polyline"))) {
//                C0252e d = SVGParserEx.m2026e("points", attributes);
//                if (d != null) {
//                    Path path = new Path();
//                    ArrayList a3 = d.f1711a;
//                    if (a3.size() > 1) {
//                        m2041c(attributes);
//                        path.moveTo(((Float) a3.get(0)).floatValue(), ((Float) a3.get(1)).floatValue());
//                        while (i < a3.size()) {
//                            path.lineTo(((Float) a3.get(i)).floatValue(), ((Float) a3.get(i + 1)).floatValue());
//                            i += 2;
//                        }
//                        if (str2.equals("polygon")) {
//                            path.close();
//                        }
//                        if (m2039a(attributes)) {
//                            m2036a(path);
//                            this.f1714b.drawPath(path, this.f1715c);
//                        }
//                        if (m2040b(attributes)) {
//                            this.f1714b.drawPath(path, this.f1715c);
//                        }
//                        m2033a();
//                    }
//                }
//            } else if (!this.f1724l && str2.equals("path")) {
//                Path c7 = SVGParserEx.m2029g(SVGParserEx.m2028f("d", attributes));
//                m2041c(attributes);
//                if (m2039a(attributes)) {
//                    m2036a(c7);
//                    this.f1714b.drawPath(c7, this.f1715c);
//                }
//                if (m2040b(attributes)) {
//                    this.f1714b.drawPath(c7, this.f1715c);
//                }
//                m2033a();
//            } else if (!this.f1724l) {
//                Log.debug("UNRECOGNIZED SVG COMMAND: " + str2);
//            }
//        }
//    }
//}
