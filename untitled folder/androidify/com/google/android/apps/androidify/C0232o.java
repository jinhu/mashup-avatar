package com.google.android.apps.androidify;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;

/* renamed from: com.google.android.apps.androidify.o */
class C0232o implements OnItemLongClickListener {
    final /* synthetic */ Androidify f1660a;

    C0232o(Androidify androidify) {
        this.f1660a = androidify;
    }

    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        Androidify.f745s = (az) ((cn) adapterView.getAdapter()).getItem(i);
        Androidify.f746t = i;
        return true;
    }
}
