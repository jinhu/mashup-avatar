package com.google.android.apps.androidify;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

class j extends View {
    final /* synthetic */ float a;
    final /* synthetic */ Paint b;
    final /* synthetic */ Paint c;
    final /* synthetic */ Androidify d;

    j(Androidify androidify, Context context, float f, Paint paint, Paint paint2) {
        this.d = androidify;
        this.a = f;
        this.b = paint;
        this.c = paint2;
        super(context);
    }

    protected void onDraw(Canvas canvas) {
        canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (((float) getHeight()) - this.a) - ((this.a * 3.0f) / 4.0f), this.b);
        this.c.setColor(-5723992);
        canvas.drawRect(0.0f, ((float) getHeight()) - this.a, (float) getWidth(), (float) getHeight(), this.c);
        this.c.setColor(-3355444);
        canvas.drawRect(0.0f, (((float) getHeight()) - this.a) - ((this.a * 3.0f) / 4.0f), (float) getWidth(), ((float) getHeight()) - this.a, this.c);
        this.c.setColor(-8355712);
        canvas.drawLine(0.0f, ((float) getHeight()) - this.a, (float) getWidth(), ((float) getHeight()) - this.a, this.c);
    }
}
