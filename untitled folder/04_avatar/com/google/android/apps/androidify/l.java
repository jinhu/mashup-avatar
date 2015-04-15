package com.google.android.apps.androidify;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.google.android.a;

class l implements OnItemLongClickListener {
    final /* synthetic */ Androidify a;

    l(Androidify androidify) {
        this.a = androidify;
    }

    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        a.c("Long press pos: " + i + ", id: " + j);
        this.a.G = i;
        return true;
    }
}
