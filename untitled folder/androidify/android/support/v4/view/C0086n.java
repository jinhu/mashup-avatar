package android.support.v4.view;

import android.os.Build.VERSION;

/* renamed from: android.support.v4.view.n */
public class C0086n {
    static final C0087o f321a;

    static {
        if (VERSION.SDK_INT >= 17) {
            f321a = new C0089q();
        } else {
            f321a = new C0088p();
        }
    }

    public static int m699a(int i, int i2) {
        return f321a.m700a(i, i2);
    }
}
