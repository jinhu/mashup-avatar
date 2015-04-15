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

class b extends Engine implements OnSharedPreferenceChangeListener {
    GestureDetector a;
    final /* synthetic */ LiveWallpaper b;
    private final Handler c;
    private boolean d;
    private ba e;
    private ba f;
    private ah g;
    private float h;
    private float i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private long o;
    private boolean p;
    private float q;
    private long r;
    private SharedPreferences s;
    private OnGestureListener t;
    private final Runnable u;
    private SharedPreferences v;

    private b(LiveWallpaper liveWallpaper) {
        this.b = liveWallpaper;
        super(liveWallpaper);
        this.c = new Handler();
        this.h = Float.MIN_VALUE;
        this.m = -1;
        this.n = -1;
        this.o = 0;
        this.p = false;
        this.t = new c(this);
        this.a = new GestureDetector(this.t);
        this.u = new d(this);
        this.s = liveWallpaper.getSharedPreferences("AndroidifyWallpaperSettings", 0);
        this.s.registerOnSharedPreferenceChangeListener(this);
    }

    private az a() {
        int nextInt;
        if (!"saved".equals(this.s.getString("wallpaper_source", "saved")) || this.v == null) {
            int length = LiveWallpaper.a.length;
            do {
                nextInt = LiveWallpaper.b.nextInt(length);
            } while (nextInt == this.m);
            this.m = nextInt;
            az azVar = new az();
            try {
                azVar.a(this.b.getApplicationContext(), LiveWallpaper.a[nextInt]);
                return azVar;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            ArrayList a = this.g.a(this.v);
            nextInt = a.size();
            if (nextInt > 0) {
                if (nextInt != 1) {
                    int nextInt2;
                    do {
                        nextInt2 = LiveWallpaper.b.nextInt(nextInt);
                    } while (nextInt2 == this.m);
                    this.m = nextInt2;
                    return (az) a.get(nextInt2);
                } else if (this.m != 0) {
                    this.m = 0;
                    return (az) a.get(0);
                } else {
                    this.m = -1;
                    return this.g.b();
                }
            }
            return this.g.b();
        }
    }

    private void a(MotionEvent motionEvent) {
        Log.d("ANDROIDIFY WALLPAPER", "Screen tapped.");
        this.e.a(false);
    }

    private int b() {
        int nextInt;
        do {
            nextInt = LiveWallpaper.b.nextInt(LiveWallpaper.c.length);
        } while (nextInt == this.m);
        return LiveWallpaper.c[nextInt];
    }

    private dp c() {
        int nextInt = LiveWallpaper.b.nextInt(10) + 5;
        if (LiveWallpaper.b.nextBoolean()) {
            nextInt = -nextInt;
        }
        float nextFloat = -1.5f + (LiveWallpaper.b.nextFloat() * 3.0f);
        float nextFloat2 = -1.5f + (LiveWallpaper.b.nextFloat() * 3.0f);
        return new dp(2.0f + (LiveWallpaper.b.nextFloat() * 0.25f), nextFloat, nextFloat2, nextInt, LiveWallpaper.b.nextBoolean(), 5.0f, 15000, (int) ((Math.atan2((double) nextFloat2, (double) nextFloat) * 180.0d) / 3.141592653589793d));
    }

    private void d() {
        Throwable th;
        int i = 0;
        long currentTimeMillis = System.currentTimeMillis() - this.o;
        if (LiveWallpaper.d) {
            LiveWallpaper.d = false;
            this.f.a(a(), this.g);
            this.f.b(b());
            this.f.a(c());
            this.f.c();
            ba baVar = this.e;
            this.e = this.f;
            this.f = baVar;
        }
        if (currentTimeMillis > 13000) {
            long j = currentTimeMillis - 13000;
            if (j > 1500) {
                baVar = this.e;
                this.e = this.f;
                this.f = baVar;
                if (currentTimeMillis - 13000 > 13000) {
                    this.o = currentTimeMillis + this.o;
                    this.e.a(c());
                    this.e.c();
                } else {
                    this.o += 13000;
                }
                this.p = false;
            } else {
                if (!this.p) {
                    this.f.a(a(), this.g);
                    this.f.b(b());
                    this.f.a(c());
                    this.f.c();
                    this.p = true;
                }
                i = (int) ((255 * j) / 1500);
            }
        }
        SurfaceHolder surfaceHolder = getSurfaceHolder();
        surfaceHolder.getSurfaceFrame();
        this.e.e();
        if (this.h != this.q) {
            currentTimeMillis = System.currentTimeMillis() - this.r;
            if (currentTimeMillis > 100) {
                this.h = this.q;
            } else {
                this.h = ((((float) currentTimeMillis) * (this.q - this.h)) / 100.0f) + this.h;
            }
        }
        Canvas canvas = null;
        try {
            Canvas lockCanvas = surfaceHolder.lockCanvas();
            if (lockCanvas != null) {
                try {
                    lockCanvas.save();
                    lockCanvas.translate(this.h, this.i);
                    this.e.a(lockCanvas);
                    if (this.p) {
                        lockCanvas.saveLayerAlpha(0.0f, 0.0f, (float) this.l, (float) this.l, i, 31);
                        this.f.a(lockCanvas);
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
            e();
        } catch (Throwable th4) {
            th = th4;
            if (canvas != null) {
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
            throw th;
        }
    }

    private void e() {
        this.c.removeCallbacks(this.u);
        if (this.d) {
            this.c.postDelayed(this.u, 25);
        }
    }

    public void onCreate(SurfaceHolder surfaceHolder) {
        super.onCreate(surfaceHolder);
        setTouchEventsEnabled(true);
        this.g = new ah(this.b, this.b.getAssets(), this.b.getResources());
        LiveWallpaper.f().b("001redplaid");
        this.v = this.b.getSharedPreferences("com.google.android.apps.androidify.Androidify", 0);
        this.e = new ba(this.b.getApplicationContext());
        this.f = new ba(this.b.getApplicationContext());
        this.e.a(a(), this.g);
        this.e.b(b());
        this.e.a(new dp(2.0f, -0.8f, 2.0f, -10, true, 5.0f, 15000, 45));
        this.o = System.currentTimeMillis();
    }

    public void onDestroy() {
        super.onDestroy();
        this.c.removeCallbacks(this.u);
    }

    public void onOffsetsChanged(float f, float f2, float f3, float f4, int i, int i2) {
        this.i = 0.0f;
        this.q = ((float) (this.j - this.l)) * f;
        if (this.h == Float.MIN_VALUE) {
            this.h = this.q;
        }
        this.r = System.currentTimeMillis();
        Log.d("!", "xOffset: " + f + ", yOffset: " + f2);
        Log.d("!", "xStep: " + f3 + ", yStep: " + f4);
        Log.d("!", "xPixels: " + i + ", yPixels: " + i2);
        e();
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
    }

    public void onSurfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        super.onSurfaceChanged(surfaceHolder, i, i2, i3);
        this.l = (Math.max(i2, i3) * 150) / 100;
        this.j = i2;
        this.k = i3;
        this.e.a((float) i2);
        this.f.a((float) i2);
        this.e.a(this.l, i3);
        this.f.a(this.l, i3);
        e();
    }

    public void onSurfaceCreated(SurfaceHolder surfaceHolder) {
        super.onSurfaceCreated(surfaceHolder);
    }

    public void onSurfaceDestroyed(SurfaceHolder surfaceHolder) {
        super.onSurfaceDestroyed(surfaceHolder);
        this.d = false;
        this.c.removeCallbacks(this.u);
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        this.a.onTouchEvent(motionEvent);
    }

    public void onVisibilityChanged(boolean z) {
        this.d = z;
        if (z) {
            e();
        } else {
            this.c.removeCallbacks(this.u);
        }
    }
}
