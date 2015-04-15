package com.google.android.apps.androidify;

public enum bh {
    NONE(false),
    HAIR(true),
    GLASSES(true),
    BEARD(true),
    SHIRT(false),
    PANTS(false),
    SHOES(false),
    SHIRT_AND_PANTS(false);
    
    public boolean i;

    private bh(boolean z) {
        this.i = z;
    }
}
