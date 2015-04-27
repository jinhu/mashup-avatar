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
    private float f1452f;
    private float f1453g;
    private Paint f1454h;
    private Paint f1455i;
    private Paint f1456j;
    private String f1457k;
    private Rect f1458l;
    private RectF f1459m;
    private float f1460n;
    private int f1461o;
    private float f1462p;
    private float f1463q;
    private boolean f1464r;
    private float f1465s;

    public bs(Androidify androidify, Picture picture, Picture picture2, Picture picture3, Picture picture4, Picture picture5, Picture picture6, int i, float f) {
        super(androidify);
        this.f1453g = 0.0f;
        this.f1457k = "";
        this.f1458l = new Rect();
        this.f1459m = new RectF();
        this.f1464r = true;
        m1457a(androidify, picture, picture2, picture3, picture4, picture5, picture6);
        androidify.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        setBackgroundColor(0);
        this.f1461o = i;
        this.f1465s = f;
        this.c = false;
        setOnGround(true);
        this.f1454h = new Paint(129);
        this.f1454h.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        this.f1454h.setTextSize(24.0f);
        this.f1454h.setStrokeWidth(2.0f);
        this.f1454h.setColor(-16777216);
        this.f1455i = new Paint(this.f1454h);
        this.f1460n = (float) ((a.nextDouble() * 3.141592653589793d) * 2.0d);
        this.f1456j = new Paint(129);
        this.f1456j.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        this.f1456j.setTextSize(24.0f);
    }

    public static float m1889a(Androidify androidify, int i, int i2, float f) {
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

    protected float m1890a(int i) {
        return this.b.m1385c().m1630a(i, this.f1460n);
    }

    public void m1891a(int i, int i2) {
        this.f1453g = -this.f1456j.getFontMetrics().ascent;
        this.f1463q = ((float) (i - this.f1458l.width())) / 2.0f;
        this.f1462p = (((float) i2) - (((this.f1465s - this.f1453g) - 2.0f) / 2.0f)) + 1.0f;
    }

    protected float getAmbientHover() {
        return 0.0f;
    }

    protected float getAmbientShadowScale() {
        return 1.0f;
    }

    public int getIndex() {
        return this.f1461o;
    }

    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.save();
        canvas.translate(0.0f, (((float) getHeight()) - (this.f1465s * 1.375f)) - this.d);
        canvas.scale(0.75f, 0.75f, (float) (getWidth() / 2), this.d);
        super.onDraw(canvas);
        canvas.restore();
        this.f1456j.setColor(-4144960);
        canvas.drawText(this.f1457k, this.f1463q, this.f1462p, this.f1456j);
        this.f1456j.setColor(-11513776);
        canvas.drawText(this.f1457k, this.f1463q, this.f1462p - 2.0f, this.f1456j);
        this.f1456j.setColor(-9474193);
        canvas.drawText(this.f1457k, this.f1463q, this.f1462p - 1.0f, this.f1456j);
        canvas.restore();
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        int a = (int) (24.0f * Androidify.m1331a());
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
            this.f1456j.setTextSize((float) a);
            this.f1456j.getTextBounds(this.f1457k, 0, this.f1457k.length(), this.f1458l);
            if (this.f1458l.width() <= i3) {
                break;
            }
        } while (a > 1);
        m1891a(i3, size2);
        setMeasuredDimension(i3, size2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void setIndex(int i) {
        this.f1461o = i;
    }

    public void setName(String str) {
        if (str == null) {
            this.f1457k = "";
        } else {
            this.f1457k = str;
        }
    }

    public void setOffsetX(float f) {
        this.f1452f = f;
    }
}
