package com.google.android.apps.androidify;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.TextView;

/* renamed from: com.google.android.apps.androidify.g */
class C0224g implements OnFocusChangeListener {
    final /* synthetic */ Androidify f1646a;

    C0224g(Androidify androidify) {
        this.f1646a = androidify;
    }

    public void onFocusChange(View view, boolean z) {
        if (z) {
            this.f1646a.f760U.postDelayed(new C0225h(this), 50);
            return;
        }
        this.f1646a.f760U.setHint(R.string.no_name);
        if (this.f1646a.f760U.getText().length() == 0) {
            C0220c.m1912a("Not renaming/saving android because name is empty.");
            this.f1646a.m1329X();
            return;
        }
        TextView textView = (TextView) view;
        C0220c.m1912a("Android name is now " + textView.getText());
        this.f1646a.m1375a(Androidify.f741a);
        Androidify.f741a.m1804g(textView.getText().toString());
        this.f1646a.m1352d(Androidify.f741a);
        this.f1646a.m1327V();
        this.f1646a.m1330Y();
    }
}
