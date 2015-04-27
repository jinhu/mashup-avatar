package android.support.v4.view;

import android.graphics.Paint;
import android.os.Build.VERSION;
import android.view.View;

public class ak {
    static final at f298a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 19) {
            f298a = new as();
        } else if (i >= 17) {
            f298a = new ar();
        } else if (i >= 16) {
            f298a = new aq();
        } else if (i >= 14) {
            f298a = new ap();
        } else if (i >= 11) {
            f298a = new ao();
        } else if (i >= 9) {
            f298a = new an();
        } else {
            f298a = new al();
        }
    }

    public static int m531a(View view) {
        return f298a.m544a(view);
    }

    public static void m532a(View view, int i, int i2, int i3, int i4) {
        f298a.m545a(view, i, i2, i3, i4);
    }

    public static void m533a(View view, int i, Paint paint) {
        f298a.m546a(view, i, paint);
    }

    public static void m534a(View view, Paint paint) {
        f298a.m547a(view, paint);
    }

    public static void m535a(View view, C0073a c0073a) {
        f298a.m548a(view, c0073a);
    }

    public static void m536a(View view, Runnable runnable) {
        f298a.m549a(view, runnable);
    }

    public static boolean m537a(View view, int i) {
        return f298a.m550a(view, i);
    }

    public static void m538b(View view) {
        f298a.m551b(view);
    }

    public static void m539b(View view, int i) {
        f298a.m552b(view, i);
    }

    public static int m540c(View view) {
        return f298a.m553c(view);
    }

    public static int m541d(View view) {
        return f298a.m554d(view);
    }

    public static int m542e(View view) {
        return f298a.m555e(view);
    }

    public static boolean m543f(View view) {
        return f298a.m556f(view);
    }
}
