package com.google.android.apps.b;

public class a {
    private static final double[] e;
    public int a;
    private char b;
    private CharSequence c;
    private int d;

    static {
        e = new double[128];
        for (int i = 0; i < e.length; i++) {
            e[i] = Math.pow(10.0d, (double) i);
        }
    }

    public a(CharSequence charSequence, int i) {
        this.c = charSequence;
        this.a = i;
        this.d = charSequence.length();
        this.b = charSequence.charAt(i);
    }

    public static float a(int i, int i2) {
        if (i2 < -125 || i == 0) {
            return 0.0f;
        }
        if (i2 >= 128) {
            return i > 0 ? Float.POSITIVE_INFINITY : Float.NEGATIVE_INFINITY;
        } else {
            if (i2 == 0) {
                return (float) i;
            }
            if (i >= 67108864) {
                i++;
            }
            return (float) (i2 > 0 ? ((double) i) * e[i2] : ((double) i) / e[-i2]);
        }
    }

    private void a(char c) {
        throw new RuntimeException("Unexpected char '" + c + "'.");
    }

    private char f() {
        if (this.a < this.d) {
            this.a++;
        }
        return this.a == this.d ? '\u0000' : this.c.charAt(this.a);
    }

    public void a() {
        while (this.a < this.d && Character.isWhitespace(this.c.charAt(this.a))) {
            c();
        }
    }

    public void b() {
        while (this.a < this.d) {
            switch (this.c.charAt(this.a)) {
                case '\t':
                case '\n':
                case ' ':
                case ',':
                    c();
                default:
                    return;
            }
        }
    }

    public void c() {
        this.b = f();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public float d() {
        int i = 1;
        int i2 = 0;
        int i3;
        switch (this.b) {
            case '+':
                i3 = 1;
                break;
            case '-':
                i3 = 0;
                break;
            default:
                i3 = 1;
                break;
        }
        this.b = f();
        switch (this.b) {
            case '.':
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                break;
            case '0':
                break;
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                break;
            default:
                return Float.NaN;
        }
    }

    public float e() {
        float d = d();
        b();
        return d;
    }
}
