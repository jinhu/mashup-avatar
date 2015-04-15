package com.google.android.apps.androidify;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class q implements OnClickListener {
    final /* synthetic */ Androidify a;

    q(Androidify androidify) {
        this.a = androidify;
    }

    public void onClick(View view) {
        this.a.h();
        Intent intent = new Intent(this.a, MenuActivity.class);
        c.a("Override anim");
        this.a.startActivityForResult(intent, 101);
        this.a.overridePendingTransition(R.anim.from_left, R.anim.hold_position);
    }
}
