package com.google.android.apps.androidify;

import android.annotation.TargetApi;
import android.graphics.RectF;
import android.text.Layout.Alignment;
import android.text.StaticLayout;

class aj implements ak {
    final /* synthetic */ AutoResizeTextView f1163a;

    aj(AutoResizeTextView autoResizeTextView) {
        this.f1163a = autoResizeTextView;
    }

    @TargetApi(16)
    public int m1692a(int i, RectF rectF) {
        this.f1163a.f789d.setTextSize((float) i);
        CharSequence charSequence = this.f1163a.getText().toString();
        if (this.f1163a.getMaxLines() == 1) {
            this.f1163a.f786a.bottom = this.f1163a.f789d.getFontSpacing();
            this.f1163a.f786a.right = this.f1163a.f789d.measureText(charSequence);
        } else {
            StaticLayout staticLayout = new StaticLayout(charSequence, this.f1163a.f789d, this.f1163a.f794i, Alignment.ALIGN_NORMAL, this.f1163a.f791f, this.f1163a.f792g, true);
            if (this.f1163a.getMaxLines() != -1 && staticLayout.getLineCount() > this.f1163a.getMaxLines()) {
                return 1;
            }
            this.f1163a.f786a.bottom = (float) staticLayout.getHeight();
            int i2 = -1;
            for (int i3 = 0; i3 < staticLayout.getLineCount(); i3++) {
                if (((float) i2) < staticLayout.getLineWidth(i3)) {
                    i2 = (int) staticLayout.getLineWidth(i3);
                }
            }
            this.f1163a.f786a.right = (float) i2;
        }
        this.f1163a.f786a.offsetTo(0.0f, 0.0f);
        return rectF.contains(this.f1163a.f786a) ? -1 : 1;
    }
}
