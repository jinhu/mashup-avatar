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

public class AndroidDrawer {
    static final Random f1337a;
    private com.google.android.apps.androidify.p018a.Part f1338A;
    private ae f1339B;
    private Matrix f1340C;
    private Matrix f1341D;
    private RectF f1342E;
    private float f1343F;
    private PointF f1344G;
    private Part f1345H;
    private Part f1346I;
    private Part f1347J;
    private Part f1348K;
    private Picture f1349L;
    private Picture f1350M;
    private Path f1351N;
    private float f1352O;
    private float f1353P;
    private float f1354Q;
    private float f1355R;
    private RectF f1356S;
    private RectF f1357T;
    private Paint f1358U;
    private int f1359V;
    private int f1360W;
    private int f1361X;
    private int f1362Y;
    private int f1363Z;
    private StructOfFloats aa;
    private float ab;
    private AnimationContainer ac;
    private AnimationContainer ad;
    private int ae;
    private ci af;
    private Matrix ag;
    private RectF mRectF;
    private Context ai;
    private float[] aj;
    Picture[] f1364b;
    private float f1365c;
    private float f1366d;
    private float f1367e;
    private float f1368f;
    private HashMap f1369g;
    private Picture f1370h;
    private Picture f1371i;
    private Picture f1372j;
    private Picture f1373k;
    private Picture f1374l;
    private Picture f1375m;
    private Picture f1376n;
    private Picture f1377o;
    private Picture f1378p;
    private Picture f1379q;
    private Picture f1380r;
    private Picture f1381s;
    private Picture f1382t;
    private Picture f1383u;
    private bb f1384v;
    private bb f1385w;
    private bb f1386x;
    private bb f1387y;
    private Path f1388z;

    static {
        f1337a = new Random();
    }

    public AndroidDrawer(Context context) {
        this.f1367e = 1.0f;
        this.f1368f = 1.0f;
        this.f1370h = null;
        this.f1371i = null;
        this.f1372j = null;
        this.f1373k = null;
        this.f1374l = null;
        this.f1375m = null;
        this.f1376n = null;
        this.f1377o = null;
        this.f1378p = null;
        this.f1379q = null;
        this.f1380r = null;
        this.f1381s = null;
        this.f1382t = null;
        this.f1383u = null;
        this.f1384v = null;
        this.f1385w = null;
        this.f1386x = null;
        this.f1387y = null;
        this.f1340C = null;
        this.f1341D = null;
        this.f1356S = Constants.f1212w;
        this.f1357T = new RectF();
        this.f1361X = 255;
        this.f1362Y = 255;
        this.f1363Z = 255;
        this.aa = null;
        this.ac = new AnimationContainer();
        this.ad = new AnimationContainer();
        this.ae = 255;
        this.af = new ci();
        this.ag = new Matrix();
        this.mRectF = new RectF(Constants.POINT_TO_REF_7.x - Constants.f1210u, 0.0f, Constants.POINT_TO_REF_7.x + Constants.f1210u, 0.0f);
        this.aj = new float[2];
        this.f1364b = new Picture[2];
        this.ai = context;
        AssetDatabase a = AssetDatabase.instance(context);
        Picture picture = a.getSvgFromResource((int) R.raw.android_body).getPicture();
        Picture picture2 = a.getSvgFromResource((int) R.raw.android_head).getPicture();
        Picture picture3 = a.getSvgFromResource((int) R.raw.android_antenna).getPicture();
        Picture picture4 = a.getSvgFromResource((int) R.raw.android_arm).getPicture();
        Picture picture5 = a.getSvgFromResource((int) R.raw.android_leg).getPicture();
        this.f1349L = a.getSvgFromResource((int) R.raw.android_foot).getPicture();
        this.f1350M = picture3;
        this.f1345H = new Part(picture);
        this.f1346I = new Part(picture2);
        this.f1347J = new Part(picture4);
        this.f1348K = new Part(picture5);
        this.f1342E = new RectF();
        this.f1344G = new PointF();
        this.f1388z = SVGParser.parsePath("M140.396,175.489v177.916c0,10.566,8.566,19.133,19.135,19.133h2.303h20.331h48.709h37.371h48.708h11.881h10.752c10.569,0,19.137-8.562,19.137-19.133V175.489H140.396z");
        this.f1341D = new Matrix();
        this.f1358U = new Paint();
        this.f1358U.setAntiAlias(true);
        this.f1351N = new Path();
        m1829p();
        this.f1369g = new HashMap();
        this.f1339B = new ae();
    }

    private static Picture m1825a(SVG aSVG) {
        return aSVG == null ? null : aSVG.getPicture();
    }

    private void m1826a(float f, int i, long j) {
        m1850b(AnimationType.DRIFT);
        this.ab = (float) ((((double) i) * 3.141592653589793d) / 180.0d);
        AndAnimation andAnimationVar = new AndAnimation(AnimationType.DRIFT, j);
        andAnimationVar.interpolate(new LinearInterpolator(), 0.0f, f);
        m1843a(andAnimationVar);
    }

    private void m1827n() {
        this.f1347J.f1503d = (-(Constants.POINT_TOP_OF_BODY.x - Constants.POINT_LEFT_OF_LEFT_SHOULDER.x)) * (this.f1345H.scaleX - 1.0f);
        Part partVar = this.f1347J;
        partVar.f1503d -= (Constants.POINT_TO_REF_20.x - Constants.POINT_TO_REF_19.x) * (this.f1347J.scaleX - 1.0f);
    }

    private void m1828o() {
        this.f1348K.f1504e = ((Constants.POINT_TO_REF_13.y - Constants.POINT_TOP_OF_BODY.y) * (this.f1345H.scaleY - 1.0f)) - 10.0f;
    }

    private void m1829p() {
        this.f1351N.rewind();
        float f = (Constants.POINT_TO_REF_20.x - Constants.POINT_TO_REF_19.x) * this.f1347J.scaleX;
        float f2 = (Constants.POINT_TO_REF_16.y - Constants.POINT_TO_REF_14.y) * this.f1347J.scaleY;
        float f3 = f / 2.0f;
        float f4 = f3 * 0.5522848f;
        this.f1351N.moveTo(Constants.POINT_TO_REF_19.x, Constants.POINT_TO_REF_14.y + f3);
        this.f1351N.rCubicTo(0.0f, -f4, f3 - f4, -f3, f3, -f3);
        this.f1351N.rCubicTo(f4, 0.0f, f3, f3 - f4, f3, f3);
        this.f1351N.rLineTo(0.0f, f2 - f);
        this.f1351N.rCubicTo(0.0f, f4, -(f3 - f4), f3, -f3, f3);
        float f5 = -f3;
        this.f1351N.rCubicTo(-f4, 0.0f, -f3, -(f3 - f4), -f3, f5);
        this.f1351N.rLineTo(0.0f, -(f2 - f));
        this.f1351N.close();
    }

    public float m1830a() {
        return this.f1352O;
    }

    public Picture m1831a(String str) {
        return (this.f1384v == null || !this.f1384v.f1389a.equals(str) || this.f1384v.f1391c == null) ? (this.f1385w == null || !this.f1385w.f1389a.equals(str) || this.f1385w.f1391c == null) ? (this.f1386x == null || !this.f1386x.f1389a.equals(str) || this.f1386x.f1391c == null) ? (this.f1387y == null || !this.f1387y.f1389a.equals(str) || this.f1387y.f1391c == null) ? null : this.f1387y.f1391c.getPicture() : this.f1386x.f1391c.getPicture() : this.f1385w.f1391c.getPicture() : this.f1384v.f1391c.getPicture();
    }

    public AndAnimation m1832a(AnimationType aAnimationTypeVar) {
        return (AndAnimation) this.f1369g.get(aAnimationTypeVar.toString());
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
            m1853c();
        }
    }

    public void m1836a(int i, int i2, int i3) {
        this.f1361X = i;
        this.f1362Y = i2;
        this.f1363Z = i3;
    }

    public void m1837a(Canvas canvas) {
        m1838a(canvas, this.f1352O, this.f1353P);
    }

    public void m1838a(Canvas canvas, float f, float f2) {
        canvas.drawARGB(this.ae, this.f1361X, this.f1362Y, this.f1363Z);
        canvas.getSaveCount();
        canvas.save();
        if (this.f1367e <= 0.0f) {
            m1835a((int) f, (int) f2);
        }
        if ((!this.f1369g.isEmpty() ? 1 : null) != null) {
            Iterator it = this.f1369g.values().iterator();
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
        canvas.concat(this.f1340C);
        com.google.android.apps.androidify.p018a.Part part = null;
        if (this.f1338A != null && this.f1338A.f1098b == C0215l.MASTER) {
            part = this.f1338A;
        }
        if (part != null) {
            SVG a4 = part.getSvg(this.ai, 0);
            canvas.save();
            canvas.translate(this.ac.f1056I + Constants.POINT_CENTER_OF_BODY.x, this.ac.f1057J + Constants.POINT_CENTER_OF_BODY.y);
            //canvas.scale(this.mLocation7.f1063P, this.mLocation7.f1062O, a4.scale.centerX(), a4.scale.centerY());
            canvas.drawPicture(a4.getPicture());
            canvas.restore();
        }
        canvas.rotate(this.ac.f1080k, Constants.POINT_CENTER_OF_BODY.x, Constants.POINT_CENTER_OF_BODY.y);
        canvas.translate(this.ac.f1048A, (((this.ac.f1049B * 0.29615164f) * this.f1345H.scaleY) + ((this.ac.f1049B * 0.70384836f) * this.f1348K.scaleY)) * 0.3f);
        canvas.scale(this.ac.f1064Q, 1.0f, Constants.POINT_CENTER_OF_BODY.x, Constants.POINT_CENTER_OF_BODY.y);
        part = null;
        if (this.f1338A != null && this.f1338A.f1098b == C0215l.BALL) {
            part = this.f1338A;
        }
        canvas.save();
        canvas.rotate(this.ac.f1079j, Constants.POINT_CENTER_OF_BODY.x, Constants.POINT_CENTER_OF_BODY.y);
        canvas.translate(this.ac.f1094y, this.ac.f1095z);
        canvas.rotate(this.ac.f1078i, Constants.POINT_TO_REF_2.x, Constants.POINT_TO_REF_2.y);
        canvas.translate(this.ac.f1092w, this.ac.f1093x);
        if (a != null) {
            canvas.rotate(a.m1760e(), Constants.POINT_TO_REF_2.x, Constants.POINT_TO_REF_2.y);
        }
        if (a2 != null) {
            canvas.translate(0.0f, a2.m1760e());
        }
        canvas.scale(this.f1346I.scaleX, this.f1346I.scaleY, Constants.POINT_TO_REF_2.x, Constants.POINT_TO_REF_2.y);
        if (this.f1377o != null) {
            this.f1377o.draw(canvas);
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
            canvas.translate(this.f1348K.f1503d, this.f1348K.f1504e);
            canvas.rotate(f3, 250.0f + ((Constants.POINT_TO_REF_37.x - 250.0f) * this.f1348K.scaleX), Constants.POINT_TO_REF_32.y);
            canvas.translate(f4, f5);
            canvas.scale(this.f1348K.scaleX, this.f1348K.scaleY, Constants.POINT_TO_REF_13.x, Constants.POINT_TO_REF_13.y);
            this.f1348K.picture.draw(canvas);
            canvas.restore();
            i++;
        }
        canvas.save();
        canvas.translate(this.f1348K.f1503d, this.f1348K.f1504e);
        i = 0;
        while (i < 2) {
            f3 = i == 0 ? this.ac.f1072c : this.ac.f1073d;
            f4 = i == 0 ? this.ac.f1088s : this.ac.f1090u;
            f5 = i == 0 ? this.ac.f1089t : this.ac.f1091v;
            canvas.save();
            if (i == 1) {
                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
            }
            canvas.rotate(f3, 250.0f + ((Constants.POINT_TO_REF_37.x - 250.0f) * this.f1348K.scaleX), Constants.POINT_TO_REF_32.y);
            canvas.translate(f4, f5);
            canvas.scale(this.f1348K.scaleX, this.f1348K.scaleY, Constants.POINT_TO_REF_13.x, Constants.POINT_TO_REF_13.y);
            canvas.save();
            canvas.scale(1.0f, this.f1348K.scaleX / this.f1348K.scaleY, 250.0f, Constants.POINT_TO_REF_35.y);
            this.f1349L.draw(canvas);
            canvas.restore();
            if (this.f1374l != null) {
                this.f1374l.draw(canvas);
            }
            canvas.save();
            canvas.scale(1.0f, this.f1348K.scaleX / this.f1348K.scaleY, i == 0 ? Constants.POINT_TO_REF_32.x : Constants.POINT_TO_REF_33.x, Constants.POINT_TO_REF_13.y);
            if (this.f1376n != null) {
                this.f1376n.draw(canvas);
            }
            canvas.restore();
            canvas.restore();
            i++;
        }
        canvas.restore();
        canvas.save();
        canvas.rotate(this.ac.f1079j, Constants.POINT_CENTER_OF_BODY.x, Constants.POINT_CENTER_OF_BODY.y);
        canvas.translate(this.ac.f1094y, this.ac.f1095z);
        canvas.save(1);
        canvas.scale(this.f1345H.scaleX, this.f1345H.scaleY, Constants.POINT_TOP_OF_BODY.x, Constants.POINT_TOP_OF_BODY.y);
        canvas.clipPath(this.f1388z);
        this.f1345H.picture.draw(canvas);
        canvas.restore();
        if (this.f1370h != null) {
            f5 = Math.max(this.f1345H.scaleX, this.f1345H.scaleY);
            if (f5 < 1.2f) {
                canvas.scale(f5 / 1.2f, f5 / 1.2f, Constants.POINT_TOP_OF_BODY.x, Constants.POINT_TOP_OF_BODY.y);
            }
            this.f1370h.draw(canvas);
        }
        canvas.restore();
        canvas.save();
        canvas.translate(this.f1348K.f1503d, this.f1348K.f1504e);
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
                canvas.rotate(f3, 250.0f + ((Constants.POINT_TO_REF_37.x - 250.0f) * this.f1348K.scaleX), Constants.POINT_TO_REF_32.y);
                canvas.translate(f4, f5);
                canvas.scale(this.f1348K.scaleX, this.f1348K.scaleY, Constants.POINT_TO_REF_13.x, Constants.POINT_TO_REF_13.y);
                canvas.scale(1.0f, this.f1348K.scaleX / this.f1348K.scaleY, 250.0f, Constants.POINT_TO_REF_35.y);
                if (i == 0 && this.ac.f1074e != 0.0f) {
                    canvas.rotate(this.ac.f1074e, Constants.POINT_TO_REF_35.x, Constants.POINT_TO_REF_35.y);
                } else if (i == 1 && this.ac.f1075f != 0.0f) {
                    canvas.rotate(this.ac.f1075f, Constants.POINT_TO_REF_35.x, Constants.POINT_TO_REF_35.y);
                }
                this.f1381s.draw(canvas);
                canvas.restore();
                i++;
            }
        }
        canvas.restore();
        if (this.f1373k != null) {
            canvas.save();
            canvas.rotate(this.ac.f1079j, Constants.POINT_CENTER_OF_BODY.x, Constants.POINT_CENTER_OF_BODY.y);
            canvas.translate(this.ac.f1094y, this.ac.f1095z);
            canvas.scale(this.f1345H.scaleX, this.f1345H.scaleY, Constants.POINT_TOP_OF_BODY.x, Constants.POINT_TOP_OF_BODY.y);
            this.f1373k.draw(canvas);
            canvas.restore();
        }
        if (this.f1375m != null) {
            canvas.save();
            canvas.rotate(this.ac.f1079j, Constants.POINT_CENTER_OF_BODY.x, Constants.POINT_CENTER_OF_BODY.y);
            canvas.translate(this.ac.f1094y, this.ac.f1095z);
            canvas.scale(this.f1345H.scaleX, this.f1345H.scaleY, Constants.POINT_TOP_OF_BODY.x, Constants.POINT_TOP_OF_BODY.y);
            this.f1375m.draw(canvas);
            canvas.restore();
        }
        Picture a5 = m1831a("body");
        if (this.f1372j != null) {
            canvas.save();
            canvas.rotate(this.ac.f1079j, Constants.POINT_CENTER_OF_BODY.x, Constants.POINT_CENTER_OF_BODY.y);
            canvas.translate(this.ac.f1094y, this.ac.f1095z);
            canvas.scale(this.f1345H.scaleX, this.f1345H.scaleY, Constants.POINT_TOP_OF_BODY.x, Constants.POINT_TOP_OF_BODY.y);
            if (this.f1372j != null) {
                this.f1372j.draw(canvas);
            }
            canvas.restore();
        }
        if (a5 != null) {
            canvas.save();
            canvas.rotate(this.ac.f1079j, Constants.POINT_CENTER_OF_BODY.x, Constants.POINT_CENTER_OF_BODY.y);
            canvas.translate(this.ac.f1094y, this.ac.f1095z);
            f4 = Math.min(this.f1345H.scaleX, this.f1345H.scaleY);
            canvas.scale(f4, f4, Constants.POINT_TOP_OF_BODY.x, Constants.POINT_TOP_OF_BODY.y);
            if (a5 != null) {
                a5.draw(canvas);
            }
            canvas.restore();
        }
        Picture a6 = m1831a("face");
        canvas.save();
        canvas.rotate(this.ac.f1079j, Constants.POINT_CENTER_OF_BODY.x, Constants.POINT_CENTER_OF_BODY.y);
        canvas.translate(this.ac.f1094y, this.ac.f1095z);
        if (a != null) {
            canvas.rotate(a.m1760e(), Constants.POINT_TO_REF_2.x, Constants.POINT_TO_REF_2.y);
        }
        canvas.rotate(this.ac.f1078i, Constants.POINT_TO_REF_2.x, Constants.POINT_TO_REF_2.y);
        canvas.translate(this.ac.f1092w, this.ac.f1093x);
        if (a2 != null) {
            canvas.translate(0.0f, a2.m1760e());
        }
        canvas.scale(this.f1346I.scaleX, this.f1346I.scaleY, Constants.POINT_TO_REF_2.x, Constants.POINT_TO_REF_2.y);
        this.f1346I.picture.draw(canvas);
        Picture a7 = m1831a("earring");
        for (int i2 = 0; i2 < 2; i2++) {
            canvas.save();
            if (i2 == 1) {
                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
            }
            if (this.f1346I.scaleX > this.f1346I.scaleY) {
                canvas.scale(1.0f, this.f1346I.scaleX / this.f1346I.scaleY, Constants.POINT_TO_REF_9.x, Constants.POINT_TO_REF_9.y);
            } else {
                canvas.scale(this.f1346I.scaleY / this.f1346I.scaleX, 1.0f, Constants.POINT_TO_REF_9.x, Constants.POINT_TO_REF_9.y);
            }
            AndAnimation a8 = m1832a(AnimationType.ANTENNA_TWITCH);
            if (a8 != null) {
                canvas.rotate(a8.m1760e(), Constants.POINT_TO_REF_9.x, Constants.POINT_TO_REF_9.y);
            } else {
                canvas.rotate(m1852c(i2), Constants.POINT_TO_REF_9.x, Constants.POINT_TO_REF_9.y);
            }
            if (i2 == 0 && this.ac.f1076g != 0.0f) {
                canvas.rotate(this.ac.f1076g, Constants.POINT_TO_REF_9.x, Constants.POINT_TO_REF_9.y);
            } else if (i2 == 1 && this.ac.f1077h != 0.0f) {
                canvas.rotate(this.ac.f1077h, Constants.POINT_TO_REF_9.x, Constants.POINT_TO_REF_9.y);
            }
            this.f1350M.draw(canvas);
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
        this.f1358U.setColor(-1);
        i = 0;
        while (i < 2) {
            canvas.save();
            if (i == 1) {
                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
            }
            if (this.f1346I.scaleX < this.f1346I.scaleY) {
                canvas.scale(1.0f, this.f1346I.scaleX / this.f1346I.scaleY, Constants.POINT_TO_REF_7.x, Constants.POINT_TO_REF_7.y);
            } else {
                canvas.scale(this.f1346I.scaleY / this.f1346I.scaleX, 1.0f, Constants.POINT_TO_REF_7.x, Constants.POINT_TO_REF_7.y);
            }
            if (i == 0 && this.ac.f1058K != 1.0f) {
                canvas.scale(this.ac.f1058K, this.ac.f1058K, Constants.POINT_TO_REF_7.x, Constants.POINT_TO_REF_7.y);
            } else if (i == 1 && this.ac.f1059L != 1.0f) {
                canvas.scale(this.ac.f1059L, this.ac.f1059L, Constants.POINT_TO_REF_7.x, Constants.POINT_TO_REF_7.y);
            }
            if (i == 0 && this.ac.f1081l != 0.0f) {
                canvas.rotate(this.ac.f1081l, Constants.POINT_TO_REF_7.x, Constants.POINT_TO_REF_7.y);
            } else if (i == 1 && this.ac.f1082m != 0.0f) {
                canvas.rotate(this.ac.f1082m, Constants.POINT_TO_REF_7.x, Constants.POINT_TO_REF_7.y);
            }
            f3 = i == 0 ? this.ac.f1052E : this.ac.f1054G;
            f4 = i == 0 ? this.ac.f1053F : this.ac.f1055H;
            f5 = i == 0 ? this.ac.f1060M : this.ac.f1061N;
            this.mRectF.left = (Constants.POINT_TO_REF_7.x - Constants.f1210u) + f3;
            this.mRectF.right = f3 + (Constants.POINT_TO_REF_7.x + Constants.f1210u);
            this.mRectF.top = by.m1898a(f5, 0.0f, 1.0f, Constants.POINT_TO_REF_7.y, Constants.POINT_TO_REF_3.y) + f4;
            this.mRectF.bottom = by.m1898a(f5, 0.0f, 1.0f, Constants.POINT_TO_REF_7.y, Constants.POINT_TO_REF_5.y) + f4;
            canvas.clipRect(this.mRectF);
            canvas.drawCircle(Constants.POINT_TO_REF_7.x, Constants.POINT_TO_REF_7.y, Constants.POINT_TO_REF_7.y - Constants.POINT_TO_REF_3.y, this.f1358U);
            canvas.restore();
            i++;
        }
        canvas.restore();
        canvas.restore();
        if (!this.ac.f1067T) {
            m1840a(canvas, a, a2);
        }
        if (part != null) {
            SVG a9 = part.getSvg(this.ai, 0);
            canvas.save();
            canvas.translate(this.ac.f1056I + Constants.POINT_CENTER_OF_BODY.x, by.m1898a(this.ac.f1057J, this.ac.f1068U.m1610b(Animation.PROP_POSITION_Y), this.ac.f1068U.m1603a(Animation.PROP_POSITION_Y), this.f1366d - 25.0f, this.f1365c - 80.0f) + part.f1103g);
            //canvas.scale(this.mLocation7.f1063P, this.mLocation7.f1062O, a9.scale.centerX(), a9.scale.centerY());
            canvas.drawPicture(a9.getPicture());
            canvas.restore();
        }
        float f6 = this.f1347J.f1503d;
        float f7 = this.f1347J.scaleX;
        Picture picture = this.f1371i;
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
            canvas.rotate(this.ac.f1079j, Constants.POINT_CENTER_OF_BODY.x, Constants.POINT_CENTER_OF_BODY.y);
            canvas.translate(this.ac.f1094y, this.ac.f1095z);
            AndAnimation a8 = m1832a(AnimationType.SHRUG);
            if (a8 != null) {
                canvas.translate(0.0f, a8.m1760e());
            }
            if (i3 == 1) {
                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
            }
            canvas.translate(f6, this.f1347J.f1504e);
            if (i3 == 0) {
                a8 = m1832a(AnimationType.WAVE);
                if (a8 != null) {
                    canvas.rotate(a8.m1760e(), Constants.POINT_TO_REF_14.x, Constants.POINT_TO_REF_14.y);
                }
            }
            canvas.rotate(f8, Constants.POINT_TO_REF_19.x + (((Constants.POINT_TO_REF_20.x - Constants.POINT_TO_REF_19.x) * f7) / 2.0f), Constants.POINT_TO_REF_14.y + ((Constants.POINT_TO_REF_18.y - Constants.POINT_TO_REF_14.y) * f7));
            canvas.translate(f3, f4);
            if (part2 != null && part2.f1098b == C0215l.RIGHT_ARM_UNDER && i3 == 1) {
                m1839a(canvas, f7, part2, -2.0f * f8);
            }
            if (this.ac.f1067T) {
                this.f1358U.setColor(this.f1359V);
            } else {
                this.f1358U.setColor(this.f1360W);
            }
            canvas.drawPath(this.f1351N, this.f1358U);
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
                canvas.translate((Constants.POINT_TO_REF_18.x - Constants.POINT_TO_REF_19.x) * (f7 - 1.0f), 0.0f);
                canvas.scale(f7, f7, Constants.POINT_TO_REF_18.x, Constants.POINT_TO_REF_14.y);
                this.f1357T.set(-20000.0f, -20000.0f, 20000.0f, Constants.POINT_TO_REF_18.y);
                if (a7 != null) {
                    a7.draw(canvas);
                }
                canvas.save();
                canvas.clipRect(this.f1357T);
                if (a12 != null) {
                    a12.draw(canvas);
                }
                if (picture != null) {
                    picture.draw(canvas);
                }
                canvas.restore();
                canvas.restore();
                f3 = (((Constants.POINT_TO_REF_24.y - Constants.POINT_TO_REF_18.y) * this.f1347J.scaleY) - (((Constants.POINT_TO_REF_18.y - Constants.POINT_TO_REF_14.y) * (f7 - this.f1347J.scaleY)) * 2.0f)) / (Constants.POINT_TO_REF_24.y - Constants.POINT_TO_REF_18.y);
                canvas.save();
                canvas.translate((Constants.POINT_TO_REF_18.x - Constants.POINT_TO_REF_19.x) * (f7 - 1.0f), 0.0f);
                canvas.scale(f7, this.f1347J.scaleY, Constants.POINT_TO_REF_14.x, Constants.POINT_TO_REF_14.y);
                canvas.scale(1.0f, f3 / this.f1347J.scaleY, Constants.POINT_TO_REF_26.x, Constants.POINT_TO_REF_26.y);
                this.f1357T.set(-20000.0f, Constants.POINT_TO_REF_18.y, 20000.0f, Constants.POINT_TO_REF_24.y);
                canvas.clipRect(this.f1357T);
                if (a12 != null) {
                    a12.draw(canvas);
                }
                if (picture != null) {
                    picture.draw(canvas);
                }
                canvas.restore();
                canvas.save();
                canvas.translate((Constants.POINT_TO_REF_18.x - Constants.POINT_TO_REF_19.x) * (f7 - 1.0f), 0.0f);
                canvas.scale(f7, this.f1347J.scaleY, Constants.POINT_TO_REF_18.x, Constants.POINT_TO_REF_14.y);
                canvas.scale(1.0f, f7 / this.f1347J.scaleY, Constants.POINT_TO_REF_16.x, Constants.POINT_TO_REF_16.y);
                this.f1357T.set(-20000.0f, Constants.POINT_TO_REF_24.y, 20000.0f, 20000.0f);
                canvas.clipRect(this.f1357T);
                if (a12 != null) {
                    a12.draw(canvas);
                }
                if (picture != null) {
                    picture.draw(canvas);
                }
                canvas.restore();
                if (!(a10 == null && a11 == null && a6 == null)) {
                    canvas.save();
                    canvas.translate((Constants.POINT_TO_REF_18.x - Constants.POINT_TO_REF_19.x) * (f7 - 1.0f), 0.0f);
                    canvas.translate(0.0f, (Constants.POINT_TO_REF_16.y - Constants.POINT_TO_REF_14.y) * (this.f1347J.scaleY - 1.0f));
                    canvas.scale(f7, f7, Constants.POINT_TO_REF_16.x, Constants.POINT_TO_REF_16.y);
                    if (a11 != null) {
                        a11.draw(canvas);
                    }
                    if (a10 != null) {
                        a10.draw(canvas);
                    }
                    if (a6 != null) {
                        canvas.save();
                        canvas.rotate(-f8, Constants.POINT_TO_REF_24.x, Constants.POINT_TO_REF_24.y);
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
            canvas.rotate(this.ac.f1079j, Constants.POINT_CENTER_OF_BODY.x, Constants.POINT_CENTER_OF_BODY.y);
            canvas.translate(this.ac.f1094y, this.ac.f1095z);
            if (i4 == 1) {
                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
            }
            float f10 = Constants.POINT_TO_REF_19.x + (((Constants.POINT_TO_REF_20.x - Constants.POINT_TO_REF_19.x) * this.f1347J.scaleX) / 2.0f);
            float f8 = Constants.POINT_TO_REF_14.y + ((Constants.POINT_TO_REF_18.y - Constants.POINT_TO_REF_14.y) * this.f1347J.scaleX);
            canvas.translate(this.f1347J.f1503d, this.f1347J.f1504e);
            canvas.rotate(f4, f10, f8);
            canvas.translate(f5, f9);
            Picture a13 = m1831a(i4 == 0 ? "leftshoulder" : "rightshoulder");
            if (a13 != null) {
                canvas.save();
                canvas.translate((Constants.POINT_TO_REF_18.x - Constants.POINT_TO_REF_19.x) * (this.f1347J.scaleX - 1.0f), 0.0f);
                canvas.scale(this.f1347J.scaleX, this.f1347J.scaleX, Constants.POINT_TO_REF_18.x, Constants.POINT_TO_REF_14.y);
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
        SVG a = aPart.getSvg(this.ai, this.f1360W);
        if (a != null) {
            canvas.save();
            Picture picture = a.getPicture();
            canvas.translate(Constants.POINT_TO_REF_18.x - (((float) picture.getWidth()) / 2.0f), Constants.POINT_TO_REF_18.y - (((float) picture.getHeight()) / 2.0f));
            canvas.translate((Constants.POINT_TO_REF_18.x - Constants.POINT_TO_REF_19.x) * (f - 1.0f), 0.0f);
            canvas.translate(this.ac.f1056I * (f / 0.92f), this.ac.f1057J * (this.f1347J.scaleY / 1.15f));
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
        canvas.rotate(this.ac.f1079j, Constants.POINT_CENTER_OF_BODY.x, Constants.POINT_CENTER_OF_BODY.y);
        canvas.translate(this.ac.f1094y, this.ac.f1095z);
        canvas.rotate(this.ac.f1078i, Constants.POINT_TO_REF_2.x, Constants.POINT_TO_REF_2.y);
        canvas.translate(this.ac.f1092w, this.ac.f1093x);
        if (aAndAnimationVar != null) {
            canvas.rotate(aAndAnimationVar.m1760e(), Constants.POINT_TO_REF_2.x, Constants.POINT_TO_REF_2.y);
        }
        if (aAndAnimationVar2 != null) {
            canvas.translate(0.0f, aAndAnimationVar2.m1760e());
        }
        canvas.scale(this.f1346I.scaleX, this.f1346I.scaleY, Constants.POINT_TO_REF_2.x, Constants.POINT_TO_REF_2.y);
        if (this.f1383u != null) {
            canvas.save();
            this.f1383u.draw(canvas);
            canvas.restore();
        }
        if (this.f1378p != null) {
            this.f1378p.draw(canvas);
        }
        if (this.f1380r != null) {
            this.f1380r.draw(canvas);
        }
        if (a2 != null) {
            a2.draw(canvas);
        }
        if (this.f1382t != null) {
            canvas.save();
            canvas.scale(1.0f, this.f1346I.scaleX / this.f1346I.scaleY, Constants.POINT_TO_REF_2.x, Constants.POINT_TO_REF_7.y);
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
            SVG a3 = part.getSvg(this.ai, this.f1360W);
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
                        canvas.translate(Constants.POINT_TO_REF_7.x - (((float) picture.getWidth()) / 2.0f), Constants.POINT_TO_REF_7.y - (((float) picture.getHeight()) / 2.0f));
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
                    canvas.translate(Constants.POINT_TO_REF_2.x - (((float) picture2.getWidth()) / 2.0f), Constants.POINT_TO_REF_2.y - (((float) picture2.getHeight()) / 2.0f));
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
        this.ac.initAnimation(aAnimationCatalogue, null, 1.0f, d, this.f1367e);
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
        this.ad.initAnimation(aAnimationCatalogue2, null, 1.0f, d2, this.f1367e);
        this.ac.initAnimation(aAnimationCatalogue, this.ad, f, d, this.f1367e);
        this.f1338A = aAnimationCatalogue.m1612c();
    }

    public void m1843a(AndAnimation aAndAnimationVar) {
        this.f1369g.put(aAndAnimationVar.m1757b().toString(), aAndAnimationVar);
    }

    public void m1844a(AndroidConfig aAndroidConfigVar, AssetDatabase aAssetDatabaseVar) {
        PartConfig h;
        int s = aAndroidConfigVar.getHairColor();
        this.f1359V = aAndroidConfigVar.getSkinColor();
        if (this.f1359V == this.ai.getResources().getColor(R.color.gray_android)) {
            this.f1360W = this.ai.getResources().getColor(R.color.gray_arm_android);
        } else {
            this.f1360W = Constants.m1693a(this.f1359V);
        }
        this.f1346I.picture = aAssetDatabaseVar.getSvgFromResource((int) R.raw.android_head, Constants.ANDROID_COLOR, Integer.valueOf(this.f1359V)).getPicture();
        this.f1345H.picture = aAssetDatabaseVar.getSvgFromResource((int) R.raw.android_body, Constants.ANDROID_COLOR, Integer.valueOf(this.f1359V)).getPicture();
        this.f1348K.picture = aAssetDatabaseVar.getSvgFromResource((int) R.raw.android_leg, Constants.ANDROID_COLOR, Integer.valueOf(this.f1359V)).getPicture();
        this.f1349L = aAssetDatabaseVar.getSvgFromResource((int) R.raw.android_foot, Constants.ANDROID_COLOR, Integer.valueOf(this.f1359V)).getPicture();
        this.f1350M = aAssetDatabaseVar.getSvgFromResource((int) R.raw.android_antenna, Constants.ANDROID_COLOR, Integer.valueOf(this.f1359V)).getPicture();
        String e = aAndroidConfigVar.getHair();
        if (e != null) {
            SVG a;
            SVG a2 = aAssetDatabaseVar.getSVG("hair", e, "back", Constants.f1190a, Integer.valueOf(s));
            this.f1377o = m1825a(a2);
            a = aAssetDatabaseVar.getSVG("hair", e, "front", Constants.f1190a, Integer.valueOf(s));
            this.f1378p = m1825a(a);
            SVG a3 = aAssetDatabaseVar.getSVG("hair", e, "backextra");
            this.f1379q = m1825a(a3);
            SVG a4 = aAssetDatabaseVar.getSVG("hair", e, "frontextra");
            this.f1380r = m1825a(a4);
            this.f1356S = new RectF(Constants.f1212w);
            if (!(a2 == null || a2.scale == 0)) {
            //    this.f1356S.union(a2.scale);
            }
            if (!(a == null || a.scale == 0)) {
             //   this.f1356S.union(a.scale);
            }
            if (!(a3 == null || a3.scale == 0)) {
             //   this.f1356S.union(a3.scale);
            }
            if (!(a4 == null || a4.scale == 0)) {
            //    this.f1356S.union(a4.scale);
            }
        } else {
            this.f1377o = null;
            this.f1378p = null;
            this.f1379q = null;
            this.f1380r = null;
            this.f1356S = Constants.f1212w;
        }
        String f = aAndroidConfigVar.getOutfit();
        if (f != null) {
            this.f1370h = m1825a(aAssetDatabaseVar.getSVG("shirt", f, "body"));
            this.f1371i = m1825a(aAssetDatabaseVar.getSVG("shirt", f, "arm"));
            this.f1372j = m1825a(aAssetDatabaseVar.getSVG("shirt", f, "top"));
            this.f1373k = m1825a(aAssetDatabaseVar.getSVG("shirt", f, "bottom"));
        } else {
            this.f1370h = null;
            this.f1371i = null;
            this.f1372j = null;
            this.f1373k = null;
        }
        f = aAndroidConfigVar.m1802g();
        if (f != null) {
            this.f1374l = m1825a(aAssetDatabaseVar.getSVG("pants", f, "leg"));
            this.f1375m = m1825a(aAssetDatabaseVar.getSVG("pants", f, "skirt"));
            this.f1376n = m1825a(aAssetDatabaseVar.getSVG("pants", f, "top"));
        } else {
            this.f1374l = null;
            this.f1375m = null;
            this.f1376n = null;
        }
        f = aAndroidConfigVar.m1805h();
        if (f != null) {
            PartConfig e2 = aAssetDatabaseVar.m1674e(f);
            if (e2 != null) {
                SVG a = aAssetDatabaseVar.getSvg(e2, aAndroidConfigVar);
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
        f = aAndroidConfigVar.m1807i();
        if (f != null) {
            this.f1382t = m1825a(aAssetDatabaseVar.getSVG("glasses", f, null));
        } else {
            this.f1382t = null;
        }
        e = aAndroidConfigVar.m1808j();
        if (e != null) {
            this.f1383u = m1825a(aAssetDatabaseVar.getSVG("beard", e, null, 
                    Constants.f1190a, Integer.valueOf(s)));
        } else {
            this.f1383u = null;
        }
        f = aAndroidConfigVar.m1821w();
        String v = aAndroidConfigVar.getHat();
        if (v != null) {
            h = aAssetDatabaseVar.getHatFromString(v);
            if (h != null) {
                this.f1384v = new bb(f, v, aAssetDatabaseVar.getSvg(h, aAndroidConfigVar));
            } else {
                this.f1384v = null;
            }
        } else {
            this.f1384v = null;
        }
        f = aAndroidConfigVar.m1823y();
        v = aAndroidConfigVar.m1822x();
        if (v != null) {
            h = aAssetDatabaseVar.m1682i(v);
            if (h != null) {
                this.f1385w = new bb(f, v, aAssetDatabaseVar.getSvg(h, aAndroidConfigVar));
            } else {
                this.f1385w = null;
            }
        } else {
            this.f1385w = null;
        }
        f = aAndroidConfigVar.m1765A();
        v = aAndroidConfigVar.m1824z();
        if (v != null) {
            h = aAssetDatabaseVar.m1684j(v);
            if (h != null) {
                this.f1386x = new bb(f, v, aAssetDatabaseVar.getSvg(h, aAndroidConfigVar));
            } else {
                this.f1386x = null;
            }
        } else {
            this.f1386x = null;
        }
        f = aAndroidConfigVar.m1767C();
        v = aAndroidConfigVar.m1766B();
        if (v != null) {
            h = aAssetDatabaseVar.m1686k(v);
            if (h != null) {
                this.f1387y = new bb(f, v, aAssetDatabaseVar.getSvg(h, aAndroidConfigVar));
            } else {
                this.f1387y = null;
            }
        } else {
            this.f1387y = null;
        }
        this.f1345H.scaleX = aAndroidConfigVar.getBodyScaleX();
        this.f1345H.scaleY = aAndroidConfigVar.getBodyScaleY();
        this.f1346I.scaleX = aAndroidConfigVar.getHeadScaleX();
        this.f1346I.scaleY = aAndroidConfigVar.getHeadScaleY();
        this.f1347J.scaleX = aAndroidConfigVar.getArmScaleX();
        this.f1347J.scaleY = aAndroidConfigVar.getArmScaleY();
        this.f1348K.scaleX = aAndroidConfigVar.getLegScaleX();
        this.f1348K.scaleY = aAndroidConfigVar.getLegScaleY();
        m1827n();
        m1828o();
        m1853c();
    }

    public void m1845a(StructOfFloats aStructOfFloatsVar) {
        this.aa = aStructOfFloatsVar;
        m1826a((aStructOfFloatsVar.f1640f * (Constants.POINT_TO_REF_5.y - Constants.POINT_TO_REF_3.y)) * Util.performance(this.ai, 1.0f), aStructOfFloatsVar.f1642h, aStructOfFloatsVar.f1641g);
    }

    public void m1846a(boolean z) {
        switch (z ? f1337a.nextInt(6) : f1337a.nextInt(4) + 1) {
            case cm.HListView_android_entries /*0*/:
                m1863l();
            case cm.HListView_android_divider /*1*/:
                m1862k();
            case cm.HListView_hlv_dividerWidth /*2*/:
                m1861j();
            case cm.HListView_hlv_headerDividersEnabled /*3*/:
                m1860i();
            case cm.HListView_hlv_footerDividersEnabled /*4*/:
                m1859h();
            case cm.HListView_hlv_overScrollHeader /*5*/:
                m1858g();
            default:
        }
    }

    public float m1847b() {
        return this.f1353P;
    }

    public void m1848b(float f) {
        this.f1368f = f;
    }

    public void m1849b(int i) {
        m1836a((16711680 & i) >> 16, (65280 & i) >> 8, i & 255);
    }

    public void m1850b(AnimationType aAnimationTypeVar) {
        this.f1369g.remove(aAnimationTypeVar.toString());
    }

    public void m1851b(boolean z) {
        this.ac.m1621a(z);
        this.ad.m1621a(z);
    }

    protected float m1852c(int i) {
        return this.f1339B.m1640a(i);
    }

    public void m1853c() {
        com.google.android.Util.debug("Rescaling for w: " + m1830a() + ", h: " + m1847b());
        float f = this.f1346I.scaleX * (Constants.POINT_RIGHT_BOTTOM_OF_HEAD.x - Constants.POINT_LEFT_BOTTOM_OF_HEAD.x);
        this.f1355R = Math.max(((Constants.POINT_TOP_LEFT_OF_BODY.x - Constants.POINT_LEFT_OF_LEFT_SHOULDER.x) * this.f1345H.scaleX) + (((Constants.POINT_LEFT_OF_LEFT_SHOULDER.x - Constants.POINT_TO_REF_19.x) * 2.0f) * this.f1347J.scaleX), f);
        float min = Math.min(Constants.f1211v, this.f1356S.top);
        SVG SVG = this.f1384v == null ? null : this.f1384v.f1391c;
        if (!(SVG == null || SVG.scale == 0)) {
            min = Math.min(min, SVG.scale);
        }
        min = ((Constants.POINT_TO_REF_2.y - min) * this.f1346I.scaleY) + (Constants.POINT_TOP_OF_BODY.y - Constants.POINT_TO_REF_2.y);
        float f2 = (Constants.POINT_TO_REF_2.y - ((Constants.POINT_TO_REF_2.y - Constants.f1211v) * this.f1346I.scaleY)) + (Constants.POINT_TOP_OF_BODY.y - Constants.POINT_TO_REF_2.y);
        f2 = (Constants.POINT_TO_REF_2.y - ((Constants.POINT_TO_REF_2.y - this.f1356S.top) * this.f1346I.scaleY)) + (Constants.POINT_TOP_OF_BODY.y - Constants.POINT_TO_REF_2.y);
        f2 = (Constants.POINT_TO_REF_13.y - Constants.POINT_TOP_OF_BODY.y) * this.f1345H.scaleY;
        this.f1343F = ((Constants.POINT_TO_REF_35.y - Constants.POINT_TO_REF_13.y) * this.f1348K.scaleY) + ((Constants.POINT_TO_REF_34.y - Constants.POINT_TO_REF_35.y) * this.f1348K.scaleX);
        float f3 = ((this.f1356S.bottom - Constants.POINT_TO_REF_2.y) * this.f1346I.scaleY) - f2;
        if (f3 > this.f1343F) {
            this.f1343F = f3;
        }
        m1829p();
        f3 = (min + f2) + this.f1343F;
        this.f1342E.set(Constants.POINT_CENTER_OF_BODY.x - (this.f1355R / 2.0f), Constants.POINT_TOP_OF_BODY.y - min, Constants.POINT_CENTER_OF_BODY.x + (this.f1355R / 2.0f), (f2 + Constants.POINT_TOP_OF_BODY.y) + this.f1343F);
        this.f1344G.set((this.f1342E.left + this.f1342E.right) / 2.0f, (this.f1342E.top + this.f1342E.bottom) / 2.0f);
        this.f1355R *= 1.15f;
        min = f3 * 1.15f;
        if (this.aa == null) {
            f2 = m1830a();
            this.f1367e = Math.min(f2 / this.f1355R, m1847b() / min) * this.f1368f;
            this.f1340C = new Matrix();
            this.f1340C.preTranslate((f2 / 2.0f) - this.f1344G.x, (m1847b() / 2.0f) - this.f1344G.y);
            this.f1340C.preScale(this.f1367e, this.f1367e, this.f1344G.x, this.f1344G.y);
        } else {
            this.f1340C = new Matrix();
            f2 = Constants.POINT_TO_REF_5.y - Constants.POINT_TO_REF_3.y;
            min = (this.aa.f1639e ? ((Constants.POINT_TO_REF_7.x - 250.0f) * this.f1346I.scaleX) + 250.0f : ((Constants.POINT_TO_REF_8.x - 250.0f) * this.f1346I.scaleX) + 250.0f) + (this.aa.f1636b * f2);
            f2 = (f2 * this.aa.f1637c) + (Constants.POINT_TO_REF_2.y + ((Constants.POINT_TO_REF_7.y - Constants.POINT_TO_REF_2.y) * this.f1346I.scaleY));
            this.f1340C.preTranslate((m1830a() / 2.0f) - min, (m1847b() / 2.0f) - f2);
            this.f1367e = ((this.f1354Q * this.aa.f1635a) / f) * this.f1368f;
            this.f1340C.preScale(this.f1367e, this.f1367e, min, f2);
            this.f1340C.preRotate((float) this.aa.f1638d, min, f2);
        }
        this.f1340C.invert(this.f1341D);
        this.f1340C.mapPoints(new float[]{Constants.POINT_TOP_OF_BODY.x, Constants.POINT_TOP_OF_BODY.y});
        this.f1365c = Constants.POINT_TOP_OF_BODY.y + (((Constants.POINT_TO_REF_13.y - Constants.POINT_TOP_OF_BODY.y) * this.f1345H.scaleY) + ((Constants.POINT_TO_REF_35.y - Constants.POINT_TO_REF_13.y) * this.f1348K.scaleY));
        this.f1366d = Constants.POINT_TOP_OF_BODY.y + ((Constants.POINT_TO_REF_24.y - Constants.POINT_TO_REF_18.y) * this.f1347J.scaleY);
        com.google.android.Util.debug("Scale factor: " + this.f1367e);
    }

    public void m1854c(float f) {
        this.ac.f1065R = f;
        this.ad.f1065R = f;
    }

    public void m1855d() {
        this.f1367e = -1.0f;
    }

    public void m1856e() {
        this.f1339B.m1641a();
//        for (AndAnimation a : this.f1369g.values()) {
//            a.step();
//        }
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
        andAnimationVar.interpolate(c0205b, 0.0f, Constants.POINT_TO_REF_2.y - Constants.POINT_TOP_OF_BODY.y);
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
        andAnimationVar.interpolate(c0205b, 0.0f, Constants.POINT_TOP_OF_BODY.y - Constants.POINT_TO_REF_2.y);
        m1843a(andAnimationVar);
    }

    public void m1860i() {
        AndAnimation andAnimationVar = new AndAnimation(AnimationType.HEAD_TILT, 1000);
        AndInterpolator c0205b = new AndInterpolator(0.0f, 0.0f);
        c0205b.nextPoint(0.2f, 1.0f);
        c0205b.nextPoint(0.8f, 1.0f);
        andAnimationVar.interpolate(c0205b, 0.0f, f1337a.nextBoolean() ? 8.0f : -8.0f);
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
        if (this.f1385w == null || !this.f1385w.f1389a.equals("head")) {
            this.f1364b[1] = null;
        } else {
            this.f1364b[1] = this.f1385w.f1391c.getPicture();
        }
        if (this.f1384v == null || !this.f1384v.f1389a.equals("head")) {
            this.f1364b[0] = null;
        } else {
            this.f1364b[0] = this.f1384v.f1391c.getPicture();
        }
        return this.f1364b;
    }
}
