package com.google.android.apps.androidify;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

class bz implements OnClickListener {
    final /* synthetic */ MenuActivity a;

    bz(MenuActivity menuActivity) {
        this.a = menuActivity;
    }

    public void onClick(View view) {
        this.a.a(((TextView) view).getText());
    }
}
