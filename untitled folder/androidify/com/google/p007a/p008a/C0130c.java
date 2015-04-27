package com.google.p007a.p008a;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.a.a.c */
public enum C0130c {
    Cp437((String) new int[]{0, 2}, (int) new String[0]),
    ISO8859_1((String) new int[]{1, 3}, (int) new String[]{"ISO-8859-1"}),
    ISO8859_2((String) 4, (int) new String[]{"ISO-8859-2"}),
    ISO8859_3((String) 5, (int) new String[]{"ISO-8859-3"}),
    ISO8859_4((String) 6, (int) new String[]{"ISO-8859-4"}),
    ISO8859_5((String) 7, (int) new String[]{"ISO-8859-5"}),
    ISO8859_6((String) 8, (int) new String[]{"ISO-8859-6"}),
    ISO8859_7((String) 9, (int) new String[]{"ISO-8859-7"}),
    ISO8859_8((String) 10, (int) new String[]{"ISO-8859-8"}),
    ISO8859_9((String) 11, (int) new String[]{"ISO-8859-9"}),
    ISO8859_10((String) 12, (int) new String[]{"ISO-8859-10"}),
    ISO8859_11((String) 13, (int) new String[]{"ISO-8859-11"}),
    ISO8859_13((String) 15, (int) new String[]{"ISO-8859-13"}),
    ISO8859_14((String) 16, (int) new String[]{"ISO-8859-14"}),
    ISO8859_15((String) 17, (int) new String[]{"ISO-8859-15"}),
    ISO8859_16((String) 18, (int) new String[]{"ISO-8859-16"}),
    SJIS((String) 20, (int) new String[]{"Shift_JIS"}),
    Cp1250((String) 21, (int) new String[]{"windows-1250"}),
    Cp1251((String) 22, (int) new String[]{"windows-1251"}),
    Cp1252((String) 23, (int) new String[]{"windows-1252"}),
    Cp1256((String) 24, (int) new String[]{"windows-1256"}),
    UnicodeBigUnmarked((String) 25, (int) new String[]{"UTF-16BE", "UnicodeBig"}),
    UTF8((String) 26, (int) new String[]{"UTF-8"}),
    ASCII((String) new int[]{27, 170}, (int) new String[]{"US-ASCII"}),
    Big5(28),
    GB18030((String) 29, (int) new String[]{"GB2312", "EUC_CN", "GBK"}),
    EUC_KR((String) 30, (int) new String[]{"EUC-KR"});
    
    private static final Map f452B;
    private static final Map f453C;
    private final int[] f481D;
    private final String[] f482E;

    static {
        f452B = new HashMap();
        f453C = new HashMap();
        for (C0130c c0130c : C0130c.values()) {
            for (int valueOf : c0130c.f481D) {
                f452B.put(Integer.valueOf(valueOf), c0130c);
            }
            f453C.put(c0130c.name(), c0130c);
            for (Object put : c0130c.f482E) {
                f453C.put(put, c0130c);
            }
        }
    }

    private C0130c(int i) {
        this(r3, r4, new int[]{i}, new String[0]);
    }

    private C0130c(int i, String... strArr) {
        this.f481D = new int[]{i};
        this.f482E = strArr;
    }

    private C0130c(int[] iArr, String... strArr) {
        this.f481D = iArr;
        this.f482E = strArr;
    }

    public static C0130c m949a(String str) {
        return (C0130c) f453C.get(str);
    }

    public int m950a() {
        return this.f481D[0];
    }
}
