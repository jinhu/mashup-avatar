package com.google.android.apps.androidify;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;

/* renamed from: com.google.android.apps.androidify.e */
final class C0223e extends AnimatorListenerAdapter {
    final /* synthetic */ C0218f f1643a;
    final /* synthetic */ float f1644b;
    final /* synthetic */ ValueAnimator f1645c;

    C0223e(C0218f c0218f, float f, ValueAnimator valueAnimator) {
        this.f1643a = c0218f;
        this.f1644b = f;
        this.f1645c = valueAnimator;
    }

    public void onAnimationEnd(Animator animator) {
        this.f1643a.m1740a(this.f1644b, this.f1645c, true);
    }
}
