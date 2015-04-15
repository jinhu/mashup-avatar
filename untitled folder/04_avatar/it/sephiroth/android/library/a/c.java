package it.sephiroth.android.library.a;

import android.util.Log;
import android.view.View;

public class c extends b {
    public c(View view) {
        super(view);
    }

    public void a(int i) {
        Log.d("ViewHelper", "setScrollX: " + i);
        this.a.scrollTo(i, this.a.getScrollY());
    }

    public void a(Runnable runnable) {
        this.a.post(runnable);
    }

    public boolean a() {
        return false;
    }
}
