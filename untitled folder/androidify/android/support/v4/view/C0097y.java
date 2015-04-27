package android.support.v4.view;

import android.view.KeyEvent;

/* renamed from: android.support.v4.view.y */
class C0097y {
    public static int m720a(int i) {
        return KeyEvent.normalizeMetaState(i);
    }

    public static boolean m721a(int i, int i2) {
        return KeyEvent.metaStateHasModifiers(i, i2);
    }

    public static boolean m722b(int i) {
        return KeyEvent.metaStateHasNoModifiers(i);
    }
}
