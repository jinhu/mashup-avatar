package com.google.android.apps.androidify;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.preference.PreferenceManager;

class db implements OnClickListener {
    final /* synthetic */ ShareToWebsiteSubmitFormActivity f1562a;

    db(ShareToWebsiteSubmitFormActivity shareToWebsiteSubmitFormActivity) {
        this.f1562a = shareToWebsiteSubmitFormActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        PreferenceManager.getDefaultSharedPreferences(this.f1562a).edit().putBoolean("ACCEPTED_TERMS", true).commit();
        this.f1562a.m1578a();
    }
}
