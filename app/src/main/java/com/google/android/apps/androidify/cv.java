package com.google.android.apps.androidify;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.AsyncTask;

import com.google.android.apps.androidify.p018a.AnimationCatalogue;
import com.google.android.apps.p017c.C0254a;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import dev.game.legend.avatar.R;

class cv extends AsyncTask {
    final /* synthetic */ AnimationCatalogue f1544a;
    final /* synthetic */ ShareActivity f1545b;

    cv(ShareActivity shareActivity, AnimationCatalogue aAnimationCatalogue) {
        this.f1545b = shareActivity;
        this.f1544a = aAnimationCatalogue;
    }

    protected File m1940a(Void[] voidArr) {
        try {
            AndroidDrawer androidDrawerVar = new AndroidDrawer(this.f1545b);
            //androidDrawerVar.setAndroidConfig(this.f1545b.f919o, this.f1545b.f918n);
            float c = 0;//this.f1545b.m1559c(this.f1545b.f909e.m1924a(this.f1545b.f923s));
            int i = (int) (800.0f * c);
            int i2 = (int) (c * 800.0f);
            androidDrawerVar.m1835a(i, i2);
            this.f1545b.f926v = System.currentTimeMillis();
            Util.debug("Preparing to encode...");
            File a = this.f1545b.m1534a("gif");
            OutputStream fileOutputStream = new FileOutputStream(a);
            Bitmap createBitmap = Bitmap.createBitmap(800, 800, Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            Bitmap createBitmap2 = Bitmap.createBitmap(400, 400, Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap2);
            this.f1545b.m1541b();
            Util.debug("Creating encoder...");
            C0254a c0254a = new C0254a();
            c0254a.m2046a(20.0f);
            c0254a.m2047a(0);
            c0254a.m2052a(fileOutputStream);
            this.f1545b.m1541b();
            Util.debug("Encoding...");
            long j = 0;
            while (((double) j) < this.f1544a.m1609b() && !isCancelled()) {
                paint.setColor(-1);
                canvas.drawRect(0.0f, 0.0f, 800.0f, 800.0f, paint);
                androidDrawerVar.m1841a(this.f1544a, (double) j);
                canvas.save();
                canvas.translate(((float) (800 - i)) / 2.0f, (float) (800 - i2));
                androidDrawerVar.m1837a(canvas);
                canvas.restore();
//                canvas2.drawBitmap(createBitmap, null, new Rect(0, 0, 400, 400), this.f1545b.f925u);
                c0254a.m2051a(createBitmap2);
                long j2 = j + 50;
                Float[] fArr = new Float[1];
                fArr[0] = Float.valueOf((float) (((double) j2) / this.f1544a.m1609b()));
                publishProgress(fArr);
                j = j2;
            }
            c0254a.m2054b();
            this.f1545b.m1541b();
            Util.debug("Elapsed mapTime: " + c0254a.m2045a());
            fileOutputStream.close();
            Util.debug("Done.");
            return a;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected void m1941a(File file) {
//        this.f1545b.f908d.setProgress(0);
//        this.f1545b.f908d.setEnabled(true);
//        this.f1545b.f917m.setEnabled(true);
//        this.f1545b.m1558b(this.f1545b.f924t);
//        this.f1545b.f915k = cw.SELECTING;
//        this.f1545b.f921q.setText(R.string.share_your_android);
//        if (!isCancelled()) {
//            this.f1545b.m1539a(file, "image/gif");
//            dh.m1957a(this.f1545b, (int) R.raw.ogg_share_complete);
//        }
    }

    protected void m1942a(Float... fArr) {
        super.onProgressUpdate(fArr);
//        this.f1545b.f908d.setProgress((int) (100.0f * fArr[0].floatValue()));
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m1940a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m1941a((File) obj);
    }

    protected void onPreExecute() {
        this.f1545b.f921q.setText(R.string.saving);
    }

    protected /* synthetic */ void onProgressUpdate(Object[] objArr) {
        m1942a((Float[]) objArr);
    }
}
