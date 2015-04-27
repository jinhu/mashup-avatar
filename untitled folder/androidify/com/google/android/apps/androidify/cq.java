package com.google.android.apps.androidify;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.C0176a;
import java.io.File;
import java.io.FileNotFoundException;

class cq implements Runnable {
    final /* synthetic */ File f1532a;
    final /* synthetic */ ImageView f1533b;
    final /* synthetic */ az f1534c;
    final /* synthetic */ File f1535d;
    final /* synthetic */ String f1536e;
    final /* synthetic */ cp f1537f;

    cq(cp cpVar, File file, ImageView imageView, az azVar, File file2, String str) {
        this.f1537f = cpVar;
        this.f1532a = file;
        this.f1533b = imageView;
        this.f1534c = azVar;
        this.f1535d = file2;
        this.f1536e = str;
    }

    public void run() {
        C0176a.m1106c("Loading cached droid image");
        try {
            this.f1533b.setImageDrawable(Drawable.createFromStream(this.f1537f.f1529a.getContext().getContentResolver().openInputStream(Uri.fromFile(this.f1532a)), null));
        } catch (FileNotFoundException e) {
            C0176a.m1106c("Error loading saved droid cache image, regenerating.");
            e.printStackTrace();
            this.f1537f.m1937a(this.f1533b, this.f1534c, this.f1535d, this.f1536e);
        }
        this.f1533b.invalidate();
    }
}
