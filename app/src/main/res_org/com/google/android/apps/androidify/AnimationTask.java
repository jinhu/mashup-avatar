package com.google.android.apps.androidify;

class AnimationTask implements Runnable {
    final /* synthetic */ Androidify f1120a;

    AnimationTask(Androidify androidify) {
        this.f1120a = androidify;
    }

    public void run() {
        Androidify.runner = new dh(this.f1120a);
        Androidify.runner.m1975a();
    }
}
