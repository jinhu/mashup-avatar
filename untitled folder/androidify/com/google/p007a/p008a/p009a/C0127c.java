package com.google.p007a.p008a.p009a;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.a.a.a.c */
public final class C0127c {
    private final C0125a f443a;
    private final List f444b;

    public C0127c(C0125a c0125a) {
        if (C0125a.f430e.equals(c0125a)) {
            this.f443a = c0125a;
            this.f444b = new ArrayList();
            this.f444b.add(new C0126b(c0125a, new int[]{1}));
            return;
        }
        throw new IllegalArgumentException("Only QR Code is supported at this time");
    }

    private C0126b m931a(int i) {
        if (i >= this.f444b.size()) {
            C0126b c0126b = (C0126b) this.f444b.get(this.f444b.size() - 1);
            C0126b c0126b2 = c0126b;
            for (int size = this.f444b.size(); size <= i; size++) {
                c0126b2 = c0126b2.m928b(new C0126b(this.f443a, new int[]{1, this.f443a.m917a(size - 1)}));
                this.f444b.add(c0126b2);
            }
        }
        return (C0126b) this.f444b.get(i);
    }

    public void m932a(int[] iArr, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("No error correction bytes");
        }
        int length = iArr.length - i;
        if (length <= 0) {
            throw new IllegalArgumentException("No data bytes provided");
        }
        C0126b a = m931a(i);
        Object obj = new int[length];
        System.arraycopy(iArr, 0, obj, 0, length);
        obj = new C0126b(this.f443a, obj).m924a(i, 1).m930c(a)[1].m926a();
        int length2 = i - obj.length;
        for (int i2 = 0; i2 < length2; i2++) {
            iArr[length + i2] = 0;
        }
        System.arraycopy(obj, 0, iArr, length + length2, obj.length);
    }
}
