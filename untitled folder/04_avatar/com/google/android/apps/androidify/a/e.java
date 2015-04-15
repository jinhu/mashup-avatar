package com.google.android.apps.androidify.a;

import java.util.HashMap;
import java.util.Map.Entry;

public class e {
    private double a;
    private HashMap b;
    private k c;
    private double d;

    public e() {
        this.d = 0.0d;
        this.b = new HashMap();
    }

    public float a(double d, h hVar) {
        i iVar = (i) this.b.get(hVar);
        return iVar == null ? hVar.Z : iVar.a(d);
    }

    public float a(h hVar) {
        i iVar = (i) this.b.get(hVar);
        return iVar == null ? hVar.Z : (float) iVar.f;
    }

    public void a() {
        for (Entry value : this.b.entrySet()) {
            ((i) value.getValue()).a();
        }
    }

    public void a(double d) {
        this.d = d;
    }

    public void a(h hVar, double d) {
        this.b.put(hVar, new i(hVar.Z, null));
    }

    public void a(h hVar, double d, double d2) {
        ((i) this.b.get(hVar)).a(d, d2);
    }

    public void a(k kVar) {
        this.c = kVar;
    }

    public double b() {
        return this.a;
    }

    public float b(h hVar) {
        i iVar = (i) this.b.get(hVar);
        return iVar == null ? hVar.Z : (float) iVar.e;
    }

    public void b(double d) {
        this.a = d;
    }

    public k c() {
        return this.c;
    }

    public double d() {
        return this.d;
    }
}
