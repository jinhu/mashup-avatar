package com.google.android.apps.androidify;

import android.view.View;
import android.view.View.OnClickListener;

class cb implements OnClickListener {
    final /* synthetic */ MotionActivity a;

    cb(MotionActivity motionActivity) {
        this.a = motionActivity;
    }

    public void onClick(View view) {
        this.a.a(this.a.b, view);
    }
}
