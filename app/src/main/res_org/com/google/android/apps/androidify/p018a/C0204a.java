package com.google.android.apps.androidify.p018a;

import android.content.Context;
import com.google.android.apps.androidify.Util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.apps.androidify.a.a */
public class C0204a {
    private static long f979a;

    static {
        f979a = 0;
    }

    public static AnimationCatalogue m1596a(Context context, int i) {
        try {
            f979a = System.currentTimeMillis();
            AnimationCatalogue animationCatalogue = new AnimationCatalogue();
            Util.debug("Parsing JSON...");
            JSONObject a = Util.getJSONObjectFromResource(context, i);
            C0204a.m1599a();
            Util.debug("Processing JSON...");
            for (Animation animation : Animation.values()) {
                JSONObject a2 = C0204a.m1598a(a, animation.mName);
                if (a2 != null) {
                    JSONArray b = C0204a.m1600b(a2, "frameData");
                    if (b != null) {
                        animationCatalogue.addAnimation(animation, (double) ((float) a2.getDouble("duration")));
                        int length = b.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            a2 = C0204a.m1597a(b, i2);
                            float f = (float) a2.getDouble("t");
                            JSONArray b2 = C0204a.m1600b(a2, "val");
                            if (b2 != null && b2.length() > animation.f1038W) {
                                animationCatalogue.m1607a(animation, (double) f, b2.getDouble(animation.f1038W) + animation.f1040Y);
                            }
                        }
                    }
                }
            }
            if (a.has("posterTime")) {
                animationCatalogue.m1605a(a.getDouble("posterTime"));
            }
            if (a.has("duration")) {
                animationCatalogue.m1611b(a.getDouble("duration"));
            }
            C0204a.m1599a();
            Util.debug("Processing motion...");
            animationCatalogue.m1604a();
            Part a3 = Part.m1622a(i);
            if (a3 != null) {
                animationCatalogue.m1608a(a3);
            }
            C0204a.m1599a();
            return animationCatalogue;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JSONObject m1597a(JSONArray jSONArray, int i) {
        try {
            return jSONArray.getJSONObject(i);
        } catch (JSONException e) {
            return null;
        }
    }

    public static JSONObject m1598a(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getJSONObject(str);
        } catch (JSONException e) {
            return null;
        }
    }

    private static void m1599a() {
        long currentTimeMillis = System.currentTimeMillis();
        Util.debug("Elapsed: " + (currentTimeMillis - f979a));
        f979a = currentTimeMillis;
    }

    public static JSONArray m1600b(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getJSONArray(str);
        } catch (JSONException e) {
            return null;
        }
    }
}
