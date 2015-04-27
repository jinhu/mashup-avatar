package com.google.android.apps.analytics;

import android.net.Uri;
import android.util.Log;

/* renamed from: com.google.android.apps.a.af */
class af {
    static String m1130a(String str, long j) {
        String queryParameter = Uri.parse(str).getQueryParameter("utmht");
        if (queryParameter != null) {
            try {
                str = str + "&utmqt=" + (j - Long.valueOf(Long.parseLong(queryParameter)).longValue());
            } catch (NumberFormatException e) {
                Log.e("GoogleAnalyticsTracker", "Error parsing utmht parameter: " + e.toString());
            }
        }
        return str;
    }
}
