package com.google.android.apps.androidify;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* renamed from: com.google.android.apps.androidify.n */
class C0231n implements AnimationListener {
    final /* synthetic */ ViewGroup f1657a;
    final /* synthetic */ View f1658b;
    final /* synthetic */ Androidify f1659c;

    C0231n(Androidify androidify, ViewGroup viewGroup, View view) {
        this.f1659c = androidify;
        this.f1657a = viewGroup;
        this.f1658b = view;
    }

    public void onAnimationEnd(Animation animation) {
        this.f1657a.removeView(this.f1658b);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
