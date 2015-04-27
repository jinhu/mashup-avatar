package it.sephiroth.android.library.p020a.p022b;

import android.annotation.TargetApi;
import android.view.View;
import it.sephiroth.android.library.p020a.C0270c;

/* renamed from: it.sephiroth.android.library.a.b.a */
public class C0271a extends C0270c {
    public C0271a(View view) {
        super(view);
    }

    @TargetApi(14)
    public void m2124a(int i) {
        this.a.setScrollX(i);
    }

    @TargetApi(11)
    public boolean m2125a() {
        return this.a.isHardwareAccelerated();
    }
}
