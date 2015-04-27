package com.google.p007a.p011c.p012a;

/* renamed from: com.google.a.c.a.b */
final class C0151b {
    private final byte[] f533a;
    private int f534b;

    C0151b(int i) {
        this.f533a = new byte[i];
        this.f534b = 0;
    }

    void m978a(int i, boolean z) {
        this.f533a[i] = (byte) (z ? 1 : 0);
    }

    void m979a(boolean z, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.f534b;
            this.f534b = i3 + 1;
            m978a(i3, z);
        }
    }

    byte[] m980a(int i) {
        byte[] bArr = new byte[(this.f533a.length * i)];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = this.f533a[i2 / i];
        }
        return bArr;
    }
}
