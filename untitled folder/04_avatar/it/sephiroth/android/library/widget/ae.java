package it.sephiroth.android.library.widget;

import java.util.ArrayList;

public class ae {
    private static ArrayList d;
    public af a;
    public GroupMetadata b;
    public int c;

    static {
        d = new ArrayList(5);
    }

    private ae() {
    }

    static ae a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
        ae d = d();
        d.a = af.a(i2, i3, i4, i);
        d.b = groupMetadata;
        d.c = i5;
        return d;
    }

    private void c() {
        if (this.a != null) {
            this.a.b();
            this.a = null;
        }
        this.b = null;
        this.c = 0;
    }

    private static ae d() {
        ae aeVar;
        synchronized (d) {
            if (d.size() > 0) {
                aeVar = (ae) d.remove(0);
                aeVar.c();
            } else {
                aeVar = new ae();
            }
        }
        return aeVar;
    }

    public void a() {
        c();
        synchronized (d) {
            if (d.size() < 5) {
                d.add(this);
            }
        }
    }

    public boolean b() {
        return this.b != null;
    }
}
