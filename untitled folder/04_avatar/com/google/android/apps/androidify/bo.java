package com.google.android.apps.androidify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bo extends BaseAdapter {
    private final int a;
    private final int b;
    private boolean c;
    private br d;
    private int e;
    private View f;
    private ArrayList g;
    private final LayoutInflater h;
    private Context i;
    private List j;
    private long k;

    public bo(Context context, ArrayList arrayList) {
        this.c = false;
        this.e = -1;
        this.f = null;
        this.j = new ArrayList();
        this.k = 0;
        this.k = System.currentTimeMillis();
        c.a("Init MotionAdapater");
        this.i = context;
        this.g = arrayList;
        this.h = (LayoutInflater) context.getSystemService("layout_inflater");
        this.a = context.getResources().getColor(R.color.bg_grey);
        a(context, arrayList);
        this.b = context.getResources().getInteger(R.integer.gallery_number_droid_threshold);
        d();
        c();
    }

    private void a(View view, int i, int i2, int i3) {
        DrawView drawView = (DrawView) view.findViewById(i);
        int a = a(i2, i3);
        if (i2 == 0) {
            c.a("galdebug " + i3 + " : " + drawView);
        }
        ba c = c(i2, i3);
        if ((a != this.e || c == null) && c != null) {
            drawView.setBackgroundColor(this.a);
        }
        if (c != null) {
            drawView.setVisibility(0);
            drawView.setDroidDrawer(c);
            drawView.setIndex(i2);
            drawView.a();
            drawView.setOnClickListener(new bq(this, a, i2, i3));
        } else {
            drawView.setVisibility(4);
            drawView.setOnClickListener(null);
        }
        drawView.invalidate();
    }

    private void c() {
        long currentTimeMillis = System.currentTimeMillis();
        c.a("Elapsed: " + (currentTimeMillis - this.k));
        this.k = currentTimeMillis;
    }

    private void d() {
        this.c = this.g.size() > this.b;
    }

    public int a(int i, int i2) {
        return this.c ? ((i - 1) * 3) + i2 : i - 1;
    }

    public void a() {
        if (this.f != null) {
            this.f.setBackgroundColor(this.a);
        }
        this.e = -1;
        if (this.d != null) {
            this.d.b();
        }
    }

    public void a(Context context, ArrayList arrayList) {
        this.j.clear();
        ah a = ah.a(context);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            az azVar = (az) it.next();
            ba baVar = new ba(context);
            baVar.a(azVar, a);
            baVar.b(0.75f);
            baVar.a(0);
            this.j.add(baVar);
        }
    }

    public void a(br brVar) {
        this.d = brVar;
    }

    public void a(ArrayList arrayList) {
        this.g = arrayList;
        d();
        a(this.i, arrayList);
        a();
        notifyDataSetChanged();
    }

    public int b() {
        return this.e;
    }

    public az b(int i, int i2) {
        int a = a(i, i2);
        return a > this.g.size() + -1 ? null : (az) this.g.get(a);
    }

    public ba c(int i, int i2) {
        int a = a(i, i2);
        return a > this.j.size() + -1 ? null : (ba) this.j.get(a);
    }

    public int getCount() {
        return this.c ? ((int) Math.ceil((double) (((float) this.g.size()) / 3.0f))) + 1 : this.g.size() + 1;
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        return i == 0 ? 0 : this.c ? ((i - 1) % 2) + 1 : 1;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        c.a("Get view for position " + i + ", type=" + itemViewType);
        if (view == null) {
            if (itemViewType == 0) {
                c.a("New view type 0");
                view = this.h.inflate(R.layout.btn_add_gallery, null);
                if (!this.c) {
                    View findViewById = view.findViewById(R.id.ll_add_button_container);
                    LayoutParams layoutParams = findViewById.getLayoutParams();
                    layoutParams.height = (int) this.i.getResources().getDimension(R.dimen.gallery_grid_height_smaller);
                    findViewById.setLayoutParams(layoutParams);
                    view.requestLayout();
                }
                view.setOnClickListener(new bp(this));
            } else if (!this.c) {
                view = this.h.inflate(R.layout.griditem_gallery_single, null);
                a(view, R.id.dv_android1, i, 0);
            } else if (itemViewType == 1) {
                c.a("New view type 1");
                view = this.h.inflate(R.layout.griditem_gallery, null);
            } else {
                c.a("New view type 2");
                view = this.h.inflate(R.layout.griditem_gallery_bigbottom, null);
            }
        }
        if (itemViewType > 0 && this.c) {
            a(view, R.id.dv_android1, i, 0);
            a(view, R.id.dv_android2, i, 1);
            a(view, R.id.dv_android3, i, 2);
        }
        c();
        return view;
    }

    public int getViewTypeCount() {
        return this.c ? 3 : 2;
    }
}
