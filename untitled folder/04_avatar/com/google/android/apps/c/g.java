package com.google.android.apps.c;

import android.graphics.Picture;
import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.a;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class g {
    private boolean a;
    private boolean b;
    private ArrayList c;
    private View d;
    private m e;
    private float[] f;
    private MotionEvent g;
    private Picture h;
    private Picture i;
    private ArrayList j;
    private boolean k;
    private l l;
    private long m;
    private long n;
    private boolean o;

    public g(View view, m mVar, Picture picture, Picture picture2, long j) {
        this.a = false;
        this.b = false;
        this.c = new ArrayList();
        this.f = new float[]{-1.0f, -1.0f};
        this.g = null;
        this.j = new ArrayList();
        this.m = 0;
        this.o = false;
        this.d = view;
        this.e = mVar;
        this.h = picture;
        this.i = picture2;
        this.n = j;
    }

    private MotionEvent a(String str, long j) {
        String[] split = str.split(",");
        int width = (int) (((float) this.d.getWidth()) * Float.parseFloat(split[1]));
        int height = (int) (((float) this.d.getHeight()) * Float.parseFloat(split[2]));
        MotionEvent obtain = MotionEvent.obtain(Long.parseLong(split[3]) + j, Long.parseLong(split[4]) + j, Integer.parseInt(split[0]), (float) width, (float) height, 0);
        a.c("Obtained MotionEvent: " + obtain.toString());
        return obtain;
    }

    private void a(long j) {
        this.d.postDelayed(new k(this), 500 + j);
    }

    public void a(MotionEvent motionEvent) {
        if (this.a) {
            this.c.add(MotionEvent.obtain(motionEvent));
        }
    }

    public void a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            long j = -1;
            String readLine = bufferedReader.readLine();
            long j2 = this.n;
            long j3 = -1;
            if (readLine != null) {
                MotionEvent a = a(readLine, 0);
                j = (uptimeMillis + j2) - a.getEventTime();
                j3 = a.getEventTime();
                a.c("Time correction for motion events replay is " + j);
            }
            this.d.post(new h(this));
            this.j.clear();
            long j4 = j2;
            String str = readLine;
            long j5 = j3;
            MotionEvent motionEvent = null;
            Object obj = 1;
            while (str != null) {
                MotionEvent a2 = a(str, j);
                if (a2.getAction() == 0 && motionEvent != null) {
                    a.c("Found down action, creating motion action between pointer positions.");
                    if (motionEvent.getAction() != 1) {
                        throw new RuntimeException("Start event for interpolation not an up event");
                    }
                    l lVar = new l(MotionEvent.obtain(a2), null);
                    this.j.add(lVar);
                    this.d.postDelayed(new i(this, lVar), j4);
                }
                if (obj == null) {
                    j4 += a2.getEventTime() - j5;
                }
                a.c("  Playing event: " + a2.toString() + " with delay " + j4);
                this.d.postDelayed(new j(this, a2), j4);
                j5 = a2.getEventTime();
                obj = null;
                MotionEvent motionEvent2 = a2;
                str = bufferedReader.readLine();
                motionEvent = motionEvent2;
            }
            a(j4);
        } catch (Throwable e) {
            Log.e("Androidify", e.getMessage(), e);
        }
    }

    public boolean a() {
        return this.a;
    }

    public void b() {
        this.o = true;
    }

    public boolean c() {
        return this.o;
    }
}
