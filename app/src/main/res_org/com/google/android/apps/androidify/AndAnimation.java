package com.google.android.apps.androidify;

import android.view.animation.Interpolator;

public class AndAnimation {
    private AnimationType mAnimationType;
    private float f1282b;
    private long f1283c;
    private long f1284d;
    private Interpolator f1285e;
    private float f1286f;
    private float f1287g;
    private int current;
    public AccessoryType mAccessoryType;

    public AndAnimation(AnimationType aAnimationTypeVar) {
        this(aAnimationTypeVar, 500);
    }

    public AndAnimation(AnimationType aAnimationTypeVar, long j) {
        this.mAnimationType = aAnimationTypeVar;
        this.f1283c = System.currentTimeMillis();
        this.f1284d = j;
        this.f1282b = 0.0f;
    }

    public void m1754a(int i) {
        this.current = i;
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

    public AnimationType m1757b() {
        return this.mAnimationType;
    }

    public float m1758c() {
        return this.f1282b;
    }

    public int getCurrent() {
        return this.current;
    }

    public float m1760e() {
        return this.f1285e == null ? this.f1282b : (this.f1285e.getInterpolation(this.f1282b) * (this.f1287g - this.f1286f)) + this.f1286f;
    }

    public float m1761f() {
        return this.f1285e == null ? this.f1282b : this.f1285e.getInterpolation(this.f1282b);
    }
}
