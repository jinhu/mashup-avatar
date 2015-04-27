package com.google.android.apps.androidify;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* renamed from: com.google.android.apps.androidify.z */
class C0247z implements AnimationListener {
    final /* synthetic */ View f1699a;
    final /* synthetic */ boolean f1700b;
    final /* synthetic */ Runnable f1701c;
    final /* synthetic */ Androidify f1702d;

    C0247z(Androidify androidify, View view, boolean z, Runnable runnable) {
        this.f1702d = androidify;
        this.f1699a = view;
        this.f1700b = z;
        this.f1701c = runnable;
    }

    public void onAnimationEnd(Animation animation) {
        this.f1699a.setVisibility(this.f1700b ? 0 : 4);
        if (this.f1701c != null) {
            this.f1701c.run();
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
