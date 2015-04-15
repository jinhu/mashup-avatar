package com.google.android.apps.androidify;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.TextView;
import com.google.android.a;

public class TextViewCompat extends TextView {
    public TextViewCompat(Context context) {
        this(context, null, 0);
    }

    public TextViewCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextViewCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cm.TextViewCompat, i, 0);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                a(context, string);
            }
            obtainStyledAttributes.recycle();
        }
        setPaintFlags((getPaintFlags() | 128) | 1);
    }

    public static Typeface a(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "fonts/and_black.ttf");
    }

    private void a(Context context, String str) {
        int style = getTypeface() != null ? getTypeface().getStyle() : 0;
        if (a(str)) {
            setTypeface(Typeface.create(str, style));
            return;
        }
        c.a(str + " " + style);
        try {
            Typeface b = str.equals("and-light") ? b(context) : str.equals("and-black") ? a(context) : null;
            if (b != null) {
                setTypeface(b);
            }
        } catch (Throwable e) {
            a.a("Error when setting custom typeface.", e);
        }
    }

    private boolean a(String str) {
        return (str.equals("sans-serif-light") && VERSION.SDK_INT >= 16) || ((str.equals("sans-serif-condensed") && VERSION.SDK_INT >= 16) || (str.equals("sans-serif-thin") && VERSION.SDK_INT >= 18));
    }

    public static Typeface b(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "fonts/and_light.otf");
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, new int[]{R.attr.custom_font});
        if (obtainStyledAttributes != null && obtainStyledAttributes.hasValue(0)) {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                a(context, string);
            }
            obtainStyledAttributes.recycle();
        }
    }
}
