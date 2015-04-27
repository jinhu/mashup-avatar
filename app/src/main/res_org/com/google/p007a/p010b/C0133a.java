package com.google.p007a.p010b;

/* renamed from: com.google.a.b.a */
public final class C0133a extends C0132l {
    static final char[] f501a;
    static final int[] f502b;
    private static final char[] f503c;

    static {
        f501a = "0123456789-$:/.+ABCD".toCharArray();
        f502b = new int[]{3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};
        f503c = new char[]{'A', 'B', 'C', 'D'};
    }

    static boolean m951a(char[] cArr, char c) {
        if (cArr == null) {
            return false;
        }
        for (char c2 : cArr) {
            if (c2 == c) {
                return true;
            }
        }
        return false;
    }
}
