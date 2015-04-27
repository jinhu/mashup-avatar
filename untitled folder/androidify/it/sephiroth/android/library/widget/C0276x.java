package it.sephiroth.android.library.widget;

import android.database.DataSetObserver;
import android.os.Parcelable;

/* renamed from: it.sephiroth.android.library.widget.x */
class C0276x extends DataSetObserver {
    private Parcelable f1962a;
    final /* synthetic */ C0273u f1963b;

    C0276x(C0273u c0273u) {
        this.f1963b = c0273u;
        this.f1962a = null;
    }

    public void onChanged() {
        this.f1963b.ai = true;
        this.f1963b.ao = this.f1963b.an;
        this.f1963b.an = this.f1963b.getAdapter().getCount();
        if (!this.f1963b.getAdapter().hasStableIds() || this.f1962a == null || this.f1963b.ao != 0 || this.f1963b.an <= 0) {
            this.f1963b.m2151w();
        } else {
            this.f1963b.onRestoreInstanceState(this.f1962a);
            this.f1962a = null;
        }
        this.f1963b.m2147s();
        this.f1963b.requestLayout();
    }

    public void onInvalidated() {
        this.f1963b.ai = true;
        if (this.f1963b.getAdapter().hasStableIds()) {
            this.f1962a = this.f1963b.onSaveInstanceState();
        }
        this.f1963b.ao = this.f1963b.an;
        this.f1963b.an = 0;
        this.f1963b.al = -1;
        this.f1963b.am = Long.MIN_VALUE;
        this.f1963b.aj = -1;
        this.f1963b.ak = Long.MIN_VALUE;
        this.f1963b.ac = false;
        this.f1963b.m2147s();
        this.f1963b.requestLayout();
    }
}
