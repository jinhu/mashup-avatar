package com.google.android.apps.c;

import android.os.SystemClock;
import android.view.MotionEvent;
import com.google.android.a;

class j implements Runnable {
    final /* synthetic */ MotionEvent a;
    final /* synthetic */ g b;

    j(g gVar, MotionEvent motionEvent) {
        this.b = gVar;
        this.a = motionEvent;
    }

    public void run() {
        if (!this.b.o) {
            if (this.a.getAction() == 0) {
                a.c("REPLAY: TOUCH DOWN");
            }
            long uptimeMillis = SystemClock.uptimeMillis() - this.a.getEventTime();
            MotionEvent obtain = MotionEvent.obtain(this.a.getDownTime() + uptimeMillis, uptimeMillis + this.a.getEventTime(), this.a.getAction(), this.a.getX(), this.a.getY(), this.a.getMetaState());
            MotionEvent obtain2 = MotionEvent.obtain(obtain);
            a.c("  Drawing setting last touch event " + obtain2);
            this.b.d.dispatchTouchEvent(obtain);
            this.b.g = obtain2;
            this.b.l = null;
            this.b.d.invalidate();
        }
    }
}
