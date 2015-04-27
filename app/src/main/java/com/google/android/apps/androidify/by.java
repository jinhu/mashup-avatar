package com.google.android.apps.androidify;

import android.view.animation.Interpolator;
import java.util.Random;

public class by {
    public static final float f1470a;
    public static final float f1471b;
    public static final Random f1472c;
    private static float[] f1473d;
    private static float[] f1474e;
    private static float[] f1475f;
    private static float[] f1476g;

    static {
        f1470a = (float) Math.sqrt(2.0d);
        f1471b = (float) Math.sqrt(1.5707963267948966d);
        f1472c = new Random();
        f1473d = new float[6];
        f1474e = new float[6];
        f1475f = new float[8];
        f1476g = new float[8];
    }

    public static float m1898a(float f, float f2, float f3, float f4, float f5) {
        return (((f - f2) / (f3 - f2)) * (f5 - f4)) + f4;
    }

    public static float m1899a(float f, float f2, float f3, float f4, float f5, Interpolator interpolator) {
        return (interpolator.getInterpolation((f - f2) / (f3 - f2)) * (f5 - f4)) + f4;
    }

    public static float m1900a(long j, float f) {
        return (float) Math.sin((((double) j) * 6.2831854820251465d) / ((double) f));
    }

    public static float m1901b(float f, float f2, float f3, float f4, float f5) {
        return f <= f2 ? f4 : f >= f3 ? f5 : f4 + (((f - f2) / (f3 - f2)) * (f5 - f4));
    }
}
