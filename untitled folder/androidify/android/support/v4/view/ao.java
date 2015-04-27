package android.support.v4.view;

import android.graphics.Paint;
import android.view.View;

class ao extends an {
    ao() {
    }

    long m573a() {
        return aw.m590a();
    }

    public void m574a(View view, int i, Paint paint) {
        aw.m591a(view, i, paint);
    }

    public void m575a(View view, Paint paint) {
        m574a(view, m576d(view), paint);
        view.invalidate();
    }

    public int m576d(View view) {
        return aw.m589a(view);
    }
}
