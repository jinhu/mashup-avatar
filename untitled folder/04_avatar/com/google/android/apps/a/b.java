package com.google.android.apps.a;

import java.util.Random;

public class b {
    private static final b a;
    private int b;
    private Random c;

    static {
        a = new b();
    }

    private b() {
        this.c = new Random();
    }

    public static b a() {
        return a;
    }

    public int b() {
        this.b = this.c.nextInt();
        return this.b;
    }
}
