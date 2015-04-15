package it.sephiroth.android.library.widget;

import android.view.VelocityTracker;

class h implements Runnable {
    final /* synthetic */ g a;

    h(g gVar) {
        this.a = gVar;
    }

    public void run() {
        int d = this.a.a.aO;
        VelocityTracker e = this.a.a.at;
        as a = this.a.b;
        if (e != null && d != -1) {
            e.computeCurrentVelocity(1000, (float) this.a.a.aM);
            float f = -e.getXVelocity(d);
            if (Math.abs(f) < ((float) this.a.a.aL) || !a.a(f, 0.0f)) {
                this.a.b();
                this.a.a.F = 3;
                this.a.a.b(1);
                return;
            }
            this.a.a.postDelayed(this, 40);
        }
    }
}
