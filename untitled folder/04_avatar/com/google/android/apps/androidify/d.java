package com.google.android.apps.androidify;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final class d implements AnimatorUpdateListener {
    final /* synthetic */ long a;
    final /* synthetic */ f b;
    final /* synthetic */ ValueAnimator c;

    d(long j, f fVar, ValueAnimator valueAnimator) {
        this.a = j;
        this.b = fVar;
        this.c = valueAnimator;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (valueAnimator.getCurrentPlayTime() < this.a) {
            this.b.a(floatValue, this.c, false);
        }
    }
}
