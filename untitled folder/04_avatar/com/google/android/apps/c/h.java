package com.google.android.apps.c;

class h implements Runnable {
    final /* synthetic */ g a;

    h(g gVar) {
        this.a = gVar;
    }

    public void run() {
        if (this.a.e != null) {
            this.a.e.b();
        }
        this.a.k = true;
        this.a.o = false;
    }
}
