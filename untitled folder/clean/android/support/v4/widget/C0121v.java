package android.support.v4.widget;

import android.support.v4.view.C0098z;
import android.support.v4.view.af;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.google.android.apps.androidify.cm;
import java.util.Arrays;

/* renamed from: android.support.v4.widget.v */
public class C0121v {
    private static final Interpolator f392v;
    private int f393a;
    private int f394b;
    private int f395c;
    private float[] f396d;
    private float[] f397e;
    private float[] f398f;
    private float[] f399g;
    private int[] f400h;
    private int[] f401i;
    private int[] f402j;
    private int f403k;
    private VelocityTracker f404l;
    private float f405m;
    private float f406n;
    private int f407o;
    private int f408p;
    private C0110k f409q;
    private final C0103x f410r;
    private View f411s;
    private boolean f412t;
    private final ViewGroup f413u;
    private final Runnable f414w;

    static {
        f392v = new C0122w();
    }

    private float m868a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    private float m869a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        return abs < f2 ? 0.0f : abs > f3 ? f <= 0.0f ? -f3 : f3 : f;
    }

    private int m870a(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.f413u.getWidth();
        int i4 = width / 2;
        float a = (m868a(Math.min(1.0f, ((float) Math.abs(i)) / ((float) width))) * ((float) i4)) + ((float) i4);
        i4 = Math.abs(i2);
        return Math.min(i4 > 0 ? Math.round(Math.abs(a / ((float) i4)) * 1000.0f) * 4 : (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f), 600);
    }

    private int m871a(View view, int i, int i2, int i3, int i4) {
        int b = m877b(i3, (int) this.f406n, (int) this.f405m);
        int b2 = m877b(i4, (int) this.f406n, (int) this.f405m);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(b);
        int abs4 = Math.abs(b2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        return (int) (((b2 != 0 ? ((float) abs4) / ((float) i5) : ((float) abs2) / ((float) i6)) * ((float) m870a(i2, b2, this.f410r.m788b(view)))) + ((b != 0 ? ((float) abs3) / ((float) i5) : ((float) abs) / ((float) i6)) * ((float) m870a(i, b, this.f410r.m781a(view)))));
    }

    private void m872a(float f, float f2) {
        this.f412t = true;
        this.f410r.m785a(this.f411s, f, f2);
        this.f412t = false;
        if (this.f393a == 1) {
            m900c(0);
        }
    }

    private void m873a(float f, float f2, int i) {
        m883f(i);
        float[] fArr = this.f396d;
        this.f398f[i] = f;
        fArr[i] = f;
        fArr = this.f397e;
        this.f399g[i] = f2;
        fArr[i] = f2;
        this.f400h[i] = m881e((int) f, (int) f2);
        this.f403k |= 1 << i;
    }

    private boolean m874a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.f400h[i] & i2) != i2 || (this.f408p & i2) == 0 || (this.f402j[i] & i2) == i2 || (this.f401i[i] & i2) == i2) {
            return false;
        }
        if (abs <= ((float) this.f394b) && abs2 <= ((float) this.f394b)) {
            return false;
        }
        if (abs >= abs2 * 0.5f || !this.f410r.m792b(i2)) {
            return (this.f401i[i] & i2) == 0 && abs > ((float) this.f394b);
        } else {
            int[] iArr = this.f402j;
            iArr[i] = iArr[i] | i2;
            return false;
        }
    }

    private boolean m875a(int i, int i2, int i3, int i4) {
        int left = this.f411s.getLeft();
        int top = this.f411s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f409q.m853g();
            m900c(0);
            return false;
        }
        this.f409q.m846a(left, top, i5, i6, m871a(this.f411s, i5, i6, i3, i4));
        m900c(2);
        return true;
    }

    private boolean m876a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.f410r.m781a(view) > 0;
        boolean z2 = this.f410r.m788b(view) > 0;
        return (z && z2) ? (f * f) + (f2 * f2) > ((float) (this.f394b * this.f394b)) : z ? Math.abs(f) > ((float) this.f394b) : z2 ? Math.abs(f2) > ((float) this.f394b) : false;
    }

    private int m877b(int i, int i2, int i3) {
        int abs = Math.abs(i);
        return abs < i2 ? 0 : abs > i3 ? i <= 0 ? -i3 : i3 : i;
    }

    private void m878b(float f, float f2, int i) {
        int i2 = 1;
        if (!m874a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (m874a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (m874a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (m874a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f401i;
            iArr[i] = iArr[i] | i2;
            this.f410r.m790b(i2, i);
        }
    }

    private void m879b(int i, int i2, int i3, int i4) {
        int a;
        int b;
        int left = this.f411s.getLeft();
        int top = this.f411s.getTop();
        if (i3 != 0) {
            a = this.f410r.m782a(this.f411s, i, i3);
            this.f411s.offsetLeftAndRight(a - left);
        } else {
            a = i;
        }
        if (i4 != 0) {
            b = this.f410r.m789b(this.f411s, i2, i4);
            this.f411s.offsetTopAndBottom(b - top);
        } else {
            b = i2;
        }
        if (i3 != 0 || i4 != 0) {
            this.f410r.m786a(this.f411s, a, b, a - left, b - top);
        }
    }

    private void m880c(MotionEvent motionEvent) {
        int c = C0098z.m728c(motionEvent);
        for (int i = 0; i < c; i++) {
            int b = C0098z.m726b(motionEvent, i);
            float c2 = C0098z.m727c(motionEvent, i);
            float d = C0098z.m729d(motionEvent, i);
            this.f398f[b] = c2;
            this.f399g[b] = d;
        }
    }

    private int m881e(int i, int i2) {
        int i3 = 0;
        if (i < this.f413u.getLeft() + this.f407o) {
            i3 = 1;
        }
        if (i2 < this.f413u.getTop() + this.f407o) {
            i3 |= 4;
        }
        if (i > this.f413u.getRight() - this.f407o) {
            i3 |= 2;
        }
        return i2 > this.f413u.getBottom() - this.f407o ? i3 | 8 : i3;
    }

    private void m882e(int i) {
        if (this.f396d != null) {
            this.f396d[i] = 0.0f;
            this.f397e[i] = 0.0f;
            this.f398f[i] = 0.0f;
            this.f399g[i] = 0.0f;
            this.f400h[i] = 0;
            this.f401i[i] = 0;
            this.f402j[i] = 0;
            this.f403k &= (1 << i) ^ -1;
        }
    }

    private void m883f(int i) {
        if (this.f396d == null || this.f396d.length <= i) {
            Object obj = new float[(i + 1)];
            Object obj2 = new float[(i + 1)];
            Object obj3 = new float[(i + 1)];
            Object obj4 = new float[(i + 1)];
            Object obj5 = new int[(i + 1)];
            Object obj6 = new int[(i + 1)];
            Object obj7 = new int[(i + 1)];
            if (this.f396d != null) {
                System.arraycopy(this.f396d, 0, obj, 0, this.f396d.length);
                System.arraycopy(this.f397e, 0, obj2, 0, this.f397e.length);
                System.arraycopy(this.f398f, 0, obj3, 0, this.f398f.length);
                System.arraycopy(this.f399g, 0, obj4, 0, this.f399g.length);
                System.arraycopy(this.f400h, 0, obj5, 0, this.f400h.length);
                System.arraycopy(this.f401i, 0, obj6, 0, this.f401i.length);
                System.arraycopy(this.f402j, 0, obj7, 0, this.f402j.length);
            }
            this.f396d = obj;
            this.f397e = obj2;
            this.f398f = obj3;
            this.f399g = obj4;
            this.f400h = obj5;
            this.f401i = obj6;
            this.f402j = obj7;
        }
    }

    private void m884g() {
        if (this.f396d != null) {
            Arrays.fill(this.f396d, 0.0f);
            Arrays.fill(this.f397e, 0.0f);
            Arrays.fill(this.f398f, 0.0f);
            Arrays.fill(this.f399g, 0.0f);
            Arrays.fill(this.f400h, 0);
            Arrays.fill(this.f401i, 0);
            Arrays.fill(this.f402j, 0);
            this.f403k = 0;
        }
    }

    private void m885h() {
        this.f404l.computeCurrentVelocity(1000, this.f405m);
        m872a(m869a(af.m521a(this.f404l, this.f395c), this.f406n, this.f405m), m869a(af.m522b(this.f404l, this.f395c), this.f406n, this.f405m));
    }

    public int m886a() {
        return this.f393a;
    }

    public void m887a(int i) {
        this.f408p = i;
    }

    public void m888a(View view, int i) {
        if (view.getParent() != this.f413u) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f413u + ")");
        }
        this.f411s = view;
        this.f395c = i;
        this.f410r.m791b(view, i);
        m900c(1);
    }

    public boolean m889a(int i, int i2) {
        if (this.f412t) {
            return m875a(i, i2, (int) af.m521a(this.f404l, this.f395c), (int) af.m522b(this.f404l, this.f395c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    public boolean m890a(MotionEvent motionEvent) {
        int a = C0098z.m723a(motionEvent);
        int b = C0098z.m725b(motionEvent);
        if (a == 0) {
            m905e();
        }
        if (this.f404l == null) {
            this.f404l = VelocityTracker.obtain();
        }
        this.f404l.addMovement(motionEvent);
        float y;
        int b2;
        switch (a) {
            case cm.HListView_android_entries /*0*/:
                float x = motionEvent.getX();
                y = motionEvent.getY();
                b2 = C0098z.m726b(motionEvent, 0);
                m873a(x, y, b2);
                View d = m903d((int) x, (int) y);
                if (d == this.f411s && this.f393a == 2) {
                    m897b(d, b2);
                }
                a = this.f400h[b2];
                if ((this.f408p & a) != 0) {
                    this.f410r.m784a(a & this.f408p, b2);
                    break;
                }
                break;
            case cm.HListView_android_divider /*1*/:
            case cm.HListView_hlv_headerDividersEnabled /*3*/:
                m905e();
                break;
            case cm.HListView_hlv_dividerWidth /*2*/:
                b = C0098z.m728c(motionEvent);
                a = 0;
                while (a < b) {
                    b2 = C0098z.m726b(motionEvent, a);
                    float c = C0098z.m727c(motionEvent, a);
                    float d2 = C0098z.m729d(motionEvent, a);
                    float f = c - this.f396d[b2];
                    float f2 = d2 - this.f397e[b2];
                    m878b(f, f2, b2);
                    if (this.f393a != 1) {
                        View d3 = m903d((int) c, (int) d2);
                        if (d3 == null || !m876a(d3, f, f2) || !m897b(d3, b2)) {
                            a++;
                        }
                    }
                    m880c(motionEvent);
                    break;
                }
                m880c(motionEvent);
                break;
            case cm.HListView_hlv_overScrollHeader /*5*/:
                a = C0098z.m726b(motionEvent, b);
                float c2 = C0098z.m727c(motionEvent, b);
                y = C0098z.m729d(motionEvent, b);
                m873a(c2, y, a);
                if (this.f393a != 0) {
                    if (this.f393a == 2) {
                        View d4 = m903d((int) c2, (int) y);
                        if (d4 == this.f411s) {
                            m897b(d4, a);
                            break;
                        }
                    }
                }
                b = this.f400h[a];
                if ((this.f408p & b) != 0) {
                    this.f410r.m784a(b & this.f408p, a);
                    break;
                }
                break;
            case cm.HListView_hlv_overScrollFooter /*6*/:
                m882e(C0098z.m726b(motionEvent, b));
                break;
        }
        return this.f393a == 1;
    }

    public boolean m891a(View view, int i, int i2) {
        this.f411s = view;
        this.f395c = -1;
        return m875a(i, i2, 0, 0);
    }

    public boolean m892a(boolean z) {
        if (this.f393a == 2) {
            boolean a;
            boolean f = this.f409q.m852f();
            int b = this.f409q.m848b();
            int c = this.f409q.m849c();
            int left = b - this.f411s.getLeft();
            int top = c - this.f411s.getTop();
            if (left != 0) {
                this.f411s.offsetLeftAndRight(left);
            }
            if (top != 0) {
                this.f411s.offsetTopAndBottom(top);
            }
            if (!(left == 0 && top == 0)) {
                this.f410r.m786a(this.f411s, b, c, left, top);
            }
            if (f && b == this.f409q.m850d() && c == this.f409q.m851e()) {
                this.f409q.m853g();
                a = this.f409q.m847a();
            } else {
                a = f;
            }
            if (!a) {
                if (z) {
                    this.f413u.post(this.f414w);
                } else {
                    m900c(0);
                }
            }
        }
        return this.f393a == 2;
    }

    public int m893b() {
        return this.f407o;
    }

    public void m894b(MotionEvent motionEvent) {
        int i = 0;
        int a = C0098z.m723a(motionEvent);
        int b = C0098z.m725b(motionEvent);
        if (a == 0) {
            m905e();
        }
        if (this.f404l == null) {
            this.f404l = VelocityTracker.obtain();
        }
        this.f404l.addMovement(motionEvent);
        float x;
        float y;
        View d;
        int i2;
        switch (a) {
            case cm.HListView_android_entries /*0*/:
                x = motionEvent.getX();
                y = motionEvent.getY();
                i = C0098z.m726b(motionEvent, 0);
                d = m903d((int) x, (int) y);
                m873a(x, y, i);
                m897b(d, i);
                i2 = this.f400h[i];
                if ((this.f408p & i2) != 0) {
                    this.f410r.m784a(i2 & this.f408p, i);
                }
            case cm.HListView_android_divider /*1*/:
                if (this.f393a == 1) {
                    m885h();
                }
                m905e();
            case cm.HListView_hlv_dividerWidth /*2*/:
                if (this.f393a == 1) {
                    i = C0098z.m724a(motionEvent, this.f395c);
                    x = C0098z.m727c(motionEvent, i);
                    i2 = (int) (x - this.f398f[this.f395c]);
                    i = (int) (C0098z.m729d(motionEvent, i) - this.f399g[this.f395c]);
                    m879b(this.f411s.getLeft() + i2, this.f411s.getTop() + i, i2, i);
                    m880c(motionEvent);
                    return;
                }
                i2 = C0098z.m728c(motionEvent);
                while (i < i2) {
                    a = C0098z.m726b(motionEvent, i);
                    float c = C0098z.m727c(motionEvent, i);
                    float d2 = C0098z.m729d(motionEvent, i);
                    float f = c - this.f396d[a];
                    float f2 = d2 - this.f397e[a];
                    m878b(f, f2, a);
                    if (this.f393a != 1) {
                        d = m903d((int) c, (int) d2);
                        if (!m876a(d, f, f2) || !m897b(d, a)) {
                            i++;
                        }
                    }
                    m880c(motionEvent);
                }
                m880c(motionEvent);
            case cm.HListView_hlv_headerDividersEnabled /*3*/:
                if (this.f393a == 1) {
                    m872a(0.0f, 0.0f);
                }
                m905e();
            case cm.HListView_hlv_overScrollHeader /*5*/:
                i = C0098z.m726b(motionEvent, b);
                x = C0098z.m727c(motionEvent, b);
                y = C0098z.m729d(motionEvent, b);
                m873a(x, y, i);
                if (this.f393a == 0) {
                    m897b(m903d((int) x, (int) y), i);
                    i2 = this.f400h[i];
                    if ((this.f408p & i2) != 0) {
                        this.f410r.m784a(i2 & this.f408p, i);
                    }
                } else if (m901c((int) x, (int) y)) {
                    m897b(this.f411s, i);
                }
            case cm.HListView_hlv_overScrollFooter /*6*/:
                a = C0098z.m726b(motionEvent, b);
                if (this.f393a == 1 && a == this.f395c) {
                    b = C0098z.m728c(motionEvent);
                    while (i < b) {
                        int b2 = C0098z.m726b(motionEvent, i);
                        if (b2 != this.f395c) {
                            if (m903d((int) C0098z.m727c(motionEvent, i), (int) C0098z.m729d(motionEvent, i)) == this.f411s && m897b(this.f411s, b2)) {
                                i = this.f395c;
                                if (i == -1) {
                                    m885h();
                                }
                            }
                        }
                        i++;
                    }
                    i = -1;
                    if (i == -1) {
                        m885h();
                    }
                }
                m882e(a);
            default:
        }
    }

    public boolean m895b(int i) {
        return (this.f403k & (1 << i)) != 0;
    }

    public boolean m896b(int i, int i2) {
        if (!m895b(i2)) {
            return false;
        }
        boolean z = (i & 1) == 1;
        boolean z2 = (i & 2) == 2;
        float f = this.f398f[i2] - this.f396d[i2];
        float f2 = this.f399g[i2] - this.f397e[i2];
        return (z && z2) ? (f * f) + (f2 * f2) > ((float) (this.f394b * this.f394b)) : z ? Math.abs(f) > ((float) this.f394b) : z2 ? Math.abs(f2) > ((float) this.f394b) : false;
    }

    boolean m897b(View view, int i) {
        if (view == this.f411s && this.f395c == i) {
            return true;
        }
        if (view == null || !this.f410r.m787a(view, i)) {
            return false;
        }
        this.f395c = i;
        m888a(view, i);
        return true;
    }

    public boolean m898b(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    public View m899c() {
        return this.f411s;
    }

    void m900c(int i) {
        if (this.f393a != i) {
            this.f393a = i;
            this.f410r.m783a(i);
            if (i == 0) {
                this.f411s = null;
            }
        }
    }

    public boolean m901c(int i, int i2) {
        return m898b(this.f411s, i, i2);
    }

    public int m902d() {
        return this.f394b;
    }

    public View m903d(int i, int i2) {
        for (int childCount = this.f413u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f413u.getChildAt(this.f410r.m793c(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public boolean m904d(int i) {
        int length = this.f396d.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (m896b(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public void m905e() {
        this.f395c = -1;
        m884g();
        if (this.f404l != null) {
            this.f404l.recycle();
            this.f404l = null;
        }
    }

    public void m906f() {
        m905e();
        if (this.f393a == 2) {
            int b = this.f409q.m848b();
            int c = this.f409q.m849c();
            this.f409q.m853g();
            int b2 = this.f409q.m848b();
            int c2 = this.f409q.m849c();
            this.f410r.m786a(this.f411s, b2, c2, b2 - b, c2 - c);
        }
        m900c(0);
    }
}
