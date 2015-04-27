package com.google.p007a.p010b;

import com.google.p007a.C0131a;
import com.google.p007a.p008a.C0129b;
import java.util.Map;

/* renamed from: com.google.a.b.f */
public final class C0140f extends C0135m {
    private static void m962a(int i, int[] iArr) {
        for (int i2 = 0; i2 < 9; i2++) {
            iArr[i2] = ((1 << i2) & i) == 0 ? 1 : 2;
        }
    }

    public C0129b m963a(String str, C0131a c0131a, int i, int i2, Map map) {
        if (c0131a == C0131a.CODE_39) {
            return super.m956a(str, c0131a, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_39, but got " + c0131a);
    }

    public boolean[] m964a(String str) {
        int length = str.length();
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
        }
        int i;
        int[] iArr = new int[9];
        int i2 = length + 25;
        int i3 = 0;
        while (i3 < length) {
            C0140f.m962a(C0139e.f507a["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(str.charAt(i3))], iArr);
            i = i2;
            for (int i4 : iArr) {
                i += i4;
            }
            i3++;
            i2 = i;
        }
        boolean[] zArr = new boolean[i2];
        C0140f.m962a(C0139e.f507a[39], iArr);
        i2 = C0135m.m953a(zArr, 0, iArr, true);
        int[] iArr2 = new int[]{1};
        i = C0135m.m953a(zArr, i2, iArr2, false) + i2;
        for (i2 = length - 1; i2 >= 0; i2--) {
            C0140f.m962a(C0139e.f507a["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(str.charAt(i2))], iArr);
            i += C0135m.m953a(zArr, i, iArr, true);
            i += C0135m.m953a(zArr, i, iArr2, false);
        }
        C0140f.m962a(C0139e.f507a[39], iArr);
        i2 = C0135m.m953a(zArr, i, iArr, true) + i;
        return zArr;
    }
}
