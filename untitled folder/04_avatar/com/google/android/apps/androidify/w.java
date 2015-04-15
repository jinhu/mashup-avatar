package com.google.android.apps.androidify;

import android.content.SharedPreferences;

class w implements Runnable {
    final /* synthetic */ Androidify a;

    w(Androidify androidify) {
        this.a = androidify;
    }

    public void run() {
        SharedPreferences preferences = this.a.getPreferences(0);
        this.a.z();
        if (!preferences.contains("SAW_TUTORIAL")) {
            preferences.edit().putBoolean("SAW_TUTORIAL", true).apply();
            this.a.l.setTutorialView(this.a.X);
            this.a.l.b();
            this.a.X.setVisibility(0);
        }
    }
}
