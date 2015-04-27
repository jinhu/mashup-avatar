package com.google.android.apps.p017c;

/* renamed from: com.google.android.apps.c.h */
class C0261h implements Runnable {
    final /* synthetic */ Interaction f1818a;

    C0261h(Interaction aInteraction) {
        this.f1818a = aInteraction;
    }

    public void run() {
        if (this.f1818a.f1807e != null) {
            this.f1818a.f1807e.onTouchedMe();
        }
        this.f1818a.f1813k = true;
        this.f1818a.f1817o = false;
    }
}
