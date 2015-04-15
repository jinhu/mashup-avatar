package com.google.android.apps.androidify;

import android.graphics.Bitmap;
import android.widget.ImageView;

class cr implements Runnable {
    final /* synthetic */ ImageView a;
    final /* synthetic */ Bitmap b;
    final /* synthetic */ cp c;

    cr(cp cpVar, ImageView imageView, Bitmap bitmap) {
        this.c = cpVar;
        this.a = imageView;
        this.b = bitmap;
    }

    public void run() {
        this.a.setImageBitmap(this.b);
        this.a.invalidate();
    }
}
