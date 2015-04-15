package com.google.android.apps.androidify;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.apps.a.i;
import com.google.android.apps.androidify.a.a;
import java.io.IOException;

public class ShareToWebsiteActivity extends Activity {
    private String a;
    private TextView b;
    private ViewPager c;
    private LinearLayout d;
    private boolean e;
    private cy f;
    private az g;

    public ShareToWebsiteActivity() {
        this.f = cy.ACCEPTING_TERMS;
    }

    private void a() {
        for (int i = 0; i < this.d.getChildCount(); i++) {
            if (this.c.getCurrentItem() == i) {
                this.d.getChildAt(i).setBackgroundResource(R.drawable.pager_indicator_selected);
            } else {
                this.d.getChildAt(i).setBackgroundResource(R.drawable.pager_indicator_unselected);
            }
        }
    }

    private void a(int i, int i2) {
        ah a = ah.a((Context) this);
        DrawView drawView = (DrawView) findViewById(i);
        ba baVar = new ba(this);
        baVar.a(this.g, a);
        baVar.b(0.75f);
        baVar.a(0);
        drawView.setMotion(a.a((Context) this, i2));
        drawView.setDroidDrawer(baVar);
        drawView.a();
        drawView.invalidate();
    }

    public static void a(Activity activity, az azVar) {
        activity.startActivity(b(activity, azVar));
    }

    public static Intent b(Activity activity, az azVar) {
        Intent intent = new Intent(activity, ShareToWebsiteActivity.class);
        try {
            intent.putExtra("configString", azVar.c());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return intent;
    }

    public void clickedClose(View view) {
        finish();
        dh.a((Context) this);
    }

    public void clickedShare(View view) {
        ShareToWebsiteSubmitFormActivity.a(this, this.g, this.e);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.g = new az();
            this.a = getIntent().getStringExtra("configString");
            this.g.a((Context) this, this.a);
        } catch (Throwable e) {
            this.g = az.a();
            com.google.android.a.a(e);
        }
        setContentView(R.layout.activity_sharetowebsite);
        this.c = (ViewPager) findViewById(R.id.vp_sharepager);
        this.c.setAdapter(new cz(this, this, this.c));
        this.c.setOffscreenPageLimit(10);
        this.c.setCurrentItem(0);
        this.c.setOnPageChangeListener(new cx(this));
        this.d = (LinearLayout) findViewById(R.id.pager_indicator);
        a((int) R.id.dv_page1_droid, (int) R.raw.anim_cheering);
        a((int) R.id.dv_page3_droid, (int) R.raw.anim_happy);
        this.b = (TextView) findViewById(R.id.tv_share_to_website);
        this.e = getIntent().hasExtra("qrMode");
        if (this.e) {
            this.b.setText(R.string.submit_for_qr_code);
        }
        try {
            i.a().a("shareToWebsiteStart");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
