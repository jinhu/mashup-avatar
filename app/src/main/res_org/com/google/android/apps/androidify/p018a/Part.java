package com.google.android.apps.androidify.p018a;

import android.content.Context;

import com.google.android.apps.androidify.AssetDatabase;

import java.util.HashMap;

import dev.game.legend.avatar.R;
import dev.game.legend.svgandroid.SVG;

;

/* renamed from: com.google.android.apps.androidify.a.k */
public class Part {
    private static final HashMap f1096h;
    public String f1097a;
    public C0215l f1098b;
    public SVG f1099c;
    public HashMap f1100d;
    public boolean f1101e;
    public boolean f1102f;
    public float f1103g;

    static {
        f1096h = new HashMap();
        f1096h.put(Integer.valueOf(R.raw.anim_blowkiss), new Part("heart", C0215l.HEAD));
        f1096h.put(Integer.valueOf(R.raw.anim_inlove), new Part("heart", C0215l.HEAD));
        Part part = new Part("hearteye", C0215l.HEAD);
        part.f1102f = true;
        f1096h.put(Integer.valueOf(R.raw.anim_inlovefloat), part);
        f1096h.put(Integer.valueOf(R.raw.anim_farewell), new Part("hankerchief", C0215l.LEFT_ARM));
        f1096h.put(Integer.valueOf(R.raw.anim_highfive), new Part("five", C0215l.LEFT_ARM));
        part = new Part("peace_fingers", C0215l.LEFT_ARM);
        part.f1101e = true;
        f1096h.put(Integer.valueOf(R.raw.anim_peace), part);
        f1096h.put(Integer.valueOf(R.raw.anim_lol), new Part("ha", C0215l.HEAD));
        f1096h.put(Integer.valueOf(R.raw.anim_giggling), new Part("he", C0215l.HEAD));
        f1096h.put(Integer.valueOf(R.raw.anim_crying), new Part("tear", C0215l.HEAD));
        f1096h.put(Integer.valueOf(R.raw.anim_sweaty), new Part("tear", C0215l.HEAD));
        f1096h.put(Integer.valueOf(R.raw.anim_sleeping), new Part("zzzzz", C0215l.HEAD));
        f1096h.put(Integer.valueOf(R.raw.anim_eating), new Part("popcornbag", C0215l.RIGHT_ARM_UNDER));
        f1096h.put(Integer.valueOf(R.raw.anim_facepalm), new Part("smack", C0215l.LEFT_ARM));
        f1096h.put(Integer.valueOf(R.raw.anim_steaming), new Part("steam", C0215l.HEAD));
        f1096h.put(Integer.valueOf(R.raw.anim_outta_here), new Part("dust", C0215l.MASTER));
        part = new Part("basketball", C0215l.BALL);
        part.f1103g = -30.0f;
        f1096h.put(Integer.valueOf(R.raw.anim_basketball_crossover), part);
        f1096h.put(Integer.valueOf(R.raw.anim_basketball_dribble), new Part("basketball", C0215l.BALL));
        f1096h.put(Integer.valueOf(R.raw.anim_basketball_shoot), new Part("basketball", C0215l.LEFT_ARM));
    }

    public Part(String str, C0215l c0215l) {
        this.f1100d = new HashMap();
        this.f1103g = 0.0f;
        this.f1097a = str;
        this.f1098b = c0215l;
    }

    public static Part m1622a(int i) {
        return (Part) f1096h.get(Integer.valueOf(i));
    }

    public SVG getSvg(Context context, int i) {
        if (this.f1099c == null) {
            AssetDatabase assetDatabase = AssetDatabase.instance(context);
            if (this.f1101e) {
                SVG SVG = (SVG) this.f1100d.get(Integer.valueOf(i));
                if (SVG != null) {
                    return SVG;
                }
                SVG = assetDatabase.getSVG(this.f1097a, i);
                this.f1100d.put(Integer.valueOf(i), SVG);
                return SVG;
            }
            this.f1099c = assetDatabase.getSVG(this.f1097a);
        }
        return this.f1099c;
    }
}
