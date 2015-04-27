package it.sephiroth.android.library.p020a.p023c;

import android.annotation.TargetApi;
import android.view.View;
import it.sephiroth.android.library.p020a.p022b.C0271a;

/* renamed from: it.sephiroth.android.library.a.c.a */
public class C0272a extends C0271a {
    public C0272a(View view) {
        super(view);
    }

    @TargetApi(16)
    public void m2126a(Runnable runnable) {
        this.a.postOnAnimation(runnable);
    }
}
