package com.google.android.apps.androidify.p018a;

import android.content.Context;
import com.google.android.apps.androidify.C0220c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.apps.androidify.a.a */
public class C0204a {
    private static long f979a;

    static {
        f979a = 0;
    }

    public static C0208e m1596a(Context context, int i) {
        try {
            f979a = System.currentTimeMillis();
            C0208e c0208e = new C0208e();
            C0220c.m1912a("Parsing JSON...");
            JSONObject a = C0220c.m1908a(context, i);
            C0204a.m1599a();
            C0220c.m1912a("Processing JSON...");
            for (C0211h c0211h : C0211h.values()) {
                JSONObject a2 = C0204a.m1598a(a, c0211h.f1037V);
                if (a2 != null) {
                    JSONArray b = C0204a.m1600b(a2, "frameData");
                    if (b != null) {
                        c0208e.m1606a(c0211h, (double) ((float) a2.getDouble("duration")));
                        int length = b.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            a2 = C0204a.m1597a(b, i2);
                            float f = (float) a2.getDouble("t");
                            JSONArray b2 = C0204a.m1600b(a2, "val");
                            if (b2 != null && b2.length() > c0211h.f1038W) {
                                c0208e.m1607a(c0211h, (double) f, b2.getDouble(c0211h.f1038W) + c0211h.f1040Y);
                            }
                        }
                    }
                }
            }
            if (a.has("posterTime")) {
                c0208e.m1605a(a.getDouble("posterTime"));
            }
            if (a.has("duration")) {
                c0208e.m1611b(a.getDouble("duration"));
            }
            C0204a.m1599a();
            C0220c.m1912a("Processing motion...");
            c0208e.m1604a();
            C0214k a3 = C0214k.m1622a(i);
            if (a3 != null) {
                c0208e.m1608a(a3);
            }
            C0204a.m1599a();
            return c0208e;
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
        C0220c.m1912a("Elapsed: " + (currentTimeMillis - f979a));
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
