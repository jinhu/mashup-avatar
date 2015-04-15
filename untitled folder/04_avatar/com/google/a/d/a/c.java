package com.google.a.d.a;

public final class c {
    private static final int[] a;
    private static final c[] b;
    private final int c;
    private final int[] d;
    private final e[] e;
    private final int f;

    static {
        a = new int[]{31892, 34236, 39577, 42195, 48118, 51042, 55367, 58893, 63784, 68472, 70749, 76311, 79154, 84390, 87683, 92361, 96236, 102084, 102881, 110507, 110734, 117786, 119615, 126325, 127568, 133589, 136944, 141498, 145311, 150283, 152622, 158308, 161089, 167017};
        b = d();
    }

    private c(int i, int[] iArr, e... eVarArr) {
        int i2 = 0;
        this.c = i;
        this.d = iArr;
        this.e = eVarArr;
        int a = eVarArr[0].a();
        d[] d = eVarArr[0].d();
        int length = d.length;
        int i3 = 0;
        while (i2 < length) {
            d dVar = d[i2];
            i3 += (dVar.b() + a) * dVar.a();
            i2++;
        }
        this.f = i3;
    }

    public static c a(int i) {
        if (i >= 1 && i <= 40) {
            return b[i - 1];
        }
        throw new IllegalArgumentException();
    }

    private static c[] d() {
        r0 = new c[40];
        int[] iArr = new int[0];
        e[] eVarArr = new e[4];
        eVarArr[0] = new e(7, new d(1, 19));
        eVarArr[1] = new e(10, new d(1, 16));
        eVarArr[2] = new e(13, new d(1, 13));
        eVarArr[3] = new e(17, new d(1, 9));
        r0[0] = new c(1, iArr, eVarArr);
        iArr = new int[]{6, 18};
        eVarArr = new e[4];
        eVarArr[0] = new e(10, new d(1, 34));
        eVarArr[1] = new e(16, new d(1, 28));
        eVarArr[2] = new e(22, new d(1, 22));
        eVarArr[3] = new e(28, new d(1, 16));
        r0[1] = new c(2, iArr, eVarArr);
        iArr = new int[]{6, 22};
        eVarArr = new e[4];
        eVarArr[0] = new e(15, new d(1, 55));
        eVarArr[1] = new e(26, new d(1, 44));
        eVarArr[2] = new e(18, new d(2, 17));
        eVarArr[3] = new e(22, new d(2, 13));
        r0[2] = new c(3, iArr, eVarArr);
        iArr = new int[]{6, 26};
        eVarArr = new e[4];
        eVarArr[0] = new e(20, new d(1, 80));
        eVarArr[1] = new e(18, new d(2, 32));
        eVarArr[2] = new e(26, new d(2, 24));
        eVarArr[3] = new e(16, new d(4, 9));
        r0[3] = new c(4, iArr, eVarArr);
        iArr = new int[]{6, 30};
        eVarArr = new e[4];
        eVarArr[0] = new e(26, new d(1, 108));
        eVarArr[1] = new e(24, new d(2, 43));
        eVarArr[2] = new e(18, new d(2, 15), new d(2, 16));
        eVarArr[3] = new e(22, new d(2, 11), new d(2, 12));
        r0[4] = new c(5, iArr, eVarArr);
        iArr = new int[]{6, 34};
        eVarArr = new e[4];
        eVarArr[0] = new e(18, new d(2, 68));
        eVarArr[1] = new e(16, new d(4, 27));
        eVarArr[2] = new e(24, new d(4, 19));
        eVarArr[3] = new e(28, new d(4, 15));
        r0[5] = new c(6, iArr, eVarArr);
        iArr = new int[]{6, 22, 38};
        eVarArr = new e[4];
        eVarArr[0] = new e(20, new d(2, 78));
        eVarArr[1] = new e(18, new d(4, 31));
        eVarArr[2] = new e(18, new d(2, 14), new d(4, 15));
        eVarArr[3] = new e(26, new d(4, 13), new d(1, 14));
        r0[6] = new c(7, iArr, eVarArr);
        iArr = new int[]{6, 24, 42};
        eVarArr = new e[4];
        eVarArr[0] = new e(24, new d(2, 97));
        eVarArr[1] = new e(22, new d(2, 38), new d(2, 39));
        eVarArr[2] = new e(22, new d(4, 18), new d(2, 19));
        eVarArr[3] = new e(26, new d(4, 14), new d(2, 15));
        r0[7] = new c(8, iArr, eVarArr);
        iArr = new int[]{6, 26, 46};
        eVarArr = new e[4];
        eVarArr[0] = new e(30, new d(2, 116));
        eVarArr[1] = new e(22, new d(3, 36), new d(2, 37));
        eVarArr[2] = new e(20, new d(4, 16), new d(4, 17));
        eVarArr[3] = new e(24, new d(4, 12), new d(4, 13));
        r0[8] = new c(9, iArr, eVarArr);
        iArr = new int[]{6, 28, 50};
        eVarArr = new e[4];
        eVarArr[0] = new e(18, new d(2, 68), new d(2, 69));
        eVarArr[1] = new e(26, new d(4, 43), new d(1, 44));
        eVarArr[2] = new e(24, new d(6, 19), new d(2, 20));
        eVarArr[3] = new e(28, new d(6, 15), new d(2, 16));
        r0[9] = new c(10, iArr, eVarArr);
        iArr = new int[]{6, 30, 54};
        eVarArr = new e[4];
        eVarArr[0] = new e(20, new d(4, 81));
        eVarArr[1] = new e(30, new d(1, 50), new d(4, 51));
        eVarArr[2] = new e(28, new d(4, 22), new d(4, 23));
        eVarArr[3] = new e(24, new d(3, 12), new d(8, 13));
        r0[10] = new c(11, iArr, eVarArr);
        iArr = new int[]{6, 32, 58};
        eVarArr = new e[4];
        eVarArr[0] = new e(24, new d(2, 92), new d(2, 93));
        eVarArr[1] = new e(22, new d(6, 36), new d(2, 37));
        eVarArr[2] = new e(26, new d(4, 20), new d(6, 21));
        eVarArr[3] = new e(28, new d(7, 14), new d(4, 15));
        r0[11] = new c(12, iArr, eVarArr);
        iArr = new int[]{6, 34, 62};
        eVarArr = new e[4];
        eVarArr[0] = new e(26, new d(4, 107));
        eVarArr[1] = new e(22, new d(8, 37), new d(1, 38));
        eVarArr[2] = new e(24, new d(8, 20), new d(4, 21));
        eVarArr[3] = new e(22, new d(12, 11), new d(4, 12));
        r0[12] = new c(13, iArr, eVarArr);
        iArr = new int[]{6, 26, 46, 66};
        eVarArr = new e[4];
        eVarArr[0] = new e(30, new d(3, 115), new d(1, 116));
        eVarArr[1] = new e(24, new d(4, 40), new d(5, 41));
        eVarArr[2] = new e(20, new d(11, 16), new d(5, 17));
        eVarArr[3] = new e(24, new d(11, 12), new d(5, 13));
        r0[13] = new c(14, iArr, eVarArr);
        iArr = new int[]{6, 26, 48, 70};
        eVarArr = new e[4];
        eVarArr[0] = new e(22, new d(5, 87), new d(1, 88));
        eVarArr[1] = new e(24, new d(5, 41), new d(5, 42));
        eVarArr[2] = new e(30, new d(5, 24), new d(7, 25));
        eVarArr[3] = new e(24, new d(11, 12), new d(7, 13));
        r0[14] = new c(15, iArr, eVarArr);
        iArr = new int[]{6, 26, 50, 74};
        eVarArr = new e[4];
        eVarArr[0] = new e(24, new d(5, 98), new d(1, 99));
        eVarArr[1] = new e(28, new d(7, 45), new d(3, 46));
        eVarArr[2] = new e(24, new d(15, 19), new d(2, 20));
        eVarArr[3] = new e(30, new d(3, 15), new d(13, 16));
        r0[15] = new c(16, iArr, eVarArr);
        iArr = new int[]{6, 30, 54, 78};
        eVarArr = new e[4];
        eVarArr[0] = new e(28, new d(1, 107), new d(5, 108));
        eVarArr[1] = new e(28, new d(10, 46), new d(1, 47));
        eVarArr[2] = new e(28, new d(1, 22), new d(15, 23));
        eVarArr[3] = new e(28, new d(2, 14), new d(17, 15));
        r0[16] = new c(17, iArr, eVarArr);
        iArr = new int[]{6, 30, 56, 82};
        eVarArr = new e[4];
        eVarArr[0] = new e(30, new d(5, 120), new d(1, 121));
        eVarArr[1] = new e(26, new d(9, 43), new d(4, 44));
        eVarArr[2] = new e(28, new d(17, 22), new d(1, 23));
        eVarArr[3] = new e(28, new d(2, 14), new d(19, 15));
        r0[17] = new c(18, iArr, eVarArr);
        iArr = new int[]{6, 30, 58, 86};
        eVarArr = new e[4];
        eVarArr[0] = new e(28, new d(3, 113), new d(4, 114));
        eVarArr[1] = new e(26, new d(3, 44), new d(11, 45));
        eVarArr[2] = new e(26, new d(17, 21), new d(4, 22));
        eVarArr[3] = new e(26, new d(9, 13), new d(16, 14));
        r0[18] = new c(19, iArr, eVarArr);
        iArr = new int[]{6, 34, 62, 90};
        eVarArr = new e[4];
        eVarArr[0] = new e(28, new d(3, 107), new d(5, 108));
        eVarArr[1] = new e(26, new d(3, 41), new d(13, 42));
        eVarArr[2] = new e(30, new d(15, 24), new d(5, 25));
        eVarArr[3] = new e(28, new d(15, 15), new d(10, 16));
        r0[19] = new c(20, iArr, eVarArr);
        iArr = new int[]{6, 28, 50, 72, 94};
        eVarArr = new e[4];
        eVarArr[0] = new e(28, new d(4, 116), new d(4, 117));
        eVarArr[1] = new e(26, new d(17, 42));
        eVarArr[2] = new e(28, new d(17, 22), new d(6, 23));
        eVarArr[3] = new e(30, new d(19, 16), new d(6, 17));
        r0[20] = new c(21, iArr, eVarArr);
        iArr = new int[]{6, 26, 50, 74, 98};
        eVarArr = new e[4];
        eVarArr[0] = new e(28, new d(2, 111), new d(7, 112));
        eVarArr[1] = new e(28, new d(17, 46));
        eVarArr[2] = new e(30, new d(7, 24), new d(16, 25));
        eVarArr[3] = new e(24, new d(34, 13));
        r0[21] = new c(22, iArr, eVarArr);
        iArr = new int[]{6, 30, 54, 78, 102};
        eVarArr = new e[4];
        eVarArr[0] = new e(30, new d(4, 121), new d(5, 122));
        eVarArr[1] = new e(28, new d(4, 47), new d(14, 48));
        eVarArr[2] = new e(30, new d(11, 24), new d(14, 25));
        eVarArr[3] = new e(30, new d(16, 15), new d(14, 16));
        r0[22] = new c(23, iArr, eVarArr);
        iArr = new int[]{6, 28, 54, 80, 106};
        eVarArr = new e[4];
        eVarArr[0] = new e(30, new d(6, 117), new d(4, 118));
        eVarArr[1] = new e(28, new d(6, 45), new d(14, 46));
        eVarArr[2] = new e(30, new d(11, 24), new d(16, 25));
        eVarArr[3] = new e(30, new d(30, 16), new d(2, 17));
        r0[23] = new c(24, iArr, eVarArr);
        iArr = new int[]{6, 32, 58, 84, 110};
        eVarArr = new e[4];
        eVarArr[0] = new e(26, new d(8, 106), new d(4, 107));
        eVarArr[1] = new e(28, new d(8, 47), new d(13, 48));
        eVarArr[2] = new e(30, new d(7, 24), new d(22, 25));
        eVarArr[3] = new e(30, new d(22, 15), new d(13, 16));
        r0[24] = new c(25, iArr, eVarArr);
        iArr = new int[]{6, 30, 58, 86, 114};
        eVarArr = new e[4];
        eVarArr[0] = new e(28, new d(10, 114), new d(2, 115));
        eVarArr[1] = new e(28, new d(19, 46), new d(4, 47));
        eVarArr[2] = new e(28, new d(28, 22), new d(6, 23));
        eVarArr[3] = new e(30, new d(33, 16), new d(4, 17));
        r0[25] = new c(26, iArr, eVarArr);
        iArr = new int[]{6, 34, 62, 90, 118};
        eVarArr = new e[4];
        eVarArr[0] = new e(30, new d(8, 122), new d(4, 123));
        eVarArr[1] = new e(28, new d(22, 45), new d(3, 46));
        eVarArr[2] = new e(30, new d(8, 23), new d(26, 24));
        eVarArr[3] = new e(30, new d(12, 15), new d(28, 16));
        r0[26] = new c(27, iArr, eVarArr);
        iArr = new int[]{6, 26, 50, 74, 98, 122};
        eVarArr = new e[4];
        eVarArr[0] = new e(30, new d(3, 117), new d(10, 118));
        eVarArr[1] = new e(28, new d(3, 45), new d(23, 46));
        eVarArr[2] = new e(30, new d(4, 24), new d(31, 25));
        eVarArr[3] = new e(30, new d(11, 15), new d(31, 16));
        r0[27] = new c(28, iArr, eVarArr);
        iArr = new int[]{6, 30, 54, 78, 102, 126};
        eVarArr = new e[4];
        eVarArr[0] = new e(30, new d(7, 116), new d(7, 117));
        eVarArr[1] = new e(28, new d(21, 45), new d(7, 46));
        eVarArr[2] = new e(30, new d(1, 23), new d(37, 24));
        eVarArr[3] = new e(30, new d(19, 15), new d(26, 16));
        r0[28] = new c(29, iArr, eVarArr);
        iArr = new int[]{6, 26, 52, 78, 104, 130};
        eVarArr = new e[4];
        eVarArr[0] = new e(30, new d(5, 115), new d(10, 116));
        eVarArr[1] = new e(28, new d(19, 47), new d(10, 48));
        eVarArr[2] = new e(30, new d(15, 24), new d(25, 25));
        eVarArr[3] = new e(30, new d(23, 15), new d(25, 16));
        r0[29] = new c(30, iArr, eVarArr);
        iArr = new int[]{6, 30, 56, 82, 108, 134};
        eVarArr = new e[4];
        eVarArr[0] = new e(30, new d(13, 115), new d(3, 116));
        eVarArr[1] = new e(28, new d(2, 46), new d(29, 47));
        eVarArr[2] = new e(30, new d(42, 24), new d(1, 25));
        eVarArr[3] = new e(30, new d(23, 15), new d(28, 16));
        r0[30] = new c(31, iArr, eVarArr);
        iArr = new int[]{6, 34, 60, 86, 112, 138};
        eVarArr = new e[4];
        eVarArr[0] = new e(30, new d(17, 115));
        eVarArr[1] = new e(28, new d(10, 46), new d(23, 47));
        eVarArr[2] = new e(30, new d(10, 24), new d(35, 25));
        eVarArr[3] = new e(30, new d(19, 15), new d(35, 16));
        r0[31] = new c(32, iArr, eVarArr);
        iArr = new int[]{6, 30, 58, 86, 114, 142};
        eVarArr = new e[4];
        eVarArr[0] = new e(30, new d(17, 115), new d(1, 116));
        eVarArr[1] = new e(28, new d(14, 46), new d(21, 47));
        eVarArr[2] = new e(30, new d(29, 24), new d(19, 25));
        eVarArr[3] = new e(30, new d(11, 15), new d(46, 16));
        r0[32] = new c(33, iArr, eVarArr);
        iArr = new int[]{6, 34, 62, 90, 118, 146};
        eVarArr = new e[4];
        eVarArr[0] = new e(30, new d(13, 115), new d(6, 116));
        eVarArr[1] = new e(28, new d(14, 46), new d(23, 47));
        eVarArr[2] = new e(30, new d(44, 24), new d(7, 25));
        eVarArr[3] = new e(30, new d(59, 16), new d(1, 17));
        r0[33] = new c(34, iArr, eVarArr);
        iArr = new int[]{6, 30, 54, 78, 102, 126, 150};
        eVarArr = new e[4];
        eVarArr[0] = new e(30, new d(12, 121), new d(7, 122));
        eVarArr[1] = new e(28, new d(12, 47), new d(26, 48));
        eVarArr[2] = new e(30, new d(39, 24), new d(14, 25));
        eVarArr[3] = new e(30, new d(22, 15), new d(41, 16));
        r0[34] = new c(35, iArr, eVarArr);
        iArr = new int[]{6, 24, 50, 76, 102, 128, 154};
        eVarArr = new e[4];
        eVarArr[0] = new e(30, new d(6, 121), new d(14, 122));
        eVarArr[1] = new e(28, new d(6, 47), new d(34, 48));
        eVarArr[2] = new e(30, new d(46, 24), new d(10, 25));
        eVarArr[3] = new e(30, new d(2, 15), new d(64, 16));
        r0[35] = new c(36, iArr, eVarArr);
        iArr = new int[]{6, 28, 54, 80, 106, 132, 158};
        eVarArr = new e[4];
        eVarArr[0] = new e(30, new d(17, 122), new d(4, 123));
        eVarArr[1] = new e(28, new d(29, 46), new d(14, 47));
        eVarArr[2] = new e(30, new d(49, 24), new d(10, 25));
        eVarArr[3] = new e(30, new d(24, 15), new d(46, 16));
        r0[36] = new c(37, iArr, eVarArr);
        iArr = new int[]{6, 32, 58, 84, 110, 136, 162};
        eVarArr = new e[4];
        eVarArr[0] = new e(30, new d(4, 122), new d(18, 123));
        eVarArr[1] = new e(28, new d(13, 46), new d(32, 47));
        eVarArr[2] = new e(30, new d(48, 24), new d(14, 25));
        eVarArr[3] = new e(30, new d(42, 15), new d(32, 16));
        r0[37] = new c(38, iArr, eVarArr);
        iArr = new int[]{6, 26, 54, 82, 110, 138, 166};
        eVarArr = new e[4];
        eVarArr[0] = new e(30, new d(20, 117), new d(4, 118));
        eVarArr[1] = new e(28, new d(40, 47), new d(7, 48));
        eVarArr[2] = new e(30, new d(43, 24), new d(22, 25));
        eVarArr[3] = new e(30, new d(10, 15), new d(67, 16));
        r0[38] = new c(39, iArr, eVarArr);
        iArr = new int[]{6, 30, 58, 86, 114, 142, 170};
        eVarArr = new e[4];
        eVarArr[0] = new e(30, new d(19, 118), new d(6, 119));
        eVarArr[1] = new e(28, new d(18, 47), new d(31, 48));
        eVarArr[2] = new e(30, new d(34, 24), new d(34, 25));
        eVarArr[3] = new e(30, new d(20, 15), new d(61, 16));
        r0[39] = new c(40, iArr, eVarArr);
        return r0;
    }

    public int a() {
        return this.c;
    }

    public e a(a aVar) {
        return this.e[aVar.ordinal()];
    }

    public int b() {
        return this.f;
    }

    public int c() {
        return (this.c * 4) + 17;
    }

    public String toString() {
        return String.valueOf(this.c);
    }
}
