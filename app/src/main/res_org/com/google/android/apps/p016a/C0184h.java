package com.google.android.apps.analytics;

/* renamed from: com.google.android.apps.a.h */
class C0184h {
    final long f630a;
    final String f631b;
    final String f632c;
    final String f633d;
    final String f634e;
    final int f635f;
    final int f636g;
    final int f637h;
    C0181e f638i;
    private int f639j;
    private int f640k;
    private int f641l;
    private int f642m;
    private int f643n;
    private int f644o;
    private int f645p;
    private boolean f646q;
    private boolean f647r;
    private ac f648s;
    private C0192p f649t;

    C0184h(long j, String str, int i, int i2, int i3, int i4, int i5, String str2, String str3, String str4, int i6, int i7, int i8) {
        this.f630a = j;
        this.f631b = str;
        this.f639j = i;
        this.f641l = i2;
        this.f642m = i3;
        this.f643n = i4;
        this.f644o = i5;
        this.f632c = str2;
        this.f633d = str3;
        this.f634e = str4;
        this.f635f = i6;
        this.f637h = i8;
        this.f636g = i7;
        this.f645p = -1;
        this.f647r = false;
    }

    C0184h(C0184h c0184h, String str) {
        this(c0184h.f630a, str, c0184h.f639j, c0184h.f641l, c0184h.f642m, c0184h.f643n, c0184h.f644o, c0184h.f632c, c0184h.f633d, c0184h.f634e, c0184h.f635f, c0184h.f636g, c0184h.f637h);
        this.f640k = c0184h.f640k;
        this.f645p = c0184h.f645p;
        this.f646q = c0184h.f646q;
        this.f647r = c0184h.f647r;
        this.f638i = c0184h.f638i;
        this.f648s = c0184h.f648s;
        this.f649t = c0184h.f649t;
    }

    C0184h(String str, String str2, String str3, String str4, int i, int i2, int i3) {
        this(-1, str, -1, -1, -1, -1, -1, str2, str3, str4, i, i2, i3);
    }

    int m1151a() {
        return this.f639j;
    }

    void m1152a(int i) {
        this.f639j = i;
    }

    public void m1153a(ac acVar) {
        if (this.f632c.equals("__##GOOGLETRANSACTION##__")) {
            this.f648s = acVar;
            return;
        }
        throw new IllegalStateException("Attempted to add a transction to an event of type " + this.f632c);
    }

    public void m1154a(C0181e c0181e) {
        this.f638i = c0181e;
    }

    public void m1155a(C0192p c0192p) {
        if (this.f632c.equals("__##GOOGLEITEM##__")) {
            this.f649t = c0192p;
            return;
        }
        throw new IllegalStateException("Attempted to add an item to an event of type " + this.f632c);
    }

    void m1156a(boolean z) {
        this.f646q = z;
    }

    int m1157b() {
        return this.f640k;
    }

    void m1158b(int i) {
        this.f640k = i;
    }

    void m1159b(boolean z) {
        this.f647r = z;
    }

    int m1160c() {
        return this.f641l;
    }

    void m1161c(int i) {
        this.f641l = i;
    }

    int m1162d() {
        return this.f642m;
    }

    void m1163d(int i) {
        this.f642m = i;
    }

    int m1164e() {
        return this.f643n;
    }

    void m1165e(int i) {
        this.f643n = i;
    }

    int m1166f() {
        return this.f644o;
    }

    void m1167f(int i) {
        this.f644o = i;
    }

    int m1168g() {
        return this.f645p;
    }

    void m1169g(int i) {
        this.f645p = i;
    }

    boolean m1170h() {
        return this.f646q;
    }

    boolean m1171i() {
        return this.f647r;
    }

    public C0181e m1172j() {
        return this.f638i;
    }

    public ac m1173k() {
        return this.f648s;
    }

    public C0192p m1174l() {
        return this.f649t;
    }

    public boolean m1175m() {
        return this.f641l != -1;
    }

    public String toString() {
        return "id:" + this.f630a + " " + "random:" + this.f639j + " " + "timestampCurrent:" + this.f643n + " " + "timestampPrevious:" + this.f642m + " " + "timestampFirst:" + this.f641l + " " + "visits:" + this.f644o + " " + "value:" + this.f635f + " " + "category:" + this.f632c + " " + "action:" + this.f633d + " " + "label:" + this.f634e + " " + "width:" + this.f636g + " " + "height:" + this.f637h;
    }
}
