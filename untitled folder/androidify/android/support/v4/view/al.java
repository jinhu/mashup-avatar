package android.support.v4.view;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.util.WeakHashMap;

class al implements at {
    WeakHashMap f299a;

    al() {
        this.f299a = null;
    }

    public int m557a(View view) {
        return 2;
    }

    long m558a() {
        return 10;
    }

    public void m559a(View view, int i, int i2, int i3, int i4) {
        view.invalidate(i, i2, i3, i4);
    }

    public void m560a(View view, int i, Paint paint) {
    }

    public void m561a(View view, Paint paint) {
    }

    public void m562a(View view, C0073a c0073a) {
    }

    public void m563a(View view, Runnable runnable) {
        view.postDelayed(runnable, m558a());
    }

    public boolean m564a(View view, int i) {
        return false;
    }

    public void m565b(View view) {
        view.invalidate();
    }

    public void m566b(View view, int i) {
    }

    public int m567c(View view) {
        return 0;
    }

    public int m568d(View view) {
        return 0;
    }

    public int m569e(View view) {
        return 0;
    }

    public boolean m570f(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }
}
