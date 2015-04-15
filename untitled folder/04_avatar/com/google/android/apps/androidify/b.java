package com.google.android.apps.androidify;

class b implements Runnable {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public void run() {
        if (this.a.h) {
            this.a.d();
            this.a.e.a(true);
            this.a.g.postDelayed(this, 100);
        }
    }
}
