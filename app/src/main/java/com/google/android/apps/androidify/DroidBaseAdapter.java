package com.google.android.apps.androidify;

import android.content.Context;
import android.graphics.Picture;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.Gallery.LayoutParams;

import java.util.ArrayList;

import dev.game.legend.avatar.R;

public class DroidBaseAdapter extends BaseAdapter {
    private ArrayList f1392a;
    private Androidify f1393b;
    private Picture f1394c;
    private Picture f1395d;
    private Picture f1396e;
    private Picture f1397f;
    private Picture f1398g;
    private Picture f1399h;
    private Gallery f1400i;
    ArrayList mSvgs;
    private Thread mThread;
    private float f1403l;

    public DroidBaseAdapter(Androidify androidify, ArrayList arrayList, Gallery gallery, float f) {
        this.f1393b = androidify;
        this.f1400i = gallery;
        this.f1403l = f;
        AssetDatabase assetDatabase = AssetDatabase.instance((Context) androidify);
        this.f1394c = assetDatabase.getSvgFromResource((int) R.raw.android_body).getPicture();
        this.f1395d = assetDatabase.getSvgFromResource((int) R.raw.android_head).getPicture();
        this.f1396e = assetDatabase.getSvgFromResource((int) R.raw.android_antenna).getPicture();
        this.f1397f = assetDatabase.getSvgFromResource((int) R.raw.android_arm).getPicture();
        this.f1398g = assetDatabase.getSvgFromResource((int) R.raw.android_leg).getPicture();
        this.f1399h = assetDatabase.getSvgFromResource((int) R.raw.android_foot).getPicture();
        this.f1392a = arrayList;
        loadSvgs();
    }

    private void loadSvgs() {
        this.mSvgs = new ArrayList(this.f1392a.size());
        for (int i = 0; i < this.f1392a.size(); i++) {
            DroidView bsVarView = new bs(this.f1393b, this.f1394c, this.f1395d, this.f1397f, this.f1398g, this.f1399h, this.f1396e, i, this.f1403l);
            bsVarView.setLoadingMode(true);
            //this.f1393b.m1372a(bsVarView);
            bsVarView.setName(((AndroidConfig) this.f1392a.get(i)).m1769E());
            bsVarView.setLayoutParams(new LayoutParams(-2, -2));
//            if (i < 3) {
//                this.f1393b.m1373a(bsVarView, (az) this.f1392a.get(i));
//            }
            this.mSvgs.add(bsVarView);
        }
        this.mThread = new Thread(new bd(this));
        this.mThread.setPriority(1);
        this.mThread.start();
    }

    public void setPriority(int i) {
        this.mThread.setPriority(i);
    }

    public void m1870b(int i) {
        ((bs) this.mSvgs.get(i)).m1461a(false);
    }

    public int getCount() {
        return this.f1392a.size();
    }

    public Object getItem(int i) {
        return this.f1392a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return (View) this.mSvgs.get(i);
    }

    public boolean hasStableIds() {
        return false;
    }
}
