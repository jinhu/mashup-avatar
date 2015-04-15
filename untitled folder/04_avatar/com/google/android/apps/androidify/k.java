package com.google.android.apps.androidify;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

class k implements OnItemSelectedListener {
    final /* synthetic */ Androidify a;

    k(Androidify androidify) {
        this.a = androidify;
    }

    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        this.a.E.b(i);
    }

    public void onNothingSelected(AdapterView adapterView) {
    }
}
