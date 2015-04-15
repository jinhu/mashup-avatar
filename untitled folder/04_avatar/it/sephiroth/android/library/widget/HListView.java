package it.sephiroth.android.library.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.c.n;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ArrayAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;
import android.widget.RemoteViews.RemoteView;
import com.google.android.apps.androidify.R;
import com.google.android.apps.androidify.cm;
import java.util.ArrayList;

@RemoteView
public class HListView extends AbsHListView {
    private boolean aA;
    private boolean aB;
    private boolean aC;
    private boolean aD;
    private boolean aE;
    private boolean aF;
    private final Rect aG;
    private Paint aH;
    private final ao aI;
    private aq aJ;
    Drawable at;
    int au;
    int av;
    Drawable aw;
    Drawable ax;
    private ArrayList ay;
    private ArrayList az;

    public HListView(Context context) {
        this(context, null);
    }

    public HListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.hlv_listViewStyle);
    }

    public HListView(Context context, AttributeSet attributeSet, int i) {
        Object[] textArray;
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        int dimensionPixelSize;
        boolean z;
        int i2 = -1;
        boolean z2 = true;
        super(context, attributeSet, i);
        this.ay = new ArrayList();
        this.az = new ArrayList();
        this.aE = true;
        this.aF = false;
        this.aG = new Rect();
        this.aI = new ao();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, cm.HListView, i, 0);
        if (obtainStyledAttributes != null) {
            textArray = obtainStyledAttributes.getTextArray(0);
            drawable = obtainStyledAttributes.getDrawable(1);
            drawable2 = obtainStyledAttributes.getDrawable(5);
            drawable3 = obtainStyledAttributes.getDrawable(6);
            dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(2, 0);
            z = obtainStyledAttributes.getBoolean(3, true);
            z2 = obtainStyledAttributes.getBoolean(4, true);
            i2 = obtainStyledAttributes.getInteger(7, -1);
            obtainStyledAttributes.recycle();
        } else {
            drawable3 = null;
            drawable2 = null;
            drawable = null;
            textArray = null;
            dimensionPixelSize = 0;
            z = true;
        }
        if (textArray != null) {
            setAdapter(new ArrayAdapter(context, 17367043, textArray));
        }
        if (drawable != null) {
            setDivider(drawable);
        }
        if (drawable2 != null) {
            setOverscrollHeader(drawable2);
        }
        if (drawable3 != null) {
            setOverscrollFooter(drawable3);
        }
        if (dimensionPixelSize != 0) {
            setDividerWidth(dimensionPixelSize);
        }
        this.aC = z;
        this.aD = z2;
        this.av = i2;
    }

    private boolean A() {
        int childCount = getChildCount();
        return (childCount + this.V) + -1 < this.an + -1 || getChildAt(childCount - 1).getRight() < (getScrollX() + getWidth()) - this.u.right;
    }

    private int a(int i, View view, int i2) {
        view.getDrawingRect(this.aG);
        offsetDescendantRectToMyCoords(view, this.aG);
        int i3;
        if (i != 33) {
            int width = getWidth() - this.u.right;
            if (this.aG.bottom <= width) {
                return 0;
            }
            i3 = this.aG.right - width;
            return i2 < this.an + -1 ? i3 + getArrowScrollPreviewLength() : i3;
        } else if (this.aG.left >= this.u.left) {
            return 0;
        } else {
            i3 = this.u.left - this.aG.left;
            return i2 > 0 ? i3 + getArrowScrollPreviewLength() : i3;
        }
    }

    private View a(int i, int i2, int i3) {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int i4 = this.al;
        int c = c(i2, horizontalFadingEdgeLength, i4);
        int b = b(i3, horizontalFadingEdgeLength, i4);
        View a = a(i4, i, true, this.u.top, true);
        if (a.getRight() > b) {
            a.offsetLeftAndRight(-Math.min(a.getLeft() - c, a.getRight() - b));
        } else if (a.getLeft() < c) {
            a.offsetLeftAndRight(Math.min(c - a.getLeft(), b - a.getRight()));
        }
        a(a, i4);
        if (this.K) {
            n(getChildCount());
        } else {
            m(getChildCount());
        }
        return a;
    }

    private View a(int i, int i2, boolean z, int i3, boolean z2) {
        View c;
        if (!this.ai) {
            c = this.p.c(i);
            if (c != null) {
                a(c, i, i2, z, i3, z2, true);
                return c;
            }
        }
        c = a(i, this.P);
        a(c, i, i2, z, i3, z2, this.P[0]);
        return c;
    }

    private View a(View view, View view2, int i, int i2, int i3) {
        View a;
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int i4 = this.al;
        int c = c(i2, horizontalFadingEdgeLength, i4);
        int b = b(i2, horizontalFadingEdgeLength, i4);
        if (i > 0) {
            View a2 = a(i4 - 1, view.getLeft(), true, this.u.top, false);
            int i5 = this.au;
            a = a(i4, a2.getRight() + i5, true, this.u.top, true);
            if (a.getRight() > b) {
                int min = Math.min(Math.min(a.getLeft() - c, a.getRight() - b), (i3 - i2) / 2);
                a2.offsetLeftAndRight(-min);
                a.offsetLeftAndRight(-min);
            }
            if (this.K) {
                g(this.al + 1, a.getRight() + i5);
                y();
                h(this.al - 2, a.getLeft() - i5);
            } else {
                h(this.al - 2, a.getLeft() - i5);
                y();
                g(this.al + 1, a.getRight() + i5);
            }
        } else if (i < 0) {
            if (view2 != null) {
                a = a(i4, view2.getLeft(), true, this.u.top, true);
            } else {
                a = a(i4, view.getLeft(), false, this.u.top, true);
            }
            if (a.getLeft() < c) {
                a.offsetLeftAndRight(Math.min(Math.min(c - a.getLeft(), b - a.getRight()), (i3 - i2) / 2));
            }
            a(a, i4);
        } else {
            int left = view.getLeft();
            a = a(i4, left, true, this.u.top, true);
            if (left < i2 && a.getRight() < i2 + 20) {
                a.offsetLeftAndRight(i2 - a.getLeft());
            }
            a(a, i4);
        }
        return a;
    }

    private void a(View view, int i) {
        int i2 = this.au;
        if (this.K) {
            g(i + 1, view.getRight() + i2);
            y();
            h(i - 1, view.getLeft() - i2);
            return;
        }
        h(i - 1, view.getLeft() - i2);
        y();
        g(i + 1, i2 + view.getRight());
    }

    private void a(View view, int i, int i2) {
        i iVar = (i) view.getLayoutParams();
        if (iVar == null) {
            iVar = (i) generateDefaultLayoutParams();
            view.setLayoutParams(iVar);
        }
        iVar.a = this.j.getItemViewType(i);
        iVar.c = true;
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, this.u.top + this.u.bottom, iVar.height);
        int i3 = iVar.width;
        view.measure(i3 > 0 ? MeasureSpec.makeMeasureSpec(i3, 1073741824) : MeasureSpec.makeMeasureSpec(0, 0), childMeasureSpec);
    }

    private void a(View view, int i, int i2, boolean z) {
        boolean z2 = true;
        if (i2 == -1) {
            throw new IllegalArgumentException("newSelectedPosition needs to be valid");
        }
        View childAt;
        int i3;
        boolean z3;
        int i4 = this.al - this.V;
        int i5 = i2 - this.V;
        if (i == 33) {
            childAt = getChildAt(i5);
            i3 = i5;
            i5 = i4;
            z3 = true;
        } else {
            childAt = view;
            view = getChildAt(i5);
            i3 = i4;
            z3 = false;
        }
        int childCount = getChildCount();
        if (childAt != null) {
            boolean z4 = !z && z3;
            childAt.setSelected(z4);
            b(childAt, i3, childCount);
        }
        if (view != null) {
            if (z || z3) {
                z2 = false;
            }
            view.setSelected(z2);
            b(view, i5, childCount);
        }
    }

    @TargetApi(11)
    private void a(View view, int i, int i2, boolean z, int i3, boolean z2, boolean z3) {
        int childMeasureSpec;
        boolean z4 = z2 && h();
        Object obj = z4 != view.isSelected() ? 1 : null;
        int i4 = this.F;
        boolean z5 = i4 > 0 && i4 < 3 && this.A == i;
        Object obj2 = z5 != view.isPressed() ? 1 : null;
        Object obj3 = (z3 && obj == null && !view.isLayoutRequested()) ? null : 1;
        LayoutParams layoutParams = (i) view.getLayoutParams();
        LayoutParams layoutParams2 = layoutParams == null ? (i) generateDefaultLayoutParams() : layoutParams;
        layoutParams2.a = this.j.getItemViewType(i);
        if ((!z3 || layoutParams2.c) && !(layoutParams2.b && layoutParams2.a == -2)) {
            layoutParams2.c = false;
            if (layoutParams2.a == -2) {
                layoutParams2.b = true;
            }
            addViewInLayout(view, z ? -1 : 0, layoutParams2, true);
        } else {
            attachViewToParent(view, z ? -1 : 0, layoutParams2);
        }
        if (obj != null) {
            view.setSelected(z4);
        }
        if (obj2 != null) {
            view.setPressed(z5);
        }
        if (!(this.b == 0 || this.f == null)) {
            if (view instanceof Checkable) {
                ((Checkable) view).setChecked(((Boolean) this.f.a(i, Boolean.valueOf(false))).booleanValue());
            } else if (VERSION.SDK_INT >= 11) {
                view.setActivated(((Boolean) this.f.a(i, Boolean.valueOf(false))).booleanValue());
            }
        }
        if (obj3 != null) {
            childMeasureSpec = ViewGroup.getChildMeasureSpec(this.v, this.u.top + this.u.bottom, layoutParams2.height);
            i4 = layoutParams2.width;
            view.measure(i4 > 0 ? MeasureSpec.makeMeasureSpec(i4, 1073741824) : MeasureSpec.makeMeasureSpec(0, 0), childMeasureSpec);
        } else {
            cleanupLayoutState(view);
        }
        i4 = view.getMeasuredWidth();
        childMeasureSpec = view.getMeasuredHeight();
        if (!z) {
            i2 -= i4;
        }
        if (obj3 != null) {
            view.layout(i2, i3, i4 + i2, childMeasureSpec + i3);
        } else {
            view.offsetLeftAndRight(i2 - view.getLeft());
            view.offsetTopAndBottom(i3 - view.getTop());
        }
        if (this.y && !view.isDrawingCacheEnabled()) {
            view.setDrawingCacheEnabled(true);
        }
        if (VERSION.SDK_INT >= 11 && z3 && ((i) view.getLayoutParams()).d != i) {
            view.jumpDrawablesToCurrentState();
        }
    }

    private void a(ArrayList arrayList) {
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                i iVar = (i) ((ap) arrayList.get(i)).a.getLayoutParams();
                if (iVar != null) {
                    iVar.b = false;
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @TargetApi(11)
    private boolean a(int i, int i2, KeyEvent keyEvent) {
        if (this.j == null || !this.S) {
            return false;
        }
        if (this.ai) {
            e();
        }
        if (VERSION.SDK_INT < 11) {
            return false;
        }
        boolean o;
        int action = keyEvent.getAction();
        if (action != 1) {
            int i3;
            switch (i) {
                case 19:
                    if (keyEvent.hasNoModifiers()) {
                        o = o(33);
                        break;
                    }
                case 20:
                    if (keyEvent.hasNoModifiers()) {
                        o = o(130);
                        break;
                    }
                case 21:
                    if (!keyEvent.hasNoModifiers()) {
                        if (keyEvent.hasModifiers(2)) {
                            if (!n() && !k(33)) {
                                o = false;
                                break;
                            }
                            o = true;
                            break;
                        }
                    }
                    o = n();
                    if (!o) {
                        i3 = i2;
                        while (true) {
                            i2 = i3 - 1;
                            if (i3 > 0 && l(33)) {
                                o = true;
                                i3 = i2;
                            }
                        }
                    }
                    break;
                case 22:
                    if (!keyEvent.hasNoModifiers()) {
                        if (keyEvent.hasModifiers(2)) {
                            if (!n() && !k(130)) {
                                o = false;
                                break;
                            }
                            o = true;
                            break;
                        }
                    }
                    o = n();
                    if (!o) {
                        i3 = i2;
                        while (true) {
                            i2 = i3 - 1;
                            if (i3 > 0 && l(130)) {
                                o = true;
                                i3 = i2;
                            }
                        }
                    }
                    break;
                case 23:
                case 66:
                    if (keyEvent.hasNoModifiers()) {
                        o = n();
                        if (!o && keyEvent.getRepeatCount() == 0 && getChildCount() > 0) {
                            i();
                            o = true;
                            break;
                        }
                    }
                case 62:
                    if (keyEvent.hasNoModifiers()) {
                        if (!n()) {
                            break;
                        }
                    } else if (keyEvent.hasModifiers(1) && !n() && j(33)) {
                    }
                    o = true;
                    break;
                case 92:
                    if (!keyEvent.hasNoModifiers()) {
                        if (keyEvent.hasModifiers(2)) {
                            if (!n() && !k(33)) {
                                o = false;
                                break;
                            }
                            o = true;
                            break;
                        }
                    } else if (!n() && !j(33)) {
                        o = false;
                        break;
                    } else {
                        o = true;
                        break;
                    }
                    break;
                case 93:
                    if (!keyEvent.hasNoModifiers()) {
                        if (keyEvent.hasModifiers(2)) {
                            if (!n() && !k(130)) {
                                o = false;
                                break;
                            }
                            o = true;
                            break;
                        }
                    } else if (!n() && !j(130)) {
                        o = false;
                        break;
                    } else {
                        o = true;
                        break;
                    }
                    break;
                case 122:
                    if (keyEvent.hasNoModifiers()) {
                        if (!n() && !k(33)) {
                            o = false;
                            break;
                        }
                        o = true;
                        break;
                    }
                    break;
                case 123:
                    if (keyEvent.hasNoModifiers()) {
                        if (!n() && !k(130)) {
                            o = false;
                            break;
                        }
                        o = true;
                        break;
                    }
                    break;
            }
        }
        o = false;
        if (o) {
            return true;
        }
        switch (action) {
            case cm.HListView_android_entries /*0*/:
                return super.onKeyDown(i, keyEvent);
            case cm.HListView_android_divider /*1*/:
                return super.onKeyUp(i, keyEvent);
            case cm.HListView_hlv_dividerWidth /*2*/:
                return super.onKeyMultiple(i, i2, keyEvent);
            default:
                return false;
        }
    }

    private boolean a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        boolean z = (parent instanceof ViewGroup) && a((View) parent, view2);
        return z;
    }

    private int b(int i, int i2, int i3) {
        return i3 != this.an + -1 ? i - i2 : i;
    }

    private View b(View view, int i) {
        int i2 = i - 1;
        View a = a(i2, this.P);
        a(a, i2, view.getLeft() - this.au, false, this.u.top, false, this.P[0]);
        return a;
    }

    private void b(View view, int i, int i2) {
        int width = view.getWidth();
        d(view);
        if (view.getMeasuredWidth() != width) {
            e(view);
            int measuredWidth = view.getMeasuredWidth() - width;
            for (width = i + 1; width < i2; width++) {
                getChildAt(width).offsetLeftAndRight(measuredWidth);
            }
        }
    }

    private int c(int i, int i2, int i3) {
        return i3 > 0 ? i + i2 : i;
    }

    private View c(View view, int i) {
        int i2 = i + 1;
        View a = a(i2, this.P);
        a(a, i2, this.au + view.getRight(), true, this.u.top, false, this.P[0]);
        return a;
    }

    private boolean c(View view) {
        int i;
        ArrayList arrayList = this.ay;
        int size = arrayList.size();
        for (i = 0; i < size; i++) {
            if (view == ((ap) arrayList.get(i)).a) {
                return true;
            }
        }
        arrayList = this.az;
        size = arrayList.size();
        for (i = 0; i < size; i++) {
            if (view == ((ap) arrayList.get(i)).a) {
                return true;
            }
        }
        return false;
    }

    private void d(View view) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-2, -1);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.v, this.u.top + this.u.bottom, layoutParams.height);
        int i = layoutParams.width;
        view.measure(i > 0 ? MeasureSpec.makeMeasureSpec(i, 1073741824) : MeasureSpec.makeMeasureSpec(0, 0), childMeasureSpec);
    }

    private void e(View view) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i = this.u.top;
        measuredHeight += i;
        int left = view.getLeft();
        view.layout(left, i, measuredWidth + left, measuredHeight);
    }

    private int f(View view) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (a(view, getChildAt(i))) {
                return i + this.V;
            }
        }
        throw new IllegalArgumentException("newFocus is not a child of any of the children of the list!");
    }

    private int g(View view) {
        view.getDrawingRect(this.aG);
        offsetDescendantRectToMyCoords(view, this.aG);
        int right = (getRight() - getLeft()) - this.u.right;
        return this.aG.right < this.u.left ? this.u.left - this.aG.right : this.aG.left > right ? this.aG.left - right : 0;
    }

    private View g(int i, int i2) {
        View view = null;
        int right = getRight() - getLeft();
        int i3 = i2;
        int i4 = i;
        while (i3 < right && i4 < this.an) {
            boolean z = i4 == this.al;
            View a = a(i4, i3, true, this.u.top, z);
            i3 = a.getRight() + this.au;
            if (!z) {
                a = view;
            }
            i4++;
            view = a;
        }
        e(this.V, (this.V + getChildCount()) - 1);
        return view;
    }

    private int getArrowScrollPreviewLength() {
        return Math.max(2, getHorizontalFadingEdgeLength());
    }

    private View h(int i, int i2) {
        View view = null;
        int i3 = i2;
        int i4 = i;
        while (i3 > 0 && i4 >= 0) {
            boolean z = i4 == this.al;
            View a = a(i4, i3, false, this.u.top, z);
            i3 = a.getLeft() - this.au;
            if (!z) {
                a = view;
            }
            i4--;
            view = a;
        }
        this.V = i4 + 1;
        e(this.V, (this.V + getChildCount()) - 1);
        return view;
    }

    private View i(int i) {
        this.V = Math.min(this.V, this.al);
        this.V = Math.min(this.V, this.an - 1);
        if (this.V < 0) {
            this.V = 0;
        }
        return g(this.V, i);
    }

    private View i(int i, int i2) {
        int i3 = i2 - i;
        int m = m();
        View a = a(m, i, true, this.u.top, true);
        this.V = m;
        int measuredWidth = a.getMeasuredWidth();
        if (measuredWidth <= i3) {
            a.offsetLeftAndRight((i3 - measuredWidth) / 2);
        }
        a(a, m);
        if (this.K) {
            n(getChildCount());
        } else {
            m(getChildCount());
        }
        return a;
    }

    private View j(int i, int i2) {
        View g;
        View h;
        boolean z = i == this.al;
        View a = a(i, i2, true, this.u.top, z);
        this.V = i;
        int i3 = this.au;
        if (this.K) {
            g = g(i + 1, a.getRight() + i3);
            y();
            h = h(i - 1, a.getLeft() - i3);
            i3 = getChildCount();
            if (i3 > 0) {
                n(i3);
            }
        } else {
            h = h(i - 1, a.getLeft() - i3);
            y();
            g = g(i + 1, i3 + a.getRight());
            i3 = getChildCount();
            if (i3 > 0) {
                m(i3);
            }
        }
        return z ? a : h != null ? h : g;
    }

    private int k(int i, int i2) {
        int width = getWidth() - this.u.right;
        int i3 = this.u.left;
        int childCount = getChildCount();
        int i4;
        if (i == 130) {
            i4 = childCount - 1;
            if (i2 != -1) {
                i4 = i2 - this.V;
            }
            i3 = this.V + i4;
            View childAt = getChildAt(i4);
            i4 = i3 < this.an + -1 ? width - getArrowScrollPreviewLength() : width;
            if (childAt.getRight() <= i4) {
                return 0;
            }
            if (i2 != -1 && i4 - childAt.getLeft() >= getMaxScrollAmount()) {
                return 0;
            }
            i4 = childAt.getRight() - i4;
            if (this.V + childCount == this.an) {
                i4 = Math.min(i4, getChildAt(childCount - 1).getRight() - width);
            }
            return Math.min(i4, getMaxScrollAmount());
        }
        i4 = i2 != -1 ? i2 - this.V : 0;
        width = this.V + i4;
        View childAt2 = getChildAt(i4);
        i4 = width > 0 ? getArrowScrollPreviewLength() + i3 : i3;
        if (childAt2.getLeft() >= i4) {
            return 0;
        }
        if (i2 != -1 && childAt2.getRight() - i4 >= getMaxScrollAmount()) {
            return 0;
        }
        i4 -= childAt2.getLeft();
        if (this.V == 0) {
            i4 = Math.min(i4, i3 - getChildAt(0).getLeft());
        }
        return Math.min(i4, getMaxScrollAmount());
    }

    private void m(int i) {
        if ((this.V + i) - 1 == this.an - 1 && i > 0) {
            int right = ((getRight() - getLeft()) - this.u.right) - getChildAt(i - 1).getRight();
            View childAt = getChildAt(0);
            int left = childAt.getLeft();
            if (right <= 0) {
                return;
            }
            if (this.V > 0 || left < this.u.top) {
                if (this.V == 0) {
                    right = Math.min(right, this.u.top - left);
                }
                e(right);
                if (this.V > 0) {
                    h(this.V - 1, childAt.getLeft() - this.au);
                    y();
                }
            }
        }
    }

    private void n(int i) {
        if (this.V == 0 && i > 0) {
            int right = (getRight() - getLeft()) - this.u.right;
            int left = getChildAt(0).getLeft() - this.u.left;
            View childAt = getChildAt(i - 1);
            int right2 = childAt.getRight();
            int i2 = (this.V + i) - 1;
            if (left <= 0) {
                return;
            }
            if (i2 < this.an - 1 || right2 > right) {
                if (i2 == this.an - 1) {
                    left = Math.min(left, right2 - right);
                }
                e(-left);
                if (i2 < this.an - 1) {
                    g(i2 + 1, childAt.getRight() + this.au);
                    y();
                }
            } else if (i2 == this.an - 1) {
                y();
            }
        }
    }

    private boolean o(int i) {
        if (i == 33 || i == 130) {
            int childCount = getChildCount();
            if (this.aF && childCount > 0 && this.al != -1) {
                View selectedView = getSelectedView();
                if (selectedView != null && selectedView.hasFocus() && (selectedView instanceof ViewGroup)) {
                    View findFocus = selectedView.findFocus();
                    selectedView = FocusFinder.getInstance().findNextFocus((ViewGroup) selectedView, findFocus, i);
                    if (selectedView != null) {
                        findFocus.getFocusedRect(this.aG);
                        offsetDescendantRectToMyCoords(findFocus, this.aG);
                        offsetRectIntoDescendantCoords(selectedView, this.aG);
                        if (selectedView.requestFocus(i, this.aG)) {
                            return true;
                        }
                    }
                    selectedView = FocusFinder.getInstance().findNextFocus((ViewGroup) getRootView(), findFocus, i);
                    if (selectedView != null) {
                        return a(selectedView, (View) this);
                    }
                }
            }
            return false;
        }
        throw new IllegalArgumentException("direction must be one of {View.FOCUS_UP, View.FOCUS_DOWN}");
    }

    private boolean p(int i) {
        if (getChildCount() <= 0) {
            return false;
        }
        View selectedView;
        int i2;
        View findFocus;
        View selectedView2 = getSelectedView();
        int i3 = this.al;
        int q = q(i);
        int k = k(i, q);
        ao r = this.aF ? r(i) : null;
        if (r != null) {
            q = r.a();
            k = r.b();
        }
        boolean z = r != null;
        if (q != -1) {
            a(selectedView2, i, q, r != null);
            setSelectedPositionInt(q);
            setNextSelectedPositionInt(q);
            selectedView = getSelectedView();
            if (this.aF && r == null) {
                View focusedChild = getFocusedChild();
                if (focusedChild != null) {
                    focusedChild.clearFocus();
                }
            }
            u();
            z = true;
            i2 = q;
        } else {
            int i4 = i3;
            selectedView = selectedView2;
            i2 = i4;
        }
        if (k > 0) {
            s(i == 33 ? k : -k);
            z = true;
        }
        if (this.aF && r == null && selectedView != null && selectedView.hasFocus()) {
            findFocus = selectedView.findFocus();
            if (!a(findFocus, (View) this) || g(findFocus) > 0) {
                findFocus.clearFocus();
            }
        }
        if (q != -1 || selectedView == null || a(selectedView, (View) this)) {
            findFocus = selectedView;
        } else {
            l();
            this.M = -1;
            findFocus = null;
        }
        if (!z) {
            return false;
        }
        if (findFocus != null) {
            a(i2, findFocus);
            this.J = findFocus.getLeft();
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        b();
        return true;
    }

    private int q(int i) {
        int i2 = this.V;
        int i3;
        int lastVisiblePosition;
        if (i == 130) {
            i3 = this.al != -1 ? this.al + 1 : i2;
            if (i3 >= this.j.getCount()) {
                return -1;
            }
            if (i3 < i2) {
                i3 = i2;
            }
            lastVisiblePosition = getLastVisiblePosition();
            ListAdapter adapter = getAdapter();
            while (i3 <= lastVisiblePosition) {
                if (adapter.isEnabled(i3) && getChildAt(i3 - i2).getVisibility() == 0) {
                    return i3;
                }
                i3++;
            }
        } else {
            i3 = (getChildCount() + i2) - 1;
            lastVisiblePosition = this.al != -1 ? this.al - 1 : (getChildCount() + i2) - 1;
            if (lastVisiblePosition < 0 || lastVisiblePosition >= this.j.getCount()) {
                return -1;
            }
            if (lastVisiblePosition <= i3) {
                i3 = lastVisiblePosition;
            }
            ListAdapter adapter2 = getAdapter();
            while (i3 >= i2) {
                if (adapter2.isEnabled(i3) && getChildAt(i3 - i2).getVisibility() == 0) {
                    return i3;
                }
                i3--;
            }
        }
        return -1;
    }

    private ao r(int i) {
        View findNextFocusFromRect;
        int i2 = 1;
        View selectedView = getSelectedView();
        if (selectedView == null || !selectedView.hasFocus()) {
            if (i == 130) {
                if (this.V <= 0) {
                    i2 = 0;
                }
                i2 = (i2 != 0 ? getArrowScrollPreviewLength() : 0) + this.u.left;
                if (selectedView != null && selectedView.getLeft() > i2) {
                    i2 = selectedView.getLeft();
                }
                this.aG.set(i2, 0, i2, 0);
            } else {
                if ((this.V + getChildCount()) - 1 >= this.an) {
                    i2 = 0;
                }
                i2 = (getWidth() - this.u.right) - (i2 != 0 ? getArrowScrollPreviewLength() : 0);
                if (selectedView != null && selectedView.getRight() < i2) {
                    i2 = selectedView.getRight();
                }
                this.aG.set(i2, 0, i2, 0);
            }
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(this, this.aG, i);
        } else {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocus(this, selectedView.findFocus(), i);
        }
        if (findNextFocusFromRect != null) {
            int q;
            int f = f(findNextFocusFromRect);
            if (!(this.al == -1 || f == this.al)) {
                q = q(i);
                if (q != -1 && ((i == 130 && q < f) || (i == 33 && q > f))) {
                    return null;
                }
            }
            q = a(i, findNextFocusFromRect, f);
            int maxScrollAmount = getMaxScrollAmount();
            if (q < maxScrollAmount) {
                findNextFocusFromRect.requestFocus(i);
                this.aI.a(f, q);
                return this.aI;
            } else if (g(findNextFocusFromRect) < maxScrollAmount) {
                findNextFocusFromRect.requestFocus(i);
                this.aI.a(f, maxScrollAmount);
                return this.aI;
            }
        }
        return null;
    }

    private void s(int i) {
        e(i);
        int width = getWidth() - this.u.right;
        int i2 = this.u.left;
        p pVar = this.p;
        int childCount;
        View childAt;
        View childAt2;
        if (i < 0) {
            childCount = getChildCount();
            childAt = getChildAt(childCount - 1);
            while (childAt.getRight() < width) {
                int i3 = (this.V + childCount) - 1;
                if (i3 >= this.an - 1) {
                    break;
                }
                childAt = c(childAt, i3);
                childCount++;
            }
            if (childAt.getBottom() < width) {
                e(width - childAt.getRight());
            }
            childAt2 = getChildAt(0);
            while (childAt2.getRight() < i2) {
                if (pVar.b(((i) childAt2.getLayoutParams()).a)) {
                    detachViewFromParent(childAt2);
                    pVar.a(childAt2, this.V);
                } else {
                    removeViewInLayout(childAt2);
                }
                childAt = getChildAt(0);
                this.V++;
                childAt2 = childAt;
            }
            return;
        }
        childAt = getChildAt(0);
        while (childAt.getLeft() > i2 && this.V > 0) {
            childAt = b(childAt, this.V);
            this.V--;
        }
        if (childAt.getLeft() > i2) {
            e(i2 - childAt.getLeft());
        }
        childCount = getChildCount() - 1;
        i2 = childCount;
        childAt2 = getChildAt(childCount);
        while (childAt2.getLeft() > width) {
            if (pVar.b(((i) childAt2.getLayoutParams()).a)) {
                detachViewFromParent(childAt2);
                pVar.a(childAt2, this.V + i2);
            } else {
                removeViewInLayout(childAt2);
            }
            childCount = i2 - 1;
            i2 = childCount;
            childAt2 = getChildAt(childCount);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void y() {
        int i = 0;
        int childCount = getChildCount();
        if (childCount > 0) {
            int right;
            if (this.K) {
                right = getChildAt(childCount - 1).getRight() - (getWidth() - this.u.right);
                if (childCount + this.V < this.an) {
                    right += this.au;
                }
            } else {
                right = getChildAt(0).getLeft() - this.u.left;
                if (this.V != 0) {
                    right -= this.au;
                }
            }
            if (i != 0) {
                e(-i);
            }
        }
    }

    private boolean z() {
        return this.V > 0 || getChildAt(0).getLeft() > getScrollX() + this.u.left;
    }

    final int a(int i, int i2, int i3, int i4, int i5) {
        int i6 = 0;
        ListAdapter listAdapter = this.j;
        if (listAdapter == null) {
            return this.u.left + this.u.right;
        }
        int i7 = this.u.left + this.u.right;
        int i8 = (this.au <= 0 || this.at == null) ? 0 : this.au;
        if (i3 == -1) {
            i3 = listAdapter.getCount() - 1;
        }
        p pVar = this.p;
        boolean x = x();
        boolean[] zArr = this.P;
        while (i2 <= i3) {
            View a = a(i2, zArr);
            a(a, i2, i);
            int i9 = i2 > 0 ? i7 + i8 : i7;
            if (x && pVar.b(((i) a.getLayoutParams()).a)) {
                pVar.a(a, -1);
            }
            i7 = a.getMeasuredWidth() + i9;
            if (i7 >= i4) {
                return (i5 < 0 || i2 <= i5 || i6 <= 0 || i7 == i4) ? i4 : i6;
            } else {
                if (i5 >= 0 && i2 >= i5) {
                    i6 = i7;
                }
                i2++;
            }
        }
        return i7;
    }

    void a(Canvas canvas, Rect rect, int i) {
        Drawable drawable = this.at;
        drawable.setBounds(rect);
        drawable.draw(canvas);
    }

    void a(Canvas canvas, Drawable drawable, Rect rect) {
        int minimumWidth = drawable.getMinimumWidth();
        canvas.save();
        canvas.clipRect(rect);
        if (rect.right - rect.left < minimumWidth) {
            rect.left = rect.right - minimumWidth;
        }
        drawable.setBounds(rect);
        drawable.draw(canvas);
        canvas.restore();
    }

    public void a(View view, Object obj, boolean z) {
        if (this.j == null || (this.j instanceof ar)) {
            ap apVar = new ap();
            apVar.a = view;
            apVar.b = obj;
            apVar.c = z;
            this.ay.add(apVar);
            if (this.j != null && this.i != null) {
                this.i.onChanged();
                return;
            }
            return;
        }
        throw new IllegalStateException("Cannot add header view to list -- setAdapter has already been called.");
    }

    protected void a(boolean z) {
        int i = 0;
        int childCount = getChildCount();
        if (z) {
            if (childCount > 0) {
                i = getChildAt(childCount - 1).getRight() + this.au;
            }
            g(childCount + this.V, i);
            m(getChildCount());
            return;
        }
        h(this.V - 1, childCount > 0 ? getChildAt(0).getLeft() - this.au : getWidth() - 0);
        n(getChildCount());
    }

    final int[] a(int i, int i2, int i3, int i4, int i5, int i6) {
        ListAdapter listAdapter = this.j;
        if (listAdapter == null) {
            return new int[]{this.u.left + this.u.right, this.u.top + this.u.bottom};
        }
        int i7 = this.u.left + this.u.right;
        int i8 = this.u.top + this.u.bottom;
        int i9 = (this.au <= 0 || this.at == null) ? 0 : this.au;
        if (i3 == -1) {
            i3 = listAdapter.getCount() - 1;
        }
        p pVar = this.p;
        boolean x = x();
        boolean[] zArr = this.P;
        int i10 = 0;
        int i11 = 0;
        while (i2 <= i3) {
            View a = a(i2, zArr);
            a(a, i2, i);
            if (x && pVar.b(((i) a.getLayoutParams()).a)) {
                pVar.a(a, -1);
            }
            i10 = Math.max(i10, a.getMeasuredWidth() + i9);
            i2++;
            i11 = Math.max(i11, a.getMeasuredHeight());
        }
        i11 += i8;
        return new int[]{Math.min(i10 + i7, i4), Math.min(i11, i5)};
    }

    protected int b(int i, boolean z) {
        ListAdapter listAdapter = this.j;
        if (listAdapter == null || isInTouchMode()) {
            return -1;
        }
        int count = listAdapter.getCount();
        if (this.aE) {
            return (i < 0 || i >= count) ? -1 : i;
        } else {
            if (z) {
                i = Math.max(0, i);
                while (i < count && !listAdapter.isEnabled(i)) {
                    i++;
                }
            } else {
                i = Math.min(i, count - 1);
                while (i >= 0 && !listAdapter.isEnabled(i)) {
                    i--;
                }
            }
            return (i < 0 || i >= count) ? -1 : i;
        }
    }

    void b(Canvas canvas, Drawable drawable, Rect rect) {
        int minimumWidth = drawable.getMinimumWidth();
        canvas.save();
        canvas.clipRect(rect);
        if (rect.right - rect.left < minimumWidth) {
            rect.right = minimumWidth + rect.left;
        }
        drawable.setBounds(rect);
        drawable.draw(canvas);
        canvas.restore();
    }

    public void b(View view) {
        a(view, null, true);
    }

    public void c(int i) {
        super.c(i);
    }

    protected boolean canAnimate() {
        return super.canAnimate() && this.an > 0;
    }

    protected void d() {
        a(this.ay);
        a(this.az);
        super.d();
        this.h = 0;
    }

    public void d(int i) {
        super.d(i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void dispatchDraw(Canvas canvas) {
        if (this.y) {
            this.z = true;
        }
        int i = this.au;
        Drawable drawable = this.aw;
        Drawable drawable2 = this.ax;
        Object obj = drawable != null ? 1 : null;
        Object obj2 = drawable2 != null ? 1 : null;
        Object obj3 = (i <= 0 || this.at == null) ? null : 1;
        if (!(obj3 == null && obj == null && obj2 == null)) {
            Rect rect = this.aG;
            rect.top = getPaddingTop();
            rect.bottom = (getBottom() - getTop()) - getPaddingBottom();
            int childCount = getChildCount();
            int size = this.ay.size();
            int i2 = this.an;
            int size2 = (i2 - this.az.size()) - 1;
            boolean z = this.aC;
            boolean z2 = this.aD;
            int i3 = this.V;
            boolean z3 = this.aE;
            ListAdapter listAdapter = this.j;
            Object obj4 = (!isOpaque() || super.isOpaque()) ? null : 1;
            if (obj4 != null && this.aH == null && this.aA) {
                this.aH = new Paint();
                this.aH.setColor(getCacheColorHint());
            }
            Paint paint = this.aH;
            int scrollX = getScrollX() + ((getRight() - getLeft()) - 0);
            int i4;
            if (this.K) {
                i2 = getScrollX();
                if (childCount > 0 && obj != null) {
                    rect.left = i2;
                    rect.right = getChildAt(0).getLeft();
                    a(canvas, drawable, rect);
                }
                i4 = obj != null ? 1 : 0;
                while (i4 < childCount) {
                    if ((z || i3 + i4 >= size) && (z2 || i3 + i4 < size2)) {
                        int left = getChildAt(i4).getLeft();
                        if (left > 0) {
                            if (!z3) {
                                if (listAdapter.isEnabled(i3 + i4)) {
                                    if (i4 != childCount - 1) {
                                    }
                                }
                                if (obj4 != null) {
                                    rect.left = left - i;
                                    rect.right = left;
                                    canvas.drawRect(rect, paint);
                                }
                            }
                            rect.left = left - i;
                            rect.right = left;
                            a(canvas, rect, i4 - 1);
                        }
                    }
                    i4++;
                }
                if (childCount > 0 && i2 > 0) {
                    if (obj2 != null) {
                        i4 = getRight();
                        rect.left = i4;
                        rect.right = i4 + i2;
                        b(canvas, drawable2, rect);
                    } else if (obj3 != null) {
                        rect.left = scrollX;
                        rect.right = scrollX + i;
                        a(canvas, rect, -1);
                    }
                }
            } else {
                i4 = getScrollX();
                if (childCount > 0 && i4 < 0) {
                    if (obj != null) {
                        rect.right = 0;
                        rect.left = i4;
                        a(canvas, drawable, rect);
                    } else if (obj3 != null) {
                        rect.right = 0;
                        rect.left = -i;
                        a(canvas, rect, -1);
                    }
                }
                i4 = 0;
                int i5 = 0;
                while (i5 < childCount) {
                    if ((z || i3 + i5 >= size) && (z2 || i3 + i5 < size2)) {
                        i4 = getChildAt(i5).getRight();
                        if (obj3 != null && i4 < scrollX && (obj2 == null || i5 != childCount - 1)) {
                            if (!z3) {
                                if (listAdapter.isEnabled(i3 + i5)) {
                                    if (i5 != childCount - 1) {
                                    }
                                }
                                if (obj4 != null) {
                                    rect.left = i4;
                                    rect.right = i4 + i;
                                    canvas.drawRect(rect, paint);
                                }
                            }
                            rect.left = i4;
                            rect.right = i4 + i;
                            a(canvas, rect, i5);
                        }
                    }
                    i5++;
                }
                i5 = getRight() + getScrollX();
                if (obj2 != null && i3 + childCount == i2 && i5 > i4) {
                    rect.left = i4;
                    rect.right = i5;
                    b(canvas, drawable2, rect);
                }
            }
        }
        super.dispatchDraw(canvas);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        return (dispatchKeyEvent || getFocusedChild() == null || keyEvent.getAction() != 0) ? dispatchKeyEvent : onKeyDown(keyEvent.getKeyCode(), keyEvent);
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild = super.drawChild(canvas, view, j);
        if (this.z) {
            this.z = false;
        }
        return drawChild;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void e() {
        boolean z = this.as;
        if (!z) {
            this.as = true;
            try {
                super.e();
                invalidate();
                if (this.j == null) {
                    d();
                    b();
                    if (!z) {
                        this.as = false;
                        return;
                    }
                    return;
                }
                View view;
                int i;
                View childAt;
                int i2 = this.u.left;
                int right = (getRight() - getLeft()) - this.u.right;
                int childCount = getChildCount();
                int i3 = 0;
                View view2 = null;
                View view3 = null;
                View view4 = null;
                switch (this.h) {
                    case cm.HListView_android_divider /*1*/:
                    case cm.HListView_hlv_headerDividersEnabled /*3*/:
                    case cm.HListView_hlv_footerDividersEnabled /*4*/:
                    case cm.HListView_hlv_overScrollHeader /*5*/:
                        view = null;
                    case cm.HListView_hlv_dividerWidth /*2*/:
                        i = this.aj - this.V;
                        if (i < 0 || i >= childCount) {
                            view = null;
                        } else {
                            view3 = getChildAt(i);
                            view = null;
                        }
                        break;
                    default:
                        int i4 = this.al - this.V;
                        if (i4 >= 0 && i4 < childCount) {
                            view2 = getChildAt(i4);
                        }
                        childAt = getChildAt(0);
                        if (this.aj >= 0) {
                            i3 = this.aj - this.al;
                        }
                        view3 = getChildAt(i4 + i3);
                        view = childAt;
                }
                boolean z2 = this.ai;
                if (z2) {
                    q();
                }
                if (this.an == 0) {
                    d();
                    b();
                    if (!z) {
                        this.as = false;
                    }
                } else if (this.an != this.j.getCount()) {
                    throw new IllegalStateException("The content of the adapter has changed but ListView did not receive a notification. Make sure the content of your adapter is not modified from a background thread, but only from the UI thread. [in ListView(" + getId() + ", " + getClass() + ") with Adapter(" + this.j.getClass() + ")]");
                } else {
                    setSelectedPositionInt(this.aj);
                    int i5 = this.V;
                    p pVar = this.p;
                    childAt = null;
                    if (z2) {
                        for (i = 0; i < childCount; i++) {
                            pVar.a(getChildAt(i), i5 + i);
                        }
                    } else {
                        pVar.a(childCount, i5);
                    }
                    View focusedChild = getFocusedChild();
                    if (focusedChild != null) {
                        if (!z2 || c(focusedChild)) {
                            view4 = findFocus();
                            if (view4 != null) {
                                view4.onStartTemporaryDetach();
                            }
                            childAt = focusedChild;
                        }
                        requestFocus();
                        focusedChild = view4;
                        view4 = childAt;
                    } else {
                        focusedChild = null;
                        view4 = null;
                    }
                    detachAllViewsFromParent();
                    pVar.d();
                    switch (this.h) {
                        case cm.HListView_android_divider /*1*/:
                            this.V = 0;
                            childAt = i(i2);
                            y();
                            view2 = childAt;
                            break;
                        case cm.HListView_hlv_dividerWidth /*2*/:
                            if (view3 == null) {
                                view2 = i(i2, right);
                                break;
                            } else {
                                view2 = a(view3.getLeft(), i2, right);
                                break;
                            }
                        case cm.HListView_hlv_headerDividersEnabled /*3*/:
                            childAt = h(this.an - 1, right);
                            y();
                            view2 = childAt;
                            break;
                        case cm.HListView_hlv_footerDividersEnabled /*4*/:
                            view2 = j(m(), this.W);
                            break;
                        case cm.HListView_hlv_overScrollHeader /*5*/:
                            view2 = j(this.Z, this.W);
                            break;
                        case cm.HListView_hlv_overScrollFooter /*6*/:
                            view2 = a(view2, view3, i3, i2, right);
                            break;
                        default:
                            if (childCount != 0) {
                                int i6;
                                if (this.al < 0 || this.al >= this.an) {
                                    if (this.V >= this.an) {
                                        view2 = j(0, i2);
                                        break;
                                    }
                                    i6 = this.V;
                                    if (view != null) {
                                        i2 = view.getLeft();
                                    }
                                    view2 = j(i6, i2);
                                    break;
                                }
                                i6 = this.al;
                                if (view2 != null) {
                                    i2 = view2.getLeft();
                                }
                                view2 = j(i6, i2);
                                break;
                            } else if (!this.K) {
                                setSelectedPositionInt(b(0, true));
                                view2 = i(i2);
                                break;
                            } else {
                                setSelectedPositionInt(b(this.an - 1, false));
                                view2 = h(this.an - 1, right);
                                break;
                            }
                            break;
                    }
                    pVar.e();
                    if (view2 != null) {
                        if (this.aF && hasFocus() && !view2.hasFocus()) {
                            Object obj = ((view2 == view4 && focusedChild != null && focusedChild.requestFocus()) || view2.requestFocus()) ? 1 : null;
                            if (obj == null) {
                                childAt = getFocusedChild();
                                if (childAt != null) {
                                    childAt.clearFocus();
                                }
                                a(-1, view2);
                            } else {
                                view2.setSelected(false);
                                this.o.setEmpty();
                            }
                        } else {
                            a(-1, view2);
                        }
                        this.J = view2.getLeft();
                    } else {
                        if (this.F <= 0 || this.F >= 3) {
                            this.J = 0;
                            this.o.setEmpty();
                        } else {
                            childAt = getChildAt(this.A - this.V);
                            if (childAt != null) {
                                a(this.A, childAt);
                            }
                        }
                        if (hasFocus() && focusedChild != null) {
                            focusedChild.requestFocus();
                        }
                    }
                    if (!(focusedChild == null || focusedChild.getWindowToken() == null)) {
                        focusedChild.onFinishTemporaryDetach();
                    }
                    this.h = 0;
                    this.ai = false;
                    if (this.O != null) {
                        post(this.O);
                        this.O = null;
                    }
                    this.ac = false;
                    setNextSelectedPositionInt(this.al);
                    f();
                    if (this.an > 0) {
                        u();
                    }
                    b();
                    if (!z) {
                        this.as = false;
                    }
                }
            } catch (Throwable th) {
                if (!z) {
                    this.as = false;
                }
            }
        }
    }

    protected int f(int i) {
        int childCount = getChildCount();
        if (childCount > 0) {
            int i2;
            if (this.K) {
                for (i2 = childCount - 1; i2 >= 0; i2--) {
                    if (i >= getChildAt(i2).getLeft()) {
                        return i2 + this.V;
                    }
                }
            } else {
                for (i2 = 0; i2 < childCount; i2++) {
                    if (i <= getChildAt(i2).getRight()) {
                        return i2 + this.V;
                    }
                }
            }
        }
        return -1;
    }

    public void f(int i, int i2) {
        if (this.j != null) {
            if (isInTouchMode()) {
                this.M = i;
            } else {
                i = b(i, true);
                if (i >= 0) {
                    setNextSelectedPositionInt(i);
                }
            }
            if (i >= 0) {
                this.h = 4;
                this.W = this.u.left + i2;
                if (this.ac) {
                    this.Z = i;
                    this.aa = this.j.getItemId(i);
                }
                if (this.I != null) {
                    this.I.a();
                }
                requestLayout();
            }
        }
    }

    public ListAdapter getAdapter() {
        return this.j;
    }

    @Deprecated
    public long[] getCheckItemIds() {
        if (this.j != null && this.j.hasStableIds()) {
            return getCheckedItemIds();
        }
        if (this.b == 0 || this.f == null || this.j == null) {
            return new long[0];
        }
        n nVar = this.f;
        int b = nVar.b();
        Object obj = new long[b];
        ListAdapter listAdapter = this.j;
        int i = 0;
        int i2 = 0;
        while (i < b) {
            int i3;
            if (((Boolean) nVar.c(i)).booleanValue()) {
                i3 = i2 + 1;
                obj[i2] = listAdapter.getItemId(nVar.b(i));
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        if (i2 == b) {
            return obj;
        }
        Object obj2 = new long[i2];
        System.arraycopy(obj, 0, obj2, 0, i2);
        return obj2;
    }

    public Drawable getDivider() {
        return this.at;
    }

    public int getDividerWidth() {
        return this.au;
    }

    public int getFooterViewsCount() {
        return this.az.size();
    }

    public int getHeaderViewsCount() {
        return this.ay.size();
    }

    public boolean getItemsCanFocus() {
        return this.aF;
    }

    public int getMaxScrollAmount() {
        return (int) (0.33f * ((float) (getRight() - getLeft())));
    }

    public Drawable getOverscrollFooter() {
        return this.ax;
    }

    public Drawable getOverscrollHeader() {
        return this.aw;
    }

    public boolean isOpaque() {
        boolean z = (this.z && this.aA && this.aB) || super.isOpaque();
        if (z) {
            int paddingLeft = this.u != null ? this.u.left : getPaddingLeft();
            View childAt = getChildAt(0);
            if (childAt == null || childAt.getLeft() > paddingLeft) {
                return false;
            }
            paddingLeft = getWidth() - (this.u != null ? this.u.right : getPaddingRight());
            childAt = getChildAt(getChildCount() - 1);
            if (childAt == null || childAt.getRight() < paddingLeft) {
                return false;
            }
        }
        return z;
    }

    boolean j(int i) {
        int max;
        boolean z;
        if (i == 33) {
            max = Math.max(0, (this.al - getChildCount()) - 1);
            z = false;
        } else if (i == 130) {
            max = Math.min(this.an - 1, (this.al + getChildCount()) - 1);
            z = true;
        } else {
            max = -1;
            z = false;
        }
        if (max >= 0) {
            max = b(max, z);
            if (max >= 0) {
                this.h = 4;
                this.W = getPaddingLeft() + getHorizontalFadingEdgeLength();
                if (z && max > this.an - getChildCount()) {
                    this.h = 3;
                }
                if (!z && max < getChildCount()) {
                    this.h = 1;
                }
                setSelectionInt(max);
                b();
                if (awakenScrollBars()) {
                    return true;
                }
                invalidate();
                return true;
            }
        }
        return false;
    }

    boolean k(int i) {
        boolean z = true;
        int b;
        if (i == 33) {
            if (this.al != 0) {
                b = b(0, true);
                if (b >= 0) {
                    this.h = 1;
                    setSelectionInt(b);
                    b();
                }
            }
            z = false;
        } else {
            if (i == 130 && this.al < this.an - 1) {
                b = b(this.an - 1, true);
                if (b >= 0) {
                    this.h = 3;
                    setSelectionInt(b);
                    b();
                }
            }
            z = false;
        }
        if (z && !awakenScrollBars()) {
            awakenScrollBars();
            invalidate();
        }
        return z;
    }

    boolean l(int i) {
        try {
            this.ae = true;
            boolean p = p(i);
            if (p) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
            }
            this.ae = false;
            return p;
        } catch (Throwable th) {
            this.ae = false;
        }
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                b(getChildAt(i));
            }
            removeAllViews();
        }
    }

    protected void onFocusChanged(boolean z, int i, Rect rect) {
        int i2 = 0;
        super.onFocusChanged(z, i, rect);
        ListAdapter listAdapter = this.j;
        int i3 = -1;
        if (!(listAdapter == null || !z || rect == null)) {
            rect.offset(getScrollX(), getScrollY());
            if (listAdapter.getCount() < getChildCount() + this.V) {
                this.h = 0;
                e();
            }
            Rect rect2 = this.aG;
            int i4 = Integer.MAX_VALUE;
            int childCount = getChildCount();
            int i5 = this.V;
            int i6 = 0;
            while (i6 < childCount) {
                int a;
                if (listAdapter.isEnabled(i5 + i6)) {
                    View childAt = getChildAt(i6);
                    childAt.getDrawingRect(rect2);
                    offsetDescendantRectToMyCoords(childAt, rect2);
                    a = AbsHListView.a(rect, rect2, i);
                    if (a < i4) {
                        i2 = i6;
                        i4 = a;
                        a = childAt.getLeft();
                    } else {
                        a = i2;
                        i2 = i3;
                    }
                } else {
                    a = i2;
                    i2 = i3;
                }
                i6++;
                i3 = i2;
                i2 = a;
            }
        }
        if (i3 >= 0) {
            f(this.V + i3, i2);
        } else {
            requestLayout();
        }
    }

    public void onGlobalLayout() {
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(HListView.class.getName());
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(HListView.class.getName());
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return a(i, 1, keyEvent);
    }

    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return a(i, i2, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return a(i, 1, keyEvent);
    }

    @TargetApi(11)
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        this.an = this.j == null ? 0 : this.j.getCount();
        if (this.an > 0 && (mode == 0 || mode2 == 0)) {
            View a = a(0, this.P);
            a(a, 0, i2);
            i3 = a.getMeasuredWidth();
            i4 = a.getMeasuredHeight();
            if (VERSION.SDK_INT >= 11) {
                i5 = combineMeasuredStates(0, a.getMeasuredState());
            }
            if (x() && this.p.b(((i) a.getLayoutParams()).a)) {
                this.p.a(a, -1);
            }
        }
        int i6 = i3;
        mode2 = mode2 == 0 ? (i4 + (this.u.top + this.u.bottom)) + getHorizontalScrollbarHeight() : (mode2 != Integer.MIN_VALUE || this.an <= 0 || this.av <= -1) ? VERSION.SDK_INT >= 11 ? size2 | (-16777216 & i5) : size2 : a(i2, this.av, this.av, size, size2, -1)[1];
        if (mode == 0) {
            size = ((this.u.left + this.u.right) + i6) + (getHorizontalFadingEdgeLength() * 2);
        }
        if (mode == Integer.MIN_VALUE) {
            size = a(i2, 0, -1, size, -1);
        }
        setMeasuredDimension(size, mode2);
        this.v = i2;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (getChildCount() > 0) {
            View focusedChild = getFocusedChild();
            if (focusedChild != null) {
                int indexOfChild = this.V + indexOfChild(focusedChild);
                int left = focusedChild.getLeft() - Math.max(0, focusedChild.getRight() - (i - getPaddingLeft()));
                if (this.aJ == null) {
                    this.aJ = new aq();
                }
                post(this.aJ.a(indexOfChild, left));
            }
        }
        super.onSizeChanged(i, i2, i3, i4);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        int i = rect.left;
        rect.offset(view.getLeft(), view.getTop());
        rect.offset(-view.getScrollX(), -view.getScrollY());
        int width = getWidth();
        int scrollX = getScrollX();
        int i2 = scrollX + width;
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        if (z() && (this.al > 0 || i > horizontalFadingEdgeLength)) {
            scrollX += horizontalFadingEdgeLength;
        }
        i = getChildAt(getChildCount() - 1).getRight();
        if (A() && (this.al < this.an - 1 || rect.right < i - horizontalFadingEdgeLength)) {
            i2 -= horizontalFadingEdgeLength;
        }
        if (rect.right > i2 && rect.left > scrollX) {
            i2 = Math.min(rect.width() > width ? (rect.left - scrollX) + 0 : (rect.right - i2) + 0, i - i2);
        } else if (rect.left >= scrollX || rect.right >= i2) {
            i2 = 0;
        } else {
            i2 = Math.max(rect.width() > width ? 0 - (i2 - rect.right) : 0 - (scrollX - rect.left), getChildAt(0).getLeft() - scrollX);
        }
        boolean z2 = i2 != 0;
        if (z2) {
            s(-i2);
            a(-1, view);
            this.J = view.getTop();
            invalidate();
        }
        return z2;
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (!(this.j == null || this.i == null)) {
            this.j.unregisterDataSetObserver(this.i);
        }
        d();
        this.p.b();
        if (this.ay.size() > 0 || this.az.size() > 0) {
            this.j = new ar(this.ay, this.az, listAdapter);
        } else {
            this.j = listAdapter;
        }
        this.aq = -1;
        this.ar = Long.MIN_VALUE;
        super.setAdapter(listAdapter);
        if (this.j != null) {
            this.aE = this.j.areAllItemsEnabled();
            this.ao = this.an;
            this.an = this.j.getCount();
            s();
            this.i = new c(this);
            this.j.registerDataSetObserver(this.i);
            this.p.a(this.j.getViewTypeCount());
            int b = this.K ? b(this.an - 1, false) : b(0, true);
            setSelectedPositionInt(b);
            setNextSelectedPositionInt(b);
            if (this.an == 0) {
                u();
            }
        } else {
            this.aE = true;
            s();
            u();
        }
        requestLayout();
    }

    public void setCacheColorHint(int i) {
        boolean z = (i >>> 24) == 255;
        this.aA = z;
        if (z) {
            if (this.aH == null) {
                this.aH = new Paint();
            }
            this.aH.setColor(i);
        }
        super.setCacheColorHint(i);
    }

    public void setDivider(Drawable drawable) {
        boolean z = false;
        if (drawable != null) {
            this.au = drawable.getIntrinsicWidth();
        } else {
            this.au = 0;
        }
        this.at = drawable;
        if (drawable == null || drawable.getOpacity() == -1) {
            z = true;
        }
        this.aB = z;
        requestLayout();
        invalidate();
    }

    public void setDividerWidth(int i) {
        this.au = i;
        requestLayout();
        invalidate();
    }

    public void setFooterDividersEnabled(boolean z) {
        this.aD = z;
        invalidate();
    }

    public void setHeaderDividersEnabled(boolean z) {
        this.aC = z;
        invalidate();
    }

    public void setItemsCanFocus(boolean z) {
        this.aF = z;
        if (!z) {
            setDescendantFocusability(393216);
        }
    }

    public void setOverscrollFooter(Drawable drawable) {
        this.ax = drawable;
        invalidate();
    }

    public void setOverscrollHeader(Drawable drawable) {
        this.aw = drawable;
        if (getScrollX() < 0) {
            invalidate();
        }
    }

    public void setSelection(int i) {
        f(i, 0);
    }

    public void setSelectionInt(int i) {
        Object obj = 1;
        setNextSelectedPositionInt(i);
        int i2 = this.al;
        if (i2 < 0 || !(i == i2 - 1 || i == i2 + 1)) {
            obj = null;
        }
        if (this.I != null) {
            this.I.a();
        }
        e();
        if (obj != null) {
            awakenScrollBars();
        }
    }

    @ExportedProperty(category = "list")
    protected boolean x() {
        return true;
    }
}
