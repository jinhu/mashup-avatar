package com.google.android.apps.c;

import android.view.animation.Interpolator;

public class d implements Interpolator {
    public float getInterpolation(float f) {
        return (float) ((Math.pow(2.0d, -12.0d * Math.sqrt((double) f)) * Math.sin(((double) ((f - 0.075f) * 6.2831855f)) / 0.3d)) + 1.0d);
    }
}
