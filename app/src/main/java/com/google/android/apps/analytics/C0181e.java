package com.google.android.apps.analytics;

/* renamed from: com.google.android.apps.a.e */
class C0181e {
    private C0180d[] f629a;

    public C0181e() {
        this.f629a = new C0180d[5];
    }

    private void m1139d(int i) {
        if (i < 1 || i > 5) {
            throw new IllegalArgumentException("Index must be between 1 and 5 inclusive.");
        }
    }

    public void m1140a(C0180d c0180d) {
        m1139d(c0180d.m1138d());
        this.f629a[c0180d.m1138d() - 1] = c0180d;
    }

    public boolean m1141a(int i) {
        m1139d(i);
        return this.f629a[i + -1] == null;
    }

    public C0180d[] m1142a() {
        return (C0180d[]) this.f629a.clone();
    }

    public C0180d m1143b(int i) {
        m1139d(i);
        return this.f629a[i - 1];
    }

    public boolean m1144b() {
        for (C0180d c0180d : this.f629a) {
            if (c0180d != null) {
                return true;
            }
        }
        return false;
    }

    public void m1145c(int i) {
        m1139d(i);
        this.f629a[i - 1] = null;
    }
}
