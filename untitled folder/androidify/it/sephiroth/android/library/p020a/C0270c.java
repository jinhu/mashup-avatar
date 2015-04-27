package it.sephiroth.android.library.p020a;

import android.util.Log;
import android.view.View;

/* renamed from: it.sephiroth.android.library.a.c */
public class C0270c extends C0269b {
    public C0270c(View view) {
        super(view);
    }

    public void m2121a(int i) {
        Log.d("ViewHelper", "setScrollX: " + i);
        this.a.scrollTo(i, this.a.getScrollY());
    }

    public void m2122a(Runnable runnable) {
        this.a.post(runnable);
    }

    public boolean m2123a() {
        return false;
    }
}
