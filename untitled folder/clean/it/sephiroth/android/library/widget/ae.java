package it.sephiroth.android.library.widget;

import java.util.ArrayList;

public class ae {
    private static ArrayList f1910d;
    public af f1911a;
    public GroupMetadata f1912b;
    public int f1913c;

    static {
        f1910d = new ArrayList(5);
    }

    private ae() {
    }

    static ae m2320a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
        ae d = m2322d();
        d.f1911a = af.m2326a(i2, i3, i4, i);
        d.f1912b = groupMetadata;
        d.f1913c = i5;
        return d;
    }

    private void m2321c() {
        if (this.f1911a != null) {
            this.f1911a.m2330b();
            this.f1911a = null;
        }
        this.f1912b = null;
        this.f1913c = 0;
    }

    private static ae m2322d() {
        ae aeVar;
        synchronized (f1910d) {
            if (f1910d.size() > 0) {
                aeVar = (ae) f1910d.remove(0);
                aeVar.m2321c();
            } else {
                aeVar = new ae();
            }
        }
        return aeVar;
    }

    public void m2323a() {
        m2321c();
        synchronized (f1910d) {
            if (f1910d.size() < 5) {
                f1910d.add(this);
            }
        }
    }

    public boolean m2324b() {
        return this.f1912b != null;
    }
}
