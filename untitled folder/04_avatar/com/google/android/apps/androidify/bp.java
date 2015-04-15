package com.google.android.apps.androidify;

import android.view.View;
import android.view.View.OnClickListener;

class bp implements OnClickListener {
    final /* synthetic */ bo a;

    bp(bo boVar) {
        this.a = boVar;
    }

    public void onClick(View view) {
        if (this.a.d != null) {
            this.a.d.a();
        }
    }
}
