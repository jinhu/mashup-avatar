package com.google.a.b;

import com.google.a.a;
import com.google.a.a.b;
import com.google.a.g;
import java.util.Map;

public final class n implements g {
    private final h a;

    public n() {
        this.a = new h();
    }

    private static String a(String str) {
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

    public b a(String str, a aVar, int i, int i2, Map map) {
        if (aVar == a.UPC_A) {
            return this.a.a(a(str), a.EAN_13, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode UPC-A, but got " + aVar);
    }
}
