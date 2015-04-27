package com.google.android.apps.androidify;

import android.view.View;
import com.google.android.Util;

import it.sephiroth.android.library.widget.AdapterView;

class MainViewOnClickListener implements  AdapterView.OnItemClickListener {
    final /* synthetic */ ManiView mManiView;

    MainViewOnClickListener(ManiView aManiViewVar) {
        this.mManiView = aManiViewVar;
    }


    @Override
    public void onItemClick(AdapterView<?> aAdapterView, View aView, int i, long l) {
        if (this.mManiView.m1733a(i, true)) {
            int a = this.mManiView.mAndroidDrawer.m2191a(this.mManiView.mAndroidDrawer.getWidth() - 1, this.mManiView.mAndroidDrawer.getHeight() / 2);
            Util.debug("[SELECT] Last index on screen=" + a);
            if (a != -1) {
                int width = (int) (this.mManiView.mAndroidDrawer.getWidth() - aView.getRight());
                if (a == i || (a == i + 1 && width < aView.getWidth() / 2)) {
                    this.mManiView.mAndroidDrawer.m2293d(1);
                }
            }
        }

    }
}
