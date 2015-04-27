package com.google.android.apps.p016a;

import java.util.Random;

/* renamed from: com.google.android.apps.a.b */
public class C0178b {
    private static final C0178b f622a;
    private int f623b;
    private Random f624c;

    static {
        f622a = new C0178b();
    }

    private C0178b() {
        this.f624c = new Random();
    }

    public static C0178b m1131a() {
        return f622a;
    }

    public int m1132b() {
        this.f623b = this.f624c.nextInt();
        return this.f623b;
    }
}
