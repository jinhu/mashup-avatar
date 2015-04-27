package it.sephiroth.android.library.widget;

import android.view.View;
import android.widget.ListAdapter;

/* renamed from: it.sephiroth.android.library.widget.l */
class C0287l extends C0278t implements Runnable {
    int f1981a;
    final /* synthetic */ AbsHListView f1982b;

    private C0287l(AbsHListView absHListView) {
        this.f1982b = absHListView;
        super(null);
    }

    public void run() {
        if (!this.f1982b.ai) {
            ListAdapter listAdapter = this.f1982b.f1878j;
            int i = this.f1981a;
            if (listAdapter != null && this.f1982b.an > 0 && i != -1 && i < listAdapter.getCount() && m2385b()) {
                View childAt = this.f1982b.getChildAt(i - this.f1982b.V);
                if (childAt != null) {
                    this.f1982b.m2202a(childAt, i, listAdapter.getItemId(i));
                }
            }
        }
    }
}
