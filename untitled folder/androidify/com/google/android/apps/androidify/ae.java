package com.google.android.apps.androidify;

public class ae {
    private float f1122a;
    private float f1123b;
    private long f1124c;
    private boolean f1125d;
    private Runnable f1126e;

    public ae() {
        this.f1124c = 0;
        this.f1125d = false;
        this.f1126e = new af(this);
    }

    private double m1638a(double d) {
        return Math.cos(1.5d * d) / (Math.cos(0.5d * d) + 2.0d);
    }

    public float m1640a(int i) {
        return i == 0 ? this.f1122a : this.f1123b;
    }

    public void m1641a() {
        double currentTimeMillis = ((((double) (System.currentTimeMillis() - this.f1124c)) / 10000.0d) * 2.0d) * 3.141592653589793d;
        this.f1122a = (float) (m1638a(currentTimeMillis) * 10.0d);
        this.f1123b = (float) (m1638a(currentTimeMillis) * 10.0d);
    }
}
