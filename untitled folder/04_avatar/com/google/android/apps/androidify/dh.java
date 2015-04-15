package com.google.android.apps.androidify;

import android.content.Context;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Handler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class dh {
    public static boolean a;
    private static Random b;
    private Handler A;
    private Runnable B;
    private Context c;
    private SoundPool d;
    private AudioManager e;
    private HashMap f;
    private float g;
    private boolean h;
    private SoundPool i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private boolean v;
    private float w;
    private float x;
    private float y;
    private float z;

    static {
        a = false;
        b = new Random();
    }

    public dh(Context context) {
        this.f = new HashMap();
        this.g = 0.0f;
        this.h = false;
        this.v = false;
        this.w = 0.0f;
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
        this.A = new Handler();
        this.B = new dj(this);
        if (!a) {
            this.d = new SoundPool(2, 3, 0);
            this.i = new SoundPool(2, 3, 0);
            this.e = (AudioManager) context.getSystemService("audio");
            this.c = context;
            AsyncTask diVar = new di(this, context);
            if (VERSION.SDK_INT >= 11) {
                diVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
            } else {
                diVar.execute(new Object[0]);
            }
        }
    }

    private void a(int i) {
        a(i, 1.0f);
    }

    private void a(int i, float f) {
        if (this.d != null) {
            float streamVolume = ((float) this.e.getStreamVolume(3)) / ((float) this.e.getStreamMaxVolume(3));
            this.d.play(i, streamVolume, streamVolume, 1, 0, f);
        }
    }

    public static void a(Context context) {
        a(context, (int) R.raw.ogg_back);
    }

    public static void a(Context context, int i) {
        MediaPlayer.create(context, i).start();
    }

    private void a(Context context, dk dkVar) {
        try {
            this.f.put(dkVar, new ArrayList());
            AssetManager assets = context.getAssets();
            String str = "sounds/" + dkVar.i;
            for (String str2 : assets.list(str)) {
                ((ArrayList) this.f.get(dkVar)).add(Integer.valueOf(this.d.load(assets.openFd(str + "/" + str2), 1)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void a() {
    }

    public void a(float f) {
    }

    public void a(float f, float f2, float f3) {
    }

    public void a(dk dkVar) {
        ArrayList arrayList = (ArrayList) this.f.get(dkVar);
        if (arrayList != null && arrayList.size() > 1) {
            a(((Integer) arrayList.get(b.nextInt(arrayList.size()))).intValue());
        }
    }

    public void a(dk dkVar, int i) {
        ArrayList arrayList = (ArrayList) this.f.get(dkVar);
        if (arrayList != null && arrayList.size() > 1) {
            if (i > arrayList.size() - 1) {
                i = arrayList.size() - 1;
            }
            c.a("Playing specific sound at index " + i);
            a(((Integer) arrayList.get(i)).intValue());
        }
    }

    public void a(boolean z) {
        if (z) {
            a(this.n);
        } else {
            a(this.o);
        }
    }

    public void a(boolean z, int i) {
        if (z) {
            a(dk.HAIR_COLOR, i);
        } else {
            a(dk.SKIN_COLOR, i);
        }
    }

    public void b() {
        a(dk.UI);
    }

    public void b(dk dkVar) {
        a(dkVar);
    }

    public void b(boolean z) {
        if (z) {
            a(this.p);
        } else {
            a(this.q);
        }
    }

    public void c() {
        a(dk.REMOVE_ITEM);
    }

    public void c(boolean z) {
        this.e.setStreamMute(3, z);
    }

    public void d() {
        a(this.s);
    }

    public void e() {
        a(this.t);
    }

    public void f() {
        a(dk.UI);
    }

    public void g() {
    }

    public void h() {
        if (this.d != null) {
            this.d.stop(this.j);
        }
    }
}
