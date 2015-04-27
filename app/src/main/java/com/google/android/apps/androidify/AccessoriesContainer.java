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
    
    public SVG f1262n;
    public String f1263o;
    public RectF f1264p;
    public boolean f1265q;
    public boolean f1266r;
    public boolean f1267s;
    public final String f1268t;
    public String f1269u;
    public AndroidViewAdapter mAdapter;
    public boolean f1271w;

    private AccessoriesContainer(String str, boolean z, boolean z2, boolean z3, String str2) {
        this.f1269u = null;
        this.f1271w = false;
        this.f1263o = str;
        this.f1265q = z;
        this.f1266r = z2;
        this.f1267s = z3;
        this.f1268t = str2;
    }
    //AndroidViewAdapter getAdapter(AccessoriesContainer aAccessoriesContainerVar, List list, LayoutInflater layoutInflater, HListView hListView) {

    public AndroidViewAdapter retrieveAdapterFromView(ManiView aManiViewVar) {
        if (this.mAdapter == null) {
            if (this == SKIN) {
                this.mAdapter = aManiViewVar.getAdapter(this, Constants.mSkinColors, aManiViewVar.mLayoutInflater, aManiViewVar.mCategoryView);
            } else if (this == HAIR_COLOR) {
                this.mAdapter = aManiViewVar.getAdapter(this, Constants.af, aManiViewVar.mLayoutInflater, aManiViewVar.mCategoryView);
            } else if (this.f1267s) {
                this.mAdapter = aManiViewVar.getAdapter(this, aManiViewVar.getAccessories(this), aManiViewVar.mLayoutInflater, aManiViewVar.mCategoryView);
            } else {
                this.mAdapter = aManiViewVar.getAdapter(this, aManiViewVar.getAccessories(this, this.f1269u), aManiViewVar.mLayoutInflater, aManiViewVar.mCategoryView);
            }
        }
        return this.mAdapter;
    }

    public void m1744a(RectF rectF) {
        this.f1264p = rectF;
    }

    public void m1745a(SVG aSVG) {
        this.f1262n = aSVG;
    }
}