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

import com.google.android.apps.androidify.p018a.AnimationCatalogue;
import com.google.android.apps.analytics.GoogleAnalyticsTracker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dev.game.legend.avatar.R;
import it.sephiroth.android.library.widget.HListView;

public class ShareActivity extends Activity {
    private static HashMap f905a;
    private static HashMap f906b;
    private static HashMap f907c;
    private ProgressRelativeLayout mProgressRelativeLayout;
    private AndroidModelAdapter mViewAdapter;
    private GoogleAnalyticsTracker f910f;
    private AsyncTask f911g;
    private int f912h;
    private int f913i;
    private AndroidDrawer f914j;
    cw f915k;
    private DrawView f916l;
    private HListView mHorizontalListView;
    private AssetDatabase f918n;
    private AndroidConfig f919o;
    private View f920p;
    TextView f921q;
    private View f922r;
    private int f923s;
    private int f924t;
    private Paint f925u;
    long f926v;

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

    File m1534a(String str) {
        String str2 = Environment.getExternalStorageDirectory() + "/DCIM/Camera/";
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str2 + "androidify." + str);
    }

    public static void m1535a(Activity activity, AndroidConfig aAndroidConfigVar) {
        try {
            Intent intent = new Intent(activity, ShareActivity.class);
            intent.putExtra("DroidConfig", aAndroidConfigVar.m1787c());
            activity.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void m1538a(AndroidModelAdapter aAndroidModelAdapterVar, View view) {
        this.f915k = cw.EXPORTING;
        this.mProgressRelativeLayout.setEnabled(false);
        m1557a(true);
        AnimationCatalogue animationCatalogue = (AnimationCatalogue) aAndroidModelAdapterVar.getItem(this.f923s);
        try {
            this.f910f.m1189a("Share", "Motion", "" + this.f923s, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (animationCatalogue != null) {
            m1556a(animationCatalogue);
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
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        intent.putExtra("qrMode", true);
        intent = Intent.createChooser(intent, resources.getString(R.string.share_title));
        intent.putExtra("android.intent.extra.INITIAL_INTENTS", (LabeledIntent[]) arrayList.toArray(new LabeledIntent[arrayList.size()]));
        startActivity(intent);
    }

    void m1541b() {
        long currentTimeMillis = System.currentTimeMillis();
        Util.debug("- Elapsed: " + (currentTimeMillis - this.f926v));
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
            AndroidDrawer androidDrawerVar = new AndroidDrawer(this);
            androidDrawerVar.setAndroidConfig(this.f919o, this.f918n);
            androidDrawerVar.m1835a(500, 500);
            androidDrawerVar.m1848b(m1559c(this.mViewAdapter.m1924a(this.f923s)));
            androidDrawerVar.m1837a(new Canvas(createBitmap));
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
        AnimationCatalogue animationCatalogue = (AnimationCatalogue) this.mViewAdapter.getItem(i);
        Util.debug("MOTION Previewing motion " + i + ", null = " + (animationCatalogue == null));
        if (i == 0 || animationCatalogue != null) {
            Util.debug("MOTION   Setting motion now.");
            this.f916l.setMotion(animationCatalogue);
        }
        this.f914j.m1851b(false);
    }

    public void m1554a(int i, int i2) {
        int childCount = mHorizontalListView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.mHorizontalListView.getChildAt(i3);
            if (childAt instanceof DrawView) {
                DrawView drawView = (DrawView) childAt;
                drawView.setBackgroundColor(((Integer) drawView.getTag()).intValue() == this.mViewAdapter.m1923a() ? i2 : i);
            }
        }
    }

    public void m1555a(DrawView drawView, int i) {
        m1553a(i);
        m1558b(this.f912h);
        drawView.setBackgroundColor(this.f913i);
        this.f923s = i;
        this.mViewAdapter.m1926b(i);
    }

    public void m1556a(AnimationCatalogue aAnimationCatalogue) {
        this.f911g = new cv(this, aAnimationCatalogue);
        this.f911g.execute(new Void[0]);
    }

    public void m1557a(boolean z) {
        int childCount = this.mHorizontalListView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mHorizontalListView.getChildAt(i);
            if (childAt instanceof DrawView) {
                DrawView drawView = (DrawView) childAt;
                if (drawView.m1427b() != z) {
                    drawView.setPaused(z);
                }
            }
        }
    }

    public void m1558b(int i) {
        int childCount = this.mHorizontalListView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.mHorizontalListView.getChildAt(i2);
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
            Util.debug("Button clicked");
            m1538a(this.mViewAdapter, view);
        }
    }

    protected void onCreate(Bundle bundle) {
        AndroidConfig androidConfigVar = null;
        super.onCreate(bundle);
        requestWindowFeature(1);
        if (getIntent().hasExtra("DroidConfig")) {
            String stringExtra = getIntent().getStringExtra("DroidConfig");
            try {
                androidConfigVar = new AndroidConfig();
                androidConfigVar.getInstance((Context) this, stringExtra);
            } catch (Exception e) {
                e.printStackTrace();
                androidConfigVar = null;
            } catch (Throwable aThrowable) {
                aThrowable.printStackTrace();
            }
        } else {
            androidConfigVar = null;
        }
        setContentView(R.layout.activity_share);
        this.f918n = AssetDatabase.instance((Context) this);
        if (androidConfigVar == null) {
            this.f919o = this.f918n.m1656a();
        } else {
            this.f919o = androidConfigVar;
        }
        this.f924t = getResources().getColor(R.color.bg_grey);
        this.f920p = findViewById(R.id.header);
        bu.m1894a(this.f920p, getString(R.string.share_your_android), false, false, false, false, true);
        this.f921q = (TextView) findViewById(R.id.tv_header_main);
        this.f916l = (DrawView) findViewById(R.id.draw_view);
        this.f914j = new AndroidDrawer(this);
        this.f914j.setAndroidConfig(this.f919o, AssetDatabase.instance((Context) this));
        this.f916l.setDroidDrawer(this.f914j);
        this.f916l.setShowPoster(false);
        this.mHorizontalListView = (HListView) findViewById(R.id.main_drawer);
        this.f913i = getResources().getColor(R.color.bg_grey);
        this.f912h = -1;
        androidConfigVar = AndroidConfig.m1762a();
        androidConfigVar.m1782b(getResources().getColor(R.color.gray_android));
        androidConfigVar.m1797e(0.75f);
        androidConfigVar.m1800f(1.0f);
        androidConfigVar.m1793d(1.2f);
        androidConfigVar.m1788c(0.9f);
        androidConfigVar.m1774a(0.7f);
        androidConfigVar.m1781b(0.8f);
        androidConfigVar.m1803g(0.8f);
        androidConfigVar.m1806h(2.25f);
        androidConfigVar.m1794d("gray_shoes");
        this.mViewAdapter = new AndroidModelAdapter(this, androidConfigVar, this.f916l);
        this.mViewAdapter.m1925a(true);
        this.mProgressRelativeLayout = (ProgressRelativeLayout) findViewById(R.id.rl_motion_bottom_bar);
        //this.mProgressRelativeLayout.setVisibility(0);
        this.mHorizontalListView.setAdapter(this.mViewAdapter);
        this.mHorizontalListView.setOnItemClickListener(new AndroidModelAdapter(this, androidConfigVar, null));
        this.f922r = findViewById(R.id.btn_motion_share);
        this.mProgressRelativeLayout.setOnClickListener(new ct(this));
        try {
            this.f910f = GoogleAnalyticsTracker.m1177a();
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
        int a = this.mViewAdapter.m1923a();
        int count = this.mViewAdapter.getCount();
        Util.debug("MOTION - Preview clicked - was " + a);
        a = (a + 1) % count;
        Util.debug("MOTION   - Now " + a);
        this.mViewAdapter.m1926b(a);
        m1553a(a);
        if (a == 0) {
            this.mHorizontalListView.setSelection(a);
        } else {
            this.mHorizontalListView.setSelectionInt(a);
        }
        m1554a(this.f912h, this.f913i);
        this.f923s = a;
    }
}
