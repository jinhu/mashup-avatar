package it.sephiroth.android.library.widget;

import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;
import com.google.android.apps.androidify.cm;

/* renamed from: it.sephiroth.android.library.widget.m */
public class C0288m implements Runnable {
    final /* synthetic */ AbsHListView f1983a;
    private int f1984b;
    private int f1985c;
    private int f1986d;
    private int f1987e;
    private int f1988f;
    private final int f1989g;
    private int f1990h;

    C0288m(AbsHListView absHListView) {
        this.f1983a = absHListView;
        this.f1989g = ViewConfiguration.get(absHListView.getContext()).getScaledFadingEdgeLength();
    }

    public void m2396a() {
        this.f1983a.removeCallbacks(this);
    }

    void m2397a(int i) {
        m2396a();
        if (this.f1983a.ai) {
            this.f1983a.f1864O = new C0289n(this, i);
            return;
        }
        int childCount = this.f1983a.getChildCount();
        if (childCount != 0) {
            int i2 = this.f1983a.V;
            childCount = (childCount + i2) - 1;
            int max = Math.max(0, Math.min(this.f1983a.getCount() - 1, i));
            if (max < i2) {
                childCount = (i2 - max) + 1;
                this.f1984b = 2;
            } else if (max > childCount) {
                childCount = (max - childCount) + 1;
                this.f1984b = 1;
            } else {
                m2399a(max, -1, 200);
                return;
            }
            if (childCount > 0) {
                this.f1988f = 200 / childCount;
            } else {
                this.f1988f = 200;
            }
            this.f1985c = max;
            this.f1986d = -1;
            this.f1987e = -1;
            this.f1983a.f1869a.m2119a((Runnable) this);
        }
    }

    void m2398a(int i, int i2) {
        m2396a();
        if (i2 == -1) {
            m2397a(i);
        } else if (this.f1983a.ai) {
            this.f1983a.f1864O = new C0290o(this, i, i2);
        } else {
            int childCount = this.f1983a.getChildCount();
            if (childCount != 0) {
                int i3 = this.f1983a.V;
                childCount = (childCount + i3) - 1;
                int max = Math.max(0, Math.min(this.f1983a.getCount() - 1, i));
                if (max < i3) {
                    childCount -= i2;
                    if (childCount >= 1) {
                        i3 = (i3 - max) + 1;
                        childCount--;
                        if (childCount < i3) {
                            this.f1984b = 4;
                        } else {
                            this.f1984b = 2;
                            childCount = i3;
                        }
                    } else {
                        return;
                    }
                } else if (max > childCount) {
                    int i4 = i2 - i3;
                    if (i4 >= 1) {
                        i3 = (max - childCount) + 1;
                        childCount = i4 - 1;
                        if (childCount < i3) {
                            this.f1984b = 3;
                        } else {
                            this.f1984b = 1;
                            childCount = i3;
                        }
                    } else {
                        return;
                    }
                } else {
                    m2399a(max, i2, 200);
                    return;
                }
                if (childCount > 0) {
                    this.f1988f = 200 / childCount;
                } else {
                    this.f1988f = 200;
                }
                this.f1985c = max;
                this.f1986d = i2;
                this.f1987e = -1;
                this.f1983a.f1869a.m2119a((Runnable) this);
            }
        }
    }

    void m2399a(int i, int i2, int i3) {
        int i4 = this.f1983a.V;
        int childCount = (this.f1983a.getChildCount() + i4) - 1;
        int i5 = this.f1983a.f1889u.left;
        int width = this.f1983a.getWidth() - this.f1983a.f1889u.right;
        if (i < i4 || i > childCount) {
            Log.w("AbsListView", "scrollToVisible called with targetPos " + i + " not visible [" + i4 + ", " + childCount + "]");
        }
        if (i2 < i4 || i2 > childCount) {
            i2 = -1;
        }
        View childAt = this.f1983a.getChildAt(i - i4);
        int left = childAt.getLeft();
        childCount = childAt.getRight();
        childCount = childCount > width ? childCount - width : 0;
        if (left < i5) {
            childCount = left - i5;
        }
        if (childCount != 0) {
            if (i2 >= 0) {
                View childAt2 = this.f1983a.getChildAt(i2 - i4);
                left = childAt2.getLeft();
                i4 = childAt2.getRight();
                int abs = Math.abs(childCount);
                if (childCount < 0 && i4 + abs > width) {
                    childCount = Math.max(0, i4 - width);
                } else if (childCount > 0 && left - abs < i5) {
                    childCount = Math.min(0, left - i5);
                }
            }
            this.f1983a.m2209c(childCount, i3);
        }
    }

    public void run() {
        int i = 0;
        int width = this.f1983a.getWidth();
        int i2 = this.f1983a.V;
        View childAt;
        int width2;
        int max;
        switch (this.f1984b) {
            case cm.HListView_android_divider /*1*/:
                i = this.f1983a.getChildCount() - 1;
                i2 += i;
                if (i < 0) {
                    return;
                }
                if (i2 == this.f1987e) {
                    this.f1983a.f1869a.m2119a((Runnable) this);
                    return;
                }
                childAt = this.f1983a.getChildAt(i);
                this.f1983a.m2195a((i2 < this.f1983a.an + -1 ? Math.max(this.f1983a.f1889u.right, this.f1989g) : this.f1983a.f1889u.right) + (childAt.getWidth() - (width - childAt.getLeft())), this.f1988f, true);
                this.f1987e = i2;
                if (i2 < this.f1985c) {
                    this.f1983a.f1869a.m2119a((Runnable) this);
                }
            case cm.HListView_hlv_dividerWidth /*2*/:
                if (i2 == this.f1987e) {
                    this.f1983a.f1869a.m2119a((Runnable) this);
                    return;
                }
                childAt = this.f1983a.getChildAt(0);
                if (childAt != null) {
                    this.f1983a.m2195a(childAt.getLeft() - (i2 > 0 ? Math.max(this.f1989g, this.f1983a.f1889u.left) : this.f1983a.f1889u.left), this.f1988f, true);
                    this.f1987e = i2;
                    if (i2 > this.f1985c) {
                        this.f1983a.f1869a.m2119a((Runnable) this);
                    }
                }
            case cm.HListView_hlv_headerDividersEnabled /*3*/:
                width = this.f1983a.getChildCount();
                if (i2 != this.f1986d && width > 1 && width + i2 < this.f1983a.an) {
                    width = i2 + 1;
                    if (width == this.f1987e) {
                        this.f1983a.f1869a.m2119a((Runnable) this);
                        return;
                    }
                    View childAt2 = this.f1983a.getChildAt(1);
                    width2 = childAt2.getWidth();
                    i2 = childAt2.getLeft();
                    max = Math.max(this.f1983a.f1889u.right, this.f1989g);
                    if (width < this.f1986d) {
                        this.f1983a.m2195a(Math.max(0, (i2 + width2) - max), this.f1988f, true);
                        this.f1987e = width;
                        this.f1983a.f1869a.m2119a((Runnable) this);
                    } else if (i2 > max) {
                        this.f1983a.m2195a(i2 - max, this.f1988f, true);
                    }
                }
            case cm.HListView_hlv_footerDividersEnabled /*4*/:
                i = this.f1983a.getChildCount() - 2;
                if (i >= 0) {
                    i2 += i;
                    if (i2 == this.f1987e) {
                        this.f1983a.f1869a.m2119a((Runnable) this);
                        return;
                    }
                    childAt = this.f1983a.getChildAt(i);
                    width2 = childAt.getWidth();
                    i = childAt.getLeft();
                    max = width - i;
                    int max2 = Math.max(this.f1983a.f1889u.left, this.f1989g);
                    this.f1987e = i2;
                    if (i2 > this.f1986d) {
                        this.f1983a.m2195a(-(max - max2), this.f1988f, true);
                        this.f1983a.f1869a.m2119a((Runnable) this);
                        return;
                    }
                    width -= max2;
                    i += width2;
                    if (width > i) {
                        this.f1983a.m2195a(-(width - i), this.f1988f, true);
                    }
                }
            case cm.HListView_hlv_overScrollHeader /*5*/:
                if (this.f1987e == i2) {
                    this.f1983a.f1869a.m2119a((Runnable) this);
                    return;
                }
                this.f1987e = i2;
                width = this.f1983a.getChildCount();
                width2 = this.f1985c;
                max = (i2 + width) - 1;
                if (width2 < i2) {
                    i = (i2 - width2) + 1;
                } else if (width2 > max) {
                    i = width2 - max;
                }
                float min = Math.min(Math.abs(((float) i) / ((float) width)), 1.0f);
                if (width2 < i2) {
                    this.f1983a.m2195a((int) (((float) (-this.f1983a.getWidth())) * min), (int) (min * ((float) this.f1988f)), true);
                    this.f1983a.f1869a.m2119a((Runnable) this);
                } else if (width2 > max) {
                    this.f1983a.m2195a((int) (((float) this.f1983a.getWidth()) * min), (int) (min * ((float) this.f1988f)), true);
                    this.f1983a.f1869a.m2119a((Runnable) this);
                } else {
                    i = this.f1983a.getChildAt(width2 - i2).getLeft() - this.f1990h;
                    this.f1983a.m2195a(i, (int) (((float) this.f1988f) * (((float) Math.abs(i)) / ((float) this.f1983a.getWidth()))), true);
                }
            default:
        }
    }
}
