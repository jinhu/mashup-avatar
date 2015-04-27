package com.google.android.apps.androidify;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.google.android.apps.androidify.p018a.JsonUtil;
import com.google.android.apps.androidify.p018a.AnimationCatalogue;

import dev.game.legend.avatar.R;

public class GifActivity extends Activity {
    AndroidDrawer mAndroidDrawer;
    AnimationCatalogue f879b;
    long f880c;

    public GifActivity() {
        this.f880c = 0;
    }

    void m1494a() {
        long currentTimeMillis = System.currentTimeMillis();
        Util.debug("- Elapsed: " + (currentTimeMillis - this.f880c));
        this.f880c = currentTimeMillis;
    }

    public void encodeClicked(View view) {
        new bt(this).execute(new Void[0]);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_gif);
        AssetDatabase a = AssetDatabase.instance((Context) this);
        this.mAndroidDrawer = new AndroidDrawer(this);
        AndroidConfig a2 = a.m1656a();
        this.mAndroidDrawer.setAndroidConfig(a2, a);
        this.mAndroidDrawer.m1835a(400, 400);
        this.mAndroidDrawer.m1848b(0.75f);
        this.f879b = JsonUtil.getAnimationCatalogue((Context) this, (int) R.raw.anim_bodywave);
        DrawView drawView = (DrawView) findViewById(R.id.draw_view);
        drawView.setDroidConfig(a2);
        drawView.setMotion(this.f879b);
    }
}
