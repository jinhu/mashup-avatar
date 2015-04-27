package com.google.android.apps.androidify;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.view.View;

import com.google.android.apps.androidify.p018a.AnimationCatalogue;
import com.google.android.apps.p017c.C0254a;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import dev.game.legend.avatar.R;

class cc extends AsyncTask {
    final /* synthetic */ AnimationCatalogue f1480a;
    final /* synthetic */ MotionActivity f1481b;

    cc(MotionActivity motionActivity, AnimationCatalogue aAnimationCatalogue) {
        this.f1481b = motionActivity;
        this.f1480a = aAnimationCatalogue;
    }

    protected File m1914a(Void[] voidArr) {
        try {
            AndroidDrawer androidDrawerVar = new AndroidDrawer(this.f1481b);
            androidDrawerVar.setAndroidConfig(this.f1481b.f889f, this.f1481b.f888e);
            androidDrawerVar.m1835a(400, 400);
            androidDrawerVar.m1848b(0.75f);
            this.f1481b.f895l = System.currentTimeMillis();
            Util.debug("Preparing to encode...");
            File a = this.f1481b.m1506a("gif");
            OutputStream fileOutputStream = new FileOutputStream(a);
            Bitmap createBitmap = Bitmap.createBitmap(400, 400, Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            this.f1481b.m1512b();
            Util.debug("Creating encoder...");
            C0254a c0254a = new C0254a();
            c0254a.m2046a(20.0f);
            c0254a.m2047a(0);
            c0254a.m2052a(fileOutputStream);
            this.f1481b.m1512b();
            Util.debug("Encoding...");
            long j = 0;
            while (((double) j) < this.f1480a.m1609b()) {
                paint.setColor(-1);
                canvas.drawRect(0.0f, 0.0f, 400.0f, 400.0f, paint);
                androidDrawerVar.m1841a(this.f1480a, (double) j);
                androidDrawerVar.m1837a(canvas);
                c0254a.m2051a(createBitmap);
                long j2 = j + 50;
                Float[] fArr = new Float[1];
                fArr[0] = Float.valueOf((float) (((double) j2) / this.f1480a.m1609b()));
                publishProgress(fArr);
                j = j2;
            }
            c0254a.m2054b();
            this.f1481b.m1512b();
            Util.debug("Elapsed mapTime: " + c0254a.m2045a());
            fileOutputStream.close();
            Util.debug("Done.");
            return a;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected void m1915a(File file) {
        View findViewWithTag = this.f1481b.f887d.findViewWithTag(Integer.valueOf(this.f1481b.f893j));
        if (findViewWithTag != null) {
            ((DrawView) findViewWithTag).setProgress(0);
        }
        this.f1481b.m1522a(this.f1481b.f894k);
        this.f1481b.f884a.setVisibility(4);
        this.f1481b.f886c = ControlState.SELECTING;
        this.f1481b.f891h.setText(R.string.share_your_android);
        this.f1481b.m1510a(file);
    }

    protected void m1916a(Float... fArr) {
        super.onProgressUpdate(fArr);
        int floatValue = (int) (100.0f * fArr[0].floatValue());
        View findViewWithTag = this.f1481b.f887d.findViewWithTag(Integer.valueOf(this.f1481b.f893j));
        if (findViewWithTag != null) {
            ((DrawView) findViewWithTag).setProgress(floatValue);
        }
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m1914a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m1915a((File) obj);
    }

    protected void onPreExecute() {
        this.f1481b.f891h.setText(R.string.saving);
        View findViewWithTag = this.f1481b.f887d.findViewWithTag(Integer.valueOf(this.f1481b.f893j));
        if (findViewWithTag != null && (findViewWithTag instanceof DrawView)) {
            ((DrawView) findViewWithTag).setProgressInset(5);
        }
    }

    protected /* synthetic */ void onProgressUpdate(Object[] objArr) {
        m1916a((Float[]) objArr);
    }
}
