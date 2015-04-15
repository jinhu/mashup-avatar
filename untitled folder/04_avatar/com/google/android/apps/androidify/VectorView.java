package com.google.android.apps.androidify;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Picture;
import android.graphics.RectF;
import android.graphics.drawable.PictureDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.google.android.apps.b.b;

public class VectorView extends View {
    private float a;
    private float b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;
    private Paint j;
    private b[] k;
    private Picture[] l;
    private boolean m;
    private RectF n;
    private boolean o;
    private PictureDrawable p;
    private b q;

    public VectorView(Context context) {
        super(context);
        this.a = 1.0f;
        this.b = -1.0f;
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = -1.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.k = null;
        this.l = null;
        this.n = null;
        this.o = true;
        this.p = null;
        this.q = null;
        a(context, null);
    }

    public VectorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 1.0f;
        this.b = -1.0f;
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = -1.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.k = null;
        this.l = null;
        this.n = null;
        this.o = true;
        this.p = null;
        this.q = null;
        a(context, attributeSet);
    }

    public VectorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 1.0f;
        this.b = -1.0f;
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = -1.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.k = null;
        this.l = null;
        this.n = null;
        this.o = true;
        this.p = null;
        this.q = null;
        a(context, attributeSet);
    }

    private void a() {
        RectF rectF;
        Object obj = null;
        this.h = 0.0f;
        this.i = 0.0f;
        this.c = 0.0f;
        this.d = 0.0f;
        for (b bVar : this.k) {
            RectF rectF2 = bVar.b;
            if (rectF2 != null) {
                obj = 1;
                this.c = -rectF2.left;
                this.d = -rectF2.top;
                this.h = rectF2.width();
                this.i = rectF2.height();
            }
        }
        if (obj == null) {
            rectF = this.n;
            if (rectF != null) {
                this.c = Math.min(this.c, -rectF.left);
                this.d = Math.min(this.d, -rectF.top);
                this.h = Math.max(this.h, rectF.width());
                this.i = Math.max(this.i, rectF.height());
            }
        }
        if (this.h == 0.0f || this.i == 0.0f) {
            this.h = (float) getHeight();
            this.i = (float) getHeight();
        }
        this.b = Math.min(((float) getWidth()) / this.h, ((float) getHeight()) / this.i);
        if (this.q != null) {
            this.e = 1.0f;
            this.f = 0.0f;
            this.g = 0.0f;
            rectF = this.q.b;
            if (rectF != null) {
                this.f = -rectF.left;
                this.g = -rectF.top;
                this.e = Math.min(((float) getWidth()) / rectF.width(), ((float) getHeight()) / rectF.height());
            }
        }
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.j = new Paint();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.b == -1.0f) {
            a();
        }
        canvas.save();
        canvas.scale(this.b, this.b);
        canvas.translate(this.c, this.d);
        if (this.o) {
            if (this.p == null) {
                this.j.setStyle(Style.FILL);
                this.j.setColor(-1);
                canvas.drawRect(-10000.0f, -10000.0f, 10000.0f, 10000.0f, this.j);
            }
            if (this.m && this.p == null) {
                this.j.setStyle(Style.FILL);
                this.j.setColor(-789517);
                canvas.drawRect(-10000.0f, -10000.0f, 10000.0f, 10000.0f, this.j);
            }
        }
        for (Picture draw : this.l) {
            draw.draw(canvas);
        }
        if (this.m && this.p != null) {
            this.p.draw(canvas);
        }
        canvas.restore();
        if (this.q != null) {
            canvas.save();
            canvas.scale(this.e, this.e);
            canvas.translate(this.f, this.g);
            this.q.a.draw(canvas);
            canvas.restore();
        }
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (mode != 0) {
            size2 = size;
        } else if (mode2 != 0) {
            size = size2;
        } else {
            int i3 = size2;
            size2 = size;
            size = i3;
        }
        setMeasuredDimension(size2, size);
    }

    public void setDefaultBounds(RectF rectF) {
        this.n = rectF;
    }

    public void setDrawBackground(boolean z) {
        this.o = z;
    }

    public void setNewBadge(b bVar) {
        this.q = bVar;
        this.b = -1.0f;
    }

    public void setSelected(boolean z) {
        this.m = z;
        invalidate();
    }

    public void setSelectionVector(PictureDrawable pictureDrawable) {
        this.p = pictureDrawable;
    }

    public void setVectors(b... bVarArr) {
        this.q = null;
        this.k = bVarArr;
        int length = this.k.length;
        this.l = new Picture[length];
        for (int i = 0; i < length; i++) {
            this.l[i] = this.k[i].a;
        }
        this.b = -1.0f;
    }

    public void setZoom(float f) {
        this.a = f;
    }
}
