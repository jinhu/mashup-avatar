package android.support.v4.view.p003a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* renamed from: android.support.v4.view.a.u */
final class C0071u extends AccessibilityNodeProvider {
    final /* synthetic */ C0066v f290a;

    C0071u(C0066v c0066v) {
        this.f290a = c0066v;
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        return (AccessibilityNodeInfo) this.f290a.m458a(i);
    }

    public List findAccessibilityNodeInfosByText(String str, int i) {
        return this.f290a.m459a(str, i);
    }

    public AccessibilityNodeInfo findFocus(int i) {
        return (AccessibilityNodeInfo) this.f290a.m461b(i);
    }

    public boolean performAction(int i, int i2, Bundle bundle) {
        return this.f290a.m460a(i, i2, bundle);
    }
}
