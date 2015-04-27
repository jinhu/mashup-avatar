package android.support.v4.widget;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.C0098z;
import android.support.v4.view.ak;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.google.android.apps.androidify.cm;
import java.util.ArrayList;

public class SlidingPaneLayout extends ViewGroup {
    static final C0117r f350a;
    private int f351b;
    private int f352c;
    private Drawable f353d;
    private Drawable f354e;
    private final int f355f;
    private boolean f356g;
    private View f357h;
    private float f358i;
    private float f359j;
    private int f360k;
    private boolean f361l;
    private int f362m;
    private float f363n;
    private float f364o;
    private C0115p f365p;
    private final C0121v f366q;
    private boolean f367r;
    private boolean f368s;
    private final Rect f369t;
    private final ArrayList f370u;

    class SavedState extends BaseSavedState {
        public static final Creator CREATOR;
        boolean f349a;

        static {
            CREATOR = new C0116q();
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f349a = parcel.readInt() != 0;
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f349a ? 1 : 0);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 17) {
            f350a = new C0120u();
        } else if (i >= 16) {
            f350a = new C0119t();
        } else {
            f350a = new C0118s();
        }
    }

    private void m758a(float f) {
        Object obj;
        int childCount;
        int i;
        View childAt;
        int i2;
        boolean f2 = m765f();
        C0114o c0114o = (C0114o) this.f357h.getLayoutParams();
        if (c0114o.f388c) {
            if ((f2 ? c0114o.rightMargin : c0114o.leftMargin) <= 0) {
                obj = 1;
                childCount = getChildCount();
                for (i = 0; i < childCount; i++) {
                    childAt = getChildAt(i);
                    if (childAt == this.f357h) {
                        i2 = (int) ((1.0f - this.f359j) * ((float) this.f362m));
                        this.f359j = f;
                        i2 -= (int) ((1.0f - f) * ((float) this.f362m));
                        if (f2) {
                            i2 = -i2;
                        }
                        childAt.offsetLeftAndRight(i2);
                        if (obj == null) {
                            m760a(childAt, f2 ? this.f359j - 1.0f : 1.0f - this.f359j, this.f352c);
                        }
                    }
                }
            }
        }
        obj = null;
        childCount = getChildCount();
        for (i = 0; i < childCount; i++) {
            childAt = getChildAt(i);
            if (childAt == this.f357h) {
                i2 = (int) ((1.0f - this.f359j) * ((float) this.f362m));
                this.f359j = f;
                i2 -= (int) ((1.0f - f) * ((float) this.f362m));
                if (f2) {
                    i2 = -i2;
                }
                childAt.offsetLeftAndRight(i2);
                if (obj == null) {
                    if (f2) {
                    }
                    m760a(childAt, f2 ? this.f359j - 1.0f : 1.0f - this.f359j, this.f352c);
                }
            }
        }
    }

    private void m760a(View view, float f, int i) {
        C0114o c0114o = (C0114o) view.getLayoutParams();
        if (f > 0.0f && i != 0) {
            int i2 = (((int) (((float) ((-16777216 & i) >>> 24)) * f)) << 24) | (16777215 & i);
            if (c0114o.f389d == null) {
                c0114o.f389d = new Paint();
            }
            c0114o.f389d.setColorFilter(new PorterDuffColorFilter(i2, Mode.SRC_OVER));
            if (ak.m541d(view) != 2) {
                ak.m533a(view, 2, c0114o.f389d);
            }
            m764d(view);
        } else if (ak.m541d(view) != 0) {
            if (c0114o.f389d != null) {
                c0114o.f389d.setColorFilter(null);
            }
            Runnable c0113n = new C0113n(this, view);
            this.f370u.add(c0113n);
            ak.m536a((View) this, c0113n);
        }
    }

    private boolean m761a(View view, int i) {
        if (!this.f368s && !m768a(0.0f, i)) {
            return false;
        }
        this.f367r = false;
        return true;
    }

    private boolean m762b(View view, int i) {
        if (!this.f368s && !m768a(1.0f, i)) {
            return false;
        }
        this.f367r = true;
        return true;
    }

    private static boolean m763c(View view) {
        if (ak.m543f(view)) {
            return true;
        }
        if (VERSION.SDK_INT >= 18) {
            return false;
        }
        Drawable background = view.getBackground();
        return background != null ? background.getOpacity() == -1 : false;
    }

    private void m764d(View view) {
        f350a.m864a(this, view);
    }

    private boolean m765f() {
        return ak.m542e(this) == 1;
    }

    void m766a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    void m767a(View view) {
        int i;
        int i2;
        int i3;
        int i4;
        boolean f = m765f();
        int width = f ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = f ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view == null || !m763c(view)) {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        } else {
            i4 = view.getLeft();
            i3 = view.getRight();
            i2 = view.getTop();
            i = view.getBottom();
        }
        int childCount = getChildCount();
        int i5 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt != view) {
                int i6 = (Math.max(f ? paddingLeft : width, childAt.getLeft()) < i4 || Math.max(paddingTop, childAt.getTop()) < i2 || Math.min(f ? width : paddingLeft, childAt.getRight()) > i3 || Math.min(height, childAt.getBottom()) > i) ? 0 : 4;
                childAt.setVisibility(i6);
                i5++;
            } else {
                return;
            }
        }
    }

    boolean m768a(float f, int i) {
        if (!this.f356g) {
            return false;
        }
        int width;
        C0114o c0114o = (C0114o) this.f357h.getLayoutParams();
        if (m765f()) {
            width = (int) (((float) getWidth()) - ((((float) (c0114o.rightMargin + getPaddingRight())) + (((float) this.f360k) * f)) + ((float) this.f357h.getWidth())));
        } else {
            width = (int) (((float) (c0114o.leftMargin + getPaddingLeft())) + (((float) this.f360k) * f));
        }
        if (!this.f366q.m891a(this.f357h, width, this.f357h.getTop())) {
            return false;
        }
        m766a();
        ak.m538b(this);
        return true;
    }

    public boolean m769b() {
        return m762b(this.f357h, 0);
    }

    boolean m770b(View view) {
        if (view == null) {
            return false;
        }
        boolean z = this.f356g && ((C0114o) view.getLayoutParams()).f388c && this.f358i > 0.0f;
        return z;
    }

    public boolean m771c() {
        return m761a(this.f357h, 0);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof C0114o) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        if (!this.f366q.m892a(true)) {
            return;
        }
        if (this.f356g) {
            ak.m538b(this);
        } else {
            this.f366q.m906f();
        }
    }

    public boolean m772d() {
        return !this.f356g || this.f358i == 1.0f;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = m765f() ? this.f354e : this.f353d;
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt != null && drawable != null) {
            int right;
            int i;
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (m765f()) {
                right = childAt.getRight();
                i = right + intrinsicWidth;
            } else {
                i = childAt.getLeft();
                right = i - intrinsicWidth;
            }
            drawable.setBounds(right, top, i, bottom);
            drawable.draw(canvas);
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild;
        C0114o c0114o = (C0114o) view.getLayoutParams();
        int save = canvas.save(2);
        if (!(!this.f356g || c0114o.f387b || this.f357h == null)) {
            canvas.getClipBounds(this.f369t);
            if (m765f()) {
                this.f369t.left = Math.max(this.f369t.left, this.f357h.getRight());
            } else {
                this.f369t.right = Math.min(this.f369t.right, this.f357h.getLeft());
            }
            canvas.clipRect(this.f369t);
        }
        if (VERSION.SDK_INT >= 11) {
            drawChild = super.drawChild(canvas, view, j);
        } else if (!c0114o.f388c || this.f358i <= 0.0f) {
            if (view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(false);
            }
            drawChild = super.drawChild(canvas, view, j);
        } else {
            if (!view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(true);
            }
            Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache != null) {
                canvas.drawBitmap(drawingCache, (float) view.getLeft(), (float) view.getTop(), c0114o.f389d);
                drawChild = false;
            } else {
                Log.e("SlidingPaneLayout", "drawChild: child view " + view + " returned null drawing cache");
                drawChild = super.drawChild(canvas, view, j);
            }
        }
        canvas.restoreToCount(save);
        return drawChild;
    }

    public boolean m773e() {
        return this.f356g;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new C0114o();
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0114o(getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new C0114o((MarginLayoutParams) layoutParams) : new C0114o(layoutParams);
    }

    public int getCoveredFadeColor() {
        return this.f352c;
    }

    public int getParallaxDistance() {
        return this.f362m;
    }

    public int getSliderFadeColor() {
        return this.f351b;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f368s = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f368s = true;
        int size = this.f370u.size();
        for (int i = 0; i < size; i++) {
            ((C0113n) this.f370u.get(i)).run();
        }
        this.f370u.clear();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int a = C0098z.m723a(motionEvent);
        if (!this.f356g && a == 0 && getChildCount() > 1) {
            View childAt = getChildAt(1);
            if (childAt != null) {
                this.f367r = !this.f366q.m898b(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
            }
        }
        if (!this.f356g || (this.f361l && a != 0)) {
            this.f366q.m905e();
            return super.onInterceptTouchEvent(motionEvent);
        } else if (a == 3 || a == 1) {
            this.f366q.m905e();
            return false;
        } else {
            boolean z;
            float x;
            float y;
            switch (a) {
                case cm.HListView_android_entries /*0*/:
                    this.f361l = false;
                    x = motionEvent.getX();
                    y = motionEvent.getY();
                    this.f363n = x;
                    this.f364o = y;
                    if (this.f366q.m898b(this.f357h, (int) x, (int) y) && m770b(this.f357h)) {
                        z = true;
                        break;
                    }
                case cm.HListView_hlv_dividerWidth /*2*/:
                    x = motionEvent.getX();
                    y = motionEvent.getY();
                    x = Math.abs(x - this.f363n);
                    y = Math.abs(y - this.f364o);
                    if (x > ((float) this.f366q.m902d()) && y > x) {
                        this.f366q.m905e();
                        this.f361l = true;
                        return false;
                    }
                    z = false;
                    break;
            }
            z = false;
            return this.f366q.m890a(motionEvent) || z;
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean f = m765f();
        if (f) {
            this.f366q.m887a(2);
        } else {
            this.f366q.m887a(1);
        }
        int i5 = i3 - i;
        int paddingRight = f ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = f ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.f368s) {
            float f2 = (this.f356g && this.f367r) ? 1.0f : 0.0f;
            this.f358i = f2;
        }
        int i6 = 0;
        int i7 = paddingRight;
        while (i6 < childCount) {
            int i8;
            int i9;
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() == 8) {
                i8 = paddingRight;
                i9 = i7;
            } else {
                int i10;
                C0114o c0114o = (C0114o) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (c0114o.f387b) {
                    int min = (Math.min(paddingRight, (i5 - paddingLeft) - this.f355f) - i7) - (c0114o.leftMargin + c0114o.rightMargin);
                    this.f360k = min;
                    i9 = f ? c0114o.rightMargin : c0114o.leftMargin;
                    c0114o.f388c = ((i7 + i9) + min) + (measuredWidth / 2) > i5 - paddingLeft;
                    i8 = (int) (((float) min) * this.f358i);
                    i10 = i7 + (i9 + i8);
                    this.f358i = ((float) i8) / ((float) this.f360k);
                    i8 = 0;
                } else if (!this.f356g || this.f362m == 0) {
                    i8 = 0;
                    i10 = paddingRight;
                } else {
                    i8 = (int) ((1.0f - this.f358i) * ((float) this.f362m));
                    i10 = paddingRight;
                }
                if (f) {
                    i9 = (i5 - i10) + i8;
                    i8 = i9 - measuredWidth;
                } else {
                    i8 = i10 - i8;
                    i9 = i8 + measuredWidth;
                }
                childAt.layout(i8, paddingTop, i9, childAt.getMeasuredHeight() + paddingTop);
                i8 = childAt.getWidth() + paddingRight;
                i9 = i10;
            }
            i6++;
            paddingRight = i8;
            i7 = i9;
        }
        if (this.f368s) {
            if (this.f356g) {
                if (this.f362m != 0) {
                    m758a(this.f358i);
                }
                if (((C0114o) this.f357h.getLayoutParams()).f388c) {
                    m760a(this.f357h, this.f358i, this.f351b);
                }
            } else {
                for (i8 = 0; i8 < childCount; i8++) {
                    m760a(getChildAt(i8), 0.0f, this.f351b);
                }
            }
            m767a(this.f357h);
        }
        this.f368s = false;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            if (mode2 == 0) {
                if (!isInEditMode()) {
                    throw new IllegalStateException("Height must not be UNSPECIFIED");
                } else if (mode2 == 0) {
                    i3 = Integer.MIN_VALUE;
                    i4 = size;
                    size = 300;
                }
            }
            i3 = mode2;
            i4 = size;
            size = size2;
        } else if (!isInEditMode()) {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        } else if (mode == Integer.MIN_VALUE) {
            i3 = mode2;
            i4 = size;
            size = size2;
        } else {
            if (mode == 0) {
                i3 = mode2;
                i4 = 300;
                size = size2;
            }
            i3 = mode2;
            i4 = size;
            size = size2;
        }
        switch (i3) {
            case Integer.MIN_VALUE:
                size2 = 0;
                mode2 = (size - getPaddingTop()) - getPaddingBottom();
                break;
            case 1073741824:
                size2 = (size - getPaddingTop()) - getPaddingBottom();
                mode2 = size2;
                break;
            default:
                size2 = 0;
                mode2 = -1;
                break;
        }
        boolean z = false;
        int paddingLeft = (i4 - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.f357h = null;
        int i6 = 0;
        int i7 = paddingLeft;
        int i8 = size2;
        float f = 0.0f;
        while (i6 < childCount) {
            float f2;
            boolean z2;
            View childAt = getChildAt(i6);
            C0114o c0114o = (C0114o) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                c0114o.f388c = false;
                size2 = i7;
                f2 = f;
                i5 = i8;
                z2 = z;
            } else {
                if (c0114o.f386a > 0.0f) {
                    f += c0114o.f386a;
                    if (c0114o.width == 0) {
                        size2 = i7;
                        f2 = f;
                        i5 = i8;
                        z2 = z;
                    }
                }
                mode = c0114o.leftMargin + c0114o.rightMargin;
                mode = c0114o.width == -2 ? MeasureSpec.makeMeasureSpec(paddingLeft - mode, Integer.MIN_VALUE) : c0114o.width == -1 ? MeasureSpec.makeMeasureSpec(paddingLeft - mode, 1073741824) : MeasureSpec.makeMeasureSpec(c0114o.width, 1073741824);
                i5 = c0114o.height == -2 ? MeasureSpec.makeMeasureSpec(mode2, Integer.MIN_VALUE) : c0114o.height == -1 ? MeasureSpec.makeMeasureSpec(mode2, 1073741824) : MeasureSpec.makeMeasureSpec(c0114o.height, 1073741824);
                childAt.measure(mode, i5);
                mode = childAt.getMeasuredWidth();
                i5 = childAt.getMeasuredHeight();
                if (i3 == Integer.MIN_VALUE && i5 > i8) {
                    i8 = Math.min(i5, mode2);
                }
                i5 = i7 - mode;
                boolean z3 = i5 < 0;
                c0114o.f387b = z3;
                z3 |= z;
                if (c0114o.f387b) {
                    this.f357h = childAt;
                }
                size2 = i5;
                i5 = i8;
                float f3 = f;
                z2 = z3;
                f2 = f3;
            }
            i6++;
            z = z2;
            i8 = i5;
            f = f2;
            i7 = size2;
        }
        if (z || f > 0.0f) {
            int i9 = paddingLeft - this.f355f;
            for (i3 = 0; i3 < childCount; i3++) {
                View childAt2 = getChildAt(i3);
                if (childAt2.getVisibility() != 8) {
                    c0114o = (C0114o) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != 8) {
                        Object obj = (c0114o.width != 0 || c0114o.f386a <= 0.0f) ? null : 1;
                        i5 = obj != null ? 0 : childAt2.getMeasuredWidth();
                        if (!z || childAt2 == this.f357h) {
                            if (c0114o.f386a > 0.0f) {
                                mode = c0114o.width == 0 ? c0114o.height == -2 ? MeasureSpec.makeMeasureSpec(mode2, Integer.MIN_VALUE) : c0114o.height == -1 ? MeasureSpec.makeMeasureSpec(mode2, 1073741824) : MeasureSpec.makeMeasureSpec(c0114o.height, 1073741824) : MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                if (z) {
                                    size2 = paddingLeft - (c0114o.rightMargin + c0114o.leftMargin);
                                    i6 = MeasureSpec.makeMeasureSpec(size2, 1073741824);
                                    if (i5 != size2) {
                                        childAt2.measure(i6, mode);
                                    }
                                } else {
                                    childAt2.measure(MeasureSpec.makeMeasureSpec(((int) ((c0114o.f386a * ((float) Math.max(0, i7))) / f)) + i5, 1073741824), mode);
                                }
                            }
                        } else if (c0114o.width < 0 && (i5 > i9 || c0114o.f386a > 0.0f)) {
                            size2 = obj != null ? c0114o.height == -2 ? MeasureSpec.makeMeasureSpec(mode2, Integer.MIN_VALUE) : c0114o.height == -1 ? MeasureSpec.makeMeasureSpec(mode2, 1073741824) : MeasureSpec.makeMeasureSpec(c0114o.height, 1073741824) : MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            childAt2.measure(MeasureSpec.makeMeasureSpec(i9, 1073741824), size2);
                        }
                    }
                }
            }
        }
        setMeasuredDimension(i4, (getPaddingTop() + i8) + getPaddingBottom());
        this.f356g = z;
        if (this.f366q.m886a() != 0 && !z) {
            this.f366q.m906f();
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f349a) {
            m769b();
        } else {
            m771c();
        }
        this.f367r = savedState.f349a;
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f349a = m773e() ? m772d() : this.f367r;
        return savedState;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.f368s = true;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f356g) {
            return super.onTouchEvent(motionEvent);
        }
        this.f366q.m894b(motionEvent);
        float x;
        float y;
        switch (motionEvent.getAction() & 255) {
            case cm.HListView_android_entries /*0*/:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.f363n = x;
                this.f364o = y;
                return true;
            case cm.HListView_android_divider /*1*/:
                if (!m770b(this.f357h)) {
                    return true;
                }
                x = motionEvent.getX();
                y = motionEvent.getY();
                float f = x - this.f363n;
                float f2 = y - this.f364o;
                int d = this.f366q.m902d();
                if ((f * f) + (f2 * f2) >= ((float) (d * d)) || !this.f366q.m898b(this.f357h, (int) x, (int) y)) {
                    return true;
                }
                m761a(this.f357h, 0);
                return true;
            default:
                return true;
        }
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.f356g) {
            this.f367r = view == this.f357h;
        }
    }

    public void setCoveredFadeColor(int i) {
        this.f352c = i;
    }

    public void setPanelSlideListener(C0115p c0115p) {
        this.f365p = c0115p;
    }

    public void setParallaxDistance(int i) {
        this.f362m = i;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(Drawable drawable) {
        this.f353d = drawable;
    }

    public void setShadowDrawableRight(Drawable drawable) {
        this.f354e = drawable;
    }

    @Deprecated
    public void setShadowResource(int i) {
        setShadowDrawable(getResources().getDrawable(i));
    }

    public void setShadowResourceLeft(int i) {
        setShadowDrawableLeft(getResources().getDrawable(i));
    }

    public void setShadowResourceRight(int i) {
        setShadowDrawableRight(getResources().getDrawable(i));
    }

    public void setSliderFadeColor(int i) {
        this.f351b = i;
    }
}
