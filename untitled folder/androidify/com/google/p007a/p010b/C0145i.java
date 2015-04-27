package com.google.p007a.p010b;

import com.google.p007a.C0131a;
import com.google.p007a.p008a.C0129b;
import java.util.Map;

/* renamed from: com.google.a.b.i */
public final class C0145i extends C0143p {
    public C0129b m969a(String str, C0131a c0131a, int i, int i2, Map map) {
        if (c0131a == C0131a.EAN_8) {
            return super.m956a(str, c0131a, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_8, but got " + c0131a);
    }

    public boolean[] m970a(String str) {
        if (str.length() != 8) {
            throw new IllegalArgumentException("Requested contents should be 8 digits long, but got " + str.length());
        }
        int i;
        boolean[] zArr = new boolean[67];
        int a = C0135m.m953a(zArr, 0, C0141o.f510b, true) + 0;
        for (i = 0; i <= 3; i++) {
            a += C0135m.m953a(zArr, a, C0141o.f512d[Integer.parseInt(str.substring(i, i + 1))], false);
        }
        int a2 = a + C0135m.m953a(zArr, a, C0141o.f511c, false);
        for (i = 4; i <= 7; i++) {
            a2 += C0135m.m953a(zArr, a2, C0141o.f512d[Integer.parseInt(str.substring(i, i + 1))], true);
        }
        i = C0135m.m953a(zArr, a2, C0141o.f510b, true) + a2;
        return zArr;
    }
}
