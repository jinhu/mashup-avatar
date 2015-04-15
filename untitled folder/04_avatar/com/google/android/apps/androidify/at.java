package com.google.android.apps.androidify;

import android.animation.ValueAnimator;
import android.view.View;

class at implements f {
    final /* synthetic */ View a;
    final /* synthetic */ Runnable b;
    final /* synthetic */ an c;

    at(an anVar, View view, Runnable runnable) {
        this.c = anVar;
        this.a = view;
        this.b = runnable;
    }

    public void a(float f, ValueAnimator valueAnimator, boolean z) {
        this.a.setTranslationY(f);
        if (z) {
            this.a.setVisibility(4);
            if (this.b != null) {
                this.b.run();
            }
        }
    }
}
