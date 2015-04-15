package com.google.android.apps.androidify;

import android.view.animation.Interpolator;

public class ax {
    private ay a;
    private float b;
    private long c;
    private long d;
    private Interpolator e;
    private float f;
    private float g;
    private int h;

    public ax(ay ayVar) {
        this(ayVar, 500);
    }

    public ax(ay ayVar, long j) {
        this.a = ayVar;
        this.c = System.currentTimeMillis();
        this.d = j;
        this.b = 0.0f;
    }

    public void a(int i) {
        this.h = i;
    }

    public void a(Interpolator interpolator, float f, float f2) {
        this.e = interpolator;
        this.f = f;
        this.g = f2;
    }

    public boolean a() {
        this.b = ((float) (System.currentTimeMillis() - this.c)) / ((float) this.d);
        return this.b >= 1.0f;
    }

    public ay b() {
        return this.a;
    }

    public float c() {
        return this.b;
    }

    public int d() {
        return this.h;
    }

    public float e() {
        return this.e == null ? this.b : (this.e.getInterpolation(this.b) * (this.g - this.f)) + this.f;
    }

    public float f() {
        return this.e == null ? this.b : this.e.getInterpolation(this.b);
    }
}
