package com.google.android.apps.androidify;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.TextView;

import dev.game.legend.avatar.R;

public class TextViewCompat extends TextView {
    public TextViewCompat(Context context) {
        this(context, null, 0);
    }

    public TextViewCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextViewCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, HListViewConstants.TextViewCompat, i, 0);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                m1581a(context, string);
            }
            obtainStyledAttributes.recycle();
        }
        setPaintFlags((getPaintFlags() | 128) | 1);
    }

    public static Typeface createTypeface(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "fonts/and_black.ttf");
    }

    private void m1581a(Context context, String str) {
        int style = getTypeface() != null ? getTypeface().getStyle() : 0;
        if (m1582a(str)) {
            setTypeface(Typeface.create(str, style));
            return;
        }
        Util.debug(str + " " + style);
        try {
            Typeface b = str.equals("and-light") ? m1583b(context) : str.equals("and-black") ? createTypeface(context) : null;
            if (b != null) {
                setTypeface(b);
            }
        } catch (Throwable e) {
            com.google.android.Util.error("Error when setting custom typeface.", e);
        }
    }

    private boolean m1582a(String str) {
        return (str.equals("sans-serif-light") && VERSION.SDK_INT >= 16) || ((str.equals("sans-serif-condensed") && VERSION.SDK_INT >= 16) || (str.equals("sans-serif-thin") && VERSION.SDK_INT >= 18));
    }

    public static Typeface m1583b(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "fonts/and_light.otf");
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, new int[]{R.attr.custom_font});
        if (obtainStyledAttributes != null && obtainStyledAttributes.hasValue(0)) {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                m1581a(context, string);
            }
            obtainStyledAttributes.recycle();
        }
    }
}
