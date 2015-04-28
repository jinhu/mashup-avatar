package com.google.android;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;

import com.google.android.apps.androidify.p018a.AndInterpolator;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.Random;

/* renamed from: com.google.android.a */
public class Util {
    private static final Random f605a;
    private static String f606b;

    static {
        f605a = new Random();
        f606b = "";
    }

    public static Object[] collect(Class cls, Object... objArr) {
        int i = 0;
        int i2 = 0;
        for (Object obj : objArr) {
            if (obj != null) {
                i2++;
            }
        }
        Object[] objArr2 = (Object[]) Array.newInstance(cls, i2);
        for (Object obj2 : objArr) {
            if (obj2 != null) {
                objArr2[i] = obj2;
                i++;
            }
        }
        return objArr2;
    }

    public static int m1094a(int i, int i2) {
        return f605a.nextInt((i2 - i) + 1) + i;
    }

    public static int m1095a(int[] iArr) {
        return iArr[f605a.nextInt(iArr.length)];
    }

    public static int m1096a(int[] iArr, int i) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (iArr[i2] == i) {
                return i2;
            }
        }
        return 0;
    }

    public static Bitmap m1097a(Bitmap bitmap, float f) {
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

    public static Bitmap convertToBitmap(View view) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.save();
        view.draw(canvas);
        return createBitmap;
    }

    public static AndInterpolator m1099a() {
        AndInterpolator andInterpolator = new AndInterpolator(1.0f, 1.0f);
        andInterpolator.nextPoint(0.25f, 1.125f);
        andInterpolator.nextPoint(0.5f, 1.0f);
        andInterpolator.nextPoint(0.75f, 1.03125f);
        return andInterpolator;
    }

    public static void m1100a(File file, String str, Bitmap bitmap) {
        OutputStream fileOutputStream;
        IOException e;
        IOException e22;
        Throwable th;
        Util.debug("Writing file: " + str);
//        try {
//            fileOutputStream = new FileOutputStream(new File(file, str));
//            try {
//                bitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
//                if (fileOutputStream != null) {
//                    try {
//                        fileOutputStream.flush();
//                        fileOutputStream.close();
//                        return;
//                    } catch (IOException e2) {
//                        e2.printStackTrace();
//                        return;
//                    }
//                }
//                Log.debug(" - Output stream was null!");
//            } catch (Exception e3) {
//                try {
//                    Log.debug("Error saving droid image.");
//                    e3.printStackTrace();
//                    if (fileOutputStream == null) {
//                        try {
//                            fileOutputStream.flush();
//                            fileOutputStream.close();
//                        } catch (IOException e33) {
//                            e33.printStackTrace();
//                            return;
//                        }
//                    }
//                    Log.debug(" - Output stream was null!");
//                } catch (Throwable th2) {
//                    th = th2;
//                    if (fileOutputStream == null) {
//                        try {
//                            fileOutputStream.flush();
//                            fileOutputStream.close();
//                        } catch (IOException e4) {
//                            e4.printStackTrace();
//                        }
//                    } else {
//                        Log.debug(" - Output stream was null!");
//                    }
//                    throw th;
//                }
//            }
//        } catch (IOException e5) {
//            e22 = e5;
//            fileOutputStream = null;
//            Log.debug("Error saving droid image.");
//            e22.printStackTrace();
//            if (fileOutputStream == null) {
//                Log.debug(" - Output stream was null!");
//            }
//            fileOutputStream.flush();
//            fileOutputStream.close();
//        } catch (Throwable th3) {
//            th = th3;
//            fileOutputStream = null;
//            if (fileOutputStream == null) {
//                Log.debug(" - Output stream was null!");
//            } else {
//                fileOutputStream.flush();
//                fileOutputStream.close();
//            }
//            throw th;
//        }
    }

    public static void m1101a(String str) {
        f606b = str;
    }

    public static void error(String str, Throwable th) {
        android.util.Log.e(f606b, str, th);
    }

    public static void m1103a(Throwable th) {
        android.util.Log.e(f606b, "", th);
    }

    public static boolean m1104a(File file, String str) {
        File file2 = new File(file, str);
        return file2.exists() ? file2.delete() : false;
    }

    public static boolean m1105b(String str) {
        return str == null || str.length() == 0;
    }

    public static void debug(String str) {
        android.util.Log.d(f606b, str);
    }

    public static int m1107d(String str) {
        return -16777216 | Integer.parseInt(str, 16);
    }
}
