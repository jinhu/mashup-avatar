package com.google.android.apps.androidify;

import android.view.View;
import it.sephiroth.android.library.widget.u;
import it.sephiroth.android.library.widget.y;

class ao implements y {
    final /* synthetic */ Androidify a;
    final /* synthetic */ an b;

    ao(an anVar, Androidify androidify) {
        this.b = anVar;
        this.a = androidify;
    }

    public void a(u uVar, View view, int i, long j) {
        this.a.f();
        this.b.a(av.values()[i]);
        if (av.values()[i] == av.NBA) {
            this.a.s();
        } else {
            this.a.a(av.values()[i].o);
        }
    }
}
