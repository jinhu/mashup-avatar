package com.google.android.apps.p017c;

import android.os.SystemClock;
import android.view.MotionEvent;
import com.google.android.C0176a;

/* renamed from: com.google.android.apps.c.j */
class C0263j implements Runnable {
    final /* synthetic */ MotionEvent f1821a;
    final /* synthetic */ C0260g f1822b;

    C0263j(C0260g c0260g, MotionEvent motionEvent) {
        this.f1822b = c0260g;
        this.f1821a = motionEvent;
    }

    public void run() {
        if (!this.f1822b.f1817o) {
            if (this.f1821a.getAction() == 0) {
                C0176a.m1106c("REPLAY: TOUCH DOWN");
            }
            long uptimeMillis = SystemClock.uptimeMillis() - this.f1821a.getEventTime();
            MotionEvent obtain = MotionEvent.obtain(this.f1821a.getDownTime() + uptimeMillis, uptimeMillis + this.f1821a.getEventTime(), this.f1821a.getAction(), this.f1821a.getX(), this.f1821a.getY(), this.f1821a.getMetaState());
            MotionEvent obtain2 = MotionEvent.obtain(obtain);
            C0176a.m1106c("  Drawing setting last touch event " + obtain2);
            this.f1822b.f1806d.dispatchTouchEvent(obtain);
            this.f1822b.f1809g = obtain2;
            this.f1822b.f1814l = null;
            this.f1822b.f1806d.invalidate();
        }
    }
}
