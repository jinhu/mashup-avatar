package com.google.p007a.p010b;

import com.google.p007a.C0131a;
import com.google.p007a.C0134g;
import com.google.p007a.C0149b;
import com.google.p007a.p008a.C0129b;
import java.util.Map;

/* renamed from: com.google.a.b.m */
public abstract class C0135m implements C0134g {
    protected static int m953a(boolean[] zArr, int i, int[] iArr, boolean z) {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = i;
        while (i2 < length) {
            int i5 = iArr[i2];
            int i6 = i4;
            i4 = 0;
            while (i4 < i5) {
                int i7 = i6 + 1;
                zArr[i6] = z;
                i4++;
                i6 = i7;
            }
            i3 += i5;
            i2++;
            z = !z;
            i4 = i6;
        }
        return i3;
    }

    private static C0129b m954a(boolean[] zArr, int i, int i2, int i3) {
        int length = zArr.length;
        int i4 = length + i3;
        int max = Math.max(i, i4);
        int max2 = Math.max(1, i2);
        int i5 = max / i4;
        i4 = (max - (length * i5)) / 2;
        C0129b c0129b = new C0129b(max, max2);
        max = 0;
        while (max < length) {
            if (zArr[max]) {
                c0129b.m944a(i4, 0, i5, max2);
            }
            max++;
            i4 += i5;
        }
        return c0129b;
    }

    public int m955a() {
        return 10;
    }

    public C0129b m956a(String str, C0131a c0131a, int i, int i2, Map map) {
        if (str.length() == 0) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Negative size is not allowed. Input: " + i + 'x' + i2);
        } else {
            int intValue;
            int a = m955a();
            if (map != null) {
                Integer num = (Integer) map.get(C0149b.MARGIN);
                if (num != null) {
                    intValue = num.intValue();
                    return C0135m.m954a(m957a(str), i, i2, intValue);
                }
            }
            intValue = a;
            return C0135m.m954a(m957a(str), i, i2, intValue);
        }
    }

    public abstract boolean[] m957a(String str);
}
