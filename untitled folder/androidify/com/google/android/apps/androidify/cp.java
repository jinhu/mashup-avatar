package com.google.android.apps.androidify;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.google.android.C0176a;
import java.io.File;

class cp implements Runnable {
    View f1529a;
    int f1530b;
    final /* synthetic */ cn f1531c;

    private cp(cn cnVar, int i, View view) {
        this.f1531c = cnVar;
        this.f1530b = i;
        this.f1529a = view;
    }

    private void m1937a(ImageView imageView, az azVar, File file, String str) {
        DroidView droidView = new DroidView(this.f1531c.f1516a, this.f1531c.f1522g, this.f1531c.f1523h, this.f1531c.f1525j, this.f1531c.f1526k, this.f1531c.f1527l, this.f1531c.f1524i);
        droidView.setPaintShadow(false);
        int i = this.f1531c.f1518c * 3;
        int i2 = this.f1531c.f1519d * 3;
        droidView.setLayoutParams(new LayoutParams(i, i2));
        droidView.setId(17777);
        droidView.layout(0, 0, i, i2);
        this.f1531c.f1516a.m1373a(droidView, azVar);
        Bitmap a = C0176a.m1097a(droidView.getBitmapOfDroid(), 16.0f);
        try {
            C0176a.m1100a(file, str, a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f1531c.f1521f.post(new cr(this, imageView, a));
    }

    public void run() {
        ImageView imageView = (ImageView) this.f1529a;
        az azVar = (az) this.f1531c.f1517b.get(this.f1530b);
        File cacheDir = imageView.getContext().getCacheDir();
        String str = azVar.m1770F() + "_portrait_" + ".png";
        File file = new File(cacheDir, str);
        C0176a.m1106c("Looking for cache droid image at " + file);
        if (file.exists()) {
            C0176a.m1106c("Cached droid image exists");
            this.f1531c.f1521f.post(new cq(this, file, imageView, azVar, cacheDir, str));
            return;
        }
        m1937a(imageView, azVar, cacheDir, str);
    }
}
