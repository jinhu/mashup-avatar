package com.google.android.apps.androidify;

import android.app.Activity;
import android.os.Bundle;

public class PoseActivity extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_pose);
        DrawView drawView = (DrawView) findViewById(R.id.draw_view);
    }
}
