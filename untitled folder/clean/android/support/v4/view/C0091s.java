package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.KeyEvent;

/* renamed from: android.support.v4.view.s */
public class C0091s {
    static final C0092w f322a;

    static {
        if (VERSION.SDK_INT >= 11) {
            f322a = new C0095v();
        } else {
            f322a = new C0093t();
        }
    }

    public static boolean m704a(KeyEvent keyEvent) {
        return f322a.m709b(keyEvent.getMetaState());
    }

    public static boolean m705a(KeyEvent keyEvent, int i) {
        return f322a.m708a(keyEvent.getMetaState(), i);
    }

    public static void m706b(KeyEvent keyEvent) {
        f322a.m707a(keyEvent);
    }
}
