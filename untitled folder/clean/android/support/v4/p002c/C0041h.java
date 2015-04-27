package android.support.v4.p002c;

import java.util.Iterator;

/* renamed from: android.support.v4.c.h */
final class C0041h implements Iterator {
    final int f211a;
    int f212b;
    int f213c;
    boolean f214d;
    final /* synthetic */ C0035g f215e;

    C0041h(C0035g c0035g, int i) {
        this.f215e = c0035g;
        this.f214d = false;
        this.f211a = i;
        this.f212b = c0035g.m219a();
    }

    public boolean hasNext() {
        return this.f213c < this.f212b;
    }

    public Object next() {
        Object a = this.f215e.m221a(this.f213c, this.f211a);
        this.f213c++;
        this.f214d = true;
        return a;
    }

    public void remove() {
        if (this.f214d) {
            this.f213c--;
            this.f212b--;
            this.f214d = false;
            this.f215e.m223a(this.f213c);
            return;
        }
        throw new IllegalStateException();
    }
}
