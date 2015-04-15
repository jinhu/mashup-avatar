package com.google.a.b;

import java.util.Arrays;

public final class b extends m {
    private static final char[] a;
    private static final char[] b;

    static {
        a = new char[]{'A', 'B', 'C', 'D'};
        b = new char[]{'T', 'N', '*', 'E'};
    }

    public boolean[] a(String str) {
        if (!a.a(a, Character.toUpperCase(str.charAt(0)))) {
            throw new IllegalArgumentException("Codabar should start with one of the following: " + Arrays.toString(a));
        } else if (a.a(b, Character.toUpperCase(str.charAt(str.length() - 1)))) {
            char[] cArr = new char[]{'/', ':', '+', '.'};
            int i = 20;
            int i2 = 1;
            while (i2 < str.length() - 1) {
                if (Character.isDigit(str.charAt(i2)) || str.charAt(i2) == '-' || str.charAt(i2) == '$') {
                    i += 9;
                } else if (a.a(cArr, str.charAt(i2))) {
                    i += 10;
                } else {
                    throw new IllegalArgumentException("Cannot encode : '" + str.charAt(i2) + '\'');
                }
                i2++;
            }
            boolean[] zArr = new boolean[((str.length() - 1) + i)];
            i = 0;
            for (i2 = 0; i2 < str.length(); i2++) {
                int i3;
                int i4;
                boolean z;
                int i5;
                char toUpperCase = Character.toUpperCase(str.charAt(i2));
                if (i2 == str.length() - 1) {
                    switch (toUpperCase) {
                        case '*':
                            toUpperCase = 'C';
                            break;
                        case 'E':
                            toUpperCase = 'D';
                            break;
                        case 'N':
                            toUpperCase = 'B';
                            break;
                        case 'T':
                            toUpperCase = 'A';
                            break;
                    }
                }
                int i6 = 0;
                while (i6 < a.a.length) {
                    if (toUpperCase == a.a[i6]) {
                        i3 = a.b[i6];
                        i6 = 0;
                        i4 = 0;
                        z = true;
                        while (i6 < 7) {
                            zArr[i] = z;
                            i5 = i + 1;
                            if (((i3 >> (6 - i6)) & 1) != 0 || i4 == 1) {
                                i6++;
                                i4 = 0;
                                z = z;
                                i = i5;
                            } else {
                                i4++;
                                i = i5;
                            }
                        }
                        if (i2 < str.length() - 1) {
                            zArr[i] = false;
                            i++;
                        }
                    } else {
                        i6++;
                    }
                }
                i3 = 0;
                i6 = 0;
                i4 = 0;
                z = true;
                while (i6 < 7) {
                    zArr[i] = z;
                    i5 = i + 1;
                    if (((i3 >> (6 - i6)) & 1) != 0) {
                    }
                    if (z) {
                    }
                    i6++;
                    i4 = 0;
                    z = z;
                    i = i5;
                }
                if (i2 < str.length() - 1) {
                    zArr[i] = false;
                    i++;
                }
            }
            return zArr;
        } else {
            throw new IllegalArgumentException("Codabar should end with one of the following: " + Arrays.toString(b));
        }
    }
}
