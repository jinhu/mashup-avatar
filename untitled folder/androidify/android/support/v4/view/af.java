package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

public class af {
    static final ai f297a;

    static {
        if (VERSION.SDK_INT >= 11) {
            f297a = new ah();
        } else {
            f297a = new ag();
        }
    }

    public static float m521a(VelocityTracker velocityTracker, int i) {
        return f297a.m523a(velocityTracker, i);
    }

    public static float m522b(VelocityTracker velocityTracker, int i) {
        return f297a.m524b(velocityTracker, i);
    }
}
