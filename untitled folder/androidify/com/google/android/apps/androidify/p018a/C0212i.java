package com.google.android.apps.androidify.p018a;

import com.google.android.apps.androidify.bw;
import com.google.android.apps.androidify.bx;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.google.android.apps.androidify.a.i */
class C0212i {
    private ArrayList f1042a;
    private bw f1043b;
    private double f1044c;
    private float f1045d;
    private double f1046e;
    private double f1047f;

    private C0212i(double d, float f) {
        this.f1046e = Double.MAX_VALUE;
        this.f1047f = Double.MIN_VALUE;
        this.f1044c = d;
        this.f1045d = f;
        this.f1042a = new ArrayList();
    }

    float m1616a(double d) {
        return this.f1043b.getInterpolation((float) (d / this.f1044c));
    }

    void m1617a() {
        bx bxVar = new bx();
        float f = this.f1045d;
        Iterator it = this.f1042a.iterator();
        while (it.hasNext()) {
            C0210g c0210g = (C0210g) it.next();
            if (bxVar.m1897b() && c0210g.f988a > 0.0d) {
                bxVar.m1896a(0.0f, (float) c0210g.f989b);
            }
            float f2 = (float) c0210g.f989b;
            if (this.f1044c == 0.0d) {
                this.f1044c = c0210g.f988a;
            }
            bxVar.m1896a((float) (c0210g.f988a / this.f1044c), f2);
            f = f2;
        }
        bxVar.m1896a(1.0f, f);
        this.f1043b = bxVar.m1895a();
        if (this.f1046e == Double.MAX_VALUE) {
            this.f1046e = (double) this.f1045d;
        }
        if (this.f1047f == Double.MAX_VALUE) {
            this.f1047f = (double) this.f1045d;
        }
    }

    void m1618a(double d, double d2) {
        this.f1042a.add(new C0210g(d, d2));
        this.f1046e = Math.min(this.f1046e, d2);
        this.f1047f = Math.max(this.f1047f, d2);
    }
}
