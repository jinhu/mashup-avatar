package com.google.android.apps.androidify;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.preference.PreferenceManager;

class db implements OnClickListener {
    final /* synthetic */ ShareToWebsiteSubmitFormActivity a;

    db(ShareToWebsiteSubmitFormActivity shareToWebsiteSubmitFormActivity) {
        this.a = shareToWebsiteSubmitFormActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        PreferenceManager.getDefaultSharedPreferences(this.a).edit().putBoolean("ACCEPTED_TERMS", true).commit();
        this.a.a();
    }
}
