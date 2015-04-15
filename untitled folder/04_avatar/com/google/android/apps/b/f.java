package com.google.android.apps.b;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.RectF;
import com.google.android.a;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

class f extends DefaultHandler {
    Picture a;
    Canvas b;
    Paint c;
    RectF d;
    RectF e;
    RectF f;
    Integer g;
    Integer h;
    Integer i;
    Integer j;
    boolean k;
    private boolean l;
    private int m;
    private boolean n;
    private Float o;
    private boolean p;

    private f(Picture picture) {
        this.d = new RectF();
        this.e = null;
        this.f = new RectF(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = false;
        this.l = false;
        this.m = 0;
        this.n = false;
        this.o = null;
        this.p = false;
        this.a = picture;
        this.c = new Paint();
        this.c.setAntiAlias(true);
    }

    private void a() {
        if (this.p) {
            this.b.restore();
        }
    }

    private void a(float f, float f2) {
        if (f < this.f.left) {
            this.f.left = f;
        }
        if (f > this.f.right) {
            this.f.right = f;
        }
        if (f2 < this.f.top) {
            this.f.top = f2;
        }
        if (f2 > this.f.bottom) {
            this.f.bottom = f2;
        }
    }

    private void a(float f, float f2, float f3, float f4) {
        a(f, f2);
        a(f + f3, f2 + f4);
    }

    private void a(Path path) {
        path.computeBounds(this.d, false);
        a(this.d.left, this.d.top);
        a(this.d.right, this.d.bottom);
    }

    private void a(Float f) {
        if (f == null) {
            this.c.setAlpha(255);
        } else {
            this.c.setAlpha((int) (255.0f * f.floatValue()));
        }
    }

    private void a(Attributes attributes, Integer num) {
        int intValue = (16777215 & num.intValue()) | -16777216;
        if (this.g != null && this.h != null && this.g.intValue() == intValue) {
            intValue = this.h.intValue();
        } else if (!(this.i == null || this.j == null || this.i.intValue() != intValue)) {
            intValue = this.j.intValue();
        }
        this.c.setColor(intValue);
    }

    private boolean a(Attributes attributes) {
        boolean z = true;
        if ("none".equals(c.f("display", attributes))) {
            return false;
        }
        if (this.k) {
            this.c.setStyle(Style.FILL);
            this.c.setColor(-1);
            return true;
        }
        Integer b = c.h("fill", attributes);
        if (b != null) {
            a(attributes, b);
            this.c.setStyle(Style.FILL);
        } else if (c.f("fill", attributes) == null && c.f("stroke", attributes) == null) {
            this.c.setStyle(Style.FILL);
            this.c.setColor(-16777216);
        } else {
            z = false;
        }
        Float c = c.g("opacity", attributes);
        if (c != null) {
            a(c);
            return z;
        } else if (this.o == null) {
            return z;
        } else {
            a(this.o);
            return z;
        }
    }

    private boolean b(Attributes attributes) {
        if (this.k || "none".equals(c.f("display", attributes))) {
            return false;
        }
        Integer b = c.h("stroke", attributes);
        if (b == null) {
            return false;
        }
        a(attributes, b);
        Float c = c.g("stroke-width", attributes);
        if (c != null) {
            this.c.setStrokeWidth(c.floatValue());
        }
        String a = c.f("stroke-linecap", attributes);
        if ("round".equals(a)) {
            this.c.setStrokeCap(Cap.ROUND);
        } else if ("square".equals(a)) {
            this.c.setStrokeCap(Cap.SQUARE);
        } else if ("butt".equals(a)) {
            this.c.setStrokeCap(Cap.BUTT);
        }
        a = c.f("stroke-linejoin", attributes);
        if ("miter".equals(a)) {
            this.c.setStrokeJoin(Join.MITER);
        } else if ("round".equals(a)) {
            this.c.setStrokeJoin(Join.ROUND);
        } else if ("bevel".equals(a)) {
            this.c.setStrokeJoin(Join.BEVEL);
        }
        this.c.setStyle(Style.STROKE);
        return true;
    }

    private void c(Attributes attributes) {
        String a = c.f("transform", attributes);
        this.p = a != null;
        if (this.p) {
            Matrix b = c.f(a);
            this.b.save();
            this.b.concat(b);
        }
    }

    public void a(Integer num, Integer num2) {
        this.g = num;
        this.h = num2;
    }

    public void a(boolean z) {
        this.k = z;
    }

    public void b(Integer num, Integer num2) {
        this.i = num;
        this.j = num2;
    }

    public void characters(char[] cArr, int i, int i2) {
    }

    public void endDocument() {
    }

    public void endElement(String str, String str2, String str3) {
        if (str2.equals("svg")) {
            this.a.endRecording();
        } else if (str2.equals("g")) {
            if (this.n) {
                this.n = false;
            }
            if (this.l) {
                this.m--;
                if (this.m == 0) {
                    this.l = false;
                }
            }
            this.o = null;
        }
    }

    public void startDocument() {
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) {
        int i = 2;
        int i2 = 0;
        Float c;
        Float c2;
        Float c3;
        if (this.n) {
            if (str2.equals("rect")) {
                c = c.g("x", attributes);
                if (c == null) {
                    c = Float.valueOf(0.0f);
                }
                c2 = c.g("y", attributes);
                if (c2 == null) {
                    c2 = Float.valueOf(0.0f);
                }
                c3 = c.g("width", attributes);
                c.g("height", attributes);
                this.e = new RectF(c.floatValue(), c2.floatValue(), c.floatValue() + c3.floatValue(), c2.floatValue() + c3.floatValue());
            }
        } else if (str2.equals("svg")) {
            c3 = c.g("width", attributes);
            r3 = c.g("height", attributes);
            if (c3 == null || r3 == null) {
                String a = c.f("viewBox", attributes);
                if (a != null) {
                    String[] split = a.split("\\s+");
                    if (split.length == 4) {
                        i = (int) Float.parseFloat(split[2]);
                        i2 = (int) Float.parseFloat(split[3]);
                    }
                }
                i = 0;
            } else {
                i = (int) Math.ceil((double) c3.floatValue());
                i2 = (int) Math.ceil((double) r3.floatValue());
            }
            this.b = this.a.beginRecording(i, i2);
        } else if (!str2.equals("defs")) {
            if (str2.equals("g")) {
                String a2 = c.f("id", attributes);
                if (a2 != null && a2.toLowerCase().startsWith("bounds")) {
                    this.n = true;
                }
                if (this.l) {
                    this.m++;
                }
                if ("none".equals(c.f("display", attributes)) && !this.l) {
                    this.l = true;
                    this.m = 1;
                }
                c = c.g("opacity", attributes);
                if (c != null) {
                    this.o = c;
                }
            } else if (!this.l && str2.equals("rect")) {
                c = c.g("x", attributes);
                Float valueOf = c == null ? Float.valueOf(0.0f) : c;
                c = c.g("y", attributes);
                Float valueOf2 = c == null ? Float.valueOf(0.0f) : c;
                Float c4 = c.g("width", attributes);
                Float c5 = c.g("height", attributes);
                c(attributes);
                if (a(attributes)) {
                    a(valueOf.floatValue(), valueOf2.floatValue(), c4.floatValue(), c5.floatValue());
                    this.b.drawRect(valueOf.floatValue(), valueOf2.floatValue(), valueOf.floatValue() + c4.floatValue(), valueOf2.floatValue() + c5.floatValue(), this.c);
                }
                if (b(attributes)) {
                    this.b.drawRect(valueOf.floatValue(), valueOf2.floatValue(), valueOf.floatValue() + c4.floatValue(), valueOf2.floatValue() + c5.floatValue(), this.c);
                }
                a();
            } else if (!this.l && str2.equals("line")) {
                c2 = c.g("x1", attributes);
                r3 = c.g("x2", attributes);
                c3 = c.g("y1", attributes);
                Float c6 = c.g("y2", attributes);
                if (b(attributes)) {
                    c(attributes);
                    a(c2.floatValue(), c3.floatValue());
                    a(r3.floatValue(), c6.floatValue());
                    this.b.drawLine(c2.floatValue(), c3.floatValue(), r3.floatValue(), c6.floatValue(), this.c);
                    a();
                }
            } else if (!this.l && str2.equals("circle")) {
                c = c.g("cx", attributes);
                c2 = c.g("cy", attributes);
                c3 = c.g("r", attributes);
                if (c != null && c2 != null && c3 != null) {
                    c(attributes);
                    if (a(attributes)) {
                        a(c.floatValue() - c3.floatValue(), c2.floatValue() - c3.floatValue());
                        a(c.floatValue() + c3.floatValue(), c2.floatValue() + c3.floatValue());
                        this.b.drawCircle(c.floatValue(), c2.floatValue(), c3.floatValue(), this.c);
                    }
                    if (b(attributes)) {
                        this.b.drawCircle(c.floatValue(), c2.floatValue(), c3.floatValue(), this.c);
                    }
                    a();
                }
            } else if (!this.l && str2.equals("ellipse")) {
                c = c.g("cx", attributes);
                c2 = c.g("cy", attributes);
                c3 = c.g("rx", attributes);
                r3 = c.g("ry", attributes);
                if (c != null && c2 != null && c3 != null && r3 != null) {
                    c(attributes);
                    this.d.set(c.floatValue() - c3.floatValue(), c2.floatValue() - r3.floatValue(), c.floatValue() + c3.floatValue(), c2.floatValue() + r3.floatValue());
                    if (a(attributes)) {
                        a(c.floatValue() - c3.floatValue(), c2.floatValue() - r3.floatValue());
                        a(c.floatValue() + c3.floatValue(), c2.floatValue() + r3.floatValue());
                        this.b.drawOval(this.d, this.c);
                    }
                    if (b(attributes)) {
                        this.b.drawOval(this.d, this.c);
                    }
                    a();
                }
            } else if (!this.l && (str2.equals("polygon") || str2.equals("polyline"))) {
                e d = c.e("points", attributes);
                if (d != null) {
                    Path path = new Path();
                    ArrayList a3 = d.a;
                    if (a3.size() > 1) {
                        c(attributes);
                        path.moveTo(((Float) a3.get(0)).floatValue(), ((Float) a3.get(1)).floatValue());
                        while (i < a3.size()) {
                            path.lineTo(((Float) a3.get(i)).floatValue(), ((Float) a3.get(i + 1)).floatValue());
                            i += 2;
                        }
                        if (str2.equals("polygon")) {
                            path.close();
                        }
                        if (a(attributes)) {
                            a(path);
                            this.b.drawPath(path, this.c);
                        }
                        if (b(attributes)) {
                            this.b.drawPath(path, this.c);
                        }
                        a();
                    }
                }
            } else if (!this.l && str2.equals("path")) {
                Path c7 = c.g(c.f("d", attributes));
                c(attributes);
                if (a(attributes)) {
                    a(c7);
                    this.b.drawPath(c7, this.c);
                }
                if (b(attributes)) {
                    this.b.drawPath(c7, this.c);
                }
                a();
            } else if (!this.l) {
                a.c("UNRECOGNIZED SVG COMMAND: " + str2);
            }
        }
    }
}
