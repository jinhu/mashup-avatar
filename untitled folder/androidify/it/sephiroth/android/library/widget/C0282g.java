package it.sephiroth.android.library.widget;

import android.view.View;
import com.google.android.apps.androidify.cm;

/* renamed from: it.sephiroth.android.library.widget.g */
class C0282g implements Runnable {
    final /* synthetic */ AbsHListView f1970a;
    private final as f1971b;
    private int f1972c;
    private final Runnable f1973d;

    C0282g(AbsHListView absHListView) {
        this.f1970a = absHListView;
        this.f1973d = new C0283h(this);
        this.f1971b = new as(absHListView.getContext());
    }

    void m2387a() {
        if (this.f1971b.m2352a(this.f1970a.getScrollX(), 0, 0, 0, 0, 0)) {
            this.f1970a.f1855F = 6;
            this.f1970a.invalidate();
            this.f1970a.f1869a.m2119a((Runnable) this);
            return;
        }
        this.f1970a.f1855F = -1;
        this.f1970a.m2205b(0);
    }

    void m2388a(int i) {
        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
        this.f1972c = i2;
        this.f1971b.m2349a(null);
        this.f1971b.m2347a(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
        this.f1970a.f1855F = 4;
        this.f1970a.f1869a.m2119a((Runnable) this);
    }

    void m2389a(int i, int i2, boolean z) {
        int i3 = i < 0 ? Integer.MAX_VALUE : 0;
        this.f1972c = i3;
        this.f1971b.m2349a(z ? AbsHListView.f1848T : null);
        this.f1971b.m2346a(i3, 0, i, 0, i2);
        this.f1970a.f1855F = 4;
        this.f1970a.f1869a.m2119a((Runnable) this);
    }

    void m2390b() {
        this.f1970a.f1855F = -1;
        this.f1970a.removeCallbacks(this);
        this.f1970a.removeCallbacks(this.f1973d);
        this.f1970a.m2205b(0);
        this.f1970a.m2157F();
        this.f1971b.m2357e();
        this.f1970a.overScrollBy(0, 0, 0, 0, 0, 0, 0, 0, false);
    }

    void m2391b(int i) {
        this.f1971b.m2349a(null);
        this.f1971b.m2348a(this.f1970a.getScrollX(), 0, i, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0, this.f1970a.getWidth(), 0);
        this.f1970a.f1855F = 6;
        this.f1970a.invalidate();
        this.f1970a.f1869a.m2119a((Runnable) this);
    }

    void m2392c() {
        this.f1970a.postDelayed(this.f1973d, 40);
    }

    void m2393c(int i) {
        this.f1971b.m2345a(this.f1970a.getScrollX(), 0, this.f1970a.f1867R);
        int overScrollMode = this.f1970a.getOverScrollMode();
        if (overScrollMode == 0 || (overScrollMode == 1 && !this.f1970a.m2190z())) {
            this.f1970a.f1855F = 6;
            overScrollMode = (int) this.f1971b.m2355c();
            if (i > 0) {
                this.f1970a.aP.m810a(overScrollMode);
            } else {
                this.f1970a.aQ.m810a(overScrollMode);
            }
        } else {
            this.f1970a.f1855F = -1;
            if (this.f1970a.f1858I != null) {
                this.f1970a.f1858I.m2396a();
            }
        }
        this.f1970a.invalidate();
        this.f1970a.f1869a.m2119a((Runnable) this);
    }

    public void run() {
        int scrollX;
        int i;
        int i2 = 1;
        int i3 = 0;
        switch (this.f1970a.f1855F) {
            case cm.HListView_hlv_headerDividersEnabled /*3*/:
                if (this.f1971b.m2350a()) {
                    return;
                }
                break;
            case cm.HListView_hlv_footerDividersEnabled /*4*/:
                break;
            case cm.HListView_hlv_overScrollFooter /*6*/:
                as asVar = this.f1971b;
                if (asVar.m2356d()) {
                    scrollX = this.f1970a.getScrollX();
                    int b = asVar.m2353b();
                    if (this.f1970a.overScrollBy(b - scrollX, 0, scrollX, 0, 0, 0, this.f1970a.f1867R, 0, false)) {
                        i = (scrollX > 0 || b <= 0) ? 0 : 1;
                        if (scrollX >= 0 && b < 0) {
                            i3 = 1;
                        }
                        if (i == 0 && i3 == 0) {
                            m2387a();
                            return;
                        }
                        i = (int) asVar.m2355c();
                        if (i3 != 0) {
                            i = -i;
                        }
                        asVar.m2357e();
                        m2388a(i);
                        return;
                    }
                    this.f1970a.invalidate();
                    this.f1970a.f1869a.m2119a((Runnable) this);
                    return;
                }
                m2390b();
                return;
            default:
                m2390b();
                return;
        }
        if (this.f1970a.ai) {
            this.f1970a.m2214e();
        }
        if (this.f1970a.an == 0 || this.f1970a.getChildCount() == 0) {
            m2390b();
            return;
        }
        int min;
        as asVar2 = this.f1971b;
        boolean d = asVar2.m2356d();
        int b2 = asVar2.m2353b();
        i = this.f1972c - b2;
        if (i > 0) {
            this.f1970a.f1850A = this.f1970a.V;
            this.f1970a.f1851B = this.f1970a.getChildAt(0).getLeft();
            min = Math.min(((this.f1970a.getWidth() - this.f1970a.getPaddingRight()) - this.f1970a.getPaddingLeft()) - 1, i);
        } else {
            scrollX = this.f1970a.getChildCount() - 1;
            this.f1970a.f1850A = this.f1970a.V + scrollX;
            this.f1970a.f1851B = this.f1970a.getChildAt(scrollX).getLeft();
            min = Math.max(-(((this.f1970a.getWidth() - this.f1970a.getPaddingRight()) - this.f1970a.getPaddingLeft()) - 1), i);
        }
        View childAt = this.f1970a.getChildAt(this.f1970a.f1850A - this.f1970a.V);
        i = childAt != null ? childAt.getLeft() : 0;
        boolean d2 = this.f1970a.m2213d(min, min);
        if (!d2 || min == 0) {
            i2 = 0;
        }
        if (i2 != 0) {
            if (childAt != null) {
                this.f1970a.overScrollBy(-(min - (childAt.getLeft() - i)), 0, this.f1970a.getScrollX(), 0, 0, 0, this.f1970a.f1867R, 0, false);
            }
            if (d) {
                m2393c(min);
            }
        } else if (d && i2 == 0) {
            if (d2) {
                this.f1970a.invalidate();
            }
            this.f1972c = b2;
            this.f1970a.f1869a.m2119a((Runnable) this);
        } else {
            m2390b();
        }
    }
}
