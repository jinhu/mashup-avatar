package com.google.android.apps.androidify;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Picture;
import android.telephony.TelephonyManager;
import com.google.android.a;
import com.google.android.apps.b.b;
import com.google.android.apps.b.c;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class ah {
    private static final Random a;
    private static Locale b;
    private static ah z;
    private ArrayList c;
    private ArrayList d;
    private ArrayList e;
    private ArrayList f;
    private ArrayList g;
    private ArrayList h;
    private ArrayList i;
    private ArrayList j;
    private ArrayList k;
    private ArrayList l;
    private HashMap m;
    private HashMap n;
    private HashMap o;
    private HashMap p;
    private HashMap q;
    private HashMap r;
    private HashMap s;
    private HashMap t;
    private HashMap u;
    private HashMap v;
    private AssetManager w;
    private Resources x;
    private final Context y;

    static {
        a = new Random();
        b = null;
        z = null;
    }

    public ah(Context context, AssetManager assetManager, Resources resources) {
        this.y = context;
        this.w = assetManager;
        this.x = resources;
        b = resources.getConfiguration().locale;
        try {
            m();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private float a(float f, float f2) {
        return (a.nextFloat() * (f2 - f)) + f;
    }

    public static ah a(Context context) {
        if (z == null) {
            z = new ah(context, context.getAssets(), context.getResources());
        }
        return z;
    }

    private ArrayList a(String str, HashSet hashSet, ai aiVar) {
        ArrayList arrayList = new ArrayList();
        for (ag agVar : aiVar.a(str)) {
            if (hashSet.contains(agVar.b)) {
                arrayList.add(agVar);
            } else {
                a.c("[ASSETS] Warning, " + str + " asset is missing: '" + agVar.b + "'.");
            }
        }
        return arrayList;
    }

    private void a(List list, Map map) {
        map.clear();
        for (ag agVar : list) {
            map.put(agVar.b, agVar);
        }
    }

    private boolean a(Set set, String str) {
        return false;
    }

    private HashSet l(String str) {
        Set n = n();
        HashSet hashSet = new HashSet();
        for (String str2 : this.w.list(str)) {
            int lastIndexOf = str2.lastIndexOf(95);
            if (lastIndexOf == -1) {
                lastIndexOf = str2.lastIndexOf(46);
            }
            if (lastIndexOf == -1) {
                a.c("** Malformed file in assets: " + str + "/" + str2);
            } else if (!a(n, str2)) {
                hashSet.add(str2.substring(0, lastIndexOf));
            }
        }
        return hashSet;
    }

    private void m() {
        ai aiVar = new ai();
        aiVar.a(this.y);
        if (this.c == null) {
            this.c = a("hair", l("hair"), aiVar);
            List list = this.c;
            Map hashMap = new HashMap();
            this.m = hashMap;
            a(list, hashMap);
        }
        if (this.d == null) {
            this.d = a("shirt", l("shirt"), aiVar);
            list = this.d;
            hashMap = new HashMap();
            this.n = hashMap;
            a(list, hashMap);
        }
        if (this.e == null) {
            this.e = a("pants", l("pants"), aiVar);
            list = this.e;
            hashMap = new HashMap();
            this.o = hashMap;
            a(list, hashMap);
        }
        if (this.f == null) {
            this.f = a("shoes", l("shoes"), aiVar);
            list = this.f;
            hashMap = new HashMap();
            this.p = hashMap;
            a(list, hashMap);
        }
        if (this.g == null) {
            this.g = a("glasses", l("glasses"), aiVar);
            list = this.g;
            hashMap = new HashMap();
            this.q = hashMap;
            a(list, hashMap);
        }
        if (this.h == null) {
            this.h = a("beard", l("beard"), aiVar);
            list = this.h;
            hashMap = new HashMap();
            this.r = hashMap;
            a(list, hashMap);
        }
        if (this.i == null) {
            this.i = a("hat", l("hat"), aiVar);
            list = this.i;
            hashMap = new HashMap();
            this.s = hashMap;
            a(list, hashMap);
        }
        if (this.j == null) {
            this.j = a("face", l("face"), aiVar);
            list = this.j;
            hashMap = new HashMap();
            this.t = hashMap;
            a(list, hashMap);
        }
        if (this.k == null) {
            this.k = a("body", l("body"), aiVar);
            list = this.k;
            hashMap = new HashMap();
            this.u = hashMap;
            a(list, hashMap);
        }
        if (this.l == null) {
            this.l = a("hand", l("hand"), aiVar);
            List list2 = this.l;
            Map hashMap2 = new HashMap();
            this.v = hashMap2;
            a(list2, hashMap2);
        }
    }

    private Set n() {
        Set hashSet = new HashSet();
        if (b != null) {
            hashSet.add(b.getCountry().toUpperCase());
        }
        TelephonyManager telephonyManager = (TelephonyManager) this.y.getSystemService("phone");
        if (telephonyManager != null) {
            String toUpperCase = telephonyManager.getNetworkCountryIso().toUpperCase();
            if (toUpperCase.length() > 0) {
                hashSet.add(toUpperCase);
            }
            if (telephonyManager.getNetworkCountryIso().toUpperCase().length() > 0) {
                hashSet.add(telephonyManager.getSimCountryIso().toUpperCase());
            }
        }
        return hashSet;
    }

    public ag a(String str, String str2) {
        return str.equals("beard") ? g(str2) : str.equals("face") ? i(str2) : str.equals("hat") ? h(str2) : str.equals("body") ? j(str2) : str.equals("glasses") ? f(str2) : str.equals("hair") ? b(str2) : str.equals("hand") ? k(str2) : str.equals("pants") ? d(str2) : str.equals("shirt") ? c(str2) : str.equals("shoes") ? e(str2) : null;
    }

    public az a() {
        az azVar = new az();
        azVar.b(((ag) this.d.get(7)).b);
        azVar.c(((ag) this.e.get(5)).b);
        azVar.d(((ag) this.f.get(7)).b);
        azVar.b(al.ai[0]);
        azVar.a(0.6f);
        azVar.b(0.6f);
        azVar.g(0.5f);
        azVar.h(1.8f);
        azVar.c(1.1f);
        azVar.d(1.1f);
        azVar.e(0.4f);
        azVar.f(0.9f);
        return azVar;
    }

    public b a(int i) {
        return a(i, null, null);
    }

    public b a(int i, Integer num, Integer num2) {
        try {
            return c.a(this.x.openRawResource(i), num, num2, false);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public b a(ag agVar, az azVar) {
        if (!agVar.e) {
            return a(agVar.a, agVar.b, "chooser", null, null);
        }
        Integer G = azVar.G();
        if (G == null) {
            G = agVar.c();
        }
        Integer H = azVar.H();
        if (H == null) {
            H = agVar.d();
        }
        return a(agVar.a, agVar.b, "chooser", al.d, G, al.e, H);
    }

    public b a(String str) {
        return a("prop", str, null);
    }

    public b a(String str, int i) {
        return a("prop", str, null, al.b, Integer.valueOf(i));
    }

    public b a(String str, String str2, String str3) {
        return a(str, str2, str3, null, null);
    }

    public b a(String str, String str2, String str3, Integer num, Integer num2) {
        return a(str, str2, str3, num, num2, null, null);
    }

    public b a(String str, String str2, String str3, Integer num, Integer num2, Integer num3, Integer num4) {
        String str4 = str + "/" + str2;
        if (!a.b(str3)) {
            str4 = str4 + "_" + str3;
        }
        try {
            InputStream open = this.w.open(str4 + ".svg");
            return open != null ? c.a(open, num, num2, num3, num4, false) : null;
        } catch (FileNotFoundException e) {
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public ArrayList a(SharedPreferences sharedPreferences) {
        Object arrayList = new ArrayList();
        for (String str : sharedPreferences.getAll().keySet()) {
            String str2;
            a.c(str2);
            if (str2.startsWith("savedDroid-")) {
                try {
                    str2 = sharedPreferences.getString(str2, null);
                    az azVar = new az();
                    azVar.a(this.y, str2);
                    if (azVar.E() != null) {
                        a.c(azVar.E() + " " + azVar.F());
                        arrayList.add(azVar);
                    }
                } catch (Throwable e) {
                    a.a("Error reading droid config", e);
                }
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public Picture b(String str, String str2, String str3) {
        b a = a(str, str2, str3, null, null);
        return a == null ? null : a.a;
    }

    public ag b(String str) {
        return (ag) this.m.get(str);
    }

    public az b() {
        az azVar = new az();
        if (a.nextInt(100) < 25) {
            azVar.f(((ag) this.h.get(a.nextInt(this.h.size()))).b);
        }
        if (a.nextInt(100) < 33) {
            azVar.e(((ag) this.g.get(a.nextInt(this.g.size()))).b);
        }
        azVar.b(((ag) this.d.get(a.nextInt(this.d.size()))).b);
        azVar.a(((ag) this.c.get(a.nextInt(this.c.size()))).b);
        azVar.c(((ag) this.e.get(a.nextInt(this.e.size()))).b);
        azVar.d(((ag) this.f.get(a.nextInt(this.f.size()))).b);
        azVar.a(a(0.6f, 1.2f));
        azVar.b(a(0.6f, 1.5f));
        azVar.g(a(0.4f, 1.1f));
        azVar.h(a(0.6f, 3.0f));
        if (azVar.q() > azVar.k()) {
            azVar.g(azVar.k());
        }
        float a = a(0.6f, 1.8f);
        float a2 = a(0.6f, 1.8f);
        if (a / a2 > 1.2f) {
            a2 = a / 1.2f;
        } else if (a2 / a > 1.2f) {
            a = a2 / 1.2f;
        }
        azVar.c(a);
        azVar.d(a2);
        azVar.e(a(0.5f, 1.2f));
        azVar.f(a(0.6f, 1.5f));
        azVar.b(al.ai[a.nextInt(al.ai.length)]);
        azVar.a(al.af[a.nextInt(al.af.length)]);
        return azVar;
    }

    public b b(ag agVar, az azVar) {
        if (!agVar.e) {
            return a(agVar.a, agVar.b, agVar.c, null, null);
        }
        Integer G = azVar.G();
        if (G == null) {
            G = agVar.c();
        }
        Integer H = azVar.H();
        if (H == null) {
            H = agVar.d();
        }
        return a(agVar.a, agVar.b, agVar.c, al.d, G, al.e, H);
    }

    public ag c(String str) {
        return (ag) this.n.get(str);
    }

    public ArrayList c() {
        return this.c;
    }

    public ag d(String str) {
        return (ag) this.o.get(str);
    }

    public ArrayList d() {
        return this.d;
    }

    public ag e(String str) {
        return (ag) this.p.get(str);
    }

    public ArrayList e() {
        return this.e;
    }

    public ag f(String str) {
        return (ag) this.q.get(str);
    }

    public ArrayList f() {
        return this.f;
    }

    public ag g(String str) {
        return (ag) this.r.get(str);
    }

    public ArrayList g() {
        return this.g;
    }

    public ag h(String str) {
        return (ag) this.s.get(str);
    }

    public ArrayList h() {
        return this.h;
    }

    public ag i(String str) {
        return (ag) this.t.get(str);
    }

    public ArrayList i() {
        return this.i;
    }

    public ag j(String str) {
        return (ag) this.u.get(str);
    }

    public ArrayList j() {
        return this.j;
    }

    public ag k(String str) {
        return (ag) this.v.get(str);
    }

    public ArrayList k() {
        return this.k;
    }

    public ArrayList l() {
        return this.l;
    }
}
