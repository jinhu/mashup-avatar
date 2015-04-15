package com.google.a.c.a;

import com.google.a.a;
import com.google.a.a.b;
import com.google.a.g;
import java.lang.reflect.Array;
import java.util.Map;

public final class h implements g {
    private static b a(e eVar, String str, int i, int i2) {
        int i3;
        eVar.a(str, 2);
        byte[][] a = eVar.a().a(2, 8);
        if (((i2 > i ? 1 : 0) ^ (a[0].length < a.length ? 1 : 0)) != 0) {
            a = b(a);
            i3 = 1;
        } else {
            i3 = 0;
        }
        int length = i / a[0].length;
        int length2 = i2 / a.length;
        if (length >= length2) {
            length = length2;
        }
        if (length <= 1) {
            return a(a);
        }
        byte[][] a2 = eVar.a().a(length * 2, (length * 4) * 2);
        return a(i3 != 0 ? b(a2) : a2);
    }

    private static b a(byte[][] bArr) {
        b bVar = new b(bArr[0].length + 60, bArr.length + 60);
        bVar.a();
        int c = bVar.c() - 30;
        int i = 0;
        while (i < bArr.length) {
            for (int i2 = 0; i2 < bArr[0].length; i2++) {
                if (bArr[i][i2] == 1) {
                    bVar.b(i2 + 30, c);
                }
            }
            i++;
            c--;
        }
        return bVar;
    }

    private static byte[][] b(byte[][] bArr) {
        byte[][] bArr2 = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{bArr[0].length, bArr.length});
        for (int i = 0; i < bArr.length; i++) {
            int length = (bArr.length - i) - 1;
            for (int i2 = 0; i2 < bArr[0].length; i2++) {
                bArr2[i2][length] = bArr[i][i2];
            }
        }
        return bArr2;
    }

    public b a(String str, a aVar, int i, int i2, Map map) {
        if (aVar != a.PDF_417) {
            throw new IllegalArgumentException("Can only encode PDF_417, but got " + aVar);
        }
        e eVar = new e();
        if (map != null) {
            if (map.containsKey(com.google.a.b.PDF417_COMPACT)) {
                eVar.a(((Boolean) map.get(com.google.a.b.PDF417_COMPACT)).booleanValue());
            }
            if (map.containsKey(com.google.a.b.PDF417_COMPACTION)) {
                eVar.a((c) map.get(com.google.a.b.PDF417_COMPACTION));
            }
            if (map.containsKey(com.google.a.b.PDF417_DIMENSIONS)) {
                d dVar = (d) map.get(com.google.a.b.PDF417_DIMENSIONS);
                eVar.a(dVar.b(), dVar.a(), dVar.d(), dVar.c());
            }
        }
        return a(eVar, str, i, i2);
    }
}
