package com.google.android.apps.androidify;

import android.view.View;
import android.view.View.OnClickListener;

class ct implements OnClickListener {
    final /* synthetic */ ShareActivity f1542a;

    ct(ShareActivity shareActivity) {
        this.f1542a = shareActivity;
    }

    public void onClick(View view) {
        if (this.f1542a.f915k != cw.EXPORTING) {
            Util.debug("Bar clicked");
            //this.f1542a.m1538a(this.f1542a.f909e, view);
        }
    }
}
