package com.google.android.apps.androidify;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import com.google.android.apps.c.a;
import java.io.File;
import java.io.FileOutputStream;

class bt extends AsyncTask {
    final /* synthetic */ GifActivity a;

    bt(GifActivity gifActivity) {
        this.a = gifActivity;
    }

    protected File a(Void[] voidArr) {
        try {
            this.a.c = System.currentTimeMillis();
            c.a("Preparing to encode...");
            String str = Environment.getExternalStorageDirectory() + "/DCIM/Camera/";
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(str + "androidify.gif");
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            Canvas canvas = new Canvas(Bitmap.createBitmap(400, 400, Config.ARGB_8888));
            Paint paint = new Paint();
            this.a.a();
            c.a("Creating encoder...");
            a aVar = new a();
            aVar.a(20.0f);
            aVar.a(0);
            this.a.a();
            c.a("Encoding...");
            for (long j = 0; j < 2000; j += 50) {
                paint.setColor(-1);
                canvas.drawRect(0.0f, 0.0f, 400.0f, 400.0f, paint);
                this.a.a.a(this.a.b, (double) j);
                this.a.a.a(canvas);
            }
            aVar.b();
            this.a.a();
            c.a("Elapsed mapTime: " + aVar.a());
            fileOutputStream.close();
            c.a("Done.");
            return file2;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected void a(File file) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/gif");
        intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
        this.a.startActivity(Intent.createChooser(intent, "Share"));
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((File) obj);
    }
}
