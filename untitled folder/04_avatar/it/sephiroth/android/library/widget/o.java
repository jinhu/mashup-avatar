package it.sephiroth.android.library.widget;

class o implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ m c;

    o(m mVar, int i, int i2) {
        this.c = mVar;
        this.a = i;
        this.b = i2;
    }

    public void run() {
        this.c.a(this.a, this.b);
    }
}
