package it.sephiroth.android.library.widget;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Gravity;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ExpandableListAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;

public class ExpandableHListView extends HListView {
    private static final int[] aI;
    private static final int[] aJ;
    private static final int[] aK;
    private static final int[] aL;
    private static final int[][] aM;
    private static final int[] aN;
    private int aA;
    private int aB;
    private int aC;
    private int aD;
    private int aE;
    private int aF;
    private Drawable aG;
    private Drawable aH;
    private Drawable aO;
    private final Rect aP;
    private final Rect aQ;
    private int aR;
    private int aS;
    private int aT;
    private int aU;
    private ak aV;
    private al aW;
    private aj aX;
    private ai aY;
    private ExpandableHListConnector ay;
    private ExpandableListAdapter az;

    class SavedState extends BaseSavedState {
        public static final Creator CREATOR;
        ArrayList f1904a;

        static {
            CREATOR = new am();
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f1904a = new ArrayList();
            parcel.readList(this.f1904a, ExpandableHListConnector.class.getClassLoader());
        }

        SavedState(Parcelable parcelable, ArrayList arrayList) {
            super(parcelable);
            this.f1904a = arrayList;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.f1904a);
        }
    }

    static {
        aI = new int[0];
        aJ = new int[]{16842920};
        aK = new int[]{16842921};
        aL = new int[]{16842920, 16842921};
        aM = new int[][]{aI, aJ, aK, aL};
        aN = new int[]{16842918};
    }

    public static int m2301a(long j) {
        return j == 4294967295L ? 2 : (j & Long.MIN_VALUE) == Long.MIN_VALUE ? 1 : 0;
    }

    private long m2302a(af afVar) {
        return afVar.f1918d == 1 ? this.az.getChildId(afVar.f1915a, afVar.f1916b) : this.az.getGroupId(afVar.f1915a);
    }

    private Drawable m2303a(ae aeVar) {
        int i = 1;
        int i2 = 0;
        if (aeVar.f1911a.f1918d == 2) {
            Drawable drawable = this.aG;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            int i3 = (aeVar.f1912b == null || aeVar.f1912b.f1896b == aeVar.f1912b.f1895a) ? 1 : 0;
            if (!aeVar.m2324b()) {
                i = 0;
            }
            if (i3 != 0) {
                i2 = 2;
            }
            drawable.setState(aM[i | i2]);
            return drawable;
        }
        Drawable drawable2 = this.aH;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(aeVar.f1911a.f1917c == aeVar.f1912b.f1896b ? aN : aI);
        }
        return drawable2;
    }

    public static int m2304b(long j) {
        return j == 4294967295L ? -1 : (int) ((9223372032559808512L & j) >> 32);
    }

    public static int m2305c(long j) {
        return (j != 4294967295L && (j & Long.MIN_VALUE) == Long.MIN_VALUE) ? (int) (j & 4294967295L) : -1;
    }

    private boolean m2306m(int i) {
        return i < getHeaderViewsCount() || i >= this.an - getFooterViewsCount();
    }

    private int m2307n(int i) {
        return i - getHeaderViewsCount();
    }

    private int m2308o(int i) {
        return getHeaderViewsCount() + i;
    }

    private void m2309y() {
        if (this.aG != null) {
            this.aR = this.aG.getIntrinsicWidth();
            this.aS = this.aG.getIntrinsicHeight();
            return;
        }
        this.aR = 0;
        this.aS = 0;
    }

    private void m2310z() {
        if (this.aH != null) {
            this.aT = this.aH.getIntrinsicWidth();
            this.aU = this.aH.getIntrinsicHeight();
            return;
        }
        this.aT = 0;
        this.aU = 0;
    }

    void m2311a(Canvas canvas, Rect rect, int i) {
        int i2 = this.V + i;
        if (i2 >= 0) {
            ae a = this.ay.m2237a(m2307n(i2));
            if (a.f1911a.f1918d == 1 || (a.m2324b() && a.f1912b.f1896b != a.f1912b.f1895a)) {
                Drawable drawable = this.aO;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                a.m2323a();
                return;
            }
            a.m2323a();
        }
        super.m2283a(canvas, rect, i2);
    }

    public boolean m2312a(View view, int i, long j) {
        return m2306m(i) ? super.m2202a(view, i, j) : m2314d(view, m2307n(i), j);
    }

    ContextMenuInfo m2313b(View view, int i, long j) {
        if (m2306m(i)) {
            return new C0296w(view, i, j);
        }
        ae a = this.ay.m2237a(m2307n(i));
        af afVar = a.f1911a;
        long a2 = m2302a(afVar);
        long a3 = afVar.m2329a();
        a.m2323a();
        return new ah(view, a3, a2);
    }

    boolean m2314d(View view, int i, long j) {
        boolean z;
        ae a = this.ay.m2237a(i);
        long a2 = m2302a(a.f1911a);
        if (a.f1911a.f1918d == 2) {
            if (this.aX != null) {
                if (this.aX.m2332a(this, view, a.f1911a.f1915a, a2)) {
                    a.m2323a();
                    return true;
                }
            }
            if (a.m2324b()) {
                this.ay.m2241a(a);
                playSoundEffect(0);
                if (this.aV != null) {
                    this.aV.m2333a(a.f1911a.f1915a);
                }
            } else {
                this.ay.m2244b(a);
                playSoundEffect(0);
                if (this.aW != null) {
                    this.aW.m2334a(a.f1911a.f1915a);
                }
                int headerViewsCount = a.f1911a.f1917c + getHeaderViewsCount();
                m2206b(this.az.getChildrenCount(a.f1911a.f1915a) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.aY != null) {
            playSoundEffect(0);
            return this.aY.m2331a(this, view, a.f1911a.f1915a, a.f1911a.f1916b, a2);
        } else {
            z = false;
        }
        a.m2323a();
        return z;
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.aH != null || this.aG != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.an - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.aP;
            int childCount = getChildCount();
            int i = this.V - headerViewsCount;
            headerViewsCount = -4;
            int i2 = 0;
            int i3 = i;
            while (i2 < childCount) {
                if (i3 >= 0) {
                    if (i3 <= footerViewsCount) {
                        View childAt = getChildAt(i2);
                        int left = childAt.getLeft();
                        int right2 = childAt.getRight();
                        if (right2 >= 0 && left <= right) {
                            ae a = this.ay.m2237a(i3);
                            if (a.f1911a.f1918d != headerViewsCount) {
                                if (a.f1911a.f1918d == 1) {
                                    rect.top = childAt.getTop() + this.aE;
                                    rect.bottom = childAt.getBottom() + this.aE;
                                } else {
                                    rect.top = childAt.getTop() + this.aA;
                                    rect.bottom = childAt.getBottom() + this.aA;
                                }
                                headerViewsCount = a.f1911a.f1918d;
                            }
                            if (rect.top != rect.bottom) {
                                if (a.f1911a.f1918d == 1) {
                                    rect.left = this.aF + left;
                                    rect.right = this.aF + right2;
                                } else {
                                    rect.left = this.aB + left;
                                    rect.right = this.aB + right2;
                                }
                                Drawable a2 = m2303a(a);
                                if (a2 != null) {
                                    if (a.f1911a.f1918d == 1) {
                                        Gravity.apply(this.aD, this.aT, this.aU, rect, this.aQ);
                                    } else {
                                        Gravity.apply(this.aC, this.aR, this.aS, rect, this.aQ);
                                    }
                                    a2.setBounds(this.aQ);
                                    a2.draw(canvas);
                                }
                            }
                            a.m2323a();
                        }
                    } else {
                        return;
                    }
                }
                i2++;
                i3++;
            }
        }
    }

    public ListAdapter getAdapter() {
        return super.getAdapter();
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.az;
    }

    public long getSelectedId() {
        long selectedPosition = getSelectedPosition();
        if (selectedPosition == 4294967295L) {
            return -1;
        }
        int b = m2304b(selectedPosition);
        return m2301a(selectedPosition) == 0 ? this.az.getGroupId(b) : this.az.getChildId(b, m2305c(selectedPosition));
    }

    public long getSelectedPosition() {
        return m2315i(getSelectedItemPosition());
    }

    public long m2315i(int i) {
        if (m2306m(i)) {
            return 4294967295L;
        }
        ae a = this.ay.m2237a(m2307n(i));
        long a2 = a.f1911a.m2329a();
        a.m2323a();
        return a2;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ExpandableHListView.class.getName());
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ExpandableHListView.class.getName());
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (this.ay != null && savedState.f1904a != null) {
                this.ay.m2240a(savedState.f1904a);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void onRtlPropertiesChanged(int i) {
        m2309y();
        m2310z();
    }

    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.ay != null ? this.ay.m2242b() : null);
    }

    public void setAdapter(ExpandableListAdapter expandableListAdapter) {
        this.az = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.ay = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.ay = null;
        }
        super.setAdapter(this.ay);
    }

    public void setAdapter(ListAdapter listAdapter) {
        throw new RuntimeException("For ExpandableListView, use setAdapter(ExpandableListAdapter) instead of setAdapter(ListAdapter)");
    }

    public void setChildDivider(Drawable drawable) {
        this.aO = drawable;
    }

    public void setChildIndicator(Drawable drawable) {
        this.aH = drawable;
        m2310z();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.aG = drawable;
        m2309y();
    }

    public void setOnChildClickListener(ai aiVar) {
        this.aY = aiVar;
    }

    public void setOnGroupClickListener(aj ajVar) {
        this.aX = ajVar;
    }

    public void setOnGroupCollapseListener(ak akVar) {
        this.aV = akVar;
    }

    public void setOnGroupExpandListener(al alVar) {
        this.aW = alVar;
    }

    public void setOnItemClickListener(C0217y c0217y) {
        super.setOnItemClickListener(c0217y);
    }

    public void setSelectedGroup(int i) {
        af a = af.m2325a(i);
        ae a2 = this.ay.m2238a(a);
        a.m2330b();
        super.setSelection(m2308o(a2.f1911a.f1917c));
        a2.m2323a();
    }
}
