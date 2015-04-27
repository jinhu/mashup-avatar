package com.google.android.apps.androidify;

import android.view.View;
import com.google.android.C0176a;
import it.sephiroth.android.library.widget.C0217y;
import it.sephiroth.android.library.widget.C0273u;

class ap implements C0217y {
    final /* synthetic */ an f1237a;

    ap(an anVar) {
        this.f1237a = anVar;
    }

    public void m1739a(C0273u c0273u, View view, int i, long j) {
        if (this.f1237a.m1733a(i, true)) {
            int a = this.f1237a.f1224g.m2191a(this.f1237a.f1224g.getWidth() - 1, this.f1237a.f1224g.getHeight() / 2);
            C0176a.m1106c("[SELECT] Last index on screen=" + a);
            if (a != -1) {
                int width = this.f1237a.f1224g.getWidth() - view.getRight();
                if (a == i || (a == i + 1 && width < view.getWidth() / 2)) {
                    this.f1237a.f1224g.m2293d(1);
                }
            }
        }
    }
}
