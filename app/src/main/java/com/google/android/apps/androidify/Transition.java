package com.google.android.apps.androidify;

/**
 * Created by jin on 4/18/15.
 */
public class Transition {
    private final float x;
    private final DirectionState mDirection;
    public long f1633h;
    public long f1634i;
    public Enum f1629d;
    public float f1626a;
    public boolean hidden;
    public float y;
    public float height;
    public String mtext;

    public Transition(float aX, float aY, DirectionState aDmVar, String aStr, boolean aZ) {
        x = aX;
        y = aY;
        mDirection = aDmVar;
        mtext = aStr;
        hidden = aZ;
    }
}
