package android.support.v4.view;

class bh implements Runnable {
    final /* synthetic */ ViewPager f301a;

    bh(ViewPager viewPager) {
        this.f301a = viewPager;
    }

    public void run() {
        this.f301a.setScrollState(0);
        this.f301a.m307c();
    }
}
