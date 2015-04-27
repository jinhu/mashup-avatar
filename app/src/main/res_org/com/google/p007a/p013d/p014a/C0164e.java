package com.google.p007a.p013d.p014a;

/* renamed from: com.google.a.d.a.e */
public final class C0164e {
    private final int f586a;
    private final C0163d[] f587b;

    C0164e(int i, C0163d... c0163dArr) {
        this.f586a = i;
        this.f587b = c0163dArr;
    }

    public int m1027a() {
        return this.f586a;
    }

    public int m1028b() {
        int i = 0;
        C0163d[] c0163dArr = this.f587b;
        int i2 = 0;
        while (i < c0163dArr.length) {
            i2 += c0163dArr[i].m1025a();
            i++;
        }
        return i2;
    }

    public int m1029c() {
        return this.f586a * m1028b();
    }

    public C0163d[] m1030d() {
        return this.f587b;
    }
}
