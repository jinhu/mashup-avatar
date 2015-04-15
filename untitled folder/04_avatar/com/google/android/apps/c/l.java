package com.google.android.apps.c;

import android.view.MotionEvent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

class l implements Comparable {
    public MotionEvent a;
    public MotionEvent b;
    public Interpolator c;

    private l(MotionEvent motionEvent, MotionEvent motionEvent2) {
        this.a = motionEvent;
        this.b = motionEvent2;
        this.c = new AccelerateDecelerateInterpolator();
    }

    public int a(l lVar) {
        return new Long(this.a.getEventTime()).compareTo(Long.valueOf(lVar.a.getEventTime()));
    }

    public /* synthetic */ int compareTo(Object obj) {
        return a((l) obj);
    }

    public String toString() {
        return "Interpolating from " + this.a.toString() + " to " + this.b.toString();
    }
}
