package android.support.v4.widget;

import android.view.View;

/* renamed from: android.support.v4.widget.e */
class C0104e extends C0103x {
    final /* synthetic */ DrawerLayout f375a;
    private final int f376b;
    private C0121v f377c;
    private final Runnable f378d;

    private void m794b() {
        int i = 3;
        if (this.f376b == 3) {
            i = 5;
        }
        View a = this.f375a.m740a(i);
        if (a != null) {
            this.f375a.m755i(a);
        }
    }

    public int m795a(View view) {
        return view.getWidth();
    }

    public int m796a(View view, int i, int i2) {
        if (this.f375a.m745a(view, 3)) {
            return Math.max(-view.getWidth(), Math.min(i, 0));
        }
        int width = this.f375a.getWidth();
        return Math.max(width - view.getWidth(), Math.min(i, width));
    }

    public void m797a() {
        this.f375a.removeCallbacks(this.f378d);
    }

    public void m798a(int i) {
        this.f375a.m742a(this.f376b, i, this.f377c.m899c());
    }

    public void m799a(int i, int i2) {
        this.f375a.postDelayed(this.f378d, 160);
    }

    public void m800a(View view, float f, float f2) {
        int i;
        float d = this.f375a.m750d(view);
        int width = view.getWidth();
        if (this.f375a.m745a(view, 3)) {
            i = (f > 0.0f || (f == 0.0f && d > 0.5f)) ? 0 : -width;
        } else {
            i = this.f375a.getWidth();
            if (f < 0.0f || (f == 0.0f && d > 0.5f)) {
                i -= width;
            }
        }
        this.f377c.m889a(i, view.getTop());
        this.f375a.invalidate();
    }

    public void m801a(View view, int i, int i2, int i3, int i4) {
        int width = view.getWidth();
        float width2 = this.f375a.m745a(view, 3) ? ((float) (width + i)) / ((float) width) : ((float) (this.f375a.getWidth() - i)) / ((float) width);
        this.f375a.m748b(view, width2);
        view.setVisibility(width2 == 0.0f ? 4 : 0);
        this.f375a.invalidate();
    }

    public boolean m802a(View view, int i) {
        return this.f375a.m753g(view) && this.f375a.m745a(view, this.f376b) && this.f375a.m738a(view) == 0;
    }

    public int m803b(View view, int i, int i2) {
        return view.getTop();
    }

    public void m804b(int i, int i2) {
        View a = (i & 1) == 1 ? this.f375a.m740a(3) : this.f375a.m740a(5);
        if (a != null && this.f375a.m738a(a) == 0) {
            this.f377c.m888a(a, i2);
        }
    }

    public void m805b(View view, int i) {
        ((C0101c) view.getLayoutParams()).f373c = false;
        m794b();
    }

    public boolean m806b(int i) {
        return false;
    }
}
