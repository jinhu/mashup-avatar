package com.google.a.a;

public final class a {
    private int[] a;
    private int b;

    public a() {
        this.b = 0;
        this.a = new int[1];
    }

    private void b(int i) {
        if (i > (this.a.length << 5)) {
            Object c = c(i);
            System.arraycopy(this.a, 0, c, 0, this.a.length);
            this.a = c;
        }
    }

    private static int[] c(int i) {
        return new int[((i + 31) >> 5)];
    }

    public int a() {
        return this.b;
    }

    public void a(int i, int i2) {
        if (i2 < 0 || i2 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        b(this.b + i2);
        while (i2 > 0) {
            a(((i >> (i2 + -1)) & 1) == 1);
            i2--;
        }
    }

    public void a(int i, byte[] bArr, int i2, int i3) {
        int i4 = 0;
        int i5 = i;
        while (i4 < i3) {
            int i6 = i5;
            i5 = 0;
            for (int i7 = 0; i7 < 8; i7++) {
                if (a(i6)) {
                    i5 |= 1 << (7 - i7);
                }
                i6++;
            }
            bArr[i2 + i4] = (byte) i5;
            i4++;
            i5 = i6;
        }
    }

    public void a(a aVar) {
        int i = aVar.b;
        b(this.b + i);
        for (int i2 = 0; i2 < i; i2++) {
            a(aVar.a(i2));
        }
    }

    public void a(boolean z) {
        b(this.b + 1);
        if (z) {
            int[] iArr = this.a;
            int i = this.b >> 5;
            iArr[i] = iArr[i] | (1 << (this.b & 31));
        }
        this.b++;
    }

    public boolean a(int i) {
        return (this.a[i >> 5] & (1 << (i & 31))) != 0;
    }

    public int b() {
        return (this.b + 7) >> 3;
    }

    public void b(a aVar) {
        if (this.a.length != aVar.a.length) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        for (int i = 0; i < this.a.length; i++) {
            int[] iArr = this.a;
            iArr[i] = iArr[i] ^ aVar.a[i];
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.b);
        for (int i = 0; i < this.b; i++) {
            if ((i & 7) == 0) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(a(i) ? 'X' : '.');
        }
        return stringBuilder.toString();
    }
}
