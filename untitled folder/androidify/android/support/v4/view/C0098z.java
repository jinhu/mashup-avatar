package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.MotionEvent;

/* renamed from: android.support.v4.view.z */
public class C0098z {
    static final ac f323a;

    static {
        if (VERSION.SDK_INT >= 5) {
            f323a = new ab();
        } else {
            f323a = new aa();
        }
    }

    public static int m723a(MotionEvent motionEvent) {
        return motionEvent.getAction() & 255;
    }

    public static int m724a(MotionEvent motionEvent, int i) {
        return f323a.m484a(motionEvent, i);
    }

    public static int m725b(MotionEvent motionEvent) {
        return (motionEvent.getAction() & 65280) >> 8;
    }

    public static int m726b(MotionEvent motionEvent, int i) {
        return f323a.m485b(motionEvent, i);
    }

    public static float m727c(MotionEvent motionEvent, int i) {
        return f323a.m486c(motionEvent, i);
    }

    public static int m728c(MotionEvent motionEvent) {
        return f323a.m483a(motionEvent);
    }

    public static float m729d(MotionEvent motionEvent, int i) {
        return f323a.m487d(motionEvent, i);
    }
}
