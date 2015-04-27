package com.google.android.apps.androidify;

import android.graphics.PointF;
import android.graphics.RectF;
import java.util.HashMap;

public class Constants {
    public static final PointF POINT_LEFT_OF_LEFT_SHOULDER;
    public static final PointF POINT_TOP_LEFT_OF_BODY;
    public static final PointF POINT_TO_REF_13;
    public static final PointF POINT_CENTER_OF_BODY;
    public static final PointF POINT_TO_REF_14;
    public static final PointF POINT_TO_REF_15;
    public static final PointF POINT_TO_REF_16;
    public static final PointF POINT_TO_REF_17;
    public static final PointF POINT_TO_REF_18;
    public static final PointF POINT_TO_REF_19;
    public static final PointF POINT_TO_REF_20;
    public static final PointF POINT_TO_REF_21;
    public static final PointF POINT_TO_REF_22;
    public static final PointF POINT_TO_REF_23;
    public static final PointF POINT_TO_REF_24;
    public static final PointF POINT_TO_REF_25;
    public static final PointF POINT_TO_REF_26;
    public static final PointF POINT_TO_REF_27;
    public static final PointF POINT_TO_REF_28;
    public static final PointF POINT_TO_REF_29;
    public static final PointF POINT_TO_REF_30;
    public static final PointF POINT_TO_REF_31;
    public static final PointF POINT_TO_REF_32;
    public static final PointF POINT_TO_REF_33;
    public static final PointF POINT_TO_REF_34;
    public static final PointF POINT_TO_REF_40;
    public static final Integer f1190a;
    public static final PointF POINT_TO_REF_35;
    public static final PointF POINT_TO_REF_36;
    public static final PointF POINT_TO_REF_37;
    public static final PointF POINT_TO_REF_38;
    public static final PointF POINT_TO_REF_39;
    public static final int[] af;
    public static final HashMap ag;
    public static final String[] ah;
    public static final int[] mSkinColors;
    public static final int[] aj;
    public static final String[] ak;
    public static final int[] al;
    public static final Integer ANDROID_COLOR;
    public static final Integer f1192c;
    public static final Integer f1193d;
    public static final Integer f1194e;
    public static final PointF POINT_TO_REF_1;
    public static final PointF POINT_TO_REF_2;
    public static final PointF POINT_LEFT_BOTTOM_OF_HEAD;
    public static final PointF POINT_RIGHT_BOTTOM_OF_HEAD;
    public static final PointF POINT_TO_REF_3;
    public static final PointF POINT_TO_REF_4;
    public static final PointF POINT_TO_REF_5;
    public static final PointF POINT_TO_REF_6;
    public static final PointF POINT_TO_REF_7;
    public static final PointF POINT_TO_REF_8;
    public static final PointF POINT_TO_REF_9;
    public static final PointF POINT_TO_REF_10;
    public static final PointF POINT_TO_REF_11;
    public static final PointF POINT_TO_REF_12;
    public static final float f1209t;
    public static final float f1210u;
    public static final float f1211v;
    public static final RectF f1212w;
    public static final RectF f1213x;
    public static final RectF f1214y;
    public static final PointF POINT_TOP_OF_BODY;
    public static final String ASSET_HAIR = "hair";
    public static final String HAIR_BACK = "back";
    public static final String HAIR_FRONT = "front";
    public static final String HAIR_BACK_EXTRA = "backextra";
    public static final String HAIR_FRONT_EXTRA = "frontextra";

    static {
        f1190a = Integer.valueOf(-13096960);
        ANDROID_COLOR = Integer.valueOf(-8862377);
        f1192c = Integer.valueOf(-6250336);
        f1193d = Integer.valueOf(-12436163);
        f1194e = Integer.valueOf(-2735279);
        POINT_TO_REF_1 = new PointF(250.0f, 72.059f);
        POINT_TO_REF_2 = new PointF(250.0f, 159.635f);
        POINT_LEFT_BOTTOM_OF_HEAD = new PointF(140.836f, 159.635f);
        POINT_RIGHT_BOTTOM_OF_HEAD = new PointF(359.164f, 159.635f);
        POINT_TO_REF_3 = new PointF(203.952f, 105.278f);
        POINT_TO_REF_4 = new PointF(296.048f, 105.278f);
        POINT_TO_REF_5 = new PointF(203.952f, 129.437f);
        POINT_TO_REF_6 = new PointF(296.048f, 129.437f);
        POINT_TO_REF_7 = new PointF(203.952f, 117.3575f);
        POINT_TO_REF_8 = new PointF(296.048f, 117.3575f);
        POINT_TO_REF_9 = new PointF(208.47101f, 91.899994f);
        POINT_TO_REF_10 = new PointF(291.529f, 91.899994f);
        POINT_TO_REF_11 = new PointF(178.74701f, 48.92f);
        POINT_TO_REF_12 = new PointF(321.253f, 48.92f);
        f1209t = POINT_TO_REF_5.y - POINT_TO_REF_3.y;
        f1210u = f1209t / 2.0f;
        f1211v = POINT_TO_REF_12.y - (72.059f - POINT_TO_REF_12.y);
        f1212w = new RectF(POINT_LEFT_BOTTOM_OF_HEAD.x, POINT_TO_REF_12.y, POINT_RIGHT_BOTTOM_OF_HEAD.x, POINT_TO_REF_2.y);
        f1213x = new RectF(POINT_LEFT_BOTTOM_OF_HEAD.x, POINT_TO_REF_7.y - (f1210u * 2.0f), POINT_RIGHT_BOTTOM_OF_HEAD.x, POINT_TO_REF_8.y + (f1210u * 2.0f));
        f1214y = new RectF(POINT_LEFT_BOTTOM_OF_HEAD.x, POINT_TO_REF_7.y + (f1210u * 2.0f), POINT_RIGHT_BOTTOM_OF_HEAD.x, POINT_RIGHT_BOTTOM_OF_HEAD.y);
        POINT_TOP_OF_BODY = new PointF(250.0f, 175.489f);
        POINT_LEFT_OF_LEFT_SHOULDER = new PointF(140.832f, 175.489f);
        POINT_TOP_LEFT_OF_BODY = new PointF(359.168f, 175.489f);
        POINT_TO_REF_13 = new PointF(250.0f, 372.537f);
        POINT_CENTER_OF_BODY = new PointF(250.0f, 274.013f);
        POINT_TO_REF_14 = new PointF(102.028f, 174.73401f);
        POINT_TO_REF_15 = new PointF(397.972f, 174.73401f);
        POINT_TO_REF_16 = new PointF(102.028f, 321.953f);
        POINT_TO_REF_17 = new PointF(397.972f, 321.953f);
        POINT_TO_REF_18 = new PointF(102.028f, 199.65399f);
        POINT_TO_REF_19 = new PointF(78.11f, 199.65399f);
        POINT_TO_REF_20 = new PointF(126.819f, 199.65399f);
        POINT_TO_REF_21 = new PointF(397.972f, 199.65399f);
        POINT_TO_REF_22 = new PointF(421.89f, 199.65399f);
        POINT_TO_REF_23 = new PointF(373.181f, 199.65399f);
        POINT_TO_REF_24 = new PointF(102.028f, 297.033f);
        POINT_TO_REF_25 = new PointF(397.972f, 297.033f);
        POINT_TO_REF_26 = new PointF(102.028f, 248.3435f);
        POINT_TO_REF_27 = new PointF(397.972f, 248.3435f);
        POINT_TO_REF_28 = new PointF(182.6f, 372.537f);
        POINT_TO_REF_29 = new PointF(317.4f, 372.537f);
        POINT_TO_REF_30 = new PointF(231.309f, 372.537f);
        POINT_TO_REF_31 = new PointF(268.691f, 372.537f);
        POINT_TO_REF_32 = new PointF((POINT_TO_REF_28.x + POINT_TO_REF_30.x) / 2.0f, 372.537f);
        POINT_TO_REF_33 = new PointF((POINT_TO_REF_31.x + POINT_TO_REF_29.x) / 2.0f, 372.537f);
        POINT_TO_REF_34 = new PointF(206.954f, 451.63498f);
        POINT_TO_REF_40 = new PointF(293.046f, 451.63498f);
        POINT_TO_REF_35 = new PointF(206.954f, 427.28f);
        POINT_TO_REF_36 = new PointF(293.046f, 427.28f);
        POINT_TO_REF_37 = new PointF(POINT_TO_REF_35.x, POINT_TO_REF_32.y + ((POINT_TO_REF_35.y - POINT_TO_REF_32.y) / 2.0f));
        POINT_TO_REF_38 = new PointF(POINT_TO_REF_36.x, POINT_TO_REF_33.y + ((POINT_TO_REF_36.y - POINT_TO_REF_33.y) / 2.0f));
        POINT_TO_REF_39 = new PointF(500.0f, 100.0f);
        af = new int[]{-16777216, -13096960, -9744606, -6723792, -2275072, -213455, -8622, -7303024, -2763307, -10062052, -16743681, -3719810};
        ag = new HashMap();
        ag.put(Integer.valueOf(-986896), Integer.valueOf(-2763307));
        ah = new String[]{"Black", "Brown", "Light Chestnut", "LightBrown", "Red", "Dirty Blonde", "Blonde", "Gray", "White", "Dark Green", "Blue", "Hot Pink"};
        mSkinColors = new int[]{-8862377, -12639473, -10535381, -6851514, -4684214, -2906258, -2902903, -1981294, -864342, -8520};
        aj = new int[]{-8930217, -13427443, -11127000, -7574718, -5276088, -3367315, -3363449, -2244718, -1390681, -404556};
        ak = new String[]{"Android Skin", "Skin Tone 1", "Skin Tone 2", "Skin Tone 3", "Skin Tone 4", "Skin Tone 5", "Skin Tone 6", "Skin Tone 7", "Skin Tone 8", "Skin Tone 9"};
        al = new int[]{-8862377, -14864766, -12759809, -7796471, -4127226, -16777216, -748100, -4435069, -1518080, -234496, -14194393, -13423321, -11721204, -5921442, -1315861, -7895161, -14213318, -13667928};
    }

    public static int m1693a(int i) {
        for (int i2 = 0; i2 < mSkinColors.length; i2++) {
            if (i == mSkinColors[i2]) {
                return aj[i2];
            }
        }
        return aj[0];
    }

    private static String m1694a(int i, int[] iArr, String[] strArr) {
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (i == iArr[i2]) {
                return strArr[i2];
            }
        }
        return "Unknown";
    }

    public static String m1695b(int i) {
        return m1694a(i, mSkinColors, ak);
    }

    public static String m1696c(int i) {
        return m1694a(i, af, ah);
    }
}
