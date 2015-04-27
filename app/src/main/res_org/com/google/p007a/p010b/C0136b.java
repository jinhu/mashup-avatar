package com.google.p007a.p010b;

import java.util.Arrays;

/* renamed from: com.google.a.b.b */
public final class C0136b extends C0135m {
    private static final char[] f504a;
    private static final char[] f505b;

    static {
        f504a = new char[]{'A', 'B', 'C', 'D'};
        f505b = new char[]{'T', 'N', '*', 'E'};
    }

    public boolean[] m958a(String str) {
        if (!C0133a.m951a(f504a, Character.toUpperCase(str.charAt(0)))) {
            throw new IllegalArgumentException("Codabar should start with one of the following: " + Arrays.toString(f504a));
        } else if (C0133a.m951a(f505b, Character.toUpperCase(str.charAt(str.length() - 1)))) {
            char[] cArr = new char[]{'/', ':', '+', '.'};
            int i = 20;
            int i2 = 1;
            while (i2 < str.length() - 1) {
                if (Character.isDigit(str.charAt(i2)) || str.charAt(i2) == '-' || str.charAt(i2) == '$') {
                    i += 9;
                } else if (C0133a.m951a(cArr, str.charAt(i2))) {
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
                while (i6 < C0133a.f501a.length) {
                    if (toUpperCase == C0133a.f501a[i6]) {
                        i3 = C0133a.f502b[i6];
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
            throw new IllegalArgumentException("Codabar should end with one of the following: " + Arrays.toString(f505b));
        }
    }
}
