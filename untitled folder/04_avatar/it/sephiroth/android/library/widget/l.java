package it.sephiroth.android.library.widget;

import android.view.View;
import android.widget.ListAdapter;

class l extends t implements Runnable {
    int a;
    final /* synthetic */ AbsHListView b;

    private l(AbsHListView absHListView) {
        this.b = absHListView;
        super(null);
    }

    public void run() {
        if (!this.b.ai) {
            ListAdapter listAdapter = this.b.j;
            int i = this.a;
            if (listAdapter != null && this.b.an > 0 && i != -1 && i < listAdapter.getCount() && b()) {
                View childAt = this.b.getChildAt(i - this.b.V);
                if (childAt != null) {
                    this.b.a(childAt, i, listAdapter.getItemId(i));
                }
            }
        }
    }
}
