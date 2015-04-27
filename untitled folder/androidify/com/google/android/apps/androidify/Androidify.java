package com.google.android.apps.androidify;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.Toast;
import com.google.android.C0176a;
import com.google.android.apps.p016a.C0185i;
import com.google.android.apps.p017c.C0203m;
import com.google.android.apps.p017c.C0260g;
import com.google.android.apps.p019b.C0249b;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Androidify extends Activity implements Callback, C0203m {
    private static Locale f734A;
    private static dh f735B;
    private static ArrayList f736I;
    private static ArrayList f737J;
    private static boolean f738K;
    private static int f739O;
    private static float f740P;
    static az f741a;
    private static final Random f742i;
    private static int f743j;
    private static int f744k;
    private static az f745s;
    private static int f746t;
    private boolean f747C;
    private C0216a f748D;
    private bc f749E;
    private Gallery f750F;
    private int f751G;
    private boolean f752H;
    private C0260g f753L;
    private String f754M;
    private az f755N;
    private boolean f756Q;
    private C0185i f757R;
    private ProgressDialog f758S;
    private ImageButton f759T;
    private EditText f760U;
    private an f761V;
    private ImageButton f762W;
    private TutorialView f763X;
    private ah f764Y;
    private SurfaceView f765Z;
    private MediaPlayer aa;
    private SurfaceHolder ab;
    private View ac;
    private View ad;
    private int ae;
    private Handler af;
    private int ag;
    private OnItemLongClickListener ah;
    private OnItemClickListener ai;
    private OnItemClickListener aj;
    private OnDismissListener ak;
    boolean f766b;
    Picture f767c;
    Picture f768d;
    Picture f769e;
    Picture f770f;
    Picture f771g;
    Picture f772h;
    private DroidView f773l;
    private boolean f774m;
    private boolean f775n;
    private long f776o;
    private String f777p;
    private String f778q;
    private az f779r;
    private boolean f780u;
    private bj f781v;
    private boolean f782w;
    private RelativeTouchRecordingLayout f783x;
    private boolean f784y;
    private boolean f785z;

    static {
        f742i = new Random();
        f743j = 0;
        f744k = 0;
        f741a = null;
        f745s = null;
        f746t = -1;
        f734A = null;
        f736I = new ArrayList();
        f737J = new ArrayList();
        f739O = 0;
        f740P = 1.0f;
    }

    public Androidify() {
        this.f774m = false;
        this.f775n = false;
        this.f776o = 0;
        this.f777p = null;
        this.f778q = null;
        this.f779r = null;
        this.f780u = false;
        this.f781v = null;
        this.f782w = false;
        this.f784y = false;
        this.f785z = false;
        this.f747C = true;
        this.f752H = false;
        this.f756Q = false;
        this.ae = -1;
        this.f766b = false;
        this.af = new aa(this);
        this.ag = 0;
        this.ah = new C0232o(this);
        this.ai = new C0233p(this);
        this.aj = new C0235r(this);
        this.ak = new C0236s(this);
    }

    private void m1306A() {
        if (f735B != null) {
            f735B.m1986c(true);
        }
        m1356e(true);
        this.f761V.m1735c();
        if (f735B != null) {
            f735B.m1986c(false);
        }
        m1396j();
        if (this.f754M != null) {
            try {
                FileWriter fileWriter = new FileWriter("/sdcard/events.txt");
                fileWriter.write(this.f754M);
                fileWriter.close();
            } catch (IOException e) {
                Log.e("foobar", e.toString());
            }
            C0176a.m1106c("Playing back touch events.");
            this.f753L.m2108a(new StringBufferInputStream(this.f754M));
        }
    }

    private void m1307B() {
        startActivity(new Intent(this, AboutActivity.class));
    }

    private void m1308C() {
        az azVar = new az();
        m1375a(azVar);
        SharedPreferences preferences = getPreferences(0);
        try {
            preferences.edit().putString("RANDOMIZED_DROID_CONFIG", azVar.m1787c()).commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void m1309D() {
        if (f741a.m1805h() != null) {
            ag e = this.f764Y.m1674e(f741a.m1805h());
            if (e != null) {
                C0249b b = this.f764Y.m1669b(e, f741a);
                this.f773l.m1456a(b.f1708a, b.f1710c);
                return;
            }
            this.f773l.m1456a(null, null);
            return;
        }
        this.f773l.m1456a(null, null);
    }

    private void m1310E() {
        if (f741a.m1807i() != null) {
            C0249b a = this.f764Y.m1662a("glasses", f741a.m1807i(), null);
            this.f773l.setGlasses(a.f1708a);
            if (a.f1710c != null) {
                this.f773l.setGlassesBounds(a.f1710c);
                return;
            }
            return;
        }
        this.f773l.setGlasses(null);
        this.f773l.setGlassesBounds(al.f1213x);
    }

    private void m1311F() {
        if (f741a.m1808j() != null) {
            C0249b a = this.f764Y.m1663a("beard", f741a.m1808j(), null, al.f1190a, Integer.valueOf(al.af[this.f773l.getHairColorIndex()]));
            this.f773l.setBeard(a.f1708a);
            if (a.f1710c != null) {
                this.f773l.setBeardBounds(a.f1710c);
                return;
            }
            return;
        }
        this.f773l.setBeard(null);
        this.f773l.setBeardBounds(al.f1214y);
    }

    private void m1312G() {
        if (f741a.m1820v() != null) {
            ag h = this.f764Y.m1680h(f741a.m1820v());
            if (h != null) {
                this.f773l.setHat(new bg(h, this.f764Y.m1669b(h, f741a)));
                return;
            }
            this.f773l.setHat(null);
            return;
        }
        this.f773l.setHat(null);
    }

    private void m1313H() {
        if (f741a.m1822x() != null) {
            ag i = this.f764Y.m1682i(f741a.m1822x());
            if (i != null) {
                this.f773l.setFace(new bg(i, this.f764Y.m1669b(i, f741a)));
                return;
            }
            this.f773l.setFace(null);
            return;
        }
        this.f773l.setFace(null);
    }

    private void m1314I() {
        if (f741a.m1824z() != null) {
            ag j = this.f764Y.m1684j(f741a.m1824z());
            if (j != null) {
                this.f773l.setBody(new bg(j, this.f764Y.m1669b(j, f741a)));
                return;
            }
            this.f773l.setBody(null);
            return;
        }
        this.f773l.setBody(null);
    }

    private void m1315J() {
        if (f741a.m1766B() != null) {
            ag k = this.f764Y.m1686k(f741a.m1766B());
            if (k != null) {
                this.f773l.setHand(new bg(k, this.f764Y.m1669b(k, f741a)));
                return;
            }
            this.f773l.setHand(null);
            return;
        }
        this.f773l.setHand(null);
    }

    private void m1316K() {
        Picture picture = null;
        if (f741a.m1796e() != null) {
            String e = f741a.m1796e();
            C0249b a = this.f764Y.m1663a("hair", e, "back", al.f1190a, Integer.valueOf(al.af[this.f773l.getHairColorIndex()]));
            C0249b a2 = this.f764Y.m1662a("hair", e, "backextra");
            C0249b a3 = this.f764Y.m1663a("hair", e, "front", al.f1190a, Integer.valueOf(al.af[this.f773l.getHairColorIndex()]));
            C0249b a4 = this.f764Y.m1662a("hair", e, "frontextra");
            RectF rectF = new RectF(al.f1212w);
            if (!(a == null || a.f1710c == null)) {
                rectF.union(a.f1710c);
            }
            if (!(a3 == null || a3.f1710c == null)) {
                rectF.union(a3.f1710c);
            }
            if (!(a2 == null || a2.f1710c == null)) {
                rectF.union(a2.f1710c);
            }
            if (!(a4 == null || a4.f1710c == null)) {
                rectF.union(a4.f1710c);
            }
            this.f773l.setHairBack(a == null ? null : a.f1708a);
            this.f773l.setHairFront(a3 == null ? null : a3.f1708a);
            this.f773l.setHairBackExtra(a2 == null ? null : a2.f1708a);
            DroidView droidView = this.f773l;
            if (a4 != null) {
                picture = a4.f1708a;
            }
            droidView.setHairFrontExtra(picture);
            this.f773l.setHairBounds(rectF);
            return;
        }
        this.f773l.setHairBack(null);
        this.f773l.setHairBackExtra(null);
        this.f773l.setHairFront(null);
        this.f773l.setHairFrontExtra(null);
        this.f773l.setHairBounds(al.f1212w);
    }

    private void m1317L() {
        if (f741a.m1799f() != null) {
            String f = f741a.m1799f();
            this.f773l.setShirtArm(this.f764Y.m1666b("shirt", f, "arm"));
            this.f773l.setShirtBody(this.f764Y.m1666b("shirt", f, "body"));
            this.f773l.setShirtTop(this.f764Y.m1666b("shirt", f, "top"));
            this.f773l.setShirtBottom(this.f764Y.m1666b("shirt", f, "bottom"));
            return;
        }
        this.f773l.setShirtArm(null);
        this.f773l.setShirtBody(null);
        this.f773l.setShirtTop(null);
        this.f773l.setShirtBottom(null);
    }

    private void m1318M() {
        int i = al.ai[this.f773l.getSkinColorIndex()];
        this.f773l.m1454a(this.f764Y.m1658a((int) R.raw.android_leg, al.f1191b, Integer.valueOf(i)).f1708a, this.f764Y.m1658a((int) R.raw.android_foot, al.f1191b, Integer.valueOf(i)).f1708a);
    }

    private void m1319N() {
        if (f741a.m1802g() != null) {
            String g = f741a.m1802g();
            this.f773l.setPantsLeg(this.f764Y.m1666b("pants", g, "leg"));
            this.f773l.setPantsSkirt(this.f764Y.m1666b("pants", g, "skirt"));
            this.f773l.setPantsTop(this.f764Y.m1666b("pants", g, "top"));
            return;
        }
        this.f773l.setPantsLeg(null);
        this.f773l.setPantsSkirt(null);
        this.f773l.setPantsTop(null);
    }

    private void m1320O() {
        int i = al.ai[this.f773l.getSkinColorIndex()];
        this.f773l.m1455a(this.f764Y.m1658a((int) R.raw.android_head, al.f1191b, Integer.valueOf(i)).f1708a, this.f764Y.m1658a((int) R.raw.android_body, al.f1191b, Integer.valueOf(i)).f1708a, this.f764Y.m1658a((int) R.raw.android_arm, al.f1191b, Integer.valueOf(i)).f1708a, this.f764Y.m1658a((int) R.raw.android_antenna, al.f1191b, Integer.valueOf(i)).f1708a);
    }

    private void m1321P() {
        az azVar = new az();
        m1375a(azVar);
        ShareActivity.m1535a((Activity) this, azVar);
    }

    private boolean m1322Q() {
        return m1356e(false);
    }

    private void m1323R() {
        m1370a(0);
        m1383b(0);
    }

    private void m1324S() {
        f743j = 0;
        this.f750F = null;
        this.f773l.setVisibility(0);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.main_layout);
        View findViewById = findViewById(14445);
        Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) viewGroup.getHeight());
        translateAnimation.setDuration(450);
        translateAnimation.setAnimationListener(new C0231n(this, viewGroup, findViewById));
        findViewById.startAnimation(translateAnimation);
    }

    private void m1325T() {
        m1375a(f741a);
        if (!f741a.m1786b()) {
            m1352d(f741a);
        }
        m1327V();
    }

    private void m1326U() {
        if (f741a == null || !f741a.m1768D()) {
            m1328W();
        }
    }

    private void m1327V() {
        if (f741a == null) {
            f741a = new az();
        }
        m1375a(f741a);
        SharedPreferences preferences = getPreferences(0);
        try {
            preferences.edit().putString("DROID_CONFIG", f741a.m1787c()).apply();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void m1328W() {
        String string = getPreferences(0).getString("DROID_CONFIG", null);
        if (string != null) {
            f741a = new az();
            try {
                f741a.m1776a((Context) this, string);
            } catch (IOException e) {
                e.printStackTrace();
                f741a = null;
            }
        }
    }

    private void m1329X() {
        if (f741a == null || f741a.m1769E() == null) {
            this.f760U.setText("");
        } else {
            this.f760U.setText(f741a.m1769E());
        }
    }

    private void m1330Y() {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.f760U.getWindowToken(), 0);
    }

    public static float m1331a() {
        return f740P;
    }

    public static ArrayList m1335a(Activity activity, boolean z) {
        List arrayList = new ArrayList();
        C0220c.m1912a("Local class name: " + activity.getLocalClassName());
        SharedPreferences b = m1345b(activity);
        for (String str : b.getAll().keySet()) {
            String str2;
            C0176a.m1106c(str2);
            if (str2.startsWith("savedDroid-")) {
                try {
                    str2 = b.getString(str2, null);
                    az azVar = new az();
                    azVar.m1776a((Context) activity, str2);
                    if (azVar.m1769E() != null) {
                        C0176a.m1106c(azVar.m1769E() + " " + azVar.m1770F());
                    } else {
                        azVar.m1804g("");
                    }
                    arrayList.add(azVar);
                } catch (Throwable e) {
                    C0176a.m1102a("Error reading droid config", e);
                }
            }
        }
        if (arrayList.size() < 1) {
            if (z) {
                Toast.makeText(activity, R.string.error_no_saved_droids, 0).show();
            }
            return arrayList;
        }
        Collections.sort(arrayList, new ad());
        return arrayList;
    }

    public static void m1336a(float f, float f2, float f3, float f4) {
        float f5 = 2.0f / (f + f2);
        if (f735B != null) {
            f735B.m1977a(f5, f3, f4);
        }
    }

    public static void m1337a(Activity activity) {
        Intent intent = new Intent(activity, Androidify.class);
        intent.addFlags(67108864);
        activity.startActivity(intent);
    }

    public static void m1338a(Activity activity, az azVar) {
        m1345b(activity).edit().remove("savedDroid-" + azVar.m1770F()).commit();
        C0176a.m1104a(activity.getCacheDir(), azVar.m1770F() + ".png");
    }

    private void m1339a(View view, boolean z) {
        m1341a(view, z, 1.0f, null);
    }

    private void m1340a(View view, boolean z, float f) {
        m1341a(view, z, f, null);
    }

    private void m1341a(View view, boolean z, float f, Runnable runnable) {
        float alpha = view.getAlpha();
        long j = (long) (250.0f * f);
        int i = z ? 1 : 0;
        if (view.getVisibility() != 0) {
            alpha = 0.0f;
        }
        if (alpha != ((float) i)) {
            Animation alphaAnimation = new AlphaAnimation(alpha, (float) i);
            alphaAnimation.setDuration(j);
            alphaAnimation.setAnimationListener(new C0247z(this, view, z, runnable));
            view.startAnimation(alphaAnimation);
        }
    }

    private void m1343a(CharSequence charSequence) {
        this.f780u = false;
        if (charSequence.equals("randomize")) {
            m1356e(true);
            this.f780u = true;
            this.f761V.m1735c();
        } else if (charSequence.equals(getString(R.string.menu_share))) {
            m1321P();
            m1398l();
        } else if (charSequence.equals(getString(R.string.menu_about))) {
            m1307B();
            m1399o();
        } else if (charSequence.equals(getString(R.string.menu_create_new))) {
            m1306A();
        } else if (charSequence.equals("share_to_website")) {
            ShareToWebsiteActivity.m1562a((Activity) this, f741a);
            m1399o();
        } else if (charSequence.equals(getString(R.string.menu_my_androids))) {
            this.f757R.m1184a("showGallery");
            ArrayList a = m1335a((Activity) this, true);
            if (a != null && a.size() > 0) {
                startActivityForResult(new Intent(this, GalleryActivity.class), 100);
            }
            m1397k();
        }
    }

    public static SharedPreferences m1345b(Activity activity) {
        return activity.getSharedPreferences("Androidify", 0);
    }

    private void m1350c(az azVar) {
        f741a = azVar;
        this.f773l.setHairColorIndex(C0176a.m1096a(al.af, azVar.m1817s()));
        this.f773l.setSkinColorIndex(C0176a.m1096a(al.ai, azVar.m1818t()));
        this.f773l.setPantsColorIndex(C0176a.m1096a(al.al, azVar.m1819u()));
        m1320O();
        m1318M();
        m1316K();
        m1317L();
        m1319N();
        m1309D();
        m1310E();
        m1311F();
        m1312G();
        m1313H();
        m1314I();
        m1315J();
        this.f773l.m1452a(azVar.m1809k(), azVar.m1810l(), azVar.m1811m(), azVar.m1812n(), azVar.m1813o(), azVar.m1814p(), azVar.m1815q(), azVar.m1816r());
    }

    private boolean m1352d(az azVar) {
        if (azVar == null) {
            try {
                azVar = f741a;
                m1375a(azVar);
            } catch (Exception e) {
                Toast.makeText(this, getString(R.string.error_save_droid_failed), 1).show();
                return false;
            }
        }
        SharedPreferences preferences = getPreferences(0);
        try {
            String c = azVar.m1787c();
            C0176a.m1106c("-----------");
            C0176a.m1106c(c);
            C0220c.m1912a("[ENCODE] " + c);
            C0176a.m1106c("-----------");
            preferences.edit().putString("savedDroid-" + azVar.m1770F(), c).apply();
            this.f757R.m1184a("saveDroid");
            C0176a.m1104a(getCacheDir(), azVar.m1770F() + ".png");
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return true;
    }

    private void m1355e(az azVar) {
        f743j = 0;
        m1350c(azVar);
        f741a = azVar;
        m1327V();
        m1329X();
        Toast.makeText(getApplicationContext(), getString(R.string.msg_droid_loaded), 0).show();
        if (f735B != null) {
            f735B.m1982b();
        }
    }

    private boolean m1356e(boolean z) {
        if (z) {
            m1308C();
        }
        f741a = new az();
        this.f773l.m1466c();
        m1323R();
        m1375a(f741a);
        m1327V();
        this.f773l.m1471e();
        m1350c(f741a);
        this.f773l.invalidate();
        m1329X();
        return true;
    }

    private void m1358f(boolean z) {
        this.f773l.m1480m();
        ArrayList a = m1335a((Activity) this, true);
        if (a != null && a.size() != 0) {
            View frameLayout = new FrameLayout(this);
            Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
            int width = defaultDisplay.getWidth();
            int height = defaultDisplay.getHeight();
            Paint paint = new Paint();
            paint.setDither(true);
            float a2 = bs.m1889a(this, width, height, m1331a());
            Paint paint2 = new Paint();
            paint2.setFlags(1);
            paint.setShader(new LinearGradient((float) (width / 2), 0.0f, (float) (width / 2), ((float) height) - ((3.0f * a2) / 4.0f), -2236963, -6250336, TileMode.CLAMP));
            View c0227j = new C0227j(this, this, a2, paint, paint2);
            this.f750F = new Gallery(this);
            this.f750F.setLayoutParams(new LayoutParams(-1, -1));
            this.f749E = new bc(this, a, this.f750F, a2);
            this.f750F.setAdapter(this.f749E);
            this.f750F.setOnItemClickListener(this.aj);
            this.f750F.setUnselectedAlpha(1.0f);
            this.f750F.setCallbackDuringFling(false);
            this.f750F.setCallbackDuringFling(false);
            this.f750F.setOnItemSelectedListener(new C0228k(this));
            this.f750F.setOnItemLongClickListener(new C0229l(this));
            frameLayout.addView(c0227j);
            frameLayout.addView(this.f750F);
            frameLayout.setLayoutParams(new LayoutParams(-1, -1));
            frameLayout.setId(14445);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.main_layout);
            viewGroup.addView(frameLayout);
            if (z) {
                Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) viewGroup.getHeight(), 0.0f);
                translateAnimation.setDuration(450);
                translateAnimation.setAnimationListener(new C0230m(this));
                frameLayout.startAnimation(translateAnimation);
                if (f735B != null) {
                    f735B.m1982b();
                }
            } else {
                this.f773l.setVisibility(8);
                this.f749E.m1869a(5);
            }
            f743j = 1;
        }
    }

    public static void m1364m() {
        f738K = true;
        if (f735B != null) {
            f735B.m1976a(1.0f);
        }
    }

    public static void m1365n() {
        if (f738K && f735B != null) {
            C0176a.m1106c("Drag ends!");
            f735B.m1990g();
        }
        f738K = false;
    }

    private void m1368y() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        f739O = Math.min(displayMetrics.heightPixels, displayMetrics.widthPixels) / 5;
        f740P = ((float) f739O) / 64.0f;
    }

    private void m1369z() {
        long currentTimeMillis = System.currentTimeMillis();
        if (f735B == null) {
            this.f773l.postDelayed(new ab(this), 0);
        } else {
            f735B.m1975a();
        }
        C0176a.m1106c("Sound start-up: " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void m1370a(int i) {
        this.f773l.setHairColorIndex(i);
        m1316K();
        m1311F();
        this.f773l.invalidate();
        m1381a(true, this.f773l.getHairColorIndex());
    }

    public void m1371a(int i, boolean z) {
        this.f773l.m1453a(i, z);
    }

    public void m1372a(DroidView droidView) {
        if (this.f767c == null) {
            this.f767c = this.f764Y.m1658a((int) R.raw.android_head, al.f1191b, al.f1192c).f1708a;
            this.f768d = this.f764Y.m1658a((int) R.raw.android_body, al.f1191b, al.f1192c).f1708a;
            this.f769e = this.f764Y.m1658a((int) R.raw.android_arm, al.f1191b, al.f1192c).f1708a;
            this.f770f = this.f764Y.m1658a((int) R.raw.android_antenna, al.f1191b, al.f1192c).f1708a;
            this.f771g = this.f764Y.m1658a((int) R.raw.android_leg, al.f1191b, al.f1192c).f1708a;
            this.f772h = this.f764Y.m1658a((int) R.raw.android_foot, al.f1191b, al.f1192c).f1708a;
        }
        droidView.setHairBack(null);
        droidView.setHairFront(null);
        droidView.setHairBounds(al.f1212w);
        droidView.setBeardBounds(al.f1214y);
        droidView.setGlassesBounds(al.f1213x);
        droidView.setBeard(null);
        droidView.setHat(null);
        droidView.setFace(null);
        droidView.setBody(null);
        droidView.setHand(null);
        droidView.setGlasses(null);
        droidView.setShirtArm(null);
        droidView.setShirtBody(null);
        droidView.setShirtTop(null);
        droidView.setShirtBottom(null);
        droidView.setPantsLeg(null);
        droidView.setPantsSkirt(null);
        droidView.setPantsTop(null);
        droidView.m1456a(null, null);
        droidView.m1455a(this.f767c, this.f768d, this.f769e, this.f770f);
        droidView.m1454a(this.f771g, this.f772h);
        droidView.m1466c();
    }

    public void m1373a(DroidView droidView, az azVar) {
    }

    public void m1374a(av avVar) {
        this.f773l.post(new C0226i(this, avVar));
    }

    public void m1375a(az azVar) {
        try {
            azVar.m1804g(f741a.m1769E());
            azVar.m1778a(f741a.m1796e());
            azVar.m1784b(f741a.m1799f());
            azVar.m1790c(f741a.m1802g());
            azVar.m1794d(f741a.m1805h());
            azVar.m1798e(f741a.m1807i());
            azVar.m1794d(f741a.m1805h());
            azVar.m1798e(f741a.m1807i());
            azVar.m1801f(f741a.m1808j());
            azVar.m1779a(f741a.m1821w(), f741a.m1820v());
            azVar.m1785b(f741a.m1823y(), f741a.m1822x());
            azVar.m1791c(f741a.m1765A(), f741a.m1824z());
            azVar.m1795d(f741a.m1767C(), f741a.m1766B());
            azVar.m1774a(this.f773l.getDroidBody().f1501b);
            azVar.m1781b(this.f773l.getDroidBody().f1502c);
            azVar.m1788c(this.f773l.getDroidHead().f1501b);
            azVar.m1793d(this.f773l.getDroidHead().f1502c);
            azVar.m1797e(this.f773l.getDroidArm().f1501b);
            azVar.m1800f(this.f773l.getDroidArm().f1502c);
            azVar.m1803g(this.f773l.getDroidLegs().f1501b);
            azVar.m1806h(this.f773l.getDroidLegs().f1502c);
            azVar.m1775a(al.af[this.f773l.getHairColorIndex()]);
            azVar.m1782b(al.ai[this.f773l.getSkinColorIndex()]);
            azVar.m1789c(al.al[this.f773l.getPantsColorIndex()]);
            azVar.m1777a(f741a.m1771G());
            azVar.m1783b(f741a.m1772H());
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public void m1376a(dk dkVar, boolean z) {
        if (f735B == null) {
            return;
        }
        if (z) {
            f735B.m1985c();
        } else {
            f735B.m1983b(dkVar);
        }
    }

    public void m1377a(String str) {
        if (str == null) {
            return;
        }
        if (str.equals("shoes")) {
            this.f773l.m1465b(bh.SHOES);
        } else if (str.equals("glasses")) {
            this.f773l.m1465b(bh.GLASSES);
        } else if (str.equals("beard")) {
            this.f773l.m1465b(bh.BEARD);
        } else if (str.equals("hair")) {
            this.f773l.m1465b(bh.HAIR);
        } else if (str.equals("pants")) {
            this.f773l.m1465b(bh.PANTS);
        } else if (str.equals("shirt")) {
            this.f773l.m1465b(bh.SHIRT);
        }
    }

    public void m1378a(String str, ag agVar, boolean z) {
        m1379a(str, agVar, z, true);
    }

    public void m1379a(String str, ag agVar, boolean z, boolean z2) {
        String str2 = null;
        String str3 = agVar.f1129b;
        String str4 = agVar.f1130c;
        Object obj = null;
        if (!agVar.f1132e) {
            if (agVar.f1133f != null) {
                f741a.m1777a(agVar.f1133f);
                obj = 1;
            }
            if (agVar.f1134g != null) {
                f741a.m1783b(agVar.f1134g);
                obj = 1;
            }
        }
        if ("shirt".equals(str)) {
            f741a.m1784b(z ? null : str3);
            m1317L();
            m1376a(dk.SHIRTS_PANTS, z);
            this.f773l.m1460a(bh.SHIRT);
        } else if ("pants".equals(str)) {
            r1 = f741a;
            if (!z) {
                str2 = str3;
            }
            r1.m1790c(str2);
            m1319N();
            m1376a(dk.SHIRTS_PANTS, z);
            this.f773l.m1460a(bh.PANTS);
        } else if ("shoes".equals(str)) {
            r1 = f741a;
            if (!z) {
                str2 = str3;
            }
            r1.m1794d(str2);
            m1309D();
            m1376a(dk.SHOES, z);
            this.f773l.m1460a(bh.SHOES);
        } else if ("hair".equals(str)) {
            r1 = f741a;
            if (!z) {
                str2 = str3;
            }
            r1.m1778a(str2);
            m1316K();
            m1376a(dk.HAIR, z);
            this.f773l.m1460a(bh.HAIR);
        } else if ("glasses".equals(str)) {
            r1 = f741a;
            if (!z) {
                str2 = str3;
            }
            r1.m1798e(str2);
            m1310E();
            m1376a(dk.GLASSES_ACCESSORIES, z);
        } else if ("beard".equals(str)) {
            r1 = f741a;
            if (!z) {
                str2 = str3;
            }
            r1.m1801f(str2);
            m1311F();
            m1376a(dk.HAIR, z);
        } else if ("hat".equals(str)) {
            r1 = f741a;
            if (!z) {
                str2 = str3;
            }
            r1.m1779a(str4, str2);
            m1312G();
            m1376a(dk.HAIR, z);
            this.f773l.m1460a(bh.HAIR);
        } else if ("face".equals(str)) {
            r1 = f741a;
            if (!z) {
                str2 = str3;
            }
            r1.m1785b(str4, str2);
            m1313H();
            m1376a(dk.GLASSES_ACCESSORIES, z);
        } else if ("body".equals(str)) {
            r1 = f741a;
            if (!z) {
                str2 = str3;
            }
            r1.m1791c(str4, str2);
            m1314I();
            m1376a(dk.HAIR, z);
            this.f773l.m1460a(bh.SHIRT);
        } else if ("hand".equals(str)) {
            r1 = f741a;
            if (!z) {
                str2 = str3;
            }
            r1.m1795d(str4, str2);
            m1315J();
            m1376a(dk.GLASSES_ACCESSORIES, z);
        }
        if (obj != null) {
            m1312G();
            m1313H();
            m1314I();
            m1315J();
            m1309D();
        }
        if (z2) {
            m1377a(str);
        }
    }

    public void m1380a(boolean z) {
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.main_layout);
        if (viewGroup == null) {
            return;
        }
        if (z) {
            viewGroup.postInvalidate();
        } else {
            viewGroup.invalidate();
        }
    }

    public void m1381a(boolean z, int i) {
        if (f735B != null) {
            f735B.m1981a(z, i);
        }
    }

    public void m1382b() {
        this.f756Q = true;
        this.f755N = new az();
        m1375a(this.f755N);
        m1356e(false);
        this.f761V.m1735c();
        this.f773l.m1480m();
        this.f773l.m1479l();
    }

    public void m1383b(int i) {
        this.f773l.setSkinColorIndex(i);
        m1320O();
        m1318M();
        this.f773l.invalidate();
        m1381a(false, i);
        this.f773l.m1468c(1);
    }

    public void m1384b(boolean z) {
        if (!z) {
            this.f773l.postDelayed(new ac(this), this.f773l.m1479l() + 500);
        } else if (this.f755N != null) {
            m1350c(this.f755N);
            this.f755N = null;
        }
        this.f756Q = false;
    }

    public C0216a m1385c() {
        return this.f748D;
    }

    public void m1386c(int i) {
        this.f773l.m1468c(i);
    }

    public void m1387c(boolean z) {
        this.f747C = z;
    }

    public void closeDrawerClicked(View view) {
        if (this.f761V != null) {
            m1393g();
            this.f761V.m1732a(null);
        }
    }

    public void m1388d() {
        if (this.f781v != null) {
            this.f781v.m1871a();
            this.f781v = null;
        }
    }

    public void m1389d(int i) {
        this.f773l.m1464b(i);
    }

    public void m1390d(boolean z) {
        boolean z2 = true;
        C0176a.m1106c("Randomize Droid");
        if (z) {
            m1308C();
        }
        f741a = new az();
        this.f773l.m1469d();
        m1383b(f742i.nextInt(al.ai.length));
        m1370a(f742i.nextInt(al.af.length));
        int nextInt = f742i.nextInt(this.f764Y.m1673d().size());
        m1378a("shirt", (ag) this.f764Y.m1673d().get(nextInt), nextInt == 0);
        m1317L();
        nextInt = f742i.nextInt(this.f764Y.m1671c().size());
        m1378a("hair", (ag) this.f764Y.m1671c().get(nextInt), nextInt == 0);
        m1316K();
        nextInt = f742i.nextInt(this.f764Y.m1677f().size());
        m1378a("shoes", (ag) this.f764Y.m1677f().get(nextInt), nextInt == 0);
        m1309D();
        nextInt = f742i.nextInt(this.f764Y.m1675e().size());
        m1378a("pants", (ag) this.f764Y.m1675e().get(nextInt), nextInt == 0);
        m1319N();
        if (f742i.nextInt(100) < 33) {
            nextInt = f742i.nextInt(this.f764Y.m1679g().size());
            m1378a("glasses", (ag) this.f764Y.m1679g().get(nextInt), nextInt == 0);
        }
        m1310E();
        if (f742i.nextInt(100) < 25) {
            nextInt = f742i.nextInt(this.f764Y.m1681h().size());
            String str = "beard";
            ag agVar = (ag) this.f764Y.m1681h().get(nextInt);
            if (nextInt != 0) {
                z2 = false;
            }
            m1378a(str, agVar, z2);
        }
        m1311F();
        m1375a(f741a);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 24 || keyEvent.getKeyCode() == 25 || !this.f756Q || this.f753L.m2111c()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        showDialog(10);
        return true;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.f756Q || this.f753L.m2111c()) {
            if (this.f760U.hasFocus()) {
                this.f760U.clearFocus();
                m1330Y();
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        showDialog(10);
        return true;
    }

    public az m1391e() {
        return f741a;
    }

    public void m1392f() {
        if (f735B != null) {
            f735B.m1980a(true);
        }
    }

    public void m1393g() {
        if (f735B != null) {
            f735B.m1980a(false);
        }
    }

    public void m1394h() {
        if (f735B != null) {
            f735B.m1984b(true);
        }
    }

    public void m1395i() {
        if (f735B != null) {
            f735B.m1984b(false);
        }
    }

    public void m1396j() {
        if (f735B != null) {
            f735B.m1987d();
        }
    }

    public void m1397k() {
        if (f735B != null) {
            f735B.m1988e();
        }
    }

    public void m1398l() {
        if (f735B != null) {
            f735B.m1989f();
        }
    }

    public void m1399o() {
        m1376a(dk.UI, false);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (intent == null) {
                return;
            }
            if (intent.hasExtra("droidConfigIndex")) {
                int intExtra = intent.getIntExtra("droidConfigIndex", 0);
                ArrayList a = m1335a((Activity) this, true);
                this.f761V.m1735c();
                m1355e((az) a.get(intExtra));
            } else if (intent.hasExtra("addButton")) {
                this.f761V.m1735c();
                m1306A();
            }
        } else if (i != 101) {
        } else {
            if (intent == null || !intent.hasExtra("menuTextSelected")) {
                m1395i();
                return;
            }
            CharSequence stringExtra = intent.getStringExtra("menuTextSelected");
            C0220c.m1912a("Menu action: " + stringExtra);
            m1343a(stringExtra);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(1);
        window.addFlags(4096);
    }

    public void onConfigurationChanged(Configuration configuration) {
        C0176a.m1106c("*** CONFIG CHANGED");
        this.f773l.m1462b();
        super.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        C0176a.m1106c("ON CREATE");
        C0176a.m1101a("Androidify");
        f734A = getResources().getConfiguration().locale;
        m1368y();
        this.f757R = C0185i.m1177a();
        this.f757R.m1185a("UA-21099199-1", 60, getApplicationContext());
        this.f757R.m1184a("start");
        setVolumeControlStream(3);
        super.onCreate(bundle);
        C0176a.m1106c("Initial onCreate time: " + (System.currentTimeMillis() - currentTimeMillis));
        System.currentTimeMillis();
        this.f764Y = ah.m1648a((Context) this);
        try {
            currentTimeMillis = System.currentTimeMillis();
            Picture picture = this.f764Y.m1657a((int) R.raw.android_body).f1708a;
            Picture picture2 = this.f764Y.m1657a((int) R.raw.android_head).f1708a;
            Picture picture3 = this.f764Y.m1657a((int) R.raw.android_antenna).f1708a;
            Picture picture4 = this.f764Y.m1657a((int) R.raw.android_arm).f1708a;
            Picture picture5 = this.f764Y.m1657a((int) R.raw.android_leg).f1708a;
            Picture picture6 = this.f764Y.m1657a((int) R.raw.android_foot).f1708a;
            C0176a.m1106c("Load initial SVG resources: " + (System.currentTimeMillis() - currentTimeMillis));
            long currentTimeMillis2 = System.currentTimeMillis();
            this.f748D = new C0216a(this);
            setContentView(R.layout.activity_androidify);
            this.f773l = (DroidView) findViewById(R.id.main_droid_view);
            this.f773l.m1457a(this, picture, picture2, picture4, picture5, picture6, picture3);
            this.f763X = (TutorialView) findViewById(R.id.tutorial);
            this.f763X.m1584a(0.0f, 0.0f, dm.LEFT, getString(R.string.tutorial_1), false);
            this.f763X.m1584a(0.0f, 0.0f, dm.DOWN, getString(R.string.tutorial_2), true);
            this.f763X.m1584a(0.0f, 0.0f, dm.DOWN, getString(R.string.tutorial_3), true);
            this.f763X.m1585a(0.0f, 0.0f, dm.DOWN, getString(R.string.tutorial_5), true, 0.0f, 5);
            this.f763X.m1584a(0.0f, 0.0f, dm.UP, getString(R.string.tutorial_6), false);
            this.f783x = (RelativeTouchRecordingLayout) findViewById(R.id.main_layout);
            this.f753L = new C0260g(this.f783x, this, this.f764Y.m1657a((int) R.raw.touchindicator_down).f1708a, this.f764Y.m1657a((int) R.raw.touchindicator_up).f1708a, 1500);
            this.f783x.setTouchRecorder(this.f753L);
            this.f783x.setWillNotDraw(false);
            Typeface a = TextViewCompat.m1580a((Context) this);
            findViewById(R.id.tv_header_main).setVisibility(4);
            this.f760U = (EditText) findViewById(R.id.et_droid_name);
            this.f760U.setVisibility(0);
            this.f760U.clearFocus();
            this.f760U.setTypeface(a);
            m1329X();
            this.f760U.setOnFocusChangeListener(new C0224g(this));
            this.f759T = (ImageButton) findViewById(R.id.btn_menu_burger);
            this.f759T.setOnClickListener(new C0234q(this));
            Picture picture7 = this.f764Y.m1657a((int) R.raw.otherassets_off).f1708a;
            picture7 = this.f764Y.m1657a((int) R.raw.otherassets_close).f1708a;
            this.f761V = new an(this, (ViewGroup) findViewById(R.id.drawer), !getPreferences(0).contains("SAW_NEW_BADGE"));
            this.f783x.setBackgroundColor(-1);
            C0176a.m1106c("UI setup time: " + (System.currentTimeMillis() - currentTimeMillis2));
            currentTimeMillis = System.currentTimeMillis();
            if (bundle != null && bundle.containsKey("galleryItem")) {
                this.ae = (int) bundle.getLong("galleryItem");
            }
            C0176a.m1106c("Rest of oncreate: " + (System.currentTimeMillis() - currentTimeMillis));
        } catch (Throwable e) {
            Log.e("DROIDIFY", "Failed", e);
        }
        this.f762W = (ImageButton) findViewById(R.id.btn_checkmark);
        this.f762W.setVisibility(0);
        this.f762W.setOnClickListener(new C0246y(this));
        if (getPreferences(0).contains("SAW_TUTORIAL")) {
            if (this.f765Z != null) {
                this.f765Z.setVisibility(8);
            }
            m1369z();
            return;
        }
        m1387c(false);
        this.ac = findViewById(R.id.header);
        this.ad = findViewById(R.id.drawer);
        m1340a(this.ac, false, 0.0f);
        m1340a(this.ad, false, 0.0f);
        m1340a(this.f773l, false, 0.0f);
        m1340a(this.f760U, false, 0.0f);
        this.f765Z = (SurfaceView) findViewById(R.id.intro_video);
        this.f765Z.setZOrderOnTop(true);
        this.ab = this.f765Z.getHolder();
        this.ab.addCallback(this);
        this.f765Z.setVisibility(0);
    }

    protected Dialog onCreateDialog(int i) {
        Dialog dialog = null;
        long currentTimeMillis = System.currentTimeMillis();
        C0176a.m1106c("--> onCreateDialog: start");
        getResources();
        switch (i) {
            case cm.HListView_hlv_overScrollFooter /*6*/:
                this.f753L.m2108a(getResources().openRawResource(R.raw.startupevents));
                break;
            case cm.HListView_hlv_measureWithChild /*7*/:
                m1322Q();
                break;
            case 10:
                this.f753L.m2110b();
                m1384b(true);
                break;
            default:
                if (dialog != null) {
                    dialog.setOnDismissListener(this.ak);
                }
                C0176a.m1106c("Create dialog time: " + (System.currentTimeMillis() - currentTimeMillis));
                break;
        }
        return dialog;
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (f743j == 1) {
                m1324S();
                if (f735B == null) {
                    return true;
                }
                f735B.m1982b();
                return true;
            } else if (this.f761V.m1736d()) {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        m1343a(menuItem.getTitle());
        return true;
    }

    protected void onPause() {
        super.onPause();
        if (f735B != null) {
            f735B.m1991h();
        }
        m1388d();
        C0176a.m1106c("Stopping antenna twitch.");
        if (this.f748D != null) {
            this.f748D.m1633c();
        }
        m1325T();
        if (this.f756Q) {
            this.f753L.m2110b();
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        int i;
        C0176a.m1106c("PREPARE MENU");
        int size = menu.size();
        for (i = 0; i < size; i++) {
            menu.removeItem(menu.getItem(0).getItemId());
        }
        MenuItem menuItem;
        if (f743j == 1) {
            for (i = 0; i < f737J.size(); i++) {
                menuItem = (MenuItem) f737J.get(i);
                menu.add(menuItem.getGroupId(), menuItem.getItemId(), i, menuItem.getTitle());
                menu.getItem(i).setIcon(menuItem.getIcon());
            }
        } else {
            for (i = 0; i < f736I.size(); i++) {
                menuItem = (MenuItem) f736I.get(i);
                menu.add(menuItem.getGroupId(), menuItem.getItemId(), i, menuItem.getTitle());
                menu.getItem(i).setIcon(menuItem.getIcon());
            }
        }
        return true;
    }

    protected void onResume() {
        long currentTimeMillis = System.currentTimeMillis();
        super.onResume();
        C0176a.m1106c("Starting antenna twitch.");
        if (this.f782w) {
            this.f781v = this.f773l.m1450a();
        }
        if (this.f747C) {
            this.f748D.m1632b();
        }
        this.af.sendEmptyMessageDelayed(0, 200);
        C0176a.m1106c("onResume time: " + (System.currentTimeMillis() - currentTimeMillis));
    }

    protected void onSaveInstanceState(Bundle bundle) {
        if (this.f750F != null) {
            bundle.putLong("galleryItem", this.f750F.getSelectedItemId());
        }
    }

    protected void onStart() {
        long currentTimeMillis = System.currentTimeMillis();
        super.onStart();
        getPreferences(0);
        m1326U();
        if (this.f755N != null) {
            m1350c(this.f755N);
            this.f755N = null;
        } else if (f741a != null) {
            m1350c(f741a);
            if (f741a.m1769E() != null && f741a.m1769E().length() > 0) {
                this.f760U.setText(f741a.m1769E());
            }
        } else {
            f741a = new az();
        }
        if (f743j == 1 && findViewById(14445) == null) {
            m1358f(false);
            if (this.ae >= 0) {
                this.f750F.setSelection(this.ae);
                this.ae = -1;
            }
        }
        if (this.f780u) {
            m1390d(false);
            this.f780u = false;
        }
        C0176a.m1106c("onStart time: " + (System.currentTimeMillis() - currentTimeMillis));
    }

    protected void onStop() {
        this.f758S = null;
        if (f741a != null && f741a.m1768D()) {
            C0220c.m1912a("Track droid config.");
            f741a.m1792d();
        }
        super.onStop();
    }

    public void onWindowFocusChanged(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (z) {
            this.f773l.m1462b();
        }
        C0176a.m1106c("onWindowFocusChanged: " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public DroidView m1400p() {
        return this.f773l;
    }

    public void m1401q() {
        this.f761V.m1731a();
    }

    public void m1402r() {
        this.f761V.m1734b();
    }

    public void m1403s() {
        this.f773l.m1465b(bh.SHIRT_AND_PANTS);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        try {
            AssetFileDescriptor openFd = getAssets().openFd("intro_30fps_13.mp4");
            DisplayMetrics a = C0220c.m1905a((Activity) this);
            C0220c.m1912a("screenSize = " + a);
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
            String extractMetadata = mediaMetadataRetriever.extractMetadata(19);
            String extractMetadata2 = mediaMetadataRetriever.extractMetadata(18);
            float parseFloat = Float.parseFloat(extractMetadata);
            C0220c.m1912a("mVideoHeight = " + parseFloat);
            float parseFloat2 = Float.parseFloat(extractMetadata2);
            C0220c.m1912a("mVideoWidth = " + parseFloat2);
            parseFloat2 = parseFloat / parseFloat2;
            C0220c.m1912a("Aspect is " + parseFloat2);
            int width = this.f765Z.getWidth();
            C0220c.m1912a("viewWidth = " + width);
            this.f765Z.getHeight();
            float f = ((float) width) * parseFloat2;
            parseFloat = (float) width;
            float height = (float) ((ViewGroup) this.f765Z.getParent()).getHeight();
            if (f > height) {
                parseFloat2 = (parseFloat * height) / f;
                parseFloat = height;
            } else {
                parseFloat2 = parseFloat;
                parseFloat = f;
            }
            C0220c.m1912a("Droidview top of view: " + this.f773l.getTop());
            C0220c.m1912a("Droidview topY: " + this.f773l.getTopY());
            C0220c.m1912a("New height is " + parseFloat);
            LayoutParams layoutParams = this.f765Z.getLayoutParams();
            layoutParams.width = (int) parseFloat2;
            layoutParams.height = (int) parseFloat;
            this.f765Z.setLayoutParams(layoutParams);
            this.f765Z.requestLayout();
            int i = (int) (0.41153845f * parseFloat);
            width = (int) ((((float) a.heightPixels) - parseFloat) / 2.0f);
            C0220c.m1912a("Video top of droid in pixels: " + i);
            C0220c.m1912a("Video view top: " + width);
            i = (i + width) - (this.f773l.getTop() + this.f773l.getTopY());
            C0220c.m1912a("Video view adjust: " + i);
            this.f765Z.setTranslationY((float) (-i));
            this.aa = new MediaPlayer();
            this.aa.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
            this.aa.setDisplay(surfaceHolder);
            this.aa.prepare();
            this.aa.setOnPreparedListener(new C0237t(this));
            this.aa.setOnCompletionListener(new C0238u(this));
        } catch (Throwable th) {
            C0176a.m1102a("Error during video setup. Skipping to app.", th);
            this.f773l.post(new C0239v(this));
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    public ah m1404t() {
        return this.f764Y;
    }

    public void m1405u() {
        C0220c.m1912a("Fading out video view.");
        m1339a(this.f773l, true);
        m1339a(this.f765Z, false);
        m1339a(this.ac, true);
        m1339a(this.ad, true);
        m1341a(this.f760U, true, 1.0f, new C0240w(this));
        this.f773l.postDelayed(new C0245x(this), 1000);
    }

    public void m1406v() {
        getPreferences(0).edit().putBoolean("SAW_NEW_BADGE", true).apply();
    }
}
