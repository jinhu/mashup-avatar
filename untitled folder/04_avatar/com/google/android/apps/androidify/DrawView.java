package com.google.android.apps.androidify;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.apps.androidify.a.e;

public class DrawView extends View {
    private ba a;
    private az b;
    private cj c;
    private e d;
    private e e;
    private int f;
    private boolean g;
    private boolean h;
    private float i;
    private float j;
    private int k;
    private int l;
    private float m;
    private double n;
    private double o;
    private float p;
    private long q;
    private long r;
    private double s;
    private double t;

    public DrawView(Context context) {
        super(context);
        this.b = null;
        this.c = null;
        this.d = null;
        this.g = false;
        this.h = false;
        this.n = -1.0d;
        this.o = -1.0d;
        this.p = 0.0f;
        this.q = 0;
        this.r = 0;
        this.s = 0.0d;
        this.t = 0.0d;
        a(context, null);
    }

    public DrawView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = null;
        this.c = null;
        this.d = null;
        this.g = false;
        this.h = false;
        this.n = -1.0d;
        this.o = -1.0d;
        this.p = 0.0f;
        this.q = 0;
        this.r = 0;
        this.s = 0.0d;
        this.t = 0.0d;
        a(context, attributeSet);
    }

    public DrawView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = null;
        this.c = null;
        this.d = null;
        this.g = false;
        this.h = false;
        this.n = -1.0d;
        this.o = -1.0d;
        this.p = 0.0f;
        this.q = 0;
        this.r = 0;
        this.s = 0.0d;
        this.t = 0.0d;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.r = System.currentTimeMillis();
        this.l = context.getResources().getColor(R.color.bg_droidview_progress);
        this.j = c.a(context, 16.0f);
        c.a("Get assets...");
        ah a = ah.a(context);
        c();
        getViewTreeObserver().addOnGlobalLayoutListener(new am(this, a));
    }

    private void c() {
        long currentTimeMillis = System.currentTimeMillis();
        c.a("- Elapsed: " + (currentTimeMillis - this.r));
        this.r = currentTimeMillis;
    }

    public void a() {
        this.a.a(getWidth(), getHeight());
        this.a.d();
    }

    public boolean b() {
        return this.g;
    }

    protected void onDraw(Canvas canvas) {
        float f = 1.0f;
        super.onDraw(canvas);
        if (this.k > 0) {
            Paint paint = new Paint();
            paint.setColor(this.l);
            canvas.drawRect(this.p, (((float) getHeight()) - this.j) - this.p, this.i + this.p, ((float) getHeight()) - this.p, paint);
            this.a.a(this.e, (double) this.m);
        }
        if (this.e == null) {
            this.a.f();
        } else if (!this.g) {
            if (this.t == 0.0d) {
                this.t = (double) System.currentTimeMillis();
            } else {
                this.n = ((double) System.currentTimeMillis()) - this.t;
                while (this.n > this.e.b()) {
                    this.n -= this.e.b();
                    this.t += this.e.b();
                }
            }
        }
        if (this.h) {
            this.n = 0.0d;
        }
        if (this.n > -1.0d && this.e != null && this.k == 0) {
            if (this.d != null) {
                long currentTimeMillis = System.currentTimeMillis() - this.q;
                if (currentTimeMillis > 600) {
                    this.d = null;
                } else {
                    f = by.b((float) currentTimeMillis, 0.0f, 600.0f, 0.0f, 1.0f);
                    this.o = ((double) System.currentTimeMillis()) - this.s;
                    while (this.o > this.d.b()) {
                        this.o -= this.d.b();
                        this.s += this.d.b();
                    }
                }
            }
            this.a.a(this.e, this.n, this.d, this.o, f);
        }
        this.a.a(canvas, (float) getWidth(), (float) getHeight());
        if (this.e != null && !this.g) {
            invalidate();
        }
    }

    public void setDroidConfig(az azVar) {
        if (this.a == null) {
            this.a = new ba(getContext());
            this.a.b(0.75f);
        }
        this.a.a(azVar, ah.a(getContext()));
    }

    public void setDroidDrawer(ba baVar) {
        this.a = baVar;
    }

    public void setGlobalMotionFactor(float f) {
        if (this.a != null) {
            this.a.c(f);
        }
    }

    public void setIndex(int i) {
        this.f = i;
    }

    public void setMotion(e eVar) {
        if (this.e != eVar) {
            c.a("Setting motion for index = " + this.f + ", null? " + (eVar == null));
            this.s = this.t;
            this.d = this.e;
            this.q = System.currentTimeMillis();
            this.t = (double) this.q;
            this.e = eVar;
            invalidate();
        }
    }

    public void setPaused(boolean z) {
        this.g = z;
        if (!z) {
            this.h = false;
            invalidate();
        }
    }

    public void setPose(cj cjVar) {
        this.c = cjVar;
    }

    public void setProgress(int i) {
        this.k = i;
        this.i = (float) ((int) by.a((float) i, 0.0f, 100.0f, 0.0f, ((float) getWidth()) - (2.0f * this.p)));
        this.m = by.a((float) i, 0.0f, 100.0f, 0.0f, (float) this.e.b());
        invalidate();
    }

    public void setProgressInset(int i) {
        this.p = c.a(getContext(), (float) i);
    }

    public void setShowPoster(boolean z) {
        this.h = z;
    }
}
