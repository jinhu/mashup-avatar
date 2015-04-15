package it.sephiroth.android.library.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import com.google.android.apps.androidify.cm;

class at {
    private static float p;
    private static final float[] q;
    private static final float[] r;
    private int a;
    private int b;
    private int c;
    private int d;
    private float e;
    private float f;
    private long g;
    private int h;
    private int i;
    private int j;
    private boolean k;
    private int l;
    private float m;
    private int n;
    private float o;

    static {
        float f = 0.0f;
        p = (float) (Math.log(0.78d) / Math.log(0.9d));
        q = new float[101];
        r = new float[101];
        int i = 0;
        float f2 = 0.0f;
        while (i < 100) {
            float f3;
            float f4 = ((float) i) / 100.0f;
            float f5 = 1.0f;
            float f6 = f2;
            while (true) {
                f2 = ((f5 - f6) / 2.0f) + f6;
                f3 = (3.0f * f2) * (1.0f - f2);
                float f7 = ((((1.0f - f2) * 0.175f) + (0.35000002f * f2)) * f3) + ((f2 * f2) * f2);
                if (((double) Math.abs(f7 - f4)) < 1.0E-5d) {
                    break;
                } else if (f7 > f4) {
                    f5 = f2;
                } else {
                    f6 = f2;
                }
            }
            q[i] = (f2 * (f2 * f2)) + (f3 * (((1.0f - f2) * 0.5f) + f2));
            f5 = 1.0f;
            while (true) {
                f2 = ((f5 - f) / 2.0f) + f;
                f3 = (3.0f * f2) * (1.0f - f2);
                f7 = ((((1.0f - f2) * 0.5f) + f2) * f3) + ((f2 * f2) * f2);
                if (((double) Math.abs(f7 - f4)) < 1.0E-5d) {
                    break;
                } else if (f7 > f4) {
                    f5 = f2;
                } else {
                    f = f2;
                }
            }
            r[i] = (f2 * (f2 * f2)) + ((((1.0f - f2) * 0.175f) + (0.35000002f * f2)) * f3);
            i++;
            f2 = f6;
        }
        float[] fArr = q;
        r[100] = 1.0f;
        fArr[100] = 1.0f;
    }

    at(Context context) {
        this.m = ViewConfiguration.getScrollFriction();
        this.n = 0;
        this.k = true;
        this.o = ((context.getResources().getDisplayMetrics().density * 160.0f) * 386.0878f) * 0.84f;
    }

    private static float a(int i) {
        return i > 0 ? -2000.0f : 2000.0f;
    }

    private void a(int i, int i2, int i3, int i4) {
        boolean z = true;
        if (i <= i2 || i >= i3) {
            boolean z2 = i > i3;
            int i5 = z2 ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 < 0) {
                z = false;
            }
            if (z) {
                g(i, i5, i4);
                return;
            } else if (c(i4) > ((double) Math.abs(i6))) {
                a(i, i4, z2 ? i2 : i, z2 ? i : i3, this.l);
                return;
            } else {
                e(i, i5, i4);
                return;
            }
        }
        Log.e("OverScroller", "startAfterEdge called from a valid position");
        this.k = true;
    }

    private double b(int i) {
        return Math.log((double) ((0.35f * ((float) Math.abs(i))) / (this.m * this.o)));
    }

    private double c(int i) {
        return Math.exp(b(i) * (((double) p) / (((double) p) - 1.0d))) * ((double) (this.m * this.o));
    }

    private int d(int i) {
        return (int) (Math.exp(b(i) / (((double) p) - 1.0d)) * 1000.0d);
    }

    private void d() {
        float abs = ((float) (this.d * this.d)) / (Math.abs(this.f) * 2.0f);
        float signum = Math.signum((float) this.d);
        if (abs > ((float) this.l)) {
            this.f = (((-signum) * ((float) this.d)) * ((float) this.d)) / (((float) this.l) * 2.0f);
            abs = (float) this.l;
        }
        this.l = (int) abs;
        this.n = 2;
        int i = this.a;
        if (this.d <= 0) {
            abs = -abs;
        }
        this.c = ((int) abs) + i;
        this.h = -((int) ((1000.0f * ((float) this.d)) / this.f));
    }

    private void d(int i, int i2, int i3) {
        float abs = Math.abs(((float) (i3 - i)) / ((float) (i2 - i)));
        int i4 = (int) (100.0f * abs);
        if (i4 < 100) {
            float f = ((float) i4) / 100.0f;
            float f2 = ((float) (i4 + 1)) / 100.0f;
            float f3 = r[i4];
            this.h = (int) (((((abs - f) / (f2 - f)) * (r[i4 + 1] - f3)) + f3) * ((float) this.h));
        }
    }

    private void e(int i, int i2, int i3) {
        this.k = false;
        this.n = 1;
        this.a = i;
        this.c = i2;
        int i4 = i - i2;
        this.f = a(i4);
        this.d = -i4;
        this.l = Math.abs(i4);
        this.h = (int) (1000.0d * Math.sqrt((-2.0d * ((double) i4)) / ((double) this.f)));
    }

    private void f(int i, int i2, int i3) {
        float sqrt = (float) Math.sqrt((((double) (((((float) (i3 * i3)) / 2.0f) / Math.abs(this.f)) + ((float) Math.abs(i2 - i)))) * 2.0d) / ((double) Math.abs(this.f)));
        this.g -= (long) ((int) ((sqrt - (((float) (-i3)) / this.f)) * 1000.0f));
        this.a = i2;
        this.d = (int) ((-this.f) * sqrt);
    }

    private void g(int i, int i2, int i3) {
        this.f = a(i3 == 0 ? i - i2 : i3);
        f(i, i2, i3);
        d();
    }

    void a() {
        this.b = this.c;
        this.k = true;
    }

    void a(float f) {
        this.m = f;
    }

    void a(int i, int i2, int i3) {
        this.k = false;
        this.a = i;
        this.c = i + i2;
        this.g = AnimationUtils.currentAnimationTimeMillis();
        this.h = i3;
        this.f = 0.0f;
        this.d = 0;
    }

    void a(int i, int i2, int i3, int i4, int i5) {
        this.l = i5;
        this.k = false;
        this.d = i2;
        this.e = (float) i2;
        this.i = 0;
        this.h = 0;
        this.g = AnimationUtils.currentAnimationTimeMillis();
        this.a = i;
        this.b = i;
        if (i > i4 || i < i3) {
            a(i, i3, i4, i2);
            return;
        }
        this.n = 0;
        double d = 0.0d;
        if (i2 != 0) {
            int d2 = d(i2);
            this.i = d2;
            this.h = d2;
            d = c(i2);
        }
        this.j = (int) (d * ((double) Math.signum((float) i2)));
        this.c = this.j + i;
        if (this.c < i3) {
            d(this.a, this.c, i3);
            this.c = i3;
        }
        if (this.c > i4) {
            d(this.a, this.c, i4);
            this.c = i4;
        }
    }

    void b(float f) {
        this.b = this.a + Math.round(((float) (this.c - this.a)) * f);
    }

    boolean b() {
        switch (this.n) {
            case cm.HListView_android_entries /*0*/:
                if (this.h < this.i) {
                    this.a = this.c;
                    this.d = (int) this.e;
                    this.f = a(this.d);
                    this.g += (long) this.h;
                    d();
                    break;
                }
                return false;
            case cm.HListView_android_divider /*1*/:
                return false;
            case cm.HListView_hlv_dividerWidth /*2*/:
                this.g += (long) this.h;
                e(this.c, this.a, 0);
                break;
        }
        c();
        return true;
    }

    boolean b(int i, int i2, int i3) {
        this.k = true;
        this.c = i;
        this.a = i;
        this.d = 0;
        this.g = AnimationUtils.currentAnimationTimeMillis();
        this.h = 0;
        if (i < i2) {
            e(i, i2, 0);
        } else if (i > i3) {
            e(i, i3, 0);
        }
        return !this.k;
    }

    void c(int i, int i2, int i3) {
        if (this.n == 0) {
            this.l = i3;
            this.g = AnimationUtils.currentAnimationTimeMillis();
            a(i, i2, i2, (int) this.e);
        }
    }

    boolean c() {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.g;
        if (currentAnimationTimeMillis > ((long) this.h)) {
            return false;
        }
        double d = 0.0d;
        float f;
        float f2;
        float f3;
        switch (this.n) {
            case cm.HListView_android_entries /*0*/:
                f = ((float) currentAnimationTimeMillis) / ((float) this.i);
                int i = (int) (100.0f * f);
                float f4 = 1.0f;
                f2 = 0.0f;
                if (i < 100) {
                    f4 = ((float) i) / 100.0f;
                    f2 = ((float) (i + 1)) / 100.0f;
                    f3 = q[i];
                    f2 = (q[i + 1] - f3) / (f2 - f4);
                    f4 = ((f - f4) * f2) + f3;
                }
                double d2 = (double) (f4 * ((float) this.j));
                this.e = ((f2 * ((float) this.j)) / ((float) this.i)) * 1000.0f;
                d = d2;
                break;
            case cm.HListView_android_divider /*1*/:
                f = ((float) currentAnimationTimeMillis) / ((float) this.h);
                float f5 = f * f;
                f3 = Math.signum((float) this.d);
                d = (double) ((((float) this.l) * f3) * ((3.0f * f5) - ((2.0f * f) * f5)));
                this.e = ((-f) + f5) * ((f3 * ((float) this.l)) * 6.0f);
                break;
            case cm.HListView_hlv_dividerWidth /*2*/:
                f2 = ((float) currentAnimationTimeMillis) / 1000.0f;
                this.e = ((float) this.d) + (this.f * f2);
                d = (double) (((f2 * (this.f * f2)) / 2.0f) + (((float) this.d) * f2));
                break;
        }
        this.b = ((int) Math.round(d)) + this.a;
        return true;
    }
}
