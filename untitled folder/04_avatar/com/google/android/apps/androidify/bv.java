package com.google.android.apps.androidify;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

class bv implements OnCompletionListener {
    final /* synthetic */ IntroActivity a;

    bv(IntroActivity introActivity) {
        this.a = introActivity;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        Intent intent = new Intent(this.a, Androidify.class);
        intent.setFlags(67108864);
        this.a.startActivity(intent);
        this.a.overridePendingTransition(0, 0);
    }
}
