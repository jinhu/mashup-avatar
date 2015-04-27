package com.google.android.apps.androidify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends Activity {
    private void m1498a(int i) {
        findViewById(i).setOnClickListener(new bz(this));
    }

    private void m1500a(CharSequence charSequence) {
        Intent intent = new Intent();
        if (charSequence != null) {
            intent.putExtra("menuTextSelected", charSequence.toString());
        }
        setResult(-1, intent);
        finish();
    }

    public void clickedClose(View view) {
        finish();
        overridePendingTransition(R.anim.hold_position, R.anim.to_right);
    }

    public void clickedShareToWebsite(View view) {
        m1500a((CharSequence) "share_to_website");
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.hold_position, R.anim.to_right);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_menu);
        m1498a((int) R.id.menu_about);
        m1498a((int) R.id.menu_myandroids);
        m1498a((int) R.id.menu_share);
        m1498a((int) R.id.menu_new_android);
    }
}
