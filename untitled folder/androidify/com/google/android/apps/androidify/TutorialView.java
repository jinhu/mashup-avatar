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
import com.google.android.apps.p017c.C0257d;
import java.util.ArrayList;
import java.util.List;

public class TutorialView extends View {
    private static final Interpolator f947a;
    private static final Interpolator f948b;
    private List f949c;
    private int f950d;
    private int f951e;
    private float f952f;
    private Bitmap[] f953g;
    private Paint f954h;
    private dn f955i;
    private float f956j;
    private float f957k;
    private float f958l;
    private long f959m;
    private long f960n;
    private boolean f961o;

    static {
        f947a = new C0257d();
        f948b = new AccelerateInterpolator();
    }

    public TutorialView(Context context) {
        super(context);
        this.f950d = 0;
        this.f951e = 0;
        this.f955i = dn.FADING_IN;
        this.f958l = -2.14748365E9f;
        this.f959m = 0;
        this.f960n = 0;
        this.f961o = false;
        m1587a(context, null);
    }

    public TutorialView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f950d = 0;
        this.f951e = 0;
        this.f955i = dn.FADING_IN;
        this.f958l = -2.14748365E9f;
        this.f959m = 0;
        this.f960n = 0;
        this.f961o = false;
        m1587a(context, attributeSet);
    }

    public TutorialView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f950d = 0;
        this.f951e = 0;
        this.f955i = dn.FADING_IN;
        this.f958l = -2.14748365E9f;
        this.f959m = 0;
        this.f960n = 0;
        this.f961o = false;
        m1587a(context, attributeSet);
    }

    public void m1584a(float f, float f2, dm dmVar, String str, boolean z) {
        this.f949c.add(new C0222do(f, f2, dmVar, str, z));
        invalidate();
    }

    public void m1585a(float f, float f2, dm dmVar, String str, boolean z, float f3, int i) {
        C0222do c0222do = new C0222do(f, f2, dmVar, str, z);
        c0222do.f1628c = f3;
        c0222do.f1634i = i;
        c0222do.f1633h = i;
        this.f949c.add(c0222do);
        invalidate();
    }

    public void m1586a(int i, float f, float f2) {
        C0222do c0222do = (C0222do) this.f949c.get(i);
        c0222do.f1626a = f;
        c0222do.f1627b = f2;
        invalidate();
    }

    public void m1587a(Context context, AttributeSet attributeSet) {
        this.f952f = getResources().getDimension(R.dimen.tutorial_arrow_distance);
        this.f956j = getResources().getDimension(R.dimen.tutorial_text_size);
        this.f957k = getResources().getDimension(R.dimen.tutorial_text_baseline);
        this.f954h = new Paint();
        this.f954h.setAntiAlias(true);
        this.f954h.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/and_black.ttf"));
        this.f954h.setTextSize(this.f956j);
        this.f954h.setColor(al.f1191b.intValue());
        this.f949c = new ArrayList();
        this.f953g = new Bitmap[dm.values().length];
        for (int i = 0; i < dm.values().length; i++) {
            this.f953g[i] = BitmapFactory.decodeResource(getResources(), dm.values()[i].f1620f);
        }
    }

    public void m1588a(boolean z) {
        if (!z && (this.f955i == dn.OUT || this.f955i == dn.FADING_OUT)) {
            return;
        }
        if (!z || (this.f955i != dn.FADING_IN && this.f955i != dn.IN)) {
            if (z) {
                if (this.f951e > this.f950d) {
                    this.f950d = this.f951e;
                    this.f958l = -2.14748365E9f;
                }
                this.f955i = dn.FADING_IN;
            } else {
                this.f955i = dn.FADING_OUT;
            }
            this.f960n = System.currentTimeMillis();
            invalidate();
        }
    }

    public boolean m1589a() {
        if (this.f950d == this.f949c.size() - 1) {
            return true;
        }
        this.f951e = this.f950d + 1;
        m1588a(false);
        invalidate();
        return false;
    }

    public void m1590b() {
        if (this.f949c.size() > 0) {
            C0222do c0222do = (C0222do) this.f949c.get(this.f950d);
            c0222do.f1634i--;
            if (c0222do.f1634i == 0) {
                c0222do.f1632g = true;
                invalidate();
            }
        }
    }

    public boolean m1591c() {
        return this.f949c.size() > 0 ? ((C0222do) this.f949c.get(this.f951e)).f1632g : false;
    }

    public boolean m1592d() {
        if (this.f949c.size() <= 0) {
            return false;
        }
        C0222do c0222do = (C0222do) this.f949c.get(this.f951e);
        return c0222do.f1632g || c0222do.f1633h > c0222do.f1634i;
    }

    public boolean m1593e() {
        return ((C0222do) this.f949c.get(this.f951e)).f1631f;
    }

    public int getStepCount() {
        return this.f949c.size();
    }

    public int getStepIndex() {
        return this.f951e;
    }

    protected void onDraw(Canvas canvas) {
        long j = 0;
        float f = 0.0f;
        super.onDraw(canvas);
        if (this.f959m == 0) {
            this.f959m = System.currentTimeMillis();
        }
        if (!this.f949c.isEmpty()) {
            float a;
            C0222do c0222do;
            Bitmap bitmap;
            float a2;
            float f2;
            float height;
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = currentTimeMillis - this.f960n;
            if (this.f955i == dn.FADING_IN) {
                if (j2 > 1800) {
                    this.f955i = dn.IN;
                }
            } else if (this.f955i == dn.FADING_OUT && j2 > 300) {
                this.f955i = dn.OUT;
            }
            if (this.f955i == dn.OUT && this.f951e > this.f950d) {
                this.f950d = this.f951e;
                this.f958l = -2.14748365E9f;
                if (!this.f961o) {
                    this.f955i = dn.FADING_IN;
                    this.f960n = currentTimeMillis;
                    if (this.f955i == dn.FADING_IN) {
                        a = by.m1899a((float) j, 0.0f, 1800.0f, 0.0f, 1.0f, f947a);
                    } else if (this.f955i != dn.FADING_OUT) {
                        a = by.m1899a((float) j, 0.0f, 300.0f, 1.0f, 0.0f, f948b);
                    } else {
                        a = 1.0f;
                    }
                    c0222do = (C0222do) this.f949c.get(this.f950d);
                    if (this.f955i != dn.OUT) {
                        canvas.save();
                        bitmap = this.f953g[c0222do.f1629d.ordinal()];
                        a2 = (by.m1900a(System.currentTimeMillis() - this.f959m, 1250.0f) * this.f952f) / 3.0f;
                        switch (dl.f1613a[c0222do.f1629d.ordinal()]) {
                            case cm.HListView_android_divider /*1*/:
                                f2 = (c0222do.f1626a + this.f952f) + a2;
                                f = c0222do.f1627b - (((float) bitmap.getHeight()) / 2.0f);
                                break;
                            case cm.HListView_hlv_dividerWidth /*2*/:
                                f2 = ((c0222do.f1626a - this.f952f) - ((float) bitmap.getWidth())) + a2;
                                f = c0222do.f1627b - (((float) bitmap.getHeight()) / 2.0f);
                                break;
                            case cm.HListView_hlv_headerDividersEnabled /*3*/:
                                f2 = c0222do.f1626a - (((float) bitmap.getWidth()) / 2.0f);
                                f = (c0222do.f1627b + this.f952f) + a2;
                                break;
                            case cm.HListView_hlv_footerDividersEnabled /*4*/:
                                f2 = c0222do.f1626a - (((float) bitmap.getWidth()) / 2.0f);
                                f = ((c0222do.f1627b - this.f952f) - ((float) bitmap.getHeight())) + a2;
                                break;
                            case cm.HListView_hlv_overScrollHeader /*5*/:
                                f2 = (c0222do.f1626a + this.f952f) + a2;
                                f = (c0222do.f1627b + this.f952f) + a2;
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
                        canvas.drawBitmap(bitmap, f2, f, this.f954h);
                        canvas.restore();
                        canvas.save();
                        if (this.f958l == -2.14748365E9f) {
                            this.f958l = (((float) getWidth()) - this.f954h.measureText(c0222do.f1630e)) / 2.0f;
                        }
                        f = (float) (getWidth() / 2);
                        f2 = (((float) getHeight()) - this.f957k) - c0222do.f1628c;
                        if (a < 1.0f) {
                            canvas.scale(a, a, f, f2);
                        }
                        canvas.drawText(c0222do.f1630e, this.f958l, (((float) getHeight()) - this.f957k) - c0222do.f1628c, this.f954h);
                        canvas.restore();
                    }
                    invalidate();
                }
            }
            j = j2;
            if (this.f955i == dn.FADING_IN) {
                a = by.m1899a((float) j, 0.0f, 1800.0f, 0.0f, 1.0f, f947a);
            } else if (this.f955i != dn.FADING_OUT) {
                a = 1.0f;
            } else {
                a = by.m1899a((float) j, 0.0f, 300.0f, 1.0f, 0.0f, f948b);
            }
            c0222do = (C0222do) this.f949c.get(this.f950d);
            if (this.f955i != dn.OUT) {
                canvas.save();
                bitmap = this.f953g[c0222do.f1629d.ordinal()];
                a2 = (by.m1900a(System.currentTimeMillis() - this.f959m, 1250.0f) * this.f952f) / 3.0f;
                switch (dl.f1613a[c0222do.f1629d.ordinal()]) {
                    case cm.HListView_android_divider /*1*/:
                        f2 = (c0222do.f1626a + this.f952f) + a2;
                        f = c0222do.f1627b - (((float) bitmap.getHeight()) / 2.0f);
                        break;
                    case cm.HListView_hlv_dividerWidth /*2*/:
                        f2 = ((c0222do.f1626a - this.f952f) - ((float) bitmap.getWidth())) + a2;
                        f = c0222do.f1627b - (((float) bitmap.getHeight()) / 2.0f);
                        break;
                    case cm.HListView_hlv_headerDividersEnabled /*3*/:
                        f2 = c0222do.f1626a - (((float) bitmap.getWidth()) / 2.0f);
                        f = (c0222do.f1627b + this.f952f) + a2;
                        break;
                    case cm.HListView_hlv_footerDividersEnabled /*4*/:
                        f2 = c0222do.f1626a - (((float) bitmap.getWidth()) / 2.0f);
                        f = ((c0222do.f1627b - this.f952f) - ((float) bitmap.getHeight())) + a2;
                        break;
                    case cm.HListView_hlv_overScrollHeader /*5*/:
                        f2 = (c0222do.f1626a + this.f952f) + a2;
                        f = (c0222do.f1627b + this.f952f) + a2;
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
                canvas.drawBitmap(bitmap, f2, f, this.f954h);
                canvas.restore();
                canvas.save();
                if (this.f958l == -2.14748365E9f) {
                    this.f958l = (((float) getWidth()) - this.f954h.measureText(c0222do.f1630e)) / 2.0f;
                }
                f = (float) (getWidth() / 2);
                f2 = (((float) getHeight()) - this.f957k) - c0222do.f1628c;
                if (a < 1.0f) {
                    canvas.scale(a, a, f, f2);
                }
                canvas.drawText(c0222do.f1630e, this.f958l, (((float) getHeight()) - this.f957k) - c0222do.f1628c, this.f954h);
                canvas.restore();
            }
            invalidate();
        }
    }

    public void setHidden(boolean z) {
        this.f961o = z;
        if (z && (this.f955i == dn.IN || this.f955i == dn.FADING_IN)) {
            m1588a(false);
        } else if (!z) {
            if (this.f955i == dn.OUT || this.f955i == dn.FADING_OUT) {
                m1588a(true);
            }
        }
    }
}
