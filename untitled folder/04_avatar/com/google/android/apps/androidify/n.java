package com.google.android.apps.androidify;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class n implements AnimationListener {
    final /* synthetic */ ViewGroup a;
    final /* synthetic */ View b;
    final /* synthetic */ Androidify c;

    n(Androidify androidify, ViewGroup viewGroup, View view) {
        this.c = androidify;
        this.a = viewGroup;
        this.b = view;
    }

    public void onAnimationEnd(Animation animation) {
        this.a.removeView(this.b);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
