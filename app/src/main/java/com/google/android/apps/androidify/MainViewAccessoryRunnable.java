package com.google.android.apps.androidify;

class MainViewAccessoryRunnable implements Runnable {
    final /* synthetic */ AccessoriesContainer mAccessoriesContainer;
    final /* synthetic */ ManiView mManiView;

    MainViewAccessoryRunnable(ManiView aManiViewVar, AccessoriesContainer aAccessoriesContainerVar) {
        this.mManiView = aManiViewVar;
        this.mAccessoriesContainer = aAccessoriesContainerVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        if (this.mManiView.f1229l == null || !this.mManiView.f1229l.f1265q) {
            if (this.mAccessoriesContainer != null && this.mAccessoriesContainer.f1265q) {
            }
        } else if (this.mAccessoriesContainer != null) {
        }
        if (this.mAccessoriesContainer != null && this.mAccessoriesContainer.f1265q) {
            //this.mManiView.mAndroidify.getDroidView().setAccessoryType();
        }
        this.mManiView.f1229l = this.mAccessoriesContainer;
        if (this.mManiView.f1229l != null) {
            this.mManiView.mAndroidDrawer.setAdapter(this.mManiView.f1229l.retrieveAdapterFromView(this.mManiView));
            int c = this.mManiView.m1724d(this.mManiView.f1229l);
            if (c >= 0) {
                this.mManiView.mCategoryView.setSelection(c);
                this.mManiView.m1728e();
            }
            this.mManiView.m1707a(this.mManiView.f1225h, true, null);
        }
    }
}