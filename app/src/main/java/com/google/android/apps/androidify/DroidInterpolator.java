package com.google.android.apps.androidify;

import android.view.animation.Interpolator;

public class DroidInterpolator implements Interpolator {
    private DroidCoordinate[] f1468a;

    public DroidInterpolator(DroidCoordinate... aDroidCoordinateVarArr) {
        this.f1468a = aDroidCoordinateVarArr;
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
