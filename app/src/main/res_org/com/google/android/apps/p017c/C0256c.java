package com.google.android.apps.p017c;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.google.android.apps.c.c */
public class C0256c extends FilterOutputStream {
    private boolean f1761a;
    private int f1762b;
    private byte[] f1763c;
    private int f1764d;
    private int f1765e;
    private boolean f1766f;
    private byte[] f1767g;
    private boolean f1768h;
    private int f1769i;
    private byte[] f1770j;

    public C0256c(OutputStream outputStream, int i) {
        boolean z = true;
        super(outputStream);
        this.f1766f = (i & 8) != 0;
        if ((i & 1) == 0) {
            z = false;
        }
        this.f1761a = z;
        this.f1764d = this.f1761a ? 3 : 4;
        this.f1763c = new byte[this.f1764d];
        this.f1762b = 0;
        this.f1765e = 0;
        this.f1768h = false;
        this.f1767g = new byte[4];
        this.f1769i = i;
        this.f1770j = C0255b.m2076c(i);
    }

    public void m2078a() {
        if (this.f1762b <= 0) {
            return;
        }
        if (this.f1761a) {
            this.out.write(C0255b.m2075b(this.f1767g, this.f1763c, this.f1762b, this.f1769i));
            this.f1762b = 0;
            return;
        }
        throw new IOException("Base64 input not properly padded.");
    }

    public void close() {
        m2078a();
        super.close();
        this.f1763c = null;
        this.out = null;
    }

    public void write(int i) {
        if (this.f1768h) {
            this.out.write(i);
        } else if (this.f1761a) {
            r0 = this.f1763c;
            r1 = this.f1762b;
            this.f1762b = r1 + 1;
            r0[r1] = (byte) i;
            if (this.f1762b >= this.f1764d) {
                this.out.write(C0255b.m2075b(this.f1767g, this.f1763c, this.f1764d, this.f1769i));
                this.f1765e += 4;
                if (this.f1766f && this.f1765e >= 76) {
                    this.out.write(10);
                    this.f1765e = 0;
                }
                this.f1762b = 0;
            }
        } else if (this.f1770j[i & 127] > (byte) -5) {
            r0 = this.f1763c;
            r1 = this.f1762b;
            this.f1762b = r1 + 1;
            r0[r1] = (byte) i;
            if (this.f1762b >= this.f1764d) {
                this.out.write(this.f1767g, 0, C0255b.m2072b(this.f1763c, 0, this.f1767g, 0, this.f1769i));
                this.f1762b = 0;
            }
        } else if (this.f1770j[i & 127] != (byte) -5) {
            throw new IOException("Invalid character in Base64 data.");
        }
    }

    public void write(byte[] bArr, int i, int i2) {
        if (this.f1768h) {
            this.out.write(bArr, i, i2);
            return;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            write(bArr[i + i3]);
        }
    }
}
