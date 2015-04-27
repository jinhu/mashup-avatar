package com.google.android.apps.androidify;

import android.os.Handler;

/* renamed from: com.google.android.apps.androidify.a */
public class C0216a {
    private float f1110a;
    private float f1111b;
    private float f1112c;
    private float f1113d;
    private Androidify f1114e;
    private long f1115f;
    private Handler f1116g;
    private boolean f1117h;
    private Runnable f1118i;

    public C0216a(Androidify androidify) {
        this.f1115f = 0;
        this.f1116g = new Handler();
        this.f1117h = false;
        this.f1118i = new C0219b(this);
        this.f1114e = androidify;
    }

    private double m1624a(double d) {
        return Math.cos(1.5d * d) / (Math.cos(0.5d * d) + 2.0d);
    }

    private double m1626b(double d) {
        return Math.sin(2.0d * d);
    }

    public float m1629a(int i) {
        return i == 0 ? this.f1110a : this.f1111b;
    }

    public float m1630a(int i, float f) {
        double currentTimeMillis = (((((double) (System.currentTimeMillis() - this.f1115f)) / 10000.0d) * 2.0d) * 3.141592653589793d) + ((double) f);
        return i == 0 ? (float) (m1624a(currentTimeMillis) * 10.0d) : (float) (m1624a(currentTimeMillis) * 10.0d);
    }

    public boolean m1631a() {
        return this.f1117h;
    }

    public void m1632b() {
        this.f1117h = true;
        this.f1115f = System.currentTimeMillis();
        this.f1116g.post(this.f1118i);
    }

    public void m1633c() {
        this.f1110a = 0.0f;
        this.f1111b = 0.0f;
        this.f1112c = 0.0f;
        this.f1113d = 1.0f;
        this.f1117h = false;
        this.f1114e.m1380a(true);
    }

    public void m1634d() {
        double currentTimeMillis = ((((double) (System.currentTimeMillis() - this.f1115f)) / 10000.0d) * 2.0d) * 3.141592653589793d;
        this.f1110a = (float) (m1624a(currentTimeMillis) * 10.0d);
        this.f1111b = (float) (m1624a(currentTimeMillis) * 10.0d);
        this.f1112c = (float) (m1626b(currentTimeMillis) * 5.0d);
        this.f1113d = ((float) (m1626b(currentTimeMillis) * 0.05000000074505806d)) + 1.0f;
    }

    public float m1635e() {
        return this.f1112c;
    }

    public float m1636f() {
        return this.f1113d;
    }
}
