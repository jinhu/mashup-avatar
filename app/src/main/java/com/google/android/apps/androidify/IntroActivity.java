package com.google.android.apps.androidify;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

import dev.game.legend.avatar.R;

public class IntroActivity extends Activity {
    private VideoView f883a;

    public void clickedClose(View view) {
        finish();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_intro);
        this.f883a = (VideoView) findViewById(R.id.intro_video);
        this.f883a.setOnCompletionListener(new bv(this));
        this.f883a.start();
    }
}
