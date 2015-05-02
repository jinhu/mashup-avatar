package com.google.android.apps.androidify;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import dev.game.legend.avatar.R;
import dev.game.legend.svgandroid.SVG;
import it.sephiroth.android.library.widget.HListView;

public class AndroidViewAdapter extends BaseAdapter {
    final /* synthetic */ ManiView mMainView;
    LayoutInflater f1273b;
    List mList1;
     List mList2;
     List mList3;
     List mList4;
     int f1278g;
     HListView mHlistView;
     AccessoriesContainer mAccessoryTypeContainer;

    AndroidViewAdapter(ManiView aManiViewVar){
        this.mMainView = aManiViewVar;
    }

    public int getCount() {
        return this.f1278g;
    }

    public Object getItem(int i) {
        return this.mList1.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        VectorView vectorView = view != null ? (VectorView) view : (VectorView) this.f1273b.inflate(R.layout.item_vector, viewGroup, false);
        vectorView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        if (this.mList1 != null) {
            int i2=1;
            if (this.mList2 == null || this.mList2.size() <= i || this.mList2.get(i) == null || !((Boolean) this.mList2.get(i)).booleanValue()) {
                boolean z = false;
            } else {
                i2 = 1;
            }
            vectorView.setVectors((SVG) this.mList1.get(i));
            if (i2 != 0) {
                vectorView.setNewBadge(this.mMainView.mSVG);
            }
            vectorView.setDrawBackground(false);
        } else if (this.mList4 != null) {
            this.mMainView.m1712a(this.mAccessoryTypeContainer, vectorView, this.mList4, i);
        } else {
            this.mMainView.m1708a(vectorView, this.mAccessoryTypeContainer, this.mList3, i);
        }
        vectorView.setTag(Integer.valueOf(i));
        if (this.mAccessoryTypeContainer != null) {
            vectorView.setSelected(this.mMainView.selectCategory(this.mAccessoryTypeContainer, i));
            if (i == 0) {
                vectorView.setContentDescription("no " + this.mAccessoryTypeContainer.mString2);
            } else {
                vectorView.setContentDescription(this.mAccessoryTypeContainer.mString2 + " " + i);
            }
        } else {
            vectorView.setContentDescription(AccessoriesContainer.values()[i].mString2);
        }
        return vectorView;
    }
}
