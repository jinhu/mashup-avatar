package it.sephiroth.android.library.widget;

class b implements Runnable {
    final /* synthetic */ AbsHListView a;

    b(AbsHListView absHListView) {
        this.a = absHListView;
    }

    public void run() {
        if (this.a.y) {
            AbsHListView absHListView = this.a;
            this.a.z = false;
            absHListView.y = false;
            this.a.setChildrenDrawnWithCacheEnabled(false);
            if ((this.a.getPersistentDrawingCache() & 2) == 0) {
                this.a.setChildrenDrawingCacheEnabled(false);
            }
            if (!this.a.isAlwaysDrawnWithCacheEnabled()) {
                this.a.invalidate();
            }
        }
    }
}
