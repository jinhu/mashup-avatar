package com.google.android.apps.androidify;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Picture;
import android.telephony.TelephonyManager;
import com.google.android.C0176a;
import com.google.android.apps.p019b.C0249b;
import com.google.android.apps.p019b.C0250c;
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
    private static final Random f1136a;
    private static Locale f1137b;
    private static ah f1138z;
    private ArrayList f1139c;
    private ArrayList f1140d;
    private ArrayList f1141e;
    private ArrayList f1142f;
    private ArrayList f1143g;
    private ArrayList f1144h;
    private ArrayList f1145i;
    private ArrayList f1146j;
    private ArrayList f1147k;
    private ArrayList f1148l;
    private HashMap f1149m;
    private HashMap f1150n;
    private HashMap f1151o;
    private HashMap f1152p;
    private HashMap f1153q;
    private HashMap f1154r;
    private HashMap f1155s;
    private HashMap f1156t;
    private HashMap f1157u;
    private HashMap f1158v;
    private AssetManager f1159w;
    private Resources f1160x;
    private final Context f1161y;

    static {
        f1136a = new Random();
        f1137b = null;
        f1138z = null;
    }

    public ah(Context context, AssetManager assetManager, Resources resources) {
        this.f1161y = context;
        this.f1159w = assetManager;
        this.f1160x = resources;
        f1137b = resources.getConfiguration().locale;
        try {
            m1653m();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private float m1647a(float f, float f2) {
        return (f1136a.nextFloat() * (f2 - f)) + f;
    }

    public static ah m1648a(Context context) {
        if (f1138z == null) {
            f1138z = new ah(context, context.getAssets(), context.getResources());
        }
        return f1138z;
    }

    private ArrayList m1649a(String str, HashSet hashSet, ai aiVar) {
        ArrayList arrayList = new ArrayList();
        for (ag agVar : aiVar.m1689a(str)) {
            if (hashSet.contains(agVar.f1129b)) {
                arrayList.add(agVar);
            } else {
                C0176a.m1106c("[ASSETS] Warning, " + str + " asset is missing: '" + agVar.f1129b + "'.");
            }
        }
        return arrayList;
    }

    private void m1650a(List list, Map map) {
        map.clear();
        for (ag agVar : list) {
            map.put(agVar.f1129b, agVar);
        }
    }

    private boolean m1651a(Set set, String str) {
        return false;
    }

    private HashSet m1652l(String str) {
        Set n = m1654n();
        HashSet hashSet = new HashSet();
        for (String str2 : this.f1159w.list(str)) {
            int lastIndexOf = str2.lastIndexOf(95);
            if (lastIndexOf == -1) {
                lastIndexOf = str2.lastIndexOf(46);
            }
            if (lastIndexOf == -1) {
                C0176a.m1106c("** Malformed file in assets: " + str + "/" + str2);
            } else if (!m1651a(n, str2)) {
                hashSet.add(str2.substring(0, lastIndexOf));
            }
        }
        return hashSet;
    }

    private void m1653m() {
        ai aiVar = new ai();
        aiVar.m1690a(this.f1161y);
        if (this.f1139c == null) {
            this.f1139c = m1649a("hair", m1652l("hair"), aiVar);
            List list = this.f1139c;
            Map hashMap = new HashMap();
            this.f1149m = hashMap;
            m1650a(list, hashMap);
        }
        if (this.f1140d == null) {
            this.f1140d = m1649a("shirt", m1652l("shirt"), aiVar);
            list = this.f1140d;
            hashMap = new HashMap();
            this.f1150n = hashMap;
            m1650a(list, hashMap);
        }
        if (this.f1141e == null) {
            this.f1141e = m1649a("pants", m1652l("pants"), aiVar);
            list = this.f1141e;
            hashMap = new HashMap();
            this.f1151o = hashMap;
            m1650a(list, hashMap);
        }
        if (this.f1142f == null) {
            this.f1142f = m1649a("shoes", m1652l("shoes"), aiVar);
            list = this.f1142f;
            hashMap = new HashMap();
            this.f1152p = hashMap;
            m1650a(list, hashMap);
        }
        if (this.f1143g == null) {
            this.f1143g = m1649a("glasses", m1652l("glasses"), aiVar);
            list = this.f1143g;
            hashMap = new HashMap();
            this.f1153q = hashMap;
            m1650a(list, hashMap);
        }
        if (this.f1144h == null) {
            this.f1144h = m1649a("beard", m1652l("beard"), aiVar);
            list = this.f1144h;
            hashMap = new HashMap();
            this.f1154r = hashMap;
            m1650a(list, hashMap);
        }
        if (this.f1145i == null) {
            this.f1145i = m1649a("hat", m1652l("hat"), aiVar);
            list = this.f1145i;
            hashMap = new HashMap();
            this.f1155s = hashMap;
            m1650a(list, hashMap);
        }
        if (this.f1146j == null) {
            this.f1146j = m1649a("face", m1652l("face"), aiVar);
            list = this.f1146j;
            hashMap = new HashMap();
            this.f1156t = hashMap;
            m1650a(list, hashMap);
        }
        if (this.f1147k == null) {
            this.f1147k = m1649a("body", m1652l("body"), aiVar);
            list = this.f1147k;
            hashMap = new HashMap();
            this.f1157u = hashMap;
            m1650a(list, hashMap);
        }
        if (this.f1148l == null) {
            this.f1148l = m1649a("hand", m1652l("hand"), aiVar);
            List list2 = this.f1148l;
            Map hashMap2 = new HashMap();
            this.f1158v = hashMap2;
            m1650a(list2, hashMap2);
        }
    }

    private Set m1654n() {
        Set hashSet = new HashSet();
        if (f1137b != null) {
            hashSet.add(f1137b.getCountry().toUpperCase());
        }
        TelephonyManager telephonyManager = (TelephonyManager) this.f1161y.getSystemService("phone");
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

    public ag m1655a(String str, String str2) {
        return str.equals("beard") ? m1678g(str2) : str.equals("face") ? m1682i(str2) : str.equals("hat") ? m1680h(str2) : str.equals("body") ? m1684j(str2) : str.equals("glasses") ? m1676f(str2) : str.equals("hair") ? m1667b(str2) : str.equals("hand") ? m1686k(str2) : str.equals("pants") ? m1672d(str2) : str.equals("shirt") ? m1670c(str2) : str.equals("shoes") ? m1674e(str2) : null;
    }

    public az m1656a() {
        az azVar = new az();
        azVar.m1784b(((ag) this.f1140d.get(7)).f1129b);
        azVar.m1790c(((ag) this.f1141e.get(5)).f1129b);
        azVar.m1794d(((ag) this.f1142f.get(7)).f1129b);
        azVar.m1782b(al.ai[0]);
        azVar.m1774a(0.6f);
        azVar.m1781b(0.6f);
        azVar.m1803g(0.5f);
        azVar.m1806h(1.8f);
        azVar.m1788c(1.1f);
        azVar.m1793d(1.1f);
        azVar.m1797e(0.4f);
        azVar.m1800f(0.9f);
        return azVar;
    }

    public C0249b m1657a(int i) {
        return m1658a(i, null, null);
    }

    public C0249b m1658a(int i, Integer num, Integer num2) {
        try {
            return C0250c.m2017a(this.f1160x.openRawResource(i), num, num2, false);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public C0249b m1659a(ag agVar, az azVar) {
        if (!agVar.f1132e) {
            return m1663a(agVar.f1128a, agVar.f1129b, "chooser", null, null);
        }
        Integer G = azVar.m1771G();
        if (G == null) {
            G = agVar.m1644c();
        }
        Integer H = azVar.m1772H();
        if (H == null) {
            H = agVar.m1645d();
        }
        return m1664a(agVar.f1128a, agVar.f1129b, "chooser", al.f1193d, G, al.f1194e, H);
    }

    public C0249b m1660a(String str) {
        return m1662a("prop", str, null);
    }

    public C0249b m1661a(String str, int i) {
        return m1663a("prop", str, null, al.f1191b, Integer.valueOf(i));
    }

    public C0249b m1662a(String str, String str2, String str3) {
        return m1663a(str, str2, str3, null, null);
    }

    public C0249b m1663a(String str, String str2, String str3, Integer num, Integer num2) {
        return m1664a(str, str2, str3, num, num2, null, null);
    }

    public C0249b m1664a(String str, String str2, String str3, Integer num, Integer num2, Integer num3, Integer num4) {
        String str4 = str + "/" + str2;
        if (!C0176a.m1105b(str3)) {
            str4 = str4 + "_" + str3;
        }
        try {
            InputStream open = this.f1159w.open(str4 + ".svg");
            return open != null ? C0250c.m2016a(open, num, num2, num3, num4, false) : null;
        } catch (FileNotFoundException e) {
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public ArrayList m1665a(SharedPreferences sharedPreferences) {
        Object arrayList = new ArrayList();
        for (String str : sharedPreferences.getAll().keySet()) {
            String str2;
            C0176a.m1106c(str2);
            if (str2.startsWith("savedDroid-")) {
                try {
                    str2 = sharedPreferences.getString(str2, null);
                    az azVar = new az();
                    azVar.m1776a(this.f1161y, str2);
                    if (azVar.m1769E() != null) {
                        C0176a.m1106c(azVar.m1769E() + " " + azVar.m1770F());
                        arrayList.add(azVar);
                    }
                } catch (Throwable e) {
                    C0176a.m1102a("Error reading droid config", e);
                }
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public Picture m1666b(String str, String str2, String str3) {
        C0249b a = m1663a(str, str2, str3, null, null);
        return a == null ? null : a.f1708a;
    }

    public ag m1667b(String str) {
        return (ag) this.f1149m.get(str);
    }

    public az m1668b() {
        az azVar = new az();
        if (f1136a.nextInt(100) < 25) {
            azVar.m1801f(((ag) this.f1144h.get(f1136a.nextInt(this.f1144h.size()))).f1129b);
        }
        if (f1136a.nextInt(100) < 33) {
            azVar.m1798e(((ag) this.f1143g.get(f1136a.nextInt(this.f1143g.size()))).f1129b);
        }
        azVar.m1784b(((ag) this.f1140d.get(f1136a.nextInt(this.f1140d.size()))).f1129b);
        azVar.m1778a(((ag) this.f1139c.get(f1136a.nextInt(this.f1139c.size()))).f1129b);
        azVar.m1790c(((ag) this.f1141e.get(f1136a.nextInt(this.f1141e.size()))).f1129b);
        azVar.m1794d(((ag) this.f1142f.get(f1136a.nextInt(this.f1142f.size()))).f1129b);
        azVar.m1774a(m1647a(0.6f, 1.2f));
        azVar.m1781b(m1647a(0.6f, 1.5f));
        azVar.m1803g(m1647a(0.4f, 1.1f));
        azVar.m1806h(m1647a(0.6f, 3.0f));
        if (azVar.m1815q() > azVar.m1809k()) {
            azVar.m1803g(azVar.m1809k());
        }
        float a = m1647a(0.6f, 1.8f);
        float a2 = m1647a(0.6f, 1.8f);
        if (a / a2 > 1.2f) {
            a2 = a / 1.2f;
        } else if (a2 / a > 1.2f) {
            a = a2 / 1.2f;
        }
        azVar.m1788c(a);
        azVar.m1793d(a2);
        azVar.m1797e(m1647a(0.5f, 1.2f));
        azVar.m1800f(m1647a(0.6f, 1.5f));
        azVar.m1782b(al.ai[f1136a.nextInt(al.ai.length)]);
        azVar.m1775a(al.af[f1136a.nextInt(al.af.length)]);
        return azVar;
    }

    public C0249b m1669b(ag agVar, az azVar) {
        if (!agVar.f1132e) {
            return m1663a(agVar.f1128a, agVar.f1129b, agVar.f1130c, null, null);
        }
        Integer G = azVar.m1771G();
        if (G == null) {
            G = agVar.m1644c();
        }
        Integer H = azVar.m1772H();
        if (H == null) {
            H = agVar.m1645d();
        }
        return m1664a(agVar.f1128a, agVar.f1129b, agVar.f1130c, al.f1193d, G, al.f1194e, H);
    }

    public ag m1670c(String str) {
        return (ag) this.f1150n.get(str);
    }

    public ArrayList m1671c() {
        return this.f1139c;
    }

    public ag m1672d(String str) {
        return (ag) this.f1151o.get(str);
    }

    public ArrayList m1673d() {
        return this.f1140d;
    }

    public ag m1674e(String str) {
        return (ag) this.f1152p.get(str);
    }

    public ArrayList m1675e() {
        return this.f1141e;
    }

    public ag m1676f(String str) {
        return (ag) this.f1153q.get(str);
    }

    public ArrayList m1677f() {
        return this.f1142f;
    }

    public ag m1678g(String str) {
        return (ag) this.f1154r.get(str);
    }

    public ArrayList m1679g() {
        return this.f1143g;
    }

    public ag m1680h(String str) {
        return (ag) this.f1155s.get(str);
    }

    public ArrayList m1681h() {
        return this.f1144h;
    }

    public ag m1682i(String str) {
        return (ag) this.f1156t.get(str);
    }

    public ArrayList m1683i() {
        return this.f1145i;
    }

    public ag m1684j(String str) {
        return (ag) this.f1157u.get(str);
    }

    public ArrayList m1685j() {
        return this.f1146j;
    }

    public ag m1686k(String str) {
        return (ag) this.f1158v.get(str);
    }

    public ArrayList m1687k() {
        return this.f1147k;
    }

    public ArrayList m1688l() {
        return this.f1148l;
    }
}
