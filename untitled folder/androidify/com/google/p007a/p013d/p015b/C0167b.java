package com.google.p007a.p013d.p015b;

import com.google.android.apps.androidify.cm;
import java.lang.reflect.Array;

/* renamed from: com.google.a.d.b.b */
public final class C0167b {
    private final byte[][] f590a;
    private final int f591b;
    private final int f592c;

    public C0167b(int i, int i2) {
        this.f590a = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{i2, i});
        this.f591b = i;
        this.f592c = i2;
    }

    public byte m1035a(int i, int i2) {
        return this.f590a[i2][i];
    }

    public int m1036a() {
        return this.f592c;
    }

    public void m1037a(byte b) {
        for (int i = 0; i < this.f592c; i++) {
            for (int i2 = 0; i2 < this.f591b; i2++) {
                this.f590a[i][i2] = b;
            }
        }
    }

    public void m1038a(int i, int i2, int i3) {
        this.f590a[i2][i] = (byte) i3;
    }

    public void m1039a(int i, int i2, boolean z) {
        this.f590a[i2][i] = (byte) (z ? 1 : 0);
    }

    public int m1040b() {
        return this.f591b;
    }

    public byte[][] m1041c() {
        return this.f590a;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(((this.f591b * 2) * this.f592c) + 2);
        for (int i = 0; i < this.f592c; i++) {
            for (int i2 = 0; i2 < this.f591b; i2++) {
                switch (this.f590a[i][i2]) {
                    case cm.HListView_android_entries /*0*/:
                        stringBuilder.append(" 0");
                        break;
                    case cm.HListView_android_divider /*1*/:
                        stringBuilder.append(" 1");
                        break;
                    default:
                        stringBuilder.append("  ");
                        break;
                }
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
