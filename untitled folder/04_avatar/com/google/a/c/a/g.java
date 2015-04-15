package com.google.a.c.a;

import com.google.a.h;
import com.google.android.apps.androidify.cm;
import java.math.BigInteger;
import java.util.Arrays;

final class g {
    private static final byte[] a;
    private static final byte[] b;
    private static final byte[] c;
    private static final byte[] d;

    static {
        byte b;
        byte b2 = (byte) 0;
        a = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 38, (byte) 13, (byte) 9, (byte) 44, (byte) 58, (byte) 35, (byte) 45, (byte) 46, (byte) 36, (byte) 47, (byte) 43, (byte) 37, (byte) 42, (byte) 61, (byte) 94, (byte) 0, (byte) 32, (byte) 0, (byte) 0, (byte) 0};
        b = new byte[]{(byte) 59, (byte) 60, (byte) 62, (byte) 64, (byte) 91, (byte) 92, (byte) 93, (byte) 95, (byte) 96, (byte) 126, (byte) 33, (byte) 13, (byte) 9, (byte) 44, (byte) 58, (byte) 10, (byte) 45, (byte) 46, (byte) 36, (byte) 47, (byte) 34, (byte) 124, (byte) 42, (byte) 40, (byte) 41, (byte) 63, (byte) 123, (byte) 125, (byte) 39, (byte) 0};
        c = new byte[128];
        d = new byte[128];
        Arrays.fill(c, (byte) -1);
        for (b = (byte) 0; b < a.length; b = (byte) (b + 1)) {
            byte b3 = a[b];
            if (b3 > null) {
                c[b3] = b;
            }
        }
        Arrays.fill(d, (byte) -1);
        while (b2 < b.length) {
            b = b[b2];
            if (b > null) {
                d[b] = b2;
            }
            b2 = (byte) (b2 + 1);
        }
    }

    private static int a(CharSequence charSequence, int i) {
        int i2 = 0;
        int length = charSequence.length();
        if (i < length) {
            char charAt = charSequence.charAt(i);
            while (a(charAt) && i < length) {
                i2++;
                i++;
                if (i < length) {
                    charAt = charSequence.charAt(i);
                }
            }
        }
        return i2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int a(CharSequence charSequence, int i, int i2, StringBuilder stringBuilder, int i3) {
        StringBuilder stringBuilder2 = new StringBuilder(i2);
        int i4 = 0;
        while (true) {
            char charAt = charSequence.charAt(i + i4);
            switch (i3) {
                case cm.HListView_android_entries /*0*/:
                    if (b(charAt)) {
                        if (charAt == ' ') {
                            stringBuilder2.append('\u001a');
                        } else {
                            stringBuilder2.append((char) (charAt - 65));
                        }
                    } else if (c(charAt)) {
                        stringBuilder2.append('\u001b');
                        i3 = 1;
                        break;
                    } else if (d(charAt)) {
                        i3 = 2;
                        stringBuilder2.append('\u001c');
                        break;
                    } else {
                        stringBuilder2.append('\u001d');
                        stringBuilder2.append((char) d[charAt]);
                    }
                case cm.HListView_android_divider /*1*/:
                    if (c(charAt)) {
                        if (charAt == ' ') {
                            stringBuilder2.append('\u001a');
                        } else {
                            stringBuilder2.append((char) (charAt - 97));
                        }
                    } else if (b(charAt)) {
                        stringBuilder2.append('\u001b');
                        stringBuilder2.append((char) (charAt - 65));
                    } else if (d(charAt)) {
                        i3 = 2;
                        stringBuilder2.append('\u001c');
                        break;
                    } else {
                        stringBuilder2.append('\u001d');
                        stringBuilder2.append((char) d[charAt]);
                    }
                case cm.HListView_hlv_dividerWidth /*2*/:
                    if (!d(charAt)) {
                        if (!b(charAt)) {
                            if (!c(charAt)) {
                                if ((i + i4) + 1 < i2 && e(charSequence.charAt((i + i4) + 1))) {
                                    i3 = 3;
                                    stringBuilder2.append('\u0019');
                                    break;
                                }
                                stringBuilder2.append('\u001d');
                                stringBuilder2.append((char) d[charAt]);
                            } else {
                                stringBuilder2.append('\u001b');
                                i3 = 1;
                                break;
                            }
                        }
                        stringBuilder2.append('\u001c');
                        i3 = 0;
                        break;
                    }
                    stringBuilder2.append((char) c[charAt]);
                    break;
                default:
                    if (!e(charAt)) {
                        stringBuilder2.append('\u001d');
                        i3 = 0;
                        break;
                    }
                    stringBuilder2.append((char) d[charAt]);
                    i4++;
                    if (i4 < i2) {
                        break;
                    }
                    int length = stringBuilder2.length();
                    int i5 = 0;
                    int i6 = 0;
                    while (i5 < length) {
                        char charAt2;
                        if ((i5 % 2 != 0 ? 1 : null) != null) {
                            charAt2 = (char) ((i6 * 30) + stringBuilder2.charAt(i5));
                            stringBuilder.append(charAt2);
                        } else {
                            charAt2 = stringBuilder2.charAt(i5);
                        }
                        i5++;
                        char c = charAt2;
                    }
                    if (length % 2 != 0) {
                        stringBuilder.append((char) ((i6 * 30) + 29));
                    }
                    return i3;
            }
        }
    }

    private static int a(CharSequence charSequence, byte[] bArr, int i) {
        int length = charSequence.length();
        int i2 = i;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            int i3 = 0;
            while (i3 < 13 && a(charAt)) {
                i3++;
                int i4 = i2 + i3;
                if (i4 >= length) {
                    break;
                }
                charAt = charSequence.charAt(i4);
            }
            if (i3 >= 13) {
                return i2 - i;
            }
            char c = charAt;
            int i5 = 0;
            while (i5 < 5 && f(r2)) {
                i5++;
                i3 = i2 + i5;
                if (i3 >= length) {
                    break;
                }
                c = charSequence.charAt(i3);
            }
            if (i5 >= 5) {
                return i2 - i;
            }
            charAt = charSequence.charAt(i2);
            if (bArr[i2] != (byte) 63 || charAt == '?') {
                i2++;
            } else {
                throw new h("Non-encodable character detected: " + charAt + " (Unicode: " + charAt + ')');
            }
        }
        return i2 - i;
    }

    static String a(String str, c cVar) {
        byte[] bArr = null;
        StringBuilder stringBuilder = new StringBuilder(str.length());
        int length = str.length();
        if (cVar == c.TEXT) {
            a((CharSequence) str, 0, length, stringBuilder, 0);
        } else if (cVar == c.BYTE) {
            bArr = a(str);
            a(bArr, 0, bArr.length, 1, stringBuilder);
        } else if (cVar == c.NUMERIC) {
            stringBuilder.append('\u0386');
            a(str, 0, length, stringBuilder);
        } else {
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (i3 < length) {
                byte[] bArr2;
                int i4;
                int i5;
                int a = a((CharSequence) str, i3);
                if (a >= 13) {
                    stringBuilder.append('\u0386');
                    i = 2;
                    a(str, i3, a, stringBuilder);
                    i2 = i3 + a;
                    bArr2 = bArr;
                    i4 = i2;
                    i2 = 0;
                } else {
                    int b = b(str, i3);
                    if (b >= 5 || a == length) {
                        if (i != 0) {
                            stringBuilder.append('\u0384');
                            i = 0;
                            i2 = 0;
                        }
                        i2 = a((CharSequence) str, i3, b, stringBuilder, i2);
                        i5 = i3 + b;
                        bArr2 = bArr;
                        i4 = i5;
                    } else {
                        if (bArr == null) {
                            bArr = a(str);
                        }
                        a = a(str, bArr, i3);
                        if (a == 0) {
                            a = 1;
                        }
                        if (a == 1 && i == 0) {
                            a(bArr, i3, 1, 0, stringBuilder);
                        } else {
                            a(bArr, i3, a, i, stringBuilder);
                            i = 1;
                            i2 = 0;
                        }
                        i5 = i3 + a;
                        bArr2 = bArr;
                        i4 = i5;
                    }
                }
                i5 = i4;
                bArr = bArr2;
                i3 = i5;
            }
        }
        return stringBuilder.toString();
    }

    private static void a(String str, int i, int i2, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder((i2 / 3) + 1);
        BigInteger valueOf = BigInteger.valueOf(900);
        BigInteger valueOf2 = BigInteger.valueOf(0);
        int i3 = 0;
        while (i3 < i2 - 1) {
            stringBuilder2.setLength(0);
            int min = Math.min(44, i2 - i3);
            BigInteger bigInteger = new BigInteger('1' + str.substring(i + i3, (i + i3) + min));
            do {
                stringBuilder2.append((char) bigInteger.mod(valueOf).intValue());
                bigInteger = bigInteger.divide(valueOf);
            } while (!bigInteger.equals(valueOf2));
            for (int length = stringBuilder2.length() - 1; length >= 0; length--) {
                stringBuilder.append(stringBuilder2.charAt(length));
            }
            i3 += min;
        }
    }

    private static void a(byte[] bArr, int i, int i2, int i3, StringBuilder stringBuilder) {
        int i4;
        if (i2 == 1 && i3 == 0) {
            stringBuilder.append('\u0391');
        }
        if (i2 >= 6) {
            stringBuilder.append('\u039c');
            char[] cArr = new char[5];
            i4 = i;
            while ((i + i2) - i4 >= 6) {
                int i5;
                long j = 0;
                for (i5 = 0; i5 < 6; i5++) {
                    j = (j << 8) + ((long) (bArr[i4 + i5] & 255));
                }
                for (i5 = 0; i5 < 5; i5++) {
                    cArr[i5] = (char) ((int) (j % 900));
                    j /= 900;
                }
                for (i5 = cArr.length - 1; i5 >= 0; i5--) {
                    stringBuilder.append(cArr[i5]);
                }
                i4 += 6;
            }
        } else {
            i4 = i;
        }
        if (i4 < i + i2) {
            stringBuilder.append('\u0385');
        }
        while (i4 < i + i2) {
            stringBuilder.append((char) (bArr[i4] & 255));
            i4++;
        }
    }

    private static boolean a(char c) {
        return c >= '0' && c <= '9';
    }

    private static byte[] a(String str) {
        return str.getBytes();
    }

    private static int b(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = i;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            int i3 = 0;
            while (i3 < 13 && a(r2) && i2 < length) {
                i3++;
                int i4 = i2 + 1;
                if (i4 < length) {
                    charAt = charSequence.charAt(i4);
                    i2 = i4;
                } else {
                    i2 = i4;
                }
            }
            if (i3 >= 13) {
                return (i2 - i) - i3;
            }
            if (i3 <= 0) {
                if (!f(charSequence.charAt(i2))) {
                    break;
                }
                i2++;
            }
        }
        return i2 - i;
    }

    private static boolean b(char c) {
        return c == ' ' || (c >= 'A' && c <= 'Z');
    }

    private static boolean c(char c) {
        return c == ' ' || (c >= 'a' && c <= 'z');
    }

    private static boolean d(char c) {
        return c[c] != -1;
    }

    private static boolean e(char c) {
        return d[c] != -1;
    }

    private static boolean f(char c) {
        return c == '\t' || c == '\n' || c == '\r' || (c >= ' ' && c <= '~');
    }
}
