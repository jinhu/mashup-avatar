package com.google.android.apps.androidify;

/* renamed from: com.google.android.apps.androidify.b */
class C0219b implements Runnable {
    final /* synthetic */ C0216a f1336a;

    C0219b(C0216a c0216a) {
        this.f1336a = c0216a;
    }

    public void run() {
        if (this.f1336a.f1117h) {
            this.f1336a.m1634d();
            this.f1336a.f1114e.m1380a(true);
            this.f1336a.f1116g.postDelayed(this, 100);
        }
    }
}
