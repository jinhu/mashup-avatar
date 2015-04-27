package android.support.v4.view;

import android.view.MotionEvent;

class aa implements ac {
    aa() {
    }

    public int m488a(MotionEvent motionEvent) {
        return 1;
    }

    public int m489a(MotionEvent motionEvent, int i) {
        return i == 0 ? 0 : -1;
    }

    public int m490b(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return 0;
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    public float m491c(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return motionEvent.getX();
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    public float m492d(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return motionEvent.getY();
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }
}
