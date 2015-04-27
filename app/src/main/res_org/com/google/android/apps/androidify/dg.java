package com.google.android.apps.androidify;

import android.os.AsyncTask;

class dg extends AsyncTask {
    final /* synthetic */ ShareToWebsiteSubmitFormActivity f1571a;

    private dg(ShareToWebsiteSubmitFormActivity shareToWebsiteSubmitFormActivity) {
        this.f1571a = shareToWebsiteSubmitFormActivity;
    }

    protected Object doInBackground(Object[] objArr) {
        this.f1571a.m1572c();
        return null;
    }

    protected void onPostExecute(Object obj) {
        if (this.f1571a.f945i == df.ERROR) {
            this.f1571a.m1579b();
            this.f1571a.m1574d();
            return;
        }
        if (this.f1571a.f944h) {
            this.f1571a.startActivity(QRCodeActivity.m1526a(this.f1571a, this.f1571a.f946j, this.f1571a.f943g));
        } else {
            ShareToWebsiteResolveActivity.m1565a(this.f1571a, this.f1571a.f946j);
        }
        this.f1571a.m1579b();
    }
}
