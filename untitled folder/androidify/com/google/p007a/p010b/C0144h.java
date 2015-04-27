package com.google.p007a.p010b;

import com.google.p007a.C0131a;
import com.google.p007a.C0159c;
import com.google.p007a.p008a.C0129b;
import java.util.Map;

/* renamed from: com.google.a.b.h */
public final class C0144h extends C0143p {
    public C0129b m967a(String str, C0131a c0131a, int i, int i2, Map map) {
        if (c0131a == C0131a.EAN_13) {
            return super.m956a(str, c0131a, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_13, but got " + c0131a);
    }

    public boolean[] m968a(String str) {
        if (str.length() != 13) {
            throw new IllegalArgumentException("Requested contents should be 13 digits long, but got " + str.length());
        }
        try {
            if (C0141o.m965a(str)) {
                int i;
                int parseInt;
                int i2 = C0142g.f514a[Integer.parseInt(str.substring(0, 1))];
                boolean[] zArr = new boolean[95];
                int a = C0135m.m953a(zArr, 0, C0141o.f510b, true) + 0;
                for (i = 1; i <= 6; i++) {
                    parseInt = Integer.parseInt(str.substring(i, i + 1));
                    if (((i2 >> (6 - i)) & 1) == 1) {
                        parseInt += 10;
                    }
                    a += C0135m.m953a(zArr, a, C0141o.f513e[parseInt], false);
                }
                i = a + C0135m.m953a(zArr, a, C0141o.f511c, false);
                for (parseInt = 7; parseInt <= 12; parseInt++) {
                    i += C0135m.m953a(zArr, i, C0141o.f512d[Integer.parseInt(str.substring(parseInt, parseInt + 1))], true);
                }
                parseInt = C0135m.m953a(zArr, i, C0141o.f510b, true) + i;
                return zArr;
            }
            throw new IllegalArgumentException("Contents do not pass checksum");
        } catch (C0159c e) {
            throw new IllegalArgumentException("Illegal contents");
        }
    }
}
