package com.google.android.apps.androidify;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;

public class AspectPreservingScaleableImageView extends ImageView {
    public AspectPreservingScaleableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int size = MeasureSpec.getSize(i);
            setMeasuredDimension(size, (int) Math.ceil((double) ((((float) size) * ((float) drawable.getIntrinsicHeight())) / ((float) drawable.getIntrinsicWidth()))));
            return;
        }
        super.onMeasure(i, i2);
    }
}
