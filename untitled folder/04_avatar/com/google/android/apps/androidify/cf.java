package com.google.android.apps.androidify;

import android.os.AsyncTask;
import com.google.android.apps.androidify.a.a;
import com.google.android.apps.androidify.a.e;

class cf extends AsyncTask {
    final /* synthetic */ int a;
    final /* synthetic */ DrawView b;
    final /* synthetic */ ce c;

    cf(ce ceVar, int i, DrawView drawView) {
        this.c = ceVar;
        this.a = i;
        this.b = drawView;
    }

    protected e a(Void[] voidArr) {
        return a.a(this.c.f, ce.d[this.a]);
    }

    protected void a(e eVar) {
        this.c.g[this.a] = eVar;
        c.a("MOTION Loaded motion for pos " + this.a);
        if (this.b.getTag().equals(Integer.valueOf(this.a))) {
            this.b.setMotion(eVar);
            if (!this.c.a) {
                this.b.setShowPoster(true);
            }
            c.a("MOTION Pos = " + this.a + ", current = " + this.c.c);
            if (this.c.j != null && this.a == this.c.c) {
                c.a("MOTION  Setting motion in preview.");
                this.c.j.setMotion(eVar);
            }
        }
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((e) obj);
    }
}
