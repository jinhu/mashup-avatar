package com.google.android.apps.androidify;

class bd implements Runnable {
    final /* synthetic */ DroidBaseAdapter mDroidBaseAdapter;

    bd(DroidBaseAdapter aDroidBaseAdapterVar) {
        this.mDroidBaseAdapter = aDroidBaseAdapterVar;
    }

    public void run() {
        for (int i = 3; i < this.mDroidBaseAdapter.mSvgs.size(); i++) {
            DroidView droidView = (bs) this.mDroidBaseAdapter.mSvgs.get(i);
            //this.mDroidBaseAdapter.f1393b.m1373a(droidView, (az) this.mDroidBaseAdapter.f1392a.get(i));
            droidView.postInvalidate();
        }
    }
}
