package com.google.android.apps.androidify;

class AnimationTask implements Runnable {
    final /* synthetic */ Androidify mAndroidify;

    AnimationTask(Androidify androidify) {
        this.mAndroidify = androidify;
    }

    public void run() {
        Androidify.runner = new DroidConfig(this.mAndroidify);
        Androidify.runner.init();
    }
}
