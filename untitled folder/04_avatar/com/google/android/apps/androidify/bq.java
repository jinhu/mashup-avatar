package com.google.android.apps.androidify;

import android.view.View;
import android.view.View.OnClickListener;

class bq implements OnClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ bo d;

    bq(bo boVar, int i, int i2, int i3) {
        this.d = boVar;
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    public void onClick(View view) {
        if (this.a == this.d.e) {
            c.a("Selecting already selected droid.");
            if (this.d.d != null) {
                this.d.d.b(this.b, this.c, this.d.b(this.b, this.c));
                return;
            }
            return;
        }
        if (this.d.e > -1 && this.d.f != null) {
            this.d.f.setBackgroundColor(this.d.a);
            c.a("galdebug resetting last selected at " + this.d.f);
        }
        this.d.e = this.a;
        this.d.f = view;
        c.a("galdebug last selected now " + this.d.f);
        view.setBackgroundResource(R.drawable.btn_bg_selected_gallery);
        view.invalidate();
        if (this.d.d != null) {
            this.d.d.a(this.b, this.c, this.d.b(this.b, this.c));
        }
    }
}
