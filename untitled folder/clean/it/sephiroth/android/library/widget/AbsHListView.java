package it.sephiroth.android.library.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p002c.C0040f;
import android.support.v4.p002c.C0046n;
import android.support.v4.widget.C0105f;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewConfiguration;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnTouchModeChangeListener;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.Checkable;
import android.widget.ListAdapter;
import com.google.android.apps.androidify.R;
import com.google.android.apps.androidify.cm;
import it.sephiroth.android.library.p020a.C0268a;
import it.sephiroth.android.library.p020a.C0269b;
import it.sephiroth.android.library.p020a.p021a.C0266a;
import it.sephiroth.android.library.p020a.p021a.C0267b;
import java.util.ArrayList;

@TargetApi(11)
public abstract class AbsHListView extends C0273u implements OnGlobalLayoutListener, OnTouchModeChangeListener {
    static final Interpolator f1848T;
    public static final int[] f1849U;
    protected int f1850A;
    int f1851B;
    int f1852C;
    int f1853D;
    int f1854E;
    protected int f1855F;
    int f1856G;
    int f1857H;
    protected C0288m f1858I;
    protected int f1859J;
    protected boolean f1860K;
    boolean f1861L;
    protected int f1862M;
    protected int f1863N;
    protected Runnable f1864O;
    protected final boolean[] f1865P;
    int f1866Q;
    int f1867R;
    protected boolean f1868S;
    C0269b f1869a;
    private C0280e aA;
    private Runnable aB;
    private C0279d aC;
    private C0287l aD;
    private Runnable aE;
    private int aF;
    private int aG;
    private boolean aH;
    private int aI;
    private int aJ;
    private Runnable aK;
    private int aL;
    private int aM;
    private float aN;
    private int aO;
    private C0105f aP;
    private C0105f aQ;
    private int aR;
    private int aS;
    private int aT;
    private boolean aU;
    private int aV;
    private int aW;
    private C0285j aX;
    private int aY;
    private int aZ;
    private VelocityTracker at;
    private C0282g au;
    private C0286k av;
    private boolean aw;
    private Rect ax;
    private ContextMenuInfo ay;
    private int az;
    protected int f1870b;
    private int ba;
    private SavedState bb;
    private float bc;
    public Object f1871c;
    Object f1872d;
    int f1873e;
    protected C0046n f1874f;
    C0040f f1875g;
    protected int f1876h;
    protected C0277c f1877i;
    protected ListAdapter f1878j;
    boolean f1879k;
    boolean f1880l;
    Drawable f1881m;
    int f1882n;
    protected Rect f1883o;
    protected final C0291p f1884p;
    int f1885q;
    int f1886r;
    int f1887s;
    int f1888t;
    protected Rect f1889u;
    protected int f1890v;
    View f1891w;
    View f1892x;
    protected boolean f1893y;
    protected boolean f1894z;

    class SavedState extends BaseSavedState {
        public static final Creator CREATOR;
        long f1830a;
        long f1831b;
        int f1832c;
        int f1833d;
        int f1834e;
        String f1835f;
        boolean f1836g;
        int f1837h;
        C0046n f1838i;
        C0040f f1839j;

        static {
            CREATOR = new C0293r();
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f1830a = parcel.readLong();
            this.f1831b = parcel.readLong();
            this.f1832c = parcel.readInt();
            this.f1833d = parcel.readInt();
            this.f1834e = parcel.readInt();
            this.f1835f = parcel.readString();
            this.f1836g = parcel.readByte() != null;
            this.f1837h = parcel.readInt();
            this.f1838i = m2132b(parcel);
            this.f1839j = m2127a(parcel);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private C0040f m2127a(Parcel parcel) {
            int readInt = parcel.readInt();
            if (readInt <= 0) {
                return null;
            }
            C0040f c0040f = new C0040f(readInt);
            m2129a(c0040f, parcel, readInt);
            return c0040f;
        }

        private void m2128a(C0040f c0040f, Parcel parcel) {
            int i = 0;
            int b = c0040f != null ? c0040f.m256b() : 0;
            parcel.writeInt(b);
            while (i < b) {
                parcel.writeLong(c0040f.m251a(i));
                parcel.writeInt(((Integer) c0040f.m257b(i)).intValue());
                i++;
            }
        }

        private void m2129a(C0040f c0040f, Parcel parcel, int i) {
            while (i > 0) {
                c0040f.m255a(parcel.readLong(), Integer.valueOf(parcel.readInt()));
                i--;
            }
        }

        private void m2130a(C0046n c0046n, Parcel parcel) {
            if (c0046n == null) {
                parcel.writeInt(-1);
                return;
            }
            int b = c0046n.m265b();
            parcel.writeInt(b);
            for (int i = 0; i < b; i++) {
                parcel.writeInt(c0046n.m266b(i));
                parcel.writeByte((byte) (((Boolean) c0046n.m268c(i)).booleanValue() ? 1 : 0));
            }
        }

        private void m2131a(C0046n c0046n, Parcel parcel, int i) {
            while (i > 0) {
                c0046n.m270c(parcel.readInt(), Boolean.valueOf(parcel.readByte() == (byte) 1));
                i--;
            }
        }

        private C0046n m2132b(Parcel parcel) {
            int readInt = parcel.readInt();
            if (readInt < 0) {
                return null;
            }
            C0046n c0046n = new C0046n(readInt);
            m2131a(c0046n, parcel, readInt);
            return c0046n;
        }

        public String toString() {
            return "AbsListView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.f1830a + " firstId=" + this.f1831b + " viewLeft=" + this.f1832c + " position=" + this.f1833d + " width=" + this.f1834e + " filter=" + this.f1835f + " checkState=" + this.f1838i + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.f1830a);
            parcel.writeLong(this.f1831b);
            parcel.writeInt(this.f1832c);
            parcel.writeInt(this.f1833d);
            parcel.writeInt(this.f1834e);
            parcel.writeString(this.f1835f);
            parcel.writeByte((byte) (this.f1836g ? 1 : 0));
            parcel.writeInt(this.f1837h);
            m2130a(this.f1838i, parcel);
            m2128a(this.f1839j, parcel);
        }
    }

    static {
        f1848T = new LinearInterpolator();
        f1849U = new int[]{0};
    }

    public AbsHListView(Context context) {
        super(context);
        this.f1870b = 0;
        this.f1876h = 0;
        this.f1880l = false;
        this.f1882n = -1;
        this.f1883o = new Rect();
        this.f1884p = new C0291p(this);
        this.f1885q = 0;
        this.f1886r = 0;
        this.f1887s = 0;
        this.f1888t = 0;
        this.f1889u = new Rect();
        this.f1890v = 0;
        this.f1855F = -1;
        this.f1859J = 0;
        this.aw = true;
        this.f1862M = -1;
        this.ay = null;
        this.az = -1;
        this.aI = 0;
        this.aN = 1.0f;
        this.f1865P = new boolean[1];
        this.aO = -1;
        this.aT = 0;
        m2188x();
    }

    public AbsHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.hlv_absHListViewStyle);
    }

    public AbsHListView(Context context, AttributeSet attributeSet, int i) {
        Drawable drawable;
        boolean z;
        boolean z2;
        boolean z3;
        int i2;
        int color;
        boolean z4 = true;
        int i3 = 0;
        super(context, attributeSet, i);
        this.f1870b = 0;
        this.f1876h = 0;
        this.f1880l = false;
        this.f1882n = -1;
        this.f1883o = new Rect();
        this.f1884p = new C0291p(this);
        this.f1885q = 0;
        this.f1886r = 0;
        this.f1887s = 0;
        this.f1888t = 0;
        this.f1889u = new Rect();
        this.f1890v = 0;
        this.f1855F = -1;
        this.f1859J = 0;
        this.aw = true;
        this.f1862M = -1;
        this.ay = null;
        this.az = -1;
        this.aI = 0;
        this.aN = 1.0f;
        this.f1865P = new boolean[1];
        this.aO = -1;
        this.aT = 0;
        m2188x();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, cm.AbsHListView, i, 0);
        if (obtainStyledAttributes != null) {
            drawable = obtainStyledAttributes.getDrawable(0);
            z = obtainStyledAttributes.getBoolean(1, false);
            z2 = obtainStyledAttributes.getBoolean(6, false);
            z3 = obtainStyledAttributes.getBoolean(2, true);
            i2 = obtainStyledAttributes.getInt(7, 0);
            color = obtainStyledAttributes.getColor(3, 0);
            z4 = obtainStyledAttributes.getBoolean(5, true);
            i3 = obtainStyledAttributes.getInt(4, 0);
            obtainStyledAttributes.recycle();
        } else {
            i2 = 0;
            z3 = true;
            z2 = false;
            z = false;
            drawable = null;
            color = 0;
        }
        if (drawable != null) {
            setSelector(drawable);
        }
        this.f1880l = z;
        setStackFromRight(z2);
        setScrollingCacheEnabled(z3);
        setTranscriptMode(i2);
        setCacheColorHint(color);
        setSmoothScrollbarEnabled(z4);
        setChoiceMode(i3);
    }

    private void m2152A() {
        setSelector(getResources().getDrawable(17301602));
    }

    private void m2153B() {
        if (this.at == null) {
            this.at = VelocityTracker.obtain();
        } else {
            this.at.clear();
        }
    }

    private void m2154C() {
        if (this.at == null) {
            this.at = VelocityTracker.obtain();
        }
    }

    private void m2155D() {
        if (this.at != null) {
            this.at.recycle();
            this.at = null;
        }
    }

    private void m2156E() {
        if (this.f1861L && !this.f1893y && !this.f1869a.m2120a()) {
            setChildrenDrawnWithCacheEnabled(true);
            setChildrenDrawingCacheEnabled(true);
            this.f1894z = true;
            this.f1893y = true;
        }
    }

    private void m2157F() {
        if (!this.f1869a.m2120a()) {
            if (this.aK == null) {
                this.aK = new C0275b(this);
            }
            post(this.aK);
        }
    }

    private void m2158G() {
        if (this.aP != null) {
            this.aP.m812b();
            this.aQ.m812b();
        }
    }

    public static int m2159a(Rect rect, Rect rect2, int i) {
        int width;
        int height;
        int width2;
        int height2;
        switch (i) {
            case cm.HListView_android_divider /*1*/:
            case cm.HListView_hlv_dividerWidth /*2*/:
                width = rect.right + (rect.width() / 2);
                height = rect.top + (rect.height() / 2);
                width2 = (rect2.width() / 2) + rect2.left;
                height2 = rect2.top + (rect2.height() / 2);
                break;
            case 17:
                width = rect.left;
                height = rect.top + (rect.height() / 2);
                width2 = rect2.right;
                height2 = rect2.top + (rect2.height() / 2);
                break;
            case 33:
                width = rect.left + (rect.width() / 2);
                height = rect.top;
                width2 = (rect2.width() / 2) + rect2.left;
                height2 = rect2.bottom;
                break;
            case 66:
                width = rect.right;
                height = rect.top + (rect.height() / 2);
                width2 = rect2.left;
                height2 = rect2.top + (rect2.height() / 2);
                break;
            case 130:
                width = rect.left + (rect.width() / 2);
                height = rect.bottom;
                width2 = (rect2.width() / 2) + rect2.left;
                height2 = rect2.top;
                break;
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT, FOCUS_FORWARD, FOCUS_BACKWARD}.");
        }
        width2 -= width;
        height2 -= height;
        return (height2 * height2) + (width2 * width2);
    }

    static View m2161a(ArrayList arrayList, int i) {
        int size = arrayList.size();
        if (size <= 0) {
            return null;
        }
        for (int i2 = 0; i2 < size; i2++) {
            View view = (View) arrayList.get(i2);
            if (((C0284i) view.getLayoutParams()).f1978d == i) {
                arrayList.remove(i2);
                return view;
            }
        }
        return (View) arrayList.remove(size - 1);
    }

    private void m2163a(int i, int i2, int i3, int i4) {
        this.f1883o.set(i - this.f1885q, i2 - this.f1886r, this.f1887s + i3, this.f1888t + i4);
    }

    private void m2164a(Canvas canvas) {
        if (!this.f1883o.isEmpty()) {
            Drawable drawable = this.f1881m;
            drawable.setBounds(this.f1883o);
            drawable.draw(canvas);
        }
    }

    private void m2169b(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (motionEvent.getPointerId(action) == this.aO) {
            action = action == 0 ? 1 : 0;
            this.f1853D = (int) motionEvent.getX(action);
            this.f1854E = (int) motionEvent.getY(action);
            this.f1857H = 0;
            this.aO = motionEvent.getPointerId(action);
        }
    }

    private boolean m2184i(int i) {
        int i2 = i - this.f1853D;
        int abs = Math.abs(i2);
        boolean z = getScrollX() != 0;
        if (!z && abs <= this.aJ) {
            return false;
        }
        m2156E();
        if (z) {
            this.f1855F = 5;
            this.f1857H = 0;
        } else {
            this.f1855F = 3;
            this.f1857H = i2 > 0 ? this.aJ : -this.aJ;
        }
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.aA);
        }
        setPressed(false);
        View childAt = getChildAt(this.f1850A - this.V);
        if (childAt != null) {
            childAt.setPressed(false);
        }
        m2205b(1);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        m2186j(i);
        return true;
    }

    private void m2186j(int i) {
        int i2 = 0;
        int i3 = i - this.f1853D;
        int i4 = i3 - this.f1857H;
        int i5 = this.f1856G != Integer.MIN_VALUE ? i - this.f1856G : i4;
        int childCount;
        int left;
        if (this.f1855F == 3) {
            if (i != this.f1856G) {
                if (Math.abs(i3) > this.aJ) {
                    ViewParent parent = getParent();
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                }
                childCount = this.f1850A >= 0 ? this.f1850A - this.V : getChildCount() / 2;
                View childAt = getChildAt(childCount);
                left = childAt != null ? childAt.getLeft() : 0;
                boolean d = i5 != 0 ? m2213d(i4, i5) : false;
                View childAt2 = getChildAt(childCount);
                if (childAt2 != null) {
                    childCount = childAt2.getLeft();
                    if (d) {
                        i4 = (-i5) - (childCount - left);
                        overScrollBy(i4, 0, getScrollX(), 0, 0, 0, this.f1866Q, 0, true);
                        if (Math.abs(this.f1866Q) == Math.abs(getScrollX()) && this.at != null) {
                            this.at.clear();
                        }
                        i5 = getOverScrollMode();
                        if (i5 == 0 || (i5 == 1 && !m2190z())) {
                            this.aT = 0;
                            this.f1855F = 5;
                            if (i3 > 0) {
                                this.aP.m809a(((float) i4) / ((float) getWidth()));
                                if (!this.aQ.m808a()) {
                                    this.aQ.m813c();
                                }
                                invalidate();
                            } else if (i3 < 0) {
                                this.aQ.m809a(((float) i4) / ((float) getWidth()));
                                if (!this.aP.m808a()) {
                                    this.aP.m813c();
                                }
                                invalidate();
                            }
                        }
                    }
                    this.f1853D = i;
                }
                this.f1856G = i;
            }
        } else if (this.f1855F == 5 && i != this.f1856G) {
            int i6;
            childCount = getScrollX();
            left = childCount - i5;
            int i7 = i > this.f1856G ? 1 : -1;
            if (this.aT == 0) {
                this.aT = i7;
            }
            i4 = -i5;
            if ((left >= 0 || childCount < 0) && (left <= 0 || childCount > 0)) {
                i6 = 0;
            } else {
                i4 = -childCount;
                i6 = i5 + i4;
            }
            if (i4 != 0) {
                overScrollBy(i4, 0, getScrollX(), 0, 0, 0, this.f1866Q, 0, true);
                i5 = getOverScrollMode();
                if (i5 == 0 || (i5 == 1 && !m2190z())) {
                    if (i3 > 0) {
                        this.aP.m809a(((float) i4) / ((float) getWidth()));
                        if (!this.aQ.m808a()) {
                            this.aQ.m813c();
                        }
                        invalidate();
                    } else if (i3 < 0) {
                        this.aQ.m809a(((float) i4) / ((float) getWidth()));
                        if (!this.aP.m808a()) {
                            this.aP.m813c();
                        }
                        invalidate();
                    }
                }
            }
            if (i6 != 0) {
                if (getScrollX() != 0) {
                    this.f1869a.m2118a(0);
                    m2224k();
                }
                m2213d(i6, i6);
                this.f1855F = 3;
                i5 = m2219g(i);
                this.f1857H = 0;
                View childAt3 = getChildAt(i5 - this.V);
                if (childAt3 != null) {
                    i2 = childAt3.getLeft();
                }
                this.f1851B = i2;
                this.f1853D = i;
                this.f1850A = i5;
            }
            this.f1856G = i;
            this.aT = i7;
        }
    }

    private void m2188x() {
        setClickable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        setAlwaysDrawnWithCacheEnabled(false);
        setScrollingCacheEnabled(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.aJ = viewConfiguration.getScaledTouchSlop();
        this.aL = viewConfiguration.getScaledMinimumFlingVelocity();
        this.aM = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f1866Q = viewConfiguration.getScaledOverscrollDistance();
        this.f1867R = viewConfiguration.getScaledOverflingDistance();
        this.f1869a = C0268a.m2117a(this);
    }

    private void m2189y() {
        int i = this.V;
        int childCount = getChildCount();
        boolean z = VERSION.SDK_INT >= 11;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int i3 = i + i2;
            if (childAt instanceof Checkable) {
                ((Checkable) childAt).setChecked(((Boolean) this.f1874f.m263a(i3, Boolean.valueOf(false))).booleanValue());
            } else if (z) {
                childAt.setActivated(((Boolean) this.f1874f.m263a(i3, Boolean.valueOf(false))).booleanValue());
            }
        }
    }

    private boolean m2190z() {
        int childCount = getChildCount();
        return childCount == 0 ? true : childCount != this.an ? false : getChildAt(0).getLeft() >= this.f1889u.left && getChildAt(childCount - 1).getRight() <= getWidth() - this.f1889u.right;
    }

    public int m2191a(int i, int i2) {
        Rect rect = this.ax;
        if (rect == null) {
            this.ax = new Rect();
            rect = this.ax;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i, i2)) {
                    return this.V + childCount;
                }
            }
        }
        return -1;
    }

    @SuppressLint({"NewApi"})
    protected View m2192a(int i, boolean[] zArr) {
        zArr[0] = false;
        View d = this.f1884p.m2410d(i);
        if (d == null) {
            d = this.f1884p.m2412e(i);
            View view;
            if (d != null) {
                view = this.f1878j.getView(i, d, this);
                if (VERSION.SDK_INT >= 16 && view.getImportantForAccessibility() == 0) {
                    view.setImportantForAccessibility(1);
                }
                if (view != d) {
                    this.f1884p.m2405a(d, i);
                    if (this.aG != 0) {
                        view.setDrawingCacheBackgroundColor(this.aG);
                        d = view;
                    }
                    d = view;
                } else {
                    zArr[0] = true;
                    view.onFinishTemporaryDetach();
                    d = view;
                }
            } else {
                view = this.f1878j.getView(i, null, this);
                if (VERSION.SDK_INT >= 16 && view.getImportantForAccessibility() == 0) {
                    view.setImportantForAccessibility(1);
                }
                if (this.aG != 0) {
                    view.setDrawingCacheBackgroundColor(this.aG);
                }
                d = view;
            }
            if (this.f1879k) {
                LayoutParams layoutParams = d.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = (C0284i) generateDefaultLayoutParams();
                } else {
                    C0284i c0284i = !checkLayoutParams(layoutParams) ? (C0284i) generateLayoutParams(layoutParams) : (C0284i) layoutParams;
                }
                layoutParams.f1979e = this.f1878j.getItemId(i);
                d.setLayoutParams(layoutParams);
            }
            if (this.ap.isEnabled()) {
                if (this.aX == null) {
                    this.aX = new C0285j(this);
                }
                if (VERSION.SDK_INT >= 16) {
                    d.setAccessibilityDelegate(this.aX);
                }
            }
        }
        return d;
    }

    public C0284i m2193a(AttributeSet attributeSet) {
        return new C0284i(getContext(), attributeSet);
    }

    public void m2194a() {
        if (this.f1874f != null) {
            this.f1874f.m269c();
        }
        if (this.f1875g != null) {
            this.f1875g.m258c();
        }
        this.f1873e = 0;
    }

    public void m2195a(int i, int i2, boolean z) {
        if (this.au == null) {
            this.au = new C0282g(this);
        }
        int i3 = this.V;
        int childCount = getChildCount();
        int i4 = i3 + childCount;
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        if (i == 0 || this.an == 0 || childCount == 0 || ((i3 == 0 && getChildAt(0).getLeft() == paddingLeft && i < 0) || (i4 == this.an && getChildAt(childCount - 1).getRight() == width && i > 0))) {
            this.au.m2390b();
            if (this.f1858I != null) {
                this.f1858I.m2396a();
                return;
            }
            return;
        }
        m2205b(2);
        this.au.m2389a(i, i2, z);
    }

    protected void m2196a(int i, View view) {
        if (i != -1) {
            this.f1882n = i;
        }
        Rect rect = this.f1883o;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        if (view instanceof C0294s) {
            ((C0294s) view).m2418a(rect);
        }
        m2163a(rect.left, rect.top, rect.right, rect.bottom);
        boolean z = this.aH;
        if (view.isEnabled() != z) {
            this.aH = !z;
            if (getSelectedItemPosition() != -1) {
                refreshDrawableState();
            }
        }
    }

    public void m2197a(int i, boolean z) {
        if (this.f1870b != 0) {
            if (VERSION.SDK_INT >= 11 && z && this.f1870b == 3 && this.f1871c == null) {
                if (this.f1872d == null || !((C0267b) this.f1872d).m2116a()) {
                    throw new IllegalStateException("AbsListView: attempted to start selection mode for CHOICE_MODE_MULTIPLE_MODAL but no choice mode callback was supplied. Call setMultiChoiceModeListener to set a callback.");
                }
                this.f1871c = startActionMode((C0267b) this.f1872d);
            }
            boolean booleanValue;
            if (this.f1870b == 2 || (VERSION.SDK_INT >= 11 && this.f1870b == 3)) {
                booleanValue = ((Boolean) this.f1874f.m263a(i, Boolean.valueOf(false))).booleanValue();
                this.f1874f.m267b(i, Boolean.valueOf(z));
                if (this.f1875g != null && this.f1878j.hasStableIds()) {
                    if (z) {
                        this.f1875g.m255a(this.f1878j.getItemId(i), Integer.valueOf(i));
                    } else {
                        this.f1875g.m254a(this.f1878j.getItemId(i));
                    }
                }
                if (booleanValue != z) {
                    if (z) {
                        this.f1873e++;
                    } else {
                        this.f1873e--;
                    }
                }
                if (this.f1871c != null) {
                    ((C0267b) this.f1872d).m2114a((ActionMode) this.f1871c, i, this.f1878j.getItemId(i), z);
                }
            } else {
                booleanValue = this.f1875g != null && this.f1878j.hasStableIds();
                if (z || m2200a(i)) {
                    this.f1874f.m269c();
                    if (booleanValue) {
                        this.f1875g.m258c();
                    }
                }
                if (z) {
                    this.f1874f.m267b(i, Boolean.valueOf(true));
                    if (booleanValue) {
                        this.f1875g.m255a(this.f1878j.getItemId(i), Integer.valueOf(i));
                    }
                    this.f1873e = 1;
                } else if (this.f1874f.m265b() == 0 || !((Boolean) this.f1874f.m268c(0)).booleanValue()) {
                    this.f1873e = 0;
                }
            }
            if (!this.ae && !this.as) {
                this.ai = true;
                m2151w();
                requestLayout();
            }
        }
    }

    protected abstract void m2198a(boolean z);

    public boolean m2199a(float f, float f2, int i) {
        int a = m2191a((int) f, (int) f2);
        if (a != -1) {
            long itemId = this.f1878j.getItemId(a);
            View childAt = getChildAt(a - this.V);
            if (childAt != null) {
                this.ay = m2203b(childAt, a, itemId);
                return super.showContextMenuForChild(this);
            }
        }
        return m2199a(f, f2, i);
    }

    public boolean m2200a(int i) {
        return (this.f1870b == 0 || this.f1874f == null) ? false : ((Boolean) this.f1874f.m263a(i, Boolean.valueOf(false))).booleanValue();
    }

    @TargetApi(14)
    protected boolean m2201a(MotionEvent motionEvent) {
        return VERSION.SDK_INT >= 14 && (motionEvent.getButtonState() & 2) != 0 && m2199a(motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState());
    }

    public boolean m2202a(View view, int i, long j) {
        boolean z;
        boolean z2 = true;
        boolean z3 = false;
        if (this.f1870b != 0) {
            if (this.f1870b == 2 || (VERSION.SDK_INT >= 11 && this.f1870b == 3 && this.f1871c != null)) {
                boolean z4 = !((Boolean) this.f1874f.m263a(i, Boolean.valueOf(false))).booleanValue();
                this.f1874f.m267b(i, Boolean.valueOf(z4));
                if (this.f1875g != null && this.f1878j.hasStableIds()) {
                    if (z4) {
                        this.f1875g.m255a(this.f1878j.getItemId(i), Integer.valueOf(i));
                    } else {
                        this.f1875g.m254a(this.f1878j.getItemId(i));
                    }
                }
                if (z4) {
                    this.f1873e++;
                } else {
                    this.f1873e--;
                }
                if (this.f1871c != null) {
                    ((C0267b) this.f1872d).m2114a((ActionMode) this.f1871c, i, j, z4);
                } else {
                    z3 = true;
                }
                z = z3;
                z3 = true;
            } else if (this.f1870b == 1) {
                if (!((Boolean) this.f1874f.m263a(i, Boolean.valueOf(false))).booleanValue()) {
                    this.f1874f.m269c();
                    this.f1874f.m267b(i, Boolean.valueOf(true));
                    if (this.f1875g != null && this.f1878j.hasStableIds()) {
                        this.f1875g.m258c();
                        this.f1875g.m255a(this.f1878j.getItemId(i), Integer.valueOf(i));
                    }
                    this.f1873e = 1;
                } else if (this.f1874f.m265b() == 0 || !((Boolean) this.f1874f.m268c(0)).booleanValue()) {
                    this.f1873e = 0;
                }
                z3 = true;
                z = true;
            } else {
                z = true;
            }
            if (z3) {
                m2189y();
            }
            boolean z5 = z;
            z = true;
            z2 = z5;
        } else {
            z = false;
        }
        return z2 ? z | super.m2142a(view, i, j) : z;
    }

    public void addTouchables(ArrayList arrayList) {
        int childCount = getChildCount();
        int i = this.V;
        ListAdapter listAdapter = this.f1878j;
        if (listAdapter != null) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (listAdapter.isEnabled(i + i2)) {
                    arrayList.add(childAt);
                }
                childAt.addTouchables(arrayList);
            }
        }
    }

    ContextMenuInfo m2203b(View view, int i, long j) {
        return new C0296w(view, i, j);
    }

    protected void m2204b() {
        if (this.av != null) {
            this.av.m2395a(this, this.V, getChildCount(), this.an);
        }
        onScrollChanged(0, 0, 0, 0);
    }

    void m2205b(int i) {
        if (i != this.aI && this.av != null) {
            this.aI = i;
            this.av.m2394a(this, i);
        }
    }

    public void m2206b(int i, int i2) {
        if (this.f1858I == null) {
            this.f1858I = new C0288m(this);
        }
        this.f1858I.m2398a(i, i2);
    }

    void m2207c() {
        if (getChildCount() > 0) {
            m2211d();
            requestLayout();
            invalidate();
        }
    }

    public void m2208c(int i) {
        if (this.f1858I == null) {
            this.f1858I = new C0288m(this);
        }
        this.f1858I.m2397a(i);
    }

    public void m2209c(int i, int i2) {
        m2195a(i, i2, false);
    }

    boolean m2210c(View view, int i, long j) {
        if (VERSION.SDK_INT < 11 || this.f1870b != 3) {
            boolean a = this.ah != null ? this.ah.m2419a(this, view, i, j) : false;
            if (!a) {
                this.ay = m2203b(view, i, j);
                a = super.showContextMenuForChild(this);
            }
            if (!a) {
                return a;
            }
            performHapticFeedback(0);
            return a;
        }
        if (this.f1871c == null) {
            ActionMode startActionMode = startActionMode((C0267b) this.f1872d);
            this.f1871c = startActionMode;
            if (startActionMode != null) {
                m2197a(i, true);
                performHapticFeedback(0);
            }
        }
        return true;
    }

    public boolean checkInputConnectionProxy(View view) {
        return false;
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof C0284i;
    }

    protected int computeHorizontalScrollExtent() {
        int childCount = getChildCount();
        if (childCount <= 0) {
            return 0;
        }
        if (!this.aw) {
            return 1;
        }
        int i = childCount * 100;
        View childAt = getChildAt(0);
        int left = childAt.getLeft();
        int width = childAt.getWidth();
        if (width > 0) {
            i += (left * 100) / width;
        }
        childAt = getChildAt(childCount - 1);
        childCount = childAt.getRight();
        width = childAt.getWidth();
        return width > 0 ? i - (((childCount - getWidth()) * 100) / width) : i;
    }

    protected int computeHorizontalScrollOffset() {
        int i = 0;
        int i2 = this.V;
        int childCount = getChildCount();
        if (i2 < 0 || childCount <= 0) {
            return 0;
        }
        int width;
        if (this.aw) {
            View childAt = getChildAt(0);
            childCount = childAt.getLeft();
            width = childAt.getWidth();
            return width > 0 ? Math.max(((i2 * 100) - ((childCount * 100) / width)) + ((int) (((((float) getScrollX()) / ((float) getWidth())) * ((float) this.an)) * 100.0f)), 0) : 0;
        } else {
            width = this.an;
            if (i2 != 0) {
                i = i2 + childCount == width ? width : (childCount / 2) + i2;
            }
            return (int) (((((float) i) / ((float) width)) * ((float) childCount)) + ((float) i2));
        }
    }

    protected int computeHorizontalScrollRange() {
        if (!this.aw) {
            return this.an;
        }
        int max = Math.max(this.an * 100, 0);
        return getScrollX() != 0 ? max + Math.abs((int) (((((float) getScrollX()) / ((float) getWidth())) * ((float) this.an)) * 100.0f)) : max;
    }

    protected void m2211d() {
        removeAllViewsInLayout();
        this.V = 0;
        this.ai = false;
        this.f1864O = null;
        this.ac = false;
        this.bb = null;
        this.aq = -1;
        this.ar = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        this.f1859J = 0;
        this.f1882n = -1;
        this.f1883o.setEmpty();
        invalidate();
    }

    protected void m2212d(int i) {
        int firstVisiblePosition = i < 0 ? getFirstVisiblePosition() : i > 0 ? getLastVisiblePosition() : -1;
        if (firstVisiblePosition > -1) {
            View childAt = getChildAt(firstVisiblePosition - getFirstVisiblePosition());
            if (childAt != null) {
                Rect rect = new Rect();
                if (childAt.getGlobalVisibleRect(rect)) {
                    float height = ((float) (rect.height() * rect.width())) / ((float) (childAt.getHeight() * childAt.getWidth()));
                    if (i < 0 && height < 0.75f) {
                        firstVisiblePosition++;
                    } else if (i > 0 && height < 0.75f) {
                        firstVisiblePosition--;
                    }
                }
                m2208c(Math.max(0, Math.min(getCount(), firstVisiblePosition + i)));
            }
        }
    }

    boolean m2213d(int i, int i2) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        int left = getChildAt(0).getLeft();
        int right = getChildAt(childCount - 1).getRight();
        Rect rect = this.f1889u;
        int i3 = 0 - left;
        int width = right - (getWidth() - 0);
        int width2 = (getWidth() - getPaddingRight()) - getPaddingLeft();
        int max = i < 0 ? Math.max(-(width2 - 1), i) : Math.min(width2 - 1, i);
        int max2 = i2 < 0 ? Math.max(-(width2 - 1), i2) : Math.min(width2 - 1, i2);
        int i4 = this.V;
        if (i4 == 0) {
            this.aR = left - rect.left;
        } else {
            this.aR += max2;
        }
        if (i4 + childCount == this.an) {
            this.aS = rect.right + right;
        } else {
            this.aS += max2;
        }
        Object obj = (i4 != 0 || left < rect.left || max2 < 0) ? null : 1;
        Object obj2 = (i4 + childCount != this.an || right > getWidth() - rect.right || max2 > 0) ? null : 1;
        if (obj != null || obj2 != null) {
            return max2 != 0;
        } else {
            boolean z = max2 < 0;
            boolean isInTouchMode = isInTouchMode();
            if (isInTouchMode) {
                m2225l();
            }
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = this.an - getFooterViewsCount();
            int i5 = 0;
            int width3;
            if (!z) {
                width3 = getWidth() - max2;
                right = 0;
                for (width2 = childCount - 1; width2 >= 0; width2--) {
                    View childAt = getChildAt(width2);
                    if (childAt.getLeft() <= width3) {
                        break;
                    }
                    i5 = right + 1;
                    right = i4 + width2;
                    if (right >= headerViewsCount && right < footerViewsCount) {
                        this.f1884p.m2405a(childAt, right);
                    }
                    right = i5;
                    i5 = width2;
                }
            } else {
                int i6 = -max2;
                right = 0;
                width2 = 0;
                while (width2 < childCount) {
                    View childAt2 = getChildAt(width2);
                    if (childAt2.getRight() >= i6) {
                        break;
                    }
                    width3 = right + 1;
                    right = i4 + width2;
                    if (right >= headerViewsCount && right < footerViewsCount) {
                        this.f1884p.m2405a(childAt2, right);
                    }
                    width2++;
                    right = width3;
                }
            }
            this.f1852C = this.f1851B + max;
            this.as = true;
            if (right > 0) {
                detachViewsFromParent(i5, right);
                this.f1884p.m2411d();
            }
            if (!awakenScrollBars()) {
                invalidate();
            }
            m2215e(max2);
            if (z) {
                this.V = right + this.V;
            }
            max2 = Math.abs(max2);
            if (i3 < max2 || width < max2) {
                m2198a(z);
            }
            if (!isInTouchMode && this.al != -1) {
                max2 = this.al - this.V;
                if (max2 >= 0 && max2 < getChildCount()) {
                    m2196a(this.al, getChildAt(max2));
                }
            } else if (this.f1882n != -1) {
                max2 = this.f1882n - this.V;
                if (max2 >= 0 && max2 < getChildCount()) {
                    m2196a(-1, getChildAt(max2));
                }
            } else {
                this.f1883o.setEmpty();
            }
            this.as = false;
            m2204b();
            return false;
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        boolean z = this.f1880l;
        if (!z) {
            m2164a(canvas);
        }
        super.dispatchDraw(canvas);
        if (z) {
            m2164a(canvas);
        }
    }

    protected void dispatchSetPressed(boolean z) {
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.aP != null) {
            int save;
            int i;
            int height;
            int scrollX = getScrollX();
            if (!this.aP.m808a()) {
                save = canvas.save();
                i = this.f1889u.top + this.aV;
                height = (getHeight() - i) - (this.f1889u.bottom + this.aW);
                int min = Math.min(0, this.aR + scrollX);
                canvas.rotate(-90.0f);
                canvas.translate((float) (i + (-getHeight())), (float) min);
                this.aP.m807a(height, height);
                if (this.aP.m811a(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save);
            }
            if (!this.aQ.m808a()) {
                save = canvas.save();
                i = this.f1889u.left + this.aV;
                height = (getHeight() - i) - (this.f1889u.right + this.aW);
                scrollX = Math.max(getWidth(), scrollX + this.aS);
                canvas.rotate(90.0f);
                canvas.translate((float) (-i), (float) (-scrollX));
                this.aQ.m807a(height, height);
                if (this.aQ.m811a(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save);
            }
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        m2223j();
    }

    protected void m2214e() {
    }

    public void m2215e(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).offsetLeftAndRight(i);
        }
    }

    protected void m2216e(int i, int i2) {
    }

    protected abstract int m2217f(int i);

    protected void m2218f() {
        int i;
        int i2 = 1;
        int i3 = 0;
        if (this.f1891w != null) {
            i = this.V > 0 ? 1 : 0;
            if (i == 0 && getChildCount() > 0) {
                i = getChildAt(0).getLeft() < this.f1889u.left ? 1 : 0;
            }
            this.f1891w.setVisibility(i != 0 ? 0 : 4);
        }
        if (this.f1892x != null) {
            int childCount = getChildCount();
            i = this.V + childCount < this.an ? 1 : 0;
            if (i != 0 || childCount <= 0) {
                i2 = i;
            } else if (getChildAt(childCount - 1).getRight() <= getRight() - this.f1889u.right) {
                i2 = 0;
            }
            View view = this.f1892x;
            if (i2 == 0) {
                i3 = 4;
            }
            view.setVisibility(i3);
        }
    }

    protected int m2219g(int i) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return -1;
        }
        int f = m2217f(i);
        return f == -1 ? (this.V + childCount) - 1 : f;
    }

    boolean m2220g() {
        switch (this.f1855F) {
            case cm.HListView_android_divider /*1*/:
            case cm.HListView_hlv_dividerWidth /*2*/:
                return true;
            default:
                return false;
        }
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new C0284i(-2, -1, 0);
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m2193a(attributeSet);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new C0284i(layoutParams);
    }

    @ExportedProperty(category = "drawing")
    public int getCacheColorHint() {
        return this.aG;
    }

    public int getCheckedItemCount() {
        return this.f1873e;
    }

    public long[] getCheckedItemIds() {
        int i = 0;
        if (this.f1870b == 0 || this.f1875g == null || this.f1878j == null) {
            return new long[0];
        }
        C0040f c0040f = this.f1875g;
        int b = c0040f.m256b();
        long[] jArr = new long[b];
        while (i < b) {
            jArr[i] = c0040f.m251a(i);
            i++;
        }
        return jArr;
    }

    public int getCheckedItemPosition() {
        return (this.f1870b == 1 && this.f1874f != null && this.f1874f.m265b() == 1) ? this.f1874f.m266b(0) : -1;
    }

    public C0046n getCheckedItemPositions() {
        return this.f1870b != 0 ? this.f1874f : null;
    }

    public int getChoiceMode() {
        return this.f1870b;
    }

    protected ContextMenuInfo getContextMenuInfo() {
        return this.ay;
    }

    public void getFocusedRect(Rect rect) {
        View selectedView = getSelectedView();
        if (selectedView == null || selectedView.getParent() != this) {
            super.getFocusedRect(rect);
            return;
        }
        selectedView.getFocusedRect(rect);
        offsetDescendantRectToMyCoords(selectedView, rect);
    }

    protected int getFooterViewsCount() {
        return 0;
    }

    protected int getHeaderViewsCount() {
        return 0;
    }

    protected float getHorizontalScrollFactor() {
        if (this.bc == 0.0f) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(R.attr.hlv_listPreferredItemWidth, typedValue, true)) {
                this.bc = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define hlv_listPreferredItemWidth.");
            }
        }
        return this.bc;
    }

    protected int getHorizontalScrollbarHeight() {
        return super.getHorizontalScrollbarHeight();
    }

    protected float getLeftFadingEdgeStrength() {
        int childCount = getChildCount();
        float leftFadingEdgeStrength = super.getLeftFadingEdgeStrength();
        if (childCount == 0) {
            return leftFadingEdgeStrength;
        }
        if (this.V > 0) {
            return 1.0f;
        }
        childCount = getChildAt(0).getLeft();
        return childCount < getPaddingLeft() ? ((float) (-(childCount - getPaddingLeft()))) / ((float) getHorizontalFadingEdgeLength()) : leftFadingEdgeStrength;
    }

    public int getListPaddingBottom() {
        return this.f1889u.bottom;
    }

    public int getListPaddingLeft() {
        return this.f1889u.left;
    }

    public int getListPaddingRight() {
        return this.f1889u.right;
    }

    public int getListPaddingTop() {
        return this.f1889u.top;
    }

    protected float getRightFadingEdgeStrength() {
        int childCount = getChildCount();
        float rightFadingEdgeStrength = super.getRightFadingEdgeStrength();
        if (childCount == 0) {
            return rightFadingEdgeStrength;
        }
        if ((this.V + childCount) - 1 < this.an - 1) {
            return 1.0f;
        }
        childCount = getChildAt(childCount - 1).getRight();
        int width = getWidth();
        return childCount > width - getPaddingRight() ? ((float) ((childCount - width) + getPaddingRight())) / ((float) getHorizontalFadingEdgeLength()) : rightFadingEdgeStrength;
    }

    @ExportedProperty
    public View getSelectedView() {
        return (this.an <= 0 || this.al < 0) ? null : getChildAt(this.al - this.V);
    }

    public Drawable getSelector() {
        return this.f1881m;
    }

    public int getSolidColor() {
        return this.aG;
    }

    public int getTranscriptMode() {
        return this.aF;
    }

    protected boolean m2221h() {
        return (hasFocus() && !isInTouchMode()) || m2220g();
    }

    protected void m2222i() {
        if (isEnabled() && isClickable()) {
            Drawable drawable = this.f1881m;
            Rect rect = this.f1883o;
            if (drawable == null) {
                return;
            }
            if ((isFocused() || m2220g()) && !rect.isEmpty()) {
                View childAt = getChildAt(this.al - this.V);
                if (childAt != null) {
                    if (!childAt.hasFocusable()) {
                        childAt.setPressed(true);
                    } else {
                        return;
                    }
                }
                setPressed(true);
                boolean isLongClickable = isLongClickable();
                drawable = drawable.getCurrent();
                if (drawable != null && (drawable instanceof TransitionDrawable)) {
                    if (isLongClickable) {
                        ((TransitionDrawable) drawable).startTransition(ViewConfiguration.getLongPressTimeout());
                    } else {
                        ((TransitionDrawable) drawable).resetTransition();
                    }
                }
                if (isLongClickable && !this.ai) {
                    if (this.aC == null) {
                        this.aC = new C0279d();
                    }
                    this.aC.m2384a();
                    postDelayed(this.aC, (long) ViewConfiguration.getLongPressTimeout());
                }
            }
        }
    }

    void m2223j() {
        if (this.f1881m == null) {
            return;
        }
        if (m2221h()) {
            this.f1881m.setState(getDrawableState());
        } else {
            this.f1881m.setState(f1849U);
        }
    }

    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f1881m != null) {
            this.f1881m.jumpToCurrentState();
        }
    }

    @TargetApi(11)
    protected void m2224k() {
        if (this.f1869a.m2120a() && (getParent() instanceof View)) {
            ((View) getParent()).invalidate();
        }
    }

    protected void m2225l() {
        if (this.al != -1) {
            if (this.f1876h != 4) {
                this.f1862M = this.al;
            }
            if (this.aj >= 0 && this.aj != this.al) {
                this.f1862M = this.aj;
            }
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.f1859J = 0;
        }
    }

    protected int m2226m() {
        int i = this.al;
        if (i < 0) {
            i = this.f1862M;
        }
        return Math.min(Math.max(0, i), this.an - 1);
    }

    protected boolean m2227n() {
        if (this.al >= 0 || !m2228o()) {
            return false;
        }
        m2223j();
        return true;
    }

    boolean m2228o() {
        boolean z = true;
        int childCount = getChildCount();
        if (childCount <= 0) {
            return false;
        }
        int left;
        int i;
        boolean z2;
        boolean z3 = this.f1889u.left;
        int right = (getRight() - getLeft()) - this.f1889u.right;
        int i2 = this.V;
        int i3 = this.f1862M;
        if (i3 >= i2 && i3 < i2 + childCount) {
            View childAt = getChildAt(i3 - this.V);
            left = childAt.getLeft();
            childCount = childAt.getRight();
            if (left < z3) {
                left = getHorizontalFadingEdgeLength() + z3;
            } else if (childCount > right) {
                left = (right - childAt.getMeasuredWidth()) - getHorizontalFadingEdgeLength();
            }
            i = left;
            z2 = true;
        } else if (i3 < i2) {
            boolean left2;
            right = 0;
            z2 = false;
            while (right < childCount) {
                boolean z4;
                left2 = getChildAt(right).getLeft();
                if (right != 0) {
                    z4 = z3;
                    z3 = z2;
                    z2 = z4;
                } else if (i2 > 0 || left2 < z3) {
                    z2 = getHorizontalFadingEdgeLength() + z3;
                    z3 = left2;
                } else {
                    z2 = z3;
                    z3 = left2;
                }
                if (left2 >= z2) {
                    left = i2 + right;
                    break;
                }
                right++;
                z4 = z2;
                z2 = z3;
                z3 = z4;
            }
            left2 = z2;
            left = i2;
            i = i3;
            i3 = left;
            z2 = true;
        } else {
            int i4 = this.an;
            left = (i2 + childCount) - 1;
            int i5 = childCount - 1;
            i = 0;
            while (i5 >= 0) {
                int i6;
                View childAt2 = getChildAt(i5);
                i3 = childAt2.getLeft();
                int right2 = childAt2.getRight();
                if (i5 != childCount - 1) {
                    i6 = right;
                    right = i;
                    i = i6;
                } else if (i2 + childCount < i4 || right2 > right) {
                    i = right - getHorizontalFadingEdgeLength();
                    right = i3;
                } else {
                    i = right;
                    right = i3;
                }
                if (right2 <= i) {
                    i = i3;
                    i3 = i2 + i5;
                    z2 = false;
                    break;
                }
                i5--;
                i6 = i;
                i = right;
                right = i6;
            }
            i3 = left;
            z2 = false;
        }
        this.f1862M = -1;
        removeCallbacks(this.au);
        if (this.f1858I != null) {
            this.f1858I.m2396a();
        }
        this.f1855F = -1;
        m2157F();
        this.W = i;
        left = m2143b(i3, z2);
        if (left < i2 || left > getLastVisiblePosition()) {
            left = -1;
        } else {
            this.f1876h = 4;
            m2223j();
            setSelectionInt(left);
            m2204b();
        }
        m2205b(0);
        if (left < 0) {
            z = false;
        }
        return z;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnTouchModeChangeListener(this);
        if (this.f1878j != null && this.f1877i == null) {
            this.f1877i = new C0277c(this);
            this.f1878j.registerDataSetObserver(this.f1877i);
            this.ai = true;
            this.ao = this.an;
            this.an = this.f1878j.getCount();
        }
        this.f1868S = true;
    }

    @SuppressLint({"Override"})
    protected int[] onCreateDrawableState(int i) {
        if (this.aH) {
            return super.onCreateDrawableState(i);
        }
        int i2 = ENABLED_STATE_SET[0];
        Object onCreateDrawableState = super.onCreateDrawableState(i + 1);
        int length = onCreateDrawableState.length - 1;
        while (length >= 0) {
            if (onCreateDrawableState[length] == i2) {
                break;
            }
            length--;
        }
        length = -1;
        if (length < 0) {
            return onCreateDrawableState;
        }
        System.arraycopy(onCreateDrawableState, length + 1, onCreateDrawableState, length, (onCreateDrawableState.length - length) - 1);
        return onCreateDrawableState;
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return null;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f1884p.m2406b();
        getViewTreeObserver().removeOnTouchModeChangeListener(this);
        if (!(this.f1878j == null || this.f1877i == null)) {
            this.f1878j.unregisterDataSetObserver(this.f1877i);
            this.f1877i = null;
        }
        if (this.au != null) {
            removeCallbacks(this.au);
        }
        if (this.f1858I != null) {
            this.f1858I.m2396a();
        }
        if (this.aK != null) {
            removeCallbacks(this.aK);
        }
        if (this.aD != null) {
            removeCallbacks(this.aD);
        }
        if (this.aE != null) {
            removeCallbacks(this.aE);
            this.aE = null;
        }
        this.f1868S = false;
    }

    protected void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (z && this.al < 0 && !isInTouchMode()) {
            if (!(this.f1868S || this.f1878j == null)) {
                this.ai = true;
                this.ao = this.an;
                this.an = this.f1878j.getCount();
            }
            m2228o();
        }
    }

    @TargetApi(12)
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0) {
            switch (motionEvent.getAction()) {
                case cm.ExpandableHListView_hlv_childIndicatorPaddingTop /*8*/:
                    if (this.f1855F == -1) {
                        float axisValue = motionEvent.getAxisValue(10);
                        if (axisValue != 0.0f) {
                            int horizontalScrollFactor = (int) (axisValue * getHorizontalScrollFactor());
                            if (!m2213d(horizontalScrollFactor, horizontalScrollFactor)) {
                                return true;
                            }
                        }
                    }
                    break;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(AbsHListView.class.getName());
    }

    @TargetApi(14)
    @SuppressLint({"Override"})
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(AbsHListView.class.getName());
        if (isEnabled()) {
            if (getFirstVisiblePosition() > 0) {
                accessibilityNodeInfo.addAction(8192);
            }
            if (getLastVisiblePosition() < getCount() - 1) {
                accessibilityNodeInfo.addAction(4096);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.f1858I != null) {
            this.f1858I.m2396a();
        }
        if (!this.f1868S) {
            return false;
        }
        switch (action & 255) {
            case cm.HListView_android_entries /*0*/:
                action = this.f1855F;
                if (action == 6 || action == 5) {
                    this.f1857H = 0;
                    return true;
                }
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                this.aO = motionEvent.getPointerId(0);
                int f = m2217f(x);
                if (action != 4 && f >= 0) {
                    this.f1851B = getChildAt(f - this.V).getLeft();
                    this.f1853D = x;
                    this.f1854E = y;
                    this.f1850A = f;
                    this.f1855F = 0;
                    m2157F();
                }
                this.f1856G = Integer.MIN_VALUE;
                m2153B();
                this.at.addMovement(motionEvent);
                return action == 4;
            case cm.HListView_android_divider /*1*/:
            case cm.HListView_hlv_headerDividersEnabled /*3*/:
                this.f1855F = -1;
                this.aO = -1;
                m2155D();
                m2205b(0);
                return false;
            case cm.HListView_hlv_dividerWidth /*2*/:
                switch (this.f1855F) {
                    case cm.HListView_android_entries /*0*/:
                        action = motionEvent.findPointerIndex(this.aO);
                        if (action == -1) {
                            this.aO = motionEvent.getPointerId(0);
                            action = 0;
                        }
                        action = (int) motionEvent.getX(action);
                        m2154C();
                        this.at.addMovement(motionEvent);
                        return m2184i(action);
                    default:
                        return false;
                }
            case cm.HListView_hlv_overScrollFooter /*6*/:
                m2169b(motionEvent);
                return false;
            default:
                return false;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        switch (i) {
            case 23:
            case 66:
                if (!isEnabled()) {
                    return true;
                }
                if (isClickable() && isPressed() && this.al >= 0 && this.f1878j != null && this.al < this.f1878j.getCount()) {
                    View childAt = getChildAt(this.al - this.V);
                    if (childAt != null) {
                        m2202a(childAt, this.al, this.am);
                        childAt.setPressed(false);
                    }
                    setPressed(false);
                    return true;
                }
        }
        return super.onKeyUp(i, keyEvent);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.ae = true;
        if (z) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                getChildAt(i5).forceLayout();
            }
            this.f1884p.m2402a();
        }
        m2214e();
        this.ae = false;
        this.f1863N = (i3 - i) / 3;
    }

    protected void onMeasure(int i, int i2) {
        if (this.f1881m == null) {
            m2152A();
        }
        Rect rect = this.f1889u;
        rect.left = this.f1885q + getPaddingLeft();
        rect.top = this.f1886r + getPaddingTop();
        rect.right = this.f1887s + getPaddingRight();
        rect.bottom = this.f1888t + getPaddingBottom();
        if (this.aF == 1) {
            int childCount = getChildCount();
            int width = getWidth() - getPaddingRight();
            View childAt = getChildAt(childCount - 1);
            boolean z = childCount + this.V >= this.ba && (childAt != null ? childAt.getRight() : width) <= width;
            this.aU = z;
        }
    }

    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        if (getScrollX() != i) {
            onScrollChanged(i, getScrollY(), getScrollX(), getScrollY());
            this.f1869a.m2118a(i);
            m2224k();
            awakenScrollBars();
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.ai = true;
        this.ab = (long) savedState.f1834e;
        if (savedState.f1830a >= 0) {
            this.ac = true;
            this.bb = savedState;
            this.aa = savedState.f1830a;
            this.Z = savedState.f1833d;
            this.W = savedState.f1832c;
            this.ad = 0;
        } else if (savedState.f1831b >= 0) {
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.f1882n = -1;
            this.ac = true;
            this.bb = savedState;
            this.aa = savedState.f1831b;
            this.Z = savedState.f1833d;
            this.W = savedState.f1832c;
            this.ad = 1;
        }
        if (savedState.f1838i != null) {
            this.f1874f = savedState.f1838i;
        }
        if (savedState.f1839j != null) {
            this.f1875g = savedState.f1839j;
        }
        this.f1873e = savedState.f1837h;
        if (VERSION.SDK_INT >= 11 && savedState.f1836g && this.f1870b == 3 && this.f1872d != null) {
            this.f1871c = startActionMode((C0267b) this.f1872d);
        }
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        boolean z = true;
        int i = 0;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.bb != null) {
            savedState.f1830a = this.bb.f1830a;
            savedState.f1831b = this.bb.f1831b;
            savedState.f1832c = this.bb.f1832c;
            savedState.f1833d = this.bb.f1833d;
            savedState.f1834e = this.bb.f1834e;
            savedState.f1835f = this.bb.f1835f;
            savedState.f1836g = this.bb.f1836g;
            savedState.f1837h = this.bb.f1837h;
            savedState.f1838i = this.bb.f1838i;
            savedState.f1839j = this.bb.f1839j;
            return savedState;
        }
        boolean z2 = getChildCount() > 0 && this.an > 0;
        long selectedItemId = getSelectedItemId();
        savedState.f1830a = selectedItemId;
        savedState.f1834e = getWidth();
        if (selectedItemId >= 0) {
            savedState.f1832c = this.f1859J;
            savedState.f1833d = getSelectedItemPosition();
            savedState.f1831b = -1;
        } else if (!z2 || this.V <= 0) {
            savedState.f1832c = 0;
            savedState.f1831b = -1;
            savedState.f1833d = 0;
        } else {
            savedState.f1832c = getChildAt(0).getLeft();
            int i2 = this.V;
            if (i2 >= this.an) {
                i2 = this.an - 1;
            }
            savedState.f1833d = i2;
            savedState.f1831b = this.f1878j.getItemId(i2);
        }
        savedState.f1835f = null;
        if (VERSION.SDK_INT < 11 || this.f1870b != 3 || this.f1871c == null) {
            z = false;
        }
        savedState.f1836g = z;
        if (this.f1874f != null) {
            try {
                savedState.f1838i = this.f1874f.m262a();
            } catch (NoSuchMethodError e) {
                e.printStackTrace();
                savedState.f1838i = new C0046n();
            }
        }
        if (this.f1875g != null) {
            C0040f c0040f = new C0040f();
            int b = this.f1875g.m256b();
            while (i < b) {
                c0040f.m255a(this.f1875g.m251a(i), this.f1875g.m257b(i));
                i++;
            }
            savedState.f1839j = c0040f;
        }
        savedState.f1837h = this.f1873e;
        return savedState;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (getChildCount() > 0) {
            this.ai = true;
            m2151w();
        }
    }

    @SuppressLint({"Override"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        if (isEnabled()) {
            if (this.f1858I != null) {
                this.f1858I.m2396a();
            }
            if (!this.f1868S) {
                return false;
            }
            int action = motionEvent.getAction();
            m2154C();
            this.at.addMovement(motionEvent);
            int x;
            int y;
            int a;
            Handler handler;
            switch (action & 255) {
                case cm.HListView_android_entries /*0*/:
                    switch (this.f1855F) {
                        case cm.HListView_hlv_overScrollFooter /*6*/:
                            this.au.m2390b();
                            if (this.f1858I != null) {
                                this.f1858I.m2396a();
                            }
                            this.f1855F = 5;
                            this.f1854E = (int) motionEvent.getY();
                            action = (int) motionEvent.getX();
                            this.f1856G = action;
                            this.f1853D = action;
                            this.f1857H = 0;
                            this.aO = motionEvent.getPointerId(0);
                            this.aT = 0;
                            break;
                        default:
                            this.aO = motionEvent.getPointerId(0);
                            x = (int) motionEvent.getX();
                            y = (int) motionEvent.getY();
                            a = m2191a(x, y);
                            if (!this.ai) {
                                if (this.f1855F == 4 || a < 0 || !((ListAdapter) getAdapter()).isEnabled(a)) {
                                    if (this.f1855F == 4) {
                                        m2156E();
                                        this.f1855F = 3;
                                        this.f1857H = 0;
                                        action = m2217f(x);
                                        this.au.m2392c();
                                        if (action >= 0) {
                                            this.f1851B = getChildAt(action - this.V).getLeft();
                                        }
                                        this.f1853D = x;
                                        this.f1854E = y;
                                        this.f1850A = action;
                                        this.f1856G = Integer.MIN_VALUE;
                                        break;
                                    }
                                }
                                this.f1855F = 0;
                                if (this.aB == null) {
                                    this.aB = new C0281f(this);
                                }
                                postDelayed(this.aB, (long) ViewConfiguration.getTapTimeout());
                                action = a;
                                if (action >= 0) {
                                    this.f1851B = getChildAt(action - this.V).getLeft();
                                }
                                this.f1853D = x;
                                this.f1854E = y;
                                this.f1850A = action;
                                this.f1856G = Integer.MIN_VALUE;
                            }
                            action = a;
                            if (action >= 0) {
                                this.f1851B = getChildAt(action - this.V).getLeft();
                            }
                            this.f1853D = x;
                            this.f1854E = y;
                            this.f1850A = action;
                            this.f1856G = Integer.MIN_VALUE;
                            break;
                    }
                    if (!m2201a(motionEvent) || this.f1855F != 0) {
                        return true;
                    }
                    removeCallbacks(this.aB);
                    return true;
                case cm.HListView_android_divider /*1*/:
                    switch (this.f1855F) {
                        case cm.HListView_android_entries /*0*/:
                        case cm.HListView_android_divider /*1*/:
                        case cm.HListView_hlv_dividerWidth /*2*/:
                            a = this.f1850A;
                            View childAt = getChildAt(a - this.V);
                            float x2 = motionEvent.getX();
                            boolean z = x2 > ((float) this.f1889u.left) && x2 < ((float) (getWidth() - this.f1889u.right));
                            if (!(childAt == null || childAt.hasFocusable() || !z)) {
                                if (this.f1855F != 0) {
                                    childAt.setPressed(false);
                                }
                                if (this.aD == null) {
                                    this.aD = new C0287l();
                                }
                                C0287l c0287l = this.aD;
                                c0287l.f1981a = a;
                                c0287l.m2384a();
                                this.f1862M = a;
                                if (this.f1855F == 0 || this.f1855F == 1) {
                                    Handler handler2 = getHandler();
                                    if (handler2 != null) {
                                        handler2.removeCallbacks(this.f1855F == 0 ? this.aB : this.aA);
                                    }
                                    this.f1876h = 0;
                                    if (this.ai || !this.f1878j.isEnabled(a)) {
                                        this.f1855F = -1;
                                        m2223j();
                                        return true;
                                    }
                                    this.f1855F = 1;
                                    setSelectedPositionInt(this.f1850A);
                                    m2214e();
                                    childAt.setPressed(true);
                                    m2196a(this.f1850A, childAt);
                                    setPressed(true);
                                    if (this.f1881m != null) {
                                        Drawable current = this.f1881m.getCurrent();
                                        if (current != null && (current instanceof TransitionDrawable)) {
                                            ((TransitionDrawable) current).resetTransition();
                                        }
                                    }
                                    if (this.aE != null) {
                                        removeCallbacks(this.aE);
                                    }
                                    this.aE = new C0274a(this, childAt, c0287l);
                                    postDelayed(this.aE, (long) ViewConfiguration.getPressedStateDuration());
                                    return true;
                                } else if (!this.ai && this.f1878j.isEnabled(a)) {
                                    c0287l.run();
                                }
                            }
                            this.f1855F = -1;
                            m2223j();
                            break;
                        case cm.HListView_hlv_headerDividersEnabled /*3*/:
                            action = getChildCount();
                            if (action <= 0) {
                                this.f1855F = -1;
                                m2205b(0);
                                break;
                            }
                            a = getChildAt(0).getLeft();
                            x = getChildAt(action - 1).getRight();
                            y = this.f1889u.left;
                            int width = getWidth() - this.f1889u.right;
                            if (this.V == 0 && a >= y && this.V + action < this.an && x <= getWidth() - width) {
                                this.f1855F = -1;
                                m2205b(0);
                                break;
                            }
                            VelocityTracker velocityTracker = this.at;
                            velocityTracker.computeCurrentVelocity(1000, (float) this.aM);
                            int xVelocity = (int) (velocityTracker.getXVelocity(this.aO) * this.aN);
                            if (Math.abs(xVelocity) > this.aL && ((this.V != 0 || a != y - this.f1866Q) && (action + this.V != this.an || x != this.f1866Q + width))) {
                                if (this.au == null) {
                                    this.au = new C0282g(this);
                                }
                                m2205b(2);
                                this.au.m2388a(-xVelocity);
                                break;
                            }
                            this.f1855F = -1;
                            m2205b(0);
                            if (this.au != null) {
                                this.au.m2390b();
                            }
                            if (this.f1858I != null) {
                                this.f1858I.m2396a();
                                break;
                            }
                            break;
                        case cm.HListView_hlv_overScrollHeader /*5*/:
                            if (this.au == null) {
                                this.au = new C0282g(this);
                            }
                            VelocityTracker velocityTracker2 = this.at;
                            velocityTracker2.computeCurrentVelocity(1000, (float) this.aM);
                            action = (int) velocityTracker2.getXVelocity(this.aO);
                            m2205b(2);
                            if (Math.abs(action) <= this.aL) {
                                this.au.m2387a();
                                break;
                            }
                            this.au.m2391b(-action);
                            break;
                    }
                    setPressed(false);
                    if (this.aP != null) {
                        this.aP.m813c();
                        this.aQ.m813c();
                    }
                    invalidate();
                    handler = getHandler();
                    if (handler != null) {
                        handler.removeCallbacks(this.aA);
                    }
                    m2155D();
                    this.aO = -1;
                    return true;
                case cm.HListView_hlv_dividerWidth /*2*/:
                    action = motionEvent.findPointerIndex(this.aO);
                    if (action == -1) {
                        this.aO = motionEvent.getPointerId(0);
                    } else {
                        i = action;
                    }
                    action = (int) motionEvent.getX(i);
                    if (this.ai) {
                        m2214e();
                    }
                    switch (this.f1855F) {
                        case cm.HListView_android_entries /*0*/:
                        case cm.HListView_android_divider /*1*/:
                        case cm.HListView_hlv_dividerWidth /*2*/:
                            m2184i(action);
                            return true;
                        case cm.HListView_hlv_headerDividersEnabled /*3*/:
                        case cm.HListView_hlv_overScrollHeader /*5*/:
                            m2186j(action);
                            return true;
                        default:
                            return true;
                    }
                case cm.HListView_hlv_headerDividersEnabled /*3*/:
                    switch (this.f1855F) {
                        case cm.HListView_hlv_overScrollHeader /*5*/:
                            if (this.au == null) {
                                this.au = new C0282g(this);
                            }
                            this.au.m2387a();
                            break;
                        case cm.HListView_hlv_overScrollFooter /*6*/:
                            break;
                        default:
                            this.f1855F = -1;
                            setPressed(false);
                            View childAt2 = getChildAt(this.f1850A - this.V);
                            if (childAt2 != null) {
                                childAt2.setPressed(false);
                            }
                            m2157F();
                            handler = getHandler();
                            if (handler != null) {
                                handler.removeCallbacks(this.aA);
                            }
                            m2155D();
                            break;
                    }
                    if (this.aP != null) {
                        this.aP.m813c();
                        this.aQ.m813c();
                    }
                    this.aO = -1;
                    return true;
                case cm.HListView_hlv_overScrollHeader /*5*/:
                    action = motionEvent.getActionIndex();
                    a = motionEvent.getPointerId(action);
                    x = (int) motionEvent.getX(action);
                    action = (int) motionEvent.getY(action);
                    this.f1857H = 0;
                    this.aO = a;
                    this.f1853D = x;
                    this.f1854E = action;
                    action = m2191a(x, action);
                    if (action >= 0) {
                        this.f1851B = getChildAt(action - this.V).getLeft();
                        this.f1850A = action;
                    }
                    this.f1856G = x;
                    return true;
                case cm.HListView_hlv_overScrollFooter /*6*/:
                    m2169b(motionEvent);
                    action = this.f1853D;
                    i = m2191a(action, this.f1854E);
                    if (i >= 0) {
                        this.f1851B = getChildAt(i - this.V).getLeft();
                        this.f1850A = i;
                    }
                    this.f1856G = action;
                    return true;
                default:
                    return true;
            }
        }
        z = isClickable() || isLongClickable();
        return z;
    }

    public void onTouchModeChanged(boolean z) {
        if (z) {
            m2225l();
            if (getWidth() > 0 && getChildCount() > 0) {
                m2214e();
            }
            m2223j();
            return;
        }
        int i = this.f1855F;
        if (i == 5 || i == 6) {
            if (this.au != null) {
                this.au.m2390b();
            }
            if (this.f1858I != null) {
                this.f1858I.m2396a();
            }
            if (getScrollX() != 0) {
                this.f1869a.m2118a(0);
                m2158G();
                invalidate();
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        int i = isInTouchMode() ? 0 : 1;
        if (!z) {
            setChildrenDrawingCacheEnabled(false);
            if (this.au != null) {
                removeCallbacks(this.au);
                this.au.m2390b();
                if (this.f1858I != null) {
                    this.f1858I.m2396a();
                }
                if (getScrollX() != 0) {
                    this.f1869a.m2118a(0);
                    m2158G();
                    invalidate();
                }
            }
            if (i == 1) {
                this.f1862M = this.al;
            }
        } else if (!(i == this.az || this.az == -1)) {
            if (i == 1) {
                m2228o();
            } else {
                m2225l();
                this.f1876h = 0;
                m2214e();
            }
        }
        this.az = i;
    }

    void m2229p() {
        this.f1874f.m269c();
        int i = 0;
        boolean z = false;
        while (i < this.f1875g.m256b()) {
            int max;
            boolean z2;
            long a = this.f1875g.m251a(i);
            int intValue = ((Integer) this.f1875g.m257b(i)).intValue();
            if (a != this.f1878j.getItemId(intValue)) {
                boolean z3;
                int min = Math.min(intValue + 20, this.an);
                for (max = Math.max(0, intValue - 20); max < min; max++) {
                    if (a == this.f1878j.getItemId(max)) {
                        this.f1874f.m267b(max, Boolean.valueOf(true));
                        this.f1875g.m253a(i, Integer.valueOf(max));
                        z3 = true;
                        break;
                    }
                }
                z3 = false;
                if (!z3) {
                    this.f1875g.m254a(a);
                    int i2 = i - 1;
                    this.f1873e--;
                    if (!(VERSION.SDK_INT <= 11 || this.f1871c == null || this.f1872d == null)) {
                        ((C0267b) this.f1872d).m2114a((ActionMode) this.f1871c, intValue, a, false);
                    }
                    i = i2;
                    z = true;
                }
                max = i;
                z2 = z;
            } else {
                this.f1874f.m267b(intValue, Boolean.valueOf(true));
                max = i;
                z2 = z;
            }
            z = z2;
            i = max + 1;
        }
        if (z && this.f1871c != null && VERSION.SDK_INT > 11) {
            ((ActionMode) this.f1871c).invalidate();
        }
    }

    @TargetApi(16)
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        if (super.performAccessibilityAction(i, bundle)) {
            return true;
        }
        switch (i) {
            case 4096:
                if (!isEnabled() || getLastVisiblePosition() >= getCount() - 1) {
                    return false;
                }
                m2209c((getWidth() - this.f1889u.left) - this.f1889u.right, 200);
                return true;
            case 8192:
                if (!isEnabled() || this.V <= 0) {
                    return false;
                }
                m2209c(-((getWidth() - this.f1889u.left) - this.f1889u.right), 200);
                return true;
            default:
                return false;
        }
    }

    protected void m2230q() {
        int i = this.an;
        int i2 = this.ba;
        this.ba = this.an;
        if (!(this.f1870b == 0 || this.f1878j == null || !this.f1878j.hasStableIds())) {
            m2229p();
        }
        this.f1884p.m2409c();
        if (i > 0) {
            int width;
            int bottom;
            if (this.ac) {
                this.ac = false;
                this.bb = null;
                if (this.aF == 2) {
                    this.f1876h = 3;
                    return;
                }
                if (this.aF == 1) {
                    if (this.aU) {
                        this.aU = false;
                        this.f1876h = 3;
                        return;
                    }
                    int childCount = getChildCount();
                    width = getWidth() - getPaddingRight();
                    View childAt = getChildAt(childCount - 1);
                    bottom = childAt != null ? childAt.getBottom() : width;
                    if (childCount + this.V < i2 || bottom > width) {
                        awakenScrollBars();
                    } else {
                        this.f1876h = 3;
                        return;
                    }
                }
                switch (this.ad) {
                    case cm.HListView_android_entries /*0*/:
                        if (isInTouchMode()) {
                            this.f1876h = 5;
                            this.Z = Math.min(Math.max(0, this.Z), i - 1);
                            return;
                        }
                        bottom = m2150v();
                        if (bottom >= 0 && m2143b(bottom, true) == bottom) {
                            this.Z = bottom;
                            if (this.ab == ((long) getWidth())) {
                                this.f1876h = 5;
                            } else {
                                this.f1876h = 2;
                            }
                            setNextSelectedPositionInt(bottom);
                            return;
                        }
                    case cm.HListView_android_divider /*1*/:
                        this.f1876h = 5;
                        this.Z = Math.min(Math.max(0, this.Z), i - 1);
                        return;
                }
            }
            if (!isInTouchMode()) {
                bottom = getSelectedItemPosition();
                if (bottom >= i) {
                    bottom = i - 1;
                }
                if (bottom < 0) {
                    bottom = 0;
                }
                width = m2143b(bottom, true);
                if (width >= 0) {
                    setNextSelectedPositionInt(width);
                    return;
                }
                bottom = m2143b(bottom, false);
                if (bottom >= 0) {
                    setNextSelectedPositionInt(bottom);
                    return;
                }
            } else if (this.f1862M >= 0) {
                return;
            }
        }
        this.f1876h = this.f1860K ? 3 : 1;
        this.al = -1;
        this.am = Long.MIN_VALUE;
        this.aj = -1;
        this.ak = Long.MIN_VALUE;
        this.ac = false;
        this.bb = null;
        this.f1882n = -1;
        m2149u();
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            m2155D();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void requestLayout() {
        if (!this.as && !this.ae) {
            super.requestLayout();
        }
    }

    public void sendAccessibilityEvent(int i) {
        if (i == 4096) {
            int firstVisiblePosition = getFirstVisiblePosition();
            int lastVisiblePosition = getLastVisiblePosition();
            if (this.aY != firstVisiblePosition || this.aZ != lastVisiblePosition) {
                this.aY = firstVisiblePosition;
                this.aZ = lastVisiblePosition;
            } else {
                return;
            }
        }
        super.sendAccessibilityEvent(i);
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.f1879k = this.f1878j.hasStableIds();
            if (this.f1870b != 0 && this.f1879k && this.f1875g == null) {
                this.f1875g = new C0040f();
            }
        }
        if (this.f1874f != null) {
            this.f1874f.m269c();
        }
        if (this.f1875g != null) {
            this.f1875g.m258c();
        }
    }

    public void setCacheColorHint(int i) {
        if (i != this.aG) {
            this.aG = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                getChildAt(i2).setDrawingCacheBackgroundColor(i);
            }
            this.f1884p.m2414f(i);
        }
    }

    @TargetApi(11)
    public void setChoiceMode(int i) {
        this.f1870b = i;
        if (VERSION.SDK_INT >= 11 && this.f1871c != null) {
            if (VERSION.SDK_INT >= 11) {
                ((ActionMode) this.f1871c).finish();
            }
            this.f1871c = null;
        }
        if (this.f1870b != 0) {
            if (this.f1874f == null) {
                this.f1874f = new C0046n();
            }
            if (this.f1875g == null && this.f1878j != null && this.f1878j.hasStableIds()) {
                this.f1875g = new C0040f();
            }
            if (VERSION.SDK_INT >= 11 && this.f1870b == 3) {
                m2194a();
                setLongClickable(true);
            }
        }
    }

    public void setDrawSelectorOnTop(boolean z) {
        this.f1880l = z;
    }

    public void setFriction(float f) {
        if (this.au == null) {
            this.au = new C0282g(this);
        }
        this.au.f1971b.m2354b(f);
    }

    @TargetApi(11)
    public void setMultiChoiceModeListener(C0266a c0266a) {
        if (VERSION.SDK_INT >= 11) {
            if (this.f1872d == null) {
                this.f1872d = new C0267b(this);
            }
            ((C0267b) this.f1872d).m2115a(c0266a);
            return;
        }
        Log.e("AbsListView", "setMultiChoiceModeListener not supported for this version of Android");
    }

    public void setOnScrollListener(C0286k c0286k) {
        this.av = c0286k;
        m2204b();
    }

    public void setOverScrollMode(int i) {
        if (i == 2) {
            this.aP = null;
            this.aQ = null;
        } else if (this.aP == null) {
            Context context = getContext();
            this.aP = new C0105f(context);
            this.aQ = new C0105f(context);
        }
        super.setOverScrollMode(i);
    }

    public void setRecyclerListener(C0292q c0292q) {
        this.f1884p.f1997b = c0292q;
    }

    public void setScrollingCacheEnabled(boolean z) {
        if (this.f1861L && !z) {
            m2157F();
        }
        this.f1861L = z;
    }

    public abstract void setSelectionInt(int i);

    public void setSelector(int i) {
        setSelector(getResources().getDrawable(i));
    }

    public void setSelector(Drawable drawable) {
        if (this.f1881m != null) {
            this.f1881m.setCallback(null);
            unscheduleDrawable(this.f1881m);
        }
        this.f1881m = drawable;
        Rect rect = new Rect();
        drawable.getPadding(rect);
        this.f1885q = rect.left;
        this.f1886r = rect.top;
        this.f1887s = rect.right;
        this.f1888t = rect.bottom;
        drawable.setCallback(this);
        m2223j();
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.aw = z;
    }

    public void setStackFromRight(boolean z) {
        if (this.f1860K != z) {
            this.f1860K = z;
            m2207c();
        }
    }

    public void setTranscriptMode(int i) {
        this.aF = i;
    }

    public void setVelocityScale(float f) {
        this.aN = f;
    }

    public boolean showContextMenuForChild(View view) {
        boolean z = false;
        int a = m2141a(view);
        if (a < 0) {
            return false;
        }
        long itemId = this.f1878j.getItemId(a);
        if (this.ah != null) {
            z = this.ah.m2419a(this, view, a, itemId);
        }
        if (z) {
            return z;
        }
        this.ay = m2203b(getChildAt(a - this.V), a, itemId);
        return super.showContextMenuForChild(view);
    }

    public boolean verifyDrawable(Drawable drawable) {
        return this.f1881m == drawable || super.verifyDrawable(drawable);
    }
}
