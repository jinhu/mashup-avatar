package com.google.android.apps.androidify;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import com.google.android.apps.androidify.p018a.C0208e;
import it.sephiroth.android.library.widget.C0284i;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ce extends BaseAdapter {
    private static final int[] f1485d;
    boolean f1486a;
    private final ThreadPoolExecutor f1487b;
    private int f1488c;
    private final int f1489e;
    private Context f1490f;
    private C0208e[] f1491g;
    private boolean[] f1492h;
    private ba f1493i;
    private DrawView f1494j;
    private long f1495k;

    static {
        f1485d = new int[]{-1, R.raw.anim_danceclassic, R.raw.anim_blowkiss, R.raw.anim_crying, R.raw.anim_giggling, R.raw.anim_lol, R.raw.anim_airguitar, R.raw.anim_butt, R.raw.anim_happy, R.raw.anim_basketball_dribble, R.raw.anim_basketball_crossover, R.raw.anim_basketball_shoot, R.raw.anim_yes, R.raw.anim_no, R.raw.anim_noway, R.raw.anim_headbanging, R.raw.anim_ropepulldancing, R.raw.anim_monicasdance, R.raw.anim_spinpose, R.raw.anim_facepalm, R.raw.anim_steaming, R.raw.anim_shocked, R.raw.anim_scared, R.raw.anim_sweaty, R.raw.anim_sneaky, R.raw.anim_sleeping, R.raw.anim_exhausted, R.raw.anim_eating, R.raw.anim_inlovefloat, R.raw.anim_inlove, R.raw.anim_farewell, R.raw.anim_impatient, R.raw.anim_childishpout, R.raw.anim_highfive, R.raw.anim_bodywave, R.raw.anim_cheering, R.raw.anim_flying, R.raw.anim_outta_here};
    }

    public ce(Context context, az azVar, DrawView drawView) {
        this.f1488c = -1;
        this.f1495k = 0;
        this.f1486a = false;
        this.f1495k = System.currentTimeMillis();
        this.f1494j = drawView;
        C0220c.m1912a("Init MotionAdapater");
        this.f1490f = context;
        this.f1489e = context.getResources().getColor(R.color.bg_grey);
        ah a = ah.m1648a(context);
        this.f1493i = new ba(context);
        this.f1493i.m1844a(azVar, a);
        this.f1493i.m1848b(0.75f);
        this.f1493i.m1834a(0);
        this.f1493i.m1849b(0);
        int length = f1485d.length;
        this.f1491g = new C0208e[length];
        this.f1492h = new boolean[length];
        m1921c();
        this.f1487b = new ThreadPoolExecutor(2, 2, 200, TimeUnit.SECONDS, new cg(this));
    }

    private void m1921c() {
        long currentTimeMillis = System.currentTimeMillis();
        C0220c.m1912a("Elapsed: " + (currentTimeMillis - this.f1495k));
        this.f1495k = currentTimeMillis;
    }

    public int m1923a() {
        return this.f1488c;
    }

    public int m1924a(int i) {
        return f1485d[i];
    }

    public void m1925a(boolean z) {
        this.f1486a = z;
        this.f1488c = 0;
    }

    public void m1926b(int i) {
        this.f1488c = i;
    }

    public int getCount() {
        return this.f1491g.length;
    }

    public Object getItem(int i) {
        return this.f1491g[i];
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view != null) {
            view = (DrawView) view;
        } else {
            view = new DrawView(this.f1490f);
            view.setDroidDrawer(this.f1493i);
            if (this.f1486a) {
                view.setShowPoster(false);
                view.setLayoutParams(new C0284i((int) C0220c.m1902a(this.f1490f, 100.0f), -1));
            } else {
                view.setLayoutParams(new LayoutParams(-1, (int) C0220c.m1902a(this.f1490f, 225.0f)));
            }
        }
        if (i == this.f1488c) {
            view.setBackgroundColor(this.f1489e);
        } else {
            view.setBackgroundColor(-1);
        }
        view.setIndex(i);
        view.setTag(Integer.valueOf(i));
        if (this.f1491g[i] == null) {
            view.setMotion(null);
            if (f1485d[i] != -1) {
                new cf(this, i, view).executeOnExecutor(this.f1487b, new Void[0]);
            }
        } else {
            view.setMotion(this.f1491g[i]);
            if (!this.f1486a) {
                view.setShowPoster(true);
            }
        }
        if (!this.f1486a) {
            view.m1426a();
        }
        if (i == 0) {
            view.setContentDescription("Static image");
        } else {
            view.setContentDescription("Animation " + i);
        }
        m1921c();
        return view;
    }
}
