package android.support.v4.p002c;

import java.util.Map;

/* renamed from: android.support.v4.c.b */
class C0036b extends C0035g {
    final /* synthetic */ C0034a f200a;

    C0036b(C0034a c0034a) {
        this.f200a = c0034a;
    }

    protected int m233a() {
        return this.f200a.h;
    }

    protected int m234a(Object obj) {
        return obj == null ? this.f200a.m206a() : this.f200a.m208a(obj, obj.hashCode());
    }

    protected Object m235a(int i, int i2) {
        return this.f200a.g[(i << 1) + i2];
    }

    protected Object m236a(int i, Object obj) {
        return this.f200a.m209a(i, obj);
    }

    protected void m237a(int i) {
        this.f200a.m213d(i);
    }

    protected void m238a(Object obj, Object obj2) {
        this.f200a.put(obj, obj2);
    }

    protected int m239b(Object obj) {
        return this.f200a.m207a(obj);
    }

    protected Map m240b() {
        return this.f200a;
    }

    protected void m241c() {
        this.f200a.clear();
    }
}
