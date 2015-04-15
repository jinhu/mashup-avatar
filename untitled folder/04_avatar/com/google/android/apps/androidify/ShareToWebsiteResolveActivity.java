package com.google.android.apps.androidify;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.google.android.a;
import com.google.android.apps.a.i;
import java.io.IOException;

public class ShareToWebsiteResolveActivity extends Activity {
    private String a;
    private az b;
    private DrawView c;

    public static void a(Activity activity, az azVar) {
        try {
            Intent intent = new Intent(activity, ShareToWebsiteResolveActivity.class);
            intent.setFlags(1073741824);
            intent.putExtra("configString", azVar.c());
            activity.startActivity(intent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clickedClose(View view) {
        Androidify.a((Activity) this);
        dh.a((Context) this);
    }

    public void clickedShare(View view) {
        ShareActivity.a((Activity) this, this.b);
    }

    public void clickedVisitAndroidify(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("http://www.androidify.com/#/gallery"));
        startActivity(intent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.b = new az();
            this.a = getIntent().getStringExtra("configString");
            this.b.a((Context) this, this.a);
        } catch (Throwable e) {
            Throwable th = e;
            this.b = (az) Androidify.a((Activity) this, false).get(0);
            a.a(th);
        }
        setContentView(R.layout.activity_sharetowebsiteresolve);
        TextView textView = (TextView) findViewById(R.id.tv_share_headline);
        if (this.b.E() == null || this.b.E().length() <= 0) {
            textView.setText(getString(R.string.welcome_to_party) + "!");
        } else {
            textView.setText(getString(R.string.welcome_to_party) + ", " + this.b.E().toLowerCase() + "!");
        }
        this.c = (DrawView) findViewById(R.id.dv_resolve_droid);
        ah a = ah.a((Context) this);
        ba baVar = new ba(this);
        baVar.a(this.b, a);
        baVar.b(0.75f);
        baVar.a(0);
        this.c.setMotion(com.google.android.apps.androidify.a.a.a((Context) this, (int) R.raw.anim_happy));
        this.c.setDroidDrawer(baVar);
        this.c.a();
        this.c.invalidate();
        try {
            i.a().a("shareToWebsiteResolve");
        } catch (RuntimeException e2) {
            e2.printStackTrace();
        }
    }
}
