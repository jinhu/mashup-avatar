package com.google.android.apps.androidify;

import android.app.Activity;
import android.os.Parcelable;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ae;
import android.view.View;

public class cz extends ae {
    Activity a;
    View[] b;
    final /* synthetic */ ShareToWebsiteActivity c;

    public cz(ShareToWebsiteActivity shareToWebsiteActivity, Activity activity, ViewPager viewPager) {
        this.c = shareToWebsiteActivity;
        this.b = new View[viewPager.getChildCount()];
        for (int i = 0; i < viewPager.getChildCount(); i++) {
            this.b[i] = viewPager.getChildAt(i);
        }
        this.a = activity;
    }

    public int a() {
        return this.b.length;
    }

    public Object a(View view, int i) {
        View view2 = this.b[i];
        if (view2.getParent() == null) {
            ((ViewPager) view).addView(view2, 0);
        }
        return view2;
    }

    public void a(View view, int i, Object obj) {
        ((ViewPager) view).removeView((View) obj);
    }

    public boolean a(View view, Object obj) {
        return view == ((View) obj);
    }

    public Parcelable b() {
        return null;
    }
}
