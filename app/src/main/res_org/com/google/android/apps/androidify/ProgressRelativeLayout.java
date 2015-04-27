package com.google.android.apps.androidify;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class ProgressRelativeLayout extends RelativeLayout {
    private int f896a;
    private int f897b;
    private Paint f898c;
    private Paint f899d;
    private int f900e;

    public ProgressRelativeLayout(Context context) {
        super(context);
        this.f897b = getResources().getColor(R.color.gallery_bottom_bar_green);
        this.f898c = new Paint();
        this.f899d = new Paint();
        m1525a();
    }

    public ProgressRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f897b = getResources().getColor(R.color.gallery_bottom_bar_green);
        this.f898c = new Paint();
        this.f899d = new Paint();
        m1525a();
    }

    public ProgressRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f897b = getResources().getColor(R.color.gallery_bottom_bar_green);
        this.f898c = new Paint();
        this.f899d = new Paint();
        m1525a();
    }

    private void m1525a() {
        this.f898c.setColor(getResources().getColor(R.color.bg_grey));
        this.f899d.setColor(this.f897b);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f896a > 0) {
            canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), this.f898c);
            canvas.drawRect(0.0f, 0.0f, (float) this.f900e, (float) getHeight(), this.f899d);
        }
    }

    public void setProgress(int i) {
        this.f896a = i;
        this.f900e = (int) by.m1898a((float) i, 0.0f, 100.0f, 0.0f, (float) getWidth());
        invalidate();
    }

    public void setProgressColor(int i) {
        this.f897b = i;
        this.f899d.setColor(i);
    }
}
