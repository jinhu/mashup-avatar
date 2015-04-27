package com.google.android.apps.androidify;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

/* renamed from: com.google.android.apps.androidify.p */
class C0233p implements OnItemClickListener {
    final /* synthetic */ Androidify f1661a;

    C0233p(Androidify androidify) {
        this.f1661a = androidify;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        try {
            this.f1661a.m1355e((az) ((cn) adapterView.getAdapter()).getItem(i));
        } catch (Exception e) {
            Toast.makeText(this.f1661a.getApplicationContext(), this.f1661a.getString(R.string.error_load_droid_failed), 0).show();
        }
    }
}
