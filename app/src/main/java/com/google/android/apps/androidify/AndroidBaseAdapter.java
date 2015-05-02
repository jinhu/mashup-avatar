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

import dev.game.legend.avatar.R;

public class AndroidBaseAdapter extends BaseAdapter {
    final int f1436a;
    private final int f1437b;
    private boolean f1438c;
    GaleryInterface f1439d;
    int f1440e;
    View f1441f;
    private ArrayList f1442g;
    private LayoutInflater mLayoutInflater;
    private Context f1444i;
    private List f1445j;
    private long f1446k;

    public AndroidBaseAdapter(Context context, ArrayList arrayList) {
        this.f1438c = false;
        this.f1440e = -1;
        this.f1441f = null;
        this.f1445j = new ArrayList();
        this.f1446k = 0;
        this.f1446k = System.currentTimeMillis();
        Util.debug("Init MotionAdapater");
        this.f1444i = context;
        this.f1442g = arrayList;
        //this.f1443h = (LayoutInflater) context.getSystemService(Context.LAUNCHER_APPS_SERVICE);
        this.f1436a = context.getResources().getColor(R.color.bg_grey);
        m1883a(context, arrayList);
        this.f1437b = context.getResources().getInteger(R.integer.gallery_number_droid_threshold);
        m1880d();
        m1878c();
    }

    private void m1875a(View view, int i, int i2, int i3) {
        DrawView drawView = (DrawView) view.findViewById(i);
        int a = m1881a(i2, i3);
        if (i2 == 0) {
            Util.debug("galdebug " + i3 + " : " + drawView);
        }
        AndroidDrawer c = m1888c(i2, i3);
        if ((a != this.f1440e || c == null) && c != null) {
            drawView.setBackgroundColor(this.f1436a);
        }
        if (c != null) {
            drawView.setVisibility(View.VISIBLE);
            drawView.setDroidDrawer(c);
            drawView.setIndex(i2);
            drawView.m1426a();
            drawView.setOnClickListener(v -> {
                if (a == this.f1440e) {
                    Util.debug("Selecting already selected droid.");
                    if (this.f1439d != null) {
                        this.f1439d.shareAll(i2, i3, this.m1887b(i2, i3));
                        return;
                    }
                    return;
                }
                if (this.f1440e > -1 && this.f1441f != null) {
                    this.f1441f.setBackgroundColor(this.f1436a);
                    Util.debug("galdebug resetting last selected at " + this.f1441f);
                }
                this.f1440e = a;
                this.f1441f = view;
                Util.debug("galdebug last selected now " + this.f1441f);
                view.setBackgroundResource(R.drawable.btn_bg_selected_gallery);
                view.invalidate();
                if (this.f1439d != null) {
                    this.f1439d.shareOnce(i2, i3, this.m1887b(i2, i3));
                }
            });
    } else {
            drawView.setVisibility(View.INVISIBLE);
            drawView.setOnClickListener(null);
        }
        drawView.invalidate();
    }

    private void m1878c() {
        long currentTimeMillis = System.currentTimeMillis();
        Util.debug("Elapsed: " + (currentTimeMillis - this.f1446k));
        this.f1446k = currentTimeMillis;
    }

    private void m1880d() {
        this.f1438c = this.f1442g.size() > this.f1437b;
    }

    public int m1881a(int i, int i2) {
        return this.f1438c ? ((i - 1) * 3) + i2 : i - 1;
    }

    public void m1882a() {
        if (this.f1441f != null) {
            this.f1441f.setBackgroundColor(this.f1436a);
        }
        this.f1440e = -1;
        if (this.f1439d != null) {
            this.f1439d.shareAll();
        }
    }

    public void m1883a(Context context, ArrayList arrayList) {
        this.f1445j.clear();
        AssetDatabase a = AssetDatabase.instance(context);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            AndroidConfig androidConfigVar = (AndroidConfig) it.next();
            AndroidDrawer androidDrawerVar = new AndroidDrawer(context);
            androidDrawerVar.setAndroidConfig(androidConfigVar, a);
            androidDrawerVar.m1848b(0.75f);
            androidDrawerVar.m1834a(0);
            this.f1445j.add(androidDrawerVar);
        }
    }

    public void m1884a(GaleryInterface aGaleryInterfaceVar) {
        this.f1439d = aGaleryInterfaceVar;
    }

    public void m1885a(ArrayList arrayList) {
        this.f1442g = arrayList;
        m1880d();
        m1883a(this.f1444i, arrayList);
        m1882a();
        notifyDataSetChanged();
    }

    public int m1886b() {
        return this.f1440e;
    }

    public AndroidConfig m1887b(int i, int i2) {
        int a = m1881a(i, i2);
        return a > this.f1442g.size() + -1 ? null : (AndroidConfig) this.f1442g.get(a);
    }

    public AndroidDrawer m1888c(int i, int i2) {
        int a = m1881a(i, i2);
        return a > this.f1445j.size() + -1 ? null : (AndroidDrawer) this.f1445j.get(a);
    }

    public int getCount() {
        return this.f1438c ? ((int) Math.ceil((double) (((float) this.f1442g.size()) / 3.0f))) + 1 : this.f1442g.size() + 1;
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        return i == 0 ? 0 : this.f1438c ? ((i - 1) % 2) + 1 : 1;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        Util.debug("Get view for position " + i + ", type=" + itemViewType);
        if (view == null) {
            if (itemViewType == 0) {
                Util.debug("New view type 0");
                view = this.mLayoutInflater.inflate(R.layout.btn_add_gallery, null);
                if (!this.f1438c) {
                    View findViewById = view.findViewById(R.id.ll_add_button_container);
                    LayoutParams layoutParams = findViewById.getLayoutParams();
                    layoutParams.height = (int) this.f1444i.getResources().getDimension(R.dimen.gallery_grid_height_smaller);
                    findViewById.setLayoutParams(layoutParams);
                    view.requestLayout();
                }
                view.setOnClickListener(v -> {
                    if (this.f1439d != null) {
                        this.f1439d.shareOnce();
                    }
                });
            } else if (!this.f1438c) {
                view = this.mLayoutInflater.inflate(R.layout.griditem_gallery_single, null);
                m1875a(view, R.id.dv_android1, i, 0);
            } else if (itemViewType == 1) {
                Util.debug("New view type 1");
                view = this.mLayoutInflater.inflate(R.layout.griditem_gallery, null);
            } else {
                Util.debug("New view type 2");
                view = this.mLayoutInflater.inflate(R.layout.griditem_gallery_bigbottom, null);
            }
        }
        if (itemViewType > 0 && this.f1438c) {
            m1875a(view, R.id.dv_android1, i, 0);
            m1875a(view, R.id.dv_android2, i, 1);
            m1875a(view, R.id.dv_android3, i, 2);
        }
        m1878c();
        return view;
    }

    public int getViewTypeCount() {
        return this.f1438c ? 3 : 2;
    }
}
