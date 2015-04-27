package com.google.android.apps.androidify;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* renamed from: com.google.android.apps.androidify.d */
final class C0221d implements AnimatorUpdateListener {
    final /* synthetic */ long f1558a;
    final /* synthetic */ C0218f f1559b;
    final /* synthetic */ ValueAnimator f1560c;

    C0221d(long j, C0218f c0218f, ValueAnimator valueAnimator) {
        this.f1558a = j;
        this.f1559b = c0218f;
        this.f1560c = valueAnimator;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (valueAnimator.getCurrentPlayTime() < this.f1558a) {
            this.f1559b.m1740a(floatValue, this.f1560c, false);
        }
    }
}
