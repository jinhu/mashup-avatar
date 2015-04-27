package com.google.android.apps.p016a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.apps.a.i */
public class C0185i {
    private static C0185i f650a;
    private boolean f651b;
    private boolean f652c;
    private boolean f653d;
    private boolean f654e;
    private int f655f;
    private String f656g;
    private Context f657h;
    private ConnectivityManager f658i;
    private String f659j;
    private String f660k;
    private int f661l;
    private C0191o f662m;
    private C0182f f663n;
    private boolean f664o;
    private boolean f665p;
    private C0177a f666q;
    private C0181e f667r;
    private Map f668s;
    private Map f669t;
    private Handler f670u;
    private Runnable f671v;

    static {
        f650a = new C0185i();
    }

    private C0185i() {
        this.f651b = false;
        this.f652c = false;
        this.f653d = false;
        this.f654e = false;
        this.f655f = 100;
        this.f659j = "GoogleAnalytics";
        this.f660k = "1.4.2";
        this.f668s = new HashMap();
        this.f669t = new HashMap();
        this.f671v = new C0186j(this);
    }

    public static C0185i m1177a() {
        return f650a;
    }

    private void m1178a(String str, String str2, String str3, String str4, int i) {
        C0184h c0184h = new C0184h(str, str2, str3, str4, i, this.f657h.getResources().getDisplayMetrics().widthPixels, this.f657h.getResources().getDisplayMetrics().heightPixels);
        c0184h.m1154a(this.f667r);
        c0184h.m1158b(this.f666q.m1108a());
        c0184h.m1159b(this.f654e);
        this.f667r = new C0181e();
        this.f662m.m1210a(c0184h);
        m1182g();
    }

    private void m1180e() {
        if (this.f661l >= 0 && this.f670u.postDelayed(this.f671v, (long) (this.f661l * 1000)) && this.f651b) {
            Log.v("GoogleAnalyticsTracker", "Scheduled next dispatch");
        }
    }

    private void m1181f() {
        if (this.f670u != null) {
            this.f670u.removeCallbacks(this.f671v);
        }
    }

    private void m1182g() {
        if (this.f664o) {
            this.f664o = false;
            m1180e();
        }
    }

    public void m1183a(int i) {
        int i2 = this.f661l;
        this.f661l = i;
        if (i2 <= 0) {
            m1180e();
        } else if (i2 > 0) {
            m1181f();
            m1180e();
        }
    }

    public void m1184a(String str) {
        m1178a(this.f656g, "__##GOOGLEPAGEVIEW##__", str, null, -1);
    }

    @Deprecated
    public void m1185a(String str, int i, Context context) {
        m1190b(str, i, context);
    }

    void m1186a(String str, int i, Context context, C0191o c0191o, C0182f c0182f, boolean z) {
        m1187a(str, i, context, c0191o, c0182f, z, new C0187k(this));
    }

    void m1187a(String str, int i, Context context, C0191o c0191o, C0182f c0182f, boolean z, C0183g c0183g) {
        this.f656g = str;
        if (context == null) {
            throw new NullPointerException("Context cannot be null");
        }
        this.f657h = context.getApplicationContext();
        this.f662m = c0191o;
        this.f666q = new C0177a();
        if (z) {
            this.f662m.m1214c();
        }
        this.f663n = c0182f;
        this.f663n.m1146a(c0183g);
        this.f665p = false;
        if (this.f658i == null) {
            this.f658i = (ConnectivityManager) this.f657h.getSystemService("connectivity");
        }
        if (this.f670u == null) {
            this.f670u = new Handler(context.getMainLooper());
        } else {
            m1181f();
        }
        m1183a(i);
    }

    void m1188a(String str, int i, Context context, boolean z) {
        if (context == null) {
            throw new NullPointerException("Context cannot be null");
        }
        C0191o c0200x;
        C0182f c0195s;
        if (this.f662m == null) {
            c0200x = new C0200x(context);
            c0200x.m1211a(this.f653d);
            c0200x.m1208a(this.f655f);
        } else {
            c0200x = this.f662m;
        }
        if (this.f663n == null) {
            c0195s = new C0195s(this.f659j, this.f660k);
            c0195s.m1147a(this.f652c);
        } else {
            c0195s = this.f663n;
        }
        m1186a(str, i, context, c0200x, c0195s, z);
    }

    public void m1189a(String str, String str2, String str3, int i) {
        if (str == null) {
            throw new IllegalArgumentException("category cannot be null");
        } else if (str2 == null) {
            throw new IllegalArgumentException("action cannot be null");
        } else {
            m1178a(this.f656g, str, str2, str3, i);
        }
    }

    public void m1190b(String str, int i, Context context) {
        m1188a(str, i, context, true);
    }

    public boolean m1191b() {
        if (this.f651b) {
            Log.v("GoogleAnalyticsTracker", "Called dispatch");
        }
        if (this.f665p) {
            if (this.f651b) {
                Log.v("GoogleAnalyticsTracker", "...but dispatcher was busy");
            }
            m1180e();
            return false;
        }
        NetworkInfo activeNetworkInfo = this.f658i.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            if (this.f651b) {
                Log.v("GoogleAnalyticsTracker", "...but there was no network available");
            }
            m1180e();
            return false;
        } else if (this.f662m.m1213b() != 0) {
            C0189m[] a = this.f662m.m1212a();
            this.f663n.m1148a(a);
            this.f665p = true;
            m1180e();
            if (this.f651b) {
                Log.v("GoogleAnalyticsTracker", "Sending " + a.length + " hits to dispatcher");
            }
            return true;
        } else {
            this.f664o = true;
            if (!this.f651b) {
                return false;
            }
            Log.v("GoogleAnalyticsTracker", "...but there was nothing to dispatch");
            return false;
        }
    }

    void m1192c() {
        this.f665p = false;
    }

    public boolean m1193d() {
        return this.f651b;
    }
}
