package com.google.android.apps.androidify;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Picture;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageButton;

import com.google.android.apps.analytics.GoogleAnalyticsTracker;
import com.google.android.apps.p017c.Interaction;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;


public class Androidify extends Activity implements Callback{//}, C0203m {
    private static Locale f734A;
    static dh runner;
    private static ArrayList f736I;
    private static ArrayList f737J;
    private static boolean f738K;
    private static int f739O;
    private static float f740P;
    static AndroidConfig theAndroidConfig;
    private static final Random f742i;
    private static int f743j;
    private static int f744k;
    private static AndroidConfig f745s;
    private static int f746t;
    private boolean f747C;
    private ItemClickListener mOnItemClickListener;
    private bc f749E;
    private Gallery mGallery;
    private int f751G;
    private boolean f752H;
    private Interaction f753L;
    private String f754M;
    private AndroidConfig f755N;
    private boolean f756Q;
    private GoogleAnalyticsTracker f757R;
    private ProgressDialog f758S;
    private ImageButton f759T;
    private EditText f760U;
    private ManiView f761V;
    private ImageButton f762W;
    private TutorialView mTutorialView;
    private AssetDatabase mAssetDatabase;
    private SurfaceView f765Z;
    private MediaPlayer aa;
    private SurfaceHolder ab;
    private View ac;
    private View ad;
    private int ae;
    private Handler af;
    private int ag;
    private OnItemLongClickListener mOnItemLongClickListener;
    private OnItemClickListener mOnItemClickListener3;
    private OnItemClickListener mOnItemClickListener2;
    private OnDismissListener mOnDismissListener;
    boolean f766b;
    Picture f767c;
    Picture f768d;
    Picture f769e;
    Picture f770f;
    Picture f771g;
    Picture f772h;
    private DroidView mDroidView;
    private boolean f774m;
    private boolean f775n;
    private long f776o;
    private String f777p;
    private String f778q;
    private AndroidConfig f779r;
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

    private AndroidDrawer mAndroid;

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
        this.mOnItemLongClickListener = new OnItemLongClickListener(this) {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                return false;
            }
        };
        this.mOnItemClickListener = new OnItemClickListener(this);
        this.mOnItemClickListener2 = new OnItemClickListener(this);
        this.mOnDismissListener = new OnDismissListener(this);
    }

    private void m1306A() {
        if (runner != null) {
            runner.m1986c(true);
        }
        m1356e(true);
        this.f761V.m1735c();
        if (runner != null) {
            runner.m1986c(false);
        }
        m1396j();
        if (this.f754M != null) {
            try {
                FileWriter fileWriter = new FileWriter("/sdcard/events.txt");
                fileWriter.write(this.f754M);
                fileWriter.close();
            } catch (IOException e) {
                android.util.Log.e("foobar", e.toString());
            }
            com.google.android.Log.debug("Playing back touch events.");
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void m1309D() {
        if (f741a.m1805h() != null) {
            ag e = this.mAssetDatabase.m1674e(f741a.m1805h());
            if (e != null) {
                SVG b = this.mAssetDatabase.m1669b(e, f741a);
                this.mDroidView.m1456a(b.getPicture(), b.getBounds());
                return;
            }
            this.mDroidView.m1456a(null, null);
            return;
        }
        this.mDroidView.m1456a(null, null);
    }

    private void m1310E() {
        if (f741a.m1807i() != null) {
            SVG a = this.mAssetDatabase.getSVG("glasses", f741a.m1807i(), null);
            this.mDroidView.setGlasses(a.getPicture());
            if (a.getBounds() != null) {
                this.mDroidView.setGlassesBounds(a.getBounds());
                return;
            }
            return;
        }
        this.mDroidView.setGlasses(null);
        this.mDroidView.setGlassesBounds(al.f1213x);
    }

    private void m1311F() {
        if (f741a.m1808j() != null) {
            SVG a = this.mAssetDatabase.getSVG("beard", f741a.m1808j(), null, al.f1190a, Integer.valueOf(al.af[this.mDroidView.getHairColorIndex()]));
            this.mDroidView.setBeardIconOn(a.getPicture());
            if (a.getBounds() != null) {
                this.mDroidView.setBeardBounds(a.getBounds());
                return;
            }
            return;
        }
        this.mDroidView.setBeardIconOn(null);
        this.mDroidView.setBeardBounds(al.f1214y);
    }

    private void m1312G() {
        if (f741a.m1820v() != null) {
            ag h = this.mAssetDatabase.m1680h(f741a.m1820v());
            if (h != null) {
                this.mDroidView.setHat(new bg(h, this.mAssetDatabase.m1669b(h, f741a)));
                return;
            }
            this.mDroidView.setHat(null);
            return;
        }
        this.mDroidView.setHat(null);
    }

    private void m1313H() {
        if (f741a.m1822x() != null) {
            ag i = this.mAssetDatabase.m1682i(f741a.m1822x());
            if (i != null) {
                this.mDroidView.setFace(new bg(i, this.mAssetDatabase.m1669b(i, f741a)));
                return;
            }
            this.mDroidView.setFace(null);
            return;
        }
        this.mDroidView.setFace(null);
    }

    private void m1314I() {
        if (f741a.m1824z() != null) {
            ag j = this.mAssetDatabase.m1684j(f741a.m1824z());
            if (j != null) {
                this.mDroidView.setBody(new bg(j, this.mAssetDatabase.m1669b(j, f741a)));
                return;
            }
            this.mDroidView.setBody(null);
            return;
        }
        this.mDroidView.setBody(null);
    }

    private void m1315J() {
        if (f741a.m1766B() != null) {
            ag k = this.mAssetDatabase.m1686k(f741a.m1766B());
            if (k != null) {
                this.mDroidView.setHand(new bg(k, this.mAssetDatabase.m1669b(k, f741a)));
                return;
            }
            this.mDroidView.setHand(null);
            return;
        }
        this.mDroidView.setHand(null);
    }

    private void m1316K() {
        Picture picture = null;
        if (f741a.getHair() != null) {
            String e = f741a.getHair();
            SVG a = this.mAssetDatabase.getSVG("hair", e, "back", al.f1190a, Integer.valueOf(al.af[this.mDroidView.getHairColorIndex()]));
            SVG a2 = this.mAssetDatabase.getSVG("hair", e, "backextra");
            SVG a3 = this.mAssetDatabase.getSVG("hair", e, "front", al.f1190a, Integer.valueOf(al.af[this.mDroidView.getHairColorIndex()]));
            SVG a4 = this.mAssetDatabase.getSVG("hair", e, "frontextra");
            RectF rectF = new RectF(al.f1212w);
            if (!(a == null || a.getBounds() == null)) {
                rectF.union(a.getBounds());
            }
            if (!(a3 == null || a3.getBounds() == null)) {
                rectF.union(a3.getBounds());
            }
            if (!(a2 == null || a2.getBounds() == null)) {
                rectF.union(a2.getBounds());
            }
            if (!(a4 == null || a4.getBounds() == null)) {
                rectF.union(a4.getBounds());
            }
            this.mDroidView.setHairIconOn(a == null ? null : a.getPicture());
            this.mDroidView.setHairFront(a3 == null ? null : a3.getPicture());
            this.mDroidView.setHairBackExtra(a2 == null ? null : a2.getPicture());
            DroidView droidView = this.mDroidView;
            if (a4 != null) {
                picture = a4.getPicture();
            }
            droidView.setHairFrontExtra(picture);
            this.mDroidView.setHairBounds(rectF);
            return;
        }
        this.mDroidView.setHairIconOn(null);
        this.mDroidView.setHairBackExtra(null);
        this.mDroidView.setHairFront(null);
        this.mDroidView.setHairFrontExtra(null);
        this.mDroidView.setHairBounds(al.f1212w);
    }

    private void m1317L() {
        if (f741a.getOutfit() != null) {
            String f = f741a.getOutfit();
            this.mDroidView.setShirtArm(this.mAssetDatabase.m1666b("shirt", f, "arm"));
            this.mDroidView.setShirtBody(this.mAssetDatabase.m1666b("shirt", f, "body"));
            this.mDroidView.setShirtTop(this.mAssetDatabase.m1666b("shirt", f, "top"));
            this.mDroidView.setShirtBottom(this.mAssetDatabase.m1666b("shirt", f, "bottom"));
            return;
        }
        this.mDroidView.setShirtArm(null);
        this.mDroidView.setShirtBody(null);
        this.mDroidView.setShirtTop(null);
        this.mDroidView.setShirtBottom(null);
    }

    private void m1318M() {
        int i = al.ai[this.mDroidView.getSkinColorIndex()];
        this.mDroidView.m1454a(this.mAssetDatabase.getSvgFromResource((int) R.raw.android_leg, al.ANDROID_COLOR, Integer.valueOf(i)).getPicture(), this.mAssetDatabase.getSvgFromResource((int) R.raw.android_foot, al.ANDROID_COLOR, Integer.valueOf(i)).getPicture());
    }

    private void m1319N() {
        if (f741a.m1802g() != null) {
            String g = f741a.m1802g();
            this.mDroidView.setPantsLeg(this.mAssetDatabase.m1666b("pants", g, "leg"));
            this.mDroidView.setPantsSkirt(this.mAssetDatabase.m1666b("pants", g, "skirt"));
            this.mDroidView.setPantsTop(this.mAssetDatabase.m1666b("pants", g, "top"));
            return;
        }
        this.mDroidView.setPantsLeg(null);
        this.mDroidView.setPantsSkirt(null);
        this.mDroidView.setPantsTop(null);
    }

    private void m1320O() {
        int i = al.ai[this.mDroidView.getSkinColorIndex()];
        this.mDroidView.m1455a(this.mAssetDatabase.getSvgFromResource((int) R.raw.android_head, al.ANDROID_COLOR, Integer.valueOf(i)).getPicture(), this.mAssetDatabase.getSvgFromResource((int) R.raw.android_body, al.ANDROID_COLOR, Integer.valueOf(i)).getPicture(), this.mAssetDatabase.getSvgFromResource((int) R.raw.android_arm, al.ANDROID_COLOR, Integer.valueOf(i)).getPicture(), this.mAssetDatabase.getSvgFromResource((int) R.raw.android_antenna, al.ANDROID_COLOR, Integer.valueOf(i)).getPicture());
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
        this.mGallery = null;
        this.mDroidView.setVisibility(0);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.main_layout);
        View findViewById = findViewById(R.id.action_bar);
        Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) viewGroup.getHeight());
        translateAnimation.setDuration(450);
        translateAnimation.setAnimationListener(new MyAnimationLisener(this, viewGroup, findViewById));
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void m1328W() {
        String string = getPreferences(0).getString("DROID_CONFIG", null);
        if (string != null) {
            f741a = new az();
            try {
                f741a.m1776a((Context) this, string);
            } catch (Exception e) {
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

    private void hideKeyboard() {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.f760U.getWindowToken(), 0);
    }

    public static float m1331a() {
        return f740P;
    }

    public static ArrayList getSaveList(Activity activity, boolean z) {
        ArrayList<az> arrayList = new ArrayList();
        Util.debug("Local class name: " + activity.getLocalClassName());
        SharedPreferences b = m1345b(activity);
        for (String str : b.getAll().keySet()) {
            String str2;
            if (str.startsWith("savedDroid-")) {
                try {
                    str2 = b.getString(str, null);
                    az azVar = new az();
                    azVar.m1776a((Context) activity, str2);
                    if (azVar.m1769E() != null) {
                        com.google.android.Log.debug(azVar.m1769E() + " " + azVar.m1770F());
                    } else {
                        azVar.m1804g("");
                    }
                    arrayList.add(azVar);
                } catch (Throwable e) {
                    com.google.android.Log.error("Error reading droid config", e);
                }
            }
        }
        if (arrayList.size() < 1) {
            if (z) {
                Toast.makeText(activity, R.string.error_no_saved_droids, 0).show();
            }
            return arrayList;
        }
        Collections.sort(arrayList, new CustomSorter());
        return arrayList;
    }

    public static void m1336a(float f, float f2, float f3, float f4) {
        float f5 = 2.0f / (f + f2);
        if (runner != null) {
            runner.m1977a(f5, f3, f4);
        }
    }

    public static void m1337a(Activity activity) {
        Intent intent = new Intent(activity, Androidify.class);
        intent.addFlags(67108864);
        activity.startActivity(intent);
    }

    public static void m1338a(Activity activity, az azVar) {
        m1345b(activity).edit().remove("savedDroid-" + azVar.m1770F()).commit();
        com.google.android.Log.m1104a(activity.getCacheDir(), azVar.m1770F() + ".png");
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
            //alphaAnimation.setAnimationListener(new C0247z(this, view, z, runnable));
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
            ArrayList a = getSaveList((Activity) this, true);
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
        this.mDroidView.setHairColorIndex(com.google.android.Log.m1096a(al.af, azVar.getHairColor()));
        this.mDroidView.setSkinColorIndex(com.google.android.Log.m1096a(al.ai, azVar.getSkinColor()));
        this.mDroidView.setPantsColorIndex(com.google.android.Log.m1096a(al.al, azVar.m1819u()));
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
        this.mDroidView.m1452a(azVar.getBodyScaleX(), azVar.getBodyScaleY(), azVar.getHeadScaleX(), azVar.getHeadScaleY(), azVar.getArmScaleX(), azVar.getArmScaleY(), azVar.getLegScaleX(), azVar.getLegScaleY());
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
            com.google.android.Log.debug("-----------");
            com.google.android.Log.debug(c);
            Util.debug("[ENCODE] " + c);
            com.google.android.Log.debug("-----------");
            preferences.edit().putString("savedDroid-" + azVar.m1770F(), c).apply();
            this.f757R.m1184a("saveDroid");
            com.google.android.Log.m1104a(getCacheDir(), azVar.m1770F() + ".png");
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
        if (runner != null) {
            runner.m1982b();
        }
    }

    private boolean m1356e(boolean z) {
        if (z) {
            m1308C();
        }
        f741a = new az();
        this.mDroidView.m1466c();
        m1323R();
        m1375a(f741a);
        m1327V();
        this.mDroidView.m1471e();
        m1350c(f741a);
        this.mDroidView.invalidate();
        m1329X();
        return true;
    }

    private void m1358f(boolean z) {
        this.mDroidView.m1480m();
        ArrayList a = getSaveList((Activity) this, true);
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
            //View c0227j = new C0227j(this, this, a2, paint, paint2);
            this.mGallery = new Gallery(this);
            this.mGallery.setLayoutParams(new LayoutParams(-1, -1));
            this.f749E = new bc(this, a, this.mGallery, a2);
            this.mGallery.setAdapter(this.f749E);
            this.mGallery.setOnItemClickListener(this.mOnItemClickListener2);
            this.mGallery.setUnselectedAlpha(1.0f);
            this.mGallery.setCallbackDuringFling(false);
            this.mGallery.setCallbackDuringFling(false);
            //this.mGallery.setOnItemSelectedListener(new C0228k(this));
            //this.mGallery.setOnItemLongClickListener(new C0229l(this));
            //frameLayout.addView(c0227j);
            //frameLayout.addView(this.mGallery);
            frameLayout.setLayoutParams(new LayoutParams(-1, -1));
            //frameLayout.setId(14445);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.main_layout);
            viewGroup.addView(frameLayout);
            if (z) {
                Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) viewGroup.getHeight(), 0.0f);
                translateAnimation.setDuration(450);
                translateAnimation.setAnimationListener(new MyAnimationListener(this));
                frameLayout.startAnimation(translateAnimation);
                if (runner != null) {
                    runner.m1982b();
                }
            } else {
                this.mDroidView.setVisibility(8);
                this.f749E.m1869a(5);
            }
            f743j = 1;
        }
    }

    public static void m1364m() {
        f738K = true;
        if (runner != null) {
            runner.m1976a(1.0f);
        }
    }

    public static void m1365n() {
        if (f738K && runner != null) {
            com.google.android.Log.debug("Drag ends!");
            runner.m1990g();
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
        if (runner == null) {
            this.mDroidView.postDelayed(new ab(this), 0);
        } else {
            runner.m1975a();
        }
        com.google.android.Log.debug("Sound start-up: " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void m1370a(int i) {
        this.mDroidView.setHairColorIndex(i);
        m1316K();
        m1311F();
        this.mDroidView.invalidate();
        m1381a(true, this.mDroidView.getHairColorIndex());
    }

    public void m1371a(int i, boolean z) {
        this.mDroidView.m1453a(i, z);
    }

    public void m1372a(DroidView droidView) {
        if (this.f767c == null) {
            this.f767c = this.mAssetDatabase.getSvgFromResource((int) R.raw.android_head, al.ANDROID_COLOR, al.f1192c).getPicture();
            this.f768d = this.mAssetDatabase.getSvgFromResource((int) R.raw.android_body, al.ANDROID_COLOR, al.f1192c).getPicture();
            this.f769e = this.mAssetDatabase.getSvgFromResource((int) R.raw.android_arm, al.ANDROID_COLOR, al.f1192c).getPicture();
            this.f770f = this.mAssetDatabase.getSvgFromResource((int) R.raw.android_antenna, al.ANDROID_COLOR, al.f1192c).getPicture();
            this.f771g = this.mAssetDatabase.getSvgFromResource((int) R.raw.android_leg, al.ANDROID_COLOR, al.f1192c).getPicture();
            this.f772h = this.mAssetDatabase.getSvgFromResource((int) R.raw.android_foot, al.ANDROID_COLOR, al.f1192c).getPicture();
        }
        droidView.setHairIconOn(null);
        droidView.setHairFront(null);
        droidView.setHairBounds(al.f1212w);
        droidView.setBeardBounds(al.f1214y);
        droidView.setGlassesBounds(al.f1213x);
        droidView.setBeardIconOn(null);
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
        this.mDroidView.post(new MyTimerTask(this, avVar));
    }

    public void m1375a(az azVar) {
        try {
            azVar.m1804g(f741a.m1769E());
            azVar.m1778a(f741a.getHair());
            azVar.m1784b(f741a.getOutfit());
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
            azVar.m1774a(this.mDroidView.getDroidBody().scaleX);
            azVar.m1781b(this.mDroidView.getDroidBody().scaleY);
            azVar.m1788c(this.mDroidView.getDroidHead().scaleX);
            azVar.m1793d(this.mDroidView.getDroidHead().scaleY);
            azVar.m1797e(this.mDroidView.getDroidArm().scaleX);
            azVar.m1800f(this.mDroidView.getDroidArm().scaleY);
            azVar.m1803g(this.mDroidView.getDroidLegs().scaleX);
            azVar.m1806h(this.mDroidView.getDroidLegs().scaleY);
            azVar.m1775a(al.af[this.mDroidView.getHairColorIndex()]);
            azVar.m1782b(al.ai[this.mDroidView.getSkinColorIndex()]);
            azVar.m1789c(al.al[this.mDroidView.getPantsColorIndex()]);
            azVar.m1777a(f741a.m1771G());
            azVar.m1783b(f741a.m1772H());
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public void m1376a(DefaultAccessory aDefaultAccessoryVar, boolean z) {
        if (runner == null) {
            return;
        }
        if (z) {
            runner.m1985c();
        } else {
            runner.m1983b(aDefaultAccessoryVar);
        }
    }

    public void m1377a(String str) {
        if (str == null) {
            return;
        }
        if (str.equals("shoes")) {
            this.mDroidView.m1465b(bh.SHOES);
        } else if (str.equals("glasses")) {
            this.mDroidView.m1465b(bh.GLASSES);
        } else if (str.equals("beard")) {
            this.mDroidView.m1465b(bh.BEARD);
        } else if (str.equals("hair")) {
            this.mDroidView.m1465b(bh.HAIR);
        } else if (str.equals("pants")) {
            this.mDroidView.m1465b(bh.PANTS);
        } else if (str.equals("shirt")) {
            this.mDroidView.m1465b(bh.SHIRT);
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
        az r1;
        if ("shirt".equals(str)) {
            f741a.m1784b(z ? null : str3);
            m1317L();
            m1376a(DefaultAccessory.SHIRTS_PANTS, z);
            this.mDroidView.m1460a(bh.SHIRT);
        } else if ("pants".equals(str)) {
            r1 = f741a;
            if (!z) {
                str2 = str3;
            }
            r1.m1790c(str2);
            m1319N();
            m1376a(DefaultAccessory.SHIRTS_PANTS, z);
            this.mDroidView.m1460a(bh.PANTS);
        } else if ("shoes".equals(str)) {
            r1 = f741a;
            if (!z) {
                str2 = str3;
            }
            r1.m1794d(str2);
            m1309D();
            m1376a(DefaultAccessory.SHOES, z);
            this.mDroidView.m1460a(bh.SHOES);
        } else if ("hair".equals(str)) {
            r1 = f741a;
            if (!z) {
                str2 = str3;
            }
            r1.m1778a(str2);
            m1316K();
            m1376a(DefaultAccessory.HAIR, z);
            this.mDroidView.m1460a(bh.HAIR);
        } else if ("glasses".equals(str)) {
            r1 = f741a;
            if (!z) {
                str2 = str3;
            }
            r1.m1798e(str2);
            m1310E();
            m1376a(DefaultAccessory.GLASSES_ACCESSORIES, z);
        } else if ("beard".equals(str)) {
            r1 = f741a;
            if (!z) {
                str2 = str3;
            }
            r1.m1801f(str2);
            m1311F();
            m1376a(DefaultAccessory.HAIR, z);
        } else if ("hat".equals(str)) {
            r1 = f741a;
            if (!z) {
                str2 = str3;
            }
            r1.m1779a(str4, str2);
            m1312G();
            m1376a(DefaultAccessory.HAIR, z);
            this.mDroidView.m1460a(bh.HAIR);
        } else if ("face".equals(str)) {
            r1 = f741a;
            if (!z) {
                str2 = str3;
            }
            r1.m1785b(str4, str2);
            m1313H();
            m1376a(DefaultAccessory.GLASSES_ACCESSORIES, z);
        } else if ("body".equals(str)) {
            r1 = f741a;
            if (!z) {
                str2 = str3;
            }
            r1.m1791c(str4, str2);
            m1314I();
            m1376a(DefaultAccessory.HAIR, z);
            this.mDroidView.m1460a(bh.SHIRT);
        } else if ("hand".equals(str)) {
            r1 = f741a;
            if (!z) {
                str2 = str3;
            }
            r1.m1795d(str4, str2);
            m1315J();
            m1376a(DefaultAccessory.GLASSES_ACCESSORIES, z);
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
        if (runner != null) {
            runner.m1981a(z, i);
        }
    }

    public void m1382b() {
        this.f756Q = true;
        this.f755N = new az();
        m1375a(this.f755N);
        m1356e(false);
        this.f761V.m1735c();
        this.mDroidView.m1480m();
        this.mDroidView.m1479l();
    }

    public void m1383b(int i) {
        this.mDroidView.setSkinColorIndex(i);
        m1320O();
        m1318M();
        this.mDroidView.invalidate();
        m1381a(false, i);
        this.mDroidView.m1468c(1);
    }

    public void m1384b(boolean z) {
        if (!z) {
            this.mDroidView.postDelayed(new ac(this), this.mDroidView.m1479l() + 500);
        } else if (this.f755N != null) {
            m1350c(this.f755N);
            this.f755N = null;
        }
        this.f756Q = false;
    }

    public ItemClickListener m1385c() {
        return this.mOnItemClickListener;
    }

    public void m1386c(int i) {
        this.mDroidView.m1468c(i);
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
        this.mDroidView.m1464b(i);
    }

    public void m1390d(boolean z) {
        boolean z2 = true;
        com.google.android.Log.debug("Randomize Droid");
        if (z) {
            m1308C();
        }
        f741a = new az();
        this.mDroidView.m1469d();
        m1383b(f742i.nextInt(al.ai.length));
        m1370a(f742i.nextInt(al.af.length));
        int nextInt = f742i.nextInt(this.mAssetDatabase.m1673d().size());
        m1378a("shirt", (ag) this.mAssetDatabase.m1673d().get(nextInt), nextInt == 0);
        m1317L();
        nextInt = f742i.nextInt(this.mAssetDatabase.m1671c().size());
        m1378a("hair", (ag) this.mAssetDatabase.m1671c().get(nextInt), nextInt == 0);
        m1316K();
        nextInt = f742i.nextInt(this.mAssetDatabase.m1677f().size());
        m1378a("shoes", (ag) this.mAssetDatabase.m1677f().get(nextInt), nextInt == 0);
        m1309D();
        nextInt = f742i.nextInt(this.mAssetDatabase.m1675e().size());
        m1378a("pants", (ag) this.mAssetDatabase.m1675e().get(nextInt), nextInt == 0);
        m1319N();
        if (f742i.nextInt(100) < 33) {
            nextInt = f742i.nextInt(this.mAssetDatabase.m1679g().size());
            m1378a("glasses", (ag) this.mAssetDatabase.m1679g().get(nextInt), nextInt == 0);
        }
        m1310E();
        if (f742i.nextInt(100) < 25) {
            nextInt = f742i.nextInt(this.mAssetDatabase.m1681h().size());
            String str = "beard";
            ag agVar = (ag) this.mAssetDatabase.m1681h().get(nextInt);
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
                hideKeyboard();
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
        if (runner != null) {
            runner.m1980a(true);
        }
    }

    public void m1393g() {
        if (runner != null) {
            runner.m1980a(false);
        }
    }

    public void m1394h() {
        if (runner != null) {
            runner.m1984b(true);
        }
    }

    public void m1395i() {
        if (runner != null) {
            runner.m1984b(false);
        }
    }

    public void m1396j() {
        if (runner != null) {
            runner.m1987d();
        }
    }

    public void m1397k() {
        if (runner != null) {
            runner.m1988e();
        }
    }

    public void m1398l() {
        if (runner != null) {
            runner.m1989f();
        }
    }

    public void m1399o() {
        m1376a(DefaultAccessory.UI, false);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (intent == null) {
                return;
            }
            if (intent.hasExtra("droidConfigIndex")) {
                int intExtra = intent.getIntExtra("droidConfigIndex", 0);
                ArrayList a = getSaveList((Activity) this, true);
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
            Util.debug("Menu action: " + stringExtra);
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
        com.google.android.Log.debug("*** CONFIG CHANGED");
        this.mDroidView.m1462b();
        super.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        com.google.android.Log.debug("ON CREATE");
        com.google.android.Log.m1101a("Androidify");
        f734A = getResources().getConfiguration().locale;
        m1368y();
        this.f757R = GoogleAnalyticsTracker.m1177a();
        this.f757R.m1185a("UA-21099199-1", 60, getApplicationContext());
        this.f757R.m1184a("start");
        setVolumeControlStream(3);
        super.onCreate(bundle);
        com.google.android.Log.debug("Initial onCreate time: " + (System.currentTimeMillis() - currentTimeMillis));
        System.currentTimeMillis();
        this.mAssetDatabase = AssetDatabase.instance((Context) this);
        try {
            currentTimeMillis = System.currentTimeMillis();
            Picture picture = this.mAssetDatabase.getSvgFromResource((int) R.raw.android_body).getPicture();
            Picture picture2 = this.mAssetDatabase.getSvgFromResource((int) R.raw.android_head).getPicture();
            Picture picture3 = this.mAssetDatabase.getSvgFromResource((int) R.raw.android_antenna).getPicture();
            Picture picture4 = this.mAssetDatabase.getSvgFromResource((int) R.raw.android_arm).getPicture();
            Picture picture5 = this.mAssetDatabase.getSvgFromResource((int) R.raw.android_leg).getPicture();
            Picture picture6 = this.mAssetDatabase.getSvgFromResource((int) R.raw.android_foot).getPicture();
            com.google.android.Log.debug("Load initial SVG resources: " + (System.currentTimeMillis() - currentTimeMillis));
            long currentTimeMillis2 = System.currentTimeMillis();
            this.mOnItemClickListener = new ItemClickListener(this);
            setContentView(R.layout.activity_androidify);
            this.mDroidView = (DroidView) findViewById(R.id.main_droid_view);
            this.mDroidView.initDroid(this, picture, picture2, picture4, picture5, picture6, picture3);
            this.mTutorialView = (TutorialView) findViewById(R.id.tutorial);
//            this.mTutorialView.addTransition(0.0f, 0.0f, dm.LEFT, getString(R.string.tutorial_1), false);
//            this.mTutorialView.addTransition(0.0f, 0.0f, dm.DOWN, getString(R.string.tutorial_2), true);
//            this.mTutorialView.addTransition(0.0f, 0.0f, dm.DOWN, getString(R.string.tutorial_3), true);
//            this.mTutorialView.m1585a(0.0f, 0.0f, dm.DOWN, getString(R.string.tutorial_5), true, 0.0f, 5);
//            this.mTutorialView.addTransition(0.0f, 0.0f, dm.UP, getString(R.string.tutorial_6), false);
            this.f783x = (RelativeTouchRecordingLayout) findViewById(R.id.main_layout);
            this.f753L = new C0260g(
                    this.f783x,
                    this,
                    this.mAssetDatabase.getSvgFromResource((int) R.raw.touchindicator_down).getPicture(),
                    this.mAssetDatabase.getSvgFromResource((int) R.raw.touchindicator_up).getPicture(),
                    1500);
            this.f783x.setTouchRecorder(this.f753L);
            this.f783x.setWillNotDraw(false);
            Typeface a = TextViewCompat.createTypeface((Context) this);
            findViewById(R.id.tv_header_main).setVisibility(4);
            this.f760U = (EditText) findViewById(R.id.et_droid_name);
            this.f760U.setVisibility(0);
            this.f760U.clearFocus();
            this.f760U.setTypeface(a);
            m1329X();
            this.f760U.setOnFocusChangeListener(new C0224g(this));
            this.f759T = (ImageButton) findViewById(R.id.btn_menu_burger);
            this.f759T.setOnClickListener(new C0234q(this));
            Picture picture7 = this.mAssetDatabase.getSVG((int) R.raw.otherassets_off).getPicture();
            picture7 = this.mAssetDatabase.getSVG((int) R.raw.otherassets_close).getPicture();
            this.f761V = new an(this, (ViewGroup) findViewById(R.id.drawer), !getPreferences(0).contains("SAW_NEW_BADGE"));
            this.f783x.setBackgroundColor(-1);
            com.google.android.Log.debug("UI setup time: " + (System.currentTimeMillis() - currentTimeMillis2));
            currentTimeMillis = System.currentTimeMillis();
            if (bundle != null && bundle.containsKey("galleryItem")) {
                this.ae = (int) bundle.getLong("galleryItem");
            }
            com.google.android.Log.debug("Rest of oncreate: " + (System.currentTimeMillis() - currentTimeMillis));
        } catch (Throwable e) {
            android.util.Log.e("DROIDIFY", "Failed", e);
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
        m1340a(this.mDroidView, false, 0.0f);
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
        com.google.android.Log.debug("--> onCreateDialog: start");
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
                    dialog.setOnDismissListener(this.mOnDismissListener);
                }
                com.google.android.Log.debug("Create dialog time: " + (System.currentTimeMillis() - currentTimeMillis));
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
                if (runner == null) {
                    return true;
                }
                runner.m1982b();
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
        if (runner != null) {
            runner.m1991h();
        }
        m1388d();
        com.google.android.Log.debug("Stopping antenna twitch.");
        if (this.mOnItemClickListener != null) {
            this.mOnItemClickListener.m1633c();
        }
        m1325T();
        if (this.f756Q) {
            this.f753L.m2110b();
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        int i;
        com.google.android.Log.debug("PREPARE MENU");
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
        com.google.android.Log.debug("Starting antenna twitch.");
        if (this.f782w) {
            this.f781v = this.mDroidView.m1450a();
        }
        if (this.f747C) {
            this.mOnItemClickListener.m1632b();
        }
        this.af.sendEmptyMessageDelayed(0, 200);
        com.google.android.Log.debug("onResume time: " + (System.currentTimeMillis() - currentTimeMillis));
    }

    protected void onSaveInstanceState(Bundle bundle) {
        if (this.mGallery != null) {
            bundle.putLong("galleryItem", this.mGallery.getSelectedItemId());
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
                this.mGallery.setSelection(this.ae);
                this.ae = -1;
            }
        }
        if (this.f780u) {
            m1390d(false);
            this.f780u = false;
        }
        com.google.android.Log.debug("onStart time: " + (System.currentTimeMillis() - currentTimeMillis));
    }

    protected void onStop() {
        this.f758S = null;
        if (f741a != null && f741a.m1768D()) {
            Util.debug("Track droid config.");
            f741a.m1792d();
        }
        super.onStop();
    }

    public void onWindowFocusChanged(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (z) {
            this.mDroidView.m1462b();
        }
        com.google.android.Log.debug("onWindowFocusChanged: " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public DroidView m1400p() {
        return this.mDroidView;
    }

    public void m1401q() {
        this.f761V.m1731a();
    }

    public void m1402r() {
        this.f761V.m1734b();
    }

    public void m1403s() {
        this.mDroidView.m1465b(bh.SHIRT_AND_PANTS);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        try {
            AssetFileDescriptor openFd = getAssets().openFd("intro_30fps_13.mp4");
            DisplayMetrics a = Util.getMetrix((Activity) this);
            Util.debug("screenSize = " + a);
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
            String extractMetadata = mediaMetadataRetriever.extractMetadata(19);
            String extractMetadata2 = mediaMetadataRetriever.extractMetadata(18);
            float parseFloat = Float.parseFloat(extractMetadata);
            Util.debug("mVideoHeight = " + parseFloat);
            float parseFloat2 = Float.parseFloat(extractMetadata2);
            Util.debug("mVideoWidth = " + parseFloat2);
            parseFloat2 = parseFloat / parseFloat2;
            Util.debug("Aspect is " + parseFloat2);
            int width = this.f765Z.getWidth();
            Util.debug("viewWidth = " + width);
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
            Util.debug("Droidview top of view: " + this.mDroidView.getTop());
            Util.debug("Droidview topY: " + this.mDroidView.getTopY());
            Util.debug("New height is " + parseFloat);
            LayoutParams layoutParams = this.f765Z.getLayoutParams();
            layoutParams.width = (int) parseFloat2;
            layoutParams.height = (int) parseFloat;
            this.f765Z.setLayoutParams(layoutParams);
            this.f765Z.requestLayout();
            int i = (int) (0.41153845f * parseFloat);
            width = (int) ((((float) a.heightPixels) - parseFloat) / 2.0f);
            Util.debug("Video top of droid in pixels: " + i);
            Util.debug("Video view top: " + width);
            i = (i + width) - (this.mDroidView.getTop() + this.mDroidView.getTopY());
            Util.debug("Video view adjust: " + i);
            this.f765Z.setTranslationY((float) (-i));
            this.aa = new MediaPlayer();
            this.aa.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
            this.aa.setDisplay(surfaceHolder);
            this.aa.prepare();
            this.aa.setOnPreparedListener(new MyPreparedListener(this));
            this.aa.setOnCompletionListener(new MyCompletionListener(this));
        } catch (Throwable th) {
            com.google.android.Log.error("Error during video setup. Skipping to app.", th);
            this.mDroidView.post(new MyTask(this));
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    public AssetDatabase getAssetDatabase() {
        return this.mAssetDatabase;
    }

    public void m1405u() {
        Util.debug("Fading out video view.");
        m1339a(this.mDroidView, true);
        m1339a(this.f765Z, false);
        m1339a(this.ac, true);
        m1339a(this.ad, true);
        m1341a(this.f760U, true, 1.0f, new C0240w(this));
        this.mDroidView.postDelayed(new C0245x(this), 1000);
    }

    public void showBadge   () {
        getPreferences(0).edit().putBoolean("SAW_NEW_BADGE", true).apply();
    }

    public AndroidConfig m1391e() {
        return null;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    public AssetDatabase getAssetDatabase() {
        return mAssetDatabase;
    }

    public void setAssetDatabase(AssetDatabase aAssetDatabase) {
        mAssetDatabase = aAssetDatabase;
    }

    public static void m1336a(float aF1501b, float aF1502c, float aX, float aY) {

    }

    public static void m1365n() {

    }

    public static void m1337a(Activity aActivity) {

    }

    public static float m1331a() {
        return 0;
    }
}
