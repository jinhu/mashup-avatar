package com.a.a.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import com.google.a.a;
import com.google.a.d;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;

public final class b {
    private int a;
    private String b;
    private String c;
    private String d;
    private a e;
    private boolean f;
    private int g;

    public b(String str, Bundle bundle, String str2, String str3, int i) {
        this.a = Integer.MIN_VALUE;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = false;
        this.g = -16777216;
        this.a = i;
        this.f = a(str, bundle, str2, str3);
    }

    private static String a(CharSequence charSequence) {
        for (int i = 0; i < charSequence.length(); i++) {
            if (charSequence.charAt(i) > '\u00ff') {
                return "UTF-8";
            }
        }
        return null;
    }

    private static String a(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        return trim.length() != 0 ? trim : null;
    }

    private void a(String str, Bundle bundle, String str2) {
        int i = 0;
        if (str2.equals("TEXT_TYPE")) {
            if (str != null && str.length() > 0) {
                this.b = str;
                this.c = str;
                this.d = "Text";
            }
        } else if (str2.equals("EMAIL_TYPE")) {
            r0 = a(str);
            if (r0 != null) {
                this.b = "mailto:" + r0;
                this.c = r0;
                this.d = "E-Mail";
            }
        } else if (str2.equals("PHONE_TYPE")) {
            r0 = a(str);
            if (r0 != null) {
                this.b = "tel:" + r0;
                this.c = PhoneNumberUtils.formatNumber(r0);
                this.d = "Phone";
            }
        } else if (str2.equals("SMS_TYPE")) {
            r0 = a(str);
            if (r0 != null) {
                this.b = "sms:" + r0;
                this.c = PhoneNumberUtils.formatNumber(r0);
                this.d = "SMS";
            }
        } else if (str2.equals("CONTACT_TYPE")) {
            if (bundle != null) {
                StringBuilder stringBuilder = new StringBuilder(100);
                StringBuilder stringBuilder2 = new StringBuilder(100);
                stringBuilder.append("MECARD:");
                r0 = a(bundle.getString("name"));
                if (r0 != null) {
                    stringBuilder.append("N:").append(b(r0)).append(';');
                    stringBuilder2.append(r0);
                }
                r0 = a(bundle.getString("postal"));
                if (r0 != null) {
                    stringBuilder.append("ADR:").append(b(r0)).append(';');
                    stringBuilder2.append('\n').append(r0);
                }
                Collection<String> hashSet = new HashSet(a.a.length);
                for (String string : a.a) {
                    String string2 = a(bundle.getString(string2));
                    if (string2 != null) {
                        hashSet.add(string2);
                    }
                }
                for (String str3 : hashSet) {
                    stringBuilder.append("TEL:").append(b(str3)).append(';');
                    stringBuilder2.append('\n').append(PhoneNumberUtils.formatNumber(str3));
                }
                Collection<String> hashSet2 = new HashSet(a.c.length);
                while (i < a.c.length) {
                    String a = a(bundle.getString(a.c[i]));
                    if (a != null) {
                        hashSet2.add(a);
                    }
                    i++;
                }
                for (String str32 : hashSet2) {
                    stringBuilder.append("EMAIL:").append(b(str32)).append(';');
                    stringBuilder2.append('\n').append(str32);
                }
                str32 = a(bundle.getString("URL_KEY"));
                if (str32 != null) {
                    stringBuilder.append("URL:").append(str32).append(';');
                    stringBuilder2.append('\n').append(str32);
                }
                str32 = a(bundle.getString("NOTE_KEY"));
                if (str32 != null) {
                    stringBuilder.append("NOTE:").append(b(str32)).append(';');
                    stringBuilder2.append('\n').append(str32);
                }
                if (stringBuilder2.length() > 0) {
                    stringBuilder.append(';');
                    this.b = stringBuilder.toString();
                    this.c = stringBuilder2.toString();
                    this.d = "Contact";
                    return;
                }
                this.b = null;
                this.c = null;
            }
        } else if (str2.equals("LOCATION_TYPE") && bundle != null) {
            float f = bundle.getFloat("LAT", Float.MAX_VALUE);
            float f2 = bundle.getFloat("LONG", Float.MAX_VALUE);
            if (f != Float.MAX_VALUE && f2 != Float.MAX_VALUE) {
                this.b = "geo:" + f + ',' + f2;
                this.c = f + "," + f2;
                this.d = "Location";
            }
        }
    }

    private boolean a(String str, Bundle bundle, String str2, String str3) {
        this.e = null;
        if (str3 != null) {
            try {
                this.e = a.valueOf(str3);
            } catch (IllegalArgumentException e) {
            }
        }
        if (this.e == null || this.e == a.QR_CODE) {
            this.e = a.QR_CODE;
            a(str, bundle, str2);
        } else if (str != null && str.length() > 0) {
            this.b = str;
            this.c = str;
            this.d = "Text";
        }
        return this.b != null && this.b.length() > 0;
    }

    private static String b(String str) {
        if (str == null) {
            return str;
        }
        if (str.indexOf(58) < 0 && str.indexOf(59) < 0) {
            return str;
        }
        int length = str.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == ':' || charAt == ';') {
                stringBuilder.append('\\');
            }
            stringBuilder.append(charAt);
        }
        return stringBuilder.toString();
    }

    public Bitmap a() {
        Map map = null;
        if (!this.f) {
            return null;
        }
        String a = a(this.b);
        if (a != null) {
            map = new EnumMap(com.google.a.b.class);
            map.put(com.google.a.b.CHARACTER_SET, a);
        }
        com.google.a.a.b a2 = new d().a(this.b, this.e, this.a, this.a, map);
        int b = a2.b();
        int c = a2.c();
        int[] iArr = new int[(b * c)];
        for (int i = 0; i < c; i++) {
            int i2 = i * b;
            for (int i3 = 0; i3 < b; i3++) {
                iArr[i2 + i3] = a2.a(i3, i) ? this.g : 0;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(b, c, Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, b, 0, 0, b, c);
        return createBitmap;
    }

    public void a(int i) {
        this.g = i;
    }
}
