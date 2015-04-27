package com.google.android.apps.p017c;

import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.google.android.apps.c.e */
class C0258e {
    int f1771a;
    int f1772b;
    int f1773c;
    int f1774d;
    int[] f1775e;
    int[] f1776f;
    int f1777g;
    int f1778h;
    boolean f1779i;
    int f1780j;
    int f1781k;
    int f1782l;
    int f1783m;
    int f1784n;
    int[] f1785o;
    int f1786p;
    byte[] f1787q;
    private int f1788r;
    private int f1789s;
    private byte[] f1790t;
    private int f1791u;
    private int f1792v;
    private int f1793w;

    C0258e(int i, int i2, byte[] bArr, int i3) {
        this.f1772b = 12;
        this.f1774d = 4096;
        this.f1775e = new int[5003];
        this.f1776f = new int[5003];
        this.f1777g = 5003;
        this.f1778h = 0;
        this.f1779i = false;
        this.f1783m = 0;
        this.f1784n = 0;
        this.f1785o = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};
        this.f1787q = new byte[256];
        this.f1788r = i;
        this.f1789s = i2;
        this.f1790t = bArr;
        this.f1791u = Math.max(2, i3);
    }

    private int m2079a() {
        if (this.f1792v == 0) {
            return -1;
        }
        this.f1792v--;
        byte[] bArr = this.f1790t;
        int i = this.f1793w;
        this.f1793w = i + 1;
        return bArr[i] & 255;
    }

    void m2080a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.f1787q;
        int i = this.f1786p;
        this.f1786p = i + 1;
        bArr[i] = b;
        if (this.f1786p >= 254) {
            m2087c(outputStream);
        }
    }

    void m2081a(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.f1775e[i2] = -1;
        }
    }

    void m2082a(int i, OutputStream outputStream) throws IOException {
        int i2;
        int i3 = 0;
        this.f1780j = i;
        this.f1779i = false;
        this.f1771a = this.f1780j;
        this.f1773c = m2084b(this.f1771a);
        this.f1781k = 1 << (i - 1);
        this.f1782l = this.f1781k + 1;
        this.f1778h = this.f1781k + 2;
        this.f1786p = 0;
        int a = m2079a();
        for (i2 = this.f1777g; i2 < 65536; i2 *= 2) {
            i3++;
        }
        int i4 = 8 - i3;
        int i5 = this.f1777g;
        m2081a(i5);
        m2085b(this.f1781k, outputStream);
        while (true) {
            i3 = m2079a();
            if (i3 != -1) {
                int i6 = (i3 << this.f1772b) + a;
                i2 = (i3 << i4) ^ a;
                int r3;
                int[] r0;
                if (this.f1775e[i2] == i6) {
                    a = this.f1776f[i2];
                } else if (this.f1775e[i2] >= 0) {
                    r3 = i5 - i2;
                    if (i2 == 0) {
                        r3 = 1;
                    }
                    do {
                        i2 -= r3;
                        if (i2 < 0) {
                            i2 += i5;
                        }
                        if (this.f1775e[i2] == i6) {
                            a = this.f1776f[i2];
                            break;
                        }
                    } while (this.f1775e[i2] >= 0);
                    m2085b(a, outputStream);
                    if (this.f1778h >= this.f1774d) {
                        r0 = this.f1776f;
                        r3 = this.f1778h;
                        this.f1778h = r3 + 1;
                        r0[i2] = r3;
                        this.f1775e[i2] = i6;
                        a = i3;
                    } else {
                        m2083a(outputStream);
                        a = i3;
                    }
                } else {
                    m2085b(a, outputStream);
                    if (this.f1778h >= this.f1774d) {
                        m2083a(outputStream);
                        a = i3;
                    } else {
                        r0 = this.f1776f;
                        r3 = this.f1778h;
                        this.f1778h = r3 + 1;
                        r0[i2] = r3;
                        this.f1775e[i2] = i6;
                        a = i3;
                    }
                }
            } else {
                m2085b(a, outputStream);
                m2085b(this.f1782l, outputStream);
                return;
            }
        }
    }

    void m2083a(OutputStream outputStream) {
        m2081a(this.f1777g);
        this.f1778h = this.f1781k + 2;
        this.f1779i = true;
        try {
            m2085b(this.f1781k, outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    final int m2084b(int i) {
        return (1 << i) - 1;
    }

    void m2085b(int i, OutputStream outputStream) throws IOException {
        this.f1783m &= this.f1785o[this.f1784n];
        if (this.f1784n > 0) {
            this.f1783m |= i << this.f1784n;
        } else {
            this.f1783m = i;
        }
        this.f1784n += this.f1771a;
        while (this.f1784n >= 8) {
            m2080a((byte) (this.f1783m & 255), outputStream);
            this.f1783m >>= 8;
            this.f1784n -= 8;
        }
        if (this.f1778h > this.f1773c || this.f1779i) {
            if (this.f1779i) {
                int i2 = this.f1780j;
                this.f1771a = i2;
                this.f1773c = m2084b(i2);
                this.f1779i = false;
            } else {
                this.f1771a++;
                if (this.f1771a == this.f1772b) {
                    this.f1773c = this.f1774d;
                } else {
                    this.f1773c = m2084b(this.f1771a);
                }
            }
        }
        if (i == this.f1782l) {
            while (this.f1784n > 0) {
                m2080a((byte) (this.f1783m & 255), outputStream);
                this.f1783m >>= 8;
                this.f1784n -= 8;
            }
            m2087c(outputStream);
        }
    }

    void m2086b(OutputStream outputStream) throws IOException {
        outputStream.write(this.f1791u);
        this.f1792v = this.f1788r * this.f1789s;
        this.f1793w = 0;
        m2082a(this.f1791u + 1, outputStream);
        outputStream.write(0);
    }

    void m2087c(OutputStream outputStream) throws IOException {
        if (this.f1786p > 0) {
            outputStream.write(this.f1786p);
            outputStream.write(this.f1787q, 0, this.f1786p);
            this.f1786p = 0;
        }
    }
}
