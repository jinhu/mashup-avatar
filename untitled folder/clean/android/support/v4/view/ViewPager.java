package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p001b.C0028a;
import android.support.v4.widget.C0105f;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.google.android.apps.androidify.cm;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ViewPager extends ViewGroup {
    private static final int[] f231a;
    private static final br af;
    private static final Comparator f232c;
    private static final Interpolator f233d;
    private boolean f234A;
    private boolean f235B;
    private int f236C;
    private int f237D;
    private int f238E;
    private float f239F;
    private float f240G;
    private float f241H;
    private float f242I;
    private int f243J;
    private VelocityTracker f244K;
    private int f245L;
    private int f246M;
    private int f247N;
    private int f248O;
    private boolean f249P;
    private C0105f f250Q;
    private C0105f f251R;
    private boolean f252S;
    private boolean f253T;
    private boolean f254U;
    private int f255V;
    private bn f256W;
    private bn f257Z;
    private bm aa;
    private bo ab;
    private Method ac;
    private int ad;
    private ArrayList ae;
    private final Runnable ag;
    private int ah;
    private int f258b;
    private final ArrayList f259e;
    private final bj f260f;
    private final Rect f261g;
    private ae f262h;
    private int f263i;
    private int f264j;
    private Parcelable f265k;
    private ClassLoader f266l;
    private Scroller f267m;
    private bp f268n;
    private int f269o;
    private Drawable f270p;
    private int f271q;
    private int f272r;
    private float f273s;
    private float f274t;
    private int f275u;
    private int f276v;
    private boolean f277w;
    private boolean f278x;
    private boolean f279y;
    private int f280z;

    public class SavedState extends BaseSavedState {
        public static final Creator CREATOR;
        int f228a;
        Parcelable f229b;
        ClassLoader f230c;

        static {
            CREATOR = C0028a.m200a(new bq());
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            if (classLoader == null) {
                classLoader = getClass().getClassLoader();
            }
            this.f228a = parcel.readInt();
            this.f229b = parcel.readParcelable(classLoader);
            this.f230c = classLoader;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f228a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f228a);
            parcel.writeParcelable(this.f229b, i);
        }
    }

    static {
        f231a = new int[]{16842931};
        f232c = new bf();
        f233d = new bg();
        af = new br();
    }

    public ViewPager(Context context) {
        super(context);
        this.f259e = new ArrayList();
        this.f260f = new bj();
        this.f261g = new Rect();
        this.f264j = -1;
        this.f265k = null;
        this.f266l = null;
        this.f273s = -3.4028235E38f;
        this.f274t = Float.MAX_VALUE;
        this.f280z = 1;
        this.f243J = -1;
        this.f252S = true;
        this.f253T = false;
        this.ag = new bh(this);
        this.ah = 0;
        m295a();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f259e = new ArrayList();
        this.f260f = new bj();
        this.f261g = new Rect();
        this.f264j = -1;
        this.f265k = null;
        this.f266l = null;
        this.f273s = -3.4028235E38f;
        this.f274t = Float.MAX_VALUE;
        this.f280z = 1;
        this.f243J = -1;
        this.f252S = true;
        this.f253T = false;
        this.ag = new bh(this);
        this.ah = 0;
        m295a();
    }

    private int m272a(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.f247N || Math.abs(i2) <= this.f245L) {
            i = (int) ((i >= this.f263i ? 0.4f : 0.6f) + (((float) i) + f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.f259e.size() <= 0) {
            return i;
        }
        return Math.max(((bj) this.f259e.get(0)).f303b, Math.min(i, ((bj) this.f259e.get(this.f259e.size() - 1)).f303b));
    }

    private Rect m273a(Rect rect, View view) {
        Rect rect2 = rect == null ? new Rect() : rect;
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewPager parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect2;
    }

    private void m275a(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.f259e.isEmpty()) {
            bj b = m304b(this.f263i);
            int min = (int) ((b != null ? Math.min(b.f306e, this.f274t) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                m280a(false);
                scrollTo(min, getScrollY());
                return;
            }
            return;
        }
        int paddingLeft = (int) (((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3)) * (((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4))));
        scrollTo(paddingLeft, getScrollY());
        if (!this.f267m.isFinished()) {
            this.f267m.startScroll(paddingLeft, 0, (int) (m304b(this.f263i).f306e * ((float) i)), 0, this.f267m.getDuration() - this.f267m.timePassed());
        }
    }

    private void m276a(int i, boolean z, int i2, boolean z2) {
        int max;
        bj b = m304b(i);
        if (b != null) {
            max = (int) (Math.max(this.f273s, Math.min(b.f306e, this.f274t)) * ((float) getClientWidth()));
        } else {
            max = 0;
        }
        if (z) {
            m298a(max, 0, i2);
            if (z2 && this.f256W != null) {
                this.f256W.m643a(i);
            }
            if (z2 && this.f257Z != null) {
                this.f257Z.m643a(i);
                return;
            }
            return;
        }
        if (z2 && this.f256W != null) {
            this.f256W.m643a(i);
        }
        if (z2 && this.f257Z != null) {
            this.f257Z.m643a(i);
        }
        m280a(false);
        scrollTo(max, 0);
        m286d(max);
    }

    private void m278a(bj bjVar, int i, bj bjVar2) {
        float f;
        int i2;
        bj bjVar3;
        int i3;
        int a = this.f262h.m504a();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? ((float) this.f269o) / ((float) clientWidth) : 0.0f;
        if (bjVar2 != null) {
            clientWidth = bjVar2.f303b;
            int i4;
            if (clientWidth < bjVar.f303b) {
                f = (bjVar2.f306e + bjVar2.f305d) + f2;
                i4 = clientWidth + 1;
                i2 = 0;
                while (i4 <= bjVar.f303b && i2 < this.f259e.size()) {
                    bjVar3 = (bj) this.f259e.get(i2);
                    while (i4 > bjVar3.f303b && i2 < this.f259e.size() - 1) {
                        i2++;
                        bjVar3 = (bj) this.f259e.get(i2);
                    }
                    while (i4 < bjVar3.f303b) {
                        f += this.f262h.m503a(i4) + f2;
                        i4++;
                    }
                    bjVar3.f306e = f;
                    f += bjVar3.f305d + f2;
                    i4++;
                }
            } else if (clientWidth > bjVar.f303b) {
                i2 = this.f259e.size() - 1;
                f = bjVar2.f306e;
                i4 = clientWidth - 1;
                while (i4 >= bjVar.f303b && i2 >= 0) {
                    bjVar3 = (bj) this.f259e.get(i2);
                    while (i4 < bjVar3.f303b && i2 > 0) {
                        i2--;
                        bjVar3 = (bj) this.f259e.get(i2);
                    }
                    while (i4 > bjVar3.f303b) {
                        f -= this.f262h.m503a(i4) + f2;
                        i4--;
                    }
                    f -= bjVar3.f305d + f2;
                    bjVar3.f306e = f;
                    i4--;
                }
            }
        }
        int size = this.f259e.size();
        float f3 = bjVar.f306e;
        i2 = bjVar.f303b - 1;
        this.f273s = bjVar.f303b == 0 ? bjVar.f306e : -3.4028235E38f;
        this.f274t = bjVar.f303b == a + -1 ? (bjVar.f306e + bjVar.f305d) - 1.0f : Float.MAX_VALUE;
        for (i3 = i - 1; i3 >= 0; i3--) {
            bjVar3 = (bj) this.f259e.get(i3);
            f = f3;
            while (i2 > bjVar3.f303b) {
                f -= this.f262h.m503a(i2) + f2;
                i2--;
            }
            f3 = f - (bjVar3.f305d + f2);
            bjVar3.f306e = f3;
            if (bjVar3.f303b == 0) {
                this.f273s = f3;
            }
            i2--;
        }
        f3 = (bjVar.f306e + bjVar.f305d) + f2;
        i2 = bjVar.f303b + 1;
        for (i3 = i + 1; i3 < size; i3++) {
            bjVar3 = (bj) this.f259e.get(i3);
            f = f3;
            while (i2 < bjVar3.f303b) {
                f = (this.f262h.m503a(i2) + f2) + f;
                i2++;
            }
            if (bjVar3.f303b == a - 1) {
                this.f274t = (bjVar3.f305d + f) - 1.0f;
            }
            bjVar3.f306e = f;
            f3 = f + (bjVar3.f305d + f2);
            i2++;
        }
        this.f253T = false;
    }

    private void m279a(MotionEvent motionEvent) {
        int b = C0098z.m725b(motionEvent);
        if (C0098z.m726b(motionEvent, b) == this.f243J) {
            b = b == 0 ? 1 : 0;
            this.f239F = C0098z.m727c(motionEvent, b);
            this.f243J = C0098z.m726b(motionEvent, b);
            if (this.f244K != null) {
                this.f244K.clear();
            }
        }
    }

    private void m280a(boolean z) {
        int scrollX;
        boolean z2 = this.ah == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            this.f267m.abortAnimation();
            scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f267m.getCurrX();
            int currY = this.f267m.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
            }
        }
        this.f279y = false;
        boolean z3 = z2;
        for (scrollX = 0; scrollX < this.f259e.size(); scrollX++) {
            bj bjVar = (bj) this.f259e.get(scrollX);
            if (bjVar.f304c) {
                bjVar.f304c = false;
                z3 = true;
            }
        }
        if (!z3) {
            return;
        }
        if (z) {
            ak.m536a((View) this, this.ag);
        } else {
            this.ag.run();
        }
    }

    private boolean m281a(float f, float f2) {
        return (f < ((float) this.f237D) && f2 > 0.0f) || (f > ((float) (getWidth() - this.f237D)) && f2 < 0.0f);
    }

    private void m283b(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ak.m533a(getChildAt(i), z ? 2 : 0, null);
        }
    }

    private boolean m284b(float f) {
        boolean z;
        float f2;
        boolean z2 = true;
        boolean z3 = false;
        float f3 = this.f239F - f;
        this.f239F = f;
        float scrollX = ((float) getScrollX()) + f3;
        int clientWidth = getClientWidth();
        float f4 = ((float) clientWidth) * this.f273s;
        float f5 = ((float) clientWidth) * this.f274t;
        bj bjVar = (bj) this.f259e.get(0);
        bj bjVar2 = (bj) this.f259e.get(this.f259e.size() - 1);
        if (bjVar.f303b != 0) {
            f4 = bjVar.f306e * ((float) clientWidth);
            z = false;
        } else {
            z = true;
        }
        if (bjVar2.f303b != this.f262h.m504a() - 1) {
            f2 = bjVar2.f306e * ((float) clientWidth);
            z2 = false;
        } else {
            f2 = f5;
        }
        if (scrollX < f4) {
            if (z) {
                z3 = this.f250Q.m809a(Math.abs(f4 - scrollX) / ((float) clientWidth));
            }
        } else if (scrollX > f2) {
            if (z2) {
                z3 = this.f251R.m809a(Math.abs(scrollX - f2) / ((float) clientWidth));
            }
            f4 = f2;
        } else {
            f4 = scrollX;
        }
        this.f239F += f4 - ((float) ((int) f4));
        scrollTo((int) f4, getScrollY());
        m286d((int) f4);
        return z3;
    }

    private void m285c(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean m286d(int i) {
        if (this.f259e.size() == 0) {
            this.f254U = false;
            m297a(0, 0.0f, 0);
            if (this.f254U) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        bj i2 = m290i();
        int clientWidth = getClientWidth();
        int i3 = this.f269o + clientWidth;
        float f = ((float) this.f269o) / ((float) clientWidth);
        int i4 = i2.f303b;
        float f2 = ((((float) i) / ((float) clientWidth)) - i2.f306e) / (i2.f305d + f);
        clientWidth = (int) (((float) i3) * f2);
        this.f254U = false;
        m297a(i4, f2, clientWidth);
        if (this.f254U) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private void m288g() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((bk) getChildAt(i).getLayoutParams()).f307a) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void m289h() {
        if (this.ad != 0) {
            if (this.ae == null) {
                this.ae = new ArrayList();
            } else {
                this.ae.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.ae.add(getChildAt(i));
            }
            Collections.sort(this.ae, af);
        }
    }

    private bj m290i() {
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        float f = clientWidth > 0 ? ((float) this.f269o) / ((float) clientWidth) : 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i = -1;
        int i2 = 0;
        Object obj = 1;
        bj bjVar = null;
        while (i2 < this.f259e.size()) {
            int i3;
            bj bjVar2;
            bj bjVar3 = (bj) this.f259e.get(i2);
            bj bjVar4;
            if (obj != null || bjVar3.f303b == i + 1) {
                bjVar4 = bjVar3;
                i3 = i2;
                bjVar2 = bjVar4;
            } else {
                bjVar3 = this.f260f;
                bjVar3.f306e = (f2 + f3) + f;
                bjVar3.f303b = i + 1;
                bjVar3.f305d = this.f262h.m503a(bjVar3.f303b);
                bjVar4 = bjVar3;
                i3 = i2 - 1;
                bjVar2 = bjVar4;
            }
            f2 = bjVar2.f306e;
            f3 = (bjVar2.f305d + f2) + f;
            if (obj == null && scrollX < f2) {
                return bjVar;
            }
            if (scrollX < f3 || i3 == this.f259e.size() - 1) {
                return bjVar2;
            }
            f3 = f2;
            i = bjVar2.f303b;
            obj = null;
            f2 = bjVar2.f305d;
            bjVar = bjVar2;
            i2 = i3 + 1;
        }
        return bjVar;
    }

    private void m291j() {
        this.f234A = false;
        this.f235B = false;
        if (this.f244K != null) {
            this.f244K.recycle();
            this.f244K = null;
        }
    }

    private void setScrollState(int i) {
        if (this.ah != i) {
            this.ah = i;
            if (this.ab != null) {
                m283b(i != 0);
            }
            if (this.f256W != null) {
                this.f256W.m645b(i);
            }
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.f278x != z) {
            this.f278x = z;
        }
    }

    float m292a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    bj m293a(int i, int i2) {
        bj bjVar = new bj();
        bjVar.f303b = i;
        bjVar.f302a = this.f262h.m507a((ViewGroup) this, i);
        bjVar.f305d = this.f262h.m503a(i);
        if (i2 < 0 || i2 >= this.f259e.size()) {
            this.f259e.add(bjVar);
        } else {
            this.f259e.add(i2, bjVar);
        }
        return bjVar;
    }

    bj m294a(View view) {
        for (int i = 0; i < this.f259e.size(); i++) {
            bj bjVar = (bj) this.f259e.get(i);
            if (this.f262h.m514a(view, bjVar.f302a)) {
                return bjVar;
            }
        }
        return null;
    }

    void m295a() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f267m = new Scroller(context, f233d);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.f238E = ba.m632a(viewConfiguration);
        this.f245L = (int) (400.0f * f);
        this.f246M = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f250Q = new C0105f(context);
        this.f251R = new C0105f(context);
        this.f247N = (int) (25.0f * f);
        this.f248O = (int) (2.0f * f);
        this.f236C = (int) (16.0f * f);
        ak.m535a((View) this, new bl(this));
        if (ak.m540c(this) == 0) {
            ak.m539b(this, 1);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m296a(int i) {
        bj bjVar;
        int i2;
        if (this.f263i != i) {
            int i3 = this.f263i < i ? 66 : 17;
            bj b = m304b(this.f263i);
            this.f263i = i;
            bjVar = b;
            i2 = i3;
        } else {
            bjVar = null;
            i2 = 2;
        }
        if (this.f262h == null) {
            m289h();
        } else if (this.f279y) {
            m289h();
        } else if (getWindowToken() != null) {
            this.f262h.m512a((ViewGroup) this);
            i3 = this.f280z;
            int max = Math.max(0, this.f263i - i3);
            int a = this.f262h.m504a();
            int min = Math.min(a - 1, i3 + this.f263i);
            if (a != this.f258b) {
                String resourceName;
                try {
                    resourceName = getResources().getResourceName(getId());
                } catch (NotFoundException e) {
                    resourceName = Integer.toHexString(getId());
                }
                throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.f258b + ", found: " + a + " Pager id: " + resourceName + " Pager class: " + getClass() + " Problematic adapter: " + this.f262h.getClass());
            }
            bj bjVar2;
            bj bjVar3;
            int i4 = 0;
            while (i4 < this.f259e.size()) {
                bjVar2 = (bj) this.f259e.get(i4);
                if (bjVar2.f303b < this.f263i) {
                    i4++;
                }
            }
            bjVar2 = null;
            bj a2 = (bjVar2 != null || a <= 0) ? bjVar2 : m293a(this.f263i, i4);
            if (a2 != null) {
                int i5 = i4 - 1;
                bjVar2 = i5 >= 0 ? (bj) this.f259e.get(i5) : null;
                int clientWidth = getClientWidth();
                float paddingLeft = clientWidth <= 0 ? 0.0f : (2.0f - a2.f305d) + (((float) getPaddingLeft()) / ((float) clientWidth));
                float f = 0.0f;
                int i6 = this.f263i - 1;
                int i7 = i5;
                i5 = i4;
                i4 = i7;
                while (i6 >= 0) {
                    if (f < paddingLeft || i6 >= max) {
                        if (bjVar2 == null || i6 != bjVar2.f303b) {
                            f += m293a(i6, i4 + 1).f305d;
                            i5++;
                            bjVar2 = i4 >= 0 ? (bj) this.f259e.get(i4) : null;
                        } else {
                            f += bjVar2.f305d;
                            i4--;
                            bjVar2 = i4 >= 0 ? (bj) this.f259e.get(i4) : null;
                        }
                    } else if (bjVar2 == null) {
                        break;
                    } else if (i6 == bjVar2.f303b && !bjVar2.f304c) {
                        this.f259e.remove(i4);
                        this.f262h.m513a((ViewGroup) this, i6, bjVar2.f302a);
                        i4--;
                        i5--;
                        bjVar2 = i4 >= 0 ? (bj) this.f259e.get(i4) : null;
                    }
                    i6--;
                }
                paddingLeft = a2.f305d;
                i6 = i5 + 1;
                if (paddingLeft < 2.0f) {
                    bj bjVar4 = i6 < this.f259e.size() ? (bj) this.f259e.get(i6) : null;
                    float paddingRight = clientWidth <= 0 ? 0.0f : (((float) getPaddingRight()) / ((float) clientWidth)) + 2.0f;
                    bjVar2 = bjVar4;
                    int i8 = i6;
                    i6 = this.f263i + 1;
                    while (i6 < a) {
                        float f2;
                        float f3;
                        if (paddingLeft < paddingRight || i6 <= min) {
                            if (bjVar2 == null || i6 != bjVar2.f303b) {
                                bjVar2 = m293a(i6, i8);
                                i8++;
                                f2 = paddingLeft + bjVar2.f305d;
                                bjVar3 = i8 < this.f259e.size() ? (bj) this.f259e.get(i8) : null;
                                f3 = f2;
                            } else {
                                i8++;
                                f2 = paddingLeft + bjVar2.f305d;
                                bjVar3 = i8 < this.f259e.size() ? (bj) this.f259e.get(i8) : null;
                                f3 = f2;
                            }
                        } else if (bjVar2 == null) {
                            break;
                        } else if (i6 != bjVar2.f303b || bjVar2.f304c) {
                            f2 = paddingLeft;
                            bjVar3 = bjVar2;
                            f3 = f2;
                        } else {
                            this.f259e.remove(i8);
                            this.f262h.m513a((ViewGroup) this, i6, bjVar2.f302a);
                            f2 = paddingLeft;
                            bjVar3 = i8 < this.f259e.size() ? (bj) this.f259e.get(i8) : null;
                            f3 = f2;
                        }
                        i6++;
                        f2 = f3;
                        bjVar2 = bjVar3;
                        paddingLeft = f2;
                    }
                }
                m278a(a2, i5, bjVar);
            }
            this.f262h.m520b((ViewGroup) this, this.f263i, a2 != null ? a2.f302a : null);
            this.f262h.m519b((ViewGroup) this);
            i4 = getChildCount();
            for (int i9 = 0; i9 < i4; i9++) {
                View childAt = getChildAt(i9);
                bk bkVar = (bk) childAt.getLayoutParams();
                bkVar.f312f = i9;
                if (!bkVar.f307a && bkVar.f309c == 0.0f) {
                    bjVar3 = m294a(childAt);
                    if (bjVar3 != null) {
                        bkVar.f309c = bjVar3.f305d;
                        bkVar.f311e = bjVar3.f303b;
                    }
                }
            }
            m289h();
            if (hasFocus()) {
                View findFocus = findFocus();
                bjVar2 = findFocus != null ? m305b(findFocus) : null;
                if (bjVar2 == null || bjVar2.f303b != this.f263i) {
                    i3 = 0;
                    while (i3 < getChildCount()) {
                        View childAt2 = getChildAt(i3);
                        bj a3 = m294a(childAt2);
                        if (a3 == null || a3.f303b != this.f263i || !childAt2.requestFocus(r3)) {
                            i3++;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    protected void m297a(int i, float f, int i2) {
        int paddingLeft;
        int paddingRight;
        int i3;
        if (this.f255V > 0) {
            int scrollX = getScrollX();
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            i3 = 0;
            while (i3 < childCount) {
                int i4;
                View childAt = getChildAt(i3);
                bk bkVar = (bk) childAt.getLayoutParams();
                if (bkVar.f307a) {
                    int max;
                    switch (bkVar.f308b & 7) {
                        case cm.HListView_android_divider /*1*/:
                            max = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        case cm.HListView_hlv_headerDividersEnabled /*3*/:
                            max = childAt.getWidth() + paddingLeft;
                            i4 = paddingLeft;
                            paddingLeft = paddingRight;
                            paddingRight = max;
                            max = i4;
                            break;
                        case cm.HListView_hlv_overScrollHeader /*5*/:
                            max = (width - paddingRight) - childAt.getMeasuredWidth();
                            i4 = paddingRight + childAt.getMeasuredWidth();
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        default:
                            max = paddingLeft;
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                    }
                    max = (max + scrollX) - childAt.getLeft();
                    if (max != 0) {
                        childAt.offsetLeftAndRight(max);
                    }
                } else {
                    i4 = paddingRight;
                    paddingRight = paddingLeft;
                    paddingLeft = i4;
                }
                i3++;
                i4 = paddingLeft;
                paddingLeft = paddingRight;
                paddingRight = i4;
            }
        }
        if (this.f256W != null) {
            this.f256W.m644a(i, f, i2);
        }
        if (this.f257Z != null) {
            this.f257Z.m644a(i, f, i2);
        }
        if (this.ab != null) {
            paddingRight = getScrollX();
            i3 = getChildCount();
            for (paddingLeft = 0; paddingLeft < i3; paddingLeft++) {
                View childAt2 = getChildAt(paddingLeft);
                if (!((bk) childAt2.getLayoutParams()).f307a) {
                    this.ab.m646a(childAt2, ((float) (childAt2.getLeft() - paddingRight)) / ((float) getClientWidth()));
                }
            }
        }
        this.f254U = true;
    }

    void m298a(int i, int i2, int i3) {
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i4 = i - scrollX;
        int i5 = i2 - scrollY;
        if (i4 == 0 && i5 == 0) {
            m280a(false);
            m307c();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i6 = clientWidth / 2;
        float a = (((float) i6) * m292a(Math.min(1.0f, (((float) Math.abs(i4)) * 1.0f) / ((float) clientWidth)))) + ((float) i6);
        int abs = Math.abs(i3);
        if (abs > 0) {
            clientWidth = Math.round(1000.0f * Math.abs(a / ((float) abs))) * 4;
        } else {
            clientWidth = (int) (((((float) Math.abs(i4)) / ((((float) clientWidth) * this.f262h.m503a(this.f263i)) + ((float) this.f269o))) + 1.0f) * 100.0f);
        }
        this.f267m.startScroll(scrollX, scrollY, i4, i5, Math.min(clientWidth, 600));
        ak.m538b(this);
    }

    public void m299a(int i, boolean z) {
        this.f279y = false;
        m300a(i, z, false);
    }

    void m300a(int i, boolean z, boolean z2) {
        m301a(i, z, z2, 0);
    }

    void m301a(int i, boolean z, boolean z2, int i2) {
        boolean z3 = false;
        if (this.f262h == null || this.f262h.m504a() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.f263i != i || this.f259e.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.f262h.m504a()) {
                i = this.f262h.m504a() - 1;
            }
            int i3 = this.f280z;
            if (i > this.f263i + i3 || i < this.f263i - i3) {
                for (int i4 = 0; i4 < this.f259e.size(); i4++) {
                    ((bj) this.f259e.get(i4)).f304c = true;
                }
            }
            if (this.f263i != i) {
                z3 = true;
            }
            if (this.f252S) {
                this.f263i = i;
                if (z3 && this.f256W != null) {
                    this.f256W.m643a(i);
                }
                if (z3 && this.f257Z != null) {
                    this.f257Z.m643a(i);
                }
                requestLayout();
                return;
            }
            m296a(i);
            m276a(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    public boolean m302a(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case 21:
                return m308c(17);
            case 22:
                return m308c(66);
            case 61:
                return VERSION.SDK_INT >= 11 ? C0091s.m704a(keyEvent) ? m308c(2) : C0091s.m705a(keyEvent, 1) ? m308c(1) : false : false;
            default:
                return false;
        }
    }

    protected boolean m303a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (m303a(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        return z && ak.m537a(view, -i);
    }

    public void addFocusables(ArrayList arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    bj a = m294a(childAt);
                    if (a != null && a.f303b == this.f263i) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList arrayList) {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                bj a = m294a(childAt);
                if (a != null && a.f303b == this.f263i) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        LayoutParams generateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : layoutParams;
        bk bkVar = (bk) generateLayoutParams;
        bkVar.f307a |= view instanceof bi;
        if (!this.f277w) {
            super.addView(view, i, generateLayoutParams);
        } else if (bkVar == null || !bkVar.f307a) {
            bkVar.f310d = true;
            addViewInLayout(view, i, generateLayoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    bj m304b(int i) {
        for (int i2 = 0; i2 < this.f259e.size(); i2++) {
            bj bjVar = (bj) this.f259e.get(i2);
            if (bjVar.f303b == i) {
                return bjVar;
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    bj m305b(View view) {
        while (true) {
            ViewPager parent = view.getParent();
            if (parent == this) {
                return m294a(view);
            }
            if (parent != null && (parent instanceof View)) {
                view = parent;
            }
        }
        return null;
    }

    void m306b() {
        int a = this.f262h.m504a();
        this.f258b = a;
        boolean z = this.f259e.size() < (this.f280z * 2) + 1 && this.f259e.size() < a;
        boolean z2 = false;
        int i = this.f263i;
        boolean z3 = z;
        int i2 = 0;
        while (i2 < this.f259e.size()) {
            int i3;
            boolean z4;
            int i4;
            boolean z5;
            bj bjVar = (bj) this.f259e.get(i2);
            int a2 = this.f262h.m505a(bjVar.f302a);
            if (a2 == -1) {
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = z3;
            } else if (a2 == -2) {
                this.f259e.remove(i2);
                i2--;
                if (!z2) {
                    this.f262h.m512a((ViewGroup) this);
                    z2 = true;
                }
                this.f262h.m513a((ViewGroup) this, bjVar.f303b, bjVar.f302a);
                if (this.f263i == bjVar.f303b) {
                    i3 = i2;
                    z4 = z2;
                    i4 = Math.max(0, Math.min(this.f263i, a - 1));
                    z5 = true;
                } else {
                    i3 = i2;
                    z4 = z2;
                    i4 = i;
                    z5 = true;
                }
            } else if (bjVar.f303b != a2) {
                if (bjVar.f303b == this.f263i) {
                    i = a2;
                }
                bjVar.f303b = a2;
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = true;
            } else {
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = z3;
            }
            z3 = z5;
            i = i4;
            z2 = z4;
            i2 = i3 + 1;
        }
        if (z2) {
            this.f262h.m519b((ViewGroup) this);
        }
        Collections.sort(this.f259e, f232c);
        if (z3) {
            i4 = getChildCount();
            for (i2 = 0; i2 < i4; i2++) {
                bk bkVar = (bk) getChildAt(i2).getLayoutParams();
                if (!bkVar.f307a) {
                    bkVar.f309c = 0.0f;
                }
            }
            m300a(i, false, true);
            requestLayout();
        }
    }

    void m307c() {
        m296a(this.f263i);
    }

    public boolean m308c(int i) {
        View view;
        boolean d;
        View findFocus = findFocus();
        if (findFocus == this) {
            view = null;
        } else {
            if (findFocus != null) {
                Object obj;
                for (ViewPager parent = findFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                    if (parent == this) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        stringBuilder.append(" => ").append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + stringBuilder.toString());
                    view = null;
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findNextFocus == null || findNextFocus == view) {
            if (i == 17 || i == 1) {
                d = m309d();
            } else {
                if (i == 66 || i == 2) {
                    d = m310e();
                }
                d = false;
            }
        } else if (i == 17) {
            d = (view == null || m273a(this.f261g, findNextFocus).left < m273a(this.f261g, view).left) ? findNextFocus.requestFocus() : m309d();
        } else {
            if (i == 66) {
                d = (view == null || m273a(this.f261g, findNextFocus).left > m273a(this.f261g, view).left) ? findNextFocus.requestFocus() : m310e();
            }
            d = false;
        }
        if (d) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return d;
    }

    public boolean canScrollHorizontally(int i) {
        boolean z = true;
        if (this.f262h == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX <= ((int) (((float) clientWidth) * this.f273s))) {
                z = false;
            }
            return z;
        } else if (i <= 0) {
            return false;
        } else {
            if (scrollX >= ((int) (((float) clientWidth) * this.f274t))) {
                z = false;
            }
            return z;
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof bk) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        if (this.f267m.isFinished() || !this.f267m.computeScrollOffset()) {
            m280a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f267m.getCurrX();
        int currY = this.f267m.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!m286d(currX)) {
                this.f267m.abortAnimation();
                scrollTo(0, currY);
            }
        }
        ak.m538b(this);
    }

    boolean m309d() {
        if (this.f263i <= 0) {
            return false;
        }
        m299a(this.f263i - 1, true);
        return true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m302a(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                bj a = m294a(childAt);
                if (a != null && a.f303b == this.f263i && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int i = 0;
        int a = ak.m531a(this);
        if (a == 0 || (a == 1 && this.f262h != null && this.f262h.m504a() > 1)) {
            int height;
            int width;
            if (!this.f250Q.m808a()) {
                a = canvas.save();
                height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-height) + getPaddingTop()), this.f273s * ((float) width));
                this.f250Q.m807a(height, width);
                i = 0 | this.f250Q.m811a(canvas);
                canvas.restoreToCount(a);
            }
            if (!this.f251R.m808a()) {
                a = canvas.save();
                height = getWidth();
                width = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.f274t + 1.0f)) * ((float) height));
                this.f251R.m807a(width, height);
                i |= this.f251R.m811a(canvas);
                canvas.restoreToCount(a);
            }
        } else {
            this.f250Q.m812b();
            this.f251R.m812b();
        }
        if (i != 0) {
            ak.m538b(this);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f270p;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    boolean m310e() {
        if (this.f262h == null || this.f263i >= this.f262h.m504a() - 1) {
            return false;
        }
        m299a(this.f263i + 1, true);
        return true;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new bk();
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new bk(getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public ae getAdapter() {
        return this.f262h;
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.ad == 2) {
            i2 = (i - 1) - i2;
        }
        return ((bk) ((View) this.ae.get(i2)).getLayoutParams()).f312f;
    }

    public int getCurrentItem() {
        return this.f263i;
    }

    public int getOffscreenPageLimit() {
        return this.f280z;
    }

    public int getPageMargin() {
        return this.f269o;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f252S = true;
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.ag);
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f269o > 0 && this.f270p != null && this.f259e.size() > 0 && this.f262h != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f = ((float) this.f269o) / ((float) width);
            bj bjVar = (bj) this.f259e.get(0);
            float f2 = bjVar.f306e;
            int size = this.f259e.size();
            int i = bjVar.f303b;
            int i2 = ((bj) this.f259e.get(size - 1)).f303b;
            int i3 = 0;
            int i4 = i;
            while (i4 < i2) {
                float f3;
                while (i4 > bjVar.f303b && i3 < size) {
                    i3++;
                    bjVar = (bj) this.f259e.get(i3);
                }
                if (i4 == bjVar.f303b) {
                    f3 = (bjVar.f306e + bjVar.f305d) * ((float) width);
                    f2 = (bjVar.f306e + bjVar.f305d) + f;
                } else {
                    float a = this.f262h.m503a(i4);
                    f3 = (f2 + a) * ((float) width);
                    f2 += a + f;
                }
                if (((float) this.f269o) + f3 > ((float) scrollX)) {
                    this.f270p.setBounds((int) f3, this.f271q, (int) ((((float) this.f269o) + f3) + 0.5f), this.f272r);
                    this.f270p.draw(canvas);
                }
                if (f3 <= ((float) (scrollX + width))) {
                    i4++;
                } else {
                    return;
                }
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.f234A = false;
            this.f235B = false;
            this.f243J = -1;
            if (this.f244K == null) {
                return false;
            }
            this.f244K.recycle();
            this.f244K = null;
            return false;
        }
        if (action != 0) {
            if (this.f234A) {
                return true;
            }
            if (this.f235B) {
                return false;
            }
        }
        switch (action) {
            case cm.HListView_android_entries /*0*/:
                float x = motionEvent.getX();
                this.f241H = x;
                this.f239F = x;
                x = motionEvent.getY();
                this.f242I = x;
                this.f240G = x;
                this.f243J = C0098z.m726b(motionEvent, 0);
                this.f235B = false;
                this.f267m.computeScrollOffset();
                if (this.ah == 2 && Math.abs(this.f267m.getFinalX() - this.f267m.getCurrX()) > this.f248O) {
                    this.f267m.abortAnimation();
                    this.f279y = false;
                    m307c();
                    this.f234A = true;
                    m285c(true);
                    setScrollState(1);
                    break;
                }
                m280a(false);
                this.f234A = false;
                break;
            case cm.HListView_hlv_dividerWidth /*2*/:
                action = this.f243J;
                if (action != -1) {
                    action = C0098z.m724a(motionEvent, action);
                    float c = C0098z.m727c(motionEvent, action);
                    float f = c - this.f239F;
                    float abs = Math.abs(f);
                    float d = C0098z.m729d(motionEvent, action);
                    float abs2 = Math.abs(d - this.f242I);
                    if (f == 0.0f || m281a(this.f239F, f) || !m303a(this, false, (int) f, (int) c, (int) d)) {
                        if (abs > ((float) this.f238E) && 0.5f * abs > abs2) {
                            this.f234A = true;
                            m285c(true);
                            setScrollState(1);
                            this.f239F = f > 0.0f ? this.f241H + ((float) this.f238E) : this.f241H - ((float) this.f238E);
                            this.f240G = d;
                            setScrollingCacheEnabled(true);
                        } else if (abs2 > ((float) this.f238E)) {
                            this.f235B = true;
                        }
                        if (this.f234A && m284b(c)) {
                            ak.m538b(this);
                            break;
                        }
                    }
                    this.f239F = c;
                    this.f240G = d;
                    this.f235B = true;
                    return false;
                }
                break;
            case cm.HListView_hlv_overScrollFooter /*6*/:
                m279a(motionEvent);
                break;
        }
        if (this.f244K == null) {
            this.f244K = VelocityTracker.obtain();
        }
        this.f244K.addMovement(motionEvent);
        return this.f234A;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        bk bkVar;
        int max;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = 0;
        int i8 = 0;
        while (i8 < childCount) {
            int measuredWidth;
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                bkVar = (bk) childAt.getLayoutParams();
                if (bkVar.f307a) {
                    int i9 = bkVar.f308b & 112;
                    switch (bkVar.f308b & 7) {
                        case cm.HListView_android_divider /*1*/:
                            max = Math.max((i5 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case cm.HListView_hlv_headerDividersEnabled /*3*/:
                            max = paddingLeft;
                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
                            break;
                        case cm.HListView_hlv_overScrollHeader /*5*/:
                            measuredWidth = (i5 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            max = measuredWidth;
                            break;
                        default:
                            max = paddingLeft;
                            break;
                    }
                    int i10;
                    switch (i9) {
                        case 16:
                            measuredWidth = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        case 48:
                            measuredWidth = childAt.getMeasuredHeight() + paddingTop;
                            i10 = paddingTop;
                            paddingTop = paddingBottom;
                            paddingBottom = measuredWidth;
                            measuredWidth = i10;
                            break;
                        case 80:
                            measuredWidth = (i6 - paddingBottom) - childAt.getMeasuredHeight();
                            i10 = paddingBottom + childAt.getMeasuredHeight();
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        default:
                            measuredWidth = paddingTop;
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                    }
                    max += scrollX;
                    childAt.layout(max, measuredWidth, childAt.getMeasuredWidth() + max, childAt.getMeasuredHeight() + measuredWidth);
                    measuredWidth = i7 + 1;
                    i7 = paddingBottom;
                    paddingBottom = paddingTop;
                    paddingTop = paddingRight;
                    paddingRight = paddingLeft;
                    i8++;
                    paddingLeft = paddingRight;
                    paddingRight = paddingTop;
                    paddingTop = i7;
                    i7 = measuredWidth;
                }
            }
            measuredWidth = i7;
            i7 = paddingTop;
            paddingTop = paddingRight;
            paddingRight = paddingLeft;
            i8++;
            paddingLeft = paddingRight;
            paddingRight = paddingTop;
            paddingTop = i7;
            i7 = measuredWidth;
        }
        max = (i5 - paddingLeft) - paddingRight;
        for (paddingRight = 0; paddingRight < childCount; paddingRight++) {
            View childAt2 = getChildAt(paddingRight);
            if (childAt2.getVisibility() != 8) {
                bkVar = (bk) childAt2.getLayoutParams();
                if (!bkVar.f307a) {
                    bj a = m294a(childAt2);
                    if (a != null) {
                        i5 = ((int) (a.f306e * ((float) max))) + paddingLeft;
                        if (bkVar.f310d) {
                            bkVar.f310d = false;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (bkVar.f309c * ((float) max)), 1073741824), MeasureSpec.makeMeasureSpec((i6 - paddingTop) - paddingBottom, 1073741824));
                        }
                        childAt2.layout(i5, paddingTop, childAt2.getMeasuredWidth() + i5, childAt2.getMeasuredHeight() + paddingTop);
                    }
                }
            }
        }
        this.f271q = paddingTop;
        this.f272r = i6 - paddingBottom;
        this.f255V = i7;
        if (this.f252S) {
            m276a(this.f263i, false, 0, false);
        }
        this.f252S = false;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.f237D = Math.min(measuredWidth / 10, this.f236C);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            bk bkVar;
            int i5;
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                bkVar = (bk) childAt.getLayoutParams();
                if (bkVar != null && bkVar.f307a) {
                    int i6 = bkVar.f308b & 7;
                    int i7 = bkVar.f308b & 112;
                    i3 = Integer.MIN_VALUE;
                    i5 = Integer.MIN_VALUE;
                    Object obj = (i7 == 48 || i7 == 80) ? 1 : null;
                    Object obj2 = (i6 == 3 || i6 == 5) ? 1 : null;
                    if (obj != null) {
                        i3 = 1073741824;
                    } else if (obj2 != null) {
                        i5 = 1073741824;
                    }
                    if (bkVar.width != -2) {
                        i7 = 1073741824;
                        i3 = bkVar.width != -1 ? bkVar.width : paddingLeft;
                    } else {
                        i7 = i3;
                        i3 = paddingLeft;
                    }
                    if (bkVar.height != -2) {
                        i5 = 1073741824;
                        if (bkVar.height != -1) {
                            measuredWidth = bkVar.height;
                            childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i5));
                            if (obj != null) {
                                measuredHeight -= childAt.getMeasuredHeight();
                            } else if (obj2 != null) {
                                paddingLeft -= childAt.getMeasuredWidth();
                            }
                        }
                    }
                    measuredWidth = measuredHeight;
                    childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i5));
                    if (obj != null) {
                        measuredHeight -= childAt.getMeasuredHeight();
                    } else if (obj2 != null) {
                        paddingLeft -= childAt.getMeasuredWidth();
                    }
                }
            }
        }
        this.f275u = MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.f276v = MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.f277w = true;
        m307c();
        this.f277w = false;
        i3 = getChildCount();
        for (i5 = 0; i5 < i3; i5++) {
            View childAt2 = getChildAt(i5);
            if (childAt2.getVisibility() != 8) {
                bkVar = (bk) childAt2.getLayoutParams();
                if (bkVar == null || !bkVar.f307a) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (bkVar.f309c * ((float) paddingLeft)), 1073741824), this.f276v);
                }
            }
        }
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3 = -1;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = 1;
            i2 = 0;
        } else {
            i2 = childCount - 1;
            childCount = -1;
        }
        while (i2 != childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                bj a = m294a(childAt);
                if (a != null && a.f303b == this.f263i && childAt.requestFocus(i, rect)) {
                    return true;
                }
            }
            i2 += i3;
        }
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (this.f262h != null) {
                this.f262h.m509a(savedState.f229b, savedState.f230c);
                m300a(savedState.f228a, false, true);
                return;
            }
            this.f264j = savedState.f228a;
            this.f265k = savedState.f229b;
            this.f266l = savedState.f230c;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f228a = this.f263i;
        if (this.f262h != null) {
            savedState.f229b = this.f262h.m515b();
        }
        return savedState;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            m275a(i, i3, this.f269o, this.f269o);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.f249P) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.f262h == null || this.f262h.m504a() == 0) {
            return false;
        }
        if (this.f244K == null) {
            this.f244K = VelocityTracker.obtain();
        }
        this.f244K.addMovement(motionEvent);
        float x;
        int a;
        switch (motionEvent.getAction() & 255) {
            case cm.HListView_android_entries /*0*/:
                this.f267m.abortAnimation();
                this.f279y = false;
                m307c();
                x = motionEvent.getX();
                this.f241H = x;
                this.f239F = x;
                x = motionEvent.getY();
                this.f242I = x;
                this.f240G = x;
                this.f243J = C0098z.m726b(motionEvent, 0);
                break;
            case cm.HListView_android_divider /*1*/:
                if (this.f234A) {
                    VelocityTracker velocityTracker = this.f244K;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f246M);
                    a = (int) af.m521a(velocityTracker, this.f243J);
                    this.f279y = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    bj i = m290i();
                    m301a(m272a(i.f303b, ((((float) scrollX) / ((float) clientWidth)) - i.f306e) / i.f305d, a, (int) (C0098z.m727c(motionEvent, C0098z.m724a(motionEvent, this.f243J)) - this.f241H)), true, true, a);
                    this.f243J = -1;
                    m291j();
                    z = this.f251R.m813c() | this.f250Q.m813c();
                    break;
                }
                break;
            case cm.HListView_hlv_dividerWidth /*2*/:
                if (!this.f234A) {
                    a = C0098z.m724a(motionEvent, this.f243J);
                    float c = C0098z.m727c(motionEvent, a);
                    float abs = Math.abs(c - this.f239F);
                    float d = C0098z.m729d(motionEvent, a);
                    x = Math.abs(d - this.f240G);
                    if (abs > ((float) this.f238E) && abs > x) {
                        this.f234A = true;
                        m285c(true);
                        this.f239F = c - this.f241H > 0.0f ? this.f241H + ((float) this.f238E) : this.f241H - ((float) this.f238E);
                        this.f240G = d;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                if (this.f234A) {
                    z = false | m284b(C0098z.m727c(motionEvent, C0098z.m724a(motionEvent, this.f243J)));
                    break;
                }
                break;
            case cm.HListView_hlv_headerDividersEnabled /*3*/:
                if (this.f234A) {
                    m276a(this.f263i, true, 0, false);
                    this.f243J = -1;
                    m291j();
                    z = this.f251R.m813c() | this.f250Q.m813c();
                    break;
                }
                break;
            case cm.HListView_hlv_overScrollHeader /*5*/:
                a = C0098z.m725b(motionEvent);
                this.f239F = C0098z.m727c(motionEvent, a);
                this.f243J = C0098z.m726b(motionEvent, a);
                break;
            case cm.HListView_hlv_overScrollFooter /*6*/:
                m279a(motionEvent);
                this.f239F = C0098z.m727c(motionEvent, C0098z.m724a(motionEvent, this.f243J));
                break;
        }
        if (z) {
            ak.m538b(this);
        }
        return true;
    }

    public void removeView(View view) {
        if (this.f277w) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(ae aeVar) {
        if (this.f262h != null) {
            this.f262h.m516b(this.f268n);
            this.f262h.m512a((ViewGroup) this);
            for (int i = 0; i < this.f259e.size(); i++) {
                bj bjVar = (bj) this.f259e.get(i);
                this.f262h.m513a((ViewGroup) this, bjVar.f303b, bjVar.f302a);
            }
            this.f262h.m519b((ViewGroup) this);
            this.f259e.clear();
            m288g();
            this.f263i = 0;
            scrollTo(0, 0);
        }
        ae aeVar2 = this.f262h;
        this.f262h = aeVar;
        this.f258b = 0;
        if (this.f262h != null) {
            if (this.f268n == null) {
                this.f268n = new bp();
            }
            this.f262h.m508a(this.f268n);
            this.f279y = false;
            boolean z = this.f252S;
            this.f252S = true;
            this.f258b = this.f262h.m504a();
            if (this.f264j >= 0) {
                this.f262h.m509a(this.f265k, this.f266l);
                m300a(this.f264j, false, true);
                this.f264j = -1;
                this.f265k = null;
                this.f266l = null;
            } else if (z) {
                requestLayout();
            } else {
                m307c();
            }
        }
        if (this.aa != null && aeVar2 != aeVar) {
            this.aa.m642a(aeVar2, aeVar);
        }
    }

    void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (VERSION.SDK_INT >= 7) {
            if (this.ac == null) {
                try {
                    this.ac = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                } catch (Throwable e) {
                    Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                this.ac.invoke(this, new Object[]{Boolean.valueOf(z)});
            } catch (Throwable e2) {
                Log.e("ViewPager", "Error changing children drawing order", e2);
            }
        }
    }

    public void setCurrentItem(int i) {
        this.f279y = false;
        m300a(i, !this.f252S, false);
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to " + 1);
            i = 1;
        }
        if (i != this.f280z) {
            this.f280z = i;
            m307c();
        }
    }

    void setOnAdapterChangeListener(bm bmVar) {
        this.aa = bmVar;
    }

    public void setOnPageChangeListener(bn bnVar) {
        this.f256W = bnVar;
    }

    public void setPageMargin(int i) {
        int i2 = this.f269o;
        this.f269o = i;
        int width = getWidth();
        m275a(width, width, i, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f270p = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f270p;
    }
}
