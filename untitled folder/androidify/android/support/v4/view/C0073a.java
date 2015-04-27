package android.support.v4.view;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.p003a.C0047a;
import android.support.v4.view.p003a.C0059j;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v4.view.a */
public class C0073a {
    private static final C0074d f293b;
    private static final Object f294c;
    final Object f295a;

    static {
        if (VERSION.SDK_INT >= 16) {
            f293b = new C0079e();
        } else if (VERSION.SDK_INT >= 14) {
            f293b = new C0076b();
        } else {
            f293b = new C0075g();
        }
        f294c = f293b.m602a();
    }

    public C0073a() {
        this.f295a = f293b.m603a(this);
    }

    public C0059j m473a(View view) {
        return f293b.m601a(f294c, view);
    }

    Object m474a() {
        return this.f295a;
    }

    public void m475a(View view, int i) {
        f293b.m604a(f294c, view, i);
    }

    public void m476a(View view, C0047a c0047a) {
        f293b.m605a(f294c, view, c0047a);
    }

    public void m477a(View view, AccessibilityEvent accessibilityEvent) {
        f293b.m611d(f294c, view, accessibilityEvent);
    }

    public boolean m478a(View view, int i, Bundle bundle) {
        return f293b.m606a(f294c, view, i, bundle);
    }

    public boolean m479a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return f293b.m608a(f294c, viewGroup, view, accessibilityEvent);
    }

    public boolean m480b(View view, AccessibilityEvent accessibilityEvent) {
        return f293b.m607a(f294c, view, accessibilityEvent);
    }

    public void m481c(View view, AccessibilityEvent accessibilityEvent) {
        f293b.m610c(f294c, view, accessibilityEvent);
    }

    public void m482d(View view, AccessibilityEvent accessibilityEvent) {
        f293b.m609b(f294c, view, accessibilityEvent);
    }
}
