package com.google.android.apps.androidify;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.apps.p016a.C0185i;

public class InfoActivity extends Activity {
    public void clickedClose(View view) {
        finish();
        dh.m1956a((Context) this);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_info);
        View findViewById = findViewById(R.id.header);
        bu.m1894a(findViewById, "", false, false, false, false, true);
        findViewById.setBackgroundColor(-1);
        try {
            C0185i.m1177a().m1184a("license");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
