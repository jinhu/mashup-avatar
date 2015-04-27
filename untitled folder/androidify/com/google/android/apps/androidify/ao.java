package com.google.android.apps.androidify;

import android.view.View;
import it.sephiroth.android.library.widget.C0217y;
import it.sephiroth.android.library.widget.C0273u;

class ao implements C0217y {
    final /* synthetic */ Androidify f1235a;
    final /* synthetic */ an f1236b;

    ao(an anVar, Androidify androidify) {
        this.f1236b = anVar;
        this.f1235a = androidify;
    }

    public void m1738a(C0273u c0273u, View view, int i, long j) {
        this.f1235a.m1392f();
        this.f1236b.m1732a(av.values()[i]);
        if (av.values()[i] == av.NBA) {
            this.f1235a.m1403s();
        } else {
            this.f1235a.m1377a(av.values()[i].f1263o);
        }
    }
}
