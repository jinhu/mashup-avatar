package com.google.android.apps.androidify;

/* synthetic */ class DirectionConvertor {
    static final /* synthetic */ int[] mState;

    static {
        mState = new int[DirectionState.values().length];
        try {
            mState[DirectionState.LEFT.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            mState[DirectionState.RIGHT.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            mState[DirectionState.UP.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            mState[DirectionState.DOWN.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            mState[DirectionState.DIAG_LEFT.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
    }
}
