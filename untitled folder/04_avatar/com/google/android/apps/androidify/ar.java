package com.google.android.apps.androidify;

class ar implements Runnable {
    final /* synthetic */ av a;
    final /* synthetic */ an b;

    ar(an anVar, av avVar) {
        this.b = anVar;
        this.a = avVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        if (this.b.l == null || !this.b.l.q) {
            if (this.a != null && this.a.q) {
            }
        } else if (this.a != null) {
        }
        if (this.a != null && this.a.q) {
            this.b.c.p().a(this.a);
        }
        this.b.l = this.a;
        if (this.b.l != null) {
            this.b.g.setAdapter(this.b.l.a(this.b));
            int c = this.b.d(this.b.l);
            if (c >= 0) {
                this.b.g.setSelection(c);
                this.b.e();
            }
            this.b.a(this.b.h, true, null);
        }
    }
}
