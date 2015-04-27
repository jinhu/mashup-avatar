package com.google.android.apps.androidify;

import android.view.View;
import android.view.View.OnClickListener;

import dev.game.legend.avatar.R;

class bq implements OnClickListener {
    final /* synthetic */ int f1448a;
    final /* synthetic */ int f1449b;
    final /* synthetic */ int f1450c;
    final /* synthetic */ AndroidBaseAdapter f1451d;

    bq(AndroidBaseAdapter aAndroidBaseAdapterVar, int i, int i2, int i3) {
        this.f1451d = aAndroidBaseAdapterVar;
        this.f1448a = i;
        this.f1449b = i2;
        this.f1450c = i3;
    }

    public void onClick(View view) {
        if (this.f1448a == this.f1451d.f1440e) {
            Util.debug("Selecting already selected droid.");
            if (this.f1451d.f1439d != null) {
                this.f1451d.f1439d.shareAll(this.f1449b, this.f1450c, this.f1451d.m1887b(this.f1449b, this.f1450c));
                return;
            }
            return;
        }
        if (this.f1451d.f1440e > -1 && this.f1451d.f1441f != null) {
            this.f1451d.f1441f.setBackgroundColor(this.f1451d.f1436a);
            Util.debug("galdebug resetting last selected at " + this.f1451d.f1441f);
        }
        this.f1451d.f1440e = this.f1448a;
        this.f1451d.f1441f = view;
        Util.debug("galdebug last selected now " + this.f1451d.f1441f);
        view.setBackgroundResource(R.drawable.btn_bg_selected_gallery);
        view.invalidate();
        if (this.f1451d.f1439d != null) {
            this.f1451d.f1439d.shareOnce(this.f1449b, this.f1450c, this.f1451d.m1887b(this.f1449b, this.f1450c));
        }
    }
}
