package com.google.a.d.a;

public enum a {
    L(1),
    M(0),
    Q(3),
    H(2);
    
    private static final a[] e;
    private final int f;

    static {
        e = new a[]{M, L, H, Q};
    }

    private a(int i) {
        this.f = i;
    }

    public int a() {
        return this.f;
    }
}
