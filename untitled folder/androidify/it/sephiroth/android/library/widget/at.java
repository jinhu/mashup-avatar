package it.sephiroth.android.library.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import com.google.android.apps.androidify.cm;

class at {
    private static float f1943p;
    private static final float[] f1944q;
    private static final float[] f1945r;
    private int f1946a;
    private int f1947b;
    private int f1948c;
    private int f1949d;
    private float f1950e;
    private float f1951f;
    private long f1952g;
    private int f1953h;
    private int f1954i;
    private int f1955j;
    private boolean f1956k;
    private int f1957l;
    private float f1958m;
    private int f1959n;
    private float f1960o;

    static {
        float f = 0.0f;
        f1943p = (float) (Math.log(0.78d) / Math.log(0.9d));
        f1944q = new float[101];
        f1945r = new float[101];
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
            f1944q[i] = (f2 * (f2 * f2)) + (f3 * (((1.0f - f2) * 0.5f) + f2));
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
            f1945r[i] = (f2 * (f2 * f2)) + ((((1.0f - f2) * 0.175f) + (0.35000002f * f2)) * f3);
            i++;
            f2 = f6;
        }
        float[] fArr = f1944q;
        f1945r[100] = 1.0f;
        fArr[100] = 1.0f;
    }

    at(Context context) {
        this.f1958m = ViewConfiguration.getScrollFriction();
        this.f1959n = 0;
        this.f1956k = true;
        this.f1960o = ((context.getResources().getDisplayMetrics().density * 160.0f) * 386.0878f) * 0.84f;
    }

    private static float m2358a(int i) {
        return i > 0 ? -2000.0f : 2000.0f;
    }

    private void m2359a(int i, int i2, int i3, int i4) {
        boolean z = true;
        if (i <= i2 || i >= i3) {
            boolean z2 = i > i3;
            int i5 = z2 ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 < 0) {
                z = false;
            }
            if (z) {
                m2374g(i, i5, i4);
                return;
            } else if (m2363c(i4) > ((double) Math.abs(i6))) {
                m2378a(i, i4, z2 ? i2 : i, z2 ? i : i3, this.f1957l);
                return;
            } else {
                m2370e(i, i5, i4);
                return;
            }
        }
        Log.e("OverScroller", "startAfterEdge called from a valid position");
        this.f1956k = true;
    }

    private double m2361b(int i) {
        return Math.log((double) ((0.35f * ((float) Math.abs(i))) / (this.f1958m * this.f1960o)));
    }

    private double m2363c(int i) {
        return Math.exp(m2361b(i) * (((double) f1943p) / (((double) f1943p) - 1.0d))) * ((double) (this.f1958m * this.f1960o));
    }

    private int m2365d(int i) {
        return (int) (Math.exp(m2361b(i) / (((double) f1943p) - 1.0d)) * 1000.0d);
    }

    private void m2367d() {
        float abs = ((float) (this.f1949d * this.f1949d)) / (Math.abs(this.f1951f) * 2.0f);
        float signum = Math.signum((float) this.f1949d);
        if (abs > ((float) this.f1957l)) {
            this.f1951f = (((-signum) * ((float) this.f1949d)) * ((float) this.f1949d)) / (((float) this.f1957l) * 2.0f);
            abs = (float) this.f1957l;
        }
        this.f1957l = (int) abs;
        this.f1959n = 2;
        int i = this.f1946a;
        if (this.f1949d <= 0) {
            abs = -abs;
        }
        this.f1948c = ((int) abs) + i;
        this.f1953h = -((int) ((1000.0f * ((float) this.f1949d)) / this.f1951f));
    }

    private void m2368d(int i, int i2, int i3) {
        float abs = Math.abs(((float) (i3 - i)) / ((float) (i2 - i)));
        int i4 = (int) (100.0f * abs);
        if (i4 < 100) {
            float f = ((float) i4) / 100.0f;
            float f2 = ((float) (i4 + 1)) / 100.0f;
            float f3 = f1945r[i4];
            this.f1953h = (int) (((((abs - f) / (f2 - f)) * (f1945r[i4 + 1] - f3)) + f3) * ((float) this.f1953h));
        }
    }

    private void m2370e(int i, int i2, int i3) {
        this.f1956k = false;
        this.f1959n = 1;
        this.f1946a = i;
        this.f1948c = i2;
        int i4 = i - i2;
        this.f1951f = m2358a(i4);
        this.f1949d = -i4;
        this.f1957l = Math.abs(i4);
        this.f1953h = (int) (1000.0d * Math.sqrt((-2.0d * ((double) i4)) / ((double) this.f1951f)));
    }

    private void m2372f(int i, int i2, int i3) {
        float sqrt = (float) Math.sqrt((((double) (((((float) (i3 * i3)) / 2.0f) / Math.abs(this.f1951f)) + ((float) Math.abs(i2 - i)))) * 2.0d) / ((double) Math.abs(this.f1951f)));
        this.f1952g -= (long) ((int) ((sqrt - (((float) (-i3)) / this.f1951f)) * 1000.0f));
        this.f1946a = i2;
        this.f1949d = (int) ((-this.f1951f) * sqrt);
    }

    private void m2374g(int i, int i2, int i3) {
        this.f1951f = m2358a(i3 == 0 ? i - i2 : i3);
        m2372f(i, i2, i3);
        m2367d();
    }

    void m2375a() {
        this.f1947b = this.f1948c;
        this.f1956k = true;
    }

    void m2376a(float f) {
        this.f1958m = f;
    }

    void m2377a(int i, int i2, int i3) {
        this.f1956k = false;
        this.f1946a = i;
        this.f1948c = i + i2;
        this.f1952g = AnimationUtils.currentAnimationTimeMillis();
        this.f1953h = i3;
        this.f1951f = 0.0f;
        this.f1949d = 0;
    }

    void m2378a(int i, int i2, int i3, int i4, int i5) {
        this.f1957l = i5;
        this.f1956k = false;
        this.f1949d = i2;
        this.f1950e = (float) i2;
        this.f1954i = 0;
        this.f1953h = 0;
        this.f1952g = AnimationUtils.currentAnimationTimeMillis();
        this.f1946a = i;
        this.f1947b = i;
        if (i > i4 || i < i3) {
            m2359a(i, i3, i4, i2);
            return;
        }
        this.f1959n = 0;
        double d = 0.0d;
        if (i2 != 0) {
            int d2 = m2365d(i2);
            this.f1954i = d2;
            this.f1953h = d2;
            d = m2363c(i2);
        }
        this.f1955j = (int) (d * ((double) Math.signum((float) i2)));
        this.f1948c = this.f1955j + i;
        if (this.f1948c < i3) {
            m2368d(this.f1946a, this.f1948c, i3);
            this.f1948c = i3;
        }
        if (this.f1948c > i4) {
            m2368d(this.f1946a, this.f1948c, i4);
            this.f1948c = i4;
        }
    }

    void m2379b(float f) {
        this.f1947b = this.f1946a + Math.round(((float) (this.f1948c - this.f1946a)) * f);
    }

    boolean m2380b() {
        switch (this.f1959n) {
            case cm.HListView_android_entries /*0*/:
                if (this.f1953h < this.f1954i) {
                    this.f1946a = this.f1948c;
                    this.f1949d = (int) this.f1950e;
                    this.f1951f = m2358a(this.f1949d);
                    this.f1952g += (long) this.f1953h;
                    m2367d();
                    break;
                }
                return false;
            case cm.HListView_android_divider /*1*/:
                return false;
            case cm.HListView_hlv_dividerWidth /*2*/:
                this.f1952g += (long) this.f1953h;
                m2370e(this.f1948c, this.f1946a, 0);
                break;
        }
        m2383c();
        return true;
    }

    boolean m2381b(int i, int i2, int i3) {
        this.f1956k = true;
        this.f1948c = i;
        this.f1946a = i;
        this.f1949d = 0;
        this.f1952g = AnimationUtils.currentAnimationTimeMillis();
        this.f1953h = 0;
        if (i < i2) {
            m2370e(i, i2, 0);
        } else if (i > i3) {
            m2370e(i, i3, 0);
        }
        return !this.f1956k;
    }

    void m2382c(int i, int i2, int i3) {
        if (this.f1959n == 0) {
            this.f1957l = i3;
            this.f1952g = AnimationUtils.currentAnimationTimeMillis();
            m2359a(i, i2, i2, (int) this.f1950e);
        }
    }

    boolean m2383c() {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.f1952g;
        if (currentAnimationTimeMillis > ((long) this.f1953h)) {
            return false;
        }
        double d = 0.0d;
        float f;
        float f2;
        float f3;
        switch (this.f1959n) {
            case cm.HListView_android_entries /*0*/:
                f = ((float) currentAnimationTimeMillis) / ((float) this.f1954i);
                int i = (int) (100.0f * f);
                float f4 = 1.0f;
                f2 = 0.0f;
                if (i < 100) {
                    f4 = ((float) i) / 100.0f;
                    f2 = ((float) (i + 1)) / 100.0f;
                    f3 = f1944q[i];
                    f2 = (f1944q[i + 1] - f3) / (f2 - f4);
                    f4 = ((f - f4) * f2) + f3;
                }
                double d2 = (double) (f4 * ((float) this.f1955j));
                this.f1950e = ((f2 * ((float) this.f1955j)) / ((float) this.f1954i)) * 1000.0f;
                d = d2;
                break;
            case cm.HListView_android_divider /*1*/:
                f = ((float) currentAnimationTimeMillis) / ((float) this.f1953h);
                float f5 = f * f;
                f3 = Math.signum((float) this.f1949d);
                d = (double) ((((float) this.f1957l) * f3) * ((3.0f * f5) - ((2.0f * f) * f5)));
                this.f1950e = ((-f) + f5) * ((f3 * ((float) this.f1957l)) * 6.0f);
                break;
            case cm.HListView_hlv_dividerWidth /*2*/:
                f2 = ((float) currentAnimationTimeMillis) / 1000.0f;
                this.f1950e = ((float) this.f1949d) + (this.f1951f * f2);
                d = (double) (((f2 * (this.f1951f * f2)) / 2.0f) + (((float) this.f1949d) * f2));
                break;
        }
        this.f1947b = ((int) Math.round(d)) + this.f1946a;
        return true;
    }
}
