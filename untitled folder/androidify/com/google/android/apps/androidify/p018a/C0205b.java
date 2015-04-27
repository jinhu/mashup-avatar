package com.google.android.apps.androidify.p018a;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.google.android.apps.androidify.a.b */
public class C0205b implements Interpolator {
    private ArrayList f980a;
    private int f981b;

    public C0205b(float f, float f2) {
        this.f980a = new ArrayList();
        this.f980a.add(new C0207d(f, null));
        this.f980a.add(new C0207d(f2, null));
        this.f981b = this.f980a.size();
    }

    public void m1601a(float f, float f2) {
        this.f980a.add(this.f981b - 1, new C0207d(f2, null));
        this.f981b = this.f980a.size();
    }

    public float getInterpolation(float f) {
        for (int i = 1; i < this.f981b; i++) {
            if (f <= ((C0207d) this.f980a.get(i)).f982a) {
                float f2 = (f - ((C0207d) this.f980a.get(i - 1)).f982a) / (((C0207d) this.f980a.get(i)).f982a - ((C0207d) this.f980a.get(i - 1)).f982a);
                return ((((C0207d) this.f980a.get(i)).f983b - ((C0207d) this.f980a.get(i - 1)).f983b) * f2) + ((C0207d) this.f980a.get(i - 1)).f983b;
            }
        }
        return ((C0207d) this.f980a.get(this.f981b - 1)).f983b;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = this.f980a.iterator();
        while (it.hasNext()) {
            C0207d c0207d = (C0207d) it.next();
            stringBuilder.append(c0207d.f982a + " -> " + c0207d.f983b + "\n");
        }
        return stringBuilder.toString();
    }
}
