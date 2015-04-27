package android.support.v4.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.C0086n;
import android.support.v4.view.C0091s;
import android.support.v4.view.C0098z;
import android.support.v4.view.ak;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.google.android.apps.androidify.cm;

public class DrawerLayout extends ViewGroup {
    private static final int[] f327a;
    private final C0099a f328b;
    private int f329c;
    private int f330d;
    private float f331e;
    private Paint f332f;
    private final C0121v f333g;
    private final C0121v f334h;
    private final C0104e f335i;
    private final C0104e f336j;
    private int f337k;
    private boolean f338l;
    private boolean f339m;
    private int f340n;
    private int f341o;
    private boolean f342p;
    private boolean f343q;
    private C0100b f344r;
    private float f345s;
    private float f346t;
    private Drawable f347u;
    private Drawable f348v;

    public class SavedState extends BaseSavedState {
        public static final Creator CREATOR;
        int f324a;
        int f325b;
        int f326c;

        static {
            CREATOR = new C0102d();
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f324a = 0;
            this.f325b = 0;
            this.f326c = 0;
            this.f324a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
            this.f324a = 0;
            this.f325b = 0;
            this.f326c = 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f324a);
        }
    }

    static {
        f327a = new int[]{16842931};
    }

    static String m730b(int i) {
        return (i & 3) == 3 ? "LEFT" : (i & 5) == 5 ? "RIGHT" : Integer.toHexString(i);
    }

    private boolean m732d() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((C0101c) getChildAt(i).getLayoutParams()).f373c) {
                return true;
            }
        }
        return false;
    }

    private boolean m733e() {
        return m734f() != null;
    }

    private View m734f() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m753g(childAt) && m756j(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    private static boolean m736l(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    private static boolean m737m(View view) {
        return (ak.m540c(view) == 4 || ak.m540c(view) == 2) ? false : true;
    }

    public int m738a(View view) {
        int e = m751e(view);
        return e == 3 ? this.f340n : e == 5 ? this.f341o : 0;
    }

    View m739a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (((C0101c) childAt.getLayoutParams()).f374d) {
                return childAt;
            }
        }
        return null;
    }

    View m740a(int i) {
        int a = C0086n.m699a(i, ak.m542e(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((m751e(childAt) & 7) == a) {
                return childAt;
            }
        }
        return null;
    }

    public void m741a(int i, int i2) {
        int a = C0086n.m699a(i2, ak.m542e(this));
        if (a == 3) {
            this.f340n = i;
        } else if (a == 5) {
            this.f341o = i;
        }
        if (i != 0) {
            (a == 3 ? this.f333g : this.f334h).m905e();
        }
        View a2;
        switch (i) {
            case cm.HListView_android_divider /*1*/:
                a2 = m740a(a);
                if (a2 != null) {
                    m755i(a2);
                }
            case cm.HListView_hlv_dividerWidth /*2*/:
                a2 = m740a(a);
                if (a2 != null) {
                    m754h(a2);
                }
            default:
        }
    }

    void m742a(int i, int i2, View view) {
        int i3 = 1;
        int a = this.f333g.m886a();
        int a2 = this.f334h.m886a();
        if (!(a == 1 || a2 == 1)) {
            i3 = (a == 2 || a2 == 2) ? 2 : 0;
        }
        if (view != null && i2 == 0) {
            C0101c c0101c = (C0101c) view.getLayoutParams();
            if (c0101c.f372b == 0.0f) {
                m747b(view);
            } else if (c0101c.f372b == 1.0f) {
                m749c(view);
            }
        }
        if (i3 != this.f337k) {
            this.f337k = i3;
            if (this.f344r != null) {
                this.f344r.m775a(i3);
            }
        }
    }

    void m743a(View view, float f) {
        if (this.f344r != null) {
            this.f344r.m777a(view, f);
        }
    }

    void m744a(boolean z) {
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            C0101c c0101c = (C0101c) childAt.getLayoutParams();
            if (m753g(childAt) && (!z || c0101c.f373c)) {
                i = m745a(childAt, 3) ? i | this.f333g.m891a(childAt, -childAt.getWidth(), childAt.getTop()) : i | this.f334h.m891a(childAt, getWidth(), childAt.getTop());
                c0101c.f373c = false;
            }
        }
        this.f335i.m797a();
        this.f336j.m797a();
        if (i != 0) {
            invalidate();
        }
    }

    boolean m745a(View view, int i) {
        return (m751e(view) & i) == i;
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (i > 0 || (i < 0 && getChildCount() > 0)) {
            ak.m539b(view, 4);
            ak.m535a(view, this.f328b);
        } else {
            ak.m539b(view, 1);
        }
        super.addView(view, i, layoutParams);
    }

    public void m746b() {
        m744a(false);
    }

    void m747b(View view) {
        C0101c c0101c = (C0101c) view.getLayoutParams();
        if (c0101c.f374d) {
            c0101c.f374d = false;
            if (this.f344r != null) {
                this.f344r.m778b(view);
            }
            View childAt = getChildAt(0);
            if (childAt != null) {
                ak.m539b(childAt, 1);
            }
            ak.m539b(view, 4);
            if (hasWindowFocus()) {
                childAt = getRootView();
                if (childAt != null) {
                    childAt.sendAccessibilityEvent(32);
                }
            }
        }
    }

    void m748b(View view, float f) {
        C0101c c0101c = (C0101c) view.getLayoutParams();
        if (f != c0101c.f372b) {
            c0101c.f372b = f;
            m743a(view, f);
        }
    }

    void m749c(View view) {
        C0101c c0101c = (C0101c) view.getLayoutParams();
        if (!c0101c.f374d) {
            c0101c.f374d = true;
            if (this.f344r != null) {
                this.f344r.m776a(view);
            }
            View childAt = getChildAt(0);
            if (childAt != null) {
                ak.m539b(childAt, 4);
            }
            ak.m539b(view, 1);
            sendAccessibilityEvent(32);
            view.requestFocus();
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof C0101c) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((C0101c) getChildAt(i).getLayoutParams()).f372b);
        }
        this.f331e = f;
        if ((this.f333g.m892a(true) | this.f334h.m892a(true)) != 0) {
            ak.m538b(this);
        }
    }

    float m750d(View view) {
        return ((C0101c) view.getLayoutParams()).f372b;
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        int i;
        int height = getHeight();
        boolean f = m752f(view);
        int i2 = 0;
        int width = getWidth();
        int save = canvas.save();
        if (f) {
            int childCount = getChildCount();
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt != view && childAt.getVisibility() == 0 && m736l(childAt) && m753g(childAt)) {
                    if (childAt.getHeight() < height) {
                        i = width;
                    } else if (m745a(childAt, 3)) {
                        i = childAt.getRight();
                        if (i <= i2) {
                            i = i2;
                        }
                        i2 = i;
                        i = width;
                    } else {
                        i = childAt.getLeft();
                        if (i < width) {
                        }
                    }
                    i3++;
                    width = i;
                }
                i = width;
                i3++;
                width = i;
            }
            canvas.clipRect(i2, 0, width, getHeight());
        }
        i = width;
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        if (this.f331e > 0.0f && f) {
            this.f332f.setColor((((int) (((float) ((this.f330d & -16777216) >>> 24)) * this.f331e)) << 24) | (this.f330d & 16777215));
            canvas.drawRect((float) i2, 0.0f, (float) i, (float) getHeight(), this.f332f);
        } else if (this.f347u != null && m745a(view, 3)) {
            i = this.f347u.getIntrinsicWidth();
            i2 = view.getRight();
            r2 = Math.max(0.0f, Math.min(((float) i2) / ((float) this.f333g.m893b()), 1.0f));
            this.f347u.setBounds(i2, view.getTop(), i + i2, view.getBottom());
            this.f347u.setAlpha((int) (255.0f * r2));
            this.f347u.draw(canvas);
        } else if (this.f348v != null && m745a(view, 5)) {
            i = this.f348v.getIntrinsicWidth();
            i2 = view.getLeft();
            r2 = Math.max(0.0f, Math.min(((float) (getWidth() - i2)) / ((float) this.f334h.m893b()), 1.0f));
            this.f348v.setBounds(i2 - i, view.getTop(), i2, view.getBottom());
            this.f348v.setAlpha((int) (255.0f * r2));
            this.f348v.draw(canvas);
        }
        return drawChild;
    }

    int m751e(View view) {
        return C0086n.m699a(((C0101c) view.getLayoutParams()).f371a, ak.m542e(this));
    }

    boolean m752f(View view) {
        return ((C0101c) view.getLayoutParams()).f371a == 0;
    }

    boolean m753g(View view) {
        return (C0086n.m699a(((C0101c) view.getLayoutParams()).f371a, ak.m542e(view)) & 7) != 0;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new C0101c(-1, -1);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0101c(getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof C0101c ? new C0101c((C0101c) layoutParams) : layoutParams instanceof MarginLayoutParams ? new C0101c((MarginLayoutParams) layoutParams) : new C0101c(layoutParams);
    }

    public void m754h(View view) {
        if (m753g(view)) {
            if (this.f339m) {
                C0101c c0101c = (C0101c) view.getLayoutParams();
                c0101c.f372b = 1.0f;
                c0101c.f374d = true;
            } else if (m745a(view, 3)) {
                this.f333g.m891a(view, 0, view.getTop());
            } else {
                this.f334h.m891a(view, getWidth() - view.getWidth(), view.getTop());
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public void m755i(View view) {
        if (m753g(view)) {
            if (this.f339m) {
                C0101c c0101c = (C0101c) view.getLayoutParams();
                c0101c.f372b = 0.0f;
                c0101c.f374d = false;
            } else if (m745a(view, 3)) {
                this.f333g.m891a(view, -view.getWidth(), view.getTop());
            } else {
                this.f334h.m891a(view, getWidth(), view.getTop());
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public boolean m756j(View view) {
        if (m753g(view)) {
            return ((C0101c) view.getLayoutParams()).f372b > 0.0f;
        } else {
            throw new IllegalArgumentException("View " + view + " is not a drawer");
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f339m = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f339m = true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int a = this.f333g.m890a(motionEvent) | this.f334h.m890a(motionEvent);
        switch (C0098z.m723a(motionEvent)) {
            case cm.HListView_android_entries /*0*/:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.f345s = x;
                this.f346t = y;
                z = this.f331e > 0.0f && m752f(this.f333g.m903d((int) x, (int) y));
                this.f342p = false;
                this.f343q = false;
                break;
            case cm.HListView_android_divider /*1*/:
            case cm.HListView_hlv_headerDividersEnabled /*3*/:
                m744a(true);
                this.f342p = false;
                this.f343q = false;
            case cm.HListView_hlv_dividerWidth /*2*/:
                if (this.f333g.m904d(3)) {
                    this.f335i.m797a();
                    this.f336j.m797a();
                    z = false;
                    break;
                }
        }
        z = false;
        return a != 0 || z || m732d() || this.f343q;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !m733e()) {
            return super.onKeyDown(i, keyEvent);
        }
        C0091s.m706b(keyEvent);
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View f = m734f();
        if (f != null && m738a(f) == 0) {
            m746b();
        }
        return f != null;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f338l = true;
        int i5 = i3 - i;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                C0101c c0101c = (C0101c) childAt.getLayoutParams();
                if (m752f(childAt)) {
                    childAt.layout(c0101c.leftMargin, c0101c.topMargin, c0101c.leftMargin + childAt.getMeasuredWidth(), c0101c.topMargin + childAt.getMeasuredHeight());
                } else {
                    int i7;
                    float f;
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (m745a(childAt, 3)) {
                        i7 = ((int) (((float) measuredWidth) * c0101c.f372b)) + (-measuredWidth);
                        f = ((float) (measuredWidth + i7)) / ((float) measuredWidth);
                    } else {
                        i7 = i5 - ((int) (((float) measuredWidth) * c0101c.f372b));
                        f = ((float) (i5 - i7)) / ((float) measuredWidth);
                    }
                    Object obj = f != c0101c.f372b ? 1 : null;
                    int i8;
                    switch (c0101c.f371a & 112) {
                        case 16:
                            int i9 = i4 - i2;
                            i8 = (i9 - measuredHeight) / 2;
                            if (i8 < c0101c.topMargin) {
                                i8 = c0101c.topMargin;
                            } else if (i8 + measuredHeight > i9 - c0101c.bottomMargin) {
                                i8 = (i9 - c0101c.bottomMargin) - measuredHeight;
                            }
                            childAt.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
                            break;
                        case 80:
                            i8 = i4 - i2;
                            childAt.layout(i7, (i8 - c0101c.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i7, i8 - c0101c.bottomMargin);
                            break;
                        default:
                            childAt.layout(i7, c0101c.topMargin, measuredWidth + i7, measuredHeight + c0101c.topMargin);
                            break;
                    }
                    if (obj != null) {
                        m748b(childAt, f);
                    }
                    int i10 = c0101c.f372b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i10) {
                        childAt.setVisibility(i10);
                    }
                }
            }
        }
        this.f338l = false;
        this.f339m = false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onMeasure(int i, int i2) {
        View childAt;
        C0101c c0101c;
        int e;
        int i3 = 300;
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (!(mode == 1073741824 && mode2 == 1073741824)) {
            if (isInEditMode()) {
                if (mode != Integer.MIN_VALUE && mode == 0) {
                    size = 300;
                }
                if (mode2 == Integer.MIN_VALUE) {
                    i3 = size2;
                }
                setMeasuredDimension(size, i3);
                mode2 = getChildCount();
                for (mode = 0; mode < mode2; mode++) {
                    childAt = getChildAt(mode);
                    if (childAt.getVisibility() == 8) {
                        c0101c = (C0101c) childAt.getLayoutParams();
                        if (m752f(childAt)) {
                            childAt.measure(MeasureSpec.makeMeasureSpec((size - c0101c.leftMargin) - c0101c.rightMargin, 1073741824), MeasureSpec.makeMeasureSpec((i3 - c0101c.topMargin) - c0101c.bottomMargin, 1073741824));
                        } else if (m753g(childAt)) {
                            throw new IllegalStateException("Child " + childAt + " at index " + mode + " does not have a valid layout_gravity - must be Gravity.LEFT, " + "Gravity.RIGHT or Gravity.NO_GRAVITY");
                        } else {
                            e = m751e(childAt) & 7;
                            if ((0 & e) == 0) {
                                throw new IllegalStateException("Child drawer has absolute gravity " + m730b(e) + " but this " + "DrawerLayout" + " already has a " + "drawer view along that edge");
                            }
                            childAt.measure(getChildMeasureSpec(i, (this.f329c + c0101c.leftMargin) + c0101c.rightMargin, c0101c.width), getChildMeasureSpec(i2, c0101c.topMargin + c0101c.bottomMargin, c0101c.height));
                        }
                    }
                }
            }
            throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
        }
        i3 = size2;
        setMeasuredDimension(size, i3);
        mode2 = getChildCount();
        for (mode = 0; mode < mode2; mode++) {
            childAt = getChildAt(mode);
            if (childAt.getVisibility() == 8) {
                c0101c = (C0101c) childAt.getLayoutParams();
                if (m752f(childAt)) {
                    childAt.measure(MeasureSpec.makeMeasureSpec((size - c0101c.leftMargin) - c0101c.rightMargin, 1073741824), MeasureSpec.makeMeasureSpec((i3 - c0101c.topMargin) - c0101c.bottomMargin, 1073741824));
                } else if (m753g(childAt)) {
                    throw new IllegalStateException("Child " + childAt + " at index " + mode + " does not have a valid layout_gravity - must be Gravity.LEFT, " + "Gravity.RIGHT or Gravity.NO_GRAVITY");
                } else {
                    e = m751e(childAt) & 7;
                    if ((0 & e) == 0) {
                        childAt.measure(getChildMeasureSpec(i, (this.f329c + c0101c.leftMargin) + c0101c.rightMargin, c0101c.width), getChildMeasureSpec(i2, c0101c.topMargin + c0101c.bottomMargin, c0101c.height));
                    } else {
                        throw new IllegalStateException("Child drawer has absolute gravity " + m730b(e) + " but this " + "DrawerLayout" + " already has a " + "drawer view along that edge");
                    }
                }
            }
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f324a != 0) {
            View a = m740a(savedState.f324a);
            if (a != null) {
                m754h(a);
            }
        }
        m741a(savedState.f325b, 3);
        m741a(savedState.f326c, 5);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m753g(childAt)) {
                C0101c c0101c = (C0101c) childAt.getLayoutParams();
                if (c0101c.f374d) {
                    savedState.f324a = c0101c.f371a;
                    break;
                }
            }
        }
        savedState.f325b = this.f340n;
        savedState.f326c = this.f341o;
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f333g.m894b(motionEvent);
        this.f334h.m894b(motionEvent);
        float x;
        float y;
        switch (motionEvent.getAction() & 255) {
            case cm.HListView_android_entries /*0*/:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.f345s = x;
                this.f346t = y;
                this.f342p = false;
                this.f343q = false;
                break;
            case cm.HListView_android_divider /*1*/:
                boolean z;
                x = motionEvent.getX();
                y = motionEvent.getY();
                View d = this.f333g.m903d((int) x, (int) y);
                if (d != null && m752f(d)) {
                    x -= this.f345s;
                    y -= this.f346t;
                    int d2 = this.f333g.m902d();
                    if ((x * x) + (y * y) < ((float) (d2 * d2))) {
                        View a = m739a();
                        if (a != null) {
                            z = m738a(a) == 2;
                            m744a(z);
                            this.f342p = false;
                            break;
                        }
                    }
                }
                z = true;
                m744a(z);
                this.f342p = false;
            case cm.HListView_hlv_headerDividersEnabled /*3*/:
                m744a(true);
                this.f342p = false;
                this.f343q = false;
                break;
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.f342p = z;
        if (z) {
            m744a(true);
        }
    }

    public void requestLayout() {
        if (!this.f338l) {
            super.requestLayout();
        }
    }

    public void setDrawerListener(C0100b c0100b) {
        this.f344r = c0100b;
    }

    public void setDrawerLockMode(int i) {
        m741a(i, 3);
        m741a(i, 5);
    }

    public void setScrimColor(int i) {
        this.f330d = i;
        invalidate();
    }
}
