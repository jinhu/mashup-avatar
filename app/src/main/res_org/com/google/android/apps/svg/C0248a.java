//package com.google.android.apps.svg;
//
///* renamed from: com.google.android.apps.b.a */
//public class C0248a {
//    private static final double[] f1703e;
//    public int f1704a;
//    private char f1705b;
//    private CharSequence f1706c;
//    private int f1707d;
//
//    static {
//        f1703e = new double[128];
//        for (int i = 0; i < f1703e.length; i++) {
//            f1703e[i] = Math.pow(10.0d, (double) i);
//        }
//    }
//
//    public C0248a(CharSequence charSequence, int i) {
//        this.f1706c = charSequence;
//        this.f1704a = i;
//        this.f1707d = charSequence.length();
//        this.f1705b = charSequence.charAt(i);
//    }
//
//    public static float m2007a(int i, int i2) {
//        if (i2 < -125 || i == 0) {
//            return 0.0f;
//        }
//        if (i2 >= 128) {
//            return i > 0 ? Float.POSITIVE_INFINITY : Float.NEGATIVE_INFINITY;
//        } else {
//            if (i2 == 0) {
//                return (float) i;
//            }
//            if (i >= 67108864) {
//                i++;
//            }
//            return (float) (i2 > 0 ? ((double) i) * f1703e[i2] : ((double) i) / f1703e[-i2]);
//        }
//    }
//
//    private void m2008a(char c) {
//        throw new RuntimeException("Unexpected char '" + c + "'.");
//    }
//
//    private char m2009f() {
//        if (this.f1704a < this.f1707d) {
//            this.f1704a++;
//        }
//        return this.f1704a == this.f1707d ? '\u0000' : this.f1706c.charAt(this.f1704a);
//    }
//
//    public void m2010a() {
//        while (this.f1704a < this.f1707d && Character.isWhitespace(this.f1706c.charAt(this.f1704a))) {
//            m2012c();
//        }
//    }
//
//    public void m2011b() {
//        while (this.f1704a < this.f1707d) {
//            switch (this.f1706c.charAt(this.f1704a)) {
//                case '\t':
//                case '\n':
//                case ' ':
//                case ',':
//                    m2012c();
//                default:
//                    return;
//            }
//        }
//    }
//
//    public void m2012c() {
//        this.f1705b = m2009f();
//    }
//
//    /* JADX WARNING: inconsistent code. */
//    /* Code decompiled incorrectly, please refer to instructions dump. */
//    public float m2013d() {
//        int i = 1;
//        int i2 = 0;
//        int i3;
//        switch (this.f1705b) {
//            case '+':
//                i3 = 1;
//                break;
//            case '-':
//                i3 = 0;
//                break;
//            default:
//                i3 = 1;
//                break;
//        }
//        this.f1705b = m2009f();
//        switch (this.f1705b) {
//            case '.':
//                int i4 = 0;
//                int i5 = 0;
//                int i6 = 0;
//                int i7 = 0;
//                break;
//            case '0':
//                break;
//            case '1':
//            case '2':
//            case '3':
//            case '4':
//            case '5':
//            case '6':
//            case '7':
//            case '8':
//            case '9':
//                break;
//            default:
//                return Float.NaN;
//        }
//    }
//
//    public float m2014e() {
//        float d = m2013d();
//        m2011b();
//        return d;
//    }
//}
