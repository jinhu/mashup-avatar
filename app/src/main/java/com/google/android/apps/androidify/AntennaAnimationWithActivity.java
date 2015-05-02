package com.google.android.apps.androidify;

import android.app.Activity;
import android.os.Parcelable;
import android.support.v4.view.ViewPager;
import android.view.View;

public class AntennaAnimationWithActivity extends AntennaAnimation {
    Activity f1555a;
    View[] f1556b;
    final /* synthetic */ ShareToWebsiteActivity f1557c;

    public AntennaAnimationWithActivity(ShareToWebsiteActivity shareToWebsiteActivity, Activity activity, ViewPager viewPager) {
        this.f1557c = shareToWebsiteActivity;
        this.f1556b = new View[viewPager.getChildCount()];
        for (int i = 0; i < viewPager.getChildCount(); i++) {
            this.f1556b[i] = viewPager.getChildAt(i);
        }
        this.f1555a = activity;
    }

    public int m1946a() {
        return this.f1556b.length;
    }

    public Object m1947a(View view, int i) {
        View view2 = this.f1556b[i];
        if (view2.getParent() == null) {
            ((ViewPager) view).addView(view2, 0);
        }
        return view2;
    }

    public void m1948a(View view, int i, Object obj) {
        ((ViewPager) view).removeView((View) obj);
    }

    public boolean m1949a(View view, Object obj) {
        return view == obj;
    }

    public Parcelable m1950b() {
        return null;
    }
}
