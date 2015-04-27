package com.google.android.apps.p017c;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.google.android.apps.androidify.Util;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.google.android.apps.c.a */
public class C0254a {
    protected int f1729a;
    protected int f1730b;
    protected int f1731c;
    protected int f1732d;
    protected int f1733e;
    protected int f1734f;
    protected int f1735g;
    protected int f1736h;
    protected boolean f1737i;
    protected OutputStream f1738j;
    protected Bitmap f1739k;
    protected byte[] f1740l;
    protected byte[] f1741m;
    protected int f1742n;
    protected byte[] f1743o;
    protected boolean[] f1744p;
    protected int f1745q;
    protected int f1746r;
    protected boolean f1747s;
    protected boolean f1748t;
    protected boolean f1749u;
    protected int f1750v;
    private int[] f1751w;
    private C0259f f1752x;
    private long f1753y;

    public C0254a() {
        this.f1731c = 0;
        this.f1732d = 0;
        this.f1733e = -1;
        this.f1735g = -1;
        this.f1736h = 0;
        this.f1737i = false;
        this.f1744p = new boolean[256];
        this.f1745q = 7;
        this.f1746r = -1;
        this.f1747s = false;
        this.f1748t = true;
        this.f1749u = false;
        this.f1750v = 10;
        this.f1753y = 0;
    }

    public long m2045a() {
        return this.f1753y;
    }

    public void m2046a(float f) {
        if (f != 0.0f) {
            this.f1736h = (int) (100.0f / f);
        }
    }

    public void m2047a(int i) {
        if (i >= 0) {
            this.f1735g = i;
        }
    }

    public void m2048a(int i, int i2) {
        this.f1729a = i;
        this.f1730b = i2;
        if (this.f1729a < 1) {
            this.f1729a = 320;
        }
        if (this.f1730b < 1) {
            this.f1730b = 240;
        }
        this.f1749u = true;
    }

    protected void m2049a(Bitmap bitmap, int[] iArr) {
        int width = bitmap.getWidth();
        bitmap.getPixels(iArr, 0, width, 0, 0, width, bitmap.getHeight());
    }

    protected void m2050a(String str) {
        for (int i = 0; i < str.length(); i++) {
            this.f1738j.write((byte) str.charAt(i));
        }
    }

    public boolean m2051a(Bitmap bitmap) {
        if (bitmap == null || !this.f1737i) {
            return false;
        }
        try {
            if (!this.f1749u) {
                m2048a(bitmap.getWidth(), bitmap.getHeight());
            }
            this.f1739k = bitmap;
            m2057d();
            m2055c();
            if (this.f1748t) {
                m2060g();
                m2062i();
                if (this.f1735g >= 0) {
                    m2061h();
                }
            }
            m2058e();
            m2059f();
            if (!this.f1748t) {
                m2062i();
            }
            m2063j();
            this.f1748t = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean m2052a(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.f1747s = false;
        this.f1738j = outputStream;
        try {
            m2050a("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.f1737i = z;
        return z;
    }

    protected int m2053b(int i) {
        int i2 = 0;
        if (this.f1743o == null) {
            return -1;
        }
        int i3 = (i >> 16) & 255;
        int i4 = (i >> 8) & 255;
        int i5 = (i >> 0) & 255;
        int i6 = 16777216;
        int length = this.f1743o.length;
        int i7 = 0;
        while (i2 < length) {
            int i8 = i2 + 1;
            i2 = i3 - (this.f1743o[i2] & 255);
            int i9 = i8 + 1;
            int i10 = i4 - (this.f1743o[i8] & 255);
            i8 = i5 - (this.f1743o[i9] & 255);
            i2 = ((i2 * i2) + (i10 * i10)) + (i8 * i8);
            i10 = i9 / 3;
            if (!this.f1744p[i10] || i2 >= i6) {
                i2 = i6;
                i6 = i7;
            } else {
                i6 = i10;
            }
            i7 = i6;
            i6 = i2;
            i2 = i9 + 1;
        }
        return i7;
    }

    public boolean m2054b() {
        if (!this.f1737i) {
            return false;
        }
        boolean z;
        this.f1737i = false;
        try {
            this.f1738j.write(59);
            this.f1738j.flush();
            if (this.f1747s) {
                this.f1738j.close();
            }
            z = true;
        } catch (IOException e) {
            z = false;
        }
        this.f1734f = 0;
        this.f1738j = null;
        this.f1739k = null;
        this.f1740l = null;
        this.f1741m = null;
        this.f1743o = null;
        this.f1747s = false;
        this.f1748t = true;
        return z;
    }

    protected void m2055c() {
        int i = 0;
        int length = this.f1740l.length;
        int i2 = length / 3;
        if (this.f1741m == null || i2 != this.f1741m.length) {
            this.f1741m = new byte[i2];
            Util.debug("New indexed pixels array.");
        }
        if (this.f1743o == null) {
            this.f1752x = new C0259f(this.f1740l, length, this.f1750v);
            this.f1743o = this.f1752x.m2095d();
            for (length = 0; length < this.f1743o.length; length += 3) {
                byte b = this.f1743o[length];
                this.f1743o[length] = this.f1743o[length + 2];
                this.f1743o[length + 2] = b;
                this.f1744p[length / 3] = false;
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        length = 0;
        while (i < i2) {
            int i3 = length + 1;
            int i4 = i3 + 1;
            length = i4 + 1;
            int a = this.f1752x.m2088a(this.f1740l[length] & 255, this.f1740l[i3] & 255, this.f1740l[i4] & 255);
            this.f1744p[a] = true;
            this.f1741m[i] = (byte) a;
            i++;
        }
        this.f1753y = (System.currentTimeMillis() - currentTimeMillis) + this.f1753y;
        this.f1742n = 8;
        this.f1745q = 7;
        if (this.f1733e != -1) {
            this.f1734f = m2053b(this.f1733e);
        }
    }

    protected void m2056c(int i) {
        this.f1738j.write(i & 255);
        this.f1738j.write((i >> 8) & 255);
    }

    protected void m2057d() {
        int width = this.f1739k.getWidth();
        int height = this.f1739k.getHeight();
        if (!(width == this.f1729a && height == this.f1730b)) {
            Util.debug("New temp bitmap of correct size.");
            Bitmap createBitmap = Bitmap.createBitmap(this.f1729a, this.f1730b, Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.f1739k, 0.0f, 0.0f, new Paint());
            this.f1739k = createBitmap;
        }
        if (this.f1751w == null) {
            Util.debug("New work data array.");
            this.f1751w = new int[(this.f1739k.getWidth() * this.f1739k.getHeight())];
        }
        m2049a(this.f1739k, this.f1751w);
        width = this.f1751w.length * 3;
        if (this.f1740l == null || this.f1740l.length != width) {
            this.f1740l = new byte[width];
            Util.debug("New pixels array.");
        }
        for (width = 0; width < this.f1751w.length; width++) {
            height = this.f1751w[width];
            int i = width * 3;
            int i2 = i + 1;
            this.f1740l[i] = (byte) ((height >> 0) & 255);
            int i3 = i2 + 1;
            this.f1740l[i2] = (byte) ((height >> 8) & 255);
            this.f1740l[i3] = (byte) ((height >> 16) & 255);
        }
    }

    protected void m2058e() {
        int i;
        int i2;
        this.f1738j.write(33);
        this.f1738j.write(249);
        this.f1738j.write(4);
        if (this.f1733e == -1) {
            i = 0;
            i2 = 0;
        } else {
            i2 = 1;
            i = 2;
        }
        if (this.f1746r >= 0) {
            i = this.f1746r & 7;
        }
        this.f1738j.write((((i << 2) | 0) | 0) | i2);
        m2056c(this.f1736h);
        this.f1738j.write(this.f1734f);
        this.f1738j.write(0);
    }

    protected void m2059f() {
        this.f1738j.write(44);
        m2056c(this.f1731c);
        m2056c(this.f1732d);
        m2056c(this.f1729a);
        m2056c(this.f1730b);
        if (this.f1748t) {
            this.f1738j.write(0);
        } else {
            this.f1738j.write(this.f1745q | 128);
        }
    }

    protected void m2060g() {
        m2056c(this.f1729a);
        m2056c(this.f1730b);
        this.f1738j.write(this.f1745q | 240);
        this.f1738j.write(0);
        this.f1738j.write(0);
    }

    protected void m2061h() {
        this.f1738j.write(33);
        this.f1738j.write(255);
        this.f1738j.write(11);
        m2050a("NETSCAPE2.0");
        this.f1738j.write(3);
        this.f1738j.write(1);
        m2056c(this.f1735g);
        this.f1738j.write(0);
    }

    protected void m2062i() {
        this.f1738j.write(this.f1743o, 0, this.f1743o.length);
        int length = 768 - this.f1743o.length;
        for (int i = 0; i < length; i++) {
            this.f1738j.write(0);
        }
    }

    protected void m2063j() {
        new C0258e(this.f1729a, this.f1730b, this.f1741m, this.f1742n).m2086b(this.f1738j);
    }
}
