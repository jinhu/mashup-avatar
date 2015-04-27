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
import com.google.android.apps.androidify.p018a.C0208e;
import com.google.android.apps.p016a.C0185i;
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
    private static HashMap f905a;
    private static HashMap f906b;
    private static HashMap f907c;
    private ProgressRelativeLayout f908d;
    private ce f909e;
    private C0185i f910f;
    private AsyncTask f911g;
    private int f912h;
    private int f913i;
    private ba f914j;
    private cw f915k;
    private DrawView f916l;
    private HListView f917m;
    private ah f918n;
    private az f919o;
    private View f920p;
    private TextView f921q;
    private View f922r;
    private int f923s;
    private int f924t;
    private Paint f925u;
    private long f926v;

    static {
        f905a = new HashMap();
        f906b = new HashMap();
        f907c = new HashMap();
        f905a.put(Integer.valueOf(R.raw.anim_blowkiss), Float.valueOf(0.8f));
        f905a.put(Integer.valueOf(R.raw.anim_highfive), Float.valueOf(0.8f));
        f905a.put(Integer.valueOf(R.raw.anim_airguitar), Float.valueOf(0.83f));
        f905a.put(Integer.valueOf(R.raw.anim_farewell), Float.valueOf(0.8f));
        f905a.put(Integer.valueOf(R.raw.anim_sleeping), Float.valueOf(0.95f));
        f905a.put(Integer.valueOf(R.raw.anim_exhausted), Float.valueOf(0.72f));
        f905a.put(Integer.valueOf(R.raw.anim_ropepulldancing), Float.valueOf(0.85f));
        f905a.put(Integer.valueOf(R.raw.anim_flying), Float.valueOf(0.85f));
        f905a.put(Integer.valueOf(R.raw.anim_giggling), Float.valueOf(0.9f));
        f905a.put(Integer.valueOf(R.raw.anim_lol), Float.valueOf(0.9f));
        f905a.put(Integer.valueOf(R.raw.anim_basketball_dribble), Float.valueOf(0.7f));
        f905a.put(Integer.valueOf(R.raw.anim_basketball_crossover), Float.valueOf(0.78f));
        f905a.put(Integer.valueOf(R.raw.anim_basketball_shoot), Float.valueOf(0.8f));
        f905a.put(Integer.valueOf(R.raw.anim_steaming), Float.valueOf(0.85f));
        f906b.put("com.facebook.katana", Integer.valueOf(R.string.custom_share_message_facebook));
        f906b.put("com.twitter.android", Integer.valueOf(R.string.custom_share_message_twitter));
        f906b.put("com.google.android.apps.plus", Integer.valueOf(R.string.custom_share_message_gplus));
        f907c.put("com.facebook.katana", Integer.valueOf(R.string.custom_share_message_nba_facebook));
        f907c.put("com.twitter.android", Integer.valueOf(R.string.custom_share_message_nba_twitter));
        f907c.put("com.google.android.apps.plus", Integer.valueOf(R.string.custom_share_message_nba_gplus));
    }

    public ShareActivity() {
        this.f915k = cw.SELECTING;
        this.f923s = 0;
        this.f925u = new Paint(2);
        this.f926v = 0;
    }

    private File m1534a(String str) {
        String str2 = Environment.getExternalStorageDirectory() + "/DCIM/Camera/";
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str2 + "androidify." + str);
    }

    public static void m1535a(Activity activity, az azVar) {
        try {
            Intent intent = new Intent(activity, ShareActivity.class);
            intent.putExtra("DroidConfig", azVar.m1787c());
            activity.startActivity(intent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void m1538a(ce ceVar, View view) {
        this.f915k = cw.EXPORTING;
        this.f908d.setEnabled(false);
        m1557a(true);
        C0208e c0208e = (C0208e) ceVar.getItem(this.f923s);
        try {
            this.f910f.m1189a("Share", "Motion", "" + this.f923s, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (c0208e != null) {
            m1556a(c0208e);
        } else {
            m1552a();
        }
    }

    private void m1539a(File file, String str) {
        Resources resources = getResources();
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setType(str);
        intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
        intent.setFlags(268468224);
        PackageManager packageManager = getPackageManager();
        this.f919o.m1780a(this.f918n);
        List queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        List arrayList = new ArrayList();
        intent = ShareToWebsiteActivity.m1564b(this, this.f919o);
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
                if (f906b.keySet().contains(toLowerCase)) {
                    intent2.putExtra("android.intent.extra.TEXT", getString(((Integer) f906b.get(toLowerCase)).intValue()));
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
            intent.putExtra("configString", this.f919o.m1787c());
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        intent.putExtra("qrMode", true);
        intent = Intent.createChooser(intent, resources.getString(R.string.share_title));
        intent.putExtra("android.intent.extra.INITIAL_INTENTS", (LabeledIntent[]) arrayList.toArray(new LabeledIntent[arrayList.size()]));
        startActivity(intent);
    }

    private void m1541b() {
        long currentTimeMillis = System.currentTimeMillis();
        C0220c.m1912a("- Elapsed: " + (currentTimeMillis - this.f926v));
        this.f926v = currentTimeMillis;
    }

    private void m1543c() {
        if (this.f911g != null) {
            this.f911g.cancel(false);
        }
    }

    public void m1552a() {
        this.f915k = cw.EXPORTING;
        try {
            File a = m1534a("png");
            OutputStream fileOutputStream = new FileOutputStream(a);
            Bitmap createBitmap = Bitmap.createBitmap(500, 500, Config.ARGB_8888);
            ba baVar = new ba(this);
            baVar.m1844a(this.f919o, this.f918n);
            baVar.m1835a(500, 500);
            baVar.m1848b(m1559c(this.f909e.m1924a(this.f923s)));
            baVar.m1837a(new Canvas(createBitmap));
            createBitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            m1539a(a, "image/png");
            m1558b(this.f924t);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } finally {
            this.f916l.postDelayed(new cu(this), 500);
        }
        try {
            this.f910f.m1189a("Share", "Static", "", 0);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void m1553a(int i) {
        C0208e c0208e = (C0208e) this.f909e.getItem(i);
        C0220c.m1912a("MOTION Previewing motion " + i + ", null = " + (c0208e == null));
        if (i == 0 || c0208e != null) {
            C0220c.m1912a("MOTION   Setting motion now.");
            this.f916l.setMotion(c0208e);
        }
        this.f914j.m1851b(false);
    }

    public void m1554a(int i, int i2) {
        int childCount = this.f917m.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.f917m.getChildAt(i3);
            if (childAt instanceof DrawView) {
                DrawView drawView = (DrawView) childAt;
                drawView.setBackgroundColor(((Integer) drawView.getTag()).intValue() == this.f909e.m1923a() ? i2 : i);
            }
        }
    }

    public void m1555a(DrawView drawView, int i) {
        m1553a(i);
        m1558b(this.f912h);
        drawView.setBackgroundColor(this.f913i);
        this.f923s = i;
        this.f909e.m1926b(i);
    }

    public void m1556a(C0208e c0208e) {
        this.f911g = new cv(this, c0208e);
        this.f911g.execute(new Void[0]);
    }

    public void m1557a(boolean z) {
        int childCount = this.f917m.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f917m.getChildAt(i);
            if (childAt instanceof DrawView) {
                DrawView drawView = (DrawView) childAt;
                if (drawView.m1427b() != z) {
                    drawView.setPaused(z);
                }
            }
        }
    }

    public void m1558b(int i) {
        int childCount = this.f917m.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.f917m.getChildAt(i2);
            if (childAt instanceof DrawView) {
                ((DrawView) childAt).setBackgroundColor(i);
            }
        }
    }

    public float m1559c(int i) {
        Float f = (Float) f905a.get(Integer.valueOf(i));
        return f != null ? f.floatValue() : 1.0f;
    }

    public void clickedClose(View view) {
        finish();
        dh.m1956a((Context) this);
    }

    public void clickedShare(View view) {
        if (this.f915k != cw.EXPORTING) {
            C0220c.m1912a("Button clicked");
            m1538a(this.f909e, view);
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
                azVar.m1776a((Context) this, stringExtra);
            } catch (IOException e) {
                e.printStackTrace();
                azVar = null;
            }
        } else {
            azVar = null;
        }
        setContentView(R.layout.activity_share);
        this.f918n = ah.m1648a((Context) this);
        if (azVar == null) {
            this.f919o = this.f918n.m1656a();
        } else {
            this.f919o = azVar;
        }
        this.f924t = getResources().getColor(R.color.bg_grey);
        this.f920p = findViewById(R.id.header);
        bu.m1894a(this.f920p, getString(R.string.share_your_android), false, false, false, false, true);
        this.f921q = (TextView) findViewById(R.id.tv_header_main);
        this.f916l = (DrawView) findViewById(R.id.draw_view);
        this.f914j = new ba(this);
        this.f914j.m1844a(this.f919o, ah.m1648a((Context) this));
        this.f916l.setDroidDrawer(this.f914j);
        this.f916l.setShowPoster(false);
        this.f917m = (HListView) findViewById(R.id.main_drawer);
        this.f913i = getResources().getColor(R.color.bg_grey);
        this.f912h = -1;
        azVar = az.m1762a();
        azVar.m1782b(getResources().getColor(R.color.gray_android));
        azVar.m1797e(0.75f);
        azVar.m1800f(1.0f);
        azVar.m1793d(1.2f);
        azVar.m1788c(0.9f);
        azVar.m1774a(0.7f);
        azVar.m1781b(0.8f);
        azVar.m1803g(0.8f);
        azVar.m1806h(2.25f);
        azVar.m1794d("gray_shoes");
        this.f909e = new ce(this, azVar, this.f916l);
        this.f909e.m1925a(true);
        this.f908d = (ProgressRelativeLayout) findViewById(R.id.rl_motion_bottom_bar);
        this.f908d.setVisibility(0);
        this.f917m.setAdapter(this.f909e);
        this.f917m.setOnItemClickListener(new cs(this));
        this.f922r = findViewById(R.id.btn_motion_share);
        this.f908d.setOnClickListener(new ct(this));
        try {
            this.f910f = C0185i.m1177a();
            this.f910f.m1184a("share");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    protected void onPause() {
        super.onPause();
        m1557a(true);
        m1543c();
    }

    protected void onResume() {
        super.onResume();
        m1557a(false);
    }

    public void previewClicked(View view) {
        int a = this.f909e.m1923a();
        int count = this.f909e.getCount();
        C0220c.m1912a("MOTION - Preview clicked - was " + a);
        a = (a + 1) % count;
        C0220c.m1912a("MOTION   - Now " + a);
        this.f909e.m1926b(a);
        m1553a(a);
        if (a == 0) {
            this.f917m.setSelection(a);
        } else {
            this.f917m.m2291c(a);
        }
        m1554a(this.f912h, this.f913i);
        this.f923s = a;
    }
}
