package it.sephiroth.android.library.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;

public class i extends LayoutParams {
    public int a;
    public boolean b;
    public boolean c;
    public int d;
    public long e;

    public i(int i, int i2) {
        super(i, i2);
        this.e = -1;
    }

    public i(int i, int i2, int i3) {
        super(i, i2);
        this.e = -1;
        this.a = i3;
    }

    public i(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = -1;
    }

    public i(LayoutParams layoutParams) {
        super(layoutParams);
        this.e = -1;
    }
}
