package com.google.android.apps.androidify;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class am implements OnGlobalLayoutListener {
    final /* synthetic */ ah f1216a;
    final /* synthetic */ DrawView f1217b;

    am(DrawView drawView, ah ahVar) {
        this.f1217b = drawView;
        this.f1216a = ahVar;
    }

    public void onGlobalLayout() {
        this.f1217b.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        if (this.f1217b.f799a == null) {
            this.f1217b.m1425c();
            C0220c.m1912a("Set config...");
            if (this.f1217b.f800b == null) {
                this.f1217b.setDroidConfig(this.f1216a.m1656a());
            } else {
                this.f1217b.setDroidConfig(this.f1217b.f800b);
            }
        }
        this.f1217b.f799a.m1835a(this.f1217b.getWidth(), this.f1217b.getHeight());
        this.f1217b.m1425c();
        C0220c.m1912a("Rescale...");
        this.f1217b.f799a.m1853c();
        this.f1217b.m1425c();
        C0220c.m1912a("Done.");
    }
}
