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

public abstract class u extends ViewGroup {
    @ExportedProperty(category = "scrolling")
    protected int V;
    protected int W;
    protected int Z;
    private int a;
    protected long aa;
    protected long ab;
    protected boolean ac;
    int ad;
    protected boolean ae;
    aa af;
    y ag;
    z ah;
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
    private View b;
    private boolean c;
    private boolean d;
    private ab e;

    public u(Context context) {
        super(context);
        this.V = 0;
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

    public u(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.V = 0;
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
    public u(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.V = 0;
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

    private void a() {
        if (this.af != null) {
            int selectedItemPosition = getSelectedItemPosition();
            if (selectedItemPosition >= 0) {
                View selectedView = getSelectedView();
                this.af.a(this, selectedView, selectedItemPosition, getAdapter().getItemId(selectedItemPosition));
                return;
            }
            this.af.a(this);
        }
    }

    @SuppressLint({"WrongCall"})
    private void a(boolean z) {
        if (r()) {
            z = false;
        }
        if (z) {
            if (this.b != null) {
                this.b.setVisibility(0);
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
        if (this.b != null) {
            this.b.setVisibility(8);
        }
        setVisibility(0);
    }

    private void b() {
        if (this.ap.isEnabled() && getSelectedItemPosition() >= 0) {
            sendAccessibilityEvent(4);
        }
    }

    private boolean c() {
        Adapter adapter = getAdapter();
        if (adapter == null) {
            return false;
        }
        int count = adapter.getCount();
        return count > 0 ? getFirstVisiblePosition() > 0 || getLastVisiblePosition() < count - 1 : false;
    }

    public int a(View view) {
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
                return i + this.V;
            }
        }
        return -1;
    }

    public boolean a(View view, int i, long j) {
        if (this.ag == null) {
            return false;
        }
        playSoundEffect(0);
        if (view != null) {
            view.sendAccessibilityEvent(1);
        }
        this.ag.a(this, view, i, j);
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

    protected int b(int i, boolean z) {
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
        return this.b;
    }

    public int getFirstVisiblePosition() {
        return this.V;
    }

    public int getLastVisiblePosition() {
        return (this.V + getChildCount()) - 1;
    }

    public final y getOnItemClickListener() {
        return this.ag;
    }

    public final z getOnItemLongClickListener() {
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

    public long h(int i) {
        Adapter adapter = getAdapter();
        return (adapter == null || i < 0) ? Long.MIN_VALUE : adapter.getItemId(i);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.e);
    }

    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(u.class.getName());
        accessibilityEvent.setScrollable(c());
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
        accessibilityNodeInfo.setClassName(u.class.getName());
        accessibilityNodeInfo.setScrollable(c());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityNodeInfo.setEnabled(selectedView.isEnabled());
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.a = getWidth();
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

    void q() {
        boolean z;
        int i = this.an;
        if (i > 0) {
            int v;
            boolean z2;
            if (this.ac) {
                this.ac = false;
                v = v();
                if (v >= 0 && b(v, true) == v) {
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
                        i = b(v, true);
                        v = i >= 0 ? b(v, false) : i;
                        if (v >= 0) {
                            setNextSelectedPositionInt(v);
                            u();
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
                i = b(v, true);
                if (i >= 0) {
                }
                if (v >= 0) {
                    setNextSelectedPositionInt(v);
                    u();
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
            u();
        }
    }

    boolean r() {
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

    protected void s() {
        boolean z = false;
        Adapter adapter = getAdapter();
        boolean z2 = adapter == null || adapter.getCount() == 0;
        boolean z3 = !z2 || r();
        z2 = z3 && this.d;
        super.setFocusableInTouchMode(z2);
        z2 = z3 && this.c;
        super.setFocusable(z2);
        if (this.b != null) {
            if (adapter == null || adapter.isEmpty()) {
                z = true;
            }
            a(z);
        }
    }

    public abstract void setAdapter(Adapter adapter);

    @TargetApi(16)
    public void setEmptyView(View view) {
        boolean z = true;
        this.b = view;
        if (VERSION.SDK_INT >= 16 && view != null && view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
        Adapter adapter = getAdapter();
        if (!(adapter == null || adapter.isEmpty())) {
            z = false;
        }
        a(z);
    }

    public void setFocusable(boolean z) {
        boolean z2 = true;
        Adapter adapter = getAdapter();
        boolean z3 = adapter == null || adapter.getCount() == 0;
        this.c = z;
        if (!z) {
            this.d = false;
        }
        if (!z || (z3 && !r())) {
            z2 = false;
        }
        super.setFocusable(z2);
    }

    public void setFocusableInTouchMode(boolean z) {
        boolean z2 = true;
        Adapter adapter = getAdapter();
        boolean z3 = adapter == null || adapter.getCount() == 0;
        this.d = z;
        if (z) {
            this.c = true;
        }
        if (!z || (z3 && !r())) {
            z2 = false;
        }
        super.setFocusableInTouchMode(z2);
    }

    protected void setNextSelectedPositionInt(int i) {
        this.aj = i;
        this.ak = h(i);
        if (this.ac && this.ad == 0 && i >= 0) {
            this.Z = i;
            this.aa = this.ak;
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
    }

    public void setOnItemClickListener(y yVar) {
        this.ag = yVar;
    }

    public void setOnItemLongClickListener(z zVar) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.ah = zVar;
    }

    public void setOnItemSelectedListener(aa aaVar) {
        this.af = aaVar;
    }

    protected void setSelectedPositionInt(int i) {
        this.al = i;
        this.am = h(i);
    }

    public abstract void setSelection(int i);

    void t() {
        if (this.af == null && !this.ap.isEnabled()) {
            return;
        }
        if (this.ae || this.as) {
            if (this.e == null) {
                this.e = new ab();
            }
            post(this.e);
            return;
        }
        a();
        b();
    }

    protected void u() {
        if (this.al != this.aq || this.am != this.ar) {
            t();
            this.aq = this.al;
            this.ar = this.am;
        }
    }

    int v() {
        int i = this.an;
        if (i == 0) {
            return -1;
        }
        long j = this.aa;
        int i2 = this.Z;
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

    public void w() {
        if (getChildCount() > 0) {
            this.ac = true;
            this.ab = (long) this.a;
            View childAt;
            if (this.al >= 0) {
                childAt = getChildAt(this.al - this.V);
                this.aa = this.ak;
                this.Z = this.aj;
                if (childAt != null) {
                    this.W = childAt.getLeft();
                }
                this.ad = 0;
                return;
            }
            childAt = getChildAt(0);
            Adapter adapter = getAdapter();
            if (this.V < 0 || this.V >= adapter.getCount()) {
                this.aa = -1;
            } else {
                this.aa = adapter.getItemId(this.V);
            }
            this.Z = this.V;
            if (childAt != null) {
                this.W = childAt.getLeft();
            }
            this.ad = 1;
        }
    }
}
