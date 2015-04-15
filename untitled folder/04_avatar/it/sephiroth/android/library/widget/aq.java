package it.sephiroth.android.library.widget;

class aq implements Runnable {
    final /* synthetic */ HListView a;
    private int b;
    private int c;

    private aq(HListView hListView) {
        this.a = hListView;
    }

    public aq a(int i, int i2) {
        this.b = i;
        this.c = i2;
        return this;
    }

    public void run() {
        this.a.f(this.b, this.c);
    }
}
