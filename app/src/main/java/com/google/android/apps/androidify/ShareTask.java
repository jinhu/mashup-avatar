package com.google.android.apps.androidify;

import android.os.AsyncTask;

class ShareTask extends AsyncTask {
    /* synthetic */ ShareToWebsiteSubmitFormActivity f1571a;

    ShareTask(ShareToWebsiteSubmitFormActivity shareToWebsiteSubmitFormActivity) {
        this.f1571a = shareToWebsiteSubmitFormActivity;
    }

    public ShareTask() {

    }

    protected Object doInBackground(Object[] objArr) {
        try {
            this.f1571a.m1572c();
        } catch (Throwable aThrowable) {
            aThrowable.printStackTrace();
        }
        return null;
    }

    protected void onPostExecute(Object obj) {
        if (this.f1571a.mResultState == ResultState.ERROR) {
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
