package com.google.a.d.a;

public enum b {
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
    
    private final int[] k;
    private final int l;

    private b(int[] iArr, int i) {
        this.k = iArr;
        this.l = i;
    }

    public int a() {
        return this.l;
    }

    public int a(c cVar) {
        int a = cVar.a();
        a = a <= 9 ? 0 : a <= 26 ? 1 : 2;
        return this.k[a];
    }
}
