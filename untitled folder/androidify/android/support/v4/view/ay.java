package android.support.v4.view;

import android.view.View;

class ay {
    public static void m594a(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void m595a(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    public static void m596a(View view, int i, int i2, int i3, int i4) {
        view.postInvalidate(i, i2, i3, i4);
    }

    public static void m597a(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static int m598b(View view) {
        return view.getImportantForAccessibility();
    }
}
