package com.google.android.apps.androidify;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import com.google.android.apps.androidify.a.e;
import it.sephiroth.android.library.widget.i;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ce extends BaseAdapter {
    private static final int[] d;
    boolean a;
    private final ThreadPoolExecutor b;
    private int c;
    private final int e;
    private Context f;
    private e[] g;
    private boolean[] h;
    private ba i;
    private DrawView j;
    private long k;

    static {
        d = new int[]{-1, R.raw.anim_danceclassic, R.raw.anim_blowkiss, R.raw.anim_crying, R.raw.anim_giggling, R.raw.anim_lol, R.raw.anim_airguitar, R.raw.anim_butt, R.raw.anim_happy, R.raw.anim_basketball_dribble, R.raw.anim_basketball_crossover, R.raw.anim_basketball_shoot, R.raw.anim_yes, R.raw.anim_no, R.raw.anim_noway, R.raw.anim_headbanging, R.raw.anim_ropepulldancing, R.raw.anim_monicasdance, R.raw.anim_spinpose, R.raw.anim_facepalm, R.raw.anim_steaming, R.raw.anim_shocked, R.raw.anim_scared, R.raw.anim_sweaty, R.raw.anim_sneaky, R.raw.anim_sleeping, R.raw.anim_exhausted, R.raw.anim_eating, R.raw.anim_inlovefloat, R.raw.anim_inlove, R.raw.anim_farewell, R.raw.anim_impatient, R.raw.anim_childishpout, R.raw.anim_highfive, R.raw.anim_bodywave, R.raw.anim_cheering, R.raw.anim_flying, R.raw.anim_outta_here};
    }

    public ce(Context context, az azVar, DrawView drawView) {
        this.c = -1;
        this.k = 0;
        this.a = false;
        this.k = System.currentTimeMillis();
        this.j = drawView;
        c.a("Init MotionAdapater");
        this.f = context;
        this.e = context.getResources().getColor(R.color.bg_grey);
        ah a = ah.a(context);
        this.i = new ba(context);
        this.i.a(azVar, a);
        this.i.b(0.75f);
        this.i.a(0);
        this.i.b(0);
        int length = d.length;
        this.g = new e[length];
        this.h = new boolean[length];
        c();
        this.b = new ThreadPoolExecutor(2, 2, 200, TimeUnit.SECONDS, new cg(this));
    }

    private void c() {
        long currentTimeMillis = System.currentTimeMillis();
        c.a("Elapsed: " + (currentTimeMillis - this.k));
        this.k = currentTimeMillis;
    }

    public int a() {
        return this.c;
    }

    public int a(int i) {
        return d[i];
    }

    public void a(boolean z) {
        this.a = z;
        this.c = 0;
    }

    public void b(int i) {
        this.c = i;
    }

    public int getCount() {
        return this.g.length;
    }

    public Object getItem(int i) {
        return this.g[i];
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view != null) {
            view = (DrawView) view;
        } else {
            view = new DrawView(this.f);
            view.setDroidDrawer(this.i);
            if (this.a) {
                view.setShowPoster(false);
                view.setLayoutParams(new i((int) c.a(this.f, 100.0f), -1));
            } else {
                view.setLayoutParams(new LayoutParams(-1, (int) c.a(this.f, 225.0f)));
            }
        }
        if (i == this.c) {
            view.setBackgroundColor(this.e);
        } else {
            view.setBackgroundColor(-1);
        }
        view.setIndex(i);
        view.setTag(Integer.valueOf(i));
        if (this.g[i] == null) {
            view.setMotion(null);
            if (d[i] != -1) {
                new cf(this, i, view).executeOnExecutor(this.b, new Void[0]);
            }
        } else {
            view.setMotion(this.g[i]);
            if (!this.a) {
                view.setShowPoster(true);
            }
        }
        if (!this.a) {
            view.a();
        }
        if (i == 0) {
            view.setContentDescription("Static image");
        } else {
            view.setContentDescription("Animation " + i);
        }
        c();
        return view;
    }
}
