package it.sephiroth.android.library.widget;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.view.View;
import android.view.ViewConfiguration;

/* renamed from: it.sephiroth.android.library.widget.f */
final class C0281f implements Runnable {
    final /* synthetic */ AbsHListView f1969a;

    C0281f(AbsHListView absHListView) {
        this.f1969a = absHListView;
    }

    public void run() {
        if (this.f1969a.f1855F == 0) {
            this.f1969a.f1855F = 1;
            View childAt = this.f1969a.getChildAt(this.f1969a.f1850A - this.f1969a.V);
            if (childAt != null && !childAt.hasFocusable()) {
                this.f1969a.f1876h = 0;
                if (this.f1969a.ai) {
                    this.f1969a.f1855F = 2;
                    return;
                }
                childAt.setPressed(true);
                this.f1969a.setPressed(true);
                this.f1969a.m2214e();
                this.f1969a.m2196a(this.f1969a.f1850A, childAt);
                this.f1969a.refreshDrawableState();
                int longPressTimeout = ViewConfiguration.getLongPressTimeout();
                boolean isLongClickable = this.f1969a.isLongClickable();
                if (this.f1969a.f1881m != null) {
                    Drawable current = this.f1969a.f1881m.getCurrent();
                    if (current != null && (current instanceof TransitionDrawable)) {
                        if (isLongClickable) {
                            ((TransitionDrawable) current).startTransition(longPressTimeout);
                        } else {
                            ((TransitionDrawable) current).resetTransition();
                        }
                    }
                }
                if (isLongClickable) {
                    if (this.f1969a.aA == null) {
                        this.f1969a.aA = new C0280e(null);
                    }
                    this.f1969a.aA.m2384a();
                    this.f1969a.postDelayed(this.f1969a.aA, (long) longPressTimeout);
                    return;
                }
                this.f1969a.f1855F = 2;
            }
        }
    }
}
