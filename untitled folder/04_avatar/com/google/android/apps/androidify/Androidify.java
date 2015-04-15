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
import com.google.android.a;
import com.google.android.apps.a.i;
import com.google.android.apps.b.b;
import com.google.android.apps.c.g;
import com.google.android.apps.c.m;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Androidify extends Activity implements Callback, m {
    private static Locale A;
    private static dh B;
    private static ArrayList I;
    private static ArrayList J;
    private static boolean K;
    private static int O;
    private static float P;
    static az a;
    private static final Random i;
    private static int j;
    private static int k;
    private static az s;
    private static int t;
    private boolean C;
    private a D;
    private bc E;
    private Gallery F;
    private int G;
    private boolean H;
    private g L;
    private String M;
    private az N;
    private boolean Q;
    private i R;
    private ProgressDialog S;
    private ImageButton T;
    private EditText U;
    private an V;
    private ImageButton W;
    private TutorialView X;
    private ah Y;
    private SurfaceView Z;
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
    boolean b;
    Picture c;
    Picture d;
    Picture e;
    Picture f;
    Picture g;
    Picture h;
    private DroidView l;
    private boolean m;
    private boolean n;
    private long o;
    private String p;
    private String q;
    private az r;
    private boolean u;
    private bj v;
    private boolean w;
    private RelativeTouchRecordingLayout x;
    private boolean y;
    private boolean z;

    static {
        i = new Random();
        j = 0;
        k = 0;
        a = null;
        s = null;
        t = -1;
        A = null;
        I = new ArrayList();
        J = new ArrayList();
        O = 0;
        P = 1.0f;
    }

    public Androidify() {
        this.m = false;
        this.n = false;
        this.o = 0;
        this.p = null;
        this.q = null;
        this.r = null;
        this.u = false;
        this.v = null;
        this.w = false;
        this.y = false;
        this.z = false;
        this.C = true;
        this.H = false;
        this.Q = false;
        this.ae = -1;
        this.b = false;
        this.af = new aa(this);
        this.ag = 0;
        this.ah = new o(this);
        this.ai = new p(this);
        this.aj = new r(this);
        this.ak = new s(this);
    }

    private void A() {
        if (B != null) {
            B.c(true);
        }
        e(true);
        this.V.c();
        if (B != null) {
            B.c(false);
        }
        j();
        if (this.M != null) {
            try {
                FileWriter fileWriter = new FileWriter("/sdcard/events.txt");
                fileWriter.write(this.M);
                fileWriter.close();
            } catch (IOException e) {
                Log.e("foobar", e.toString());
            }
            a.c("Playing back touch events.");
            this.L.a(new StringBufferInputStream(this.M));
        }
    }

    private void B() {
        startActivity(new Intent(this, AboutActivity.class));
    }

    private void C() {
        az azVar = new az();
        a(azVar);
        SharedPreferences preferences = getPreferences(0);
        try {
            preferences.edit().putString("RANDOMIZED_DROID_CONFIG", azVar.c()).commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void D() {
        if (a.h() != null) {
            ag e = this.Y.e(a.h());
            if (e != null) {
                b b = this.Y.b(e, a);
                this.l.a(b.a, b.c);
                return;
            }
            this.l.a(null, null);
            return;
        }
        this.l.a(null, null);
    }

    private void E() {
        if (a.i() != null) {
            b a = this.Y.a("glasses", a.i(), null);
            this.l.setGlasses(a.a);
            if (a.c != null) {
                this.l.setGlassesBounds(a.c);
                return;
            }
            return;
        }
        this.l.setGlasses(null);
        this.l.setGlassesBounds(al.x);
    }

    private void F() {
        if (a.j() != null) {
            b a = this.Y.a("beard", a.j(), null, al.a, Integer.valueOf(al.af[this.l.getHairColorIndex()]));
            this.l.setBeard(a.a);
            if (a.c != null) {
                this.l.setBeardBounds(a.c);
                return;
            }
            return;
        }
        this.l.setBeard(null);
        this.l.setBeardBounds(al.y);
    }

    private void G() {
        if (a.v() != null) {
            ag h = this.Y.h(a.v());
            if (h != null) {
                this.l.setHat(new bg(h, this.Y.b(h, a)));
                return;
            }
            this.l.setHat(null);
            return;
        }
        this.l.setHat(null);
    }

    private void H() {
        if (a.x() != null) {
            ag i = this.Y.i(a.x());
            if (i != null) {
                this.l.setFace(new bg(i, this.Y.b(i, a)));
                return;
            }
            this.l.setFace(null);
            return;
        }
        this.l.setFace(null);
    }

    private void I() {
        if (a.z() != null) {
            ag j = this.Y.j(a.z());
            if (j != null) {
                this.l.setBody(new bg(j, this.Y.b(j, a)));
                return;
            }
            this.l.setBody(null);
            return;
        }
        this.l.setBody(null);
    }

    private void J() {
        if (a.B() != null) {
            ag k = this.Y.k(a.B());
            if (k != null) {
                this.l.setHand(new bg(k, this.Y.b(k, a)));
                return;
            }
            this.l.setHand(null);
            return;
        }
        this.l.setHand(null);
    }

    private void K() {
        Picture picture = null;
        if (a.e() != null) {
            String e = a.e();
            b a = this.Y.a("hair", e, "back", al.a, Integer.valueOf(al.af[this.l.getHairColorIndex()]));
            b a2 = this.Y.a("hair", e, "backextra");
            b a3 = this.Y.a("hair", e, "front", al.a, Integer.valueOf(al.af[this.l.getHairColorIndex()]));
            b a4 = this.Y.a("hair", e, "frontextra");
            RectF rectF = new RectF(al.w);
            if (!(a == null || a.c == null)) {
                rectF.union(a.c);
            }
            if (!(a3 == null || a3.c == null)) {
                rectF.union(a3.c);
            }
            if (!(a2 == null || a2.c == null)) {
                rectF.union(a2.c);
            }
            if (!(a4 == null || a4.c == null)) {
                rectF.union(a4.c);
            }
            this.l.setHairBack(a == null ? null : a.a);
            this.l.setHairFront(a3 == null ? null : a3.a);
            this.l.setHairBackExtra(a2 == null ? null : a2.a);
            DroidView droidView = this.l;
            if (a4 != null) {
                picture = a4.a;
            }
            droidView.setHairFrontExtra(picture);
            this.l.setHairBounds(rectF);
            return;
        }
        this.l.setHairBack(null);
        this.l.setHairBackExtra(null);
        this.l.setHairFront(null);
        this.l.setHairFrontExtra(null);
        this.l.setHairBounds(al.w);
    }

    private void L() {
        if (a.f() != null) {
            String f = a.f();
            this.l.setShirtArm(this.Y.b("shirt", f, "arm"));
            this.l.setShirtBody(this.Y.b("shirt", f, "body"));
            this.l.setShirtTop(this.Y.b("shirt", f, "top"));
            this.l.setShirtBottom(this.Y.b("shirt", f, "bottom"));
            return;
        }
        this.l.setShirtArm(null);
        this.l.setShirtBody(null);
        this.l.setShirtTop(null);
        this.l.setShirtBottom(null);
    }

    private void M() {
        int i = al.ai[this.l.getSkinColorIndex()];
        this.l.a(this.Y.a((int) R.raw.android_leg, al.b, Integer.valueOf(i)).a, this.Y.a((int) R.raw.android_foot, al.b, Integer.valueOf(i)).a);
    }

    private void N() {
        if (a.g() != null) {
            String g = a.g();
            this.l.setPantsLeg(this.Y.b("pants", g, "leg"));
            this.l.setPantsSkirt(this.Y.b("pants", g, "skirt"));
            this.l.setPantsTop(this.Y.b("pants", g, "top"));
            return;
        }
        this.l.setPantsLeg(null);
        this.l.setPantsSkirt(null);
        this.l.setPantsTop(null);
    }

    private void O() {
        int i = al.ai[this.l.getSkinColorIndex()];
        this.l.a(this.Y.a((int) R.raw.android_head, al.b, Integer.valueOf(i)).a, this.Y.a((int) R.raw.android_body, al.b, Integer.valueOf(i)).a, this.Y.a((int) R.raw.android_arm, al.b, Integer.valueOf(i)).a, this.Y.a((int) R.raw.android_antenna, al.b, Integer.valueOf(i)).a);
    }

    private void P() {
        az azVar = new az();
        a(azVar);
        ShareActivity.a((Activity) this, azVar);
    }

    private boolean Q() {
        return e(false);
    }

    private void R() {
        a(0);
        b(0);
    }

    private void S() {
        j = 0;
        this.F = null;
        this.l.setVisibility(0);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.main_layout);
        View findViewById = findViewById(14445);
        Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) viewGroup.getHeight());
        translateAnimation.setDuration(450);
        translateAnimation.setAnimationListener(new n(this, viewGroup, findViewById));
        findViewById.startAnimation(translateAnimation);
    }

    private void T() {
        a(a);
        if (!a.b()) {
            d(a);
        }
        V();
    }

    private void U() {
        if (a == null || !a.D()) {
            W();
        }
    }

    private void V() {
        if (a == null) {
            a = new az();
        }
        a(a);
        SharedPreferences preferences = getPreferences(0);
        try {
            preferences.edit().putString("DROID_CONFIG", a.c()).apply();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void W() {
        String string = getPreferences(0).getString("DROID_CONFIG", null);
        if (string != null) {
            a = new az();
            try {
                a.a((Context) this, string);
            } catch (IOException e) {
                e.printStackTrace();
                a = null;
            }
        }
    }

    private void X() {
        if (a == null || a.E() == null) {
            this.U.setText("");
        } else {
            this.U.setText(a.E());
        }
    }

    private void Y() {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.U.getWindowToken(), 0);
    }

    public static float a() {
        return P;
    }

    public static ArrayList a(Activity activity, boolean z) {
        List arrayList = new ArrayList();
        c.a("Local class name: " + activity.getLocalClassName());
        SharedPreferences b = b(activity);
        for (String str : b.getAll().keySet()) {
            String str2;
            a.c(str2);
            if (str2.startsWith("savedDroid-")) {
                try {
                    str2 = b.getString(str2, null);
                    az azVar = new az();
                    azVar.a((Context) activity, str2);
                    if (azVar.E() != null) {
                        a.c(azVar.E() + " " + azVar.F());
                    } else {
                        azVar.g("");
                    }
                    arrayList.add(azVar);
                } catch (Throwable e) {
                    a.a("Error reading droid config", e);
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

    public static void a(float f, float f2, float f3, float f4) {
        float f5 = 2.0f / (f + f2);
        if (B != null) {
            B.a(f5, f3, f4);
        }
    }

    public static void a(Activity activity) {
        Intent intent = new Intent(activity, Androidify.class);
        intent.addFlags(67108864);
        activity.startActivity(intent);
    }

    public static void a(Activity activity, az azVar) {
        b(activity).edit().remove("savedDroid-" + azVar.F()).commit();
        a.a(activity.getCacheDir(), azVar.F() + ".png");
    }

    private void a(View view, boolean z) {
        a(view, z, 1.0f, null);
    }

    private void a(View view, boolean z, float f) {
        a(view, z, f, null);
    }

    private void a(View view, boolean z, float f, Runnable runnable) {
        float alpha = view.getAlpha();
        long j = (long) (250.0f * f);
        int i = z ? 1 : 0;
        if (view.getVisibility() != 0) {
            alpha = 0.0f;
        }
        if (alpha != ((float) i)) {
            Animation alphaAnimation = new AlphaAnimation(alpha, (float) i);
            alphaAnimation.setDuration(j);
            alphaAnimation.setAnimationListener(new z(this, view, z, runnable));
            view.startAnimation(alphaAnimation);
        }
    }

    private void a(CharSequence charSequence) {
        this.u = false;
        if (charSequence.equals("randomize")) {
            e(true);
            this.u = true;
            this.V.c();
        } else if (charSequence.equals(getString(R.string.menu_share))) {
            P();
            l();
        } else if (charSequence.equals(getString(R.string.menu_about))) {
            B();
            o();
        } else if (charSequence.equals(getString(R.string.menu_create_new))) {
            A();
        } else if (charSequence.equals("share_to_website")) {
            ShareToWebsiteActivity.a((Activity) this, a);
            o();
        } else if (charSequence.equals(getString(R.string.menu_my_androids))) {
            this.R.a("showGallery");
            ArrayList a = a((Activity) this, true);
            if (a != null && a.size() > 0) {
                startActivityForResult(new Intent(this, GalleryActivity.class), 100);
            }
            k();
        }
    }

    public static SharedPreferences b(Activity activity) {
        return activity.getSharedPreferences("Androidify", 0);
    }

    private void c(az azVar) {
        a = azVar;
        this.l.setHairColorIndex(a.a(al.af, azVar.s()));
        this.l.setSkinColorIndex(a.a(al.ai, azVar.t()));
        this.l.setPantsColorIndex(a.a(al.al, azVar.u()));
        O();
        M();
        K();
        L();
        N();
        D();
        E();
        F();
        G();
        H();
        I();
        J();
        this.l.a(azVar.k(), azVar.l(), azVar.m(), azVar.n(), azVar.o(), azVar.p(), azVar.q(), azVar.r());
    }

    private boolean d(az azVar) {
        if (azVar == null) {
            try {
                azVar = a;
                a(azVar);
            } catch (Exception e) {
                Toast.makeText(this, getString(R.string.error_save_droid_failed), 1).show();
                return false;
            }
        }
        SharedPreferences preferences = getPreferences(0);
        try {
            String c = azVar.c();
            a.c("-----------");
            a.c(c);
            c.a("[ENCODE] " + c);
            a.c("-----------");
            preferences.edit().putString("savedDroid-" + azVar.F(), c).apply();
            this.R.a("saveDroid");
            a.a(getCacheDir(), azVar.F() + ".png");
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return true;
    }

    private void e(az azVar) {
        j = 0;
        c(azVar);
        a = azVar;
        V();
        X();
        Toast.makeText(getApplicationContext(), getString(R.string.msg_droid_loaded), 0).show();
        if (B != null) {
            B.b();
        }
    }

    private boolean e(boolean z) {
        if (z) {
            C();
        }
        a = new az();
        this.l.c();
        R();
        a(a);
        V();
        this.l.e();
        c(a);
        this.l.invalidate();
        X();
        return true;
    }

    private void f(boolean z) {
        this.l.m();
        ArrayList a = a((Activity) this, true);
        if (a != null && a.size() != 0) {
            View frameLayout = new FrameLayout(this);
            Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
            int width = defaultDisplay.getWidth();
            int height = defaultDisplay.getHeight();
            Paint paint = new Paint();
            paint.setDither(true);
            float a2 = bs.a(this, width, height, a());
            Paint paint2 = new Paint();
            paint2.setFlags(1);
            paint.setShader(new LinearGradient((float) (width / 2), 0.0f, (float) (width / 2), ((float) height) - ((3.0f * a2) / 4.0f), -2236963, -6250336, TileMode.CLAMP));
            View jVar = new j(this, this, a2, paint, paint2);
            this.F = new Gallery(this);
            this.F.setLayoutParams(new LayoutParams(-1, -1));
            this.E = new bc(this, a, this.F, a2);
            this.F.setAdapter(this.E);
            this.F.setOnItemClickListener(this.aj);
            this.F.setUnselectedAlpha(1.0f);
            this.F.setCallbackDuringFling(false);
            this.F.setCallbackDuringFling(false);
            this.F.setOnItemSelectedListener(new k(this));
            this.F.setOnItemLongClickListener(new l(this));
            frameLayout.addView(jVar);
            frameLayout.addView(this.F);
            frameLayout.setLayoutParams(new LayoutParams(-1, -1));
            frameLayout.setId(14445);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.main_layout);
            viewGroup.addView(frameLayout);
            if (z) {
                Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) viewGroup.getHeight(), 0.0f);
                translateAnimation.setDuration(450);
                translateAnimation.setAnimationListener(new m(this));
                frameLayout.startAnimation(translateAnimation);
                if (B != null) {
                    B.b();
                }
            } else {
                this.l.setVisibility(8);
                this.E.a(5);
            }
            j = 1;
        }
    }

    public static void m() {
        K = true;
        if (B != null) {
            B.a(1.0f);
        }
    }

    public static void n() {
        if (K && B != null) {
            a.c("Drag ends!");
            B.g();
        }
        K = false;
    }

    private void y() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        O = Math.min(displayMetrics.heightPixels, displayMetrics.widthPixels) / 5;
        P = ((float) O) / 64.0f;
    }

    private void z() {
        long currentTimeMillis = System.currentTimeMillis();
        if (B == null) {
            this.l.postDelayed(new ab(this), 0);
        } else {
            B.a();
        }
        a.c("Sound start-up: " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void a(int i) {
        this.l.setHairColorIndex(i);
        K();
        F();
        this.l.invalidate();
        a(true, this.l.getHairColorIndex());
    }

    public void a(int i, boolean z) {
        this.l.a(i, z);
    }

    public void a(DroidView droidView) {
        if (this.c == null) {
            this.c = this.Y.a((int) R.raw.android_head, al.b, al.c).a;
            this.d = this.Y.a((int) R.raw.android_body, al.b, al.c).a;
            this.e = this.Y.a((int) R.raw.android_arm, al.b, al.c).a;
            this.f = this.Y.a((int) R.raw.android_antenna, al.b, al.c).a;
            this.g = this.Y.a((int) R.raw.android_leg, al.b, al.c).a;
            this.h = this.Y.a((int) R.raw.android_foot, al.b, al.c).a;
        }
        droidView.setHairBack(null);
        droidView.setHairFront(null);
        droidView.setHairBounds(al.w);
        droidView.setBeardBounds(al.y);
        droidView.setGlassesBounds(al.x);
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
        droidView.a(null, null);
        droidView.a(this.c, this.d, this.e, this.f);
        droidView.a(this.g, this.h);
        droidView.c();
    }

    public void a(DroidView droidView, az azVar) {
    }

    public void a(av avVar) {
        this.l.post(new i(this, avVar));
    }

    public void a(az azVar) {
        try {
            azVar.g(a.E());
            azVar.a(a.e());
            azVar.b(a.f());
            azVar.c(a.g());
            azVar.d(a.h());
            azVar.e(a.i());
            azVar.d(a.h());
            azVar.e(a.i());
            azVar.f(a.j());
            azVar.a(a.w(), a.v());
            azVar.b(a.y(), a.x());
            azVar.c(a.A(), a.z());
            azVar.d(a.C(), a.B());
            azVar.a(this.l.getDroidBody().b);
            azVar.b(this.l.getDroidBody().c);
            azVar.c(this.l.getDroidHead().b);
            azVar.d(this.l.getDroidHead().c);
            azVar.e(this.l.getDroidArm().b);
            azVar.f(this.l.getDroidArm().c);
            azVar.g(this.l.getDroidLegs().b);
            azVar.h(this.l.getDroidLegs().c);
            azVar.a(al.af[this.l.getHairColorIndex()]);
            azVar.b(al.ai[this.l.getSkinColorIndex()]);
            azVar.c(al.al[this.l.getPantsColorIndex()]);
            azVar.a(a.G());
            azVar.b(a.H());
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public void a(dk dkVar, boolean z) {
        if (B == null) {
            return;
        }
        if (z) {
            B.c();
        } else {
            B.b(dkVar);
        }
    }

    public void a(String str) {
        if (str == null) {
            return;
        }
        if (str.equals("shoes")) {
            this.l.b(bh.SHOES);
        } else if (str.equals("glasses")) {
            this.l.b(bh.GLASSES);
        } else if (str.equals("beard")) {
            this.l.b(bh.BEARD);
        } else if (str.equals("hair")) {
            this.l.b(bh.HAIR);
        } else if (str.equals("pants")) {
            this.l.b(bh.PANTS);
        } else if (str.equals("shirt")) {
            this.l.b(bh.SHIRT);
        }
    }

    public void a(String str, ag agVar, boolean z) {
        a(str, agVar, z, true);
    }

    public void a(String str, ag agVar, boolean z, boolean z2) {
        String str2 = null;
        String str3 = agVar.b;
        String str4 = agVar.c;
        Object obj = null;
        if (!agVar.e) {
            if (agVar.f != null) {
                a.a(agVar.f);
                obj = 1;
            }
            if (agVar.g != null) {
                a.b(agVar.g);
                obj = 1;
            }
        }
        if ("shirt".equals(str)) {
            a.b(z ? null : str3);
            L();
            a(dk.SHIRTS_PANTS, z);
            this.l.a(bh.SHIRT);
        } else if ("pants".equals(str)) {
            r1 = a;
            if (!z) {
                str2 = str3;
            }
            r1.c(str2);
            N();
            a(dk.SHIRTS_PANTS, z);
            this.l.a(bh.PANTS);
        } else if ("shoes".equals(str)) {
            r1 = a;
            if (!z) {
                str2 = str3;
            }
            r1.d(str2);
            D();
            a(dk.SHOES, z);
            this.l.a(bh.SHOES);
        } else if ("hair".equals(str)) {
            r1 = a;
            if (!z) {
                str2 = str3;
            }
            r1.a(str2);
            K();
            a(dk.HAIR, z);
            this.l.a(bh.HAIR);
        } else if ("glasses".equals(str)) {
            r1 = a;
            if (!z) {
                str2 = str3;
            }
            r1.e(str2);
            E();
            a(dk.GLASSES_ACCESSORIES, z);
        } else if ("beard".equals(str)) {
            r1 = a;
            if (!z) {
                str2 = str3;
            }
            r1.f(str2);
            F();
            a(dk.HAIR, z);
        } else if ("hat".equals(str)) {
            r1 = a;
            if (!z) {
                str2 = str3;
            }
            r1.a(str4, str2);
            G();
            a(dk.HAIR, z);
            this.l.a(bh.HAIR);
        } else if ("face".equals(str)) {
            r1 = a;
            if (!z) {
                str2 = str3;
            }
            r1.b(str4, str2);
            H();
            a(dk.GLASSES_ACCESSORIES, z);
        } else if ("body".equals(str)) {
            r1 = a;
            if (!z) {
                str2 = str3;
            }
            r1.c(str4, str2);
            I();
            a(dk.HAIR, z);
            this.l.a(bh.SHIRT);
        } else if ("hand".equals(str)) {
            r1 = a;
            if (!z) {
                str2 = str3;
            }
            r1.d(str4, str2);
            J();
            a(dk.GLASSES_ACCESSORIES, z);
        }
        if (obj != null) {
            G();
            H();
            I();
            J();
            D();
        }
        if (z2) {
            a(str);
        }
    }

    public void a(boolean z) {
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

    public void a(boolean z, int i) {
        if (B != null) {
            B.a(z, i);
        }
    }

    public void b() {
        this.Q = true;
        this.N = new az();
        a(this.N);
        e(false);
        this.V.c();
        this.l.m();
        this.l.l();
    }

    public void b(int i) {
        this.l.setSkinColorIndex(i);
        O();
        M();
        this.l.invalidate();
        a(false, i);
        this.l.c(1);
    }

    public void b(boolean z) {
        if (!z) {
            this.l.postDelayed(new ac(this), this.l.l() + 500);
        } else if (this.N != null) {
            c(this.N);
            this.N = null;
        }
        this.Q = false;
    }

    public a c() {
        return this.D;
    }

    public void c(int i) {
        this.l.c(i);
    }

    public void c(boolean z) {
        this.C = z;
    }

    public void closeDrawerClicked(View view) {
        if (this.V != null) {
            g();
            this.V.a(null);
        }
    }

    public void d() {
        if (this.v != null) {
            this.v.a();
            this.v = null;
        }
    }

    public void d(int i) {
        this.l.b(i);
    }

    public void d(boolean z) {
        boolean z2 = true;
        a.c("Randomize Droid");
        if (z) {
            C();
        }
        a = new az();
        this.l.d();
        b(i.nextInt(al.ai.length));
        a(i.nextInt(al.af.length));
        int nextInt = i.nextInt(this.Y.d().size());
        a("shirt", (ag) this.Y.d().get(nextInt), nextInt == 0);
        L();
        nextInt = i.nextInt(this.Y.c().size());
        a("hair", (ag) this.Y.c().get(nextInt), nextInt == 0);
        K();
        nextInt = i.nextInt(this.Y.f().size());
        a("shoes", (ag) this.Y.f().get(nextInt), nextInt == 0);
        D();
        nextInt = i.nextInt(this.Y.e().size());
        a("pants", (ag) this.Y.e().get(nextInt), nextInt == 0);
        N();
        if (i.nextInt(100) < 33) {
            nextInt = i.nextInt(this.Y.g().size());
            a("glasses", (ag) this.Y.g().get(nextInt), nextInt == 0);
        }
        E();
        if (i.nextInt(100) < 25) {
            nextInt = i.nextInt(this.Y.h().size());
            String str = "beard";
            ag agVar = (ag) this.Y.h().get(nextInt);
            if (nextInt != 0) {
                z2 = false;
            }
            a(str, agVar, z2);
        }
        F();
        a(a);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 24 || keyEvent.getKeyCode() == 25 || !this.Q || this.L.c()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        showDialog(10);
        return true;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.Q || this.L.c()) {
            if (this.U.hasFocus()) {
                this.U.clearFocus();
                Y();
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        showDialog(10);
        return true;
    }

    public az e() {
        return a;
    }

    public void f() {
        if (B != null) {
            B.a(true);
        }
    }

    public void g() {
        if (B != null) {
            B.a(false);
        }
    }

    public void h() {
        if (B != null) {
            B.b(true);
        }
    }

    public void i() {
        if (B != null) {
            B.b(false);
        }
    }

    public void j() {
        if (B != null) {
            B.d();
        }
    }

    public void k() {
        if (B != null) {
            B.e();
        }
    }

    public void l() {
        if (B != null) {
            B.f();
        }
    }

    public void o() {
        a(dk.UI, false);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (intent == null) {
                return;
            }
            if (intent.hasExtra("droidConfigIndex")) {
                int intExtra = intent.getIntExtra("droidConfigIndex", 0);
                ArrayList a = a((Activity) this, true);
                this.V.c();
                e((az) a.get(intExtra));
            } else if (intent.hasExtra("addButton")) {
                this.V.c();
                A();
            }
        } else if (i != 101) {
        } else {
            if (intent == null || !intent.hasExtra("menuTextSelected")) {
                i();
                return;
            }
            CharSequence stringExtra = intent.getStringExtra("menuTextSelected");
            c.a("Menu action: " + stringExtra);
            a(stringExtra);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(1);
        window.addFlags(4096);
    }

    public void onConfigurationChanged(Configuration configuration) {
        a.c("*** CONFIG CHANGED");
        this.l.b();
        super.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        a.c("ON CREATE");
        a.a("Androidify");
        A = getResources().getConfiguration().locale;
        y();
        this.R = i.a();
        this.R.a("UA-21099199-1", 60, getApplicationContext());
        this.R.a("start");
        setVolumeControlStream(3);
        super.onCreate(bundle);
        a.c("Initial onCreate time: " + (System.currentTimeMillis() - currentTimeMillis));
        System.currentTimeMillis();
        this.Y = ah.a((Context) this);
        try {
            currentTimeMillis = System.currentTimeMillis();
            Picture picture = this.Y.a((int) R.raw.android_body).a;
            Picture picture2 = this.Y.a((int) R.raw.android_head).a;
            Picture picture3 = this.Y.a((int) R.raw.android_antenna).a;
            Picture picture4 = this.Y.a((int) R.raw.android_arm).a;
            Picture picture5 = this.Y.a((int) R.raw.android_leg).a;
            Picture picture6 = this.Y.a((int) R.raw.android_foot).a;
            a.c("Load initial SVG resources: " + (System.currentTimeMillis() - currentTimeMillis));
            long currentTimeMillis2 = System.currentTimeMillis();
            this.D = new a(this);
            setContentView(R.layout.activity_androidify);
            this.l = (DroidView) findViewById(R.id.main_droid_view);
            this.l.a(this, picture, picture2, picture4, picture5, picture6, picture3);
            this.X = (TutorialView) findViewById(R.id.tutorial);
            this.X.a(0.0f, 0.0f, dm.LEFT, getString(R.string.tutorial_1), false);
            this.X.a(0.0f, 0.0f, dm.DOWN, getString(R.string.tutorial_2), true);
            this.X.a(0.0f, 0.0f, dm.DOWN, getString(R.string.tutorial_3), true);
            this.X.a(0.0f, 0.0f, dm.DOWN, getString(R.string.tutorial_5), true, 0.0f, 5);
            this.X.a(0.0f, 0.0f, dm.UP, getString(R.string.tutorial_6), false);
            this.x = (RelativeTouchRecordingLayout) findViewById(R.id.main_layout);
            this.L = new g(this.x, this, this.Y.a((int) R.raw.touchindicator_down).a, this.Y.a((int) R.raw.touchindicator_up).a, 1500);
            this.x.setTouchRecorder(this.L);
            this.x.setWillNotDraw(false);
            Typeface a = TextViewCompat.a((Context) this);
            findViewById(R.id.tv_header_main).setVisibility(4);
            this.U = (EditText) findViewById(R.id.et_droid_name);
            this.U.setVisibility(0);
            this.U.clearFocus();
            this.U.setTypeface(a);
            X();
            this.U.setOnFocusChangeListener(new g(this));
            this.T = (ImageButton) findViewById(R.id.btn_menu_burger);
            this.T.setOnClickListener(new q(this));
            Picture picture7 = this.Y.a((int) R.raw.otherassets_off).a;
            picture7 = this.Y.a((int) R.raw.otherassets_close).a;
            this.V = new an(this, (ViewGroup) findViewById(R.id.drawer), !getPreferences(0).contains("SAW_NEW_BADGE"));
            this.x.setBackgroundColor(-1);
            a.c("UI setup time: " + (System.currentTimeMillis() - currentTimeMillis2));
            currentTimeMillis = System.currentTimeMillis();
            if (bundle != null && bundle.containsKey("galleryItem")) {
                this.ae = (int) bundle.getLong("galleryItem");
            }
            a.c("Rest of oncreate: " + (System.currentTimeMillis() - currentTimeMillis));
        } catch (Throwable e) {
            Log.e("DROIDIFY", "Failed", e);
        }
        this.W = (ImageButton) findViewById(R.id.btn_checkmark);
        this.W.setVisibility(0);
        this.W.setOnClickListener(new y(this));
        if (getPreferences(0).contains("SAW_TUTORIAL")) {
            if (this.Z != null) {
                this.Z.setVisibility(8);
            }
            z();
            return;
        }
        c(false);
        this.ac = findViewById(R.id.header);
        this.ad = findViewById(R.id.drawer);
        a(this.ac, false, 0.0f);
        a(this.ad, false, 0.0f);
        a(this.l, false, 0.0f);
        a(this.U, false, 0.0f);
        this.Z = (SurfaceView) findViewById(R.id.intro_video);
        this.Z.setZOrderOnTop(true);
        this.ab = this.Z.getHolder();
        this.ab.addCallback(this);
        this.Z.setVisibility(0);
    }

    protected Dialog onCreateDialog(int i) {
        Dialog dialog = null;
        long currentTimeMillis = System.currentTimeMillis();
        a.c("--> onCreateDialog: start");
        getResources();
        switch (i) {
            case cm.HListView_hlv_overScrollFooter /*6*/:
                this.L.a(getResources().openRawResource(R.raw.startupevents));
                break;
            case cm.HListView_hlv_measureWithChild /*7*/:
                Q();
                break;
            case 10:
                this.L.b();
                b(true);
                break;
            default:
                if (dialog != null) {
                    dialog.setOnDismissListener(this.ak);
                }
                a.c("Create dialog time: " + (System.currentTimeMillis() - currentTimeMillis));
                break;
        }
        return dialog;
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (j == 1) {
                S();
                if (B == null) {
                    return true;
                }
                B.b();
                return true;
            } else if (this.V.d()) {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        a(menuItem.getTitle());
        return true;
    }

    protected void onPause() {
        super.onPause();
        if (B != null) {
            B.h();
        }
        d();
        a.c("Stopping antenna twitch.");
        if (this.D != null) {
            this.D.c();
        }
        T();
        if (this.Q) {
            this.L.b();
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        int i;
        a.c("PREPARE MENU");
        int size = menu.size();
        for (i = 0; i < size; i++) {
            menu.removeItem(menu.getItem(0).getItemId());
        }
        MenuItem menuItem;
        if (j == 1) {
            for (i = 0; i < J.size(); i++) {
                menuItem = (MenuItem) J.get(i);
                menu.add(menuItem.getGroupId(), menuItem.getItemId(), i, menuItem.getTitle());
                menu.getItem(i).setIcon(menuItem.getIcon());
            }
        } else {
            for (i = 0; i < I.size(); i++) {
                menuItem = (MenuItem) I.get(i);
                menu.add(menuItem.getGroupId(), menuItem.getItemId(), i, menuItem.getTitle());
                menu.getItem(i).setIcon(menuItem.getIcon());
            }
        }
        return true;
    }

    protected void onResume() {
        long currentTimeMillis = System.currentTimeMillis();
        super.onResume();
        a.c("Starting antenna twitch.");
        if (this.w) {
            this.v = this.l.a();
        }
        if (this.C) {
            this.D.b();
        }
        this.af.sendEmptyMessageDelayed(0, 200);
        a.c("onResume time: " + (System.currentTimeMillis() - currentTimeMillis));
    }

    protected void onSaveInstanceState(Bundle bundle) {
        if (this.F != null) {
            bundle.putLong("galleryItem", this.F.getSelectedItemId());
        }
    }

    protected void onStart() {
        long currentTimeMillis = System.currentTimeMillis();
        super.onStart();
        getPreferences(0);
        U();
        if (this.N != null) {
            c(this.N);
            this.N = null;
        } else if (a != null) {
            c(a);
            if (a.E() != null && a.E().length() > 0) {
                this.U.setText(a.E());
            }
        } else {
            a = new az();
        }
        if (j == 1 && findViewById(14445) == null) {
            f(false);
            if (this.ae >= 0) {
                this.F.setSelection(this.ae);
                this.ae = -1;
            }
        }
        if (this.u) {
            d(false);
            this.u = false;
        }
        a.c("onStart time: " + (System.currentTimeMillis() - currentTimeMillis));
    }

    protected void onStop() {
        this.S = null;
        if (a != null && a.D()) {
            c.a("Track droid config.");
            a.d();
        }
        super.onStop();
    }

    public void onWindowFocusChanged(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (z) {
            this.l.b();
        }
        a.c("onWindowFocusChanged: " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public DroidView p() {
        return this.l;
    }

    public void q() {
        this.V.a();
    }

    public void r() {
        this.V.b();
    }

    public void s() {
        this.l.b(bh.SHIRT_AND_PANTS);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        try {
            AssetFileDescriptor openFd = getAssets().openFd("intro_30fps_13.mp4");
            DisplayMetrics a = c.a((Activity) this);
            c.a("screenSize = " + a);
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
            String extractMetadata = mediaMetadataRetriever.extractMetadata(19);
            String extractMetadata2 = mediaMetadataRetriever.extractMetadata(18);
            float parseFloat = Float.parseFloat(extractMetadata);
            c.a("mVideoHeight = " + parseFloat);
            float parseFloat2 = Float.parseFloat(extractMetadata2);
            c.a("mVideoWidth = " + parseFloat2);
            parseFloat2 = parseFloat / parseFloat2;
            c.a("Aspect is " + parseFloat2);
            int width = this.Z.getWidth();
            c.a("viewWidth = " + width);
            this.Z.getHeight();
            float f = ((float) width) * parseFloat2;
            parseFloat = (float) width;
            float height = (float) ((ViewGroup) this.Z.getParent()).getHeight();
            if (f > height) {
                parseFloat2 = (parseFloat * height) / f;
                parseFloat = height;
            } else {
                parseFloat2 = parseFloat;
                parseFloat = f;
            }
            c.a("Droidview top of view: " + this.l.getTop());
            c.a("Droidview topY: " + this.l.getTopY());
            c.a("New height is " + parseFloat);
            LayoutParams layoutParams = this.Z.getLayoutParams();
            layoutParams.width = (int) parseFloat2;
            layoutParams.height = (int) parseFloat;
            this.Z.setLayoutParams(layoutParams);
            this.Z.requestLayout();
            int i = (int) (0.41153845f * parseFloat);
            width = (int) ((((float) a.heightPixels) - parseFloat) / 2.0f);
            c.a("Video top of droid in pixels: " + i);
            c.a("Video view top: " + width);
            i = (i + width) - (this.l.getTop() + this.l.getTopY());
            c.a("Video view adjust: " + i);
            this.Z.setTranslationY((float) (-i));
            this.aa = new MediaPlayer();
            this.aa.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
            this.aa.setDisplay(surfaceHolder);
            this.aa.prepare();
            this.aa.setOnPreparedListener(new t(this));
            this.aa.setOnCompletionListener(new u(this));
        } catch (Throwable th) {
            a.a("Error during video setup. Skipping to app.", th);
            this.l.post(new v(this));
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    public ah t() {
        return this.Y;
    }

    public void u() {
        c.a("Fading out video view.");
        a(this.l, true);
        a(this.Z, false);
        a(this.ac, true);
        a(this.ad, true);
        a(this.U, true, 1.0f, new w(this));
        this.l.postDelayed(new x(this), 1000);
    }

    public void v() {
        getPreferences(0).edit().putBoolean("SAW_NEW_BADGE", true).apply();
    }
}
