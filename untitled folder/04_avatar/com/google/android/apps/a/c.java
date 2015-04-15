package com.google.android.apps.a;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class c {
    public static String a(String str) {
        return a(str, "UTF-8");
    }

    static String a(String str, String str2) {
        try {
            return URLEncoder.encode(str, str2).replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError("URL encoding failed for: " + str);
        }
    }
}
