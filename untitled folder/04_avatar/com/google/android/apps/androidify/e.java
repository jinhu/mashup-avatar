package com.google.android.apps.androidify;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;

final class e extends AnimatorListenerAdapter {
    final /* synthetic */ f a;
    final /* synthetic */ float b;
    final /* synthetic */ ValueAnimator c;

    e(f fVar, float f, ValueAnimator valueAnimator) {
        this.a = fVar;
        this.b = f;
        this.c = valueAnimator;
    }

    public void onAnimationEnd(Animator animator) {
        this.a.a(this.b, this.c, true);
    }
}
