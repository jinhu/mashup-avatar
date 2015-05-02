package com.google.android.apps.androidify;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.animation.LinearInterpolator;

import com.google.android.apps.androidify.p018a.AndInterpolator;
import com.google.android.apps.androidify.p018a.Animation;
import com.google.android.apps.androidify.p018a.AnimationCatalogue;
import com.google.android.apps.androidify.p018a.AnimationContainer;
import com.google.android.apps.androidify.p018a.C0215l;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

import dev.game.legend.avatar.R;
import dev.game.legend.svgandroid.SVG;
import dev.game.legend.svgandroid.SVGParser;

import static com.google.android.apps.androidify.Constants.*;
import static dev.game.legend.androidify.wallpaper.Constants.HAIR_COLOR_DEFAULT;

public class AndroidDrawer {
    static final Random RAANDOM = new Random();
    private com.google.android.apps.androidify.p018a.Part f1338A;
    private AntennaAnimation antennaAnimation;
    private Matrix transform = null;
    private Matrix reverseTransform;
    private RectF droidBounds;
    private float topOfHead;
    private PointF droidCenter;
    private Part mDroidBody;
    private Part mDroidHead;
    private Part mArm;
    private Part mLeg;
    private Picture mFoot;
    private Picture mAntenna;
    private Path armPath;
    private float f1352O;
    private float f1353P;
    private float f1354Q;
    private float droidWidth;
    private RectF hairBounds;
    private RectF workRect;
    private Paint workPaint;
    private int skinColor;
    private int f1360W;
    private int backgroundRed;
    private int backgroundGreen;
    private int backgroundBlue;
    private StructOfFloats zoom;
    private float ab;
    private AnimationContainer ac;
    private AnimationContainer ad;
    private int ae;
    private DroidCoordinate af;
    private Matrix ag;
    private RectF mRectF;
    private Context context;
    private float[] aj;
    Picture[] f1364b;
    private float f1365c;
    private float f1366d;
    private float scaleFactor = 1.0f;
    private float f1368f = 1.0f;
    public HashMap<String,AndAnimation> animations;
    private Picture shirtBody = null;
    private Picture shirtArm = null;
    private Picture shirtTop = null;
    private Picture shirtBottom = null;
    private Picture pantsLeg;
    private Picture pantsTop = null;
    private Picture shoes = null;
    private Picture glasses = null;
    private Picture beard = null;
    private Picture hairBack = null;
    private Picture f1379q = null;
    private Picture hairFront = null;
    private Picture f1381s = null;
    private Picture f1382t = null;
    private Picture f1383u = null;
    private SvgToStringBinder accessories = null;
    private SvgToStringBinder f1385w = null;
    private SvgToStringBinder f1386x = null;
    private SvgToStringBinder f1387y = null;
    private Path bodyClip;

    public AndroidDrawer(Context context) {
        this.reverseTransform = null;
        this.hairBounds = f1212w;
        this.workRect = new RectF();
        this.backgroundRed = 255;
        this.backgroundGreen = 255;
        this.backgroundBlue = 255;
        this.zoom = null;
        this.ac = new AnimationContainer();
        this.ad = new AnimationContainer();
        this.ae = 255;
        this.af = new DroidCoordinate();
        this.ag = new Matrix();
        this.mRectF = new RectF(POINT_TO_REF_7.x - f1210u, 0.0f, POINT_TO_REF_7.x + f1210u, 0.0f);
        this.aj = new float[2];
        this.f1364b = new Picture[2];
        this.context = context;
        AssetDatabase a = AssetDatabase.instance(context);
        Picture body = a.getSvgFromResource(R.raw.android_body).getPicture();
        Picture head = a.getSvgFromResource(R.raw.android_head).getPicture();
        Picture anntenna = a.getSvgFromResource(R.raw.android_antenna).getPicture();
        Picture arm = a.getSvgFromResource(R.raw.android_arm).getPicture();
        Picture leg = a.getSvgFromResource(R.raw.android_leg).getPicture();
        this.mFoot = a.getSvgFromResource(R.raw.android_foot).getPicture();
        this.mAntenna = anntenna;
        this.mDroidBody = new Part(body);
        this.mDroidHead = new Part(head);
        this.mArm = new Part(arm);
        this.mLeg = new Part(leg);
        this.droidBounds = new RectF();
        this.droidCenter = new PointF();
        this.bodyClip = SVGParser.parsePath("M140.396,175.489v177.916c0,10.566,8.566,19.133,19.135,19.133h2.303h20.331h48.709h37.371h48.708h11.881h10.752c10.569,0,19.137-8.562,19.137-19.133V175.489H140.396z");
        this.reverseTransform = new Matrix();
        this.workPaint = new Paint();
        this.workPaint.setAntiAlias(true);
        this.armPath = new Path();
        createArmPath();
        this.animations = new HashMap();
        this.antennaAnimation = new AntennaAnimation();
    }

    private static Picture getPicture(SVG aSVG) {
        return aSVG == null ? null : aSVG.getPicture();
    }

    private void m1826a(float f, int i, long j) {
        m1850b(AnimationType.DRIFT);
        this.ab = (float) ((((double) i) * 3.141592653589793d) / 180.0d);
        AndAnimation andAnimationVar = new AndAnimation(AnimationType.DRIFT, j);
        andAnimationVar.interpolate(new LinearInterpolator(), 0.0f, f);
        m1843a(andAnimationVar);
    }

    private void computeArmOffset() {
        this.mArm.f1503d = (-(POINT_TOP_OF_BODY.x - POINT_LEFT_OF_LEFT_SHOULDER.x)) * (this.mDroidBody.scaleX - 1.0f);
        Part partVar = this.mArm;
        partVar.f1503d -= (POINT_TO_REF_20.x - POINT_TO_REF_19.x) * (this.mArm.scaleX - 1.0f);
    }

    private void computeLegsOffset() {
        this.mLeg.f1504e = ((POINT_TO_REF_13.y - POINT_TOP_OF_BODY.y) * (this.mDroidBody.scaleY - 1.0f)) - 10.0f;
    }

    private void createArmPath() {
        this.armPath.rewind();
        float f = (POINT_TO_REF_20.x - POINT_TO_REF_19.x) * this.mArm.scaleX;
        float f2 = (POINT_TO_REF_16.y - POINT_TO_REF_14.y) * this.mArm.scaleY;
        float f3 = f / 2.0f;
        float f4 = f3 * 0.5522848f;
        this.armPath.moveTo(POINT_TO_REF_19.x, POINT_TO_REF_14.y + f3);
        this.armPath.rCubicTo(0.0f, -f4, f3 - f4, -f3, f3, -f3);
        this.armPath.rCubicTo(f4, 0.0f, f3, f3 - f4, f3, f3);
        this.armPath.rLineTo(0.0f, f2 - f);
        this.armPath.rCubicTo(0.0f, f4, -(f3 - f4), f3, -f3, f3);
        float f5 = -f3;
        this.armPath.rCubicTo(-f4, 0.0f, -f3, -(f3 - f4), -f3, f5);
        this.armPath.rLineTo(0.0f, -(f2 - f));
        this.armPath.close();
    }

    public float getWidth() {
        return this.f1352O;
    }

    public Picture m1831a(String str) {
        return (this.accessories == null || !this.accessories.name.equals(str) || this.accessories.mSVG == null) ? (this.f1385w == null || !this.f1385w.name.equals(str) || this.f1385w.mSVG == null) ? (this.f1386x == null || !this.f1386x.name.equals(str) || this.f1386x.mSVG == null) ? (this.f1387y == null || !this.f1387y.name.equals(str) || this.f1387y.mSVG == null) ? null : this.f1387y.mSVG.getPicture() : this.f1386x.mSVG.getPicture() : this.f1385w.mSVG.getPicture() : this.accessories.mSVG.getPicture();
    }

    public AndAnimation m1832a(AnimationType aAnimationTypeVar) {
        return this.animations.get(aAnimationTypeVar.toString());
    }

    public void m1833a(float f) {
        this.f1354Q = f;
    }

    public void m1834a(int i) {
        this.ae = i;
    }

    public void m1835a(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.f1352O = (float) i;
            this.f1353P = (float) i2;
            rescale();
        }
    }

    public void setBackgroundColor(int aRedValue, int aGreenValue, int aBlueValue) {
        this.backgroundRed = aRedValue;
        this.backgroundGreen = aGreenValue;
        this.backgroundBlue = aBlueValue;
    }

    public void m1837a(Canvas canvas) {
        m1838a(canvas, this.f1352O, this.f1353P);
    }

    public void m1838a(Canvas canvas, float f, float f2) {
        canvas.drawARGB(this.ae, this.backgroundRed, this.backgroundGreen, this.backgroundBlue);
        canvas.getSaveCount();
        canvas.save();
        if (this.scaleFactor <= 0.0f) {
            m1835a((int) f, (int) f2);
        }
        if ((!this.animations.isEmpty() ? 1 : null) != null) {
            Iterator it = this.animations.values().iterator();
            while (it.hasNext()) {
                if (((AndAnimation) it.next()).step()) {
                    it.remove();
                }
            }
        }
        AndAnimation a = m1832a(AnimationType.HEAD_TILT);
        AndAnimation a2 = m1832a(AnimationType.NOD);
        AndAnimation a3 = m1832a(AnimationType.DRIFT);
        if (a3 != null) {
            canvas.translate((float) (Math.cos((double) this.ab) * ((double) a3.m1760e())), (float) (Math.sin((double) this.ab) * ((double) a3.m1760e())));
        }
        canvas.concat(this.transform);
        com.google.android.apps.androidify.p018a.Part part = null;
        if (this.f1338A != null && this.f1338A.f1098b == C0215l.MASTER) {
            part = this.f1338A;
        }
        if (part != null) {
            SVG a4 = part.getSvg(this.context, 0);
            canvas.save();
            canvas.translate(this.ac.f1056I + POINT_CENTER_OF_BODY.x, this.ac.f1057J + POINT_CENTER_OF_BODY.y);
            //canvas.scale(this.mLocation7.f1063P, this.mLocation7.f1062O, a4.scale.centerX(), a4.scale.centerY());
            canvas.drawPicture(a4.getPicture());
            canvas.restore();
        }
        canvas.rotate(this.ac.f1080k, POINT_CENTER_OF_BODY.x, POINT_CENTER_OF_BODY.y);
        canvas.translate(this.ac.f1048A, (((this.ac.f1049B * 0.29615164f) * this.mDroidBody.scaleY) + ((this.ac.f1049B * 0.70384836f) * this.mLeg.scaleY)) * 0.3f);
        canvas.scale(this.ac.f1064Q, 1.0f, POINT_CENTER_OF_BODY.x, POINT_CENTER_OF_BODY.y);
        part = null;
        if (this.f1338A != null && this.f1338A.f1098b == C0215l.BALL) {
            part = this.f1338A;
        }
        canvas.save();
        canvas.rotate(this.ac.f1079j, POINT_CENTER_OF_BODY.x, POINT_CENTER_OF_BODY.y);
        canvas.translate(this.ac.f1094y, this.ac.f1095z);
        canvas.rotate(this.ac.f1078i, POINT_TO_REF_2.x, POINT_TO_REF_2.y);
        canvas.translate(this.ac.f1092w, this.ac.f1093x);
        if (a != null) {
            canvas.rotate(a.m1760e(), POINT_TO_REF_2.x, POINT_TO_REF_2.y);
        }
        if (a2 != null) {
            canvas.translate(0.0f, a2.m1760e());
        }
        canvas.scale(this.mDroidHead.scaleX, this.mDroidHead.scaleY, POINT_TO_REF_2.x, POINT_TO_REF_2.y);
        if (this.beard != null) {
            this.beard.draw(canvas);
        }
        if (this.f1379q != null) {
            this.f1379q.draw(canvas);
        }
        canvas.restore();
        int i = 0;
        float f3 = i == 0 ? this.ac.f1072c : this.ac.f1073d;
        float f4 = i == 0 ? this.ac.f1088s : this.ac.f1090u;
        float f5 = i == 0 ? this.ac.f1089t : this.ac.f1091v;
        while (i < 2) {
            canvas.save();
            if (i == 1) {
                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
            }
            canvas.translate(this.mLeg.f1503d, this.mLeg.f1504e);
            canvas.rotate(f3, 250.0f + ((Constants.POINT_TO_REF_37.x - 250.0f) * this.mLeg.scaleX), POINT_TO_REF_32.y);
            canvas.translate(f4, f5);
            canvas.scale(this.mLeg.scaleX, this.mLeg.scaleY, POINT_TO_REF_13.x, POINT_TO_REF_13.y);
            this.mLeg.picture.draw(canvas);
            canvas.restore();
            i++;
        }
        canvas.save();
        canvas.translate(this.mLeg.f1503d, this.mLeg.f1504e);
        i = 0;
        while (i < 2) {
            f3 = i == 0 ? this.ac.f1072c : this.ac.f1073d;
            f4 = i == 0 ? this.ac.f1088s : this.ac.f1090u;
            f5 = i == 0 ? this.ac.f1089t : this.ac.f1091v;
            canvas.save();
            if (i == 1) {
                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
            }
            canvas.rotate(f3, 250.0f + ((Constants.POINT_TO_REF_37.x - 250.0f) * this.mLeg.scaleX), POINT_TO_REF_32.y);
            canvas.translate(f4, f5);
            canvas.scale(this.mLeg.scaleX, this.mLeg.scaleY, POINT_TO_REF_13.x, POINT_TO_REF_13.y);
            canvas.save();
            canvas.scale(1.0f, this.mLeg.scaleX / this.mLeg.scaleY, 250.0f, POINT_TO_REF_35.y);
            this.mFoot.draw(canvas);
            canvas.restore();
            if (this.pantsTop != null) {
                this.pantsTop.draw(canvas);
            }
            canvas.save();
            canvas.scale(1.0f, this.mLeg.scaleX / this.mLeg.scaleY, i == 0 ? POINT_TO_REF_32.x : POINT_TO_REF_33.x, POINT_TO_REF_13.y);
            if (this.glasses != null) {
                this.glasses.draw(canvas);
            }
            canvas.restore();
            canvas.restore();
            i++;
        }
        canvas.restore();
        canvas.save();
        canvas.rotate(this.ac.f1079j, POINT_CENTER_OF_BODY.x, POINT_CENTER_OF_BODY.y);
        canvas.translate(this.ac.f1094y, this.ac.f1095z);
        canvas.save(1);
        canvas.scale(this.mDroidBody.scaleX, this.mDroidBody.scaleY, POINT_TOP_OF_BODY.x, POINT_TOP_OF_BODY.y);
        canvas.clipPath(this.bodyClip);
        this.mDroidBody.picture.draw(canvas);
        canvas.restore();
        if (this.shirtBody != null) {
            f5 = Math.max(this.mDroidBody.scaleX, this.mDroidBody.scaleY);
            if (f5 < 1.2f) {
                canvas.scale(f5 / 1.2f, f5 / 1.2f, POINT_TOP_OF_BODY.x, POINT_TOP_OF_BODY.y);
            }
            this.shirtBody.draw(canvas);
        }
        canvas.restore();
        canvas.save();
        canvas.translate(this.mLeg.f1503d, this.mLeg.f1504e);
        if (this.f1381s != null) {
            i = 0;
            while (i < 2) {
                canvas.save();
                f3 = i == 0 ? this.ac.f1072c : this.ac.f1073d;
                f4 = i == 0 ? this.ac.f1088s : this.ac.f1090u;
                f5 = i == 0 ? this.ac.f1089t : this.ac.f1091v;
                if (i == 1) {
                    canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
                }
                canvas.rotate(f3, 250.0f + ((Constants.POINT_TO_REF_37.x - 250.0f) * this.mLeg.scaleX), POINT_TO_REF_32.y);
                canvas.translate(f4, f5);
                canvas.scale(this.mLeg.scaleX, this.mLeg.scaleY, POINT_TO_REF_13.x, POINT_TO_REF_13.y);
                canvas.scale(1.0f, this.mLeg.scaleX / this.mLeg.scaleY, 250.0f, POINT_TO_REF_35.y);
                if (i == 0 && this.ac.f1074e != 0.0f) {
                    canvas.rotate(this.ac.f1074e, POINT_TO_REF_35.x, POINT_TO_REF_35.y);
                } else if (i == 1 && this.ac.f1075f != 0.0f) {
                    canvas.rotate(this.ac.f1075f, POINT_TO_REF_35.x, POINT_TO_REF_35.y);
                }
                this.f1381s.draw(canvas);
                canvas.restore();
                i++;
            }
        }
        canvas.restore();
        if (this.shirtBottom != null) {
            canvas.save();
            canvas.rotate(this.ac.f1079j, POINT_CENTER_OF_BODY.x, POINT_CENTER_OF_BODY.y);
            canvas.translate(this.ac.f1094y, this.ac.f1095z);
            canvas.scale(this.mDroidBody.scaleX, this.mDroidBody.scaleY, POINT_TOP_OF_BODY.x, POINT_TOP_OF_BODY.y);
            this.shirtBottom.draw(canvas);
            canvas.restore();
        }
        if (this.shoes != null) {
            canvas.save();
            canvas.rotate(this.ac.f1079j, POINT_CENTER_OF_BODY.x, POINT_CENTER_OF_BODY.y);
            canvas.translate(this.ac.f1094y, this.ac.f1095z);
            canvas.scale(this.mDroidBody.scaleX, this.mDroidBody.scaleY, POINT_TOP_OF_BODY.x, POINT_TOP_OF_BODY.y);
            this.shoes.draw(canvas);
            canvas.restore();
        }
        Picture a5 = m1831a("body");
        if (this.shirtTop != null) {
            canvas.save();
            canvas.rotate(this.ac.f1079j, POINT_CENTER_OF_BODY.x, POINT_CENTER_OF_BODY.y);
            canvas.translate(this.ac.f1094y, this.ac.f1095z);
            canvas.scale(this.mDroidBody.scaleX, this.mDroidBody.scaleY, POINT_TOP_OF_BODY.x, POINT_TOP_OF_BODY.y);
            if (this.shirtTop != null) {
                this.shirtTop.draw(canvas);
            }
            canvas.restore();
        }
        if (a5 != null) {
            canvas.save();
            canvas.rotate(this.ac.f1079j, POINT_CENTER_OF_BODY.x, POINT_CENTER_OF_BODY.y);
            canvas.translate(this.ac.f1094y, this.ac.f1095z);
            f4 = Math.min(this.mDroidBody.scaleX, this.mDroidBody.scaleY);
            canvas.scale(f4, f4, POINT_TOP_OF_BODY.x, POINT_TOP_OF_BODY.y);
            if (a5 != null) {
                a5.draw(canvas);
            }
            canvas.restore();
        }
        Picture a6 = m1831a("face");
        canvas.save();
        canvas.rotate(this.ac.f1079j, POINT_CENTER_OF_BODY.x, POINT_CENTER_OF_BODY.y);
        canvas.translate(this.ac.f1094y, this.ac.f1095z);
        if (a != null) {
            canvas.rotate(a.m1760e(), POINT_TO_REF_2.x, POINT_TO_REF_2.y);
        }
        canvas.rotate(this.ac.f1078i, POINT_TO_REF_2.x, POINT_TO_REF_2.y);
        canvas.translate(this.ac.f1092w, this.ac.f1093x);
        if (a2 != null) {
            canvas.translate(0.0f, a2.m1760e());
        }
        canvas.scale(this.mDroidHead.scaleX, this.mDroidHead.scaleY, POINT_TO_REF_2.x, POINT_TO_REF_2.y);
        this.mDroidHead.picture.draw(canvas);
        Picture a7 = m1831a("earring");
        for (int i2 = 0; i2 < 2; i2++) {
            canvas.save();
            if (i2 == 1) {
                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
            }
            if (this.mDroidHead.scaleX > this.mDroidHead.scaleY) {
                canvas.scale(1.0f, this.mDroidHead.scaleX / this.mDroidHead.scaleY, POINT_TO_REF_9.x, POINT_TO_REF_9.y);
            } else {
                canvas.scale(this.mDroidHead.scaleY / this.mDroidHead.scaleX, 1.0f, POINT_TO_REF_9.x, POINT_TO_REF_9.y);
            }
            AndAnimation a8 = m1832a(AnimationType.ANTENNA_TWITCH);
            if (a8 != null) {
                canvas.rotate(a8.m1760e(), POINT_TO_REF_9.x, POINT_TO_REF_9.y);
            } else {
                canvas.rotate(getAmbientAntennaAngle(i2), POINT_TO_REF_9.x, POINT_TO_REF_9.y);
            }
            if (i2 == 0 && this.ac.f1076g != 0.0f) {
                canvas.rotate(this.ac.f1076g, POINT_TO_REF_9.x, POINT_TO_REF_9.y);
            } else if (i2 == 1 && this.ac.f1077h != 0.0f) {
                canvas.rotate(this.ac.f1077h, POINT_TO_REF_9.x, POINT_TO_REF_9.y);
            }
            this.mAntenna.draw(canvas);
            if (a7 != null) {
                a7.draw(canvas);
            }
            canvas.restore();
        }
        if (a6 != null) {
            a6.draw(canvas);
        }
        canvas.save();
        canvas.translate(this.ac.f1050C, this.ac.f1051D);
        this.workPaint.setColor(-1);
        i = 0;
        while (i < 2) {
            canvas.save();
            if (i == 1) {
                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
            }
            if (this.mDroidHead.scaleX < this.mDroidHead.scaleY) {
                canvas.scale(1.0f, this.mDroidHead.scaleX / this.mDroidHead.scaleY, POINT_TO_REF_7.x, POINT_TO_REF_7.y);
            } else {
                canvas.scale(this.mDroidHead.scaleY / this.mDroidHead.scaleX, 1.0f, POINT_TO_REF_7.x, POINT_TO_REF_7.y);
            }
            if (i == 0 && this.ac.f1058K != 1.0f) {
                canvas.scale(this.ac.f1058K, this.ac.f1058K, POINT_TO_REF_7.x, POINT_TO_REF_7.y);
            } else if (i == 1 && this.ac.f1059L != 1.0f) {
                canvas.scale(this.ac.f1059L, this.ac.f1059L, POINT_TO_REF_7.x, POINT_TO_REF_7.y);
            }
            if (i == 0 && this.ac.f1081l != 0.0f) {
                canvas.rotate(this.ac.f1081l, POINT_TO_REF_7.x, POINT_TO_REF_7.y);
            } else if (i == 1 && this.ac.f1082m != 0.0f) {
                canvas.rotate(this.ac.f1082m, POINT_TO_REF_7.x, POINT_TO_REF_7.y);
            }
            f3 = i == 0 ? this.ac.f1052E : this.ac.f1054G;
            f4 = i == 0 ? this.ac.f1053F : this.ac.f1055H;
            f5 = i == 0 ? this.ac.f1060M : this.ac.f1061N;
            this.mRectF.left = (POINT_TO_REF_7.x - f1210u) + f3;
            this.mRectF.right = f3 + (POINT_TO_REF_7.x + f1210u);
            this.mRectF.top = SmoothRandomGenerator.m1898a(f5, 0.0f, 1.0f, POINT_TO_REF_7.y, POINT_TO_REF_3.y) + f4;
            this.mRectF.bottom = SmoothRandomGenerator.m1898a(f5, 0.0f, 1.0f, POINT_TO_REF_7.y, POINT_TO_REF_5.y) + f4;
            canvas.clipRect(this.mRectF);
            canvas.drawCircle(POINT_TO_REF_7.x, POINT_TO_REF_7.y, POINT_TO_REF_7.y - POINT_TO_REF_3.y, this.workPaint);
            canvas.restore();
            i++;
        }
        canvas.restore();
        canvas.restore();
        if (!this.ac.f1067T) {
            m1840a(canvas, a, a2);
        }
        if (part != null) {
            SVG a9 = part.getSvg(this.context, 0);
            canvas.save();
            canvas.translate(this.ac.f1056I + POINT_CENTER_OF_BODY.x, SmoothRandomGenerator.m1898a(this.ac.f1057J, this.ac.f1068U.m1610b(Animation.PROP_POSITION_Y), this.ac.f1068U.m1603a(Animation.PROP_POSITION_Y), this.f1366d - 25.0f, this.f1365c - 80.0f) + part.f1103g);
            //canvas.scale(this.mLocation7.f1063P, this.mLocation7.f1062O, a9.scale.centerX(), a9.scale.centerY());
            canvas.drawPicture(a9.getPicture());
            canvas.restore();
        }
        float f6 = this.mArm.f1503d;
        float f7 = this.mArm.scaleX;
        Picture picture = this.shirtArm;
        int i3 = 0;
        while (i3 < 2) {
            com.google.android.apps.androidify.p018a.Part part2 = null;
            if (this.f1338A != null && (this.f1338A.f1098b == C0215l.LEFT_ARM || this.f1338A.f1098b == C0215l.RIGHT_ARM_UNDER)) {
                part2 = this.f1338A;
            }
            canvas.save();
            float f8 = i3 == 0 ? this.ac.f1070a : this.ac.f1071b;
            f3 = i3 == 0 ? this.ac.f1084o : this.ac.f1086q;
            f4 = i3 == 0 ? this.ac.f1085p : this.ac.f1087r;
            canvas.rotate(this.ac.f1079j, POINT_CENTER_OF_BODY.x, POINT_CENTER_OF_BODY.y);
            canvas.translate(this.ac.f1094y, this.ac.f1095z);
            AndAnimation a8 = m1832a(AnimationType.SHRUG);
            if (a8 != null) {
                canvas.translate(0.0f, a8.m1760e());
            }
            if (i3 == 1) {
                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
            }
            canvas.translate(f6, this.mArm.f1504e);
            if (i3 == 0) {
                a8 = m1832a(AnimationType.WAVE);
                if (a8 != null) {
                    canvas.rotate(a8.m1760e(), POINT_TO_REF_14.x, POINT_TO_REF_14.y);
                }
            }
            canvas.rotate(f8, POINT_TO_REF_19.x + (((POINT_TO_REF_20.x - POINT_TO_REF_19.x) * f7) / 2.0f), POINT_TO_REF_14.y + ((POINT_TO_REF_18.y - POINT_TO_REF_14.y) * f7));
            canvas.translate(f3, f4);
            if (part2 != null && part2.f1098b == C0215l.RIGHT_ARM_UNDER && i3 == 1) {
                m1839a(canvas, f7, part2, -2.0f * f8);
            }
            if (this.ac.f1067T) {
                this.workPaint.setColor(this.skinColor);
            } else {
                this.workPaint.setColor(this.f1360W);
            }
            canvas.drawPath(this.armPath, this.workPaint);
            Picture a10 = m1831a(i3 == 0 ? "onlefthand" : "onrighthand");
            a6 = m1831a(i3 == 0 ? "inlefthand" : "inrighthand");
            if (!(part == null && part2 == null)) {
                a6 = null;
            }
            Picture a11 = part != null ? null : m1831a("onbothhands");
            a7 = i3 == 0 ? m1831a("arm") : null;
            Picture a12 = m1831a("sleeve");
            if (picture != null || a10 != null || a6 != null || a11 != null || part2 != null || a7 != null || a12 != null) {
                canvas.save();
                canvas.translate((POINT_TO_REF_18.x - POINT_TO_REF_19.x) * (f7 - 1.0f), 0.0f);
                canvas.scale(f7, f7, POINT_TO_REF_18.x, POINT_TO_REF_14.y);
                this.workRect.set(-20000.0f, -20000.0f, 20000.0f, POINT_TO_REF_18.y);
                if (a7 != null) {
                    a7.draw(canvas);
                }
                canvas.save();
                canvas.clipRect(this.workRect);
                if (a12 != null) {
                    a12.draw(canvas);
                }
                if (picture != null) {
                    picture.draw(canvas);
                }
                canvas.restore();
                canvas.restore();
                f3 = (((POINT_TO_REF_24.y - POINT_TO_REF_18.y) * this.mArm.scaleY) - (((POINT_TO_REF_18.y - POINT_TO_REF_14.y) * (f7 - this.mArm.scaleY)) * 2.0f)) / (POINT_TO_REF_24.y - POINT_TO_REF_18.y);
                canvas.save();
                canvas.translate((POINT_TO_REF_18.x - POINT_TO_REF_19.x) * (f7 - 1.0f), 0.0f);
                canvas.scale(f7, this.mArm.scaleY, POINT_TO_REF_14.x, POINT_TO_REF_14.y);
                canvas.scale(1.0f, f3 / this.mArm.scaleY, POINT_TO_REF_26.x, POINT_TO_REF_26.y);
                this.workRect.set(-20000.0f, POINT_TO_REF_18.y, 20000.0f, POINT_TO_REF_24.y);
                canvas.clipRect(this.workRect);
                if (a12 != null) {
                    a12.draw(canvas);
                }
                if (picture != null) {
                    picture.draw(canvas);
                }
                canvas.restore();
                canvas.save();
                canvas.translate((POINT_TO_REF_18.x - POINT_TO_REF_19.x) * (f7 - 1.0f), 0.0f);
                canvas.scale(f7, this.mArm.scaleY, POINT_TO_REF_18.x, POINT_TO_REF_14.y);
                canvas.scale(1.0f, f7 / this.mArm.scaleY, POINT_TO_REF_16.x, POINT_TO_REF_16.y);
                this.workRect.set(-20000.0f, POINT_TO_REF_24.y, 20000.0f, 20000.0f);
                canvas.clipRect(this.workRect);
                if (a12 != null) {
                    a12.draw(canvas);
                }
                if (picture != null) {
                    picture.draw(canvas);
                }
                canvas.restore();
                if (!(a10 == null && a11 == null && a6 == null)) {
                    canvas.save();
                    canvas.translate((POINT_TO_REF_18.x - POINT_TO_REF_19.x) * (f7 - 1.0f), 0.0f);
                    canvas.translate(0.0f, (POINT_TO_REF_16.y - POINT_TO_REF_14.y) * (this.mArm.scaleY - 1.0f));
                    canvas.scale(f7, f7, POINT_TO_REF_16.x, POINT_TO_REF_16.y);
                    if (a11 != null) {
                        a11.draw(canvas);
                    }
                    if (a10 != null) {
                        a10.draw(canvas);
                    }
                    if (a6 != null) {
                        canvas.save();
                        canvas.rotate(-f8, POINT_TO_REF_24.x, POINT_TO_REF_24.y);
                        a6.draw(canvas);
                        canvas.restore();
                    }
                    canvas.restore();
                }
                if (part2 != null && part2.f1098b == C0215l.LEFT_ARM && i3 == 0) {
                    m1839a(canvas, f7, part2, 0.0f);
                }
            }
            canvas.restore();
            i3++;
        }
        int i4 = 0;
        while (i4 < 2) {
            f4 = i4 == 0 ? this.ac.f1070a : this.ac.f1071b;
            f5 = i4 == 0 ? this.ac.f1084o : this.ac.f1086q;
            float f9 = i4 == 0 ? this.ac.f1085p : this.ac.f1087r;
            canvas.save();
            canvas.rotate(this.ac.f1079j, POINT_CENTER_OF_BODY.x, POINT_CENTER_OF_BODY.y);
            canvas.translate(this.ac.f1094y, this.ac.f1095z);
            if (i4 == 1) {
                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
            }
            float f10 = POINT_TO_REF_19.x + (((POINT_TO_REF_20.x - POINT_TO_REF_19.x) * this.mArm.scaleX) / 2.0f);
            float f8 = POINT_TO_REF_14.y + ((POINT_TO_REF_18.y - POINT_TO_REF_14.y) * this.mArm.scaleX);
            canvas.translate(this.mArm.f1503d, this.mArm.f1504e);
            canvas.rotate(f4, f10, f8);
            canvas.translate(f5, f9);
            Picture a13 = m1831a(i4 == 0 ? "leftshoulder" : "rightshoulder");
            if (a13 != null) {
                canvas.save();
                canvas.translate((POINT_TO_REF_18.x - POINT_TO_REF_19.x) * (this.mArm.scaleX - 1.0f), 0.0f);
                canvas.scale(this.mArm.scaleX, this.mArm.scaleX, POINT_TO_REF_18.x, POINT_TO_REF_14.y);
                a13.draw(canvas);
                canvas.restore();
            }
            canvas.restore();
            i4++;
        }
        if (this.ac.f1067T) {
            m1840a(canvas, a, a2);
        }
        canvas.restore();
    }

    public void m1839a(Canvas canvas, float f, com.google.android.apps.androidify.p018a.Part aPart, float f2) {
        SVG a = aPart.getSvg(this.context, this.f1360W);
        if (a != null) {
            canvas.save();
            Picture picture = a.getPicture();
            canvas.translate(POINT_TO_REF_18.x - (((float) picture.getWidth()) / 2.0f), POINT_TO_REF_18.y - (((float) picture.getHeight()) / 2.0f));
            canvas.translate((POINT_TO_REF_18.x - POINT_TO_REF_19.x) * (f - 1.0f), 0.0f);
            canvas.translate(this.ac.f1056I * (f / 0.92f), this.ac.f1057J * (this.mArm.scaleY / 1.15f));
            canvas.rotate(aPart.f1098b == C0215l.RIGHT_ARM_UNDER ? -this.ac.f1083n : this.ac.f1083n, ((float) picture.getWidth()) / 2.0f, ((float) picture.getHeight()) / 2.0f);
            canvas.scale((this.ac.f1063P * f) / 0.92f, (this.ac.f1062O * f) / 0.92f, ((float) picture.getWidth()) / 2.0f, ((float) picture.getHeight()) / 2.0f);
            canvas.drawPicture(picture);
            canvas.restore();
        }
    }

    public void m1840a(Canvas canvas, AndAnimation aAndAnimationVar, AndAnimation aAndAnimationVar2) {
        int i = 0;
        Picture[] m = m1864m();
        Picture a = m1831a("mouth");
        Picture a2 = m1831a("hat");
        canvas.save();
        canvas.rotate(this.ac.f1079j, POINT_CENTER_OF_BODY.x, POINT_CENTER_OF_BODY.y);
        canvas.translate(this.ac.f1094y, this.ac.f1095z);
        canvas.rotate(this.ac.f1078i, POINT_TO_REF_2.x, POINT_TO_REF_2.y);
        canvas.translate(this.ac.f1092w, this.ac.f1093x);
        if (aAndAnimationVar != null) {
            canvas.rotate(aAndAnimationVar.m1760e(), POINT_TO_REF_2.x, POINT_TO_REF_2.y);
        }
        if (aAndAnimationVar2 != null) {
            canvas.translate(0.0f, aAndAnimationVar2.m1760e());
        }
        canvas.scale(this.mDroidHead.scaleX, this.mDroidHead.scaleY, POINT_TO_REF_2.x, POINT_TO_REF_2.y);
        if (this.f1383u != null) {
            canvas.save();
            this.f1383u.draw(canvas);
            canvas.restore();
        }
        if (this.hairBack != null) {
            this.hairBack.draw(canvas);
        }
        if (this.hairFront != null) {
            this.hairFront.draw(canvas);
        }
        if (a2 != null) {
            a2.draw(canvas);
        }
        if (this.f1382t != null) {
            canvas.save();
            canvas.scale(1.0f, this.mDroidHead.scaleX / this.mDroidHead.scaleY, POINT_TO_REF_2.x, POINT_TO_REF_7.y);
            this.f1382t.draw(canvas);
            canvas.restore();
        }
        if (a != null) {
            a.draw(canvas);
        }
        if (m[0] != null) {
            m[0].draw(canvas);
        }
        if (m[1] != null) {
            m[1].draw(canvas);
        }
        com.google.android.apps.androidify.p018a.Part part = null;
        if (this.f1338A != null && this.f1338A.f1098b == C0215l.HEAD) {
            part = this.f1338A;
        }
        if (part != null) {
            SVG a3 = part.getSvg(this.context, this.f1360W);
            if (a3 != null) {
                if (part.f1102f) {
                    canvas.save();
                    Picture picture = a3.getPicture();
                    canvas.translate(this.ac.f1050C, this.ac.f1051D);
                    while (i < 2) {
                        canvas.save();
                        if (i == 1) {
                            canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
                        }
                        canvas.translate(POINT_TO_REF_7.x - (((float) picture.getWidth()) / 2.0f), POINT_TO_REF_7.y - (((float) picture.getHeight()) / 2.0f));
                        canvas.rotate(this.ac.f1083n, ((float) picture.getWidth()) / 2.0f, ((float) picture.getHeight()) / 2.0f);
                        canvas.scale(this.ac.f1063P, this.ac.f1062O, ((float) picture.getWidth()) / 2.0f, ((float) picture.getHeight()) / 2.0f);
                        canvas.drawPicture(picture);
                        canvas.restore();
                        i++;
                    }
                    canvas.restore();
                } else {
                    canvas.save();
                    Picture picture2 = a3.getPicture();
                    canvas.translate(POINT_TO_REF_2.x - (((float) picture2.getWidth()) / 2.0f), POINT_TO_REF_2.y - (((float) picture2.getHeight()) / 2.0f));
                    canvas.translate(this.ac.f1056I * 0.667f, this.ac.f1057J * 0.667f);
                    canvas.rotate(this.ac.f1083n, ((float) picture2.getWidth()) / 2.0f, ((float) picture2.getHeight()) / 2.0f);
                    canvas.scale(this.ac.f1063P, this.ac.f1062O, ((float) picture2.getWidth()) / 2.0f, ((float) picture2.getHeight()) / 2.0f);
                    canvas.drawPicture(picture2);
                    canvas.restore();
                }
            }
        }
        canvas.restore();
    }

    public void m1841a(AnimationCatalogue aAnimationCatalogue, double d) {
        this.ac.initAnimation(aAnimationCatalogue, null, 1.0f, d, this.scaleFactor);
        this.f1338A = aAnimationCatalogue.m1612c();
    }

    public void m1842a(AnimationCatalogue aAnimationCatalogue, double d, AnimationCatalogue aAnimationCatalogue2, double d2, float f) {
        if (aAnimationCatalogue2 == null) {
            this.ac.f1066S = false;
            m1841a(aAnimationCatalogue, d);
            return;
        }
        com.google.android.apps.androidify.p018a.Part c = aAnimationCatalogue2.m1612c();
        com.google.android.apps.androidify.p018a.Part c2 = aAnimationCatalogue.m1612c();
        if (!(c == null || c2 == null || !c.f1097a.equals(c2.f1097a))) {
            this.ac.f1066S = true;
        }
        this.ad.initAnimation(aAnimationCatalogue2, null, 1.0f, d2, this.scaleFactor);
        this.ac.initAnimation(aAnimationCatalogue, this.ad, f, d, this.scaleFactor);
        this.f1338A = aAnimationCatalogue.m1612c();
    }

    public void m1843a(AndAnimation aAndAnimationVar) {
        this.animations.put(aAndAnimationVar.m1757b().toString(), aAndAnimationVar);
    }

    public void setAndroidConfig(AndroidConfig config, AssetDatabase aDb) {
        PartConfig partConfig;
        int hairColor = config.getHairColor();
        this.skinColor = config.getSkinColor();
        if (this.skinColor == this.context.getResources().getColor(R.color.gray_android)) {
            this.f1360W = this.context.getResources().getColor(R.color.gray_arm_android);
        } else {
            this.f1360W = m1693a(this.skinColor);
        }
        this.mDroidHead.picture = aDb.getSvgFromResource(R.raw.android_head, ANDROID_COLOR, Integer.valueOf(this.skinColor)).getPicture();
        this.mDroidBody.picture = aDb.getSvgFromResource(R.raw.android_body, ANDROID_COLOR, Integer.valueOf(this.skinColor)).getPicture();
        this.mLeg.picture = aDb.getSvgFromResource(R.raw.android_leg, ANDROID_COLOR, Integer.valueOf(this.skinColor)).getPicture();
        this.mFoot = aDb.getSvgFromResource(R.raw.android_foot, ANDROID_COLOR, Integer.valueOf(this.skinColor)).getPicture();
        this.mAntenna = aDb.getSvgFromResource(R.raw.android_antenna, ANDROID_COLOR, Integer.valueOf(this.skinColor)).getPicture();

        String hair = config.getHair();

        if (hair != null) {
            SVG a;
            SVG a2 = aDb.getSVG(ASSET_HAIR, hair, HAIR_BACK, HAIR_COLOR_DEFAULT, Integer.valueOf(hairColor));
            this.beard = getPicture(a2);
            a = aDb.getSVG(ASSET_HAIR, hair, HAIR_FRONT, HAIR_COLOR_DEFAULT, Integer.valueOf(hairColor));
            this.hairBack = getPicture(a);
            SVG a3 = aDb.getSVG(ASSET_HAIR, hair, HAIR_BACK_EXTRA);
            this.f1379q = getPicture(a3);
            SVG a4 = aDb.getSVG(ASSET_HAIR, hair, HAIR_FRONT_EXTRA);
            this.hairFront = getPicture(a4);
            this.hairBounds = new RectF(f1212w);
            if (!(a2 == null || a2.scale.centerX() == 0)) {
                this.hairBounds.union(a2.bounds);
            }
            if (!(a == null || a.scale.centerX() == 0)) {
                this.hairBounds.union(a.bounds);
            }
            if (!(a3 == null || a3.scale.centerX() == 0)) {
                this.hairBounds.union(a3.bounds);
            }
            if (!(a4 == null || a4.scale.centerX() == 0)) {
                this.hairBounds.union(a4.bounds);
            }
        } else {
            this.beard = null;
            this.hairBack = null;
            this.f1379q = null;
            this.hairFront = null;
            this.hairBounds = f1212w;
        }
        String outfit = config.getOutfit();
        if (outfit != null) {
            this.shirtBody = getPicture(aDb.getSVG("shirt", outfit, "body"));
            this.shirtArm = getPicture(aDb.getSVG("shirt", outfit, "arm"));
            this.shirtTop = getPicture(aDb.getSVG("shirt", outfit, "top"));
            this.shirtBottom = getPicture(aDb.getSVG("shirt", outfit, "bottom"));
        } else {
            this.shirtBody = null;
            this.shirtArm = null;
            this.shirtTop = null;
            this.shirtBottom = null;
        }
        outfit = config.m1802g();
        if (outfit != null) {
            this.pantsTop = getPicture(aDb.getSVG("pants", outfit, "leg"));
            this.shoes = getPicture(aDb.getSVG("pants", outfit, "skirt"));
            this.glasses = getPicture(aDb.getSVG("pants", outfit, "top"));
        } else {
            this.pantsTop = null;
            this.shoes = null;
            this.glasses = null;
        }
        outfit = config.m1805h();
        if (outfit != null) {
            PartConfig e2 = aDb.m1674e(outfit);
            if (e2 != null) {
                SVG a = aDb.getSvg(e2, config);
                if (a != null) {
                    this.f1381s = a.getPicture();
                } else {
                    this.f1381s = null;
                }
            } else {
                this.f1381s = null;
            }
        } else {
            this.f1381s = null;
        }
        outfit = config.m1807i();
        if (outfit != null) {
            this.f1382t = getPicture(aDb.getSVG("glasses", outfit, null));
        } else {
            this.f1382t = null;
        }
        hair = config.m1808j();
        if (hair != null) {
            this.f1383u = getPicture(aDb.getSVG("beard", hair, null,
                    HAIR_COLOR_DEFAULT, Integer.valueOf(hairColor)));
        } else {
            this.f1383u = null;
        }
        outfit = config.m1821w();
        String hatType = config.getHat();
        if (hatType != null) {
            partConfig = aDb.getHatFromString(hatType);
            if (partConfig != null) {
                this.accessories = new SvgToStringBinder(outfit, hatType, aDb.getSvg(partConfig, config));
            } else {
                this.accessories = null;
            }
        } else {
            this.accessories = null;
        }
        outfit = config.m1823y();
        hatType = config.m1822x();
        if (hatType != null) {
            partConfig = aDb.m1682i(hatType);
            if (partConfig != null) {
                this.f1385w = new SvgToStringBinder(outfit, hatType, aDb.getSvg(partConfig, config));
            } else {
                this.f1385w = null;
            }
        } else {
            this.f1385w = null;
        }
        outfit = config.m1765A();
        hatType = config.m1824z();
        if (hatType != null) {
            partConfig = aDb.m1684j(hatType);
            if (partConfig != null) {
                this.f1386x = new SvgToStringBinder(outfit, hatType, aDb.getSvg(partConfig, config));
            } else {
                this.f1386x = null;
            }
        } else {
            this.f1386x = null;
        }
        outfit = config.m1767C();
        hatType = config.m1766B();
        if (hatType != null) {
            partConfig = aDb.m1686k(hatType);
            if (partConfig != null) {
                this.f1387y = new SvgToStringBinder(outfit, hatType, aDb.getSvg(partConfig, config));
            } else {
                this.f1387y = null;
            }
        } else {
            this.f1387y = null;
        }
        this.mDroidBody.scaleX = config.getBodyScaleX();
        this.mDroidBody.scaleY = config.getBodyScaleY();
        this.mDroidHead.scaleX = config.getHeadScaleX();
        this.mDroidHead.scaleY = config.getHeadScaleY();
        this.mArm.scaleX = config.getArmScaleX();
        this.mArm.scaleY = config.getArmScaleY();
        this.mLeg.scaleX = config.getLegScaleX();
        this.mLeg.scaleY = config.getLegScaleY();
        computeArmOffset();
        computeLegsOffset();
        rescale();
    }

    public void m1845a(StructOfFloats aStructOfFloatsVar) {
        this.zoom = aStructOfFloatsVar;
        m1826a((aStructOfFloatsVar.f1640f * (POINT_TO_REF_5.y - POINT_TO_REF_3.y)) * Util.performance(this.context, 1.0f), aStructOfFloatsVar.f1642h, aStructOfFloatsVar.f1641g);
    }

    public void m1846a(boolean z) {
        switch (z ? RAANDOM.nextInt(6) : RAANDOM.nextInt(4) + 1) {
            case HListViewConstants.HListView_android_entries /*0*/:
                m1863l();
            case HListViewConstants.HListView_android_divider /*1*/:
                m1862k();
            case HListViewConstants.HListView_hlv_dividerWidth /*2*/:
                m1861j();
            case HListViewConstants.HListView_hlv_headerDividersEnabled /*3*/:
                m1860i();
            case HListViewConstants.HListView_hlv_footerDividersEnabled /*4*/:
                m1859h();
            case HListViewConstants.HListView_hlv_overScrollHeader /*5*/:
                m1858g();
            default:
        }
    }

    public float getHeight() {
        return this.f1353P;
    }

    public void m1848b(float f) {
        this.f1368f = f;
    }

    public void setBackgroundColor(int i) {
        setBackgroundColor((16711680 & i) >> 16, (65280 & i) >> 8, i & 255);
    }

    public void m1850b(AnimationType aAnimationTypeVar) {
        this.animations.remove(aAnimationTypeVar.toString());
    }

    public void m1851b(boolean z) {
        this.ac.m1621a(z);
        this.ad.m1621a(z);
    }

    protected float getAmbientAntennaAngle(int i) {
        return this.antennaAnimation.getAngle(i);
    }

    public void rescale() {
        com.google.android.Util.debug("Rescaling for w: " + getWidth() + ", h: " + getHeight());
        float f = this.mDroidHead.scaleX * (POINT_RIGHT_BOTTOM_OF_HEAD.x - POINT_LEFT_BOTTOM_OF_HEAD.x);
        this.droidWidth = Math.max(((POINT_TOP_LEFT_OF_BODY.x - POINT_LEFT_OF_LEFT_SHOULDER.x) * this.mDroidBody.scaleX)
                + (((POINT_LEFT_OF_LEFT_SHOULDER.x - POINT_TO_REF_19.x) * 2.0f) * this.mArm.scaleX), f);
        float min = Math.min(f1211v, this.hairBounds.top);
        SVG hat = this.accessories == null ? null : this.accessories.mSVG;
        if (!(hat == null || hat.scale.centerX() == 0)) {
            min = Math.min(min, hat.scale.width());
        }
        min = ((POINT_TO_REF_2.y - min) * this.mDroidHead.scaleY) + (POINT_TOP_OF_BODY.y - POINT_TO_REF_2.y);
        float headHeight = (POINT_TO_REF_2.y - ((POINT_TO_REF_2.y - f1211v) * this.mDroidHead.scaleY)) + (POINT_TOP_OF_BODY.y - POINT_TO_REF_2.y);
        headHeight = (POINT_TO_REF_2.y - ((POINT_TO_REF_2.y - this.hairBounds.top) * this.mDroidHead.scaleY)) + (POINT_TOP_OF_BODY.y - POINT_TO_REF_2.y);
        headHeight = (POINT_TO_REF_13.y - POINT_TOP_OF_BODY.y) * this.mDroidBody.scaleY;
        this.topOfHead = ((POINT_TO_REF_35.y - POINT_TO_REF_13.y) * this.mLeg.scaleY) + ((POINT_TO_REF_34.y - POINT_TO_REF_35.y) * this.mLeg.scaleX);
        float topOfHair = ((this.hairBounds.bottom - POINT_TO_REF_2.y) * this.mDroidHead.scaleY) - headHeight;
        if (topOfHair > this.topOfHead) {
            this.topOfHead = topOfHair;
        }

        createArmPath();

        topOfHair = (min + headHeight) + this.topOfHead;

        this.droidBounds.set(POINT_CENTER_OF_BODY.x - (this.droidWidth / 2.0f), POINT_TOP_OF_BODY.y - min, POINT_CENTER_OF_BODY.x + (this.droidWidth / 2.0f), (headHeight + POINT_TOP_OF_BODY.y) + this.topOfHead);
        this.droidCenter.set((this.droidBounds.left + this.droidBounds.right) / 2.0f, (this.droidBounds.top + this.droidBounds.bottom) / 2.0f);
        this.droidWidth *= 1.15f;
        min = topOfHair * 1.15f;
        if (this.zoom == null) {
            headHeight = getWidth();
            this.scaleFactor = Math.min(headHeight / this.droidWidth, getHeight() / min) * this.f1368f;
            this.transform = new Matrix();
            this.transform.preTranslate((headHeight / 2.0f) - this.droidCenter.x, (getHeight() / 2.0f) - this.droidCenter.y);
            this.transform.preScale(this.scaleFactor, this.scaleFactor, this.droidCenter.x, this.droidCenter.y);
        } else {
            this.transform = new Matrix();
            headHeight = POINT_TO_REF_5.y - POINT_TO_REF_3.y;
            min = (this.zoom.f1639e ? ((POINT_TO_REF_7.x - 250.0f) * this.mDroidHead.scaleX) + 250.0f : ((POINT_TO_REF_8.x - 250.0f) * this.mDroidHead.scaleX) + 250.0f) + (this.zoom.f1636b * headHeight);
            headHeight = (headHeight * this.zoom.f1637c) + (POINT_TO_REF_2.y + ((POINT_TO_REF_7.y - POINT_TO_REF_2.y) * this.mDroidHead.scaleY));
            this.transform.preTranslate((getWidth() / 2.0f) - min, (getHeight() / 2.0f) - headHeight);
            this.scaleFactor = ((this.f1354Q * this.zoom.f1635a) / f) * this.f1368f;
            this.transform.preScale(this.scaleFactor, this.scaleFactor, min, headHeight);
            this.transform.preRotate((float) this.zoom.f1638d, min, headHeight);
        }
        this.transform.invert(this.reverseTransform);
        this.transform.mapPoints(new float[]{POINT_TOP_OF_BODY.x, POINT_TOP_OF_BODY.y});
        this.f1365c = POINT_TOP_OF_BODY.y + (((POINT_TO_REF_13.y - POINT_TOP_OF_BODY.y) * this.mDroidBody.scaleY) + ((POINT_TO_REF_35.y - POINT_TO_REF_13.y) * this.mLeg.scaleY));
        this.f1366d = POINT_TOP_OF_BODY.y + ((POINT_TO_REF_24.y - POINT_TO_REF_18.y) * this.mArm.scaleY);
        com.google.android.Util.debug("Scale factor: " + this.scaleFactor);
    }

    public void m1854c(float f) {
        this.ac.f1065R = f;
        this.ad.f1065R = f;
    }

    public void m1855d() {
        this.scaleFactor = -1.0f;
    }

    public void stepAnimations() {
        this.antennaAnimation.step();
        for (AndAnimation a : this.animations.values()) {
            a.step();
        }
    }

    public void m1857f() {
        this.ac.m1619a();
        this.f1338A = null;
    }

    public void m1858g() {
        AndAnimation andAnimationVar = new AndAnimation(AnimationType.SHRUG, 1000);
        AndInterpolator c0205b = new AndInterpolator(0.0f, 0.0f);
        c0205b.nextPoint(0.2f, 1.0f);
        c0205b.nextPoint(0.8f, 1.0f);
        c0205b.nextPoint(1.0f, 0.0f);
        andAnimationVar.interpolate(c0205b, 0.0f, POINT_TO_REF_2.y - POINT_TOP_OF_BODY.y);
        m1843a(andAnimationVar);
    }

    public void m1859h() {
        AndAnimation andAnimationVar = new AndAnimation(AnimationType.NOD, 600);
        AndInterpolator c0205b = new AndInterpolator(0.0f, 0.0f);
        c0205b.nextPoint(0.225f, 1.0f);
        c0205b.nextPoint(0.45f, 0.0f);
        c0205b.nextPoint(0.55f, 0.0f);
        c0205b.nextPoint(0.775f, 1.0f);
        c0205b.nextPoint(1.0f, 0.0f);
        andAnimationVar.interpolate(c0205b, 0.0f, POINT_TOP_OF_BODY.y - POINT_TO_REF_2.y);
        m1843a(andAnimationVar);
    }

    public void m1860i() {
        AndAnimation andAnimationVar = new AndAnimation(AnimationType.HEAD_TILT, 1000);
        AndInterpolator c0205b = new AndInterpolator(0.0f, 0.0f);
        c0205b.nextPoint(0.2f, 1.0f);
        c0205b.nextPoint(0.8f, 1.0f);
        andAnimationVar.interpolate(c0205b, 0.0f, RAANDOM.nextBoolean() ? 8.0f : -8.0f);
        m1843a(andAnimationVar);
    }

    public void m1861j() {
        AndAnimation andAnimationVar = new AndAnimation(AnimationType.ANTENNA_TWITCH);
        AndInterpolator c0205b = new AndInterpolator(0.0f, 0.0f);
        c0205b.nextPoint(0.25f, 1.0f);
        c0205b.nextPoint(0.5f, 0.0f);
        c0205b.nextPoint(0.75f, 1.0f);
        andAnimationVar.interpolate(c0205b, 0.0f, 40.0f);
        m1843a(andAnimationVar);
    }

    public void m1862k() {
        m1843a(new AndAnimation(AnimationType.BLINK));
    }

    public long m1863l() {
        AndAnimation andAnimationVar = new AndAnimation(AnimationType.WAVE, (long) 1200);
        AndInterpolator c0205b = new AndInterpolator(0.0f, 0.0f);
        c0205b.nextPoint(0.35f, 1.0f);
        c0205b.nextPoint(0.5f, 0.8f);
        c0205b.nextPoint(0.65f, 1.0f);
        andAnimationVar.interpolate(c0205b, 0.0f, 160.0f);
        m1843a(andAnimationVar);
        return (long) 1200;
    }

    public Picture[] m1864m() {
        if (this.f1385w == null || !this.f1385w.name.equals("mDroidHead")) {
            this.f1364b[1] = null;
        } else {
            this.f1364b[1] = this.f1385w.mSVG.getPicture();
        }
        if (this.accessories == null || !this.accessories.name.equals("mDroidHead")) {
            this.f1364b[0] = null;
        } else {
            this.f1364b[0] = this.accessories.mSVG.getPicture();
        }
        return this.f1364b;
    }

    public int m2191a(float v, float v1) {
        return 0;
    }

    public void m2293d(int i) {

    }

    public void setAdapter(AndroidViewAdapter aAndroidViewAdapter) {

    }
}
