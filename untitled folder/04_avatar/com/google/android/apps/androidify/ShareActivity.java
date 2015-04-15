package com.google.android.apps.androidify;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;
import com.google.android.apps.a.i;
import com.google.android.apps.androidify.a.e;
import it.sephiroth.android.library.widget.HListView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShareActivity extends Activity {
    private static HashMap a;
    private static HashMap b;
    private static HashMap c;
    private ProgressRelativeLayout d;
    private ce e;
    private i f;
    private AsyncTask g;
    private int h;
    private int i;
    private ba j;
    private cw k;
    private DrawView l;
    private HListView m;
    private ah n;
    private az o;
    private View p;
    private TextView q;
    private View r;
    private int s;
    private int t;
    private Paint u;
    private long v;

    static {
        a = new HashMap();
        b = new HashMap();
        c = new HashMap();
        a.put(Integer.valueOf(R.raw.anim_blowkiss), Float.valueOf(0.8f));
        a.put(Integer.valueOf(R.raw.anim_highfive), Float.valueOf(0.8f));
        a.put(Integer.valueOf(R.raw.anim_airguitar), Float.valueOf(0.83f));
        a.put(Integer.valueOf(R.raw.anim_farewell), Float.valueOf(0.8f));
        a.put(Integer.valueOf(R.raw.anim_sleeping), Float.valueOf(0.95f));
        a.put(Integer.valueOf(R.raw.anim_exhausted), Float.valueOf(0.72f));
        a.put(Integer.valueOf(R.raw.anim_ropepulldancing), Float.valueOf(0.85f));
        a.put(Integer.valueOf(R.raw.anim_flying), Float.valueOf(0.85f));
        a.put(Integer.valueOf(R.raw.anim_giggling), Float.valueOf(0.9f));
        a.put(Integer.valueOf(R.raw.anim_lol), Float.valueOf(0.9f));
        a.put(Integer.valueOf(R.raw.anim_basketball_dribble), Float.valueOf(0.7f));
        a.put(Integer.valueOf(R.raw.anim_basketball_crossover), Float.valueOf(0.78f));
        a.put(Integer.valueOf(R.raw.anim_basketball_shoot), Float.valueOf(0.8f));
        a.put(Integer.valueOf(R.raw.anim_steaming), Float.valueOf(0.85f));
        b.put("com.facebook.katana", Integer.valueOf(R.string.custom_share_message_facebook));
        b.put("com.twitter.android", Integer.valueOf(R.string.custom_share_message_twitter));
        b.put("com.google.android.apps.plus", Integer.valueOf(R.string.custom_share_message_gplus));
        c.put("com.facebook.katana", Integer.valueOf(R.string.custom_share_message_nba_facebook));
        c.put("com.twitter.android", Integer.valueOf(R.string.custom_share_message_nba_twitter));
        c.put("com.google.android.apps.plus", Integer.valueOf(R.string.custom_share_message_nba_gplus));
    }

    public ShareActivity() {
        this.k = cw.SELECTING;
        this.s = 0;
        this.u = new Paint(2);
        this.v = 0;
    }

    private File a(String str) {
        String str2 = Environment.getExternalStorageDirectory() + "/DCIM/Camera/";
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str2 + "androidify." + str);
    }

    public static void a(Activity activity, az azVar) {
        try {
            Intent intent = new Intent(activity, ShareActivity.class);
            intent.putExtra("DroidConfig", azVar.c());
            activity.startActivity(intent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void a(ce ceVar, View view) {
        this.k = cw.EXPORTING;
        this.d.setEnabled(false);
        a(true);
        e eVar = (e) ceVar.getItem(this.s);
        try {
            this.f.a("Share", "Motion", "" + this.s, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (eVar != null) {
            a(eVar);
        } else {
            a();
        }
    }

    private void a(File file, String str) {
        Resources resources = getResources();
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setType(str);
        intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
        intent.setFlags(268468224);
        PackageManager packageManager = getPackageManager();
        this.o.a(this.n);
        List queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        List arrayList = new ArrayList();
        intent = ShareToWebsiteActivity.b(this, this.o);
        intent.putExtra("android.intent.extra.TEXT", R.string.share_to_androidify_share_item);
        arrayList.add(new LabeledIntent(intent, intent.getPackage(), R.string.share_to_androidify_share_item, R.drawable.ic_launcher));
        for (int i = 0; i < queryIntentActivities.size(); i++) {
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivities.get(i);
            String str2 = resolveInfo.activityInfo.packageName;
            Intent intent2 = new Intent();
            intent2.setComponent(new ComponentName(str2, resolveInfo.activityInfo.name));
            intent2.setAction("android.intent.action.SEND");
            intent2.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
            try {
                String toLowerCase = resolveInfo.activityInfo.applicationInfo.packageName.toLowerCase();
                if (b.keySet().contains(toLowerCase)) {
                    intent2.putExtra("android.intent.extra.TEXT", getString(((Integer) b.get(toLowerCase)).intValue()));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            intent2.setType(str);
            arrayList.add(new LabeledIntent(intent2, str2, resolveInfo.loadLabel(packageManager), resolveInfo.icon));
        }
        intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("customAndroidifyShare");
        try {
            intent.putExtra("configString", this.o.c());
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        intent.putExtra("qrMode", true);
        intent = Intent.createChooser(intent, resources.getString(R.string.share_title));
        intent.putExtra("android.intent.extra.INITIAL_INTENTS", (LabeledIntent[]) arrayList.toArray(new LabeledIntent[arrayList.size()]));
        startActivity(intent);
    }

    private void b() {
        long currentTimeMillis = System.currentTimeMillis();
        c.a("- Elapsed: " + (currentTimeMillis - this.v));
        this.v = currentTimeMillis;
    }

    private void c() {
        if (this.g != null) {
            this.g.cancel(false);
        }
    }

    public void a() {
        this.k = cw.EXPORTING;
        try {
            File a = a("png");
            OutputStream fileOutputStream = new FileOutputStream(a);
            Bitmap createBitmap = Bitmap.createBitmap(500, 500, Config.ARGB_8888);
            ba baVar = new ba(this);
            baVar.a(this.o, this.n);
            baVar.a(500, 500);
            baVar.b(c(this.e.a(this.s)));
            baVar.a(new Canvas(createBitmap));
            createBitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            a(a, "image/png");
            b(this.t);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } finally {
            this.l.postDelayed(new cu(this), 500);
        }
        try {
            this.f.a("Share", "Static", "", 0);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void a(int i) {
        e eVar = (e) this.e.getItem(i);
        c.a("MOTION Previewing motion " + i + ", null = " + (eVar == null));
        if (i == 0 || eVar != null) {
            c.a("MOTION   Setting motion now.");
            this.l.setMotion(eVar);
        }
        this.j.b(false);
    }

    public void a(int i, int i2) {
        int childCount = this.m.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.m.getChildAt(i3);
            if (childAt instanceof DrawView) {
                DrawView drawView = (DrawView) childAt;
                drawView.setBackgroundColor(((Integer) drawView.getTag()).intValue() == this.e.a() ? i2 : i);
            }
        }
    }

    public void a(DrawView drawView, int i) {
        a(i);
        b(this.h);
        drawView.setBackgroundColor(this.i);
        this.s = i;
        this.e.b(i);
    }

    public void a(e eVar) {
        this.g = new cv(this, eVar);
        this.g.execute(new Void[0]);
    }

    public void a(boolean z) {
        int childCount = this.m.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.m.getChildAt(i);
            if (childAt instanceof DrawView) {
                DrawView drawView = (DrawView) childAt;
                if (drawView.b() != z) {
                    drawView.setPaused(z);
                }
            }
        }
    }

    public void b(int i) {
        int childCount = this.m.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.m.getChildAt(i2);
            if (childAt instanceof DrawView) {
                ((DrawView) childAt).setBackgroundColor(i);
            }
        }
    }

    public float c(int i) {
        Float f = (Float) a.get(Integer.valueOf(i));
        return f != null ? f.floatValue() : 1.0f;
    }

    public void clickedClose(View view) {
        finish();
        dh.a((Context) this);
    }

    public void clickedShare(View view) {
        if (this.k != cw.EXPORTING) {
            c.a("Button clicked");
            a(this.e, view);
        }
    }

    protected void onCreate(Bundle bundle) {
        az azVar;
        super.onCreate(bundle);
        requestWindowFeature(1);
        if (getIntent().hasExtra("DroidConfig")) {
            String stringExtra = getIntent().getStringExtra("DroidConfig");
            try {
                azVar = new az();
                azVar.a((Context) this, stringExtra);
            } catch (IOException e) {
                e.printStackTrace();
                azVar = null;
            }
        } else {
            azVar = null;
        }
        setContentView(R.layout.activity_share);
        this.n = ah.a((Context) this);
        if (azVar == null) {
            this.o = this.n.a();
        } else {
            this.o = azVar;
        }
        this.t = getResources().getColor(R.color.bg_grey);
        this.p = findViewById(R.id.header);
        bu.a(this.p, getString(R.string.share_your_android), false, false, false, false, true);
        this.q = (TextView) findViewById(R.id.tv_header_main);
        this.l = (DrawView) findViewById(R.id.draw_view);
        this.j = new ba(this);
        this.j.a(this.o, ah.a((Context) this));
        this.l.setDroidDrawer(this.j);
        this.l.setShowPoster(false);
        this.m = (HListView) findViewById(R.id.main_drawer);
        this.i = getResources().getColor(R.color.bg_grey);
        this.h = -1;
        azVar = az.a();
        azVar.b(getResources().getColor(R.color.gray_android));
        azVar.e(0.75f);
        azVar.f(1.0f);
        azVar.d(1.2f);
        azVar.c(0.9f);
        azVar.a(0.7f);
        azVar.b(0.8f);
        azVar.g(0.8f);
        azVar.h(2.25f);
        azVar.d("gray_shoes");
        this.e = new ce(this, azVar, this.l);
        this.e.a(true);
        this.d = (ProgressRelativeLayout) findViewById(R.id.rl_motion_bottom_bar);
        this.d.setVisibility(0);
        this.m.setAdapter(this.e);
        this.m.setOnItemClickListener(new cs(this));
        this.r = findViewById(R.id.btn_motion_share);
        this.d.setOnClickListener(new ct(this));
        try {
            this.f = i.a();
            this.f.a("share");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    protected void onPause() {
        super.onPause();
        a(true);
        c();
    }

    protected void onResume() {
        super.onResume();
        a(false);
    }

    public void previewClicked(View view) {
        int a = this.e.a();
        int count = this.e.getCount();
        c.a("MOTION - Preview clicked - was " + a);
        a = (a + 1) % count;
        c.a("MOTION   - Now " + a);
        this.e.b(a);
        a(a);
        if (a == 0) {
            this.m.setSelection(a);
        } else {
            this.m.c(a);
        }
        a(this.h, this.i);
        this.s = a;
    }
}
