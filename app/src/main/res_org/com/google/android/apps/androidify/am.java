package com.google.android.apps.androidify;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class am implements OnGlobalLayoutListener {
    final /* synthetic */ AssetDatabase mAssetDatabase;
    final /* synthetic */ DrawView mDrawView;

    am(DrawView drawView, AssetDatabase aAssetDatabaseVar) {
        this.mDrawView = drawView;
        this.mAssetDatabase = aAssetDatabaseVar;
    }

    public void onGlobalLayout() {
        this.mDrawView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        if (this.mDrawView.mAndroidDrawer == null) {
            this.mDrawView.initStartTime();
            Util.debug("Set config...");
            if (this.mDrawView.f800b == null) {
                this.mDrawView.setDroidConfig(this.mAssetDatabase.m1656a());
            } else {
                this.mDrawView.setDroidConfig(this.mDrawView.f800b);
            }
        }
        this.mDrawView.mAndroidDrawer.m1835a(this.mDrawView.getWidth(), this.mDrawView.getHeight());
        this.mDrawView.initStartTime();
        Util.debug("Rescale...");
        this.mDrawView.mAndroidDrawer.rescale();
        this.mDrawView.initStartTime();
        Util.debug("Done.");
    }
}
