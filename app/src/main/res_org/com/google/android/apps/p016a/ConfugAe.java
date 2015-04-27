package com.google.android.apps.analytics;

/* renamed from: com.google.android.apps.a.POINT_TO_REF_39 */
public class ConfugAe {
    final String f617a;
    String f618b;
    final double f619c;
    double f620d;
    double f621e;

    public ConfugAe(String str, double d) {
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
        return new ac(this);
    }

    public ConfugAe m1127a(double d) {
        this.f620d = d;
        return this;
    }

    public ConfugAe m1128a(String str) {
        this.f618b = str;
        return this;
    }

    public ConfugAe m1129b(double d) {
        this.f621e = d;
        return this;
    }
}
