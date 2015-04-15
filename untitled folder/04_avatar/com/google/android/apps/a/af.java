package com.google.android.apps.a;

import android.net.Uri;
import android.util.Log;

class af {
    static String a(String str, long j) {
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
