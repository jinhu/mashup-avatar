package com.google.android.apps.androidify;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.google.android.apps.androidify.q */
class C0234q implements OnClickListener {
    final /* synthetic */ Androidify f1662a;

    C0234q(Androidify androidify) {
        this.f1662a = androidify;
    }

    public void onClick(View view) {
        this.f1662a.m1394h();
        Intent intent = new Intent(this.f1662a, MenuActivity.class);
        C0220c.m1912a("Override anim");
        this.f1662a.startActivityForResult(intent, 101);
        this.f1662a.overridePendingTransition(R.anim.from_left, R.anim.hold_position);
    }
}
