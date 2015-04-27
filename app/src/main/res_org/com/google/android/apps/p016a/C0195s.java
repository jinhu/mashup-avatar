package com.google.android.apps.analytics;

import android.os.Build;
import android.os.Build.VERSION;
import java.util.Locale;
import org.apache.http.HttpHost;

/* renamed from: com.google.android.apps.a.s */
class C0195s implements C0182f {
    private final String f689a;
    private final HttpHost f690b;
    private C0197u f691c;
    private boolean f692d;

    public C0195s() {
        this("GoogleAnalytics", "1.4.2");
    }

    public C0195s(String str, String str2) {
        this(str, str2, "www.google-analytics.com", 80);
    }

    C0195s(String str, String str2, String str3, int i) {
        this.f692d = false;
        this.f690b = new HttpHost(str3, i);
        Locale locale = Locale.getDefault();
        String str4 = "%s/%s (Linux; U; Android %s; %s-%s; %s Build/%s)";
        Object[] objArr = new Object[7];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = VERSION.RELEASE;
        objArr[3] = locale.getLanguage() != null ? locale.getLanguage().toLowerCase() : "en";
        objArr[4] = locale.getCountry() != null ? locale.getCountry().toLowerCase() : "";
        objArr[5] = Build.MODEL;
        objArr[6] = Build.ID;
        this.f689a = String.format(str4, objArr);
    }

    public void m1231a(C0183g c0183g) {
        m1235b();
        this.f691c = new C0197u(this.f689a, this, null);
        this.f691c.start();
    }

    public void m1232a(boolean z) {
        this.f692d = z;
    }

    public void m1233a(C0189m[] c0189mArr) {
        if (this.f691c != null) {
            this.f691c.m1250a(c0189mArr);
        }
    }

    public boolean m1234a() {
        return this.f692d;
    }

    public void m1235b() {
        if (this.f691c != null && this.f691c.getLooper() != null) {
            this.f691c.getLooper().quit();
            this.f691c = null;
        }
    }
}
