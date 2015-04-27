package android.support.v4.p002c;

import java.util.Collection;
import java.util.Iterator;

/* renamed from: android.support.v4.c.l */
final class C0045l implements Collection {
    final /* synthetic */ C0035g f222a;

    C0045l(C0035g c0035g) {
        this.f222a = c0035g;
    }

    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.f222a.m229c();
    }

    public boolean contains(Object obj) {
        return this.f222a.m226b(obj) >= 0;
    }

    public boolean containsAll(Collection collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return this.f222a.m219a() == 0;
    }

    public Iterator iterator() {
        return new C0041h(this.f222a, 1);
    }

    public boolean remove(Object obj) {
        int b = this.f222a.m226b(obj);
        if (b < 0) {
            return false;
        }
        this.f222a.m223a(b);
        return true;
    }

    public boolean removeAll(Collection collection) {
        int i = 0;
        int a = this.f222a.m219a();
        boolean z = false;
        while (i < a) {
            if (collection.contains(this.f222a.m221a(i, 1))) {
                this.f222a.m223a(i);
                i--;
                a--;
                z = true;
            }
            i++;
        }
        return z;
    }

    public boolean retainAll(Collection collection) {
        int i = 0;
        int a = this.f222a.m219a();
        boolean z = false;
        while (i < a) {
            if (!collection.contains(this.f222a.m221a(i, 1))) {
                this.f222a.m223a(i);
                i--;
                a--;
                z = true;
            }
            i++;
        }
        return z;
    }

    public int size() {
        return this.f222a.m219a();
    }

    public Object[] toArray() {
        return this.f222a.m228b(1);
    }

    public Object[] toArray(Object[] objArr) {
        return this.f222a.m225a(objArr, 1);
    }
}
