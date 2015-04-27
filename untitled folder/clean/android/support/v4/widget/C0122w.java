package android.support.v4.widget;

import android.view.animation.Interpolator;

/* renamed from: android.support.v4.widget.w */
final class C0122w implements Interpolator {
    C0122w() {
    }

    public float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
    }
}
