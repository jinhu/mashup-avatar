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
import com.google.android.C0176a;
import com.google.android.apps.androidify.p018a.C0204a;
import com.google.android.apps.androidify.p018a.C0205b;
import com.google.android.apps.androidify.p018a.C0208e;
import com.google.android.apps.androidify.p018a.C0213j;
import com.google.android.apps.p019b.C0249b;
import com.google.android.apps.p019b.C0250c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public class DroidView extends View implements OnGestureListener, OnScaleGestureListener {
    static final Random f819a;
    private static final HashMap f820f;
    private static int[] f821g;
    private static final float f822h;
    private boolean f823A;
    private int f824B;
    private int f825C;
    private int f826D;
    private Picture f827E;
    private Picture f828F;
    private Picture f829G;
    private Picture f830H;
    private Picture f831I;
    private Picture f832J;
    private Picture f833K;
    private Picture f834L;
    private Picture f835M;
    private Picture f836N;
    private Picture f837O;
    private Picture f838P;
    private Picture f839Q;
    private Picture f840R;
    private bg f841S;
    private bg f842T;
    private bg f843U;
    private bg f844V;
    private RectF f845W;
    private RectF f846Z;
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
    private C0213j ak;
    private C0213j al;
    private C0208e am;
    private C0208e an;
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
    protected Androidify f847b;
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
    protected boolean f848c;
    protected float f849d;
    Picture[] f850e;
    private float f851i;
    private float f852j;
    private Matrix f853k;
    private Matrix f854l;
    private float f855m;
    private float f856n;
    private float f857o;
    private HashMap f858p;
    private RectF f859q;
    private PointF f860r;
    private float f861s;
    private ch f862t;
    private ch f863u;
    private ch f864v;
    private ch f865w;
    private Picture f866x;
    private Picture f867y;
    private Path f868z;

    static {
        f820f = new HashMap();
        f820f.put(bh.SHOES, Integer.valueOf(R.raw.react_shoes));
        f820f.put(bh.HAIR, Integer.valueOf(R.raw.react_hathair));
        f820f.put(bh.SHIRT, Integer.valueOf(R.raw.react_shirt));
        f820f.put(bh.PANTS, Integer.valueOf(R.raw.react_pants));
        f821g = new int[]{R.raw.idle_blinkonce, R.raw.idle_blinksimple, R.raw.idle_blinktwice, R.raw.idle_drumming, R.raw.idle_lookdown, R.raw.idle_lookleft, R.raw.idle_lookright, R.raw.idle_lookup, R.raw.idle_sway, R.raw.idle_wave};
        f822h = -26.0f * Androidify.m1331a();
        f819a = new Random();
    }

    public DroidView(Context context) {
        super(context);
        this.f858p = new HashMap();
        this.f823A = false;
        this.f827E = null;
        this.f828F = null;
        this.f829G = null;
        this.f830H = null;
        this.f831I = null;
        this.f832J = null;
        this.f833K = null;
        this.f834L = null;
        this.f835M = null;
        this.f836N = null;
        this.f837O = null;
        this.f838P = null;
        this.f839Q = null;
        this.f840R = null;
        this.f841S = null;
        this.f842T = null;
        this.f843U = null;
        this.f844V = null;
        this.f845W = al.f1212w;
        this.f846Z = al.f1213x;
        this.aa = al.f1214y;
        this.ab = al.f1189Z.y;
        this.ad = null;
        this.ae = null;
        this.af = null;
        this.ag = null;
        this.aj = null;
        this.ak = new C0213j();
        this.al = new C0213j();
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
        this.f848c = true;
        this.aE = 0;
        this.aH = true;
        this.aI = false;
        this.aJ = false;
        this.aQ = new Picture[3];
        this.aR = new ci();
        this.aS = new Matrix();
        this.aT = new RectF(al.f1203n.x - al.f1210u, 0.0f, al.f1203n.x + al.f1210u, 0.0f);
        this.aU = new Handler();
        this.aV = new be(this);
        this.aY = false;
        this.aZ = false;
        this.bt = false;
        this.bv = false;
        this.bz = 0;
        this.bA = 0;
        this.bB = new Paint();
        this.f850e = new Picture[2];
    }

    public DroidView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f858p = new HashMap();
        this.f823A = false;
        this.f827E = null;
        this.f828F = null;
        this.f829G = null;
        this.f830H = null;
        this.f831I = null;
        this.f832J = null;
        this.f833K = null;
        this.f834L = null;
        this.f835M = null;
        this.f836N = null;
        this.f837O = null;
        this.f838P = null;
        this.f839Q = null;
        this.f840R = null;
        this.f841S = null;
        this.f842T = null;
        this.f843U = null;
        this.f844V = null;
        this.f845W = al.f1212w;
        this.f846Z = al.f1213x;
        this.aa = al.f1214y;
        this.ab = al.f1189Z.y;
        this.ad = null;
        this.ae = null;
        this.af = null;
        this.ag = null;
        this.aj = null;
        this.ak = new C0213j();
        this.al = new C0213j();
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
        this.f848c = true;
        this.aE = 0;
        this.aH = true;
        this.aI = false;
        this.aJ = false;
        this.aQ = new Picture[3];
        this.aR = new ci();
        this.aS = new Matrix();
        this.aT = new RectF(al.f1203n.x - al.f1210u, 0.0f, al.f1203n.x + al.f1210u, 0.0f);
        this.aU = new Handler();
        this.aV = new be(this);
        this.aY = false;
        this.aZ = false;
        this.bt = false;
        this.bv = false;
        this.bz = 0;
        this.bA = 0;
        this.bB = new Paint();
        this.f850e = new Picture[2];
    }

    public DroidView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f858p = new HashMap();
        this.f823A = false;
        this.f827E = null;
        this.f828F = null;
        this.f829G = null;
        this.f830H = null;
        this.f831I = null;
        this.f832J = null;
        this.f833K = null;
        this.f834L = null;
        this.f835M = null;
        this.f836N = null;
        this.f837O = null;
        this.f838P = null;
        this.f839Q = null;
        this.f840R = null;
        this.f841S = null;
        this.f842T = null;
        this.f843U = null;
        this.f844V = null;
        this.f845W = al.f1212w;
        this.f846Z = al.f1213x;
        this.aa = al.f1214y;
        this.ab = al.f1189Z.y;
        this.ad = null;
        this.ae = null;
        this.af = null;
        this.ag = null;
        this.aj = null;
        this.ak = new C0213j();
        this.al = new C0213j();
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
        this.f848c = true;
        this.aE = 0;
        this.aH = true;
        this.aI = false;
        this.aJ = false;
        this.aQ = new Picture[3];
        this.aR = new ci();
        this.aS = new Matrix();
        this.aT = new RectF(al.f1203n.x - al.f1210u, 0.0f, al.f1203n.x + al.f1210u, 0.0f);
        this.aU = new Handler();
        this.aV = new be(this);
        this.aY = false;
        this.aZ = false;
        this.bt = false;
        this.bv = false;
        this.bz = 0;
        this.bA = 0;
        this.bB = new Paint();
        this.f850e = new Picture[2];
    }

    public DroidView(Androidify androidify, Picture picture, Picture picture2, Picture picture3, Picture picture4, Picture picture5, Picture picture6) {
        super(androidify);
        this.f858p = new HashMap();
        this.f823A = false;
        this.f827E = null;
        this.f828F = null;
        this.f829G = null;
        this.f830H = null;
        this.f831I = null;
        this.f832J = null;
        this.f833K = null;
        this.f834L = null;
        this.f835M = null;
        this.f836N = null;
        this.f837O = null;
        this.f838P = null;
        this.f839Q = null;
        this.f840R = null;
        this.f841S = null;
        this.f842T = null;
        this.f843U = null;
        this.f844V = null;
        this.f845W = al.f1212w;
        this.f846Z = al.f1213x;
        this.aa = al.f1214y;
        this.ab = al.f1189Z.y;
        this.ad = null;
        this.ae = null;
        this.af = null;
        this.ag = null;
        this.aj = null;
        this.ak = new C0213j();
        this.al = new C0213j();
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
        this.f848c = true;
        this.aE = 0;
        this.aH = true;
        this.aI = false;
        this.aJ = false;
        this.aQ = new Picture[3];
        this.aR = new ci();
        this.aS = new Matrix();
        this.aT = new RectF(al.f1203n.x - al.f1210u, 0.0f, al.f1203n.x + al.f1210u, 0.0f);
        this.aU = new Handler();
        this.aV = new be(this);
        this.aY = false;
        this.aZ = false;
        this.bt = false;
        this.bv = false;
        this.bz = 0;
        this.bA = 0;
        this.bB = new Paint();
        this.f850e = new Picture[2];
        m1457a(androidify, picture, picture2, picture3, picture4, picture5, picture6);
    }

    private float m1428a(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    private int m1429a(int i, int i2, float f) {
        return ((int) (((float) (i - i2)) * f)) + i2;
    }

    private void m1431a(Canvas canvas, ax axVar, bh bhVar) {
        switch (bf.f1406a[bhVar.ordinal()]) {
            case cm.HListView_android_divider /*1*/:
            case cm.HListView_hlv_dividerWidth /*2*/:
            case cm.HListView_hlv_headerDividersEnabled /*3*/:
                canvas.scale(axVar.m1761f(), axVar.m1761f(), al.f1196g.x, al.f1196g.y);
            case cm.HListView_hlv_footerDividersEnabled /*4*/:
                canvas.scale(axVar.m1761f(), axVar.m1761f(), al.f1186W.x, (al.f1166C.y + al.aa.y) / 2.0f);
            case cm.HListView_hlv_overScrollHeader /*5*/:
                canvas.scale(axVar.m1761f(), axVar.m1761f(), al.f1196g.x, al.f1167D.y);
            case cm.HListView_hlv_overScrollFooter /*6*/:
                canvas.scale(axVar.m1761f(), axVar.m1761f(), al.f1196g.x, al.aa.y);
            default:
        }
    }

    private float m1434f(float f, float f2) {
        return (f819a.nextFloat() * (f2 - f)) + f;
    }

    private boolean m1435g(float f, float f2) {
        if (f2 > ((float) this.bi)) {
            return f < ((float) this.bg) || f > ((float) this.bh);
        } else {
            float[] fArr = new float[]{f, f2};
            this.f854l.mapPoints(fArr);
            if (!this.f845W.contains(fArr[0], fArr[1])) {
                return true;
            }
            C0176a.m1106c("Touching hair!");
            return false;
        }
    }

    private bl m1436h(float f, float f2) {
        Object obj = 1;
        bl blVar = new bl();
        if (this.bq < ((float) this.bi) + 0.0f) {
            blVar.f1430a = bi.HEAD;
            if (this.bp < ((float) this.bc)) {
                blVar.f1431b = bk.LEFT;
            } else {
                blVar.f1431b = bk.RIGHT;
            }
        } else if (this.bq >= ((float) this.bl) + 0.0f) {
            if (this.bq < 0.0f + ((float) this.bm)) {
                if (this.bp < ((float) this.bb)) {
                    blVar.f1430a = bi.ARM;
                    blVar.f1431b = bk.LEFT;
                } else if (this.bp > ((float) this.bd)) {
                    blVar.f1430a = bi.ARM;
                    blVar.f1431b = bk.RIGHT;
                }
                if (obj == null) {
                    blVar.f1430a = bi.LEG;
                    if (this.bp >= ((float) this.bc)) {
                        blVar.f1431b = bk.LEFT;
                    } else {
                        blVar.f1431b = bk.RIGHT;
                    }
                }
            }
            obj = null;
            if (obj == null) {
                blVar.f1430a = bi.LEG;
                if (this.bp >= ((float) this.bc)) {
                    blVar.f1431b = bk.RIGHT;
                } else {
                    blVar.f1431b = bk.LEFT;
                }
            }
        } else if (this.bp < ((float) this.bb)) {
            blVar.f1430a = bi.ARM;
            blVar.f1431b = bk.LEFT;
        } else if (this.bp > ((float) this.bd)) {
            blVar.f1430a = bi.ARM;
            blVar.f1431b = bk.RIGHT;
        } else {
            blVar.f1430a = bi.BODY;
            if (this.bp < ((float) this.bc)) {
                blVar.f1431b = bk.LEFT;
            } else {
                blVar.f1431b = bk.RIGHT;
            }
        }
        return blVar;
    }

    private void m1437i(float f, float f2) {
        float f3 = this.f862t.f1502c * f2;
        float a = m1428a(this.f862t.f1501b * f, 0.6f, 1.2f);
        if (this.f865w.f1501b > a) {
            m1467c(a, this.f865w.f1502c);
        }
        m1451a(a, m1428a(f3, 0.6f, 1.5f));
    }

    private void m1438j(float f, float f2) {
        m1463b(m1428a(this.f864v.f1501b * f, 0.5f, 1.2f), m1428a(this.f864v.f1502c * f2, 0.6f, 1.5f));
    }

    private void m1439k(float f, float f2) {
        float f3 = this.f865w.f1501b * f;
        float f4 = this.f865w.f1502c * f2;
        if (f3 > this.f862t.f1501b) {
            f3 = this.f862t.f1501b;
        }
        m1467c(m1428a(f3, 0.4f, 1.1f), m1428a(f4, 0.6f, 3.0f));
    }

    private void m1440n() {
        this.as = System.currentTimeMillis() + ((long) C0176a.m1094a(2500, 7000));
    }

    private void m1441o() {
        this.f868z.rewind();
        float f = (al.f1174K.x - al.f1173J.x) * this.f864v.f1501b;
        float f2 = (al.f1170G.y - al.f1168E.y) * this.f864v.f1502c;
        float f3 = f / 2.0f;
        float f4 = f3 * 0.5522848f;
        this.f868z.moveTo(al.f1173J.x, al.f1168E.y + f3);
        this.f868z.rCubicTo(0.0f, -f4, f3 - f4, -f3, f3, -f3);
        this.f868z.rCubicTo(f4, 0.0f, f3, f3 - f4, f3, f3);
        this.f868z.rLineTo(0.0f, f2 - f);
        this.f868z.rCubicTo(0.0f, f4, -(f3 - f4), f3, -f3, f3);
        float f5 = -f3;
        this.f868z.rCubicTo(-f4, 0.0f, -f3, -(f3 - f4), -f3, f5);
        this.f868z.rLineTo(0.0f, -(f2 - f));
        this.f868z.close();
    }

    private void m1442p() {
        if (this.aC) {
            this.bx.setShader(new RadialGradient(250.0f, al.f1215z.y, al.f1188Y.y - ((float) this.bi), new int[]{-1, -12566464}, null, TileMode.CLAMP));
            return;
        }
        this.bx.setShader(new LinearGradient(250.0f, al.f1195f.y, 250.0f, al.f1188Y.y, new int[]{-3618616, -1}, null, TileMode.CLAMP));
    }

    private void m1443q() {
        this.f864v.f1503d = (-(al.f1215z.x - al.f1164A.x)) * (this.f862t.f1501b - 1.0f);
        ch chVar = this.f864v;
        chVar.f1503d -= (al.f1174K.x - al.f1173J.x) * (this.f864v.f1501b - 1.0f);
    }

    private void m1444r() {
        this.f865w.f1504e = (al.f1166C.y - al.f1215z.y) * (this.f862t.f1502c - 1.0f);
    }

    private void m1445s() {
        if (this.ao > this.am.m1609b()) {
            C0176a.m1106c("Motion done.");
            this.ak.m1619a();
            this.am = null;
            m1440n();
        } else if (this.an == null) {
            this.ak.m1620a(this.am, null, 1.0f, this.ao, this.au);
            invalidate();
        } else {
            this.al.m1620a(this.an, null, 1.0f, this.aq, this.au);
            this.ak.m1620a(this.am, this.al, by.m1901b((float) this.ao, 0.0f, 600.0f, 0.0f, 1.0f), this.ao, this.au);
            invalidate();
        }
    }

    private void m1446t() {
        if (this.aq > this.an.m1609b()) {
            C0176a.m1106c("Idle motion done.");
            this.an = null;
            if (this.am == null) {
                this.ak.m1619a();
                m1440n();
                invalidate();
            }
        } else if (this.am == null) {
            this.ak.m1620a(this.an, null, 1.0f, this.aq, this.au);
            invalidate();
        }
    }

    protected float m1447a(int i) {
        return this.f847b.m1385c().m1629a(i);
    }

    public Picture m1448a(String str) {
        return (this.f841S == null || !this.f841S.f1408a.m1643b().equals(str) || this.f841S.f1409b == null) ? (this.f842T == null || !this.f842T.f1408a.m1643b().equals(str) || this.f842T.f1409b == null) ? (this.f843U == null || !this.f843U.f1408a.m1643b().equals(str) || this.f843U.f1409b == null) ? (this.f844V == null || !this.f844V.f1408a.m1643b().equals(str) || this.f844V.f1409b == null) ? null : this.f844V.f1409b.f1708a : this.f843U.f1409b.f1708a : this.f842T.f1409b.f1708a : this.f841S.f1409b.f1708a;
    }

    public ax m1449a(ay ayVar) {
        return (ax) this.at.get(ayVar.toString());
    }

    public bj m1450a() {
        bj bjVar = new bj(this);
        bjVar.start();
        return bjVar;
    }

    public void m1451a(float f, float f2) {
        this.f862t.f1501b = f;
        this.f862t.f1502c = f2;
        m1443q();
        m1444r();
        m1462b();
    }

    public void m1452a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        this.f862t.f1501b = f;
        this.f862t.f1502c = f2;
        this.f863u.f1501b = f3;
        this.f863u.f1502c = f4;
        this.f864v.f1501b = f5;
        this.f864v.f1502c = f6;
        this.f865w.f1501b = f7;
        this.f865w.f1502c = f8;
        m1443q();
        m1444r();
        m1462b();
    }

    public void m1453a(int i, boolean z) {
        if (this.aj != null && this.aj.getStepIndex() == i) {
            if (!this.aj.m1592d() || !this.aj.m1593e() || !z) {
                this.aj.setHidden(!z);
            }
        }
    }

    public void m1454a(Picture picture, Picture picture2) {
        this.f865w.f1500a = picture;
        this.f866x = picture2;
    }

    public void m1455a(Picture picture, Picture picture2, Picture picture3, Picture picture4) {
        this.f863u.f1500a = picture;
        this.f862t.f1500a = picture2;
        this.f864v.f1500a = picture3;
        this.f867y = picture4;
    }

    public void m1456a(Picture picture, RectF rectF) {
        this.f838P = picture;
        this.aG = rectF;
        postInvalidate();
    }

    public void m1457a(Androidify androidify, Picture picture, Picture picture2, Picture picture3, Picture picture4, Picture picture5, Picture picture6) {
        this.ak.f1065R = 0.33333334f;
        this.f847b = androidify;
        this.f866x = picture5;
        this.f867y = picture6;
        this.f862t = new ch(picture);
        this.f863u = new ch(picture2);
        this.f864v = new ch(picture3);
        this.f865w = new ch(picture4);
        setBackgroundColor(-1);
        this.f859q = new RectF();
        this.f860r = new PointF();
        this.ac = C0250c.m2015a("M140.396,175.489v177.916c0,10.566,8.566,19.133,19.135,19.133h2.303h20.331h48.709h37.371h48.708h11.881h10.752c10.569,0,19.137-8.562,19.137-19.133V175.489H140.396z");
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
        this.f868z = new Path();
        m1441o();
        this.at = new HashMap();
        this.f861s = getResources().getDimension(R.dimen.droidview_bottom_margin);
        this.aK = androidify.m1404t().m1657a((int) R.raw.hair_icon).f1708a;
        this.aL = androidify.m1404t().m1657a((int) R.raw.glasses_icon).f1708a;
        this.aM = androidify.m1404t().m1657a((int) R.raw.beard_icon).f1708a;
        this.aN = androidify.m1404t().m1657a((int) R.raw.hair_icon_on).f1708a;
        this.aO = androidify.m1404t().m1657a((int) R.raw.glasses_icon_on).f1708a;
        this.aP = androidify.m1404t().m1657a((int) R.raw.beard_icon_on).f1708a;
        this.aQ[0] = this.aK;
        this.aQ[1] = this.aL;
        this.aQ[2] = this.aM;
        float a = C0220c.m1902a(getContext(), 90.0f);
        this.f857o = getResources().getDimension(R.dimen.droidview_top_margin);
        this.aA = a / ((float) this.aK.getHeight());
        m1440n();
    }

    public void m1458a(av avVar) {
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

    public void m1459a(ax axVar) {
        this.at.put(axVar.m1757b().toString(), axVar);
        postInvalidate();
    }

    public void m1460a(bh bhVar) {
        long currentTimeMillis = System.currentTimeMillis();
        Long l = (Long) this.f858p.get(bhVar);
        if (l == null || currentTimeMillis - l.longValue() > 3000) {
            this.f858p.put(bhVar, Long.valueOf(currentTimeMillis));
            Integer num = (Integer) f820f.get(bhVar);
            if (num != null) {
                C0208e a = C0204a.m1596a(getContext(), num.intValue());
                a.m1605a(0.0d);
                setMotion(a);
                invalidate();
            }
        }
    }

    public void m1461a(boolean z) {
        switch (z ? f819a.nextInt(6) : f819a.nextInt(5) + 1) {
            case cm.HListView_android_entries /*0*/:
                m1479l();
            case cm.HListView_android_divider /*1*/:
                m1478k();
            case cm.HListView_hlv_dividerWidth /*2*/:
                m1477j();
            case cm.HListView_hlv_headerDividersEnabled /*3*/:
                m1476i();
            case cm.HListView_hlv_footerDividersEnabled /*4*/:
                m1475h();
            case cm.HListView_hlv_overScrollHeader /*5*/:
                m1474g();
            default:
        }
    }

    public void m1462b() {
        float f;
        ax axVar;
        float f2 = ((al.f1165B.x - al.f1164A.x) * this.f862t.f1501b) + (((al.f1164A.x - al.f1173J.x) * 2.0f) * this.f864v.f1501b);
        C0176a.m1106c("Body width now: " + f2);
        float f3 = (al.f1198i.x - al.f1197h.x) * this.f863u.f1501b;
        this.aW = Math.max(f2, f3);
        C0176a.m1106c(" Droid width now: " + this.aW);
        C0249b c0249b = this.f844V == null ? null : this.f844V.f1409b;
        if (!(c0249b == null || c0249b.f1710c == null)) {
            f = ((al.f1165B.x - 250.0f) * this.f862t.f1501b) + ((al.f1175L.x - al.f1165B.x) * this.f864v.f1501b);
            this.aW = Math.max(this.aW, Math.max((f + ((Math.max(250.0f - c0249b.f1710c.left, c0249b.f1710c.left - 250.0f) - f) * this.f864v.f1501b)) * 2.0f, (((Math.max(250.0f - c0249b.f1710c.right, c0249b.f1710c.right - 250.0f) - f) * this.f864v.f1501b) + f) * 2.0f));
            C0176a.m1106c(" Droid width width hand now: " + this.aW);
        }
        if (!(this.aX == 0.0f || this.aW == this.aX)) {
            ax a = m1449a(ay.doStroke);
            axVar = new ax(ay.doStroke, 300);
            axVar.m1755a(new DecelerateInterpolator(1.0f), a != null ? a.m1760e() : this.aX, this.aW);
            m1459a(axVar);
            postInvalidate();
        }
        this.aX = this.aW;
        ax a2 = m1449a(ay.doStroke);
        f2 = Math.min(al.f1211v, this.f845W.top);
        C0249b c0249b2 = this.f841S == null ? null : this.f841S.f1409b;
        if (!(c0249b2 == null || c0249b2.f1710c == null)) {
            f2 = Math.min(f2, c0249b2.f1710c.top);
        }
        if (!(f2 == this.f851i || this.aI)) {
            axVar = m1449a(ay.ADJUST_HEIGHT);
            ax axVar2 = new ax(ay.ADJUST_HEIGHT, 300);
            axVar2.m1755a(new DecelerateInterpolator(1.0f), axVar != null ? axVar.m1760e() : this.f851i, f2);
            m1459a(axVar2);
            postInvalidate();
        }
        axVar = m1449a(ay.ADJUST_HEIGHT);
        float e = axVar != null ? axVar.m1760e() : f2;
        f = a2 != null ? a2.m1760e() : this.aW;
        this.f851i = f2;
        f2 = ((al.f1196g.y - e) * this.f863u.f1502c) + (al.f1215z.y - al.f1196g.y);
        e = (al.f1166C.y - al.f1215z.y) * this.f862t.f1502c;
        this.aF = ((al.aa.y - al.f1166C.y) * this.f865w.f1502c) + ((al.f1188Y.y - al.aa.y) * this.f865w.f1501b);
        float f4 = ((this.f845W.bottom - al.f1196g.y) * this.f863u.f1502c) - e;
        if (f4 > this.aF) {
            this.aF = f4;
        }
        f4 = (f2 + e) + this.aF;
        this.f859q.set(al.f1167D.x - (f / 2.0f), al.f1215z.y - f2, al.f1167D.x + (f / 2.0f), (e + al.f1215z.y) + this.aF);
        this.f860r.set((this.f859q.left + this.f859q.right) / 2.0f, (this.f859q.top + this.f859q.bottom) / 2.0f);
        f2 = 1.15f * f;
        f = 1.15f * f4;
        int width = getWidth();
        this.au = Math.min(((float) width) / f2, ((((float) getHeight()) - this.f861s) - this.f857o) / f);
        this.f855m = ((((float) getWidth()) * 0.75f) / f3) / this.au;
        if (this.aJ) {
            f2 = this.f855m;
            this.f856n = 1.0f;
        } else {
            a = m1449a(ay.ZOOM_HEAD_IN);
            axVar = a == null ? m1449a(ay.ZOOM_HEAD_OUT) : a;
            if (axVar != null) {
                f2 = axVar.m1760e();
                if (axVar.m1757b() == ay.ZOOM_HEAD_IN) {
                    this.f856n = axVar.m1758c();
                } else {
                    this.f856n = 1.0f - axVar.m1758c();
                }
            } else {
                this.f856n = 0.0f;
                f2 = 1.0f;
            }
        }
        C0176a.m1106c("Zoom progress = " + this.f856n);
        this.ad = new Matrix();
        this.ad.preTranslate(((float) (width / 2)) - this.f860r.x, (((float) (getHeight() / 2)) - this.f860r.y) + (this.f857o / 2.0f));
        this.ad.preScale(this.au, this.au, this.f860r.x, this.f860r.y);
        this.ad.preScale(f2, f2, al.f1195f.x, (al.f1196g.y - al.f1195f.y) * -2.0f);
        this.ad.preTranslate(0.0f, (al.f1188Y.y - al.aa.y) * -2.0f);
        this.ad.invert(this.ae);
        this.f853k = new Matrix();
        this.f854l = new Matrix();
        this.f853k.preTranslate(((float) (width / 2)) - this.f860r.x, ((float) (getHeight() / 2)) - this.f860r.y);
        this.f853k.preScale(this.au, this.au, this.f860r.x, this.f860r.y);
        this.f853k.preScale(f2, f2, al.f1195f.x, (al.f1196g.y - al.f1195f.y) * -2.0f);
        this.f853k.preScale(this.f863u.f1501b, this.f863u.f1502c, al.f1196g.x, al.f1196g.y);
        this.f853k.preTranslate(0.0f, (al.f1188Y.y - al.aa.y) * -2.0f);
        this.f853k.invert(this.f854l);
        float[] fArr = new float[]{al.f1215z.x, al.f1215z.y};
        this.ad.mapPoints(fArr);
        this.bc = (int) fArr[0];
        this.bb = (int) (((float) this.bc) - (((250.0f - al.f1164A.x) * this.f862t.f1501b) * this.au));
        this.bd = (int) (((float) this.bc) + (((250.0f - al.f1164A.x) * this.f862t.f1501b) * this.au));
        this.be = (int) (((float) this.bc) - (((250.0f - al.f1182S.x) * this.f865w.f1501b) * this.au));
        this.bf = (int) (((float) this.bc) + (((250.0f - al.f1182S.x) * this.f865w.f1501b) * this.au));
        float f5 = (al.f1164A.x - al.f1174K.x) * this.au;
        f3 = ((al.f1174K.x - al.f1173J.x) * this.f864v.f1501b) * this.au;
        this.bg = (int) ((((float) this.bb) - f5) - f3);
        this.bh = (int) ((f5 + ((float) this.bd)) + f3);
        this.bi = (int) fArr[1];
        this.bj = (int) (((float) this.bi) - (f2 * (((al.f1196g.y - al.f1195f.y) * this.f863u.f1502c) * this.au)));
        this.bk = (int) (fArr[1] + ((((al.f1166C.y - al.f1215z.y) * this.f862t.f1502c) * this.au) / 2.0f));
        this.bl = (int) (fArr[1] + (((al.f1166C.y - al.f1215z.y) * this.f862t.f1502c) * this.au));
        this.bn = (int) (fArr[1] + ((((al.f1166C.y - al.f1215z.y) * this.f862t.f1502c) + ((al.aa.y - al.f1166C.y) * this.f865w.f1502c)) * this.au));
        this.bm = (int) (fArr[1] + (((al.f1170G.y - al.f1168E.y) * this.f864v.f1502c) * this.au));
        this.bi = (int) (((float) this.bi) + f822h);
        this.bj = (int) (((float) this.bj) + f822h);
        this.bk = (int) (((float) this.bk) + f822h);
        this.bl = (int) (((float) this.bl) + f822h);
        this.bn = (int) (((float) this.bn) + f822h);
        this.bm = (int) (((float) this.bm) + f822h);
        if (this.aG == null) {
            this.f849d = ((float) this.bn) + (((al.f1188Y.y - al.aa.y) * this.f865w.f1501b) * this.au);
        } else {
            this.f849d = ((float) this.bn) + (((this.aG.bottom - al.aa.y) * this.f865w.f1501b) * this.au);
        }
        this.bo = (int) ((((float) this.bl) + this.f849d) / 2.0f);
        this.f852j = this.f849d + (((3.0f * (al.f1188Y.y - al.aa.y)) / 2.0f) * this.au);
        if (this.ay) {
            int i = width / 2;
            int height = getHeight();
            this.bb = m1429a(this.bb, i, this.aB);
            this.bc = m1429a(this.bc, i, this.aB);
            this.bd = m1429a(this.bd, i, this.aB);
            this.bi = m1429a(this.bi, height, this.aB);
            this.bk = m1429a(this.bk, height, this.aB);
            this.bm = m1429a(this.bm, height, this.aB);
            this.bl = m1429a(this.bl, height, this.aB);
            this.bn = m1429a(this.bn, height, this.aB);
            this.f849d = (float) m1429a((int) this.f849d, height, this.aB);
        }
        if (this.aY) {
            i = this.aZ ? getHeight() / 2 : 0;
            this.bb = m1429a(this.bb, width, this.ba);
            this.bc = m1429a(this.bc, width, this.ba);
            this.bd = m1429a(this.bd, width, this.ba);
            this.bi = m1429a(this.bi, i, this.ba);
            this.bk = m1429a(this.bk, i, this.ba);
            this.bm = m1429a(this.bm, i, this.ba);
            this.bl = m1429a(this.bl, i, this.ba);
            this.bn = m1429a(this.bn, i, this.ba);
            this.f849d = (float) m1429a((int) this.f849d, i, this.ba);
        }
        m1442p();
        m1441o();
        m1473f();
        if (this.aj != null) {
            f2 = getResources().getDimension(R.dimen.tutorial_item_width);
            f = getResources().getDimension(R.dimen.tutorial_button_width);
            f5 = getResources().getDimension(R.dimen.tutorial_header_height);
            e = getResources().getDimension(R.dimen.tutorial_arrow_bottom_adjust);
            ci a3 = C0220c.m1906a(this, (float) this.bf, (float) this.bo, this.aj);
            this.aj.m1586a(0, a3.f1505a, a3.f1506b);
            this.aj.m1586a(1, f2 / 2.0f, ((float) getHeight()) - e);
            this.aj.m1586a(2, (3.0f * f2) / 2.0f, ((float) getHeight()) - e);
            C0220c.m1906a(this, (float) this.bd, (float) this.bl, this.aj);
            this.aj.m1586a(3, (f2 * 5.0f) / 2.0f, (float) (-getHeight()));
            this.aj.m1586a(4, ((float) getWidth()) - (f / 2.0f), f5);
        }
        postInvalidate();
    }

    public void m1463b(float f, float f2) {
        this.f864v.f1501b = f;
        this.f864v.f1502c = f2;
        m1443q();
        m1462b();
    }

    public void m1464b(int i) {
        if (this.aj != null && this.aj.getStepIndex() == i) {
            this.aj.m1590b();
        }
    }

    public void m1465b(bh bhVar) {
        ax axVar = new ax(ay.BOUNCE_ELEMENT, 300);
        axVar.m1755a(C0176a.m1099a(), 0.0f, 0.0f);
        axVar.m1754a(bhVar.ordinal());
        m1459a(axVar);
        invalidate();
    }

    public void m1466c() {
        m1451a(1.0f, 1.0f);
        m1467c(1.0f, 1.0f);
        m1470d(1.0f, 1.0f);
        m1463b(1.0f, 1.0f);
    }

    public void m1467c(float f, float f2) {
        this.f865w.f1501b = f;
        this.f865w.f1502c = f2;
        m1444r();
        m1462b();
    }

    public void m1468c(int i) {
        if (this.aj != null && this.aj.getStepIndex() == i && this.aj.m1591c() && this.aj.m1589a()) {
            this.aj.setVisibility(8);
            this.aj = null;
        }
    }

    public void m1469d() {
        m1467c(m1434f(0.4f, 1.1f), m1434f(0.6f, 3.0f));
        m1463b(m1434f(0.5f, 1.2f), m1434f(0.6f, 1.5f));
        m1451a(m1434f(0.6f, 1.2f), m1434f(0.6f, 1.5f));
        if (this.f865w.f1501b > this.f862t.f1501b) {
            m1467c(this.f862t.f1501b, this.f865w.f1502c);
        }
    }

    public void m1470d(float f, float f2) {
        this.f863u.f1501b = f;
        this.f863u.f1502c = f2;
        m1462b();
    }

    public void m1471e() {
        this.at.clear();
    }

    public void m1472e(float f, float f2) {
        float f3;
        float f4;
        Object obj = 1;
        float f5 = f * this.f863u.f1501b;
        float f6 = f2 * this.f863u.f1502c;
        Object obj2 = this.f863u.f1501b < f5 ? 1 : null;
        if (this.f863u.f1502c >= f6) {
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
        m1470d(m1428a(f3, 0.6f, 1.8f), m1428a(f4, 0.6f, 1.8f));
    }

    public void m1473f() {
        this.af = new Matrix();
        if (this.ay) {
            this.af.preScale(this.aB, this.aB, (float) (getWidth() / 2), (float) getHeight());
        }
        if (this.aY) {
            this.af.preScale(this.ba, this.ba, this.aZ ? 0.0f : (float) getWidth(), (float) (getHeight() / 2));
        }
        this.af.invert(this.ag);
    }

    public void m1474g() {
        ax axVar = new ax(ay.SHRUG, 1000);
        Interpolator c0205b = new C0205b(0.0f, 0.0f);
        c0205b.m1601a(0.2f, 1.0f);
        c0205b.m1601a(0.8f, 1.0f);
        c0205b.m1601a(1.0f, 0.0f);
        axVar.m1755a(c0205b, 0.0f, al.f1196g.y - al.f1215z.y);
        m1459a(axVar);
    }

    protected float getAmbientHover() {
        return this.f847b.m1385c().m1635e();
    }

    protected float getAmbientShadowScale() {
        return this.f847b.m1385c().m1636f();
    }

    public Bitmap getBitmapOfDroid() {
        boolean a = this.f847b.m1385c().m1631a();
        if (a) {
            this.f847b.m1385c().m1633c();
        }
        Bitmap a2 = C0176a.m1098a((View) this);
        if (a) {
            this.f847b.m1385c().m1632b();
        }
        return a2;
    }

    public float getBottomOfShadow() {
        return this.f852j;
    }

    public ch getDroidArm() {
        return this.f864v;
    }

    public ch getDroidBody() {
        return this.f862t;
    }

    public ch getDroidHead() {
        return this.f863u;
    }

    public ch getDroidLegs() {
        return this.f865w;
    }

    public int getHairColorIndex() {
        return this.f824B;
    }

    public Picture[] getHeadPictures() {
        if (this.f841S == null || this.f841S.f1409b == null || !this.f841S.f1408a.m1643b().equals("head")) {
            this.f850e[0] = null;
        } else {
            this.f850e[0] = this.f841S.f1409b.f1708a;
        }
        if (this.f842T == null || this.f842T.f1409b == null || !this.f842T.f1408a.m1643b().equals("head")) {
            this.f850e[1] = null;
        } else {
            this.f850e[1] = this.f842T.f1409b.f1708a;
        }
        return this.f850e;
    }

    public int getPantsColorIndex() {
        return this.f826D;
    }

    public int getSkinColorIndex() {
        return this.f825C;
    }

    public int getTopY() {
        return this.bi;
    }

    public void m1475h() {
        ax axVar = new ax(ay.NOD, 600);
        Interpolator c0205b = new C0205b(0.0f, 0.0f);
        c0205b.m1601a(0.225f, 1.0f);
        c0205b.m1601a(0.45f, 0.0f);
        c0205b.m1601a(0.55f, 0.0f);
        c0205b.m1601a(0.775f, 1.0f);
        c0205b.m1601a(1.0f, 0.0f);
        axVar.m1755a(c0205b, 0.0f, al.f1215z.y - al.f1196g.y);
        m1459a(axVar);
    }

    public void m1476i() {
        ax axVar = new ax(ay.HEAD_TILT, 1000);
        Interpolator c0205b = new C0205b(0.0f, 0.0f);
        c0205b.m1601a(0.2f, 1.0f);
        c0205b.m1601a(0.8f, 1.0f);
        axVar.m1755a(c0205b, 0.0f, f819a.nextBoolean() ? 8.0f : -8.0f);
        m1459a(axVar);
    }

    public void m1477j() {
        ax axVar = new ax(ay.ANTENNA_TWITCH);
        Interpolator c0205b = new C0205b(0.0f, 0.0f);
        c0205b.m1601a(0.25f, 1.0f);
        c0205b.m1601a(0.5f, 0.0f);
        c0205b.m1601a(0.75f, 1.0f);
        axVar.m1755a(c0205b, 0.0f, 40.0f);
        m1459a(axVar);
    }

    public void m1478k() {
        m1459a(new ax(ay.BLINK));
    }

    public long m1479l() {
        ax axVar = new ax(ay.WAVE, (long) 1200);
        Interpolator c0205b = new C0205b(0.0f, 0.0f);
        c0205b.m1601a(0.35f, 1.0f);
        c0205b.m1601a(0.5f, 0.8f);
        c0205b.m1601a(0.65f, 1.0f);
        axVar.m1755a(c0205b, 0.0f, 160.0f);
        m1459a(axVar);
        return (long) 1200;
    }

    public void m1480m() {
        if (this.ax) {
            this.ax = false;
            m1462b();
            m1473f();
        }
    }

    public boolean onDown(MotionEvent motionEvent) {
        C0176a.m1106c("GESTURE: Down.");
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
            m1462b();
        }
        if (!(m1449a(ay.ADJUST_HEIGHT) == null && m1449a(ay.doStroke) == null && m1449a(ay.ZOOM_HEAD_IN) == null && m1449a(ay.ZOOM_HEAD_OUT) == null)) {
            m1462b();
        }
        Object obj = !this.at.isEmpty() ? 1 : null;
        if (obj != null) {
            Iterator it = this.at.values().iterator();
            while (it.hasNext()) {
                axVar = (ax) it.next();
                if (axVar.m1756a()) {
                    if (axVar.m1757b() == ay.ZOOM_HEAD_IN) {
                        this.aJ = true;
                    }
                    it.remove();
                }
            }
        }
        axVar = m1449a(ay.SHRINK_LEFT);
        ax a = m1449a(ay.SHRINK_UP);
        if (axVar != null && a != null) {
            e = axVar.m1760e();
            canvas.scale(e, e, (float) getWidth(), (float) (getHeight() / 2));
            e = a.m1760e();
            canvas.scale(e, e, (float) getWidth(), 0.0f);
        } else if (axVar != null) {
            e = axVar.m1760e();
            canvas.scale(e, e, (float) getWidth(), (float) (getHeight() / 2));
        } else if (a != null) {
            e = a.m1760e();
            canvas.scale(e, e, (float) getWidth(), 0.0f);
        } else if (this.aY) {
            canvas.scale(this.ba, this.ba, (float) getWidth(), this.aZ ? (float) (getHeight() / 2) : 0.0f);
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.ao = (double) (currentTimeMillis - this.ap);
        this.aq = (double) (currentTimeMillis - this.ar);
        if (this.am == null && this.an == null && this.as > 0 && currentTimeMillis >= this.as) {
            C0176a.m1106c("Starting idle animation.");
            setIdleMotion(C0176a.m1095a(f821g));
            invalidate();
        }
        if (this.an != null) {
            m1446t();
        }
        if (this.am != null) {
            m1445s();
        }
        currentTimeMillis /= 1000;
        if (currentTimeMillis > this.bA) {
            this.bz = 0;
            this.bA = currentTimeMillis;
        } else {
            this.bz++;
        }
        ax a2 = m1449a(ay.HEAD_TILT);
        ax a3 = m1449a(ay.NOD);
        ax a4 = m1449a(ay.BOUNCE_ELEMENT);
        bh bhVar = bh.NONE;
        if (a4 != null) {
            bhVar = bh.values()[a4.m1759d()];
        }
        if (this.ay) {
            a = m1449a(ay.SHRINK_DOWN);
            if (a != null) {
                canvas.scale(a.m1760e(), a.m1760e(), (float) (getWidth() / 2), (float) getHeight());
            } else {
                canvas.scale(this.aB, this.aB, (float) (getWidth() / 2), (float) getHeight());
            }
        } else {
            a = m1449a(ay.SHRINK_DOWN);
            if (a != null) {
                canvas.scale(a.m1760e(), a.m1760e(), (float) (getWidth() / 2), (float) getHeight());
            }
        }
        canvas.translate(0.0f, f822h);
        canvas.concat(this.ad);
        canvas.rotate(this.ak.f1080k, al.f1167D.x, al.f1167D.y);
        canvas.translate(this.ak.f1048A, this.ak.f1049B);
        canvas.scale(this.ak.f1064Q, 1.0f, al.f1167D.x, al.f1167D.y);
        if (this.f848c) {
            canvas.save();
            this.av.set(-10000.0f, -10000.0f, 10000.0f, 10000.0f);
            if (this.aC) {
                canvas.translate(0.0f, (((al.f1166C.y - al.f1215z.y) * this.f862t.f1502c) + ((al.aa.y - al.f1166C.y) * this.f865w.f1502c)) + ((al.f1188Y.y - al.aa.y) * this.f865w.f1501b));
                canvas.scale(1.0f, 0.5f, 250.0f, al.f1167D.y);
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
            float f = this.aG != null ? (this.aG.bottom - al.aa.y) * this.f865w.f1501b : (al.f1188Y.y - al.aa.y) * this.f865w.f1501b;
            canvas.translate(this.f865w.f1503d, (this.aI ? f - ((al.f1188Y.y - al.aa.y) / 2.0f) : f + ((al.f1188Y.y - al.aa.y) / 2.0f)) + this.f865w.f1504e);
            canvas.scale(1.0f, this.f865w.f1502c, al.f1166C.x, al.f1166C.y);
            canvas.scale(1.0f, 1.0f / this.f865w.f1502c, 250.0f, al.aa.y);
            canvas.scale(((this.aI ? 1.1f : 0.75f) * this.f862t.f1501b) * getAmbientShadowScale(), 1.0f, 250.0f, al.aa.y);
            this.by.setColor(-2136956768);
            this.av.set(al.f1172I.x, al.aa.y, al.f1175L.x, al.f1189Z.y);
            canvas.drawOval(this.av, this.by);
            canvas.restore();
        }
        canvas.translate(0.0f, getAmbientHover());
        canvas.save();
        canvas.rotate(this.ak.f1079j, al.f1167D.x, al.f1167D.y);
        canvas.translate(this.ak.f1094y, this.ak.f1095z);
        canvas.rotate(this.ak.f1078i, al.f1196g.x, al.f1196g.y);
        canvas.translate(this.ak.f1092w, this.ak.f1093x);
        if (a2 != null) {
            canvas.rotate(a2.m1760e(), al.f1196g.x, al.f1196g.y);
        }
        if (a3 != null) {
            canvas.translate(0.0f, a3.m1760e());
        }
        canvas.scale(this.f863u.f1501b, this.f863u.f1502c, al.f1196g.x, al.f1196g.y);
        if (bhVar.f1419i) {
            m1431a(canvas, a4, bhVar);
        }
        if (this.f834L != null) {
            this.f834L.draw(canvas);
        }
        if (this.f836N != null) {
            this.f836N.draw(canvas);
        }
        canvas.restore();
        int i2 = 0;
        while (i2 < 2) {
            float f2 = i2 == 0 ? this.ak.f1072c : this.ak.f1073d;
            float f3 = i2 == 0 ? this.ak.f1088s : this.ak.f1090u;
            f = i2 == 0 ? this.ak.f1089t : this.ak.f1091v;
            canvas.save();
            if (i2 == 1) {
                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
            }
            canvas.translate(this.f865w.f1503d, this.f865w.f1504e);
            canvas.rotate(f2, 250.0f + ((al.ac.x - 250.0f) * this.f865w.f1501b), al.f1186W.y);
            canvas.translate(f3, f);
            canvas.scale(this.f865w.f1501b, this.f865w.f1502c, al.f1166C.x, al.f1166C.y);
            if (bhVar != bh.PANTS) {
                bh bhVar2 = bh.BEARD;
                if (bhVar != bh.SHIRT_AND_PANTS) {
                    this.f865w.f1500a.draw(canvas);
                    canvas.restore();
                    i2++;
                }
            }
            m1431a(canvas, a4, bh.PANTS);
            this.f865w.f1500a.draw(canvas);
            canvas.restore();
            i2++;
        }
        canvas.save();
        canvas.translate(this.f865w.f1503d, this.f865w.f1504e);
        i2 = 0;
        while (i2 < 2) {
            f2 = i2 == 0 ? this.ak.f1072c : this.ak.f1073d;
            f3 = i2 == 0 ? this.ak.f1088s : this.ak.f1090u;
            f = i2 == 0 ? this.ak.f1089t : this.ak.f1091v;
            canvas.save();
            if (i2 == 1) {
                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
            }
            canvas.rotate(f2, 250.0f + ((al.ac.x - 250.0f) * this.f865w.f1501b), al.f1186W.y);
            canvas.translate(f3, f);
            canvas.scale(this.f865w.f1501b, this.f865w.f1502c, al.f1166C.x, al.f1166C.y);
            canvas.save();
            canvas.scale(1.0f, this.f865w.f1501b / this.f865w.f1502c, 250.0f, al.aa.y);
            if (bhVar != bh.PANTS) {
                bhVar2 = bh.BEARD;
            }
            m1431a(canvas, a4, bh.PANTS);
            this.f866x.draw(canvas);
            canvas.restore();
            canvas.save();
            if (bhVar != bh.PANTS) {
                bhVar2 = bh.BEARD;
            }
            m1431a(canvas, a4, bh.PANTS);
            if (this.f831I != null) {
                this.f831I.draw(canvas);
            }
            canvas.save();
            canvas.scale(1.0f, this.f865w.f1501b / this.f865w.f1502c, i2 == 0 ? al.f1186W.x : al.f1187X.x, al.f1166C.y);
            if (this.f832J != null) {
                this.f832J.draw(canvas);
            }
            canvas.restore();
            canvas.restore();
            canvas.restore();
            i2++;
        }
        canvas.restore();
        canvas.save();
        canvas.rotate(this.ak.f1079j, al.f1167D.x, al.f1167D.y);
        canvas.translate(this.ak.f1094y, this.ak.f1095z);
        if (bhVar != bh.SHIRT) {
            bhVar2 = bh.BEARD;
        }
        m1431a(canvas, a4, bh.SHIRT);
        canvas.save(1);
        canvas.scale(this.f862t.f1501b, this.f862t.f1502c, al.f1215z.x, al.f1215z.y);
        canvas.clipPath(this.ac);
        this.f862t.f1500a.draw(canvas);
        canvas.restore();
        if (this.f827E != null) {
            f = Math.max(this.f862t.f1501b, this.f862t.f1502c);
            if (f < 1.2f) {
                canvas.scale(f / 1.2f, f / 1.2f, al.f1215z.x, al.f1215z.y);
            }
            this.f827E.draw(canvas);
        }
        canvas.restore();
        Picture a5 = m1448a("face");
        canvas.save();
        canvas.rotate(this.ak.f1079j, al.f1167D.x, al.f1167D.y);
        canvas.translate(this.ak.f1094y, this.ak.f1095z);
        if (a2 != null) {
            canvas.rotate(a2.m1760e(), al.f1196g.x, al.f1196g.y);
        }
        canvas.rotate(this.ak.f1078i, al.f1196g.x, al.f1196g.y);
        canvas.translate(this.ak.f1092w, this.ak.f1093x);
        if (a3 != null) {
            canvas.translate(0.0f, a3.m1760e());
        }
        canvas.scale(this.f863u.f1501b, this.f863u.f1502c, al.f1196g.x, al.f1196g.y);
        if (bhVar.f1419i) {
            m1431a(canvas, a4, bhVar);
        }
        this.f863u.f1500a.draw(canvas);
        Picture a6 = m1448a("earring");
        for (int i3 = 0; i3 < 2; i3++) {
            canvas.save();
            if (i3 == 1) {
                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
            }
            if (this.f863u.f1501b > this.f863u.f1502c) {
                canvas.scale(1.0f, this.f863u.f1501b / this.f863u.f1502c, al.f1205p.x, al.f1205p.y);
            } else {
                canvas.scale(this.f863u.f1502c / this.f863u.f1501b, 1.0f, al.f1205p.x, al.f1205p.y);
            }
            ax a7 = m1449a(ay.ANTENNA_TWITCH);
            if (a7 != null) {
                canvas.rotate(a7.m1760e(), al.f1205p.x, al.f1205p.y);
            } else {
                canvas.rotate(m1447a(i3), al.f1205p.x, al.f1205p.y);
            }
            if (i3 == 0 && this.ak.f1076g != 0.0f) {
                canvas.rotate(this.ak.f1076g, al.f1205p.x, al.f1205p.y);
            } else if (i3 == 1 && this.ak.f1077h != 0.0f) {
                canvas.rotate(this.ak.f1077h, al.f1205p.x, al.f1205p.y);
            }
            this.f867y.draw(canvas);
            if (a6 != null) {
                a6.draw(canvas);
            }
            canvas.restore();
        }
        if (a5 != null) {
            a5.draw(canvas);
        }
        canvas.save();
        canvas.translate(this.ak.f1050C, this.ak.f1051D);
        this.aw.setColor(-1);
        i2 = 0;
        while (i2 < 2) {
            canvas.save();
            if (i2 == 1) {
                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
            }
            if (this.f863u.f1501b < this.f863u.f1502c) {
                canvas.scale(1.0f, this.f863u.f1501b / this.f863u.f1502c, al.f1203n.x, al.f1203n.y);
            } else {
                canvas.scale(this.f863u.f1502c / this.f863u.f1501b, 1.0f, al.f1203n.x, al.f1203n.y);
            }
            if (i2 == 0 && this.ak.f1058K != 1.0f) {
                canvas.scale(this.ak.f1058K, this.ak.f1058K, al.f1203n.x, al.f1203n.y);
            } else if (i2 == 1 && this.ak.f1059L != 1.0f) {
                canvas.scale(this.ak.f1059L, this.ak.f1059L, al.f1203n.x, al.f1203n.y);
            }
            if (i2 == 0 && this.ak.f1081l != 0.0f) {
                canvas.rotate(this.ak.f1081l, al.f1203n.x, al.f1203n.y);
            } else if (i2 == 1 && this.ak.f1082m != 0.0f) {
                canvas.rotate(this.ak.f1082m, al.f1203n.x, al.f1203n.y);
            }
            f2 = i2 == 0 ? this.ak.f1052E : this.ak.f1054G;
            f3 = i2 == 0 ? this.ak.f1053F : this.ak.f1055H;
            f = i2 == 0 ? this.ak.f1060M : this.ak.f1061N;
            this.aT.left = (al.f1203n.x - al.f1210u) + f2;
            this.aT.right = f2 + (al.f1203n.x + al.f1210u);
            this.aT.top = by.m1898a(f, 0.0f, 1.0f, al.f1203n.y, al.f1199j.y) + f3;
            this.aT.bottom = by.m1898a(f, 0.0f, 1.0f, al.f1203n.y, al.f1201l.y) + f3;
            canvas.clipRect(this.aT);
            canvas.drawCircle(al.f1203n.x, al.f1203n.y, al.f1203n.y - al.f1199j.y, this.aw);
            canvas.restore();
            i2++;
        }
        canvas.restore();
        canvas.restore();
        canvas.save();
        canvas.translate(this.f865w.f1503d, this.f865w.f1504e);
        if (this.f838P != null) {
            i = 0;
            while (i < 2) {
                canvas.save();
                f3 = i == 0 ? this.ak.f1072c : this.ak.f1073d;
                f = i == 0 ? this.ak.f1088s : this.ak.f1090u;
                float f4 = i == 0 ? this.ak.f1089t : this.ak.f1091v;
                if (i == 1) {
                    canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
                }
                canvas.rotate(f3, 250.0f + ((al.ac.x - 250.0f) * this.f865w.f1501b), al.f1186W.y);
                canvas.translate(f, f4);
                canvas.scale(this.f865w.f1501b, this.f865w.f1502c, al.f1166C.x, al.f1166C.y);
                canvas.scale(1.0f, this.f865w.f1501b / this.f865w.f1502c, 250.0f, al.aa.y);
                if (bhVar == bh.SHOES) {
                    m1431a(canvas, a4, bhVar);
                }
                if (i == 0 && this.ak.f1074e != 0.0f) {
                    canvas.rotate(this.ak.f1074e, al.aa.x, al.aa.y);
                } else if (i == 1 && this.ak.f1075f != 0.0f) {
                    canvas.rotate(this.ak.f1075f, al.aa.x, al.aa.y);
                }
                this.f838P.draw(canvas);
                canvas.restore();
                i++;
            }
        }
        canvas.restore();
        if (this.f830H != null) {
            canvas.save();
            canvas.rotate(this.ak.f1079j, al.f1167D.x, al.f1167D.y);
            canvas.translate(this.ak.f1094y, this.ak.f1095z);
            canvas.scale(this.f862t.f1501b, this.f862t.f1502c, al.f1215z.x, al.f1215z.y);
            if (bhVar != bh.SHIRT) {
                bhVar2 = bh.BEARD;
            }
            m1431a(canvas, a4, bh.SHIRT);
            this.f830H.draw(canvas);
            canvas.restore();
        }
        if (this.f833K != null) {
            canvas.save();
            canvas.rotate(this.ak.f1079j, al.f1167D.x, al.f1167D.y);
            canvas.translate(this.ak.f1094y, this.ak.f1095z);
            canvas.scale(this.f862t.f1501b, this.f862t.f1502c, al.f1215z.x, al.f1215z.y);
            if (bhVar != bh.PANTS) {
                bhVar2 = bh.BEARD;
            }
            m1431a(canvas, a4, bh.PANTS);
            this.f833K.draw(canvas);
            canvas.restore();
        }
        Picture a8 = m1448a("body");
        if (this.f829G != null) {
            canvas.save();
            canvas.rotate(this.ak.f1079j, al.f1167D.x, al.f1167D.y);
            canvas.translate(this.ak.f1094y, this.ak.f1095z);
            canvas.scale(this.f862t.f1501b, this.f862t.f1502c, al.f1215z.x, al.f1215z.y);
            if (bhVar != bh.SHIRT) {
                bh bhVar3 = bh.BEARD;
            }
            m1431a(canvas, a4, bh.SHIRT);
            this.f829G.draw(canvas);
            canvas.restore();
        }
        if (a8 != null) {
            canvas.save();
            canvas.rotate(this.ak.f1079j, al.f1167D.x, al.f1167D.y);
            canvas.translate(this.ak.f1094y, this.ak.f1095z);
            f3 = Math.min(this.f862t.f1501b, this.f862t.f1502c);
            canvas.scale(f3, f3, al.f1215z.x, al.f1215z.y);
            if (bhVar != bh.SHIRT) {
                bhVar3 = bh.BEARD;
            }
            m1431a(canvas, a4, bh.SHIRT);
            a8.draw(canvas);
            canvas.restore();
        }
        float f5 = this.f864v.f1503d;
        float f6 = this.f864v.f1501b;
        Picture picture = this.f828F;
        i2 = 0;
        while (i2 < 2) {
            canvas.save();
            f2 = i2 == 0 ? this.ak.f1070a : this.ak.f1071b;
            f3 = i2 == 0 ? this.ak.f1084o : this.ak.f1086q;
            f = i2 == 0 ? this.ak.f1085p : this.ak.f1087r;
            canvas.rotate(this.ak.f1079j, al.f1167D.x, al.f1167D.y);
            canvas.translate(this.ak.f1094y, this.ak.f1095z);
            ax a9 = m1449a(ay.SHRUG);
            if (a9 != null) {
                canvas.translate(0.0f, a9.m1760e());
            }
            if (i2 == 1) {
                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
            }
            canvas.translate(f5, this.f864v.f1504e);
            if (i2 == 0) {
                a9 = m1449a(ay.WAVE);
                if (a9 != null) {
                    canvas.rotate(a9.m1760e(), al.f1168E.x, al.f1168E.y);
                }
            }
            canvas.rotate(f2, al.f1173J.x + (((al.f1174K.x - al.f1173J.x) * f6) / 2.0f), al.f1168E.y + ((al.f1172I.y - al.f1168E.y) * f6));
            canvas.translate(f3, f);
            this.aw.setColor(this.f823A ? al.f1192c.intValue() : al.ai[this.f825C]);
            if (bhVar != bh.SHIRT) {
                bhVar2 = bh.BEARD;
            }
            m1431a(canvas, a4, bh.SHIRT);
            canvas.drawPath(this.f868z, this.aw);
            a5 = m1448a(i2 == 0 ? "onlefthand" : "onrighthand");
            a6 = m1448a(i2 == 0 ? "inlefthand" : "inrighthand");
            Picture a10 = m1448a("onbothhands");
            a8 = i2 == 0 ? m1448a("arm") : null;
            Picture a11 = m1448a("sleeve");
            if (picture != null || a5 != null || a6 != null || a10 != null || a8 != null || a11 != null) {
                canvas.save();
                canvas.translate((al.f1172I.x - al.f1173J.x) * (f6 - 1.0f), 0.0f);
                canvas.scale(f6, f6, al.f1172I.x, al.f1168E.y);
                this.av.set(-20000.0f, -20000.0f, 20000.0f, al.f1172I.y);
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
                f = (((al.f1178O.y - al.f1172I.y) * this.f864v.f1502c) - (((al.f1172I.y - al.f1168E.y) * (f6 - this.f864v.f1502c)) * 2.0f)) / (al.f1178O.y - al.f1172I.y);
                canvas.save();
                canvas.translate((al.f1172I.x - al.f1173J.x) * (f6 - 1.0f), 0.0f);
                canvas.scale(f6, this.f864v.f1502c, al.f1168E.x, al.f1168E.y);
                canvas.scale(1.0f, f / this.f864v.f1502c, al.f1180Q.x, al.f1180Q.y);
                this.av.set(-20000.0f, al.f1172I.y, 20000.0f, al.f1178O.y);
                canvas.clipRect(this.av);
                if (a11 != null) {
                    a11.draw(canvas);
                }
                if (picture != null) {
                    picture.draw(canvas);
                }
                canvas.restore();
                canvas.save();
                canvas.translate((al.f1172I.x - al.f1173J.x) * (f6 - 1.0f), 0.0f);
                canvas.scale(f6, this.f864v.f1502c, al.f1172I.x, al.f1168E.y);
                canvas.scale(1.0f, f6 / this.f864v.f1502c, al.f1170G.x, al.f1170G.y);
                this.av.set(-20000.0f, al.f1178O.y, 20000.0f, 20000.0f);
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
                    canvas.translate((al.f1172I.x - al.f1173J.x) * (f6 - 1.0f), 0.0f);
                    canvas.translate(0.0f, (al.f1170G.y - al.f1168E.y) * (this.f864v.f1502c - 1.0f));
                    canvas.scale(f6, f6, al.f1170G.x, al.f1170G.y);
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
        a5 = m1448a("mouth");
        a6 = m1448a("hat");
        canvas.save();
        canvas.rotate(this.ak.f1079j, al.f1167D.x, al.f1167D.y);
        canvas.translate(this.ak.f1094y, this.ak.f1095z);
        canvas.rotate(this.ak.f1078i, al.f1196g.x, al.f1196g.y);
        canvas.translate(this.ak.f1092w, this.ak.f1093x);
        if (a2 != null) {
            canvas.rotate(a2.m1760e(), al.f1196g.x, al.f1196g.y);
        }
        if (a3 != null) {
            canvas.translate(0.0f, a3.m1760e());
        }
        canvas.scale(this.f863u.f1501b, this.f863u.f1502c, al.f1196g.x, al.f1196g.y);
        if (this.f840R != null) {
            canvas.save();
            if (bhVar.f1419i) {
                m1431a(canvas, a4, bhVar);
            }
            this.f840R.draw(canvas);
            canvas.restore();
        }
        if (!(this.f835M == null && this.f837O == null)) {
            canvas.save();
            if (bhVar.f1419i) {
                m1431a(canvas, a4, bhVar);
            }
            if (this.f835M != null) {
                this.f835M.draw(canvas);
            }
            if (this.f837O != null) {
                this.f837O.draw(canvas);
            }
            canvas.restore();
        }
        if (a6 != null) {
            a6.draw(canvas);
        }
        if (this.f839Q != null) {
            canvas.save();
            canvas.scale(1.0f, this.f863u.f1501b / this.f863u.f1502c, al.f1196g.x, al.f1203n.y);
            if (bhVar.f1419i) {
                m1431a(canvas, a4, bhVar);
            }
            this.f839Q.draw(canvas);
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
            f3 = i == 0 ? this.ak.f1070a : this.ak.f1071b;
            f = i == 0 ? this.ak.f1084o : this.ak.f1086q;
            e = i == 0 ? this.ak.f1085p : this.ak.f1087r;
            canvas.save();
            canvas.rotate(this.ak.f1079j, al.f1167D.x, al.f1167D.y);
            canvas.translate(this.ak.f1094y, this.ak.f1095z);
            if (i == 1) {
                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
            }
            f4 = al.f1173J.x + (((al.f1174K.x - al.f1173J.x) * this.f864v.f1501b) / 2.0f);
            float f7 = al.f1168E.y + ((al.f1172I.y - al.f1168E.y) * this.f864v.f1501b);
            canvas.translate(this.f864v.f1503d, this.f864v.f1504e);
            canvas.rotate(f3, f4, f7);
            canvas.translate(f, e);
            Picture a12 = m1448a(i == 0 ? "leftshoulder" : "rightshoulder");
            if (a12 != null) {
                canvas.save();
                canvas.translate((al.f1172I.x - al.f1173J.x) * (this.f864v.f1501b - 1.0f), 0.0f);
                canvas.scale(this.f864v.f1501b, this.f864v.f1501b, al.f1172I.x, al.f1168E.y);
                a12.draw(canvas);
                canvas.restore();
            }
            canvas.restore();
            i++;
        }
        canvas.restore();
        if (this.f856n > 0.0f) {
            e = ((float) this.aK.getWidth()) * this.aA;
            float width = (((float) getWidth()) - (3.0f * e)) / 4.0f;
            float f8 = width + e;
            f3 = by.m1899a(this.f856n, 0.0f, 1.0f, ((float) (-this.aK.getHeight())) * this.aA, 0.0f, an.f1218a);
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
        C0176a.m1106c("GESTURE: Fling.");
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
        C0176a.m1106c("GESTURE: Long press.");
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        C0176a.m1106c("Scaling!!");
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        if (scaleFactor > 0.0f) {
            switch (bf.f1407b[m1436h(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY()).f1430a.ordinal()]) {
                case cm.HListView_android_divider /*1*/:
                    m1472e(scaleFactor, scaleFactor);
                    break;
                case cm.HListView_hlv_dividerWidth /*2*/:
                    m1437i(scaleFactor, scaleFactor);
                    break;
                case cm.HListView_hlv_headerDividersEnabled /*3*/:
                    m1438j(scaleFactor, scaleFactor);
                    break;
                case cm.HListView_hlv_footerDividersEnabled /*4*/:
                    m1439k(scaleFactor, scaleFactor);
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
        C0176a.m1106c("GESTURE: Scroll.");
        if (!this.bt) {
            bl h = m1436h(this.bp, this.bq);
            this.bw = h.f1430a;
            this.bu = h.f1431b == bk.LEFT;
            Androidify.m1364m();
            switch (bf.f1407b[this.bw.ordinal()]) {
                case cm.HListView_android_divider /*1*/:
                    this.av.set(al.f1197h.x, al.f1195f.y, al.f1198i.x, al.f1196g.y);
                    Androidify.m1336a(this.f863u.f1501b, this.f863u.f1502c, motionEvent2.getX(), motionEvent2.getY());
                    m1468c(0);
                    break;
                case cm.HListView_hlv_dividerWidth /*2*/:
                    this.av.set(al.f1164A.x, al.f1215z.y, al.f1165B.x, al.f1166C.y);
                    Androidify.m1336a(this.f862t.f1501b, this.f862t.f1502c, motionEvent2.getX(), motionEvent2.getY());
                    m1468c(0);
                    break;
                case cm.HListView_hlv_headerDividersEnabled /*3*/:
                    this.av.set(al.f1173J.x, al.f1168E.y, al.f1174K.x, al.f1170G.y);
                    Androidify.m1336a(this.f864v.f1501b, this.f864v.f1502c, motionEvent2.getX(), motionEvent2.getY());
                    m1468c(0);
                    break;
                case cm.HListView_hlv_footerDividersEnabled /*4*/:
                    this.av.set(al.f1182S.x, al.f1182S.y, al.f1184U.x, al.f1188Y.y);
                    Androidify.m1336a(this.f865w.f1501b, this.f865w.f1502c, motionEvent2.getX(), motionEvent2.getY());
                    m1468c(0);
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
        switch (bf.f1407b[this.bw.ordinal()]) {
            case cm.HListView_android_divider /*1*/:
                m1472e((this.br + f) / this.br, (this.bs + f2) / this.bs);
                Androidify.m1336a(this.f863u.f1501b, this.f863u.f1502c, motionEvent2.getX(), motionEvent2.getY());
                break;
            case cm.HListView_hlv_dividerWidth /*2*/:
                m1437i((this.br + f) / this.br, (this.bs - f2) / this.bs);
                Androidify.m1336a(this.f862t.f1501b, this.f862t.f1502c, motionEvent2.getX(), motionEvent2.getY());
                break;
            case cm.HListView_hlv_headerDividersEnabled /*3*/:
                m1438j((this.br + f) / this.br, (this.bs - f2) / this.bs);
                Androidify.m1336a(this.f864v.f1501b, this.f864v.f1502c, motionEvent2.getX(), motionEvent2.getY());
                break;
            case cm.HListView_hlv_footerDividersEnabled /*4*/:
                m1439k((this.br + f) / this.br, (this.bs - f2) / this.bs);
                Androidify.m1336a(this.f865w.f1501b, this.f865w.f1502c, motionEvent2.getX(), motionEvent2.getY());
                break;
        }
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
        C0176a.m1106c("GESTURE: Show press.");
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        int i = 0;
        C0176a.m1106c("GESTURE: Single Tap Up.");
        float[] fArr = new float[]{motionEvent.getX(), motionEvent.getY()};
        if (this.ag != null) {
            this.ag.mapPoints(fArr);
        }
        if (this.f856n > 0.0f && motionEvent.getY() < this.aA * ((float) this.aK.getHeight())) {
            if (motionEvent.getX() < ((float) (getWidth() / 3))) {
                this.f847b.m1374a(av.HAIR);
                i = 1;
            } else if (motionEvent.getX() > ((float) ((getWidth() * 2) / 3))) {
                this.f847b.m1374a(av.BEARD);
                i = 1;
            } else {
                this.f847b.m1374a(av.GLASSES);
                i = 1;
            }
        }
        if (i == 0) {
            if (m1435g(motionEvent.getX(), motionEvent.getY())) {
                this.f847b.m1374a(null);
            } else if (fArr[1] < ((float) this.bi)) {
                C0176a.m1106c("  Head touched!");
                this.f847b.m1401q();
            } else if (fArr[1] < ((float) this.bl)) {
                C0176a.m1106c("  Body touched!");
                this.f847b.m1402r();
            } else if (fArr[1] < ((float) this.bn)) {
                C0176a.m1106c("  Legs touched!");
                this.f847b.m1374a(av.PANTS);
            } else {
                C0176a.m1106c("  Feet touched!");
                this.f847b.m1374a(av.SHOES);
            }
        }
        return true;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        C0176a.m1106c("Size changed.");
        m1462b();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            Androidify.m1365n();
        }
        this.aE = System.currentTimeMillis();
        if ((!this.ai.onTouchEvent(motionEvent) || !this.ai.isInProgress()) && !this.bv) {
            return !this.ah.onTouchEvent(motionEvent) ? super.onTouchEvent(motionEvent) : true;
        } else {
            if (motionEvent.getAction() == 1 && motionEvent.getPointerCount() == 1) {
                C0176a.m1106c("Done touch event group, resetting scaling flag.");
                this.bv = false;
                return true;
            }
            this.bv = true;
            return true;
        }
    }

    public void setBeard(Picture picture) {
        this.f840R = picture;
        postInvalidate();
    }

    public void setBeardBounds(RectF rectF) {
        this.aa = rectF;
    }

    public void setBody(bg bgVar) {
        this.f843U = bgVar;
        postInvalidate();
    }

    public void setDrawBackground(boolean z) {
        this.f848c = z;
    }

    public void setFace(bg bgVar) {
        this.f842T = bgVar;
        postInvalidate();
    }

    public void setGlasses(Picture picture) {
        this.f839Q = picture;
        postInvalidate();
    }

    public void setGlassesBounds(RectF rectF) {
        this.f846Z = rectF;
    }

    public void setHairBack(Picture picture) {
        this.f834L = picture;
        postInvalidate();
    }

    public void setHairBackExtra(Picture picture) {
        this.f836N = picture;
        postInvalidate();
    }

    public void setHairBounds(RectF rectF) {
        this.f845W = rectF;
        m1462b();
    }

    public void setHairColorIndex(int i) {
        this.f824B = i;
    }

    public void setHairFront(Picture picture) {
        this.f835M = picture;
        postInvalidate();
    }

    public void setHairFrontExtra(Picture picture) {
        this.f837O = picture;
        postInvalidate();
    }

    public void setHand(bg bgVar) {
        this.f844V = bgVar;
        m1462b();
        postInvalidate();
    }

    public void setHat(bg bgVar) {
        this.f841S = bgVar;
        m1462b();
        postInvalidate();
    }

    public void setIdleMotion(int i) {
        C0208e a = C0204a.m1596a(getContext(), i);
        a.m1605a(0.0d);
        this.an = a;
        this.aq = 0.0d;
        this.ar = System.currentTimeMillis();
        this.as = 0;
    }

    public void setLoadingMode(boolean z) {
        this.f823A = z;
    }

    public void setMotion(C0208e c0208e) {
        this.am = c0208e;
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
        this.f826D = i;
    }

    public void setPantsLeg(Picture picture) {
        this.f831I = picture;
        postInvalidate();
    }

    public void setPantsSkirt(Picture picture) {
        this.f833K = picture;
        postInvalidate();
    }

    public void setPantsTop(Picture picture) {
        this.f832J = picture;
        postInvalidate();
    }

    public void setShirtArm(Picture picture) {
        this.f828F = picture;
        postInvalidate();
    }

    public void setShirtBody(Picture picture) {
        this.f827E = picture;
        postInvalidate();
    }

    public void setShirtBottom(Picture picture) {
        this.f830H = picture;
    }

    public void setShirtTop(Picture picture) {
        this.f829G = picture;
    }

    public void setSkinColorIndex(int i) {
        this.f825C = i;
    }

    public void setTutorialView(TutorialView tutorialView) {
        this.aj = tutorialView;
    }
}
