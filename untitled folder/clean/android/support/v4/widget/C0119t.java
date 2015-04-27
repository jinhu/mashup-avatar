package android.support.v4.widget;

import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* renamed from: android.support.v4.widget.t */
class C0119t extends C0118s {
    private Method f390a;
    private Field f391b;

    C0119t() {
        try {
            this.f390a = View.class.getDeclaredMethod("getDisplayList", (Class[]) null);
        } catch (Throwable e) {
            Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", e);
        }
        try {
            this.f391b = View.class.getDeclaredField("mRecreateDisplayList");
            this.f391b.setAccessible(true);
        } catch (Throwable e2) {
            Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", e2);
        }
    }

    public void m866a(SlidingPaneLayout slidingPaneLayout, View view) {
        if (this.f390a == null || this.f391b == null) {
            view.invalidate();
            return;
        }
        try {
            this.f391b.setBoolean(view, true);
            this.f390a.invoke(view, (Object[]) null);
        } catch (Throwable e) {
            Log.e("SlidingPaneLayout", "Error refreshing display list state", e);
        }
        super.m865a(slidingPaneLayout, view);
    }
}
