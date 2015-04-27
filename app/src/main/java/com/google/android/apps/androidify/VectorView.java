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

import dev.game.legend.svgandroid.SVG;

public class VectorView extends View {
    private float f962a;
    private float f963b;
    private float f964c;
    private float f965d;
    private float f966e;
    private float f967f;
    private float f968g;
    private float f969h;
    private float f970i;
    private Paint f971j;
    private SVG[] svgs;
    private Picture[] f973l;
    private boolean f974m;
    private RectF f975n;
    private boolean f976o;
    private PictureDrawable f977p;
    private SVG svg;

    public VectorView(Context context) {
        super(context);
        this.f962a = 1.0f;
        this.f963b = -1.0f;
        this.f964c = 0.0f;
        this.f965d = 0.0f;
        this.f966e = -1.0f;
        this.f967f = 0.0f;
        this.f968g = 0.0f;
        this.svgs = null;
        this.f973l = null;
        this.f975n = null;
        this.f976o = true;
        this.f977p = null;
        this.svg = null;
        m1595a(context, null);
    }

    public VectorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f962a = 1.0f;
        this.f963b = -1.0f;
        this.f964c = 0.0f;
        this.f965d = 0.0f;
        this.f966e = -1.0f;
        this.f967f = 0.0f;
        this.f968g = 0.0f;
        this.svgs = null;
        this.f973l = null;
        this.f975n = null;
        this.f976o = true;
        this.f977p = null;
        this.svg = null;
        m1595a(context, attributeSet);
    }

    public VectorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f962a = 1.0f;
        this.f963b = -1.0f;
        this.f964c = 0.0f;
        this.f965d = 0.0f;
        this.f966e = -1.0f;
        this.f967f = 0.0f;
        this.f968g = 0.0f;
        this.svgs = null;
        this.f973l = null;
        this.f975n = null;
        this.f976o = true;
        this.f977p = null;
        this.svg = null;
        m1595a(context, attributeSet);
    }

    private void m1594a() {
        RectF rectF;
        Object obj = null;
        this.f969h = 0.0f;
        this.f970i = 0.0f;
        this.f964c = 0.0f;
        this.f965d = 0.0f;
        for (SVG SVG : this.svgs) {
            RectF rectF2 = SVG.bounds;
            if (rectF2 != null) {
                obj = 1;
                this.f964c = -rectF2.left;
                this.f965d = -rectF2.top;
                this.f969h = rectF2.width();
                this.f970i = rectF2.height();
            }
        }
        if (obj == null) {
            rectF = this.f975n;
            if (rectF != null) {
                this.f964c = Math.min(this.f964c, -rectF.left);
                this.f965d = Math.min(this.f965d, -rectF.top);
                this.f969h = Math.max(this.f969h, rectF.width());
                this.f970i = Math.max(this.f970i, rectF.height());
            }
        }
        if (this.f969h == 0.0f || this.f970i == 0.0f) {
            this.f969h = (float) getHeight();
            this.f970i = (float) getHeight();
        }
        this.f963b = Math.min(((float) getWidth()) / this.f969h, ((float) getHeight()) / this.f970i);
        if (this.svg != null) {
            this.f966e = 1.0f;
            this.f967f = 0.0f;
            this.f968g = 0.0f;
            rectF = this.svg.bounds;
            if (rectF != null) {
                this.f967f = -rectF.left;
                this.f968g = -rectF.top;
                this.f966e = Math.min(((float) getWidth()) / rectF.width(), ((float) getHeight()) / rectF.height());
            }
        }
    }

    private void m1595a(Context context, AttributeSet attributeSet) {
        this.f971j = new Paint();
    }

    protected void onDraw(Canvas canvas) {
       super.onDraw(canvas);
        if (this.f963b == -1.0f) {
            m1594a();
        }
        canvas.save();
        canvas.scale(this.f963b, this.f963b);
        canvas.translate(this.f964c, this.f965d);
        if (this.f976o) {
            if (this.f977p == null) {
                this.f971j.setStyle(Style.FILL);
                this.f971j.setColor(-1);
                canvas.drawRect(-10000.0f, -10000.0f, 10000.0f, 10000.0f, this.f971j);
            }
            if (this.f974m && this.f977p == null) {
                this.f971j.setStyle(Style.FILL);
                this.f971j.setColor(-789517);
                canvas.drawRect(-10000.0f, -10000.0f, 10000.0f, 10000.0f, this.f971j);
            }
        }
        for (Picture draw : this.f973l) {
            draw.draw(canvas);
        }
        if (this.f974m && this.f977p != null) {
            this.f977p.draw(canvas);
        }
        canvas.restore();
        if (this.svg != null) {
            canvas.save();
            canvas.scale(this.f966e, this.f966e);
            canvas.translate(this.f967f, this.f968g);
            this.svg.getPicture().draw(canvas);
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
        this.f975n = rectF;
    }

    public void setDrawBackground(boolean z) {
        this.f976o = z;
    }

    public void setNewBadge(SVG aSVG) {
        this.svg = aSVG;
        this.f963b = -1.0f;
    }

    public void setSelected(boolean z) {
        this.f974m = z;
        invalidate();
    }

    public void setSelectionVector(PictureDrawable pictureDrawable) {
        this.f977p = pictureDrawable;
    }

    public void setVectors(SVG... aSVGArr) {
        this.svg = null;
        this.svgs = aSVGArr;
        int length = this.svgs.length;
        this.f973l = new Picture[length];
        for (int i = 0; i < length; i++) {
            this.f973l[i] = this.svgs[i].getPicture();
        }
        this.f963b = -1.0f;
    }

    public void setZoom(float f) {
        this.f962a = f;
    }
}
