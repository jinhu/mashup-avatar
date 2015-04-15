package com.google.android.apps.androidify;

import java.util.Comparator;

class ad implements Comparator {
    private ad() {
    }

    public int a(az azVar, az azVar2) {
        return new Long(azVar.F()).compareTo(Long.valueOf(azVar2.F()));
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((az) obj, (az) obj2);
    }
}
