package com.google.p007a.p013d.p014a;

/* renamed from: com.google.a.d.a.c */
public final class C0162c {
    private static final int[] f578a;
    private static final C0162c[] f579b;
    private final int f580c;
    private final int[] f581d;
    private final C0164e[] f582e;
    private final int f583f;

    static {
        f578a = new int[]{31892, 34236, 39577, 42195, 48118, 51042, 55367, 58893, 63784, 68472, 70749, 76311, 79154, 84390, 87683, 92361, 96236, 102084, 102881, 110507, 110734, 117786, 119615, 126325, 127568, 133589, 136944, 141498, 145311, 150283, 152622, 158308, 161089, 167017};
        f579b = C0162c.m1020d();
    }

    private C0162c(int i, int[] iArr, C0164e... c0164eArr) {
        int i2 = 0;
        this.f580c = i;
        this.f581d = iArr;
        this.f582e = c0164eArr;
        int a = c0164eArr[0].m1027a();
        C0163d[] d = c0164eArr[0].m1030d();
        int length = d.length;
        int i3 = 0;
        while (i2 < length) {
            C0163d c0163d = d[i2];
            i3 += (c0163d.m1026b() + a) * c0163d.m1025a();
            i2++;
        }
        this.f583f = i3;
    }

    public static C0162c m1019a(int i) {
        if (i >= 1 && i <= 40) {
            return f579b[i - 1];
        }
        throw new IllegalArgumentException();
    }

    private static C0162c[] m1020d() {
        r0 = new C0162c[40];
        int[] iArr = new int[0];
        C0164e[] c0164eArr = new C0164e[4];
        c0164eArr[0] = new C0164e(7, new C0163d(1, 19));
        c0164eArr[1] = new C0164e(10, new C0163d(1, 16));
        c0164eArr[2] = new C0164e(13, new C0163d(1, 13));
        c0164eArr[3] = new C0164e(17, new C0163d(1, 9));
        r0[0] = new C0162c(1, iArr, c0164eArr);
        iArr = new int[]{6, 18};
        c0164eArr = new C0164e[4];
        c0164eArr[0] = new C0164e(10, new C0163d(1, 34));
        c0164eArr[1] = new C0164e(16, new C0163d(1, 28));
        c0164eArr[2] = new C0164e(22, new C0163d(1, 22));
        c0164eArr[3] = new C0164e(28, new C0163d(1, 16));
        r0[1] = new C0162c(2, iArr, c0164eArr);
        iArr = new int[]{6, 22};
        c0164eArr = new C0164e[4];
        c0164eArr[0] = new C0164e(15, new C0163d(1, 55));
        c0164eArr[1] = new C0164e(26, new C0163d(1, 44));
        c0164eArr[2] = new C0164e(18, new C0163d(2, 17));
        c0164eArr[3] = new C0164e(22, new C0163d(2, 13));
        r0[2] = new C0162c(3, iArr, c0164eArr);
        iArr = new int[]{6, 26};
        c0164eArr = new C0164e[4];
        c0164eArr[0] = new C0164e(20, new C0163d(1, 80));
        c0164eArr[1] = new C0164e(18, new C0163d(2, 32));
        c0164eArr[2] = new C0164e(26, new C0163d(2, 24));
        c0164eArr[3] = new C0164e(16, new C0163d(4, 9));
        r0[3] = new C0162c(4, iArr, c0164eArr);
        iArr = new int[]{6, 30};
        c0164eArr = new C0164e[4];
        c0164eArr[0] = new C0164e(26, new C0163d(1, 108));
        c0164eArr[1] = new C0164e(24, new C0163d(2, 43));
        c0164eArr[2] = new C0164e(18, new C0163d(2, 15), new C0163d(2, 16));
        c0164eArr[3] = new C0164e(22, new C0163d(2, 11), new C0163d(2, 12));
        r0[4] = new C0162c(5, iArr, c0164eArr);
        iArr = new int[]{6, 34};
        c0164eArr = new C0164e[4];
        c0164eArr[0] = new C0164e(18, new C0163d(2, 68));
        c0164eArr[1] = new C0164e(16, new C0163d(4, 27));
        c0164eArr[2] = new C0164e(24, new C0163d(4, 19));
        c0164eArr[3] = new C0164e(28, new C0163d(4, 15));
        r0[5] = new C0162c(6, iArr, c0164eArr);
        iArr = new int[]{6, 22, 38};
        c0164eArr = new C0164e[4];
        c0164eArr[0] = new C0164e(20, new C0163d(2, 78));
        c0164eArr[1] = new C0164e(18, new C0163d(4, 31));
        c0164eArr[2] = new C0164e(18, new C0163d(2, 14), new C0163d(4, 15));
        c0164eArr[3] = new C0164e(26, new C0163d(4, 13), new C0163d(1, 14));
        r0[6] = new C0162c(7, iArr, c0164eArr);
        iArr = new int[]{6, 24, 42};
        c0164eArr = new C0164e[4];
        c0164eArr[0] = new C0164e(24, new C0163d(2, 97));
        c0164eArr[1] = new C0164e(22, new C0163d(2, 38), new C0163d(2, 39));
        c0164eArr[2] = new C0164e(22, new C0163d(4, 18), new C0163d(2, 19));
        c0164eArr[3] = new C0164e(26, new C0163d(4, 14), new C0163d(2, 15));
        r0[7] = new C0162c(8, iArr, c0164eArr);
        iArr = new int[]{6, 26, 46};
        c0164eArr = new C0164e[4];
        c0164eArr[0] = new C0164e(30, new C0163d(2, 116));
        c0164eArr[1] = new C0164e(22, new C0163d(3, 36), new C0163d(2, 37));
        c0164eArr[2] = new C0164e(20, new C0163d(4, 16), new C0163d(4, 17));
        c0164eArr[3] = new C0164e(24, new C0163d(4, 12), new C0163d(4, 13));
        r0[8] = new C0162c(9, iArr, c0164eArr);
        iArr = new int[]{6, 28, 50};
        c0164eArr = new C0164e[4];
        c0164eArr[0] = new C0164e(18, new C0163d(2, 68), new C0163d(2, 69));
        c0164eArr[1] = new C0164e(26, new C0163d(4, 43), new C0163d(1, 44));
        c0164eArr[2] = new C0164e(24, new C0163d(6, 19), new C0163d(2, 20));
        c0164eArr[3] = new C0164e(28, new C0163d(6, 15), new C0163d(2, 16));
        r0[9] = new C0162c(10, iArr, c0164eArr);
        iArr = new int[]{6, 30, 54};
        c0164eArr = new C0164e[4];
        c0164eArr[0] = new C0164e(20, new C0163d(4, 81));
        c0164eArr[1] = new C0164e(30, new C0163d(1, 50), new C0163d(4, 51));
        c0164eArr[2] = new C0164e(28, new C0163d(4, 22), new C0163d(4, 23));
        c0164eArr[3] = new C0164e(24, new C0163d(3, 12), new C0163d(8, 13));
        r0[10] = new C0162c(11, iArr, c0164eArr);
        iArr = new int[]{6, 32, 58};
        c0164eArr = new C0164e[4];
        c0164eArr[0] = new C0164e(24, new C0163d(2, 92), new C0163d(2, 93));
        c0164eArr[1] = new C0164e(22, new C0163d(6, 36), new C0163d(2, 37));
        c0164eArr[2] = new C0164e(26, new C0163d(4, 20), new C0163d(6, 21));
        c0164eArr[3] = new C0164e(28, new C0163d(7, 14), new C0163d(4, 15));
        r0[11] = new C0162c(12, iArr, c0164eArr);
        iArr = new int[]{6, 34, 62};
        c0164eArr = new C0164e[4];
        c0164eArr[0] = new C0164e(26, new C0163d(4, 107));
        c0164eArr[1] = new C0164e(22, new C0163d(8, 37), new C0163d(1, 38));
        c0164eArr[2] = new C0164e(24, new C0163d(8, 20), new C0163d(4, 21));
        c0164eArr[3] = new C0164e(22, new C0163d(12, 11), new C0163d(4, 12));
        r0[12] = new C0162c(13, iArr, c0164eArr);
        iArr = new int[]{6, 26, 46, 66};
        c0164eArr = new C0164e[4];
        c0164eArr[0] = new C0164e(30, new C0163d(3, 115), new C0163d(1, 116));
        c0164eArr[1] = new C0164e(24, new C0163d(4, 40), new C0163d(5, 41));
        c0164eArr[2] = new C0164e(20, new C0163d(11, 16), new C0163d(5, 17));
        c0164eArr[3] = new C0164e(24, new C0163d(11, 12), new C0163d(5, 13));
        r0[13] = new C0162c(14, iArr, c0164eArr);
        iArr = new int[]{6, 26, 48, 70};
        c0164eArr = new C0164e[4];
        c0164eArr[0] = new C0164e(22, new C0163d(5, 87), new C0163d(1, 88));
        c0164eArr[1] = new C0164e(24, new C0163d(5, 41), new C0163d(5, 42));
        c0164eArr[2] = new C0164e(30, new C0163d(5, 24), new C0163d(7, 25));
        c0164eArr[3] = new C0164e(24, new C0163d(11, 12), new C0163d(7, 13));
        r0[14] = new C0162c(15, iArr, c0164eArr);
        iArr = new int[]{6, 26, 50, 74};
        c0164eArr = new C0164e[4];
        c0164eArr[0] = new C0164e(24, new C0163d(5, 98), new C0163d(1, 99));
        c0164eArr[1] = new C0164e(28, new C0163d(7, 45), new C0163d(3, 46));
        c0164eArr[2] = new C0164e(24, new C0163d(15, 19), new C0163d(2, 20));
        c0164eArr[3] = new C0164e(30, new C0163d(3, 15), new C0163d(13, 16));
        r0[15] = new C0162c(16, iArr, c0164eArr);
        iArr = new int[]{6, 30, 54, 78};
        c0164eArr = new C0164e[4];
        c0164eArr[0] = new C0164e(28, new C0163d(1, 107), new C0163d(5, 108));
        c0164eArr[1] = new C0164e(28, new C0163d(10, 46), new C0163d(1, 47));
        c0164eArr[2] = new C0164e(28, new C0163d(1, 22), new C0163d(15, 23));
        c0164eArr[3] = new C0164e(28, new C0163d(2, 14), new C0163d(17, 15));
        r0[16] = new C0162c(17, iArr, c0164eArr);
        iArr = new int[]{6, 30, 56, 82};
        c0164eArr = new C0164e[4];
        c0164eArr[0] = new C0164e(30, new C0163d(5, 120), new C0163d(1, 121));
        c0164eArr[1] = new C0164e(26, new C0163d(9, 43), new C0163d(4, 44));
        c0164eArr[2] = new C0164e(28, new C0163d(17, 22), new C0163d(1, 23));
        c0164eArr[3] = new C0164e(28, new C0163d(2, 14), new C0163d(19, 15));
        r0[17] = new C0162c(18, iArr, c0164eArr);
        iArr = new int[]{6, 30, 58, 86};
        c0164eArr = new C0164e[4];
        c0164eArr[0] = new C0164e(28, new C0163d(3, 113), new C0163d(4, 114));
        c0164eArr[1] = new C0164e(26, new C0163d(3, 44), new C0163d(11, 45));
        c0164eArr[2] = new C0164e(26, new C0163d(17, 21), new C0163d(4, 22));
        c0164eArr[3] = new C0164e(26, new C0163d(9, 13), new C0163d(16, 14));
        r0[18] = new C0162c(19, iArr, c0164eArr);
        iArr = new int[]{6, 34, 62, 90};
        c0164eArr = new C0164e[4];
        c0164eArr[0] = new C0164e(28, new C0163d(3, 107), new C0163d(5, 108));
        c0164eArr[1] = new C0164e(26, new C0163d(3, 41), new C0163d(13, 42));
        c0164eArr[2] = new C0164e(30, new C0163d(15, 24), new C0163d(5, 25));
        c0164eArr[3] = new C0164e(28, new C0163d(15, 15), new C0163d(10, 16));
        r0[19] = new C0162c(20, iArr, c0164eArr);
        iArr = new int[]{6, 28, 50, 72, 94};
        c0164eArr = new C0164e[4];
        c0164eArr[0] = new C0164e(28, new C0163d(4, 116), new C0163d(4, 117));
        c0164eArr[1] = new C0164e(26, new C0163d(17, 42));
        c0164eArr[2] = new C0164e(28, new C0163d(17, 22), new C0163d(6, 23));
        c0164eArr[3] = new C0164e(30, new C0163d(19, 16), new C0163d(6, 17));
        r0[20] = new C0162c(21, iArr, c0164eArr);
        iArr = new int[]{6, 26, 50, 74, 98};
        c0164eArr = new C0164e[4];
        c0164eArr[0] = new C0164e(28, new C0163d(2, 111), new C0163d(7, 112));
        c0164eArr[1] = new C0164e(28, new C0163d(17, 46));
        c0164eArr[2] = new C0164e(30, new C0163d(7, 24), new C0163d(16, 25));
        c0164eArr[3] = new C0164e(24, new C0163d(34, 13));
        r0[21] = new C0162c(22, iArr, c0164eArr);
        iArr = new int[]{6, 30, 54, 78, 102};
        c0164eArr = new C0164e[4];
        c0164eArr[0] = new C0164e(30, new C0163d(4, 121), new C0163d(5, 122));
        c0164eArr[1] = new C0164e(28, new C0163d(4, 47), new C0163d(14, 48));
        c0164eArr[2] = new C0164e(30, new C0163d(11, 24), new C0163d(14, 25));
        c0164eArr[3] = new C0164e(30, new C0163d(16, 15), new C0163d(14, 16));
        r0[22] = new C0162c(23, iArr, c0164eArr);
        iArr = new int[]{6, 28, 54, 80, 106};
        c0164eArr = new C0164e[4];
        c0164eArr[0] = new C0164e(30, new C0163d(6, 117), new C0163d(4, 118));
        c0164eArr[1] = new C0164e(28, new C0163d(6, 45), new C0163d(14, 46));
        c0164eArr[2] = new C0164e(30, new C0163d(11, 24), new C0163d(16, 25));
        c0164eArr[3] = new C0164e(30, new C0163d(30, 16), new C0163d(2, 17));
        r0[23] = new C0162c(24, iArr, c0164eArr);
        iArr = new int[]{6, 32, 58, 84, 110};
        c0164eArr = new C0164e[4];
        c0164eArr[0] = new C0164e(26, new C0163d(8, 106), new C0163d(4, 107));
        c0164eArr[1] = new C0164e(28, new C0163d(8, 47), new C0163d(13, 48));
        c0164eArr[2] = new C0164e(30, new C0163d(7, 24), new C0163d(22, 25));
        c0164eArr[3] = new C0164e(30, new C0163d(22, 15), new C0163d(13, 16));
        r0[24] = new C0162c(25, iArr, c0164eArr);
        iArr = new int[]{6, 30, 58, 86, 114};
        c0164eArr = new C0164e[4];
        c0164eArr[0] = new C0164e(28, new C0163d(10, 114), new C0163d(2, 115));
        c0164eArr[1] = new C0164e(28, new C0163d(19, 46), new C0163d(4, 47));
        c0164eArr[2] = new C0164e(28, new C0163d(28, 22), new C0163d(6, 23));
        c0164eArr[3] = new C0164e(30, new C0163d(33, 16), new C0163d(4, 17));
        r0[25] = new C0162c(26, iArr, c0164eArr);
        iArr = new int[]{6, 34, 62, 90, 118};
        c0164eArr = new C0164e[4];
        c0164eArr[0] = new C0164e(30, new C0163d(8, 122), new C0163d(4, 123));
        c0164eArr[1] = new C0164e(28, new C0163d(22, 45), new C0163d(3, 46));
        c0164eArr[2] = new C0164e(30, new C0163d(8, 23), new C0163d(26, 24));
        c0164eArr[3] = new C0164e(30, new C0163d(12, 15), new C0163d(28, 16));
        r0[26] = new C0162c(27, iArr, c0164eArr);
        iArr = new int[]{6, 26, 50, 74, 98, 122};
        c0164eArr = new C0164e[4];
        c0164eArr[0] = new C0164e(30, new C0163d(3, 117), new C0163d(10, 118));
        c0164eArr[1] = new C0164e(28, new C0163d(3, 45), new C0163d(23, 46));
        c0164eArr[2] = new C0164e(30, new C0163d(4, 24), new C0163d(31, 25));
        c0164eArr[3] = new C0164e(30, new C0163d(11, 15), new C0163d(31, 16));
        r0[27] = new C0162c(28, iArr, c0164eArr);
        iArr = new int[]{6, 30, 54, 78, 102, 126};
        c0164eArr = new C0164e[4];
        c0164eArr[0] = new C0164e(30, new C0163d(7, 116), new C0163d(7, 117));
        c0164eArr[1] = new C0164e(28, new C0163d(21, 45), new C0163d(7, 46));
        c0164eArr[2] = new C0164e(30, new C0163d(1, 23), new C0163d(37, 24));
        c0164eArr[3] = new C0164e(30, new C0163d(19, 15), new C0163d(26, 16));
        r0[28] = new C0162c(29, iArr, c0164eArr);
        iArr = new int[]{6, 26, 52, 78, 104, 130};
        c0164eArr = new C0164e[4];
        c0164eArr[0] = new C0164e(30, new C0163d(5, 115), new C0163d(10, 116));
        c0164eArr[1] = new C0164e(28, new C0163d(19, 47), new C0163d(10, 48));
        c0164eArr[2] = new C0164e(30, new C0163d(15, 24), new C0163d(25, 25));
        c0164eArr[3] = new C0164e(30, new C0163d(23, 15), new C0163d(25, 16));
        r0[29] = new C0162c(30, iArr, c0164eArr);
        iArr = new int[]{6, 30, 56, 82, 108, 134};
        c0164eArr = new C0164e[4];
        c0164eArr[0] = new C0164e(30, new C0163d(13, 115), new C0163d(3, 116));
        c0164eArr[1] = new C0164e(28, new C0163d(2, 46), new C0163d(29, 47));
        c0164eArr[2] = new C0164e(30, new C0163d(42, 24), new C0163d(1, 25));
        c0164eArr[3] = new C0164e(30, new C0163d(23, 15), new C0163d(28, 16));
        r0[30] = new C0162c(31, iArr, c0164eArr);
        iArr = new int[]{6, 34, 60, 86, 112, 138};
        c0164eArr = new C0164e[4];
        c0164eArr[0] = new C0164e(30, new C0163d(17, 115));
        c0164eArr[1] = new C0164e(28, new C0163d(10, 46), new C0163d(23, 47));
        c0164eArr[2] = new C0164e(30, new C0163d(10, 24), new C0163d(35, 25));
        c0164eArr[3] = new C0164e(30, new C0163d(19, 15), new C0163d(35, 16));
        r0[31] = new C0162c(32, iArr, c0164eArr);
        iArr = new int[]{6, 30, 58, 86, 114, 142};
        c0164eArr = new C0164e[4];
        c0164eArr[0] = new C0164e(30, new C0163d(17, 115), new C0163d(1, 116));
        c0164eArr[1] = new C0164e(28, new C0163d(14, 46), new C0163d(21, 47));
        c0164eArr[2] = new C0164e(30, new C0163d(29, 24), new C0163d(19, 25));
        c0164eArr[3] = new C0164e(30, new C0163d(11, 15), new C0163d(46, 16));
        r0[32] = new C0162c(33, iArr, c0164eArr);
        iArr = new int[]{6, 34, 62, 90, 118, 146};
        c0164eArr = new C0164e[4];
        c0164eArr[0] = new C0164e(30, new C0163d(13, 115), new C0163d(6, 116));
        c0164eArr[1] = new C0164e(28, new C0163d(14, 46), new C0163d(23, 47));
        c0164eArr[2] = new C0164e(30, new C0163d(44, 24), new C0163d(7, 25));
        c0164eArr[3] = new C0164e(30, new C0163d(59, 16), new C0163d(1, 17));
        r0[33] = new C0162c(34, iArr, c0164eArr);
        iArr = new int[]{6, 30, 54, 78, 102, 126, 150};
        c0164eArr = new C0164e[4];
        c0164eArr[0] = new C0164e(30, new C0163d(12, 121), new C0163d(7, 122));
        c0164eArr[1] = new C0164e(28, new C0163d(12, 47), new C0163d(26, 48));
        c0164eArr[2] = new C0164e(30, new C0163d(39, 24), new C0163d(14, 25));
        c0164eArr[3] = new C0164e(30, new C0163d(22, 15), new C0163d(41, 16));
        r0[34] = new C0162c(35, iArr, c0164eArr);
        iArr = new int[]{6, 24, 50, 76, 102, 128, 154};
        c0164eArr = new C0164e[4];
        c0164eArr[0] = new C0164e(30, new C0163d(6, 121), new C0163d(14, 122));
        c0164eArr[1] = new C0164e(28, new C0163d(6, 47), new C0163d(34, 48));
        c0164eArr[2] = new C0164e(30, new C0163d(46, 24), new C0163d(10, 25));
        c0164eArr[3] = new C0164e(30, new C0163d(2, 15), new C0163d(64, 16));
        r0[35] = new C0162c(36, iArr, c0164eArr);
        iArr = new int[]{6, 28, 54, 80, 106, 132, 158};
        c0164eArr = new C0164e[4];
        c0164eArr[0] = new C0164e(30, new C0163d(17, 122), new C0163d(4, 123));
        c0164eArr[1] = new C0164e(28, new C0163d(29, 46), new C0163d(14, 47));
        c0164eArr[2] = new C0164e(30, new C0163d(49, 24), new C0163d(10, 25));
        c0164eArr[3] = new C0164e(30, new C0163d(24, 15), new C0163d(46, 16));
        r0[36] = new C0162c(37, iArr, c0164eArr);
        iArr = new int[]{6, 32, 58, 84, 110, 136, 162};
        c0164eArr = new C0164e[4];
        c0164eArr[0] = new C0164e(30, new C0163d(4, 122), new C0163d(18, 123));
        c0164eArr[1] = new C0164e(28, new C0163d(13, 46), new C0163d(32, 47));
        c0164eArr[2] = new C0164e(30, new C0163d(48, 24), new C0163d(14, 25));
        c0164eArr[3] = new C0164e(30, new C0163d(42, 15), new C0163d(32, 16));
        r0[37] = new C0162c(38, iArr, c0164eArr);
        iArr = new int[]{6, 26, 54, 82, 110, 138, 166};
        c0164eArr = new C0164e[4];
        c0164eArr[0] = new C0164e(30, new C0163d(20, 117), new C0163d(4, 118));
        c0164eArr[1] = new C0164e(28, new C0163d(40, 47), new C0163d(7, 48));
        c0164eArr[2] = new C0164e(30, new C0163d(43, 24), new C0163d(22, 25));
        c0164eArr[3] = new C0164e(30, new C0163d(10, 15), new C0163d(67, 16));
        r0[38] = new C0162c(39, iArr, c0164eArr);
        iArr = new int[]{6, 30, 58, 86, 114, 142, 170};
        c0164eArr = new C0164e[4];
        c0164eArr[0] = new C0164e(30, new C0163d(19, 118), new C0163d(6, 119));
        c0164eArr[1] = new C0164e(28, new C0163d(18, 47), new C0163d(31, 48));
        c0164eArr[2] = new C0164e(30, new C0163d(34, 24), new C0163d(34, 25));
        c0164eArr[3] = new C0164e(30, new C0163d(20, 15), new C0163d(61, 16));
        r0[39] = new C0162c(40, iArr, c0164eArr);
        return r0;
    }

    public int m1021a() {
        return this.f580c;
    }

    public C0164e m1022a(C0160a c0160a) {
        return this.f582e[c0160a.ordinal()];
    }

    public int m1023b() {
        return this.f583f;
    }

    public int m1024c() {
        return (this.f580c * 4) + 17;
    }

    public String toString() {
        return String.valueOf(this.f580c);
    }
}
