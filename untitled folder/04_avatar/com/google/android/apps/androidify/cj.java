package com.google.android.apps.androidify;

import java.util.Random;

public class cj {
    public float a;
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;

    public void a() {
        Random random = new Random();
        this.b = random.nextFloat() * 180.0f;
        this.d = random.nextFloat() * 180.0f;
        this.a = random.nextFloat() * 90.0f;
        this.c = random.nextFloat() * 90.0f;
        this.e = random.nextFloat() * 70.0f;
        this.g = random.nextFloat() * 70.0f;
        this.f = random.nextFloat() * -90.0f;
        this.h = random.nextFloat() * -90.0f;
    }
}
