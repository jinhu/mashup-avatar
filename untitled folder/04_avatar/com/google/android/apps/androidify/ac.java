package com.google.android.apps.androidify;

class ac implements Runnable {
    final /* synthetic */ Androidify a;

    ac(Androidify androidify) {
        this.a = androidify;
    }

    public void run() {
        this.a.showDialog(7);
    }
}
