package com.google.android.apps.androidify;

import android.animation.ValueAnimator;
import android.view.View;
import com.google.android.Util;

class as  {
    final /* synthetic */ View f1241a;
    final /* synthetic */ Runnable f1242b;
    final /* synthetic */ ManiView f1243c;

    as(ManiView aManiViewVar, View view, Runnable runnable) {
        this.f1243c = aManiViewVar;
        this.f1241a = view;
        this.f1242b = runnable;
    }

    public void m1741a(float f, ValueAnimator valueAnimator, boolean z) {
        Util.debug("[DRAWER] Animate in: " + f + ", visibility: " + (this.f1241a.getVisibility() == 0));
        this.f1241a.setTranslationY(f);
        if (z && this.f1242b != null) {
            this.f1242b.run();
        }
    }
}
