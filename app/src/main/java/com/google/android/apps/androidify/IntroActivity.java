package com.google.android.apps.androidify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

import dev.game.legend.avatar.R;

public class IntroActivity extends Activity {
    private VideoView mVideoView;

    public void clickedClose(View view) {
        finish();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_intro);
        this.mVideoView = (VideoView) findViewById(R.id.intro_video);
        this.mVideoView.setOnCompletionListener(mp -> {
                    Intent intent = new Intent(this, Androidify.class);
                    intent.setFlags(67108864);
                    this.startActivity(intent);
                    this.overridePendingTransition(0, 0);
                }
        );
            this.mVideoView .start();
        }
    }
