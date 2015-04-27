package com.google.android.apps.androidify;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.View;

import com.google.android.apps.androidify.p018a.AndInterpolator;
import com.google.android.apps.androidify.p018a.AnimationCatalogue;
import com.google.android.apps.androidify.p018a.AnimationContainer;

import java.util.HashMap;
import java.util.Random;

import dev.game.legend.avatar.R;
import dev.game.legend.svgandroid.SVGParser;

public class DroidView extends View implements OnGestureListener, OnScaleGestureListener {
    static final Random f819a;
    private static final HashMap accessoryMap;
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
    private Picture[] mAccessory;
    private ci aR;
    private Matrix aS;
    private RectF aT;
    private float aW;
    private float aX;
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
    private AnimationContainer ak;
    private AnimationContainer al;
    private AnimationCatalogue am;
    private AnimationCatalogue an;
    private double ao;
    private long ap;
    private double aq;
    private long ar;
    private long as;
    private HashMap at;
    private float au;
    private RectF mRectF;
    private Paint aw;
    private boolean ax;
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
    private float mTopY;
    private int bj;
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
    private PartType bw;
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
    private Part f862t;
    private Part f863u;
    private Part f864v;
    private Part f865w;
    private Picture f866x;
    private Picture f867y;
    private Path f868z;

    static {
        accessoryMap = new HashMap();
        accessoryMap.put(AccessoryType.SHOES, Integer.valueOf(R.raw.react_shoes));
        accessoryMap.put(AccessoryType.HAIR, Integer.valueOf(R.raw.react_hathair));
        accessoryMap.put(AccessoryType.SHIRT, Integer.valueOf(R.raw.react_shirt));
        accessoryMap.put(AccessoryType.PANTS, Integer.valueOf(R.raw.react_pants));
        f821g = new int[]{R.raw.idle_blinkonce, R.raw.idle_blinksimple, R.raw.idle_blinktwice, R.raw.idle_drumming, R.raw.idle_lookdown, R.raw.idle_lookleft, R.raw.idle_lookright, R.raw.idle_lookup, R.raw.idle_wave, R.raw.idle_wave};
        f822h = -26.0f * 1;//Androidify.m1331a();
        f819a = new Random();
    }

    private String mName;
    public long aE;
    public Handler aU;
    public Runnable aV;

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
//        this.f845W = al.f1212w;
//        this.f846Z = al.f1213x;
//        this.mCoordinate7 = al.f1214y;
//        this.POINT_TO_REF_36 = al.POINT_TO_REF_40.y;
        this.ad = null;
        this.ae = null;
        this.af = null;
        this.ag = null;
        this.aj = null;
        this.ak = new AnimationContainer();
        this.al = new AnimationContainer();
        this.am = null;
        this.an = null;
        this.ao = 0.0d;
        this.ap = 0;
        this.aq = 0.0d;
        this.ar = 0;
        this.as = 0;
        this.au = -1.0f;
        this.ax = false;
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
        this.mAccessory = new Picture[3];
        this.aR = new ci();
        this.aS = new Matrix();
        //this.aT = new RectF(al.mLocation5.x - al.f1210u, 0.0f, al.mLocation5.x + al.f1210u, 0.0f);
        this.aU = new Handler();
        this.aV = new be(this);
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
//        this.f845W = al.f1212w;
//        this.f846Z = al.f1213x;
//        this.mCoordinate7 = al.f1214y;
//        this.POINT_TO_REF_36 = al.POINT_TO_REF_40.y;
//        this.POINT_TO_REF_38 = null;
        this.ae = null;
        this.af = null;
        this.ag = null;
        this.aj = null;
        this.ak = new AnimationContainer();
        this.al = new AnimationContainer();
        this.am = null;
        this.an = null;
        this.ao = 0.0d;
        this.ap = 0;
        this.aq = 0.0d;
        this.ar = 0;
        this.as = 0;
        this.au = -1.0f;
        this.ax = false;
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
        this.mAccessory = new Picture[3];
        this.aR = new ci();
        this.aS = new Matrix();
        //this.aT = new RectF(al.mLocation5.x - al.f1210u, 0.0f, al.mLocation5.x + al.f1210u, 0.0f);
        this.aU = new Handler();
        this.aV = new be(this);
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
//        this.f845W = al.f1212w;
//        this.f846Z = al.f1213x;
//        this.mCoordinate7 = al.f1214y;
//        this.POINT_TO_REF_36 = al.POINT_TO_REF_40.y;
        this.ad = null;
        this.ae = null;
        this.af = null;
        this.ag = null;
        this.aj = null;
        this.ak = new AnimationContainer();
        this.al = new AnimationContainer();
        this.am = null;
        this.an = null;
        this.ao = 0.0d;
        this.ap = 0;
        this.aq = 0.0d;
        this.ar = 0;
        this.as = 0;
        this.au = -1.0f;
        this.ax = false;
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
        this.mAccessory = new Picture[3];
        this.aR = new ci();
        this.aS = new Matrix();
//        this.aT = new RectF(al.mLocation5.x - al.f1210u, 0.0f, al.mLocation5.x + al.f1210u, 0.0f);
        this.aU = new Handler();
        this.aV = new be(this);
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
//        this.f845W = al.f1212w;
//        this.f846Z = al.f1213x;
//        this.mCoordinate7 = al.f1214y;
//        this.POINT_TO_REF_36 = al.POINT_TO_REF_40.y;
        this.ad = null;
        this.ae = null;
        this.af = null;
        this.ag = null;
        this.aj = null;
        this.ak = new AnimationContainer();
        this.al = new AnimationContainer();
        this.am = null;
        this.an = null;
        this.ao = 0.0d;
        this.ap = 0;
        this.aq = 0.0d;
        this.ar = 0;
        this.as = 0;
        this.au = -1.0f;
        this.mRectF = new RectF();
        this.ax = false;
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
        this.mAccessory = new Picture[3];
        this.aR = new ci();
        this.aS = new Matrix();
//        this.aT = new RectF(al.mLocation5.x - al.f1210u, 0.0f, al.mLocation5.x + al.f1210u, 0.0f);
        this.aU = new Handler();
        this.aV = new be(this);
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

    private void m1431a(Canvas canvas, AndAnimation aAndAnimationVar, AccessoryType aAccessoryTypeVar) {
//        switch (bf.f1406a[aAccessoryTypeVar.ordinal()]) {
//            case cm.HListView_android_divider /*1*/:
//            case cm.HListView_hlv_dividerWidth /*2*/:
//            case cm.HListView_hlv_headerDividersEnabled /*3*/:
//                canvas.scale(axVar.m1761f(), axVar.m1761f(), al.mCoordinate2.x, al.mCoordinate2.y);
//            case cm.HListView_hlv_footerDividersEnabled /*4*/:
//                canvas.scale(axVar.m1761f(), axVar.m1761f(), al.mLocation8.x, (al.mCoordinate3.y + al.mCoordinate7.y) / 2.0f);
//            case cm.HListView_hlv_overScrollHeader /*5*/:
//                canvas.scale(axVar.m1761f(), axVar.m1761f(), al.mCoordinate2.x, al.POINT_CENTER_OF_BODY.y);
//            case cm.HListView_hlv_overScrollFooter /*6*/:
//                canvas.scale(axVar.m1761f(), axVar.m1761f(), al.mCoordinate2.x, al.mCoordinate7.y);
//            default:
//        }
    }

    private float m1434f(float f, float f2) {
        return (f819a.nextFloat() * (f2 - f)) + f;
    }

    private boolean m1435g(float f, float f2) {
        if (f2 > ((float) this.mTopY)) {
            return f < ((float) this.bg) || f > ((float) this.bh);
        } else {
            float[] fArr = new float[]{f, f2};
            this.f854l.mapPoints(fArr);
            if (!this.f845W.contains(fArr[0], fArr[1])) {
                return true;
            }
            com.google.android.Util.debug("Touching hair!");
            return false;
        }
    }

    private BodyPart m1436h(float f, float f2) {
        Object obj = 1;
        BodyPart bodyPartVar = new BodyPart();
        if (this.bq < ((float) this.mTopY) + 0.0f) {
            bodyPartVar.mPart = PartType.HEAD;
            if (this.bp < ((float) this.bc)) {
                bodyPartVar.mSide = SideType.LEFT;
            } else {
                bodyPartVar.mSide = SideType.RIGHT;
            }
        } else if (this.bq >= ((float) this.bl) + 0.0f) {
            if (this.bq < 0.0f + ((float) this.bm)) {
                if (this.bp < ((float) this.bb)) {
                    bodyPartVar.mPart = PartType.ARM;
                    bodyPartVar.mSide = SideType.LEFT;
                } else if (this.bp > ((float) this.bd)) {
                    bodyPartVar.mPart = PartType.ARM;
                    bodyPartVar.mSide = SideType.RIGHT;
                }
                if (obj == null) {
                    bodyPartVar.mPart = PartType.LEG;
                    if (this.bp >= ((float) this.bc)) {
                        bodyPartVar.mSide = SideType.LEFT;
                    } else {
                        bodyPartVar.mSide = SideType.RIGHT;
                    }
                }
            }
            obj = null;
            if (obj == null) {
                bodyPartVar.mPart = PartType.LEG;
                if (this.bp >= ((float) this.bc)) {
                    bodyPartVar.mSide = SideType.RIGHT;
                } else {
                    bodyPartVar.mSide = SideType.LEFT;
                }
            }
        } else if (this.bp < ((float) this.bb)) {
            bodyPartVar.mPart = PartType.ARM;
            bodyPartVar.mSide = SideType.LEFT;
        } else if (this.bp > ((float) this.bd)) {
            bodyPartVar.mPart = PartType.ARM;
            bodyPartVar.mSide = SideType.RIGHT;
        } else {
            bodyPartVar.mPart = PartType.BODY;
            if (this.bp < ((float) this.bc)) {
                bodyPartVar.mSide = SideType.LEFT;
            } else {
                bodyPartVar.mSide = SideType.RIGHT;
            }
        }
        return bodyPartVar;
    }

    private void m1437i(float f, float f2) {
        float f3 = this.f862t.scaleY * f2;
        float a = m1428a(this.f862t.scaleX * f, 0.6f, 1.2f);
        if (this.f865w.scaleX > a) {
            m1467c(a, this.f865w.scaleY);
        }
        m1451a(a, m1428a(f3, 0.6f, 1.5f));
    }

    private void m1438j(float f, float f2) {
        m1463b(m1428a(this.f864v.scaleX * f, 0.5f, 1.2f), m1428a(this.f864v.scaleY * f2, 0.6f, 1.5f));
    }

    private void m1439k(float f, float f2) {
        float f3 = this.f865w.scaleX * f;
        float f4 = this.f865w.scaleY * f2;
        if (f3 > this.f862t.scaleX) {
            f3 = this.f862t.scaleX;
        }
        m1467c(m1428a(f3, 0.4f, 1.1f), m1428a(f4, 0.6f, 3.0f));
    }

    private void m1440n() {
        this.as = System.currentTimeMillis() + ((long) com.google.android.Util.m1094a(2500, 7000));
    }

    private void m1441o() {
//        this.f868z.rewind();
//        float f = (al.mLocation6.x - al.mLocation2.x) * this.f864v.scaleX;
//        float f2 = (al.mLocation3.y - al.mLocation4.y) * this.f864v.scaleY;
//        float f3 = f / 2.0f;
//        float f4 = f3 * 0.5522848f;
//        this.f868z.moveTo(al.mLocation2.x, al.mLocation4.y + f3);
//        this.f868z.rCubicTo(0.0f, -f4, f3 - f4, -f3, f3, -f3);
//        this.f868z.rCubicTo(f4, 0.0f, f3, f3 - f4, f3, f3);
//        this.f868z.rLineTo(0.0f, f2 - f);
//        this.f868z.rCubicTo(0.0f, f4, -(f3 - f4), f3, -f3, f3);
//        float f5 = -f3;
//        this.f868z.rCubicTo(-f4, 0.0f, -f3, -(f3 - f4), -f3, f5);
//        this.f868z.rLineTo(0.0f, -(f2 - f));
//        this.f868z.close();
    }

    private void setColor() {
//        if (this.aC) {
//            this.bx.setShader(new RadialGradient(250.0f, al.POINT_TOP_OF_BODY.y, al.POINT_TO_REF_34.y - ((float) this.mTopY), new int[]{-1, -12566464}, null, Shader.TileMode.CLAMP));
//            return;
//        }
//        this.bx.setShader(new LinearGradient(250.0f, al.POINT_TO_REF_1.y, 250.0f, al.POINT_TO_REF_34.y, new int[]{-3618616, -1}, null, Shader.TileMode.CLAMP));
    }

    private void m1443q() {
//        this.f864v.f1503d = (-(al.POINT_TOP_OF_BODY.x - al.POINT_LEFT_OF_LEFT_SHOULDER.x)) * (this.f862t.scaleX - 1.0f);
//        ch chVar = this.f864v;
//        chVar.f1503d -= (al.mLocation6.x - al.mLocation2.x) * (this.f864v.scaleX - 1.0f);
    }

    private void m1444r() {
//        this.f865w.f1504e = (al.mCoordinate3.y - al.POINT_TOP_OF_BODY.y) * (this.f862t.scaleY - 1.0f);
    }

    private void m1445s() {
        if (this.ao > this.am.m1609b()) {
            com.google.android.Util.debug("Motion done.");
            this.ak.m1619a();
            this.am = null;
            m1440n();
        } else if (this.an == null) {
            this.ak.initAnimation(this.am, null, 1.0f, this.ao, this.au);
            invalidate();
        } else {
            this.al.initAnimation(this.an, null, 1.0f, this.aq, this.au);
            //this.ak.initAnimation(this.am, this.al, by.m1901b((float) this.ao, 0.0f, 600.0f, 0.0f, 1.0f), this.ao, this.au);
            invalidate();
        }
    }

    private void m1446t() {
        if (this.aq > this.an.m1609b()) {
            com.google.android.Util.debug("Idle motion done.");
            this.an = null;
            if (this.am == null) {
                this.ak.m1619a();
                m1440n();
                invalidate();
            }
        } else if (this.am == null) {
            this.ak.initAnimation(this.an, null, 1.0f, this.aq, this.au);
            invalidate();
        }
    }

    protected float m1447a(int i) {
        return 0.0f;//this.mAndroidify.getClickListener().m1629a(i);
    }

    public Picture m1448a(String str) {
        return (this.f841S == null || !this.f841S.f1408a.m1643b().equals(str) || this.f841S.f1409b == null) ? (this.f842T == null || !this.f842T.f1408a.m1643b().equals(str) || this.f842T.f1409b == null) ? (this.f843U == null || !this.f843U.f1408a.m1643b().equals(str) || this.f843U.f1409b == null) ? (this.f844V == null || !this.f844V.f1408a.m1643b().equals(str) || this.f844V.f1409b == null) ? null : this.f844V.f1409b.getPicture() : this.f843U.f1409b.getPicture() : this.f842T.f1409b.getPicture() : this.f841S.f1409b.getPicture();
    }

    public AndAnimation defineAnimation(AnimationType aAnimationTypeVar) {
        return (AndAnimation) this.at.get(aAnimationTypeVar.toString());
    }

    public AnimatorThread m1450a() {
        AnimatorThread animatorThreadVar = new AnimatorThread(this);
        animatorThreadVar.start();
        return animatorThreadVar;
    }

    public void m1451a(float f, float f2) {
        this.f862t.scaleX = f;
        this.f862t.scaleY = f2;
        m1443q();
        m1444r();
        m1462b();
    }

    public void m1452a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        this.f862t.scaleX = f;
        this.f862t.scaleY = f2;
        this.f863u.scaleX = f3;
        this.f863u.scaleY = f4;
        this.f864v.scaleX = f5;
        this.f864v.scaleY = f6;
        this.f865w.scaleX = f7;
        this.f865w.scaleY = f8;
        m1443q();
        m1444r();
        m1462b();
    }
//
//    public void proceedTutorial(int i, boolean z) {
//        if (this.aj != null && this.aj.getStepIndex() == i) {
//            if (!this.aj.hasMoreSteps() || !this.aj.isCurrentStepVisible() || !z) {
//                this.aj.setHidden(!z);
//            }
//        }
//    }

    public void m1454a(Picture picture, Picture picture2) {
        this.f865w.picture = picture;
        this.f866x = picture2;
    }

    public void m1455a(Picture picture, Picture picture2, Picture picture3, Picture picture4) {
        this.f863u.picture = picture;
        this.f862t.picture = picture2;
        this.f864v.picture = picture3;
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
        this.f862t = new Part(picture);
        this.f863u = new Part(picture2);
        this.f864v = new Part(picture3);
        this.f865w = new Part(picture4);
        setBackgroundColor(-1);
        this.f859q = new RectF();
        this.f860r = new PointF();
        this.ac = SVGParser.parsePath("M140.396,175.489v177.916c0,10.566,8.566,19.133,19.135,19.133h2.303h20.331h48.709h37.371h48.708h11.881h10.752c10.569,0,19.137-8.562,19.137-19.133V175.489H140.396z");
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
        this.aK = androidify.getAssetDatabase().getSvgFromResource((int) R.raw.hair_icon).getPicture();
        this.aL = androidify.getAssetDatabase().getSvgFromResource((int) R.raw.glasses_icon).getPicture();
        this.aM = androidify.getAssetDatabase().getSvgFromResource((int) R.raw.beard_icon).getPicture();
        this.aN = androidify.getAssetDatabase().getSvgFromResource((int) R.raw.hair_icon_on).getPicture();
        this.aO = androidify.getAssetDatabase().getSvgFromResource((int) R.raw.glasses_icon_on).getPicture();
        this.aP = androidify.getAssetDatabase().getSvgFromResource((int) R.raw.beard_icon_on).getPicture();
        this.mAccessory[0] = this.aK;
        this.mAccessory[1] = this.aL;
        this.mAccessory[2] = this.aM;
        float a = Util.performance(getContext(), 90.0f);
        this.f857o = getResources().getDimension(R.dimen.droidview_top_margin);
        this.aA = a / ((float) this.aK.getHeight());
        m1440n();
    }

    public void m1458a(AccessoryType avVar) {
        if (avVar == AccessoryType.HAIR) {
            this.mAccessory[0] = this.aN;
            this.mAccessory[1] = this.aL;
            this.mAccessory[2] = this.aM;
        } else if (avVar == AccessoryType.GLASSES) {
            this.mAccessory[0] = this.aK;
            this.mAccessory[1] = this.aO;
            this.mAccessory[2] = this.aM;
        } else if (avVar == AccessoryType.BEARD) {
            this.mAccessory[0] = this.aK;
            this.mAccessory[1] = this.aL;
            this.mAccessory[2] = this.aP;
        }
    }

    public void m1459a(AndAnimation aAndAnimationVar) {
        this.at.put(aAndAnimationVar.m1757b().toString(), aAndAnimationVar);
        postInvalidate();
    }

    public void m1460a(AccessoryType aAccessoryTypeVar) {
        long currentTimeMillis = System.currentTimeMillis();
        Long l = (Long) this.f858p.get(aAccessoryTypeVar);
        if (l == null || currentTimeMillis - l.longValue() > 3000) {
            this.f858p.put(aAccessoryTypeVar, Long.valueOf(currentTimeMillis));
            Integer num = (Integer) accessoryMap.get(aAccessoryTypeVar);
            if (num != null) {
                AnimationCatalogue a = null;//C0204a.getAnimationCatalogue(getContext(), num.intValue());
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
//        float f;
//        ax axVar;
//        float f2 = ((al.POINT_TOP_LEFT_OF_BODY.x - al.POINT_LEFT_OF_LEFT_SHOULDER.x) * this.f862t.scaleX) + (((al.POINT_LEFT_OF_LEFT_SHOULDER.x - al.mLocation2.x) * 2.0f) * this.f864v.scaleX);
//        com.google.android.Log.debug("Body width now: " + f2);
//        float f3 = (al.POINT_RIGHT_BOTTOM_OF_HEAD.x - al.POINT_LEFT_BOTTOM_OF_HEAD.x) * this.f863u.scaleX;
//        this.aW = Math.max(f2, f3);
//        com.google.android.Log.debug(" Droid width now: " + this.aW);
//        SVG SVG = this.f844V == null ? null : this.f844V.f1409b;
//        if (!(SVG == null || SVG.scale == null)) {
//            f = ((al.POINT_TOP_LEFT_OF_BODY.x - 250.0f) * this.f862t.scaleX) + ((al.POINT_TO_REF_21.x - al.POINT_TOP_LEFT_OF_BODY.x) * this.f864v.scaleX);
//            this.aW = Math.max(this.aW, Math.max((f + ((Math.max(250.0f - SVG.scale.left, SVG.scale.left - 250.0f) - f) * this.f864v.scaleX)) * 2.0f, (((Math.max(250.0f - SVG.scale.right, SVG.scale.right - 250.0f) - f) * this.f864v.scaleX) + f) * 2.0f));
//            com.google.android.Log.debug(" Droid width width hand now: " + this.aW);
//        }
//        if (!(this.aX == 0.0f || this.aW == this.aX)) {
//            ax a = defineAnimation(AccessoryType.doStroke);
//            axVar = new ax(AccessoryType.doStroke, 300);
//            axVar.interpolate(new DecelerateInterpolator(1.0f), a != null ? a.m1760e() : this.aX, this.aW);
//            m1459a(axVar);
//            postInvalidate();
//        }
//        this.aX = this.aW;
//        ax a2 = defineAnimation(AccessoryType.doStroke);
//        f2 = Math.min(al.f1211v, this.f845W.top);
//        SVG SVG2 = this.f841S == null ? null : this.f841S.f1409b;
//        if (!(SVG2 == null || SVG2.scale == null)) {
//            f2 = Math.min(f2, SVG2.scale.top);
//        }
//        if (!(f2 == this.f851i || this.aI)) {
//            axVar = defineAnimation(AccessoryType.ADJUST_HEIGHT);
//            ax axVar2 = new ax(AccessoryType.ADJUST_HEIGHT, 300);
//            axVar2.interpolate(new DecelerateInterpolator(1.0f), axVar != null ? axVar.m1760e() : this.f851i, f2);
//            m1459a(axVar2);
//            postInvalidate();
//        }
//        axVar = defineAnimation(AccessoryType.ADJUST_HEIGHT);
//        float e = axVar != null ? axVar.m1760e() : f2;
//        f = a2 != null ? a2.m1760e() : this.aW;
//        this.f851i = f2;
//        f2 = ((al.mCoordinate2.y - e) * this.f863u.scaleY) + (al.POINT_TOP_OF_BODY.y - al.mCoordinate2.y);
//        e = (al.mCoordinate3.y - al.POINT_TOP_OF_BODY.y) * this.f862t.scaleY;
//        this.aF = ((al.mCoordinate7.y - al.mCoordinate3.y) * this.f865w.scaleY) + ((al.POINT_TO_REF_34.y - al.mCoordinate7.y) * this.f865w.scaleX);
//        float f4 = ((this.f845W.bottom - al.mCoordinate2.y) * this.f863u.scaleY) - e;
//        if (f4 > this.aF) {
//            this.aF = f4;
//        }
//        f4 = (f2 + e) + this.aF;
//        this.f859q.set(al.POINT_CENTER_OF_BODY.x - (f / 2.0f), al.POINT_TOP_OF_BODY.y - f2, al.POINT_CENTER_OF_BODY.x + (f / 2.0f), (e + al.POINT_TOP_OF_BODY.y) + this.aF);
//        this.f860r.set((this.f859q.left + this.f859q.right) / 2.0f, (this.f859q.top + this.f859q.bottom) / 2.0f);
//        f2 = 1.15f * f;
//        f = 1.15f * f4;
//        int width = getWidth();
//        this.au = Math.min(((float) width) / f2, ((((float) getHeight()) - this.f861s) - this.f857o) / f);
//        this.f855m = ((((float) getWidth()) * 0.75f) / f3) / this.au;
//        if (this.aJ) {
//            f2 = this.f855m;
//            this.f856n = 1.0f;
//        } else {
//            a = defineAnimation(AccessoryType.ZOOM_HEAD_IN);
//            axVar = a == null ? defineAnimation(AccessoryType.ZOOM_HEAD_OUT) : a;
//            if (axVar != null) {
//                f2 = axVar.m1760e();
//                if (axVar.m1757b() == AccessoryType.ZOOM_HEAD_IN) {
//                    this.f856n = axVar.m1758c();
//                } else {
//                    this.f856n = 1.0f - axVar.m1758c();
//                }
//            } else {
//                this.f856n = 0.0f;
//                f2 = 1.0f;
//            }
//        }
//        com.google.android.Log.debug("Zoom progress = " + this.f856n);
//        this.POINT_TO_REF_38 = new Matrix();
//        this.POINT_TO_REF_38.preTranslate(((float) (width / 2)) - this.f860r.x, (((float) (getHeight() / 2)) - this.f860r.y) + (this.f857o / 2.0f));
//        this.POINT_TO_REF_38.preScale(this.au, this.au, this.f860r.x, this.f860r.y);
//        this.POINT_TO_REF_38.preScale(f2, f2, al.POINT_TO_REF_1.x, (al.mCoordinate2.y - al.POINT_TO_REF_1.y) * -2.0f);
//        this.POINT_TO_REF_38.preTranslate(0.0f, (al.POINT_TO_REF_34.y - al.mCoordinate7.y) * -2.0f);
//        this.POINT_TO_REF_38.invert(this.POINT_TO_REF_39);
//        this.f853k = new Matrix();
//        this.f854l = new Matrix();
//        this.f853k.preTranslate(((float) (width / 2)) - this.f860r.x, ((float) (getHeight() / 2)) - this.f860r.y);
//        this.f853k.preScale(this.au, this.au, this.f860r.x, this.f860r.y);
//        this.f853k.preScale(f2, f2, al.POINT_TO_REF_1.x, (al.mCoordinate2.y - al.POINT_TO_REF_1.y) * -2.0f);
//        this.f853k.preScale(this.f863u.scaleX, this.f863u.scaleY, al.mCoordinate2.x, al.mCoordinate2.y);
//        this.f853k.preTranslate(0.0f, (al.POINT_TO_REF_34.y - al.mCoordinate7.y) * -2.0f);
//        this.f853k.invert(this.f854l);
//        float[] fArr = new float[]{al.POINT_TOP_OF_BODY.x, al.POINT_TOP_OF_BODY.y};
//        this.POINT_TO_REF_38.mapPoints(fArr);
//        this.bc = (int) fArr[0];
//        this.bb = (int) (((float) this.bc) - (((250.0f - al.POINT_LEFT_OF_LEFT_SHOULDER.x) * this.f862t.scaleX) * this.au));
//        this.bd = (int) (((float) this.bc) + (((250.0f - al.POINT_LEFT_OF_LEFT_SHOULDER.x) * this.f862t.scaleX) * this.au));
//        this.be = (int) (((float) this.bc) - (((250.0f - al.POINT_TO_REF_28.x) * this.f865w.scaleX) * this.au));
//        this.bf = (int) (((float) this.bc) + (((250.0f - al.POINT_TO_REF_28.x) * this.f865w.scaleX) * this.au));
//        float f5 = (al.POINT_LEFT_OF_LEFT_SHOULDER.x - al.mLocation6.x) * this.au;
//        f3 = ((al.mLocation6.x - al.mLocation2.x) * this.f864v.scaleX) * this.au;
//        this.bg = (int) ((((float) this.bb) - f5) - f3);
//        this.bh = (int) ((f5 + ((float) this.bd)) + f3);
//        this.mTopY = (int) fArr[1];
//        this.bj = (int) (((float) this.mTopY) - (f2 * (((al.mCoordinate2.y - al.POINT_TO_REF_1.y) * this.f863u.scaleY) * this.au)));
//        this.SideType = (int) (fArr[1] + ((((al.mCoordinate3.y - al.POINT_TOP_OF_BODY.y) * this.f862t.scaleY) * this.au) / 2.0f));
//        this.bl = (int) (fArr[1] + (((al.mCoordinate3.y - al.POINT_TOP_OF_BODY.y) * this.f862t.scaleY) * this.au));
//        this.bn = (int) (fArr[1] + ((((al.mCoordinate3.y - al.POINT_TOP_OF_BODY.y) * this.f862t.scaleY) + ((al.mCoordinate7.y - al.mCoordinate3.y) * this.f865w.scaleY)) * this.au));
//        this.bm = (int) (fArr[1] + (((al.mLocation3.y - al.mLocation4.y) * this.f864v.scaleY) * this.au));
//        this.mTopY = (int) (((float) this.mTopY) + f822h);
//        this.bj = (int) (((float) this.bj) + f822h);
//        this.SideType = (int) (((float) this.SideType) + f822h);
//        this.bl = (int) (((float) this.bl) + f822h);
//        this.bn = (int) (((float) this.bn) + f822h);
//        this.bm = (int) (((float) this.bm) + f822h);
//        if (this.aG == null) {
//            this.f849d = ((float) this.bn) + (((al.POINT_TO_REF_34.y - al.mCoordinate7.y) * this.f865w.scaleX) * this.au);
//        } else {
//            this.f849d = ((float) this.bn) + (((this.aG.bottom - al.mCoordinate7.y) * this.f865w.scaleX) * this.au);
//        }
//        this.bo = (int) ((((float) this.bl) + this.f849d) / 2.0f);
//        this.f852j = this.f849d + (((3.0f * (al.POINT_TO_REF_34.y - al.mCoordinate7.y)) / 2.0f) * this.au);
//        if (this.AccessoryType) {
//            int i = width / 2;
//            int height = getHeight();
//            this.bb = m1429a(this.bb, i, this.aB);
//            this.bc = m1429a(this.bc, i, this.aB);
//            this.bd = m1429a(this.bd, i, this.aB);
//            this.mTopY = m1429a(this.mTopY, height, this.aB);
//            this.SideType = m1429a(this.SideType, height, this.aB);
//            this.bm = m1429a(this.bm, height, this.aB);
//            this.bl = m1429a(this.bl, height, this.aB);
//            this.bn = m1429a(this.bn, height, this.aB);
//            this.f849d = (float) m1429a((int) this.f849d, height, this.aB);
//        }
//        if (this.AccessoryType) {
//            i = this.aZ ? getHeight() / 2 : 0;
//            this.bb = m1429a(this.bb, width, this.ba);
//            this.bc = m1429a(this.bc, width, this.ba);
//            this.bd = m1429a(this.bd, width, this.ba);
//            this.mTopY = m1429a(this.mTopY, i, this.ba);
//            this.SideType = m1429a(this.SideType, i, this.ba);
//            this.bm = m1429a(this.bm, i, this.ba);
//            this.bl = m1429a(this.bl, i, this.ba);
//            this.bn = m1429a(this.bn, i, this.ba);
//            this.f849d = (float) m1429a((int) this.f849d, i, this.ba);
//        }
//        setColor();
//        m1441o();
//        m1473f();
//        if (this.aj != null) {
//            f2 = getResources().getDimension(R.dimen.tutorial_item_width);
//            f = getResources().getDimension(R.dimen.tutorial_button_width);
//            f5 = getResources().getDimension(R.dimen.tutorial_header_height);
//            e = getResources().getDimension(R.dimen.tutorial_arrow_bottom_adjust);
//            ci a3 = Log.m1906a(this, (float) this.bf, (float) this.bo, this.aj);
//            this.aj.m1586a(0, a3.f1505a, a3.f1506b);
//            this.aj.m1586a(1, f2 / 2.0f, ((float) getHeight()) - e);
//            this.aj.m1586a(2, (3.0f * f2) / 2.0f, ((float) getHeight()) - e);
//            Log.m1906a(this, (float) this.bd, (float) this.bl, this.aj);
//            this.aj.m1586a(3, (f2 * 5.0f) / 2.0f, (float) (-getHeight()));
//            this.aj.m1586a(4, ((float) getWidth()) - (f / 2.0f), f5);
//        }
//        postInvalidate();
    }

    public void m1463b(float f, float f2) {
        this.f864v.scaleX = f;
        this.f864v.scaleY = f2;
        m1443q();
        m1462b();
    }

    public void m1464b(int i) {
//        if (this.aj != null && this.aj.getStepIndex() == i) {
//            this.aj.m1590b();
//        }
    }

    public void m1465b(AccessoryType aAccessoryTypeVar) {
//        ax axVar = new ax(AccessoryType.BOUNCE_ELEMENT, 300);
//        axVar.interpolate(com.google.android.Log.m1099a(), 0.0f, 0.0f);
//        axVar.m1754a(aAccessoryTypeVar.ordinal());
//        m1459a(axVar);
//        invalidate();
    }

    public void m1466c() {
        m1451a(1.0f, 1.0f);
        m1467c(1.0f, 1.0f);
        m1470d(1.0f, 1.0f);
        m1463b(1.0f, 1.0f);
    }

    public void m1467c(float f, float f2) {
        this.f865w.scaleX = f;
        this.f865w.scaleY = f2;
        m1444r();
        m1462b();
    }

    public void m1468c(int i) {
//        if (this.aj != null && this.aj.getStepIndex() == i && this.aj.m1591c() && this.aj.m1589a()) {
//            this.aj.setVisibility(8);
//            this.aj = null;
//        }
    }

    public void m1469d() {
        m1467c(m1434f(0.4f, 1.1f), m1434f(0.6f, 3.0f));
        m1463b(m1434f(0.5f, 1.2f), m1434f(0.6f, 1.5f));
        m1451a(m1434f(0.6f, 1.2f), m1434f(0.6f, 1.5f));
        if (this.f865w.scaleX > this.f862t.scaleX) {
            m1467c(this.f862t.scaleX, this.f865w.scaleY);
        }
    }

    public void m1470d(float f, float f2) {
        this.f863u.scaleX = f;
        this.f863u.scaleY = f2;
        m1462b();
    }

    public void m1471e() {
        this.at.clear();
    }

    public void m1472e(float f, float f2) {
        float f3;
        float f4;
        Object obj = 1;
        float f5 = f * this.f863u.scaleX;
        float f6 = f2 * this.f863u.scaleY;
        Object obj2 = this.f863u.scaleX < f5 ? 1 : null;
        if (this.f863u.scaleY >= f6) {
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
        this.af.preScale(this.aB, this.aB, (float) (getWidth() / 2), (float) getHeight());
        this.af.preScale(this.ba, this.ba, this.aZ ? 0.0f : (float) getWidth(), (float) (getHeight() / 2));
        this.af.invert(this.ag);
    }

    public void m1474g() {
//        ax axVar = new ax(AccessoryType.SHRUG, 1000);
//        Interpolator c0205b = new C0205b(0.0f, 0.0f);
//        c0205b.nextPoint(0.2f, 1.0f);
//        c0205b.nextPoint(0.8f, 1.0f);
//        c0205b.nextPoint(1.0f, 0.0f);
//        axVar.interpolate(c0205b, 0.0f, al.mCoordinate2.y - al.POINT_TOP_OF_BODY.y);
//        m1459a(axVar);
    }

    protected float getAmbientHover() {
//        return this.mAndroidify.getClickListener().m1635e();
        return 0;
    }

    protected float getAmbientShadowScale() {
//        return this.mAndroidify.getClickListener().m1636f();
        return 0;
    }

    public Bitmap getBitmapOfDroid() {
//        boolean a = this.mAndroidify.getClickListener().m1631a();
//        if (a) {
//            this.mAndroidify.getClickListener().last();
//        }
        Bitmap a2 = com.google.android.Util.m1098a((View) this);
//        if (a) {
//            this.mAndroidify.getClickListener().next();
//        }
        return a2;
    }

    public float getBottomOfShadow() {
        return this.f852j;
    }

    public Part getDroidArm() {
        return this.f864v;
    }

    public Part getDroidBody() {
        return this.f862t;
    }

    public Part getDroidHead() {
        return this.f863u;
    }

    public Part getDroidLegs() {
        return this.f865w;
    }

    public int getHairColorIndex() {
        return this.f824B;
    }

    public Picture[] getHeadPictures() {
        if (this.f841S == null || this.f841S.f1409b == null || !this.f841S.f1408a.m1643b().equals("head")) {
            this.f850e[0] = null;
        } else {
            this.f850e[0] = this.f841S.f1409b.getPicture();
        }
        if (this.f842T == null || this.f842T.f1409b == null || !this.f842T.f1408a.m1643b().equals("head")) {
            this.f850e[1] = null;
        } else {
            this.f850e[1] = this.f842T.f1409b.getPicture();
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
        return (int) this.mTopY;
    }

    public void m1475h() {
        AndAnimation andAnimationVar = new AndAnimation(AnimationType.NOD, 600);
        AndInterpolator interpolator = new AndInterpolator(0.0f, 0.0f);
        interpolator.nextPoint(0.225f, 1.0f);
        interpolator.nextPoint(0.45f, 0.0f);
        interpolator.nextPoint(0.55f, 0.0f);
        interpolator.nextPoint(0.775f, 1.0f);
        interpolator.nextPoint(1.0f, 0.0f);
        andAnimationVar.interpolate(interpolator, 0.0f, 100.0f);//al.POINT_TOP_OF_BODY.y - al.mCoordinate2.y);
        m1459a(andAnimationVar);
    }

    public void m1476i() {
        AndAnimation andAnimationVar = new AndAnimation(AnimationType.HEAD_TILT, 1000);
        AndInterpolator c0205b = new AndInterpolator(0.0f, 0.0f);
        c0205b.nextPoint(0.2f, 1.0f);
        c0205b.nextPoint(0.8f, 1.0f);
        andAnimationVar.interpolate(c0205b, 0.0f, f819a.nextBoolean() ? 8.0f : -8.0f);
        m1459a(andAnimationVar);
    }

    public void m1477j() {
        AndAnimation andAnimationVar = new AndAnimation(AnimationType.ANTENNA_TWITCH);
        AndInterpolator c0205b = new AndInterpolator(0.0f, 0.0f);
        c0205b.nextPoint(0.25f, 1.0f);
        c0205b.nextPoint(0.5f, 0.0f);
        c0205b.nextPoint(0.75f, 1.0f);
        andAnimationVar.interpolate(c0205b, 0.0f, 40.0f);
        m1459a(andAnimationVar);
    }

    public void m1478k() {
        m1459a(new AndAnimation(AnimationType.BLINK));
    }

    public long m1479l() {
        AndAnimation andAnimationVar = new AndAnimation(AnimationType.WAVE, (long) 1200);
        AndInterpolator c0205b = new AndInterpolator(0.0f, 0.0f);
        c0205b.nextPoint(0.35f, 1.0f);
        c0205b.nextPoint(0.5f, 0.8f);
        c0205b.nextPoint(0.65f, 1.0f);
        andAnimationVar.interpolate(c0205b, 0.0f, 160.0f);
        m1459a(andAnimationVar);
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
        com.google.android.Util.debug("GESTURE: Down.");
        float[] fArr = new float[]{motionEvent.getX(), motionEvent.getY()};
        this.bp = fArr[0];
        this.bq = fArr[1];
        this.bt = false;
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onDraw(Canvas canvas) {
//        AndAnimation andAnimationVar;
//        float e;
//        int i;
//        canvas.getSaveCount();
//        canvas.save();
//        if (this.au == -1.0f) {
//            m1462b();
//        }
//        if (!(defineAnimation(AnimationType.ADJUST_HEIGHT) == null && defineAnimation(AnimationType.doStroke) == null && defineAnimation(AnimationType.ZOOM_HEAD_IN) == null && defineAnimation(AnimationType.ZOOM_HEAD_OUT) == null)) {
//            m1462b();
//        }
//        Object obj = !this.at.isEmpty() ? 1 : null;
//        if (obj != null) {
//            Iterator it = this.at.values().iterator();
//            while (it.hasNext()) {
//                andAnimationVar = (AndAnimation) it.next();
//                if (andAnimationVar.step()) {
//                    if (andAnimationVar.m1757b() == AnimationType.ZOOM_HEAD_IN) {
//                        this.aJ = true;
//                    }
//                    it.remove();
//                }
//            }
//        }
//        andAnimationVar = defineAnimation(AnimationType.SHRINK_LEFT);
//        AndAnimation a = defineAnimation(AnimationType.SHRINK_UP);
//        if (andAnimationVar != null && a != null) {
//            e = andAnimationVar.m1760e();
//            canvas.scale(e, e, (float) getWidth(), (float) (getHeight() / 2));
//            e = a.m1760e();
//            canvas.scale(e, e, (float) getWidth(), 0.0f);
//        } else if (andAnimationVar != null) {
//            e = andAnimationVar.m1760e();
//            canvas.scale(e, e, (float) getWidth(), (float) (getHeight() / 2));
//        } else if (a != null) {
//            e = a.m1760e();
//            canvas.scale(e, e, (float) getWidth(), 0.0f);
//        } else  {
//            canvas.scale(this.ba, this.ba, (float) getWidth(), this.aZ ? (float) (getHeight() / 2) : 0.0f);
//        }
//        long currentTimeMillis = System.currentTimeMillis();
//        this.ao = (double) (currentTimeMillis - this.ap);
//        this.aq = (double) (currentTimeMillis - this.ar);
//        if (this.am == null && this.an == null && this.as > 0 && currentTimeMillis >= this.as) {
//            com.google.android.Log.debug("Starting idle animation.");
//            setIdleMotion(com.google.android.Log.m1095a(f821g));
//            invalidate();
//        }
//        if (this.an != null) {
//            m1446t();
//        }
//        if (this.am != null) {
//            m1445s();
//        }
//        currentTimeMillis /= 1000;
//        if (currentTimeMillis > this.bA) {
//            this.bz = 0;
//            this.bA = currentTimeMillis;
//        } else {
//            this.bz++;
//        }
//        AndAnimation a2 = defineAnimation(AnimationType.HEAD_TILT);
//        AndAnimation a3 = defineAnimation(AnimationType.NOD);
//        AndAnimation a4 = defineAnimation(AnimationType.BOUNCE_ELEMENT);
//        AccessoryType accessoryTypeVar = AccessoryType.NONE;
//        if (a4 != null) {
//            accessoryTypeVar = a4.mAccessoryType;
//        }
//        if (true) {
//            a = defineAnimation(AnimationType.SHRINK_DOWN);
//            if (a != null) {
//                canvas.scale(a.m1760e(), a.m1760e(), (float) (getWidth() / 2), (float) getHeight());
//            } else {
//                canvas.scale(this.aB, this.aB, (float) (getWidth() / 2), (float) getHeight());
//            }
//        } else {
//            a = defineAnimation(AnimationType.SHRINK_DOWN);
//            if (a != null) {
//                canvas.scale(a.m1760e(), a.m1760e(), (float) (getWidth() / 2), (float) getHeight());
//            }
//        }
//        canvas.translate(0.0f, f822h);
//        canvas.concat(this.POINT_TO_REF_38);
//        //canvas.rotate(this.ak.f1080k, al.POINT_CENTER_OF_BODY.x, al.POINT_CENTER_OF_BODY.y);
//        canvas.translate(this.ak.f1048A, this.ak.f1049B);
//        //canvas.scale(this.ak.f1064Q, 1.0f, al.POINT_CENTER_OF_BODY.x, al.POINT_CENTER_OF_BODY.y);
//        if (this.f848c) {
//            canvas.save();
//            //PartType.set(-10000.0f, -10000.0f, 10000.0f, 10000.0f);
//            if (this.aC) {
//                //canvas.translate(0.0f, (((al.mCoordinate3.y - al.POINT_TOP_OF_BODY.y) * this.f862t.scaleY) + ((al.mCoordinate7.y - al.mCoordinate3.y) * this.f865w.scaleY)) + ((al.POINT_TO_REF_34.y - al.mCoordinate7.y) * this.f865w.scaleX));
//                //canvas.scale(1.0f, 0.5f, 250.0f, al.POINT_CENTER_OF_BODY.y);
//            } else if (this.aD) {
//                Paint paint = new Paint();
//                paint.setColor(getResources().getColor(R.color.bg_grey));
//                //paint.setStyle(Style.FILL);
//                //canvas.drawRect(this.PartType, paint);
//            } else {
//                //canvas.drawRect(this.PartType, this.bx);
//            }
//            canvas.restore();
//        }
//        if (this.aH && this.aj == null) {
//            canvas.save();
////            float f = this.aG != null ? (this.aG.bottom - al.mCoordinate7.y) * this.f865w.scaleX : (al.POINT_TO_REF_34.y - al.mCoordinate7.y) * this.f865w.scaleX;
////            canvas.translate(this.f865w.f1503d, (this.aI ? f - ((al.POINT_TO_REF_34.y - al.mCoordinate7.y) / 2.0f) : f + ((al.POINT_TO_REF_34.y - al.mCoordinate7.y) / 2.0f)) + this.f865w.f1504e);
////            canvas.scale(1.0f, this.f865w.scaleY, al.mCoordinate3.x, al.mCoordinate3.y);
////            canvas.scale(1.0f, 1.0f / this.f865w.scaleY, 250.0f, al.mCoordinate7.y);
////            canvas.scale(((this.aI ? 1.1f : 0.75f) * this.f862t.scaleX) * getAmbientShadowScale(), 1.0f, 250.0f, al.mCoordinate7.y);
////            this.by.setColor(-2136956768);
////            this.PartType.set(al.mLocation1.x, al.mCoordinate7.y, al.POINT_TO_REF_21.x, al.POINT_TO_REF_40.y);
////            canvas.drawOval(this.PartType, this.by);
//            canvas.restore();
//        }
//        canvas.translate(0.0f, getAmbientHover());
//        canvas.save();
//        canvas.rotate(this.ak.f1079j, al.POINT_CENTER_OF_BODY.x, al.POINT_CENTER_OF_BODY.y);
//        canvas.translate(this.ak.f1094y, this.ak.f1095z);
//        canvas.rotate(this.ak.f1078i, al.mCoordinate2.x, al.mCoordinate2.y);
//        canvas.translate(this.ak.f1092w, this.ak.f1093x);
//        if (a2 != null) {
//            canvas.rotate(a2.m1760e(), al.mCoordinate2.x, al.mCoordinate2.y);
//        }
//        if (a3 != null) {
//            canvas.translate(0.0f, a3.m1760e());
//        }
//        canvas.scale(this.f863u.scaleX, this.f863u.scaleY, al.mCoordinate2.x, al.mCoordinate2.y);
//        if (accessoryTypeVar.enabled) {
//            m1431a(canvas, a4, accessoryTypeVar);
//        }
//        if (this.f834L != null) {
//            this.f834L.draw(canvas);
//        }
//        if (this.f836N != null) {
//            this.f836N.draw(canvas);
//        }
//        canvas.restore();
//        int i2 = 0;
//        while (i2 < 2) {
//            float f2 = i2 == 0 ? this.ak.f1072c : this.ak.f1073d;
//            float f3 = i2 == 0 ? this.ak.f1088s : this.ak.f1090u;
//            f = i2 == 0 ? this.ak.f1089t : this.ak.f1091v;
//            canvas.save();
//            if (i2 == 1) {
//                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
//            }
//            canvas.translate(this.f865w.f1503d, this.f865w.f1504e);
//            canvas.rotate(f2, 250.0f + ((al.mLocation7.x - 250.0f) * this.f865w.scaleX), al.mLocation8.y);
//            canvas.translate(f3, f);
//            canvas.scale(this.f865w.scaleX, this.f865w.scaleY, al.mCoordinate3.x, al.mCoordinate3.y);
//            if (accessoryTypeVar != bh.PANTS) {
//                AccessoryType accessoryTypeVar2 = bh.BEARD;
//                if (accessoryTypeVar != bh.SHIRT_AND_PANTS) {
//                    this.f865w.picture.draw(canvas);
//                    canvas.restore();
//                    i2++;
//                }
//            }
//            m1431a(canvas, a4, bh.PANTS);
//            this.f865w.picture.draw(canvas);
//            canvas.restore();
//            i2++;
//        }
//        canvas.save();
//        canvas.translate(this.f865w.f1503d, this.f865w.f1504e);
//        i2 = 0;
//        while (i2 < 2) {
//            f2 = i2 == 0 ? this.ak.f1072c : this.ak.f1073d;
//            f3 = i2 == 0 ? this.ak.f1088s : this.ak.f1090u;
//            f = i2 == 0 ? this.ak.f1089t : this.ak.f1091v;
//            canvas.save();
//            if (i2 == 1) {
//                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
//            }
//            canvas.rotate(f2, 250.0f + ((al.mLocation7.x - 250.0f) * this.f865w.scaleX), al.mLocation8.y);
//            canvas.translate(f3, f);
//            canvas.scale(this.f865w.scaleX, this.f865w.scaleY, al.mCoordinate3.x, al.mCoordinate3.y);
//            canvas.save();
//            canvas.scale(1.0f, this.f865w.scaleX / this.f865w.scaleY, 250.0f, al.mCoordinate7.y);
//            if (accessoryTypeVar != bh.PANTS) {
//                bhVar2 = bh.BEARD;
//            }
//            m1431a(canvas, a4, bh.PANTS);
//            this.f866x.draw(canvas);
//            canvas.restore();
//            canvas.save();
//            if (accessoryTypeVar != bh.PANTS) {
//                bhVar2 = bh.BEARD;
//            }
//            m1431a(canvas, a4, bh.PANTS);
//            if (this.f831I != null) {
//                this.f831I.draw(canvas);
//            }
//            canvas.save();
//            canvas.scale(1.0f, this.f865w.scaleX / this.f865w.scaleY, i2 == 0 ? al.mLocation8.x : al.mLocation9.x, al.mCoordinate3.y);
//            if (this.f832J != null) {
//                this.f832J.draw(canvas);
//            }
//            canvas.restore();
//            canvas.restore();
//            canvas.restore();
//            i2++;
//        }
//        canvas.restore();
//        canvas.save();
//        canvas.rotate(this.ak.f1079j, al.POINT_CENTER_OF_BODY.x, al.POINT_CENTER_OF_BODY.y);
//        canvas.translate(this.ak.f1094y, this.ak.f1095z);
//        if (accessoryTypeVar != bh.SHIRT) {
//            bhVar2 = bh.BEARD;
//        }
//        m1431a(canvas, a4, bh.SHIRT);
//        canvas.save(1);
//        canvas.scale(this.f862t.scaleX, this.f862t.scaleY, al.POINT_TOP_OF_BODY.x, al.POINT_TOP_OF_BODY.y);
//        canvas.clipPath(this.mLocation7);
//        this.f862t.picture.draw(canvas);
//        canvas.restore();
//        if (this.f827E != null) {
//            f = Math.max(this.f862t.scaleX, this.f862t.scaleY);
//            if (f < 1.2f) {
//                canvas.scale(f / 1.2f, f / 1.2f, al.POINT_TOP_OF_BODY.x, al.POINT_TOP_OF_BODY.y);
//            }
//            this.f827E.draw(canvas);
//        }
//        canvas.restore();
//        Picture a5 = m1448a("face");
//        canvas.save();
//        canvas.rotate(this.ak.f1079j, al.POINT_CENTER_OF_BODY.x, al.POINT_CENTER_OF_BODY.y);
//        canvas.translate(this.ak.f1094y, this.ak.f1095z);
//        if (a2 != null) {
//            canvas.rotate(a2.m1760e(), al.mCoordinate2.x, al.mCoordinate2.y);
//        }
//        canvas.rotate(this.ak.f1078i, al.mCoordinate2.x, al.mCoordinate2.y);
//        canvas.translate(this.ak.f1092w, this.ak.f1093x);
//        if (a3 != null) {
//            canvas.translate(0.0f, a3.m1760e());
//        }
//        canvas.scale(this.f863u.scaleX, this.f863u.scaleY, al.mCoordinate2.x, al.mCoordinate2.y);
//        if (accessoryTypeVar.enabled) {
//            m1431a(canvas, a4, accessoryTypeVar);
//        }
//        this.f863u.picture.draw(canvas);
//        Picture a6 = m1448a("earring");
//        for (int i3 = 0; i3 < 2; i3++) {
//            canvas.save();
//            if (i3 == 1) {
//                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
//            }
//            if (this.f863u.scaleX > this.f863u.scaleY) {
//                canvas.scale(1.0f, this.f863u.scaleX / this.f863u.scaleY, al.mCoordinate5.x, al.mCoordinate5.y);
//            } else {
//                canvas.scale(this.f863u.scaleY / this.f863u.scaleX, 1.0f, al.mCoordinate5.x, al.mCoordinate5.y);
//            }
//            AndAnimation a7 = defineAnimation(AccessoryType.ANTENNA_TWITCH);
//            if (a7 != null) {
//                canvas.rotate(a7.m1760e(), al.mCoordinate5.x, al.mCoordinate5.y);
//            } else {
//                canvas.rotate(m1447a(i3), al.mCoordinate5.x, al.mCoordinate5.y);
//            }
//            if (i3 == 0 && this.ak.f1076g != 0.0f) {
//                canvas.rotate(this.ak.f1076g, al.mCoordinate5.x, al.mCoordinate5.y);
//            } else if (i3 == 1 && this.ak.f1077h != 0.0f) {
//                canvas.rotate(this.ak.f1077h, al.mCoordinate5.x, al.mCoordinate5.y);
//            }
//            this.f867y.draw(canvas);
//            if (a6 != null) {
//                a6.draw(canvas);
//            }
//            canvas.restore();
//        }
//        if (a5 != null) {
//            a5.draw(canvas);
//        }
//        canvas.save();
//        canvas.translate(this.ak.f1050C, this.ak.f1051D);
//        this.aw.setColor(-1);
//        i2 = 0;
//        while (i2 < 2) {
//            canvas.save();
//            if (i2 == 1) {
//                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
//            }
//            if (this.f863u.scaleX < this.f863u.scaleY) {
//                canvas.scale(1.0f, this.f863u.scaleX / this.f863u.scaleY, al.mLocation5.x, al.mLocation5.y);
//            } else {
//                canvas.scale(this.f863u.scaleY / this.f863u.scaleX, 1.0f, al.mLocation5.x, al.mLocation5.y);
//            }
//            if (i2 == 0 && this.ak.f1058K != 1.0f) {
//                canvas.scale(this.ak.f1058K, this.ak.f1058K, al.mLocation5.x, al.mLocation5.y);
//            } else if (i2 == 1 && this.ak.f1059L != 1.0f) {
//                canvas.scale(this.ak.f1059L, this.ak.f1059L, al.mLocation5.x, al.mLocation5.y);
//            }
//            if (i2 == 0 && this.ak.f1081l != 0.0f) {
//                canvas.rotate(this.ak.f1081l, al.mLocation5.x, al.mLocation5.y);
//            } else if (i2 == 1 && this.ak.f1082m != 0.0f) {
//                canvas.rotate(this.ak.f1082m, al.mLocation5.x, al.mLocation5.y);
//            }
//            f2 = i2 == 0 ? this.ak.f1052E : this.ak.f1054G;
//            f3 = i2 == 0 ? this.ak.f1053F : this.ak.f1055H;
//            f = i2 == 0 ? this.ak.f1060M : this.ak.f1061N;
//            this.aT.left = (al.mLocation5.x - al.f1210u) + f2;
//            this.aT.right = f2 + (al.mLocation5.x + al.f1210u);
//            this.aT.top = by.m1898a(f, 0.0f, 1.0f, al.mLocation5.y, al.mLocation0.y) + f3;
//            this.aT.bottom = by.m1898a(f, 0.0f, 1.0f, al.mLocation5.y, al.mCoordinate6.y) + f3;
//            canvas.clipRect(this.aT);
//            canvas.drawCircle(al.mLocation5.x, al.mLocation5.y, al.mLocation5.y - al.mLocation0.y, this.aw);
//            canvas.restore();
//            i2++;
//        }
//        canvas.restore();
//        canvas.restore();
//        canvas.save();
//        canvas.translate(this.f865w.f1503d, this.f865w.f1504e);
//        if (this.f838P != null) {
//            i = 0;
//            while (i < 2) {
//                canvas.save();
//                f3 = i == 0 ? this.ak.f1072c : this.ak.f1073d;
//                f = i == 0 ? this.ak.f1088s : this.ak.f1090u;
//                float f4 = i == 0 ? this.ak.f1089t : this.ak.f1091v;
//                if (i == 1) {
//                    canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
//                }
//                canvas.rotate(f3, 250.0f + ((al.mLocation7.x - 250.0f) * this.f865w.scaleX), al.mLocation8.y);
//                canvas.translate(f, f4);
//                canvas.scale(this.f865w.scaleX, this.f865w.scaleY, al.mCoordinate3.x, al.mCoordinate3.y);
//                canvas.scale(1.0f, this.f865w.scaleX / this.f865w.scaleY, 250.0f, al.mCoordinate7.y);
//                if (accessoryTypeVar == bh.SHOES) {
//                    m1431a(canvas, a4, accessoryTypeVar);
//                }
//                if (i == 0 && this.ak.f1074e != 0.0f) {
//                    canvas.rotate(this.ak.f1074e, al.mCoordinate7.x, al.mCoordinate7.y);
//                } else if (i == 1 && this.ak.f1075f != 0.0f) {
//                    canvas.rotate(this.ak.f1075f, al.mCoordinate7.x, al.mCoordinate7.y);
//                }
//                this.f838P.draw(canvas);
//                canvas.restore();
//                i++;
//            }
//        }
//        canvas.restore();
//        if (this.f830H != null) {
//            canvas.save();
//            canvas.rotate(this.ak.f1079j, al.POINT_CENTER_OF_BODY.x, al.POINT_CENTER_OF_BODY.y);
//            canvas.translate(this.ak.f1094y, this.ak.f1095z);
//            canvas.scale(this.f862t.scaleX, this.f862t.scaleY, al.POINT_TOP_OF_BODY.x, al.POINT_TOP_OF_BODY.y);
//            if (accessoryTypeVar != bh.SHIRT) {
//                bhVar2 = bh.BEARD;
//            }
//            m1431a(canvas, a4, bh.SHIRT);
//            this.f830H.draw(canvas);
//            canvas.restore();
//        }
//        if (this.f833K != null) {
//            canvas.save();
//            canvas.rotate(this.ak.f1079j, al.POINT_CENTER_OF_BODY.x, al.POINT_CENTER_OF_BODY.y);
//            canvas.translate(this.ak.f1094y, this.ak.f1095z);
//            canvas.scale(this.f862t.scaleX, this.f862t.scaleY, al.POINT_TOP_OF_BODY.x, al.POINT_TOP_OF_BODY.y);
//            if (accessoryTypeVar != bh.PANTS) {
//                bhVar2 = bh.BEARD;
//            }
//            m1431a(canvas, a4, bh.PANTS);
//            this.f833K.draw(canvas);
//            canvas.restore();
//        }
//        Picture a8 = m1448a("body");
//        if (this.f829G != null) {
//            canvas.save();
//            canvas.rotate(this.ak.f1079j, al.POINT_CENTER_OF_BODY.x, al.POINT_CENTER_OF_BODY.y);
//            canvas.translate(this.ak.f1094y, this.ak.f1095z);
//            canvas.scale(this.f862t.scaleX, this.f862t.scaleY, al.POINT_TOP_OF_BODY.x, al.POINT_TOP_OF_BODY.y);
//            if (accessoryTypeVar != bh.SHIRT) {
//                AccessoryType accessoryTypeVar3 = bh.BEARD;
//            }
//            m1431a(canvas, a4, bh.SHIRT);
//            this.f829G.draw(canvas);
//            canvas.restore();
//        }
//        if (a8 != null) {
//            canvas.save();
//            canvas.rotate(this.ak.f1079j, al.POINT_CENTER_OF_BODY.x, al.POINT_CENTER_OF_BODY.y);
//            canvas.translate(this.ak.f1094y, this.ak.f1095z);
//            f3 = Math.min(this.f862t.scaleX, this.f862t.scaleY);
//            canvas.scale(f3, f3, al.POINT_TOP_OF_BODY.x, al.POINT_TOP_OF_BODY.y);
//            if (accessoryTypeVar != bh.SHIRT) {
//                bhVar3 = bh.BEARD;
//            }
//            m1431a(canvas, a4, bh.SHIRT);
//            a8.draw(canvas);
//            canvas.restore();
//        }
//        float f5 = this.f864v.f1503d;
//        float f6 = this.f864v.scaleX;
//        Picture picture = this.f828F;
//        i2 = 0;
//        while (i2 < 2) {
//            canvas.save();
//            f2 = i2 == 0 ? this.ak.f1070a : this.ak.f1071b;
//            f3 = i2 == 0 ? this.ak.f1084o : this.ak.f1086q;
//            f = i2 == 0 ? this.ak.f1085p : this.ak.f1087r;
//            canvas.rotate(this.ak.f1079j, al.POINT_CENTER_OF_BODY.x, al.POINT_CENTER_OF_BODY.y);
//            canvas.translate(this.ak.f1094y, this.ak.f1095z);
//            AndAnimation a9 = defineAnimation(AccessoryType.SHRUG);
//            if (a9 != null) {
//                canvas.translate(0.0f, a9.m1760e());
//            }
//            if (i2 == 1) {
//                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
//            }
//            canvas.translate(f5, this.f864v.f1504e);
//            if (i2 == 0) {
//                a9 = defineAnimation(AccessoryType.WAVE);
//                if (a9 != null) {
//                    canvas.rotate(a9.m1760e(), al.mLocation4.x, al.mLocation4.y);
//                }
//            }
//            canvas.rotate(f2, al.mLocation2.x + (((al.mLocation6.x - al.mLocation2.x) * f6) / 2.0f), al.mLocation4.y + ((al.mLocation1.y - al.mLocation4.y) * f6));
//            canvas.translate(f3, f);
//            this.aw.setColor(this.f823A ? al.f1192c.intValue() : al.mSkinColors[this.f825C]);
//            if (accessoryTypeVar != bh.SHIRT) {
//                bhVar2 = bh.BEARD;
//            }
//            m1431a(canvas, a4, bh.SHIRT);
//            canvas.drawPath(this.f868z, this.aw);
//            a5 = m1448a(i2 == 0 ? "onlefthand" : "onrighthand");
//            a6 = m1448a(i2 == 0 ? "inlefthand" : "inrighthand");
//            Picture a10 = m1448a("onbothhands");
//            a8 = i2 == 0 ? m1448a("arm") : null;
//            Picture a11 = m1448a("sleeve");
//            if (picture != null || a5 != null || a6 != null || a10 != null || a8 != null || a11 != null) {
//                canvas.save();
//                canvas.translate((al.mLocation1.x - al.mLocation2.x) * (f6 - 1.0f), 0.0f);
//                canvas.scale(f6, f6, al.mLocation1.x, al.mLocation4.y);
//                this.PartType.set(-20000.0f, -20000.0f, 20000.0f, al.mLocation1.y);
//                if (a8 != null) {
//                    a8.draw(canvas);
//                }
//                canvas.save();
//                canvas.clipRect(this.PartType);
//                if (a11 != null) {
//                    a11.draw(canvas);
//                }
//                if (picture != null) {
//                    picture.draw(canvas);
//                }
//                canvas.restore();
//                canvas.restore();
//                f = (((al.POINT_TO_REF_24.y - al.mLocation1.y) * this.f864v.scaleY) - (((al.mLocation1.y - al.mLocation4.y) * (f6 - this.f864v.scaleY)) * 2.0f)) / (al.POINT_TO_REF_24.y - al.mLocation1.y);
//                canvas.save();
//                canvas.translate((al.mLocation1.x - al.mLocation2.x) * (f6 - 1.0f), 0.0f);
//                canvas.scale(f6, this.f864v.scaleY, al.mLocation4.x, al.mLocation4.y);
//                canvas.scale(1.0f, f / this.f864v.scaleY, al.POINT_TO_REF_26.x, al.POINT_TO_REF_26.y);
//                this.PartType.set(-20000.0f, al.mLocation1.y, 20000.0f, al.POINT_TO_REF_24.y);
//                canvas.clipRect(this.PartType);
//                if (a11 != null) {
//                    a11.draw(canvas);
//                }
//                if (picture != null) {
//                    picture.draw(canvas);
//                }
//                canvas.restore();
//                canvas.save();
//                canvas.translate((al.mLocation1.x - al.mLocation2.x) * (f6 - 1.0f), 0.0f);
//                canvas.scale(f6, this.f864v.scaleY, al.mLocation1.x, al.mLocation4.y);
//                canvas.scale(1.0f, f6 / this.f864v.scaleY, al.mLocation3.x, al.mLocation3.y);
//                this.PartType.set(-20000.0f, al.POINT_TO_REF_24.y, 20000.0f, 20000.0f);
//                canvas.clipRect(this.PartType);
//                if (a11 != null) {
//                    a11.draw(canvas);
//                }
//                if (picture != null) {
//                    picture.draw(canvas);
//                }
//                canvas.restore();
//                if (a5 != null || a10 != null || a6 != null) {
//                    canvas.save();
//                    canvas.translate((al.mLocation1.x - al.mLocation2.x) * (f6 - 1.0f), 0.0f);
//                    canvas.translate(0.0f, (al.mLocation3.y - al.mLocation4.y) * (this.f864v.scaleY - 1.0f));
//                    canvas.scale(f6, f6, al.mLocation3.x, al.mLocation3.y);
//                    if (a10 != null) {
//                        a10.draw(canvas);
//                    }
//                    if (a5 != null) {
//                        a5.draw(canvas);
//                    }
//                    if (a6 != null) {
//                        a6.draw(canvas);
//                    }
//                    canvas.restore();
//                }
//            }
//            canvas.restore();
//            i2++;
//        }
//        Picture[] headPictures = getHeadPictures();
//        a5 = m1448a("mouth");
//        a6 = m1448a("hat");
//        canvas.save();
//        canvas.rotate(this.ak.f1079j, al.POINT_CENTER_OF_BODY.x, al.POINT_CENTER_OF_BODY.y);
//        canvas.translate(this.ak.f1094y, this.ak.f1095z);
//        canvas.rotate(this.ak.f1078i, al.mCoordinate2.x, al.mCoordinate2.y);
//        canvas.translate(this.ak.f1092w, this.ak.f1093x);
//        if (a2 != null) {
//            canvas.rotate(a2.m1760e(), al.mCoordinate2.x, al.mCoordinate2.y);
//        }
//        if (a3 != null) {
//            canvas.translate(0.0f, a3.m1760e());
//        }
//        canvas.scale(this.f863u.scaleX, this.f863u.scaleY, al.mCoordinate2.x, al.mCoordinate2.y);
//        if (this.f840R != null) {
//            canvas.save();
//            if (accessoryTypeVar.enabled) {
//                m1431a(canvas, a4, accessoryTypeVar);
//            }
//            this.f840R.draw(canvas);
//            canvas.restore();
//        }
//        if (!(this.f835M == null && this.f837O == null)) {
//            canvas.save();
//            if (accessoryTypeVar.enabled) {
//                m1431a(canvas, a4, accessoryTypeVar);
//            }
//            if (this.f835M != null) {
//                this.f835M.draw(canvas);
//            }
//            if (this.f837O != null) {
//                this.f837O.draw(canvas);
//            }
//            canvas.restore();
//        }
//        if (a6 != null) {
//            a6.draw(canvas);
//        }
//        if (this.f839Q != null) {
//            canvas.save();
//            canvas.scale(1.0f, this.f863u.scaleX / this.f863u.scaleY, al.mCoordinate2.x, al.mLocation5.y);
//            if (accessoryTypeVar.enabled) {
//                m1431a(canvas, a4, accessoryTypeVar);
//            }
//            this.f839Q.draw(canvas);
//            canvas.restore();
//        }
//        if (a5 != null) {
//            a5.draw(canvas);
//        }
//        if (headPictures[0] != null) {
//            headPictures[0].draw(canvas);
//        }
//        if (headPictures[1] != null) {
//            headPictures[1].draw(canvas);
//        }
//        canvas.restore();
//        i = 0;
//        while (i < 2) {
//            f3 = i == 0 ? this.ak.f1070a : this.ak.f1071b;
//            f = i == 0 ? this.ak.f1084o : this.ak.f1086q;
//            e = i == 0 ? this.ak.f1085p : this.ak.f1087r;
//            canvas.save();
//            canvas.rotate(this.ak.f1079j, al.POINT_CENTER_OF_BODY.x, al.POINT_CENTER_OF_BODY.y);
//            canvas.translate(this.ak.f1094y, this.ak.f1095z);
//            if (i == 1) {
//                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
//            }
//            f4 = al.mLocation2.x + (((al.mLocation6.x - al.mLocation2.x) * this.f864v.scaleX) / 2.0f);
//            float f7 = al.mLocation4.y + ((al.mLocation1.y - al.mLocation4.y) * this.f864v.scaleX);
//            canvas.translate(this.f864v.f1503d, this.f864v.f1504e);
//            canvas.rotate(f3, f4, f7);
//            canvas.translate(f, e);
//            Picture a12 = m1448a(i == 0 ? "leftshoulder" : "rightshoulder");
//            if (a12 != null) {
//                canvas.save();
//                canvas.translate((al.mLocation1.x - al.mLocation2.x) * (this.f864v.scaleX - 1.0f), 0.0f);
//                canvas.scale(this.f864v.scaleX, this.f864v.scaleX, al.mLocation1.x, al.mLocation4.y);
//                a12.draw(canvas);
//                canvas.restore();
//            }
//            canvas.restore();
//            i++;
//        }
//        canvas.restore();
//        if (this.f856n > 0.0f) {
//            e = ((float) this.aK.getWidth()) * this.aA;
//            float width = (((float) getWidth()) - (3.0f * e)) / 4.0f;
//            float f8 = width + e;
//            f3 = by.m1899a(this.f856n, 0.0f, 1.0f, ((float) (-this.aK.getHeight())) * this.aA, 0.0f, an.f1218a);
//            f = width;
//            for (int i4 = 0; i4 < 3; i4++) {
//                canvas.save();
//                canvas.translate(f, f3);
//                canvas.scale(this.aA, this.aA);
//                this.mAccessory[i4].draw(canvas);
//                canvas.restore();
//                f += f8;
//            }
//        }
//        if (obj != null) {
//            invalidate();
//        }
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        com.google.android.Util.debug("GESTURE: Fling.");
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
        com.google.android.Util.debug("GESTURE: Long press.");
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        com.google.android.Util.debug("Scaling!!");
        float scaleFactor = scaleGestureDetector.getScaleFactor();
//        if (scaleFactor > 0.0f) {
//            switch (bf.f1407b[m1436h(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY()).mPart.ordinal()]) {
//                case cm.HListView_android_divider /*1*/:
//                    m1472e(scaleFactor, scaleFactor);
//                    break;
//                case cm.HListView_hlv_dividerWidth /*2*/:
//                    m1437i(scaleFactor, scaleFactor);
//                    break;
//                case cm.HListView_hlv_headerDividersEnabled /*3*/:
//                    m1438j(scaleFactor, scaleFactor);
//                    break;
//                case cm.HListView_hlv_footerDividersEnabled /*4*/:
//                    m1439k(scaleFactor, scaleFactor);
//                    break;
//            }
//        }
        return true;
    }

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
//        com.google.android.Log.debug("GESTURE: Scroll.");
//        if (!this.bt) {
//            BodyPart h = m1436h(this.bp, this.bq);
//            this.bw = h.mPart;
//            this.bu = h.mSide == SideType.LEFT;
//            Androidify.m1364m();
//            switch (bf.f1407b[this.bw.ordinal()]) {
//                case cm.HListView_android_divider /*1*/:
//                    this.PartType.set(al.POINT_LEFT_BOTTOM_OF_HEAD.x, al.POINT_TO_REF_1.y, al.POINT_RIGHT_BOTTOM_OF_HEAD.x, al.mCoordinate2.y);
//                    Androidify.m1336a(this.f863u.scaleX, this.f863u.scaleY, motionEvent2.getX(), motionEvent2.getY());
//                    m1468c(0);
//                    break;
//                case cm.HListView_hlv_dividerWidth /*2*/:
//                    this.PartType.set(al.POINT_LEFT_OF_LEFT_SHOULDER.x, al.POINT_TOP_OF_BODY.y, al.POINT_TOP_LEFT_OF_BODY.x, al.mCoordinate3.y);
//                    Androidify.m1336a(this.f862t.scaleX, this.f862t.scaleY, motionEvent2.getX(), motionEvent2.getY());
//                    m1468c(0);
//                    break;
//                case cm.HListView_hlv_headerDividersEnabled /*3*/:
//                    this.PartType.set(al.mLocation2.x, al.mLocation4.y, al.mLocation6.x, al.mLocation3.y);
//                    Androidify.m1336a(this.f864v.scaleX, this.f864v.scaleY, motionEvent2.getX(), motionEvent2.getY());
//                    m1468c(0);
//                    break;
//                case cm.HListView_hlv_footerDividersEnabled /*4*/:
//                    this.PartType.set(al.POINT_TO_REF_28.x, al.POINT_TO_REF_28.y, al.POINT_TO_REF_30.x, al.POINT_TO_REF_34.y);
//                    Androidify.m1336a(this.f865w.scaleX, this.f865w.scaleY, motionEvent2.getX(), motionEvent2.getY());
//                    m1468c(0);
//                    break;
//            }
//            this.POINT_TO_REF_38.mapRect(this.PartType);
//            this.br = this.PartType.width();
//            this.bs = this.PartType.height();
//            this.bt = true;
//        }
//        if (!this.bu) {
//            f = -f;
//        }
//        switch (bf.f1407b[this.bw.ordinal()]) {
//            case cm.HListView_android_divider /*1*/:
//                m1472e((this.br + f) / this.br, (this.bs + f2) / this.bs);
//                Androidify.m1336a(this.f863u.scaleX, this.f863u.scaleY, motionEvent2.getX(), motionEvent2.getY());
//                break;
//            case cm.HListView_hlv_dividerWidth /*2*/:
//                m1437i((this.br + f) / this.br, (this.bs - f2) / this.bs);
//                Androidify.m1336a(this.f862t.scaleX, this.f862t.scaleY, motionEvent2.getX(), motionEvent2.getY());
//                break;
//            case cm.HListView_hlv_headerDividersEnabled /*3*/:
//                m1438j((this.br + f) / this.br, (this.bs - f2) / this.bs);
//                Androidify.m1336a(this.f864v.scaleX, this.f864v.scaleY, motionEvent2.getX(), motionEvent2.getY());
//                break;
//            case cm.HListView_hlv_footerDividersEnabled /*4*/:
//                m1439k((this.br + f) / this.br, (this.bs - f2) / this.bs);
//                Androidify.m1336a(this.f865w.scaleX, this.f865w.scaleY, motionEvent2.getX(), motionEvent2.getY());
//                break;
//        }
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
        com.google.android.Util.debug("GESTURE: Show press.");
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
//        int i = 0;
//        com.google.android.Log.debug("GESTURE: Single Tap Up.");
//        float[] fArr = new float[]{motionEvent.getX(), motionEvent.getY()};
//        if (this.ag != null) {
//            this.ag.mapPoints(fArr);
//        }
//        if (this.f856n > 0.0f && motionEvent.getY() < this.aA * ((float) this.aK.getHeight())) {
//            if (motionEvent.getX() < ((float) (getWidth() / 3))) {
//                this.mAndroidify.m1374a(PartType.HAIR);
//                i = 1;
//            } else if (motionEvent.getX() > ((float) ((getWidth() * 2) / 3))) {
//                this.mAndroidify.m1374a(PartType.BEARD);
//                i = 1;
//            } else {
//                this.mAndroidify.m1374a(PartType.GLASSES);
//                i = 1;
//            }
//        }
//        if (i == 0) {
//            if (m1435g(motionEvent.getX(), motionEvent.getY())) {
//                this.mAndroidify.m1374a(null);
//            } else if (fArr[1] < ((float) this.mTopY)) {
//                com.google.android.Log.debug("  Head touched!");
//                this.mAndroidify.m1401q();
//            } else if (fArr[1] < ((float) this.bl)) {
//                com.google.android.Log.debug("  Body touched!");
//                this.mAndroidify.m1402r();
//            } else if (fArr[1] < ((float) this.bn)) {
//                com.google.android.Log.debug("  Legs touched!");
//                this.mAndroidify.m1374a(PartType.PANTS);
//            } else {
//                com.google.android.Log.debug("  Feet touched!");
//                this.mAndroidify.m1374a(PartType.SHOES);
//            }
//        }
        return true;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        com.google.android.Util.debug("Size changed.");
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
                com.google.android.Util.debug("Done touch event group, resetting scaling flag.");
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
        AnimationCatalogue a = null;//C0204a.getAnimationCatalogue(getContext(), i);
        a.m1605a(0.0d);
        this.an = a;
        this.aq = 0.0d;
        this.ar = System.currentTimeMillis();
        this.as = 0;
    }

    public void setLoadingMode(boolean z) {
        this.f823A = z;
    }

    public void setMotion(AnimationCatalogue aAnimationCatalogue) {
        this.am = aAnimationCatalogue;
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

    public void setName(String aName) {
        mName = aName;
    }

    public String getName() {
        return mName;
    }
}
