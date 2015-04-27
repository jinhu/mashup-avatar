package com.google.android.apps.androidify;

import java.util.concurrent.LinkedBlockingDeque;

public class cg extends LinkedBlockingDeque {
    final /* synthetic */ AndroidModelAdapter f1499a;

    public cg(AndroidModelAdapter aAndroidModelAdapterVar) {
        this.f1499a = aAndroidModelAdapterVar;
    }

    public boolean offer(Object obj) {
        return super.offerFirst(obj);
    }

    public Object remove() {
        return super.removeFirst();
    }
}
