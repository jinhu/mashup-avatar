package com.google.android.apps.androidify;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class am implements OnGlobalLayoutListener {
    final /* synthetic */ ah a;
    final /* synthetic */ DrawView b;

    am(DrawView drawView, ah ahVar) {
        this.b = drawView;
        this.a = ahVar;
    }

    public void onGlobalLayout() {
        this.b.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        if (this.b.a == null) {
            this.b.c();
            c.a("Set config...");
            if (this.b.b == null) {
                this.b.setDroidConfig(this.a.a());
            } else {
                this.b.setDroidConfig(this.b.b);
            }
        }
        this.b.a.a(this.b.getWidth(), this.b.getHeight());
        this.b.c();
        c.a("Rescale...");
        this.b.a.c();
        this.b.c();
        c.a("Done.");
    }
}
