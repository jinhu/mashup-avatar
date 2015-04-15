package com.google.android.apps.androidify;

import android.os.Handler;

public class a {
    private float a;
    private float b;
    private float c;
    private float d;
    private Androidify e;
    private long f;
    private Handler g;
    private boolean h;
    private Runnable i;

    public a(Androidify androidify) {
        this.f = 0;
        this.g = new Handler();
        this.h = false;
        this.i = new b(this);
        this.e = androidify;
    }

    private double a(double d) {
        return Math.cos(1.5d * d) / (Math.cos(0.5d * d) + 2.0d);
    }

    private double b(double d) {
        return Math.sin(2.0d * d);
    }

    public float a(int i) {
        return i == 0 ? this.a : this.b;
    }

    public float a(int i, float f) {
        double currentTimeMillis = (((((double) (System.currentTimeMillis() - this.f)) / 10000.0d) * 2.0d) * 3.141592653589793d) + ((double) f);
        return i == 0 ? (float) (a(currentTimeMillis) * 10.0d) : (float) (a(currentTimeMillis) * 10.0d);
    }

    public boolean a() {
        return this.h;
    }

    public void b() {
        this.h = true;
        this.f = System.currentTimeMillis();
        this.g.post(this.i);
    }

    public void c() {
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 1.0f;
        this.h = false;
        this.e.a(true);
    }

    public void d() {
        double currentTimeMillis = ((((double) (System.currentTimeMillis() - this.f)) / 10000.0d) * 2.0d) * 3.141592653589793d;
        this.a = (float) (a(currentTimeMillis) * 10.0d);
        this.b = (float) (a(currentTimeMillis) * 10.0d);
        this.c = (float) (b(currentTimeMillis) * 5.0d);
        this.d = ((float) (b(currentTimeMillis) * 0.05000000074505806d)) + 1.0f;
    }

    public float e() {
        return this.c;
    }

    public float f() {
        return this.d;
    }
}
