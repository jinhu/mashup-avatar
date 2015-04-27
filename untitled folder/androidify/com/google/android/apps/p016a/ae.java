package com.google.android.apps.p016a;

/* renamed from: com.google.android.apps.a.ae */
public class ae {
    private final String f617a;
    private String f618b;
    private final double f619c;
    private double f620d;
    private double f621e;

    public ae(String str, double d) {
        this.f618b = null;
        this.f620d = 0.0d;
        this.f621e = 0.0d;
        if (str == null || str.trim().length() == 0) {
            throw new IllegalArgumentException("orderId must not be empty or null");
        }
        this.f617a = str;
        this.f619c = d;
    }

    public ac m1126a() {
        return new ac();
    }

    public ae m1127a(double d) {
        this.f620d = d;
        return this;
    }

    public ae m1128a(String str) {
        this.f618b = str;
        return this;
    }

    public ae m1129b(double d) {
        this.f621e = d;
        return this;
    }
}
