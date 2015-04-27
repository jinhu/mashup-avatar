package com.google.android.apps.androidify;

import android.animation.ValueAnimator;
import android.view.View;

class at implements C0218f {
    final /* synthetic */ View f1244a;
    final /* synthetic */ Runnable f1245b;
    final /* synthetic */ an f1246c;

    at(an anVar, View view, Runnable runnable) {
        this.f1246c = anVar;
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
