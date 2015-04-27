package com.google.android.apps.androidify;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/* renamed from: com.google.android.apps.androidify.j */
class C0227j extends View {
    final /* synthetic */ float f1650a;
    final /* synthetic */ Paint f1651b;
    final /* synthetic */ Paint f1652c;
    final /* synthetic */ Androidify f1653d;

    C0227j(Androidify androidify, Context context, float f, Paint paint, Paint paint2) {
        this.f1653d = androidify;
        this.f1650a = f;
        this.f1651b = paint;
        this.f1652c = paint2;
        super(context);
    }

    protected void onDraw(Canvas canvas) {
        canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (((float) getHeight()) - this.f1650a) - ((this.f1650a * 3.0f) / 4.0f), this.f1651b);
        this.f1652c.setColor(-5723992);
        canvas.drawRect(0.0f, ((float) getHeight()) - this.f1650a, (float) getWidth(), (float) getHeight(), this.f1652c);
        this.f1652c.setColor(-3355444);
        canvas.drawRect(0.0f, (((float) getHeight()) - this.f1650a) - ((this.f1650a * 3.0f) / 4.0f), (float) getWidth(), ((float) getHeight()) - this.f1650a, this.f1652c);
        this.f1652c.setColor(-8355712);
        canvas.drawLine(0.0f, ((float) getHeight()) - this.f1650a, (float) getWidth(), ((float) getHeight()) - this.f1650a, this.f1652c);
    }
}
