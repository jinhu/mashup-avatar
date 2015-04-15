package com.google.android.apps.androidify;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class bm implements OnClickListener {
    final /* synthetic */ GalleryActivity a;

    bm(GalleryActivity galleryActivity) {
        this.a = galleryActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        Androidify.a(this.a, this.a.b);
        this.a.e.a(Androidify.a(this.a, true));
        this.a.f.setAdapter(this.a.e);
    }
}
