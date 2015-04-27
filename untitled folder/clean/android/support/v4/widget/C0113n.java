package android.support.v4.widget;

import android.support.v4.view.ak;
import android.view.View;

/* renamed from: android.support.v4.widget.n */
class C0113n implements Runnable {
    final View f383a;
    final /* synthetic */ SlidingPaneLayout f384b;

    C0113n(SlidingPaneLayout slidingPaneLayout, View view) {
        this.f384b = slidingPaneLayout;
        this.f383a = view;
    }

    public void run() {
        if (this.f383a.getParent() == this.f384b) {
            ak.m533a(this.f383a, 0, null);
            this.f384b.m764d(this.f383a);
        }
        this.f384b.f370u.remove(this);
    }
}
