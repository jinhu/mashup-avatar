package com.google.android.apps.androidify;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;

class t implements OnPreparedListener {
    final /* synthetic */ Androidify a;

    t(Androidify androidify) {
        this.a = androidify;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        c.a("Surface prepared.");
        mediaPlayer.start();
    }
}
