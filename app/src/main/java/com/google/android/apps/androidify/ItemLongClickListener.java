package com.google.android.apps.androidify;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;

/**
 * Created by jin on 4/26/15.
 */
public class ItemLongClickListener implements AdapterView.OnItemLongClickListener {
    public ItemLongClickListener(Activity aActivity) {
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        return false;
    }
}
