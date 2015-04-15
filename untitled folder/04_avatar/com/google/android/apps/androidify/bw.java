package com.google.android.apps.androidify;

import android.view.animation.Interpolator;

public class bw implements Interpolator {
    private ci[] a;

    public bw(ci... ciVarArr) {
        this.a = ciVarArr;
    }

    public float getInterpolation(float f) {
        for (int i = 1; i < this.a.length - 1; i++) {
            if (this.a[i].a >= f) {
                float f2 = (f - this.a[i - 1].a) / (this.a[i].a - this.a[i - 1].a);
                return (this.a[i].b * f2) + ((1.0f - f2) * this.a[i - 1].b);
            }
        }
        return this.a[this.a.length - 1].b;
    }
}
