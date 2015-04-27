package com.google.android.apps.androidify;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* renamed from: com.google.android.apps.androidify.m */
class C0230m implements AnimationListener {
    final /* synthetic */ Androidify f1656a;

    C0230m(Androidify androidify) {
        this.f1656a = androidify;
    }

    public void onAnimationEnd(Animation animation) {
        this.f1656a.f773l.setVisibility(8);
        this.f1656a.f749E.m1869a(5);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
