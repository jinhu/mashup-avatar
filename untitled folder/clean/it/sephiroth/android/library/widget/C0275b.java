package it.sephiroth.android.library.widget;

/* renamed from: it.sephiroth.android.library.widget.b */
class C0275b implements Runnable {
    final /* synthetic */ AbsHListView f1961a;

    C0275b(AbsHListView absHListView) {
        this.f1961a = absHListView;
    }

    public void run() {
        if (this.f1961a.f1893y) {
            AbsHListView absHListView = this.f1961a;
            this.f1961a.f1894z = false;
            absHListView.f1893y = false;
            this.f1961a.setChildrenDrawnWithCacheEnabled(false);
            if ((this.f1961a.getPersistentDrawingCache() & 2) == 0) {
                this.f1961a.setChildrenDrawingCacheEnabled(false);
            }
            if (!this.f1961a.isAlwaysDrawnWithCacheEnabled()) {
                this.f1961a.invalidate();
            }
        }
    }
}
