package com.google.a.d.b;

import com.google.android.apps.androidify.cm;

final class e {
    static int a(b bVar) {
        return a(bVar, true) + a(bVar, false);
    }

    private static int a(b bVar, boolean z) {
        int a = z ? bVar.a() : bVar.b();
        int b = z ? bVar.b() : bVar.a();
        byte[][] c = bVar.c();
        int i = 0;
        int i2 = 0;
        while (i < a) {
            Object obj = -1;
            int i3 = 0;
            int i4 = 0;
            while (i3 < b) {
                int i5;
                int i6;
                byte b2;
                byte b3 = z ? c[i][i3] : c[i3][i];
                if (b3 == obj) {
                    Object obj2 = obj;
                    i5 = i4 + 1;
                    i6 = i2;
                    b2 = obj2;
                } else {
                    if (i4 >= 5) {
                        i2 += (i4 - 5) + 3;
                    }
                    i5 = 1;
                    byte b4 = b3;
                    i6 = i2;
                    b2 = b4;
                }
                i3++;
                i4 = i5;
                obj = b2;
                i2 = i6;
            }
            if (i4 > 5) {
                i2 += (i4 - 5) + 3;
            }
            i++;
        }
        return i2;
    }

    static boolean a(int i, int i2, int i3) {
        int i4;
        switch (i) {
            case cm.HListView_android_entries /*0*/:
                i4 = (i3 + i2) & 1;
                break;
            case cm.HListView_android_divider /*1*/:
                i4 = i3 & 1;
                break;
            case cm.HListView_hlv_dividerWidth /*2*/:
                i4 = i2 % 3;
                break;
            case cm.HListView_hlv_headerDividersEnabled /*3*/:
                i4 = (i3 + i2) % 3;
                break;
            case cm.HListView_hlv_footerDividersEnabled /*4*/:
                i4 = ((i3 >>> 1) + (i2 / 3)) & 1;
                break;
            case cm.HListView_hlv_overScrollHeader /*5*/:
                i4 = i3 * i2;
                i4 = (i4 % 3) + (i4 & 1);
                break;
            case cm.HListView_hlv_overScrollFooter /*6*/:
                i4 = i3 * i2;
                i4 = ((i4 % 3) + (i4 & 1)) & 1;
                break;
            case cm.HListView_hlv_measureWithChild /*7*/:
                i4 = (((i3 * i2) % 3) + ((i3 + i2) & 1)) & 1;
                break;
            default:
                throw new IllegalArgumentException("Invalid mask pattern: " + i);
        }
        return i4 == 0;
    }

    static int b(b bVar) {
        byte[][] c = bVar.c();
        int b = bVar.b();
        int a = bVar.a();
        int i = 0;
        int i2 = 0;
        while (i < a - 1) {
            int i3 = 0;
            while (i3 < b - 1) {
                byte b2 = c[i][i3];
                if (b2 == c[i][i3 + 1] && b2 == c[i + 1][i3] && b2 == c[i + 1][i3 + 1]) {
                    i2++;
                }
                i3++;
            }
            i++;
        }
        return i2 * 3;
    }

    static int c(b bVar) {
        byte[][] c = bVar.c();
        int b = bVar.b();
        int a = bVar.a();
        int i = 0;
        int i2 = 0;
        while (i < a) {
            int i3 = 0;
            while (i3 < b) {
                if (i3 + 6 < b && c[i][i3] == (byte) 1 && c[i][i3 + 1] == null && c[i][i3 + 2] == (byte) 1 && c[i][i3 + 3] == (byte) 1 && c[i][i3 + 4] == (byte) 1 && c[i][i3 + 5] == null && c[i][i3 + 6] == (byte) 1 && ((i3 + 10 < b && c[i][i3 + 7] == null && c[i][i3 + 8] == null && c[i][i3 + 9] == null && c[i][i3 + 10] == null) || (i3 - 4 >= 0 && c[i][i3 - 1] == null && c[i][i3 - 2] == null && c[i][i3 - 3] == null && c[i][i3 - 4] == null))) {
                    i2 += 40;
                }
                if (i + 6 < a && c[i][i3] == (byte) 1 && c[i + 1][i3] == null && c[i + 2][i3] == (byte) 1 && c[i + 3][i3] == (byte) 1 && c[i + 4][i3] == (byte) 1 && c[i + 5][i3] == null && c[i + 6][i3] == (byte) 1 && ((i + 10 < a && c[i + 7][i3] == null && c[i + 8][i3] == null && c[i + 9][i3] == null && c[i + 10][i3] == null) || (i - 4 >= 0 && c[i - 1][i3] == null && c[i - 2][i3] == null && c[i - 3][i3] == null && c[i - 4][i3] == null))) {
                    i2 += 40;
                }
                i3++;
            }
            i++;
        }
        return i2;
    }

    static int d(b bVar) {
        byte[][] c = bVar.c();
        int b = bVar.b();
        int a = bVar.a();
        int i = 0;
        for (int i2 = 0; i2 < a; i2++) {
            byte[] bArr = c[i2];
            for (int i3 = 0; i3 < b; i3++) {
                if (bArr[i3] == 1) {
                    i++;
                }
            }
        }
        return ((int) (Math.abs((((double) i) / ((double) (bVar.a() * bVar.b()))) - 0.5d) * 20.0d)) * 10;
    }
}