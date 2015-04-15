package com.google.android.apps.androidify;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.google.android.apps.b.b;
import it.sephiroth.android.library.widget.HListView;
import java.util.List;

class aw extends BaseAdapter {
    final /* synthetic */ an a;
    private LayoutInflater b;
    private List c;
    private List d;
    private List e;
    private List f;
    private int g;
    private HListView h;
    private av i;

    private aw(an anVar) {
        this.a = anVar;
    }

    public int getCount() {
        return this.g;
    }

    public Object getItem(int i) {
        return this.c.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        VectorView vectorView = view != null ? (VectorView) view : (VectorView) this.b.inflate(R.layout.item_vector, viewGroup, false);
        if (this.c != null) {
            int i2;
            if (this.d == null || this.d.size() <= i || this.d.get(i) == null || !((Boolean) this.d.get(i)).booleanValue()) {
                boolean z = false;
            } else {
                i2 = 1;
            }
            vectorView.setVectors((b) this.c.get(i));
            if (i2 != 0) {
                vectorView.setNewBadge(this.a.o);
            }
            vectorView.setDrawBackground(false);
        } else if (this.f != null) {
            this.a.a(this.i, vectorView, this.f, i);
        } else {
            this.a.a(vectorView, this.i, this.e, i);
        }
        vectorView.setTag(Integer.valueOf(i));
        if (this.i != null) {
            vectorView.setSelected(this.a.a(this.i, i));
            if (i == 0) {
                vectorView.setContentDescription("no " + this.i.t);
            } else {
                vectorView.setContentDescription(this.i.t + " " + i);
            }
        } else {
            vectorView.setContentDescription(av.values()[i].t);
        }
        return vectorView;
    }
}
