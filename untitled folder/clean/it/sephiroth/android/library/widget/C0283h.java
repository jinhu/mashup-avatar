package it.sephiroth.android.library.widget;

import android.view.VelocityTracker;

/* renamed from: it.sephiroth.android.library.widget.h */
class C0283h implements Runnable {
    final /* synthetic */ C0282g f1974a;

    C0283h(C0282g c0282g) {
        this.f1974a = c0282g;
    }

    public void run() {
        int d = this.f1974a.f1970a.aO;
        VelocityTracker e = this.f1974a.f1970a.at;
        as a = this.f1974a.f1971b;
        if (e != null && d != -1) {
            e.computeCurrentVelocity(1000, (float) this.f1974a.f1970a.aM);
            float f = -e.getXVelocity(d);
            if (Math.abs(f) < ((float) this.f1974a.f1970a.aL) || !a.m2351a(f, 0.0f)) {
                this.f1974a.m2390b();
                this.f1974a.f1970a.f1855F = 3;
                this.f1974a.f1970a.m2205b(1);
                return;
            }
            this.f1974a.f1970a.postDelayed(this, 40);
        }
    }
}
