package com.google.android.apps.androidify.p018a;

import java.util.HashMap;
import java.util.Map.Entry;

/* renamed from: com.google.android.apps.androidify.a.e */
public class C0208e {
    private double f984a;
    protected HashMap<String,Entry> f985b;
    private Part f986c;
    private double f987d;

    public C0208e() {
        this.f987d = 0.0d;
        this.f985b = new HashMap();
    }

    public float m1602a(double d, Animation aAnimation) {
        C0212i c0212i = (C0212i) this.f985b.get(aAnimation);
        return c0212i == null ? aAnimation.f1041Z : c0212i.m1616a(d);
    }

    public float m1603a(Animation aAnimation) {
        C0212i c0212i = (C0212i) this.f985b.get(aAnimation);
        return c0212i == null ? aAnimation.f1041Z : (float) c0212i.f1047f;
    }

    public void m1604a() {
        for (Entry value : this.f985b.entrySet()) {
            ((C0212i) value.getValue()).m1617a();
        }
    }

    public void m1605a(double d) {
        this.f987d = d;
    }

    public void addAnimation(Animation aAnimation, double d) {
        //this.f985b.put(aAnimation, new C0212i(aAnimation.f1041Z, 0));
    }

    public void m1607a(Animation aAnimation, double d, double d2) {
        ((C0212i) this.f985b.get(aAnimation)).m1618a(d, d2);
    }

    public void m1608a(Part aPart) {
        this.f986c = aPart;
    }

    public double m1609b() {
        return this.f984a;
    }

    public float m1610b(Animation aAnimation) {
        C0212i c0212i = (C0212i) this.f985b.get(aAnimation);
        return c0212i == null ? aAnimation.f1041Z : (float) c0212i.f1046e;
    }

    public void m1611b(double d) {
        this.f984a = d;
    }

    public Part m1612c() {
        return this.f986c;
    }

    public double m1613d() {
        return this.f987d;
    }
}
