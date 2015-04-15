package it.sephiroth.android.library.widget;

import android.view.View;

class d extends t implements Runnable {
    final /* synthetic */ AbsHListView a;

    private d(AbsHListView absHListView) {
        this.a = absHListView;
        super(null);
    }

    public void run() {
        if (this.a.isPressed() && this.a.al >= 0) {
            View childAt = this.a.getChildAt(this.a.al - this.a.V);
            if (this.a.ai) {
                this.a.setPressed(false);
                if (childAt != null) {
                    childAt.setPressed(false);
                    return;
                }
                return;
            }
            if (b() ? this.a.c(childAt, this.a.al, this.a.am) : false) {
                this.a.setPressed(false);
                childAt.setPressed(false);
            }
        }
    }
}
