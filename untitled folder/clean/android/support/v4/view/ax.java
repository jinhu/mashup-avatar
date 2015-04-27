package android.support.v4.view;

import android.view.View;
import android.view.View.AccessibilityDelegate;

class ax {
    public static void m592a(View view, Object obj) {
        view.setAccessibilityDelegate((AccessibilityDelegate) obj);
    }

    public static boolean m593a(View view, int i) {
        return view.canScrollHorizontally(i);
    }
}
