package com.google.android.apps.androidify;

import android.view.View;
import com.google.android.a;
import it.sephiroth.android.library.widget.u;
import it.sephiroth.android.library.widget.y;

class cs implements y {
    final /* synthetic */ ShareActivity a;

    cs(ShareActivity shareActivity) {
        this.a = shareActivity;
    }

    public void a(u uVar, View view, int i, long j) {
        this.a.a((DrawView) view, i);
        int a = this.a.m.a(this.a.m.getWidth() - 1, this.a.m.getHeight() / 2);
        a.c("[SELECT] Last index on screen=" + a);
        if (a != -1) {
            int width = this.a.m.getWidth() - view.getRight();
            if (a == i || (a == i + 1 && width < view.getWidth() / 2)) {
                this.a.m.d(1);
            }
        }
    }
}
