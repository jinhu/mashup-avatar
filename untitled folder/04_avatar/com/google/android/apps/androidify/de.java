package com.google.android.apps.androidify;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class de implements OnKeyListener {
    final /* synthetic */ ShareToWebsiteSubmitFormActivity a;

    de(ShareToWebsiteSubmitFormActivity shareToWebsiteSubmitFormActivity) {
        this.a = shareToWebsiteSubmitFormActivity;
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        return i == 84 && keyEvent.getRepeatCount() == 0;
    }
}
