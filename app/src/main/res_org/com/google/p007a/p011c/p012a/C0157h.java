package com.google.p007a.p011c.p012a;

import com.google.p007a.C0131a;
import com.google.p007a.C0134g;
import com.google.p007a.C0149b;
import com.google.p007a.p008a.C0129b;
import java.lang.reflect.Array;
import java.util.Map;

/* renamed from: com.google.a.c.a.h */
public final class C0157h implements C0134g {
    private static C0129b m1011a(C0154e c0154e, String str, int i, int i2) {
        int i3;
        c0154e.m992a(str, 2);
        byte[][] a = c0154e.m989a().m976a(2, 8);
        if (((i2 > i ? 1 : 0) ^ (a[0].length < a.length ? 1 : 0)) != 0) {
            a = C0157h.m1013b(a);
            i3 = 1;
        } else {
            i3 = 0;
        }
        int length = i / a[0].length;
        int length2 = i2 / a.length;
        if (length >= length2) {
            length = length2;
        }
        if (length <= 1) {
            return C0157h.m1012a(a);
        }
        byte[][] a2 = c0154e.m989a().m976a(length * 2, (length * 4) * 2);
        return C0157h.m1012a(i3 != 0 ? C0157h.m1013b(a2) : a2);
    }

    private static C0129b m1012a(byte[][] bArr) {
        C0129b c0129b = new C0129b(bArr[0].length + 60, bArr.length + 60);
        c0129b.m943a();
        int c = c0129b.m948c() - 30;
        int i = 0;
        while (i < bArr.length) {
            for (int i2 = 0; i2 < bArr[0].length; i2++) {
                if (bArr[i][i2] == 1) {
                    c0129b.m947b(i2 + 30, c);
                }
            }
            i++;
            c--;
        }
        return c0129b;
    }

    private static byte[][] m1013b(byte[][] bArr) {
        byte[][] bArr2 = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{bArr[0].length, bArr.length});
        for (int i = 0; i < bArr.length; i++) {
            int length = (bArr.length - i) - 1;
            for (int i2 = 0; i2 < bArr[0].length; i2++) {
                bArr2[i2][length] = bArr[i][i2];
            }
        }
        return bArr2;
    }

    public C0129b m1014a(String str, C0131a c0131a, int i, int i2, Map map) {
        if (c0131a != C0131a.PDF_417) {
            throw new IllegalArgumentException("Can only encode PDF_417, but got " + c0131a);
        }
        C0154e c0154e = new C0154e();
        if (map != null) {
            if (map.containsKey(C0149b.PDF417_COMPACT)) {
                c0154e.m993a(((Boolean) map.get(C0149b.PDF417_COMPACT)).booleanValue());
            }
            if (map.containsKey(C0149b.PDF417_COMPACTION)) {
                c0154e.m991a((C0152c) map.get(C0149b.PDF417_COMPACTION));
            }
            if (map.containsKey(C0149b.PDF417_DIMENSIONS)) {
                C0153d c0153d = (C0153d) map.get(C0149b.PDF417_DIMENSIONS);
                c0154e.m990a(c0153d.m982b(), c0153d.m981a(), c0153d.m984d(), c0153d.m983c());
            }
        }
        return C0157h.m1011a(c0154e, str, i, i2);
    }
}
