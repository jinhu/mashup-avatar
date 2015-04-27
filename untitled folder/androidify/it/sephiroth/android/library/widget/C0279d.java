package it.sephiroth.android.library.widget;

import android.view.View;

/* renamed from: it.sephiroth.android.library.widget.d */
class C0279d extends C0278t implements Runnable {
    final /* synthetic */ AbsHListView f1967a;

    private C0279d(AbsHListView absHListView) {
        this.f1967a = absHListView;
        super(null);
    }

    public void run() {
        if (this.f1967a.isPressed() && this.f1967a.al >= 0) {
            View childAt = this.f1967a.getChildAt(this.f1967a.al - this.f1967a.V);
            if (this.f1967a.ai) {
                this.f1967a.setPressed(false);
                if (childAt != null) {
                    childAt.setPressed(false);
                    return;
                }
                return;
            }
            if (m2385b() ? this.f1967a.m2210c(childAt, this.f1967a.al, this.f1967a.am) : false) {
                this.f1967a.setPressed(false);
                childAt.setPressed(false);
            }
        }
    }
}
