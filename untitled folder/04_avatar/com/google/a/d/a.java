package com.google.a.d;

import com.google.a.a.b;
import com.google.a.d.b.c;
import com.google.a.g;
import java.util.Map;

public final class a implements g {
    private static b a(com.google.a.d.b.g gVar, int i, int i2, int i3) {
        com.google.a.d.b.b a = gVar.a();
        if (a == null) {
            throw new IllegalStateException();
        }
        int b = a.b();
        int a2 = a.a();
        int i4 = (i3 << 1) + b;
        int i5 = (i3 << 1) + a2;
        int max = Math.max(i, i4);
        int max2 = Math.max(i2, i5);
        int min = Math.min(max / i4, max2 / i5);
        i5 = (max - (b * min)) / 2;
        i4 = (max2 - (a2 * min)) / 2;
        b bVar = new b(max, max2);
        max2 = i4;
        for (int i6 = 0; i6 < a2; i6++) {
            max = 0;
            i4 = i5;
            while (max < b) {
                if (a.a(max, i6) == 1) {
                    bVar.a(i4, max2, min, min);
                }
                max++;
                i4 += min;
            }
            max2 += min;
        }
        return bVar;
    }

    public b a(String str, com.google.a.a aVar, int i, int i2, Map map) {
        if (str.length() == 0) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (aVar != com.google.a.a.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got " + aVar);
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i + 'x' + i2);
        } else {
            int intValue;
            com.google.a.d.a.a aVar2 = com.google.a.d.a.a.L;
            if (map != null) {
                com.google.a.d.a.a aVar3 = (com.google.a.d.a.a) map.get(com.google.a.b.ERROR_CORRECTION);
                if (aVar3 != null) {
                    aVar2 = aVar3;
                }
                Integer num = (Integer) map.get(com.google.a.b.MARGIN);
                if (num != null) {
                    intValue = num.intValue();
                    return a(c.a(str, aVar2, map), i, i2, intValue);
                }
            }
            intValue = 4;
            return a(c.a(str, aVar2, map), i, i2, intValue);
        }
    }
}
