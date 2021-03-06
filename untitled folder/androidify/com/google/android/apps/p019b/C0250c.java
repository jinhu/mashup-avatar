package com.google.android.apps.p019b;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Picture;
import java.io.InputStream;
import java.util.ArrayList;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

/* renamed from: com.google.android.apps.b.c */
public class C0250c {
    public static Path m2015a(String str) {
        return C0250c.m2029g(str);
    }

    public static C0249b m2016a(InputStream inputStream, Integer num, Integer num2, Integer num3, Integer num4, boolean z) {
        System.currentTimeMillis();
        XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
        Picture picture = new Picture();
        C0253f c0253f = new C0253f(null);
        if (!(num == null || num2 == null)) {
            c0253f.m2042a(num, num2);
        }
        if (!(num3 == null || num4 == null)) {
            c0253f.m2044b(num3, num4);
        }
        c0253f.m2043a(z);
        xMLReader.setContentHandler(c0253f);
        xMLReader.parse(new InputSource(inputStream));
        C0249b c0249b = new C0249b(picture, c0253f.f1717e);
        if (!Float.isInfinite(c0253f.f1718f.top)) {
            c0249b.f1710c = c0253f.f1718f;
        }
        return c0249b;
    }

    public static C0249b m2017a(InputStream inputStream, Integer num, Integer num2, boolean z) {
        return C0250c.m2016a(inputStream, num, num2, null, null, z);
    }

    private static C0252e m2023d(String str) {
        int indexOf = str.indexOf(40);
        int indexOf2 = str.indexOf(41);
        ArrayList arrayList = new ArrayList();
        if (indexOf >= 0 && indexOf2 >= 0) {
            for (String parseFloat : str.substring(indexOf + 1, indexOf2).split("\\s+")) {
                arrayList.add(Float.valueOf(Float.parseFloat(parseFloat)));
            }
        }
        return new C0252e(arrayList, 0);
    }

    private static C0252e m2025e(String str) {
        String substring;
        int length = str.length();
        ArrayList arrayList = new ArrayList();
        Object obj = null;
        int i = 0;
        for (int i2 = 1; i2 < length; i2++) {
            if (obj == null) {
                char charAt = str.charAt(i2);
                switch (charAt) {
                    case '\t':
                    case '\n':
                    case ' ':
                    case ',':
                    case '-':
                        String substring2 = str.substring(i, i2);
                        if (substring2.trim().length() <= 0) {
                            i++;
                            break;
                        }
                        arrayList.add(Float.valueOf(Float.parseFloat(substring2)));
                        if (charAt != '-') {
                            i = i2 + 1;
                            int i3 = 1;
                            break;
                        }
                        i = i2;
                        break;
                    case ')':
                    case 'A':
                    case 'C':
                    case 'H':
                    case 'L':
                    case 'M':
                    case 'Q':
                    case 'S':
                    case 'T':
                    case 'V':
                    case 'Z':
                    case 'a':
                    case 'c':
                    case 'h':
                    case 'l':
                    case 'm':
                    case 'q':
                    case 's':
                    case 't':
                    case 'v':
                    case 'z':
                        substring = str.substring(i, i2);
                        if (substring.trim().length() > 0) {
                            arrayList.add(Float.valueOf(Float.parseFloat(substring)));
                        }
                        return new C0252e(arrayList, i2);
                    default:
                        break;
                }
            }
            obj = null;
        }
        substring = str.substring(i);
        if (substring.length() > 0) {
            try {
                arrayList.add(Float.valueOf(Float.parseFloat(substring)));
            } catch (NumberFormatException e) {
            }
            i = str.length();
        }
        return new C0252e(arrayList, i);
    }

    private static C0252e m2026e(String str, Attributes attributes) {
        int length = attributes.getLength();
        for (int i = 0; i < length; i++) {
            if (attributes.getLocalName(i).equals(str)) {
                return C0250c.m2025e(attributes.getValue(i));
            }
        }
        return null;
    }

    private static Matrix m2027f(String str) {
        float f = 0.0f;
        Matrix matrix;
        C0252e e;
        if (str.startsWith("matrix(")) {
            if (C0250c.m2023d(str).f1711a.size() == 6) {
                matrix = new Matrix();
                matrix.setValues(new float[]{((Float) e.f1711a.get(0)).floatValue(), ((Float) e.f1711a.get(2)).floatValue(), ((Float) e.f1711a.get(4)).floatValue(), ((Float) e.f1711a.get(1)).floatValue(), ((Float) e.f1711a.get(3)).floatValue(), ((Float) e.f1711a.get(5)).floatValue(), 0.0f, 0.0f, 1.0f});
                return matrix;
            }
        } else if (str.startsWith("translate(")) {
            r2 = C0250c.m2025e(str.substring("translate(".length()));
            if (r2.f1711a.size() > 0) {
                r3 = ((Float) r2.f1711a.get(0)).floatValue();
                r0 = r2.f1711a.size() > 1 ? ((Float) r2.f1711a.get(1)).floatValue() : 0.0f;
                Matrix matrix2 = new Matrix();
                matrix2.postTranslate(r3, r0);
                return matrix2;
            }
        } else if (str.startsWith("scale(")) {
            r2 = C0250c.m2025e(str.substring("scale(".length()));
            if (r2.f1711a.size() > 0) {
                r3 = ((Float) r2.f1711a.get(0)).floatValue();
                if (r2.f1711a.size() > 1) {
                    f = ((Float) r2.f1711a.get(1)).floatValue();
                }
                r0 = new Matrix();
                r0.postScale(r3, f);
                return r0;
            }
        } else if (str.startsWith("skewX(")) {
            r0 = C0250c.m2025e(str.substring("skewX(".length()));
            if (r0.f1711a.size() > 0) {
                r2 = ((Float) r0.f1711a.get(0)).floatValue();
                r0 = new Matrix();
                r0.postSkew((float) Math.tan((double) r2), 0.0f);
                return r0;
            }
        } else if (str.startsWith("skewY(")) {
            r0 = C0250c.m2025e(str.substring("skewY(".length()));
            if (r0.f1711a.size() > 0) {
                r2 = ((Float) r0.f1711a.get(0)).floatValue();
                r0 = new Matrix();
                r0.postSkew(0.0f, (float) Math.tan((double) r2));
                return r0;
            }
        } else if (str.startsWith("rotate(")) {
            e = C0250c.m2025e(str.substring("rotate(".length()));
            if (e.f1711a.size() > 0) {
                float floatValue = ((Float) e.f1711a.get(0)).floatValue();
                if (e.f1711a.size() > 2) {
                    r2 = ((Float) e.f1711a.get(1)).floatValue();
                    f = ((Float) e.f1711a.get(2)).floatValue();
                    r0 = r2;
                } else {
                    r0 = 0.0f;
                }
                matrix = new Matrix();
                matrix.postTranslate(r0, f);
                matrix.postRotate(floatValue);
                matrix.postTranslate(-r0, -f);
                return matrix;
            }
        }
        return null;
    }

    private static String m2028f(String str, Attributes attributes) {
        int length = attributes.getLength();
        for (int i = 0; i < length; i++) {
            if (attributes.getLocalName(i).equals(str)) {
                return attributes.getValue(i);
            }
        }
        return null;
    }

    private static Path m2029g(String str) {
        int length = str.length();
        C0248a c0248a = new C0248a(str, 0);
        c0248a.m2010a();
        Path path = new Path();
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        while (c0248a.f1704a < length) {
            float e;
            float e2;
            Object obj;
            float f5;
            char charAt = str.charAt(c0248a.f1704a);
            c0248a.m2012c();
            float e3;
            float e4;
            int i;
            switch (charAt) {
                case 'C':
                case 'c':
                    f3 = c0248a.m2014e();
                    f4 = c0248a.m2014e();
                    e = c0248a.m2014e();
                    e2 = c0248a.m2014e();
                    e3 = c0248a.m2014e();
                    e4 = c0248a.m2014e();
                    if (charAt == 'c') {
                        f3 += f2;
                        e += f2;
                        e3 += f2;
                        f4 += f;
                        e2 += f;
                        e4 += f;
                    }
                    path.cubicTo(f3, f4, e, e2, e3, e4);
                    f3 = e2;
                    f4 = e;
                    e = e4;
                    e2 = e3;
                    i = 1;
                    break;
                case 'H':
                case 'h':
                    e3 = c0248a.m2014e();
                    if (charAt != 'h') {
                        path.lineTo(e3, f);
                        e2 = e3;
                        obj = null;
                        e = f;
                        f5 = f3;
                        f3 = f4;
                        f4 = f5;
                        break;
                    }
                    path.rLineTo(e3, 0.0f);
                    f2 += e3;
                    obj = null;
                    e2 = f2;
                    e = f;
                    f5 = f3;
                    f3 = f4;
                    f4 = f5;
                    break;
                case 'L':
                case 'l':
                    e3 = c0248a.m2014e();
                    e4 = c0248a.m2014e();
                    if (charAt != 'l') {
                        path.lineTo(e3, e4);
                        e2 = e3;
                        obj = null;
                        e = e4;
                        f5 = f3;
                        f3 = f4;
                        f4 = f5;
                        break;
                    }
                    path.rLineTo(e3, e4);
                    f2 += e3;
                    obj = null;
                    e2 = f2;
                    e = f + e4;
                    f5 = f3;
                    f3 = f4;
                    f4 = f5;
                    break;
                case 'M':
                case 'm':
                    e3 = c0248a.m2014e();
                    e4 = c0248a.m2014e();
                    if (charAt != 'm') {
                        path.moveTo(e3, e4);
                        e2 = e3;
                        obj = null;
                        e = e4;
                        f5 = f3;
                        f3 = f4;
                        f4 = f5;
                        break;
                    }
                    path.rMoveTo(e3, e4);
                    f2 += e3;
                    obj = null;
                    e2 = f2;
                    e = f + e4;
                    f5 = f3;
                    f3 = f4;
                    f4 = f5;
                    break;
                case 'S':
                case 's':
                    e = c0248a.m2014e();
                    e2 = c0248a.m2014e();
                    e3 = c0248a.m2014e();
                    e4 = c0248a.m2014e();
                    if (charAt == 's') {
                        e += f2;
                        e3 += f2;
                        e2 += f;
                        e4 += f;
                    }
                    path.cubicTo((f2 * 2.0f) - f3, (f * 2.0f) - f4, e, e2, e3, e4);
                    f3 = e2;
                    f4 = e;
                    e = e4;
                    e2 = e3;
                    i = 1;
                    break;
                case 'V':
                case 'v':
                    e4 = c0248a.m2014e();
                    if (charAt != 'v') {
                        path.lineTo(f2, e4);
                        obj = null;
                        e2 = f2;
                        e = e4;
                        f5 = f3;
                        f3 = f4;
                        f4 = f5;
                        break;
                    }
                    path.rLineTo(0.0f, e4);
                    obj = null;
                    e2 = f2;
                    e = f + e4;
                    f5 = f3;
                    f3 = f4;
                    f4 = f5;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    obj = null;
                    e2 = f2;
                    e = f;
                    f5 = f3;
                    f3 = f4;
                    f4 = f5;
                    break;
                default:
                    obj = null;
                    e2 = f2;
                    e = f;
                    f5 = f3;
                    f3 = f4;
                    f4 = f5;
                    break;
            }
            if (obj == null) {
                f3 = e;
                f4 = e2;
            }
            c0248a.m2010a();
            f = e;
            f2 = e2;
            f5 = f3;
            f3 = f4;
            f4 = f5;
        }
        return path;
    }

    private static Float m2030g(String str, Attributes attributes) {
        String f = C0250c.m2028f(str, attributes);
        if (f == null) {
            return null;
        }
        if (f.endsWith("px")) {
            f = f.substring(0, f.length() - 2);
        }
        return Float.valueOf(Float.parseFloat(f));
    }

    private static Integer m2031h(String str, Attributes attributes) {
        Integer num = null;
        String f = C0250c.m2028f(str, attributes);
        if (f != null) {
            try {
                num = Integer.valueOf(Integer.parseInt(f.substring(1), 16));
            } catch (NumberFormatException e) {
            }
        }
        return num;
    }
}
