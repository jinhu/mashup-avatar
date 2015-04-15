package com.google.android.apps.c;

import android.os.SystemClock;
import com.google.android.a;

class i implements Runnable {
    final /* synthetic */ l a;
    final /* synthetic */ g b;

    i(g gVar, l lVar) {
        this.b = gVar;
        this.a = lVar;
    }

    public void run() {
        if (!this.b.o) {
            a.c("  Drawing: Setting current interpolator: " + this.a.toString());
            this.b.l = this.a;
            this.b.m = SystemClock.uptimeMillis();
            this.b.d.invalidate();
        }
    }
}
