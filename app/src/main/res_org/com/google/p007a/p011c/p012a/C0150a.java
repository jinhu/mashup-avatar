package com.google.p007a.p011c.p012a;

import java.lang.reflect.Array;

/* renamed from: com.google.a.c.a.a */
final class C0150a {
    private final C0151b[] f529a;
    private int f530b;
    private final int f531c;
    private final int f532d;

    C0150a(int i, int i2) {
        this.f529a = new C0151b[(i + 2)];
        int length = this.f529a.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.f529a[i3] = new C0151b(((i2 + 4) * 17) + 1);
        }
        this.f532d = i2 * 17;
        this.f531c = i + 2;
        this.f530b = 0;
    }

    void m975a() {
        this.f530b++;
    }

    byte[][] m976a(int i, int i2) {
        byte[][] bArr = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{this.f531c * i2, this.f532d * i});
        int i3 = this.f531c * i2;
        for (int i4 = 0; i4 < i3; i4++) {
            bArr[(i3 - i4) - 1] = this.f529a[i4 / i2].m980a(i);
        }
        return bArr;
    }

    C0151b m977b() {
        return this.f529a[this.f530b];
    }
}
