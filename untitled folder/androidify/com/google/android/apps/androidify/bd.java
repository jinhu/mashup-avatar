package com.google.android.apps.androidify;

class bd implements Runnable {
    final /* synthetic */ bc f1404a;

    bd(bc bcVar) {
        this.f1404a = bcVar;
    }

    public void run() {
        for (int i = 3; i < this.f1404a.f1392a.size(); i++) {
            DroidView droidView = (bs) this.f1404a.f1401j.get(i);
            this.f1404a.f1393b.m1373a(droidView, (az) this.f1404a.f1392a.get(i));
            droidView.postInvalidate();
        }
    }
}