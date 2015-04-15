package com.google.android.apps.androidify;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class ProgressRelativeLayout extends RelativeLayout {
    private int a;
    private int b;
    private Paint c;
    private Paint d;
    private int e;

    public ProgressRelativeLayout(Context context) {
        super(context);
        this.b = getResources().getColor(R.color.gallery_bottom_bar_green);
        this.c = new Paint();
        this.d = new Paint();
        a();
    }

    public ProgressRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = getResources().getColor(R.color.gallery_bottom_bar_green);
        this.c = new Paint();
        this.d = new Paint();
        a();
    }

    public ProgressRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = getResources().getColor(R.color.gallery_bottom_bar_green);
        this.c = new Paint();
        this.d = new Paint();
        a();
    }

    private void a() {
        this.c.setColor(getResources().getColor(R.color.bg_grey));
        this.d.setColor(this.b);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.a > 0) {
            canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), this.c);
            canvas.drawRect(0.0f, 0.0f, (float) this.e, (float) getHeight(), this.d);
        }
    }

    public void setProgress(int i) {
        this.a = i;
        this.e = (int) by.a((float) i, 0.0f, 100.0f, 0.0f, (float) getWidth());
        invalidate();
    }

    public void setProgressColor(int i) {
        this.b = i;
        this.d.setColor(i);
    }
}
