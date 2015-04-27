package com.google.android.apps.androidify;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import com.google.android.apps.androidify.p018a.C0208e;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MotionActivity extends Activity {
    private ViewGroup f884a;
    private ce f885b;
    private cd f886c;
    private GridView f887d;
    private ah f888e;
    private az f889f;
    private View f890g;
    private TextView f891h;
    private ImageButton f892i;
    private int f893j;
    private int f894k;
    private long f895l;

    public MotionActivity() {
        this.f886c = cd.SELECTING;
        this.f893j = 0;
        this.f895l = 0;
    }

    private File m1506a(String str) {
        String str2 = Environment.getExternalStorageDirectory() + "/DCIM/Camera/";
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str2 + "androidify." + str);
    }

    private void m1509a(ce ceVar, View view) {
        m1524a(true);
        this.f886c = cd.EXPORTING;
        C0208e c0208e = (C0208e) ceVar.getItem(this.f893j);
        if (c0208e != null) {
            m1523a(c0208e);
        } else {
            m1521a();
        }
    }

    private void m1510a(File file) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/gif");
        intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
        intent.setFlags(268468224);
        startActivity(Intent.createChooser(intent, "Share"));
    }

    private void m1512b() {
        long currentTimeMillis = System.currentTimeMillis();
        C0220c.m1912a("- Elapsed: " + (currentTimeMillis - this.f895l));
        this.f895l = currentTimeMillis;
    }

    public void m1521a() {
        try {
            File a = m1506a("png");
            OutputStream fileOutputStream = new FileOutputStream(a);
            Bitmap createBitmap = Bitmap.createBitmap(500, 500, Config.ARGB_8888);
            ba baVar = new ba(this);
            baVar.m1844a(this.f889f, this.f888e);
            baVar.m1835a(500, 500);
            baVar.m1848b(0.75f);
            baVar.m1837a(new Canvas(createBitmap));
            createBitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            m1510a(a);
            m1522a(this.f894k);
            this.f886c = cd.SELECTING;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void m1522a(int i) {
        int childCount = this.f887d.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.f887d.getChildAt(i2);
            if (childAt instanceof DrawView) {
                DrawView drawView = (DrawView) childAt;
                drawView.setShowPoster(true);
                drawView.setBackgroundColor(i);
            }
        }
    }

    public void m1523a(C0208e c0208e) {
        new cc(this, c0208e).execute(new Void[0]);
    }

    public void m1524a(boolean z) {
        int childCount = this.f887d.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f887d.getChildAt(i);
            if (childAt instanceof DrawView) {
                DrawView drawView = (DrawView) childAt;
                if (drawView.m1427b() != z) {
                    drawView.setPaused(z);
                }
            }
        }
    }

    public void clickedShare(View view) {
        m1509a(this.f885b, view);
    }

    protected void onCreate(Bundle bundle) {
        az azVar;
        super.onCreate(bundle);
        requestWindowFeature(1);
        if (getIntent().hasExtra("DroidConfig")) {
            String stringExtra = getIntent().getStringExtra("DroidConfig");
            try {
                azVar = new az();
                azVar.m1776a((Context) this, stringExtra);
            } catch (IOException e) {
                e.printStackTrace();
                azVar = null;
            }
        } else {
            azVar = null;
        }
        setContentView(R.layout.activity_motion);
        this.f888e = ah.m1648a((Context) this);
        if (azVar == null) {
            this.f889f = this.f888e.m1656a();
        } else {
            this.f889f = azVar;
        }
        this.f894k = getResources().getColor(R.color.bg_grey);
        this.f890g = findViewById(R.id.header);
        bu.m1894a(this.f890g, getString(R.string.share_your_android), false, false, false, false, true);
        this.f891h = (TextView) findViewById(R.id.tv_header_main);
        this.f887d = (GridView) findViewById(R.id.grid_view);
        this.f885b = new ce(this, this.f889f, null);
        this.f887d.setAdapter(this.f885b);
        this.f887d.setOnItemClickListener(new ca(this));
        this.f884a = (ViewGroup) findViewById(R.id.rl_motion_bottom_bar);
        this.f892i = (ImageButton) findViewById(R.id.btn_motion_share);
        this.f884a.setOnClickListener(new cb(this));
    }

    protected void onPause() {
        super.onPause();
        m1524a(true);
    }

    protected void onResume() {
        super.onResume();
        m1524a(false);
    }
}
