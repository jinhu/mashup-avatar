package com.google.android.apps.androidify;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.google.android.C0176a;

/* renamed from: com.google.android.apps.androidify.l */
class C0229l implements OnItemLongClickListener {
    final /* synthetic */ Androidify f1655a;

    C0229l(Androidify androidify) {
        this.f1655a = androidify;
    }

    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        C0176a.m1106c("Long press pos: " + i + ", id: " + j);
        this.f1655a.f751G = i;
        return true;
    }
}
