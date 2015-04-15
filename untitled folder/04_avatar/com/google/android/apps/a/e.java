package com.google.android.apps.a;

class e {
    private d[] a;

    public e() {
        this.a = new d[5];
    }

    private void d(int i) {
        if (i < 1 || i > 5) {
            throw new IllegalArgumentException("Index must be between 1 and 5 inclusive.");
        }
    }

    public void a(d dVar) {
        d(dVar.d());
        this.a[dVar.d() - 1] = dVar;
    }

    public boolean a(int i) {
        d(i);
        return this.a[i + -1] == null;
    }

    public d[] a() {
        return (d[]) this.a.clone();
    }

    public d b(int i) {
        d(i);
        return this.a[i - 1];
    }

    public boolean b() {
        for (d dVar : this.a) {
            if (dVar != null) {
                return true;
            }
        }
        return false;
    }

    public void c(int i) {
        d(i);
        this.a[i - 1] = null;
    }
}
