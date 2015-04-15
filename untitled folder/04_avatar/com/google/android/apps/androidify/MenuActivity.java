package com.google.android.apps.androidify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends Activity {
    private void a(int i) {
        findViewById(i).setOnClickListener(new bz(this));
    }

    private void a(CharSequence charSequence) {
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
        a((CharSequence) "share_to_website");
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.hold_position, R.anim.to_right);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_menu);
        a((int) R.id.menu_about);
        a((int) R.id.menu_myandroids);
        a((int) R.id.menu_share);
        a((int) R.id.menu_new_android);
    }
}
