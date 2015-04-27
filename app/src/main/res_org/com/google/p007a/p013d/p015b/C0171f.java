package com.google.p007a.p013d.p015b;

import com.google.p007a.C0175h;
import com.google.p007a.p008a.C0128a;
import com.google.p007a.p013d.p014a.C0160a;
import com.google.p007a.p013d.p014a.C0162c;

/* renamed from: com.google.a.d.b.f */
final class C0171f {
    private static final int[][] f595a;
    private static final int[][] f596b;
    private static final int[][] f597c;
    private static final int[][] f598d;

    static {
        f595a = new int[][]{new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
        f596b = new int[][]{new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
        f597c = new int[][]{new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};
        f598d = new int[][]{new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};
    }

    static int m1067a(int i) {
        int i2 = 0;
        while (i != 0) {
            i >>>= 1;
            i2++;
        }
        return i2;
    }

    static int m1068a(int i, int i2) {
        int a = C0171f.m1067a(i2);
        int i3 = i << (a - 1);
        while (C0171f.m1067a(i3) >= a) {
            i3 ^= i2 << (C0171f.m1067a(i3) - a);
        }
        return i3;
    }

    private static void m1069a(int i, int i2, C0167b c0167b) {
        int i3 = 0;
        while (i3 < 8) {
            if (C0171f.m1080b(c0167b.m1035a(i + i3, i2))) {
                c0167b.m1038a(i + i3, i2, 0);
                i3++;
            } else {
                throw new C0175h();
            }
        }
    }

    static void m1070a(C0128a c0128a, int i, C0167b c0167b) {
        int b = c0167b.m1040b() - 1;
        int a = c0167b.m1036a() - 1;
        int i2 = -1;
        int i3 = 0;
        while (b > 0) {
            int i4;
            int i5;
            if (b == 6) {
                i4 = a;
                i5 = b - 1;
                a = i3;
            } else {
                i4 = a;
                i5 = b;
                a = i3;
            }
            while (i4 >= 0 && i4 < c0167b.m1036a()) {
                for (i3 = 0; i3 < 2; i3++) {
                    int i6 = i5 - i3;
                    if (C0171f.m1080b(c0167b.m1035a(i6, i4))) {
                        boolean a2;
                        if (a < c0128a.m935a()) {
                            b = a + 1;
                            a2 = c0128a.m940a(a);
                        } else {
                            b = a;
                            a2 = false;
                        }
                        if (i != -1 && C0170e.m1063a(i, i6, i4)) {
                            a2 = !a2;
                        }
                        c0167b.m1039a(i6, i4, a2);
                        a = b;
                    }
                }
                i4 += i2;
            }
            i2 = -i2;
            b = i5 - 2;
            i3 = a;
            a = i4 + i2;
        }
        if (i3 != c0128a.m935a()) {
            throw new C0175h("Not all bits consumed: " + i3 + '/' + c0128a.m935a());
        }
    }

    static void m1071a(C0128a c0128a, C0160a c0160a, C0162c c0162c, int i, C0167b c0167b) {
        C0171f.m1076a(c0167b);
        C0171f.m1075a(c0162c, c0167b);
        C0171f.m1073a(c0160a, i, c0167b);
        C0171f.m1078b(c0162c, c0167b);
        C0171f.m1070a(c0128a, i, c0167b);
    }

    static void m1072a(C0160a c0160a, int i, C0128a c0128a) {
        if (C0172g.m1086b(i)) {
            int a = (c0160a.m1016a() << 3) | i;
            c0128a.m936a(a, 5);
            c0128a.m936a(C0171f.m1068a(a, 1335), 10);
            C0128a c0128a2 = new C0128a();
            c0128a2.m936a(21522, 15);
            c0128a.m942b(c0128a2);
            if (c0128a.m935a() != 15) {
                throw new C0175h("should not happen but we got: " + c0128a.m935a());
            }
            return;
        }
        throw new C0175h("Invalid mask pattern");
    }

    static void m1073a(C0160a c0160a, int i, C0167b c0167b) {
        C0128a c0128a = new C0128a();
        C0171f.m1072a(c0160a, i, c0128a);
        for (int i2 = 0; i2 < c0128a.m935a(); i2++) {
            boolean a = c0128a.m940a((c0128a.m935a() - 1) - i2);
            c0167b.m1039a(f598d[i2][0], f598d[i2][1], a);
            if (i2 < 8) {
                c0167b.m1039a((c0167b.m1040b() - i2) - 1, 8, a);
            } else {
                c0167b.m1039a(8, (c0167b.m1036a() - 7) + (i2 - 8), a);
            }
        }
    }

    static void m1074a(C0162c c0162c, C0128a c0128a) {
        c0128a.m936a(c0162c.m1021a(), 6);
        c0128a.m936a(C0171f.m1068a(c0162c.m1021a(), 7973), 12);
        if (c0128a.m935a() != 18) {
            throw new C0175h("should not happen but we got: " + c0128a.m935a());
        }
    }

    static void m1075a(C0162c c0162c, C0167b c0167b) {
        C0171f.m1085d(c0167b);
        C0171f.m1083c(c0167b);
        C0171f.m1082c(c0162c, c0167b);
        C0171f.m1079b(c0167b);
    }

    static void m1076a(C0167b c0167b) {
        c0167b.m1037a((byte) -1);
    }

    private static void m1077b(int i, int i2, C0167b c0167b) {
        int i3 = 0;
        while (i3 < 7) {
            if (C0171f.m1080b(c0167b.m1035a(i, i2 + i3))) {
                c0167b.m1038a(i, i2 + i3, 0);
                i3++;
            } else {
                throw new C0175h();
            }
        }
    }

    static void m1078b(C0162c c0162c, C0167b c0167b) {
        if (c0162c.m1021a() >= 7) {
            C0128a c0128a = new C0128a();
            C0171f.m1074a(c0162c, c0128a);
            int i = 17;
            int i2 = 0;
            while (i2 < 6) {
                int i3 = i;
                for (i = 0; i < 3; i++) {
                    boolean a = c0128a.m940a(i3);
                    i3--;
                    c0167b.m1039a(i2, (c0167b.m1036a() - 11) + i, a);
                    c0167b.m1039a((c0167b.m1036a() - 11) + i, i2, a);
                }
                i2++;
                i = i3;
            }
        }
    }

    private static void m1079b(C0167b c0167b) {
        for (int i = 8; i < c0167b.m1040b() - 8; i++) {
            int i2 = (i + 1) % 2;
            if (C0171f.m1080b(c0167b.m1035a(i, 6))) {
                c0167b.m1038a(i, 6, i2);
            }
            if (C0171f.m1080b(c0167b.m1035a(6, i))) {
                c0167b.m1038a(6, i, i2);
            }
        }
    }

    private static boolean m1080b(int i) {
        return i == -1;
    }

    private static void m1081c(int i, int i2, C0167b c0167b) {
        for (int i3 = 0; i3 < 5; i3++) {
            for (int i4 = 0; i4 < 5; i4++) {
                c0167b.m1038a(i + i4, i2 + i3, f596b[i3][i4]);
            }
        }
    }

    private static void m1082c(C0162c c0162c, C0167b c0167b) {
        if (c0162c.m1021a() >= 2) {
            int a = c0162c.m1021a() - 1;
            int[] iArr = f597c[a];
            int length = f597c[a].length;
            for (int i = 0; i < length; i++) {
                for (a = 0; a < length; a++) {
                    int i2 = iArr[i];
                    int i3 = iArr[a];
                    if (!(i3 == -1 || i2 == -1 || !C0171f.m1080b(c0167b.m1035a(i3, i2)))) {
                        C0171f.m1081c(i3 - 2, i2 - 2, c0167b);
                    }
                }
            }
        }
    }

    private static void m1083c(C0167b c0167b) {
        if (c0167b.m1035a(8, c0167b.m1036a() - 8) == null) {
            throw new C0175h();
        }
        c0167b.m1038a(8, c0167b.m1036a() - 8, 1);
    }

    private static void m1084d(int i, int i2, C0167b c0167b) {
        for (int i3 = 0; i3 < 7; i3++) {
            for (int i4 = 0; i4 < 7; i4++) {
                c0167b.m1038a(i + i4, i2 + i3, f595a[i3][i4]);
            }
        }
    }

    private static void m1085d(C0167b c0167b) {
        int length = f595a[0].length;
        C0171f.m1084d(0, 0, c0167b);
        C0171f.m1084d(c0167b.m1040b() - length, 0, c0167b);
        C0171f.m1084d(0, c0167b.m1040b() - length, c0167b);
        C0171f.m1069a(0, 7, c0167b);
        C0171f.m1069a(c0167b.m1040b() - 8, 7, c0167b);
        C0171f.m1069a(0, c0167b.m1040b() - 8, c0167b);
        C0171f.m1077b(7, 0, c0167b);
        C0171f.m1077b((c0167b.m1036a() - 7) - 1, 0, c0167b);
        C0171f.m1077b(7, c0167b.m1036a() - 7, c0167b);
    }
}
