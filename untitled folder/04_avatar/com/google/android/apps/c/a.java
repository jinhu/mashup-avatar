package com.google.android.apps.c;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.google.android.apps.androidify.c;
import java.io.IOException;
import java.io.OutputStream;

public class a {
    protected int a;
    protected int b;
    protected int c;
    protected int d;
    protected int e;
    protected int f;
    protected int g;
    protected int h;
    protected boolean i;
    protected OutputStream j;
    protected Bitmap k;
    protected byte[] l;
    protected byte[] m;
    protected int n;
    protected byte[] o;
    protected boolean[] p;
    protected int q;
    protected int r;
    protected boolean s;
    protected boolean t;
    protected boolean u;
    protected int v;
    private int[] w;
    private f x;
    private long y;

    public a() {
        this.c = 0;
        this.d = 0;
        this.e = -1;
        this.g = -1;
        this.h = 0;
        this.i = false;
        this.p = new boolean[256];
        this.q = 7;
        this.r = -1;
        this.s = false;
        this.t = true;
        this.u = false;
        this.v = 10;
        this.y = 0;
    }

    public long a() {
        return this.y;
    }

    public void a(float f) {
        if (f != 0.0f) {
            this.h = (int) (100.0f / f);
        }
    }

    public void a(int i) {
        if (i >= 0) {
            this.g = i;
        }
    }

    public void a(int i, int i2) {
        this.a = i;
        this.b = i2;
        if (this.a < 1) {
            this.a = 320;
        }
        if (this.b < 1) {
            this.b = 240;
        }
        this.u = true;
    }

    protected void a(Bitmap bitmap, int[] iArr) {
        int width = bitmap.getWidth();
        bitmap.getPixels(iArr, 0, width, 0, 0, width, bitmap.getHeight());
    }

    protected void a(String str) {
        for (int i = 0; i < str.length(); i++) {
            this.j.write((byte) str.charAt(i));
        }
    }

    public boolean a(Bitmap bitmap) {
        if (bitmap == null || !this.i) {
            return false;
        }
        try {
            if (!this.u) {
                a(bitmap.getWidth(), bitmap.getHeight());
            }
            this.k = bitmap;
            d();
            c();
            if (this.t) {
                g();
                i();
                if (this.g >= 0) {
                    h();
                }
            }
            e();
            f();
            if (!this.t) {
                i();
            }
            j();
            this.t = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean a(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.s = false;
        this.j = outputStream;
        try {
            a("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.i = z;
        return z;
    }

    protected int b(int i) {
        int i2 = 0;
        if (this.o == null) {
            return -1;
        }
        int i3 = (i >> 16) & 255;
        int i4 = (i >> 8) & 255;
        int i5 = (i >> 0) & 255;
        int i6 = 16777216;
        int length = this.o.length;
        int i7 = 0;
        while (i2 < length) {
            int i8 = i2 + 1;
            i2 = i3 - (this.o[i2] & 255);
            int i9 = i8 + 1;
            int i10 = i4 - (this.o[i8] & 255);
            i8 = i5 - (this.o[i9] & 255);
            i2 = ((i2 * i2) + (i10 * i10)) + (i8 * i8);
            i10 = i9 / 3;
            if (!this.p[i10] || i2 >= i6) {
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

    public boolean b() {
        if (!this.i) {
            return false;
        }
        boolean z;
        this.i = false;
        try {
            this.j.write(59);
            this.j.flush();
            if (this.s) {
                this.j.close();
            }
            z = true;
        } catch (IOException e) {
            z = false;
        }
        this.f = 0;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.o = null;
        this.s = false;
        this.t = true;
        return z;
    }

    protected void c() {
        int i = 0;
        int length = this.l.length;
        int i2 = length / 3;
        if (this.m == null || i2 != this.m.length) {
            this.m = new byte[i2];
            c.a("New indexed pixels array.");
        }
        if (this.o == null) {
            this.x = new f(this.l, length, this.v);
            this.o = this.x.d();
            for (length = 0; length < this.o.length; length += 3) {
                byte b = this.o[length];
                this.o[length] = this.o[length + 2];
                this.o[length + 2] = b;
                this.p[length / 3] = false;
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        length = 0;
        while (i < i2) {
            int i3 = length + 1;
            int i4 = i3 + 1;
            length = i4 + 1;
            int a = this.x.a(this.l[length] & 255, this.l[i3] & 255, this.l[i4] & 255);
            this.p[a] = true;
            this.m[i] = (byte) a;
            i++;
        }
        this.y = (System.currentTimeMillis() - currentTimeMillis) + this.y;
        this.n = 8;
        this.q = 7;
        if (this.e != -1) {
            this.f = b(this.e);
        }
    }

    protected void c(int i) {
        this.j.write(i & 255);
        this.j.write((i >> 8) & 255);
    }

    protected void d() {
        int width = this.k.getWidth();
        int height = this.k.getHeight();
        if (!(width == this.a && height == this.b)) {
            c.a("New temp bitmap of correct size.");
            Bitmap createBitmap = Bitmap.createBitmap(this.a, this.b, Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.k, 0.0f, 0.0f, new Paint());
            this.k = createBitmap;
        }
        if (this.w == null) {
            c.a("New work data array.");
            this.w = new int[(this.k.getWidth() * this.k.getHeight())];
        }
        a(this.k, this.w);
        width = this.w.length * 3;
        if (this.l == null || this.l.length != width) {
            this.l = new byte[width];
            c.a("New pixels array.");
        }
        for (width = 0; width < this.w.length; width++) {
            height = this.w[width];
            int i = width * 3;
            int i2 = i + 1;
            this.l[i] = (byte) ((height >> 0) & 255);
            int i3 = i2 + 1;
            this.l[i2] = (byte) ((height >> 8) & 255);
            this.l[i3] = (byte) ((height >> 16) & 255);
        }
    }

    protected void e() {
        int i;
        int i2;
        this.j.write(33);
        this.j.write(249);
        this.j.write(4);
        if (this.e == -1) {
            i = 0;
            i2 = 0;
        } else {
            i2 = 1;
            i = 2;
        }
        if (this.r >= 0) {
            i = this.r & 7;
        }
        this.j.write((((i << 2) | 0) | 0) | i2);
        c(this.h);
        this.j.write(this.f);
        this.j.write(0);
    }

    protected void f() {
        this.j.write(44);
        c(this.c);
        c(this.d);
        c(this.a);
        c(this.b);
        if (this.t) {
            this.j.write(0);
        } else {
            this.j.write(this.q | 128);
        }
    }

    protected void g() {
        c(this.a);
        c(this.b);
        this.j.write(this.q | 240);
        this.j.write(0);
        this.j.write(0);
    }

    protected void h() {
        this.j.write(33);
        this.j.write(255);
        this.j.write(11);
        a("NETSCAPE2.0");
        this.j.write(3);
        this.j.write(1);
        c(this.g);
        this.j.write(0);
    }

    protected void i() {
        this.j.write(this.o, 0, this.o.length);
        int length = 768 - this.o.length;
        for (int i = 0; i < length; i++) {
            this.j.write(0);
        }
    }

    protected void j() {
        new e(this.a, this.b, this.m, this.n).b(this.j);
    }
}
