package com.google.android.apps.a;

public class ae {
    private final String a;
    private String b;
    private final double c;
    private double d;
    private double e;

    public ae(String str, double d) {
        this.b = null;
        this.d = 0.0d;
        this.e = 0.0d;
        if (str == null || str.trim().length() == 0) {
            throw new IllegalArgumentException("orderId must not be empty or null");
        }
        this.a = str;
        this.c = d;
    }

    public ac a() {
        return new ac();
    }

    public ae a(double d) {
        this.d = d;
        return this;
    }

    public ae a(String str) {
        this.b = str;
        return this;
    }

    public ae b(double d) {
        this.e = d;
        return this;
    }
}
