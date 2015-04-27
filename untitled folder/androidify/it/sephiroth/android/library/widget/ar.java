package it.sephiroth.android.library.widget;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import java.util.ArrayList;
import java.util.Iterator;

public class ar implements Filterable, WrapperListAdapter {
    static final ArrayList f1930c;
    ArrayList f1931a;
    ArrayList f1932b;
    boolean f1933d;
    private final ListAdapter f1934e;
    private final boolean f1935f;

    static {
        f1930c = new ArrayList();
    }

    public ar(ArrayList arrayList, ArrayList arrayList2, ListAdapter listAdapter) {
        this.f1934e = listAdapter;
        this.f1935f = listAdapter instanceof Filterable;
        if (arrayList == null) {
            this.f1931a = f1930c;
        } else {
            this.f1931a = arrayList;
        }
        if (arrayList2 == null) {
            this.f1932b = f1930c;
        } else {
            this.f1932b = arrayList2;
        }
        boolean z = m2341a(this.f1931a) && m2341a(this.f1932b);
        this.f1933d = z;
    }

    private boolean m2341a(ArrayList arrayList) {
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (!((ap) it.next()).f1926c) {
                    return false;
                }
            }
        }
        return true;
    }

    public int m2342a() {
        return this.f1931a.size();
    }

    public boolean areAllItemsEnabled() {
        return this.f1934e != null ? this.f1933d && this.f1934e.areAllItemsEnabled() : true;
    }

    public int m2343b() {
        return this.f1932b.size();
    }

    public int getCount() {
        return this.f1934e != null ? (m2343b() + m2342a()) + this.f1934e.getCount() : m2343b() + m2342a();
    }

    public Filter getFilter() {
        return this.f1935f ? ((Filterable) this.f1934e).getFilter() : null;
    }

    public Object getItem(int i) {
        int a = m2342a();
        if (i < a) {
            return ((ap) this.f1931a.get(i)).f1925b;
        }
        int i2 = i - a;
        a = 0;
        if (this.f1934e != null) {
            a = this.f1934e.getCount();
            if (i2 < a) {
                return this.f1934e.getItem(i2);
            }
        }
        return ((ap) this.f1932b.get(i2 - a)).f1925b;
    }

    public long getItemId(int i) {
        int a = m2342a();
        if (this.f1934e != null && i >= a) {
            a = i - a;
            if (a < this.f1934e.getCount()) {
                return this.f1934e.getItemId(a);
            }
        }
        return -1;
    }

    public int getItemViewType(int i) {
        int a = m2342a();
        if (this.f1934e != null && i >= a) {
            a = i - a;
            if (a < this.f1934e.getCount()) {
                return this.f1934e.getItemViewType(a);
            }
        }
        return -2;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        int a = m2342a();
        if (i < a) {
            return ((ap) this.f1931a.get(i)).f1924a;
        }
        int i2 = i - a;
        a = 0;
        if (this.f1934e != null) {
            a = this.f1934e.getCount();
            if (i2 < a) {
                return this.f1934e.getView(i2, view, viewGroup);
            }
        }
        return ((ap) this.f1932b.get(i2 - a)).f1924a;
    }

    public int getViewTypeCount() {
        return this.f1934e != null ? this.f1934e.getViewTypeCount() : 1;
    }

    public ListAdapter getWrappedAdapter() {
        return this.f1934e;
    }

    public boolean hasStableIds() {
        return this.f1934e != null ? this.f1934e.hasStableIds() : false;
    }

    public boolean isEmpty() {
        return this.f1934e == null || this.f1934e.isEmpty();
    }

    public boolean isEnabled(int i) {
        int a = m2342a();
        if (i < a) {
            return ((ap) this.f1931a.get(i)).f1926c;
        }
        int i2 = i - a;
        a = 0;
        if (this.f1934e != null) {
            a = this.f1934e.getCount();
            if (i2 < a) {
                return this.f1934e.isEnabled(i2);
            }
        }
        return ((ap) this.f1932b.get(i2 - a)).f1926c;
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        if (this.f1934e != null) {
            this.f1934e.registerDataSetObserver(dataSetObserver);
        }
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (this.f1934e != null) {
            this.f1934e.unregisterDataSetObserver(dataSetObserver);
        }
    }
}
