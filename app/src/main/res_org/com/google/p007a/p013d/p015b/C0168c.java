package com.google.p007a.p013d.p015b;

import com.google.android.apps.androidify.cm;
import com.google.p007a.C0149b;
import com.google.p007a.C0175h;
import com.google.p007a.p008a.C0128a;
import com.google.p007a.p008a.C0130c;
import com.google.p007a.p008a.p009a.C0125a;
import com.google.p007a.p008a.p009a.C0127c;
import com.google.p007a.p013d.p014a.C0160a;
import com.google.p007a.p013d.p014a.C0161b;
import com.google.p007a.p013d.p014a.C0162c;
import com.google.p007a.p013d.p014a.C0164e;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* renamed from: com.google.a.d.b.c */
public final class C0168c {
    private static final int[] f593a;

    static {
        f593a = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};
    }

    static int m1042a(int i) {
        return i < f593a.length ? f593a[i] : -1;
    }

    private static int m1043a(C0128a c0128a, C0160a c0160a, C0162c c0162c, C0167b c0167b) {
        int i = Integer.MAX_VALUE;
        int i2 = -1;
        int i3 = 0;
        while (i3 < 8) {
            C0171f.m1071a(c0128a, c0160a, c0162c, i3, c0167b);
            int a = C0168c.m1044a(c0167b);
            if (a < i) {
                i2 = i3;
            } else {
                a = i;
            }
            i3++;
            i = a;
        }
        return i2;
    }

    private static int m1044a(C0167b c0167b) {
        return ((C0170e.m1061a(c0167b) + C0170e.m1064b(c0167b)) + C0170e.m1065c(c0167b)) + C0170e.m1066d(c0167b);
    }

    static C0128a m1045a(C0128a c0128a, int i, int i2, int i3) {
        if (c0128a.m941b() != i2) {
            throw new C0175h("Number of bits and data bytes does not match");
        }
        Collection<C0166a> arrayList = new ArrayList(i3);
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i4 < i3) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            C0168c.m1049a(i, i2, i3, i4, iArr, iArr2);
            int i8 = iArr[0];
            byte[] bArr = new byte[i8];
            c0128a.m937a(i7 * 8, bArr, 0, i8);
            byte[] a = C0168c.m1059a(bArr, iArr2[0]);
            arrayList.add(new C0166a(bArr, a));
            int max = Math.max(i6, i8);
            i4++;
            i5 = Math.max(i5, a.length);
            i6 = max;
            i7 = iArr[0] + i7;
        }
        if (i2 != i7) {
            throw new C0175h("Data bytes does not match offset");
        }
        C0128a c0128a2 = new C0128a();
        for (max = 0; max < i6; max++) {
            for (C0166a a2 : arrayList) {
                byte[] a3 = a2.m1033a();
                if (max < a3.length) {
                    c0128a2.m936a(a3[max], 8);
                }
            }
        }
        for (max = 0; max < i5; max++) {
            for (C0166a a22 : arrayList) {
                a3 = a22.m1034b();
                if (max < a3.length) {
                    c0128a2.m936a(a3[max], 8);
                }
            }
        }
        if (i == c0128a2.m941b()) {
            return c0128a2;
        }
        throw new C0175h("Interleaving error: " + i + " and " + c0128a2.m941b() + " differ.");
    }

    private static C0161b m1046a(String str, String str2) {
        int i = 0;
        if ("Shift_JIS".equals(str2)) {
            return C0168c.m1058a(str) ? C0161b.KANJI : C0161b.BYTE;
        } else {
            int i2 = 0;
            int i3 = 0;
            while (i < str.length()) {
                int charAt = str.charAt(i);
                if (charAt >= '0' && charAt <= '9') {
                    i3 = 1;
                } else if (C0168c.m1042a(charAt) == -1) {
                    return C0161b.BYTE;
                } else {
                    i2 = 1;
                }
                i++;
            }
            return i2 != 0 ? C0161b.ALPHANUMERIC : i3 != 0 ? C0161b.NUMERIC : C0161b.BYTE;
        }
    }

    private static C0162c m1047a(int i, C0160a c0160a) {
        for (int i2 = 1; i2 <= 40; i2++) {
            C0162c a = C0162c.m1019a(i2);
            if (a.m1023b() - a.m1022a(c0160a).m1029c() >= (i + 7) / 8) {
                return a;
            }
        }
        throw new C0175h("Data too big");
    }

    public static C0172g m1048a(String str, C0160a c0160a, Map map) {
        String str2 = map == null ? null : (String) map.get(C0149b.CHARACTER_SET);
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        C0161b a = C0168c.m1046a(str, str2);
        C0128a c0128a = new C0128a();
        if (a == C0161b.BYTE && !"ISO-8859-1".equals(str2)) {
            C0130c a2 = C0130c.m949a(str2);
            if (a2 != null) {
                C0168c.m1052a(a2, c0128a);
            }
        }
        C0168c.m1053a(a, c0128a);
        C0128a c0128a2 = new C0128a();
        C0168c.m1057a(str, a, c0128a2, str2);
        C0162c a3 = C0168c.m1047a((a.m1018a(C0168c.m1047a((c0128a.m935a() + a.m1018a(C0162c.m1019a(1))) + c0128a2.m935a(), c0160a)) + c0128a.m935a()) + c0128a2.m935a(), c0160a);
        C0128a c0128a3 = new C0128a();
        c0128a3.m938a(c0128a);
        C0168c.m1051a(a == C0161b.BYTE ? c0128a2.m941b() : str.length(), a3, a, c0128a3);
        c0128a3.m938a(c0128a2);
        C0164e a4 = a3.m1022a(c0160a);
        int b = a3.m1023b() - a4.m1029c();
        C0168c.m1050a(b, c0128a3);
        C0128a a5 = C0168c.m1045a(c0128a3, a3.m1023b(), b, a4.m1028b());
        C0172g c0172g = new C0172g();
        c0172g.m1089a(c0160a);
        c0172g.m1090a(a);
        c0172g.m1091a(a3);
        int c = a3.m1024c();
        C0167b c0167b = new C0167b(c, c);
        c = C0168c.m1043a(a5, c0160a, a3, c0167b);
        c0172g.m1088a(c);
        C0171f.m1071a(a5, c0160a, a3, c, c0167b);
        c0172g.m1092a(c0167b);
        return c0172g;
    }

    static void m1049a(int i, int i2, int i3, int i4, int[] iArr, int[] iArr2) {
        if (i4 >= i3) {
            throw new C0175h("Block ID too large");
        }
        int i5 = i % i3;
        int i6 = i3 - i5;
        int i7 = i / i3;
        int i8 = i7 + 1;
        int i9 = i2 / i3;
        int i10 = i9 + 1;
        i7 -= i9;
        i8 -= i10;
        if (i7 != i8) {
            throw new C0175h("EC bytes mismatch");
        } else if (i3 != i6 + i5) {
            throw new C0175h("RS blocks mismatch");
        } else {
            if (i != (i5 * (i10 + i8)) + ((i9 + i7) * i6)) {
                throw new C0175h("Total bytes mismatch");
            } else if (i4 < i6) {
                iArr[0] = i9;
                iArr2[0] = i7;
            } else {
                iArr[0] = i10;
                iArr2[0] = i8;
            }
        }
    }

    static void m1050a(int i, C0128a c0128a) {
        int i2 = i << 3;
        if (c0128a.m935a() > i2) {
            throw new C0175h("data bits cannot fit in the QR Code" + c0128a.m935a() + " > " + i2);
        }
        int i3;
        for (i3 = 0; i3 < 4 && c0128a.m935a() < i2; i3++) {
            c0128a.m939a(false);
        }
        i3 = c0128a.m935a() & 7;
        if (i3 > 0) {
            while (i3 < 8) {
                c0128a.m939a(false);
                i3++;
            }
        }
        int b = i - c0128a.m941b();
        for (i3 = 0; i3 < b; i3++) {
            c0128a.m936a((i3 & 1) == 0 ? 236 : 17, 8);
        }
        if (c0128a.m935a() != i2) {
            throw new C0175h("Bits size does not equal capacity");
        }
    }

    static void m1051a(int i, C0162c c0162c, C0161b c0161b, C0128a c0128a) {
        int a = c0161b.m1018a(c0162c);
        if (i >= (1 << a)) {
            throw new C0175h(i + " is bigger than " + ((1 << a) - 1));
        }
        c0128a.m936a(i, a);
    }

    private static void m1052a(C0130c c0130c, C0128a c0128a) {
        c0128a.m936a(C0161b.ECI.m1017a(), 4);
        c0128a.m936a(c0130c.m950a(), 8);
    }

    static void m1053a(C0161b c0161b, C0128a c0128a) {
        c0128a.m936a(c0161b.m1017a(), 4);
    }

    static void m1054a(CharSequence charSequence, C0128a c0128a) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int charAt = charSequence.charAt(i) - 48;
            if (i + 2 < length) {
                c0128a.m936a(((charAt * 100) + ((charSequence.charAt(i + 1) - 48) * 10)) + (charSequence.charAt(i + 2) - 48), 10);
                i += 3;
            } else if (i + 1 < length) {
                c0128a.m936a((charAt * 10) + (charSequence.charAt(i + 1) - 48), 7);
                i += 2;
            } else {
                c0128a.m936a(charAt, 4);
                i++;
            }
        }
    }

    static void m1055a(String str, C0128a c0128a) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            for (int i = 0; i < length; i += 2) {
                int i2 = ((bytes[i] & 255) << 8) | (bytes[i + 1] & 255);
                i2 = (i2 < 33088 || i2 > 40956) ? (i2 < 57408 || i2 > 60351) ? -1 : i2 - 49472 : i2 - 33088;
                if (i2 == -1) {
                    throw new C0175h("Invalid byte sequence");
                }
                c0128a.m936a((i2 & 255) + ((i2 >> 8) * 192), 13);
            }
        } catch (Throwable e) {
            throw new C0175h(e);
        }
    }

    static void m1056a(String str, C0128a c0128a, String str2) {
        try {
            for (byte a : str.getBytes(str2)) {
                c0128a.m936a(a, 8);
            }
        } catch (Throwable e) {
            throw new C0175h(e);
        }
    }

    static void m1057a(String str, C0161b c0161b, C0128a c0128a, String str2) {
        switch (C0169d.f594a[c0161b.ordinal()]) {
            case cm.HListView_android_divider /*1*/:
                C0168c.m1054a((CharSequence) str, c0128a);
            case cm.HListView_hlv_dividerWidth /*2*/:
                C0168c.m1060b(str, c0128a);
            case cm.HListView_hlv_headerDividersEnabled /*3*/:
                C0168c.m1056a(str, c0128a, str2);
            case cm.HListView_hlv_footerDividersEnabled /*4*/:
                C0168c.m1055a(str, c0128a);
            default:
                throw new C0175h("Invalid mode: " + c0161b);
        }
    }

    private static boolean m1058a(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i = 0; i < length; i += 2) {
                int i2 = bytes[i] & 255;
                if ((i2 < 129 || i2 > 159) && (i2 < 224 || i2 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException e) {
            return false;
        }
    }

    static byte[] m1059a(byte[] bArr, int i) {
        int i2 = 0;
        int length = bArr.length;
        int[] iArr = new int[(length + i)];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & 255;
        }
        new C0127c(C0125a.f430e).m932a(iArr, i);
        byte[] bArr2 = new byte[i];
        while (i2 < i) {
            bArr2[i2] = (byte) iArr[length + i2];
            i2++;
        }
        return bArr2;
    }

    static void m1060b(CharSequence charSequence, C0128a c0128a) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int a = C0168c.m1042a(charSequence.charAt(i));
            if (a == -1) {
                throw new C0175h();
            } else if (i + 1 < length) {
                int a2 = C0168c.m1042a(charSequence.charAt(i + 1));
                if (a2 == -1) {
                    throw new C0175h();
                }
                c0128a.m936a((a * 45) + a2, 11);
                i += 2;
            } else {
                c0128a.m936a(a, 6);
                i++;
            }
        }
    }
}
