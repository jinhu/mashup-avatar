package it.sephiroth.android.library.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewDebug.CapturedViewProperty;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityRecord;
import android.widget.Adapter;

/* renamed from: it.sephiroth.android.library.widget.u */
public abstract class C0273u extends ViewGroup {
    @ExportedProperty(category = "scrolling")
    protected int f1840V;
    protected int f1841W;
    protected int f1842Z;
    private int f1843a;
    protected long aa;
    protected long ab;
    protected boolean ac;
    int ad;
    protected boolean ae;
    aa af;
    C0217y ag;
    C0297z ah;
    public boolean ai;
    @ExportedProperty(category = "list")
    protected int aj;
    protected long ak;
    @ExportedProperty(category = "list")
    protected int al;
    protected long am;
    @ExportedProperty(category = "list")
    protected int an;
    protected int ao;
    AccessibilityManager ap;
    protected int aq;
    protected long ar;
    protected boolean as;
    private View f1844b;
    private boolean f1845c;
    private boolean f1846d;
    private ab f1847e;

    public C0273u(Context context) {
        super(context);
        this.f1840V = 0;
        this.aa = Long.MIN_VALUE;
        this.ac = false;
        this.ae = false;
        this.aj = -1;
        this.ak = Long.MIN_VALUE;
        this.al = -1;
        this.am = Long.MIN_VALUE;
        this.aq = -1;
        this.ar = Long.MIN_VALUE;
        this.as = false;
    }

    public C0273u(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1840V = 0;
        this.aa = Long.MIN_VALUE;
        this.ac = false;
        this.ae = false;
        this.aj = -1;
        this.ak = Long.MIN_VALUE;
        this.al = -1;
        this.am = Long.MIN_VALUE;
        this.aq = -1;
        this.ar = Long.MIN_VALUE;
        this.as = false;
    }

    @TargetApi(16)
    public C0273u(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1840V = 0;
        this.aa = Long.MIN_VALUE;
        this.ac = false;
        this.ae = false;
        this.aj = -1;
        this.ak = Long.MIN_VALUE;
        this.al = -1;
        this.am = Long.MIN_VALUE;
        this.aq = -1;
        this.ar = Long.MIN_VALUE;
        this.as = false;
        if (VERSION.SDK_INT >= 16 && getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        if (!isInEditMode()) {
            this.ap = (AccessibilityManager) getContext().getSystemService("accessibility");
        }
    }

    private void m2134a() {
        if (this.af != null) {
            int selectedItemPosition = getSelectedItemPosition();
            if (selectedItemPosition >= 0) {
                View selectedView = getSelectedView();
                this.af.m2317a(this, selectedView, selectedItemPosition, getAdapter().getItemId(selectedItemPosition));
                return;
            }
            this.af.m2316a(this);
        }
    }

    @SuppressLint({"WrongCall"})
    private void m2136a(boolean z) {
        if (m2146r()) {
            z = false;
        }
        if (z) {
            if (this.f1844b != null) {
                this.f1844b.setVisibility(0);
                setVisibility(8);
            } else {
                setVisibility(0);
            }
            if (this.ai) {
                onLayout(false, getLeft(), getTop(), getRight(), getBottom());
                return;
            }
            return;
        }
        if (this.f1844b != null) {
            this.f1844b.setVisibility(8);
        }
        setVisibility(0);
    }

    private void m2137b() {
        if (this.ap.isEnabled() && getSelectedItemPosition() >= 0) {
            sendAccessibilityEvent(4);
        }
    }

    private boolean m2140c() {
        Adapter adapter = getAdapter();
        if (adapter == null) {
            return false;
        }
        int count = adapter.getCount();
        return count > 0 ? getFirstVisiblePosition() > 0 || getLastVisiblePosition() < count - 1 : false;
    }

    public int m2141a(View view) {
        while (true) {
            try {
                View view2 = (View) view.getParent();
                if (view2.equals(this)) {
                    break;
                }
                view = view2;
            } catch (ClassCastException e) {
                return -1;
            }
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i).equals(view)) {
                return i + this.f1840V;
            }
        }
        return -1;
    }

    public boolean m2142a(View view, int i, long j) {
        if (this.ag == null) {
            return false;
        }
        playSoundEffect(0);
        if (view != null) {
            view.sendAccessibilityEvent(1);
        }
        this.ag.m1737a(this, view, i, j);
        return true;
    }

    public void addView(View view) {
        throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
    }

    public void addView(View view, int i) {
        throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
    }

    public void addView(View view, LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
    }

    protected int m2143b(int i, boolean z) {
        return i;
    }

    protected boolean canAnimate() {
        return super.canAnimate() && this.an > 0;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        View selectedView = getSelectedView();
        return selectedView != null && selectedView.getVisibility() == 0 && selectedView.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    protected void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    protected void dispatchSaveInstanceState(SparseArray sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    public abstract Adapter getAdapter();

    @CapturedViewProperty
    public int getCount() {
        return this.an;
    }

    public View getEmptyView() {
        return this.f1844b;
    }

    public int getFirstVisiblePosition() {
        return this.f1840V;
    }

    public int getLastVisiblePosition() {
        return (this.f1840V + getChildCount()) - 1;
    }

    public final C0217y getOnItemClickListener() {
        return this.ag;
    }

    public final C0297z getOnItemLongClickListener() {
        return this.ah;
    }

    public final aa getOnItemSelectedListener() {
        return this.af;
    }

    public Object getSelectedItem() {
        Adapter adapter = getAdapter();
        int selectedItemPosition = getSelectedItemPosition();
        return (adapter == null || adapter.getCount() <= 0 || selectedItemPosition < 0) ? null : adapter.getItem(selectedItemPosition);
    }

    @CapturedViewProperty
    public long getSelectedItemId() {
        return this.ak;
    }

    @CapturedViewProperty
    public int getSelectedItemPosition() {
        return this.aj;
    }

    public abstract View getSelectedView();

    public long m2144h(int i) {
        Adapter adapter = getAdapter();
        return (adapter == null || i < 0) ? Long.MIN_VALUE : adapter.getItemId(i);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f1847e);
    }

    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(C0273u.class.getName());
        accessibilityEvent.setScrollable(m2140c());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityEvent.setEnabled(selectedView.isEnabled());
        }
        accessibilityEvent.setCurrentItemIndex(getSelectedItemPosition());
        accessibilityEvent.setFromIndex(getFirstVisiblePosition());
        accessibilityEvent.setToIndex(getLastVisiblePosition());
        accessibilityEvent.setItemCount(getCount());
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(C0273u.class.getName());
        accessibilityNodeInfo.setScrollable(m2140c());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityNodeInfo.setEnabled(selectedView.isEnabled());
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f1843a = getWidth();
    }

    @TargetApi(14)
    public boolean onRequestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        if (!super.onRequestSendAccessibilityEvent(view, accessibilityEvent)) {
            return false;
        }
        AccessibilityRecord obtain = AccessibilityEvent.obtain();
        onInitializeAccessibilityEvent(obtain);
        view.dispatchPopulateAccessibilityEvent(obtain);
        accessibilityEvent.appendRecord(obtain);
        return true;
    }

    void m2145q() {
        boolean z;
        int i = this.an;
        if (i > 0) {
            int v;
            boolean z2;
            if (this.ac) {
                this.ac = false;
                v = m2150v();
                if (v >= 0 && m2143b(v, true) == v) {
                    setNextSelectedPositionInt(v);
                    z2 = true;
                    if (!z2) {
                        v = getSelectedItemPosition();
                        if (v >= i) {
                            v = i - 1;
                        }
                        if (v < 0) {
                            v = 0;
                        }
                        i = m2143b(v, true);
                        v = i >= 0 ? m2143b(v, false) : i;
                        if (v >= 0) {
                            setNextSelectedPositionInt(v);
                            m2149u();
                            z = true;
                        }
                    }
                    z = z2;
                }
            }
            z2 = false;
            if (z2) {
                v = getSelectedItemPosition();
                if (v >= i) {
                    v = i - 1;
                }
                if (v < 0) {
                    v = 0;
                }
                i = m2143b(v, true);
                if (i >= 0) {
                }
                if (v >= 0) {
                    setNextSelectedPositionInt(v);
                    m2149u();
                    z = true;
                }
            }
            z = z2;
        } else {
            z = false;
        }
        if (!z) {
            this.al = -1;
            this.am = Long.MIN_VALUE;
            this.aj = -1;
            this.ak = Long.MIN_VALUE;
            this.ac = false;
            m2149u();
        }
    }

    boolean m2146r() {
        return false;
    }

    public void removeAllViews() {
        throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
    }

    public void removeView(View view) {
        throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
    }

    public void removeViewAt(int i) {
        throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
    }

    protected void m2147s() {
        boolean z = false;
        Adapter adapter = getAdapter();
        boolean z2 = adapter == null || adapter.getCount() == 0;
        boolean z3 = !z2 || m2146r();
        z2 = z3 && this.f1846d;
        super.setFocusableInTouchMode(z2);
        z2 = z3 && this.f1845c;
        super.setFocusable(z2);
        if (this.f1844b != null) {
            if (adapter == null || adapter.isEmpty()) {
                z = true;
            }
            m2136a(z);
        }
    }

    public abstract void setAdapter(Adapter adapter);

    @TargetApi(16)
    public void setEmptyView(View view) {
        boolean z = true;
        this.f1844b = view;
        if (VERSION.SDK_INT >= 16 && view != null && view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
        Adapter adapter = getAdapter();
        if (!(adapter == null || adapter.isEmpty())) {
            z = false;
        }
        m2136a(z);
    }

    public void setFocusable(boolean z) {
        boolean z2 = true;
        Adapter adapter = getAdapter();
        boolean z3 = adapter == null || adapter.getCount() == 0;
        this.f1845c = z;
        if (!z) {
            this.f1846d = false;
        }
        if (!z || (z3 && !m2146r())) {
            z2 = false;
        }
        super.setFocusable(z2);
    }

    public void setFocusableInTouchMode(boolean z) {
        boolean z2 = true;
        Adapter adapter = getAdapter();
        boolean z3 = adapter == null || adapter.getCount() == 0;
        this.f1846d = z;
        if (z) {
            this.f1845c = true;
        }
        if (!z || (z3 && !m2146r())) {
            z2 = false;
        }
        super.setFocusableInTouchMode(z2);
    }

    protected void setNextSelectedPositionInt(int i) {
        this.aj = i;
        this.ak = m2144h(i);
        if (this.ac && this.ad == 0 && i >= 0) {
            this.f1842Z = i;
            this.aa = this.ak;
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
    }

    public void setOnItemClickListener(C0217y c0217y) {
        this.ag = c0217y;
    }

    public void setOnItemLongClickListener(C0297z c0297z) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.ah = c0297z;
    }

    public void setOnItemSelectedListener(aa aaVar) {
        this.af = aaVar;
    }

    protected void setSelectedPositionInt(int i) {
        this.al = i;
        this.am = m2144h(i);
    }

    public abstract void setSelection(int i);

    void m2148t() {
        if (this.af == null && !this.ap.isEnabled()) {
            return;
        }
        if (this.ae || this.as) {
            if (this.f1847e == null) {
                this.f1847e = new ab();
            }
            post(this.f1847e);
            return;
        }
        m2134a();
        m2137b();
    }

    protected void m2149u() {
        if (this.al != this.aq || this.am != this.ar) {
            m2148t();
            this.aq = this.al;
            this.ar = this.am;
        }
    }

    int m2150v() {
        int i = this.an;
        if (i == 0) {
            return -1;
        }
        long j = this.aa;
        int i2 = this.f1842Z;
        if (j == Long.MIN_VALUE) {
            return -1;
        }
        i2 = Math.min(i - 1, Math.max(0, i2));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        Adapter adapter = getAdapter();
        if (adapter == null) {
            return -1;
        }
        int i3 = i2;
        int i4 = i2;
        int i5 = i2;
        i2 = 0;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (adapter.getItemId(i5) != j) {
                int i6 = i3 == i + -1 ? 1 : 0;
                int i7 = i4 == 0 ? 1 : 0;
                if (i6 != 0 && i7 != 0) {
                    break;
                } else if (i7 != 0 || (r0 != 0 && i6 == 0)) {
                    i2 = i3 + 1;
                    i3 = i2;
                    i5 = i2;
                    i2 = 0;
                } else if (i6 != 0 || (r0 == 0 && i7 == 0)) {
                    i2 = i4 - 1;
                    i4 = i2;
                    i5 = i2;
                    i2 = 1;
                }
            } else {
                return i5;
            }
        }
        return -1;
    }

    public void m2151w() {
        if (getChildCount() > 0) {
            this.ac = true;
            this.ab = (long) this.f1843a;
            View childAt;
            if (this.al >= 0) {
                childAt = getChildAt(this.al - this.f1840V);
                this.aa = this.ak;
                this.f1842Z = this.aj;
                if (childAt != null) {
                    this.f1841W = childAt.getLeft();
                }
                this.ad = 0;
                return;
            }
            childAt = getChildAt(0);
            Adapter adapter = getAdapter();
            if (this.f1840V < 0 || this.f1840V >= adapter.getCount()) {
                this.aa = -1;
            } else {
                this.aa = adapter.getItemId(this.f1840V);
            }
            this.f1842Z = this.f1840V;
            if (childAt != null) {
                this.f1841W = childAt.getLeft();
            }
            this.ad = 1;
        }
    }
}
