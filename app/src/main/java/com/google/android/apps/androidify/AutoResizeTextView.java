package com.google.android.apps.androidify;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.widget.TextView;

import dev.game.legend.avatar.R;

public class AutoResizeTextView extends TextView {
    private RectF f786a;
    private RectF f787b;
    private SparseIntArray f788c;
    private TextPaint f789d;
    private float f790e;
    private float f791f;
    private float f792g;
    private float f793h;
    private int f794i;
    private int f795j;
    private boolean f796k;
    private boolean f797l;
    //private final ak f798m;

    public AutoResizeTextView(Context context) {
        this(context, null, 0);
    }

    public AutoResizeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoResizeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f786a = new RectF();
        this.f791f = 1.0f;
        this.f792g = 0.0f;
        this.f793h = 20.0f;
        this.f796k = true;
        //this.f798m = new aj(this);
        m1410a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, HListViewConstants.TextViewCompat, i, 0);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                m1411a(context, string);
            }
            obtainStyledAttributes.recycle();
        }
        setPaintFlags((getPaintFlags() | 128) | 1);
    }

    private int determineSize(int i, int i2, Object akVar, RectF rectF) {
        if (!this.f796k) {
            return m1413b(i, i2, akVar, rectF);
        }
        String charSequence = getText().toString();
        int length = charSequence == null ? 0 : charSequence.length();
        int i3 = this.f788c.get(length);
        if (i3 != 0) {
            return i3;
        }
        i3 = m1413b(i, i2, akVar, rectF);
        this.f788c.put(length, i3);
        return i3;
    }

    public static Typeface m1408a(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "fonts/and_black.ttf");
    }

    private void m1410a() {
        this.f789d = new TextPaint(getPaint());
        this.f790e = getTextSize();
        this.f787b = new RectF();
        this.f788c = new SparseIntArray();
        if (this.f795j == 0) {
            this.f795j = -1;
        }
        this.f797l = true;
    }

    private void m1411a(Context context, String str) {
        int style = getTypeface() != null ? getTypeface().getStyle() : 0;
        if (m1417b(str)) {
            setTypeface(Typeface.create(str, style));
            return;
        }
        Util.debug(str + " " + style);
        try {
            Typeface b = str.equals("and-light") ? m1415b(context) : str.equals("and-black") ? m1408a(context) : null;
            if (b != null) {
                setTypeface(b);
                if (this.f789d != null) {
                    this.f789d.setTypeface(b);
                }
            }
        } catch (Throwable e) {
            com.google.android.Util.error("Error when setting custom typeface.", e);
        }
    }

    private void m1412a(String str) {
        if (this.f797l) {
            int i = (int) this.f793h;
            int measuredHeight = (getMeasuredHeight() - getCompoundPaddingBottom()) - getCompoundPaddingTop();
            this.f794i = (getMeasuredWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight();
            this.f787b.right = (float) this.f794i;
            this.f787b.bottom = (float) measuredHeight;
            getTextSize();
            super.setTextSize(0, (float) determineSize(i, (int) this.f790e, 123, this.f787b));
        }
    }

    private static int m1413b(int current, int max, Object akVar, RectF rectF) {
        int i3 = max - 1;
        int i4 = current;
        int i5 = current;
        while (i4 <= i3) {
            i5 = (i4 + i3) >>> 1;
            int a = 1;//akVar.m1691a(i5, rectF);
            if (a < 0) {
                i5++;
            } else if (a <= 0) {
                return i5;
            } else {
                i3 = i5 - 1;
                i5 = i4;
                i4 = i3;
            }
            int i6 = i5;
            i5 = i4;
            i4 = i6;
        }
        return i5;
    }

    public static Typeface m1415b(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "fonts/and_light.otf");
    }

    private void m1416b() {
        m1412a(getText().toString());
    }

    private boolean m1417b(String str) {
        return (str.equals("sans-serif-light") && VERSION.SDK_INT >= 16) || ((str.equals("sans-serif-condensed") && VERSION.SDK_INT >= 16) || (str.equals("sans-serif-thin") && VERSION.SDK_INT >= 18));
    }

    public int getMaxLines() {
        return this.f795j;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m1416b();
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        this.f788c.clear();
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            m1416b();
        }
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        m1416b();
    }

    public void setLineSpacing(float f, float f2) {
        super.setLineSpacing(f, f2);
        this.f791f = f2;
        this.f792g = f;
    }

    public void setLines(int i) {
        super.setLines(i);
        this.f795j = i;
        m1416b();
    }

    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.f795j = i;
        m1416b();
    }

    public void setMinTextSize(float f) {
        this.f793h = f;
        m1416b();
    }

    public void setSingleLine() {
        super.setSingleLine();
        this.f795j = 1;
        m1416b();
    }

    public void setSingleLine(boolean z) {
        super.setSingleLine(z);
        if (z) {
            this.f795j = 1;
        } else {
            this.f795j = -1;
        }
        m1416b();
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        super.setText(charSequence, bufferType);
        m1412a(charSequence.toString());
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, new int[]{R.attr.custom_font});
        if (obtainStyledAttributes != null && obtainStyledAttributes.hasValue(0)) {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                m1411a(context, string);
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void setTextSize(float f) {
        this.f790e = f;
        this.f788c.clear();
        m1412a(getText().toString());
    }

    public void setTextSize(int i, float f) {
        Context context = getContext();
        this.f790e = TypedValue.applyDimension(i, f, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics());
        this.f788c.clear();
        m1412a(getText().toString());
    }
}
