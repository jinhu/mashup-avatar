package com.google.android.apps.androidify;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.google.android.apps.p019b.C0249b;
import it.sephiroth.android.library.widget.HListView;
import java.util.List;

class aw extends BaseAdapter {
    final /* synthetic */ an f1272a;
    private LayoutInflater f1273b;
    private List f1274c;
    private List f1275d;
    private List f1276e;
    private List f1277f;
    private int f1278g;
    private HListView f1279h;
    private av f1280i;

    private aw(an anVar) {
        this.f1272a = anVar;
    }

    public int getCount() {
        return this.f1278g;
    }

    public Object getItem(int i) {
        return this.f1274c.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        VectorView vectorView = view != null ? (VectorView) view : (VectorView) this.f1273b.inflate(R.layout.item_vector, viewGroup, false);
        if (this.f1274c != null) {
            int i2;
            if (this.f1275d == null || this.f1275d.size() <= i || this.f1275d.get(i) == null || !((Boolean) this.f1275d.get(i)).booleanValue()) {
                boolean z = false;
            } else {
                i2 = 1;
            }
            vectorView.setVectors((C0249b) this.f1274c.get(i));
            if (i2 != 0) {
                vectorView.setNewBadge(this.f1272a.f1232o);
            }
            vectorView.setDrawBackground(false);
        } else if (this.f1277f != null) {
            this.f1272a.m1712a(this.f1280i, vectorView, this.f1277f, i);
        } else {
            this.f1272a.m1708a(vectorView, this.f1280i, this.f1276e, i);
        }
        vectorView.setTag(Integer.valueOf(i));
        if (this.f1280i != null) {
            vectorView.setSelected(this.f1272a.m1715a(this.f1280i, i));
            if (i == 0) {
                vectorView.setContentDescription("no " + this.f1280i.f1268t);
            } else {
                vectorView.setContentDescription(this.f1280i.f1268t + " " + i);
            }
        } else {
            vectorView.setContentDescription(av.values()[i].f1268t);
        }
        return vectorView;
    }
}
