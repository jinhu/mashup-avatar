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
import com.google.android.a;
import com.google.android.apps.androidify.a.e;
import com.google.android.apps.androidify.a.h;
import com.google.android.apps.androidify.a.j;
import com.google.android.apps.androidify.a.k;
import com.google.android.apps.androidify.a.l;
import com.google.android.apps.b.b;
import com.google.android.apps.b.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public class ba {
    static final Random a;
    private k A;
    private ae B;
    private Matrix C;
    private Matrix D;
    private RectF E;
    private float F;
    private PointF G;
    private ch H;
    private ch I;
    private ch J;
    private ch K;
    private Picture L;
    private Picture M;
    private Path N;
    private float O;
    private float P;
    private float Q;
    private float R;
    private RectF S;
    private RectF T;
    private Paint U;
    private int V;
    private int W;
    private int X;
    private int Y;
    private int Z;
    private dp aa;
    private float ab;
    private j ac;
    private j ad;
    private int ae;
    private ci af;
    private Matrix ag;
    private RectF ah;
    private Context ai;
    private float[] aj;
    Picture[] b;
    private float c;
    private float d;
    private float e;
    private float f;
    private HashMap g;
    private Picture h;
    private Picture i;
    private Picture j;
    private Picture k;
    private Picture l;
    private Picture m;
    private Picture n;
    private Picture o;
    private Picture p;
    private Picture q;
    private Picture r;
    private Picture s;
    private Picture t;
    private Picture u;
    private bb v;
    private bb w;
    private bb x;
    private bb y;
    private Path z;

    static {
        a = new Random();
    }

    public ba(Context context) {
        this.e = 1.0f;
        this.f = 1.0f;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.C = null;
        this.D = null;
        this.S = al.w;
        this.T = new RectF();
        this.X = 255;
        this.Y = 255;
        this.Z = 255;
        this.aa = null;
        this.ac = new j();
        this.ad = new j();
        this.ae = 255;
        this.af = new ci();
        this.ag = new Matrix();
        this.ah = new RectF(al.n.x - al.u, 0.0f, al.n.x + al.u, 0.0f);
        this.aj = new float[2];
        this.b = new Picture[2];
        this.ai = context;
        ah a = ah.a(context);
        Picture picture = a.a((int) R.raw.android_body).a;
        Picture picture2 = a.a((int) R.raw.android_head).a;
        Picture picture3 = a.a((int) R.raw.android_antenna).a;
        Picture picture4 = a.a((int) R.raw.android_arm).a;
        Picture picture5 = a.a((int) R.raw.android_leg).a;
        this.L = a.a((int) R.raw.android_foot).a;
        this.M = picture3;
        this.H = new ch(picture);
        this.I = new ch(picture2);
        this.J = new ch(picture4);
        this.K = new ch(picture5);
        this.E = new RectF();
        this.G = new PointF();
        this.z = c.a("M140.396,175.489v177.916c0,10.566,8.566,19.133,19.135,19.133h2.303h20.331h48.709h37.371h48.708h11.881h10.752c10.569,0,19.137-8.562,19.137-19.133V175.489H140.396z");
        this.D = new Matrix();
        this.U = new Paint();
        this.U.setAntiAlias(true);
        this.N = new Path();
        p();
        this.g = new HashMap();
        this.B = new ae();
    }

    private static Picture a(b bVar) {
        return bVar == null ? null : bVar.a;
    }

    private void a(float f, int i, long j) {
        b(ay.DRIFT);
        this.ab = (float) ((((double) i) * 3.141592653589793d) / 180.0d);
        ax axVar = new ax(ay.DRIFT, j);
        axVar.a(new LinearInterpolator(), 0.0f, f);
        a(axVar);
    }

    private void n() {
        this.J.d = (-(al.z.x - al.A.x)) * (this.H.b - 1.0f);
        ch chVar = this.J;
        chVar.d -= (al.K.x - al.J.x) * (this.J.b - 1.0f);
    }

    private void o() {
        this.K.e = ((al.C.y - al.z.y) * (this.H.c - 1.0f)) - 10.0f;
    }

    private void p() {
        this.N.rewind();
        float f = (al.K.x - al.J.x) * this.J.b;
        float f2 = (al.G.y - al.E.y) * this.J.c;
        float f3 = f / 2.0f;
        float f4 = f3 * 0.5522848f;
        this.N.moveTo(al.J.x, al.E.y + f3);
        this.N.rCubicTo(0.0f, -f4, f3 - f4, -f3, f3, -f3);
        this.N.rCubicTo(f4, 0.0f, f3, f3 - f4, f3, f3);
        this.N.rLineTo(0.0f, f2 - f);
        this.N.rCubicTo(0.0f, f4, -(f3 - f4), f3, -f3, f3);
        float f5 = -f3;
        this.N.rCubicTo(-f4, 0.0f, -f3, -(f3 - f4), -f3, f5);
        this.N.rLineTo(0.0f, -(f2 - f));
        this.N.close();
    }

    public float a() {
        return this.O;
    }

    public Picture a(String str) {
        return (this.v == null || !this.v.a.equals(str) || this.v.c == null) ? (this.w == null || !this.w.a.equals(str) || this.w.c == null) ? (this.x == null || !this.x.a.equals(str) || this.x.c == null) ? (this.y == null || !this.y.a.equals(str) || this.y.c == null) ? null : this.y.c.a : this.x.c.a : this.w.c.a : this.v.c.a;
    }

    public ax a(ay ayVar) {
        return (ax) this.g.get(ayVar.toString());
    }

    public void a(float f) {
        this.Q = f;
    }

    public void a(int i) {
        this.ae = i;
    }

    public void a(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.O = (float) i;
            this.P = (float) i2;
            c();
        }
    }

    public void a(int i, int i2, int i3) {
        this.X = i;
        this.Y = i2;
        this.Z = i3;
    }

    public void a(Canvas canvas) {
        a(canvas, this.O, this.P);
    }

    public void a(Canvas canvas, float f, float f2) {
        canvas.drawARGB(this.ae, this.X, this.Y, this.Z);
        canvas.getSaveCount();
        canvas.save();
        if (this.e <= 0.0f) {
            a((int) f, (int) f2);
        }
        if ((!this.g.isEmpty() ? 1 : null) != null) {
            Iterator it = this.g.values().iterator();
            while (it.hasNext()) {
                if (((ax) it.next()).a()) {
                    it.remove();
                }
            }
        }
        ax a = a(ay.HEAD_TILT);
        ax a2 = a(ay.NOD);
        ax a3 = a(ay.DRIFT);
        if (a3 != null) {
            canvas.translate((float) (Math.cos((double) this.ab) * ((double) a3.e())), (float) (Math.sin((double) this.ab) * ((double) a3.e())));
        }
        canvas.concat(this.C);
        k kVar = null;
        if (this.A != null && this.A.b == l.MASTER) {
            kVar = this.A;
        }
        if (kVar != null) {
            b a4 = kVar.a(this.ai, 0);
            canvas.save();
            canvas.translate(this.ac.I + al.D.x, this.ac.J + al.D.y);
            canvas.scale(this.ac.P, this.ac.O, a4.c.centerX(), a4.c.centerY());
            canvas.drawPicture(a4.a);
            canvas.restore();
        }
        canvas.rotate(this.ac.k, al.D.x, al.D.y);
        canvas.translate(this.ac.A, (((this.ac.B * 0.29615164f) * this.H.c) + ((this.ac.B * 0.70384836f) * this.K.c)) * 0.3f);
        canvas.scale(this.ac.Q, 1.0f, al.D.x, al.D.y);
        kVar = null;
        if (this.A != null && this.A.b == l.BALL) {
            kVar = this.A;
        }
        canvas.save();
        canvas.rotate(this.ac.j, al.D.x, al.D.y);
        canvas.translate(this.ac.y, this.ac.z);
        canvas.rotate(this.ac.i, al.g.x, al.g.y);
        canvas.translate(this.ac.w, this.ac.x);
        if (a != null) {
            canvas.rotate(a.e(), al.g.x, al.g.y);
        }
        if (a2 != null) {
            canvas.translate(0.0f, a2.e());
        }
        canvas.scale(this.I.b, this.I.c, al.g.x, al.g.y);
        if (this.o != null) {
            this.o.draw(canvas);
        }
        if (this.q != null) {
            this.q.draw(canvas);
        }
        canvas.restore();
        int i = 0;
        while (i < 2) {
            float f3 = i == 0 ? this.ac.c : this.ac.d;
            float f4 = i == 0 ? this.ac.s : this.ac.u;
            float f5 = i == 0 ? this.ac.t : this.ac.v;
            canvas.save();
            if (i == 1) {
                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
            }
            canvas.translate(this.K.d, this.K.e);
            canvas.rotate(f3, 250.0f + ((al.ac.x - 250.0f) * this.K.b), al.W.y);
            canvas.translate(f4, f5);
            canvas.scale(this.K.b, this.K.c, al.C.x, al.C.y);
            this.K.a.draw(canvas);
            canvas.restore();
            i++;
        }
        canvas.save();
        canvas.translate(this.K.d, this.K.e);
        i = 0;
        while (i < 2) {
            f3 = i == 0 ? this.ac.c : this.ac.d;
            f4 = i == 0 ? this.ac.s : this.ac.u;
            f5 = i == 0 ? this.ac.t : this.ac.v;
            canvas.save();
            if (i == 1) {
                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
            }
            canvas.rotate(f3, 250.0f + ((al.ac.x - 250.0f) * this.K.b), al.W.y);
            canvas.translate(f4, f5);
            canvas.scale(this.K.b, this.K.c, al.C.x, al.C.y);
            canvas.save();
            canvas.scale(1.0f, this.K.b / this.K.c, 250.0f, al.aa.y);
            this.L.draw(canvas);
            canvas.restore();
            if (this.l != null) {
                this.l.draw(canvas);
            }
            canvas.save();
            canvas.scale(1.0f, this.K.b / this.K.c, i == 0 ? al.W.x : al.X.x, al.C.y);
            if (this.n != null) {
                this.n.draw(canvas);
            }
            canvas.restore();
            canvas.restore();
            i++;
        }
        canvas.restore();
        canvas.save();
        canvas.rotate(this.ac.j, al.D.x, al.D.y);
        canvas.translate(this.ac.y, this.ac.z);
        canvas.save(1);
        canvas.scale(this.H.b, this.H.c, al.z.x, al.z.y);
        canvas.clipPath(this.z);
        this.H.a.draw(canvas);
        canvas.restore();
        if (this.h != null) {
            f5 = Math.max(this.H.b, this.H.c);
            if (f5 < 1.2f) {
                canvas.scale(f5 / 1.2f, f5 / 1.2f, al.z.x, al.z.y);
            }
            this.h.draw(canvas);
        }
        canvas.restore();
        canvas.save();
        canvas.translate(this.K.d, this.K.e);
        if (this.s != null) {
            i = 0;
            while (i < 2) {
                canvas.save();
                f3 = i == 0 ? this.ac.c : this.ac.d;
                f4 = i == 0 ? this.ac.s : this.ac.u;
                f5 = i == 0 ? this.ac.t : this.ac.v;
                if (i == 1) {
                    canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
                }
                canvas.rotate(f3, 250.0f + ((al.ac.x - 250.0f) * this.K.b), al.W.y);
                canvas.translate(f4, f5);
                canvas.scale(this.K.b, this.K.c, al.C.x, al.C.y);
                canvas.scale(1.0f, this.K.b / this.K.c, 250.0f, al.aa.y);
                if (i == 0 && this.ac.e != 0.0f) {
                    canvas.rotate(this.ac.e, al.aa.x, al.aa.y);
                } else if (i == 1 && this.ac.f != 0.0f) {
                    canvas.rotate(this.ac.f, al.aa.x, al.aa.y);
                }
                this.s.draw(canvas);
                canvas.restore();
                i++;
            }
        }
        canvas.restore();
        if (this.k != null) {
            canvas.save();
            canvas.rotate(this.ac.j, al.D.x, al.D.y);
            canvas.translate(this.ac.y, this.ac.z);
            canvas.scale(this.H.b, this.H.c, al.z.x, al.z.y);
            this.k.draw(canvas);
            canvas.restore();
        }
        if (this.m != null) {
            canvas.save();
            canvas.rotate(this.ac.j, al.D.x, al.D.y);
            canvas.translate(this.ac.y, this.ac.z);
            canvas.scale(this.H.b, this.H.c, al.z.x, al.z.y);
            this.m.draw(canvas);
            canvas.restore();
        }
        Picture a5 = a("body");
        if (this.j != null) {
            canvas.save();
            canvas.rotate(this.ac.j, al.D.x, al.D.y);
            canvas.translate(this.ac.y, this.ac.z);
            canvas.scale(this.H.b, this.H.c, al.z.x, al.z.y);
            if (this.j != null) {
                this.j.draw(canvas);
            }
            canvas.restore();
        }
        if (a5 != null) {
            canvas.save();
            canvas.rotate(this.ac.j, al.D.x, al.D.y);
            canvas.translate(this.ac.y, this.ac.z);
            f4 = Math.min(this.H.b, this.H.c);
            canvas.scale(f4, f4, al.z.x, al.z.y);
            if (a5 != null) {
                a5.draw(canvas);
            }
            canvas.restore();
        }
        Picture a6 = a("face");
        canvas.save();
        canvas.rotate(this.ac.j, al.D.x, al.D.y);
        canvas.translate(this.ac.y, this.ac.z);
        if (a != null) {
            canvas.rotate(a.e(), al.g.x, al.g.y);
        }
        canvas.rotate(this.ac.i, al.g.x, al.g.y);
        canvas.translate(this.ac.w, this.ac.x);
        if (a2 != null) {
            canvas.translate(0.0f, a2.e());
        }
        canvas.scale(this.I.b, this.I.c, al.g.x, al.g.y);
        this.I.a.draw(canvas);
        Picture a7 = a("earring");
        for (int i2 = 0; i2 < 2; i2++) {
            canvas.save();
            if (i2 == 1) {
                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
            }
            if (this.I.b > this.I.c) {
                canvas.scale(1.0f, this.I.b / this.I.c, al.p.x, al.p.y);
            } else {
                canvas.scale(this.I.c / this.I.b, 1.0f, al.p.x, al.p.y);
            }
            ax a8 = a(ay.ANTENNA_TWITCH);
            if (a8 != null) {
                canvas.rotate(a8.e(), al.p.x, al.p.y);
            } else {
                canvas.rotate(c(i2), al.p.x, al.p.y);
            }
            if (i2 == 0 && this.ac.g != 0.0f) {
                canvas.rotate(this.ac.g, al.p.x, al.p.y);
            } else if (i2 == 1 && this.ac.h != 0.0f) {
                canvas.rotate(this.ac.h, al.p.x, al.p.y);
            }
            this.M.draw(canvas);
            if (a7 != null) {
                a7.draw(canvas);
            }
            canvas.restore();
        }
        if (a6 != null) {
            a6.draw(canvas);
        }
        canvas.save();
        canvas.translate(this.ac.C, this.ac.D);
        this.U.setColor(-1);
        i = 0;
        while (i < 2) {
            canvas.save();
            if (i == 1) {
                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
            }
            if (this.I.b < this.I.c) {
                canvas.scale(1.0f, this.I.b / this.I.c, al.n.x, al.n.y);
            } else {
                canvas.scale(this.I.c / this.I.b, 1.0f, al.n.x, al.n.y);
            }
            if (i == 0 && this.ac.K != 1.0f) {
                canvas.scale(this.ac.K, this.ac.K, al.n.x, al.n.y);
            } else if (i == 1 && this.ac.L != 1.0f) {
                canvas.scale(this.ac.L, this.ac.L, al.n.x, al.n.y);
            }
            if (i == 0 && this.ac.l != 0.0f) {
                canvas.rotate(this.ac.l, al.n.x, al.n.y);
            } else if (i == 1 && this.ac.m != 0.0f) {
                canvas.rotate(this.ac.m, al.n.x, al.n.y);
            }
            f3 = i == 0 ? this.ac.E : this.ac.G;
            f4 = i == 0 ? this.ac.F : this.ac.H;
            f5 = i == 0 ? this.ac.M : this.ac.N;
            this.ah.left = (al.n.x - al.u) + f3;
            this.ah.right = f3 + (al.n.x + al.u);
            this.ah.top = by.a(f5, 0.0f, 1.0f, al.n.y, al.j.y) + f4;
            this.ah.bottom = by.a(f5, 0.0f, 1.0f, al.n.y, al.l.y) + f4;
            canvas.clipRect(this.ah);
            canvas.drawCircle(al.n.x, al.n.y, al.n.y - al.j.y, this.U);
            canvas.restore();
            i++;
        }
        canvas.restore();
        canvas.restore();
        if (!this.ac.T) {
            a(canvas, a, a2);
        }
        if (kVar != null) {
            b a9 = kVar.a(this.ai, 0);
            canvas.save();
            canvas.translate(this.ac.I + al.D.x, by.a(this.ac.J, this.ac.U.b(h.PROP_POSITION_Y), this.ac.U.a(h.PROP_POSITION_Y), this.d - 25.0f, this.c - 80.0f) + kVar.g);
            canvas.scale(this.ac.P, this.ac.O, a9.c.centerX(), a9.c.centerY());
            canvas.drawPicture(a9.a);
            canvas.restore();
        }
        float f6 = this.J.d;
        float f7 = this.J.b;
        Picture picture = this.i;
        int i3 = 0;
        while (i3 < 2) {
            k kVar2 = null;
            if (this.A != null && (this.A.b == l.LEFT_ARM || this.A.b == l.RIGHT_ARM_UNDER)) {
                kVar2 = this.A;
            }
            canvas.save();
            float f8 = i3 == 0 ? this.ac.a : this.ac.b;
            f3 = i3 == 0 ? this.ac.o : this.ac.q;
            f4 = i3 == 0 ? this.ac.p : this.ac.r;
            canvas.rotate(this.ac.j, al.D.x, al.D.y);
            canvas.translate(this.ac.y, this.ac.z);
            a8 = a(ay.SHRUG);
            if (a8 != null) {
                canvas.translate(0.0f, a8.e());
            }
            if (i3 == 1) {
                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
            }
            canvas.translate(f6, this.J.e);
            if (i3 == 0) {
                a8 = a(ay.WAVE);
                if (a8 != null) {
                    canvas.rotate(a8.e(), al.E.x, al.E.y);
                }
            }
            canvas.rotate(f8, al.J.x + (((al.K.x - al.J.x) * f7) / 2.0f), al.E.y + ((al.I.y - al.E.y) * f7));
            canvas.translate(f3, f4);
            if (kVar2 != null && kVar2.b == l.RIGHT_ARM_UNDER && i3 == 1) {
                a(canvas, f7, kVar2, -2.0f * f8);
            }
            if (this.ac.T) {
                this.U.setColor(this.V);
            } else {
                this.U.setColor(this.W);
            }
            canvas.drawPath(this.N, this.U);
            Picture a10 = a(i3 == 0 ? "onlefthand" : "onrighthand");
            a6 = a(i3 == 0 ? "inlefthand" : "inrighthand");
            if (!(kVar == null && kVar2 == null)) {
                a6 = null;
            }
            Picture a11 = kVar != null ? null : a("onbothhands");
            a7 = i3 == 0 ? a("arm") : null;
            Picture a12 = a("sleeve");
            if (picture != null || a10 != null || a6 != null || a11 != null || kVar2 != null || a7 != null || a12 != null) {
                canvas.save();
                canvas.translate((al.I.x - al.J.x) * (f7 - 1.0f), 0.0f);
                canvas.scale(f7, f7, al.I.x, al.E.y);
                this.T.set(-20000.0f, -20000.0f, 20000.0f, al.I.y);
                if (a7 != null) {
                    a7.draw(canvas);
                }
                canvas.save();
                canvas.clipRect(this.T);
                if (a12 != null) {
                    a12.draw(canvas);
                }
                if (picture != null) {
                    picture.draw(canvas);
                }
                canvas.restore();
                canvas.restore();
                f3 = (((al.O.y - al.I.y) * this.J.c) - (((al.I.y - al.E.y) * (f7 - this.J.c)) * 2.0f)) / (al.O.y - al.I.y);
                canvas.save();
                canvas.translate((al.I.x - al.J.x) * (f7 - 1.0f), 0.0f);
                canvas.scale(f7, this.J.c, al.E.x, al.E.y);
                canvas.scale(1.0f, f3 / this.J.c, al.Q.x, al.Q.y);
                this.T.set(-20000.0f, al.I.y, 20000.0f, al.O.y);
                canvas.clipRect(this.T);
                if (a12 != null) {
                    a12.draw(canvas);
                }
                if (picture != null) {
                    picture.draw(canvas);
                }
                canvas.restore();
                canvas.save();
                canvas.translate((al.I.x - al.J.x) * (f7 - 1.0f), 0.0f);
                canvas.scale(f7, this.J.c, al.I.x, al.E.y);
                canvas.scale(1.0f, f7 / this.J.c, al.G.x, al.G.y);
                this.T.set(-20000.0f, al.O.y, 20000.0f, 20000.0f);
                canvas.clipRect(this.T);
                if (a12 != null) {
                    a12.draw(canvas);
                }
                if (picture != null) {
                    picture.draw(canvas);
                }
                canvas.restore();
                if (!(a10 == null && a11 == null && a6 == null)) {
                    canvas.save();
                    canvas.translate((al.I.x - al.J.x) * (f7 - 1.0f), 0.0f);
                    canvas.translate(0.0f, (al.G.y - al.E.y) * (this.J.c - 1.0f));
                    canvas.scale(f7, f7, al.G.x, al.G.y);
                    if (a11 != null) {
                        a11.draw(canvas);
                    }
                    if (a10 != null) {
                        a10.draw(canvas);
                    }
                    if (a6 != null) {
                        canvas.save();
                        canvas.rotate(-f8, al.O.x, al.O.y);
                        a6.draw(canvas);
                        canvas.restore();
                    }
                    canvas.restore();
                }
                if (kVar2 != null && kVar2.b == l.LEFT_ARM && i3 == 0) {
                    a(canvas, f7, kVar2, 0.0f);
                }
            }
            canvas.restore();
            i3++;
        }
        int i4 = 0;
        while (i4 < 2) {
            f4 = i4 == 0 ? this.ac.a : this.ac.b;
            f5 = i4 == 0 ? this.ac.o : this.ac.q;
            float f9 = i4 == 0 ? this.ac.p : this.ac.r;
            canvas.save();
            canvas.rotate(this.ac.j, al.D.x, al.D.y);
            canvas.translate(this.ac.y, this.ac.z);
            if (i4 == 1) {
                canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
            }
            float f10 = al.J.x + (((al.K.x - al.J.x) * this.J.b) / 2.0f);
            f8 = al.E.y + ((al.I.y - al.E.y) * this.J.b);
            canvas.translate(this.J.d, this.J.e);
            canvas.rotate(f4, f10, f8);
            canvas.translate(f5, f9);
            Picture a13 = a(i4 == 0 ? "leftshoulder" : "rightshoulder");
            if (a13 != null) {
                canvas.save();
                canvas.translate((al.I.x - al.J.x) * (this.J.b - 1.0f), 0.0f);
                canvas.scale(this.J.b, this.J.b, al.I.x, al.E.y);
                a13.draw(canvas);
                canvas.restore();
            }
            canvas.restore();
            i4++;
        }
        if (this.ac.T) {
            a(canvas, a, a2);
        }
        canvas.restore();
    }

    public void a(Canvas canvas, float f, k kVar, float f2) {
        b a = kVar.a(this.ai, this.W);
        if (a != null) {
            canvas.save();
            Picture picture = a.a;
            canvas.translate(al.I.x - (((float) picture.getWidth()) / 2.0f), al.I.y - (((float) picture.getHeight()) / 2.0f));
            canvas.translate((al.I.x - al.J.x) * (f - 1.0f), 0.0f);
            canvas.translate(this.ac.I * (f / 0.92f), this.ac.J * (this.J.c / 1.15f));
            canvas.rotate(kVar.b == l.RIGHT_ARM_UNDER ? -this.ac.n : this.ac.n, ((float) picture.getWidth()) / 2.0f, ((float) picture.getHeight()) / 2.0f);
            canvas.scale((this.ac.P * f) / 0.92f, (this.ac.O * f) / 0.92f, ((float) picture.getWidth()) / 2.0f, ((float) picture.getHeight()) / 2.0f);
            canvas.drawPicture(picture);
            canvas.restore();
        }
    }

    public void a(Canvas canvas, ax axVar, ax axVar2) {
        int i = 0;
        Picture[] m = m();
        Picture a = a("mouth");
        Picture a2 = a("hat");
        canvas.save();
        canvas.rotate(this.ac.j, al.D.x, al.D.y);
        canvas.translate(this.ac.y, this.ac.z);
        canvas.rotate(this.ac.i, al.g.x, al.g.y);
        canvas.translate(this.ac.w, this.ac.x);
        if (axVar != null) {
            canvas.rotate(axVar.e(), al.g.x, al.g.y);
        }
        if (axVar2 != null) {
            canvas.translate(0.0f, axVar2.e());
        }
        canvas.scale(this.I.b, this.I.c, al.g.x, al.g.y);
        if (this.u != null) {
            canvas.save();
            this.u.draw(canvas);
            canvas.restore();
        }
        if (this.p != null) {
            this.p.draw(canvas);
        }
        if (this.r != null) {
            this.r.draw(canvas);
        }
        if (a2 != null) {
            a2.draw(canvas);
        }
        if (this.t != null) {
            canvas.save();
            canvas.scale(1.0f, this.I.b / this.I.c, al.g.x, al.n.y);
            this.t.draw(canvas);
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
        k kVar = null;
        if (this.A != null && this.A.b == l.HEAD) {
            kVar = this.A;
        }
        if (kVar != null) {
            b a3 = kVar.a(this.ai, this.W);
            if (a3 != null) {
                if (kVar.f) {
                    canvas.save();
                    Picture picture = a3.a;
                    canvas.translate(this.ac.C, this.ac.D);
                    while (i < 2) {
                        canvas.save();
                        if (i == 1) {
                            canvas.scale(-1.0f, 1.0f, 250.0f, 72.059f);
                        }
                        canvas.translate(al.n.x - (((float) picture.getWidth()) / 2.0f), al.n.y - (((float) picture.getHeight()) / 2.0f));
                        canvas.rotate(this.ac.n, ((float) picture.getWidth()) / 2.0f, ((float) picture.getHeight()) / 2.0f);
                        canvas.scale(this.ac.P, this.ac.O, ((float) picture.getWidth()) / 2.0f, ((float) picture.getHeight()) / 2.0f);
                        canvas.drawPicture(picture);
                        canvas.restore();
                        i++;
                    }
                    canvas.restore();
                } else {
                    canvas.save();
                    Picture picture2 = a3.a;
                    canvas.translate(al.g.x - (((float) picture2.getWidth()) / 2.0f), al.g.y - (((float) picture2.getHeight()) / 2.0f));
                    canvas.translate(this.ac.I * 0.667f, this.ac.J * 0.667f);
                    canvas.rotate(this.ac.n, ((float) picture2.getWidth()) / 2.0f, ((float) picture2.getHeight()) / 2.0f);
                    canvas.scale(this.ac.P, this.ac.O, ((float) picture2.getWidth()) / 2.0f, ((float) picture2.getHeight()) / 2.0f);
                    canvas.drawPicture(picture2);
                    canvas.restore();
                }
            }
        }
        canvas.restore();
    }

    public void a(e eVar, double d) {
        this.ac.a(eVar, null, 1.0f, d, this.e);
        this.A = eVar.c();
    }

    public void a(e eVar, double d, e eVar2, double d2, float f) {
        if (eVar2 == null) {
            this.ac.S = false;
            a(eVar, d);
            return;
        }
        k c = eVar2.c();
        k c2 = eVar.c();
        if (!(c == null || c2 == null || !c.a.equals(c2.a))) {
            this.ac.S = true;
        }
        this.ad.a(eVar2, null, 1.0f, d2, this.e);
        this.ac.a(eVar, this.ad, f, d, this.e);
        this.A = eVar.c();
    }

    public void a(ax axVar) {
        this.g.put(axVar.b().toString(), axVar);
    }

    public void a(az azVar, ah ahVar) {
        ag h;
        int s = azVar.s();
        this.V = azVar.t();
        if (this.V == this.ai.getResources().getColor(R.color.gray_android)) {
            this.W = this.ai.getResources().getColor(R.color.gray_arm_android);
        } else {
            this.W = al.a(this.V);
        }
        this.I.a = ahVar.a((int) R.raw.android_head, al.b, Integer.valueOf(this.V)).a;
        this.H.a = ahVar.a((int) R.raw.android_body, al.b, Integer.valueOf(this.V)).a;
        this.K.a = ahVar.a((int) R.raw.android_leg, al.b, Integer.valueOf(this.V)).a;
        this.L = ahVar.a((int) R.raw.android_foot, al.b, Integer.valueOf(this.V)).a;
        this.M = ahVar.a((int) R.raw.android_antenna, al.b, Integer.valueOf(this.V)).a;
        String e = azVar.e();
        if (e != null) {
            b a;
            b a2 = ahVar.a("hair", e, "back", al.a, Integer.valueOf(s));
            this.o = a(a2);
            a = ahVar.a("hair", e, "front", al.a, Integer.valueOf(s));
            this.p = a(a);
            b a3 = ahVar.a("hair", e, "backextra");
            this.q = a(a3);
            b a4 = ahVar.a("hair", e, "frontextra");
            this.r = a(a4);
            this.S = new RectF(al.w);
            if (!(a2 == null || a2.c == null)) {
                this.S.union(a2.c);
            }
            if (!(a == null || a.c == null)) {
                this.S.union(a.c);
            }
            if (!(a3 == null || a3.c == null)) {
                this.S.union(a3.c);
            }
            if (!(a4 == null || a4.c == null)) {
                this.S.union(a4.c);
            }
        } else {
            this.o = null;
            this.p = null;
            this.q = null;
            this.r = null;
            this.S = al.w;
        }
        String f = azVar.f();
        if (f != null) {
            this.h = a(ahVar.a("shirt", f, "body"));
            this.i = a(ahVar.a("shirt", f, "arm"));
            this.j = a(ahVar.a("shirt", f, "top"));
            this.k = a(ahVar.a("shirt", f, "bottom"));
        } else {
            this.h = null;
            this.i = null;
            this.j = null;
            this.k = null;
        }
        f = azVar.g();
        if (f != null) {
            this.l = a(ahVar.a("pants", f, "leg"));
            this.m = a(ahVar.a("pants", f, "skirt"));
            this.n = a(ahVar.a("pants", f, "top"));
        } else {
            this.l = null;
            this.m = null;
            this.n = null;
        }
        f = azVar.h();
        if (f != null) {
            ag e2 = ahVar.e(f);
            if (e2 != null) {
                a = ahVar.b(e2, azVar);
                if (a != null) {
                    this.s = a.a;
                } else {
                    this.s = null;
                }
            } else {
                this.s = null;
            }
        } else {
            this.s = null;
        }
        f = azVar.i();
        if (f != null) {
            this.t = a(ahVar.a("glasses", f, null));
        } else {
            this.t = null;
        }
        e = azVar.j();
        if (e != null) {
            this.u = a(ahVar.a("beard", e, null, al.a, Integer.valueOf(s)));
        } else {
            this.u = null;
        }
        f = azVar.w();
        String v = azVar.v();
        if (v != null) {
            h = ahVar.h(v);
            if (h != null) {
                this.v = new bb(f, v, ahVar.b(h, azVar));
            } else {
                this.v = null;
            }
        } else {
            this.v = null;
        }
        f = azVar.y();
        v = azVar.x();
        if (v != null) {
            h = ahVar.i(v);
            if (h != null) {
                this.w = new bb(f, v, ahVar.b(h, azVar));
            } else {
                this.w = null;
            }
        } else {
            this.w = null;
        }
        f = azVar.A();
        v = azVar.z();
        if (v != null) {
            h = ahVar.j(v);
            if (h != null) {
                this.x = new bb(f, v, ahVar.b(h, azVar));
            } else {
                this.x = null;
            }
        } else {
            this.x = null;
        }
        f = azVar.C();
        v = azVar.B();
        if (v != null) {
            h = ahVar.k(v);
            if (h != null) {
                this.y = new bb(f, v, ahVar.b(h, azVar));
            } else {
                this.y = null;
            }
        } else {
            this.y = null;
        }
        this.H.b = azVar.k();
        this.H.c = azVar.l();
        this.I.b = azVar.m();
        this.I.c = azVar.n();
        this.J.b = azVar.o();
        this.J.c = azVar.p();
        this.K.b = azVar.q();
        this.K.c = azVar.r();
        n();
        o();
        c();
    }

    public void a(dp dpVar) {
        this.aa = dpVar;
        a((dpVar.f * (al.l.y - al.j.y)) * c.a(this.ai, 1.0f), dpVar.h, dpVar.g);
    }

    public void a(boolean z) {
        switch (z ? a.nextInt(6) : a.nextInt(4) + 1) {
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

    public float b() {
        return this.P;
    }

    public void b(float f) {
        this.f = f;
    }

    public void b(int i) {
        a((16711680 & i) >> 16, (65280 & i) >> 8, i & 255);
    }

    public void b(ay ayVar) {
        this.g.remove(ayVar.toString());
    }

    public void b(boolean z) {
        this.ac.a(z);
        this.ad.a(z);
    }

    protected float c(int i) {
        return this.B.a(i);
    }

    public void c() {
        a.c("Rescaling for w: " + a() + ", h: " + b());
        float f = this.I.b * (al.i.x - al.h.x);
        this.R = Math.max(((al.B.x - al.A.x) * this.H.b) + (((al.A.x - al.J.x) * 2.0f) * this.J.b), f);
        float min = Math.min(al.v, this.S.top);
        b bVar = this.v == null ? null : this.v.c;
        if (!(bVar == null || bVar.c == null)) {
            min = Math.min(min, bVar.c.top);
        }
        min = ((al.g.y - min) * this.I.c) + (al.z.y - al.g.y);
        float f2 = (al.g.y - ((al.g.y - al.v) * this.I.c)) + (al.z.y - al.g.y);
        f2 = (al.g.y - ((al.g.y - this.S.top) * this.I.c)) + (al.z.y - al.g.y);
        f2 = (al.C.y - al.z.y) * this.H.c;
        this.F = ((al.aa.y - al.C.y) * this.K.c) + ((al.Y.y - al.aa.y) * this.K.b);
        float f3 = ((this.S.bottom - al.g.y) * this.I.c) - f2;
        if (f3 > this.F) {
            this.F = f3;
        }
        p();
        f3 = (min + f2) + this.F;
        this.E.set(al.D.x - (this.R / 2.0f), al.z.y - min, al.D.x + (this.R / 2.0f), (f2 + al.z.y) + this.F);
        this.G.set((this.E.left + this.E.right) / 2.0f, (this.E.top + this.E.bottom) / 2.0f);
        this.R *= 1.15f;
        min = f3 * 1.15f;
        if (this.aa == null) {
            f2 = a();
            this.e = Math.min(f2 / this.R, b() / min) * this.f;
            this.C = new Matrix();
            this.C.preTranslate((f2 / 2.0f) - this.G.x, (b() / 2.0f) - this.G.y);
            this.C.preScale(this.e, this.e, this.G.x, this.G.y);
        } else {
            this.C = new Matrix();
            f2 = al.l.y - al.j.y;
            min = (this.aa.e ? ((al.n.x - 250.0f) * this.I.b) + 250.0f : ((al.o.x - 250.0f) * this.I.b) + 250.0f) + (this.aa.b * f2);
            f2 = (f2 * this.aa.c) + (al.g.y + ((al.n.y - al.g.y) * this.I.c));
            this.C.preTranslate((a() / 2.0f) - min, (b() / 2.0f) - f2);
            this.e = ((this.Q * this.aa.a) / f) * this.f;
            this.C.preScale(this.e, this.e, min, f2);
            this.C.preRotate((float) this.aa.d, min, f2);
        }
        this.C.invert(this.D);
        this.C.mapPoints(new float[]{al.z.x, al.z.y});
        this.c = al.z.y + (((al.C.y - al.z.y) * this.H.c) + ((al.aa.y - al.C.y) * this.K.c));
        this.d = al.z.y + ((al.O.y - al.I.y) * this.J.c);
        a.c("Scale factor: " + this.e);
    }

    public void c(float f) {
        this.ac.R = f;
        this.ad.R = f;
    }

    public void d() {
        this.e = -1.0f;
    }

    public void e() {
        this.B.a();
        for (ax a : this.g.values()) {
            a.a();
        }
    }

    public void f() {
        this.ac.a();
        this.A = null;
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

    public Picture[] m() {
        if (this.w == null || !this.w.a.equals("head")) {
            this.b[1] = null;
        } else {
            this.b[1] = this.w.c.a;
        }
        if (this.v == null || !this.v.a.equals("head")) {
            this.b[0] = null;
        } else {
            this.b[0] = this.v.c.a;
        }
        return this.b;
    }
}
