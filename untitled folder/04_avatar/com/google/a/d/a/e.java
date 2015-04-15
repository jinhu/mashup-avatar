package com.google.a.d.a;

public final class e {
    private final int a;
    private final d[] b;

    e(int i, d... dVarArr) {
        this.a = i;
        this.b = dVarArr;
    }

    public int a() {
        return this.a;
    }

    public int b() {
        int i = 0;
        d[] dVarArr = this.b;
        int i2 = 0;
        while (i < dVarArr.length) {
            i2 += dVarArr[i].a();
            i++;
        }
        return i2;
    }

    public int c() {
        return this.a * b();
    }

    public d[] d() {
        return this.b;
    }
}
