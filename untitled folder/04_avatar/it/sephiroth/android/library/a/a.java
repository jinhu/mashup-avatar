package it.sephiroth.android.library.a;

import android.os.Build.VERSION;
import android.view.View;

public class a {
    public static final b a(View view) {
        int i = VERSION.SDK_INT;
        return i >= 16 ? new it.sephiroth.android.library.a.c.a(view) : i >= 14 ? new it.sephiroth.android.library.a.b.a(view) : new c(view);
    }
}
