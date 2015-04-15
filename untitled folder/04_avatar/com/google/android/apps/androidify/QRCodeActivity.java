package com.google.android.apps.androidify;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.a.a.a.b;
import com.google.android.a;
import com.google.android.apps.a.i;
import java.io.IOException;

public class QRCodeActivity extends Activity {
    private ImageView a;
    private az b;
    private String c;

    public static Intent a(Activity activity, az azVar, String str) {
        Intent intent = new Intent(activity, QRCodeActivity.class);
        intent.setFlags(1073741824);
        try {
            intent.putExtra("configString", azVar.c());
        } catch (IOException e) {
            e.printStackTrace();
        }
        intent.putExtra("shareId", str);
        return intent;
    }

    private void a() {
        try {
            String str = "https://www.androidify.com/p/" + this.c;
            c.a("Encoding droid string url " + str);
            b bVar = new b(str, null, "TEXT_TYPE", "QR_CODE", this.a.getWidth());
            bVar.a(getResources().getColor(R.color.qr_green));
            this.a.setImageBitmap(bVar.a());
        } catch (Throwable e) {
            a.a(e);
            finish();
        }
    }

    private void a(int i, int i2, az azVar) {
        ah a = ah.a((Context) this);
        DrawView drawView = (DrawView) findViewById(i);
        ba baVar = new ba(this);
        baVar.a(azVar, a);
        baVar.b(0.75f);
        baVar.a(0);
        drawView.setMotion(com.google.android.apps.androidify.a.a.a((Context) this, i2));
        drawView.setDroidDrawer(baVar);
        drawView.a();
        drawView.invalidate();
    }

    public void clickedClose(View view) {
        finish();
        dh.a((Context) this);
    }

    public void clickedXButton(View view) {
        Androidify.a((Activity) this);
        dh.a((Context) this);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_qrcode);
        this.a = (ImageView) findViewById(R.id.qr_view);
        View findViewById = findViewById(R.id.header);
        bu.a(findViewById, "", false, false, true, false, true);
        findViewById.setBackgroundColor(-1);
        this.c = getIntent().getStringExtra("shareId");
        this.b = null;
        try {
            String stringExtra = getIntent().getStringExtra("configString");
            this.b = new az();
            this.b.a((Context) this, stringExtra);
        } catch (Exception e) {
            e.printStackTrace();
            this.b = az.a();
        }
        ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(new ck(this));
        }
        a((int) R.id.dv_qr_droid, (int) R.raw.anim_bodywave, this.b);
        try {
            i.a().a("qrshare");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
