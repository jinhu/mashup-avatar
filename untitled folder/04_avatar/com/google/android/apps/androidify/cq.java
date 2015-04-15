package com.google.android.apps.androidify;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.a;
import java.io.File;
import java.io.FileNotFoundException;

class cq implements Runnable {
    final /* synthetic */ File a;
    final /* synthetic */ ImageView b;
    final /* synthetic */ az c;
    final /* synthetic */ File d;
    final /* synthetic */ String e;
    final /* synthetic */ cp f;

    cq(cp cpVar, File file, ImageView imageView, az azVar, File file2, String str) {
        this.f = cpVar;
        this.a = file;
        this.b = imageView;
        this.c = azVar;
        this.d = file2;
        this.e = str;
    }

    public void run() {
        a.c("Loading cached droid image");
        try {
            this.b.setImageDrawable(Drawable.createFromStream(this.f.a.getContext().getContentResolver().openInputStream(Uri.fromFile(this.a)), null));
        } catch (FileNotFoundException e) {
            a.c("Error loading saved droid cache image, regenerating.");
            e.printStackTrace();
            this.f.a(this.b, this.c, this.d, this.e);
        }
        this.b.invalidate();
    }
}
