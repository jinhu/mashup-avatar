package com.google.android.apps.androidify;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import com.google.android.apps.androidify.p018a.JsonUtil;
import com.google.android.apps.analytics.GoogleAnalyticsTracker;

import java.io.IOException;

import dev.game.legend.avatar.R;

public class QRCodeActivity extends Activity {
    private ImageView f901a;
    private AndroidConfig f902b;
    private String f903c;

    public static Intent m1526a(Activity activity, AndroidConfig aAndroidConfigVar, String str) {
        Intent intent = new Intent(activity, QRCodeActivity.class);
        intent.setFlags(1073741824);
        try {
            intent.putExtra("configString", aAndroidConfigVar.m1787c());
        } catch (IOException e) {
            e.printStackTrace();
        }
        intent.putExtra("shareId", str);
        return intent;
    }

    void m1527a() {
        try {
            String str = "https://www.androidify.com/p/" + this.f903c;
            Util.debug("Encoding droid string url " + str);
            //C0124b c0124b = new C0124b(str, null, "TEXT_TYPE", "QR_CODE", this.f901a.getWidth());
            //c0124b.m913a(getResources().getColor(R.color.qr_green));
            //this.f901a.setImageBitmap(c0124b.m912a());
        } catch (Throwable e) {
            com.google.android.Util.m1103a(e);
            finish();
        }
    }

    private void m1528a(int i, int i2, AndroidConfig aAndroidConfigVar) {
        AssetDatabase a = AssetDatabase.instance((Context) this);
        DrawView drawView = (DrawView) findViewById(i);
        AndroidDrawer androidDrawerVar = new AndroidDrawer(this);
        androidDrawerVar.setAndroidConfig(aAndroidConfigVar, a);
        androidDrawerVar.m1848b(0.75f);
        androidDrawerVar.m1834a(0);
        drawView.setMotion(JsonUtil.getAnimationCatalogue((Context) this, i2));
        drawView.setDroidDrawer(androidDrawerVar);
        drawView.m1426a();
        drawView.invalidate();
    }

    public void clickedClose(View view) {
        finish();
        dh.m1956a((Context) this);
    }

    public void clickedXButton(View view) {
        Androidify.m1337a((Activity) this);
        dh.m1956a((Context) this);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_qrcode);
        this.f901a = (ImageView) findViewById(R.id.qr_view);
        View findViewById = findViewById(R.id.header);
        bu.m1894a(findViewById, "", false, false, true, false, true);
        findViewById.setBackgroundColor(-1);
        this.f903c = getIntent().getStringExtra("shareId");
        this.f902b = null;
        try {
            String stringExtra = getIntent().getStringExtra("configString");
            this.f902b = new AndroidConfig();
            this.f902b.getInstance((Context) this, stringExtra);
        } catch (Exception e) {
            e.printStackTrace();
            this.f902b = AndroidConfig.m1762a();
        } catch (Throwable aThrowable) {
            aThrowable.printStackTrace();
        }
        ViewTreeObserver viewTreeObserver = this.f901a.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(new ck(this));
        }
        m1528a((int) R.id.dv_qr_droid, (int) R.raw.anim_bodywave, this.f902b);
        try {
            GoogleAnalyticsTracker.m1177a().m1184a("qrshare");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
