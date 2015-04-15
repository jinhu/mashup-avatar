package com.google.android.apps.androidify;

public class ae {
    private float a;
    private float b;
    private long c;
    private boolean d;
    private Runnable e;

    public ae() {
        this.c = 0;
        this.d = false;
        this.e = new af(this);
    }

    private double a(double d) {
        return Math.cos(1.5d * d) / (Math.cos(0.5d * d) + 2.0d);
    }

    public float a(int i) {
        return i == 0 ? this.a : this.b;
    }

    public void a() {
        double currentTimeMillis = ((((double) (System.currentTimeMillis() - this.c)) / 10000.0d) * 2.0d) * 3.141592653589793d;
        this.a = (float) (a(currentTimeMillis) * 10.0d);
        this.b = (float) (a(currentTimeMillis) * 10.0d);
    }
}
