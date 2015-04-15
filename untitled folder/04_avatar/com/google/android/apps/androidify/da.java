package com.google.android.apps.androidify;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class da implements OnClickListener {
    final /* synthetic */ ShareToWebsiteSubmitFormActivity a;

    da(ShareToWebsiteSubmitFormActivity shareToWebsiteSubmitFormActivity) {
        this.a = shareToWebsiteSubmitFormActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.a.a();
    }
}
