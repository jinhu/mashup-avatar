package com.google.android.apps.androidify;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Picture;
import android.telephony.TelephonyManager;

import com.google.android.Util;

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

import dev.game.legend.svgandroid.SVG;
import dev.game.legend.svgandroid.SVGParser;

public class AssetDatabase {
    private static final Random theRandom;
    private static Locale theLocale;
    private static AssetDatabase theAssetDatabse;

    private ArrayList hairAssets;
    private ArrayList shirtAssets;
    private ArrayList pantsAssets;
    private ArrayList shoeAssets;
    private ArrayList glassAssets;
    private ArrayList beardAssets;
    private ArrayList hatAssets;
    private ArrayList faceAssets;
    private ArrayList bodyAssets;
    private ArrayList handAssets;
    private HashMap mHairAssets;
    private HashMap f1150n;
    private HashMap f1151o;
    private HashMap f1152p;
    private HashMap f1153q;
    private HashMap mBeardCatalog;
    private HashMap mHatCatalog;
    private HashMap mFaceCatalog;
    private HashMap mBodyCatalog;
    private HashMap mHandCatalog;
    private AssetManager mAssetManager;
    private Resources mResources;
    private final Context mContext;

    static {
        theRandom = new Random();
        theLocale = null;
        theAssetDatabse = null;
    }

    public AssetDatabase(Context context, AssetManager assetManager, Resources resources) {
        this.mContext = context;
        this.mAssetManager = assetManager;
        this.mResources = resources;
        theLocale = resources.getConfiguration().locale;
        try {
            scanAssets();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private float m1647a(float f, float f2) {
        return (theRandom.nextFloat() * (f2 - f)) + f;
    }

    public static AssetDatabase instance(Context context) {
        if (theAssetDatabse == null) {
            theAssetDatabse = new AssetDatabase(context, context.getAssets(), context.getResources());
        }
        return theAssetDatabse;
    }

    private ArrayList m1649a(String str, HashSet hashSet, AssetCatalogue aAssetCatalogueVar) {
        ArrayList arrayList = new ArrayList();
        for (PartConfig partConfigVar : aAssetCatalogueVar.getAssets(str)) {
            if (hashSet.contains(partConfigVar.name)) {
                arrayList.add(partConfigVar);
            } else {
                Util.debug("[ASSETS] Warning, " + str + " asset is missing: '" + partConfigVar.name + "'.");
            }
        }
        return arrayList;
    }

    private void precache(List<PartConfig> list, Map map) {
        map.clear();
        for (PartConfig partConfigVar : list) {
            map.put(partConfigVar.name, partConfigVar);
        }
    }

    private boolean m1651a(Set set, String str) {
        return false;
    }

    private HashSet getAssetFromName(String str) throws IOException {
        Set n = m1654n();
        HashSet hashSet = new HashSet();
        for (String str2 : this.mAssetManager.list(str)) {
            int lastIndexOf = str2.lastIndexOf(95);
            if (lastIndexOf == -1) {
                lastIndexOf = str2.lastIndexOf(46);
            }
            if (lastIndexOf == -1) {
                Util.debug("** Malformed file in assets: " + str + "/" + str2);
            } else if (!m1651a(n, str2)) {
                hashSet.add(str2.substring(0, lastIndexOf));
            }
        }
        return hashSet;
    }

    private void scanAssets() throws IOException {
        List list;
        HashMap hashMap;
        AssetCatalogue assetCatalogueVar = new AssetCatalogue();
        assetCatalogueVar.initAssets(this.mContext);
        if (this.hairAssets == null) {
            this.hairAssets = m1649a("hair", getAssetFromName("hair"), assetCatalogueVar);
            list = this.hairAssets;
            hashMap = new HashMap();
            this.mHairAssets = hashMap;
            precache(list, hashMap);
        }
        if (this.shirtAssets == null) {
            this.shirtAssets = m1649a("shirt", getAssetFromName("shirt"), assetCatalogueVar);
            list = this.shirtAssets;
            hashMap = new HashMap();
            this.f1150n = hashMap;
            precache(list, hashMap);
        }
        if (this.pantsAssets == null) {
            this.pantsAssets = m1649a("pants", getAssetFromName("pants"), assetCatalogueVar);
            list = this.pantsAssets;
            hashMap = new HashMap();
            this.f1151o = hashMap;
            precache(list, hashMap);
        }
        if (this.shoeAssets == null) {
            this.shoeAssets = m1649a("shoes", getAssetFromName("shoes"), assetCatalogueVar);
            list = this.shoeAssets;
            hashMap = new HashMap();
            this.f1152p = hashMap;
            precache(list, hashMap);
        }
        if (this.glassAssets == null) {
            this.glassAssets = m1649a("glasses", getAssetFromName("glasses"), assetCatalogueVar);
            list = this.glassAssets;
            hashMap = new HashMap();
            this.f1153q = hashMap;
            precache(list, hashMap);
        }
        if (this.beardAssets == null) {
            this.beardAssets = m1649a("beard", getAssetFromName("beard"), assetCatalogueVar);
            list = this.beardAssets;
            hashMap = new HashMap();
            this.mBeardCatalog = hashMap;
            precache(list, hashMap);
        }
        if (this.hatAssets == null) {
            this.hatAssets = m1649a("hat", getAssetFromName("hat"), assetCatalogueVar);
            list = this.hatAssets;
            hashMap = new HashMap<String , PartConfig>();
            this.mHatCatalog = hashMap;
            precache(list, hashMap);
        }
        if (this.faceAssets == null) {
            this.faceAssets = m1649a("face", getAssetFromName("face"), assetCatalogueVar);
            list = this.faceAssets;
            hashMap = new HashMap();
            this.mFaceCatalog = hashMap;
            precache(list, hashMap);
        }
        if (this.bodyAssets == null) {
            this.bodyAssets = m1649a("body", getAssetFromName("body"), assetCatalogueVar);
            list = this.bodyAssets;
            hashMap = new HashMap();
            this.mBodyCatalog = hashMap;
            precache(list, hashMap);
        }
        if (this.handAssets == null) {
            this.handAssets = m1649a("hand", getAssetFromName("hand"), assetCatalogueVar);
            list = this.handAssets;
            hashMap = new HashMap();
            this.mHandCatalog = hashMap;
            precache(list, hashMap);
        }
    }

    private Set m1654n() {
        Set hashSet = new HashSet();
        if (theLocale != null) {
            hashSet.add(theLocale.getCountry().toUpperCase());
        }
        TelephonyManager telephonyManager = (TelephonyManager) this.mContext.getSystemService(Context.TELEPHONY_SERVICE);
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

    public PartConfig m1655a(String str, String str2) {
        return str.equals("beard") ? m1678g(str2) : str.equals("face") ? m1682i(str2) : str.equals("hat") ? getHatFromString(str2) : str.equals("body") ? m1684j(str2) : str.equals("glasses") ?
                m1676f(str2) : str.equals("hair") ? m1667b(str2) : str.equals("hand") ? m1686k(str2) : str.equals("pants") ? m1672d(str2) : str.equals("shirt") ? m1670c(str2) : str.equals("shoes") ? m1674e(str2) : null;
    }

    public AndroidConfig m1656a() {
        AndroidConfig androidConfigVar = new AndroidConfig();
        androidConfigVar.m1784b(((PartConfig) this.shirtAssets.get(7)).name);
        androidConfigVar.m1790c(((PartConfig) this.pantsAssets.get(5)).name);
        androidConfigVar.m1794d(((PartConfig) this.shoeAssets.get(7)).name);
        androidConfigVar.m1782b(Constants.mSkinColors[0]);
        androidConfigVar.m1774a(0.6f);
        androidConfigVar.m1781b(0.6f);
        androidConfigVar.m1803g(0.5f);
        androidConfigVar.m1806h(1.8f);
        androidConfigVar.m1788c(1.1f);
        androidConfigVar.m1793d(1.1f);
        androidConfigVar.m1797e(0.4f);
        androidConfigVar.m1800f(0.9f);
        return androidConfigVar;
    }



    public dev.game.legend.svgandroid.SVG getSvgFromResource(int i) {
        return getSvgFromResource(i, 0, 0);
    }

    public dev.game.legend.svgandroid.SVG getSvgFromResource(int i, int source, int replace) {
        try {
            //return C0250c.m2017a(this.f1160x.openRawResource(i), num, num2, false);
            InputStream stream = this.mResources.openRawResource(i);
            return SVGParser.getSVGFromInputStream(stream, source, replace);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public dev.game.legend.svgandroid.SVG getSVG(PartConfig aPartConfigVar, AndroidConfig aAndroidConfigVar) {
        if (!aPartConfigVar.f1132e) {
            return getSVG(aPartConfigVar.f1128a, aPartConfigVar.name, "chooser", null, null);
        }
        Integer G = aAndroidConfigVar.m1771G();
        if (G == null) {
            G = aPartConfigVar.m1644c();
        }
        Integer H = aAndroidConfigVar.m1772H();
        if (H == null) {
            H = aPartConfigVar.m1645d();
        }
        return getSVG(aPartConfigVar.f1128a, aPartConfigVar.name, "chooser", Constants.f1193d, G, Constants.f1194e, H);
    }

    public dev.game.legend.svgandroid.SVG getSVG(String str) {
        return getSVG("prop", str, null);
    }

    public dev.game.legend.svgandroid.SVG getSVG(String str, int i) {
        return getSVG("prop", str, null, Constants.ANDROID_COLOR, Integer.valueOf(i));
    }

    public dev.game.legend.svgandroid.SVG getSVG(String str, String str2, String str3) {
        return getSVG(str, str2, str3, null, null);
    }

    public dev.game.legend.svgandroid.SVG getSVG(String str, String str2, String str3, Integer num, Integer num2) {
        return getSVG(str, str2, str3, num, num2, null, null);
    }

    public dev.game.legend.svgandroid.SVG getSVG(String str, String str2, String str3, Integer num, Integer num2, Integer num3, Integer num4) {
        String str4 = str + "/" + str2;
        if (!Util.m1105b(str3)) {
            str4 = str4 + "_" + str3;
        }
        try {
            InputStream open = this.mAssetManager.open(str4 + ".svg");
            return open != null ? SVGParser.parse(open, num, num2, num3, num4, false) : null;
        } catch (FileNotFoundException e) {
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public ArrayList m1665a(SharedPreferences sharedPreferences) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : sharedPreferences.getAll().keySet()) {

            Util.debug(str2);
            if (str2.startsWith("savedDroid-")) {
                try {
                    str2 = sharedPreferences.getString(str2, null);
                    AndroidConfig androidConfigVar = new AndroidConfig();
                    androidConfigVar.getInstance(this.mContext, str2);
                    if (androidConfigVar.m1769E() != null) {
                        Util.debug(androidConfigVar.m1769E() + " " + androidConfigVar.m1770F());
                        arrayList.add(androidConfigVar);
                    }
                } catch (Throwable e) {
                    Util.error("Error reading droid config", e);
                }
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public Picture m1666b(String str, String str2, String str3) {
        SVG a = getSVG(str, str2, str3, null, null);
        return a == null ? null : a.getPicture();
    }

    public PartConfig m1667b(String str) {
        return (PartConfig) this.mHairAssets.get(str);
    }

    public AndroidConfig m1668b() {
        AndroidConfig androidConfigVar = new AndroidConfig();
        if (theRandom.nextInt(100) < 25) {
            androidConfigVar.m1801f(((PartConfig) this.beardAssets.get(theRandom.nextInt(this.beardAssets.size()))).name);
        }
        if (theRandom.nextInt(100) < 33) {
            androidConfigVar.m1798e(((PartConfig) this.glassAssets.get(theRandom.nextInt(this.glassAssets.size()))).name);
        }
        androidConfigVar.m1784b(((PartConfig) this.shirtAssets.get(theRandom.nextInt(this.shirtAssets.size()))).name);
        androidConfigVar.m1778a(((PartConfig) this.hairAssets.get(theRandom.nextInt(this.hairAssets.size()))).name);
        androidConfigVar.m1790c(((PartConfig) this.pantsAssets.get(theRandom.nextInt(this.pantsAssets.size()))).name);
        androidConfigVar.m1794d(((PartConfig) this.shoeAssets.get(theRandom.nextInt(this.shoeAssets.size()))).name);
        androidConfigVar.m1774a(m1647a(0.6f, 1.2f));
        androidConfigVar.m1781b(m1647a(0.6f, 1.5f));
        androidConfigVar.m1803g(m1647a(0.4f, 1.1f));
        androidConfigVar.m1806h(m1647a(0.6f, 3.0f));
        if (androidConfigVar.getLegScaleX() > androidConfigVar.getBodyScaleX()) {
            androidConfigVar.m1803g(androidConfigVar.getBodyScaleX());
        }
        float a = m1647a(0.6f, 1.8f);
        float a2 = m1647a(0.6f, 1.8f);
        if (a / a2 > 1.2f) {
            a2 = a / 1.2f;
        } else if (a2 / a > 1.2f) {
            a = a2 / 1.2f;
        }
        androidConfigVar.m1788c(a);
        androidConfigVar.m1793d(a2);
        androidConfigVar.m1797e(m1647a(0.5f, 1.2f));
        androidConfigVar.m1800f(m1647a(0.6f, 1.5f));
        androidConfigVar.m1782b(Constants.mSkinColors[theRandom.nextInt(Constants.mSkinColors.length)]);
        androidConfigVar.m1775a(Constants.af[theRandom.nextInt(Constants.af.length)]);
        return androidConfigVar;
    }

    public SVG getSvg(PartConfig aPartConfigVar, AndroidConfig aAndroidConfigVar) {
        if (!aPartConfigVar.f1132e) {
            return getSVG(aPartConfigVar.f1128a, aPartConfigVar.name, aPartConfigVar.f1130c, null, null);
        }
        Integer G = aAndroidConfigVar.m1771G();
        if (G == null) {
            G = aPartConfigVar.m1644c();
        }
        Integer H = aAndroidConfigVar.m1772H();
        if (H == null) {
            H = aPartConfigVar.m1645d();
        }
        return getSVG(aPartConfigVar.f1128a, aPartConfigVar.name, aPartConfigVar.f1130c, Constants.f1193d, G, Constants.f1194e, H);
    }

    public PartConfig m1670c(String str) {
        return (PartConfig) this.f1150n.get(str);
    }

    public ArrayList m1671c() {
        return this.hairAssets;
    }

    public PartConfig m1672d(String str) {
        return (PartConfig) this.f1151o.get(str);
    }

    public ArrayList m1673d() {
        return this.shirtAssets;
    }

    public PartConfig m1674e(String str) {
        return (PartConfig) this.f1152p.get(str);
    }

    public ArrayList m1675e() {
        return this.pantsAssets;
    }

    public PartConfig m1676f(String str) {
        return (PartConfig) this.f1153q.get(str);
    }

    public ArrayList m1677f() {
        return this.shoeAssets;
    }

    public PartConfig m1678g(String str) {
        return (PartConfig) this.mBeardCatalog.get(str);
    }

    public ArrayList m1679g() {
        return this.glassAssets;
    }

    public PartConfig getHatFromString(String str) {
        return (PartConfig) this.mHatCatalog.get(str);
    }

    public ArrayList m1681h() {
        return this.beardAssets;
    }

    public PartConfig m1682i(String str) {
        return (PartConfig) this.mFaceCatalog.get(str);
    }

    public ArrayList m1683i() {
        return this.hatAssets;
    }

    public PartConfig m1684j(String str) {
        return (PartConfig) this.mBodyCatalog.get(str);
    }

    public ArrayList m1685j() {
        return this.faceAssets;
    }

    public PartConfig m1686k(String str) {
        return (PartConfig) this.mHandCatalog.get(str);
    }

    public ArrayList m1687k() {
        return this.bodyAssets;
    }

    public ArrayList m1688l() {
        return this.handAssets;
    }
}
