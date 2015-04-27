package it.sephiroth.android.library.widget;

import android.view.View;

/* renamed from: it.sephiroth.android.library.widget.a */
class C0274a implements Runnable {
    final /* synthetic */ View f1905a;
    final /* synthetic */ C0287l f1906b;
    final /* synthetic */ AbsHListView f1907c;

    C0274a(AbsHListView absHListView, View view, C0287l c0287l) {
        this.f1907c = absHListView;
        this.f1905a = view;
        this.f1906b = c0287l;
    }

    public void run() {
        this.f1907c.f1855F = -1;
        this.f1905a.setPressed(false);
        this.f1907c.setPressed(false);
        if (!this.f1907c.ai) {
            this.f1906b.run();
        }
    }
}
