package com.google.android.apps.androidify.a;

import android.content.Context;
import com.google.android.apps.androidify.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    private static long a;

    static {
        a = 0;
    }

    public static e a(Context context, int i) {
        try {
            a = System.currentTimeMillis();
            e eVar = new e();
            c.a("Parsing JSON...");
            JSONObject a = c.a(context, i);
            a();
            c.a("Processing JSON...");
            for (h hVar : h.values()) {
                JSONObject a2 = a(a, hVar.V);
                if (a2 != null) {
                    JSONArray b = b(a2, "frameData");
                    if (b != null) {
                        eVar.a(hVar, (double) ((float) a2.getDouble("duration")));
                        int length = b.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            a2 = a(b, i2);
                            float f = (float) a2.getDouble("t");
                            JSONArray b2 = b(a2, "val");
                            if (b2 != null && b2.length() > hVar.W) {
                                eVar.a(hVar, (double) f, b2.getDouble(hVar.W) + hVar.Y);
                            }
                        }
                    }
                }
            }
            if (a.has("posterTime")) {
                eVar.a(a.getDouble("posterTime"));
            }
            if (a.has("duration")) {
                eVar.b(a.getDouble("duration"));
            }
            a();
            c.a("Processing motion...");
            eVar.a();
            k a3 = k.a(i);
            if (a3 != null) {
                eVar.a(a3);
            }
            a();
            return eVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JSONObject a(JSONArray jSONArray, int i) {
        try {
            return jSONArray.getJSONObject(i);
        } catch (JSONException e) {
            return null;
        }
    }

    public static JSONObject a(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getJSONObject(str);
        } catch (JSONException e) {
            return null;
        }
    }

    private static void a() {
        long currentTimeMillis = System.currentTimeMillis();
        c.a("Elapsed: " + (currentTimeMillis - a));
        a = currentTimeMillis;
    }

    public static JSONArray b(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getJSONArray(str);
        } catch (JSONException e) {
            return null;
        }
    }
}
