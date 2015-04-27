package android.support.v4.view.p003a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* renamed from: android.support.v4.view.a.r */
final class C0069r extends AccessibilityNodeProvider {
    final /* synthetic */ C0063s f289a;

    C0069r(C0063s c0063s) {
        this.f289a = c0063s;
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        return (AccessibilityNodeInfo) this.f289a.m451a(i);
    }

    public List findAccessibilityNodeInfosByText(String str, int i) {
        return this.f289a.m452a(str, i);
    }

    public boolean performAction(int i, int i2, Bundle bundle) {
        return this.f289a.m453a(i, i2, bundle);
    }
}
