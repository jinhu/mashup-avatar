package com.google.android.apps.androidify;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class ca implements OnItemClickListener {
    final /* synthetic */ MotionActivity f1478a;

    ca(MotionActivity motionActivity) {
        this.f1478a = motionActivity;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (this.f1478a.f886c != cd.EXPORTING) {
            this.f1478a.f884a.setVisibility(0);
            this.f1478a.m1522a(this.f1478a.f894k);
            DrawView drawView = (DrawView) view;
            drawView.setShowPoster(false);
            drawView.setBackgroundResource(R.drawable.btn_bg_selected_gallery);
            this.f1478a.f893j = i;
            this.f1478a.f885b.m1926b(i);
        }
    }
}
