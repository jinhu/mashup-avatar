package com.google.android.apps.p017c;

import android.view.MotionEvent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

/* renamed from: com.google.android.apps.c.l */
class C0265l implements Comparable {
    public MotionEvent f1824a;
    public MotionEvent f1825b;
    public Interpolator f1826c;

    private C0265l(MotionEvent motionEvent, MotionEvent motionEvent2) {
        this.f1824a = motionEvent;
        this.f1825b = motionEvent2;
        this.f1826c = new AccelerateDecelerateInterpolator();
    }

    public int m2112a(C0265l c0265l) {
        return new Long(this.f1824a.getEventTime()).compareTo(Long.valueOf(c0265l.f1824a.getEventTime()));
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m2112a((C0265l) obj);
    }

    public String toString() {
        return "Interpolating from " + this.f1824a.toString() + " to " + this.f1825b.toString();
    }
}
