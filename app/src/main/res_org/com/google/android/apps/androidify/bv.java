package com.google.android.apps.androidify;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

class bv implements OnCompletionListener {
    final /* synthetic */ IntroActivity f1467a;

    bv(IntroActivity introActivity) {
        this.f1467a = introActivity;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        Intent intent = new Intent(this.f1467a, Androidify.class);
        intent.setFlags(67108864);
        this.f1467a.startActivity(intent);
        this.f1467a.overridePendingTransition(0, 0);
    }
}
