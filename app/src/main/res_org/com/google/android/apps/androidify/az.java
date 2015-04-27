package com.google.android.apps.androidify;

import android.content.Context;

import com.google.android.apps.analytics.GoogleAnalyticsTracker;
import com.google.android.apps.p017c.C0255b;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

public class az implements Comparable {
    private int f1307A;
    private Integer f1308B;
    private Integer f1309C;
    private long f1310a;
    private String f1311b;
    private String f1312c;
    private String f1313d;
    private String f1314e;
    private String f1315f;
    private String f1316g;
    private String f1317h;
    private String f1318i;
    private String f1319j;
    private String f1320k;
    private String f1321l;
    private String f1322m;
    private String f1323n;
    private String f1324o;
    private String f1325p;
    private float f1326q;
    private float f1327r;
    private float f1328s;
    private float f1329t;
    private float f1330u;
    private float f1331v;
    private float f1332w;
    private float f1333x;
    private int f1334y;
    private int f1335z;

    public az() {
        this.f1308B = null;
        this.f1309C = null;
        this.f1310a = System.currentTimeMillis();
    }

    public static az m1762a() {
        az azVar = new az();
        azVar.m1797e(1.0f);
        azVar.m1800f(1.0f);
        azVar.m1774a(1.0f);
        azVar.m1781b(1.0f);
        azVar.m1788c(1.0f);
        azVar.m1793d(1.0f);
        azVar.m1803g(1.0f);
        azVar.m1806h(1.0f);
        azVar.m1782b(Constants.ANDROID_COLOR.intValue());
        azVar.m1775a(Constants.f1190a.intValue());
        return azVar;
    }

    private boolean m1763a(PartConfig aPartConfigVar) {
        return (aPartConfigVar == null || aPartConfigVar.m1643b() == null) ? false : aPartConfigVar.m1643b().equals("nba");
    }

    private static boolean m1764h(String str) {
        return str == null || str.contains("none");
    }

    public String m1765A() {
        return this.f1322m;
    }

    public String m1766B() {
        return this.f1325p;
    }

    public String m1767C() {
        return this.f1324o;
    }

    public boolean m1768D() {
        return this.f1311b != null;
    }

    public String m1769E() {
        return this.f1311b;
    }

    public long m1770F() {
        return this.f1310a;
    }

    public Integer m1771G() {
        return this.f1308B;
    }

    public Integer m1772H() {
        return this.f1309C;
    }

    public int m1773a(az azVar) {
        return (this.f1311b == null || azVar.f1311b == null || this.f1311b.equals(azVar.f1311b)) ? Double.compare((double) this.f1310a, (double) azVar.f1310a) : this.f1311b.toUpperCase().compareTo(azVar.f1311b.toUpperCase());
    }

    public void m1774a(float f) {
        this.f1326q = f;
    }

    public void m1775a(int i) {
        this.f1334y = i;
    }

    public void m1776a(Context context, String str) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(C0255b.m2068a(str)));
        int readInt = dataInputStream.readInt();
        if (dataInputStream.readBoolean()) {
            this.f1312c = dataInputStream.readUTF();
        }
        if (dataInputStream.readBoolean()) {
            this.f1313d = dataInputStream.readUTF();
        }
        if (dataInputStream.readBoolean()) {
            this.f1315f = dataInputStream.readUTF();
        }
        if (dataInputStream.readBoolean()) {
            this.f1316g = dataInputStream.readUTF();
        }
        if (dataInputStream.readBoolean()) {
            this.f1317h = dataInputStream.readUTF();
        }
        if (dataInputStream.readBoolean()) {
            this.f1310a = dataInputStream.readLong();
        }
        if (dataInputStream.readBoolean()) {
            this.f1311b = dataInputStream.readUTF();
        }
        this.f1326q = dataInputStream.readFloat();
        this.f1327r = dataInputStream.readFloat();
        this.f1328s = dataInputStream.readFloat();
        this.f1329t = dataInputStream.readFloat();
        this.f1330u = dataInputStream.readFloat();
        this.f1331v = dataInputStream.readFloat();
        this.f1332w = dataInputStream.readFloat();
        this.f1333x = dataInputStream.readFloat();
        this.f1334y = dataInputStream.readInt();
        this.f1334y = Constants.af[Util.print(this.f1334y, Constants.af)];
        this.f1335z = dataInputStream.readInt();
        this.f1335z = Constants.mSkinColors[Util.print(this.f1335z, Constants.mSkinColors)];
        this.f1307A = dataInputStream.readInt();
        if (readInt == 1) {
            AssetDatabase a = AssetDatabase.instance(context);
            while (dataInputStream.readBoolean()) {
                PartConfig partConfigVar;
                dataInputStream.readUTF();
                String readUTF = dataInputStream.readUTF();
                Iterator it = a.m1683i().iterator();
                while (it.hasNext()) {
                    partConfigVar = (PartConfig) it.next();
                    if (partConfigVar.m1642a().equals(readUTF)) {
                        this.f1318i = partConfigVar.m1643b();
                        this.f1319j = partConfigVar.m1642a();
                    }
                }
                it = a.m1685j().iterator();
                while (it.hasNext()) {
                    partConfigVar = (PartConfig) it.next();
                    if (partConfigVar.m1642a().equals(readUTF)) {
                        this.f1320k = partConfigVar.m1643b();
                        this.f1321l = partConfigVar.m1642a();
                    }
                }
                it = a.m1687k().iterator();
                while (it.hasNext()) {
                    partConfigVar = (PartConfig) it.next();
                    if (partConfigVar.m1642a().equals(readUTF)) {
                        this.f1322m = partConfigVar.m1643b();
                        this.f1323n = partConfigVar.m1642a();
                    }
                }
                it = a.m1688l().iterator();
                while (it.hasNext()) {
                    partConfigVar = (PartConfig) it.next();
                    if (partConfigVar.m1642a().equals(readUTF)) {
                        this.f1324o = partConfigVar.m1643b();
                        this.f1325p = partConfigVar.m1642a();
                    }
                }
            }
            try {
                if (dataInputStream.readBoolean()) {
                    this.f1314e = dataInputStream.readUTF();
                }
            } catch (Exception e) {
                com.google.android.Util.debug("No pants available in this config.");
            }
        } else {
            if (dataInputStream.readBoolean()) {
                this.f1314e = dataInputStream.readUTF();
            }
            if (dataInputStream.readBoolean()) {
                this.f1318i = dataInputStream.readUTF();
                this.f1319j = dataInputStream.readUTF();
            }
            if (dataInputStream.readBoolean()) {
                this.f1320k = dataInputStream.readUTF();
                this.f1321l = dataInputStream.readUTF();
            }
            if (dataInputStream.readBoolean()) {
                this.f1322m = dataInputStream.readUTF();
                this.f1323n = dataInputStream.readUTF();
            }
            if (dataInputStream.readBoolean()) {
                this.f1324o = dataInputStream.readUTF();
                this.f1325p = dataInputStream.readUTF();
            }
        }
        if (readInt > 2) {
            if (dataInputStream.readBoolean()) {
                this.f1308B = Integer.valueOf(dataInputStream.readInt());
            }
            if (dataInputStream.readBoolean()) {
                this.f1309C = Integer.valueOf(dataInputStream.readInt());
            }
        }
        dataInputStream.close();
    }

    public void m1777a(Integer num) {
        this.f1308B = num;
    }

    public void m1778a(String str) {
        this.f1312c = str;
    }

    public void m1779a(String str, String str2) {
        this.f1318i = str;
        this.f1319j = str2;
    }

    public boolean m1780a(AssetDatabase aAssetDatabaseVar) {
        return m1763a(aAssetDatabaseVar.m1672d(this.f1313d));
    }

    public void m1781b(float f) {
        this.f1327r = f;
    }

    public void m1782b(int i) {
        this.f1335z = i;
    }

    public void m1783b(Integer num) {
        this.f1309C = num;
    }

    public void m1784b(String str) {
        this.f1313d = str;
    }

    public void m1785b(String str, String str2) {
        this.f1320k = str;
        this.f1321l = str2;
    }

    public boolean m1786b() {
        return this.f1311b == null && this.f1330u == 1.0f && this.f1331v == 1.0f && this.f1326q == 1.0f && this.f1327r == 1.0f && this.f1328s == 1.0f && this.f1329t == 1.0f && this.f1332w == 1.0f && this.f1333x == 1.0f && this.f1335z == Constants.ANDROID_COLOR.intValue() && ((this.f1334y == Constants.f1190a.intValue() || this.f1334y == -16777216) && m1764h(this.f1312c) && m1764h(this.f1313d) && m1764h(this.f1314e) && m1764h(this.f1315f) && m1764h(this.f1316g) && m1764h(this.f1317h) && m1764h(this.f1319j) && m1764h(this.f1321l) && m1764h(this.f1323n) && m1764h(this.f1325p));
    }

    public String m1787c() throws IOException {
        boolean z = true;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeInt(3);
        dataOutputStream.writeBoolean(this.f1312c != null);
        if (this.f1312c != null) {
            dataOutputStream.writeUTF(this.f1312c);
        }
        dataOutputStream.writeBoolean(this.f1313d != null);
        if (this.f1313d != null) {
            dataOutputStream.writeUTF(this.f1313d);
        }
        dataOutputStream.writeBoolean(this.f1315f != null);
        if (this.f1315f != null) {
            dataOutputStream.writeUTF(this.f1315f);
        }
        dataOutputStream.writeBoolean(this.f1316g != null);
        if (this.f1316g != null) {
            dataOutputStream.writeUTF(this.f1316g);
        }
        dataOutputStream.writeBoolean(this.f1317h != null);
        if (this.f1317h != null) {
            dataOutputStream.writeUTF(this.f1317h);
        }
        dataOutputStream.writeBoolean(this.f1310a >= 0);
        if (this.f1310a >= 0) {
            dataOutputStream.writeLong(this.f1310a);
        }
        dataOutputStream.writeBoolean(this.f1311b != null);
        if (this.f1311b != null) {
            dataOutputStream.writeUTF(this.f1311b);
        }
        dataOutputStream.writeFloat(this.f1326q);
        dataOutputStream.writeFloat(this.f1327r);
        dataOutputStream.writeFloat(this.f1328s);
        dataOutputStream.writeFloat(this.f1329t);
        dataOutputStream.writeFloat(this.f1330u);
        dataOutputStream.writeFloat(this.f1331v);
        dataOutputStream.writeFloat(this.f1332w);
        dataOutputStream.writeFloat(this.f1333x);
        dataOutputStream.writeInt(this.f1334y);
        dataOutputStream.writeInt(this.f1335z);
        dataOutputStream.writeInt(this.f1307A);
        dataOutputStream.writeBoolean(this.f1314e != null);
        if (this.f1314e != null) {
            dataOutputStream.writeUTF(this.f1314e);
        }
        dataOutputStream.writeBoolean(this.f1319j != null);
        if (this.f1319j != null) {
            dataOutputStream.writeUTF(this.f1318i);
            dataOutputStream.writeUTF(this.f1319j);
        }
        dataOutputStream.writeBoolean(this.f1321l != null);
        if (this.f1321l != null) {
            dataOutputStream.writeUTF(this.f1320k);
            dataOutputStream.writeUTF(this.f1321l);
        }
        dataOutputStream.writeBoolean(this.f1323n != null);
        if (this.f1323n != null) {
            dataOutputStream.writeUTF(this.f1322m);
            dataOutputStream.writeUTF(this.f1323n);
        }
        dataOutputStream.writeBoolean(this.f1325p != null);
        if (this.f1325p != null) {
            dataOutputStream.writeUTF(this.f1324o);
            dataOutputStream.writeUTF(this.f1325p);
        }
        dataOutputStream.writeBoolean(this.f1308B != null);
        if (this.f1308B != null) {
            dataOutputStream.writeInt(this.f1308B.intValue());
        }
        if (this.f1309C == null) {
            z = false;
        }
        dataOutputStream.writeBoolean(z);
        if (this.f1309C != null) {
            dataOutputStream.writeInt(this.f1309C.intValue());
        }
        return "";//C0255b.m2065a(byteArrayOutputStream.toByteArray());
    }

    public void m1788c(float f) {
        this.f1328s = f;
    }

    public void m1789c(int i) {
        this.f1307A = i;
    }

    public void m1790c(String str) {
        this.f1314e = str;
    }

    public void m1791c(String str, String str2) {
        this.f1322m = str;
        this.f1323n = str2;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m1773a((az) obj);
    }

    public void m1792d() {
        try {
            GoogleAnalyticsTracker a = GoogleAnalyticsTracker.m1177a();
            a.m1189a("Colors", "Hair Color", Constants.m1696c(this.f1334y), 0);
            a.m1189a("Colors", "Skin Color", Constants.m1695b(this.f1335z), 0);
            a.m1189a("Clothes", "Hair", this.f1312c, 0);
            a.m1189a("Clothes", "Shirt", this.f1313d, 0);
            a.m1189a("Clothes", "Pants", this.f1314e, 0);
            a.m1189a("Clothes", "Shoes", this.f1315f, 0);
            a.m1189a("Clothes", "Glasses", this.f1316g, 0);
            a.m1189a("Clothes", "Beard", this.f1317h, 0);
            a.m1189a("Accessories", "Hat", this.f1319j, 0);
            a.m1189a("Accessories", "Face", this.f1321l, 0);
            a.m1189a("Accessories", "Body", this.f1323n, 0);
            a.m1189a("Accessories", "Hand", this.f1325p, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void m1793d(float f) {
        this.f1329t = f;
    }

    public void m1794d(String str) {
        this.f1315f = str;
    }

    public void m1795d(String str, String str2) {
        this.f1324o = str;
        this.f1325p = str2;
    }

    public String m1796e() {
        return this.f1312c;
    }

    public void m1797e(float f) {
        this.f1330u = f;
    }

    public void m1798e(String str) {
        this.f1316g = str;
    }

    public String m1799f() {
        return this.f1313d;
    }

    public void m1800f(float f) {
        this.f1331v = f;
    }

    public void m1801f(String str) {
        this.f1317h = str;
    }

    public String m1802g() {
        return this.f1314e;
    }

    public void m1803g(float f) {
        this.f1332w = f;
    }

    public void m1804g(String str) {
        this.f1311b = str;
    }

    public String m1805h() {
        return this.f1315f;
    }

    public void m1806h(float f) {
        this.f1333x = f;
    }

    public String m1807i() {
        return this.f1316g;
    }

    public String m1808j() {
        return this.f1317h;
    }

    public float m1809k() {
        return this.f1326q;
    }

    public float m1810l() {
        return this.f1327r;
    }

    public float m1811m() {
        return this.f1328s;
    }

    public float m1812n() {
        return this.f1329t;
    }

    public float m1813o() {
        return this.f1330u;
    }

    public float m1814p() {
        return this.f1331v;
    }

    public float m1815q() {
        return this.f1332w;
    }

    public float m1816r() {
        return this.f1333x;
    }

    public int m1817s() {
        return this.f1334y;
    }

    public int m1818t() {
        return this.f1335z;
    }

    public int m1819u() {
        return this.f1307A;
    }

    public String m1820v() {
        return this.f1319j;
    }

    public String m1821w() {
        return this.f1318i;
    }

    public String m1822x() {
        return this.f1321l;
    }

    public String m1823y() {
        return this.f1320k;
    }

    public String m1824z() {
        return this.f1323n;
    }
}
