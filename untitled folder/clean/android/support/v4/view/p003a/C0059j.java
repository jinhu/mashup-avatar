package android.support.v4.view.p003a;

import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.List;

/* renamed from: android.support.v4.view.a.j */
public class C0059j {
    private static final C0060k f283a;
    private final Object f284b;

    static {
        if (VERSION.SDK_INT >= 19) {
            f283a = new C0065n();
        } else if (VERSION.SDK_INT >= 16) {
            f283a = new C0062l();
        } else {
            f283a = new C0061p();
        }
    }

    public C0059j() {
        this.f284b = f283a.m448a(this);
    }

    public C0059j(Object obj) {
        this.f284b = obj;
    }

    public C0047a m443a(int i) {
        return null;
    }

    public Object m444a() {
        return this.f284b;
    }

    public List m445a(String str, int i) {
        return null;
    }

    public boolean m446a(int i, int i2, Bundle bundle) {
        return false;
    }

    public C0047a m447b(int i) {
        return null;
    }
}
