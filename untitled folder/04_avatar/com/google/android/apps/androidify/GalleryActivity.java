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
import com.google.android.apps.a.i;

public class GalleryActivity extends Activity implements br {
    private CharSequence a;
    private az b;
    private View c;
    private bn d;
    private bo e;
    private GridView f;
    private View g;
    private ImageButton h;
    private TextView i;

    public GalleryActivity() {
        this.d = bn.BLANK;
    }

    private void c() {
        Intent intent = new Intent();
        intent.putExtra("droidConfigIndex", this.e.b());
        this.b = null;
        setResult(-1, intent);
        finish();
    }

    public void a() {
        Intent intent = new Intent();
        intent.putExtra("addButton", true);
        this.b = null;
        setResult(-1, intent);
        finish();
    }

    public void a(int i, int i2, az azVar) {
        bu.a(this.g, azVar.E(), false, false, false, false, true);
        this.c.setVisibility(0);
        this.b = azVar;
    }

    public void b() {
        this.b = null;
        this.c.setVisibility(4);
    }

    public void b(int i, int i2, az azVar) {
        c();
    }

    public void clickedClose(View view) {
        finish();
        dh.a((Context) this);
    }

    public void clickedEdit(View view) {
        c();
    }

    public void clickedShare(View view) {
        ShareActivity.a((Activity) this, this.b);
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
        this.e = new bo(this, Androidify.a((Activity) this, true));
        this.e.a((br) this);
        this.f = (GridView) findViewById(R.id.grid_view);
        this.f.setAdapter(this.e);
        this.g = findViewById(R.id.header);
        bu.a(this.g, getString(R.string.menu_my_androids), false, false, false, false, true);
        this.i = (TextView) findViewById(R.id.tv_header_main);
        this.a = this.i.getText();
        this.h = (ImageButton) findViewById(R.id.btn_menu_burger);
        this.h.setVisibility(4);
        this.c = findViewById(R.id.rl_gallery_bottom_bar);
        try {
            i.a().a("gallery");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
