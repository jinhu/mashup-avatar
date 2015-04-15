package com.google.android.apps.androidify;

import android.content.Context;
import android.os.AsyncTask;

class di extends AsyncTask {
    final /* synthetic */ Context a;
    final /* synthetic */ dh b;

    di(dh dhVar, Context context) {
        this.b = dhVar;
        this.a = context;
    }

    protected Object doInBackground(Object[] objArr) {
        this.b.l = this.b.d.load(this.a, R.raw.ogg_rip1, 1);
        this.b.m = this.b.d.load(this.a, R.raw.ogg_short1, 1);
        this.b.k = this.b.i.load(this.a, R.raw.ogg_silence, 1);
        this.b.n = this.b.d.load(this.a, R.raw.ogg_drawer_open, 1);
        this.b.o = this.b.d.load(this.a, R.raw.ogg_drawer_close, 1);
        this.b.p = this.b.d.load(this.a, R.raw.ogg_menu_open, 1);
        this.b.q = this.b.d.load(this.a, R.raw.ogg_menu_close, 1);
        this.b.r = this.b.d.load(this.a, R.raw.ogg_back, 1);
        this.b.s = this.b.d.load(this.a, R.raw.ogg_new_android, 1);
        this.b.t = this.b.d.load(this.a, R.raw.ogg_my_androids, 1);
        this.b.u = this.b.d.load(this.a, R.raw.ogg_share, 1);
        for (dk dkVar : dk.values()) {
            c.a("Loading type " + dkVar.i);
            this.b.a(this.a, dkVar);
        }
        return null;
    }
}
