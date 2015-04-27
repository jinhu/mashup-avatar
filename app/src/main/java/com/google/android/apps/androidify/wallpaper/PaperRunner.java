package com.google.android.apps.androidify.wallpaper;

/* renamed from: com.google.android.apps.androidify.wallpaper.d */
class PaperRunner implements Runnable {
    final /* synthetic */ PaperEngine mPaperEngine;

    PaperRunner(PaperEngine aPaperEngine) {
        this.mPaperEngine = aPaperEngine;
    }

    public void run() {
        try {
            this.mPaperEngine.initAndroid();
        } catch (Throwable aThrowable) {
            aThrowable.printStackTrace();
        }
    }
}
