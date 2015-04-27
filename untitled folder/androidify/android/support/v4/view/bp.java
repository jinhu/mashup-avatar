package android.support.v4.view;

import android.database.DataSetObserver;

class bp extends DataSetObserver {
    final /* synthetic */ ViewPager f314a;

    private bp(ViewPager viewPager) {
        this.f314a = viewPager;
    }

    public void onChanged() {
        this.f314a.m306b();
    }

    public void onInvalidated() {
        this.f314a.m306b();
    }
}
