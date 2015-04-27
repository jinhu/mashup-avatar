package it.sephiroth.android.library.widget;

class aq implements Runnable {
    final /* synthetic */ HListView f1927a;
    private int f1928b;
    private int f1929c;

    private aq(HListView hListView) {
        this.f1927a = hListView;
    }

    public aq m2340a(int i, int i2) {
        this.f1928b = i;
        this.f1929c = i2;
        return this;
    }

    public void run() {
        this.f1927a.m2296f(this.f1928b, this.f1929c);
    }
}
