package com.google.android.apps.androidify;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.google.android.a;
import java.io.File;

class cp implements Runnable {
    View a;
    int b;
    final /* synthetic */ cn c;

    private cp(cn cnVar, int i, View view) {
        this.c = cnVar;
        this.b = i;
        this.a = view;
    }

    private void a(ImageView imageView, az azVar, File file, String str) {
        DroidView droidView = new DroidView(this.c.a, this.c.g, this.c.h, this.c.j, this.c.k, this.c.l, this.c.i);
        droidView.setPaintShadow(false);
        int i = this.c.c * 3;
        int i2 = this.c.d * 3;
        droidView.setLayoutParams(new LayoutParams(i, i2));
        droidView.setId(17777);
        droidView.layout(0, 0, i, i2);
        this.c.a.a(droidView, azVar);
        Bitmap a = a.a(droidView.getBitmapOfDroid(), 16.0f);
        try {
            a.a(file, str, a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.c.f.post(new cr(this, imageView, a));
    }

    public void run() {
        ImageView imageView = (ImageView) this.a;
        az azVar = (az) this.c.b.get(this.b);
        File cacheDir = imageView.getContext().getCacheDir();
        String str = azVar.F() + "_portrait_" + ".png";
        File file = new File(cacheDir, str);
        a.c("Looking for cache droid image at " + file);
        if (file.exists()) {
            a.c("Cached droid image exists");
            this.c.f.post(new cq(this, file, imageView, azVar, cacheDir, str));
            return;
        }
        a(imageView, azVar, cacheDir, str);
    }
}
