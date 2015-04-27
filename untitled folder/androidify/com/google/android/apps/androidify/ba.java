package com.google.android.apps.androidify;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.google.android.C0176a;
import com.google.android.apps.androidify.p018a.C0205b;
import com.google.android.apps.androidify.p018a.C0208e;
import com.google.android.apps.androidify.p018a.C0211h;
import com.google.android.apps.androidify.p018a.C0213j;
import com.google.android.apps.androidify.p018a.C0214k;
import com.google.android.apps.androidify.p018a.C0215l;
import com.google.android.apps.p019b.C0249b;
import com.google.android.apps.p019b.C0250c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public class ba {
    static final Random f1337a;
    private C0214k f1338A;
    private ae f1339B;
    private Matrix f1340C;
    private Matrix f1341D;
    private RectF f1342E;
    private float f1343F;
    private PointF f1344G;
    private ch f1345H;
    private ch f1346I;
    private ch f1347J;
    private ch f1348K;
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
    private dp aa;
    private float ab;
    private C0213j ac;
    private C0213j ad;
    private int ae;
    private ci af;
    private Matrix ag;
    private RectF ah;
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

    public ba(Context context) {
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
        this.f1356S = al.f1212w;
        this.f1357T = new RectF();
        this.f1361X = 255;
        this.f1362Y = 255;
        this.f1363Z = 255;
        this.aa = null;
        this.ac = new C0213j();
        this.ad = new C0213j();
        this.ae = 255;
        this.af = new ci();
        this.ag = new Matrix();
        this.ah = new RectF(al.f1203n.x - al.f1210u, 0.0f, al.f1203n.x + al.f1210u, 0.0f);
        this.aj = new float[2];
        this.f1364b = new Picture[2];
        this.ai = context;
        ah a = ah.m1648a(context);
        Picture picture = a.m1657a((int) R.raw.android_body).f1708a;
        Picture picture2 = a.m1657a((int) R.raw.android_head).f1708a;
        Picture picture3 = a.m1657a((int) R.raw.android_antenna).f1708a;
        Picture picture4 = a.m1657a((int) R.raw.android_arm).f1708a;
        Picture picture5 = a.m1657a((int) R.raw.android_leg).f1708a;
        this.f1349L = a.m1657a((int) R.raw.android_foot).f1708a;
        this.f1350M = picture3;
        this.f1345H = new ch(picture);
        this.f1346I = new ch(picture2);
        this.f1347J = new ch(picture4);
        this.f1348K = new ch(picture5);
        this.f1342E = new RectF();
        this.f1344G = new PointF();
        this.f1388z = C0250c.m2015a("M140.396,175.489v177.916c0,10.566,8.566,19.133,19.135,19.133h2.303h20.331h48.709h37.371h48.708h11.881h10.752c10.569,0,19.137-8.562,19.137-19.133V175.489H140.396z");
        this.f1341D = new Matrix();
        this.f1358U = new Paint();
        this.f1358U.setAntiAlias(true);
        this.f1351N = new Path();
        m1829p();
        this.f1369g = new HashMap();
        this.f1339B = new ae();
    }

    private static Picture m1825a(C0249b c0249b) {
        return c0249b == null ? null : c0249b.f1708a;
    }

    private void m1826a(float f, int i, long j) {
        m1850b(ay.DRIFT);
        this.ab = (float) ((((double) i) * 3.141592653589793d) / 180.0d);
        ax axVar = new ax(ay.DRIFT, j);
        axVar.m1755a(new LinearInterpolator(), 0.0f, f);
        m1843a(axVar);
    }

    private void m1827n() {
        this.f1347J.f1503d = (-(al.f1215z.x - al.f1164A.x)) * (this.f1345H.f1501b - 1.0f);
        ch chVar = this.f1347J;
        chVar.f1503d -= (al.f1174K.x - al.f1173J.x) * (this.f1347J.f1501b - 1.0f);
    }

    private void m1828o() {
        this.f1348K.f1504e = ((al.f1166C.y - al.f1215z.y) * (this.f1345H.f1502c - 1.0f)) - 10.0f;
    }

    private void m1829p() {
        this.f1351N.rewind();
        float f = (al.f1174K.x - al.f1173J.x) * this.f1347J.f1501b;
        float f2 = (al.f1170G.y - al.f1168E.y) * this.f1347J.f1502c;
        float f3 = f / 2.0f;
        float f4 = f3 * 0.5522848f;
        this.f1351N.moveTo(al.f1173J.x, al.f1168E.y + f3);
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
        return (this.f1384v == null || !this.f1384v.f1389a.equals(str) || this.f1384v.f1391c == null) ? (this.f1385w == null || !this.f1385w.f1389a.equals(str) || this.f1385w.f1391c == null) ? (this.f1386x == null || !this.f1386x.f1389a.equals(str) || this.f1386x.f1391c == null) ? (this.f1387y == null || !this.f1387y.f1389a.equals(str) || this.f1387y.f1391c == null) ? null : this.f1387y.f1391c.f1708a : this.f1386x.f1391c.f1708a : this.f1385w.f1391c.f1708a : this.f1384v.f1391c.f1708a;
    }

    public ax m1832a(ay ayVar) {
        return (ax) this.f1369g.get(ayVar.toString());
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
                if (((ax) it.next()).m1756a()) {
                    it.remove();
                }
            }
        }
        ax a = m1832a(ay.HEAD_TILT);
        ax a2 = m1832a(ay.NOD);
        ax a3 = m1832a(ay.DRIFT);
        if (a3 != null) {
            canvas.translate((float) (Math.cos((double) this.ab) * ((double) a3.m1760e())), (float) (Math.sin((double) this.ab) * ((double) a3.m1760e())));
        }
        canvas.concat(this.f1340C);
        C0214k c0214k = null;
        if (this.f1338A != null && this.f1338A.f1098b == C0215l.MASTER) {
            c0214k = this.f1338A;
        }
        if (c0214k != null) {
            C0249b a4 = c0214k.m1623a(this.ai, 0);
            canvas.save();
            canvas.translate(this.ac.f1056I + al.f1167D.x, this.ac.f1057J + al.f1167D.y);
            canvas.scale(this.ac.f1063P, this.ac.f1062O, a4.f1710c.centerX(), a4.f1710c.centerY());
            canvas.drawPicture(a4.f1708a);
            canvas.restore();
        }
        canvas.rotate(this.ac.f1080k, al.f1167D.x, al.f1167D.y);
        canvas.translate(this.ac.f1048A, (((this.ac.f1049B * 0.29615164f) * this.f1345H.f1502c) + ((this.ac.f1049B * 0.70384836f) * this.f1348K.f1502c)) * 0.3f);
        canvas.scale(this.ac.f1064Q, 1.0f, al.f1167D.x, al.f1167D.y);
        c0214k = null;
        if (this.f1338A != null && this.f1338A.f1098b == C0215l.BALL) {
            c0214k = this.f1338A;
        }
        canvas.save();
        canvas.rotate(this.ac.f1079j, al.f1167D.x, al.f1167D.y);
        canvas.translate(this.ac.f1094y, this.ac.f1095z);
        canvas.rotate(this.ac.f1078i, al.f1196g.x, al.f1196g.y);
        canvas.translate(this.ac.f1092w, this.ac.f1093x);
        if (a != null) {
            canvas.rotate(a.m1760e(), al.f1196g.x, al.f1196g.y);
        }
        if (a2 != null) {
            canvas.translate(0.0f, a2.m1760e());
        }
        canvas.scale(this.f1346I.f1501b, this.f1346I.f1502c, al.f1196g.x, al.f1196g.y);
        if (this.f1377o != null) {
            this.f1377o.draw(canvas);
        }
        if (this.f1379q != null) {
            this.f1379q.draw(canvas);
        }
        canvas.restore();
        int i = 0;
        while (i < 2) {
            float f3 = i == 0 ? this.ac.f1072c : this.ac.f1073d;
            float f4 = i == 0 ? this.ac.f1088s : this.ac.f1090u;
            float f5 = i == 0 ? this.ac.f1089t : this.ac.f1091v;
            canvas.save();
            if (i == 1) {
                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
            }
            canvas.translate(this.f1348K.f1503d, this.f1348K.f1504e);
            canvas.rotate(f3, 250.0f + ((al.ac.x - 250.0f) * this.f1348K.f1501b), al.f1186W.y);
            canvas.translate(f4, f5);
            canvas.scale(this.f1348K.f1501b, this.f1348K.f1502c, al.f1166C.x, al.f1166C.y);
            this.f1348K.f1500a.draw(canvas);
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
            canvas.rotate(f3, 250.0f + ((al.ac.x - 250.0f) * this.f1348K.f1501b), al.f1186W.y);
            canvas.translate(f4, f5);
            canvas.scale(this.f1348K.f1501b, this.f1348K.f1502c, al.f1166C.x, al.f1166C.y);
            canvas.save();
            canvas.scale(1.0f, this.f1348K.f1501b / this.f1348K.f1502c, 250.0f, al.aa.y);
            this.f1349L.draw(canvas);
            canvas.restore();
            if (this.f1374l != null) {
                this.f1374l.draw(canvas);
            }
            canvas.save();
            canvas.scale(1.0f, this.f1348K.f1501b / this.f1348K.f1502c, i == 0 ? al.f1186W.x : al.f1187X.x, al.f1166C.y);
            if (this.f1376n != null) {
                this.f1376n.draw(canvas);
            }
            canvas.restore();
            canvas.restore();
            i++;
        }
        canvas.restore();
        canvas.save();
        canvas.rotate(this.ac.f1079j, al.f1167D.x, al.f1167D.y);
        canvas.translate(this.ac.f1094y, this.ac.f1095z);
        canvas.save(1);
        canvas.scale(this.f1345H.f1501b, this.f1345H.f1502c, al.f1215z.x, al.f1215z.y);
        canvas.clipPath(this.f1388z);
        this.f1345H.f1500a.draw(canvas);
        canvas.restore();
        if (this.f1370h != null) {
            f5 = Math.max(this.f1345H.f1501b, this.f1345H.f1502c);
            if (f5 < 1.2f) {
                canvas.scale(f5 / 1.2f, f5 / 1.2f, al.f1215z.x, al.f1215z.y);
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
                canvas.rotate(f3, 250.0f + ((al.ac.x - 250.0f) * this.f1348K.f1501b), al.f1186W.y);
                canvas.translate(f4, f5);
                canvas.scale(this.f1348K.f1501b, this.f1348K.f1502c, al.f1166C.x, al.f1166C.y);
                canvas.scale(1.0f, this.f1348K.f1501b / this.f1348K.f1502c, 250.0f, al.aa.y);
                if (i == 0 && this.ac.f1074e != 0.0f) {
                    canvas.rotate(this.ac.f1074e, al.aa.x, al.aa.y);
                } else if (i == 1 && this.ac.f1075f != 0.0f) {
                    canvas.rotate(this.ac.f1075f, al.aa.x, al.aa.y);
                }
                this.f1381s.draw(canvas);
                canvas.restore();
                i++;
            }
        }
        canvas.restore();
        if (this.f1373k != null) {
            canvas.save();
            canvas.rotate(this.ac.f1079j, al.f1167D.x, al.f1167D.y);
            canvas.translate(this.ac.f1094y, this.ac.f1095z);
            canvas.scale(this.f1345H.f1501b, this.f1345H.f1502c, al.f1215z.x, al.f1215z.y);
            this.f1373k.draw(canvas);
            canvas.restore();
        }
        if (this.f1375m != null) {
            canvas.save();
            canvas.rotate(this.ac.f1079j, al.f1167D.x, al.f1167D.y);
            canvas.translate(this.ac.f1094y, this.ac.f1095z);
            canvas.scale(this.f1345H.f1501b, this.f1345H.f1502c, al.f1215z.x, al.f1215z.y);
            this.f1375m.draw(canvas);
            canvas.restore();
        }
        Picture a5 = m1831a("body");
        if (this.f1372j != null) {
            canvas.save();
            canvas.rotate(this.ac.f1079j, al.f1167D.x, al.f1167D.y);
            canvas.translate(this.ac.f1094y, this.ac.f1095z);
            canvas.scale(this.f1345H.f1501b, this.f1345H.f1502c, al.f1215z.x, al.f1215z.y);
            if (this.f1372j != null) {
                this.f1372j.draw(canvas);
            }
            canvas.restore();
        }
        if (a5 != null) {
            canvas.save();
            canvas.rotate(this.ac.f1079j, al.f1167D.x, al.f1167D.y);
            canvas.translate(this.ac.f1094y, this.ac.f1095z);
            f4 = Math.min(this.f1345H.f1501b, this.f1345H.f1502c);
            canvas.scale(f4, f4, al.f1215z.x, al.f1215z.y);
            if (a5 != null) {
                a5.draw(canvas);
            }
            canvas.restore();
        }
        Picture a6 = m1831a("face");
        canvas.save();
        canvas.rotate(this.ac.f1079j, al.f1167D.x, al.f1167D.y);
        canvas.translate(this.ac.f1094y, this.ac.f1095z);
        if (a != null) {
            canvas.rotate(a.m1760e(), al.f1196g.x, al.f1196g.y);
        }
        canvas.rotate(this.ac.f1078i, al.f1196g.x, al.f1196g.y);
        canvas.translate(this.ac.f1092w, this.ac.f1093x);
        if (a2 != null) {
            canvas.translate(0.0f, a2.m1760e());
        }
        canvas.scale(this.f1346I.f1501b, this.f1346I.f1502c, al.f1196g.x, al.f1196g.y);
        this.f1346I.f1500a.draw(canvas);
        Picture a7 = m1831a("earring");
        for (int i2 = 0; i2 < 2; i2++) {
            canvas.save();
            if (i2 == 1) {
                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
            }
            if (this.f1346I.f1501b > this.f1346I.f1502c) {
                canvas.scale(1.0f, this.f1346I.f1501b / this.f1346I.f1502c, al.f1205p.x, al.f1205p.y);
            } else {
                canvas.scale(this.f1346I.f1502c / this.f1346I.f1501b, 1.0f, al.f1205p.x, al.f1205p.y);
            }
            ax a8 = m1832a(ay.ANTENNA_TWITCH);
            if (a8 != null) {
                canvas.rotate(a8.m1760e(), al.f1205p.x, al.f1205p.y);
            } else {
                canvas.rotate(m1852c(i2), al.f1205p.x, al.f1205p.y);
            }
            if (i2 == 0 && this.ac.f1076g != 0.0f) {
                canvas.rotate(this.ac.f1076g, al.f1205p.x, al.f1205p.y);
            } else if (i2 == 1 && this.ac.f1077h != 0.0f) {
                canvas.rotate(this.ac.f1077h, al.f1205p.x, al.f1205p.y);
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
            if (this.f1346I.f1501b < this.f1346I.f1502c) {
                canvas.scale(1.0f, this.f1346I.f1501b / this.f1346I.f1502c, al.f1203n.x, al.f1203n.y);
            } else {
                canvas.scale(this.f1346I.f1502c / this.f1346I.f1501b, 1.0f, al.f1203n.x, al.f1203n.y);
            }
            if (i == 0 && this.ac.f1058K != 1.0f) {
                canvas.scale(this.ac.f1058K, this.ac.f1058K, al.f1203n.x, al.f1203n.y);
            } else if (i == 1 && this.ac.f1059L != 1.0f) {
                canvas.scale(this.ac.f1059L, this.ac.f1059L, al.f1203n.x, al.f1203n.y);
            }
            if (i == 0 && this.ac.f1081l != 0.0f) {
                canvas.rotate(this.ac.f1081l, al.f1203n.x, al.f1203n.y);
            } else if (i == 1 && this.ac.f1082m != 0.0f) {
                canvas.rotate(this.ac.f1082m, al.f1203n.x, al.f1203n.y);
            }
            f3 = i == 0 ? this.ac.f1052E : this.ac.f1054G;
            f4 = i == 0 ? this.ac.f1053F : this.ac.f1055H;
            f5 = i == 0 ? this.ac.f1060M : this.ac.f1061N;
            this.ah.left = (al.f1203n.x - al.f1210u) + f3;
            this.ah.right = f3 + (al.f1203n.x + al.f1210u);
            this.ah.top = by.m1898a(f5, 0.0f, 1.0f, al.f1203n.y, al.f1199j.y) + f4;
            this.ah.bottom = by.m1898a(f5, 0.0f, 1.0f, al.f1203n.y, al.f1201l.y) + f4;
            canvas.clipRect(this.ah);
            canvas.drawCircle(al.f1203n.x, al.f1203n.y, al.f1203n.y - al.f1199j.y, this.f1358U);
            canvas.restore();
            i++;
        }
        canvas.restore();
        canvas.restore();
        if (!this.ac.f1067T) {
            m1840a(canvas, a, a2);
        }
        if (c0214k != null) {
            C0249b a9 = c0214k.m1623a(this.ai, 0);
            canvas.save();
            canvas.translate(this.ac.f1056I + al.f1167D.x, by.m1898a(this.ac.f1057J, this.ac.f1068U.m1610b(C0211h.PROP_POSITION_Y), this.ac.f1068U.m1603a(C0211h.PROP_POSITION_Y), this.f1366d - 25.0f, this.f1365c - 80.0f) + c0214k.f1103g);
            canvas.scale(this.ac.f1063P, this.ac.f1062O, a9.f1710c.centerX(), a9.f1710c.centerY());
            canvas.drawPicture(a9.f1708a);
            canvas.restore();
        }
        float f6 = this.f1347J.f1503d;
        float f7 = this.f1347J.f1501b;
        Picture picture = this.f1371i;
        int i3 = 0;
        while (i3 < 2) {
            C0214k c0214k2 = null;
            if (this.f1338A != null && (this.f1338A.f1098b == C0215l.LEFT_ARM || this.f1338A.f1098b == C0215l.RIGHT_ARM_UNDER)) {
                c0214k2 = this.f1338A;
            }
            canvas.save();
            float f8 = i3 == 0 ? this.ac.f1070a : this.ac.f1071b;
            f3 = i3 == 0 ? this.ac.f1084o : this.ac.f1086q;
            f4 = i3 == 0 ? this.ac.f1085p : this.ac.f1087r;
            canvas.rotate(this.ac.f1079j, al.f1167D.x, al.f1167D.y);
            canvas.translate(this.ac.f1094y, this.ac.f1095z);
            a8 = m1832a(ay.SHRUG);
            if (a8 != null) {
                canvas.translate(0.0f, a8.m1760e());
            }
            if (i3 == 1) {
                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
            }
            canvas.translate(f6, this.f1347J.f1504e);
            if (i3 == 0) {
                a8 = m1832a(ay.WAVE);
                if (a8 != null) {
                    canvas.rotate(a8.m1760e(), al.f1168E.x, al.f1168E.y);
                }
            }
            canvas.rotate(f8, al.f1173J.x + (((al.f1174K.x - al.f1173J.x) * f7) / 2.0f), al.f1168E.y + ((al.f1172I.y - al.f1168E.y) * f7));
            canvas.translate(f3, f4);
            if (c0214k2 != null && c0214k2.f1098b == C0215l.RIGHT_ARM_UNDER && i3 == 1) {
                m1839a(canvas, f7, c0214k2, -2.0f * f8);
            }
            if (this.ac.f1067T) {
                this.f1358U.setColor(this.f1359V);
            } else {
                this.f1358U.setColor(this.f1360W);
            }
            canvas.drawPath(this.f1351N, this.f1358U);
            Picture a10 = m1831a(i3 == 0 ? "onlefthand" : "onrighthand");
            a6 = m1831a(i3 == 0 ? "inlefthand" : "inrighthand");
            if (!(c0214k == null && c0214k2 == null)) {
                a6 = null;
            }
            Picture a11 = c0214k != null ? null : m1831a("onbothhands");
            a7 = i3 == 0 ? m1831a("arm") : null;
            Picture a12 = m1831a("sleeve");
            if (picture != null || a10 != null || a6 != null || a11 != null || c0214k2 != null || a7 != null || a12 != null) {
                canvas.save();
                canvas.translate((al.f1172I.x - al.f1173J.x) * (f7 - 1.0f), 0.0f);
                canvas.scale(f7, f7, al.f1172I.x, al.f1168E.y);
                this.f1357T.set(-20000.0f, -20000.0f, 20000.0f, al.f1172I.y);
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
                f3 = (((al.f1178O.y - al.f1172I.y) * this.f1347J.f1502c) - (((al.f1172I.y - al.f1168E.y) * (f7 - this.f1347J.f1502c)) * 2.0f)) / (al.f1178O.y - al.f1172I.y);
                canvas.save();
                canvas.translate((al.f1172I.x - al.f1173J.x) * (f7 - 1.0f), 0.0f);
                canvas.scale(f7, this.f1347J.f1502c, al.f1168E.x, al.f1168E.y);
                canvas.scale(1.0f, f3 / this.f1347J.f1502c, al.f1180Q.x, al.f1180Q.y);
                this.f1357T.set(-20000.0f, al.f1172I.y, 20000.0f, al.f1178O.y);
                canvas.clipRect(this.f1357T);
                if (a12 != null) {
                    a12.draw(canvas);
                }
                if (picture != null) {
                    picture.draw(canvas);
                }
                canvas.restore();
                canvas.save();
                canvas.translate((al.f1172I.x - al.f1173J.x) * (f7 - 1.0f), 0.0f);
                canvas.scale(f7, this.f1347J.f1502c, al.f1172I.x, al.f1168E.y);
                canvas.scale(1.0f, f7 / this.f1347J.f1502c, al.f1170G.x, al.f1170G.y);
                this.f1357T.set(-20000.0f, al.f1178O.y, 20000.0f, 20000.0f);
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
                    canvas.translate((al.f1172I.x - al.f1173J.x) * (f7 - 1.0f), 0.0f);
                    canvas.translate(0.0f, (al.f1170G.y - al.f1168E.y) * (this.f1347J.f1502c - 1.0f));
                    canvas.scale(f7, f7, al.f1170G.x, al.f1170G.y);
                    if (a11 != null) {
                        a11.draw(canvas);
                    }
                    if (a10 != null) {
                        a10.draw(canvas);
                    }
                    if (a6 != null) {
                        canvas.save();
                        canvas.rotate(-f8, al.f1178O.x, al.f1178O.y);
                        a6.draw(canvas);
                        canvas.restore();
                    }
                    canvas.restore();
                }
                if (c0214k2 != null && c0214k2.f1098b == C0215l.LEFT_ARM && i3 == 0) {
                    m1839a(canvas, f7, c0214k2, 0.0f);
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
            canvas.rotate(this.ac.f1079j, al.f1167D.x, al.f1167D.y);
            canvas.translate(this.ac.f1094y, this.ac.f1095z);
            if (i4 == 1) {
                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
            }
            float f10 = al.f1173J.x + (((al.f1174K.x - al.f1173J.x) * this.f1347J.f1501b) / 2.0f);
            f8 = al.f1168E.y + ((al.f1172I.y - al.f1168E.y) * this.f1347J.f1501b);
            canvas.translate(this.f1347J.f1503d, this.f1347J.f1504e);
            canvas.rotate(f4, f10, f8);
            canvas.translate(f5, f9);
            Picture a13 = m1831a(i4 == 0 ? "leftshoulder" : "rightshoulder");
            if (a13 != null) {
                canvas.save();
                canvas.translate((al.f1172I.x - al.f1173J.x) * (this.f1347J.f1501b - 1.0f), 0.0f);
                canvas.scale(this.f1347J.f1501b, this.f1347J.f1501b, al.f1172I.x, al.f1168E.y);
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

    public void m1839a(Canvas canvas, float f, C0214k c0214k, float f2) {
        C0249b a = c0214k.m1623a(this.ai, this.f1360W);
        if (a != null) {
            canvas.save();
            Picture picture = a.f1708a;
            canvas.translate(al.f1172I.x - (((float) picture.getWidth()) / 2.0f), al.f1172I.y - (((float) picture.getHeight()) / 2.0f));
            canvas.translate((al.f1172I.x - al.f1173J.x) * (f - 1.0f), 0.0f);
            canvas.translate(this.ac.f1056I * (f / 0.92f), this.ac.f1057J * (this.f1347J.f1502c / 1.15f));
            canvas.rotate(c0214k.f1098b == C0215l.RIGHT_ARM_UNDER ? -this.ac.f1083n : this.ac.f1083n, ((float) picture.getWidth()) / 2.0f, ((float) picture.getHeight()) / 2.0f);
            canvas.scale((this.ac.f1063P * f) / 0.92f, (this.ac.f1062O * f) / 0.92f, ((float) picture.getWidth()) / 2.0f, ((float) picture.getHeight()) / 2.0f);
            canvas.drawPicture(picture);
            canvas.restore();
        }
    }

    public void m1840a(Canvas canvas, ax axVar, ax axVar2) {
        int i = 0;
        Picture[] m = m1864m();
        Picture a = m1831a("mouth");
        Picture a2 = m1831a("hat");
        canvas.save();
        canvas.rotate(this.ac.f1079j, al.f1167D.x, al.f1167D.y);
        canvas.translate(this.ac.f1094y, this.ac.f1095z);
        canvas.rotate(this.ac.f1078i, al.f1196g.x, al.f1196g.y);
        canvas.translate(this.ac.f1092w, this.ac.f1093x);
        if (axVar != null) {
            canvas.rotate(axVar.m1760e(), al.f1196g.x, al.f1196g.y);
        }
        if (axVar2 != null) {
            canvas.translate(0.0f, axVar2.m1760e());
        }
        canvas.scale(this.f1346I.f1501b, this.f1346I.f1502c, al.f1196g.x, al.f1196g.y);
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
            canvas.scale(1.0f, this.f1346I.f1501b / this.f1346I.f1502c, al.f1196g.x, al.f1203n.y);
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
        C0214k c0214k = null;
        if (this.f1338A != null && this.f1338A.f1098b == C0215l.HEAD) {
            c0214k = this.f1338A;
        }
        if (c0214k != null) {
            C0249b a3 = c0214k.m1623a(this.ai, this.f1360W);
            if (a3 != null) {
                if (c0214k.f1102f) {
                    canvas.save();
                    Picture picture = a3.f1708a;
                    canvas.translate(this.ac.f1050C, this.ac.f1051D);
                    while (i < 2) {
                        canvas.save();
                        if (i == 1) {
                            canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
                        }
                        canvas.translate(al.f1203n.x - (((float) picture.getWidth()) / 2.0f), al.f1203n.y - (((float) picture.getHeight()) / 2.0f));
                        canvas.rotate(this.ac.f1083n, ((float) picture.getWidth()) / 2.0f, ((float) picture.getHeight()) / 2.0f);
                        canvas.scale(this.ac.f1063P, this.ac.f1062O, ((float) picture.getWidth()) / 2.0f, ((float) picture.getHeight()) / 2.0f);
                        canvas.drawPicture(picture);
                        canvas.restore();
                        i++;
                    }
                    canvas.restore();
                } else {
                    canvas.save();
                    Picture picture2 = a3.f1708a;
                    canvas.translate(al.f1196g.x - (((float) picture2.getWidth()) / 2.0f), al.f1196g.y - (((float) picture2.getHeight()) / 2.0f));
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

    public void m1841a(C0208e c0208e, double d) {
        this.ac.m1620a(c0208e, null, 1.0f, d, this.f1367e);
        this.f1338A = c0208e.m1612c();
    }

    public void m1842a(C0208e c0208e, double d, C0208e c0208e2, double d2, float f) {
        if (c0208e2 == null) {
            this.ac.f1066S = false;
            m1841a(c0208e, d);
            return;
        }
        C0214k c = c0208e2.m1612c();
        C0214k c2 = c0208e.m1612c();
        if (!(c == null || c2 == null || !c.f1097a.equals(c2.f1097a))) {
            this.ac.f1066S = true;
        }
        this.ad.m1620a(c0208e2, null, 1.0f, d2, this.f1367e);
        this.ac.m1620a(c0208e, this.ad, f, d, this.f1367e);
        this.f1338A = c0208e.m1612c();
    }

    public void m1843a(ax axVar) {
        this.f1369g.put(axVar.m1757b().toString(), axVar);
    }

    public void m1844a(az azVar, ah ahVar) {
        C0249b a;
        ag h;
        int s = azVar.m1817s();
        this.f1359V = azVar.m1818t();
        if (this.f1359V == this.ai.getResources().getColor(R.color.gray_android)) {
            this.f1360W = this.ai.getResources().getColor(R.color.gray_arm_android);
        } else {
            this.f1360W = al.m1693a(this.f1359V);
        }
        this.f1346I.f1500a = ahVar.m1658a((int) R.raw.android_head, al.f1191b, Integer.valueOf(this.f1359V)).f1708a;
        this.f1345H.f1500a = ahVar.m1658a((int) R.raw.android_body, al.f1191b, Integer.valueOf(this.f1359V)).f1708a;
        this.f1348K.f1500a = ahVar.m1658a((int) R.raw.android_leg, al.f1191b, Integer.valueOf(this.f1359V)).f1708a;
        this.f1349L = ahVar.m1658a((int) R.raw.android_foot, al.f1191b, Integer.valueOf(this.f1359V)).f1708a;
        this.f1350M = ahVar.m1658a((int) R.raw.android_antenna, al.f1191b, Integer.valueOf(this.f1359V)).f1708a;
        String e = azVar.m1796e();
        if (e != null) {
            C0249b a2 = ahVar.m1663a("hair", e, "back", al.f1190a, Integer.valueOf(s));
            this.f1377o = m1825a(a2);
            a = ahVar.m1663a("hair", e, "front", al.f1190a, Integer.valueOf(s));
            this.f1378p = m1825a(a);
            C0249b a3 = ahVar.m1662a("hair", e, "backextra");
            this.f1379q = m1825a(a3);
            C0249b a4 = ahVar.m1662a("hair", e, "frontextra");
            this.f1380r = m1825a(a4);
            this.f1356S = new RectF(al.f1212w);
            if (!(a2 == null || a2.f1710c == null)) {
                this.f1356S.union(a2.f1710c);
            }
            if (!(a == null || a.f1710c == null)) {
                this.f1356S.union(a.f1710c);
            }
            if (!(a3 == null || a3.f1710c == null)) {
                this.f1356S.union(a3.f1710c);
            }
            if (!(a4 == null || a4.f1710c == null)) {
                this.f1356S.union(a4.f1710c);
            }
        } else {
            this.f1377o = null;
            this.f1378p = null;
            this.f1379q = null;
            this.f1380r = null;
            this.f1356S = al.f1212w;
        }
        String f = azVar.m1799f();
        if (f != null) {
            this.f1370h = m1825a(ahVar.m1662a("shirt", f, "body"));
            this.f1371i = m1825a(ahVar.m1662a("shirt", f, "arm"));
            this.f1372j = m1825a(ahVar.m1662a("shirt", f, "top"));
            this.f1373k = m1825a(ahVar.m1662a("shirt", f, "bottom"));
        } else {
            this.f1370h = null;
            this.f1371i = null;
            this.f1372j = null;
            this.f1373k = null;
        }
        f = azVar.m1802g();
        if (f != null) {
            this.f1374l = m1825a(ahVar.m1662a("pants", f, "leg"));
            this.f1375m = m1825a(ahVar.m1662a("pants", f, "skirt"));
            this.f1376n = m1825a(ahVar.m1662a("pants", f, "top"));
        } else {
            this.f1374l = null;
            this.f1375m = null;
            this.f1376n = null;
        }
        f = azVar.m1805h();
        if (f != null) {
            ag e2 = ahVar.m1674e(f);
            if (e2 != null) {
                a = ahVar.m1669b(e2, azVar);
                if (a != null) {
                    this.f1381s = a.f1708a;
                } else {
                    this.f1381s = null;
                }
            } else {
                this.f1381s = null;
            }
        } else {
            this.f1381s = null;
        }
        f = azVar.m1807i();
        if (f != null) {
            this.f1382t = m1825a(ahVar.m1662a("glasses", f, null));
        } else {
            this.f1382t = null;
        }
        e = azVar.m1808j();
        if (e != null) {
            this.f1383u = m1825a(ahVar.m1663a("beard", e, null, al.f1190a, Integer.valueOf(s)));
        } else {
            this.f1383u = null;
        }
        f = azVar.m1821w();
        String v = azVar.m1820v();
        if (v != null) {
            h = ahVar.m1680h(v);
            if (h != null) {
                this.f1384v = new bb(f, v, ahVar.m1669b(h, azVar));
            } else {
                this.f1384v = null;
            }
        } else {
            this.f1384v = null;
        }
        f = azVar.m1823y();
        v = azVar.m1822x();
        if (v != null) {
            h = ahVar.m1682i(v);
            if (h != null) {
                this.f1385w = new bb(f, v, ahVar.m1669b(h, azVar));
            } else {
                this.f1385w = null;
            }
        } else {
            this.f1385w = null;
        }
        f = azVar.m1765A();
        v = azVar.m1824z();
        if (v != null) {
            h = ahVar.m1684j(v);
            if (h != null) {
                this.f1386x = new bb(f, v, ahVar.m1669b(h, azVar));
            } else {
                this.f1386x = null;
            }
        } else {
            this.f1386x = null;
        }
        f = azVar.m1767C();
        v = azVar.m1766B();
        if (v != null) {
            h = ahVar.m1686k(v);
            if (h != null) {
                this.f1387y = new bb(f, v, ahVar.m1669b(h, azVar));
            } else {
                this.f1387y = null;
            }
        } else {
            this.f1387y = null;
        }
        this.f1345H.f1501b = azVar.m1809k();
        this.f1345H.f1502c = azVar.m1810l();
        this.f1346I.f1501b = azVar.m1811m();
        this.f1346I.f1502c = azVar.m1812n();
        this.f1347J.f1501b = azVar.m1813o();
        this.f1347J.f1502c = azVar.m1814p();
        this.f1348K.f1501b = azVar.m1815q();
        this.f1348K.f1502c = azVar.m1816r();
        m1827n();
        m1828o();
        m1853c();
    }

    public void m1845a(dp dpVar) {
        this.aa = dpVar;
        m1826a((dpVar.f1640f * (al.f1201l.y - al.f1199j.y)) * C0220c.m1902a(this.ai, 1.0f), dpVar.f1642h, dpVar.f1641g);
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

    public void m1850b(ay ayVar) {
        this.f1369g.remove(ayVar.toString());
    }

    public void m1851b(boolean z) {
        this.ac.m1621a(z);
        this.ad.m1621a(z);
    }

    protected float m1852c(int i) {
        return this.f1339B.m1640a(i);
    }

    public void m1853c() {
        C0176a.m1106c("Rescaling for w: " + m1830a() + ", h: " + m1847b());
        float f = this.f1346I.f1501b * (al.f1198i.x - al.f1197h.x);
        this.f1355R = Math.max(((al.f1165B.x - al.f1164A.x) * this.f1345H.f1501b) + (((al.f1164A.x - al.f1173J.x) * 2.0f) * this.f1347J.f1501b), f);
        float min = Math.min(al.f1211v, this.f1356S.top);
        C0249b c0249b = this.f1384v == null ? null : this.f1384v.f1391c;
        if (!(c0249b == null || c0249b.f1710c == null)) {
            min = Math.min(min, c0249b.f1710c.top);
        }
        min = ((al.f1196g.y - min) * this.f1346I.f1502c) + (al.f1215z.y - al.f1196g.y);
        float f2 = (al.f1196g.y - ((al.f1196g.y - al.f1211v) * this.f1346I.f1502c)) + (al.f1215z.y - al.f1196g.y);
        f2 = (al.f1196g.y - ((al.f1196g.y - this.f1356S.top) * this.f1346I.f1502c)) + (al.f1215z.y - al.f1196g.y);
        f2 = (al.f1166C.y - al.f1215z.y) * this.f1345H.f1502c;
        this.f1343F = ((al.aa.y - al.f1166C.y) * this.f1348K.f1502c) + ((al.f1188Y.y - al.aa.y) * this.f1348K.f1501b);
        float f3 = ((this.f1356S.bottom - al.f1196g.y) * this.f1346I.f1502c) - f2;
        if (f3 > this.f1343F) {
            this.f1343F = f3;
        }
        m1829p();
        f3 = (min + f2) + this.f1343F;
        this.f1342E.set(al.f1167D.x - (this.f1355R / 2.0f), al.f1215z.y - min, al.f1167D.x + (this.f1355R / 2.0f), (f2 + al.f1215z.y) + this.f1343F);
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
            f2 = al.f1201l.y - al.f1199j.y;
            min = (this.aa.f1639e ? ((al.f1203n.x - 250.0f) * this.f1346I.f1501b) + 250.0f : ((al.f1204o.x - 250.0f) * this.f1346I.f1501b) + 250.0f) + (this.aa.f1636b * f2);
            f2 = (f2 * this.aa.f1637c) + (al.f1196g.y + ((al.f1203n.y - al.f1196g.y) * this.f1346I.f1502c));
            this.f1340C.preTranslate((m1830a() / 2.0f) - min, (m1847b() / 2.0f) - f2);
            this.f1367e = ((this.f1354Q * this.aa.f1635a) / f) * this.f1368f;
            this.f1340C.preScale(this.f1367e, this.f1367e, min, f2);
            this.f1340C.preRotate((float) this.aa.f1638d, min, f2);
        }
        this.f1340C.invert(this.f1341D);
        this.f1340C.mapPoints(new float[]{al.f1215z.x, al.f1215z.y});
        this.f1365c = al.f1215z.y + (((al.f1166C.y - al.f1215z.y) * this.f1345H.f1502c) + ((al.aa.y - al.f1166C.y) * this.f1348K.f1502c));
        this.f1366d = al.f1215z.y + ((al.f1178O.y - al.f1172I.y) * this.f1347J.f1502c);
        C0176a.m1106c("Scale factor: " + this.f1367e);
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
        for (ax a : this.f1369g.values()) {
            a.m1756a();
        }
    }

    public void m1857f() {
        this.ac.m1619a();
        this.f1338A = null;
    }

    public void m1858g() {
        ax axVar = new ax(ay.SHRUG, 1000);
        Interpolator c0205b = new C0205b(0.0f, 0.0f);
        c0205b.m1601a(0.2f, 1.0f);
        c0205b.m1601a(0.8f, 1.0f);
        c0205b.m1601a(1.0f, 0.0f);
        axVar.m1755a(c0205b, 0.0f, al.f1196g.y - al.f1215z.y);
        m1843a(axVar);
    }

    public void m1859h() {
        ax axVar = new ax(ay.NOD, 600);
        Interpolator c0205b = new C0205b(0.0f, 0.0f);
        c0205b.m1601a(0.225f, 1.0f);
        c0205b.m1601a(0.45f, 0.0f);
        c0205b.m1601a(0.55f, 0.0f);
        c0205b.m1601a(0.775f, 1.0f);
        c0205b.m1601a(1.0f, 0.0f);
        axVar.m1755a(c0205b, 0.0f, al.f1215z.y - al.f1196g.y);
        m1843a(axVar);
    }

    public void m1860i() {
        ax axVar = new ax(ay.HEAD_TILT, 1000);
        Interpolator c0205b = new C0205b(0.0f, 0.0f);
        c0205b.m1601a(0.2f, 1.0f);
        c0205b.m1601a(0.8f, 1.0f);
        axVar.m1755a(c0205b, 0.0f, f1337a.nextBoolean() ? 8.0f : -8.0f);
        m1843a(axVar);
    }

    public void m1861j() {
        ax axVar = new ax(ay.ANTENNA_TWITCH);
        Interpolator c0205b = new C0205b(0.0f, 0.0f);
        c0205b.m1601a(0.25f, 1.0f);
        c0205b.m1601a(0.5f, 0.0f);
        c0205b.m1601a(0.75f, 1.0f);
        axVar.m1755a(c0205b, 0.0f, 40.0f);
        m1843a(axVar);
    }

    public void m1862k() {
        m1843a(new ax(ay.BLINK));
    }

    public long m1863l() {
        ax axVar = new ax(ay.WAVE, (long) 1200);
        Interpolator c0205b = new C0205b(0.0f, 0.0f);
        c0205b.m1601a(0.35f, 1.0f);
        c0205b.m1601a(0.5f, 0.8f);
        c0205b.m1601a(0.65f, 1.0f);
        axVar.m1755a(c0205b, 0.0f, 160.0f);
        m1843a(axVar);
        return (long) 1200;
    }

    public Picture[] m1864m() {
        if (this.f1385w == null || !this.f1385w.f1389a.equals("head")) {
            this.f1364b[1] = null;
        } else {
            this.f1364b[1] = this.f1385w.f1391c.f1708a;
        }
        if (this.f1384v == null || !this.f1384v.f1389a.equals("head")) {
            this.f1364b[0] = null;
        } else {
            this.f1364b[0] = this.f1384v.f1391c.f1708a;
        }
        return this.f1364b;
    }
}
