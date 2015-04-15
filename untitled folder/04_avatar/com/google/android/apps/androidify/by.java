package com.google.android.apps.androidify;

import android.view.animation.Interpolator;
import java.util.Random;

public class by {
    public static final float a;
    public static final float b;
    public static final Random c;
    private static float[] d;
    private static float[] e;
    private static float[] f;
    private static float[] g;

    static {
        a = (float) Math.sqrt(2.0d);
        b = (float) Math.sqrt(1.5707963267948966d);
        c = new Random();
        d = new float[6];
        e = new float[6];
        f = new float[8];
        g = new float[8];
    }

    public static float a(float f, float f2, float f3, float f4, float f5) {
        return (((f - f2) / (f3 - f2)) * (f5 - f4)) + f4;
    }

    public static float a(float f, float f2, float f3, float f4, float f5, Interpolator interpolator) {
        return (interpolator.getInterpolation((f - f2) / (f3 - f2)) * (f5 - f4)) + f4;
    }

    public static float a(long j, float f) {
        return (float) Math.sin((((double) j) * 6.2831854820251465d) / ((double) f));
    }

    public static float b(float f, float f2, float f3, float f4, float f5) {
        return f <= f2 ? f4 : f >= f3 ? f5 : f4 + (((f - f2) / (f3 - f2)) * (f5 - f4));
    }
}
