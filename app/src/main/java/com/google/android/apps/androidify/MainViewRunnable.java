package com.google.android.apps.androidify;

class MainViewRunnable implements Runnable {
    final /* synthetic */ ManiView mManiView;

    MainViewRunnable(ManiView aManiViewVar) {
        this.mManiView = aManiViewVar;
    }

    public void run() {
        this.mManiView.mAndroidify.proceedTutorial(3, false);
    }
}
