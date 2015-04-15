package com.google.android.apps.a;

public class r {
    private final String a;
    private final String b;
    private final double c;
    private final long d;
    private String e;
    private String f;

    public r(String str, String str2, double d, long j) {
        this.e = null;
        this.f = null;
        if (str == null || str.trim().length() == 0) {
            throw new IllegalArgumentException("orderId must not be empty or null");
        } else if (str2 == null || str2.trim().length() == 0) {
            throw new IllegalArgumentException("itemSKU must not be empty or null");
        } else {
            this.a = str;
            this.b = str2;
            this.c = d;
            this.d = j;
        }
    }

    public p a() {
        return new p();
    }

    public r a(String str) {
        this.e = str;
        return this;
    }

    public r b(String str) {
        this.f = str;
        return this;
    }
}
