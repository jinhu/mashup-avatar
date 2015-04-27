package com.google.android.apps.androidify;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.C0176a;
import com.google.android.apps.androidify.p018a.C0204a;
import com.google.android.apps.p016a.C0185i;
import java.io.IOException;

public class ShareToWebsiteActivity extends Activity {
    private String f927a;
    private TextView f928b;
    private ViewPager f929c;
    private LinearLayout f930d;
    private boolean f931e;
    private cy f932f;
    private az f933g;

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
        ah a = ah.m1648a((Context) this);
        DrawView drawView = (DrawView) findViewById(i);
        ba baVar = new ba(this);
        baVar.m1844a(this.f933g, a);
        baVar.m1848b(0.75f);
        baVar.m1834a(0);
        drawView.setMotion(C0204a.m1596a((Context) this, i2));
        drawView.setDroidDrawer(baVar);
        drawView.m1426a();
        drawView.invalidate();
    }

    public static void m1562a(Activity activity, az azVar) {
        activity.startActivity(m1564b(activity, azVar));
    }

    public static Intent m1564b(Activity activity, az azVar) {
        Intent intent = new Intent(activity, ShareToWebsiteActivity.class);
        try {
            intent.putExtra("configString", azVar.m1787c());
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
            this.f933g = new az();
            this.f927a = getIntent().getStringExtra("configString");
            this.f933g.m1776a((Context) this, this.f927a);
        } catch (Throwable e) {
            this.f933g = az.m1762a();
            C0176a.m1103a(e);
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
            C0185i.m1177a().m1184a("shareToWebsiteStart");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
