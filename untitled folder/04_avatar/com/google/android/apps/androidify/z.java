package com.google.android.apps.androidify;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class z implements AnimationListener {
    final /* synthetic */ View a;
    final /* synthetic */ boolean b;
    final /* synthetic */ Runnable c;
    final /* synthetic */ Androidify d;

    z(Androidify androidify, View view, boolean z, Runnable runnable) {
        this.d = androidify;
        this.a = view;
        this.b = z;
        this.c = runnable;
    }

    public void onAnimationEnd(Animation animation) {
        this.a.setVisibility(this.b ? 0 : 4);
        if (this.c != null) {
            this.c.run();
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
