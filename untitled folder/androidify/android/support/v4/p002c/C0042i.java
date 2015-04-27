package android.support.v4.p002c;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: android.support.v4.c.i */
final class C0042i implements Set {
    final /* synthetic */ C0035g f216a;

    C0042i(C0035g c0035g) {
        this.f216a = c0035g;
    }

    public boolean m259a(Entry entry) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ boolean add(Object obj) {
        return m259a((Entry) obj);
    }

    public boolean addAll(Collection collection) {
        int a = this.f216a.m219a();
        for (Entry entry : collection) {
            this.f216a.m224a(entry.getKey(), entry.getValue());
        }
        return a != this.f216a.m219a();
    }

    public void clear() {
        this.f216a.m229c();
    }

    public boolean contains(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        int a = this.f216a.m220a(entry.getKey());
        return a >= 0 ? C0037c.m245a(this.f216a.m221a(a, 1), entry.getValue()) : false;
    }

    public boolean containsAll(Collection collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        return C0035g.m216a((Set) this, obj);
    }

    public int hashCode() {
        int a = this.f216a.m219a() - 1;
        int i = 0;
        while (a >= 0) {
            Object a2 = this.f216a.m221a(a, 0);
            Object a3 = this.f216a.m221a(a, 1);
            a--;
            i += (a3 == null ? 0 : a3.hashCode()) ^ (a2 == null ? 0 : a2.hashCode());
        }
        return i;
    }

    public boolean isEmpty() {
        return this.f216a.m219a() == 0;
    }

    public Iterator iterator() {
        return new C0044k(this.f216a);
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return this.f216a.m219a();
    }

    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    public Object[] toArray(Object[] objArr) {
        throw new UnsupportedOperationException();
    }
}
