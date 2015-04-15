package com.google.android.apps.a;

import android.os.Build;
import android.os.Build.VERSION;
import java.util.Locale;
import org.apache.http.HttpHost;

class s implements f {
    private final String a;
    private final HttpHost b;
    private u c;
    private boolean d;

    public s() {
        this("GoogleAnalytics", "1.4.2");
    }

    public s(String str, String str2) {
        this(str, str2, "www.google-analytics.com", 80);
    }

    s(String str, String str2, String str3, int i) {
        this.d = false;
        this.b = new HttpHost(str3, i);
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
        this.a = String.format(str4, objArr);
    }

    public void a(g gVar) {
        b();
        this.c = new u(this.a, this, null);
        this.c.start();
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void a(m[] mVarArr) {
        if (this.c != null) {
            this.c.a(mVarArr);
        }
    }

    public boolean a() {
        return this.d;
    }

    public void b() {
        if (this.c != null && this.c.getLooper() != null) {
            this.c.getLooper().quit();
            this.c = null;
        }
    }
}
