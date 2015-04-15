package com.google.android.apps.androidify;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

class p implements OnItemClickListener {
    final /* synthetic */ Androidify a;

    p(Androidify androidify) {
        this.a = androidify;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        try {
            this.a.e((az) ((cn) adapterView.getAdapter()).getItem(i));
        } catch (Exception e) {
            Toast.makeText(this.a.getApplicationContext(), this.a.getString(R.string.error_load_droid_failed), 0).show();
        }
    }
}
