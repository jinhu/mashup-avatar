package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;

public class bk extends LayoutParams {
    public boolean f307a;
    public int f308b;
    float f309c;
    boolean f310d;
    int f311e;
    int f312f;

    public bk() {
        super(-1, -1);
        this.f309c = 0.0f;
    }

    public bk(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f309c = 0.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f231a);
        this.f308b = obtainStyledAttributes.getInteger(0, 48);
        obtainStyledAttributes.recycle();
    }
}
