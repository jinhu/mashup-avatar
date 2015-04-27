package com.google.android.apps.androidify;

import android.animation.ValueAnimator;
import android.view.View;
class at {
    final /* synthetic */ View f1244a;
    final /* synthetic */ Runnable f1245b;
    final /* synthetic */ ManiView f1246c;

    at(ManiView aManiViewVar, View view, Runnable runnable) {
        this.f1246c = aManiViewVar;
        this.f1244a = view;
        this.f1245b = runnable;
    }

    public void m1742a(float f, ValueAnimator valueAnimator, boolean z) {
        this.f1244a.setTranslationY(f);
        if (z) {
            this.f1244a.setVisibility(4);
            if (this.f1245b != null) {
                this.f1245b.run();
            }
        }
    }
}
