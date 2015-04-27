package com.google.android.apps.androidify;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import dev.game.legend.avatar.R;
import dev.game.legend.svgandroid.SVG;
import it.sephiroth.android.library.widget.HListView;

;

public class AndroidViewAdapter extends BaseAdapter {
    final /* synthetic */ ManiView mMainView;
    LayoutInflater f1273b;
    List f1274c;
     List f1275d;
     List f1276e;
     List f1277f;
     int f1278g;
     HListView f1279h;
     AccessoriesContainer f1280i;

    AndroidViewAdapter(ManiView aManiViewVar) {
        this.mMainView = aManiViewVar;
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
            int i2=1;
            if (this.f1275d == null || this.f1275d.size() <= i || this.f1275d.get(i) == null || !((Boolean) this.f1275d.get(i)).booleanValue()) {
                boolean z = false;
            } else {
                i2 = 1;
            }
            vectorView.setVectors((SVG) this.f1274c.get(i));
            if (i2 != 0) {
                vectorView.setNewBadge(this.mMainView.mSVG);
            }
            vectorView.setDrawBackground(false);
        } else if (this.f1277f != null) {
            this.mMainView.m1712a(this.f1280i, vectorView, this.f1277f, i);
        } else {
            this.mMainView.m1708a(vectorView, this.f1280i, this.f1276e, i);
        }
        vectorView.setTag(Integer.valueOf(i));
        if (this.f1280i != null) {
            vectorView.setSelected(this.mMainView.m1715a(this.f1280i, i));
            if (i == 0) {
                vectorView.setContentDescription("no " + this.f1280i.f1268t);
            } else {
                vectorView.setContentDescription(this.f1280i.f1268t + " " + i);
            }
        } else {
            vectorView.setContentDescription(AccessoriesContainer.values()[i].f1268t);
        }
        return vectorView;
    }
}
