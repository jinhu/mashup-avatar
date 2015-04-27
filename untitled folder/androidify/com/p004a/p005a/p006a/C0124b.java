package com.p004a.p005a.p006a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import com.google.p007a.C0131a;
import com.google.p007a.C0149b;
import com.google.p007a.C0173d;
import com.google.p007a.p008a.C0129b;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;

/* renamed from: com.a.a.a.b */
public final class C0124b {
    private int f419a;
    private String f420b;
    private String f421c;
    private String f422d;
    private C0131a f423e;
    private boolean f424f;
    private int f425g;

    public C0124b(String str, Bundle bundle, String str2, String str3, int i) {
        this.f419a = Integer.MIN_VALUE;
        this.f420b = null;
        this.f421c = null;
        this.f422d = null;
        this.f423e = null;
        this.f424f = false;
        this.f425g = -16777216;
        this.f419a = i;
        this.f424f = m910a(str, bundle, str2, str3);
    }

    private static String m907a(CharSequence charSequence) {
        for (int i = 0; i < charSequence.length(); i++) {
            if (charSequence.charAt(i) > '\u00ff') {
                return "UTF-8";
            }
        }
        return null;
    }

    private static String m908a(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        return trim.length() != 0 ? trim : null;
    }

    private void m909a(String str, Bundle bundle, String str2) {
        int i = 0;
        if (str2.equals("TEXT_TYPE")) {
            if (str != null && str.length() > 0) {
                this.f420b = str;
                this.f421c = str;
                this.f422d = "Text";
            }
        } else if (str2.equals("EMAIL_TYPE")) {
            r0 = C0124b.m908a(str);
            if (r0 != null) {
                this.f420b = "mailto:" + r0;
                this.f421c = r0;
                this.f422d = "E-Mail";
            }
        } else if (str2.equals("PHONE_TYPE")) {
            r0 = C0124b.m908a(str);
            if (r0 != null) {
                this.f420b = "tel:" + r0;
                this.f421c = PhoneNumberUtils.formatNumber(r0);
                this.f422d = "Phone";
            }
        } else if (str2.equals("SMS_TYPE")) {
            r0 = C0124b.m908a(str);
            if (r0 != null) {
                this.f420b = "sms:" + r0;
                this.f421c = PhoneNumberUtils.formatNumber(r0);
                this.f422d = "SMS";
            }
        } else if (str2.equals("CONTACT_TYPE")) {
            if (bundle != null) {
                StringBuilder stringBuilder = new StringBuilder(100);
                StringBuilder stringBuilder2 = new StringBuilder(100);
                stringBuilder.append("MECARD:");
                r0 = C0124b.m908a(bundle.getString("name"));
                if (r0 != null) {
                    stringBuilder.append("N:").append(C0124b.m911b(r0)).append(';');
                    stringBuilder2.append(r0);
                }
                r0 = C0124b.m908a(bundle.getString("postal"));
                if (r0 != null) {
                    stringBuilder.append("ADR:").append(C0124b.m911b(r0)).append(';');
                    stringBuilder2.append('\n').append(r0);
                }
                Collection<String> hashSet = new HashSet(C0123a.f415a.length);
                for (String string : C0123a.f415a) {
                    String string2 = C0124b.m908a(bundle.getString(string2));
                    if (string2 != null) {
                        hashSet.add(string2);
                    }
                }
                for (String str3 : hashSet) {
                    stringBuilder.append("TEL:").append(C0124b.m911b(str3)).append(';');
                    stringBuilder2.append('\n').append(PhoneNumberUtils.formatNumber(str3));
                }
                Collection<String> hashSet2 = new HashSet(C0123a.f417c.length);
                while (i < C0123a.f417c.length) {
                    String a = C0124b.m908a(bundle.getString(C0123a.f417c[i]));
                    if (a != null) {
                        hashSet2.add(a);
                    }
                    i++;
                }
                for (String str32 : hashSet2) {
                    stringBuilder.append("EMAIL:").append(C0124b.m911b(str32)).append(';');
                    stringBuilder2.append('\n').append(str32);
                }
                str32 = C0124b.m908a(bundle.getString("URL_KEY"));
                if (str32 != null) {
                    stringBuilder.append("URL:").append(str32).append(';');
                    stringBuilder2.append('\n').append(str32);
                }
                str32 = C0124b.m908a(bundle.getString("NOTE_KEY"));
                if (str32 != null) {
                    stringBuilder.append("NOTE:").append(C0124b.m911b(str32)).append(';');
                    stringBuilder2.append('\n').append(str32);
                }
                if (stringBuilder2.length() > 0) {
                    stringBuilder.append(';');
                    this.f420b = stringBuilder.toString();
                    this.f421c = stringBuilder2.toString();
                    this.f422d = "Contact";
                    return;
                }
                this.f420b = null;
                this.f421c = null;
            }
        } else if (str2.equals("LOCATION_TYPE") && bundle != null) {
            float f = bundle.getFloat("LAT", Float.MAX_VALUE);
            float f2 = bundle.getFloat("LONG", Float.MAX_VALUE);
            if (f != Float.MAX_VALUE && f2 != Float.MAX_VALUE) {
                this.f420b = "geo:" + f + ',' + f2;
                this.f421c = f + "," + f2;
                this.f422d = "Location";
            }
        }
    }

    private boolean m910a(String str, Bundle bundle, String str2, String str3) {
        this.f423e = null;
        if (str3 != null) {
            try {
                this.f423e = C0131a.valueOf(str3);
            } catch (IllegalArgumentException e) {
            }
        }
        if (this.f423e == null || this.f423e == C0131a.QR_CODE) {
            this.f423e = C0131a.QR_CODE;
            m909a(str, bundle, str2);
        } else if (str != null && str.length() > 0) {
            this.f420b = str;
            this.f421c = str;
            this.f422d = "Text";
        }
        return this.f420b != null && this.f420b.length() > 0;
    }

    private static String m911b(String str) {
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

    public Bitmap m912a() {
        Map map = null;
        if (!this.f424f) {
            return null;
        }
        String a = C0124b.m907a(this.f420b);
        if (a != null) {
            map = new EnumMap(C0149b.class);
            map.put(C0149b.CHARACTER_SET, a);
        }
        C0129b a2 = new C0173d().m1093a(this.f420b, this.f423e, this.f419a, this.f419a, map);
        int b = a2.m946b();
        int c = a2.m948c();
        int[] iArr = new int[(b * c)];
        for (int i = 0; i < c; i++) {
            int i2 = i * b;
            for (int i3 = 0; i3 < b; i3++) {
                iArr[i2 + i3] = a2.m945a(i3, i) ? this.f425g : 0;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(b, c, Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, b, 0, 0, b, c);
        return createBitmap;
    }

    public void m913a(int i) {
        this.f425g = i;
    }
}
