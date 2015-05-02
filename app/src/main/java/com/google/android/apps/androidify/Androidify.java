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
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
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

import com.google.android.apps.analytics.GoogleAnalyticsTracker;
import com.google.android.apps.p017c.Interactable;
import com.google.android.apps.p017c.Interaction;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

import dev.game.legend.androidify.wallpaper.AndroidDrawer;
import dev.game.legend.avatar.R;
import dev.game.legend.svgandroid.SVG;

import static com.google.android.apps.androidify.Constants.ANDROID_COLOR;
import static com.google.android.apps.androidify.Constants.al;
import static com.google.android.apps.androidify.Constants.f1190a;
import static com.google.android.apps.androidify.Constants.f1192c;
import static com.google.android.apps.androidify.Constants.f1212w;
import static com.google.android.apps.androidify.Constants.f1213x;
import static com.google.android.apps.androidify.Constants.f1214y;
import static com.google.android.apps.androidify.Constants.mSkinColors;

public class Androidify extends Activity implements Handler.Callback, Interactable, SurfaceHolder.Callback {
    private static Locale f734A;
    static DroidConfig runner;
    private static ArrayList f736I;
    private static ArrayList f737J;
    private static boolean f738K;
    private static int f739O;
    private static float f740P;
    static AndroidConfig f741a;
    private static final Random f742i;
    private static int f743j;
    private static int f744k;
    private static AndroidConfig f745s;
    private static int f746t;
    private boolean f747C;
    private OnItemClickListener mOnItemClickListener;
    private DroidBaseAdapter mDroidBaseAdapter;
    private Gallery mGallery;
    private int f751G;
    private boolean f752H;
    private Interaction f753L;
    private String f754M;
    private AndroidConfig f755N;
    private boolean f756Q;
    private GoogleAnalyticsTracker f757R;
    private ProgressDialog f758S;
    private ImageButton mMenuView;
    private EditText mNameField;
    private ManiView mManiView;
    private ImageButton mCheckmark;
    private TutorialView mTutorialView;
    private AssetDatabase mAssetDatabase;
    private SurfaceView tutorialView;
    private MediaPlayer mMediaPlayer;
    private SurfaceHolder mSurfaceHolder;
    private View mHeader;
    private View mDrawer;
    private int ae;
    private Handler af;
    private int ag;
    private OnItemLongClickListener mOnItemLongClickListener;
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
    private AnimatorThread mAnimatorThread;
    private boolean f782w;
    private RelativeTouchRecordingLayout mTouchRecordingLayout;
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
    static private AndroidConfig theAndroidConfig;

    public Androidify() {
        this.f774m = false;
        this.f775n = false;
        this.f776o = 0;
        this.f777p = null;
        this.f778q = null;
        this.f779r = null;
        this.f780u = false;
        this.mAnimatorThread = null;
        this.f782w = false;
        this.f784y = false;
        this.f785z = false;
        this.f747C = true;
        this.f752H = false;
        this.f756Q = false;
        this.ae = -1;
        this.f766b = false;
        this.af = new Handler(this);
        this.ag = 0;

    }

    private void saveVideo() {
        if (runner != null) {
            runner.m1986c(true);
        }
        //m1356e(true);
        this.mManiView.m1735c();
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
            com.google.android.Util.debug("Playing back touch events.");
            this.f753L.m2108a(new StringBufferInputStream(this.f754M));
        }
    }

    private void showAbout() {
        startActivity(new Intent(this, AboutActivity.class));
    }

    private void saveSettings() {
        AndroidConfig config = new AndroidConfig();
        m1375a(config);
        SharedPreferences preferences = getPreferences(0);
        try {
            preferences.edit().putString("RANDOMIZED_DROID_CONFIG", config.m1787c()).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void m1309D() {
        if (theAndroidConfig.m1805h() != null) {
            PartConfig e = this.mAssetDatabase.m1674e(theAndroidConfig.m1805h());
            if (e != null) {
                SVG b = this.mAssetDatabase.getSvg(e, theAndroidConfig);
                this.mDroidView.m1456a(b.getPicture(), b.getBounds());
                return;
            }
            this.mDroidView.m1456a(null, null);
            return;
        }
        this.mDroidView.m1456a(null, null);
    }

    private void m1310E() {
        if (theAndroidConfig.m1807i() != null) {
            SVG a = this.mAssetDatabase.getSVG("glasses", theAndroidConfig.m1807i(), null);
            this.mDroidView.setGlasses(a.getPicture());
            if (a.getBounds() != null) {
                this.mDroidView.setGlassesBounds(a.getBounds());
                return;
            }
            return;
        }
        this.mDroidView.setGlasses(null);
        this.mDroidView.setGlassesBounds(f1213x);
    }

    private void m1311F() {
        if (theAndroidConfig.m1808j() != null) {
            SVG a = this.mAssetDatabase.getSVG("beard", theAndroidConfig.m1808j(), null, f1190a, Integer.valueOf(Constants.af[this.mDroidView.getHairColorIndex()]));
            this.mDroidView.setBeardIconOn(a.getPicture());
            if (a.getBounds() != null) {
                this.mDroidView.setBeardBounds(a.getBounds());
                return;
            }
            return;
        }
        this.mDroidView.setBeardIconOn(null);
        this.mDroidView.setBeardBounds(f1214y);
    }

    private void m1312G() {
        if (theAndroidConfig.getHat() != null) {
            PartConfig h = this.mAssetDatabase.getHatFromString(theAndroidConfig.getHat());
            if (h != null) {
                this.mDroidView.setHat(new SvgToPartConfigBinder(h, this.mAssetDatabase.getSvg(h, theAndroidConfig)));
                return;
            }
            this.mDroidView.setHat(null);
            return;
        }
        this.mDroidView.setHat(null);
    }

    private void m1313H() {
        if (theAndroidConfig.m1822x() != null) {
            PartConfig i = this.mAssetDatabase.m1682i(theAndroidConfig.m1822x());
            if (i != null) {
                this.mDroidView.setFace(new SvgToPartConfigBinder(i, this.mAssetDatabase.getSvg(i, theAndroidConfig)));
                return;
            }
            this.mDroidView.setFace(null);
            return;
        }
        this.mDroidView.setFace(null);
    }

    private void m1314I() {
        if (theAndroidConfig.m1824z() != null) {
            PartConfig j = this.mAssetDatabase.m1684j(theAndroidConfig.m1824z());
            if (j != null) {
                this.mDroidView.setBody(new SvgToPartConfigBinder(j, this.mAssetDatabase.getSvg(j, theAndroidConfig)));
                return;
            }
            this.mDroidView.setBody(null);
            return;
        }
        this.mDroidView.setBody(null);
    }

    private void m1315J() {
        if (theAndroidConfig.m1766B() != null) {
            PartConfig k = this.mAssetDatabase.m1686k(theAndroidConfig.m1766B());
            if (k != null) {
                this.mDroidView.setHand(new SvgToPartConfigBinder(k, this.mAssetDatabase.getSvg(k, theAndroidConfig)));
                return;
            }
            this.mDroidView.setHand(null);
            return;
        }
        this.mDroidView.setHand(null);
    }

    private void m1316K() {
        Picture picture = null;
        if (theAndroidConfig.getHair() != null) {
            String e = theAndroidConfig.getHair();
            SVG a = this.mAssetDatabase.getSVG("hair", e, "back", f1190a, Integer.valueOf(Constants.af[this.mDroidView.getHairColorIndex()]));
            SVG a2 = this.mAssetDatabase.getSVG("hair", e, "backextra");
            SVG a3 = this.mAssetDatabase.getSVG("hair", e, "front", f1190a, Integer.valueOf(Constants.af[this.mDroidView.getHairColorIndex()]));
            SVG a4 = this.mAssetDatabase.getSVG("hair", e, "frontextra");
            RectF rectF = new RectF(f1212w);
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
        this.mDroidView.setHairBounds(f1212w);
    }

    private void m1317L() {
        if (theAndroidConfig.getOutfit() != null) {
            String f = theAndroidConfig.getOutfit();
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
        int i = mSkinColors[this.mDroidView.getSkinColorIndex()];
        this.mDroidView.m1454a(this.mAssetDatabase.getSvgFromResource(R.raw.android_leg,
                        ANDROID_COLOR, Integer.valueOf(i)).getPicture(),
                this.mAssetDatabase.getSvgFromResource(R.raw.android_foot,
                        ANDROID_COLOR, Integer.valueOf(i)).getPicture());
    }

    private void m1319N() {
        if (theAndroidConfig.m1802g() != null) {
            String g = theAndroidConfig.m1802g();
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
        int i = mSkinColors[this.mDroidView.getSkinColorIndex()];
        this.mDroidView.initNakedDroid(this.mAssetDatabase.getSvgFromResource(R.raw.android_head,
                        ANDROID_COLOR, Integer.valueOf(i)).getPicture(), this.mAssetDatabase.getSvgFromResource(R.raw.android_body, ANDROID_COLOR, Integer.valueOf(i)).getPicture(),
                this.mAssetDatabase.getSvgFromResource(R.raw.android_arm,
                        ANDROID_COLOR, Integer.valueOf(i)).getPicture(),
                this.mAssetDatabase.getSvgFromResource(R.raw.android_antenna,
                        ANDROID_COLOR, Integer.valueOf(i)).getPicture());
    }

    private void m1321P() {
        AndroidConfig config = new AndroidConfig();
        m1375a(config);
        ShareActivity.m1535a(this, config);
    }

    private boolean m1322Q() {
        return false;//m1356e(false);
    }

    private void m1323R() {
        changeHairColor(0);
        m1383b(0);
    }

    private void startAnimation() {
        f743j = 0;
        this.mGallery = null;
        this.mDroidView.setVisibility(View.VISIBLE);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.main_layout);
        View findViewById = findViewById(R.id.action_bar);
        Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) viewGroup.getHeight());
        translateAnimation.setDuration(450);
        translateAnimation.setAnimationListener(new MyAnimationLisener(this, viewGroup, findViewById));
        findViewById.startAnimation(translateAnimation);
    }

    private void m1325T() {
        m1375a(theAndroidConfig);
        if (!theAndroidConfig.m1786b()) {
            m1352d(theAndroidConfig);
        }
        save();
    }

    private void m1326U() {
        if (theAndroidConfig == null || !theAndroidConfig.m1768D()) {
            m1328W();
        }
    }

    private void save() {
        if (theAndroidConfig == null) {
            theAndroidConfig = new AndroidConfig();
        }
        m1375a(theAndroidConfig);
        SharedPreferences preferences = getPreferences(0);
        try {
            preferences.edit().putString("DROID_CONFIG", theAndroidConfig.m1787c()).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void m1328W() {
        String string = getPreferences(0).getString("DROID_CONFIG", null);
        if (string != null) {
            theAndroidConfig = new AndroidConfig();
            try {
                theAndroidConfig.getInstance(this, string);
            } catch (Exception e) {
                e.printStackTrace();
                theAndroidConfig = null;
            } catch (Throwable aThrowable) {
                aThrowable.printStackTrace();
            }
        }
    }

    private void initName() {
        if (theAndroidConfig == null || theAndroidConfig.m1769E() == null) {
            this.mNameField.setText("");
        } else {
            this.mNameField.setText(theAndroidConfig.m1769E());
        }
    }

    private void hideKeyboard() {
        ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(this.mNameField.getWindowToken(), 0);
    }

    public static float m1331a() {
        return f740P;
    }

    public static ArrayList getSaveList(Activity activity, boolean z) {
        ArrayList<AndroidConfig> arrayList = new ArrayList();
        Util.debug("Local class name: " + activity.getLocalClassName());
        SharedPreferences b = getPreference(activity);
//        for (String str : b.getAll().keySet()) {
//            String str2;
//            if (str.startsWith("savedDroid-")) {
//                try {
//                    str2 = b.getString(str, null);
//                    AndroidConfig config = new AndroidConfig();
//                    config.getInstance((Context) activity, str2);
//                    if (config.m1769E() != null) {
//                        com.google.android.Util.debug(config.m1769E() + " " + config.m1770F());
//                    } else {
//                        config.m1804g("");
//                    }
//                    arrayList.add(config);
//                } catch (Throwable e) {
//                    com.google.android.Util.error("Error reading droid config", e);
//                }
//            }
//        }
//        if (arrayList.size() < 1) {
//            if (z) {
//                Toast.makeText(activity, R.string.error_no_saved_droids, Toast.LENGTH_SHORT).show();
//            }
//            return arrayList;
//        }
//        Collections.sort(arrayList, new CustomSorter());
        return arrayList;
    }

    private static SharedPreferences getPreference(Activity aActivity) {
        return null;
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

    public static void m1338a(Activity activity, AndroidConfig config) {
        getAndroidConfigFromPreference(activity).edit().remove("savedDroid-" + config.m1770F()).commit();
        com.google.android.Util.m1104a(activity.getCacheDir(), config.m1770F() + ".png");
    }


    private void move(View view, boolean z) {
        startMoving(view, z, 1.0f, null);
    }

    private void startMoving(View view, boolean z, float f) {
        startMoving(view, z, f, null);
    }

    private void startMoving(View view, boolean z, float f, Runnable runnable) {
        float alpha = view.getAlpha();
        long j = (long) (250.0f * f);
        int i = z ? 1 : 0;
        if (view.getVisibility() != View.VISIBLE) {
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
            this.mManiView.m1735c();
        } else if (charSequence.equals(getString(R.string.menu_share))) {
            m1321P();
            m1398l();
        } else if (charSequence.equals(getString(R.string.menu_about))) {
            showAbout();
            m1399o();
        } else if (charSequence.equals(getString(R.string.menu_create_new))) {
            saveVideo();
        } else if (charSequence.equals("share_to_website")) {
            ShareToWebsiteActivity.m1562a(this, theAndroidConfig);
            m1399o();
        } else if (charSequence.equals(getString(R.string.menu_my_androids))) {
            this.f757R.m1184a("showGallery");
            ArrayList a = getSaveList(this, true);
            if (a != null && a.size() > 0) {
                startActivityForResult(new Intent(this, GalleryActivity.class), 100);
            }
            m1397k();
        }
    }

    public static SharedPreferences getAndroidConfigFromPreference(Activity activity) {
        return activity.getSharedPreferences("Androidify", 0);
    }

    private void m1350c(AndroidConfig config) {
        theAndroidConfig = config;
        this.mDroidView.setHairColorIndex(com.google.android.Util.m1096a(Constants.af, config.getHairColor()));
        this.mDroidView.setSkinColorIndex(com.google.android.Util.m1096a(Constants.mSkinColors, config.getSkinColor()));
        this.mDroidView.setPantsColorIndex(com.google.android.Util.m1096a(Constants.al, config.m1819u()));
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
        this.mDroidView.m1452a(config.getBodyScaleX(), config.getBodyScaleY(), config.getHeadScaleX(),
                config.getHeadScaleY(), config.getArmScaleX(), config.getArmScaleY(), config.getLegScaleX(),
                config.getLegScaleY());
    }

    private boolean m1352d(AndroidConfig config) {
        if (config == null) {
            try {
                config = theAndroidConfig;
                m1375a(config);
            } catch (Exception e) {
                Toast.makeText(this, getString(R.string.error_save_droid_failed), Toast.LENGTH_LONG).show();
                return false;
            }
        }
        SharedPreferences preferences = getPreferences(0);
        try {
            String c = config.m1787c();
            com.google.android.Util.debug("-----------");
            com.google.android.Util.debug(c);
            Util.debug("[ENCODE] " + c);
            com.google.android.Util.debug("-----------");
            preferences.edit().putString("savedDroid-" + config.m1770F(), c).apply();
            this.f757R.m1184a("saveDroid");
            com.google.android.Util.m1104a(getCacheDir(), config.m1770F() + ".png");
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return true;
    }

    private void m1355e(AndroidConfig config) {
        f743j = 0;
        m1350c(config);
        theAndroidConfig = config;
        save();
        initName();
        Toast.makeText(getApplicationContext(), getString(R.string.msg_droid_loaded), Toast.LENGTH_SHORT).show();
        if (runner != null) {
            runner.m1982b();
        }
    }

    private boolean m1356e(boolean z) {
        if (z) {
            saveSettings();
        }
        theAndroidConfig = new AndroidConfig();
        this.mDroidView.m1466c();
        m1323R();
        m1375a(theAndroidConfig);
        save();
        this.mDroidView.m1471e();
        m1350c(theAndroidConfig);
        this.mDroidView.invalidate();
        initName();
        return true;
    }

    private void showGallery(boolean z) {
        this.mDroidView.m1480m();
        ArrayList a = getSaveList(this, true);
        if (a != null && a.size() != 0) {
            FrameLayout frameLayout = new FrameLayout(this);
            Display defaultDisplay = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
            int width = defaultDisplay.getWidth();
            int height = defaultDisplay.getHeight();
            Paint paint = new Paint();
            paint.setDither(true);
            float a2 = SpecialDroidView.m1889a(this, width, height, m1331a());
            Paint paint2 = new Paint();
            paint2.setFlags(1);
            paint.setShader(new LinearGradient((float) (width / 2), 0.0f, (float) (width / 2), ((float) height) - ((3.0f * a2) / 4.0f), -2236963, -6250336, Shader.TileMode.CLAMP));
            View c0227j = new C0227j(this, this, a2, paint, paint2);
            this.mGallery = new Gallery(this);
            this.mGallery.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.mDroidBaseAdapter = new DroidBaseAdapter(this, a, this.mGallery, a2);
            this.mGallery.setAdapter(this.mDroidBaseAdapter);
//            this.mGallery.setOnItemClickListener(new OnItemClickListener(){
//                @Override
//                public void onItemClick(AdapterView<?> c0273u, View view, int i, long j) {
//                    m1392f();
//                    this.f1236b.m1732a(mManiView.values()[i]);
//                        this.f1235a.m1377a(av.values()[i].mString);
//                    }parent, View view, int position, long id) {
//
//                }
//                ao(an anVar, Androidify androidify) {
//                    this.f1236b = anVar;
//                    this.f1235a = androidify;
//                }
//
//                public void m1738a
//                }
//
//            });
//            (this.mManiView, this));
            this.mGallery.setUnselectedAlpha(1.0f);
            this.mGallery.setCallbackDuringFling(false);
            this.mGallery.setCallbackDuringFling(false);
            this.mGallery.setOnItemSelectedListener(new ItemSelectedListener(this));
            this.mGallery.setOnItemLongClickListener(new ItemLongClickListener(this));
            frameLayout.addView(c0227j);
            frameLayout.addView(this.mGallery);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            frameLayout.setId(R.id.main_droid_view);
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
                this.mDroidView.setVisibility(View.GONE);
                this.mDroidBaseAdapter.setPriority(5);
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
            com.google.android.Util.debug("Drag ends!");
            runner.m1990g();
        }
        f738K = false;
    }

    private void initDisplayMetrics() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        f739O = Math.min(displayMetrics.heightPixels, displayMetrics.widthPixels) / 5;
        f740P = ((float) f739O) / 64.0f;
    }

    private void startIntro() {
        long currentTimeMillis = System.currentTimeMillis();
        if (runner == null) {
            //this.mDroidView.postDelayed(new mSurfaceHolder(this), 0);
        } else {
            runner.init();
        }
        com.google.android.Util.debug("Sound start-up: " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void changeHairColor(int i) {
        this.mDroidView.setHairColorIndex(i);
        m1316K();
        m1311F();
        this.mDroidView.invalidate();
        m1381a(true, this.mDroidView.getHairColorIndex());
    }

    public void proceedTutorial(int i, boolean z) {
        this.mDroidView.proceedTutorial(i, z);
    }

    public void m1372a(DroidView droidView) {
        if (this.f767c == null) {
            this.f767c = this.mAssetDatabase.getSvgFromResource(R.raw.android_head, ANDROID_COLOR, f1192c).getPicture();
            this.f768d = this.mAssetDatabase.getSvgFromResource(R.raw.android_body, ANDROID_COLOR, f1192c).getPicture();
            this.f769e = this.mAssetDatabase.getSvgFromResource(R.raw.android_arm, ANDROID_COLOR, f1192c).getPicture();
            this.f770f = this.mAssetDatabase.getSvgFromResource(R.raw.android_antenna, ANDROID_COLOR, f1192c).getPicture();
            this.f771g = this.mAssetDatabase.getSvgFromResource(R.raw.android_leg, ANDROID_COLOR, f1192c).getPicture();
            this.f772h = this.mAssetDatabase.getSvgFromResource(R.raw.android_foot, ANDROID_COLOR, f1192c).getPicture();
        }
        droidView.setHairIconOn(null);
        droidView.setHairFront(null);
        droidView.setHairBounds(f1212w);
        droidView.setBeardBounds(f1214y);
        droidView.setGlassesBounds(f1213x);
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
        droidView.initNakedDroid(this.f767c, this.f768d, this.f769e, this.f770f);
        droidView.m1454a(this.f771g, this.f772h);
        droidView.m1466c();
    }

    public void m1373a(DroidView droidView, AndroidConfig config) {
    }

    public void m1374a(AccessoriesContainer aAccessoriesContainerVar) {
        this.mDroidView.post(new MyTimerTask(this, aAccessoriesContainerVar));
    }

    public void m1375a(AndroidConfig config) {
        try {
            config.m1804g(theAndroidConfig.m1769E());
            config.m1778a(theAndroidConfig.getHair());
            config.m1784b(theAndroidConfig.getOutfit());
            config.m1790c(theAndroidConfig.m1802g());
            config.m1794d(theAndroidConfig.m1805h());
            config.m1798e(theAndroidConfig.m1807i());
            config.m1794d(theAndroidConfig.m1805h());
            config.m1798e(theAndroidConfig.m1807i());
            config.m1801f(theAndroidConfig.m1808j());
            config.m1779a(theAndroidConfig.m1821w(), theAndroidConfig.getHat());
            config.m1785b(theAndroidConfig.m1823y(), theAndroidConfig.m1822x());
            config.m1791c(theAndroidConfig.m1765A(), theAndroidConfig.m1824z());
            config.m1795d(theAndroidConfig.m1767C(), theAndroidConfig.m1766B());
            config.m1774a(this.mDroidView.getDroidBody().scaleX);
            config.m1781b(this.mDroidView.getDroidBody().scaleY);
            config.m1788c(this.mDroidView.getDroidHead().scaleX);
            config.m1793d(this.mDroidView.getDroidHead().scaleY);
            config.m1797e(this.mDroidView.getDroidArm().scaleX);
            config.m1800f(this.mDroidView.getDroidArm().scaleY);
            config.m1803g(this.mDroidView.getDroidLegs().scaleX);
            config.m1806h(this.mDroidView.getDroidLegs().scaleY);
            config.m1775a(Constants.af[this.mDroidView.getHairColorIndex()]);
            config.m1782b(mSkinColors[this.mDroidView.getSkinColorIndex()]);
            config.m1789c(al[this.mDroidView.getPantsColorIndex()]);
            config.m1777a(theAndroidConfig.m1771G());
            config.m1783b(theAndroidConfig.m1772H());
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
            this.mDroidView.m1465b(AccessoryType.SHOES);
        } else if (str.equals("glasses")) {
            this.mDroidView.m1465b(AccessoryType.GLASSES);
        } else if (str.equals("beard")) {
            this.mDroidView.m1465b(AccessoryType.BEARD);
        } else if (str.equals("hair")) {
            this.mDroidView.m1465b(AccessoryType.HAIR);
        } else if (str.equals("pants")) {
            this.mDroidView.m1465b(AccessoryType.PANTS);
        } else if (str.equals("shirt")) {
            this.mDroidView.m1465b(AccessoryType.SHIRT);
        }
    }

    public void m1378a(String str, PartConfig aPartConfigVar, boolean z) {
        m1379a(str, aPartConfigVar, z, true);
    }

    public void m1379a(String str, PartConfig aPartConfigVar, boolean z, boolean z2) {
        String str2 = null;
        String str3 = aPartConfigVar.name;
        String str4 = aPartConfigVar.f1130c;
        Object obj = null;
        if (!aPartConfigVar.f1132e) {
            if (aPartConfigVar.f1133f != null) {
                theAndroidConfig.m1777a(aPartConfigVar.f1133f);
                obj = 1;
            }
            if (aPartConfigVar.f1134g != null) {
                theAndroidConfig.m1783b(aPartConfigVar.f1134g);
                obj = 1;
            }
        }
        AndroidConfig r1;
        if ("shirt".equals(str)) {
            theAndroidConfig.m1784b(z ? null : str3);
            m1317L();
            m1376a(DefaultAccessory.SHIRTS_PANTS, z);
            this.mDroidView.m1460a(AccessoryType.SHIRT);
        } else if ("pants".equals(str)) {
            r1 = theAndroidConfig;
            if (!z) {
                str2 = str3;
            }
            r1.m1790c(str2);
            m1319N();
            m1376a(DefaultAccessory.SHIRTS_PANTS, z);
            this.mDroidView.m1460a(AccessoryType.PANTS);
        } else if ("shoes".equals(str)) {
            r1 = theAndroidConfig;
            if (!z) {
                str2 = str3;
            }
            r1.m1794d(str2);
            m1309D();
            m1376a(DefaultAccessory.SHOES, z);
            this.mDroidView.m1460a(AccessoryType.SHOES);
        } else if ("hair".equals(str)) {
            r1 = theAndroidConfig;
            if (!z) {
                str2 = str3;
            }
            r1.m1778a(str2);
            m1316K();
            m1376a(DefaultAccessory.HAIR, z);
            this.mDroidView.m1460a(AccessoryType.HAIR);
        } else if ("glasses".equals(str)) {
            r1 = theAndroidConfig;
            if (!z) {
                str2 = str3;
            }
            r1.m1798e(str2);
            m1310E();
            m1376a(DefaultAccessory.GLASSES_ACCESSORIES, z);
        } else if ("beard".equals(str)) {
            r1 = theAndroidConfig;
            if (!z) {
                str2 = str3;
            }
            r1.m1801f(str2);
            m1311F();
            m1376a(DefaultAccessory.HAIR, z);
        } else if ("hat".equals(str)) {
            r1 = theAndroidConfig;
            if (!z) {
                str2 = str3;
            }
            r1.m1779a(str4, str2);
            m1312G();
            m1376a(DefaultAccessory.HAIR, z);
            this.mDroidView.m1460a(AccessoryType.HAIR);
        } else if ("face".equals(str)) {
            r1 = theAndroidConfig;
            if (!z) {
                str2 = str3;
            }
            r1.m1785b(str4, str2);
            m1313H();
            m1376a(DefaultAccessory.GLASSES_ACCESSORIES, z);
        } else if ("body".equals(str)) {
            r1 = theAndroidConfig;
            if (!z) {
                str2 = str3;
            }
            r1.m1791c(str4, str2);
            m1314I();
            m1376a(DefaultAccessory.HAIR, z);
            this.mDroidView.m1460a(AccessoryType.SHIRT);
        } else if ("hand".equals(str)) {
            r1 = theAndroidConfig;
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
        this.f755N = new AndroidConfig();
        m1375a(this.f755N);
        m1356e(false);
        this.mManiView.m1735c();
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
            //this.mDroidView.postDelayed(new mLocation7(this), this.mDroidView.m1479l() + 500);
        } else if (this.f755N != null) {
            m1350c(this.f755N);
            this.f755N = null;
        }
        this.f756Q = false;
    }

    public OnItemClickListener getClickListener() {
        return this.mOnItemClickListener;
    }

    public void m1386c(int i) {
        this.mDroidView.m1468c(i);
    }


    public void closeDrawerClicked(View view) {
        if (this.mManiView != null) {
            m1393g();
            this.mManiView.m1732a(null);
        }
    }

    public void m1388d() {
        if (this.mAnimatorThread != null) {
            this.mAnimatorThread.stopAnimation();
            this.mAnimatorThread = null;
        }
    }

    public void m1389d(int i) {
        this.mDroidView.m1464b(i);
    }

    public void m1390d(boolean z) {
        boolean z2 = true;
        com.google.android.Util.debug("Randomize Droid");
        if (z) {
            saveSettings();
        }
        theAndroidConfig = new AndroidConfig();
        this.mDroidView.m1469d();
        m1383b(f742i.nextInt(mSkinColors.length));
        changeHairColor(f742i.nextInt(Constants.af.length));
        int nextInt = f742i.nextInt(this.mAssetDatabase.m1673d().size());
        m1378a("shirt", (PartConfig) this.mAssetDatabase.m1673d().get(nextInt), nextInt == 0);
        m1317L();
        nextInt = f742i.nextInt(this.mAssetDatabase.m1671c().size());
        m1378a("hair", (PartConfig) this.mAssetDatabase.m1671c().get(nextInt), nextInt == 0);
        m1316K();
        nextInt = f742i.nextInt(this.mAssetDatabase.m1677f().size());
        m1378a("shoes", (PartConfig) this.mAssetDatabase.m1677f().get(nextInt), nextInt == 0);
        m1309D();
        nextInt = f742i.nextInt(this.mAssetDatabase.m1675e().size());
        m1378a("pants", (PartConfig) this.mAssetDatabase.m1675e().get(nextInt), nextInt == 0);
        m1319N();
        if (f742i.nextInt(100) < 33) {
            nextInt = f742i.nextInt(this.mAssetDatabase.m1679g().size());
            m1378a("glasses", (PartConfig) this.mAssetDatabase.m1679g().get(nextInt), nextInt == 0);
        }
        m1310E();
        if (f742i.nextInt(100) < 25) {
            nextInt = f742i.nextInt(this.mAssetDatabase.m1681h().size());
            String str = "beard";
            PartConfig partConfigVar = (PartConfig) this.mAssetDatabase.m1681h().get(nextInt);
            if (nextInt != 0) {
                z2 = false;
            }
            m1378a(str, partConfigVar, z2);
        }
        m1311F();
        m1375a(theAndroidConfig);
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
            if (this.mNameField.hasFocus()) {
                this.mNameField.clearFocus();
                hideKeyboard();
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        showDialog(10);
        return true;
    }

    public AndroidConfig getCurrentConfig() {
        return theAndroidConfig;
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

    public void startRunner() {
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
                ArrayList a = getSaveList(this, true);
                this.mManiView.m1735c();
                m1355e((AndroidConfig) a.get(intExtra));
            } else if (intent.hasExtra("addButton")) {
                this.mManiView.m1735c();
                saveVideo();
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
        com.google.android.Util.debug("*** CONFIG CHANGED");
        this.mDroidView.m1462b();
        super.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        com.google.android.Util.debug("ON CREATE");
        com.google.android.Util.m1101a("Androidify");
        f734A = getResources().getConfiguration().locale;
        initDisplayMetrics();
        //this.f757R = GoogleAnalyticsTracker.m1177a();
        //this.f757R.m1185a("UA-21099199-1", 60, getApplicationContext());
        //this.f757R.m1184a("start");
        setVolumeControlStream(3);
        super.onCreate(bundle);
        com.google.android.Util.debug("Initial onCreate time: " + (System.currentTimeMillis() - currentTimeMillis));

        this.mAssetDatabase = AssetDatabase.instance(this);
        try {
            currentTimeMillis = System.currentTimeMillis();
            Picture body = this.mAssetDatabase.getSvgFromResource(R.raw.android_body).getPicture();
            Picture head = this.mAssetDatabase.getSvgFromResource(R.raw.android_head).getPicture();
            Picture leg = this.mAssetDatabase.getSvgFromResource(R.raw.android_legs_new).getPicture();
            Picture antenna = this.mAssetDatabase.getSvgFromResource(R.raw.android_antenna).getPicture();
            Picture foot = this.mAssetDatabase.getSvgFromResource(R.raw.android_foot).getPicture();
            Picture arm = this.mAssetDatabase.getSvgFromResource(R.raw.android_arm).getPicture();
            com.google.android.Util.debug("Load initial SVG resources: " + (System.currentTimeMillis() - currentTimeMillis));
            long currentTimeMillis2 = System.currentTimeMillis();
            this.mOnItemClickListener = (adapterView, view, i, j) -> {
                try {
                    m1355e((AndroidConfig) adapterView.getAdapter().getItem(i));
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), getString(R.string.error_load_droid_failed), Toast.LENGTH_SHORT).show();
                }
            };
            setContentView(R.layout.activity_androidify_2);
            this.mDroidView = (DroidView) findViewById(R.id.main_droid_view);
            this.mDroidView.initDroid(this, body, head, antenna, arm, foot, leg);
            this.mTutorialView = (TutorialView) findViewById(R.id.tutorial);
            this.mTutorialView.addTransition(0.0f, 0.0f, DirectionState.LEFT, getString(R.string.tutorial_1), false);
            this.mTutorialView.addTransition(0.0f, 0.0f, DirectionState.DOWN, getString(R.string.tutorial_2), true);
            this.mTutorialView.addTransition(0.0f, 0.0f, DirectionState.DOWN, getString(R.string.tutorial_3), true);
            this.mTutorialView.m1585a(0.0f, 0.0f, DirectionState.DOWN, getString(R.string.tutorial_5), true, 0.0f, 5);
            this.mTutorialView.addTransition(0.0f, 0.0f, DirectionState.UP, getString(R.string.tutorial_6), false);
            this.mTouchRecordingLayout = (RelativeTouchRecordingLayout) findViewById(R.id.main_layout);
            this.f753L = new Interaction(
                    this.mTouchRecordingLayout,
                    this,
                    this.mAssetDatabase.getSvgFromResource(R.raw.touchindicator_down).getPicture(),
                    this.mAssetDatabase.getSvgFromResource(R.raw.touchindicator_up).getPicture(),
                    1500);
            this.mTouchRecordingLayout.setTouchRecorder(this.f753L);
            this.mTouchRecordingLayout.setWillNotDraw(false);
            Typeface a = TextViewCompat.createTypeface(this);
            findViewById(R.id.tv_header_main).setVisibility(View.INVISIBLE);
            this.mNameField = (EditText) findViewById(R.id.et_droid_name);
            this.mNameField.setVisibility(View.VISIBLE);
            this.mNameField.clearFocus();
            this.mNameField.setTypeface(a);
            initName();
            //this.mNameField.setOnFocusChangeListener(new C0224g(this));
            this.mMenuView = (ImageButton) findViewById(R.id.btn_menu_burger);
            this.mMenuView.setOnClickListener(v -> {
                    this.startRunner();
                    Intent intent = new Intent(this, MenuActivity.class);
                    this.startActivityForResult(intent, 101);
                    this.overridePendingTransition(R.anim.from_left, R.anim.hold_position);
            });
            Picture picture7 = this.mAssetDatabase.getSvgFromResource(R.raw.otherassets_off).getPicture();
            picture7 = this.mAssetDatabase.getSvgFromResource(R.raw.otherassets_close).getPicture();
            this.mManiView = new ManiView(this, (ViewGroup) findViewById(R.id.drawer), !getPreferences(0).contains("SAW_NEW_BADGE"));
            this.mTouchRecordingLayout.setBackgroundColor(-1);
            com.google.android.Util.debug("UI setup time: " + (System.currentTimeMillis() - currentTimeMillis2));
            currentTimeMillis = System.currentTimeMillis();
            if (bundle != null && bundle.containsKey("galleryItem")) {
                this.ae = (int) bundle.getLong("galleryItem");
            }
            com.google.android.Util.debug("Rest of oncreate: " + (System.currentTimeMillis() - currentTimeMillis));
        } catch (Throwable e) {
            android.util.Log.e("DROIDIFY", "Failed", e);
        }
        this.mCheckmark = (ImageButton) findViewById(R.id.btn_checkmark);
        this.mCheckmark.setVisibility(View.VISIBLE);
        this.mCheckmark.setOnClickListener(v -> {
                this.m1399o();
                this.m1343a(this.getString(R.string.menu_share));
                mDroidView.m1468c(View.INVISIBLE);
});
        if (getPreferences(0).contains("SAW_TUTORIAL")) {
            if (this.tutorialView != null) {
                this.tutorialView.setVisibility(View.INVISIBLE);
            }
            startIntro();
            return;
        }
        this.f747C = false;
        this.mHeader = findViewById(R.id.header);
        this.mDrawer = findViewById(R.id.drawer);
        startMoving(this.mHeader, false, 0.0f);
        startMoving(this.mDrawer, false, 0.0f);
        startMoving(this.mDroidView, false, 0.0f);
        startMoving(this.mNameField, false, 0.0f);
        this.tutorialView = (SurfaceView) findViewById(R.id.intro_video);
        this.tutorialView.setZOrderOnTop(true);
        this.mSurfaceHolder = this.tutorialView.getHolder();
        this.mSurfaceHolder.addCallback(this);
        this.tutorialView.setVisibility(View.VISIBLE);
    }

    protected Dialog onCreateDialog(int i) {
        Dialog dialog = null;
        long currentTimeMillis = System.currentTimeMillis();
        com.google.android.Util.debug("--> onCreateDialog: start");
        getResources();
        switch (i) {
            case HListViewConstants.HListView_hlv_overScrollFooter /*6*/:
                this.f753L.m2108a(getResources().openRawResource(R.raw.startupevents));
                break;
            case HListViewConstants.HListView_hlv_measureWithChild /*7*/:
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
                com.google.android.Util.debug("Create dialog time: " + (System.currentTimeMillis() - currentTimeMillis));
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
                startAnimation();
                if (runner == null) {
                    return true;
                }
                runner.m1982b();
                return true;
            } else if (this.mManiView.m1736d()) {
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
        com.google.android.Util.debug("Stopping antenna twitch.");
        if (this.mOnItemClickListener != null) {
            //this.mOnItemClickListener.last();
        }
        m1325T();
        if (this.f756Q) {
            this.f753L.m2110b();
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        int i;
        com.google.android.Util.debug("PREPARE MENU");
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
        com.google.android.Util.debug("Starting antenna twitch.");
        if (this.f782w) {
            this.mAnimatorThread = this.mDroidView.startAnAnimation();
        }
        if (this.f747C) {
            //this.mOnItemClickListener.next();
        }
        this.af.sendEmptyMessageDelayed(0, 200);
        com.google.android.Util.debug("onResume time: " + (System.currentTimeMillis() - currentTimeMillis));
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
        } else if (theAndroidConfig != null) {
            m1350c(theAndroidConfig);
            if (theAndroidConfig.m1769E() != null && theAndroidConfig.m1769E().length() > 0) {
                this.mNameField.setText(theAndroidConfig.m1769E());
            }
        } else {
            theAndroidConfig = new AndroidConfig();
        }
        if (f743j == 1 && findViewById(R.id.main_droid_view) == null) {
            showGallery(false);
            if (this.ae >= 0) {
                this.mGallery.setSelection(this.ae);
                this.ae = -1;
            }
        }
        if (this.f780u) {
            m1390d(false);
            this.f780u = false;
        }
        com.google.android.Util.debug("onStart time: " + (System.currentTimeMillis() - currentTimeMillis));
    }

    protected void onStop() {
        this.f758S = null;
        if (theAndroidConfig != null && theAndroidConfig.m1768D()) {
            Util.debug("Track droid config.");
            theAndroidConfig.m1792d();
        }
        super.onStop();
    }

    public void onWindowFocusChanged(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (z) {
            this.mDroidView.m1462b();
        }
        com.google.android.Util.debug("onWindowFocusChanged: " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public DroidView getDroidView() {
        return this.mDroidView;
    }

    public void m1401q() {
        this.mManiView.m1731a();
    }

    public void m1402r() {
        this.mManiView.m1734b();
    }

    public void m1403s() {
        this.mDroidView.m1465b(AccessoryType.SHIRT_AND_PANTS);
    }



    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        try {
            AssetFileDescriptor openFd = getAssets().openFd("intro_30fps_13.mp4");
            DisplayMetrics a = Util.getMetrix(this);
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
            int width = this.tutorialView.getWidth();
            Util.debug("viewWidth = " + width);
            this.tutorialView.getHeight();
            float f = ((float) width) * parseFloat2;
            parseFloat = (float) width;
            float height = (float) ((ViewGroup) this.tutorialView.getParent()).getHeight();
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
            ViewGroup.LayoutParams layoutParams = this.tutorialView.getLayoutParams();
            layoutParams.width = (int) parseFloat2;
            layoutParams.height = (int) parseFloat;
            this.tutorialView.setLayoutParams(layoutParams);
            this.tutorialView.requestLayout();
            int i = (int) (0.41153845f * parseFloat);
            width = (int) ((((float) a.heightPixels) - parseFloat) / 2.0f);
            Util.debug("Video top of droid in pixels: " + i);
            Util.debug("Video view top: " + width);
            i = (i + width) - (this.mDroidView.getTop() + this.mDroidView.getTopY());
            Util.debug("Video view adjust: " + i);
            this.tutorialView.setTranslationY((float) (-i));
            this.mMediaPlayer = new MediaPlayer();
            this.mMediaPlayer.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
            this.mMediaPlayer.setDisplay(surfaceHolder);
            this.mMediaPlayer.prepare();
            this.mMediaPlayer.setOnPreparedListener(new MyPreparedListener(this));
            this.mMediaPlayer.setOnCompletionListener(new MyCompletionListener(this));
        } catch (Throwable th) {
            com.google.android.Util.error("Error during video setup. Skipping to app.", th);
            this.mDroidView.post(new MyTask(this));
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }


    public void fadeOutVideo() {
        Util.debug("Fading out video view.");
        move(this.mDroidView, true);
        move(this.tutorialView, false);
        move(this.mHeader, true);
        move(this.mDrawer, true);
        Androidify.runner = new DroidConfig(this);
        startMoving(this.mNameField, true, 1.0f, ()->{
            Androidify.runner.init();
        });
        this.mDroidView.postDelayed(()->{
            Androidify.runner.init();
        }, 1000);
    }

    public void showBadge   () {
        getPreferences(0).edit().putBoolean("SAW_NEW_BADGE", true).apply();
    }


    public AssetDatabase getAssetDatabase() {
        return mAssetDatabase;
    }

    public void setAssetDatabase(AssetDatabase aAssetDatabase) {
        mAssetDatabase = aAssetDatabase;
    }

    @Override
    public void onTouchedMe() {

    }

    @Override
    public void onTouchedMe(boolean z) {

    }

    @Override
    public boolean handleMessage(Message msg) {
        return false;
    }

    private class C0227j extends View {
        final /* synthetic */ float f1650a;
        final /* synthetic */ Paint f1651b;
        final /* synthetic */ Paint f1652c;
        final /* synthetic */ Androidify f1653d;

        C0227j(Androidify androidify, Context context, float f, Paint paint, Paint paint2) {
            super(context);
            this.f1653d = androidify;
            this.f1650a = f;
            this.f1651b = paint;
            this.f1652c = paint2;
        }

        protected void onDraw(Canvas canvas) {
            canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (((float) getHeight()) - this.f1650a) - ((this.f1650a * 3.0f) / 4.0f), this.f1651b);
            this.f1652c.setColor(-5723992);
            canvas.drawRect(0.0f, ((float) getHeight()) - this.f1650a, (float) getWidth(), (float) getHeight(), this.f1652c);
            this.f1652c.setColor(-3355444);
            canvas.drawRect(0.0f, (((float) getHeight()) - this.f1650a) - ((this.f1650a * 3.0f) / 4.0f), (float) getWidth(), ((float) getHeight()) - this.f1650a, this.f1652c);
            this.f1652c.setColor(-8355712);
            canvas.drawLine(0.0f, ((float) getHeight()) - this.f1650a, (float) getWidth(), ((float) getHeight()) - this.f1650a, this.f1652c);
        }
    }
}
