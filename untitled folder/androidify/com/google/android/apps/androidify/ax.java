package com.google.android.apps.androidify;

import android.view.animation.Interpolator;

public class ax {
    private ay f1281a;
    private float f1282b;
    private long f1283c;
    private long f1284d;
    private Interpolator f1285e;
    private float f1286f;
    private float f1287g;
    private int f1288h;

    public ax(ay ayVar) {
        this(ayVar, 500);
    }

    public ax(ay ayVar, long j) {
        this.f1281a = ayVar;
        this.f1283c = System.currentTimeMillis();
        this.f1284d = j;
        this.f1282b = 0.0f;
    }

    public void m1754a(int i) {
        this.f1288h = i;
    }

    public void m1755a(Interpolator interpolator, float f, float f2) {
        this.f1285e = interpolator;
        this.f1286f = f;
        this.f1287g = f2;
    }

    public boolean m1756a() {
        this.f1282b = ((float) (System.currentTimeMillis() - this.f1283c)) / ((float) this.f1284d);
        return this.f1282b >= 1.0f;
    }

    public ay m1757b() {
        return this.f1281a;
    }

    public float m1758c() {
        return this.f1282b;
    }

    public int m1759d() {
        return this.f1288h;
    }

    public float m1760e() {
        return this.f1285e == null ? this.f1282b : (this.f1285e.getInterpolation(this.f1282b) * (this.f1287g - this.f1286f)) + this.f1286f;
    }

    public float m1761f() {
        return this.f1285e == null ? this.f1282b : this.f1285e.getInterpolation(this.f1282b);
    }
}
