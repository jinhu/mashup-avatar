package com.google.android.apps.androidify.wallpaper;

import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

class c implements OnGestureListener {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.a.a(motionEvent);
        return true;
    }
}
