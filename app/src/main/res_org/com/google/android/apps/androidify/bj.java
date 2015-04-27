package com.google.android.apps.androidify;

import com.google.android.Util;

public final class bj extends Thread {
    final /* synthetic */ DroidView mDroidView;
    private boolean f1426b;

    public bj(DroidView droidView) {
        this.mDroidView = droidView;
    }

    public void m1871a() {
        this.f1426b = true;
    }

    public void run() {
        Util.debug("--> Starting random animations.");
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
                Util.debug("--> Stopping random animations.");
                return;
            } else if (System.currentTimeMillis() - this.mDroidView.startTime > 2000 && DroidView.f819a.nextInt(100) < 20) {
                this.mDroidView.aU.post(this.mDroidView.aV
                );
            }
        }
    }
}
