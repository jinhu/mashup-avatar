package com.google.android.apps.androidify;

import com.google.android.Util;

public final class AnimatorThread extends Thread {
    final /* synthetic */ DroidView mDroidView;
    private boolean mStopFlag;

    public AnimatorThread(DroidView droidView) {
        this.mDroidView = droidView;
    }

    public void stopAnimation() {
        this.mStopFlag = true;
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
            if (this.mStopFlag) {
                Util.debug("--> Stopping random animations.");
                return;
            } else if (System.currentTimeMillis() - this.mDroidView.startTime > 2000 && DroidView.RANDOM.nextInt(100) < 20) {
                this.mDroidView.mAnimationHandler.post(this.mDroidView.mAnimationTask);
            }
        }
    }
}
