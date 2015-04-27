package com.google.android.apps.androidify;

class MyUnknownTask implements Runnable {
    final /* synthetic */ AntennaAnimation f1127a;

    MyUnknownTask(AntennaAnimation aAntennaAnimationVar) {
        this.f1127a = aAntennaAnimationVar;
    }

    public void run() {
        if (this.f1127a.f1125d) {
            this.f1127a.step();
        }
    }
}
