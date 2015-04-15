package com.google.android.apps.androidify;

import android.animation.ValueAnimator;
import android.view.View;
import com.google.android.a;

class as implements f {
    final /* synthetic */ View a;
    final /* synthetic */ Runnable b;
    final /* synthetic */ an c;

    as(an anVar, View view, Runnable runnable) {
        this.c = anVar;
        this.a = view;
        this.b = runnable;
    }

    public void a(float f, ValueAnimator valueAnimator, boolean z) {
        a.c("[DRAWER] Animate in: " + f + ", visibility: " + (this.a.getVisibility() == 0));
        this.a.setTranslationY(f);
        if (z && this.b != null) {
            this.b.run();
        }
    }
}
