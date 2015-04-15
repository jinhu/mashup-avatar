package it.sephiroth.android.library.widget;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ListAdapter;
import com.google.android.apps.androidify.cm;

@TargetApi(14)
class j extends AccessibilityDelegate {
    final /* synthetic */ AbsHListView a;

    j(AbsHListView absHListView) {
        this.a = absHListView;
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        int a = this.a.a(view);
        ListAdapter listAdapter = (ListAdapter) this.a.getAdapter();
        if (a != -1 && listAdapter != null && this.a.isEnabled() && listAdapter.isEnabled(a)) {
            if (a == this.a.getSelectedItemPosition()) {
                accessibilityNodeInfo.setSelected(true);
                accessibilityNodeInfo.addAction(8);
            } else {
                accessibilityNodeInfo.addAction(4);
            }
            if (this.a.isClickable()) {
                accessibilityNodeInfo.addAction(16);
                accessibilityNodeInfo.setClickable(true);
            }
            if (this.a.isLongClickable()) {
                accessibilityNodeInfo.addAction(32);
                accessibilityNodeInfo.setLongClickable(true);
            }
        }
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        int a = this.a.a(view);
        ListAdapter listAdapter = (ListAdapter) this.a.getAdapter();
        if (a == -1 || listAdapter == null) {
            return false;
        }
        if (!this.a.isEnabled() || !listAdapter.isEnabled(a)) {
            return false;
        }
        long h = this.a.h(a);
        switch (i) {
            case cm.HListView_hlv_footerDividersEnabled /*4*/:
                if (this.a.getSelectedItemPosition() == a) {
                    return false;
                }
                this.a.setSelection(a);
                return true;
            case cm.ExpandableHListView_hlv_childIndicatorPaddingTop /*8*/:
                if (this.a.getSelectedItemPosition() != a) {
                    return false;
                }
                this.a.setSelection(-1);
                return true;
            case 16:
                return this.a.isClickable() ? this.a.a(view, a, h) : false;
            case 32:
                return this.a.isLongClickable() ? this.a.c(view, a, h) : false;
            default:
                return false;
        }
    }
}
