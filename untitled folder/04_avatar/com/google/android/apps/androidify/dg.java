package com.google.android.apps.androidify;

import android.os.AsyncTask;

class dg extends AsyncTask {
    final /* synthetic */ ShareToWebsiteSubmitFormActivity a;

    private dg(ShareToWebsiteSubmitFormActivity shareToWebsiteSubmitFormActivity) {
        this.a = shareToWebsiteSubmitFormActivity;
    }

    protected Object doInBackground(Object[] objArr) {
        this.a.c();
        return null;
    }

    protected void onPostExecute(Object obj) {
        if (this.a.i == df.ERROR) {
            this.a.b();
            this.a.d();
            return;
        }
        if (this.a.h) {
            this.a.startActivity(QRCodeActivity.a(this.a, this.a.j, this.a.g));
        } else {
            ShareToWebsiteResolveActivity.a(this.a, this.a.j);
        }
        this.a.b();
    }
}
