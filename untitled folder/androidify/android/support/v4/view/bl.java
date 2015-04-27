package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.p003a.C0047a;
import android.support.v4.view.p003a.C0072w;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

class bl extends C0073a {
    final /* synthetic */ ViewPager f313b;

    bl(ViewPager viewPager) {
        this.f313b = viewPager;
    }

    private boolean m638b() {
        return this.f313b.f262h != null && this.f313b.f262h.m504a() > 1;
    }

    public void m639a(View view, C0047a c0047a) {
        super.m476a(view, c0047a);
        c0047a.m316a(ViewPager.class.getName());
        c0047a.m317a(m638b());
        if (this.f313b.canScrollHorizontally(1)) {
            c0047a.m313a(4096);
        }
        if (this.f313b.canScrollHorizontally(-1)) {
            c0047a.m313a(8192);
        }
    }

    public boolean m640a(View view, int i, Bundle bundle) {
        if (super.m478a(view, i, bundle)) {
            return true;
        }
        switch (i) {
            case 4096:
                if (!this.f313b.canScrollHorizontally(1)) {
                    return false;
                }
                this.f313b.setCurrentItem(this.f313b.f263i + 1);
                return true;
            case 8192:
                if (!this.f313b.canScrollHorizontally(-1)) {
                    return false;
                }
                this.f313b.setCurrentItem(this.f313b.f263i - 1);
                return true;
            default:
                return false;
        }
    }

    public void m641d(View view, AccessibilityEvent accessibilityEvent) {
        super.m482d(view, accessibilityEvent);
        accessibilityEvent.setClassName(ViewPager.class.getName());
        C0072w a = C0072w.m468a();
        a.m470a(m638b());
        if (accessibilityEvent.getEventType() == 4096 && this.f313b.f262h != null) {
            a.m469a(this.f313b.f262h.m504a());
            a.m471b(this.f313b.f263i);
            a.m472c(this.f313b.f263i);
        }
    }
}
