package com.google.a.c.a;

final class b {
    private final byte[] a;
    private int b;

    b(int i) {
        this.a = new byte[i];
        this.b = 0;
    }

    void a(int i, boolean z) {
        this.a[i] = (byte) (z ? 1 : 0);
    }

    void a(boolean z, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.b;
            this.b = i3 + 1;
            a(i3, z);
        }
    }

    byte[] a(int i) {
        byte[] bArr = new byte[(this.a.length * i)];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = this.a[i2 / i];
        }
        return bArr;
    }
}
