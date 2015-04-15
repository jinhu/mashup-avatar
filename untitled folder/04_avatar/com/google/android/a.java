package com.google.android;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.view.View;
import com.google.android.apps.androidify.a.b;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class a {
    private static final Random a;
    private static String b;

    static {
        a = new Random();
        b = "";
    }

    public static int a(int i, int i2) {
        return a.nextInt((i2 - i) + 1) + i;
    }

    public static int a(int[] iArr) {
        return iArr[a.nextInt(iArr.length)];
    }

    public static int a(int[] iArr, int i) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (iArr[i2] == i) {
                return i2;
            }
        }
        return 0;
    }

    public static Bitmap a(Bitmap bitmap, float f) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    public static Bitmap a(View view) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.save();
        view.draw(canvas);
        return createBitmap;
    }

    public static b a() {
        b bVar = new b(1.0f, 1.0f);
        bVar.a(0.25f, 1.125f);
        bVar.a(0.5f, 1.0f);
        bVar.a(0.75f, 1.03125f);
        return bVar;
    }

    public static void a(File file, String str, Bitmap bitmap) {
        OutputStream fileOutputStream;
        IOException e;
        Throwable th;
        c("Writing file: " + str);
        try {
            fileOutputStream = new FileOutputStream(new File(file, str));
            try {
                bitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        return;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                c(" - Output stream was null!");
            } catch (IOException e3) {
                e2 = e3;
                try {
                    c("Error saving droid image.");
                    e2.printStackTrace();
                    if (fileOutputStream == null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                            return;
                        }
                    }
                    c(" - Output stream was null!");
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream == null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    } else {
                        c(" - Output stream was null!");
                    }
                    throw th;
                }
            }
        } catch (IOException e5) {
            e22 = e5;
            fileOutputStream = null;
            c("Error saving droid image.");
            e22.printStackTrace();
            if (fileOutputStream == null) {
                c(" - Output stream was null!");
            }
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream == null) {
                c(" - Output stream was null!");
            } else {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
            throw th;
        }
    }

    public static void a(String str) {
        b = str;
    }

    public static void a(String str, Throwable th) {
        Log.e(b, str, th);
    }

    public static void a(Throwable th) {
        Log.e(b, "", th);
    }

    public static boolean a(File file, String str) {
        File file2 = new File(file, str);
        return file2.exists() ? file2.delete() : false;
    }

    public static boolean b(String str) {
        return str == null || str.length() == 0;
    }

    public static void c(String str) {
        Log.d(b, str);
    }

    public static int d(String str) {
        return -16777216 | Integer.parseInt(str, 16);
    }
}
