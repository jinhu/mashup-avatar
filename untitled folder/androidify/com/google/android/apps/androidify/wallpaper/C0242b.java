package com.google.android.apps.androidify.wallpaper;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.graphics.Canvas;
import android.os.Handler;
import android.service.wallpaper.WallpaperService.Engine;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.google.android.apps.androidify.ah;
import com.google.android.apps.androidify.az;
import com.google.android.apps.androidify.ba;
import com.google.android.apps.androidify.dp;
import java.io.IOException;
import java.util.ArrayList;

/* renamed from: com.google.android.apps.androidify.wallpaper.b */
class C0242b extends Engine implements OnSharedPreferenceChangeListener {
    GestureDetector f1673a;
    final /* synthetic */ LiveWallpaper f1674b;
    private final Handler f1675c;
    private boolean f1676d;
    private ba f1677e;
    private ba f1678f;
    private ah f1679g;
    private float f1680h;
    private float f1681i;
    private int f1682j;
    private int f1683k;
    private int f1684l;
    private int f1685m;
    private int f1686n;
    private long f1687o;
    private boolean f1688p;
    private float f1689q;
    private long f1690r;
    private SharedPreferences f1691s;
    private OnGestureListener f1692t;
    private final Runnable f1693u;
    private SharedPreferences f1694v;

    private C0242b(LiveWallpaper liveWallpaper) {
        this.f1674b = liveWallpaper;
        super(liveWallpaper);
        this.f1675c = new Handler();
        this.f1680h = Float.MIN_VALUE;
        this.f1685m = -1;
        this.f1686n = -1;
        this.f1687o = 0;
        this.f1688p = false;
        this.f1692t = new C0243c(this);
        this.f1673a = new GestureDetector(this.f1692t);
        this.f1693u = new C0244d(this);
        this.f1691s = liveWallpaper.getSharedPreferences("AndroidifyWallpaperSettings", 0);
        this.f1691s.registerOnSharedPreferenceChangeListener(this);
    }

    private az m1999a() {
        int nextInt;
        if (!"saved".equals(this.f1691s.getString("wallpaper_source", "saved")) || this.f1694v == null) {
            int length = LiveWallpaper.f1669a.length;
            do {
                nextInt = LiveWallpaper.f1670b.nextInt(length);
            } while (nextInt == this.f1685m);
            this.f1685m = nextInt;
            az azVar = new az();
            try {
                azVar.m1776a(this.f1674b.getApplicationContext(), LiveWallpaper.f1669a[nextInt]);
                return azVar;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            ArrayList a = this.f1679g.m1665a(this.f1694v);
            nextInt = a.size();
            if (nextInt > 0) {
                if (nextInt != 1) {
                    int nextInt2;
                    do {
                        nextInt2 = LiveWallpaper.f1670b.nextInt(nextInt);
                    } while (nextInt2 == this.f1685m);
                    this.f1685m = nextInt2;
                    return (az) a.get(nextInt2);
                } else if (this.f1685m != 0) {
                    this.f1685m = 0;
                    return (az) a.get(0);
                } else {
                    this.f1685m = -1;
                    return this.f1679g.m1668b();
                }
            }
            return this.f1679g.m1668b();
        }
    }

    private void m2000a(MotionEvent motionEvent) {
        Log.d("ANDROIDIFY WALLPAPER", "Screen tapped.");
        this.f1677e.m1846a(false);
    }

    private int m2003b() {
        int nextInt;
        do {
            nextInt = LiveWallpaper.f1670b.nextInt(LiveWallpaper.f1671c.length);
        } while (nextInt == this.f1685m);
        return LiveWallpaper.f1671c[nextInt];
    }

    private dp m2004c() {
        int nextInt = LiveWallpaper.f1670b.nextInt(10) + 5;
        if (LiveWallpaper.f1670b.nextBoolean()) {
            nextInt = -nextInt;
        }
        float nextFloat = -1.5f + (LiveWallpaper.f1670b.nextFloat() * 3.0f);
        float nextFloat2 = -1.5f + (LiveWallpaper.f1670b.nextFloat() * 3.0f);
        return new dp(2.0f + (LiveWallpaper.f1670b.nextFloat() * 0.25f), nextFloat, nextFloat2, nextInt, LiveWallpaper.f1670b.nextBoolean(), 5.0f, 15000, (int) ((Math.atan2((double) nextFloat2, (double) nextFloat) * 180.0d) / 3.141592653589793d));
    }

    private void m2005d() {
        Throwable th;
        int i = 0;
        long currentTimeMillis = System.currentTimeMillis() - this.f1687o;
        if (LiveWallpaper.f1672d) {
            LiveWallpaper.f1672d = false;
            this.f1678f.m1844a(m1999a(), this.f1679g);
            this.f1678f.m1849b(m2003b());
            this.f1678f.m1845a(m2004c());
            this.f1678f.m1853c();
            ba baVar = this.f1677e;
            this.f1677e = this.f1678f;
            this.f1678f = baVar;
        }
        if (currentTimeMillis > 13000) {
            long j = currentTimeMillis - 13000;
            if (j > 1500) {
                baVar = this.f1677e;
                this.f1677e = this.f1678f;
                this.f1678f = baVar;
                if (currentTimeMillis - 13000 > 13000) {
                    this.f1687o = currentTimeMillis + this.f1687o;
                    this.f1677e.m1845a(m2004c());
                    this.f1677e.m1853c();
                } else {
                    this.f1687o += 13000;
                }
                this.f1688p = false;
            } else {
                if (!this.f1688p) {
                    this.f1678f.m1844a(m1999a(), this.f1679g);
                    this.f1678f.m1849b(m2003b());
                    this.f1678f.m1845a(m2004c());
                    this.f1678f.m1853c();
                    this.f1688p = true;
                }
                i = (int) ((255 * j) / 1500);
            }
        }
        SurfaceHolder surfaceHolder = getSurfaceHolder();
        surfaceHolder.getSurfaceFrame();
        this.f1677e.m1856e();
        if (this.f1680h != this.f1689q) {
            currentTimeMillis = System.currentTimeMillis() - this.f1690r;
            if (currentTimeMillis > 100) {
                this.f1680h = this.f1689q;
            } else {
                this.f1680h = ((((float) currentTimeMillis) * (this.f1689q - this.f1680h)) / 100.0f) + this.f1680h;
            }
        }
        Canvas canvas = null;
        try {
            Canvas lockCanvas = surfaceHolder.lockCanvas();
            if (lockCanvas != null) {
                try {
                    lockCanvas.save();
                    lockCanvas.translate(this.f1680h, this.f1681i);
                    this.f1677e.m1837a(lockCanvas);
                    if (this.f1688p) {
                        lockCanvas.saveLayerAlpha(0.0f, 0.0f, (float) this.f1684l, (float) this.f1684l, i, 31);
                        this.f1678f.m1837a(lockCanvas);
                        lockCanvas.restore();
                    }
                    lockCanvas.restore();
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    canvas = lockCanvas;
                    th = th3;
                    if (canvas != null) {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }
                    throw th;
                }
            }
            if (lockCanvas != null) {
                surfaceHolder.unlockCanvasAndPost(lockCanvas);
            }
            m2006e();
        } catch (Throwable th4) {
            th = th4;
            if (canvas != null) {
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
            throw th;
        }
    }

    private void m2006e() {
        this.f1675c.removeCallbacks(this.f1693u);
        if (this.f1676d) {
            this.f1675c.postDelayed(this.f1693u, 25);
        }
    }

    public void onCreate(SurfaceHolder surfaceHolder) {
        super.onCreate(surfaceHolder);
        setTouchEventsEnabled(true);
        this.f1679g = new ah(this.f1674b, this.f1674b.getAssets(), this.f1674b.getResources());
        LiveWallpaper.m1998f().m1784b("001redplaid");
        this.f1694v = this.f1674b.getSharedPreferences("com.google.android.apps.androidify.Androidify", 0);
        this.f1677e = new ba(this.f1674b.getApplicationContext());
        this.f1678f = new ba(this.f1674b.getApplicationContext());
        this.f1677e.m1844a(m1999a(), this.f1679g);
        this.f1677e.m1849b(m2003b());
        this.f1677e.m1845a(new dp(2.0f, -0.8f, 2.0f, -10, true, 5.0f, 15000, 45));
        this.f1687o = System.currentTimeMillis();
    }

    public void onDestroy() {
        super.onDestroy();
        this.f1675c.removeCallbacks(this.f1693u);
    }

    public void onOffsetsChanged(float f, float f2, float f3, float f4, int i, int i2) {
        this.f1681i = 0.0f;
        this.f1689q = ((float) (this.f1682j - this.f1684l)) * f;
        if (this.f1680h == Float.MIN_VALUE) {
            this.f1680h = this.f1689q;
        }
        this.f1690r = System.currentTimeMillis();
        Log.d("!", "xOffset: " + f + ", yOffset: " + f2);
        Log.d("!", "xStep: " + f3 + ", yStep: " + f4);
        Log.d("!", "xPixels: " + i + ", yPixels: " + i2);
        m2006e();
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
    }

    public void onSurfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        super.onSurfaceChanged(surfaceHolder, i, i2, i3);
        this.f1684l = (Math.max(i2, i3) * 150) / 100;
        this.f1682j = i2;
        this.f1683k = i3;
        this.f1677e.m1833a((float) i2);
        this.f1678f.m1833a((float) i2);
        this.f1677e.m1835a(this.f1684l, i3);
        this.f1678f.m1835a(this.f1684l, i3);
        m2006e();
    }

    public void onSurfaceCreated(SurfaceHolder surfaceHolder) {
        super.onSurfaceCreated(surfaceHolder);
    }

    public void onSurfaceDestroyed(SurfaceHolder surfaceHolder) {
        super.onSurfaceDestroyed(surfaceHolder);
        this.f1676d = false;
        this.f1675c.removeCallbacks(this.f1693u);
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        this.f1673a.onTouchEvent(motionEvent);
    }

    public void onVisibilityChanged(boolean z) {
        this.f1676d = z;
        if (z) {
            m2006e();
        } else {
            this.f1675c.removeCallbacks(this.f1693u);
        }
    }
}
