package com.google.android.apps.p017c;

import android.view.animation.Interpolator;

/* renamed from: com.google.android.apps.c.d */
public class UtilInterpolator implements Interpolator {
    public float getInterpolation(float f) {
        return (float) ((Math.pow(2.0d, -12.0d * Math.sqrt((double) f)) * Math.sin(((double) ((f - 0.075f) * 6.2831855f)) / 0.3d)) + 1.0d);
    }
}
