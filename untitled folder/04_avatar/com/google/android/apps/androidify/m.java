package com.google.android.apps.androidify;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class m implements AnimationListener {
    final /* synthetic */ Androidify a;

    m(Androidify androidify) {
        this.a = androidify;
    }

    public void onAnimationEnd(Animation animation) {
        this.a.l.setVisibility(8);
        this.a.E.a(5);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
