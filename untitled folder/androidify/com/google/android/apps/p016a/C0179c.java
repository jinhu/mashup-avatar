package com.google.android.apps.p016a;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* renamed from: com.google.android.apps.a.c */
public class C0179c {
    public static String m1133a(String str) {
        return C0179c.m1134a(str, "UTF-8");
    }

    static String m1134a(String str, String str2) {
        try {
            return URLEncoder.encode(str, str2).replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError("URL encoding failed for: " + str);
        }
    }
}
