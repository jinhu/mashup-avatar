package com.google.android.apps.androidify.a;

import com.google.android.apps.androidify.bw;
import com.google.android.apps.androidify.bx;
import java.util.ArrayList;
import java.util.Iterator;

class i {
    private ArrayList a;
    private bw b;
    private double c;
    private float d;
    private double e;
    private double f;

    private i(double d, float f) {
        this.e = Double.MAX_VALUE;
        this.f = Double.MIN_VALUE;
        this.c = d;
        this.d = f;
        this.a = new ArrayList();
    }

    float a(double d) {
        return this.b.getInterpolation((float) (d / this.c));
    }

    void a() {
        bx bxVar = new bx();
        float f = this.d;
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            g gVar = (g) it.next();
            if (bxVar.b() && gVar.a > 0.0d) {
                bxVar.a(0.0f, (float) gVar.b);
            }
            float f2 = (float) gVar.b;
            if (this.c == 0.0d) {
                this.c = gVar.a;
            }
            bxVar.a((float) (gVar.a / this.c), f2);
            f = f2;
        }
        bxVar.a(1.0f, f);
        this.b = bxVar.a();
        if (this.e == Double.MAX_VALUE) {
            this.e = (double) this.d;
        }
        if (this.f == Double.MAX_VALUE) {
            this.f = (double) this.d;
        }
    }

    void a(double d, double d2) {
        this.a.add(new g(d, d2));
        this.e = Math.min(this.e, d2);
        this.f = Math.max(this.f, d2);
    }
}
