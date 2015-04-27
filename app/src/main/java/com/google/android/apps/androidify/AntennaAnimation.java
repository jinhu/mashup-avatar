package com.google.android.apps.androidify;

public class AntennaAnimation {
    private float angleLeft;
    private float mAngleRight;
    private long mStartTime;
    boolean f1125d;
    private Runnable f1126e;

    public AntennaAnimation() {
        this.mStartTime = 0;
        this.f1125d = false;
        this.f1126e = new MyUnknownTask(this);
    }

    private double angleOf(double d) {
        return Math.cos(1.5d * d) / (Math.cos(0.5d * d) + 2.0d);
    }

    public float getAngle(int i) {
        return i == 0 ? this.angleLeft : this.mAngleRight;
    }

    public void step() {
        double currentTimeMillis = ((((double) (System.currentTimeMillis() - this.mStartTime)) / 10000.0d) * 2.0d) * 3.141592653589793d;
        this.angleLeft = (float) (angleOf(currentTimeMillis) * 10.0d);
        this.mAngleRight = (float) (angleOf(currentTimeMillis) * 10.0d);
    }
}
