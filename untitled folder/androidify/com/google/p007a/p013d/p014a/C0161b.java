package com.google.p007a.p013d.p014a;

/* renamed from: com.google.a.d.a.b */
public enum C0161b {
    TERMINATOR(new int[]{0, 0, 0}, 0),
    NUMERIC(new int[]{10, 12, 14}, 1),
    ALPHANUMERIC(new int[]{9, 11, 13}, 2),
    STRUCTURED_APPEND(new int[]{0, 0, 0}, 3),
    BYTE(new int[]{8, 16, 16}, 4),
    ECI(new int[]{0, 0, 0}, 7),
    KANJI(new int[]{8, 10, 12}, 8),
    FNC1_FIRST_POSITION(new int[]{0, 0, 0}, 5),
    FNC1_SECOND_POSITION(new int[]{0, 0, 0}, 9),
    HANZI(new int[]{8, 10, 12}, 13);
    
    private final int[] f576k;
    private final int f577l;

    private C0161b(int[] iArr, int i) {
        this.f576k = iArr;
        this.f577l = i;
    }

    public int m1017a() {
        return this.f577l;
    }

    public int m1018a(C0162c c0162c) {
        int a = c0162c.m1021a();
        a = a <= 9 ? 0 : a <= 26 ? 1 : 2;
        return this.f576k[a];
    }
}
