package com.google.android.apps.androidify;

class bd implements Runnable {
    final /* synthetic */ bc a;

    bd(bc bcVar) {
        this.a = bcVar;
    }

    public void run() {
        for (int i = 3; i < this.a.a.size(); i++) {
            DroidView droidView = (bs) this.a.j.get(i);
            this.a.b.a(droidView, (az) this.a.a.get(i));
            droidView.postInvalidate();
        }
    }
}
