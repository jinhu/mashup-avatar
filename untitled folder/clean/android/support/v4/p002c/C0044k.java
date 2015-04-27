package android.support.v4.p002c;

import java.util.Iterator;
import java.util.Map.Entry;

/* renamed from: android.support.v4.c.k */
final class C0044k implements Iterator, Entry {
    int f218a;
    int f219b;
    boolean f220c;
    final /* synthetic */ C0035g f221d;

    C0044k(C0035g c0035g) {
        this.f221d = c0035g;
        this.f220c = false;
        this.f218a = c0035g.m219a() - 1;
        this.f219b = -1;
    }

    public Entry m260a() {
        this.f219b++;
        this.f220c = true;
        return this;
    }

    public final boolean equals(Object obj) {
        boolean z = true;
        if (!this.f220c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        } else if (!(obj instanceof Entry)) {
            return false;
        } else {
            Entry entry = (Entry) obj;
            if (!(C0037c.m245a(entry.getKey(), this.f221d.m221a(this.f219b, 0)) && C0037c.m245a(entry.getValue(), this.f221d.m221a(this.f219b, 1)))) {
                z = false;
            }
            return z;
        }
    }

    public Object getKey() {
        if (this.f220c) {
            return this.f221d.m221a(this.f219b, 0);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public Object getValue() {
        if (this.f220c) {
            return this.f221d.m221a(this.f219b, 1);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public boolean hasNext() {
        return this.f219b < this.f218a;
    }

    public final int hashCode() {
        int i = 0;
        if (this.f220c) {
            Object a = this.f221d.m221a(this.f219b, 0);
            Object a2 = this.f221d.m221a(this.f219b, 1);
            int hashCode = a == null ? 0 : a.hashCode();
            if (a2 != null) {
                i = a2.hashCode();
            }
            return i ^ hashCode;
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public /* synthetic */ Object next() {
        return m260a();
    }

    public void remove() {
        if (this.f220c) {
            this.f221d.m223a(this.f219b);
            this.f219b--;
            this.f218a--;
            this.f220c = false;
            return;
        }
        throw new IllegalStateException();
    }

    public Object setValue(Object obj) {
        if (this.f220c) {
            return this.f221d.m222a(this.f219b, obj);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}
