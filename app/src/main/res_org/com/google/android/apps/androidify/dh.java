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

import dev.game.legend.avatar.R;

public class dh {
    public static boolean f1572a;
    private static Random f1573b;
    private Handler f1574A;
    private Runnable f1575B;
    private Context f1576c;
    private SoundPool f1577d;
    private AudioManager f1578e;
    private HashMap f1579f;
    private float f1580g;
    private boolean f1581h;
    private SoundPool f1582i;
    private int f1583j;
    private int f1584k;
    private int f1585l;
    private int f1586m;
    private int f1587n;
    private int f1588o;
    private int f1589p;
    private int f1590q;
    private int f1591r;
    private int f1592s;
    private int f1593t;
    private int f1594u;
    private boolean f1595v;
    private float f1596w;
    private float f1597x;
    private float f1598y;
    private float f1599z;

    static {
        f1572a = false;
        f1573b = new Random();
    }

    public dh(Context context) {
        this.f1579f = new HashMap();
        this.f1580g = 0.0f;
        this.f1581h = false;
        this.f1595v = false;
        this.f1596w = 0.0f;
        this.f1597x = 0.0f;
        this.f1598y = 0.0f;
        this.f1599z = 0.0f;
        this.f1574A = new Handler();
        this.f1575B = new dj(this);
        if (!f1572a) {
            this.f1577d = new SoundPool(2, 3, 0);
            this.f1582i = new SoundPool(2, 3, 0);
            this.f1578e = (AudioManager) context.getSystemService("audio");
            this.f1576c = context;
            AsyncTask diVar = new di(this, context);
            if (VERSION.SDK_INT >= 11) {
                diVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
            } else {
                diVar.execute(new Object[0]);
            }
        }
    }

    private void m1954a(int i) {
        m1955a(i, 1.0f);
    }

    private void m1955a(int i, float f) {
        if (this.f1577d != null) {
            float streamVolume = ((float) this.f1578e.getStreamVolume(3)) / ((float) this.f1578e.getStreamMaxVolume(3));
            this.f1577d.play(i, streamVolume, streamVolume, 1, 0, f);
        }
    }

    public static void m1956a(Context context) {
        m1957a(context, (int) R.raw.ogg_back);
    }

    public static void m1957a(Context context, int i) {
        MediaPlayer.create(context, i).start();
    }

    private void m1958a(Context context, DefaultAccessory aDefaultAccessoryVar) {
        try {
            this.f1579f.put(aDefaultAccessoryVar, new ArrayList());
            AssetManager assets = context.getAssets();
            String str = "sounds/" + aDefaultAccessoryVar.mName;
            for (String str2 : assets.list(str)) {
                ((ArrayList) this.f1579f.get(aDefaultAccessoryVar)).add(Integer.valueOf(this.f1577d.load(assets.openFd(str + "/" + str2), 1)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void m1975a() {
    }

    public void m1976a(float f) {
    }

    public void m1977a(float f, float f2, float f3) {
    }

    public void m1978a(DefaultAccessory aDefaultAccessoryVar) {
        ArrayList arrayList = (ArrayList) this.f1579f.get(aDefaultAccessoryVar);
        if (arrayList != null && arrayList.size() > 1) {
            m1954a(((Integer) arrayList.get(f1573b.nextInt(arrayList.size()))).intValue());
        }
    }

    public void m1979a(DefaultAccessory aDefaultAccessoryVar, int i) {
        ArrayList arrayList = (ArrayList) this.f1579f.get(aDefaultAccessoryVar);
        if (arrayList != null && arrayList.size() > 1) {
            if (i > arrayList.size() - 1) {
                i = arrayList.size() - 1;
            }
            Util.debug("Playing specific sound at index " + i);
            m1954a(((Integer) arrayList.get(i)).intValue());
        }
    }

    public void m1980a(boolean z) {
        if (z) {
            m1954a(this.f1587n);
        } else {
            m1954a(this.f1588o);
        }
    }

    public void m1981a(boolean z, int i) {
        if (z) {
            m1979a(DefaultAccessory.HAIR_COLOR, i);
        } else {
            m1979a(DefaultAccessory.SKIN_COLOR, i);
        }
    }

    public void m1982b() {
        m1978a(DefaultAccessory.UI);
    }

    public void m1983b(DefaultAccessory aDefaultAccessoryVar) {
        m1978a(aDefaultAccessoryVar);
    }

    public void m1984b(boolean z) {
        if (z) {
            m1954a(this.f1589p);
        } else {
            m1954a(this.f1590q);
        }
    }

    public void m1985c() {
        m1978a(DefaultAccessory.REMOVE_ITEM);
    }

    public void m1986c(boolean z) {
        this.f1578e.setStreamMute(3, z);
    }

    public void m1987d() {
        m1954a(this.f1592s);
    }

    public void m1988e() {
        m1954a(this.f1593t);
    }

    public void m1989f() {
        m1978a(DefaultAccessory.UI);
    }

    public void m1990g() {
    }

    public void m1991h() {
        if (this.f1577d != null) {
            this.f1577d.stop(this.f1583j);
        }
    }
}
