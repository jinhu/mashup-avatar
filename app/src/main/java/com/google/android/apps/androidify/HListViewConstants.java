package com.google.android.apps.androidify;

import dev.game.legend.avatar.R;

public final class HListViewConstants {
    public static final int[] AbsHListView;
    public static final int AbsHListView_android_cacheColorHint = 3;
    public static final int AbsHListView_android_choiceMode = 4;
    public static final int AbsHListView_android_drawSelectorOnTop = 1;
    public static final int AbsHListView_android_listSelector = 0;
    public static final int AbsHListView_android_scrollingCache = 2;
    public static final int AbsHListView_android_smoothScrollbar = 5;
    public static final int AbsHListView_hlv_stackFromRight = 6;
    public static final int AbsHListView_hlv_transcriptMode = 7;
    public static final int[] ExpandableHListView;
    public static final int ExpandableHListView_hlv_childDivider = 2;
    public static final int ExpandableHListView_hlv_childIndicator = 4;
    public static final int ExpandableHListView_hlv_childIndicatorGravity = 1;
    public static final int ExpandableHListView_hlv_childIndicatorPaddingLeft = 7;
    public static final int ExpandableHListView_hlv_childIndicatorPaddingTop = 8;
    public static final int ExpandableHListView_hlv_groupIndicator = 3;
    public static final int ExpandableHListView_hlv_indicatorGravity = 0;
    public static final int ExpandableHListView_hlv_indicatorPaddingLeft = 5;
    public static final int ExpandableHListView_hlv_indicatorPaddingTop = 6;
    public static final int[] HListView;
    public static final int HListView_android_divider = 1;
    public static final int HListView_android_entries = 0;
    public static final int HListView_hlv_dividerWidth = 2;
    public static final int HListView_hlv_footerDividersEnabled = 4;
    public static final int HListView_hlv_headerDividersEnabled = 3;
    public static final int HListView_hlv_measureWithChild = 7;
    public static final int HListView_hlv_overScrollFooter = 6;
    public static final int HListView_hlv_overScrollHeader = 5;
    public static final int[] TextViewCompat;
    public static final int TextViewCompat_custom_font = 0;

    static {
        AbsHListView = new int[]{16843003, 16843004, 16843006, 16843009, 16843051, 16843313, R.attr.hlv_stackFromRight, R.attr.hlv_transcriptMode};
        ExpandableHListView = new int[]{R.attr.hlv_indicatorGravity, R.attr.hlv_childIndicatorGravity, R.attr.hlv_childDivider, R.attr.hlv_groupIndicator, R.attr.hlv_childIndicator, R.attr.hlv_indicatorPaddingLeft, R.attr.hlv_indicatorPaddingTop, R.attr.hlv_childIndicatorPaddingLeft, R.attr.hlv_childIndicatorPaddingTop};
        HListView = new int[]{16842930, 16843049, R.attr.hlv_dividerWidth, R.attr.hlv_headerDividersEnabled, R.attr.hlv_footerDividersEnabled, R.attr.hlv_overScrollHeader, R.attr.hlv_overScrollFooter, R.attr.hlv_measureWithChild};
        int[] iArr = new int[HListView_android_divider];
        iArr[HListView_android_entries] = R.attr.custom_font;
        TextViewCompat = iArr;
    }
}
