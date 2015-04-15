package com.google.a.b;

import com.google.a.a;
import com.google.a.a.b;
import java.util.Map;

public final class f extends m {
    private static void a(int i, int[] iArr) {
        for (int i2 = 0; i2 < 9; i2++) {
            iArr[i2] = ((1 << i2) & i) == 0 ? 1 : 2;
        }
    }

    public b a(String str, a aVar, int i, int i2, Map map) {
        if (aVar == a.CODE_39) {
            return super.a(str, aVar, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_39, but got " + aVar);
    }

    public boolean[] a(String str) {
        int length = str.length();
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
        }
        int i;
        int[] iArr = new int[9];
        int i2 = length + 25;
        int i3 = 0;
        while (i3 < length) {
            a(e.a["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(str.charAt(i3))], iArr);
            i = i2;
            for (int i4 : iArr) {
                i += i4;
            }
            i3++;
            i2 = i;
        }
        boolean[] zArr = new boolean[i2];
        a(e.a[39], iArr);
        i2 = m.a(zArr, 0, iArr, true);
        int[] iArr2 = new int[]{1};
        i = m.a(zArr, i2, iArr2, false) + i2;
        for (i2 = length - 1; i2 >= 0; i2--) {
            a(e.a["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(str.charAt(i2))], iArr);
            i += m.a(zArr, i, iArr, true);
            i += m.a(zArr, i, iArr2, false);
        }
        a(e.a[39], iArr);
        i2 = m.a(zArr, i, iArr, true) + i;
        return zArr;
    }
}
