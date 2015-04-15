package com.google.a.b;

import com.google.a.c;

public abstract class o extends l {
    static final int[] b;
    static final int[] c;
    static final int[][] d;
    static final int[][] e;

    static {
        b = new int[]{1, 1, 1};
        c = new int[]{1, 1, 1, 1, 1};
        d = new int[][]{new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        e = new int[20][];
        System.arraycopy(d, 0, e, 0, 10);
        for (int i = 10; i < 20; i++) {
            int[] iArr = d[i - 10];
            int[] iArr2 = new int[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                iArr2[i2] = iArr[(iArr.length - i2) - 1];
            }
            e[i] = iArr2;
        }
    }

    static boolean a(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i;
        int i2 = 0;
        for (i = length - 2; i >= 0; i -= 2) {
            int charAt = charSequence.charAt(i) - 48;
            if (charAt < 0 || charAt > 9) {
                throw c.a();
            }
            i2 += charAt;
        }
        i2 *= 3;
        for (i = length - 1; i >= 0; i -= 2) {
            length = charSequence.charAt(i) - 48;
            if (length < 0 || length > 9) {
                throw c.a();
            }
            i2 += length;
        }
        return i2 % 10 == 0;
    }
}
