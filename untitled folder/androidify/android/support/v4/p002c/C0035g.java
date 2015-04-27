package android.support.v4.p002c;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: android.support.v4.c.g */
abstract class C0035g {
    C0042i f197b;
    C0043j f198c;
    C0045l f199d;

    C0035g() {
    }

    public static boolean m215a(Map map, Collection collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public static boolean m216a(Set set, Object obj) {
        boolean z = true;
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (!(set.size() == set2.size() && set.containsAll(set2))) {
                z = false;
            }
            return z;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    public static boolean m217b(Map map, Collection collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size();
    }

    public static boolean m218c(Map map, Collection collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    protected abstract int m219a();

    protected abstract int m220a(Object obj);

    protected abstract Object m221a(int i, int i2);

    protected abstract Object m222a(int i, Object obj);

    protected abstract void m223a(int i);

    protected abstract void m224a(Object obj, Object obj2);

    public Object[] m225a(Object[] objArr, int i) {
        int a = m219a();
        Object[] objArr2 = objArr.length < a ? (Object[]) Array.newInstance(objArr.getClass().getComponentType(), a) : objArr;
        for (int i2 = 0; i2 < a; i2++) {
            objArr2[i2] = m221a(i2, i);
        }
        if (objArr2.length > a) {
            objArr2[a] = null;
        }
        return objArr2;
    }

    protected abstract int m226b(Object obj);

    protected abstract Map m227b();

    public Object[] m228b(int i) {
        int a = m219a();
        Object[] objArr = new Object[a];
        for (int i2 = 0; i2 < a; i2++) {
            objArr[i2] = m221a(i2, i);
        }
        return objArr;
    }

    protected abstract void m229c();

    public Set m230d() {
        if (this.f197b == null) {
            this.f197b = new C0042i(this);
        }
        return this.f197b;
    }

    public Set m231e() {
        if (this.f198c == null) {
            this.f198c = new C0043j(this);
        }
        return this.f198c;
    }

    public Collection m232f() {
        if (this.f199d == null) {
            this.f199d = new C0045l(this);
        }
        return this.f199d;
    }
}
