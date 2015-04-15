package com.google.a.b;

import com.google.a.a;
import com.google.a.a.b;
import java.util.Map;

public final class i extends p {
    public b a(String str, a aVar, int i, int i2, Map map) {
        if (aVar == a.EAN_8) {
            return super.a(str, aVar, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_8, but got " + aVar);
    }

    public boolean[] a(String str) {
        if (str.length() != 8) {
            throw new IllegalArgumentException("Requested contents should be 8 digits long, but got " + str.length());
        }
        int i;
        boolean[] zArr = new boolean[67];
        int a = m.a(zArr, 0, o.b, true) + 0;
        for (i = 0; i <= 3; i++) {
            a += m.a(zArr, a, o.d[Integer.parseInt(str.substring(i, i + 1))], false);
        }
        int a2 = a + m.a(zArr, a, o.c, false);
        for (i = 4; i <= 7; i++) {
            a2 += m.a(zArr, a2, o.d[Integer.parseInt(str.substring(i, i + 1))], true);
        }
        i = m.a(zArr, a2, o.b, true) + a2;
        return zArr;
    }
}
