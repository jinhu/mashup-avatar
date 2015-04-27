package com.google.android.apps.androidify.p018a;

import android.content.Context;
import com.google.android.apps.androidify.R;
import com.google.android.apps.androidify.ah;
import com.google.android.apps.p019b.C0249b;
import java.util.HashMap;

/* renamed from: com.google.android.apps.androidify.a.k */
public class C0214k {
    private static final HashMap f1096h;
    public String f1097a;
    public C0215l f1098b;
    public C0249b f1099c;
    public HashMap f1100d;
    public boolean f1101e;
    public boolean f1102f;
    public float f1103g;

    static {
        f1096h = new HashMap();
        f1096h.put(Integer.valueOf(R.raw.anim_blowkiss), new C0214k("heart", C0215l.HEAD));
        f1096h.put(Integer.valueOf(R.raw.anim_inlove), new C0214k("heart", C0215l.HEAD));
        C0214k c0214k = new C0214k("hearteye", C0215l.HEAD);
        c0214k.f1102f = true;
        f1096h.put(Integer.valueOf(R.raw.anim_inlovefloat), c0214k);
        f1096h.put(Integer.valueOf(R.raw.anim_farewell), new C0214k("hankerchief", C0215l.LEFT_ARM));
        f1096h.put(Integer.valueOf(R.raw.anim_highfive), new C0214k("five", C0215l.LEFT_ARM));
        c0214k = new C0214k("peace_fingers", C0215l.LEFT_ARM);
        c0214k.f1101e = true;
        f1096h.put(Integer.valueOf(R.raw.anim_peace), c0214k);
        f1096h.put(Integer.valueOf(R.raw.anim_lol), new C0214k("ha", C0215l.HEAD));
        f1096h.put(Integer.valueOf(R.raw.anim_giggling), new C0214k("he", C0215l.HEAD));
        f1096h.put(Integer.valueOf(R.raw.anim_crying), new C0214k("tear", C0215l.HEAD));
        f1096h.put(Integer.valueOf(R.raw.anim_sweaty), new C0214k("tear", C0215l.HEAD));
        f1096h.put(Integer.valueOf(R.raw.anim_sleeping), new C0214k("zzzzz", C0215l.HEAD));
        f1096h.put(Integer.valueOf(R.raw.anim_eating), new C0214k("popcornbag", C0215l.RIGHT_ARM_UNDER));
        f1096h.put(Integer.valueOf(R.raw.anim_facepalm), new C0214k("smack", C0215l.LEFT_ARM));
        f1096h.put(Integer.valueOf(R.raw.anim_steaming), new C0214k("steam", C0215l.HEAD));
        f1096h.put(Integer.valueOf(R.raw.anim_outta_here), new C0214k("dust", C0215l.MASTER));
        c0214k = new C0214k("basketball", C0215l.BALL);
        c0214k.f1103g = -30.0f;
        f1096h.put(Integer.valueOf(R.raw.anim_basketball_crossover), c0214k);
        f1096h.put(Integer.valueOf(R.raw.anim_basketball_dribble), new C0214k("basketball", C0215l.BALL));
        f1096h.put(Integer.valueOf(R.raw.anim_basketball_shoot), new C0214k("basketball", C0215l.LEFT_ARM));
    }

    public C0214k(String str, C0215l c0215l) {
        this.f1100d = new HashMap();
        this.f1103g = 0.0f;
        this.f1097a = str;
        this.f1098b = c0215l;
    }

    public static C0214k m1622a(int i) {
        return (C0214k) f1096h.get(Integer.valueOf(i));
    }

    public C0249b m1623a(Context context, int i) {
        if (this.f1099c == null) {
            ah a = ah.m1648a(context);
            if (this.f1101e) {
                C0249b c0249b = (C0249b) this.f1100d.get(Integer.valueOf(i));
                if (c0249b != null) {
                    return c0249b;
                }
                c0249b = a.m1661a(this.f1097a, i);
                this.f1100d.put(Integer.valueOf(i), c0249b);
                return c0249b;
            }
            this.f1099c = a.m1660a(this.f1097a);
        }
        return this.f1099c;
    }
}
