package com.google.android.apps.androidify;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import dev.game.legend.svgandroid.SVG;

/**
 * Created by jin on 4/18/15.
 */
public class Util {
    public static void debug(String s) {

    }

    public static DisplayMetrics getMetrix(Activity anActivity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        anActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static int performance(Context context, float v) {

        return 0;
    }

    public static void inspect(Class<SVG> aSVGexClass, SVG aA3, SVG aA5, SVG aF1231n, SVG aA4, SVG aA) {

    }

    public static void performance(float v, float aHeight2, int i, int i1, Interpolator aF1219b, MainViewHideRunner aMainViewHideRunner) {

    }

    public static void print(Context aContext, String s) {

    }

    public static void print(float aHeight, float v, int i, int i1, Interpolator aF1218a, MainViewTransitionRunner aMainViewTransitionRunner) {

    }

    public static int print(int aF1334y, int[] aAf) {
        return 0;
    }


    public static float m1902a(Context context, float f) {
        return TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static final int m1903a(int i, int i2) {
        int i3 = (i & 16711680) >> 16;
        int i4 = (i & 65280) >> 8;
        int i5 = i & 255;
        int i6 = (16711680 & i2) >> 16;
        int i7 = (65280 & i2) >> 8;
        int i8 = i2 & 255;
        return (((i3 - i6) * (i3 - i6)) + ((i4 - i7) * (i4 - i7))) + ((i5 - i8) * (i5 - i8));
    }

    public static final int m1904a(int i, int[] iArr) {
        int i2 = 0;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        while (i2 < iArr.length) {
            int i5 = iArr[i2];
            if (i5 == i) {
                return i2;
            }
            i5 = Util.m1903a(i5, i);
            if (i5 < i3) {
                i4 = i2;
                i3 = i5;
            }
            i2++;
        }
        return i4;
    }

    public static DisplayMetrics m1905a(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static DroidCoordinate m1906a(View view, float f, float f2, View view2) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        view2.getLocationOnScreen(iArr2);
        return new DroidCoordinate(((float) (iArr[0] - iArr2[0])) + f, ((float) (iArr[1] - iArr2[1])) + f2);
    }

    public static List m1907a(ViewGroup viewGroup) {
        List arrayList = new ArrayList();
        Util.m1911a(viewGroup, arrayList);
        return arrayList;
    }

    public static JSONObject getJSONObjectFromResource(Context context, int i) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(i), "UTF-8"));
            StringBuilder stringBuilder = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return new JSONObject(stringBuilder.toString());
                }
                stringBuilder.append(readLine);
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static void m1909a(float f, float f2, long j, long j2, Interpolator interpolator, Object c0218f) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, f2);
        ofFloat.setDuration(j2);
        ofFloat.setStartDelay(j);
        if (interpolator != null) {
            ofFloat.setInterpolator(interpolator);
        }
        //ofFloat.addUpdateListener(new C0221d(j2, c0218f, ofFloat));
        //ofFloat.addListener(new C0223e(c0218f, f2, ofFloat));
        ofFloat.start();
    }

    public static void m1910a(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.setFlags(268468224);
        context.startActivity(intent);
    }

    private static void m1911a(ViewGroup viewGroup, List list) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                Util.m1911a((ViewGroup) childAt, list);
            } else {
                list.add(childAt);
            }
        }
    }

    public static void m1912a(String str) {
        //C0176a.m1106c(str);
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



}
