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
import android.widget.TextView.BufferType;
import com.google.android.a;

public class AutoResizeTextView extends TextView {
    private RectF a;
    private RectF b;
    private SparseIntArray c;
    private TextPaint d;
    private float e;
    private float f;
    private float g;
    private float h;
    private int i;
    private int j;
    private boolean k;
    private boolean l;
    private final ak m;

    public AutoResizeTextView(Context context) {
        this(context, null, 0);
    }

    public AutoResizeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoResizeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new RectF();
        this.f = 1.0f;
        this.g = 0.0f;
        this.h = 20.0f;
        this.k = true;
        this.m = new aj(this);
        a();
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

    private int a(int i, int i2, ak akVar, RectF rectF) {
        if (!this.k) {
            return b(i, i2, akVar, rectF);
        }
        String charSequence = getText().toString();
        int length = charSequence == null ? 0 : charSequence.length();
        int i3 = this.c.get(length);
        if (i3 != 0) {
            return i3;
        }
        i3 = b(i, i2, akVar, rectF);
        this.c.put(length, i3);
        return i3;
    }

    public static Typeface a(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "fonts/and_black.ttf");
    }

    private void a() {
        this.d = new TextPaint(getPaint());
        this.e = getTextSize();
        this.b = new RectF();
        this.c = new SparseIntArray();
        if (this.j == 0) {
            this.j = -1;
        }
        this.l = true;
    }

    private void a(Context context, String str) {
        int style = getTypeface() != null ? getTypeface().getStyle() : 0;
        if (b(str)) {
            setTypeface(Typeface.create(str, style));
            return;
        }
        c.a(str + " " + style);
        try {
            Typeface b = str.equals("and-light") ? b(context) : str.equals("and-black") ? a(context) : null;
            if (b != null) {
                setTypeface(b);
                if (this.d != null) {
                    this.d.setTypeface(b);
                }
            }
        } catch (Throwable e) {
            a.a("Error when setting custom typeface.", e);
        }
    }

    private void a(String str) {
        if (this.l) {
            int i = (int) this.h;
            int measuredHeight = (getMeasuredHeight() - getCompoundPaddingBottom()) - getCompoundPaddingTop();
            this.i = (getMeasuredWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight();
            this.b.right = (float) this.i;
            this.b.bottom = (float) measuredHeight;
            getTextSize();
            super.setTextSize(0, (float) a(i, (int) this.e, this.m, this.b));
        }
    }

    private static int b(int i, int i2, ak akVar, RectF rectF) {
        int i3 = i2 - 1;
        int i4 = i;
        int i5 = i;
        while (i4 <= i3) {
            i5 = (i4 + i3) >>> 1;
            int a = akVar.a(i5, rectF);
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

    public static Typeface b(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "fonts/and_light.otf");
    }

    private void b() {
        a(getText().toString());
    }

    private boolean b(String str) {
        return (str.equals("sans-serif-light") && VERSION.SDK_INT >= 16) || ((str.equals("sans-serif-condensed") && VERSION.SDK_INT >= 16) || (str.equals("sans-serif-thin") && VERSION.SDK_INT >= 18));
    }

    public int getMaxLines() {
        return this.j;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        b();
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        this.c.clear();
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            b();
        }
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        b();
    }

    public void setLineSpacing(float f, float f2) {
        super.setLineSpacing(f, f2);
        this.f = f2;
        this.g = f;
    }

    public void setLines(int i) {
        super.setLines(i);
        this.j = i;
        b();
    }

    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.j = i;
        b();
    }

    public void setMinTextSize(float f) {
        this.h = f;
        b();
    }

    public void setSingleLine() {
        super.setSingleLine();
        this.j = 1;
        b();
    }

    public void setSingleLine(boolean z) {
        super.setSingleLine(z);
        if (z) {
            this.j = 1;
        } else {
            this.j = -1;
        }
        b();
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        super.setText(charSequence, bufferType);
        a(charSequence.toString());
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

    public void setTextSize(float f) {
        this.e = f;
        this.c.clear();
        a(getText().toString());
    }

    public void setTextSize(int i, float f) {
        Context context = getContext();
        this.e = TypedValue.applyDimension(i, f, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics());
        this.c.clear();
        a(getText().toString());
    }
}
