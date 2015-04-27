package com.google.android.apps.androidify;

import android.os.AsyncTask;
import com.google.android.apps.androidify.p018a.C0204a;
import com.google.android.apps.androidify.p018a.C0208e;

class cf extends AsyncTask {
    final /* synthetic */ int f1496a;
    final /* synthetic */ DrawView f1497b;
    final /* synthetic */ ce f1498c;

    cf(ce ceVar, int i, DrawView drawView) {
        this.f1498c = ceVar;
        this.f1496a = i;
        this.f1497b = drawView;
    }

    protected C0208e m1927a(Void[] voidArr) {
        return C0204a.m1596a(this.f1498c.f1490f, ce.f1485d[this.f1496a]);
    }

    protected void m1928a(C0208e c0208e) {
        this.f1498c.f1491g[this.f1496a] = c0208e;
        C0220c.m1912a("MOTION Loaded motion for pos " + this.f1496a);
        if (this.f1497b.getTag().equals(Integer.valueOf(this.f1496a))) {
            this.f1497b.setMotion(c0208e);
            if (!this.f1498c.f1486a) {
                this.f1497b.setShowPoster(true);
            }
            C0220c.m1912a("MOTION Pos = " + this.f1496a + ", current = " + this.f1498c.f1488c);
            if (this.f1498c.f1494j != null && this.f1496a == this.f1498c.f1488c) {
                C0220c.m1912a("MOTION  Setting motion in preview.");
                this.f1498c.f1494j.setMotion(c0208e);
            }
        }
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m1927a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m1928a((C0208e) obj);
    }
}
