package it.sephiroth.android.library.widget;

class t {
    private int a;
    final /* synthetic */ AbsHListView c;

    private t(AbsHListView absHListView) {
        this.c = absHListView;
    }

    public void a() {
        this.a = this.c.getWindowAttachCount();
    }

    public boolean b() {
        return this.c.hasWindowFocus() && this.c.getWindowAttachCount() == this.a;
    }
}
