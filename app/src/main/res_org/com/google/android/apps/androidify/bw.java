package com.google.android.apps.androidify;

import android.view.animation.Interpolator;

public class bw implements Interpolator {
    private ci[] f1468a;

    public bw(ci... ciVarArr) {
        this.f1468a = ciVarArr;
    }

    public float getInterpolation(float f) {
        for (int i = 1; i < this.f1468a.length - 1; i++) {
            if (this.f1468a[i].f1505a >= f) {
                float f2 = (f - this.f1468a[i - 1].f1505a) / (this.f1468a[i].f1505a - this.f1468a[i - 1].f1505a);
                return (this.f1468a[i].f1506b * f2) + ((1.0f - f2) * this.f1468a[i - 1].f1506b);
            }
        }
        return this.f1468a[this.f1468a.length - 1].f1506b;
    }
}
