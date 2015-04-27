package it.sephiroth.android.library.widget;

import android.database.DataSetObserver;

public class ad extends DataSetObserver {
    final /* synthetic */ ExpandableHListConnector f1909a;

    protected ad(ExpandableHListConnector expandableHListConnector) {
        this.f1909a = expandableHListConnector;
    }

    public void onChanged() {
        this.f1909a.m2234a(true, true);
        this.f1909a.notifyDataSetChanged();
    }

    public void onInvalidated() {
        this.f1909a.m2234a(true, true);
        this.f1909a.notifyDataSetInvalidated();
    }
}
