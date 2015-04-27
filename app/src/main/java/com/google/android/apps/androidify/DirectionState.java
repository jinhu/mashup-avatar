package com.google.android.apps.androidify;

import dev.game.legend.avatar.R;

public enum DirectionState {
    LEFT(R.drawable.tutorial_arrow_left),
    UP(R.drawable.tutorial_arrow_up),
    RIGHT(R.drawable.tutorial_arrow_right),
    DOWN(R.drawable.tutorial_arrow_down),
    DIAG_LEFT(R.drawable.tutorial_arrow_diag_left);
    
    int mCurrent;

    private DirectionState(int i) {
        this.mCurrent = i;
    }
}
