package com.google.android.apps.a;

class d {
    private final int a;
    private final String b;
    private final String c;
    private final int d;

    public d(int i, String str, String str2, int i2) {
        if (i2 != 1 && i2 != 2 && i2 != 3) {
            throw new IllegalArgumentException("Invalid Scope:" + i2);
        } else if (i < 1 || i > 5) {
            throw new IllegalArgumentException("Index must be between 1 and 5 inclusive.");
        } else if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Invalid argument for name:  Cannot be empty");
        } else if (str2 == null || str2.length() == 0) {
            throw new IllegalArgumentException("Invalid argument for value:  Cannot be empty");
        } else {
            int length = c.a(str + str2).length();
            if (length > 64) {
                throw new IllegalArgumentException("Encoded form of name and value must not exceed 64 characters combined.  Character length: " + length);
            }
            this.d = i;
            this.a = i2;
            this.b = str;
            this.c = str2;
        }
    }

    public int a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }
}
