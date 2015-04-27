package com.google.android.apps.androidify;

import com.google.android.C0176a;

public final class bj extends Thread {
    final /* synthetic */ DroidView f1425a;
    private boolean f1426b;

    public bj(DroidView droidView) {
        this.f1425a = droidView;
    }

    public void m1871a() {
        this.f1426b = true;
    }

    public void run() {
        C0176a.m1106c("--> Starting random animations.");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e2) {
            }
            if (this.f1426b) {
                C0176a.m1106c("--> Stopping random animations.");
                return;
            } else if (System.currentTimeMillis() - this.f1425a.aE > 2000 && DroidView.f819a.nextInt(100) < 20) {
                this.f1425a.aU.post(this.f1425a.aV);
            }
        }
    }
}
