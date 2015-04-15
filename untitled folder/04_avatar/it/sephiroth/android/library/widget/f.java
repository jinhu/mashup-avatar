package it.sephiroth.android.library.widget;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.view.View;
import android.view.ViewConfiguration;

final class f implements Runnable {
    final /* synthetic */ AbsHListView a;

    f(AbsHListView absHListView) {
        this.a = absHListView;
    }

    public void run() {
        if (this.a.F == 0) {
            this.a.F = 1;
            View childAt = this.a.getChildAt(this.a.A - this.a.V);
            if (childAt != null && !childAt.hasFocusable()) {
                this.a.h = 0;
                if (this.a.ai) {
                    this.a.F = 2;
                    return;
                }
                childAt.setPressed(true);
                this.a.setPressed(true);
                this.a.e();
                this.a.a(this.a.A, childAt);
                this.a.refreshDrawableState();
                int longPressTimeout = ViewConfiguration.getLongPressTimeout();
                boolean isLongClickable = this.a.isLongClickable();
                if (this.a.m != null) {
                    Drawable current = this.a.m.getCurrent();
                    if (current != null && (current instanceof TransitionDrawable)) {
                        if (isLongClickable) {
                            ((TransitionDrawable) current).startTransition(longPressTimeout);
                        } else {
                            ((TransitionDrawable) current).resetTransition();
                        }
                    }
                }
                if (isLongClickable) {
                    if (this.a.aA == null) {
                        this.a.aA = new e(null);
                    }
                    this.a.aA.a();
                    this.a.postDelayed(this.a.aA, (long) longPressTimeout);
                    return;
                }
                this.a.F = 2;
            }
        }
    }
}
