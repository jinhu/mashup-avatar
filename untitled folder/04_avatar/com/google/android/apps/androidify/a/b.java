package com.google.android.apps.androidify.a;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public class b implements Interpolator {
    private ArrayList a;
    private int b;

    public b(float f, float f2) {
        this.a = new ArrayList();
        this.a.add(new d(f, null));
        this.a.add(new d(f2, null));
        this.b = this.a.size();
    }

    public void a(float f, float f2) {
        this.a.add(this.b - 1, new d(f2, null));
        this.b = this.a.size();
    }

    public float getInterpolation(float f) {
        for (int i = 1; i < this.b; i++) {
            if (f <= ((d) this.a.get(i)).a) {
                float f2 = (f - ((d) this.a.get(i - 1)).a) / (((d) this.a.get(i)).a - ((d) this.a.get(i - 1)).a);
                return ((((d) this.a.get(i)).b - ((d) this.a.get(i - 1)).b) * f2) + ((d) this.a.get(i - 1)).b;
            }
        }
        return ((d) this.a.get(this.b - 1)).b;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            stringBuilder.append(dVar.a + " -> " + dVar.b + "\n");
        }
        return stringBuilder.toString();
    }
}
