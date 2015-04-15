package com.google.android.apps.c;

class k implements Runnable {
    final /* synthetic */ g a;

    k(g gVar) {
        this.a = gVar;
    }

    public void run() {
        if (this.a.e != null) {
            this.a.e.b(this.a.o);
        }
        this.a.g = null;
        this.a.k = false;
        this.a.o = false;
    }
}
