package com.google.a.b;

import com.google.a.a;
import com.google.a.a.b;
import java.util.Map;

public final class k extends m {
    private static final int[] a;
    private static final int[] b;

    static {
        a = new int[]{1, 1, 1, 1};
        b = new int[]{3, 1, 1};
    }

    public b a(String str, a aVar, int i, int i2, Map map) {
        if (aVar == a.ITF) {
            return super.a(str, aVar, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode ITF, but got " + aVar);
    }

    public boolean[] a(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("The lenght of the input should be even");
        } else if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
        } else {
            boolean[] zArr = new boolean[((length * 9) + 9)];
            int a = m.a(zArr, 0, a, true);
            for (int i = 0; i < length; i += 2) {
                int digit = Character.digit(str.charAt(i), 10);
                int digit2 = Character.digit(str.charAt(i + 1), 10);
                int[] iArr = new int[18];
                for (int i2 = 0; i2 < 5; i2++) {
                    iArr[i2 << 1] = j.a[digit][i2];
                    iArr[(i2 << 1) + 1] = j.a[digit2][i2];
                }
                a += m.a(zArr, a, iArr, true);
            }
            m.a(zArr, a, b, true);
            return zArr;
        }
    }
}
