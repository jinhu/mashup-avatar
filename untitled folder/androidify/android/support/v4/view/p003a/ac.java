package android.support.v4.view.p003a;

import android.view.accessibility.AccessibilityRecord;

/* renamed from: android.support.v4.view.a.ac */
class ac {
    public static Object m350a() {
        return AccessibilityRecord.obtain();
    }

    public static void m351a(Object obj, int i) {
        ((AccessibilityRecord) obj).setFromIndex(i);
    }

    public static void m352a(Object obj, boolean z) {
        ((AccessibilityRecord) obj).setScrollable(z);
    }

    public static void m353b(Object obj, int i) {
        ((AccessibilityRecord) obj).setItemCount(i);
    }

    public static void m354c(Object obj, int i) {
        ((AccessibilityRecord) obj).setToIndex(i);
    }
}
