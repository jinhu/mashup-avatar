package com.google.android.apps.a;

public class a {
    private boolean a;

    public a() {
        try {
            this.a = Class.forName("com.google.ads.AdRequest") != null;
        } catch (ClassNotFoundException e) {
            this.a = false;
        }
    }

    int a() {
        return !this.a ? 0 : b.a().b();
    }
}
