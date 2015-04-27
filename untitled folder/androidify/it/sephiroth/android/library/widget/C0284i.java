package it.sephiroth.android.library.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;

/* renamed from: it.sephiroth.android.library.widget.i */
public class C0284i extends LayoutParams {
    public int f1975a;
    public boolean f1976b;
    public boolean f1977c;
    public int f1978d;
    public long f1979e;

    public C0284i(int i, int i2) {
        super(i, i2);
        this.f1979e = -1;
    }

    public C0284i(int i, int i2, int i3) {
        super(i, i2);
        this.f1979e = -1;
        this.f1975a = i3;
    }

    public C0284i(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1979e = -1;
    }

    public C0284i(LayoutParams layoutParams) {
        super(layoutParams);
        this.f1979e = -1;
    }
}
