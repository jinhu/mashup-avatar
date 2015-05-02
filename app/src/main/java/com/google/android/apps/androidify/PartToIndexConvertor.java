package com.google.android.apps.androidify;

/* synthetic */ class PartToIndexConvertor {
    static final /* synthetic */ int[] mAccessoryType;
    static final /* synthetic */ int[] mBaseType;

    static {
        mBaseType = new int[PartType.values().length];
        try {
            mBaseType[PartType.HEAD.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            mBaseType[PartType.BODY.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            mBaseType[PartType.ARM.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            mBaseType[PartType.LEG.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        mAccessoryType = new int[AccessoryType.values().length];
        try {
            mAccessoryType[AccessoryType.BEARD.ordinal()] = 1;
        } catch (NoSuchFieldError e5) {
        }
        try {
            mAccessoryType[AccessoryType.GLASSES.ordinal()] = 2;
        } catch (NoSuchFieldError e6) {
        }
        try {
            mAccessoryType[AccessoryType.HAIR.ordinal()] = 3;
        } catch (NoSuchFieldError e7) {
        }
        try {
            mAccessoryType[AccessoryType.PANTS.ordinal()] = 4;
        } catch (NoSuchFieldError e8) {
        }
        try {
            mAccessoryType[AccessoryType.SHIRT.ordinal()] = 5;
        } catch (NoSuchFieldError e9) {
        }
        try {
            mAccessoryType[AccessoryType.SHOES.ordinal()] = 6;
        } catch (NoSuchFieldError e10) {
        }
    }
}
