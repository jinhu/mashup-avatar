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

public class AndroidConfig implements Comparable {
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
    private String mHat;
    private String f1320k;
    private String f1321l;
    private String f1322m;
    private String f1323n;
    private String f1324o;
    private String f1325p;
    private float mBodyScaleX;
    private float mBodyScaleY;
    private float mHeadSclaeX;
    private float mHeadScaleY;
    private float mArmScaleX;
    private float mArmScaleY;
    private float mLegScaleX;
    private float mLegScaleY;
    private int mHairColor;
    private int mSkinColor;

    public AndroidConfig() {
        this.f1308B = null;
        this.f1309C = null;
        this.f1310a = System.currentTimeMillis();
    }

    public static AndroidConfig m1762a() {
        AndroidConfig androidConfigVar = new AndroidConfig();
        androidConfigVar.m1797e(1.0f);
        androidConfigVar.m1800f(1.0f);
        androidConfigVar.m1774a(1.0f);
        androidConfigVar.m1781b(1.0f);
        androidConfigVar.m1788c(1.0f);
        androidConfigVar.m1793d(1.0f);
        androidConfigVar.m1803g(1.0f);
        androidConfigVar.m1806h(1.0f);
        androidConfigVar.m1782b(Constants.ANDROID_COLOR.intValue());
        androidConfigVar.m1775a(Constants.f1190a.intValue());
        return androidConfigVar;
    }

    private boolean m1763a(PartConfig aPartConfigVar) {
        return (aPartConfigVar == null || aPartConfigVar.m1643b() == null) ? false : aPartConfigVar.m1643b().equals("nba");
    }

    private static boolean isAccessoryNone(String str) {
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

    public int m1773a(AndroidConfig aAndroidConfigVar) {
        return (this.f1311b == null || aAndroidConfigVar.f1311b == null || this.f1311b.equals(aAndroidConfigVar.f1311b)) ? Double.compare((double) this.f1310a, (double) aAndroidConfigVar.f1310a) : this.f1311b.toUpperCase().compareTo(aAndroidConfigVar.f1311b.toUpperCase());
    }

    public void m1774a(float f) {
        this.mBodyScaleX = f;
    }

    public void m1775a(int i) {
        this.mHairColor = i;
    }

    public void getInstance(Context context, String str) throws Throwable {
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
        this.mBodyScaleX = dataInputStream.readFloat();
        this.mBodyScaleY = dataInputStream.readFloat();
        this.mHeadSclaeX = dataInputStream.readFloat();
        this.mHeadScaleY = dataInputStream.readFloat();
        this.mArmScaleX = dataInputStream.readFloat();
        this.mArmScaleY = dataInputStream.readFloat();
        this.mLegScaleX = dataInputStream.readFloat();
        this.mLegScaleY = dataInputStream.readFloat();
        this.mHairColor = dataInputStream.readInt();
        this.mHairColor = Constants.af[Util.print(this.mHairColor, Constants.af)];
        this.mSkinColor = dataInputStream.readInt();
        this.mSkinColor = Constants.mSkinColors[Util.print(this.mSkinColor, Constants.mSkinColors)];
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
                        this.mHat = partConfigVar.m1642a();
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
                this.mHat = dataInputStream.readUTF();
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
        this.mHat = str2;
    }

    public boolean m1780a(AssetDatabase aAssetDatabaseVar) {
        return m1763a(aAssetDatabaseVar.m1672d(this.f1313d));
    }

    public void m1781b(float f) {
        this.mBodyScaleY = f;
    }

    public void m1782b(int i) {
        this.mSkinColor = i;
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
        return this.f1311b == null
                && this.mArmScaleX == 1.0f && this.mArmScaleY == 1.0f && this.mBodyScaleX == 1.0f && this.mBodyScaleY == 1.0f
                && this.mHeadSclaeX == 1.0f && this.mHeadScaleY == 1.0f && this.mLegScaleX == 1.0f && this.mLegScaleY == 1.0f
                && this.mSkinColor == Constants.ANDROID_COLOR.intValue() &&
                ((this.mHairColor == Constants.f1190a.intValue() || this.mHairColor == -16777216) && isAccessoryNone(this.f1312c) && isAccessoryNone(this.f1313d)
                        && isAccessoryNone(this.f1314e) && isAccessoryNone(this.f1315f) && isAccessoryNone(this.f1316g) && isAccessoryNone(this.f1317h) && isAccessoryNone(this.mHat)
                        && isAccessoryNone(this.f1321l) && isAccessoryNone(this.f1323n) && isAccessoryNone(this.f1325p));
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
        dataOutputStream.writeFloat(this.mBodyScaleX);
        dataOutputStream.writeFloat(this.mBodyScaleY);
        dataOutputStream.writeFloat(this.mHeadSclaeX);
        dataOutputStream.writeFloat(this.mHeadScaleY);
        dataOutputStream.writeFloat(this.mArmScaleX);
        dataOutputStream.writeFloat(this.mArmScaleY);
        dataOutputStream.writeFloat(this.mLegScaleX);
        dataOutputStream.writeFloat(this.mLegScaleY);
        dataOutputStream.writeInt(this.mHairColor);
        dataOutputStream.writeInt(this.mSkinColor);
        dataOutputStream.writeInt(this.f1307A);
        dataOutputStream.writeBoolean(this.f1314e != null);
        if (this.f1314e != null) {
            dataOutputStream.writeUTF(this.f1314e);
        }
        dataOutputStream.writeBoolean(this.mHat != null);
        if (this.mHat != null) {
            dataOutputStream.writeUTF(this.f1318i);
            dataOutputStream.writeUTF(this.mHat);
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
        this.mHeadSclaeX = f;
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
        return m1773a((AndroidConfig) obj);
    }

    public void m1792d() {
        try {
            GoogleAnalyticsTracker a = GoogleAnalyticsTracker.m1177a();
            a.m1189a("Colors", "Hair Color", Constants.m1696c(this.mHairColor), 0);
            a.m1189a("Colors", "Skin Color", Constants.m1695b(this.mSkinColor), 0);
            a.m1189a("Clothes", "Hair", this.f1312c, 0);
            a.m1189a("Clothes", "Shirt", this.f1313d, 0);
            a.m1189a("Clothes", "Pants", this.f1314e, 0);
            a.m1189a("Clothes", "Shoes", this.f1315f, 0);
            a.m1189a("Clothes", "Glasses", this.f1316g, 0);
            a.m1189a("Clothes", "Beard", this.f1317h, 0);
            a.m1189a("Accessories", "Hat", this.mHat, 0);
            a.m1189a("Accessories", "Face", this.f1321l, 0);
            a.m1189a("Accessories", "Body", this.f1323n, 0);
            a.m1189a("Accessories", "Hand", this.f1325p, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void m1793d(float f) {
        this.mHeadScaleY = f;
    }

    public void m1794d(String str) {
        this.f1315f = str;
    }

    public void m1795d(String str, String str2) {
        this.f1324o = str;
        this.f1325p = str2;
    }

    public String getHair() {
        return this.f1312c;
    }

    public void m1797e(float f) {
        this.mArmScaleX = f;
    }

    public void m1798e(String str) {
        this.f1316g = str;
    }

    public String getOutfit() {
        return this.f1313d;
    }

    public void m1800f(float f) {
        this.mArmScaleY = f;
    }

    public void m1801f(String str) {
        this.f1317h = str;
    }

    public String m1802g() {
        return this.f1314e;
    }

    public void m1803g(float f) {
        this.mLegScaleX = f;
    }

    public void m1804g(String str) {
        this.f1311b = str;
    }

    public String m1805h() {
        return this.f1315f;
    }

    public void m1806h(float f) {
        this.mLegScaleY = f;
    }

    public String m1807i() {
        return this.f1316g;
    }

    public String m1808j() {
        return this.f1317h;
    }

    public float getBodyScaleX() {
        return this.mBodyScaleX;
    }

    public float getBodyScaleY() {
        return this.mBodyScaleY;
    }

    public float getHeadScaleX() {
        return this.mHeadSclaeX;
    }

    public float getHeadScaleY() {
        return this.mHeadScaleY;
    }

    public float getArmScaleX() {
        return this.mArmScaleX;
    }

    public float getArmScaleY() {
        return this.mArmScaleY;
    }

    public float getLegScaleX() {
        return this.mLegScaleX;
    }

    public float getLegScaleY() {
        return this.mLegScaleY;
    }

    public int getHairColor() {
        return this.mHairColor;
    }

    public int getSkinColor() {
        return this.mSkinColor;
    }

    public int m1819u() {
        return this.f1307A;
    }

    public String getHat() {
        return this.mHat;
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
