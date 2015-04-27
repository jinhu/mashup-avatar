package com.google.android.apps.androidify;

import android.view.View;
import android.view.View.OnClickListener;

class bq implements OnClickListener {
    final /* synthetic */ int f1448a;
    final /* synthetic */ int f1449b;
    final /* synthetic */ int f1450c;
    final /* synthetic */ bo f1451d;

    bq(bo boVar, int i, int i2, int i3) {
        this.f1451d = boVar;
        this.f1448a = i;
        this.f1449b = i2;
        this.f1450c = i3;
    }

    public void onClick(View view) {
        if (this.f1448a == this.f1451d.f1440e) {
            C0220c.m1912a("Selecting already selected droid.");
            if (this.f1451d.f1439d != null) {
                this.f1451d.f1439d.m1484b(this.f1449b, this.f1450c, this.f1451d.m1887b(this.f1449b, this.f1450c));
                return;
            }
            return;
        }
        if (this.f1451d.f1440e > -1 && this.f1451d.f1441f != null) {
            this.f1451d.f1441f.setBackgroundColor(this.f1451d.f1436a);
            C0220c.m1912a("galdebug resetting last selected at " + this.f1451d.f1441f);
        }
        this.f1451d.f1440e = this.f1448a;
        this.f1451d.f1441f = view;
        C0220c.m1912a("galdebug last selected now " + this.f1451d.f1441f);
        view.setBackgroundResource(R.drawable.btn_bg_selected_gallery);
        view.invalidate();
        if (this.f1451d.f1439d != null) {
            this.f1451d.f1439d.m1482a(this.f1449b, this.f1450c, this.f1451d.m1887b(this.f1449b, this.f1450c));
        }
    }
}
