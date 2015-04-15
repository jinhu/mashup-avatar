package com.google.android.apps.androidify;

class ab implements Runnable {
    final /* synthetic */ Androidify a;

    ab(Androidify androidify) {
        this.a = androidify;
    }

    public void run() {
        Androidify.B = new dh(this.a);
        Androidify.B.a();
    }
}
