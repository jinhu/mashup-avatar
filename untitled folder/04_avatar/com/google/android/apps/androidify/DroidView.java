package com.google.android.apps.androidify;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.google.android.a;
import com.google.android.apps.androidify.a.e;
import com.google.android.apps.androidify.a.j;
import com.google.android.apps.b.b;
import com.google.android.apps.b.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public class DroidView extends View implements OnGestureListener, OnScaleGestureListener {
    static final Random a;
    private static final HashMap f;
    private static int[] g;
    private static final float h;
    private boolean A;
    private int B;
    private int C;
    private int D;
    private Picture E;
    private Picture F;
    private Picture G;
    private Picture H;
    private Picture I;
    private Picture J;
    private Picture K;
    private Picture L;
    private Picture M;
    private Picture N;
    private Picture O;
    private Picture P;
    private Picture Q;
    private Picture R;
    private bg S;
    private bg T;
    private bg U;
    private bg V;
    private RectF W;
    private RectF Z;
    private float aA;
    private float aB;
    private boolean aC;
    private boolean aD;
    private long aE;
    private float aF;
    private RectF aG;
    private boolean aH;
    private boolean aI;
    private boolean aJ;
    private Picture aK;
    private Picture aL;
    private Picture aM;
    private Picture aN;
    private Picture aO;
    private Picture aP;
    private Picture[] aQ;
    private ci aR;
    private Matrix aS;
    private RectF aT;
    private final Handler aU;
    private final Runnable aV;
    private float aW;
    private float aX;
    private boolean aY;
    private boolean aZ;
    private RectF aa;
    private float ab;
    private Path ac;
    private Matrix ad;
    private Matrix ae;
    private Matrix af;
    private Matrix ag;
    private GestureDetector ah;
    private ScaleGestureDetector ai;
    private TutorialView aj;
    private j ak;
    private j al;
    private e am;
    private e an;
    private double ao;
    private long ap;
    private double aq;
    private long ar;
    private long as;
    private HashMap at;
    private float au;
    private RectF av;
    private Paint aw;
    private boolean ax;
    private boolean ay;
    private int az;
    protected Androidify b;
    private long bA;
    private Paint bB;
    private float ba;
    private int bb;
    private int bc;
    private int bd;
    private int be;
    private int bf;
    private int bg;
    private int bh;
    private int bi;
    private int bj;
    private int bk;
    private int bl;
    private int bm;
    private int bn;
    private int bo;
    private float bp;
    private float bq;
    private float br;
    private float bs;
    private boolean bt;
    private boolean bu;
    private boolean bv;
    private bi bw;
    private Paint bx;
    private Paint by;
    private int bz;
    protected boolean c;
    protected float d;
    Picture[] e;
    private float i;
    private float j;
    private Matrix k;
    private Matrix l;
    private float m;
    private float n;
    private float o;
    private HashMap p;
    private RectF q;
    private PointF r;
    private float s;
    private ch t;
    private ch u;
    private ch v;
    private ch w;
    private Picture x;
    private Picture y;
    private Path z;

    static {
        f = new HashMap();
        f.put(bh.SHOES, Integer.valueOf(R.raw.react_shoes));
        f.put(bh.HAIR, Integer.valueOf(R.raw.react_hathair));
        f.put(bh.SHIRT, Integer.valueOf(R.raw.react_shirt));
        f.put(bh.PANTS, Integer.valueOf(R.raw.react_pants));
        g = new int[]{R.raw.idle_blinkonce, R.raw.idle_blinksimple, R.raw.idle_blinktwice, R.raw.idle_drumming, R.raw.idle_lookdown, R.raw.idle_lookleft, R.raw.idle_lookright, R.raw.idle_lookup, R.raw.idle_sway, R.raw.idle_wave};
        h = -26.0f * Androidify.a();
        a = new Random();
    }

    public DroidView(Context context) {
        super(context);
        this.p = new HashMap();
        this.A = false;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = al.w;
        this.Z = al.x;
        this.aa = al.y;
        this.ab = al.Z.y;
        this.ad = null;
        this.ae = null;
        this.af = null;
        this.ag = null;
        this.aj = null;
        this.ak = new j();
        this.al = new j();
        this.am = null;
        this.an = null;
        this.ao = 0.0d;
        this.ap = 0;
        this.aq = 0.0d;
        this.ar = 0;
        this.as = 0;
        this.au = -1.0f;
        this.av = new RectF();
        this.ax = false;
        this.ay = false;
        this.az = 1;
        this.aA = 1.0f;
        this.aB = 1.0f;
        this.aC = false;
        this.aD = true;
        this.c = true;
        this.aE = 0;
        this.aH = true;
        this.aI = false;
        this.aJ = false;
        this.aQ = new Picture[3];
        this.aR = new ci();
        this.aS = new Matrix();
        this.aT = new RectF(al.n.x - al.u, 0.0f, al.n.x + al.u, 0.0f);
        this.aU = new Handler();
        this.aV = new be(this);
        this.aY = false;
        this.aZ = false;
        this.bt = false;
        this.bv = false;
        this.bz = 0;
        this.bA = 0;
        this.bB = new Paint();
        this.e = new Picture[2];
    }

    public DroidView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.p = new HashMap();
        this.A = false;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = al.w;
        this.Z = al.x;
        this.aa = al.y;
        this.ab = al.Z.y;
        this.ad = null;
        this.ae = null;
        this.af = null;
        this.ag = null;
        this.aj = null;
        this.ak = new j();
        this.al = new j();
        this.am = null;
        this.an = null;
        this.ao = 0.0d;
        this.ap = 0;
        this.aq = 0.0d;
        this.ar = 0;
        this.as = 0;
        this.au = -1.0f;
        this.av = new RectF();
        this.ax = false;
        this.ay = false;
        this.az = 1;
        this.aA = 1.0f;
        this.aB = 1.0f;
        this.aC = false;
        this.aD = true;
        this.c = true;
        this.aE = 0;
        this.aH = true;
        this.aI = false;
        this.aJ = false;
        this.aQ = new Picture[3];
        this.aR = new ci();
        this.aS = new Matrix();
        this.aT = new RectF(al.n.x - al.u, 0.0f, al.n.x + al.u, 0.0f);
        this.aU = new Handler();
        this.aV = new be(this);
        this.aY = false;
        this.aZ = false;
        this.bt = false;
        this.bv = false;
        this.bz = 0;
        this.bA = 0;
        this.bB = new Paint();
        this.e = new Picture[2];
    }

    public DroidView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.p = new HashMap();
        this.A = false;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = al.w;
        this.Z = al.x;
        this.aa = al.y;
        this.ab = al.Z.y;
        this.ad = null;
        this.ae = null;
        this.af = null;
        this.ag = null;
        this.aj = null;
        this.ak = new j();
        this.al = new j();
        this.am = null;
        this.an = null;
        this.ao = 0.0d;
        this.ap = 0;
        this.aq = 0.0d;
        this.ar = 0;
        this.as = 0;
        this.au = -1.0f;
        this.av = new RectF();
        this.ax = false;
        this.ay = false;
        this.az = 1;
        this.aA = 1.0f;
        this.aB = 1.0f;
        this.aC = false;
        this.aD = true;
        this.c = true;
        this.aE = 0;
        this.aH = true;
        this.aI = false;
        this.aJ = false;
        this.aQ = new Picture[3];
        this.aR = new ci();
        this.aS = new Matrix();
        this.aT = new RectF(al.n.x - al.u, 0.0f, al.n.x + al.u, 0.0f);
        this.aU = new Handler();
        this.aV = new be(this);
        this.aY = false;
        this.aZ = false;
        this.bt = false;
        this.bv = false;
        this.bz = 0;
        this.bA = 0;
        this.bB = new Paint();
        this.e = new Picture[2];
    }

    public DroidView(Androidify androidify, Picture picture, Picture picture2, Picture picture3, Picture picture4, Picture picture5, Picture picture6) {
        super(androidify);
        this.p = new HashMap();
        this.A = false;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = al.w;
        this.Z = al.x;
        this.aa = al.y;
        this.ab = al.Z.y;
        this.ad = null;
        this.ae = null;
        this.af = null;
        this.ag = null;
        this.aj = null;
        this.ak = new j();
        this.al = new j();
        this.am = null;
        this.an = null;
        this.ao = 0.0d;
        this.ap = 0;
        this.aq = 0.0d;
        this.ar = 0;
        this.as = 0;
        this.au = -1.0f;
        this.av = new RectF();
        this.ax = false;
        this.ay = false;
        this.az = 1;
        this.aA = 1.0f;
        this.aB = 1.0f;
        this.aC = false;
        this.aD = true;
        this.c = true;
        this.aE = 0;
        this.aH = true;
        this.aI = false;
        this.aJ = false;
        this.aQ = new Picture[3];
        this.aR = new ci();
        this.aS = new Matrix();
        this.aT = new RectF(al.n.x - al.u, 0.0f, al.n.x + al.u, 0.0f);
        this.aU = new Handler();
        this.aV = new be(this);
        this.aY = false;
        this.aZ = false;
        this.bt = false;
        this.bv = false;
        this.bz = 0;
        this.bA = 0;
        this.bB = new Paint();
        this.e = new Picture[2];
        a(androidify, picture, picture2, picture3, picture4, picture5, picture6);
    }

    private float a(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    private int a(int i, int i2, float f) {
        return ((int) (((float) (i - i2)) * f)) + i2;
    }

    private void a(Canvas canvas, ax axVar, bh bhVar) {
        switch (bf.a[bhVar.ordinal()]) {
            case cm.HListView_android_divider /*1*/:
            case cm.HListView_hlv_dividerWidth /*2*/:
            case cm.HListView_hlv_headerDividersEnabled /*3*/:
                canvas.scale(axVar.f(), axVar.f(), al.g.x, al.g.y);
            case cm.HListView_hlv_footerDividersEnabled /*4*/:
                canvas.scale(axVar.f(), axVar.f(), al.W.x, (al.C.y + al.aa.y) / 2.0f);
            case cm.HListView_hlv_overScrollHeader /*5*/:
                canvas.scale(axVar.f(), axVar.f(), al.g.x, al.D.y);
            case cm.HListView_hlv_overScrollFooter /*6*/:
                canvas.scale(axVar.f(), axVar.f(), al.g.x, al.aa.y);
            default:
        }
    }

    private float f(float f, float f2) {
        return (a.nextFloat() * (f2 - f)) + f;
    }

    private boolean g(float f, float f2) {
        if (f2 > ((float) this.bi)) {
            return f < ((float) this.bg) || f > ((float) this.bh);
        } else {
            float[] fArr = new float[]{f, f2};
            this.l.mapPoints(fArr);
            if (!this.W.contains(fArr[0], fArr[1])) {
                return true;
            }
            a.c("Touching hair!");
            return false;
        }
    }

    private bl h(float f, float f2) {
        Object obj = 1;
        bl blVar = new bl();
        if (this.bq < ((float) this.bi) + 0.0f) {
            blVar.a = bi.HEAD;
            if (this.bp < ((float) this.bc)) {
                blVar.b = bk.LEFT;
            } else {
                blVar.b = bk.RIGHT;
            }
        } else if (this.bq >= ((float) this.bl) + 0.0f) {
            if (this.bq < 0.0f + ((float) this.bm)) {
                if (this.bp < ((float) this.bb)) {
                    blVar.a = bi.ARM;
                    blVar.b = bk.LEFT;
                } else if (this.bp > ((float) this.bd)) {
                    blVar.a = bi.ARM;
                    blVar.b = bk.RIGHT;
                }
                if (obj == null) {
                    blVar.a = bi.LEG;
                    if (this.bp >= ((float) this.bc)) {
                        blVar.b = bk.LEFT;
                    } else {
                        blVar.b = bk.RIGHT;
                    }
                }
            }
            obj = null;
            if (obj == null) {
                blVar.a = bi.LEG;
                if (this.bp >= ((float) this.bc)) {
                    blVar.b = bk.RIGHT;
                } else {
                    blVar.b = bk.LEFT;
                }
            }
        } else if (this.bp < ((float) this.bb)) {
            blVar.a = bi.ARM;
            blVar.b = bk.LEFT;
        } else if (this.bp > ((float) this.bd)) {
            blVar.a = bi.ARM;
            blVar.b = bk.RIGHT;
        } else {
            blVar.a = bi.BODY;
            if (this.bp < ((float) this.bc)) {
                blVar.b = bk.LEFT;
            } else {
                blVar.b = bk.RIGHT;
            }
        }
        return blVar;
    }

    private void i(float f, float f2) {
        float f3 = this.t.c * f2;
        float a = a(this.t.b * f, 0.6f, 1.2f);
        if (this.w.b > a) {
            c(a, this.w.c);
        }
        a(a, a(f3, 0.6f, 1.5f));
    }

    private void j(float f, float f2) {
        b(a(this.v.b * f, 0.5f, 1.2f), a(this.v.c * f2, 0.6f, 1.5f));
    }

    private void k(float f, float f2) {
        float f3 = this.w.b * f;
        float f4 = this.w.c * f2;
        if (f3 > this.t.b) {
            f3 = this.t.b;
        }
        c(a(f3, 0.4f, 1.1f), a(f4, 0.6f, 3.0f));
    }

    private void n() {
        this.as = System.currentTimeMillis() + ((long) a.a(2500, 7000));
    }

    private void o() {
        this.z.rewind();
        float f = (al.K.x - al.J.x) * this.v.b;
        float f2 = (al.G.y - al.E.y) * this.v.c;
        float f3 = f / 2.0f;
        float f4 = f3 * 0.5522848f;
        this.z.moveTo(al.J.x, al.E.y + f3);
        this.z.rCubicTo(0.0f, -f4, f3 - f4, -f3, f3, -f3);
        this.z.rCubicTo(f4, 0.0f, f3, f3 - f4, f3, f3);
        this.z.rLineTo(0.0f, f2 - f);
        this.z.rCubicTo(0.0f, f4, -(f3 - f4), f3, -f3, f3);
        float f5 = -f3;
        this.z.rCubicTo(-f4, 0.0f, -f3, -(f3 - f4), -f3, f5);
        this.z.rLineTo(0.0f, -(f2 - f));
        this.z.close();
    }

    private void p() {
        if (this.aC) {
            this.bx.setShader(new RadialGradient(250.0f, al.z.y, al.Y.y - ((float) this.bi), new int[]{-1, -12566464}, null, TileMode.CLAMP));
            return;
        }
        this.bx.setShader(new LinearGradient(250.0f, al.f.y, 250.0f, al.Y.y, new int[]{-3618616, -1}, null, TileMode.CLAMP));
    }

    private void q() {
        this.v.d = (-(al.z.x - al.A.x)) * (this.t.b - 1.0f);
        ch chVar = this.v;
        chVar.d -= (al.K.x - al.J.x) * (this.v.b - 1.0f);
    }

    private void r() {
        this.w.e = (al.C.y - al.z.y) * (this.t.c - 1.0f);
    }

    private void s() {
        if (this.ao > this.am.b()) {
            a.c("Motion done.");
            this.ak.a();
            this.am = null;
            n();
        } else if (this.an == null) {
            this.ak.a(this.am, null, 1.0f, this.ao, this.au);
            invalidate();
        } else {
            this.al.a(this.an, null, 1.0f, this.aq, this.au);
            this.ak.a(this.am, this.al, by.b((float) this.ao, 0.0f, 600.0f, 0.0f, 1.0f), this.ao, this.au);
            invalidate();
        }
    }

    private void t() {
        if (this.aq > this.an.b()) {
            a.c("Idle motion done.");
            this.an = null;
            if (this.am == null) {
                this.ak.a();
                n();
                invalidate();
            }
        } else if (this.am == null) {
            this.ak.a(this.an, null, 1.0f, this.aq, this.au);
            invalidate();
        }
    }

    protected float a(int i) {
        return this.b.c().a(i);
    }

    public Picture a(String str) {
        return (this.S == null || !this.S.a.b().equals(str) || this.S.b == null) ? (this.T == null || !this.T.a.b().equals(str) || this.T.b == null) ? (this.U == null || !this.U.a.b().equals(str) || this.U.b == null) ? (this.V == null || !this.V.a.b().equals(str) || this.V.b == null) ? null : this.V.b.a : this.U.b.a : this.T.b.a : this.S.b.a;
    }

    public ax a(ay ayVar) {
        return (ax) this.at.get(ayVar.toString());
    }

    public bj a() {
        bj bjVar = new bj(this);
        bjVar.start();
        return bjVar;
    }

    public void a(float f, float f2) {
        this.t.b = f;
        this.t.c = f2;
        q();
        r();
        b();
    }

    public void a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        this.t.b = f;
        this.t.c = f2;
        this.u.b = f3;
        this.u.c = f4;
        this.v.b = f5;
        this.v.c = f6;
        this.w.b = f7;
        this.w.c = f8;
        q();
        r();
        b();
    }

    public void a(int i, boolean z) {
        if (this.aj != null && this.aj.getStepIndex() == i) {
            if (!this.aj.d() || !this.aj.e() || !z) {
                this.aj.setHidden(!z);
            }
        }
    }

    public void a(Picture picture, Picture picture2) {
        this.w.a = picture;
        this.x = picture2;
    }

    public void a(Picture picture, Picture picture2, Picture picture3, Picture picture4) {
        this.u.a = picture;
        this.t.a = picture2;
        this.v.a = picture3;
        this.y = picture4;
    }

    public void a(Picture picture, RectF rectF) {
        this.P = picture;
        this.aG = rectF;
        postInvalidate();
    }

    public void a(Androidify androidify, Picture picture, Picture picture2, Picture picture3, Picture picture4, Picture picture5, Picture picture6) {
        this.ak.R = 0.33333334f;
        this.b = androidify;
        this.x = picture5;
        this.y = picture6;
        this.t = new ch(picture);
        this.u = new ch(picture2);
        this.v = new ch(picture3);
        this.w = new ch(picture4);
        setBackgroundColor(-1);
        this.q = new RectF();
        this.r = new PointF();
        this.ac = c.a("M140.396,175.489v177.916c0,10.566,8.566,19.133,19.135,19.133h2.303h20.331h48.709h37.371h48.708h11.881h10.752c10.569,0,19.137-8.562,19.137-19.133V175.489H140.396z");
        setClickable(true);
        this.ah = new GestureDetector(this);
        this.ah.setIsLongpressEnabled(false);
        this.ai = new ScaleGestureDetector(getContext(), this);
        this.ae = new Matrix();
        this.ag = new Matrix();
        this.aw = new Paint();
        this.aw.setAntiAlias(true);
        this.bx = new Paint();
        this.bx.setDither(false);
        this.bx.setAntiAlias(true);
        this.by = new Paint();
        this.by.setAntiAlias(true);
        this.z = new Path();
        o();
        this.at = new HashMap();
        this.s = getResources().getDimension(R.dimen.droidview_bottom_margin);
        this.aK = androidify.t().a((int) R.raw.hair_icon).a;
        this.aL = androidify.t().a((int) R.raw.glasses_icon).a;
        this.aM = androidify.t().a((int) R.raw.beard_icon).a;
        this.aN = androidify.t().a((int) R.raw.hair_icon_on).a;
        this.aO = androidify.t().a((int) R.raw.glasses_icon_on).a;
        this.aP = androidify.t().a((int) R.raw.beard_icon_on).a;
        this.aQ[0] = this.aK;
        this.aQ[1] = this.aL;
        this.aQ[2] = this.aM;
        float a = c.a(getContext(), 90.0f);
        this.o = getResources().getDimension(R.dimen.droidview_top_margin);
        this.aA = a / ((float) this.aK.getHeight());
        n();
    }

    public void a(av avVar) {
        if (avVar == av.HAIR) {
            this.aQ[0] = this.aN;
            this.aQ[1] = this.aL;
            this.aQ[2] = this.aM;
        } else if (avVar == av.GLASSES) {
            this.aQ[0] = this.aK;
            this.aQ[1] = this.aO;
            this.aQ[2] = this.aM;
        } else if (avVar == av.BEARD) {
            this.aQ[0] = this.aK;
            this.aQ[1] = this.aL;
            this.aQ[2] = this.aP;
        }
    }

    public void a(ax axVar) {
        this.at.put(axVar.b().toString(), axVar);
        postInvalidate();
    }

    public void a(bh bhVar) {
        long currentTimeMillis = System.currentTimeMillis();
        Long l = (Long) this.p.get(bhVar);
        if (l == null || currentTimeMillis - l.longValue() > 3000) {
            this.p.put(bhVar, Long.valueOf(currentTimeMillis));
            Integer num = (Integer) f.get(bhVar);
            if (num != null) {
                e a = com.google.android.apps.androidify.a.a.a(getContext(), num.intValue());
                a.a(0.0d);
                setMotion(a);
                invalidate();
            }
        }
    }

    public void a(boolean z) {
        switch (z ? a.nextInt(6) : a.nextInt(5) + 1) {
            case cm.HListView_android_entries /*0*/:
                l();
            case cm.HListView_android_divider /*1*/:
                k();
            case cm.HListView_hlv_dividerWidth /*2*/:
                j();
            case cm.HListView_hlv_headerDividersEnabled /*3*/:
                i();
            case cm.HListView_hlv_footerDividersEnabled /*4*/:
                h();
            case cm.HListView_hlv_overScrollHeader /*5*/:
                g();
            default:
        }
    }

    public void b() {
        float f;
        ax axVar;
        float f2 = ((al.B.x - al.A.x) * this.t.b) + (((al.A.x - al.J.x) * 2.0f) * this.v.b);
        a.c("Body width now: " + f2);
        float f3 = (al.i.x - al.h.x) * this.u.b;
        this.aW = Math.max(f2, f3);
        a.c(" Droid width now: " + this.aW);
        b bVar = this.V == null ? null : this.V.b;
        if (!(bVar == null || bVar.c == null)) {
            f = ((al.B.x - 250.0f) * this.t.b) + ((al.L.x - al.B.x) * this.v.b);
            this.aW = Math.max(this.aW, Math.max((f + ((Math.max(250.0f - bVar.c.left, bVar.c.left - 250.0f) - f) * this.v.b)) * 2.0f, (((Math.max(250.0f - bVar.c.right, bVar.c.right - 250.0f) - f) * this.v.b) + f) * 2.0f));
            a.c(" Droid width width hand now: " + this.aW);
        }
        if (!(this.aX == 0.0f || this.aW == this.aX)) {
            ax a = a(ay.ADJUST_WIDTH);
            axVar = new ax(ay.ADJUST_WIDTH, 300);
            axVar.a(new DecelerateInterpolator(1.0f), a != null ? a.e() : this.aX, this.aW);
            a(axVar);
            postInvalidate();
        }
        this.aX = this.aW;
        ax a2 = a(ay.ADJUST_WIDTH);
        f2 = Math.min(al.v, this.W.top);
        b bVar2 = this.S == null ? null : this.S.b;
        if (!(bVar2 == null || bVar2.c == null)) {
            f2 = Math.min(f2, bVar2.c.top);
        }
        if (!(f2 == this.i || this.aI)) {
            axVar = a(ay.ADJUST_HEIGHT);
            ax axVar2 = new ax(ay.ADJUST_HEIGHT, 300);
            axVar2.a(new DecelerateInterpolator(1.0f), axVar != null ? axVar.e() : this.i, f2);
            a(axVar2);
            postInvalidate();
        }
        axVar = a(ay.ADJUST_HEIGHT);
        float e = axVar != null ? axVar.e() : f2;
        f = a2 != null ? a2.e() : this.aW;
        this.i = f2;
        f2 = ((al.g.y - e) * this.u.c) + (al.z.y - al.g.y);
        e = (al.C.y - al.z.y) * this.t.c;
        this.aF = ((al.aa.y - al.C.y) * this.w.c) + ((al.Y.y - al.aa.y) * this.w.b);
        float f4 = ((this.W.bottom - al.g.y) * this.u.c) - e;
        if (f4 > this.aF) {
            this.aF = f4;
        }
        f4 = (f2 + e) + this.aF;
        this.q.set(al.D.x - (f / 2.0f), al.z.y - f2, al.D.x + (f / 2.0f), (e + al.z.y) + this.aF);
        this.r.set((this.q.left + this.q.right) / 2.0f, (this.q.top + this.q.bottom) / 2.0f);
        f2 = 1.15f * f;
        f = 1.15f * f4;
        int width = getWidth();
        this.au = Math.min(((float) width) / f2, ((((float) getHeight()) - this.s) - this.o) / f);
        this.m = ((((float) getWidth()) * 0.75f) / f3) / this.au;
        if (this.aJ) {
            f2 = this.m;
            this.n = 1.0f;
        } else {
            a = a(ay.ZOOM_HEAD_IN);
            axVar = a == null ? a(ay.ZOOM_HEAD_OUT) : a;
            if (axVar != null) {
                f2 = axVar.e();
                if (axVar.b() == ay.ZOOM_HEAD_IN) {
                    this.n = axVar.c();
                } else {
                    this.n = 1.0f - axVar.c();
                }
            } else {
                this.n = 0.0f;
                f2 = 1.0f;
            }
        }
        a.c("Zoom progress = " + this.n);
        this.ad = new Matrix();
        this.ad.preTranslate(((float) (width / 2)) - this.r.x, (((float) (getHeight() / 2)) - this.r.y) + (this.o / 2.0f));
        this.ad.preScale(this.au, this.au, this.r.x, this.r.y);
        this.ad.preScale(f2, f2, al.f.x, (al.g.y - al.f.y) * -2.0f);
        this.ad.preTranslate(0.0f, (al.Y.y - al.aa.y) * -2.0f);
        this.ad.invert(this.ae);
        this.k = new Matrix();
        this.l = new Matrix();
        this.k.preTranslate(((float) (width / 2)) - this.r.x, ((float) (getHeight() / 2)) - this.r.y);
        this.k.preScale(this.au, this.au, this.r.x, this.r.y);
        this.k.preScale(f2, f2, al.f.x, (al.g.y - al.f.y) * -2.0f);
        this.k.preScale(this.u.b, this.u.c, al.g.x, al.g.y);
        this.k.preTranslate(0.0f, (al.Y.y - al.aa.y) * -2.0f);
        this.k.invert(this.l);
        float[] fArr = new float[]{al.z.x, al.z.y};
        this.ad.mapPoints(fArr);
        this.bc = (int) fArr[0];
        this.bb = (int) (((float) this.bc) - (((250.0f - al.A.x) * this.t.b) * this.au));
        this.bd = (int) (((float) this.bc) + (((250.0f - al.A.x) * this.t.b) * this.au));
        this.be = (int) (((float) this.bc) - (((250.0f - al.S.x) * this.w.b) * this.au));
        this.bf = (int) (((float) this.bc) + (((250.0f - al.S.x) * this.w.b) * this.au));
        float f5 = (al.A.x - al.K.x) * this.au;
        f3 = ((al.K.x - al.J.x) * this.v.b) * this.au;
        this.bg = (int) ((((float) this.bb) - f5) - f3);
        this.bh = (int) ((f5 + ((float) this.bd)) + f3);
        this.bi = (int) fArr[1];
        this.bj = (int) (((float) this.bi) - (f2 * (((al.g.y - al.f.y) * this.u.c) * this.au)));
        this.bk = (int) (fArr[1] + ((((al.C.y - al.z.y) * this.t.c) * this.au) / 2.0f));
        this.bl = (int) (fArr[1] + (((al.C.y - al.z.y) * this.t.c) * this.au));
        this.bn = (int) (fArr[1] + ((((al.C.y - al.z.y) * this.t.c) + ((al.aa.y - al.C.y) * this.w.c)) * this.au));
        this.bm = (int) (fArr[1] + (((al.G.y - al.E.y) * this.v.c) * this.au));
        this.bi = (int) (((float) this.bi) + h);
        this.bj = (int) (((float) this.bj) + h);
        this.bk = (int) (((float) this.bk) + h);
        this.bl = (int) (((float) this.bl) + h);
        this.bn = (int) (((float) this.bn) + h);
        this.bm = (int) (((float) this.bm) + h);
        if (this.aG == null) {
            this.d = ((float) this.bn) + (((al.Y.y - al.aa.y) * this.w.b) * this.au);
        } else {
            this.d = ((float) this.bn) + (((this.aG.bottom - al.aa.y) * this.w.b) * this.au);
        }
        this.bo = (int) ((((float) this.bl) + this.d) / 2.0f);
        this.j = this.d + (((3.0f * (al.Y.y - al.aa.y)) / 2.0f) * this.au);
        if (this.ay) {
            int i = width / 2;
            int height = getHeight();
            this.bb = a(this.bb, i, this.aB);
            this.bc = a(this.bc, i, this.aB);
            this.bd = a(this.bd, i, this.aB);
            this.bi = a(this.bi, height, this.aB);
            this.bk = a(this.bk, height, this.aB);
            this.bm = a(this.bm, height, this.aB);
            this.bl = a(this.bl, height, this.aB);
            this.bn = a(this.bn, height, this.aB);
            this.d = (float) a((int) this.d, height, this.aB);
        }
        if (this.aY) {
            i = this.aZ ? getHeight() / 2 : 0;
            this.bb = a(this.bb, width, this.ba);
            this.bc = a(this.bc, width, this.ba);
            this.bd = a(this.bd, width, this.ba);
            this.bi = a(this.bi, i, this.ba);
            this.bk = a(this.bk, i, this.ba);
            this.bm = a(this.bm, i, this.ba);
            this.bl = a(this.bl, i, this.ba);
            this.bn = a(this.bn, i, this.ba);
            this.d = (float) a((int) this.d, i, this.ba);
        }
        p();
        o();
        f();
        if (this.aj != null) {
            f2 = getResources().getDimension(R.dimen.tutorial_item_width);
            f = getResources().getDimension(R.dimen.tutorial_button_width);
            f5 = getResources().getDimension(R.dimen.tutorial_header_height);
            e = getResources().getDimension(R.dimen.tutorial_arrow_bottom_adjust);
            ci a3 = c.a(this, (float) this.bf, (float) this.bo, this.aj);
            this.aj.a(0, a3.a, a3.b);
            this.aj.a(1, f2 / 2.0f, ((float) getHeight()) - e);
            this.aj.a(2, (3.0f * f2) / 2.0f, ((float) getHeight()) - e);
            c.a(this, (float) this.bd, (float) this.bl, this.aj);
            this.aj.a(3, (f2 * 5.0f) / 2.0f, (float) (-getHeight()));
            this.aj.a(4, ((float) getWidth()) - (f / 2.0f), f5);
        }
        postInvalidate();
    }

    public void b(float f, float f2) {
        this.v.b = f;
        this.v.c = f2;
        q();
        b();
    }

    public void b(int i) {
        if (this.aj != null && this.aj.getStepIndex() == i) {
            this.aj.b();
        }
    }

    public void b(bh bhVar) {
        ax axVar = new ax(ay.BOUNCE_ELEMENT, 300);
        axVar.a(a.a(), 0.0f, 0.0f);
        axVar.a(bhVar.ordinal());
        a(axVar);
        invalidate();
    }

    public void c() {
        a(1.0f, 1.0f);
        c(1.0f, 1.0f);
        d(1.0f, 1.0f);
        b(1.0f, 1.0f);
    }

    public void c(float f, float f2) {
        this.w.b = f;
        this.w.c = f2;
        r();
        b();
    }

    public void c(int i) {
        if (this.aj != null && this.aj.getStepIndex() == i && this.aj.c() && this.aj.a()) {
            this.aj.setVisibility(8);
            this.aj = null;
        }
    }

    public void d() {
        c(f(0.4f, 1.1f), f(0.6f, 3.0f));
        b(f(0.5f, 1.2f), f(0.6f, 1.5f));
        a(f(0.6f, 1.2f), f(0.6f, 1.5f));
        if (this.w.b > this.t.b) {
            c(this.t.b, this.w.c);
        }
    }

    public void d(float f, float f2) {
        this.u.b = f;
        this.u.c = f2;
        b();
    }

    public void e() {
        this.at.clear();
    }

    public void e(float f, float f2) {
        float f3;
        float f4;
        Object obj = 1;
        float f5 = f * this.u.b;
        float f6 = f2 * this.u.c;
        Object obj2 = this.u.b < f5 ? 1 : null;
        if (this.u.c >= f6) {
            obj = null;
        }
        if (f5 / f6 > 1.2f) {
            if (obj != null) {
                f3 = f6 * 1.2f;
                f4 = f6;
            } else {
                f4 = f5 / 1.2f;
                f3 = f5;
            }
        } else if (f6 / f5 <= 1.2f) {
            f4 = f6;
            f3 = f5;
        } else if (obj2 != null) {
            f4 = f5 * 1.2f;
            f3 = f5;
        } else {
            f3 = f6 / 1.2f;
            f4 = f6;
        }
        d(a(f3, 0.6f, 1.8f), a(f4, 0.6f, 1.8f));
    }

    public void f() {
        this.af = new Matrix();
        if (this.ay) {
            this.af.preScale(this.aB, this.aB, (float) (getWidth() / 2), (float) getHeight());
        }
        if (this.aY) {
            this.af.preScale(this.ba, this.ba, this.aZ ? 0.0f : (float) getWidth(), (float) (getHeight() / 2));
        }
        this.af.invert(this.ag);
    }

    public void g() {
        ax axVar = new ax(ay.SHRUG, 1000);
        Interpolator bVar = new com.google.android.apps.androidify.a.b(0.0f, 0.0f);
        bVar.a(0.2f, 1.0f);
        bVar.a(0.8f, 1.0f);
        bVar.a(1.0f, 0.0f);
        axVar.a(bVar, 0.0f, al.g.y - al.z.y);
        a(axVar);
    }

    protected float getAmbientHover() {
        return this.b.c().e();
    }

    protected float getAmbientShadowScale() {
        return this.b.c().f();
    }

    public Bitmap getBitmapOfDroid() {
        boolean a = this.b.c().a();
        if (a) {
            this.b.c().c();
        }
        Bitmap a2 = a.a((View) this);
        if (a) {
            this.b.c().b();
        }
        return a2;
    }

    public float getBottomOfShadow() {
        return this.j;
    }

    public ch getDroidArm() {
        return this.v;
    }

    public ch getDroidBody() {
        return this.t;
    }

    public ch getDroidHead() {
        return this.u;
    }

    public ch getDroidLegs() {
        return this.w;
    }

    public int getHairColorIndex() {
        return this.B;
    }

    public Picture[] getHeadPictures() {
        if (this.S == null || this.S.b == null || !this.S.a.b().equals("head")) {
            this.e[0] = null;
        } else {
            this.e[0] = this.S.b.a;
        }
        if (this.T == null || this.T.b == null || !this.T.a.b().equals("head")) {
            this.e[1] = null;
        } else {
            this.e[1] = this.T.b.a;
        }
        return this.e;
    }

    public int getPantsColorIndex() {
        return this.D;
    }

    public int getSkinColorIndex() {
        return this.C;
    }

    public int getTopY() {
        return this.bi;
    }

    public void h() {
        ax axVar = new ax(ay.NOD, 600);
        Interpolator bVar = new com.google.android.apps.androidify.a.b(0.0f, 0.0f);
        bVar.a(0.225f, 1.0f);
        bVar.a(0.45f, 0.0f);
        bVar.a(0.55f, 0.0f);
        bVar.a(0.775f, 1.0f);
        bVar.a(1.0f, 0.0f);
        axVar.a(bVar, 0.0f, al.z.y - al.g.y);
        a(axVar);
    }

    public void i() {
        ax axVar = new ax(ay.HEAD_TILT, 1000);
        Interpolator bVar = new com.google.android.apps.androidify.a.b(0.0f, 0.0f);
        bVar.a(0.2f, 1.0f);
        bVar.a(0.8f, 1.0f);
        axVar.a(bVar, 0.0f, a.nextBoolean() ? 8.0f : -8.0f);
        a(axVar);
    }

    public void j() {
        ax axVar = new ax(ay.ANTENNA_TWITCH);
        Interpolator bVar = new com.google.android.apps.androidify.a.b(0.0f, 0.0f);
        bVar.a(0.25f, 1.0f);
        bVar.a(0.5f, 0.0f);
        bVar.a(0.75f, 1.0f);
        axVar.a(bVar, 0.0f, 40.0f);
        a(axVar);
    }

    public void k() {
        a(new ax(ay.BLINK));
    }

    public long l() {
        ax axVar = new ax(ay.WAVE, (long) 1200);
        Interpolator bVar = new com.google.android.apps.androidify.a.b(0.0f, 0.0f);
        bVar.a(0.35f, 1.0f);
        bVar.a(0.5f, 0.8f);
        bVar.a(0.65f, 1.0f);
        axVar.a(bVar, 0.0f, 160.0f);
        a(axVar);
        return (long) 1200;
    }

    public void m() {
        if (this.ax) {
            this.ax = false;
            b();
            f();
        }
    }

    public boolean onDown(MotionEvent motionEvent) {
        a.c("GESTURE: Down.");
        float[] fArr = new float[]{motionEvent.getX(), motionEvent.getY()};
        this.bp = fArr[0];
        this.bq = fArr[1];
        this.bt = false;
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onDraw(Canvas canvas) {
        ax axVar;
        float e;
        int i;
        canvas.getSaveCount();
        canvas.save();
        if (this.au == -1.0f) {
            b();
        }
        if (!(a(ay.ADJUST_HEIGHT) == null && a(ay.ADJUST_WIDTH) == null && a(ay.ZOOM_HEAD_IN) == null && a(ay.ZOOM_HEAD_OUT) == null)) {
            b();
        }
        Object obj = !this.at.isEmpty() ? 1 : null;
        if (obj != null) {
            Iterator it = this.at.values().iterator();
            while (it.hasNext()) {
                axVar = (ax) it.next();
                if (axVar.a()) {
                    if (axVar.b() == ay.ZOOM_HEAD_IN) {
                        this.aJ = true;
                    }
                    it.remove();
                }
            }
        }
        axVar = a(ay.SHRINK_LEFT);
        ax a = a(ay.SHRINK_UP);
        if (axVar != null && a != null) {
            e = axVar.e();
            canvas.scale(e, e, (float) getWidth(), (float) (getHeight() / 2));
            e = a.e();
            canvas.scale(e, e, (float) getWidth(), 0.0f);
        } else if (axVar != null) {
            e = axVar.e();
            canvas.scale(e, e, (float) getWidth(), (float) (getHeight() / 2));
        } else if (a != null) {
            e = a.e();
            canvas.scale(e, e, (float) getWidth(), 0.0f);
        } else if (this.aY) {
            canvas.scale(this.ba, this.ba, (float) getWidth(), this.aZ ? (float) (getHeight() / 2) : 0.0f);
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.ao = (double) (currentTimeMillis - this.ap);
        this.aq = (double) (currentTimeMillis - this.ar);
        if (this.am == null && this.an == null && this.as > 0 && currentTimeMillis >= this.as) {
            a.c("Starting idle animation.");
            setIdleMotion(a.a(g));
            invalidate();
        }
        if (this.an != null) {
            t();
        }
        if (this.am != null) {
            s();
        }
        currentTimeMillis /= 1000;
        if (currentTimeMillis > this.bA) {
            this.bz = 0;
            this.bA = currentTimeMillis;
        } else {
            this.bz++;
        }
        ax a2 = a(ay.HEAD_TILT);
        ax a3 = a(ay.NOD);
        ax a4 = a(ay.BOUNCE_ELEMENT);
        bh bhVar = bh.NONE;
        if (a4 != null) {
            bhVar = bh.values()[a4.d()];
        }
        if (this.ay) {
            a = a(ay.SHRINK_DOWN);
            if (a != null) {
                canvas.scale(a.e(), a.e(), (float) (getWidth() / 2), (float) getHeight());
            } else {
                canvas.scale(this.aB, this.aB, (float) (getWidth() / 2), (float) getHeight());
            }
        } else {
            a = a(ay.SHRINK_DOWN);
            if (a != null) {
                canvas.scale(a.e(), a.e(), (float) (getWidth() / 2), (float) getHeight());
            }
        }
        canvas.translate(0.0f, h);
        canvas.concat(this.ad);
        canvas.rotate(this.ak.k, al.D.x, al.D.y);
        canvas.translate(this.ak.A, this.ak.B);
        canvas.scale(this.ak.Q, 1.0f, al.D.x, al.D.y);
        if (this.c) {
            canvas.save();
            this.av.set(-10000.0f, -10000.0f, 10000.0f, 10000.0f);
            if (this.aC) {
                canvas.translate(0.0f, (((al.C.y - al.z.y) * this.t.c) + ((al.aa.y - al.C.y) * this.w.c)) + ((al.Y.y - al.aa.y) * this.w.b));
                canvas.scale(1.0f, 0.5f, 250.0f, al.D.y);
            } else if (this.aD) {
                Paint paint = new Paint();
                paint.setColor(getResources().getColor(R.color.bg_grey));
                paint.setStyle(Style.FILL);
                canvas.drawRect(this.av, paint);
            } else {
                canvas.drawRect(this.av, this.bx);
            }
            canvas.restore();
        }
        if (this.aH && this.aj == null) {
            canvas.save();
            float f = this.aG != null ? (this.aG.bottom - al.aa.y) * this.w.b : (al.Y.y - al.aa.y) * this.w.b;
            canvas.translate(this.w.d, (this.aI ? f - ((al.Y.y - al.aa.y) / 2.0f) : f + ((al.Y.y - al.aa.y) / 2.0f)) + this.w.e);
            canvas.scale(1.0f, this.w.c, al.C.x, al.C.y);
            canvas.scale(1.0f, 1.0f / this.w.c, 250.0f, al.aa.y);
            canvas.scale(((this.aI ? 1.1f : 0.75f) * this.t.b) * getAmbientShadowScale(), 1.0f, 250.0f, al.aa.y);
            this.by.setColor(-2136956768);
            this.av.set(al.I.x, al.aa.y, al.L.x, al.Z.y);
            canvas.drawOval(this.av, this.by);
            canvas.restore();
        }
        canvas.translate(0.0f, getAmbientHover());
        canvas.save();
        canvas.rotate(this.ak.j, al.D.x, al.D.y);
        canvas.translate(this.ak.y, this.ak.z);
        canvas.rotate(this.ak.i, al.g.x, al.g.y);
        canvas.translate(this.ak.w, this.ak.x);
        if (a2 != null) {
            canvas.rotate(a2.e(), al.g.x, al.g.y);
        }
        if (a3 != null) {
            canvas.translate(0.0f, a3.e());
        }
        canvas.scale(this.u.b, this.u.c, al.g.x, al.g.y);
        if (bhVar.i) {
            a(canvas, a4, bhVar);
        }
        if (this.L != null) {
            this.L.draw(canvas);
        }
        if (this.N != null) {
            this.N.draw(canvas);
        }
        canvas.restore();
        int i2 = 0;
        while (i2 < 2) {
            float f2 = i2 == 0 ? this.ak.c : this.ak.d;
            float f3 = i2 == 0 ? this.ak.s : this.ak.u;
            f = i2 == 0 ? this.ak.t : this.ak.v;
            canvas.save();
            if (i2 == 1) {
                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
            }
            canvas.translate(this.w.d, this.w.e);
            canvas.rotate(f2, 250.0f + ((al.ac.x - 250.0f) * this.w.b), al.W.y);
            canvas.translate(f3, f);
            canvas.scale(this.w.b, this.w.c, al.C.x, al.C.y);
            if (bhVar != bh.PANTS) {
                bh bhVar2 = bh.BEARD;
                if (bhVar != bh.SHIRT_AND_PANTS) {
                    this.w.a.draw(canvas);
                    canvas.restore();
                    i2++;
                }
            }
            a(canvas, a4, bh.PANTS);
            this.w.a.draw(canvas);
            canvas.restore();
            i2++;
        }
        canvas.save();
        canvas.translate(this.w.d, this.w.e);
        i2 = 0;
        while (i2 < 2) {
            f2 = i2 == 0 ? this.ak.c : this.ak.d;
            f3 = i2 == 0 ? this.ak.s : this.ak.u;
            f = i2 == 0 ? this.ak.t : this.ak.v;
            canvas.save();
            if (i2 == 1) {
                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
            }
            canvas.rotate(f2, 250.0f + ((al.ac.x - 250.0f) * this.w.b), al.W.y);
            canvas.translate(f3, f);
            canvas.scale(this.w.b, this.w.c, al.C.x, al.C.y);
            canvas.save();
            canvas.scale(1.0f, this.w.b / this.w.c, 250.0f, al.aa.y);
            if (bhVar != bh.PANTS) {
                bhVar2 = bh.BEARD;
            }
            a(canvas, a4, bh.PANTS);
            this.x.draw(canvas);
            canvas.restore();
            canvas.save();
            if (bhVar != bh.PANTS) {
                bhVar2 = bh.BEARD;
            }
            a(canvas, a4, bh.PANTS);
            if (this.I != null) {
                this.I.draw(canvas);
            }
            canvas.save();
            canvas.scale(1.0f, this.w.b / this.w.c, i2 == 0 ? al.W.x : al.X.x, al.C.y);
            if (this.J != null) {
                this.J.draw(canvas);
            }
            canvas.restore();
            canvas.restore();
            canvas.restore();
            i2++;
        }
        canvas.restore();
        canvas.save();
        canvas.rotate(this.ak.j, al.D.x, al.D.y);
        canvas.translate(this.ak.y, this.ak.z);
        if (bhVar != bh.SHIRT) {
            bhVar2 = bh.BEARD;
        }
        a(canvas, a4, bh.SHIRT);
        canvas.save(1);
        canvas.scale(this.t.b, this.t.c, al.z.x, al.z.y);
        canvas.clipPath(this.ac);
        this.t.a.draw(canvas);
        canvas.restore();
        if (this.E != null) {
            f = Math.max(this.t.b, this.t.c);
            if (f < 1.2f) {
                canvas.scale(f / 1.2f, f / 1.2f, al.z.x, al.z.y);
            }
            this.E.draw(canvas);
        }
        canvas.restore();
        Picture a5 = a("face");
        canvas.save();
        canvas.rotate(this.ak.j, al.D.x, al.D.y);
        canvas.translate(this.ak.y, this.ak.z);
        if (a2 != null) {
            canvas.rotate(a2.e(), al.g.x, al.g.y);
        }
        canvas.rotate(this.ak.i, al.g.x, al.g.y);
        canvas.translate(this.ak.w, this.ak.x);
        if (a3 != null) {
            canvas.translate(0.0f, a3.e());
        }
        canvas.scale(this.u.b, this.u.c, al.g.x, al.g.y);
        if (bhVar.i) {
            a(canvas, a4, bhVar);
        }
        this.u.a.draw(canvas);
        Picture a6 = a("earring");
        for (int i3 = 0; i3 < 2; i3++) {
            canvas.save();
            if (i3 == 1) {
                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
            }
            if (this.u.b > this.u.c) {
                canvas.scale(1.0f, this.u.b / this.u.c, al.p.x, al.p.y);
            } else {
                canvas.scale(this.u.c / this.u.b, 1.0f, al.p.x, al.p.y);
            }
            ax a7 = a(ay.ANTENNA_TWITCH);
            if (a7 != null) {
                canvas.rotate(a7.e(), al.p.x, al.p.y);
            } else {
                canvas.rotate(a(i3), al.p.x, al.p.y);
            }
            if (i3 == 0 && this.ak.g != 0.0f) {
                canvas.rotate(this.ak.g, al.p.x, al.p.y);
            } else if (i3 == 1 && this.ak.h != 0.0f) {
                canvas.rotate(this.ak.h, al.p.x, al.p.y);
            }
            this.y.draw(canvas);
            if (a6 != null) {
                a6.draw(canvas);
            }
            canvas.restore();
        }
        if (a5 != null) {
            a5.draw(canvas);
        }
        canvas.save();
        canvas.translate(this.ak.C, this.ak.D);
        this.aw.setColor(-1);
        i2 = 0;
        while (i2 < 2) {
            canvas.save();
            if (i2 == 1) {
                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
            }
            if (this.u.b < this.u.c) {
                canvas.scale(1.0f, this.u.b / this.u.c, al.n.x, al.n.y);
            } else {
                canvas.scale(this.u.c / this.u.b, 1.0f, al.n.x, al.n.y);
            }
            if (i2 == 0 && this.ak.K != 1.0f) {
                canvas.scale(this.ak.K, this.ak.K, al.n.x, al.n.y);
            } else if (i2 == 1 && this.ak.L != 1.0f) {
                canvas.scale(this.ak.L, this.ak.L, al.n.x, al.n.y);
            }
            if (i2 == 0 && this.ak.l != 0.0f) {
                canvas.rotate(this.ak.l, al.n.x, al.n.y);
            } else if (i2 == 1 && this.ak.m != 0.0f) {
                canvas.rotate(this.ak.m, al.n.x, al.n.y);
            }
            f2 = i2 == 0 ? this.ak.E : this.ak.G;
            f3 = i2 == 0 ? this.ak.F : this.ak.H;
            f = i2 == 0 ? this.ak.M : this.ak.N;
            this.aT.left = (al.n.x - al.u) + f2;
            this.aT.right = f2 + (al.n.x + al.u);
            this.aT.top = by.a(f, 0.0f, 1.0f, al.n.y, al.j.y) + f3;
            this.aT.bottom = by.a(f, 0.0f, 1.0f, al.n.y, al.l.y) + f3;
            canvas.clipRect(this.aT);
            canvas.drawCircle(al.n.x, al.n.y, al.n.y - al.j.y, this.aw);
            canvas.restore();
            i2++;
        }
        canvas.restore();
        canvas.restore();
        canvas.save();
        canvas.translate(this.w.d, this.w.e);
        if (this.P != null) {
            i = 0;
            while (i < 2) {
                canvas.save();
                f3 = i == 0 ? this.ak.c : this.ak.d;
                f = i == 0 ? this.ak.s : this.ak.u;
                float f4 = i == 0 ? this.ak.t : this.ak.v;
                if (i == 1) {
                    canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
                }
                canvas.rotate(f3, 250.0f + ((al.ac.x - 250.0f) * this.w.b), al.W.y);
                canvas.translate(f, f4);
                canvas.scale(this.w.b, this.w.c, al.C.x, al.C.y);
                canvas.scale(1.0f, this.w.b / this.w.c, 250.0f, al.aa.y);
                if (bhVar == bh.SHOES) {
                    a(canvas, a4, bhVar);
                }
                if (i == 0 && this.ak.e != 0.0f) {
                    canvas.rotate(this.ak.e, al.aa.x, al.aa.y);
                } else if (i == 1 && this.ak.f != 0.0f) {
                    canvas.rotate(this.ak.f, al.aa.x, al.aa.y);
                }
                this.P.draw(canvas);
                canvas.restore();
                i++;
            }
        }
        canvas.restore();
        if (this.H != null) {
            canvas.save();
            canvas.rotate(this.ak.j, al.D.x, al.D.y);
            canvas.translate(this.ak.y, this.ak.z);
            canvas.scale(this.t.b, this.t.c, al.z.x, al.z.y);
            if (bhVar != bh.SHIRT) {
                bhVar2 = bh.BEARD;
            }
            a(canvas, a4, bh.SHIRT);
            this.H.draw(canvas);
            canvas.restore();
        }
        if (this.K != null) {
            canvas.save();
            canvas.rotate(this.ak.j, al.D.x, al.D.y);
            canvas.translate(this.ak.y, this.ak.z);
            canvas.scale(this.t.b, this.t.c, al.z.x, al.z.y);
            if (bhVar != bh.PANTS) {
                bhVar2 = bh.BEARD;
            }
            a(canvas, a4, bh.PANTS);
            this.K.draw(canvas);
            canvas.restore();
        }
        Picture a8 = a("body");
        if (this.G != null) {
            canvas.save();
            canvas.rotate(this.ak.j, al.D.x, al.D.y);
            canvas.translate(this.ak.y, this.ak.z);
            canvas.scale(this.t.b, this.t.c, al.z.x, al.z.y);
            if (bhVar != bh.SHIRT) {
                bh bhVar3 = bh.BEARD;
            }
            a(canvas, a4, bh.SHIRT);
            this.G.draw(canvas);
            canvas.restore();
        }
        if (a8 != null) {
            canvas.save();
            canvas.rotate(this.ak.j, al.D.x, al.D.y);
            canvas.translate(this.ak.y, this.ak.z);
            f3 = Math.min(this.t.b, this.t.c);
            canvas.scale(f3, f3, al.z.x, al.z.y);
            if (bhVar != bh.SHIRT) {
                bhVar3 = bh.BEARD;
            }
            a(canvas, a4, bh.SHIRT);
            a8.draw(canvas);
            canvas.restore();
        }
        float f5 = this.v.d;
        float f6 = this.v.b;
        Picture picture = this.F;
        i2 = 0;
        while (i2 < 2) {
            canvas.save();
            f2 = i2 == 0 ? this.ak.a : this.ak.b;
            f3 = i2 == 0 ? this.ak.o : this.ak.q;
            f = i2 == 0 ? this.ak.p : this.ak.r;
            canvas.rotate(this.ak.j, al.D.x, al.D.y);
            canvas.translate(this.ak.y, this.ak.z);
            ax a9 = a(ay.SHRUG);
            if (a9 != null) {
                canvas.translate(0.0f, a9.e());
            }
            if (i2 == 1) {
                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
            }
            canvas.translate(f5, this.v.e);
            if (i2 == 0) {
                a9 = a(ay.WAVE);
                if (a9 != null) {
                    canvas.rotate(a9.e(), al.E.x, al.E.y);
                }
            }
            canvas.rotate(f2, al.J.x + (((al.K.x - al.J.x) * f6) / 2.0f), al.E.y + ((al.I.y - al.E.y) * f6));
            canvas.translate(f3, f);
            this.aw.setColor(this.A ? al.c.intValue() : al.ai[this.C]);
            if (bhVar != bh.SHIRT) {
                bhVar2 = bh.BEARD;
            }
            a(canvas, a4, bh.SHIRT);
            canvas.drawPath(this.z, this.aw);
            a5 = a(i2 == 0 ? "onlefthand" : "onrighthand");
            a6 = a(i2 == 0 ? "inlefthand" : "inrighthand");
            Picture a10 = a("onbothhands");
            a8 = i2 == 0 ? a("arm") : null;
            Picture a11 = a("sleeve");
            if (picture != null || a5 != null || a6 != null || a10 != null || a8 != null || a11 != null) {
                canvas.save();
                canvas.translate((al.I.x - al.J.x) * (f6 - 1.0f), 0.0f);
                canvas.scale(f6, f6, al.I.x, al.E.y);
                this.av.set(-20000.0f, -20000.0f, 20000.0f, al.I.y);
                if (a8 != null) {
                    a8.draw(canvas);
                }
                canvas.save();
                canvas.clipRect(this.av);
                if (a11 != null) {
                    a11.draw(canvas);
                }
                if (picture != null) {
                    picture.draw(canvas);
                }
                canvas.restore();
                canvas.restore();
                f = (((al.O.y - al.I.y) * this.v.c) - (((al.I.y - al.E.y) * (f6 - this.v.c)) * 2.0f)) / (al.O.y - al.I.y);
                canvas.save();
                canvas.translate((al.I.x - al.J.x) * (f6 - 1.0f), 0.0f);
                canvas.scale(f6, this.v.c, al.E.x, al.E.y);
                canvas.scale(1.0f, f / this.v.c, al.Q.x, al.Q.y);
                this.av.set(-20000.0f, al.I.y, 20000.0f, al.O.y);
                canvas.clipRect(this.av);
                if (a11 != null) {
                    a11.draw(canvas);
                }
                if (picture != null) {
                    picture.draw(canvas);
                }
                canvas.restore();
                canvas.save();
                canvas.translate((al.I.x - al.J.x) * (f6 - 1.0f), 0.0f);
                canvas.scale(f6, this.v.c, al.I.x, al.E.y);
                canvas.scale(1.0f, f6 / this.v.c, al.G.x, al.G.y);
                this.av.set(-20000.0f, al.O.y, 20000.0f, 20000.0f);
                canvas.clipRect(this.av);
                if (a11 != null) {
                    a11.draw(canvas);
                }
                if (picture != null) {
                    picture.draw(canvas);
                }
                canvas.restore();
                if (a5 != null || a10 != null || a6 != null) {
                    canvas.save();
                    canvas.translate((al.I.x - al.J.x) * (f6 - 1.0f), 0.0f);
                    canvas.translate(0.0f, (al.G.y - al.E.y) * (this.v.c - 1.0f));
                    canvas.scale(f6, f6, al.G.x, al.G.y);
                    if (a10 != null) {
                        a10.draw(canvas);
                    }
                    if (a5 != null) {
                        a5.draw(canvas);
                    }
                    if (a6 != null) {
                        a6.draw(canvas);
                    }
                    canvas.restore();
                }
            }
            canvas.restore();
            i2++;
        }
        Picture[] headPictures = getHeadPictures();
        a5 = a("mouth");
        a6 = a("hat");
        canvas.save();
        canvas.rotate(this.ak.j, al.D.x, al.D.y);
        canvas.translate(this.ak.y, this.ak.z);
        canvas.rotate(this.ak.i, al.g.x, al.g.y);
        canvas.translate(this.ak.w, this.ak.x);
        if (a2 != null) {
            canvas.rotate(a2.e(), al.g.x, al.g.y);
        }
        if (a3 != null) {
            canvas.translate(0.0f, a3.e());
        }
        canvas.scale(this.u.b, this.u.c, al.g.x, al.g.y);
        if (this.R != null) {
            canvas.save();
            if (bhVar.i) {
                a(canvas, a4, bhVar);
            }
            this.R.draw(canvas);
            canvas.restore();
        }
        if (!(this.M == null && this.O == null)) {
            canvas.save();
            if (bhVar.i) {
                a(canvas, a4, bhVar);
            }
            if (this.M != null) {
                this.M.draw(canvas);
            }
            if (this.O != null) {
                this.O.draw(canvas);
            }
            canvas.restore();
        }
        if (a6 != null) {
            a6.draw(canvas);
        }
        if (this.Q != null) {
            canvas.save();
            canvas.scale(1.0f, this.u.b / this.u.c, al.g.x, al.n.y);
            if (bhVar.i) {
                a(canvas, a4, bhVar);
            }
            this.Q.draw(canvas);
            canvas.restore();
        }
        if (a5 != null) {
            a5.draw(canvas);
        }
        if (headPictures[0] != null) {
            headPictures[0].draw(canvas);
        }
        if (headPictures[1] != null) {
            headPictures[1].draw(canvas);
        }
        canvas.restore();
        i = 0;
        while (i < 2) {
            f3 = i == 0 ? this.ak.a : this.ak.b;
            f = i == 0 ? this.ak.o : this.ak.q;
            e = i == 0 ? this.ak.p : this.ak.r;
            canvas.save();
            canvas.rotate(this.ak.j, al.D.x, al.D.y);
            canvas.translate(this.ak.y, this.ak.z);
            if (i == 1) {
                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
            }
            f4 = al.J.x + (((al.K.x - al.J.x) * this.v.b) / 2.0f);
            float f7 = al.E.y + ((al.I.y - al.E.y) * this.v.b);
            canvas.translate(this.v.d, this.v.e);
            canvas.rotate(f3, f4, f7);
            canvas.translate(f, e);
            Picture a12 = a(i == 0 ? "leftshoulder" : "rightshoulder");
            if (a12 != null) {
                canvas.save();
                canvas.translate((al.I.x - al.J.x) * (this.v.b - 1.0f), 0.0f);
                canvas.scale(this.v.b, this.v.b, al.I.x, al.E.y);
                a12.draw(canvas);
                canvas.restore();
            }
            canvas.restore();
            i++;
        }
        canvas.restore();
        if (this.n > 0.0f) {
            e = ((float) this.aK.getWidth()) * this.aA;
            float width = (((float) getWidth()) - (3.0f * e)) / 4.0f;
            float f8 = width + e;
            f3 = by.a(this.n, 0.0f, 1.0f, ((float) (-this.aK.getHeight())) * this.aA, 0.0f, an.a);
            f = width;
            for (int i4 = 0; i4 < 3; i4++) {
                canvas.save();
                canvas.translate(f, f3);
                canvas.scale(this.aA, this.aA);
                this.aQ[i4].draw(canvas);
                canvas.restore();
                f += f8;
            }
        }
        if (obj != null) {
            invalidate();
        }
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        a.c("GESTURE: Fling.");
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
        a.c("GESTURE: Long press.");
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        a.c("Scaling!!");
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        if (scaleFactor > 0.0f) {
            switch (bf.b[h(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY()).a.ordinal()]) {
                case cm.HListView_android_divider /*1*/:
                    e(scaleFactor, scaleFactor);
                    break;
                case cm.HListView_hlv_dividerWidth /*2*/:
                    i(scaleFactor, scaleFactor);
                    break;
                case cm.HListView_hlv_headerDividersEnabled /*3*/:
                    j(scaleFactor, scaleFactor);
                    break;
                case cm.HListView_hlv_footerDividersEnabled /*4*/:
                    k(scaleFactor, scaleFactor);
                    break;
            }
        }
        return true;
    }

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        a.c("GESTURE: Scroll.");
        if (!this.bt) {
            bl h = h(this.bp, this.bq);
            this.bw = h.a;
            this.bu = h.b == bk.LEFT;
            Androidify.m();
            switch (bf.b[this.bw.ordinal()]) {
                case cm.HListView_android_divider /*1*/:
                    this.av.set(al.h.x, al.f.y, al.i.x, al.g.y);
                    Androidify.a(this.u.b, this.u.c, motionEvent2.getX(), motionEvent2.getY());
                    c(0);
                    break;
                case cm.HListView_hlv_dividerWidth /*2*/:
                    this.av.set(al.A.x, al.z.y, al.B.x, al.C.y);
                    Androidify.a(this.t.b, this.t.c, motionEvent2.getX(), motionEvent2.getY());
                    c(0);
                    break;
                case cm.HListView_hlv_headerDividersEnabled /*3*/:
                    this.av.set(al.J.x, al.E.y, al.K.x, al.G.y);
                    Androidify.a(this.v.b, this.v.c, motionEvent2.getX(), motionEvent2.getY());
                    c(0);
                    break;
                case cm.HListView_hlv_footerDividersEnabled /*4*/:
                    this.av.set(al.S.x, al.S.y, al.U.x, al.Y.y);
                    Androidify.a(this.w.b, this.w.c, motionEvent2.getX(), motionEvent2.getY());
                    c(0);
                    break;
            }
            this.ad.mapRect(this.av);
            this.br = this.av.width();
            this.bs = this.av.height();
            this.bt = true;
        }
        if (!this.bu) {
            f = -f;
        }
        switch (bf.b[this.bw.ordinal()]) {
            case cm.HListView_android_divider /*1*/:
                e((this.br + f) / this.br, (this.bs + f2) / this.bs);
                Androidify.a(this.u.b, this.u.c, motionEvent2.getX(), motionEvent2.getY());
                break;
            case cm.HListView_hlv_dividerWidth /*2*/:
                i((this.br + f) / this.br, (this.bs - f2) / this.bs);
                Androidify.a(this.t.b, this.t.c, motionEvent2.getX(), motionEvent2.getY());
                break;
            case cm.HListView_hlv_headerDividersEnabled /*3*/:
                j((this.br + f) / this.br, (this.bs - f2) / this.bs);
                Androidify.a(this.v.b, this.v.c, motionEvent2.getX(), motionEvent2.getY());
                break;
            case cm.HListView_hlv_footerDividersEnabled /*4*/:
                k((this.br + f) / this.br, (this.bs - f2) / this.bs);
                Androidify.a(this.w.b, this.w.c, motionEvent2.getX(), motionEvent2.getY());
                break;
        }
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
        a.c("GESTURE: Show press.");
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        int i = 0;
        a.c("GESTURE: Single Tap Up.");
        float[] fArr = new float[]{motionEvent.getX(), motionEvent.getY()};
        if (this.ag != null) {
            this.ag.mapPoints(fArr);
        }
        if (this.n > 0.0f && motionEvent.getY() < this.aA * ((float) this.aK.getHeight())) {
            if (motionEvent.getX() < ((float) (getWidth() / 3))) {
                this.b.a(av.HAIR);
                i = 1;
            } else if (motionEvent.getX() > ((float) ((getWidth() * 2) / 3))) {
                this.b.a(av.BEARD);
                i = 1;
            } else {
                this.b.a(av.GLASSES);
                i = 1;
            }
        }
        if (i == 0) {
            if (g(motionEvent.getX(), motionEvent.getY())) {
                this.b.a(null);
            } else if (fArr[1] < ((float) this.bi)) {
                a.c("  Head touched!");
                this.b.q();
            } else if (fArr[1] < ((float) this.bl)) {
                a.c("  Body touched!");
                this.b.r();
            } else if (fArr[1] < ((float) this.bn)) {
                a.c("  Legs touched!");
                this.b.a(av.PANTS);
            } else {
                a.c("  Feet touched!");
                this.b.a(av.SHOES);
            }
        }
        return true;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        a.c("Size changed.");
        b();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            Androidify.n();
        }
        this.aE = System.currentTimeMillis();
        if ((!this.ai.onTouchEvent(motionEvent) || !this.ai.isInProgress()) && !this.bv) {
            return !this.ah.onTouchEvent(motionEvent) ? super.onTouchEvent(motionEvent) : true;
        } else {
            if (motionEvent.getAction() == 1 && motionEvent.getPointerCount() == 1) {
                a.c("Done touch event group, resetting scaling flag.");
                this.bv = false;
                return true;
            }
            this.bv = true;
            return true;
        }
    }

    public void setBeard(Picture picture) {
        this.R = picture;
        postInvalidate();
    }

    public void setBeardBounds(RectF rectF) {
        this.aa = rectF;
    }

    public void setBody(bg bgVar) {
        this.U = bgVar;
        postInvalidate();
    }

    public void setDrawBackground(boolean z) {
        this.c = z;
    }

    public void setFace(bg bgVar) {
        this.T = bgVar;
        postInvalidate();
    }

    public void setGlasses(Picture picture) {
        this.Q = picture;
        postInvalidate();
    }

    public void setGlassesBounds(RectF rectF) {
        this.Z = rectF;
    }

    public void setHairBack(Picture picture) {
        this.L = picture;
        postInvalidate();
    }

    public void setHairBackExtra(Picture picture) {
        this.N = picture;
        postInvalidate();
    }

    public void setHairBounds(RectF rectF) {
        this.W = rectF;
        b();
    }

    public void setHairColorIndex(int i) {
        this.B = i;
    }

    public void setHairFront(Picture picture) {
        this.M = picture;
        postInvalidate();
    }

    public void setHairFrontExtra(Picture picture) {
        this.O = picture;
        postInvalidate();
    }

    public void setHand(bg bgVar) {
        this.V = bgVar;
        b();
        postInvalidate();
    }

    public void setHat(bg bgVar) {
        this.S = bgVar;
        b();
        postInvalidate();
    }

    public void setIdleMotion(int i) {
        e a = com.google.android.apps.androidify.a.a.a(getContext(), i);
        a.a(0.0d);
        this.an = a;
        this.aq = 0.0d;
        this.ar = System.currentTimeMillis();
        this.as = 0;
    }

    public void setLoadingMode(boolean z) {
        this.A = z;
    }

    public void setMotion(e eVar) {
        this.am = eVar;
        this.ao = 0.0d;
        this.ap = System.currentTimeMillis();
        this.as = 0;
    }

    public void setOnGround(boolean z) {
        this.aI = z;
    }

    public void setPaintShadow(boolean z) {
        this.aH = z;
    }

    public void setPantsColorIndex(int i) {
        this.D = i;
    }

    public void setPantsLeg(Picture picture) {
        this.I = picture;
        postInvalidate();
    }

    public void setPantsSkirt(Picture picture) {
        this.K = picture;
        postInvalidate();
    }

    public void setPantsTop(Picture picture) {
        this.J = picture;
        postInvalidate();
    }

    public void setShirtArm(Picture picture) {
        this.F = picture;
        postInvalidate();
    }

    public void setShirtBody(Picture picture) {
        this.E = picture;
        postInvalidate();
    }

    public void setShirtBottom(Picture picture) {
        this.H = picture;
    }

    public void setShirtTop(Picture picture) {
        this.G = picture;
    }

    public void setSkinColorIndex(int i) {
        this.C = i;
    }

    public void setTutorialView(TutorialView tutorialView) {
        this.aj = tutorialView;
    }
}
