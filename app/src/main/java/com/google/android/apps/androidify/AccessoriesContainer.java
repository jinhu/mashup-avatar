package com.google.android.apps.androidify;

import android.graphics.RectF;

import dev.game.legend.svgandroid.SVG;

public enum AccessoriesContainer {
    SKIN(null, false, false, false, "skin"),
    SHIRT("shirt", false, true, false, "shirt"),
    PANTS("pants", false, false, false, "pants"),
    SHOES("shoes", false, false, false, "shoes"),
    HAIR("hair", true, false, false, "hair"),
    HAIR_COLOR(null, true, false, false, "hair color"),
    BEARD("beard", true, false, false, "beard"),
    NBA("shirt", false, true, false, "NBA"),
    GLASSES("glasses", true, false, false, "glasses"),
    HAT("hat", true, false, true, "hat"),
    FACE("face", true, false, true, "face"),
    BODY("body", false, true, true, "body"),
    HAND("hand", false, false, true, "hand");
    
    public SVG mSVG;
    public String mString;
    public RectF mRectF;
    public boolean bool1;
    public boolean bool2;
    public boolean bool3;
    public final String mString2;
    public String mString3;
    public AndroidViewAdapter mAdapter;
    public boolean bool4;

    AccessoriesContainer(String str, boolean z, boolean z2, boolean z3, String str2) {
        this.mString3 = null;
        this.bool4 = false;
        this.mString = str;
        this.bool1 = z;
        this.bool2 = z2;
        this.bool3 = z3;
        this.mString2 = str2;
    }
    //AndroidViewAdapter getAdapter(AccessoriesContainer aAccessoriesContainerVar, List list, LayoutInflater layoutInflater, HListView hListView) {

    public AndroidViewAdapter retrieveAdapterFromView(ManiView aManiViewVar) {
        if (this.mAdapter == null) {
            if (this == SKIN) {
                this.mAdapter = aManiViewVar.getAdapter(this, Constants.mSkinColors, aManiViewVar.mLayoutInflater, aManiViewVar.mCategoryView);
            } else if (this == HAIR_COLOR) {
                this.mAdapter = aManiViewVar.getAdapter(this, Constants.af, aManiViewVar.mLayoutInflater, aManiViewVar.mCategoryView);
            } else if (this.bool3) {
                this.mAdapter = aManiViewVar.getAdapter(this, aManiViewVar.getAccessories(this), aManiViewVar.mLayoutInflater, aManiViewVar.mCategoryView);
            } else {
                this.mAdapter = aManiViewVar.getAdapter(this, aManiViewVar.getAccessories(this, this.mString3), aManiViewVar.mLayoutInflater, aManiViewVar.mCategoryView);
            }
        }
        return this.mAdapter;
    }

    public void setRect(RectF rectF) {
        this.mRectF = rectF;
    }

    public void setSvg(SVG aSVG) {
        this.mSVG = aSVG;
    }
}
