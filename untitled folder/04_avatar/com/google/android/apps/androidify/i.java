package com.google.android.apps.androidify;

class i implements Runnable {
    final /* synthetic */ av a;
    final /* synthetic */ Androidify b;

    i(Androidify androidify, av avVar) {
        this.b = androidify;
        this.a = avVar;
    }

    public void run() {
        this.b.V.a(this.a);
        if (this.a != null) {
            this.b.a(this.a.o);
        }
    }
}
