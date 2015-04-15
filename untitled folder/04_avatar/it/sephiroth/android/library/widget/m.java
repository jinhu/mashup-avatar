package it.sephiroth.android.library.widget;

import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;
import com.google.android.apps.androidify.cm;

public class m implements Runnable {
    final /* synthetic */ AbsHListView a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private final int g;
    private int h;

    m(AbsHListView absHListView) {
        this.a = absHListView;
        this.g = ViewConfiguration.get(absHListView.getContext()).getScaledFadingEdgeLength();
    }

    public void a() {
        this.a.removeCallbacks(this);
    }

    void a(int i) {
        a();
        if (this.a.ai) {
            this.a.O = new n(this, i);
            return;
        }
        int childCount = this.a.getChildCount();
        if (childCount != 0) {
            int i2 = this.a.V;
            childCount = (childCount + i2) - 1;
            int max = Math.max(0, Math.min(this.a.getCount() - 1, i));
            if (max < i2) {
                childCount = (i2 - max) + 1;
                this.b = 2;
            } else if (max > childCount) {
                childCount = (max - childCount) + 1;
                this.b = 1;
            } else {
                a(max, -1, 200);
                return;
            }
            if (childCount > 0) {
                this.f = 200 / childCount;
            } else {
                this.f = 200;
            }
            this.c = max;
            this.d = -1;
            this.e = -1;
            this.a.a.a((Runnable) this);
        }
    }

    void a(int i, int i2) {
        a();
        if (i2 == -1) {
            a(i);
        } else if (this.a.ai) {
            this.a.O = new o(this, i, i2);
        } else {
            int childCount = this.a.getChildCount();
            if (childCount != 0) {
                int i3 = this.a.V;
                childCount = (childCount + i3) - 1;
                int max = Math.max(0, Math.min(this.a.getCount() - 1, i));
                if (max < i3) {
                    childCount -= i2;
                    if (childCount >= 1) {
                        i3 = (i3 - max) + 1;
                        childCount--;
                        if (childCount < i3) {
                            this.b = 4;
                        } else {
                            this.b = 2;
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
                            this.b = 3;
                        } else {
                            this.b = 1;
                            childCount = i3;
                        }
                    } else {
                        return;
                    }
                } else {
                    a(max, i2, 200);
                    return;
                }
                if (childCount > 0) {
                    this.f = 200 / childCount;
                } else {
                    this.f = 200;
                }
                this.c = max;
                this.d = i2;
                this.e = -1;
                this.a.a.a((Runnable) this);
            }
        }
    }

    void a(int i, int i2, int i3) {
        int i4 = this.a.V;
        int childCount = (this.a.getChildCount() + i4) - 1;
        int i5 = this.a.u.left;
        int width = this.a.getWidth() - this.a.u.right;
        if (i < i4 || i > childCount) {
            Log.w("AbsListView", "scrollToVisible called with targetPos " + i + " not visible [" + i4 + ", " + childCount + "]");
        }
        if (i2 < i4 || i2 > childCount) {
            i2 = -1;
        }
        View childAt = this.a.getChildAt(i - i4);
        int left = childAt.getLeft();
        childCount = childAt.getRight();
        childCount = childCount > width ? childCount - width : 0;
        if (left < i5) {
            childCount = left - i5;
        }
        if (childCount != 0) {
            if (i2 >= 0) {
                View childAt2 = this.a.getChildAt(i2 - i4);
                left = childAt2.getLeft();
                i4 = childAt2.getRight();
                int abs = Math.abs(childCount);
                if (childCount < 0 && i4 + abs > width) {
                    childCount = Math.max(0, i4 - width);
                } else if (childCount > 0 && left - abs < i5) {
                    childCount = Math.min(0, left - i5);
                }
            }
            this.a.c(childCount, i3);
        }
    }

    public void run() {
        int i = 0;
        int width = this.a.getWidth();
        int i2 = this.a.V;
        View childAt;
        int width2;
        int max;
        switch (this.b) {
            case cm.HListView_android_divider /*1*/:
                i = this.a.getChildCount() - 1;
                i2 += i;
                if (i < 0) {
                    return;
                }
                if (i2 == this.e) {
                    this.a.a.a((Runnable) this);
                    return;
                }
                childAt = this.a.getChildAt(i);
                this.a.a((i2 < this.a.an + -1 ? Math.max(this.a.u.right, this.g) : this.a.u.right) + (childAt.getWidth() - (width - childAt.getLeft())), this.f, true);
                this.e = i2;
                if (i2 < this.c) {
                    this.a.a.a((Runnable) this);
                }
            case cm.HListView_hlv_dividerWidth /*2*/:
                if (i2 == this.e) {
                    this.a.a.a((Runnable) this);
                    return;
                }
                childAt = this.a.getChildAt(0);
                if (childAt != null) {
                    this.a.a(childAt.getLeft() - (i2 > 0 ? Math.max(this.g, this.a.u.left) : this.a.u.left), this.f, true);
                    this.e = i2;
                    if (i2 > this.c) {
                        this.a.a.a((Runnable) this);
                    }
                }
            case cm.HListView_hlv_headerDividersEnabled /*3*/:
                width = this.a.getChildCount();
                if (i2 != this.d && width > 1 && width + i2 < this.a.an) {
                    width = i2 + 1;
                    if (width == this.e) {
                        this.a.a.a((Runnable) this);
                        return;
                    }
                    View childAt2 = this.a.getChildAt(1);
                    width2 = childAt2.getWidth();
                    i2 = childAt2.getLeft();
                    max = Math.max(this.a.u.right, this.g);
                    if (width < this.d) {
                        this.a.a(Math.max(0, (i2 + width2) - max), this.f, true);
                        this.e = width;
                        this.a.a.a((Runnable) this);
                    } else if (i2 > max) {
                        this.a.a(i2 - max, this.f, true);
                    }
                }
            case cm.HListView_hlv_footerDividersEnabled /*4*/:
                i = this.a.getChildCount() - 2;
                if (i >= 0) {
                    i2 += i;
                    if (i2 == this.e) {
                        this.a.a.a((Runnable) this);
                        return;
                    }
                    childAt = this.a.getChildAt(i);
                    width2 = childAt.getWidth();
                    i = childAt.getLeft();
                    max = width - i;
                    int max2 = Math.max(this.a.u.left, this.g);
                    this.e = i2;
                    if (i2 > this.d) {
                        this.a.a(-(max - max2), this.f, true);
                        this.a.a.a((Runnable) this);
                        return;
                    }
                    width -= max2;
                    i += width2;
                    if (width > i) {
                        this.a.a(-(width - i), this.f, true);
                    }
                }
            case cm.HListView_hlv_overScrollHeader /*5*/:
                if (this.e == i2) {
                    this.a.a.a((Runnable) this);
                    return;
                }
                this.e = i2;
                width = this.a.getChildCount();
                width2 = this.c;
                max = (i2 + width) - 1;
                if (width2 < i2) {
                    i = (i2 - width2) + 1;
                } else if (width2 > max) {
                    i = width2 - max;
                }
                float min = Math.min(Math.abs(((float) i) / ((float) width)), 1.0f);
                if (width2 < i2) {
                    this.a.a((int) (((float) (-this.a.getWidth())) * min), (int) (min * ((float) this.f)), true);
                    this.a.a.a((Runnable) this);
                } else if (width2 > max) {
                    this.a.a((int) (((float) this.a.getWidth()) * min), (int) (min * ((float) this.f)), true);
                    this.a.a.a((Runnable) this);
                } else {
                    i = this.a.getChildAt(width2 - i2).getLeft() - this.h;
                    this.a.a(i, (int) (((float) this.f) * (((float) Math.abs(i)) / ((float) this.a.getWidth()))), true);
                }
            default:
        }
    }
}
