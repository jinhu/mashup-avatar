package com.google.android.apps.p017c;

/* renamed from: com.google.android.apps.c.k */
class C0264k implements Runnable {
    final /* synthetic */ Interaction f1823a;

    C0264k(Interaction aInteraction) {
        this.f1823a = aInteraction;
    }

    public void run() {
        if (this.f1823a.f1807e != null) {
            this.f1823a.f1807e.onTouchedMe(this.f1823a.f1817o);
        }
        this.f1823a.f1809g = null;
        this.f1823a.f1813k = false;
        this.f1823a.f1817o = false;
    }
}
