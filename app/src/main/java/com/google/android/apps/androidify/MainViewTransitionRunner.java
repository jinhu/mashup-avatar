package com.google.android.apps.androidify;

import android.animation.ValueAnimator;
import android.view.View;
import com.google.android.Util;

class MainViewTransitionRunner {
    final /* synthetic */ View mView;
    final /* synthetic */ Runnable mRunnable;
    final /* synthetic */ ManiView mManiView;

    MainViewTransitionRunner(ManiView aManiViewVar, View view, Runnable runnable) {
        this.mManiView = aManiViewVar;
        this.mView = view;
        this.mRunnable = runnable;
    }

    public void m1741a(float duration, ValueAnimator valueAnimator, boolean runInBackground) {
        Util.debug("[DRAWER] Animate in: " + duration + ", visibility: " + (this.mView.getVisibility() == View.VISIBLE));
        this.mView.setTranslationY(duration);
        if (runInBackground && this.mRunnable != null) {
            this.mRunnable.run();
        }
    }
}
