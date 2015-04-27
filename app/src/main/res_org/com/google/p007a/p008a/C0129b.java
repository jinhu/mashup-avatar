package com.google.p007a.p008a;

/* renamed from: com.google.a.a.b */
public final class C0129b {
    private final int f447a;
    private final int f448b;
    private final int f449c;
    private final int[] f450d;

    public C0129b(int i, int i2) {
        if (i < 1 || i2 < 1) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f447a = i;
        this.f448b = i2;
        this.f449c = (i + 31) >> 5;
        this.f450d = new int[(this.f449c * i2)];
    }

    public void m943a() {
        int length = this.f450d.length;
        for (int i = 0; i < length; i++) {
            this.f450d[i] = 0;
        }
    }

    public void m944a(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        } else if (i4 < 1 || i3 < 1) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        } else {
            int i5 = i + i3;
            int i6 = i2 + i4;
            if (i6 > this.f448b || i5 > this.f447a) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i2 < i6) {
                int i7 = i2 * this.f449c;
                for (int i8 = i; i8 < i5; i8++) {
                    int[] iArr = this.f450d;
                    int i9 = (i8 >> 5) + i7;
                    iArr[i9] = iArr[i9] | (1 << (i8 & 31));
                }
                i2++;
            }
        }
    }

    public boolean m945a(int i, int i2) {
        return ((this.f450d[(this.f449c * i2) + (i >> 5)] >>> (i & 31)) & 1) != 0;
    }

    public int m946b() {
        return this.f447a;
    }

    public void m947b(int i, int i2) {
        int i3 = (this.f449c * i2) + (i >> 5);
        int[] iArr = this.f450d;
        iArr[i3] = iArr[i3] | (1 << (i & 31));
    }

    public int m948c() {
        return this.f448b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0129b)) {
            return false;
        }
        C0129b c0129b = (C0129b) obj;
        if (this.f447a != c0129b.f447a || this.f448b != c0129b.f448b || this.f449c != c0129b.f449c || this.f450d.length != c0129b.f450d.length) {
            return false;
        }
        for (int i = 0; i < this.f450d.length; i++) {
            if (this.f450d[i] != c0129b.f450d[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = this.f449c + (((((this.f447a * 31) + this.f447a) * 31) + this.f448b) * 31);
        for (int i2 : this.f450d) {
            i = (i * 31) + i2;
        }
        return i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.f448b * (this.f447a + 1));
        for (int i = 0; i < this.f448b; i++) {
            for (int i2 = 0; i2 < this.f447a; i2++) {
                stringBuilder.append(m945a(i2, i) ? "X " : "  ");
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
