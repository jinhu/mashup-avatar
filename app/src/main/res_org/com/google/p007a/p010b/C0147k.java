package com.google.p007a.p010b;

import com.google.p007a.C0131a;
import com.google.p007a.p008a.C0129b;
import java.util.Map;

/* renamed from: com.google.a.b.k */
public final class C0147k extends C0135m {
    private static final int[] f519a;
    private static final int[] f520b;

    static {
        f519a = new int[]{1, 1, 1, 1};
        f520b = new int[]{3, 1, 1};
    }

    public C0129b m971a(String str, C0131a c0131a, int i, int i2, Map map) {
        if (c0131a == C0131a.ITF) {
            return super.m956a(str, c0131a, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode ITF, but got " + c0131a);
    }

    public boolean[] m972a(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("The lenght of the input should be even");
        } else if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
        } else {
            boolean[] zArr = new boolean[((length * 9) + 9)];
            int a = C0135m.m953a(zArr, 0, f519a, true);
            for (int i = 0; i < length; i += 2) {
                int digit = Character.digit(str.charAt(i), 10);
                int digit2 = Character.digit(str.charAt(i + 1), 10);
                int[] iArr = new int[18];
                for (int i2 = 0; i2 < 5; i2++) {
                    iArr[i2 << 1] = C0146j.f515a[digit][i2];
                    iArr[(i2 << 1) + 1] = C0146j.f515a[digit2][i2];
                }
                a += C0135m.m953a(zArr, a, iArr, true);
            }
            C0135m.m953a(zArr, a, f520b, true);
            return zArr;
        }
    }
}
