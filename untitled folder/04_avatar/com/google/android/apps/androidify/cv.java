package com.google.android.apps.androidify;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.AsyncTask;
import com.google.android.apps.androidify.a.e;
import com.google.android.apps.c.a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

class cv extends AsyncTask {
    final /* synthetic */ e a;
    final /* synthetic */ ShareActivity b;

    cv(ShareActivity shareActivity, e eVar) {
        this.b = shareActivity;
        this.a = eVar;
    }

    protected File a(Void[] voidArr) {
        try {
            ba baVar = new ba(this.b);
            baVar.a(this.b.o, this.b.n);
            float c = this.b.c(this.b.e.a(this.b.s));
            int i = (int) (800.0f * c);
            int i2 = (int) (c * 800.0f);
            baVar.a(i, i2);
            this.b.v = System.currentTimeMillis();
            c.a("Preparing to encode...");
            File a = this.b.a("gif");
            OutputStream fileOutputStream = new FileOutputStream(a);
            Bitmap createBitmap = Bitmap.createBitmap(800, 800, Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            Bitmap createBitmap2 = Bitmap.createBitmap(400, 400, Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap2);
            this.b.b();
            c.a("Creating encoder...");
            a aVar = new a();
            aVar.a(20.0f);
            aVar.a(0);
            aVar.a(fileOutputStream);
            this.b.b();
            c.a("Encoding...");
            long j = 0;
            while (((double) j) < this.a.b() && !isCancelled()) {
                paint.setColor(-1);
                canvas.drawRect(0.0f, 0.0f, 800.0f, 800.0f, paint);
                baVar.a(this.a, (double) j);
                canvas.save();
                canvas.translate(((float) (800 - i)) / 2.0f, (float) (800 - i2));
                baVar.a(canvas);
                canvas.restore();
                canvas2.drawBitmap(createBitmap, null, new Rect(0, 0, 400, 400), this.b.u);
                aVar.a(createBitmap2);
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
        this.b.d.setProgress(0);
        this.b.d.setEnabled(true);
        this.b.m.setEnabled(true);
        this.b.b(this.b.t);
        this.b.k = cw.SELECTING;
        this.b.q.setText(R.string.share_your_android);
        if (!isCancelled()) {
            this.b.a(file, "image/gif");
            dh.a(this.b, (int) R.raw.ogg_share_complete);
        }
    }

    protected void a(Float... fArr) {
        super.onProgressUpdate(fArr);
        this.b.d.setProgress((int) (100.0f * fArr[0].floatValue()));
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((File) obj);
    }

    protected void onPreExecute() {
        this.b.q.setText(R.string.saving);
    }

    protected /* synthetic */ void onProgressUpdate(Object[] objArr) {
        a((Float[]) objArr);
    }
}
