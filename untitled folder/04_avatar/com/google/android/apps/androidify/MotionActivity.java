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
import com.google.android.apps.androidify.a.e;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MotionActivity extends Activity {
    private ViewGroup a;
    private ce b;
    private cd c;
    private GridView d;
    private ah e;
    private az f;
    private View g;
    private TextView h;
    private ImageButton i;
    private int j;
    private int k;
    private long l;

    public MotionActivity() {
        this.c = cd.SELECTING;
        this.j = 0;
        this.l = 0;
    }

    private File a(String str) {
        String str2 = Environment.getExternalStorageDirectory() + "/DCIM/Camera/";
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str2 + "androidify." + str);
    }

    private void a(ce ceVar, View view) {
        a(true);
        this.c = cd.EXPORTING;
        e eVar = (e) ceVar.getItem(this.j);
        if (eVar != null) {
            a(eVar);
        } else {
            a();
        }
    }

    private void a(File file) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/gif");
        intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
        intent.setFlags(268468224);
        startActivity(Intent.createChooser(intent, "Share"));
    }

    private void b() {
        long currentTimeMillis = System.currentTimeMillis();
        c.a("- Elapsed: " + (currentTimeMillis - this.l));
        this.l = currentTimeMillis;
    }

    public void a() {
        try {
            File a = a("png");
            OutputStream fileOutputStream = new FileOutputStream(a);
            Bitmap createBitmap = Bitmap.createBitmap(500, 500, Config.ARGB_8888);
            ba baVar = new ba(this);
            baVar.a(this.f, this.e);
            baVar.a(500, 500);
            baVar.b(0.75f);
            baVar.a(new Canvas(createBitmap));
            createBitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            a(a);
            a(this.k);
            this.c = cd.SELECTING;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void a(int i) {
        int childCount = this.d.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.d.getChildAt(i2);
            if (childAt instanceof DrawView) {
                DrawView drawView = (DrawView) childAt;
                drawView.setShowPoster(true);
                drawView.setBackgroundColor(i);
            }
        }
    }

    public void a(e eVar) {
        new cc(this, eVar).execute(new Void[0]);
    }

    public void a(boolean z) {
        int childCount = this.d.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.d.getChildAt(i);
            if (childAt instanceof DrawView) {
                DrawView drawView = (DrawView) childAt;
                if (drawView.b() != z) {
                    drawView.setPaused(z);
                }
            }
        }
    }

    public void clickedShare(View view) {
        a(this.b, view);
    }

    protected void onCreate(Bundle bundle) {
        az azVar;
        super.onCreate(bundle);
        requestWindowFeature(1);
        if (getIntent().hasExtra("DroidConfig")) {
            String stringExtra = getIntent().getStringExtra("DroidConfig");
            try {
                azVar = new az();
                azVar.a((Context) this, stringExtra);
            } catch (IOException e) {
                e.printStackTrace();
                azVar = null;
            }
        } else {
            azVar = null;
        }
        setContentView(R.layout.activity_motion);
        this.e = ah.a((Context) this);
        if (azVar == null) {
            this.f = this.e.a();
        } else {
            this.f = azVar;
        }
        this.k = getResources().getColor(R.color.bg_grey);
        this.g = findViewById(R.id.header);
        bu.a(this.g, getString(R.string.share_your_android), false, false, false, false, true);
        this.h = (TextView) findViewById(R.id.tv_header_main);
        this.d = (GridView) findViewById(R.id.grid_view);
        this.b = new ce(this, this.f, null);
        this.d.setAdapter(this.b);
        this.d.setOnItemClickListener(new ca(this));
        this.a = (ViewGroup) findViewById(R.id.rl_motion_bottom_bar);
        this.i = (ImageButton) findViewById(R.id.btn_motion_share);
        this.a.setOnClickListener(new cb(this));
    }

    protected void onPause() {
        super.onPause();
        a(true);
    }

    protected void onResume() {
        super.onResume();
        a(false);
    }
}
