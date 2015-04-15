package com.google.a.a;

public final class b {
    private final int a;
    private final int b;
    private final int c;
    private final int[] d;

    public b(int i, int i2) {
        if (i < 1 || i2 < 1) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.a = i;
        this.b = i2;
        this.c = (i + 31) >> 5;
        this.d = new int[(this.c * i2)];
    }

    public void a() {
        int length = this.d.length;
        for (int i = 0; i < length; i++) {
            this.d[i] = 0;
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        } else if (i4 < 1 || i3 < 1) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        } else {
            int i5 = i + i3;
            int i6 = i2 + i4;
            if (i6 > this.b || i5 > this.a) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i2 < i6) {
                int i7 = i2 * this.c;
                for (int i8 = i; i8 < i5; i8++) {
                    int[] iArr = this.d;
                    int i9 = (i8 >> 5) + i7;
                    iArr[i9] = iArr[i9] | (1 << (i8 & 31));
                }
                i2++;
            }
        }
    }

    public boolean a(int i, int i2) {
        return ((this.d[(this.c * i2) + (i >> 5)] >>> (i & 31)) & 1) != 0;
    }

    public int b() {
        return this.a;
    }

    public void b(int i, int i2) {
        int i3 = (this.c * i2) + (i >> 5);
        int[] iArr = this.d;
        iArr[i3] = iArr[i3] | (1 << (i & 31));
    }

    public int c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.a != bVar.a || this.b != bVar.b || this.c != bVar.c || this.d.length != bVar.d.length) {
            return false;
        }
        for (int i = 0; i < this.d.length; i++) {
            if (this.d[i] != bVar.d[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = this.c + (((((this.a * 31) + this.a) * 31) + this.b) * 31);
        for (int i2 : this.d) {
            i = (i * 31) + i2;
        }
        return i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.b * (this.a + 1));
        for (int i = 0; i < this.b; i++) {
            for (int i2 = 0; i2 < this.a; i2++) {
                stringBuilder.append(a(i2, i) ? "X " : "  ");
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
