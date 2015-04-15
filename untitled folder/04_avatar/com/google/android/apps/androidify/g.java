package com.google.android.apps.androidify;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.TextView;

class g implements OnFocusChangeListener {
    final /* synthetic */ Androidify a;

    g(Androidify androidify) {
        this.a = androidify;
    }

    public void onFocusChange(View view, boolean z) {
        if (z) {
            this.a.U.postDelayed(new h(this), 50);
            return;
        }
        this.a.U.setHint(R.string.no_name);
        if (this.a.U.getText().length() == 0) {
            c.a("Not renaming/saving android because name is empty.");
            this.a.X();
            return;
        }
        TextView textView = (TextView) view;
        c.a("Android name is now " + textView.getText());
        this.a.a(Androidify.a);
        Androidify.a.g(textView.getText().toString());
        this.a.d(Androidify.a);
        this.a.V();
        this.a.Y();
    }
}
