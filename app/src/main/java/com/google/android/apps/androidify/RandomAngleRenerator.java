package com.google.android.apps.androidify;

import java.util.Random;

public class RandomAngleRenerator {
    public float f1507a;
    public float f1508b;
    public float f1509c;
    public float f1510d;
    public float f1511e;
    public float f1512f;
    public float f1513g;
    public float f1514h;

    public void m1929a() {
        Random random = new Random();
        this.f1508b = random.nextFloat() * 180.0f;
        this.f1510d = random.nextFloat() * 180.0f;
        this.f1507a = random.nextFloat() * 90.0f;
        this.f1509c = random.nextFloat() * 90.0f;
        this.f1511e = random.nextFloat() * 70.0f;
        this.f1513g = random.nextFloat() * 70.0f;
        this.f1512f = random.nextFloat() * -90.0f;
        this.f1514h = random.nextFloat() * -90.0f;
    }
}
