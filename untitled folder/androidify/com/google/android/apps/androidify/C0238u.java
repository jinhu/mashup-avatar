package com.google.android.apps.androidify;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

/* renamed from: com.google.android.apps.androidify.u */
class C0238u implements OnCompletionListener {
    final /* synthetic */ Androidify f1666a;

    C0238u(Androidify androidify) {
        this.f1666a = androidify;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f1666a.m1405u();
    }
}
