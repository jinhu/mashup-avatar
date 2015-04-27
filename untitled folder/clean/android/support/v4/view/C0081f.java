package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.p003a.C0047a;
import android.support.v4.view.p003a.C0059j;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v4.view.f */
class C0081f implements C0080m {
    final /* synthetic */ C0073a f317a;
    final /* synthetic */ C0079e f318b;

    C0081f(C0079e c0079e, C0073a c0073a) {
        this.f318b = c0079e;
        this.f317a = c0073a;
    }

    public Object m678a(View view) {
        C0059j a = this.f317a.m473a(view);
        return a != null ? a.m444a() : null;
    }

    public void m679a(View view, int i) {
        this.f317a.m475a(view, i);
    }

    public void m680a(View view, Object obj) {
        this.f317a.m476a(view, new C0047a(obj));
    }

    public boolean m681a(View view, int i, Bundle bundle) {
        return this.f317a.m478a(view, i, bundle);
    }

    public boolean m682a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f317a.m480b(view, accessibilityEvent);
    }

    public boolean m683a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f317a.m479a(viewGroup, view, accessibilityEvent);
    }

    public void m684b(View view, AccessibilityEvent accessibilityEvent) {
        this.f317a.m482d(view, accessibilityEvent);
    }

    public void m685c(View view, AccessibilityEvent accessibilityEvent) {
        this.f317a.m481c(view, accessibilityEvent);
    }

    public void m686d(View view, AccessibilityEvent accessibilityEvent) {
        this.f317a.m477a(view, accessibilityEvent);
    }
}
