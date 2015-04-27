package com.google.android.apps.androidify;

import java.util.Comparator;

class CustomSorter implements Comparator {
    CustomSorter() {
    }

    public int m1637a(AndroidConfig aAndroidConfigVar, AndroidConfig aAndroidConfigVar2) {
        return new Long(aAndroidConfigVar.m1770F()).compareTo(Long.valueOf(aAndroidConfigVar2.m1770F()));
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m1637a((AndroidConfig) obj, (AndroidConfig) obj2);
    }
}
