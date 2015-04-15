package com.google.android.apps.androidify;

import android.content.Context;
import android.graphics.Picture;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.Gallery.LayoutParams;
import java.util.ArrayList;

public class bc extends BaseAdapter {
    private ArrayList a;
    private Androidify b;
    private Picture c;
    private Picture d;
    private Picture e;
    private Picture f;
    private Picture g;
    private Picture h;
    private Gallery i;
    private ArrayList j;
    private Thread k;
    private float l;

    public bc(Androidify androidify, ArrayList arrayList, Gallery gallery, float f) {
        this.b = androidify;
        this.i = gallery;
        this.l = f;
        ah a = ah.a((Context) androidify);
        this.c = a.a((int) R.raw.android_body).a;
        this.d = a.a((int) R.raw.android_head).a;
        this.e = a.a((int) R.raw.android_antenna).a;
        this.f = a.a((int) R.raw.android_arm).a;
        this.g = a.a((int) R.raw.android_leg).a;
        this.h = a.a((int) R.raw.android_foot).a;
        this.a = arrayList;
        a();
    }

    private void a() {
        this.j = new ArrayList(this.a.size());
        for (int i = 0; i < this.a.size(); i++) {
            DroidView bsVar = new bs(this.b, this.c, this.d, this.f, this.g, this.h, this.e, i, this.l);
            bsVar.setLoadingMode(true);
            this.b.a(bsVar);
            bsVar.setName(((az) this.a.get(i)).E());
            bsVar.setLayoutParams(new LayoutParams(-2, -2));
            if (i < 3) {
                this.b.a(bsVar, (az) this.a.get(i));
            }
            this.j.add(bsVar);
        }
        this.k = new Thread(new bd(this));
        this.k.setPriority(1);
        this.k.start();
    }

    public void a(int i) {
        this.k.setPriority(i);
    }

    public void b(int i) {
        ((bs) this.j.get(i)).a(false);
    }

    public int getCount() {
        return this.a.size();
    }

    public Object getItem(int i) {
        return this.a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return (View) this.j.get(i);
    }

    public boolean hasStableIds() {
        return false;
    }
}
