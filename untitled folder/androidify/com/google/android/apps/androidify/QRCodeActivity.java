package com.google.android.apps.androidify;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.google.android.C0176a;
import com.google.android.apps.androidify.p018a.C0204a;
import com.google.android.apps.p016a.C0185i;
import com.p004a.p005a.p006a.C0124b;
import java.io.IOException;

public class QRCodeActivity extends Activity {
    private ImageView f901a;
    private az f902b;
    private String f903c;

    public static Intent m1526a(Activity activity, az azVar, String str) {
        Intent intent = new Intent(activity, QRCodeActivity.class);
        intent.setFlags(1073741824);
        try {
            intent.putExtra("configString", azVar.m1787c());
        } catch (IOException e) {
            e.printStackTrace();
        }
        intent.putExtra("shareId", str);
        return intent;
    }

    private void m1527a() {
        try {
            String str = "https://www.androidify.com/p/" + this.f903c;
            C0220c.m1912a("Encoding droid string url " + str);
            C0124b c0124b = new C0124b(str, null, "TEXT_TYPE", "QR_CODE", this.f901a.getWidth());
            c0124b.m913a(getResources().getColor(R.color.qr_green));
            this.f901a.setImageBitmap(c0124b.m912a());
        } catch (Throwable e) {
            C0176a.m1103a(e);
            finish();
        }
    }

    private void m1528a(int i, int i2, az azVar) {
        ah a = ah.m1648a((Context) this);
        DrawView drawView = (DrawView) findViewById(i);
        ba baVar = new ba(this);
        baVar.m1844a(azVar, a);
        baVar.m1848b(0.75f);
        baVar.m1834a(0);
        drawView.setMotion(C0204a.m1596a((Context) this, i2));
        drawView.setDroidDrawer(baVar);
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
            this.f902b = new az();
            this.f902b.m1776a((Context) this, stringExtra);
        } catch (Exception e) {
            e.printStackTrace();
            this.f902b = az.m1762a();
        }
        ViewTreeObserver viewTreeObserver = this.f901a.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(new ck(this));
        }
        m1528a((int) R.id.dv_qr_droid, (int) R.raw.anim_bodywave, this.f902b);
        try {
            C0185i.m1177a().m1184a("qrshare");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
