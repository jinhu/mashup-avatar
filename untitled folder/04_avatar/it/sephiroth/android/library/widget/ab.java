package it.sephiroth.android.library.widget;

class ab implements Runnable {
    final /* synthetic */ u a;

    private ab(u uVar) {
        this.a = uVar;
    }

    public void run() {
        if (!this.a.ai) {
            this.a.a();
            this.a.b();
        } else if (this.a.getAdapter() != null) {
            this.a.post(this);
        }
    }
}
