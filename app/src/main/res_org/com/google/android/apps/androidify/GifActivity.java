package com.google.android.apps.androidify;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.apps.androidify.p018a.JsonUtil;
import com.google.android.apps.androidify.p018a.AnimationCatalogue;

public class GifActivity extends Activity {
    private AndroidDrawer f878a;
    private AnimationCatalogue f879b;
    private long f880c;

    public GifActivity() {
        this.f880c = 0;
    }

    private void m1494a() {
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
        this.f878a = new AndroidDrawer(this);
        AndroidConfig a2 = a.m1656a();
        this.f878a.setAndroidConfig(a2, a);
        this.f878a.m1835a(400, 400);
        this.f878a.m1848b(0.75f);
        this.f879b = JsonUtil.getAnimationCatalogue((Context) this, (int) R.raw.anim_bodywave);
        DrawView drawView = (DrawView) findViewById(R.id.draw_view);
        drawView.setDroidConfig(a2);
        drawView.setMotion(this.f879b);
    }
}
