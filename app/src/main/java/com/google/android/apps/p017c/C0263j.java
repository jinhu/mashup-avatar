package com.google.android.apps.p017c;

import android.os.SystemClock;
import android.view.MotionEvent;
import com.google.android.Util;

/* renamed from: com.google.android.apps.c.j */
class C0263j implements Runnable {
    final /* synthetic */ MotionEvent motionEvent;
    final /* synthetic */ Interaction intercation;

    C0263j(Interaction aInteraction, MotionEvent motionEvent) {
        this.intercation = aInteraction;
        this.motionEvent = motionEvent;
    }

    public void run() {
        if (!this.intercation.f1817o) {
            if (this.motionEvent.getAction() == 0) {
                Util.debug("REPLAY: TOUCH DOWN");
            }
            long uptimeMillis = SystemClock.uptimeMillis() - this.motionEvent.getEventTime();
            MotionEvent obtain = MotionEvent.obtain(this.motionEvent.getDownTime() + uptimeMillis, uptimeMillis + this.motionEvent.getEventTime(), this.motionEvent.getAction(), this.motionEvent.getX(), this.motionEvent.getY(), this.motionEvent.getMetaState());
            MotionEvent obtain2 = MotionEvent.obtain(obtain);
            Util.debug("  Drawing setting last touch event " + obtain2);
            this.intercation.f1806d.dispatchTouchEvent(obtain);
            this.intercation.f1809g = obtain2;
            this.intercation.f1814l = null;
            this.intercation.f1806d.invalidate();
        }
    }
}
