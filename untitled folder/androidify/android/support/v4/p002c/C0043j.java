package android.support.v4.p002c;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* renamed from: android.support.v4.c.j */
final class C0043j implements Set {
    final /* synthetic */ C0035g f217a;

    C0043j(C0035g c0035g) {
        this.f217a = c0035g;
    }

    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.f217a.m229c();
    }

    public boolean contains(Object obj) {
        return this.f217a.m220a(obj) >= 0;
    }

    public boolean containsAll(Collection collection) {
        return C0035g.m215a(this.f217a.m227b(), collection);
    }

    public boolean equals(Object obj) {
        return C0035g.m216a((Set) this, obj);
    }

    public int hashCode() {
        int i = 0;
        for (int a = this.f217a.m219a() - 1; a >= 0; a--) {
            Object a2 = this.f217a.m221a(a, 0);
            i += a2 == null ? 0 : a2.hashCode();
        }
        return i;
    }

    public boolean isEmpty() {
        return this.f217a.m219a() == 0;
    }

    public Iterator iterator() {
        return new C0041h(this.f217a, 0);
    }

    public boolean remove(Object obj) {
        int a = this.f217a.m220a(obj);
        if (a < 0) {
            return false;
        }
        this.f217a.m223a(a);
        return true;
    }

    public boolean removeAll(Collection collection) {
        return C0035g.m217b(this.f217a.m227b(), collection);
    }

    public boolean retainAll(Collection collection) {
        return C0035g.m218c(this.f217a.m227b(), collection);
    }

    public int size() {
        return this.f217a.m219a();
    }

    public Object[] toArray() {
        return this.f217a.m228b(0);
    }

    public Object[] toArray(Object[] objArr) {
        return this.f217a.m225a(objArr, 0);
    }
}
