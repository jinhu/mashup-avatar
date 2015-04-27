package com.google.android.apps.androidify;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.google.android.apps.androidify.p018a.AnimationCatalogue;

import dev.game.legend.avatar.R;

public class DrawView extends View {
    private AndroidDrawer f799a;
//    private az f800b;
//    private cj f801c;
    private AnimationCatalogue f802d;
    private AnimationCatalogue f803e;
    private int f804f;
    private boolean f805g;
    private boolean f806h;
    private float f807i;
    private float f808j;
    private int f809k;
    private int f810l;
    private float f811m;
    private double f812n;
    private double f813o;
    private float f814p;
    private long f815q;
    private long mStartTime;
    private double f817s;
    private double f818t;
    public AndroidDrawer mAndroidDrawer;
    public AndroidConfig f800b;

    public DrawView(Context context) {
        super(context);
        this.f800b = null;
        //this.f801c = null;
        this.f802d = null;
        this.f805g = false;
        this.f806h = false;
        this.f812n = -1.0d;
        this.f813o = -1.0d;
        this.f814p = 0.0f;
        this.f815q = 0;
        this.mStartTime = 0;
        this.f817s = 0.0d;
        this.f818t = 0.0d;
        m1422a(context, null);
    }

    public DrawView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f800b = null;
        //this.f801c = null;
        this.f802d = null;
        this.f805g = false;
        this.f806h = false;
        this.f812n = -1.0d;
        this.f813o = -1.0d;
        this.f814p = 0.0f;
        this.f815q = 0;
        this.mStartTime = 0;
        this.f817s = 0.0d;
        this.f818t = 0.0d;
        m1422a(context, attributeSet);
    }

    public DrawView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f800b = null;
        //this.f801c = null;
        this.f802d = null;
        this.f805g = false;
        this.f806h = false;
        this.f812n = -1.0d;
        this.f813o = -1.0d;
        this.f814p = 0.0f;
        this.f815q = 0;
        this.mStartTime = 0;
        this.f817s = 0.0d;
        this.f818t = 0.0d;
        m1422a(context, attributeSet);
    }

    private void m1422a(Context context, AttributeSet attributeSet) {
        this.mStartTime = System.currentTimeMillis();
        this.f810l = context.getResources().getColor(R.color.bg_droidview_progress);
        this.f808j = Util.performance(context, 16.0f);
        Util.debug("Get assets...");
        AssetDatabase a = AssetDatabase.instance(context);
        initStartTime();
        getViewTreeObserver().addOnGlobalLayoutListener(new am(this, a));
    }

    void initStartTime() {
        long currentTimeMillis = System.currentTimeMillis();
        Util.debug("- Elapsed: " + (currentTimeMillis - this.mStartTime));
        this.mStartTime = currentTimeMillis;
    }

    public void m1426a() {
        this.mAndroidDrawer.m1835a(getWidth(), getHeight());
        this.mAndroidDrawer.m1855d();
    }

    public boolean m1427b() {
        return this.f805g;
    }

    protected void onDraw(Canvas canvas) {
        float f = 1.0f;
        super.onDraw(canvas);
        if (this.f809k > 0) {
            Paint paint = new Paint();
            paint.setColor(this.f810l);
            canvas.drawRect(this.f814p, (((float) getHeight()) - this.f808j) - this.f814p, this.f807i + this.f814p, ((float) getHeight()) - this.f814p, paint);
            this.mAndroidDrawer.m1841a(this.f803e, (double) this.f811m);
        }
        if (this.f803e == null) {
            this.mAndroidDrawer.m1857f();
        } else if (!this.f805g) {
            if (this.f818t == 0.0d) {
                this.f818t = (double) System.currentTimeMillis();
            } else {
                this.f812n = ((double) System.currentTimeMillis()) - this.f818t;
                while (this.f812n > this.f803e.m1609b()) {
                    this.f812n -= this.f803e.m1609b();
                    this.f818t += this.f803e.m1609b();
                }
            }
        }
        if (this.f806h) {
            this.f812n = 0.0d;
        }
        if (this.f812n > -1.0d && this.f803e != null && this.f809k == 0) {
            if (this.f802d != null) {
                long currentTimeMillis = System.currentTimeMillis() - this.f815q;
                if (currentTimeMillis > 600) {
                    this.f802d = null;
                } else {
                    f = by.m1901b((float) currentTimeMillis, 0.0f, 600.0f, 0.0f, 1.0f);
                    this.f813o = ((double) System.currentTimeMillis()) - this.f817s;
                    while (this.f813o > this.f802d.m1609b()) {
                        this.f813o -= this.f802d.m1609b();
                        this.f817s += this.f802d.m1609b();
                    }
                }
            }
            this.mAndroidDrawer.m1842a(this.f803e, this.f812n, this.f802d, this.f813o, f);
        }
        this.mAndroidDrawer.m1838a(canvas, (float) getWidth(), (float) getHeight());
        if (this.f803e != null && !this.f805g) {
            invalidate();
        }
    }

    public void setDroidConfig(AndroidConfig aAndroidConfigVar) {
        if (this.mAndroidDrawer == null) {
            this.mAndroidDrawer = new AndroidDrawer(getContext());
            this.mAndroidDrawer.m1848b(0.75f);
        }
        this.mAndroidDrawer.setAndroidConfig(aAndroidConfigVar, AssetDatabase.instance(getContext()));
    }

    public void setDroidDrawer(AndroidDrawer aAndroidDrawerVar) {
        this.mAndroidDrawer = aAndroidDrawerVar;
    }

    public void setGlobalMotionFactor(float f) {
        if (this.mAndroidDrawer != null) {
            this.mAndroidDrawer.m1854c(f);
        }
    }

    public void setIndex(int i) {
        this.f804f = i;
    }

    public void setMotion(AnimationCatalogue aAnimationCatalogue) {
        if (this.f803e != aAnimationCatalogue) {
            Util.debug("Setting motion for index = " + this.f804f + ", null? " + (aAnimationCatalogue == null));
            this.f817s = this.f818t;
            this.f802d = this.f803e;
            this.f815q = System.currentTimeMillis();
            this.f818t = (double) this.f815q;
            this.f803e = aAnimationCatalogue;
            invalidate();
        }
    }

    public void setPaused(boolean z) {
        this.f805g = z;
        if (!z) {
            this.f806h = false;
            invalidate();
        }
    }

    public void setPose(cj cjVar) {
   //     this.f801c = cjVar;
    }

    public void setProgress(int i) {
        this.f809k = i;
        this.f807i = (float) ((int) by.m1898a((float) i, 0.0f, 100.0f, 0.0f, ((float) getWidth()) - (2.0f * this.f814p)));
        this.f811m = by.m1898a((float) i, 0.0f, 100.0f, 0.0f, (float) this.f803e.m1609b());
        invalidate();
    }

    public void setProgressInset(int i) {
        this.f814p = Util.performance(getContext(), (float) i);
    }

    public void setShowPoster(boolean z) {
        this.f806h = z;
    }
}
