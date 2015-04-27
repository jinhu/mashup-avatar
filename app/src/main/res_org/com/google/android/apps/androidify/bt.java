package com.google.android.apps.androidify;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import com.google.android.apps.p017c.C0254a;
import java.io.File;
import java.io.FileOutputStream;

class bt extends AsyncTask {
    final /* synthetic */ GifActivity f1466a;

    bt(GifActivity gifActivity) {
        this.f1466a = gifActivity;
    }

    protected File m1892a(Void[] voidArr) {
        try {
            this.f1466a.f880c = System.currentTimeMillis();
            Util.debug("Preparing to encode...");
            String str = Environment.getExternalStorageDirectory() + "/DCIM/Camera/";
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(str + "androidify.gif");
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            Canvas canvas = new Canvas(Bitmap.createBitmap(400, 400, Config.ARGB_8888));
            Paint paint = new Paint();
            this.f1466a.m1494a();
            Util.debug("Creating encoder...");
            C0254a c0254a = new C0254a();
            c0254a.m2046a(20.0f);
            c0254a.m2047a(0);
            this.f1466a.m1494a();
            Util.debug("Encoding...");
            for (long j = 0; j < 2000; j += 50) {
                paint.setColor(-1);
                canvas.drawRect(0.0f, 0.0f, 400.0f, 400.0f, paint);
                this.f1466a.f878a.m1841a(this.f1466a.f879b, (double) j);
                this.f1466a.f878a.m1837a(canvas);
            }
            c0254a.m2054b();
            this.f1466a.m1494a();
            Util.debug("Elapsed mapTime: " + c0254a.m2045a());
            fileOutputStream.close();
            Util.debug("Done.");
            return file2;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected void m1893a(File file) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/gif");
        intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
        this.f1466a.startActivity(Intent.createChooser(intent, "Share"));
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m1892a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m1893a((File) obj);
    }
}
