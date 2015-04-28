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
        if (this.mManiView.mAccessoryContainer == null || !this.mManiView.mAccessoryContainer.bool1) {
            if (this.mAccessoriesContainer != null && this.mAccessoriesContainer.bool1) {
            }
        } else if (this.mAccessoriesContainer != null) {
        }
        if (this.mAccessoriesContainer != null && this.mAccessoriesContainer.bool1) {
            //this.mManiView.mAndroidify.getDroidView().setAccessoryType();
        }
        this.mManiView.mAccessoryContainer = this.mAccessoriesContainer;
        if (this.mManiView.mAccessoryContainer != null) {
            this.mManiView.mAndroidDrawer.setAdapter(this.mManiView.mAccessoryContainer.retrieveAdapterFromView(this.mManiView));
            int c = this.mManiView.m1724d(this.mManiView.mAccessoryContainer);
            if (c >= 0) {
                this.mManiView.mCategoryView.setSelection(c);
                this.mManiView.m1728e();
            }
            this.mManiView.m1707a(this.mManiView.f1225h, true, null);
        }
    }
}
