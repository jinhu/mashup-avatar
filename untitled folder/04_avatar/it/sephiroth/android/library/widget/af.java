package it.sephiroth.android.library.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;

class af {
    private static ArrayList e;
    public int a;
    public int b;
    int c;
    public int d;

    static {
        e = new ArrayList(5);
    }

    private af() {
    }

    static af a(int i) {
        return a(2, i, 0, 0);
    }

    static af a(int i, int i2, int i3, int i4) {
        af d = d();
        d.d = i;
        d.a = i2;
        d.b = i3;
        d.c = i4;
        return d;
    }

    private void c() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
    }

    private static af d() {
        af afVar;
        synchronized (e) {
            if (e.size() > 0) {
                afVar = (af) e.remove(0);
                afVar.c();
            } else {
                afVar = new af();
            }
        }
        return afVar;
    }

    long a() {
        return this.d == 1 ? ExpandableListView.getPackedPositionForChild(this.a, this.b) : ExpandableListView.getPackedPositionForGroup(this.a);
    }

    public void b() {
        synchronized (e) {
            if (e.size() < 5) {
                e.add(this);
            }
        }
    }
}
