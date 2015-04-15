package it.sephiroth.android.library.widget;

import android.database.DataSetObserver;

public class ad extends DataSetObserver {
    final /* synthetic */ ExpandableHListConnector a;

    protected ad(ExpandableHListConnector expandableHListConnector) {
        this.a = expandableHListConnector;
    }

    public void onChanged() {
        this.a.a(true, true);
        this.a.notifyDataSetChanged();
    }

    public void onInvalidated() {
        this.a.a(true, true);
        this.a.notifyDataSetInvalidated();
    }
}
