package com.google.android.apps.p017c;

import android.os.SystemClock;
import com.google.android.Util;

/* renamed from: com.google.android.apps.c.i */
class C0262i implements Runnable {
    final /* synthetic */ C0265l f1819a;
    final /* synthetic */ Interaction f1820b;

    C0262i(Interaction aInteraction, C0265l c0265l) {
        this.f1820b = aInteraction;
        this.f1819a = c0265l;
    }

    public void run() {
        if (!this.f1820b.f1817o) {
            Util.debug("  Drawing: Setting current interpolator: " + this.f1819a.toString());
            this.f1820b.f1814l = this.f1819a;
            this.f1820b.f1815m = SystemClock.uptimeMillis();
            this.f1820b.f1806d.invalidate();
        }
    }
}
