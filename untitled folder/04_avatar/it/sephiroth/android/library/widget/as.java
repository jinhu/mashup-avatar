package it.sephiroth.android.library.widget;

import android.content.Context;
import android.util.FloatMath;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.google.android.apps.androidify.cm;

public class as {
    private static float f;
    private static float g;
    private int a;
    private final at b;
    private final at c;
    private Interpolator d;
    private final boolean e;

    static {
        f = 8.0f;
        g = 1.0f;
        g = 1.0f / a(1.0f);
    }

    public as(Context context) {
        this(context, null);
    }

    public as(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public as(Context context, Interpolator interpolator, boolean z) {
        this.d = interpolator;
        this.e = z;
        this.b = new at(context);
        this.c = new at(context);
    }

    public static float a(float f) {
        float f2 = f * f;
        return (f2 < 1.0f ? f2 - (1.0f - ((float) Math.exp((double) (-f2)))) : ((1.0f - ((float) Math.exp((double) (1.0f - f2)))) * (1.0f - 0.36787945f)) + 0.36787945f) * g;
    }

    public void a(int i, int i2, int i3) {
        this.b.c(i, i2, i3);
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        this.a = 0;
        this.b.a(i, i3, i5);
        this.c.a(i2, i4, i5);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        a(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.e && !a()) {
            float c = this.b.e;
            float c2 = this.c.e;
            if (Math.signum((float) i3) == Math.signum(c) && Math.signum((float) i4) == Math.signum(c2)) {
                i4 = (int) (((float) i4) + c2);
                i11 = (int) (c + ((float) i3));
                this.a = 1;
                this.b.a(i, i11, i5, i6, i9);
                this.c.a(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.a = 1;
        this.b.a(i, i11, i5, i6, i9);
        this.c.a(i2, i4, i7, i8, i10);
    }

    void a(Interpolator interpolator) {
        this.d = interpolator;
    }

    public final boolean a() {
        return this.b.k && this.c.k;
    }

    public boolean a(float f, float f2) {
        return !a() && Math.signum(f) == Math.signum((float) (this.b.c - this.b.a)) && Math.signum(f2) == Math.signum((float) (this.c.c - this.c.a));
    }

    public boolean a(int i, int i2, int i3, int i4, int i5, int i6) {
        this.a = 1;
        return this.b.b(i, i3, i4) || this.c.b(i2, i5, i6);
    }

    public final int b() {
        return this.b.b;
    }

    public final void b(float f) {
        this.b.a(f);
        this.c.a(f);
    }

    public float c() {
        return FloatMath.sqrt((this.b.e * this.b.e) + (this.c.e * this.c.e));
    }

    public boolean d() {
        if (a()) {
            return false;
        }
        switch (this.a) {
            case cm.HListView_android_entries /*0*/:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.b.g;
                int f = this.b.h;
                if (currentAnimationTimeMillis >= ((long) f)) {
                    e();
                    break;
                }
                float f2 = ((float) currentAnimationTimeMillis) / ((float) f);
                f2 = this.d == null ? a(f2) : this.d.getInterpolation(f2);
                this.b.b(f2);
                this.c.b(f2);
                break;
            case cm.HListView_android_divider /*1*/:
                if (!(this.b.k || this.b.c() || this.b.b())) {
                    this.b.a();
                }
                if (!(this.c.k || this.c.c() || this.c.b())) {
                    this.c.a();
                    break;
                }
        }
        return true;
    }

    public void e() {
        this.b.a();
        this.c.a();
    }
}
