package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

/* renamed from: android.support.v4.widget.o */
public class C0114o extends MarginLayoutParams {
    private static final int[] f385e;
    public float f386a;
    boolean f387b;
    boolean f388c;
    Paint f389d;

    static {
        f385e = new int[]{16843137};
    }

    public C0114o() {
        super(-1, -1);
        this.f386a = 0.0f;
    }

    public C0114o(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f386a = 0.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f385e);
        this.f386a = obtainStyledAttributes.getFloat(0, 0.0f);
        obtainStyledAttributes.recycle();
    }

    public C0114o(LayoutParams layoutParams) {
        super(layoutParams);
        this.f386a = 0.0f;
    }

    public C0114o(MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f386a = 0.0f;
    }
}
