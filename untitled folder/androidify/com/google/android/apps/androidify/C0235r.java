package com.google.android.apps.androidify;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

/* renamed from: com.google.android.apps.androidify.r */
class C0235r implements OnItemClickListener {
    final /* synthetic */ Androidify f1663a;

    C0235r(Androidify androidify) {
        this.f1663a = androidify;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        try {
            az azVar = (az) ((bc) adapterView.getAdapter()).getItem(i);
            this.f1663a.f757R.m1184a("loadDroid");
            this.f1663a.m1355e(azVar);
        } catch (Exception e) {
            Toast.makeText(this.f1663a.getApplicationContext(), this.f1663a.getString(R.string.error_load_droid_failed), 0).show();
        }
    }
}
