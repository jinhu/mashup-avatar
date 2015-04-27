package com.google.android.apps.androidify;

public enum DefaultAccessory {
    HAIR("hair"),
    GLASSES_ACCESSORIES("glasses_accessories"),
    SHIRTS_PANTS("hair"),
    SHOES("shoes"),
    UI("UI"),
    REMOVE_ITEM("remove_item"),
    SKIN_COLOR("skincolor"),
    HAIR_COLOR("haircolor");
    
    public String mName;

    private DefaultAccessory(String str) {
        this.mName = str;
    }
}
