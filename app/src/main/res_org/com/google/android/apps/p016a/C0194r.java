package com.google.android.apps.analytics;

/* renamed from: com.google.android.apps.a.r */
public class C0194r {
    final String f683a;
    final String f684b;
    final double f685c;
    final long f686d;
    String f687e;
    String f688f;

    public C0194r(String str, String str2, double d, long j) {
        this.f687e = null;
        this.f688f = null;
        if (str == null || str.trim().length() == 0) {
            throw new IllegalArgumentException("orderId must not be empty or null");
        } else if (str2 == null || str2.trim().length() == 0) {
            throw new IllegalArgumentException("itemSKU must not be empty or null");
        } else {
            this.f683a = str;
            this.f684b = str2;
            this.f685c = d;
            this.f686d = j;
        }
    }

    public C0192p m1227a() {
        return new C0192p(this);
    }

    public C0194r m1228a(String str) {
        this.f687e = str;
        return this;
    }

    public C0194r m1229b(String str) {
        this.f688f = str;
        return this;
    }
}
