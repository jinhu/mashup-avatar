package com.google.android.apps.androidify;

import android.content.SharedPreferences;

/* renamed from: com.google.android.apps.androidify.w */
class C0240w implements Runnable {
    final /* synthetic */ Androidify f1668a;

    C0240w(Androidify androidify) {
        this.f1668a = androidify;
    }

    public void run() {
        SharedPreferences preferences = this.f1668a.getPreferences(0);
        this.f1668a.m1369z();
        if (!preferences.contains("SAW_TUTORIAL")) {
            preferences.edit().putBoolean("SAW_TUTORIAL", true).apply();
            this.f1668a.f773l.setTutorialView(this.f1668a.f763X);
            this.f1668a.f773l.m1462b();
            this.f1668a.f763X.setVisibility(0);
        }
    }
}
