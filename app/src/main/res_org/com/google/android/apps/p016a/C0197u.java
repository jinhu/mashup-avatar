package com.google.android.apps.analytics;

import android.os.Handler;
import android.os.HandlerThread;

/* renamed from: com.google.android.apps.a.u */
class C0197u extends HandlerThread {
    volatile Handler f693a;
    private final C0202z f694b;
    private final String f695c;
    private int f696d;
    private int f697e;
    private long f698f;
    private C0198v f699g;
    private final C0183g f700h;
    private final C0199w f701i;
    private final C0195s f702j;

    private C0197u(C0183g c0183g, C0202z c0202z, String str, C0195s c0195s) {
        super("DispatcherThread");
        this.f697e = 30;
        this.f699g = null;
        this.f700h = c0183g;
        this.f695c = str;
        this.f694b = c0202z;
        this.f701i = new C0199w();
        this.f694b.m1301a(this.f701i);
        this.f702j = c0195s;
    }

    private C0197u(C0183g c0183g, String str, C0195s c0195s) {
        this(c0183g, new C0202z(c0195s.f690b), str, c0195s);
    }

    static /* synthetic */ long m1238a(C0197u c0197u, long j) {
        long j2 = c0197u.f698f * j;
        c0197u.f698f = j2;
        return j2;
    }

    public void m1250a(C0189m[] c0189mArr) {
        if (this.f693a != null) {
            this.f693a.post(new C0198v(this, c0189mArr));
        }
    }

    protected void onLooperPrepared() {
        this.f693a = new Handler();
    }
}
