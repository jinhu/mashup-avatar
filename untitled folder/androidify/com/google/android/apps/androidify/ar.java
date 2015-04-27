package com.google.android.apps.androidify;

class ar implements Runnable {
    final /* synthetic */ av f1239a;
    final /* synthetic */ an f1240b;

    ar(an anVar, av avVar) {
        this.f1240b = anVar;
        this.f1239a = avVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        if (this.f1240b.f1229l == null || !this.f1240b.f1229l.f1265q) {
            if (this.f1239a != null && this.f1239a.f1265q) {
            }
        } else if (this.f1239a != null) {
        }
        if (this.f1239a != null && this.f1239a.f1265q) {
            this.f1240b.f1220c.m1400p().m1458a(this.f1239a);
        }
        this.f1240b.f1229l = this.f1239a;
        if (this.f1240b.f1229l != null) {
            this.f1240b.f1224g.setAdapter(this.f1240b.f1229l.m1743a(this.f1240b));
            int c = this.f1240b.m1724d(this.f1240b.f1229l);
            if (c >= 0) {
                this.f1240b.f1224g.setSelection(c);
                this.f1240b.m1728e();
            }
            this.f1240b.m1707a(this.f1240b.f1225h, true, null);
        }
    }
}
