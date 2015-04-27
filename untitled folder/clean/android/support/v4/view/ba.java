package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

public class ba {
    static final bd f300a;

    static {
        if (VERSION.SDK_INT >= 11) {
            f300a = new bc();
        } else {
            f300a = new bb();
        }
    }

    public static int m632a(ViewConfiguration viewConfiguration) {
        return f300a.m633a(viewConfiguration);
    }
}
