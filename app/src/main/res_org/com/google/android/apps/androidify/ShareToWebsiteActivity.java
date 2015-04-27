package com.google.android.apps.androidify;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.Util;
import com.google.android.apps.androidify.p018a.JsonUtil;
import com.google.android.apps.analytics.GoogleAnalyticsTracker;
import java.io.IOException;

public class ShareToWebsiteActivity extends Activity {
    private String f927a;
    private TextView f928b;
    private ViewPager f929c;
    private LinearLayout f930d;
    private boolean f931e;
    private cy f932f;
    private AndroidConfig f933g;

    public ShareToWebsiteActivity() {
        this.f932f = cy.ACCEPTING_TERMS;
    }

    private void m1560a() {
        for (int i = 0; i < this.f930d.getChildCount(); i++) {
            if (this.f929c.getCurrentItem() == i) {
                this.f930d.getChildAt(i).setBackgroundResource(R.drawable.pager_indicator_selected);
            } else {
                this.f930d.getChildAt(i).setBackgroundResource(R.drawable.pager_indicator_unselected);
            }
        }
    }

    private void m1561a(int i, int i2) {
        AssetDatabase a = AssetDatabase.instance((Context) this);
        DrawView drawView = (DrawView) findViewById(i);
        AndroidDrawer androidDrawerVar = new AndroidDrawer(this);
        androidDrawerVar.setAndroidConfig(this.f933g, a);
        androidDrawerVar.m1848b(0.75f);
        androidDrawerVar.m1834a(0);
        drawView.setMotion(JsonUtil.getAnimationCatalogue((Context) this, i2));
        drawView.setDroidDrawer(androidDrawerVar);
        drawView.m1426a();
        drawView.invalidate();
    }

    public static void m1562a(Activity activity, AndroidConfig aAndroidConfigVar) {
        activity.startActivity(m1564b(activity, aAndroidConfigVar));
    }

    public static Intent m1564b(Activity activity, AndroidConfig aAndroidConfigVar) {
        Intent intent = new Intent(activity, ShareToWebsiteActivity.class);
        try {
            intent.putExtra("configString", aAndroidConfigVar.m1787c());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return intent;
    }

    public void clickedClose(View view) {
        finish();
        dh.m1956a((Context) this);
    }

    public void clickedShare(View view) {
        ShareToWebsiteSubmitFormActivity.m1569a(this, this.f933g, this.f931e);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.f933g = new AndroidConfig();
            this.f927a = getIntent().getStringExtra("configString");
            this.f933g.getInstance((Context) this, this.f927a);
        } catch (Throwable e) {
            this.f933g = AndroidConfig.m1762a();
            Util.m1103a(e);
        }
        setContentView(R.layout.activity_sharetowebsite);
        this.f929c = (ViewPager) findViewById(R.id.vp_sharepager);
        this.f929c.setAdapter(new cz(this, this, this.f929c));
        this.f929c.setOffscreenPageLimit(10);
        this.f929c.setCurrentItem(0);
        this.f929c.setOnPageChangeListener(new cx(this));
        this.f930d = (LinearLayout) findViewById(R.id.pager_indicator);
        m1561a((int) R.id.dv_page1_droid, (int) R.raw.anim_cheering);
        m1561a((int) R.id.dv_page3_droid, (int) R.raw.anim_happy);
        this.f928b = (TextView) findViewById(R.id.tv_share_to_website);
        this.f931e = getIntent().hasExtra("qrMode");
        if (this.f931e) {
            this.f928b.setText(R.string.submit_for_qr_code);
        }
        try {
            GoogleAnalyticsTracker.m1177a().m1184a("shareToWebsiteStart");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
