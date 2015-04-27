package it.sephiroth.android.library.widget;

import android.content.Context;
import android.util.FloatMath;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.google.android.apps.androidify.cm;

public class as {
    private static float f1936f;
    private static float f1937g;
    private int f1938a;
    private final at f1939b;
    private final at f1940c;
    private Interpolator f1941d;
    private final boolean f1942e;

    static {
        f1936f = 8.0f;
        f1937g = 1.0f;
        f1937g = 1.0f / m2344a(1.0f);
    }

    public as(Context context) {
        this(context, null);
    }

    public as(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public as(Context context, Interpolator interpolator, boolean z) {
        this.f1941d = interpolator;
        this.f1942e = z;
        this.f1939b = new at(context);
        this.f1940c = new at(context);
    }

    public static float m2344a(float f) {
        float f2 = f1936f * f;
        return (f2 < 1.0f ? f2 - (1.0f - ((float) Math.exp((double) (-f2)))) : ((1.0f - ((float) Math.exp((double) (1.0f - f2)))) * (1.0f - 0.36787945f)) + 0.36787945f) * f1937g;
    }

    public void m2345a(int i, int i2, int i3) {
        this.f1939b.m2382c(i, i2, i3);
    }

    public void m2346a(int i, int i2, int i3, int i4, int i5) {
        this.f1938a = 0;
        this.f1939b.m2377a(i, i3, i5);
        this.f1940c.m2377a(i2, i4, i5);
    }

    public void m2347a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        m2348a(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void m2348a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.f1942e && !m2350a()) {
            float c = this.f1939b.f1950e;
            float c2 = this.f1940c.f1950e;
            if (Math.signum((float) i3) == Math.signum(c) && Math.signum((float) i4) == Math.signum(c2)) {
                i4 = (int) (((float) i4) + c2);
                i11 = (int) (c + ((float) i3));
                this.f1938a = 1;
                this.f1939b.m2378a(i, i11, i5, i6, i9);
                this.f1940c.m2378a(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.f1938a = 1;
        this.f1939b.m2378a(i, i11, i5, i6, i9);
        this.f1940c.m2378a(i2, i4, i7, i8, i10);
    }

    void m2349a(Interpolator interpolator) {
        this.f1941d = interpolator;
    }

    public final boolean m2350a() {
        return this.f1939b.f1956k && this.f1940c.f1956k;
    }

    public boolean m2351a(float f, float f2) {
        return !m2350a() && Math.signum(f) == Math.signum((float) (this.f1939b.f1948c - this.f1939b.f1946a)) && Math.signum(f2) == Math.signum((float) (this.f1940c.f1948c - this.f1940c.f1946a));
    }

    public boolean m2352a(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f1938a = 1;
        return this.f1939b.m2381b(i, i3, i4) || this.f1940c.m2381b(i2, i5, i6);
    }

    public final int m2353b() {
        return this.f1939b.f1947b;
    }

    public final void m2354b(float f) {
        this.f1939b.m2376a(f);
        this.f1940c.m2376a(f);
    }

    public float m2355c() {
        return FloatMath.sqrt((this.f1939b.f1950e * this.f1939b.f1950e) + (this.f1940c.f1950e * this.f1940c.f1950e));
    }

    public boolean m2356d() {
        if (m2350a()) {
            return false;
        }
        switch (this.f1938a) {
            case cm.HListView_android_entries /*0*/:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.f1939b.f1952g;
                int f = this.f1939b.f1953h;
                if (currentAnimationTimeMillis >= ((long) f)) {
                    m2357e();
                    break;
                }
                float f2 = ((float) currentAnimationTimeMillis) / ((float) f);
                f2 = this.f1941d == null ? m2344a(f2) : this.f1941d.getInterpolation(f2);
                this.f1939b.m2379b(f2);
                this.f1940c.m2379b(f2);
                break;
            case cm.HListView_android_divider /*1*/:
                if (!(this.f1939b.f1956k || this.f1939b.m2383c() || this.f1939b.m2380b())) {
                    this.f1939b.m2375a();
                }
                if (!(this.f1940c.f1956k || this.f1940c.m2383c() || this.f1940c.m2380b())) {
                    this.f1940c.m2375a();
                    break;
                }
        }
        return true;
    }

    public void m2357e() {
        this.f1939b.m2375a();
        this.f1940c.m2375a();
    }
}
