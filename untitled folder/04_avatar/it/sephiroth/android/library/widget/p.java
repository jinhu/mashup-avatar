package it.sephiroth.android.library.widget;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.support.v4.c.n;
import android.view.View;
import java.util.ArrayList;

public class p {
    final /* synthetic */ AbsHListView a;
    private q b;
    private int c;
    private View[] d;
    private ArrayList[] e;
    private int f;
    private ArrayList g;
    private ArrayList h;
    private n i;

    public p(AbsHListView absHListView) {
        this.a = absHListView;
        this.d = new View[0];
    }

    @SuppressLint({"NewApi"})
    private void f() {
        int i = 0;
        int length = this.d.length;
        int i2 = this.f;
        ArrayList[] arrayListArr = this.e;
        for (int i3 = 0; i3 < i2; i3++) {
            ArrayList arrayList = arrayListArr[i3];
            int size = arrayList.size();
            int i4 = size - length;
            size--;
            int i5 = 0;
            while (i5 < i4) {
                int i6 = size - 1;
                this.a.removeDetachedView((View) arrayList.remove(size), false);
                i5++;
                size = i6;
            }
        }
        if (this.i != null) {
            while (i < this.i.b()) {
                if (!((View) this.i.c(i)).hasTransientState()) {
                    this.i.a(i);
                    i--;
                }
                i++;
            }
        }
    }

    public void a() {
        int i;
        int i2 = 0;
        int size;
        if (this.f == 1) {
            ArrayList arrayList = this.g;
            size = arrayList.size();
            for (i = 0; i < size; i++) {
                ((View) arrayList.get(i)).forceLayout();
            }
        } else {
            size = this.f;
            for (int i3 = 0; i3 < size; i3++) {
                ArrayList arrayList2 = this.e[i3];
                int size2 = arrayList2.size();
                for (i = 0; i < size2; i++) {
                    ((View) arrayList2.get(i)).forceLayout();
                }
            }
        }
        if (this.i != null) {
            i = this.i.b();
            while (i2 < i) {
                ((View) this.i.c(i2)).forceLayout();
                i2++;
            }
        }
    }

    public void a(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
        }
        ArrayList[] arrayListArr = new ArrayList[i];
        for (int i2 = 0; i2 < i; i2++) {
            arrayListArr[i2] = new ArrayList();
        }
        this.f = i;
        this.g = arrayListArr[0];
        this.e = arrayListArr;
    }

    public void a(int i, int i2) {
        if (this.d.length < i) {
            this.d = new View[i];
        }
        this.c = i2;
        View[] viewArr = this.d;
        for (int i3 = 0; i3 < i; i3++) {
            View childAt = this.a.getChildAt(i3);
            i iVar = (i) childAt.getLayoutParams();
            if (!(iVar == null || iVar.a == -2)) {
                viewArr[i3] = childAt;
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void a(View view, int i) {
        i iVar = (i) view.getLayoutParams();
        if (iVar != null) {
            iVar.d = i;
            int i2 = iVar.a;
            boolean hasTransientState = VERSION.SDK_INT >= 16 ? view.hasTransientState() : false;
            if (!b(i2) || hasTransientState) {
                if (i2 != -2 || hasTransientState) {
                    if (this.h == null) {
                        this.h = new ArrayList();
                    }
                    this.h.add(view);
                }
                if (hasTransientState) {
                    if (this.i == null) {
                        this.i = new n();
                    }
                    view.onStartTemporaryDetach();
                    this.i.b(i, view);
                    return;
                }
                return;
            }
            view.onStartTemporaryDetach();
            if (this.f == 1) {
                this.g.add(view);
            } else {
                this.e[i2].add(view);
            }
            if (VERSION.SDK_INT >= 14) {
                view.setAccessibilityDelegate(null);
            }
            if (this.b != null) {
                this.b.a(view);
            }
        }
    }

    public void b() {
        int size;
        int i;
        if (this.f == 1) {
            ArrayList arrayList = this.g;
            size = arrayList.size();
            for (i = 0; i < size; i++) {
                this.a.removeDetachedView((View) arrayList.remove((size - 1) - i), false);
            }
        } else {
            size = this.f;
            for (int i2 = 0; i2 < size; i2++) {
                ArrayList arrayList2 = this.e[i2];
                int size2 = arrayList2.size();
                for (i = 0; i < size2; i++) {
                    this.a.removeDetachedView((View) arrayList2.remove((size2 - 1) - i), false);
                }
            }
        }
        if (this.i != null) {
            this.i.c();
        }
    }

    public boolean b(int i) {
        return i >= 0;
    }

    public View c(int i) {
        int i2 = i - this.c;
        View[] viewArr = this.d;
        if (i2 < 0 || i2 >= viewArr.length) {
            return null;
        }
        View view = viewArr[i2];
        viewArr[i2] = null;
        return view;
    }

    void c() {
        if (this.i != null) {
            this.i.c();
        }
    }

    View d(int i) {
        if (this.i == null) {
            return null;
        }
        int d = this.i.d(i);
        if (d < 0) {
            return null;
        }
        View view = (View) this.i.c(d);
        this.i.a(d);
        return view;
    }

    public void d() {
        if (this.h != null) {
            int size = this.h.size();
            for (int i = 0; i < size; i++) {
                this.a.removeDetachedView((View) this.h.get(i), false);
            }
            this.h.clear();
        }
    }

    View e(int i) {
        if (this.f == 1) {
            return AbsHListView.a(this.g, i);
        }
        int itemViewType = this.a.j.getItemViewType(i);
        return (itemViewType < 0 || itemViewType >= this.e.length) ? null : AbsHListView.a(this.e[itemViewType], i);
    }

    @SuppressLint({"NewApi"})
    public void e() {
        View[] viewArr = this.d;
        boolean z = this.b != null;
        boolean z2 = this.f > 1;
        ArrayList arrayList = this.g;
        for (int length = viewArr.length - 1; length >= 0; length--) {
            View view = viewArr[length];
            if (view != null) {
                i iVar = (i) view.getLayoutParams();
                int i = iVar.a;
                viewArr[length] = null;
                boolean hasTransientState = VERSION.SDK_INT >= 16 ? view.hasTransientState() : false;
                if (!b(i) || hasTransientState) {
                    if (i != -2 || hasTransientState) {
                        this.a.removeDetachedView(view, false);
                    }
                    if (hasTransientState) {
                        if (this.i == null) {
                            this.i = new n();
                        }
                        this.i.b(this.c + length, view);
                    }
                } else {
                    ArrayList arrayList2 = z2 ? this.e[i] : arrayList;
                    view.onStartTemporaryDetach();
                    iVar.d = this.c + length;
                    arrayList2.add(view);
                    if (VERSION.SDK_INT >= 14) {
                        view.setAccessibilityDelegate(null);
                    }
                    if (z) {
                        this.b.a(view);
                    }
                    arrayList = arrayList2;
                }
            }
        }
        f();
    }

    void f(int i) {
        int i2;
        int size;
        int i3;
        if (this.f == 1) {
            ArrayList arrayList = this.g;
            size = arrayList.size();
            for (i3 = 0; i3 < size; i3++) {
                ((View) arrayList.get(i3)).setDrawingCacheBackgroundColor(i);
            }
        } else {
            size = this.f;
            for (i2 = 0; i2 < size; i2++) {
                ArrayList arrayList2 = this.e[i2];
                int size2 = arrayList2.size();
                for (i3 = 0; i3 < size2; i3++) {
                    ((View) arrayList2.get(i3)).setDrawingCacheBackgroundColor(i);
                }
            }
        }
        for (View view : this.d) {
            if (view != null) {
                view.setDrawingCacheBackgroundColor(i);
            }
        }
    }
}
