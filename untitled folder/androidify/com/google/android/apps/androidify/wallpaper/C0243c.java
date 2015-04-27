package com.google.android.apps.androidify.wallpaper;

import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

/* renamed from: com.google.android.apps.androidify.wallpaper.c */
class C0243c implements OnGestureListener {
    final /* synthetic */ C0242b f1695a;

    C0243c(C0242b c0242b) {
        this.f1695a = c0242b;
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
        this.f1695a.m2000a(motionEvent);
        return true;
    }
}
