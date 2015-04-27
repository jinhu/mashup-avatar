package com.google.android.apps.androidify;

import android.animation.ValueAnimator;
import android.view.View;
class MainViewHideRunner {
    final /* synthetic */ View mView;
    final /* synthetic */ Runnable mRunnable;
    final /* synthetic */ ManiView mManiView;

    MainViewHideRunner(ManiView aManiViewVar, View view, Runnable runnable) {
        this.mManiView = aManiViewVar;
        this.mView = view;
        this.mRunnable = runnable;
    }

    public void hideInBackground(float f, ValueAnimator valueAnimator, boolean z) {
        this.mView.setTranslationY(f);
        if (z) {
            this.mView.setVisibility(View.INVISIBLE);
            if (this.mRunnable != null) {
                this.mRunnable.run();
            }
        }
    }
}
