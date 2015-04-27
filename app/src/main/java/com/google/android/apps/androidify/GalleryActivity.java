package com.google.android.apps.androidify;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.apps.analytics.GoogleAnalyticsTracker;

import dev.game.legend.avatar.R;

public class GalleryActivity extends Activity implements GaleryInterface {
    private CharSequence f869a;
    private AndroidConfig f870b;
    private View f871c;
    private bn f872d;
    private AndroidBaseAdapter f873e;
    private GridView f874f;
    private View f875g;
    private ImageButton f876h;
    private TextView f877i;

    public GalleryActivity() {
        this.f872d = bn.BLANK;
    }

    private void share() {
        Intent intent = new Intent();
        intent.putExtra("droidConfigIndex", this.f873e.m1886b());
        this.f870b = null;
        setResult(-1, intent);
        finish();
    }
    @Override
    public void shareOnce() {
        Intent intent = new Intent();
        intent.putExtra("addButton", true);
        this.f870b = null;
        setResult(-1, intent);
        finish();
    }
@Override
    public void shareOnce(int i, int i2, AndroidConfig aAndroidConfigVar) {
        bu.m1894a(this.f875g, aAndroidConfigVar.m1769E(), false, false, false, false, true);
        this.f871c.setVisibility(0);
        this.f870b = aAndroidConfigVar;
    }
@Override
    public void shareAll() {
        this.f870b = null;
        this.f871c.setVisibility(4);
    }
@Override
    public void shareAll(int i, int i2, AndroidConfig aAndroidConfigVar) {
        share();
    }

    public void clickedClose(View view) {
        finish();
        dh.m1956a((Context) this);
    }

    public void clickedEdit(View view) {
        share();
    }

    public void clickedShare(View view) {
        ShareActivity.m1535a((Activity) this, this.f870b);
    }

    public void clickedTrash(View view) {
        Builder builder = new Builder(this);
        builder.setIcon(R.drawable.ic_launcher);
        builder.setTitle(R.string.dialog_title_discard_droid);
        builder.setMessage(R.string.dialog_msg_discard_droid);
        builder.setPositiveButton(R.string.dialog_ok_discard_droid, new bm(this));
        builder.setNegativeButton(R.string.dialog_nok_discard_droid, null);
        builder.show();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.activity_gallery);
        this.f873e = new AndroidBaseAdapter(this, Androidify.getSaveList((Activity) this, true));
        this.f873e.m1884a((GaleryInterface) this);
        this.f874f = (GridView) findViewById(R.id.grid_view);
        this.f874f.setAdapter(this.f873e);
        this.f875g = findViewById(R.id.header);
        bu.m1894a(this.f875g, getString(R.string.menu_my_androids), false, false, false, false, true);
        this.f877i = (TextView) findViewById(R.id.tv_header_main);
        this.f869a = this.f877i.getText();
        this.f876h = (ImageButton) findViewById(R.id.btn_menu_burger);
        this.f876h.setVisibility(View.INVISIBLE);
        this.f871c = findViewById(R.id.rl_gallery_bottom_bar);
        try {
            GoogleAnalyticsTracker.m1177a().m1184a("gallery");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
