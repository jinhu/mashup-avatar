package android.support.v4.view;

import android.support.v4.view.p003a.C0047a;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v4.view.c */
class C0078c implements C0077j {
    final /* synthetic */ C0073a f315a;
    final /* synthetic */ C0076b f316b;

    C0078c(C0076b c0076b, C0073a c0073a) {
        this.f316b = c0076b;
        this.f315a = c0073a;
    }

    public void m659a(View view, int i) {
        this.f315a.m475a(view, i);
    }

    public void m660a(View view, Object obj) {
        this.f315a.m476a(view, new C0047a(obj));
    }

    public boolean m661a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f315a.m480b(view, accessibilityEvent);
    }

    public boolean m662a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f315a.m479a(viewGroup, view, accessibilityEvent);
    }

    public void m663b(View view, AccessibilityEvent accessibilityEvent) {
        this.f315a.m482d(view, accessibilityEvent);
    }

    public void m664c(View view, AccessibilityEvent accessibilityEvent) {
        this.f315a.m481c(view, accessibilityEvent);
    }

    public void m665d(View view, AccessibilityEvent accessibilityEvent) {
        this.f315a.m477a(view, accessibilityEvent);
    }
}
