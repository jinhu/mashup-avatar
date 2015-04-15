package com.google.a.b;

import com.google.a.a;
import com.google.a.a.b;
import com.google.a.c;
import java.util.Map;

public final class h extends p {
    public b a(String str, a aVar, int i, int i2, Map map) {
        if (aVar == a.EAN_13) {
            return super.a(str, aVar, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_13, but got " + aVar);
    }

    public boolean[] a(String str) {
        if (str.length() != 13) {
            throw new IllegalArgumentException("Requested contents should be 13 digits long, but got " + str.length());
        }
        try {
            if (o.a(str)) {
                int i;
                int parseInt;
                int i2 = g.a[Integer.parseInt(str.substring(0, 1))];
                boolean[] zArr = new boolean[95];
                int a = m.a(zArr, 0, o.b, true) + 0;
                for (i = 1; i <= 6; i++) {
                    parseInt = Integer.parseInt(str.substring(i, i + 1));
                    if (((i2 >> (6 - i)) & 1) == 1) {
                        parseInt += 10;
                    }
                    a += m.a(zArr, a, o.e[parseInt], false);
                }
                i = a + m.a(zArr, a, o.c, false);
                for (parseInt = 7; parseInt <= 12; parseInt++) {
                    i += m.a(zArr, i, o.d[Integer.parseInt(str.substring(parseInt, parseInt + 1))], true);
                }
                parseInt = m.a(zArr, i, o.b, true) + i;
                return zArr;
            }
            throw new IllegalArgumentException("Contents do not pass checksum");
        } catch (c e) {
            throw new IllegalArgumentException("Illegal contents");
        }
    }
}
