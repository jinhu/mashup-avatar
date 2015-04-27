package com.google.android.apps.androidify;

import android.view.View;
import android.view.View.OnClickListener;

class bp implements OnClickListener {
    final /* synthetic */ AndroidBaseAdapter f1447a;

    bp(AndroidBaseAdapter aAndroidBaseAdapterVar) {
        this.f1447a = aAndroidBaseAdapterVar;
    }

    public void onClick(View view) {
        if (this.f1447a.f1439d != null) {
            this.f1447a.f1439d.shareOnce();
        }
    }
}
