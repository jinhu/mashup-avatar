package com.google.android.apps.androidify;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

class bz implements OnClickListener {
    final /* synthetic */ MenuActivity f1477a;

    bz(MenuActivity menuActivity) {
        this.f1477a = menuActivity;
    }

    public void onClick(View view) {
        this.f1477a.m1500a(((TextView) view).getText());
    }
}
