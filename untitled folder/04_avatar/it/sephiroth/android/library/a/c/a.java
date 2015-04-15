package it.sephiroth.android.library.a.c;

import android.annotation.TargetApi;
import android.view.View;

public class a extends it.sephiroth.android.library.a.b.a {
    public a(View view) {
        super(view);
    }

    @TargetApi(16)
    public void a(Runnable runnable) {
        this.a.postOnAnimation(runnable);
    }
}
