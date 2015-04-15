package it.sephiroth.android.library.widget;

import android.view.View;

class e extends t implements Runnable {
    final /* synthetic */ AbsHListView a;

    private e(AbsHListView absHListView) {
        this.a = absHListView;
        super(null);
    }

    public void run() {
        View childAt = this.a.getChildAt(this.a.A - this.a.V);
        if (childAt != null) {
            boolean c = (!b() || this.a.ai) ? false : this.a.c(childAt, this.a.A, this.a.j.getItemId(this.a.A));
            if (c) {
                this.a.F = -1;
                this.a.setPressed(false);
                childAt.setPressed(false);
                return;
            }
            this.a.F = 2;
        }
    }
}
