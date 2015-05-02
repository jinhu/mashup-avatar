package com.google.android.apps.androidify.wallpaper;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

import com.google.android.apps.androidify.AndroidDrawer;
import com.google.android.apps.androidify.AssetDatabase;
import com.google.android.apps.androidify.AndroidConfig;
import com.google.android.apps.androidify.StructOfFloats;

import java.io.IOException;
import java.util.ArrayList;

/* renamed from: com.google.android.apps.androidify.wallpaper.b */
public class PaperEngine implements OnSharedPreferenceChangeListener {
    GestureDetector f1673a;
    final /* synthetic */ LiveWallpaper mLiveWallpaper;
    private final Handler f1675c;
    private boolean f1676d;
    private AndroidDrawer mCurrentDroid;
    private AndroidDrawer mNextDroid;
    private AssetDatabase mAssetDatabase;
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
    private GestureDetector.OnGestureListener mGeastureListener;
    private final Runnable f1693u;
    private SharedPreferences f1694v;

    PaperEngine(LiveWallpaper aLiveWallpaper) {
        mLiveWallpaper = aLiveWallpaper;
        this.f1675c = new Handler();
        this.f1680h = Float.MIN_VALUE;
        this.f1685m = -1;
        this.f1686n = -1;
        this.f1687o = 0;
        this.f1688p = false;
        this.mGeastureListener = new GestureListener(this);
        this.f1673a = new GestureDetector(this.mGeastureListener);
        this.f1693u = new PaperRunner(this);
        this.f1691s = aLiveWallpaper.getSharedPreferences("AndroidifyWallpaperSettings", 0);
        this.f1691s.registerOnSharedPreferenceChangeListener(this);
    }

    private AndroidConfig m1999a() {
        int nextInt;
        if (!"saved".equals(this.f1691s.getString("wallpaper_source", "saved")) || this.f1694v == null) {
            int length = LiveWallpaper.f1669a.length;
            do {
                nextInt = LiveWallpaper.f1670b.nextInt(length);
            } while (nextInt == this.f1685m);
            this.f1685m = nextInt;
            AndroidConfig androidConfigVar = new AndroidConfig();
            try {
                androidConfigVar.getInstance(this.mLiveWallpaper.getApplicationContext(), LiveWallpaper.f1669a[nextInt]);
                return androidConfigVar;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Throwable aThrowable) {
                aThrowable.printStackTrace();
            }
        } else {
            ArrayList a = this.mAssetDatabase.m1665a(this.f1694v);
            nextInt = a.size();
            if (nextInt > 0) {
                if (nextInt != 1) {
                    int nextInt2;
                    do {
                        nextInt2 = LiveWallpaper.f1670b.nextInt(nextInt);
                    } while (nextInt2 == this.f1685m);
                    this.f1685m = nextInt2;
                    return (AndroidConfig) a.get(nextInt2);
                } else if (this.f1685m != 0) {
                    this.f1685m = 0;
                    return (AndroidConfig) a.get(0);
                } else {
                    this.f1685m = -1;
                    return this.mAssetDatabase.m1668b();
                }
            }
            return this.mAssetDatabase.m1668b();
        }
        return null;
    }

    void m2000a(MotionEvent motionEvent) {
        Log.d("ANDROIDIFY WALLPAPER", "Screen tapped.");
        this.mCurrentDroid.m1846a(false);
    }

    private int m2003b() {
        int nextInt;
        do {
            nextInt = LiveWallpaper.f1670b.nextInt(LiveWallpaper.f1671c.length);
        } while (nextInt == this.f1685m);
        return LiveWallpaper.f1671c[nextInt];
    }

    private StructOfFloats m2004c() {
        int nextInt = LiveWallpaper.f1670b.nextInt(10) + 5;
        if (LiveWallpaper.f1670b.nextBoolean()) {
            nextInt = -nextInt;
        }
        float nextFloat = -1.5f + (LiveWallpaper.f1670b.nextFloat() * 3.0f);
        float nextFloat2 = -1.5f + (LiveWallpaper.f1670b.nextFloat() * 3.0f);
        return new StructOfFloats(2.0f + (LiveWallpaper.f1670b.nextFloat() * 0.25f), nextFloat, nextFloat2, nextInt, LiveWallpaper.f1670b.nextBoolean(), 5.0f, 15000, (int) ((Math.atan2((double) nextFloat2, (double) nextFloat) * 180.0d) / 3.141592653589793d));
    }

    void initAndroid() throws Throwable {
        Throwable th;
        int i = 0;
        long currentTimeMillis = System.currentTimeMillis() - this.f1687o;
        if (LiveWallpaper.f1672d) {
            LiveWallpaper.f1672d = false;
            this.mNextDroid.setAndroidConfig(m1999a(), this.mAssetDatabase);
            this.mNextDroid.setBackgroundColor(m2003b());
            this.mNextDroid.m1845a(m2004c());
            this.mNextDroid.rescale();
            AndroidDrawer androidDrawerVar = this.mCurrentDroid;
            this.mCurrentDroid = this.mNextDroid;
            this.mNextDroid = androidDrawerVar;
        }
        if (currentTimeMillis > 13000) {
            long j = currentTimeMillis - 13000;
            if (j > 1500) {
                AndroidDrawer baVar = this.mCurrentDroid;
                this.mCurrentDroid = this.mNextDroid;
                this.mNextDroid = baVar;
                if (currentTimeMillis - 13000 > 13000) {
                    this.f1687o = currentTimeMillis + this.f1687o;
                    this.mCurrentDroid.m1845a(m2004c());
                    this.mCurrentDroid.rescale();
                } else {
                    this.f1687o += 13000;
                }
                this.f1688p = false;
            } else {
                if (!this.f1688p) {
                    this.mNextDroid.setAndroidConfig(m1999a(), this.mAssetDatabase);
                    this.mNextDroid.setBackgroundColor(m2003b());
                    this.mNextDroid.m1845a(m2004c());
                    this.mNextDroid.rescale();
                    this.f1688p = true;
                }
                i = (int) ((255 * j) / 1500);
            }
        }
        SurfaceHolder surfaceHolder = null;//getSurfaceHolder();
        surfaceHolder.getSurfaceFrame();
        this.mCurrentDroid.stepAnimations();
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
                    this.mCurrentDroid.m1837a(lockCanvas);
                    if (this.f1688p) {
                        lockCanvas.saveLayerAlpha(0.0f, 0.0f, (float) this.f1684l, (float) this.f1684l, i, 31);
                        this.mNextDroid.m1837a(lockCanvas);
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

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
    }

}
