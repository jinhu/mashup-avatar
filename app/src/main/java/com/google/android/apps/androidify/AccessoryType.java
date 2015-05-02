package com.google.android.apps.androidify;

public enum AccessoryType {
    NONE(false),
    HAIR(true),
    GLASSES(true),
    BEARD(true),
    SHIRT(false),
    PANTS(false),
    SHOES(false),
    SHIRT_AND_PANTS(false), ;
    
    public boolean enabled;

    AccessoryType(boolean z) {
        this.enabled = z;
    }
}
