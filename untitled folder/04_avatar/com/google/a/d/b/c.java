package com.google.a.d.b;

import com.google.a.a.a;
import com.google.a.d.a.b;
import com.google.a.d.a.e;
import com.google.a.h;
import com.google.android.apps.androidify.cm;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class c {
    private static final int[] a;

    static {
        a = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};
    }

    static int a(int i) {
        return i < a.length ? a[i] : -1;
    }

    private static int a(a aVar, com.google.a.d.a.a aVar2, com.google.a.d.a.c cVar, b bVar) {
        int i = Integer.MAX_VALUE;
        int i2 = -1;
        int i3 = 0;
        while (i3 < 8) {
            f.a(aVar, aVar2, cVar, i3, bVar);
            int a = a(bVar);
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

    private static int a(b bVar) {
        return ((e.a(bVar) + e.b(bVar)) + e.c(bVar)) + e.d(bVar);
    }

    static a a(a aVar, int i, int i2, int i3) {
        if (aVar.b() != i2) {
            throw new h("Number of bits and data bytes does not match");
        }
        Collection<a> arrayList = new ArrayList(i3);
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i4 < i3) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            a(i, i2, i3, i4, iArr, iArr2);
            int i8 = iArr[0];
            byte[] bArr = new byte[i8];
            aVar.a(i7 * 8, bArr, 0, i8);
            byte[] a = a(bArr, iArr2[0]);
            arrayList.add(new a(bArr, a));
            int max = Math.max(i6, i8);
            i4++;
            i5 = Math.max(i5, a.length);
            i6 = max;
            i7 = iArr[0] + i7;
        }
        if (i2 != i7) {
            throw new h("Data bytes does not match offset");
        }
        a aVar2 = new a();
        for (max = 0; max < i6; max++) {
            for (a a2 : arrayList) {
                byte[] a3 = a2.a();
                if (max < a3.length) {
                    aVar2.a(a3[max], 8);
                }
            }
        }
        for (max = 0; max < i5; max++) {
            for (a a22 : arrayList) {
                a3 = a22.b();
                if (max < a3.length) {
                    aVar2.a(a3[max], 8);
                }
            }
        }
        if (i == aVar2.b()) {
            return aVar2;
        }
        throw new h("Interleaving error: " + i + " and " + aVar2.b() + " differ.");
    }

    private static b a(String str, String str2) {
        int i = 0;
        if ("Shift_JIS".equals(str2)) {
            return a(str) ? b.KANJI : b.BYTE;
        } else {
            int i2 = 0;
            int i3 = 0;
            while (i < str.length()) {
                int charAt = str.charAt(i);
                if (charAt >= '0' && charAt <= '9') {
                    i3 = 1;
                } else if (a(charAt) == -1) {
                    return b.BYTE;
                } else {
                    i2 = 1;
                }
                i++;
            }
            return i2 != 0 ? b.ALPHANUMERIC : i3 != 0 ? b.NUMERIC : b.BYTE;
        }
    }

    private static com.google.a.d.a.c a(int i, com.google.a.d.a.a aVar) {
        for (int i2 = 1; i2 <= 40; i2++) {
            com.google.a.d.a.c a = com.google.a.d.a.c.a(i2);
            if (a.b() - a.a(aVar).c() >= (i + 7) / 8) {
                return a;
            }
        }
        throw new h("Data too big");
    }

    public static g a(String str, com.google.a.d.a.a aVar, Map map) {
        String str2 = map == null ? null : (String) map.get(com.google.a.b.CHARACTER_SET);
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        b a = a(str, str2);
        a aVar2 = new a();
        if (a == b.BYTE && !"ISO-8859-1".equals(str2)) {
            com.google.a.a.c a2 = com.google.a.a.c.a(str2);
            if (a2 != null) {
                a(a2, aVar2);
            }
        }
        a(a, aVar2);
        a aVar3 = new a();
        a(str, a, aVar3, str2);
        com.google.a.d.a.c a3 = a((a.a(a((aVar2.a() + a.a(com.google.a.d.a.c.a(1))) + aVar3.a(), aVar)) + aVar2.a()) + aVar3.a(), aVar);
        a aVar4 = new a();
        aVar4.a(aVar2);
        a(a == b.BYTE ? aVar3.b() : str.length(), a3, a, aVar4);
        aVar4.a(aVar3);
        e a4 = a3.a(aVar);
        int b = a3.b() - a4.c();
        a(b, aVar4);
        a a5 = a(aVar4, a3.b(), b, a4.b());
        g gVar = new g();
        gVar.a(aVar);
        gVar.a(a);
        gVar.a(a3);
        int c = a3.c();
        b bVar = new b(c, c);
        c = a(a5, aVar, a3, bVar);
        gVar.a(c);
        f.a(a5, aVar, a3, c, bVar);
        gVar.a(bVar);
        return gVar;
    }

    static void a(int i, int i2, int i3, int i4, int[] iArr, int[] iArr2) {
        if (i4 >= i3) {
            throw new h("Block ID too large");
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
            throw new h("EC bytes mismatch");
        } else if (i3 != i6 + i5) {
            throw new h("RS blocks mismatch");
        } else {
            if (i != (i5 * (i10 + i8)) + ((i9 + i7) * i6)) {
                throw new h("Total bytes mismatch");
            } else if (i4 < i6) {
                iArr[0] = i9;
                iArr2[0] = i7;
            } else {
                iArr[0] = i10;
                iArr2[0] = i8;
            }
        }
    }

    static void a(int i, a aVar) {
        int i2 = i << 3;
        if (aVar.a() > i2) {
            throw new h("data bits cannot fit in the QR Code" + aVar.a() + " > " + i2);
        }
        int i3;
        for (i3 = 0; i3 < 4 && aVar.a() < i2; i3++) {
            aVar.a(false);
        }
        i3 = aVar.a() & 7;
        if (i3 > 0) {
            while (i3 < 8) {
                aVar.a(false);
                i3++;
            }
        }
        int b = i - aVar.b();
        for (i3 = 0; i3 < b; i3++) {
            aVar.a((i3 & 1) == 0 ? 236 : 17, 8);
        }
        if (aVar.a() != i2) {
            throw new h("Bits size does not equal capacity");
        }
    }

    static void a(int i, com.google.a.d.a.c cVar, b bVar, a aVar) {
        int a = bVar.a(cVar);
        if (i >= (1 << a)) {
            throw new h(i + " is bigger than " + ((1 << a) - 1));
        }
        aVar.a(i, a);
    }

    private static void a(com.google.a.a.c cVar, a aVar) {
        aVar.a(b.ECI.a(), 4);
        aVar.a(cVar.a(), 8);
    }

    static void a(b bVar, a aVar) {
        aVar.a(bVar.a(), 4);
    }

    static void a(CharSequence charSequence, a aVar) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int charAt = charSequence.charAt(i) - 48;
            if (i + 2 < length) {
                aVar.a(((charAt * 100) + ((charSequence.charAt(i + 1) - 48) * 10)) + (charSequence.charAt(i + 2) - 48), 10);
                i += 3;
            } else if (i + 1 < length) {
                aVar.a((charAt * 10) + (charSequence.charAt(i + 1) - 48), 7);
                i += 2;
            } else {
                aVar.a(charAt, 4);
                i++;
            }
        }
    }

    static void a(String str, a aVar) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            for (int i = 0; i < length; i += 2) {
                int i2 = ((bytes[i] & 255) << 8) | (bytes[i + 1] & 255);
                i2 = (i2 < 33088 || i2 > 40956) ? (i2 < 57408 || i2 > 60351) ? -1 : i2 - 49472 : i2 - 33088;
                if (i2 == -1) {
                    throw new h("Invalid byte sequence");
                }
                aVar.a((i2 & 255) + ((i2 >> 8) * 192), 13);
            }
        } catch (Throwable e) {
            throw new h(e);
        }
    }

    static void a(String str, a aVar, String str2) {
        try {
            for (byte a : str.getBytes(str2)) {
                aVar.a(a, 8);
            }
        } catch (Throwable e) {
            throw new h(e);
        }
    }

    static void a(String str, b bVar, a aVar, String str2) {
        switch (d.a[bVar.ordinal()]) {
            case cm.HListView_android_divider /*1*/:
                a((CharSequence) str, aVar);
            case cm.HListView_hlv_dividerWidth /*2*/:
                b(str, aVar);
            case cm.HListView_hlv_headerDividersEnabled /*3*/:
                a(str, aVar, str2);
            case cm.HListView_hlv_footerDividersEnabled /*4*/:
                a(str, aVar);
            default:
                throw new h("Invalid mode: " + bVar);
        }
    }

    private static boolean a(String str) {
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

    static byte[] a(byte[] bArr, int i) {
        int i2 = 0;
        int length = bArr.length;
        int[] iArr = new int[(length + i)];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & 255;
        }
        new com.google.a.a.a.c(com.google.a.a.a.a.e).a(iArr, i);
        byte[] bArr2 = new byte[i];
        while (i2 < i) {
            bArr2[i2] = (byte) iArr[length + i2];
            i2++;
        }
        return bArr2;
    }

    static void b(CharSequence charSequence, a aVar) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int a = a(charSequence.charAt(i));
            if (a == -1) {
                throw new h();
            } else if (i + 1 < length) {
                int a2 = a(charSequence.charAt(i + 1));
                if (a2 == -1) {
                    throw new h();
                }
                aVar.a((a * 45) + a2, 11);
                i += 2;
            } else {
                aVar.a(a, 6);
                i++;
            }
        }
    }
}
