package com.google.android.apps.androidify;

import android.view.View;
import android.view.View.OnClickListener;

class y implements OnClickListener {
    final /* synthetic */ Androidify a;

    y(Androidify androidify) {
        this.a = androidify;
    }

    public void onClick(View view) {
        this.a.o();
        this.a.a(this.a.getString(R.string.menu_share));
        this.a.l.c(4);
    }
}
