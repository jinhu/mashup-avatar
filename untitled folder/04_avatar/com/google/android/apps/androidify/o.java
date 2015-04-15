package com.google.android.apps.androidify;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;

class o implements OnItemLongClickListener {
    final /* synthetic */ Androidify a;

    o(Androidify androidify) {
        this.a = androidify;
    }

    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        Androidify.s = (az) ((cn) adapterView.getAdapter()).getItem(i);
        Androidify.t = i;
        return true;
    }
}
