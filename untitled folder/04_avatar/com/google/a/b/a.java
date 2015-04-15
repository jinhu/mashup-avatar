package com.google.a.b;

public final class a extends l {
    static final char[] a;
    static final int[] b;
    private static final char[] c;

    static {
        a = "0123456789-$:/.+ABCD".toCharArray();
        b = new int[]{3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};
        c = new char[]{'A', 'B', 'C', 'D'};
    }

    static boolean a(char[] cArr, char c) {
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
