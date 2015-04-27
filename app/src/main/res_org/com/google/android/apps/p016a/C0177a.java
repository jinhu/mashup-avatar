package com.google.android.apps.analytics;

/* renamed from: com.google.android.apps.a.a */
public class C0177a {
    private boolean f607a;

    public C0177a() {
        try {
            this.f607a = Class.forName("com.google.ads.AdRequest") != null;
        } catch (ClassNotFoundException e) {
            this.f607a = false;
        }
    }

    int m1108a() {
        return !this.f607a ? 0 : C0178b.m1131a().m1132b();
    }
}
