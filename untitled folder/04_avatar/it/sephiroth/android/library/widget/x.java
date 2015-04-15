package it.sephiroth.android.library.widget;

import android.database.DataSetObserver;
import android.os.Parcelable;

class x extends DataSetObserver {
    private Parcelable a;
    final /* synthetic */ u b;

    x(u uVar) {
        this.b = uVar;
        this.a = null;
    }

    public void onChanged() {
        this.b.ai = true;
        this.b.ao = this.b.an;
        this.b.an = this.b.getAdapter().getCount();
        if (!this.b.getAdapter().hasStableIds() || this.a == null || this.b.ao != 0 || this.b.an <= 0) {
            this.b.w();
        } else {
            this.b.onRestoreInstanceState(this.a);
            this.a = null;
        }
        this.b.s();
        this.b.requestLayout();
    }

    public void onInvalidated() {
        this.b.ai = true;
        if (this.b.getAdapter().hasStableIds()) {
            this.a = this.b.onSaveInstanceState();
        }
        this.b.ao = this.b.an;
        this.b.an = 0;
        this.b.al = -1;
        this.b.am = Long.MIN_VALUE;
        this.b.aj = -1;
        this.b.ak = Long.MIN_VALUE;
        this.b.ac = false;
        this.b.s();
        this.b.requestLayout();
    }
}
