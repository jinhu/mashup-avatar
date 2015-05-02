package com.google.android.apps.androidify;

import java.util.ArrayList;

public class DroidCoordinateArray {
    private ArrayList mList;

    public DroidCoordinateArray() {
        this.mList = new ArrayList();
    }

    public DroidInterpolator m1895a() {
        return new DroidInterpolator((DroidCoordinate[]) this.mList.toArray(new DroidCoordinate[this.mList.size()]));
    }

    public void m1896a(float f, float f2) {
        this.mList.add(new DroidCoordinate(f, f2));
    }

    public boolean isEmpty() {
        return this.mList.isEmpty();
    }
}
