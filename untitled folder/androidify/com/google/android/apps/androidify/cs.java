package com.google.android.apps.androidify;

import android.view.View;
import com.google.android.C0176a;
import it.sephiroth.android.library.widget.C0217y;
import it.sephiroth.android.library.widget.C0273u;

class cs implements C0217y {
    final /* synthetic */ ShareActivity f1541a;

    cs(ShareActivity shareActivity) {
        this.f1541a = shareActivity;
    }

    public void m1939a(C0273u c0273u, View view, int i, long j) {
        this.f1541a.m1555a((DrawView) view, i);
        int a = this.f1541a.f917m.m2191a(this.f1541a.f917m.getWidth() - 1, this.f1541a.f917m.getHeight() / 2);
        C0176a.m1106c("[SELECT] Last index on screen=" + a);
        if (a != -1) {
            int width = this.f1541a.f917m.getWidth() - view.getRight();
            if (a == i || (a == i + 1 && width < view.getWidth() / 2)) {
                this.f1541a.f917m.m2293d(1);
            }
        }
    }
}
