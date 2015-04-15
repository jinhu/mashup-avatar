package com.google.android.apps.androidify.a;

import android.content.Context;
import com.google.android.apps.androidify.R;
import com.google.android.apps.androidify.ah;
import com.google.android.apps.b.b;
import java.util.HashMap;

public class k {
    private static final HashMap h;
    public String a;
    public l b;
    public b c;
    public HashMap d;
    public boolean e;
    public boolean f;
    public float g;

    static {
        h = new HashMap();
        h.put(Integer.valueOf(R.raw.anim_blowkiss), new k("heart", l.HEAD));
        h.put(Integer.valueOf(R.raw.anim_inlove), new k("heart", l.HEAD));
        k kVar = new k("hearteye", l.HEAD);
        kVar.f = true;
        h.put(Integer.valueOf(R.raw.anim_inlovefloat), kVar);
        h.put(Integer.valueOf(R.raw.anim_farewell), new k("hankerchief", l.LEFT_ARM));
        h.put(Integer.valueOf(R.raw.anim_highfive), new k("five", l.LEFT_ARM));
        kVar = new k("peace_fingers", l.LEFT_ARM);
        kVar.e = true;
        h.put(Integer.valueOf(R.raw.anim_peace), kVar);
        h.put(Integer.valueOf(R.raw.anim_lol), new k("ha", l.HEAD));
        h.put(Integer.valueOf(R.raw.anim_giggling), new k("he", l.HEAD));
        h.put(Integer.valueOf(R.raw.anim_crying), new k("tear", l.HEAD));
        h.put(Integer.valueOf(R.raw.anim_sweaty), new k("tear", l.HEAD));
        h.put(Integer.valueOf(R.raw.anim_sleeping), new k("zzzzz", l.HEAD));
        h.put(Integer.valueOf(R.raw.anim_eating), new k("popcornbag", l.RIGHT_ARM_UNDER));
        h.put(Integer.valueOf(R.raw.anim_facepalm), new k("smack", l.LEFT_ARM));
        h.put(Integer.valueOf(R.raw.anim_steaming), new k("steam", l.HEAD));
        h.put(Integer.valueOf(R.raw.anim_outta_here), new k("dust", l.MASTER));
        kVar = new k("basketball", l.BALL);
        kVar.g = -30.0f;
        h.put(Integer.valueOf(R.raw.anim_basketball_crossover), kVar);
        h.put(Integer.valueOf(R.raw.anim_basketball_dribble), new k("basketball", l.BALL));
        h.put(Integer.valueOf(R.raw.anim_basketball_shoot), new k("basketball", l.LEFT_ARM));
    }

    public k(String str, l lVar) {
        this.d = new HashMap();
        this.g = 0.0f;
        this.a = str;
        this.b = lVar;
    }

    public static k a(int i) {
        return (k) h.get(Integer.valueOf(i));
    }

    public b a(Context context, int i) {
        if (this.c == null) {
            ah a = ah.a(context);
            if (this.e) {
                b bVar = (b) this.d.get(Integer.valueOf(i));
                if (bVar != null) {
                    return bVar;
                }
                bVar = a.a(this.a, i);
                this.d.put(Integer.valueOf(i), bVar);
                return bVar;
            }
            this.c = a.a(this.a);
        }
        return this.c;
    }
}
