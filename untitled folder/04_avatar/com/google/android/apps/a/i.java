package com.google.android.apps.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

public class i {
    private static i a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private int f;
    private String g;
    private Context h;
    private ConnectivityManager i;
    private String j;
    private String k;
    private int l;
    private o m;
    private f n;
    private boolean o;
    private boolean p;
    private a q;
    private e r;
    private Map s;
    private Map t;
    private Handler u;
    private Runnable v;

    static {
        a = new i();
    }

    private i() {
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = 100;
        this.j = "GoogleAnalytics";
        this.k = "1.4.2";
        this.s = new HashMap();
        this.t = new HashMap();
        this.v = new j(this);
    }

    public static i a() {
        return a;
    }

    private void a(String str, String str2, String str3, String str4, int i) {
        h hVar = new h(str, str2, str3, str4, i, this.h.getResources().getDisplayMetrics().widthPixels, this.h.getResources().getDisplayMetrics().heightPixels);
        hVar.a(this.r);
        hVar.b(this.q.a());
        hVar.b(this.e);
        this.r = new e();
        this.m.a(hVar);
        g();
    }

    private void e() {
        if (this.l >= 0 && this.u.postDelayed(this.v, (long) (this.l * 1000)) && this.b) {
            Log.v("GoogleAnalyticsTracker", "Scheduled next dispatch");
        }
    }

    private void f() {
        if (this.u != null) {
            this.u.removeCallbacks(this.v);
        }
    }

    private void g() {
        if (this.o) {
            this.o = false;
            e();
        }
    }

    public void a(int i) {
        int i2 = this.l;
        this.l = i;
        if (i2 <= 0) {
            e();
        } else if (i2 > 0) {
            f();
            e();
        }
    }

    public void a(String str) {
        a(this.g, "__##GOOGLEPAGEVIEW##__", str, null, -1);
    }

    @Deprecated
    public void a(String str, int i, Context context) {
        b(str, i, context);
    }

    void a(String str, int i, Context context, o oVar, f fVar, boolean z) {
        a(str, i, context, oVar, fVar, z, new k(this));
    }

    void a(String str, int i, Context context, o oVar, f fVar, boolean z, g gVar) {
        this.g = str;
        if (context == null) {
            throw new NullPointerException("Context cannot be null");
        }
        this.h = context.getApplicationContext();
        this.m = oVar;
        this.q = new a();
        if (z) {
            this.m.c();
        }
        this.n = fVar;
        this.n.a(gVar);
        this.p = false;
        if (this.i == null) {
            this.i = (ConnectivityManager) this.h.getSystemService("connectivity");
        }
        if (this.u == null) {
            this.u = new Handler(context.getMainLooper());
        } else {
            f();
        }
        a(i);
    }

    void a(String str, int i, Context context, boolean z) {
        if (context == null) {
            throw new NullPointerException("Context cannot be null");
        }
        o xVar;
        f sVar;
        if (this.m == null) {
            xVar = new x(context);
            xVar.a(this.d);
            xVar.a(this.f);
        } else {
            xVar = this.m;
        }
        if (this.n == null) {
            sVar = new s(this.j, this.k);
            sVar.a(this.c);
        } else {
            sVar = this.n;
        }
        a(str, i, context, xVar, sVar, z);
    }

    public void a(String str, String str2, String str3, int i) {
        if (str == null) {
            throw new IllegalArgumentException("category cannot be null");
        } else if (str2 == null) {
            throw new IllegalArgumentException("action cannot be null");
        } else {
            a(this.g, str, str2, str3, i);
        }
    }

    public void b(String str, int i, Context context) {
        a(str, i, context, true);
    }

    public boolean b() {
        if (this.b) {
            Log.v("GoogleAnalyticsTracker", "Called dispatch");
        }
        if (this.p) {
            if (this.b) {
                Log.v("GoogleAnalyticsTracker", "...but dispatcher was busy");
            }
            e();
            return false;
        }
        NetworkInfo activeNetworkInfo = this.i.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            if (this.b) {
                Log.v("GoogleAnalyticsTracker", "...but there was no network available");
            }
            e();
            return false;
        } else if (this.m.b() != 0) {
            m[] a = this.m.a();
            this.n.a(a);
            this.p = true;
            e();
            if (this.b) {
                Log.v("GoogleAnalyticsTracker", "Sending " + a.length + " hits to dispatcher");
            }
            return true;
        } else {
            this.o = true;
            if (!this.b) {
                return false;
            }
            Log.v("GoogleAnalyticsTracker", "...but there was nothing to dispatch");
            return false;
        }
    }

    void c() {
        this.p = false;
    }

    public boolean d() {
        return this.b;
    }
}
