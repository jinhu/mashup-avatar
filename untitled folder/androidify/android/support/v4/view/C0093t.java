package android.support.v4.view;

import android.view.KeyEvent;

/* renamed from: android.support.v4.view.t */
class C0093t implements C0092w {
    C0093t() {
    }

    private static int m710a(int i, int i2, int i3, int i4, int i5) {
        Object obj = 1;
        Object obj2 = (i2 & i3) != 0 ? 1 : null;
        int i6 = i4 | i5;
        if ((i2 & i6) == 0) {
            obj = null;
        }
        if (obj2 == null) {
            return obj != null ? i & (i3 ^ -1) : i;
        } else {
            if (obj == null) {
                return i & (i6 ^ -1);
            }
            throw new IllegalArgumentException("bad arguments");
        }
    }

    public int m711a(int i) {
        int i2 = (i & 192) != 0 ? i | 1 : i;
        if ((i2 & 48) != 0) {
            i2 |= 2;
        }
        return i2 & 247;
    }

    public void m712a(KeyEvent keyEvent) {
    }

    public boolean m713a(int i, int i2) {
        return C0093t.m710a(C0093t.m710a(m711a(i) & 247, i2, 1, 64, 128), i2, 2, 16, 32) == i2;
    }

    public boolean m714b(int i) {
        return (m711a(i) & 247) == 0;
    }
}
