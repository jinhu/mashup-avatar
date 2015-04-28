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
import android.view.SurfaceView;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import com.google.android.apps.androidify.p018a.AndInterpolator;
import com.google.android.apps.androidify.p018a.AnimationCatalogue;
import com.google.android.apps.androidify.p018a.AnimationContainer;
import com.google.android.apps.androidify.p018a.JsonUtil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

import dev.game.legend.avatar.R;
import dev.game.legend.svgandroid.SVG;
import dev.game.legend.svgandroid.SVGParser;

import static com.google.android.apps.androidify.Constants.POINT_LEFT_BOTTOM_OF_HEAD;
import static com.google.android.apps.androidify.Constants.POINT_LEFT_OF_LEFT_SHOULDER;
import static com.google.android.apps.androidify.Constants.POINT_RIGHT_BOTTOM_OF_HEAD;
import static com.google.android.apps.androidify.Constants.POINT_TOP_LEFT_OF_BODY;
import static com.google.android.apps.androidify.Constants.POINT_TOP_OF_BODY;
import static com.google.android.apps.androidify.Constants.POINT_TO_REF_1;
import static com.google.android.apps.androidify.Constants.POINT_TO_REF_15;
import static com.google.android.apps.androidify.Constants.POINT_TO_REF_21;
import static com.google.android.apps.androidify.Constants.POINT_TO_REF_28;
import static com.google.android.apps.androidify.Constants.POINT_TO_REF_34;
import static com.google.android.apps.androidify.Constants.POINT_TO_REF_40;
import static com.google.android.apps.androidify.Constants.f1210u;
import static com.google.android.apps.androidify.Constants.f1211v;
import static com.google.android.apps.androidify.Constants.f1212w;
import static com.google.android.apps.androidify.Constants.f1213x;

public class DroidView extends SurfaceView implements OnGestureListener, OnScaleGestureListener {
    static final Random RANDOM;
    private static final HashMap accessoryMap;
    private static int[] f821g;
    private static final float f822h;
    private boolean f823A = false;
    private int f824B;
    private int f825C;
    private int f826D;
    private Picture f827E = null;
    private Picture f828F = null;
    private Picture f829G = null;
    private Picture f830H = null;
    private Picture f831I = null;
    private Picture f832J = null;
    private Picture f833K = null;
    private Picture f834L = null;
    private Picture f835M = null;
    private Picture f836N = null;
    private Picture f837O = null;
    private Picture f838P = null;
    private Picture f839Q = null;
    private Picture f840R = null;
    private bg f841S = null;
    private bg f842T = null;
    private bg f843U = null;
    private bg f844V = null;
    private RectF mRect1;
    private RectF f846Z;
    private float aA = 1.0f;
    private float aB = 1.0f;
    private boolean aC = false;
    private boolean aD = true;
    private float aF;
    private RectF aG;
    private boolean aH = true;
    private boolean aI = false;
    private boolean aJ = false;
    private Picture mHairIcon;
    private Picture mGlassIcon;
    private Picture mBeardIcon;
    private Picture mHairIconOn;
    private Picture mGlassIconOn;
    private Picture mBeardIconOn;
    private Picture[] mAccessory;
    private ci aR = new ci();
    private Matrix aS = new Matrix();
    private RectF aT;
    private float aW;
    private float aX;
    private boolean aZ = false;
    private RectF aa;
    private float ab;
    private Path ac;
    private Matrix ad = null;
    private Matrix ae = null;
    private Matrix af = null;
    private Matrix ag = null;
    private GestureDetector ah;
    private ScaleGestureDetector ai;
    private TutorialView mTutorialView = null;
    private AnimationContainer ak;
    private AnimationContainer mAnimationContainer = new AnimationContainer();
    private AnimationCatalogue am = null;
    private AnimationCatalogue mAnimationCatalogue = null;
    private double ao = 0.0d;
    private long ap = 0;
    private double aq = 0.0d;
    private long ar = 0;
    private long as = 0;
    private HashMap at;
    private float au = -1.0f;
    private RectF mRectF;
    private Paint aw;
    private boolean ax = false;
    private int az = 1;
    protected Androidify mAndroidify;
    private long bA = 0;
    private Paint bB = new Paint();
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
    private int bk;
    private int bl;
    private int bm;
    private int bn;
    private int bo;
    private float bp;
    private float bq;
    private float br;
    private float bs;
    private boolean bt = false;
    private boolean bu;
    private boolean bv = false;
    private PartType bw;
    private Paint bx;
    private Paint by;
    private int bz = 0;
    protected boolean f848c = true;
    protected float f849d;
    Picture[] f850e = new Picture[2];
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
    private float mBottomMargin;
    private Part mBodyPart;
    private Part mHeadPart;
    private Part mAntennaPart;
    private Part mArmPart;
    private Picture mLegs;
    private Picture mFoot;
    private Path mAntennaPath;

    static {
        accessoryMap = new HashMap();
        accessoryMap.put(AccessoryType.SHOES, Integer.valueOf(R.raw.react_shoes));
        accessoryMap.put(AccessoryType.HAIR, Integer.valueOf(R.raw.react_hathair));
        accessoryMap.put(AccessoryType.SHIRT, Integer.valueOf(R.raw.react_shirt));
        accessoryMap.put(AccessoryType.PANTS, Integer.valueOf(R.raw.react_pants));
        f821g = new int[]{R.raw.idle_blinkonce, R.raw.idle_blinksimple, R.raw.idle_blinktwice, R.raw.idle_drumming, R.raw.idle_lookdown, R.raw.idle_lookleft, R.raw.idle_lookright, R.raw.idle_lookup, R.raw.idle_wave, R.raw.idle_wave};
        f822h = -26.0f * 1;//Androidify.m1331a();
        RANDOM = new Random();
    }

    private String mName;
    public long startTime = 0;
    public Handler mAnimationHandler = new Handler();
    public Runnable mAnimationTask;

    public DroidView(Context context) {
        super(context);
        this.f858p = new HashMap();
        this.mRect1 = f1212w;
        this.f846Z = f1213x;
        //this.mAnimationContainer.mCoordinate7 = f1214y;
        this.ab = POINT_TO_REF_40.y;
        this.ak = new AnimationContainer();
        this.mAccessory = new Picture[3];
        //this.aT = new RectF(mLocation5.x - f1210u, 0.0f, mLocation5.x + f1210u, 0.0f);
        this.mAnimationTask = new be(this);
    }

    public DroidView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f858p = new HashMap();
        this.mRect1 = f1212w;
        this.f846Z = f1213x;
        //this.mAnimationContainer.mCoordinate7 = f1214y;
        this.ab = POINT_TO_REF_40.y;
        this.ak = new AnimationContainer();
        this.mAccessory = new Picture[3];
        //this.aT = new RectF(mLocation5.x - f1210u, 0.0f, mLocation5.x + f1210u, 0.0f);
        this.mAnimationTask = new be(this);
    }

    public DroidView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f858p = new HashMap();
        //        this.mRect1 = f1212w;
//        this.f846Z = f1213x;
//        this.mCoordinate7 = f1214y;
//        this.POINT_TO_REF_36 = POINT_TO_REF_40.y;
        this.ak = new AnimationContainer();
        this.mAccessory = new Picture[3];
        //        this.aT = new RectF(mLocation5.x - f1210u, 0.0f, mLocation5.x + f1210u, 0.0f);
        this.mAnimationTask = new be(this);
    }

    public DroidView(Androidify androidify, Picture picture, Picture picture2, Picture picture3, Picture picture4, Picture picture5, Picture picture6) {
        super(androidify);
        this.f858p = new HashMap();
        //        this.mRect1 = f1212w;
//        this.f846Z = f1213x;
//        this.mCoordinate7 = f1214y;
//        this.POINT_TO_REF_36 = POINT_TO_REF_40.y;
        this.ak = new AnimationContainer();
        this.mRectF = new RectF();
        this.mAccessory = new Picture[3];
        this.aT = new RectF(mAnimationContainer.mLocation5.x - f1210u, 0.0f, mAnimationContainer.mLocation5.x + f1210u, 0.0f);
        this.mAnimationTask = new be(this);
        initDroid(androidify, picture, picture2, picture3, picture4, picture5, picture6);
    }

    private float m1428a(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    private int m1429a(int i, int i2, float f) {
        return ((int) (((float) (i - i2)) * f)) + i2;
    }

    private void m1431a(Canvas canvas, AndAnimation aAndAnimationVar, AccessoryType aType) {
//        switch (bf.f1406a[aType.ordinal()]) {
//            case cm.HListView_android_divider /*1*/:
//            case cm.HListView_hlv_dividerWidth /*2*/:
//            case cm.HListView_hlv_headerDividersEnabled /*3*/:
//                canvas.scale(axVar.m1761f(), axVar.m1761f(), mCoordinate2.x, mCoordinate2.y);
//            case cm.HListView_hlv_footerDividersEnabled /*4*/:
//                canvas.scale(axVar.m1761f(), axVar.m1761f(), mLocation8.x, (mCoordinate3.y + mCoordinate7.y) / 2.0f);
//            case cm.HListView_hlv_overScrollHeader /*5*/:
//                canvas.scale(axVar.m1761f(), axVar.m1761f(), mCoordinate2.x, POINT_CENTER_OF_BODY.y);
//            case cm.HListView_hlv_overScrollFooter /*6*/:
//                canvas.scale(axVar.m1761f(), axVar.m1761f(), mCoordinate2.x, mCoordinate7.y);
//            default:
//        }
    }

    private float m1434f(float f, float f2) {
        return (RANDOM.nextFloat() * (f2 - f)) + f;
    }

    private boolean m1435g(float f, float f2) {
        if (f2 > ((float) this.mTopY)) {
            return f < ((float) this.bg) || f > ((float) this.bh);
        } else {
            float[] fArr = new float[]{f, f2};
            this.f854l.mapPoints(fArr);
            if (!this.mRect1.contains(fArr[0], fArr[1])) {
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
        float f3 = this.mBodyPart.scaleY * f2;
        float a = m1428a(this.mBodyPart.scaleX * f, 0.6f, 1.2f);
        if (this.mArmPart.scaleX > a) {
            m1467c(a, this.mArmPart.scaleY);
        }
        m1451a(a, m1428a(f3, 0.6f, 1.5f));
    }

    private void m1438j(float f, float f2) {
        m1463b(m1428a(this.mAntennaPart.scaleX * f, 0.5f, 1.2f), m1428a(this.mAntennaPart.scaleY * f2, 0.6f, 1.5f));
    }

    private void m1439k(float f, float f2) {
        float f3 = this.mArmPart.scaleX * f;
        float f4 = this.mArmPart.scaleY * f2;
        if (f3 > this.mBodyPart.scaleX) {
            f3 = this.mBodyPart.scaleX;
        }
        m1467c(m1428a(f3, 0.4f, 1.1f), m1428a(f4, 0.6f, 3.0f));
    }

    private void m1440n() {
        this.as = System.currentTimeMillis() + ((long) com.google.android.Util.m1094a(2500, 7000));
    }

    //TODO: check if true
    private void addAntennaAnimation() {
        this.mAntennaPath.rewind();
        float f = (mAnimationContainer.mLocation6.x - mAnimationContainer.mLocation2.x) * this.mAntennaPart.scaleX;
        float f2 = (mAnimationContainer.mLocation3.y - mAnimationContainer.mLocation4.y) * this.mAntennaPart.scaleY;
        float f3 = f / 2.0f;
        float f4 = f3 * 0.5522848f;
        this.mAntennaPath.moveTo(mAnimationContainer.mLocation2.x, mAnimationContainer.mLocation4.y + f3);
        this.mAntennaPath.rCubicTo(0.0f, -f4, f3 - f4, -f3, f3, -f3);
        this.mAntennaPath.rCubicTo(f4, 0.0f, f3, f3 - f4, f3, f3);
        this.mAntennaPath.rLineTo(0.0f, f2 - f);
        this.mAntennaPath.rCubicTo(0.0f, f4, -(f3 - f4), f3, -f3, f3);
        float f5 = -f3;
        this.mAntennaPath.rCubicTo(-f4, 0.0f, -f3, -(f3 - f4), -f3, f5);
        this.mAntennaPath.rLineTo(0.0f, -(f2 - f));
        this.mAntennaPath.close();
    }

    private void setColor() {
//        if (this.aC) {
//            this.bx.setShader(new RadialGradient(250.0f, POINT_TOP_OF_BODY.y, POINT_TO_REF_34.y - ((float) this.mTopY), new int[]{-1, -12566464}, null, Shader.TileMode.CLAMP));
//            return;
//        }
//        this.bx.setShader(new LinearGradient(250.0f, POINT_TO_REF_1.y, 250.0f, POINT_TO_REF_34.y, new int[]{-3618616, -1}, null, Shader.TileMode.CLAMP));
    }

    private void m1443q() {
//        this.mAntennaPart.f1503d = (-(POINT_TOP_OF_BODY.x - POINT_LEFT_OF_LEFT_SHOULDER.x)) * (this.mBodyPart.scaleX - 1.0f);
//        ch chVar = this.mAntennaPart;
//        chVar.f1503d -= (mLocation6.x - mLocation2.x) * (this.mAntennaPart.scaleX - 1.0f);
    }

    private void m1444r() {
//        this.mArmPart.f1504e = (mCoordinate3.y - POINT_TOP_OF_BODY.y) * (this.mBodyPart.scaleY - 1.0f);
    }

    private void m1445s() {
        if (this.ao > this.am.m1609b()) {
            com.google.android.Util.debug("Motion done.");
            this.ak.m1619a();
            this.am = null;
            m1440n();
        } else if (this.mAnimationCatalogue == null) {
            this.ak.initAnimation(this.am, null, 1.0f, this.ao, this.au);
            invalidate();
        } else {
            this.mAnimationContainer.initAnimation(this.mAnimationCatalogue, null, 1.0f, this.aq, this.au);
            //this.ak.initAnimation(this.am, this.mAnimationContainer, by.m1901b((float) this.ao, 0.0f, 600.0f, 0.0f, 1.0f), this.ao, this.au);
            invalidate();
        }
    }

    private void m1446t() {
        if (this.aq > this.mAnimationCatalogue.m1609b()) {
            com.google.android.Util.debug("Idle motion done.");
            this.mAnimationCatalogue = null;
            if (this.am == null) {
                this.ak.m1619a();
                m1440n();
                invalidate();
            }
        } else if (this.am == null) {
            this.ak.initAnimation(this.mAnimationCatalogue, null, 1.0f, this.aq, this.au);
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

    public AnimatorThread startAnAnimation() {
        AnimatorThread animatorThreadVar = new AnimatorThread(this);
        animatorThreadVar.start();
        return animatorThreadVar;
    }

    public void m1451a(float f, float f2) {
        this.mBodyPart.scaleX = f;
        this.mBodyPart.scaleY = f2;
        m1443q();
        m1444r();
        m1462b();
    }

    public void m1452a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        this.mBodyPart.scaleX = f;
        this.mBodyPart.scaleY = f2;
        this.mHeadPart.scaleX = f3;
        this.mHeadPart.scaleY = f4;
        this.mAntennaPart.scaleX = f5;
        this.mAntennaPart.scaleY = f6;
        this.mArmPart.scaleX = f7;
        this.mArmPart.scaleY = f8;
        m1443q();
        m1444r();
        m1462b();
    }

    public void proceedTutorial(int aStep, boolean aCompletionFlag) {
        if (this.mTutorialView != null && this.mTutorialView.getStepIndex() == aStep) {
            if (!this.mTutorialView.hasMoreSteps() || !this.mTutorialView.isCurrentStepVisible() || !aCompletionFlag) {
                this.mTutorialView.setHidden(!aCompletionFlag);
            }
        }
    }

    public void m1454a(Picture picture, Picture picture2) {
        this.mArmPart.picture = picture;
        this.mLegs = picture2;
    }

    public void initNakedDroid(Picture picture, Picture picture2, Picture picture3, Picture picture4) {
        this.mHeadPart.picture = picture;
        this.mBodyPart.picture = picture2;
        this.mAntennaPart.picture = picture3;
        this.mFoot = picture4;
    }

    public void m1456a(Picture picture, RectF rectF) {
        this.f838P = picture;
        this.aG = rectF;
        postInvalidate();
    }

    public void initDroid(Androidify androidify, Picture aBody, Picture aHead, Picture anAntenna, Picture anArm, Picture aLeg, Picture aFoot) {
        this.ak.f1065R = 0.33333334f;
        this.mAndroidify = androidify;
        this.mLegs = aLeg;
        this.mFoot = aFoot;
        this.mBodyPart = new Part(aBody);
        this.mHeadPart = new Part(aHead);
        this.mAntennaPart = new Part(anAntenna);
        this.mArmPart = new Part(anArm);
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
        this.mAntennaPath = new Path();
        addAntennaAnimation();
        this.at = new HashMap();
        this.mBottomMargin = getResources().getDimension(R.dimen.droidview_bottom_margin);
        this.mHairIcon = androidify.getAssetDatabase().getSvgFromResource((int) R.raw.hair_icon).getPicture();
        this.mGlassIcon = androidify.getAssetDatabase().getSvgFromResource((int) R.raw.glasses_icon).getPicture();
        this.mBeardIcon = androidify.getAssetDatabase().getSvgFromResource((int) R.raw.beard_icon).getPicture();
        this.mHairIconOn = androidify.getAssetDatabase().getSvgFromResource((int) R.raw.hair_icon_on).getPicture();
        this.mGlassIconOn = androidify.getAssetDatabase().getSvgFromResource((int) R.raw.glasses_icon_on).getPicture();
        this.mBeardIconOn = androidify.getAssetDatabase().getSvgFromResource((int) R.raw.beard_icon_on).getPicture();
        this.mAccessory[0] = this.mHairIcon;
        this.mAccessory[1] = this.mGlassIcon;
        this.mAccessory[2] = this.mBeardIcon;
        float a = Util.performance(getContext(), 90.0f);
        this.f857o = getResources().getDimension(R.dimen.droidview_top_margin);
        this.aA = a / ((float) this.mHairIcon.getHeight());
        m1440n();
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);

    }

    public void setAccessoryType(AccessoryType aAccessoryType) {
        if (aAccessoryType == AccessoryType.HAIR) {
            this.mAccessory[0] = this.mHairIconOn;
            this.mAccessory[1] = this.mGlassIcon;
            this.mAccessory[2] = this.mBeardIcon;
        } else if (aAccessoryType == AccessoryType.GLASSES) {
            this.mAccessory[0] = this.mHairIcon;
            this.mAccessory[1] = this.mGlassIconOn;
            this.mAccessory[2] = this.mBeardIcon;
        } else if (aAccessoryType == AccessoryType.BEARD) {
            this.mAccessory[0] = this.mHairIcon;
            this.mAccessory[1] = this.mGlassIcon;
            this.mAccessory[2] = this.mBeardIconOn;
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
        switch (z ? RANDOM.nextInt(6) : RANDOM.nextInt(5) + 1) {
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
        AndAnimation axVar;
        float f2 = ((POINT_TOP_LEFT_OF_BODY.x - POINT_LEFT_OF_LEFT_SHOULDER.x) * this.mBodyPart.scaleX) + (((POINT_LEFT_OF_LEFT_SHOULDER.x - mAnimationContainer.mLocation2.x) * 2.0f) * this.mAntennaPart.scaleX);
        Util.debug("Body width now: " + f2);
        float f3 = (POINT_RIGHT_BOTTOM_OF_HEAD.x - POINT_LEFT_BOTTOM_OF_HEAD.x) * this.mHeadPart.scaleX;
        this.aW = Math.max(f2, f3);
        Util.debug(" Droid width now: " + this.aW);
        SVG svg = this.f844V == null ? null : this.f844V.f1409b;
        if (!(svg == null || svg.scale == null)) {
            f = ((POINT_TOP_LEFT_OF_BODY.x - 250.0f) * this.mBodyPart.scaleX) + ((POINT_TO_REF_21.x - POINT_TOP_LEFT_OF_BODY.x) * this.mAntennaPart.scaleX);
            this.aW = Math.max(this.aW, Math.max((f + ((Math.max(250.0f - svg.scale.left, svg.scale.left - 250.0f) - f)
                    * this.mAntennaPart.scaleX)) * 2.0f, (((Math.max(250.0f - svg.scale.right, svg.scale.right - 250.0f) - f)
                    *  this.mAntennaPart.scaleX) + f) * 2.0f));
            Util.debug(" Droid width width hand now: " + this.aW);
        }
        if (!(this.aX == 0.0f || this.aW == this.aX)) {
            AndAnimation a = defineAnimation(AnimationType.doStroke);
            axVar = new AndAnimation(AnimationType.doStroke, 300);
            axVar.interpolate(new DecelerateInterpolator(1.0f), a != null ? a.m1760e() : this.aX, this.aW);
            m1459a(axVar);
            postInvalidate();
        }
        this.aX = this.aW;
        AndAnimation a2 = defineAnimation(AnimationType.doStroke);
        f2 = Math.min(f1211v, this.mRect1.top);
        SVG SVG2 = this.f841S == null ? null : this.f841S.f1409b;
        if (!(SVG2 == null || SVG2.scale == null)) {
            f2 = Math.min(f2, SVG2.scale.top);
        }
        if (!(f2 == this.f851i || this.aI)) {
            axVar = defineAnimation(AnimationType.ADJUST_HEIGHT);
            AndAnimation axVar2 = new AndAnimation(AnimationType.ADJUST_HEIGHT, 300);
            axVar2.interpolate(new DecelerateInterpolator(1.0f), axVar != null ? axVar.m1760e() : this.f851i, f2);
            m1459a(axVar2);
            postInvalidate();
        }
        axVar = defineAnimation(AnimationType.ADJUST_HEIGHT);
        float e = axVar != null ? axVar.m1760e() : f2;
        f = a2 != null ? a2.m1760e() : this.aW;
        this.f851i = f2;
        f2 = ((mAnimationContainer.mCoordinate2.y - e) * this.mHeadPart.scaleY) + (POINT_TOP_OF_BODY.y - mAnimationContainer.mCoordinate2.y);
        e = (mAnimationContainer.mCoordinate3.y - POINT_TOP_OF_BODY.y) * this.mBodyPart.scaleY;
        this.aF = ((mAnimationContainer.mCoordinate7.y - mAnimationContainer.mCoordinate3.y) * this.mArmPart.scaleY) + ((POINT_TO_REF_34.y - mAnimationContainer.mCoordinate7.y) * this.mArmPart.scaleX);
        float f4 = ((this.mRect1.bottom - mAnimationContainer.mCoordinate2.y) * this.mHeadPart.scaleY) - e;
        if (f4 > this.aF) {
            this.aF = f4;
        }
        f4 = (f2 + e) + this.aF;
        this.f860r.set((this.f859q.left + this.f859q.right) / 2.0f, (this.f859q.top + this.f859q.bottom) / 2.0f);
        f2 = 1.15f * f;
        f = 1.15f * f4;
        int width = getWidth();
        this.au = Math.min(((float) width) / f2, ((((float) getHeight()) - this.mBottomMargin) - this.f857o) / f);
        this.f855m = ((((float) getWidth()) * 0.75f) / f3) / this.au;
        if (this.aJ) {
            f2 = this.f855m;
            this.f856n = 1.0f;
        } else {
            AndAnimation a = defineAnimation(AnimationType.ZOOM_HEAD_IN);
            axVar = a == null ? defineAnimation(AnimationType.ZOOM_HEAD_OUT) : a;
            if (axVar != null) {
                f2 = axVar.m1760e();
                if (axVar.m1757b() == AnimationType.ZOOM_HEAD_IN) {
                    this.f856n = axVar.m1758c();
                } else {
                    this.f856n = 1.0f - axVar.m1758c();
                }
            } else {
                this.f856n = 0.0f;
                f2 = 1.0f;
            }
        }
        Util.debug("Zoom progress = " + this.f856n);
        this.ad = new Matrix();
        this.ad.preTranslate(((float) (width / 2)) - this.f860r.x, (((float) (getHeight() / 2)) - this.f860r.y) + (this.f857o / 2.0f));
        this.ad.preScale(this.au, this.au, this.f860r.x, this.f860r.y);
        this.ad.preScale(f2, f2, POINT_TO_REF_1.x, (mAnimationContainer.mCoordinate2.y - POINT_TO_REF_15.y) * -2.0f);
        this.ad.preTranslate(0.0f, (POINT_TO_REF_34.y - mAnimationContainer.mCoordinate7.y) * -2.0f);
        this.ad.invert(this.ae);
        this.f853k = new Matrix();
        this.f854l = new Matrix();
        this.f853k.preTranslate(((float) (width / 2)) - this.f860r.x, ((float) (getHeight() / 2)) - this.f860r.y);
        this.f853k.preScale(this.au, this.au, this.f860r.x, this.f860r.y);
        this.f853k.preScale(f2, f2, POINT_TO_REF_15.x, (mAnimationContainer.mCoordinate2.y - POINT_TO_REF_15.y) * -2.0f);
        this.f853k.preScale(this.mHeadPart.scaleX, this.mHeadPart.scaleY, mAnimationContainer.mCoordinate2.x, mAnimationContainer.mCoordinate2.y);
        this.f853k.preTranslate(0.0f, (POINT_TO_REF_34.y - mAnimationContainer.mCoordinate7.y) * -2.0f);
        this.f853k.invert(this.f854l);
        float[] fArr = new float[]{POINT_TOP_OF_BODY.x, POINT_TOP_OF_BODY.y};
        this.ad.mapPoints(fArr);
        this.bc = (int) fArr[0];
        this.bb = (int) (((float) this.bc) - (((250.0f - POINT_LEFT_OF_LEFT_SHOULDER.x) * this.mBodyPart.scaleX) * this.au));
        this.bd = (int) (((float) this.bc) + (((250.0f - POINT_LEFT_OF_LEFT_SHOULDER.x) * this.mBodyPart.scaleX) * this.au));
        this.be = (int) (((float) this.bc) - (((250.0f - POINT_TO_REF_28.x) * this.mArmPart.scaleX) * this.au));
        this.bf = (int) (((float) this.bc) + (((250.0f - POINT_TO_REF_28.x) * this.mArmPart.scaleX) * this.au));
        float f5 = (POINT_LEFT_OF_LEFT_SHOULDER.x - mAnimationContainer.mLocation6.x) * this.au;
        f3 = ((mAnimationContainer.mLocation6.x - mAnimationContainer.mLocation2.x) * this.mAntennaPart.scaleX) * this.au;
        this.bg = (int) ((((float) this.bb) - f5) - f3);
        this.bh = (int) ((f5 + ((float) this.bd)) + f3);
        this.mTopY = (int) fArr[1];
        this.bj = (int) (((float) this.mTopY) - (f2 * (((mAnimationContainer.mCoordinate2.y - POINT_TO_REF_1.y) * this.mHeadPart.scaleY) * this.au)));
        this.bk = (int) (fArr[1] + ((((mAnimationContainer.mCoordinate3.y - POINT_TOP_OF_BODY.y) * this.mBodyPart.scaleY) * this.au) / 2.0f));
        this.bl = (int) (fArr[1] + (((mAnimationContainer.mCoordinate3.y - POINT_TOP_OF_BODY.y) * this.mBodyPart.scaleY) * this.au));
        this.bn = (int) (fArr[1] + ((((mAnimationContainer.mCoordinate3.y - POINT_TOP_OF_BODY.y) * this.mBodyPart.scaleY) + ((mAnimationContainer.mCoordinate7.y - mAnimationContainer.mCoordinate3.y) * this.mArmPart.scaleY)) * this.au));
        this.bm = (int) (fArr[1] + (((mAnimationContainer.mLocation3.y - mAnimationContainer.mLocation4.y) * this.mAntennaPart.scaleY) * this.au));
        this.mTopY = (int) (((float) this.mTopY) + f822h);
        this.bj = (int) (((float) this.bj) + f822h);
        this.bk = (int) (((float) this.bk) + f822h);
        this.bl = (int) (((float) this.bl) + f822h);
        this.bn = (int) (((float) this.bn) + f822h);
        this.bm = (int) (((float) this.bm) + f822h);
        if (this.aG == null) {
            this.f849d = ((float) this.bn) + (((POINT_TO_REF_34.y - mAnimationContainer.mCoordinate7.y) * this.mArmPart.scaleX) * this.au);
        } else {
            this.f849d = ((float) this.bn) + (((this.aG.bottom - mAnimationContainer.mCoordinate7.y) * this.mArmPart.scaleX) * this.au);
        }
        this.bo = (int) ((((float) this.bl) + this.f849d) / 2.0f);
        this.f852j = this.f849d + (((3.0f * (POINT_TO_REF_34.y - mAnimationContainer.mCoordinate7.y)) / 2.0f) * this.au);
        if (this.bt) {
            int i = width / 2;
            int height = getHeight();
            this.bb = m1429a(this.bb, i, this.aB);
            this.bc = m1429a(this.bc, i, this.aB);
            this.bd = m1429a(this.bd, i, this.aB);
            this.mTopY = m1429a((int) this.mTopY, height, this.aB);
            this.be = m1429a(this.be, height, this.aB);
            this.bm = m1429a(this.bm, height, this.aB);
            this.bl = m1429a(this.bl, height, this.aB);
            this.bn = m1429a(this.bn, height, this.aB);
            this.f849d = (float) m1429a((int) this.f849d, height, this.aB);
        }
        if (this.bt) {
            int i = this.aZ ? getHeight() / 2 : 0;
            this.bb = m1429a(this.bb, width, this.ba);
            this.bc = m1429a(this.bc, width, this.ba);
            this.bd = m1429a(this.bd, width, this.ba);
            this.mTopY = m1429a((int) this.mTopY, i, this.ba);
            this.be = m1429a(this.be, i, this.ba);
            this.bm = m1429a(this.bm, i, this.ba);
            this.bl = m1429a(this.bl, i, this.ba);
            this.bn = m1429a(this.bn, i, this.ba);
            this.f849d = (float) m1429a((int) this.f849d, i, this.ba);
        }
        setColor();
        addAntennaAnimation();
        m1473f();
        if (this.mTutorialView != null) {
            f2 = getResources().getDimension(R.dimen.tutorial_item_width);
            f = getResources().getDimension(R.dimen.tutorial_button_width);
            f5 = getResources().getDimension(R.dimen.tutorial_header_height);
            e = getResources().getDimension(R.dimen.tutorial_arrow_bottom_adjust);
            ci a3 = Util.m1906a(this, (float) this.bf, (float) this.bo, this.mTutorialView);
            this.mTutorialView.m1586a(0, a3.f1505a, a3.f1506b);
            this.mTutorialView.m1586a(1, f2 / 2.0f, ((float) getHeight()) - e);
            this.mTutorialView.m1586a(2, (3.0f * f2) / 2.0f, ((float) getHeight()) - e);
            Util.m1906a(this, (float) this.bd, (float) this.bl, this.mTutorialView);
            this.mTutorialView.m1586a(3, (f2 * 5.0f) / 2.0f, (float) (-getHeight()));
            this.mTutorialView.m1586a(4, ((float) getWidth()) - (f / 2.0f), f5);
        }
        postInvalidate();
    }

    public void m1463b(float f, float f2) {
        this.mAntennaPart.scaleX = f;
        this.mAntennaPart.scaleY = f2;
        m1443q();
        m1462b();
    }

    public void m1464b(int i) {
//        if (this.mTutorialView != null && this.mTutorialView.getStepIndex() == i) {
//            this.mTutorialView.m1590b();
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
        this.mArmPart.scaleX = f;
        this.mArmPart.scaleY = f2;
        m1444r();
        m1462b();
    }

    public void m1468c(int i) {
//        if (this.mTutorialView != null && this.mTutorialView.getStepIndex() == i && this.mTutorialView.m1591c() && this.mTutorialView.m1589a()) {
//            this.mTutorialView.setVisibility(8);
//            this.mTutorialView = null;
//        }
    }

    public void m1469d() {
        m1467c(m1434f(0.4f, 1.1f), m1434f(0.6f, 3.0f));
        m1463b(m1434f(0.5f, 1.2f), m1434f(0.6f, 1.5f));
        m1451a(m1434f(0.6f, 1.2f), m1434f(0.6f, 1.5f));
        if (this.mArmPart.scaleX > this.mBodyPart.scaleX) {
            m1467c(this.mBodyPart.scaleX, this.mArmPart.scaleY);
        }
    }

    public void m1470d(float f, float f2) {
        this.mHeadPart.scaleX = f;
        this.mHeadPart.scaleY = f2;
        m1462b();
    }

    public void m1471e() {
        this.at.clear();
    }

    public void m1472e(float f, float f2) {
        float f3;
        float f4;
        Object obj = 1;
        float f5 = f * this.mHeadPart.scaleX;
        float f6 = f2 * this.mHeadPart.scaleY;
        Object obj2 = this.mHeadPart.scaleX < f5 ? 1 : null;
        if (this.mHeadPart.scaleY >= f6) {
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
        AndAnimation axVar = new AndAnimation(AnimationType.SHRUG, 1000);
        AndInterpolator c0205b = new AndInterpolator(0.0f, 0.0f);
        c0205b.nextPoint(0.2f, 1.0f);
        c0205b.nextPoint(0.8f, 1.0f);
        c0205b.nextPoint(1.0f, 0.0f);
        axVar.interpolate(c0205b, 0.0f, mAnimationContainer.mCoordinate2.y - POINT_TOP_OF_BODY.y);
        m1459a(axVar);
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
        Bitmap bitmap = com.google.android.Util.convertToBitmap((View) this);
//        if (a) {
//            this.mAndroidify.getClickListener().next();
//        }
        return bitmap;
    }

    public float getBottomOfShadow() {
        return this.f852j;
    }

    public Part getDroidArm() {
        return this.mAntennaPart;
    }

    public Part getDroidBody() {
        return this.mBodyPart;
    }

    public Part getDroidHead() {
        return this.mHeadPart;
    }

    public Part getDroidLegs() {
        return this.mArmPart;
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
        andAnimationVar.interpolate(interpolator, 0.0f, 100.0f);//POINT_TOP_OF_BODY.y - mCoordinate2.y);
        m1459a(andAnimationVar);
    }

    public void m1476i() {
        AndAnimation andAnimationVar = new AndAnimation(AnimationType.HEAD_TILT, 1000);
        AndInterpolator c0205b = new AndInterpolator(0.0f, 0.0f);
        c0205b.nextPoint(0.2f, 1.0f);
        c0205b.nextPoint(0.8f, 1.0f);
        andAnimationVar.interpolate(c0205b, 0.0f, RANDOM.nextBoolean() ? 8.0f : -8.0f);
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
        //SurfaceHolder surfaceHolder = getHolder();
        //canvas = surfaceHolder.lockCanvas();
        AndAnimation andAnimationVar;
        float e;
        int i;
        canvas.getSaveCount();
        canvas.save();
        if (this.au == -1.0f) {
            m1462b();
        }
        if (!(defineAnimation(AnimationType.ADJUST_HEIGHT) == null && defineAnimation(AnimationType.doStroke) == null && defineAnimation(AnimationType.ZOOM_HEAD_IN) == null && defineAnimation(AnimationType.ZOOM_HEAD_OUT) == null)) {
            m1462b();
        }
        Object obj = !this.at.isEmpty() ? 1 : null;
        if (obj != null) {
            Iterator it = this.at.values().iterator();
            while (it.hasNext()) {
                andAnimationVar = (AndAnimation) it.next();
                if (andAnimationVar.step()) {
                    if (andAnimationVar.m1757b() == AnimationType.ZOOM_HEAD_IN) {
                        this.aJ = true;
                    }
                    it.remove();
                }
            }
        }
        andAnimationVar = defineAnimation(AnimationType.SHRINK_LEFT);
        AndAnimation a = defineAnimation(AnimationType.SHRINK_UP);
        if (andAnimationVar != null && a != null) {
            e = andAnimationVar.m1760e();
            canvas.scale(e, e, (float) getWidth(), (float) (getHeight() / 2));
            e = a.m1760e();
            canvas.scale(e, e, (float) getWidth(), 0.0f);
        } else if (andAnimationVar != null) {
            e = andAnimationVar.m1760e();
            canvas.scale(e, e, (float) getWidth(), (float) (getHeight() / 2));
        } else if (a != null) {
            e = a.m1760e();
            canvas.scale(e, e, (float) getWidth(), 0.0f);
        } else  {
            canvas.scale(this.ba, this.ba, (float) getWidth(), this.aZ ? (float) (getHeight() / 2) : 0.0f);
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.ao = (double) (currentTimeMillis - this.ap);
        this.aq = (double) (currentTimeMillis - this.ar);
        if (this.am == null && this.mAnimationCatalogue == null && this.as > 0 && currentTimeMillis >= this.as) {
            com.google.android.Util.debug("Starting idle animation.");
//            setIdleMotion(com.google.android.Util.m1095a(f821g));
            invalidate();
        }
        if (this.mAnimationCatalogue != null) {
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
        AndAnimation a2 = defineAnimation(AnimationType.HEAD_TILT);
        AndAnimation a3 = defineAnimation(AnimationType.NOD);
        AndAnimation a4 = defineAnimation(AnimationType.BOUNCE_ELEMENT);
        AccessoryType accessoryTypeVar = AccessoryType.NONE;
        if (a4 != null) {
            accessoryTypeVar = a4.mAccessoryType;
        }
        if (true) {
            a = defineAnimation(AnimationType.SHRINK_DOWN);
            if (a != null) {
                canvas.scale(a.m1760e(), a.m1760e(), (float) (getWidth() / 2), (float) getHeight());
            } else {
                canvas.scale(this.aB, this.aB, (float) (getWidth() / 2), (float) getHeight());
            }
        } else {
            a = defineAnimation(AnimationType.SHRINK_DOWN);
            if (a != null) {
                canvas.scale(a.m1760e(), a.m1760e(), (float) (getWidth() / 2), (float) getHeight());
            }
        }
        canvas.translate(0.0f, f822h);
        canvas.concat(this.ad);
        canvas.rotate(this.ak.f1080k, Constants.POINT_CENTER_OF_BODY.x, Constants.POINT_CENTER_OF_BODY.y);
        canvas.translate(this.ak.f1048A, this.ak.f1049B);
        canvas.scale(this.ak.f1064Q, 1.0f, Constants.POINT_CENTER_OF_BODY.x, Constants.POINT_CENTER_OF_BODY.y);
        if (this.f848c) {
            canvas.save();
            //PartType.set(-10000.0f, -10000.0f, 10000.0f, 10000.0f);
            if (this.aC) {
                canvas.translate(0.0f, (((mAnimationContainer.mCoordinate3.y - Constants.POINT_TOP_OF_BODY.y) * this.mBodyPart.scaleY)
                        + ((mAnimationContainer.mCoordinate7.y - mAnimationContainer.mCoordinate3.y) * this.mArmPart.scaleY))
                        + ((mAnimationContainer.mCoordinate6.y - mAnimationContainer.mCoordinate7.y) * this.mArmPart.scaleX));
                canvas.scale(1.0f, 0.5f, 250.0f, Constants.POINT_CENTER_OF_BODY.y);
            } else if (this.aD) {
                Paint paint = new Paint();
                paint.setColor(getResources().getColor(R.color.bg_grey));
                paint.setStyle(Paint.Style.FILL);
                //canvas.drawRect(this.PartType, paint);
            } else {
                //canvas.drawRect(this.PartType, this.bx);
            }
            canvas.restore();
        }
        if (this.aH && this.mTutorialView == null) {
            canvas.save();
            float f = this.aG != null ? (this.aG.bottom - mAnimationContainer.mCoordinate7.y) * this.mArmPart.scaleX : (POINT_TO_REF_34.y - mAnimationContainer.mCoordinate7.y) * this.mArmPart.scaleX;
            canvas.translate(this.mArmPart.f1503d, (this.aI ? f - ((POINT_TO_REF_34.y - mAnimationContainer.mCoordinate7.y) / 2.0f) : f + ((POINT_TO_REF_34.y - mAnimationContainer.mCoordinate7.y) / 2.0f)) + this.mArmPart.f1504e);
            canvas.scale(1.0f, this.mArmPart.scaleY, mAnimationContainer.mCoordinate3.x, mAnimationContainer.mCoordinate3.y);
            canvas.scale(1.0f, 1.0f / this.mArmPart.scaleY, 250.0f, mAnimationContainer.mCoordinate7.y);
            canvas.scale(((this.aI ? 1.1f : 0.75f) * this.mBodyPart.scaleX) * getAmbientShadowScale(), 1.0f, 250.0f, mAnimationContainer.mCoordinate7.y);
            this.by.setColor(-2136956768);
            //this.PartType.set(mAnimationContainer.mLocation1.x, mAnimationContainer.mCoordinate7.y, POINT_TO_REF_21.x, POINT_TO_REF_40.y);
            //canvas.drawOval(this.PartType, this.by);
            canvas.restore();
        }
        canvas.translate(0.0f, getAmbientHover());
        canvas.save();
        canvas.rotate(this.ak.f1079j, mAnimationContainer.mCoordinate1.x, mAnimationContainer.mCoordinate1.y);
        canvas.translate(this.ak.f1094y, this.ak.f1095z);
        canvas.rotate(this.ak.f1078i, mAnimationContainer.mCoordinate2.x, mAnimationContainer.mCoordinate2.y);
        canvas.translate(this.ak.f1092w, this.ak.f1093x);
        if (a2 != null) {
            canvas.rotate(a2.m1760e(), mAnimationContainer.mCoordinate2.x, mAnimationContainer.mCoordinate2.y);
        }
        if (a3 != null) {
            canvas.translate(0.0f, a3.m1760e());
        }
        canvas.scale(this.mHeadPart.scaleX, this.mHeadPart.scaleY, mAnimationContainer.mCoordinate2.x, mAnimationContainer.mCoordinate2.y);
        if (accessoryTypeVar.enabled) {
            m1431a(canvas, a4, accessoryTypeVar);
        }
        if (this.f834L != null) {
            this.f834L.draw(canvas);
        }
        if (this.f836N != null) {
            this.f836N.draw(canvas);
        }
        canvas.restore();
        int i2 = 0;
        float f;
        while (i2 < 2) {
            float f2 = i2 == 0 ? this.ak.f1072c : this.ak.f1073d;
            float f3 = i2 == 0 ? this.ak.f1088s : this.ak.f1090u;
            f = i2 == 0 ? this.ak.f1089t : this.ak.f1091v;
            canvas.save();
            if (i2 == 1) {
                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
            }
            canvas.translate(this.mArmPart.f1503d, this.mArmPart.f1504e);
            canvas.rotate(f2, 250.0f + ((mAnimationContainer.mLocation7.x - 250.0f) * this.mArmPart.scaleX), mAnimationContainer.mLocation8.y);
            canvas.translate(f3, f);
            canvas.scale(this.mArmPart.scaleX, this.mArmPart.scaleY, mAnimationContainer.mCoordinate3.x, mAnimationContainer.mCoordinate3.y);
            if (accessoryTypeVar != AccessoryType.PANTS) {
                AccessoryType accessoryTypeVar2 = AccessoryType.BEARD;
                if (accessoryTypeVar != AccessoryType.SHIRT_AND_PANTS) {
                    this.mArmPart.picture.draw(canvas);
                    canvas.restore();
                    i2++;
                }
            }
            m1431a(canvas, a4, AccessoryType.PANTS);
            this.mArmPart.picture.draw(canvas);
            canvas.restore();
            i2++;
        }
        canvas.save();
        canvas.translate(this.mArmPart.f1503d, this.mArmPart.f1504e);
        i2 = 0;
        float f2;
        float f3;
        AccessoryType bhVar2;
        while (i2 < 2) {
            f2 = i2 == 0 ? this.ak.f1072c : this.ak.f1073d;
            f3 = i2 == 0 ? this.ak.f1088s : this.ak.f1090u;
            f = i2 == 0 ? this.ak.f1089t : this.ak.f1091v;
            canvas.save();
            if (i2 == 1) {
                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
            }
            canvas.rotate(f2, 250.0f + ((mAnimationContainer.mLocation7.x - 250.0f) * this.mArmPart.scaleX), mAnimationContainer.mLocation8.y);
            canvas.translate(f3, f);
            canvas.scale(this.mArmPart.scaleX, this.mArmPart.scaleY, mAnimationContainer.mCoordinate3.x, mAnimationContainer.mCoordinate3.y);
            canvas.save();
            canvas.scale(1.0f, this.mArmPart.scaleX / this.mArmPart.scaleY, 250.0f, mAnimationContainer.mCoordinate7.y);
            if (accessoryTypeVar != AccessoryType.PANTS) {
                bhVar2 = AccessoryType.BEARD;
            }
            m1431a(canvas, a4, AccessoryType.PANTS);
            this.mLegs.draw(canvas);
            canvas.restore();
            canvas.save();
            if (accessoryTypeVar != AccessoryType.PANTS) {
                bhVar2 = AccessoryType.BEARD;
            }
            m1431a(canvas, a4, AccessoryType.PANTS);
            if (this.f831I != null) {
                this.f831I.draw(canvas);
            }
            canvas.save();
            canvas.scale(1.0f, this.mArmPart.scaleX / this.mArmPart.scaleY, i2 == 0 ? mAnimationContainer.mLocation8.x : mAnimationContainer.mLocation9.x, mAnimationContainer.mCoordinate3.y);
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
        canvas.rotate(this.ak.f1079j, mAnimationContainer.mCoordinate1.x, mAnimationContainer.mCoordinate1.y);
        canvas.translate(this.ak.f1094y, this.ak.f1095z);
        if (accessoryTypeVar != AccessoryType.SHIRT) {
            bhVar2 = AccessoryType.BEARD;
        }
        m1431a(canvas, a4, AccessoryType.SHIRT);
        canvas.save(1);
        canvas.scale(this.mBodyPart.scaleX, this.mBodyPart.scaleY, mAnimationContainer.mCoordinate4.x, mAnimationContainer.mCoordinate4.y);
        canvas.clipPath(this.ac);
        this.mBodyPart.picture.draw(canvas);
        canvas.restore();
        if (this.f827E != null) {
            f = Math.max(this.mBodyPart.scaleX, this.mBodyPart.scaleY);
            if (f < 1.2f) {
                canvas.scale(f / 1.2f, f / 1.2f, mAnimationContainer.mCoordinate4.x, mAnimationContainer.mCoordinate4.y);
            }
            this.f827E.draw(canvas);
        }
        canvas.restore();
        Picture a5 = m1448a("face");
        canvas.save();
        canvas.rotate(this.ak.f1079j, mAnimationContainer.mCoordinate1.x, mAnimationContainer.mCoordinate1.y);
        canvas.translate(this.ak.f1094y, this.ak.f1095z);
        if (a2 != null) {
            canvas.rotate(a2.m1760e(), mAnimationContainer.mCoordinate2.x, mAnimationContainer.mCoordinate2.y);
        }
        canvas.rotate(this.ak.f1078i, mAnimationContainer.mCoordinate2.x, mAnimationContainer.mCoordinate2.y);
        canvas.translate(this.ak.f1092w, this.ak.f1093x);
        if (a3 != null) {
            canvas.translate(0.0f, a3.m1760e());
        }
        canvas.scale(this.mHeadPart.scaleX, this.mHeadPart.scaleY, mAnimationContainer.mCoordinate2.x, mAnimationContainer.mCoordinate2.y);
        if (accessoryTypeVar.enabled) {
            m1431a(canvas, a4, accessoryTypeVar);
        }
        this.mHeadPart.picture.draw(canvas);
        Picture a6 = m1448a("earring");
        for (int i3 = 0; i3 < 2; i3++) {
            canvas.save();
            if (i3 == 1) {
                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
            }
            if (this.mHeadPart.scaleX > this.mHeadPart.scaleY) {
                canvas.scale(1.0f, this.mHeadPart.scaleX / this.mHeadPart.scaleY, mAnimationContainer.mCoordinate5.x, mAnimationContainer.mCoordinate5.y);
            } else {
                canvas.scale(this.mHeadPart.scaleY / this.mHeadPart.scaleX, 1.0f, mAnimationContainer.mCoordinate5.x, mAnimationContainer.mCoordinate5.y);
            }
            AndAnimation a7 = defineAnimation(AnimationType.ANTENNA_TWITCH);
            if (a7 != null) {
                canvas.rotate(a7.m1760e(), mAnimationContainer.mCoordinate5.x, mAnimationContainer.mCoordinate5.y);
            } else {
                canvas.rotate(m1447a(i3), mAnimationContainer.mCoordinate5.x, mAnimationContainer.mCoordinate5.y);
            }
            if (i3 == 0 && this.ak.f1076g != 0.0f) {
                canvas.rotate(this.ak.f1076g, mAnimationContainer.mCoordinate5.x, mAnimationContainer.mCoordinate5.y);
            } else if (i3 == 1 && this.ak.f1077h != 0.0f) {
                canvas.rotate(this.ak.f1077h, mAnimationContainer.mCoordinate5.x, mAnimationContainer.mCoordinate5.y);
            }
            this.mFoot.draw(canvas);
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
            if (this.mHeadPart.scaleX < this.mHeadPart.scaleY) {
                canvas.scale(1.0f, this.mHeadPart.scaleX / this.mHeadPart.scaleY, mAnimationContainer.mLocation5.x, mAnimationContainer.mLocation5.y);
            } else {
                canvas.scale(this.mHeadPart.scaleY / this.mHeadPart.scaleX, 1.0f, mAnimationContainer.mLocation5.x, mAnimationContainer.mLocation5.y);
            }
            if (i2 == 0 && this.ak.f1058K != 1.0f) {
                canvas.scale(this.ak.f1058K, this.ak.f1058K, mAnimationContainer.mLocation5.x, mAnimationContainer.mLocation5.y);
            } else if (i2 == 1 && this.ak.f1059L != 1.0f) {
                canvas.scale(this.ak.f1059L, this.ak.f1059L, mAnimationContainer.mLocation5.x, mAnimationContainer.mLocation5.y);
            }
            if (i2 == 0 && this.ak.f1081l != 0.0f) {
                canvas.rotate(this.ak.f1081l, mAnimationContainer.mLocation5.x, mAnimationContainer.mLocation5.y);
            } else if (i2 == 1 && this.ak.f1082m != 0.0f) {
                canvas.rotate(this.ak.f1082m, mAnimationContainer.mLocation5.x, mAnimationContainer.mLocation5.y);
            }
            f2 = i2 == 0 ? this.ak.f1052E : this.ak.f1054G;
            f3 = i2 == 0 ? this.ak.f1053F : this.ak.f1055H;
            f = i2 == 0 ? this.ak.f1060M : this.ak.f1061N;
           // this.aT.left = (mAnimationContainer.mLocation5.x - f1210u) + f2;
           // this.aT.right = f2 + (mAnimationContainer.mLocation5.x + f1210u);
            //this.aT.top = by.m1898a(f, 0.0f, 1.0f, mAnimationContainer.mLocation5.y, mAnimationContainer.mLocation0.y) + f3;
            //this.aT.bottom = by.m1898a(f, 0.0f, 1.0f, mAnimationContainer.mLocation5.y, mAnimationContainer.mCoordinate6.y) + f3;
            //canvas.clipRect(this.aT);
            canvas.drawCircle(mAnimationContainer.mLocation5.x, mAnimationContainer.mLocation5.y, mAnimationContainer.mLocation5.y - mAnimationContainer.mLocation0.y, this.aw);
            canvas.restore();
            i2++;
        }
        canvas.restore();
        canvas.restore();
        canvas.save();
        canvas.translate(this.mArmPart.f1503d, this.mArmPart.f1504e);
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
                canvas.rotate(f3, 250.0f + ((mAnimationContainer.mLocation7.x - 250.0f) * this.mArmPart.scaleX), mAnimationContainer.mLocation8.y);
                canvas.translate(f, f4);
                canvas.scale(this.mArmPart.scaleX, this.mArmPart.scaleY, mAnimationContainer.mCoordinate3.x, mAnimationContainer.mCoordinate3.y);
                canvas.scale(1.0f, this.mArmPart.scaleX / this.mArmPart.scaleY, 250.0f, mAnimationContainer.mCoordinate7.y);
                if (accessoryTypeVar == AccessoryType.SHOES) {
                    m1431a(canvas, a4, accessoryTypeVar);
                }
                if (i == 0 && this.ak.f1074e != 0.0f) {
                    canvas.rotate(this.ak.f1074e, mAnimationContainer.mCoordinate7.x, mAnimationContainer.mCoordinate7.y);
                } else if (i == 1 && this.ak.f1075f != 0.0f) {
                    canvas.rotate(this.ak.f1075f, mAnimationContainer.mCoordinate7.x, mAnimationContainer.mCoordinate7.y);
                }
                this.f838P.draw(canvas);
                canvas.restore();
                i++;
            }
        }
        canvas.restore();
        if (this.f830H != null) {
            canvas.save();
            canvas.rotate(this.ak.f1079j, mAnimationContainer.mCoordinate1.x, mAnimationContainer.mCoordinate1.y);
            canvas.translate(this.ak.f1094y, this.ak.f1095z);
            canvas.scale(this.mBodyPart.scaleX, this.mBodyPart.scaleY, mAnimationContainer.mCoordinate4.x, mAnimationContainer.mCoordinate4.y);
            if (accessoryTypeVar != AccessoryType.SHIRT) {
                bhVar2 = AccessoryType.BEARD;
            }
            m1431a(canvas, a4, AccessoryType.SHIRT);
            this.f830H.draw(canvas);
            canvas.restore();
        }
        if (this.f833K != null) {
            canvas.save();
            canvas.rotate(this.ak.f1079j, mAnimationContainer.mCoordinate1.x, mAnimationContainer.mCoordinate1.y);
            canvas.translate(this.ak.f1094y, this.ak.f1095z);
            canvas.scale(this.mBodyPart.scaleX, this.mBodyPart.scaleY, mAnimationContainer.mCoordinate4.x, mAnimationContainer.mCoordinate4.y);
            if (accessoryTypeVar != AccessoryType.PANTS) {
                bhVar2 = AccessoryType.BEARD;
            }
            m1431a(canvas, a4, AccessoryType.PANTS);
            this.f833K.draw(canvas);
            canvas.restore();
        }
        Picture a8 = m1448a("body");
        if (this.f829G != null) {
            canvas.save();
            canvas.rotate(this.ak.f1079j, mAnimationContainer.mCoordinate1.x, mAnimationContainer.mCoordinate1.y);
            canvas.translate(this.ak.f1094y, this.ak.f1095z);
            canvas.scale(this.mBodyPart.scaleX, this.mBodyPart.scaleY, mAnimationContainer.mCoordinate4.x, mAnimationContainer.mCoordinate4.y);
            if (accessoryTypeVar != AccessoryType.SHIRT) {
                AccessoryType accessoryTypeVar3 = AccessoryType.BEARD;
            }
            m1431a(canvas, a4, AccessoryType.SHIRT);
            this.f829G.draw(canvas);
            canvas.restore();
        }
        if (a8 != null) {
            canvas.save();
            canvas.rotate(this.ak.f1079j, mAnimationContainer.mCoordinate1.x, mAnimationContainer.mCoordinate1.y);
            canvas.translate(this.ak.f1094y, this.ak.f1095z);
            f3 = Math.min(this.mBodyPart.scaleX, this.mBodyPart.scaleY);
            canvas.scale(f3, f3, mAnimationContainer.mCoordinate4.x, mAnimationContainer.mCoordinate4.y);
            if (accessoryTypeVar != AccessoryType.SHIRT) {
                AccessoryType bhVar3 = AccessoryType.BEARD;
            }
            m1431a(canvas, a4, AccessoryType.SHIRT);
            a8.draw(canvas);
            canvas.restore();
        }
        float f5 = this.mAntennaPart.f1503d;
        float f6 = this.mAntennaPart.scaleX;
        Picture picture = this.f828F;
        i2 = 0;
        while (i2 < 2) {
            canvas.save();
            f2 = i2 == 0 ? this.ak.f1070a : this.ak.f1071b;
            f3 = i2 == 0 ? this.ak.f1084o : this.ak.f1086q;
            f = i2 == 0 ? this.ak.f1085p : this.ak.f1087r;
            canvas.rotate(this.ak.f1079j, mAnimationContainer.mCoordinate1.x, mAnimationContainer.mCoordinate1.y);
            canvas.translate(this.ak.f1094y, this.ak.f1095z);
            AndAnimation a9 = defineAnimation(AnimationType.SHRUG);
            if (a9 != null) {
                canvas.translate(0.0f, a9.m1760e());
            }
            if (i2 == 1) {
                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
            }
            canvas.translate(f5, this.mAntennaPart.f1504e);
            if (i2 == 0) {
                a9 = defineAnimation(AnimationType.WAVE);
                if (a9 != null) {
                    canvas.rotate(a9.m1760e(), mAnimationContainer.mLocation4.x, mAnimationContainer.mLocation4.y);
                }
            }
            canvas.rotate(f2, mAnimationContainer.mLocation2.x + (((mAnimationContainer.mLocation6.x - mAnimationContainer.mLocation2.x) * f6) / 2.0f), mAnimationContainer.mLocation4.y + ((mAnimationContainer.mLocation1.y - mAnimationContainer.mLocation4.y) * f6));
            canvas.translate(f3, f);
            //this.aw.setColor(this.f823A ? f1192c.intValue() : ai[this.f825C]);
            if (accessoryTypeVar != AccessoryType.SHIRT) {
                bhVar2 = AccessoryType.BEARD;
            }
            m1431a(canvas, a4, AccessoryType.SHIRT);
            canvas.drawPath(this.mAntennaPath, this.aw);
            a5 = m1448a(i2 == 0 ? "onlefthand" : "onrighthand");
            a6 = m1448a(i2 == 0 ? "inlefthand" : "inrighthand");
            Picture a10 = m1448a("onbothhands");
            a8 = i2 == 0 ? m1448a("arm") : null;
            Picture a11 = m1448a("sleeve");
            if (picture != null || a5 != null || a6 != null || a10 != null || a8 != null || a11 != null) {
                canvas.save();
                canvas.translate((mAnimationContainer.mLocation1.x - mAnimationContainer.mLocation2.x) * (f6 - 1.0f), 0.0f);
                canvas.scale(f6, f6, mAnimationContainer.mLocation1.x, mAnimationContainer.mLocation4.y);
                //this.PartType.set(-20000.0f, -20000.0f, 20000.0f, mAnimationContainer.mLocation1.y);
                if (a8 != null) {
                    a8.draw(canvas);
                }
                canvas.save();
                //canvas.clipRect(this.PartType);
                if (a11 != null) {
                    a11.draw(canvas);
                }
                if (picture != null) {
                    picture.draw(canvas);
                }
                canvas.restore();
                canvas.restore();
                f = 0;//(((POINT_TO_REF_24.y - mAnimationContainer.mLocation1.y) * this.mAntennaPart.scaleY) - (((mAnimationContainer.mLocation1.y - mAnimationContainer.mLocation4.y) * (f6 - this.mAntennaPart.scaleY)) * 2.0f)) / (POINT_TO_REF_24.y - mAnimationContainer.mLocation1.y);
                canvas.save();
                canvas.translate((mAnimationContainer.mLocation1.x - mAnimationContainer.mLocation2.x) * (f6 - 1.0f), 0.0f);
                canvas.scale(f6, this.mAntennaPart.scaleY, mAnimationContainer.mLocation4.x, mAnimationContainer.mLocation4.y);
//                canvas.scale(1.0f, f / this.mAntennaPart.scaleY, POINT_TO_REF_26.x, POINT_TO_REF_26.y);
//                this.PartType.set(-20000.0f, mAnimationContainer.mLocation1.y, 20000.0f, POINT_TO_REF_24.y);
//                canvas.clipRect(this.PartType);
                if (a11 != null) {
                    a11.draw(canvas);
                }
                if (picture != null) {
                    picture.draw(canvas);
                }
                canvas.restore();
                canvas.save();
                canvas.translate((mAnimationContainer.mLocation1.x - mAnimationContainer.mLocation2.x) * (f6 - 1.0f), 0.0f);
                canvas.scale(f6, this.mAntennaPart.scaleY, mAnimationContainer.mLocation1.x, mAnimationContainer.mLocation4.y);
                canvas.scale(1.0f, f6 / this.mAntennaPart.scaleY, mAnimationContainer.mLocation3.x, mAnimationContainer.mLocation3.y);
//                this.PartType.set(-20000.0f, POINT_TO_REF_24.y, 20000.0f, 20000.0f);
//                canvas.clipRect(this.PartType);
                if (a11 != null) {
                    a11.draw(canvas);
                }
                if (picture != null) {
                    picture.draw(canvas);
                }
                canvas.restore();
                if (a5 != null || a10 != null || a6 != null) {
                    canvas.save();
                    canvas.translate((mAnimationContainer.mLocation1.x - mAnimationContainer.mLocation2.x) * (f6 - 1.0f), 0.0f);
                    canvas.translate(0.0f, (mAnimationContainer.mLocation3.y - mAnimationContainer.mLocation4.y) * (this.mAntennaPart.scaleY - 1.0f));
                    canvas.scale(f6, f6, mAnimationContainer.mLocation3.x, mAnimationContainer.mLocation3.y);
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
        canvas.rotate(this.ak.f1079j, mAnimationContainer.mCoordinate1.x, mAnimationContainer.mCoordinate1.y);
        canvas.translate(this.ak.f1094y, this.ak.f1095z);
        canvas.rotate(this.ak.f1078i, mAnimationContainer.mCoordinate2.x, mAnimationContainer.mCoordinate2.y);
        canvas.translate(this.ak.f1092w, this.ak.f1093x);
        if (a2 != null) {
            canvas.rotate(a2.m1760e(), mAnimationContainer.mCoordinate2.x, mAnimationContainer.mCoordinate2.y);
        }
        if (a3 != null) {
            canvas.translate(0.0f, a3.m1760e());
        }
        canvas.scale(this.mHeadPart.scaleX, this.mHeadPart.scaleY, mAnimationContainer.mCoordinate2.x, mAnimationContainer.mCoordinate2.y);
        if (this.f840R != null) {
            canvas.save();
            if (accessoryTypeVar.enabled) {
                m1431a(canvas, a4, accessoryTypeVar);
            }
            this.f840R.draw(canvas);
            canvas.restore();
        }
        if (!(this.f835M == null && this.f837O == null)) {
            canvas.save();
            if (accessoryTypeVar.enabled) {
                m1431a(canvas, a4, accessoryTypeVar);
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
            canvas.scale(1.0f, this.mHeadPart.scaleX / this.mHeadPart.scaleY, mAnimationContainer.mCoordinate2.x, mAnimationContainer.mLocation5.y);
            if (accessoryTypeVar.enabled) {
                m1431a(canvas, a4, accessoryTypeVar);
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
            canvas.rotate(this.ak.f1079j, mAnimationContainer.mCoordinate1.x, mAnimationContainer.mCoordinate1.y);
            canvas.translate(this.ak.f1094y, this.ak.f1095z);
            if (i == 1) {
                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
            }
            float f4 = mAnimationContainer.mLocation2.x + (((mAnimationContainer.mLocation6.x - mAnimationContainer.mLocation2.x) * this.mAntennaPart.scaleX) / 2.0f);
            float f7 = mAnimationContainer.mLocation4.y + ((mAnimationContainer.mLocation1.y - mAnimationContainer.mLocation4.y) * this.mAntennaPart.scaleX);
            canvas.translate(this.mAntennaPart.f1503d, this.mAntennaPart.f1504e);
            canvas.rotate(f3, f4, f7);
            canvas.translate(f, e);
            Picture a12 = m1448a(i == 0 ? "leftshoulder" : "rightshoulder");
            if (a12 != null) {
                canvas.save();
                canvas.translate((mAnimationContainer.mLocation1.x - mAnimationContainer.mLocation2.x) * (this.mAntennaPart.scaleX - 1.0f), 0.0f);
                canvas.scale(this.mAntennaPart.scaleX, this.mAntennaPart.scaleX, mAnimationContainer.mLocation1.x, mAnimationContainer.mLocation4.y);
                a12.draw(canvas);
                canvas.restore();
            }
            canvas.restore();
            i++;
        }
//        canvas.restore();
        if (this.f856n > 0.0f) {
            e = ((float) this.mHairIcon.getWidth()) * this.aA;
            float width = (((float) getWidth()) - (3.0f * e)) / 4.0f;
            float f8 = width + e;
            f3 = 0;//by.m1899a(this.f856n, 0.0f, 1.0f, ((float) (-this.mHairIcon.getHeight())) * this.aA, 0.0f, mAnimationCatalogue.theInterpolator);
            f = width;
            for (int i4 = 0; i4 < 3; i4++) {
                canvas.save();
                canvas.translate(f, f3);
                canvas.scale(this.aA, this.aA);
                this.mAccessory[i4].draw(canvas);
                canvas.restore();
                f += f8;
            }
        }
        if (obj != null) {
            invalidate();
        }
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
        if (scaleFactor > 0.0f) {
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
        }
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
//                    this.PartType.set(POINT_LEFT_BOTTOM_OF_HEAD.x, POINT_TO_REF_1.y, POINT_RIGHT_BOTTOM_OF_HEAD.x, mAnimationContainer.mCoordinate2.y);
//                    Androidify.m1336a(this.mHeadPart.scaleX, this.mHeadPart.scaleY, motionEvent2.getX(), motionEvent2.getY());
//                    m1468c(0);
//                    break;
//                case cm.HListView_hlv_dividerWidth /*2*/:
//                    this.PartType.set(POINT_LEFT_OF_LEFT_SHOULDER.x, POINT_TOP_OF_BODY.y, POINT_TOP_LEFT_OF_BODY.x, mAnimationContainer.mCoordinate3.y);
//                    Androidify.m1336a(this.mBodyPart.scaleX, this.mBodyPart.scaleY, motionEvent2.getX(), motionEvent2.getY());
//                    m1468c(0);
//                    break;
//                case cm.HListView_hlv_headerDividersEnabled /*3*/:
//                    this.PartType.set(mAnimationContainer.mLocation2.x, mAnimationContainer.mLocation4.y, mAnimationContainer.mLocation6.x, mAnimationContainer.mLocation3.y);
//                    Androidify.m1336a(this.mAntennaPart.scaleX, this.mAntennaPart.scaleY, motionEvent2.getX(), motionEvent2.getY());
//                    m1468c(0);
//                    break;
//                case cm.HListView_hlv_footerDividersEnabled /*4*/:
//                    this.PartType.set(POINT_TO_REF_28.x, POINT_TO_REF_28.y, POINT_TO_REF_30.x, POINT_TO_REF_34.y);
//                    Androidify.m1336a(this.mArmPart.scaleX, this.mArmPart.scaleY, motionEvent2.getX(), motionEvent2.getY());
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
//                Androidify.m1336a(this.mHeadPart.scaleX, this.mHeadPart.scaleY, motionEvent2.getX(), motionEvent2.getY());
//                break;
//            case cm.HListView_hlv_dividerWidth /*2*/:
//                m1437i((this.br + f) / this.br, (this.bs - f2) / this.bs);
//                Androidify.m1336a(this.mBodyPart.scaleX, this.mBodyPart.scaleY, motionEvent2.getX(), motionEvent2.getY());
//                break;
//            case cm.HListView_hlv_headerDividersEnabled /*3*/:
//                m1438j((this.br + f) / this.br, (this.bs - f2) / this.bs);
//                Androidify.m1336a(this.mAntennaPart.scaleX, this.mAntennaPart.scaleY, motionEvent2.getX(), motionEvent2.getY());
//                break;
//            case cm.HListView_hlv_footerDividersEnabled /*4*/:
//                m1439k((this.br + f) / this.br, (this.bs - f2) / this.bs);
//                Androidify.m1336a(this.mArmPart.scaleX, this.mArmPart.scaleY, motionEvent2.getX(), motionEvent2.getY());
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
//        if (this.f856n > 0.0f && motionEvent.getY() < this.aA * ((float) this.mHairIcon.getHeight())) {
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
        this.startTime = System.currentTimeMillis();
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

    public void setBeardIconOn(Picture picture) {
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

    public void setHairIconOn(Picture picture) {
        this.f834L = picture;
        postInvalidate();
    }

    public void setHairBackExtra(Picture picture) {
        this.f836N = picture;
        postInvalidate();
    }

    public void setHairBounds(RectF rectF) {
        this.mRect1 = rectF;
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
        AnimationCatalogue animationCatalogue = JsonUtil.getAnimationCatalogue(getContext(), i);
        animationCatalogue.m1605a(0.0d);
        this.mAnimationCatalogue = animationCatalogue;
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
        this.mTutorialView = tutorialView;
    }

    public void setName(String aName) {
        mName = aName;
    }

    public String getName() {
        return mName;
    }
}
