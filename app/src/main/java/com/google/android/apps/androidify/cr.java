package com.google.android.apps.androidify;

import android.graphics.Bitmap;
import android.widget.ImageView;

class cr implements Runnable {
    final /* synthetic */ ImageView f1538a;
    final /* synthetic */ Bitmap f1539b;
    final /* synthetic */ cp f1540c;

    cr(cp cpVar, ImageView imageView, Bitmap bitmap) {
        this.f1540c = cpVar;
        this.f1538a = imageView;
        this.f1539b = bitmap;
    }

    public void run() {
        this.f1538a.setImageBitmap(this.f1539b);
        this.f1538a.invalidate();
    }
}
