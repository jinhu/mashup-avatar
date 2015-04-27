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

import com.google.android.apps.androidify.p018a.AnimationCatalogue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import dev.game.legend.avatar.R;

public class MotionActivity extends Activity {
    private ViewGroup f884a;
    private AndroidModelAdapter mAndroidModelAdapter;
    private ControlState mState;
    private GridView mGridView;
    private AssetDatabase mAssetDatabase;
    AndroidConfig f889f;
    private View f890g;
    TextView f891h;
    private ImageButton f892i;
    int f893j;
    private int f894k;
    private long f895l;

    public MotionActivity() {
        this.mState = ControlState.SELECTING;
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

    private void m1509a(AndroidModelAdapter aAndroidModelAdapterVar, View view) {
        m1524a(true);
        this.mState = ControlState.EXPORTING;
        AnimationCatalogue animationCatalogue = (AnimationCatalogue) aAndroidModelAdapterVar.getItem(this.f893j);
        if (animationCatalogue != null) {
            m1523a(animationCatalogue);
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
        Util.debug("- Elapsed: " + (currentTimeMillis - this.f895l));
        this.f895l = currentTimeMillis;
    }

    public void m1521a() {
        try {
            File a = m1506a("png");
            OutputStream fileOutputStream = new FileOutputStream(a);
            Bitmap createBitmap = Bitmap.createBitmap(500, 500, Config.ARGB_8888);
            AndroidDrawer androidDrawerVar = new AndroidDrawer(this);
            androidDrawerVar.setAndroidConfig(this.f889f, this.mAssetDatabase);
            androidDrawerVar.m1835a(500, 500);
            androidDrawerVar.m1848b(0.75f);
            androidDrawerVar.m1837a(new Canvas(createBitmap));
            createBitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            m1510a(a);
            m1522a(this.f894k);
            this.mState = ControlState.SELECTING;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void m1522a(int i) {
        int childCount = this.mGridView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.mGridView.getChildAt(i2);
            if (childAt instanceof DrawView) {
                DrawView drawView = (DrawView) childAt;
                drawView.setShowPoster(true);
                drawView.setBackgroundColor(i);
            }
        }
    }

    public void m1523a(AnimationCatalogue aAnimationCatalogue) {
        new cc(this, aAnimationCatalogue).execute(new Void[0]);
    }

    public void m1524a(boolean z) {
        int childCount = this.mGridView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mGridView.getChildAt(i);
            if (childAt instanceof DrawView) {
                DrawView drawView = (DrawView) childAt;
                if (drawView.m1427b() != z) {
                    drawView.setPaused(z);
                }
            }
        }
    }

    public void clickedShare(View view) {
        m1509a(this.mAndroidModelAdapter, view);
    }

    protected void onCreate(Bundle bundle) {
        AndroidConfig androidConfigVar;
        super.onCreate(bundle);
        requestWindowFeature(1);
        if (getIntent().hasExtra("DroidConfig")) {
            String stringExtra = getIntent().getStringExtra("DroidConfig");
            try {
                androidConfigVar = new AndroidConfig();
                androidConfigVar.getInstance((Context) this, stringExtra);
            } catch (Exception e) {
                e.printStackTrace();
                androidConfigVar = null;
            }
        } else {
            androidConfigVar = null;
        }
        setContentView(R.layout.activity_motion);
        this.mAssetDatabase = AssetDatabase.instance((Context) this);
        if (androidConfigVar == null) {
            this.f889f = this.mAssetDatabase.m1656a();
        } else {
            this.f889f = androidConfigVar;
        }
        this.f894k = getResources().getColor(R.color.bg_grey);
        this.f890g = findViewById(R.id.header);
        bu.m1894a(this.f890g, getString(R.string.share_your_android), false, false, false, false, true);
        this.f891h = (TextView) findViewById(R.id.tv_header_main);
        this.mGridView = (GridView) findViewById(R.id.grid_view);
        this.mAndroidModelAdapter = new AndroidModelAdapter(this, this.f889f, null);
        this.mGridView.setAdapter(this.mAndroidModelAdapter);
        this.mGridView.setOnItemClickListener(new ItemClickListener(this));
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
