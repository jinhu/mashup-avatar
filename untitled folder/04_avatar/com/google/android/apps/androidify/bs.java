package com.google.android.apps.androidify;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;

public class bs extends DroidView {
    private float f;
    private float g;
    private Paint h;
    private Paint i;
    private Paint j;
    private String k;
    private Rect l;
    private RectF m;
    private float n;
    private int o;
    private float p;
    private float q;
    private boolean r;
    private float s;

    public bs(Androidify androidify, Picture picture, Picture picture2, Picture picture3, Picture picture4, Picture picture5, Picture picture6, int i, float f) {
        super(androidify);
        this.g = 0.0f;
        this.k = "";
        this.l = new Rect();
        this.m = new RectF();
        this.r = true;
        a(androidify, picture, picture2, picture3, picture4, picture5, picture6);
        androidify.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        setBackgroundColor(0);
        this.o = i;
        this.s = f;
        this.c = false;
        setOnGround(true);
        this.h = new Paint(129);
        this.h.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        this.h.setTextSize(24.0f);
        this.h.setStrokeWidth(2.0f);
        this.h.setColor(-16777216);
        this.i = new Paint(this.h);
        this.n = (float) ((a.nextDouble() * 3.141592653589793d) * 2.0d);
        this.j = new Paint(129);
        this.j.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        this.j.setTextSize(24.0f);
    }

    public static float a(Androidify androidify, int i, int i2, float f) {
        float f2 = 1.5f;
        int i3 = (int) (24.0f * f);
        if (i > i2) {
            i3 = (i3 * 3) / 4;
        } else {
            f2 = 2.0f;
        }
        Paint paint = new Paint(129);
        paint.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        paint.setTextSize((float) i3);
        return (((-paint.getFontMetrics().ascent) * (f2 + 1.0f)) + 4.0f) + 2.0f;
    }

    protected float a(int i) {
        return this.b.c().a(i, this.n);
    }

    public void a(int i, int i2) {
        this.g = -this.j.getFontMetrics().ascent;
        this.q = ((float) (i - this.l.width())) / 2.0f;
        this.p = (((float) i2) - (((this.s - this.g) - 2.0f) / 2.0f)) + 1.0f;
    }

    protected float getAmbientHover() {
        return 0.0f;
    }

    protected float getAmbientShadowScale() {
        return 1.0f;
    }

    public int getIndex() {
        return this.o;
    }

    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.save();
        canvas.translate(0.0f, (((float) getHeight()) - (this.s * 1.375f)) - this.d);
        canvas.scale(0.75f, 0.75f, (float) (getWidth() / 2), this.d);
        super.onDraw(canvas);
        canvas.restore();
        this.j.setColor(-4144960);
        canvas.drawText(this.k, this.q, this.p, this.j);
        this.j.setColor(-11513776);
        canvas.drawText(this.k, this.q, this.p - 2.0f, this.j);
        this.j.setColor(-9474193);
        canvas.drawText(this.k, this.q, this.p - 1.0f, this.j);
        canvas.restore();
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        int a = (int) (24.0f * Androidify.a());
        if (size > size2) {
            i3 = (a * 3) / 4;
            a = (((size2 * 2) / 3) * 70) / 100;
            if (a < size / 3) {
                a = size / 3;
            }
            int i4 = i3;
            i3 = a;
            a = i4;
        } else {
            i3 = (size * 70) / 100;
        }
        a++;
        do {
            a--;
            this.j.setTextSize((float) a);
            this.j.getTextBounds(this.k, 0, this.k.length(), this.l);
            if (this.l.width() <= i3) {
                break;
            }
        } while (a > 1);
        a(i3, size2);
        setMeasuredDimension(i3, size2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void setIndex(int i) {
        this.o = i;
    }

    public void setName(String str) {
        if (str == null) {
            this.k = "";
        } else {
            this.k = str;
        }
    }

    public void setOffsetX(float f) {
        this.f = f;
    }
}
