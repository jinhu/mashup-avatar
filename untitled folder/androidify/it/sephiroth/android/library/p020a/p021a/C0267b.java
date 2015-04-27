package it.sephiroth.android.library.p020a.p021a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import it.sephiroth.android.library.widget.AbsHListView;

/* renamed from: it.sephiroth.android.library.a.a.b */
public class C0267b implements C0266a {
    private C0266a f1827a;
    private AbsHListView f1828b;

    public C0267b(AbsHListView absHListView) {
        this.f1828b = absHListView;
    }

    @TargetApi(11)
    public void m2114a(ActionMode actionMode, int i, long j, boolean z) {
        this.f1827a.m2113a(actionMode, i, j, z);
        if (this.f1828b.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }

    public void m2115a(C0266a c0266a) {
        this.f1827a = c0266a;
    }

    public boolean m2116a() {
        return this.f1827a != null;
    }

    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.f1827a.onActionItemClicked(actionMode, menuItem);
    }

    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (!this.f1827a.onCreateActionMode(actionMode, menu)) {
            return false;
        }
        this.f1828b.setLongClickable(false);
        return true;
    }

    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.f1827a.onDestroyActionMode(actionMode);
        this.f1828b.f1871c = null;
        this.f1828b.m2194a();
        this.f1828b.ai = true;
        this.f1828b.m2151w();
        this.f1828b.requestLayout();
        this.f1828b.setLongClickable(true);
    }

    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.f1827a.onPrepareActionMode(actionMode, menu);
    }
}
