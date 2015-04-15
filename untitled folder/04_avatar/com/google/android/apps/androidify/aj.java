package com.google.android.apps.androidify;

import android.annotation.TargetApi;
import android.graphics.RectF;
import android.text.Layout.Alignment;
import android.text.StaticLayout;

class aj implements ak {
    final /* synthetic */ AutoResizeTextView a;

    aj(AutoResizeTextView autoResizeTextView) {
        this.a = autoResizeTextView;
    }

    @TargetApi(16)
    public int a(int i, RectF rectF) {
        this.a.d.setTextSize((float) i);
        CharSequence charSequence = this.a.getText().toString();
        if (this.a.getMaxLines() == 1) {
            this.a.a.bottom = this.a.d.getFontSpacing();
            this.a.a.right = this.a.d.measureText(charSequence);
        } else {
            StaticLayout staticLayout = new StaticLayout(charSequence, this.a.d, this.a.i, Alignment.ALIGN_NORMAL, this.a.f, this.a.g, true);
            if (this.a.getMaxLines() != -1 && staticLayout.getLineCount() > this.a.getMaxLines()) {
                return 1;
            }
            this.a.a.bottom = (float) staticLayout.getHeight();
            int i2 = -1;
            for (int i3 = 0; i3 < staticLayout.getLineCount(); i3++) {
                if (((float) i2) < staticLayout.getLineWidth(i3)) {
                    i2 = (int) staticLayout.getLineWidth(i3);
                }
            }
            this.a.a.right = (float) i2;
        }
        this.a.a.offsetTo(0.0f, 0.0f);
        return rectF.contains(this.a.a) ? -1 : 1;
    }
}
