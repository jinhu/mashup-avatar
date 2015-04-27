package com.google.p007a.p010b;

import com.google.p007a.C0131a;
import com.google.p007a.C0134g;
import com.google.p007a.p008a.C0129b;
import java.util.Map;

/* renamed from: com.google.a.b.n */
public final class C0148n implements C0134g {
    private final C0144h f521a;

    public C0148n() {
        this.f521a = new C0144h();
    }

    private static String m973a(String str) {
        int length = str.length();
        if (length == 11) {
            int i = 0;
            for (length = 0; length < 11; length++) {
                i += (length % 2 == 0 ? 3 : 1) * (str.charAt(length) - 48);
            }
            str = str + ((1000 - i) % 10);
        } else if (length != 12) {
            throw new IllegalArgumentException("Requested contents should be 11 or 12 digits long, but got " + str.length());
        }
        return '0' + str;
    }

    public C0129b m974a(String str, C0131a c0131a, int i, int i2, Map map) {
        if (c0131a == C0131a.UPC_A) {
            return this.f521a.m967a(C0148n.m973a(str), C0131a.EAN_13, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode UPC-A, but got " + c0131a);
    }
}
