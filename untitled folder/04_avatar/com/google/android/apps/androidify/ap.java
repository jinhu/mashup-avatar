package com.google.android.apps.androidify;

import android.view.View;
import com.google.android.a;
import it.sephiroth.android.library.widget.u;
import it.sephiroth.android.library.widget.y;

class ap implements y {
    final /* synthetic */ an a;

    ap(an anVar) {
        this.a = anVar;
    }

    public void a(u uVar, View view, int i, long j) {
        if (this.a.a(i, true)) {
            int a = this.a.g.a(this.a.g.getWidth() - 1, this.a.g.getHeight() / 2);
            a.c("[SELECT] Last index on screen=" + a);
            if (a != -1) {
                int width = this.a.g.getWidth() - view.getRight();
                if (a == i || (a == i + 1 && width < view.getWidth() / 2)) {
                    this.a.g.d(1);
                }
            }
        }
    }
}
