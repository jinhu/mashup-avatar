package com.google.android.apps.androidify;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.google.android.C0176a;
import com.google.android.apps.androidify.p018a.C0204a;
import com.google.android.apps.p016a.C0185i;
import java.io.IOException;

public class ShareToWebsiteResolveActivity extends Activity {
    private String f934a;
    private az f935b;
    private DrawView f936c;

    public static void m1565a(Activity activity, az azVar) {
        try {
            Intent intent = new Intent(activity, ShareToWebsiteResolveActivity.class);
            intent.setFlags(1073741824);
            intent.putExtra("configString", azVar.m1787c());
            activity.startActivity(intent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clickedClose(View view) {
        Androidify.m1337a((Activity) this);
        dh.m1956a((Context) this);
    }

    public void clickedShare(View view) {
        ShareActivity.m1535a((Activity) this, this.f935b);
    }

    public void clickedVisitAndroidify(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("http://www.androidify.com/#/gallery"));
        startActivity(intent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.f935b = new az();
            this.f934a = getIntent().getStringExtra("configString");
            this.f935b.m1776a((Context) this, this.f934a);
        } catch (Throwable e) {
            Throwable th = e;
            this.f935b = (az) Androidify.m1335a((Activity) this, false).get(0);
            C0176a.m1103a(th);
        }
        setContentView(R.layout.activity_sharetowebsiteresolve);
        TextView textView = (TextView) findViewById(R.id.tv_share_headline);
        if (this.f935b.m1769E() == null || this.f935b.m1769E().length() <= 0) {
            textView.setText(getString(R.string.welcome_to_party) + "!");
        } else {
            textView.setText(getString(R.string.welcome_to_party) + ", " + this.f935b.m1769E().toLowerCase() + "!");
        }
        this.f936c = (DrawView) findViewById(R.id.dv_resolve_droid);
        ah a = ah.m1648a((Context) this);
        ba baVar = new ba(this);
        baVar.m1844a(this.f935b, a);
        baVar.m1848b(0.75f);
        baVar.m1834a(0);
        this.f936c.setMotion(C0204a.m1596a((Context) this, (int) R.raw.anim_happy));
        this.f936c.setDroidDrawer(baVar);
        this.f936c.m1426a();
        this.f936c.invalidate();
        try {
            C0185i.m1177a().m1184a("shareToWebsiteResolve");
        } catch (RuntimeException e2) {
            e2.printStackTrace();
        }
    }
}
