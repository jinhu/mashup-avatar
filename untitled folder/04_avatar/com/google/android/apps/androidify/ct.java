package com.google.android.apps.androidify;

import android.view.View;
import android.view.View.OnClickListener;

class ct implements OnClickListener {
    final /* synthetic */ ShareActivity a;

    ct(ShareActivity shareActivity) {
        this.a = shareActivity;
    }

    public void onClick(View view) {
        if (this.a.k != cw.EXPORTING) {
            c.a("Bar clicked");
            this.a.a(this.a.e, view);
        }
    }
}
