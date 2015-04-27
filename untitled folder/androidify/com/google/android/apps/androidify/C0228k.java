package com.google.android.apps.androidify;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

/* renamed from: com.google.android.apps.androidify.k */
class C0228k implements OnItemSelectedListener {
    final /* synthetic */ Androidify f1654a;

    C0228k(Androidify androidify) {
        this.f1654a = androidify;
    }

    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        this.f1654a.f749E.m1870b(i);
    }

    public void onNothingSelected(AdapterView adapterView) {
    }
}
