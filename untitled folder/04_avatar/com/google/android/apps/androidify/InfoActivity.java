package com.google.android.apps.androidify;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.apps.a.i;

public class InfoActivity extends Activity {
    public void clickedClose(View view) {
        finish();
        dh.a((Context) this);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_info);
        View findViewById = findViewById(R.id.header);
        bu.a(findViewById, "", false, false, false, false, true);
        findViewById.setBackgroundColor(-1);
        try {
            i.a().a("license");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
