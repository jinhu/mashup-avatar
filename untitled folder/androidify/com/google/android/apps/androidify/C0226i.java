package com.google.android.apps.androidify;

/* renamed from: com.google.android.apps.androidify.i */
class C0226i implements Runnable {
    final /* synthetic */ av f1648a;
    final /* synthetic */ Androidify f1649b;

    C0226i(Androidify androidify, av avVar) {
        this.f1649b = androidify;
        this.f1648a = avVar;
    }

    public void run() {
        this.f1649b.f761V.m1732a(this.f1648a);
        if (this.f1648a != null) {
            this.f1649b.m1377a(this.f1648a.f1263o);
        }
    }
}
