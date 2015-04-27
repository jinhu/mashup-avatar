package it.sephiroth.android.library.widget;

import android.view.View;

/* renamed from: it.sephiroth.android.library.widget.e */
class C0280e extends C0278t implements Runnable {
    final /* synthetic */ AbsHListView f1968a;

    private C0280e(AbsHListView absHListView) {
        this.f1968a = absHListView;
        super(null);
    }

    public void run() {
        View childAt = this.f1968a.getChildAt(this.f1968a.f1850A - this.f1968a.V);
        if (childAt != null) {
            boolean c = (!m2385b() || this.f1968a.ai) ? false : this.f1968a.m2210c(childAt, this.f1968a.f1850A, this.f1968a.f1878j.getItemId(this.f1968a.f1850A));
            if (c) {
                this.f1968a.f1855F = -1;
                this.f1968a.setPressed(false);
                childAt.setPressed(false);
                return;
            }
            this.f1968a.f1855F = 2;
        }
    }
}
