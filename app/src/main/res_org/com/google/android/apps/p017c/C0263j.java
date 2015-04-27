package com.google.android.apps.p017c;

import android.os.SystemClock;
import android.view.MotionEvent;
import com.google.android.Util;

/* renamed from: com.google.android.apps.c.j */
class C0263j implements Runnable {
    final /* synthetic */ MotionEvent f1821a;
    final /* synthetic */ Interaction f1822b;

    C0263j(Interaction aInteraction, MotionEvent motionEvent) {
        this.f1822b = aInteraction;
        this.f1821a = motionEvent;
    }

    public void run() {
        if (!this.f1822b.f1817o) {
            if (this.f1821a.getAction() == 0) {
                Util.debug("REPLAY: TOUCH DOWN");
            }
            long uptimeMillis = SystemClock.uptimeMillis() - this.f1821a.getEventTime();
            MotionEvent obtain = MotionEvent.obtain(this.f1821a.getDownTime() + uptimeMillis, uptimeMillis + this.f1821a.getEventTime(), this.f1821a.getAction(), this.f1821a.getX(), this.f1821a.getY(), this.f1821a.getMetaState());
            MotionEvent obtain2 = MotionEvent.obtain(obtain);
            Util.debug("  Drawing setting last touch event " + obtain2);
            this.f1822b.f1806d.dispatchTouchEvent(obtain);
            this.f1822b.f1809g = obtain2;
            this.f1822b.f1814l = null;
            this.f1822b.f1806d.invalidate();
        }
    }
}
