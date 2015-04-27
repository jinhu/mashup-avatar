package android.support.v4.view.p003a;

import android.os.Build.VERSION;

/* renamed from: android.support.v4.view.a.w */
public class C0072w {
    private static final C0048z f291a;
    private final Object f292b;

    static {
        if (VERSION.SDK_INT >= 16) {
            f291a = new aa();
        } else if (VERSION.SDK_INT >= 15) {
            f291a = new C0050y();
        } else if (VERSION.SDK_INT >= 14) {
            f291a = new C0049x();
        } else {
            f291a = new ab();
        }
    }

    public C0072w(Object obj) {
        this.f292b = obj;
    }

    public static C0072w m468a() {
        return new C0072w(f291a.m335a());
    }

    public void m469a(int i) {
        f291a.m338b(this.f292b, i);
    }

    public void m470a(boolean z) {
        f291a.m337a(this.f292b, z);
    }

    public void m471b(int i) {
        f291a.m336a(this.f292b, i);
    }

    public void m472c(int i) {
        f291a.m339c(this.f292b, i);
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
        C0072w c0072w = (C0072w) obj;
        return this.f292b == null ? c0072w.f292b == null : this.f292b.equals(c0072w.f292b);
    }

    public int hashCode() {
        return this.f292b == null ? 0 : this.f292b.hashCode();
    }
}
