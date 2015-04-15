package com.google.android.apps.androidify;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import com.google.android.apps.c.d;
import java.util.ArrayList;
import java.util.List;

public class TutorialView extends View {
    private static final Interpolator a;
    private static final Interpolator b;
    private List c;
    private int d;
    private int e;
    private float f;
    private Bitmap[] g;
    private Paint h;
    private dn i;
    private float j;
    private float k;
    private float l;
    private long m;
    private long n;
    private boolean o;

    static {
        a = new d();
        b = new AccelerateInterpolator();
    }

    public TutorialView(Context context) {
        super(context);
        this.d = 0;
        this.e = 0;
        this.i = dn.FADING_IN;
        this.l = -2.14748365E9f;
        this.m = 0;
        this.n = 0;
        this.o = false;
        a(context, null);
    }

    public TutorialView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 0;
        this.e = 0;
        this.i = dn.FADING_IN;
        this.l = -2.14748365E9f;
        this.m = 0;
        this.n = 0;
        this.o = false;
        a(context, attributeSet);
    }

    public TutorialView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = 0;
        this.e = 0;
        this.i = dn.FADING_IN;
        this.l = -2.14748365E9f;
        this.m = 0;
        this.n = 0;
        this.o = false;
        a(context, attributeSet);
    }

    public void a(float f, float f2, dm dmVar, String str, boolean z) {
        this.c.add(new do(f, f2, dmVar, str, z));
        invalidate();
    }

    public void a(float f, float f2, dm dmVar, String str, boolean z, float f3, int i) {
        do doVar = new do(f, f2, dmVar, str, z);
        doVar.c = f3;
        doVar.i = i;
        doVar.h = i;
        this.c.add(doVar);
        invalidate();
    }

    public void a(int i, float f, float f2) {
        do doVar = (do) this.c.get(i);
        doVar.a = f;
        doVar.b = f2;
        invalidate();
    }

    public void a(Context context, AttributeSet attributeSet) {
        this.f = getResources().getDimension(R.dimen.tutorial_arrow_distance);
        this.j = getResources().getDimension(R.dimen.tutorial_text_size);
        this.k = getResources().getDimension(R.dimen.tutorial_text_baseline);
        this.h = new Paint();
        this.h.setAntiAlias(true);
        this.h.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/and_black.ttf"));
        this.h.setTextSize(this.j);
        this.h.setColor(al.b.intValue());
        this.c = new ArrayList();
        this.g = new Bitmap[dm.values().length];
        for (int i = 0; i < dm.values().length; i++) {
            this.g[i] = BitmapFactory.decodeResource(getResources(), dm.values()[i].f);
        }
    }

    public void a(boolean z) {
        if (!z && (this.i == dn.OUT || this.i == dn.FADING_OUT)) {
            return;
        }
        if (!z || (this.i != dn.FADING_IN && this.i != dn.IN)) {
            if (z) {
                if (this.e > this.d) {
                    this.d = this.e;
                    this.l = -2.14748365E9f;
                }
                this.i = dn.FADING_IN;
            } else {
                this.i = dn.FADING_OUT;
            }
            this.n = System.currentTimeMillis();
            invalidate();
        }
    }

    public boolean a() {
        if (this.d == this.c.size() - 1) {
            return true;
        }
        this.e = this.d + 1;
        a(false);
        invalidate();
        return false;
    }

    public void b() {
        if (this.c.size() > 0) {
            do doVar = (do) this.c.get(this.d);
            doVar.i--;
            if (doVar.i == 0) {
                doVar.g = true;
                invalidate();
            }
        }
    }

    public boolean c() {
        return this.c.size() > 0 ? ((do) this.c.get(this.e)).g : false;
    }

    public boolean d() {
        if (this.c.size() <= 0) {
            return false;
        }
        do doVar = (do) this.c.get(this.e);
        return doVar.g || doVar.h > doVar.i;
    }

    public boolean e() {
        return ((do) this.c.get(this.e)).f;
    }

    public int getStepCount() {
        return this.c.size();
    }

    public int getStepIndex() {
        return this.e;
    }

    protected void onDraw(Canvas canvas) {
        long j = 0;
        float f = 0.0f;
        super.onDraw(canvas);
        if (this.m == 0) {
            this.m = System.currentTimeMillis();
        }
        if (!this.c.isEmpty()) {
            float a;
            do doVar;
            Bitmap bitmap;
            float a2;
            float f2;
            float height;
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = currentTimeMillis - this.n;
            if (this.i == dn.FADING_IN) {
                if (j2 > 1800) {
                    this.i = dn.IN;
                }
            } else if (this.i == dn.FADING_OUT && j2 > 300) {
                this.i = dn.OUT;
            }
            if (this.i == dn.OUT && this.e > this.d) {
                this.d = this.e;
                this.l = -2.14748365E9f;
                if (!this.o) {
                    this.i = dn.FADING_IN;
                    this.n = currentTimeMillis;
                    if (this.i == dn.FADING_IN) {
                        a = by.a((float) j, 0.0f, 1800.0f, 0.0f, 1.0f, a);
                    } else if (this.i != dn.FADING_OUT) {
                        a = by.a((float) j, 0.0f, 300.0f, 1.0f, 0.0f, b);
                    } else {
                        a = 1.0f;
                    }
                    doVar = (do) this.c.get(this.d);
                    if (this.i != dn.OUT) {
                        canvas.save();
                        bitmap = this.g[doVar.d.ordinal()];
                        a2 = (by.a(System.currentTimeMillis() - this.m, 1250.0f) * this.f) / 3.0f;
                        switch (dl.a[doVar.d.ordinal()]) {
                            case cm.HListView_android_divider /*1*/:
                                f2 = (doVar.a + this.f) + a2;
                                f = doVar.b - (((float) bitmap.getHeight()) / 2.0f);
                                break;
                            case cm.HListView_hlv_dividerWidth /*2*/:
                                f2 = ((doVar.a - this.f) - ((float) bitmap.getWidth())) + a2;
                                f = doVar.b - (((float) bitmap.getHeight()) / 2.0f);
                                break;
                            case cm.HListView_hlv_headerDividersEnabled /*3*/:
                                f2 = doVar.a - (((float) bitmap.getWidth()) / 2.0f);
                                f = (doVar.b + this.f) + a2;
                                break;
                            case cm.HListView_hlv_footerDividersEnabled /*4*/:
                                f2 = doVar.a - (((float) bitmap.getWidth()) / 2.0f);
                                f = ((doVar.b - this.f) - ((float) bitmap.getHeight())) + a2;
                                break;
                            case cm.HListView_hlv_overScrollHeader /*5*/:
                                f2 = (doVar.a + this.f) + a2;
                                f = (doVar.b + this.f) + a2;
                                break;
                            default:
                                f2 = 0.0f;
                                break;
                        }
                        a2 = (((float) bitmap.getWidth()) / 2.0f) + f2;
                        height = (((float) bitmap.getHeight()) / 2.0f) + f;
                        if (a < 1.0f) {
                            canvas.scale(a, a, a2, height);
                        }
                        canvas.drawBitmap(bitmap, f2, f, this.h);
                        canvas.restore();
                        canvas.save();
                        if (this.l == -2.14748365E9f) {
                            this.l = (((float) getWidth()) - this.h.measureText(doVar.e)) / 2.0f;
                        }
                        f = (float) (getWidth() / 2);
                        f2 = (((float) getHeight()) - this.k) - doVar.c;
                        if (a < 1.0f) {
                            canvas.scale(a, a, f, f2);
                        }
                        canvas.drawText(doVar.e, this.l, (((float) getHeight()) - this.k) - doVar.c, this.h);
                        canvas.restore();
                    }
                    invalidate();
                }
            }
            j = j2;
            if (this.i == dn.FADING_IN) {
                a = by.a((float) j, 0.0f, 1800.0f, 0.0f, 1.0f, a);
            } else if (this.i != dn.FADING_OUT) {
                a = 1.0f;
            } else {
                a = by.a((float) j, 0.0f, 300.0f, 1.0f, 0.0f, b);
            }
            doVar = (do) this.c.get(this.d);
            if (this.i != dn.OUT) {
                canvas.save();
                bitmap = this.g[doVar.d.ordinal()];
                a2 = (by.a(System.currentTimeMillis() - this.m, 1250.0f) * this.f) / 3.0f;
                switch (dl.a[doVar.d.ordinal()]) {
                    case cm.HListView_android_divider /*1*/:
                        f2 = (doVar.a + this.f) + a2;
                        f = doVar.b - (((float) bitmap.getHeight()) / 2.0f);
                        break;
                    case cm.HListView_hlv_dividerWidth /*2*/:
                        f2 = ((doVar.a - this.f) - ((float) bitmap.getWidth())) + a2;
                        f = doVar.b - (((float) bitmap.getHeight()) / 2.0f);
                        break;
                    case cm.HListView_hlv_headerDividersEnabled /*3*/:
                        f2 = doVar.a - (((float) bitmap.getWidth()) / 2.0f);
                        f = (doVar.b + this.f) + a2;
                        break;
                    case cm.HListView_hlv_footerDividersEnabled /*4*/:
                        f2 = doVar.a - (((float) bitmap.getWidth()) / 2.0f);
                        f = ((doVar.b - this.f) - ((float) bitmap.getHeight())) + a2;
                        break;
                    case cm.HListView_hlv_overScrollHeader /*5*/:
                        f2 = (doVar.a + this.f) + a2;
                        f = (doVar.b + this.f) + a2;
                        break;
                    default:
                        f2 = 0.0f;
                        break;
                }
                a2 = (((float) bitmap.getWidth()) / 2.0f) + f2;
                height = (((float) bitmap.getHeight()) / 2.0f) + f;
                if (a < 1.0f) {
                    canvas.scale(a, a, a2, height);
                }
                canvas.drawBitmap(bitmap, f2, f, this.h);
                canvas.restore();
                canvas.save();
                if (this.l == -2.14748365E9f) {
                    this.l = (((float) getWidth()) - this.h.measureText(doVar.e)) / 2.0f;
                }
                f = (float) (getWidth() / 2);
                f2 = (((float) getHeight()) - this.k) - doVar.c;
                if (a < 1.0f) {
                    canvas.scale(a, a, f, f2);
                }
                canvas.drawText(doVar.e, this.l, (((float) getHeight()) - this.k) - doVar.c, this.h);
                canvas.restore();
            }
            invalidate();
        }
    }

    public void setHidden(boolean z) {
        this.o = z;
        if (z && (this.i == dn.IN || this.i == dn.FADING_IN)) {
            a(false);
        } else if (!z) {
            if (this.i == dn.OUT || this.i == dn.FADING_OUT) {
                a(true);
            }
        }
    }
}
