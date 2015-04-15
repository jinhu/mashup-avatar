package com.google.android.apps.a;

class h {
    final long a;
    final String b;
    final String c;
    final String d;
    final String e;
    final int f;
    final int g;
    final int h;
    e i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private boolean q;
    private boolean r;
    private ac s;
    private p t;

    h(long j, String str, int i, int i2, int i3, int i4, int i5, String str2, String str3, String str4, int i6, int i7, int i8) {
        this.a = j;
        this.b = str;
        this.j = i;
        this.l = i2;
        this.m = i3;
        this.n = i4;
        this.o = i5;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = i6;
        this.h = i8;
        this.g = i7;
        this.p = -1;
        this.r = false;
    }

    h(h hVar, String str) {
        this(hVar.a, str, hVar.j, hVar.l, hVar.m, hVar.n, hVar.o, hVar.c, hVar.d, hVar.e, hVar.f, hVar.g, hVar.h);
        this.k = hVar.k;
        this.p = hVar.p;
        this.q = hVar.q;
        this.r = hVar.r;
        this.i = hVar.i;
        this.s = hVar.s;
        this.t = hVar.t;
    }

    h(String str, String str2, String str3, String str4, int i, int i2, int i3) {
        this(-1, str, -1, -1, -1, -1, -1, str2, str3, str4, i, i2, i3);
    }

    int a() {
        return this.j;
    }

    void a(int i) {
        this.j = i;
    }

    public void a(ac acVar) {
        if (this.c.equals("__##GOOGLETRANSACTION##__")) {
            this.s = acVar;
            return;
        }
        throw new IllegalStateException("Attempted to add a transction to an event of type " + this.c);
    }

    public void a(e eVar) {
        this.i = eVar;
    }

    public void a(p pVar) {
        if (this.c.equals("__##GOOGLEITEM##__")) {
            this.t = pVar;
            return;
        }
        throw new IllegalStateException("Attempted to add an item to an event of type " + this.c);
    }

    void a(boolean z) {
        this.q = z;
    }

    int b() {
        return this.k;
    }

    void b(int i) {
        this.k = i;
    }

    void b(boolean z) {
        this.r = z;
    }

    int c() {
        return this.l;
    }

    void c(int i) {
        this.l = i;
    }

    int d() {
        return this.m;
    }

    void d(int i) {
        this.m = i;
    }

    int e() {
        return this.n;
    }

    void e(int i) {
        this.n = i;
    }

    int f() {
        return this.o;
    }

    void f(int i) {
        this.o = i;
    }

    int g() {
        return this.p;
    }

    void g(int i) {
        this.p = i;
    }

    boolean h() {
        return this.q;
    }

    boolean i() {
        return this.r;
    }

    public e j() {
        return this.i;
    }

    public ac k() {
        return this.s;
    }

    public p l() {
        return this.t;
    }

    public boolean m() {
        return this.l != -1;
    }

    public String toString() {
        return "id:" + this.a + " " + "random:" + this.j + " " + "timestampCurrent:" + this.n + " " + "timestampPrevious:" + this.m + " " + "timestampFirst:" + this.l + " " + "visits:" + this.o + " " + "value:" + this.f + " " + "category:" + this.c + " " + "action:" + this.d + " " + "label:" + this.e + " " + "width:" + this.g + " " + "height:" + this.h;
    }
}
