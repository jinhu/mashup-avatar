package android.support.v4.view;

import android.view.MotionEvent;

class ad {
    public static int m498a(MotionEvent motionEvent) {
        return motionEvent.getPointerCount();
    }

    public static int m499a(MotionEvent motionEvent, int i) {
        return motionEvent.findPointerIndex(i);
    }

    public static int m500b(MotionEvent motionEvent, int i) {
        return motionEvent.getPointerId(i);
    }

    public static float m501c(MotionEvent motionEvent, int i) {
        return motionEvent.getX(i);
    }

    public static float m502d(MotionEvent motionEvent, int i) {
        return motionEvent.getY(i);
    }
}
