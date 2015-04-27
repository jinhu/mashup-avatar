package com.google.android.apps.p017c;

import android.os.SystemClock;
import com.google.android.C0176a;

/* renamed from: com.google.android.apps.c.i */
class C0262i implements Runnable {
    final /* synthetic */ C0265l f1819a;
    final /* synthetic */ C0260g f1820b;

    C0262i(C0260g c0260g, C0265l c0265l) {
        this.f1820b = c0260g;
        this.f1819a = c0265l;
    }

    public void run() {
        if (!this.f1820b.f1817o) {
            C0176a.m1106c("  Drawing: Setting current interpolator: " + this.f1819a.toString());
            this.f1820b.f1814l = this.f1819a;
            this.f1820b.f1815m = SystemClock.uptimeMillis();
            this.f1820b.f1806d.invalidate();
        }
    }
}
