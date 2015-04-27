package com.google.android.apps.analytics;

/* renamed from: com.google.android.apps.a.d */
class C0180d {
    private final int f625a;
    private final String f626b;
    private final String f627c;
    private final int f628d;

    public C0180d(int i, String str, String str2, int i2) {
        if (i2 != 1 && i2 != 2 && i2 != 3) {
            throw new IllegalArgumentException("Invalid Scope:" + i2);
        } else if (i < 1 || i > 5) {
            throw new IllegalArgumentException("Index must be between 1 and 5 inclusive.");
        } else if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Invalid argument for name:  Cannot be empty");
        } else if (str2 == null || str2.length() == 0) {
            throw new IllegalArgumentException("Invalid argument for value:  Cannot be empty");
        } else {
            int length = C0179c.m1133a(str + str2).length();
            if (length > 64) {
                throw new IllegalArgumentException("Encoded form of name and value must not exceed 64 characters combined.  Character length: " + length);
            }
            this.f628d = i;
            this.f625a = i2;
            this.f626b = str;
            this.f627c = str2;
        }
    }

    public int m1135a() {
        return this.f625a;
    }

    public String m1136b() {
        return this.f626b;
    }

    public String m1137c() {
        return this.f627c;
    }

    public int m1138d() {
        return this.f628d;
    }
}
