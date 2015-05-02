package com.google.android.apps.androidify;

import dev.game.legend.svgandroid.SVG;



public class SvgToStringBinder {
    String name;
    String description;

    SVG mSVG;

    public SvgToStringBinder(String str, String str2, SVG aSVG) {
        this.name = str;
        this.description = str2;
        this.mSVG = aSVG;
    }
}
