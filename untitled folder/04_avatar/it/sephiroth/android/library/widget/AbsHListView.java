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
import android.support.v4.c.n;
import android.support.v4.widget.f;
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
import it.sephiroth.android.library.a.a;
import it.sephiroth.android.library.a.b;
import java.util.ArrayList;

@TargetApi(11)
public abstract class AbsHListView extends u implements OnGlobalLayoutListener, OnTouchModeChangeListener {
    static final Interpolator T;
    public static final int[] U;
    protected int A;
    int B;
    int C;
    int D;
    int E;
    protected int F;
    int G;
    int H;
    protected m I;
    protected int J;
    protected boolean K;
    boolean L;
    protected int M;
    protected int N;
    protected Runnable O;
    protected final boolean[] P;
    int Q;
    int R;
    protected boolean S;
    b a;
    private e aA;
    private Runnable aB;
    private d aC;
    private l aD;
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
    private f aP;
    private f aQ;
    private int aR;
    private int aS;
    private int aT;
    private boolean aU;
    private int aV;
    private int aW;
    private j aX;
    private int aY;
    private int aZ;
    private VelocityTracker at;
    private g au;
    private k av;
    private boolean aw;
    private Rect ax;
    private ContextMenuInfo ay;
    private int az;
    protected int b;
    private int ba;
    private SavedState bb;
    private float bc;
    public Object c;
    Object d;
    int e;
    protected n f;
    android.support.v4.c.f g;
    protected int h;
    protected c i;
    protected ListAdapter j;
    boolean k;
    boolean l;
    Drawable m;
    int n;
    protected Rect o;
    protected final p p;
    int q;
    int r;
    int s;
    int t;
    protected Rect u;
    protected int v;
    View w;
    View x;
    protected boolean y;
    protected boolean z;

    class SavedState extends BaseSavedState {
        public static final Creator CREATOR;
        long a;
        long b;
        int c;
        int d;
        int e;
        String f;
        boolean g;
        int h;
        n i;
        android.support.v4.c.f j;

        static {
            CREATOR = new r();
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readLong();
            this.b = parcel.readLong();
            this.c = parcel.readInt();
            this.d = parcel.readInt();
            this.e = parcel.readInt();
            this.f = parcel.readString();
            this.g = parcel.readByte() != null;
            this.h = parcel.readInt();
            this.i = b(parcel);
            this.j = a(parcel);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private android.support.v4.c.f a(Parcel parcel) {
            int readInt = parcel.readInt();
            if (readInt <= 0) {
                return null;
            }
            android.support.v4.c.f fVar = new android.support.v4.c.f(readInt);
            a(fVar, parcel, readInt);
            return fVar;
        }

        private void a(android.support.v4.c.f fVar, Parcel parcel) {
            int i = 0;
            int b = fVar != null ? fVar.b() : 0;
            parcel.writeInt(b);
            while (i < b) {
                parcel.writeLong(fVar.a(i));
                parcel.writeInt(((Integer) fVar.b(i)).intValue());
                i++;
            }
        }

        private void a(android.support.v4.c.f fVar, Parcel parcel, int i) {
            while (i > 0) {
                fVar.a(parcel.readLong(), Integer.valueOf(parcel.readInt()));
                i--;
            }
        }

        private void a(n nVar, Parcel parcel) {
            if (nVar == null) {
                parcel.writeInt(-1);
                return;
            }
            int b = nVar.b();
            parcel.writeInt(b);
            for (int i = 0; i < b; i++) {
                parcel.writeInt(nVar.b(i));
                parcel.writeByte((byte) (((Boolean) nVar.c(i)).booleanValue() ? 1 : 0));
            }
        }

        private void a(n nVar, Parcel parcel, int i) {
            while (i > 0) {
                nVar.c(parcel.readInt(), Boolean.valueOf(parcel.readByte() == (byte) 1));
                i--;
            }
        }

        private n b(Parcel parcel) {
            int readInt = parcel.readInt();
            if (readInt < 0) {
                return null;
            }
            n nVar = new n(readInt);
            a(nVar, parcel, readInt);
            return nVar;
        }

        public String toString() {
            return "AbsListView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.a + " firstId=" + this.b + " viewLeft=" + this.c + " position=" + this.d + " width=" + this.e + " filter=" + this.f + " checkState=" + this.i + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.a);
            parcel.writeLong(this.b);
            parcel.writeInt(this.c);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e);
            parcel.writeString(this.f);
            parcel.writeByte((byte) (this.g ? 1 : 0));
            parcel.writeInt(this.h);
            a(this.i, parcel);
            a(this.j, parcel);
        }
    }

    static {
        T = new LinearInterpolator();
        U = new int[]{0};
    }

    public AbsHListView(Context context) {
        super(context);
        this.b = 0;
        this.h = 0;
        this.l = false;
        this.n = -1;
        this.o = new Rect();
        this.p = new p(this);
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = new Rect();
        this.v = 0;
        this.F = -1;
        this.J = 0;
        this.aw = true;
        this.M = -1;
        this.ay = null;
        this.az = -1;
        this.aI = 0;
        this.aN = 1.0f;
        this.P = new boolean[1];
        this.aO = -1;
        this.aT = 0;
        x();
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
        this.b = 0;
        this.h = 0;
        this.l = false;
        this.n = -1;
        this.o = new Rect();
        this.p = new p(this);
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = new Rect();
        this.v = 0;
        this.F = -1;
        this.J = 0;
        this.aw = true;
        this.M = -1;
        this.ay = null;
        this.az = -1;
        this.aI = 0;
        this.aN = 1.0f;
        this.P = new boolean[1];
        this.aO = -1;
        this.aT = 0;
        x();
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
        this.l = z;
        setStackFromRight(z2);
        setScrollingCacheEnabled(z3);
        setTranscriptMode(i2);
        setCacheColorHint(color);
        setSmoothScrollbarEnabled(z4);
        setChoiceMode(i3);
    }

    private void A() {
        setSelector(getResources().getDrawable(17301602));
    }

    private void B() {
        if (this.at == null) {
            this.at = VelocityTracker.obtain();
        } else {
            this.at.clear();
        }
    }

    private void C() {
        if (this.at == null) {
            this.at = VelocityTracker.obtain();
        }
    }

    private void D() {
        if (this.at != null) {
            this.at.recycle();
            this.at = null;
        }
    }

    private void E() {
        if (this.L && !this.y && !this.a.a()) {
            setChildrenDrawnWithCacheEnabled(true);
            setChildrenDrawingCacheEnabled(true);
            this.z = true;
            this.y = true;
        }
    }

    private void F() {
        if (!this.a.a()) {
            if (this.aK == null) {
                this.aK = new b(this);
            }
            post(this.aK);
        }
    }

    private void G() {
        if (this.aP != null) {
            this.aP.b();
            this.aQ.b();
        }
    }

    public static int a(Rect rect, Rect rect2, int i) {
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

    static View a(ArrayList arrayList, int i) {
        int size = arrayList.size();
        if (size <= 0) {
            return null;
        }
        for (int i2 = 0; i2 < size; i2++) {
            View view = (View) arrayList.get(i2);
            if (((i) view.getLayoutParams()).d == i) {
                arrayList.remove(i2);
                return view;
            }
        }
        return (View) arrayList.remove(size - 1);
    }

    private void a(int i, int i2, int i3, int i4) {
        this.o.set(i - this.q, i2 - this.r, this.s + i3, this.t + i4);
    }

    private void a(Canvas canvas) {
        if (!this.o.isEmpty()) {
            Drawable drawable = this.m;
            drawable.setBounds(this.o);
            drawable.draw(canvas);
        }
    }

    private void b(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (motionEvent.getPointerId(action) == this.aO) {
            action = action == 0 ? 1 : 0;
            this.D = (int) motionEvent.getX(action);
            this.E = (int) motionEvent.getY(action);
            this.H = 0;
            this.aO = motionEvent.getPointerId(action);
        }
    }

    private boolean i(int i) {
        int i2 = i - this.D;
        int abs = Math.abs(i2);
        boolean z = getScrollX() != 0;
        if (!z && abs <= this.aJ) {
            return false;
        }
        E();
        if (z) {
            this.F = 5;
            this.H = 0;
        } else {
            this.F = 3;
            this.H = i2 > 0 ? this.aJ : -this.aJ;
        }
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.aA);
        }
        setPressed(false);
        View childAt = getChildAt(this.A - this.V);
        if (childAt != null) {
            childAt.setPressed(false);
        }
        b(1);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        j(i);
        return true;
    }

    private void j(int i) {
        int i2 = 0;
        int i3 = i - this.D;
        int i4 = i3 - this.H;
        int i5 = this.G != Integer.MIN_VALUE ? i - this.G : i4;
        int childCount;
        int left;
        if (this.F == 3) {
            if (i != this.G) {
                if (Math.abs(i3) > this.aJ) {
                    ViewParent parent = getParent();
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                }
                childCount = this.A >= 0 ? this.A - this.V : getChildCount() / 2;
                View childAt = getChildAt(childCount);
                left = childAt != null ? childAt.getLeft() : 0;
                boolean d = i5 != 0 ? d(i4, i5) : false;
                View childAt2 = getChildAt(childCount);
                if (childAt2 != null) {
                    childCount = childAt2.getLeft();
                    if (d) {
                        i4 = (-i5) - (childCount - left);
                        overScrollBy(i4, 0, getScrollX(), 0, 0, 0, this.Q, 0, true);
                        if (Math.abs(this.Q) == Math.abs(getScrollX()) && this.at != null) {
                            this.at.clear();
                        }
                        i5 = getOverScrollMode();
                        if (i5 == 0 || (i5 == 1 && !z())) {
                            this.aT = 0;
                            this.F = 5;
                            if (i3 > 0) {
                                this.aP.a(((float) i4) / ((float) getWidth()));
                                if (!this.aQ.a()) {
                                    this.aQ.c();
                                }
                                invalidate();
                            } else if (i3 < 0) {
                                this.aQ.a(((float) i4) / ((float) getWidth()));
                                if (!this.aP.a()) {
                                    this.aP.c();
                                }
                                invalidate();
                            }
                        }
                    }
                    this.D = i;
                }
                this.G = i;
            }
        } else if (this.F == 5 && i != this.G) {
            int i6;
            childCount = getScrollX();
            left = childCount - i5;
            int i7 = i > this.G ? 1 : -1;
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
                overScrollBy(i4, 0, getScrollX(), 0, 0, 0, this.Q, 0, true);
                i5 = getOverScrollMode();
                if (i5 == 0 || (i5 == 1 && !z())) {
                    if (i3 > 0) {
                        this.aP.a(((float) i4) / ((float) getWidth()));
                        if (!this.aQ.a()) {
                            this.aQ.c();
                        }
                        invalidate();
                    } else if (i3 < 0) {
                        this.aQ.a(((float) i4) / ((float) getWidth()));
                        if (!this.aP.a()) {
                            this.aP.c();
                        }
                        invalidate();
                    }
                }
            }
            if (i6 != 0) {
                if (getScrollX() != 0) {
                    this.a.a(0);
                    k();
                }
                d(i6, i6);
                this.F = 3;
                i5 = g(i);
                this.H = 0;
                View childAt3 = getChildAt(i5 - this.V);
                if (childAt3 != null) {
                    i2 = childAt3.getLeft();
                }
                this.B = i2;
                this.D = i;
                this.A = i5;
            }
            this.G = i;
            this.aT = i7;
        }
    }

    private void x() {
        setClickable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        setAlwaysDrawnWithCacheEnabled(false);
        setScrollingCacheEnabled(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.aJ = viewConfiguration.getScaledTouchSlop();
        this.aL = viewConfiguration.getScaledMinimumFlingVelocity();
        this.aM = viewConfiguration.getScaledMaximumFlingVelocity();
        this.Q = viewConfiguration.getScaledOverscrollDistance();
        this.R = viewConfiguration.getScaledOverflingDistance();
        this.a = a.a(this);
    }

    private void y() {
        int i = this.V;
        int childCount = getChildCount();
        boolean z = VERSION.SDK_INT >= 11;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int i3 = i + i2;
            if (childAt instanceof Checkable) {
                ((Checkable) childAt).setChecked(((Boolean) this.f.a(i3, Boolean.valueOf(false))).booleanValue());
            } else if (z) {
                childAt.setActivated(((Boolean) this.f.a(i3, Boolean.valueOf(false))).booleanValue());
            }
        }
    }

    private boolean z() {
        int childCount = getChildCount();
        return childCount == 0 ? true : childCount != this.an ? false : getChildAt(0).getLeft() >= this.u.left && getChildAt(childCount - 1).getRight() <= getWidth() - this.u.right;
    }

    public int a(int i, int i2) {
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
    protected View a(int i, boolean[] zArr) {
        zArr[0] = false;
        View d = this.p.d(i);
        if (d == null) {
            d = this.p.e(i);
            View view;
            if (d != null) {
                view = this.j.getView(i, d, this);
                if (VERSION.SDK_INT >= 16 && view.getImportantForAccessibility() == 0) {
                    view.setImportantForAccessibility(1);
                }
                if (view != d) {
                    this.p.a(d, i);
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
                view = this.j.getView(i, null, this);
                if (VERSION.SDK_INT >= 16 && view.getImportantForAccessibility() == 0) {
                    view.setImportantForAccessibility(1);
                }
                if (this.aG != 0) {
                    view.setDrawingCacheBackgroundColor(this.aG);
                }
                d = view;
            }
            if (this.k) {
                LayoutParams layoutParams = d.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = (i) generateDefaultLayoutParams();
                } else {
                    i iVar = !checkLayoutParams(layoutParams) ? (i) generateLayoutParams(layoutParams) : (i) layoutParams;
                }
                layoutParams.e = this.j.getItemId(i);
                d.setLayoutParams(layoutParams);
            }
            if (this.ap.isEnabled()) {
                if (this.aX == null) {
                    this.aX = new j(this);
                }
                if (VERSION.SDK_INT >= 16) {
                    d.setAccessibilityDelegate(this.aX);
                }
            }
        }
        return d;
    }

    public i a(AttributeSet attributeSet) {
        return new i(getContext(), attributeSet);
    }

    public void a() {
        if (this.f != null) {
            this.f.c();
        }
        if (this.g != null) {
            this.g.c();
        }
        this.e = 0;
    }

    public void a(int i, int i2, boolean z) {
        if (this.au == null) {
            this.au = new g(this);
        }
        int i3 = this.V;
        int childCount = getChildCount();
        int i4 = i3 + childCount;
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        if (i == 0 || this.an == 0 || childCount == 0 || ((i3 == 0 && getChildAt(0).getLeft() == paddingLeft && i < 0) || (i4 == this.an && getChildAt(childCount - 1).getRight() == width && i > 0))) {
            this.au.b();
            if (this.I != null) {
                this.I.a();
                return;
            }
            return;
        }
        b(2);
        this.au.a(i, i2, z);
    }

    protected void a(int i, View view) {
        if (i != -1) {
            this.n = i;
        }
        Rect rect = this.o;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        if (view instanceof s) {
            ((s) view).a(rect);
        }
        a(rect.left, rect.top, rect.right, rect.bottom);
        boolean z = this.aH;
        if (view.isEnabled() != z) {
            this.aH = !z;
            if (getSelectedItemPosition() != -1) {
                refreshDrawableState();
            }
        }
    }

    public void a(int i, boolean z) {
        if (this.b != 0) {
            if (VERSION.SDK_INT >= 11 && z && this.b == 3 && this.c == null) {
                if (this.d == null || !((it.sephiroth.android.library.a.a.b) this.d).a()) {
                    throw new IllegalStateException("AbsListView: attempted to start selection mode for CHOICE_MODE_MULTIPLE_MODAL but no choice mode callback was supplied. Call setMultiChoiceModeListener to set a callback.");
                }
                this.c = startActionMode((it.sephiroth.android.library.a.a.b) this.d);
            }
            boolean booleanValue;
            if (this.b == 2 || (VERSION.SDK_INT >= 11 && this.b == 3)) {
                booleanValue = ((Boolean) this.f.a(i, Boolean.valueOf(false))).booleanValue();
                this.f.b(i, Boolean.valueOf(z));
                if (this.g != null && this.j.hasStableIds()) {
                    if (z) {
                        this.g.a(this.j.getItemId(i), Integer.valueOf(i));
                    } else {
                        this.g.a(this.j.getItemId(i));
                    }
                }
                if (booleanValue != z) {
                    if (z) {
                        this.e++;
                    } else {
                        this.e--;
                    }
                }
                if (this.c != null) {
                    ((it.sephiroth.android.library.a.a.b) this.d).a((ActionMode) this.c, i, this.j.getItemId(i), z);
                }
            } else {
                booleanValue = this.g != null && this.j.hasStableIds();
                if (z || a(i)) {
                    this.f.c();
                    if (booleanValue) {
                        this.g.c();
                    }
                }
                if (z) {
                    this.f.b(i, Boolean.valueOf(true));
                    if (booleanValue) {
                        this.g.a(this.j.getItemId(i), Integer.valueOf(i));
                    }
                    this.e = 1;
                } else if (this.f.b() == 0 || !((Boolean) this.f.c(0)).booleanValue()) {
                    this.e = 0;
                }
            }
            if (!this.ae && !this.as) {
                this.ai = true;
                w();
                requestLayout();
            }
        }
    }

    protected abstract void a(boolean z);

    public boolean a(float f, float f2, int i) {
        int a = a((int) f, (int) f2);
        if (a != -1) {
            long itemId = this.j.getItemId(a);
            View childAt = getChildAt(a - this.V);
            if (childAt != null) {
                this.ay = b(childAt, a, itemId);
                return super.showContextMenuForChild(this);
            }
        }
        return a(f, f2, i);
    }

    public boolean a(int i) {
        return (this.b == 0 || this.f == null) ? false : ((Boolean) this.f.a(i, Boolean.valueOf(false))).booleanValue();
    }

    @TargetApi(14)
    protected boolean a(MotionEvent motionEvent) {
        return VERSION.SDK_INT >= 14 && (motionEvent.getButtonState() & 2) != 0 && a(motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState());
    }

    public boolean a(View view, int i, long j) {
        boolean z;
        boolean z2 = true;
        boolean z3 = false;
        if (this.b != 0) {
            if (this.b == 2 || (VERSION.SDK_INT >= 11 && this.b == 3 && this.c != null)) {
                boolean z4 = !((Boolean) this.f.a(i, Boolean.valueOf(false))).booleanValue();
                this.f.b(i, Boolean.valueOf(z4));
                if (this.g != null && this.j.hasStableIds()) {
                    if (z4) {
                        this.g.a(this.j.getItemId(i), Integer.valueOf(i));
                    } else {
                        this.g.a(this.j.getItemId(i));
                    }
                }
                if (z4) {
                    this.e++;
                } else {
                    this.e--;
                }
                if (this.c != null) {
                    ((it.sephiroth.android.library.a.a.b) this.d).a((ActionMode) this.c, i, j, z4);
                } else {
                    z3 = true;
                }
                z = z3;
                z3 = true;
            } else if (this.b == 1) {
                if (!((Boolean) this.f.a(i, Boolean.valueOf(false))).booleanValue()) {
                    this.f.c();
                    this.f.b(i, Boolean.valueOf(true));
                    if (this.g != null && this.j.hasStableIds()) {
                        this.g.c();
                        this.g.a(this.j.getItemId(i), Integer.valueOf(i));
                    }
                    this.e = 1;
                } else if (this.f.b() == 0 || !((Boolean) this.f.c(0)).booleanValue()) {
                    this.e = 0;
                }
                z3 = true;
                z = true;
            } else {
                z = true;
            }
            if (z3) {
                y();
            }
            boolean z5 = z;
            z = true;
            z2 = z5;
        } else {
            z = false;
        }
        return z2 ? z | super.a(view, i, j) : z;
    }

    public void addTouchables(ArrayList arrayList) {
        int childCount = getChildCount();
        int i = this.V;
        ListAdapter listAdapter = this.j;
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

    ContextMenuInfo b(View view, int i, long j) {
        return new w(view, i, j);
    }

    protected void b() {
        if (this.av != null) {
            this.av.a(this, this.V, getChildCount(), this.an);
        }
        onScrollChanged(0, 0, 0, 0);
    }

    void b(int i) {
        if (i != this.aI && this.av != null) {
            this.aI = i;
            this.av.a(this, i);
        }
    }

    public void b(int i, int i2) {
        if (this.I == null) {
            this.I = new m(this);
        }
        this.I.a(i, i2);
    }

    void c() {
        if (getChildCount() > 0) {
            d();
            requestLayout();
            invalidate();
        }
    }

    public void c(int i) {
        if (this.I == null) {
            this.I = new m(this);
        }
        this.I.a(i);
    }

    public void c(int i, int i2) {
        a(i, i2, false);
    }

    boolean c(View view, int i, long j) {
        if (VERSION.SDK_INT < 11 || this.b != 3) {
            boolean a = this.ah != null ? this.ah.a(this, view, i, j) : false;
            if (!a) {
                this.ay = b(view, i, j);
                a = super.showContextMenuForChild(this);
            }
            if (!a) {
                return a;
            }
            performHapticFeedback(0);
            return a;
        }
        if (this.c == null) {
            ActionMode startActionMode = startActionMode((it.sephiroth.android.library.a.a.b) this.d);
            this.c = startActionMode;
            if (startActionMode != null) {
                a(i, true);
                performHapticFeedback(0);
            }
        }
        return true;
    }

    public boolean checkInputConnectionProxy(View view) {
        return false;
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof i;
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

    protected void d() {
        removeAllViewsInLayout();
        this.V = 0;
        this.ai = false;
        this.O = null;
        this.ac = false;
        this.bb = null;
        this.aq = -1;
        this.ar = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        this.J = 0;
        this.n = -1;
        this.o.setEmpty();
        invalidate();
    }

    protected void d(int i) {
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
                c(Math.max(0, Math.min(getCount(), firstVisiblePosition + i)));
            }
        }
    }

    boolean d(int i, int i2) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        int left = getChildAt(0).getLeft();
        int right = getChildAt(childCount - 1).getRight();
        Rect rect = this.u;
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
                l();
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
                        this.p.a(childAt, right);
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
                        this.p.a(childAt2, right);
                    }
                    width2++;
                    right = width3;
                }
            }
            this.C = this.B + max;
            this.as = true;
            if (right > 0) {
                detachViewsFromParent(i5, right);
                this.p.d();
            }
            if (!awakenScrollBars()) {
                invalidate();
            }
            e(max2);
            if (z) {
                this.V = right + this.V;
            }
            max2 = Math.abs(max2);
            if (i3 < max2 || width < max2) {
                a(z);
            }
            if (!isInTouchMode && this.al != -1) {
                max2 = this.al - this.V;
                if (max2 >= 0 && max2 < getChildCount()) {
                    a(this.al, getChildAt(max2));
                }
            } else if (this.n != -1) {
                max2 = this.n - this.V;
                if (max2 >= 0 && max2 < getChildCount()) {
                    a(-1, getChildAt(max2));
                }
            } else {
                this.o.setEmpty();
            }
            this.as = false;
            b();
            return false;
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        boolean z = this.l;
        if (!z) {
            a(canvas);
        }
        super.dispatchDraw(canvas);
        if (z) {
            a(canvas);
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
            if (!this.aP.a()) {
                save = canvas.save();
                i = this.u.top + this.aV;
                height = (getHeight() - i) - (this.u.bottom + this.aW);
                int min = Math.min(0, this.aR + scrollX);
                canvas.rotate(-90.0f);
                canvas.translate((float) (i + (-getHeight())), (float) min);
                this.aP.a(height, height);
                if (this.aP.a(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save);
            }
            if (!this.aQ.a()) {
                save = canvas.save();
                i = this.u.left + this.aV;
                height = (getHeight() - i) - (this.u.right + this.aW);
                scrollX = Math.max(getWidth(), scrollX + this.aS);
                canvas.rotate(90.0f);
                canvas.translate((float) (-i), (float) (-scrollX));
                this.aQ.a(height, height);
                if (this.aQ.a(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save);
            }
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        j();
    }

    protected void e() {
    }

    public void e(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).offsetLeftAndRight(i);
        }
    }

    protected void e(int i, int i2) {
    }

    protected abstract int f(int i);

    protected void f() {
        int i;
        int i2 = 1;
        int i3 = 0;
        if (this.w != null) {
            i = this.V > 0 ? 1 : 0;
            if (i == 0 && getChildCount() > 0) {
                i = getChildAt(0).getLeft() < this.u.left ? 1 : 0;
            }
            this.w.setVisibility(i != 0 ? 0 : 4);
        }
        if (this.x != null) {
            int childCount = getChildCount();
            i = this.V + childCount < this.an ? 1 : 0;
            if (i != 0 || childCount <= 0) {
                i2 = i;
            } else if (getChildAt(childCount - 1).getRight() <= getRight() - this.u.right) {
                i2 = 0;
            }
            View view = this.x;
            if (i2 == 0) {
                i3 = 4;
            }
            view.setVisibility(i3);
        }
    }

    protected int g(int i) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return -1;
        }
        int f = f(i);
        return f == -1 ? (this.V + childCount) - 1 : f;
    }

    boolean g() {
        switch (this.F) {
            case cm.HListView_android_divider /*1*/:
            case cm.HListView_hlv_dividerWidth /*2*/:
                return true;
            default:
                return false;
        }
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new i(-2, -1, 0);
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return a(attributeSet);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new i(layoutParams);
    }

    @ExportedProperty(category = "drawing")
    public int getCacheColorHint() {
        return this.aG;
    }

    public int getCheckedItemCount() {
        return this.e;
    }

    public long[] getCheckedItemIds() {
        int i = 0;
        if (this.b == 0 || this.g == null || this.j == null) {
            return new long[0];
        }
        android.support.v4.c.f fVar = this.g;
        int b = fVar.b();
        long[] jArr = new long[b];
        while (i < b) {
            jArr[i] = fVar.a(i);
            i++;
        }
        return jArr;
    }

    public int getCheckedItemPosition() {
        return (this.b == 1 && this.f != null && this.f.b() == 1) ? this.f.b(0) : -1;
    }

    public n getCheckedItemPositions() {
        return this.b != 0 ? this.f : null;
    }

    public int getChoiceMode() {
        return this.b;
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
        return this.u.bottom;
    }

    public int getListPaddingLeft() {
        return this.u.left;
    }

    public int getListPaddingRight() {
        return this.u.right;
    }

    public int getListPaddingTop() {
        return this.u.top;
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
        return this.m;
    }

    public int getSolidColor() {
        return this.aG;
    }

    public int getTranscriptMode() {
        return this.aF;
    }

    protected boolean h() {
        return (hasFocus() && !isInTouchMode()) || g();
    }

    protected void i() {
        if (isEnabled() && isClickable()) {
            Drawable drawable = this.m;
            Rect rect = this.o;
            if (drawable == null) {
                return;
            }
            if ((isFocused() || g()) && !rect.isEmpty()) {
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
                        this.aC = new d();
                    }
                    this.aC.a();
                    postDelayed(this.aC, (long) ViewConfiguration.getLongPressTimeout());
                }
            }
        }
    }

    void j() {
        if (this.m == null) {
            return;
        }
        if (h()) {
            this.m.setState(getDrawableState());
        } else {
            this.m.setState(U);
        }
    }

    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.m != null) {
            this.m.jumpToCurrentState();
        }
    }

    @TargetApi(11)
    protected void k() {
        if (this.a.a() && (getParent() instanceof View)) {
            ((View) getParent()).invalidate();
        }
    }

    protected void l() {
        if (this.al != -1) {
            if (this.h != 4) {
                this.M = this.al;
            }
            if (this.aj >= 0 && this.aj != this.al) {
                this.M = this.aj;
            }
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.J = 0;
        }
    }

    protected int m() {
        int i = this.al;
        if (i < 0) {
            i = this.M;
        }
        return Math.min(Math.max(0, i), this.an - 1);
    }

    protected boolean n() {
        if (this.al >= 0 || !o()) {
            return false;
        }
        j();
        return true;
    }

    boolean o() {
        boolean z = true;
        int childCount = getChildCount();
        if (childCount <= 0) {
            return false;
        }
        int left;
        int i;
        boolean z2;
        boolean z3 = this.u.left;
        int right = (getRight() - getLeft()) - this.u.right;
        int i2 = this.V;
        int i3 = this.M;
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
        this.M = -1;
        removeCallbacks(this.au);
        if (this.I != null) {
            this.I.a();
        }
        this.F = -1;
        F();
        this.W = i;
        left = b(i3, z2);
        if (left < i2 || left > getLastVisiblePosition()) {
            left = -1;
        } else {
            this.h = 4;
            j();
            setSelectionInt(left);
            b();
        }
        b(0);
        if (left < 0) {
            z = false;
        }
        return z;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnTouchModeChangeListener(this);
        if (this.j != null && this.i == null) {
            this.i = new c(this);
            this.j.registerDataSetObserver(this.i);
            this.ai = true;
            this.ao = this.an;
            this.an = this.j.getCount();
        }
        this.S = true;
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
        this.p.b();
        getViewTreeObserver().removeOnTouchModeChangeListener(this);
        if (!(this.j == null || this.i == null)) {
            this.j.unregisterDataSetObserver(this.i);
            this.i = null;
        }
        if (this.au != null) {
            removeCallbacks(this.au);
        }
        if (this.I != null) {
            this.I.a();
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
        this.S = false;
    }

    protected void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (z && this.al < 0 && !isInTouchMode()) {
            if (!(this.S || this.j == null)) {
                this.ai = true;
                this.ao = this.an;
                this.an = this.j.getCount();
            }
            o();
        }
    }

    @TargetApi(12)
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0) {
            switch (motionEvent.getAction()) {
                case cm.ExpandableHListView_hlv_childIndicatorPaddingTop /*8*/:
                    if (this.F == -1) {
                        float axisValue = motionEvent.getAxisValue(10);
                        if (axisValue != 0.0f) {
                            int horizontalScrollFactor = (int) (axisValue * getHorizontalScrollFactor());
                            if (!d(horizontalScrollFactor, horizontalScrollFactor)) {
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
        if (this.I != null) {
            this.I.a();
        }
        if (!this.S) {
            return false;
        }
        switch (action & 255) {
            case cm.HListView_android_entries /*0*/:
                action = this.F;
                if (action == 6 || action == 5) {
                    this.H = 0;
                    return true;
                }
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                this.aO = motionEvent.getPointerId(0);
                int f = f(x);
                if (action != 4 && f >= 0) {
                    this.B = getChildAt(f - this.V).getLeft();
                    this.D = x;
                    this.E = y;
                    this.A = f;
                    this.F = 0;
                    F();
                }
                this.G = Integer.MIN_VALUE;
                B();
                this.at.addMovement(motionEvent);
                return action == 4;
            case cm.HListView_android_divider /*1*/:
            case cm.HListView_hlv_headerDividersEnabled /*3*/:
                this.F = -1;
                this.aO = -1;
                D();
                b(0);
                return false;
            case cm.HListView_hlv_dividerWidth /*2*/:
                switch (this.F) {
                    case cm.HListView_android_entries /*0*/:
                        action = motionEvent.findPointerIndex(this.aO);
                        if (action == -1) {
                            this.aO = motionEvent.getPointerId(0);
                            action = 0;
                        }
                        action = (int) motionEvent.getX(action);
                        C();
                        this.at.addMovement(motionEvent);
                        return i(action);
                    default:
                        return false;
                }
            case cm.HListView_hlv_overScrollFooter /*6*/:
                b(motionEvent);
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
                if (isClickable() && isPressed() && this.al >= 0 && this.j != null && this.al < this.j.getCount()) {
                    View childAt = getChildAt(this.al - this.V);
                    if (childAt != null) {
                        a(childAt, this.al, this.am);
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
            this.p.a();
        }
        e();
        this.ae = false;
        this.N = (i3 - i) / 3;
    }

    protected void onMeasure(int i, int i2) {
        if (this.m == null) {
            A();
        }
        Rect rect = this.u;
        rect.left = this.q + getPaddingLeft();
        rect.top = this.r + getPaddingTop();
        rect.right = this.s + getPaddingRight();
        rect.bottom = this.t + getPaddingBottom();
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
            this.a.a(i);
            k();
            awakenScrollBars();
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.ai = true;
        this.ab = (long) savedState.e;
        if (savedState.a >= 0) {
            this.ac = true;
            this.bb = savedState;
            this.aa = savedState.a;
            this.Z = savedState.d;
            this.W = savedState.c;
            this.ad = 0;
        } else if (savedState.b >= 0) {
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.n = -1;
            this.ac = true;
            this.bb = savedState;
            this.aa = savedState.b;
            this.Z = savedState.d;
            this.W = savedState.c;
            this.ad = 1;
        }
        if (savedState.i != null) {
            this.f = savedState.i;
        }
        if (savedState.j != null) {
            this.g = savedState.j;
        }
        this.e = savedState.h;
        if (VERSION.SDK_INT >= 11 && savedState.g && this.b == 3 && this.d != null) {
            this.c = startActionMode((it.sephiroth.android.library.a.a.b) this.d);
        }
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        boolean z = true;
        int i = 0;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.bb != null) {
            savedState.a = this.bb.a;
            savedState.b = this.bb.b;
            savedState.c = this.bb.c;
            savedState.d = this.bb.d;
            savedState.e = this.bb.e;
            savedState.f = this.bb.f;
            savedState.g = this.bb.g;
            savedState.h = this.bb.h;
            savedState.i = this.bb.i;
            savedState.j = this.bb.j;
            return savedState;
        }
        boolean z2 = getChildCount() > 0 && this.an > 0;
        long selectedItemId = getSelectedItemId();
        savedState.a = selectedItemId;
        savedState.e = getWidth();
        if (selectedItemId >= 0) {
            savedState.c = this.J;
            savedState.d = getSelectedItemPosition();
            savedState.b = -1;
        } else if (!z2 || this.V <= 0) {
            savedState.c = 0;
            savedState.b = -1;
            savedState.d = 0;
        } else {
            savedState.c = getChildAt(0).getLeft();
            int i2 = this.V;
            if (i2 >= this.an) {
                i2 = this.an - 1;
            }
            savedState.d = i2;
            savedState.b = this.j.getItemId(i2);
        }
        savedState.f = null;
        if (VERSION.SDK_INT < 11 || this.b != 3 || this.c == null) {
            z = false;
        }
        savedState.g = z;
        if (this.f != null) {
            try {
                savedState.i = this.f.a();
            } catch (NoSuchMethodError e) {
                e.printStackTrace();
                savedState.i = new n();
            }
        }
        if (this.g != null) {
            android.support.v4.c.f fVar = new android.support.v4.c.f();
            int b = this.g.b();
            while (i < b) {
                fVar.a(this.g.a(i), this.g.b(i));
                i++;
            }
            savedState.j = fVar;
        }
        savedState.h = this.e;
        return savedState;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (getChildCount() > 0) {
            this.ai = true;
            w();
        }
    }

    @SuppressLint({"Override"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        if (isEnabled()) {
            if (this.I != null) {
                this.I.a();
            }
            if (!this.S) {
                return false;
            }
            int action = motionEvent.getAction();
            C();
            this.at.addMovement(motionEvent);
            int x;
            int y;
            int a;
            Handler handler;
            switch (action & 255) {
                case cm.HListView_android_entries /*0*/:
                    switch (this.F) {
                        case cm.HListView_hlv_overScrollFooter /*6*/:
                            this.au.b();
                            if (this.I != null) {
                                this.I.a();
                            }
                            this.F = 5;
                            this.E = (int) motionEvent.getY();
                            action = (int) motionEvent.getX();
                            this.G = action;
                            this.D = action;
                            this.H = 0;
                            this.aO = motionEvent.getPointerId(0);
                            this.aT = 0;
                            break;
                        default:
                            this.aO = motionEvent.getPointerId(0);
                            x = (int) motionEvent.getX();
                            y = (int) motionEvent.getY();
                            a = a(x, y);
                            if (!this.ai) {
                                if (this.F == 4 || a < 0 || !((ListAdapter) getAdapter()).isEnabled(a)) {
                                    if (this.F == 4) {
                                        E();
                                        this.F = 3;
                                        this.H = 0;
                                        action = f(x);
                                        this.au.c();
                                        if (action >= 0) {
                                            this.B = getChildAt(action - this.V).getLeft();
                                        }
                                        this.D = x;
                                        this.E = y;
                                        this.A = action;
                                        this.G = Integer.MIN_VALUE;
                                        break;
                                    }
                                }
                                this.F = 0;
                                if (this.aB == null) {
                                    this.aB = new f(this);
                                }
                                postDelayed(this.aB, (long) ViewConfiguration.getTapTimeout());
                                action = a;
                                if (action >= 0) {
                                    this.B = getChildAt(action - this.V).getLeft();
                                }
                                this.D = x;
                                this.E = y;
                                this.A = action;
                                this.G = Integer.MIN_VALUE;
                            }
                            action = a;
                            if (action >= 0) {
                                this.B = getChildAt(action - this.V).getLeft();
                            }
                            this.D = x;
                            this.E = y;
                            this.A = action;
                            this.G = Integer.MIN_VALUE;
                            break;
                    }
                    if (!a(motionEvent) || this.F != 0) {
                        return true;
                    }
                    removeCallbacks(this.aB);
                    return true;
                case cm.HListView_android_divider /*1*/:
                    switch (this.F) {
                        case cm.HListView_android_entries /*0*/:
                        case cm.HListView_android_divider /*1*/:
                        case cm.HListView_hlv_dividerWidth /*2*/:
                            a = this.A;
                            View childAt = getChildAt(a - this.V);
                            float x2 = motionEvent.getX();
                            boolean z = x2 > ((float) this.u.left) && x2 < ((float) (getWidth() - this.u.right));
                            if (!(childAt == null || childAt.hasFocusable() || !z)) {
                                if (this.F != 0) {
                                    childAt.setPressed(false);
                                }
                                if (this.aD == null) {
                                    this.aD = new l();
                                }
                                l lVar = this.aD;
                                lVar.a = a;
                                lVar.a();
                                this.M = a;
                                if (this.F == 0 || this.F == 1) {
                                    Handler handler2 = getHandler();
                                    if (handler2 != null) {
                                        handler2.removeCallbacks(this.F == 0 ? this.aB : this.aA);
                                    }
                                    this.h = 0;
                                    if (this.ai || !this.j.isEnabled(a)) {
                                        this.F = -1;
                                        j();
                                        return true;
                                    }
                                    this.F = 1;
                                    setSelectedPositionInt(this.A);
                                    e();
                                    childAt.setPressed(true);
                                    a(this.A, childAt);
                                    setPressed(true);
                                    if (this.m != null) {
                                        Drawable current = this.m.getCurrent();
                                        if (current != null && (current instanceof TransitionDrawable)) {
                                            ((TransitionDrawable) current).resetTransition();
                                        }
                                    }
                                    if (this.aE != null) {
                                        removeCallbacks(this.aE);
                                    }
                                    this.aE = new a(this, childAt, lVar);
                                    postDelayed(this.aE, (long) ViewConfiguration.getPressedStateDuration());
                                    return true;
                                } else if (!this.ai && this.j.isEnabled(a)) {
                                    lVar.run();
                                }
                            }
                            this.F = -1;
                            j();
                            break;
                        case cm.HListView_hlv_headerDividersEnabled /*3*/:
                            action = getChildCount();
                            if (action <= 0) {
                                this.F = -1;
                                b(0);
                                break;
                            }
                            a = getChildAt(0).getLeft();
                            x = getChildAt(action - 1).getRight();
                            y = this.u.left;
                            int width = getWidth() - this.u.right;
                            if (this.V == 0 && a >= y && this.V + action < this.an && x <= getWidth() - width) {
                                this.F = -1;
                                b(0);
                                break;
                            }
                            VelocityTracker velocityTracker = this.at;
                            velocityTracker.computeCurrentVelocity(1000, (float) this.aM);
                            int xVelocity = (int) (velocityTracker.getXVelocity(this.aO) * this.aN);
                            if (Math.abs(xVelocity) > this.aL && ((this.V != 0 || a != y - this.Q) && (action + this.V != this.an || x != this.Q + width))) {
                                if (this.au == null) {
                                    this.au = new g(this);
                                }
                                b(2);
                                this.au.a(-xVelocity);
                                break;
                            }
                            this.F = -1;
                            b(0);
                            if (this.au != null) {
                                this.au.b();
                            }
                            if (this.I != null) {
                                this.I.a();
                                break;
                            }
                            break;
                        case cm.HListView_hlv_overScrollHeader /*5*/:
                            if (this.au == null) {
                                this.au = new g(this);
                            }
                            VelocityTracker velocityTracker2 = this.at;
                            velocityTracker2.computeCurrentVelocity(1000, (float) this.aM);
                            action = (int) velocityTracker2.getXVelocity(this.aO);
                            b(2);
                            if (Math.abs(action) <= this.aL) {
                                this.au.a();
                                break;
                            }
                            this.au.b(-action);
                            break;
                    }
                    setPressed(false);
                    if (this.aP != null) {
                        this.aP.c();
                        this.aQ.c();
                    }
                    invalidate();
                    handler = getHandler();
                    if (handler != null) {
                        handler.removeCallbacks(this.aA);
                    }
                    D();
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
                        e();
                    }
                    switch (this.F) {
                        case cm.HListView_android_entries /*0*/:
                        case cm.HListView_android_divider /*1*/:
                        case cm.HListView_hlv_dividerWidth /*2*/:
                            i(action);
                            return true;
                        case cm.HListView_hlv_headerDividersEnabled /*3*/:
                        case cm.HListView_hlv_overScrollHeader /*5*/:
                            j(action);
                            return true;
                        default:
                            return true;
                    }
                case cm.HListView_hlv_headerDividersEnabled /*3*/:
                    switch (this.F) {
                        case cm.HListView_hlv_overScrollHeader /*5*/:
                            if (this.au == null) {
                                this.au = new g(this);
                            }
                            this.au.a();
                            break;
                        case cm.HListView_hlv_overScrollFooter /*6*/:
                            break;
                        default:
                            this.F = -1;
                            setPressed(false);
                            View childAt2 = getChildAt(this.A - this.V);
                            if (childAt2 != null) {
                                childAt2.setPressed(false);
                            }
                            F();
                            handler = getHandler();
                            if (handler != null) {
                                handler.removeCallbacks(this.aA);
                            }
                            D();
                            break;
                    }
                    if (this.aP != null) {
                        this.aP.c();
                        this.aQ.c();
                    }
                    this.aO = -1;
                    return true;
                case cm.HListView_hlv_overScrollHeader /*5*/:
                    action = motionEvent.getActionIndex();
                    a = motionEvent.getPointerId(action);
                    x = (int) motionEvent.getX(action);
                    action = (int) motionEvent.getY(action);
                    this.H = 0;
                    this.aO = a;
                    this.D = x;
                    this.E = action;
                    action = a(x, action);
                    if (action >= 0) {
                        this.B = getChildAt(action - this.V).getLeft();
                        this.A = action;
                    }
                    this.G = x;
                    return true;
                case cm.HListView_hlv_overScrollFooter /*6*/:
                    b(motionEvent);
                    action = this.D;
                    i = a(action, this.E);
                    if (i >= 0) {
                        this.B = getChildAt(i - this.V).getLeft();
                        this.A = i;
                    }
                    this.G = action;
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
            l();
            if (getWidth() > 0 && getChildCount() > 0) {
                e();
            }
            j();
            return;
        }
        int i = this.F;
        if (i == 5 || i == 6) {
            if (this.au != null) {
                this.au.b();
            }
            if (this.I != null) {
                this.I.a();
            }
            if (getScrollX() != 0) {
                this.a.a(0);
                G();
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
                this.au.b();
                if (this.I != null) {
                    this.I.a();
                }
                if (getScrollX() != 0) {
                    this.a.a(0);
                    G();
                    invalidate();
                }
            }
            if (i == 1) {
                this.M = this.al;
            }
        } else if (!(i == this.az || this.az == -1)) {
            if (i == 1) {
                o();
            } else {
                l();
                this.h = 0;
                e();
            }
        }
        this.az = i;
    }

    void p() {
        this.f.c();
        int i = 0;
        boolean z = false;
        while (i < this.g.b()) {
            int max;
            boolean z2;
            long a = this.g.a(i);
            int intValue = ((Integer) this.g.b(i)).intValue();
            if (a != this.j.getItemId(intValue)) {
                boolean z3;
                int min = Math.min(intValue + 20, this.an);
                for (max = Math.max(0, intValue - 20); max < min; max++) {
                    if (a == this.j.getItemId(max)) {
                        this.f.b(max, Boolean.valueOf(true));
                        this.g.a(i, Integer.valueOf(max));
                        z3 = true;
                        break;
                    }
                }
                z3 = false;
                if (!z3) {
                    this.g.a(a);
                    int i2 = i - 1;
                    this.e--;
                    if (!(VERSION.SDK_INT <= 11 || this.c == null || this.d == null)) {
                        ((it.sephiroth.android.library.a.a.b) this.d).a((ActionMode) this.c, intValue, a, false);
                    }
                    i = i2;
                    z = true;
                }
                max = i;
                z2 = z;
            } else {
                this.f.b(intValue, Boolean.valueOf(true));
                max = i;
                z2 = z;
            }
            z = z2;
            i = max + 1;
        }
        if (z && this.c != null && VERSION.SDK_INT > 11) {
            ((ActionMode) this.c).invalidate();
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
                c((getWidth() - this.u.left) - this.u.right, 200);
                return true;
            case 8192:
                if (!isEnabled() || this.V <= 0) {
                    return false;
                }
                c(-((getWidth() - this.u.left) - this.u.right), 200);
                return true;
            default:
                return false;
        }
    }

    protected void q() {
        int i = this.an;
        int i2 = this.ba;
        this.ba = this.an;
        if (!(this.b == 0 || this.j == null || !this.j.hasStableIds())) {
            p();
        }
        this.p.c();
        if (i > 0) {
            int width;
            int bottom;
            if (this.ac) {
                this.ac = false;
                this.bb = null;
                if (this.aF == 2) {
                    this.h = 3;
                    return;
                }
                if (this.aF == 1) {
                    if (this.aU) {
                        this.aU = false;
                        this.h = 3;
                        return;
                    }
                    int childCount = getChildCount();
                    width = getWidth() - getPaddingRight();
                    View childAt = getChildAt(childCount - 1);
                    bottom = childAt != null ? childAt.getBottom() : width;
                    if (childCount + this.V < i2 || bottom > width) {
                        awakenScrollBars();
                    } else {
                        this.h = 3;
                        return;
                    }
                }
                switch (this.ad) {
                    case cm.HListView_android_entries /*0*/:
                        if (isInTouchMode()) {
                            this.h = 5;
                            this.Z = Math.min(Math.max(0, this.Z), i - 1);
                            return;
                        }
                        bottom = v();
                        if (bottom >= 0 && b(bottom, true) == bottom) {
                            this.Z = bottom;
                            if (this.ab == ((long) getWidth())) {
                                this.h = 5;
                            } else {
                                this.h = 2;
                            }
                            setNextSelectedPositionInt(bottom);
                            return;
                        }
                    case cm.HListView_android_divider /*1*/:
                        this.h = 5;
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
                width = b(bottom, true);
                if (width >= 0) {
                    setNextSelectedPositionInt(width);
                    return;
                }
                bottom = b(bottom, false);
                if (bottom >= 0) {
                    setNextSelectedPositionInt(bottom);
                    return;
                }
            } else if (this.M >= 0) {
                return;
            }
        }
        this.h = this.K ? 3 : 1;
        this.al = -1;
        this.am = Long.MIN_VALUE;
        this.aj = -1;
        this.ak = Long.MIN_VALUE;
        this.ac = false;
        this.bb = null;
        this.n = -1;
        u();
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            D();
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
            this.k = this.j.hasStableIds();
            if (this.b != 0 && this.k && this.g == null) {
                this.g = new android.support.v4.c.f();
            }
        }
        if (this.f != null) {
            this.f.c();
        }
        if (this.g != null) {
            this.g.c();
        }
    }

    public void setCacheColorHint(int i) {
        if (i != this.aG) {
            this.aG = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                getChildAt(i2).setDrawingCacheBackgroundColor(i);
            }
            this.p.f(i);
        }
    }

    @TargetApi(11)
    public void setChoiceMode(int i) {
        this.b = i;
        if (VERSION.SDK_INT >= 11 && this.c != null) {
            if (VERSION.SDK_INT >= 11) {
                ((ActionMode) this.c).finish();
            }
            this.c = null;
        }
        if (this.b != 0) {
            if (this.f == null) {
                this.f = new n();
            }
            if (this.g == null && this.j != null && this.j.hasStableIds()) {
                this.g = new android.support.v4.c.f();
            }
            if (VERSION.SDK_INT >= 11 && this.b == 3) {
                a();
                setLongClickable(true);
            }
        }
    }

    public void setDrawSelectorOnTop(boolean z) {
        this.l = z;
    }

    public void setFriction(float f) {
        if (this.au == null) {
            this.au = new g(this);
        }
        this.au.b.b(f);
    }

    @TargetApi(11)
    public void setMultiChoiceModeListener(it.sephiroth.android.library.a.a.a aVar) {
        if (VERSION.SDK_INT >= 11) {
            if (this.d == null) {
                this.d = new it.sephiroth.android.library.a.a.b(this);
            }
            ((it.sephiroth.android.library.a.a.b) this.d).a(aVar);
            return;
        }
        Log.e("AbsListView", "setMultiChoiceModeListener not supported for this version of Android");
    }

    public void setOnScrollListener(k kVar) {
        this.av = kVar;
        b();
    }

    public void setOverScrollMode(int i) {
        if (i == 2) {
            this.aP = null;
            this.aQ = null;
        } else if (this.aP == null) {
            Context context = getContext();
            this.aP = new f(context);
            this.aQ = new f(context);
        }
        super.setOverScrollMode(i);
    }

    public void setRecyclerListener(q qVar) {
        this.p.b = qVar;
    }

    public void setScrollingCacheEnabled(boolean z) {
        if (this.L && !z) {
            F();
        }
        this.L = z;
    }

    public abstract void setSelectionInt(int i);

    public void setSelector(int i) {
        setSelector(getResources().getDrawable(i));
    }

    public void setSelector(Drawable drawable) {
        if (this.m != null) {
            this.m.setCallback(null);
            unscheduleDrawable(this.m);
        }
        this.m = drawable;
        Rect rect = new Rect();
        drawable.getPadding(rect);
        this.q = rect.left;
        this.r = rect.top;
        this.s = rect.right;
        this.t = rect.bottom;
        drawable.setCallback(this);
        j();
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.aw = z;
    }

    public void setStackFromRight(boolean z) {
        if (this.K != z) {
            this.K = z;
            c();
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
        int a = a(view);
        if (a < 0) {
            return false;
        }
        long itemId = this.j.getItemId(a);
        if (this.ah != null) {
            z = this.ah.a(this, view, a, itemId);
        }
        if (z) {
            return z;
        }
        this.ay = b(getChildAt(a - this.V), a, itemId);
        return super.showContextMenuForChild(view);
    }

    public boolean verifyDrawable(Drawable drawable) {
        return this.m == drawable || super.verifyDrawable(drawable);
    }
}
