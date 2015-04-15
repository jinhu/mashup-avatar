package com.google.a.a.a;

public final class a {
    public static final a a;
    public static final a b;
    public static final a c;
    public static final a d;
    public static final a e;
    public static final a f;
    public static final a g;
    public static final a h;
    private int[] i;
    private int[] j;
    private b k;
    private b l;
    private final int m;
    private final int n;
    private boolean o;

    static {
        a = new a(4201, 4096);
        b = new a(1033, 1024);
        c = new a(67, 64);
        d = new a(19, 16);
        e = new a(285, 256);
        f = new a(301, 256);
        g = f;
        h = c;
    }

    public a(int i, int i2) {
        this.o = false;
        this.n = i;
        this.m = i2;
        if (i2 <= 0) {
            b();
        }
    }

    static int b(int i, int i2) {
        return i ^ i2;
    }

    private void b() {
        int i;
        this.i = new int[this.m];
        this.j = new int[this.m];
        int i2 = 1;
        for (i = 0; i < this.m; i++) {
            this.i[i] = i2;
            i2 <<= 1;
            if (i2 >= this.m) {
                i2 = (i2 ^ this.n) & (this.m - 1);
            }
        }
        for (i = 0; i < this.m - 1; i++) {
            this.j[this.i[i]] = i;
        }
        this.k = new b(this, new int[]{0});
        this.l = new b(this, new int[]{1});
        this.o = true;
    }

    private void c() {
        if (!this.o) {
            b();
        }
    }

    int a(int i) {
        c();
        return this.i[i];
    }

    b a() {
        c();
        return this.k;
    }

    b a(int i, int i2) {
        c();
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.k;
        } else {
            int[] iArr = new int[(i + 1)];
            iArr[0] = i2;
            return new b(this, iArr);
        }
    }

    int b(int i) {
        c();
        if (i != 0) {
            return this.j[i];
        }
        throw new IllegalArgumentException();
    }

    int c(int i) {
        c();
        if (i != 0) {
            return this.i[(this.m - this.j[i]) - 1];
        }
        throw new ArithmeticException();
    }

    int c(int i, int i2) {
        c();
        return (i == 0 || i2 == 0) ? 0 : this.i[(this.j[i] + this.j[i2]) % (this.m - 1)];
    }
}
