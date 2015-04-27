package com.google.android.apps.p017c;

import android.graphics.Picture;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.Util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* renamed from: com.google.android.apps.c.g */
public class C0260g {
    private boolean f1803a;
    private boolean f1804b;
    private ArrayList f1805c;
    private View f1806d;
    private Interactable f1807e;
    private float[] f1808f;
    private MotionEvent f1809g;
    private Picture f1810h;
    private Picture f1811i;
    private ArrayList f1812j;
    private boolean f1813k;
    private C0265l f1814l;
    private long f1815m;
    private long f1816n;
    private boolean f1817o;

    public C0260g(View view, Interactable c0203m, Picture picture, Picture picture2, long j) {
        this.f1803a = false;
        this.f1804b = false;
        this.f1805c = new ArrayList();
        this.f1808f = new float[]{-1.0f, -1.0f};
        this.f1809g = null;
        this.f1812j = new ArrayList();
        this.f1815m = 0;
        this.f1817o = false;
        this.f1806d = view;
        this.f1807e = c0203m;
        this.f1810h = picture;
        this.f1811i = picture2;
        this.f1816n = j;
    }

    private MotionEvent m2099a(String str, long j) {
        String[] split = str.split(",");
        int width = (int) (((float) this.f1806d.getWidth()) * Float.parseFloat(split[1]));
        int height = (int) (((float) this.f1806d.getHeight()) * Float.parseFloat(split[2]));
        MotionEvent obtain = MotionEvent.obtain(Long.parseLong(split[3]) + j, Long.parseLong(split[4]) + j, Integer.parseInt(split[0]), (float) width, (float) height, 0);
        Util.debug("Obtained MotionEvent: " + obtain.toString());
        return obtain;
    }

    private void m2102a(long j) {
        this.f1806d.postDelayed(new C0264k(this), 500 + j);
    }

    public void m2107a(MotionEvent motionEvent) {
        if (this.f1803a) {
            this.f1805c.add(MotionEvent.obtain(motionEvent));
        }
    }

    public void m2108a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            long j = -1;
            String readLine = bufferedReader.readLine();
            long j2 = this.f1816n;
            long j3 = -1;
            if (readLine != null) {
                MotionEvent a = m2099a(readLine, 0);
                j = (uptimeMillis + j2) - a.getEventTime();
                j3 = a.getEventTime();
                Util.debug("Time correction for motion events replay is " + j);
            }
            this.f1806d.post(new C0261h(this));
            this.f1812j.clear();
            long j4 = j2;
            String str = readLine;
            long j5 = j3;
            MotionEvent motionEvent = null;
            Object obj = 1;
            while (str != null) {
                MotionEvent a2 = m2099a(str, j);
                if (a2.getAction() == 0 && motionEvent != null) {
                    Util.debug("Found down action, creating motion action between pointer positions.");
                    if (motionEvent.getAction() != 1) {
                        throw new RuntimeException("Start event for interpolation not an up event");
                    }
                    C0265l c0265l = new C0265l(MotionEvent.obtain(a2), null);
                    this.f1812j.add(c0265l);
                    this.f1806d.postDelayed(new C0262i(this, c0265l), j4);
                }
                if (obj == null) {
                    j4 += a2.getEventTime() - j5;
                }
                Util.debug("  Playing event: " + a2.toString() + " with delay " + j4);
                this.f1806d.postDelayed(new C0263j(this, a2), j4);
                j5 = a2.getEventTime();
                obj = null;
                MotionEvent motionEvent2 = a2;
                str = bufferedReader.readLine();
                motionEvent = motionEvent2;
            }
            m2102a(j4);
        } catch (Throwable e) {
            android.util.Log.e("Androidify", e.getMessage(), e);
        }
    }

    public boolean m2109a() {
        return this.f1803a;
    }

    public void m2110b() {
        this.f1817o = true;
    }

    public boolean m2111c() {
        return this.f1817o;
    }
}
