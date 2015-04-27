package com.google.android.apps.androidify.p018a;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.google.android.apps.androidify.a.b */
public class AndInterpolator implements Interpolator {
    private ArrayList f980a;
    private int f981b;

    public AndInterpolator(float f, float f2) {
        this.f980a = new ArrayList();
        this.f980a.add(new Coordinate(f, 0));
        this.f980a.add(new Coordinate(f2, 0));
        this.f981b = this.f980a.size();
    }

    public void nextPoint(float f, float f2) {
        this.f980a.add(this.f981b - 1, new Coordinate(f2, 0));
        this.f981b = this.f980a.size();
    }

    public float getInterpolation(float f) {
        for (int i = 1; i < this.f981b; i++) {
            if (f <= ((Coordinate) this.f980a.get(i)).x) {
                float f2 = (f - ((Coordinate) this.f980a.get(i - 1)).x) / (((Coordinate) this.f980a.get(i)).x - ((Coordinate) this.f980a.get(i - 1)).x);
                return ((((Coordinate) this.f980a.get(i)).y - ((Coordinate) this.f980a.get(i - 1)).y) * f2) + ((Coordinate) this.f980a.get(i - 1)).y;
            }
        }
        return ((Coordinate) this.f980a.get(this.f981b - 1)).y;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = this.f980a.iterator();
        while (it.hasNext()) {
            Coordinate coordinate = (Coordinate) it.next();
            stringBuilder.append(coordinate.x + " -> " + coordinate.y + "\n");
        }
        return stringBuilder.toString();
    }
}
