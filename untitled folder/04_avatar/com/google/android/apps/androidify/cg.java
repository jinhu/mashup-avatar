package com.google.android.apps.androidify;

import java.util.concurrent.LinkedBlockingDeque;

public class cg extends LinkedBlockingDeque {
    final /* synthetic */ ce a;

    public cg(ce ceVar) {
        this.a = ceVar;
    }

    public boolean offer(Object obj) {
        return super.offerFirst(obj);
    }

    public Object remove() {
        return super.removeFirst();
    }
}
