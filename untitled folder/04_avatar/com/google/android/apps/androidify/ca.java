package com.google.android.apps.androidify;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class ca implements OnItemClickListener {
    final /* synthetic */ MotionActivity a;

    ca(MotionActivity motionActivity) {
        this.a = motionActivity;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (this.a.c != cd.EXPORTING) {
            this.a.a.setVisibility(0);
            this.a.a(this.a.k);
            DrawView drawView = (DrawView) view;
            drawView.setShowPoster(false);
            drawView.setBackgroundResource(R.drawable.btn_bg_selected_gallery);
            this.a.j = i;
            this.a.b.b(i);
        }
    }
}
