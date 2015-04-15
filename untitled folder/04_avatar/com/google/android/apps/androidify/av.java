package com.google.android.apps.androidify;

import android.graphics.RectF;
import com.google.android.apps.b.b;

public enum av {
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
    
    public b n;
    public String o;
    public RectF p;
    public boolean q;
    public boolean r;
    public boolean s;
    public final String t;
    public String u;
    public aw v;
    public boolean w;

    private av(String str, boolean z, boolean z2, boolean z3, String str2) {
        this.u = null;
        this.w = false;
        this.o = str;
        this.q = z;
        this.r = z2;
        this.s = z3;
        this.t = str2;
    }

    public aw a(an anVar) {
        if (this.v == null) {
            if (this == SKIN) {
                this.v = anVar.a(this, al.ai, anVar.j, anVar.g);
            } else if (this == HAIR_COLOR) {
                this.v = anVar.a(this, al.af, anVar.j, anVar.g);
            } else if (this.s) {
                this.v = anVar.a(this, anVar.b(this), anVar.j, anVar.g);
            } else {
                this.v = anVar.a(this, anVar.a(this, this.u), anVar.j, anVar.g);
            }
        }
        return this.v;
    }

    public void a(RectF rectF) {
        this.p = rectF;
    }

    public void a(b bVar) {
        this.n = bVar;
    }
}
