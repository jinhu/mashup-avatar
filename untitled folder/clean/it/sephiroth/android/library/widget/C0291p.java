package it.sephiroth.android.library.widget;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.support.v4.p002c.C0046n;
import android.view.View;
import java.util.ArrayList;

/* renamed from: it.sephiroth.android.library.widget.p */
public class C0291p {
    final /* synthetic */ AbsHListView f1996a;
    private C0292q f1997b;
    private int f1998c;
    private View[] f1999d;
    private ArrayList[] f2000e;
    private int f2001f;
    private ArrayList f2002g;
    private ArrayList f2003h;
    private C0046n f2004i;

    public C0291p(AbsHListView absHListView) {
        this.f1996a = absHListView;
        this.f1999d = new View[0];
    }

    @SuppressLint({"NewApi"})
    private void m2401f() {
        int i = 0;
        int length = this.f1999d.length;
        int i2 = this.f2001f;
        ArrayList[] arrayListArr = this.f2000e;
        for (int i3 = 0; i3 < i2; i3++) {
            ArrayList arrayList = arrayListArr[i3];
            int size = arrayList.size();
            int i4 = size - length;
            size--;
            int i5 = 0;
            while (i5 < i4) {
                int i6 = size - 1;
                this.f1996a.removeDetachedView((View) arrayList.remove(size), false);
                i5++;
                size = i6;
            }
        }
        if (this.f2004i != null) {
            while (i < this.f2004i.m265b()) {
                if (!((View) this.f2004i.m268c(i)).hasTransientState()) {
                    this.f2004i.m264a(i);
                    i--;
                }
                i++;
            }
        }
    }

    public void m2402a() {
        int i;
        int i2 = 0;
        int size;
        if (this.f2001f == 1) {
            ArrayList arrayList = this.f2002g;
            size = arrayList.size();
            for (i = 0; i < size; i++) {
                ((View) arrayList.get(i)).forceLayout();
            }
        } else {
            size = this.f2001f;
            for (int i3 = 0; i3 < size; i3++) {
                ArrayList arrayList2 = this.f2000e[i3];
                int size2 = arrayList2.size();
                for (i = 0; i < size2; i++) {
                    ((View) arrayList2.get(i)).forceLayout();
                }
            }
        }
        if (this.f2004i != null) {
            i = this.f2004i.m265b();
            while (i2 < i) {
                ((View) this.f2004i.m268c(i2)).forceLayout();
                i2++;
            }
        }
    }

    public void m2403a(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
        }
        ArrayList[] arrayListArr = new ArrayList[i];
        for (int i2 = 0; i2 < i; i2++) {
            arrayListArr[i2] = new ArrayList();
        }
        this.f2001f = i;
        this.f2002g = arrayListArr[0];
        this.f2000e = arrayListArr;
    }

    public void m2404a(int i, int i2) {
        if (this.f1999d.length < i) {
            this.f1999d = new View[i];
        }
        this.f1998c = i2;
        View[] viewArr = this.f1999d;
        for (int i3 = 0; i3 < i; i3++) {
            View childAt = this.f1996a.getChildAt(i3);
            C0284i c0284i = (C0284i) childAt.getLayoutParams();
            if (!(c0284i == null || c0284i.f1975a == -2)) {
                viewArr[i3] = childAt;
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void m2405a(View view, int i) {
        C0284i c0284i = (C0284i) view.getLayoutParams();
        if (c0284i != null) {
            c0284i.f1978d = i;
            int i2 = c0284i.f1975a;
            boolean hasTransientState = VERSION.SDK_INT >= 16 ? view.hasTransientState() : false;
            if (!m2407b(i2) || hasTransientState) {
                if (i2 != -2 || hasTransientState) {
                    if (this.f2003h == null) {
                        this.f2003h = new ArrayList();
                    }
                    this.f2003h.add(view);
                }
                if (hasTransientState) {
                    if (this.f2004i == null) {
                        this.f2004i = new C0046n();
                    }
                    view.onStartTemporaryDetach();
                    this.f2004i.m267b(i, view);
                    return;
                }
                return;
            }
            view.onStartTemporaryDetach();
            if (this.f2001f == 1) {
                this.f2002g.add(view);
            } else {
                this.f2000e[i2].add(view);
            }
            if (VERSION.SDK_INT >= 14) {
                view.setAccessibilityDelegate(null);
            }
            if (this.f1997b != null) {
                this.f1997b.m2415a(view);
            }
        }
    }

    public void m2406b() {
        int size;
        int i;
        if (this.f2001f == 1) {
            ArrayList arrayList = this.f2002g;
            size = arrayList.size();
            for (i = 0; i < size; i++) {
                this.f1996a.removeDetachedView((View) arrayList.remove((size - 1) - i), false);
            }
        } else {
            size = this.f2001f;
            for (int i2 = 0; i2 < size; i2++) {
                ArrayList arrayList2 = this.f2000e[i2];
                int size2 = arrayList2.size();
                for (i = 0; i < size2; i++) {
                    this.f1996a.removeDetachedView((View) arrayList2.remove((size2 - 1) - i), false);
                }
            }
        }
        if (this.f2004i != null) {
            this.f2004i.m269c();
        }
    }

    public boolean m2407b(int i) {
        return i >= 0;
    }

    public View m2408c(int i) {
        int i2 = i - this.f1998c;
        View[] viewArr = this.f1999d;
        if (i2 < 0 || i2 >= viewArr.length) {
            return null;
        }
        View view = viewArr[i2];
        viewArr[i2] = null;
        return view;
    }

    void m2409c() {
        if (this.f2004i != null) {
            this.f2004i.m269c();
        }
    }

    View m2410d(int i) {
        if (this.f2004i == null) {
            return null;
        }
        int d = this.f2004i.m271d(i);
        if (d < 0) {
            return null;
        }
        View view = (View) this.f2004i.m268c(d);
        this.f2004i.m264a(d);
        return view;
    }

    public void m2411d() {
        if (this.f2003h != null) {
            int size = this.f2003h.size();
            for (int i = 0; i < size; i++) {
                this.f1996a.removeDetachedView((View) this.f2003h.get(i), false);
            }
            this.f2003h.clear();
        }
    }

    View m2412e(int i) {
        if (this.f2001f == 1) {
            return AbsHListView.m2161a(this.f2002g, i);
        }
        int itemViewType = this.f1996a.f1878j.getItemViewType(i);
        return (itemViewType < 0 || itemViewType >= this.f2000e.length) ? null : AbsHListView.m2161a(this.f2000e[itemViewType], i);
    }

    @SuppressLint({"NewApi"})
    public void m2413e() {
        View[] viewArr = this.f1999d;
        boolean z = this.f1997b != null;
        boolean z2 = this.f2001f > 1;
        ArrayList arrayList = this.f2002g;
        for (int length = viewArr.length - 1; length >= 0; length--) {
            View view = viewArr[length];
            if (view != null) {
                C0284i c0284i = (C0284i) view.getLayoutParams();
                int i = c0284i.f1975a;
                viewArr[length] = null;
                boolean hasTransientState = VERSION.SDK_INT >= 16 ? view.hasTransientState() : false;
                if (!m2407b(i) || hasTransientState) {
                    if (i != -2 || hasTransientState) {
                        this.f1996a.removeDetachedView(view, false);
                    }
                    if (hasTransientState) {
                        if (this.f2004i == null) {
                            this.f2004i = new C0046n();
                        }
                        this.f2004i.m267b(this.f1998c + length, view);
                    }
                } else {
                    ArrayList arrayList2 = z2 ? this.f2000e[i] : arrayList;
                    view.onStartTemporaryDetach();
                    c0284i.f1978d = this.f1998c + length;
                    arrayList2.add(view);
                    if (VERSION.SDK_INT >= 14) {
                        view.setAccessibilityDelegate(null);
                    }
                    if (z) {
                        this.f1997b.m2415a(view);
                    }
                    arrayList = arrayList2;
                }
            }
        }
        m2401f();
    }

    void m2414f(int i) {
        int size;
        int i2;
        if (this.f2001f == 1) {
            ArrayList arrayList = this.f2002g;
            size = arrayList.size();
            for (i2 = 0; i2 < size; i2++) {
                ((View) arrayList.get(i2)).setDrawingCacheBackgroundColor(i);
            }
        } else {
            size = this.f2001f;
            int i3;
            for (i3 = 0; i3 < size; i3++) {
                ArrayList arrayList2 = this.f2000e[i3];
                int size2 = arrayList2.size();
                for (i2 = 0; i2 < size2; i2++) {
                    ((View) arrayList2.get(i2)).setDrawingCacheBackgroundColor(i);
                }
            }
        }
        for (View view : this.f1999d) {
            if (view != null) {
                view.setDrawingCacheBackgroundColor(i);
            }
        }
    }
}
