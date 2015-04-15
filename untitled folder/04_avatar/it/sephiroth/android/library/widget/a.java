package it.sephiroth.android.library.widget;

import android.view.View;

class a implements Runnable {
    final /* synthetic */ View a;
    final /* synthetic */ l b;
    final /* synthetic */ AbsHListView c;

    a(AbsHListView absHListView, View view, l lVar) {
        this.c = absHListView;
        this.a = view;
        this.b = lVar;
    }

    public void run() {
        this.c.F = -1;
        this.a.setPressed(false);
        this.c.setPressed(false);
        if (!this.c.ai) {
            this.b.run();
        }
    }
}
