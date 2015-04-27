package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.widget.f */
public class C0105f {
    private static final C0106i f379b;
    private Object f380a;

    static {
        if (VERSION.SDK_INT >= 14) {
            f379b = new C0108h();
        } else {
            f379b = new C0107g();
        }
    }

    public C0105f(Context context) {
        this.f380a = f379b.m814a(context);
    }

    public void m807a(int i, int i2) {
        f379b.m815a(this.f380a, i, i2);
    }

    public boolean m808a() {
        return f379b.m816a(this.f380a);
    }

    public boolean m809a(float f) {
        return f379b.m817a(this.f380a, f);
    }

    public boolean m810a(int i) {
        return f379b.m818a(this.f380a, i);
    }

    public boolean m811a(Canvas canvas) {
        return f379b.m819a(this.f380a, canvas);
    }

    public void m812b() {
        f379b.m820b(this.f380a);
    }

    public boolean m813c() {
        return f379b.m821c(this.f380a);
    }
}
