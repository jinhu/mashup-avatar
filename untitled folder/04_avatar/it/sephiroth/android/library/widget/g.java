package it.sephiroth.android.library.widget;

import android.view.View;
import com.google.android.apps.androidify.cm;

class g implements Runnable {
    final /* synthetic */ AbsHListView a;
    private final as b;
    private int c;
    private final Runnable d;

    g(AbsHListView absHListView) {
        this.a = absHListView;
        this.d = new h(this);
        this.b = new as(absHListView.getContext());
    }

    void a() {
        if (this.b.a(this.a.getScrollX(), 0, 0, 0, 0, 0)) {
            this.a.F = 6;
            this.a.invalidate();
            this.a.a.a((Runnable) this);
            return;
        }
        this.a.F = -1;
        this.a.b(0);
    }

    void a(int i) {
        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
        this.c = i2;
        this.b.a(null);
        this.b.a(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
        this.a.F = 4;
        this.a.a.a((Runnable) this);
    }

    void a(int i, int i2, boolean z) {
        int i3 = i < 0 ? Integer.MAX_VALUE : 0;
        this.c = i3;
        this.b.a(z ? AbsHListView.T : null);
        this.b.a(i3, 0, i, 0, i2);
        this.a.F = 4;
        this.a.a.a((Runnable) this);
    }

    void b() {
        this.a.F = -1;
        this.a.removeCallbacks(this);
        this.a.removeCallbacks(this.d);
        this.a.b(0);
        this.a.F();
        this.b.e();
        this.a.overScrollBy(0, 0, 0, 0, 0, 0, 0, 0, false);
    }

    void b(int i) {
        this.b.a(null);
        this.b.a(this.a.getScrollX(), 0, i, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0, this.a.getWidth(), 0);
        this.a.F = 6;
        this.a.invalidate();
        this.a.a.a((Runnable) this);
    }

    void c() {
        this.a.postDelayed(this.d, 40);
    }

    void c(int i) {
        this.b.a(this.a.getScrollX(), 0, this.a.R);
        int overScrollMode = this.a.getOverScrollMode();
        if (overScrollMode == 0 || (overScrollMode == 1 && !this.a.z())) {
            this.a.F = 6;
            overScrollMode = (int) this.b.c();
            if (i > 0) {
                this.a.aP.a(overScrollMode);
            } else {
                this.a.aQ.a(overScrollMode);
            }
        } else {
            this.a.F = -1;
            if (this.a.I != null) {
                this.a.I.a();
            }
        }
        this.a.invalidate();
        this.a.a.a((Runnable) this);
    }

    public void run() {
        int scrollX;
        int i;
        int i2 = 1;
        int i3 = 0;
        switch (this.a.F) {
            case cm.HListView_hlv_headerDividersEnabled /*3*/:
                if (this.b.a()) {
                    return;
                }
                break;
            case cm.HListView_hlv_footerDividersEnabled /*4*/:
                break;
            case cm.HListView_hlv_overScrollFooter /*6*/:
                as asVar = this.b;
                if (asVar.d()) {
                    scrollX = this.a.getScrollX();
                    int b = asVar.b();
                    if (this.a.overScrollBy(b - scrollX, 0, scrollX, 0, 0, 0, this.a.R, 0, false)) {
                        i = (scrollX > 0 || b <= 0) ? 0 : 1;
                        if (scrollX >= 0 && b < 0) {
                            i3 = 1;
                        }
                        if (i == 0 && i3 == 0) {
                            a();
                            return;
                        }
                        i = (int) asVar.c();
                        if (i3 != 0) {
                            i = -i;
                        }
                        asVar.e();
                        a(i);
                        return;
                    }
                    this.a.invalidate();
                    this.a.a.a((Runnable) this);
                    return;
                }
                b();
                return;
            default:
                b();
                return;
        }
        if (this.a.ai) {
            this.a.e();
        }
        if (this.a.an == 0 || this.a.getChildCount() == 0) {
            b();
            return;
        }
        int min;
        as asVar2 = this.b;
        boolean d = asVar2.d();
        int b2 = asVar2.b();
        i = this.c - b2;
        if (i > 0) {
            this.a.A = this.a.V;
            this.a.B = this.a.getChildAt(0).getLeft();
            min = Math.min(((this.a.getWidth() - this.a.getPaddingRight()) - this.a.getPaddingLeft()) - 1, i);
        } else {
            scrollX = this.a.getChildCount() - 1;
            this.a.A = this.a.V + scrollX;
            this.a.B = this.a.getChildAt(scrollX).getLeft();
            min = Math.max(-(((this.a.getWidth() - this.a.getPaddingRight()) - this.a.getPaddingLeft()) - 1), i);
        }
        View childAt = this.a.getChildAt(this.a.A - this.a.V);
        i = childAt != null ? childAt.getLeft() : 0;
        boolean d2 = this.a.d(min, min);
        if (!d2 || min == 0) {
            i2 = 0;
        }
        if (i2 != 0) {
            if (childAt != null) {
                this.a.overScrollBy(-(min - (childAt.getLeft() - i)), 0, this.a.getScrollX(), 0, 0, 0, this.a.R, 0, false);
            }
            if (d) {
                c(min);
            }
        } else if (d && i2 == 0) {
            if (d2) {
                this.a.invalidate();
            }
            this.c = b2;
            this.a.a.a((Runnable) this);
        } else {
            b();
        }
    }
}
