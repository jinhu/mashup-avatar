package com.google.android.apps.androidify;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class ItemClickListener implements OnItemClickListener, it.sephiroth.android.library.widget.AdapterView.OnItemClickListener {
    final /* synthetic */ Activity mActivity;

    ItemClickListener(Activity anActivity) {
        this.mActivity = anActivity;
    }

    public ItemClickListener(ManiView aManiView, Androidify anActivity) {
        this.mActivity = anActivity;


    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
//        if (this.mActivity.f886c != ControlState.EXPORTING) {
//            this.mActivity.f884a.setVisibility(0);
//            this.mActivity.m1522a(this.mActivity.f894k);
//            DrawView drawView = (DrawView) view;
//            drawView.setShowPoster(false);
//            drawView.setBackgroundResource(R.drawable.btn_bg_selected_gallery);
//            this.mActivity.f893j = i;
//            this.mActivity.f885b.m1926b(i);
//        }
    }

    @Override
    public void onItemClick(it.sephiroth.android.library.widget.AdapterView<?> aAdapterView, View aView, int i, long l) {

    }

    public void last() {

    }

    public void next() {

    }

    public boolean m1631a() {
        return false;
    }
}
