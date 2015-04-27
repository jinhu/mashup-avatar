package it.sephiroth.android.library.widget;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ListAdapter;
import com.google.android.apps.androidify.cm;

@TargetApi(14)
/* renamed from: it.sephiroth.android.library.widget.j */
class C0285j extends AccessibilityDelegate {
    final /* synthetic */ AbsHListView f1980a;

    C0285j(AbsHListView absHListView) {
        this.f1980a = absHListView;
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        int a = this.f1980a.m2141a(view);
        ListAdapter listAdapter = (ListAdapter) this.f1980a.getAdapter();
        if (a != -1 && listAdapter != null && this.f1980a.isEnabled() && listAdapter.isEnabled(a)) {
            if (a == this.f1980a.getSelectedItemPosition()) {
                accessibilityNodeInfo.setSelected(true);
                accessibilityNodeInfo.addAction(8);
            } else {
                accessibilityNodeInfo.addAction(4);
            }
            if (this.f1980a.isClickable()) {
                accessibilityNodeInfo.addAction(16);
                accessibilityNodeInfo.setClickable(true);
            }
            if (this.f1980a.isLongClickable()) {
                accessibilityNodeInfo.addAction(32);
                accessibilityNodeInfo.setLongClickable(true);
            }
        }
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        int a = this.f1980a.m2141a(view);
        ListAdapter listAdapter = (ListAdapter) this.f1980a.getAdapter();
        if (a == -1 || listAdapter == null) {
            return false;
        }
        if (!this.f1980a.isEnabled() || !listAdapter.isEnabled(a)) {
            return false;
        }
        long h = this.f1980a.m2144h(a);
        switch (i) {
            case cm.HListView_hlv_footerDividersEnabled /*4*/:
                if (this.f1980a.getSelectedItemPosition() == a) {
                    return false;
                }
                this.f1980a.setSelection(a);
                return true;
            case cm.ExpandableHListView_hlv_childIndicatorPaddingTop /*8*/:
                if (this.f1980a.getSelectedItemPosition() != a) {
                    return false;
                }
                this.f1980a.setSelection(-1);
                return true;
            case 16:
                return this.f1980a.isClickable() ? this.f1980a.m2202a(view, a, h) : false;
            case 32:
                return this.f1980a.isLongClickable() ? this.f1980a.m2210c(view, a, h) : false;
            default:
                return false;
        }
    }
}
