package android.support.v4.view.p003a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import com.google.android.apps.androidify.cm;

/* renamed from: android.support.v4.view.a.a */
public class C0047a {
    private static final C0051c f281a;
    private final Object f282b;

    static {
        if (VERSION.SDK_INT >= 19) {
            f281a = new C0056f();
        } else if (VERSION.SDK_INT >= 18) {
            f281a = new C0055e();
        } else if (VERSION.SDK_INT >= 16) {
            f281a = new C0054d();
        } else if (VERSION.SDK_INT >= 14) {
            f281a = new C0053b();
        } else {
            f281a = new C0052g();
        }
    }

    public C0047a(Object obj) {
        this.f282b = obj;
    }

    private static String m311b(int i) {
        switch (i) {
            case cm.HListView_android_divider /*1*/:
                return "ACTION_FOCUS";
            case cm.HListView_hlv_dividerWidth /*2*/:
                return "ACTION_CLEAR_FOCUS";
            case cm.HListView_hlv_footerDividersEnabled /*4*/:
                return "ACTION_SELECT";
            case cm.ExpandableHListView_hlv_childIndicatorPaddingTop /*8*/:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }

    public Object m312a() {
        return this.f282b;
    }

    public void m313a(int i) {
        f281a.m356a(this.f282b, i);
    }

    public void m314a(Rect rect) {
        f281a.m357a(this.f282b, rect);
    }

    public void m315a(View view) {
        f281a.m358a(this.f282b, view);
    }

    public void m316a(CharSequence charSequence) {
        f281a.m359a(this.f282b, charSequence);
    }

    public void m317a(boolean z) {
        f281a.m360a(this.f282b, z);
    }

    public int m318b() {
        return f281a.m355a(this.f282b);
    }

    public void m319b(Rect rect) {
        f281a.m362b(this.f282b, rect);
    }

    public boolean m320c() {
        return f281a.m366f(this.f282b);
    }

    public boolean m321d() {
        return f281a.m367g(this.f282b);
    }

    public boolean m322e() {
        return f281a.m370j(this.f282b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        C0047a c0047a = (C0047a) obj;
        return this.f282b == null ? c0047a.f282b == null : this.f282b.equals(c0047a.f282b);
    }

    public boolean m323f() {
        return f281a.m371k(this.f282b);
    }

    public boolean m324g() {
        return f281a.m375o(this.f282b);
    }

    public boolean m325h() {
        return f281a.m368h(this.f282b);
    }

    public int hashCode() {
        return this.f282b == null ? 0 : this.f282b.hashCode();
    }

    public boolean m326i() {
        return f281a.m372l(this.f282b);
    }

    public boolean m327j() {
        return f281a.m369i(this.f282b);
    }

    public boolean m328k() {
        return f281a.m373m(this.f282b);
    }

    public boolean m329l() {
        return f281a.m374n(this.f282b);
    }

    public CharSequence m330m() {
        return f281a.m364d(this.f282b);
    }

    public CharSequence m331n() {
        return f281a.m361b(this.f282b);
    }

    public CharSequence m332o() {
        return f281a.m365e(this.f282b);
    }

    public CharSequence m333p() {
        return f281a.m363c(this.f282b);
    }

    public String m334q() {
        return f281a.m376p(this.f282b);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        Rect rect = new Rect();
        m314a(rect);
        stringBuilder.append("; boundsInParent: " + rect);
        m319b(rect);
        stringBuilder.append("; boundsInScreen: " + rect);
        stringBuilder.append("; packageName: ").append(m330m());
        stringBuilder.append("; className: ").append(m331n());
        stringBuilder.append("; text: ").append(m332o());
        stringBuilder.append("; contentDescription: ").append(m333p());
        stringBuilder.append("; viewId: ").append(m334q());
        stringBuilder.append("; checkable: ").append(m320c());
        stringBuilder.append("; checked: ").append(m321d());
        stringBuilder.append("; focusable: ").append(m322e());
        stringBuilder.append("; focused: ").append(m323f());
        stringBuilder.append("; selected: ").append(m324g());
        stringBuilder.append("; clickable: ").append(m325h());
        stringBuilder.append("; longClickable: ").append(m326i());
        stringBuilder.append("; enabled: ").append(m327j());
        stringBuilder.append("; password: ").append(m328k());
        stringBuilder.append("; scrollable: " + m329l());
        stringBuilder.append("; [");
        int b = m318b();
        while (b != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(b);
            b &= numberOfTrailingZeros ^ -1;
            stringBuilder.append(C0047a.m311b(numberOfTrailingZeros));
            if (b != 0) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
