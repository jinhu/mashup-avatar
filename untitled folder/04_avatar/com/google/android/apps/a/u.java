package com.google.android.apps.a;

import android.os.Handler;
import android.os.HandlerThread;

class u extends HandlerThread {
    volatile Handler a;
    private final z b;
    private final String c;
    private int d;
    private int e;
    private long f;
    private v g;
    private final g h;
    private final w i;
    private final s j;

    private u(g gVar, z zVar, String str, s sVar) {
        super("DispatcherThread");
        this.e = 30;
        this.g = null;
        this.h = gVar;
        this.c = str;
        this.b = zVar;
        this.i = new w();
        this.b.a(this.i);
        this.j = sVar;
    }

    private u(g gVar, String str, s sVar) {
        this(gVar, new z(sVar.b), str, sVar);
    }

    static /* synthetic */ long a(u uVar, long j) {
        long j2 = uVar.f * j;
        uVar.f = j2;
        return j2;
    }

    public void a(m[] mVarArr) {
        if (this.a != null) {
            this.a.post(new v(this, mVarArr));
        }
    }

    protected void onLooperPrepared() {
        this.a = new Handler();
    }
}
