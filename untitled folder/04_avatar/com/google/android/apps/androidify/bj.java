package com.google.android.apps.androidify;

import com.google.android.a;

public final class bj extends Thread {
    final /* synthetic */ DroidView a;
    private boolean b;

    public bj(DroidView droidView) {
        this.a = droidView;
    }

    public void a() {
        this.b = true;
    }

    public void run() {
        a.c("--> Starting random animations.");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e2) {
            }
            if (this.b) {
                a.c("--> Stopping random animations.");
                return;
            } else if (System.currentTimeMillis() - this.a.aE > 2000 && DroidView.a.nextInt(100) < 20) {
                this.a.aU.post(this.a.aV);
            }
        }
    }
}
