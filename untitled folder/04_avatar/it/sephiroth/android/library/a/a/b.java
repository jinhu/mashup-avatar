package it.sephiroth.android.library.a.a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import it.sephiroth.android.library.widget.AbsHListView;

public class b implements a {
    private a a;
    private AbsHListView b;

    public b(AbsHListView absHListView) {
        this.b = absHListView;
    }

    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        this.a.a(actionMode, i, j, z);
        if (this.b.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }

    public void a(a aVar) {
        this.a = aVar;
    }

    public boolean a() {
        return this.a != null;
    }

    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.a.onActionItemClicked(actionMode, menuItem);
    }

    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (!this.a.onCreateActionMode(actionMode, menu)) {
            return false;
        }
        this.b.setLongClickable(false);
        return true;
    }

    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.a.onDestroyActionMode(actionMode);
        this.b.c = null;
        this.b.a();
        this.b.ai = true;
        this.b.w();
        this.b.requestLayout();
        this.b.setLongClickable(true);
    }

    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.a.onPrepareActionMode(actionMode, menu);
    }
}
