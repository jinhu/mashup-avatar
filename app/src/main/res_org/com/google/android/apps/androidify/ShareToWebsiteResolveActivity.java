package com.google.android.apps.androidify;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.google.android.Util;
import com.google.android.apps.androidify.p018a.JsonUtil;
import com.google.android.apps.analytics.GoogleAnalyticsTracker;
import java.io.IOException;

public class ShareToWebsiteResolveActivity extends Activity {
    private String f934a;
    private AndroidConfig f935b;
    private DrawView f936c;

    public static void m1565a(Activity activity, AndroidConfig aAndroidConfigVar) {
        try {
            Intent intent = new Intent(activity, ShareToWebsiteResolveActivity.class);
            intent.setFlags(1073741824);
            intent.putExtra("configString", aAndroidConfigVar.m1787c());
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
            this.f935b = new AndroidConfig();
            this.f934a = getIntent().getStringExtra("configString");
            this.f935b.getInstance((Context) this, this.f934a);
        } catch (Throwable e) {
            Throwable th = e;
            this.f935b = (AndroidConfig) Androidify.getSaveList((Activity) this, false).get(0);
            Util.m1103a(th);
        }
        setContentView(R.layout.activity_sharetowebsiteresolve);
        TextView textView = (TextView) findViewById(R.id.tv_share_headline);
        if (this.f935b.m1769E() == null || this.f935b.m1769E().length() <= 0) {
            textView.setText(getString(R.string.welcome_to_party) + "!");
        } else {
            textView.setText(getString(R.string.welcome_to_party) + ", " + this.f935b.m1769E().toLowerCase() + "!");
        }
        this.f936c = (DrawView) findViewById(R.id.dv_resolve_droid);
        AssetDatabase a = AssetDatabase.instance((Context) this);
        AndroidDrawer androidDrawerVar = new AndroidDrawer(this);
        androidDrawerVar.setAndroidConfig(this.f935b, a);
        androidDrawerVar.m1848b(0.75f);
        androidDrawerVar.m1834a(0);
        this.f936c.setMotion(JsonUtil.getAnimationCatalogue((Context) this, (int) R.raw.anim_happy));
        this.f936c.setDroidDrawer(androidDrawerVar);
        this.f936c.m1426a();
        this.f936c.invalidate();
        try {
            GoogleAnalyticsTracker.m1177a().m1184a("shareToWebsiteResolve");
        } catch (RuntimeException e2) {
            e2.printStackTrace();
        }
    }
}
