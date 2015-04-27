package it.sephiroth.android.library.widget;

class ab implements Runnable {
    final /* synthetic */ C0273u f1908a;

    private ab(C0273u c0273u) {
        this.f1908a = c0273u;
    }

    public void run() {
        if (!this.f1908a.ai) {
            this.f1908a.m2134a();
            this.f1908a.m2137b();
        } else if (this.f1908a.getAdapter() != null) {
            this.f1908a.post(this);
        }
    }
}
