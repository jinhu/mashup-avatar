package com.google.p007a.p008a.p009a;

/* renamed from: com.google.a.a.a.a */
public final class C0125a {
    public static final C0125a f426a;
    public static final C0125a f427b;
    public static final C0125a f428c;
    public static final C0125a f429d;
    public static final C0125a f430e;
    public static final C0125a f431f;
    public static final C0125a f432g;
    public static final C0125a f433h;
    private int[] f434i;
    private int[] f435j;
    private C0126b f436k;
    private C0126b f437l;
    private final int f438m;
    private final int f439n;
    private boolean f440o;

    static {
        f426a = new C0125a(4201, 4096);
        f427b = new C0125a(1033, 1024);
        f428c = new C0125a(67, 64);
        f429d = new C0125a(19, 16);
        f430e = new C0125a(285, 256);
        f431f = new C0125a(301, 256);
        f432g = f431f;
        f433h = f428c;
    }

    public C0125a(int i, int i2) {
        this.f440o = false;
        this.f439n = i;
        this.f438m = i2;
        if (i2 <= 0) {
            m915b();
        }
    }

    static int m914b(int i, int i2) {
        return i ^ i2;
    }

    private void m915b() {
        int i;
        this.f434i = new int[this.f438m];
        this.f435j = new int[this.f438m];
        int i2 = 1;
        for (i = 0; i < this.f438m; i++) {
            this.f434i[i] = i2;
            i2 <<= 1;
            if (i2 >= this.f438m) {
                i2 = (i2 ^ this.f439n) & (this.f438m - 1);
            }
        }
        for (i = 0; i < this.f438m - 1; i++) {
            this.f435j[this.f434i[i]] = i;
        }
        this.f436k = new C0126b(this, new int[]{0});
        this.f437l = new C0126b(this, new int[]{1});
        this.f440o = true;
    }

    private void m916c() {
        if (!this.f440o) {
            m915b();
        }
    }

    int m917a(int i) {
        m916c();
        return this.f434i[i];
    }

    C0126b m918a() {
        m916c();
        return this.f436k;
    }

    C0126b m919a(int i, int i2) {
        m916c();
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.f436k;
        } else {
            int[] iArr = new int[(i + 1)];
            iArr[0] = i2;
            return new C0126b(this, iArr);
        }
    }

    int m920b(int i) {
        m916c();
        if (i != 0) {
            return this.f435j[i];
        }
        throw new IllegalArgumentException();
    }

    int m921c(int i) {
        m916c();
        if (i != 0) {
            return this.f434i[(this.f438m - this.f435j[i]) - 1];
        }
        throw new ArithmeticException();
    }

    int m922c(int i, int i2) {
        m916c();
        return (i == 0 || i2 == 0) ? 0 : this.f434i[(this.f435j[i] + this.f435j[i2]) % (this.f438m - 1)];
    }
}
