package it.sephiroth.android.library.widget;

/* renamed from: it.sephiroth.android.library.widget.t */
class C0278t {
    private int f1965a;
    final /* synthetic */ AbsHListView f1966c;

    private C0278t(AbsHListView absHListView) {
        this.f1966c = absHListView;
    }

    public void m2384a() {
        this.f1965a = this.f1966c.getWindowAttachCount();
    }

    public boolean m2385b() {
        return this.f1966c.hasWindowFocus() && this.f1966c.getWindowAttachCount() == this.f1965a;
    }
}
