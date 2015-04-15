package com.google.android.apps.androidify;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

public class IntroActivity extends Activity {
    private VideoView a;

    public void clickedClose(View view) {
        finish();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_intro);
        this.a = (VideoView) findViewById(R.id.intro_video);
        this.a.setOnCompletionListener(new bv(this));
        this.a.start();
    }
}
