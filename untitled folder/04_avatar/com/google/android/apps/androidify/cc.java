package com.google.android.apps.androidify;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.view.View;
import com.google.android.apps.androidify.a.e;
import com.google.android.apps.c.a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

class cc extends AsyncTask {
    final /* synthetic */ e a;
    final /* synthetic */ MotionActivity b;

    cc(MotionActivity motionActivity, e eVar) {
        this.b = motionActivity;
        this.a = eVar;
    }

    protected File a(Void[] voidArr) {
        try {
            ba baVar = new ba(this.b);
            baVar.a(this.b.f, this.b.e);
            baVar.a(400, 400);
            baVar.b(0.75f);
            this.b.l = System.currentTimeMillis();
            c.a("Preparing to encode...");
            File a = this.b.a("gif");
            OutputStream fileOutputStream = new FileOutputStream(a);
            Bitmap createBitmap = Bitmap.createBitmap(400, 400, Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            this.b.b();
            c.a("Creating encoder...");
            a aVar = new a();
            aVar.a(20.0f);
            aVar.a(0);
            aVar.a(fileOutputStream);
            this.b.b();
            c.a("Encoding...");
            long j = 0;
            while (((double) j) < this.a.b()) {
                paint.setColor(-1);
                canvas.drawRect(0.0f, 0.0f, 400.0f, 400.0f, paint);
                baVar.a(this.a, (double) j);
                baVar.a(canvas);
                aVar.a(createBitmap);
                long j2 = j + 50;
                Float[] fArr = new Float[1];
                fArr[0] = Float.valueOf((float) (((double) j2) / this.a.b()));
                publishProgress(fArr);
                j = j2;
            }
            aVar.b();
            this.b.b();
            c.a("Elapsed mapTime: " + aVar.a());
            fileOutputStream.close();
            c.a("Done.");
            return a;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected void a(File file) {
        View findViewWithTag = this.b.d.findViewWithTag(Integer.valueOf(this.b.j));
        if (findViewWithTag != null) {
            ((DrawView) findViewWithTag).setProgress(0);
        }
        this.b.a(this.b.k);
        this.b.a.setVisibility(4);
        this.b.c = cd.SELECTING;
        this.b.h.setText(R.string.share_your_android);
        this.b.a(file);
    }

    protected void a(Float... fArr) {
        super.onProgressUpdate(fArr);
        int floatValue = (int) (100.0f * fArr[0].floatValue());
        View findViewWithTag = this.b.d.findViewWithTag(Integer.valueOf(this.b.j));
        if (findViewWithTag != null) {
            ((DrawView) findViewWithTag).setProgress(floatValue);
        }
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((File) obj);
    }

    protected void onPreExecute() {
        this.b.h.setText(R.string.saving);
        View findViewWithTag = this.b.d.findViewWithTag(Integer.valueOf(this.b.j));
        if (findViewWithTag != null && (findViewWithTag instanceof DrawView)) {
            ((DrawView) findViewWithTag).setProgressInset(5);
        }
    }

    protected /* synthetic */ void onProgressUpdate(Object[] objArr) {
        a((Float[]) objArr);
    }
}
