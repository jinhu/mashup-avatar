package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

/* renamed from: android.support.v4.widget.c */
public class C0101c extends MarginLayoutParams {
    public int f371a;
    float f372b;
    boolean f373c;
    boolean f374d;

    public C0101c(int i, int i2) {
        super(i, i2);
        this.f371a = 0;
    }

    public C0101c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f371a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.f327a);
        this.f371a = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
    }

    public C0101c(C0101c c0101c) {
        super(c0101c);
        this.f371a = 0;
        this.f371a = c0101c.f371a;
    }

    public C0101c(LayoutParams layoutParams) {
        super(layoutParams);
        this.f371a = 0;
    }

    public C0101c(MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f371a = 0;
    }
}
