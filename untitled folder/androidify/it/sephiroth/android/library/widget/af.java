package it.sephiroth.android.library.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;

class af {
    private static ArrayList f1914e;
    public int f1915a;
    public int f1916b;
    int f1917c;
    public int f1918d;

    static {
        f1914e = new ArrayList(5);
    }

    private af() {
    }

    static af m2325a(int i) {
        return m2326a(2, i, 0, 0);
    }

    static af m2326a(int i, int i2, int i3, int i4) {
        af d = m2328d();
        d.f1918d = i;
        d.f1915a = i2;
        d.f1916b = i3;
        d.f1917c = i4;
        return d;
    }

    private void m2327c() {
        this.f1915a = 0;
        this.f1916b = 0;
        this.f1917c = 0;
        this.f1918d = 0;
    }

    private static af m2328d() {
        af afVar;
        synchronized (f1914e) {
            if (f1914e.size() > 0) {
                afVar = (af) f1914e.remove(0);
                afVar.m2327c();
            } else {
                afVar = new af();
            }
        }
        return afVar;
    }

    long m2329a() {
        return this.f1918d == 1 ? ExpandableListView.getPackedPositionForChild(this.f1915a, this.f1916b) : ExpandableListView.getPackedPositionForGroup(this.f1915a);
    }

    public void m2330b() {
        synchronized (f1914e) {
            if (f1914e.size() < 5) {
                f1914e.add(this);
            }
        }
    }
}
