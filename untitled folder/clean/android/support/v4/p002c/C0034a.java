package android.support.v4.p002c;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: android.support.v4.c.a */
public class C0034a extends C0033m implements Map {
    C0035g f196a;

    private C0035g m214b() {
        if (this.f196a == null) {
            this.f196a = new C0036b(this);
        }
        return this.f196a;
    }

    public Set entrySet() {
        return m214b().m230d();
    }

    public Set keySet() {
        return m214b().m231e();
    }

    public void putAll(Map map) {
        m210a(this.h + map.size());
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Collection values() {
        return m214b().m232f();
    }
}
