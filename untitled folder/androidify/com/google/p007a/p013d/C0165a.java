package com.google.p007a.p013d;

import com.google.p007a.C0131a;
import com.google.p007a.C0134g;
import com.google.p007a.C0149b;
import com.google.p007a.p008a.C0129b;
import com.google.p007a.p013d.p014a.C0160a;
import com.google.p007a.p013d.p015b.C0167b;
import com.google.p007a.p013d.p015b.C0168c;
import com.google.p007a.p013d.p015b.C0172g;
import java.util.Map;

/* renamed from: com.google.a.d.a */
public final class C0165a implements C0134g {
    private static C0129b m1031a(C0172g c0172g, int i, int i2, int i3) {
        C0167b a = c0172g.m1087a();
        if (a == null) {
            throw new IllegalStateException();
        }
        int b = a.m1040b();
        int a2 = a.m1036a();
        int i4 = (i3 << 1) + b;
        int i5 = (i3 << 1) + a2;
        int max = Math.max(i, i4);
        int max2 = Math.max(i2, i5);
        int min = Math.min(max / i4, max2 / i5);
        i5 = (max - (b * min)) / 2;
        i4 = (max2 - (a2 * min)) / 2;
        C0129b c0129b = new C0129b(max, max2);
        max2 = i4;
        for (int i6 = 0; i6 < a2; i6++) {
            max = 0;
            i4 = i5;
            while (max < b) {
                if (a.m1035a(max, i6) == 1) {
                    c0129b.m944a(i4, max2, min, min);
                }
                max++;
                i4 += min;
            }
            max2 += min;
        }
        return c0129b;
    }

    public C0129b m1032a(String str, C0131a c0131a, int i, int i2, Map map) {
        if (str.length() == 0) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (c0131a != C0131a.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got " + c0131a);
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i + 'x' + i2);
        } else {
            int intValue;
            C0160a c0160a = C0160a.L;
            if (map != null) {
                C0160a c0160a2 = (C0160a) map.get(C0149b.ERROR_CORRECTION);
                if (c0160a2 != null) {
                    c0160a = c0160a2;
                }
                Integer num = (Integer) map.get(C0149b.MARGIN);
                if (num != null) {
                    intValue = num.intValue();
                    return C0165a.m1031a(C0168c.m1048a(str, c0160a, map), i, i2, intValue);
                }
            }
            intValue = 4;
            return C0165a.m1031a(C0168c.m1048a(str, c0160a, map), i, i2, intValue);
        }
    }
}
