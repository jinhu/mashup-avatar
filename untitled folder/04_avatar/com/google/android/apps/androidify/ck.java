package com.google.android.apps.androidify;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class ck implements OnGlobalLayoutListener {
    final /* synthetic */ QRCodeActivity a;

    ck(QRCodeActivity qRCodeActivity) {
        this.a = qRCodeActivity;
    }

    public void onGlobalLayout() {
        this.a.a();
    }
}
