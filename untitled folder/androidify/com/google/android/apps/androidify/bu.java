package com.google.android.apps.androidify;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class bu {
    public static void m1894a(View view, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        int i = 0;
        ((TextView) view.findViewById(R.id.tv_header_main)).setText(str);
        ((ImageButton) view.findViewById(R.id.btn_menu_burger)).setVisibility(z ? 0 : 4);
        ((ImageButton) view.findViewById(R.id.btn_share)).setVisibility(z2 ? 0 : 4);
        ((ImageButton) view.findViewById(R.id.btn_close)).setVisibility(z3 ? 0 : 4);
        ((ImageButton) view.findViewById(R.id.btn_edit)).setVisibility(z4 ? 0 : 4);
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.btn_menu_back);
        if (!z5) {
            i = 4;
        }
        imageButton.setVisibility(i);
    }
}
