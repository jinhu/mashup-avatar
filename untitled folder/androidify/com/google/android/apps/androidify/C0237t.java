package com.google.android.apps.androidify;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;

/* renamed from: com.google.android.apps.androidify.t */
class C0237t implements OnPreparedListener {
    final /* synthetic */ Androidify f1665a;

    C0237t(Androidify androidify) {
        this.f1665a = androidify;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        C0220c.m1912a("Surface prepared.");
        mediaPlayer.start();
    }
}
