package com.google.p007a.p008a;

/* renamed from: com.google.a.a.a */
public final class C0128a {
    private int[] f445a;
    private int f446b;

    public C0128a() {
        this.f446b = 0;
        this.f445a = new int[1];
    }

    private void m933b(int i) {
        if (i > (this.f445a.length << 5)) {
            Object c = C0128a.m934c(i);
            System.arraycopy(this.f445a, 0, c, 0, this.f445a.length);
            this.f445a = c;
        }
    }

    private static int[] m934c(int i) {
        return new int[((i + 31) >> 5)];
    }

    public int m935a() {
        return this.f446b;
    }

    public void m936a(int i, int i2) {
        if (i2 < 0 || i2 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        m933b(this.f446b + i2);
        while (i2 > 0) {
            m939a(((i >> (i2 + -1)) & 1) == 1);
            i2--;
        }
    }

    public void m937a(int i, byte[] bArr, int i2, int i3) {
        int i4 = 0;
        int i5 = i;
        while (i4 < i3) {
            int i6 = i5;
            i5 = 0;
            for (int i7 = 0; i7 < 8; i7++) {
                if (m940a(i6)) {
                    i5 |= 1 << (7 - i7);
                }
                i6++;
            }
            bArr[i2 + i4] = (byte) i5;
            i4++;
            i5 = i6;
        }
    }

    public void m938a(C0128a c0128a) {
        int i = c0128a.f446b;
        m933b(this.f446b + i);
        for (int i2 = 0; i2 < i; i2++) {
            m939a(c0128a.m940a(i2));
        }
    }

    public void m939a(boolean z) {
        m933b(this.f446b + 1);
        if (z) {
            int[] iArr = this.f445a;
            int i = this.f446b >> 5;
            iArr[i] = iArr[i] | (1 << (this.f446b & 31));
        }
        this.f446b++;
    }

    public boolean m940a(int i) {
        return (this.f445a[i >> 5] & (1 << (i & 31))) != 0;
    }

    public int m941b() {
        return (this.f446b + 7) >> 3;
    }

    public void m942b(C0128a c0128a) {
        if (this.f445a.length != c0128a.f445a.length) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        for (int i = 0; i < this.f445a.length; i++) {
            int[] iArr = this.f445a;
            iArr[i] = iArr[i] ^ c0128a.f445a[i];
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.f446b);
        for (int i = 0; i < this.f446b; i++) {
            if ((i & 7) == 0) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(m940a(i) ? 'X' : '.');
        }
        return stringBuilder.toString();
    }
}
