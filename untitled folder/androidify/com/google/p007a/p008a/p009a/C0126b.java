package com.google.p007a.p008a.p009a;

/* renamed from: com.google.a.a.a.b */
final class C0126b {
    private final C0125a f441a;
    private final int[] f442b;

    C0126b(C0125a c0125a, int[] iArr) {
        int i = 1;
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f441a = c0125a;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.f442b = iArr;
            return;
        }
        while (i < length && iArr[i] == 0) {
            i++;
        }
        if (i == length) {
            this.f442b = c0125a.m918a().f442b;
            return;
        }
        this.f442b = new int[(length - i)];
        System.arraycopy(iArr, i, this.f442b, 0, this.f442b.length);
    }

    int m923a(int i) {
        return this.f442b[(this.f442b.length - 1) - i];
    }

    C0126b m924a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.f441a.m918a();
        } else {
            int length = this.f442b.length;
            int[] iArr = new int[(length + i)];
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = this.f441a.m922c(this.f442b[i3], i2);
            }
            return new C0126b(this.f441a, iArr);
        }
    }

    C0126b m925a(C0126b c0126b) {
        if (!this.f441a.equals(c0126b.f441a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (m929c()) {
            return c0126b;
        } else {
            if (c0126b.m929c()) {
                return this;
            }
            Object obj = this.f442b;
            Object obj2 = c0126b.f442b;
            if (obj.length <= obj2.length) {
                Object obj3 = obj2;
                obj2 = obj;
                obj = obj3;
            }
            Object obj4 = new int[obj.length];
            int length = obj.length - r1.length;
            System.arraycopy(obj, 0, obj4, 0, length);
            for (int i = length; i < obj.length; i++) {
                obj4[i] = C0125a.m914b(r1[i - length], obj[i]);
            }
            return new C0126b(this.f441a, obj4);
        }
    }

    int[] m926a() {
        return this.f442b;
    }

    int m927b() {
        return this.f442b.length - 1;
    }

    C0126b m928b(C0126b c0126b) {
        if (!this.f441a.equals(c0126b.f441a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (m929c() || c0126b.m929c()) {
            return this.f441a.m918a();
        } else {
            int[] iArr = this.f442b;
            int length = iArr.length;
            int[] iArr2 = c0126b.f442b;
            int length2 = iArr2.length;
            int[] iArr3 = new int[((length + length2) - 1)];
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                for (int i3 = 0; i3 < length2; i3++) {
                    iArr3[i + i3] = C0125a.m914b(iArr3[i + i3], this.f441a.m922c(i2, iArr2[i3]));
                }
            }
            return new C0126b(this.f441a, iArr3);
        }
    }

    boolean m929c() {
        return this.f442b[0] == 0;
    }

    C0126b[] m930c(C0126b c0126b) {
        if (!this.f441a.equals(c0126b.f441a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (c0126b.m929c()) {
            throw new IllegalArgumentException("Divide by 0");
        } else {
            C0126b a = this.f441a.m918a();
            int c = this.f441a.m921c(c0126b.m923a(c0126b.m927b()));
            C0126b c0126b2 = a;
            a = this;
            while (a.m927b() >= c0126b.m927b() && !a.m929c()) {
                int b = a.m927b() - c0126b.m927b();
                int c2 = this.f441a.m922c(a.m923a(a.m927b()), c);
                C0126b a2 = c0126b.m924a(b, c2);
                c0126b2 = c0126b2.m925a(this.f441a.m919a(b, c2));
                a = a.m925a(a2);
            }
            return new C0126b[]{c0126b2, a};
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(m927b() * 8);
        for (int b = m927b(); b >= 0; b--) {
            int a = m923a(b);
            if (a != 0) {
                if (a < 0) {
                    stringBuilder.append(" - ");
                    a = -a;
                } else if (stringBuilder.length() > 0) {
                    stringBuilder.append(" + ");
                }
                if (b == 0 || a != 1) {
                    a = this.f441a.m920b(a);
                    if (a == 0) {
                        stringBuilder.append('1');
                    } else if (a == 1) {
                        stringBuilder.append('a');
                    } else {
                        stringBuilder.append("a^");
                        stringBuilder.append(a);
                    }
                }
                if (b != 0) {
                    if (b == 1) {
                        stringBuilder.append('x');
                    } else {
                        stringBuilder.append("x^");
                        stringBuilder.append(b);
                    }
                }
            }
        }
        return stringBuilder.toString();
    }
}
