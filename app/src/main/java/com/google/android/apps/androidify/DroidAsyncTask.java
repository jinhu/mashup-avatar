package com.google.android.apps.androidify;

import android.os.AsyncTask;

import com.google.android.apps.androidify.p018a.AnimationCatalogue;

class DroidAsyncTask extends AsyncTask {
    final /* synthetic */ int f1496a;
    final /* synthetic */ DrawView f1497b;
    final /* synthetic */ AndroidModelAdapter f1498c;

    DroidAsyncTask(AndroidModelAdapter aAndroidModelAdapterVar, int i, DrawView drawView) {
        this.f1498c = aAndroidModelAdapterVar;
        this.f1496a = i;
        this.f1497b = drawView;

    }

    protected AnimationCatalogue m1927a(Void[] voidArr) {
        return null;//C0204a.getAnimationCatalogue(this.f1498c.f1490f, AndroidModelAdapter.f1485d[this.f1496a]);
    }

    protected void m1928a(AnimationCatalogue aAnimationCatalogue) {
//        this.f1498c.f1491g[this.f1496a] = c0208e;
//        Log.debug("MOTION Loaded motion for pos " + this.f1496a);
//        if (this.f1497b.getTag().equals(Integer.valueOf(this.f1496a))) {
//            this.f1497b.setMotion(c0208e);
//            if (!this.f1498c.f1486a) {
//                this.f1497b.setShowPoster(true);
//            }
//            Log.debug("MOTION Pos = " + this.f1496a + ", current = " + this.f1498c.f1488c);
//            if (this.f1498c.f1494j != null && this.f1496a == this.f1498c.f1488c) {
//                Log.debug("MOTION  Setting motion in preview.");
//                this.f1498c.f1494j.setMotion(c0208e);
//            }
//        }
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m1927a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m1928a((AnimationCatalogue) obj);
    }
}
