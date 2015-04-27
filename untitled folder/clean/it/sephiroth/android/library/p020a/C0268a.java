package it.sephiroth.android.library.p020a;

import android.os.Build.VERSION;
import android.view.View;
import it.sephiroth.android.library.p020a.p022b.C0271a;
import it.sephiroth.android.library.p020a.p023c.C0272a;

/* renamed from: it.sephiroth.android.library.a.a */
public class C0268a {
    public static final C0269b m2117a(View view) {
        int i = VERSION.SDK_INT;
        return i >= 16 ? new C0272a(view) : i >= 14 ? new C0271a(view) : new C0270c(view);
    }
}
