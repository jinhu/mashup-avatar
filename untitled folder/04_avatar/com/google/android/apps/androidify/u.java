package com.google.android.apps.androidify;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

class u implements OnCompletionListener {
    final /* synthetic */ Androidify a;

    u(Androidify androidify) {
        this.a = androidify;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        this.a.u();
    }
}
