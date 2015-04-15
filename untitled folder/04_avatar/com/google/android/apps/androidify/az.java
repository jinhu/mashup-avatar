package com.google.android.apps.androidify;

import android.content.Context;
import com.google.android.a;
import com.google.android.apps.a.i;
import com.google.android.apps.c.b;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.Iterator;

public class az implements Comparable {
    private int A;
    private Integer B;
    private Integer C;
    private long a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private float q;
    private float r;
    private float s;
    private float t;
    private float u;
    private float v;
    private float w;
    private float x;
    private int y;
    private int z;

    public az() {
        this.B = null;
        this.C = null;
        this.a = System.currentTimeMillis();
    }

    public static az a() {
        az azVar = new az();
        azVar.e(1.0f);
        azVar.f(1.0f);
        azVar.a(1.0f);
        azVar.b(1.0f);
        azVar.c(1.0f);
        azVar.d(1.0f);
        azVar.g(1.0f);
        azVar.h(1.0f);
        azVar.b(al.b.intValue());
        azVar.a(al.a.intValue());
        return azVar;
    }

    private boolean a(ag agVar) {
        return (agVar == null || agVar.b() == null) ? false : agVar.b().equals("nba");
    }

    private static boolean h(String str) {
        return str == null || str.contains("none");
    }

    public String A() {
        return this.m;
    }

    public String B() {
        return this.p;
    }

    public String C() {
        return this.o;
    }

    public boolean D() {
        return this.b != null;
    }

    public String E() {
        return this.b;
    }

    public long F() {
        return this.a;
    }

    public Integer G() {
        return this.B;
    }

    public Integer H() {
        return this.C;
    }

    public int a(az azVar) {
        return (this.b == null || azVar.b == null || this.b.equals(azVar.b)) ? Double.compare((double) this.a, (double) azVar.a) : this.b.toUpperCase().compareTo(azVar.b.toUpperCase());
    }

    public void a(float f) {
        this.q = f;
    }

    public void a(int i) {
        this.y = i;
    }

    public void a(Context context, String str) {
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(b.a(str)));
        int readInt = dataInputStream.readInt();
        if (dataInputStream.readBoolean()) {
            this.c = dataInputStream.readUTF();
        }
        if (dataInputStream.readBoolean()) {
            this.d = dataInputStream.readUTF();
        }
        if (dataInputStream.readBoolean()) {
            this.f = dataInputStream.readUTF();
        }
        if (dataInputStream.readBoolean()) {
            this.g = dataInputStream.readUTF();
        }
        if (dataInputStream.readBoolean()) {
            this.h = dataInputStream.readUTF();
        }
        if (dataInputStream.readBoolean()) {
            this.a = dataInputStream.readLong();
        }
        if (dataInputStream.readBoolean()) {
            this.b = dataInputStream.readUTF();
        }
        this.q = dataInputStream.readFloat();
        this.r = dataInputStream.readFloat();
        this.s = dataInputStream.readFloat();
        this.t = dataInputStream.readFloat();
        this.u = dataInputStream.readFloat();
        this.v = dataInputStream.readFloat();
        this.w = dataInputStream.readFloat();
        this.x = dataInputStream.readFloat();
        this.y = dataInputStream.readInt();
        this.y = al.af[c.a(this.y, al.af)];
        this.z = dataInputStream.readInt();
        this.z = al.ai[c.a(this.z, al.ai)];
        this.A = dataInputStream.readInt();
        if (readInt == 1) {
            ah a = ah.a(context);
            while (dataInputStream.readBoolean()) {
                ag agVar;
                dataInputStream.readUTF();
                String readUTF = dataInputStream.readUTF();
                Iterator it = a.i().iterator();
                while (it.hasNext()) {
                    agVar = (ag) it.next();
                    if (agVar.a().equals(readUTF)) {
                        this.i = agVar.b();
                        this.j = agVar.a();
                    }
                }
                it = a.j().iterator();
                while (it.hasNext()) {
                    agVar = (ag) it.next();
                    if (agVar.a().equals(readUTF)) {
                        this.k = agVar.b();
                        this.l = agVar.a();
                    }
                }
                it = a.k().iterator();
                while (it.hasNext()) {
                    agVar = (ag) it.next();
                    if (agVar.a().equals(readUTF)) {
                        this.m = agVar.b();
                        this.n = agVar.a();
                    }
                }
                it = a.l().iterator();
                while (it.hasNext()) {
                    agVar = (ag) it.next();
                    if (agVar.a().equals(readUTF)) {
                        this.o = agVar.b();
                        this.p = agVar.a();
                    }
                }
            }
            try {
                if (dataInputStream.readBoolean()) {
                    this.e = dataInputStream.readUTF();
                }
            } catch (Exception e) {
                a.c("No pants available in this config.");
            }
        } else {
            if (dataInputStream.readBoolean()) {
                this.e = dataInputStream.readUTF();
            }
            if (dataInputStream.readBoolean()) {
                this.i = dataInputStream.readUTF();
                this.j = dataInputStream.readUTF();
            }
            if (dataInputStream.readBoolean()) {
                this.k = dataInputStream.readUTF();
                this.l = dataInputStream.readUTF();
            }
            if (dataInputStream.readBoolean()) {
                this.m = dataInputStream.readUTF();
                this.n = dataInputStream.readUTF();
            }
            if (dataInputStream.readBoolean()) {
                this.o = dataInputStream.readUTF();
                this.p = dataInputStream.readUTF();
            }
        }
        if (readInt > 2) {
            if (dataInputStream.readBoolean()) {
                this.B = Integer.valueOf(dataInputStream.readInt());
            }
            if (dataInputStream.readBoolean()) {
                this.C = Integer.valueOf(dataInputStream.readInt());
            }
        }
        dataInputStream.close();
    }

    public void a(Integer num) {
        this.B = num;
    }

    public void a(String str) {
        this.c = str;
    }

    public void a(String str, String str2) {
        this.i = str;
        this.j = str2;
    }

    public boolean a(ah ahVar) {
        return a(ahVar.d(this.d));
    }

    public void b(float f) {
        this.r = f;
    }

    public void b(int i) {
        this.z = i;
    }

    public void b(Integer num) {
        this.C = num;
    }

    public void b(String str) {
        this.d = str;
    }

    public void b(String str, String str2) {
        this.k = str;
        this.l = str2;
    }

    public boolean b() {
        return this.b == null && this.u == 1.0f && this.v == 1.0f && this.q == 1.0f && this.r == 1.0f && this.s == 1.0f && this.t == 1.0f && this.w == 1.0f && this.x == 1.0f && this.z == al.b.intValue() && ((this.y == al.a.intValue() || this.y == -16777216) && h(this.c) && h(this.d) && h(this.e) && h(this.f) && h(this.g) && h(this.h) && h(this.j) && h(this.l) && h(this.n) && h(this.p));
    }

    public String c() {
        boolean z = true;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeInt(3);
        dataOutputStream.writeBoolean(this.c != null);
        if (this.c != null) {
            dataOutputStream.writeUTF(this.c);
        }
        dataOutputStream.writeBoolean(this.d != null);
        if (this.d != null) {
            dataOutputStream.writeUTF(this.d);
        }
        dataOutputStream.writeBoolean(this.f != null);
        if (this.f != null) {
            dataOutputStream.writeUTF(this.f);
        }
        dataOutputStream.writeBoolean(this.g != null);
        if (this.g != null) {
            dataOutputStream.writeUTF(this.g);
        }
        dataOutputStream.writeBoolean(this.h != null);
        if (this.h != null) {
            dataOutputStream.writeUTF(this.h);
        }
        dataOutputStream.writeBoolean(this.a >= 0);
        if (this.a >= 0) {
            dataOutputStream.writeLong(this.a);
        }
        dataOutputStream.writeBoolean(this.b != null);
        if (this.b != null) {
            dataOutputStream.writeUTF(this.b);
        }
        dataOutputStream.writeFloat(this.q);
        dataOutputStream.writeFloat(this.r);
        dataOutputStream.writeFloat(this.s);
        dataOutputStream.writeFloat(this.t);
        dataOutputStream.writeFloat(this.u);
        dataOutputStream.writeFloat(this.v);
        dataOutputStream.writeFloat(this.w);
        dataOutputStream.writeFloat(this.x);
        dataOutputStream.writeInt(this.y);
        dataOutputStream.writeInt(this.z);
        dataOutputStream.writeInt(this.A);
        dataOutputStream.writeBoolean(this.e != null);
        if (this.e != null) {
            dataOutputStream.writeUTF(this.e);
        }
        dataOutputStream.writeBoolean(this.j != null);
        if (this.j != null) {
            dataOutputStream.writeUTF(this.i);
            dataOutputStream.writeUTF(this.j);
        }
        dataOutputStream.writeBoolean(this.l != null);
        if (this.l != null) {
            dataOutputStream.writeUTF(this.k);
            dataOutputStream.writeUTF(this.l);
        }
        dataOutputStream.writeBoolean(this.n != null);
        if (this.n != null) {
            dataOutputStream.writeUTF(this.m);
            dataOutputStream.writeUTF(this.n);
        }
        dataOutputStream.writeBoolean(this.p != null);
        if (this.p != null) {
            dataOutputStream.writeUTF(this.o);
            dataOutputStream.writeUTF(this.p);
        }
        dataOutputStream.writeBoolean(this.B != null);
        if (this.B != null) {
            dataOutputStream.writeInt(this.B.intValue());
        }
        if (this.C == null) {
            z = false;
        }
        dataOutputStream.writeBoolean(z);
        if (this.C != null) {
            dataOutputStream.writeInt(this.C.intValue());
        }
        return b.a(byteArrayOutputStream.toByteArray());
    }

    public void c(float f) {
        this.s = f;
    }

    public void c(int i) {
        this.A = i;
    }

    public void c(String str) {
        this.e = str;
    }

    public void c(String str, String str2) {
        this.m = str;
        this.n = str2;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return a((az) obj);
    }

    public void d() {
        try {
            i a = i.a();
            a.a("Colors", "Hair Color", al.c(this.y), 0);
            a.a("Colors", "Skin Color", al.b(this.z), 0);
            a.a("Clothes", "Hair", this.c, 0);
            a.a("Clothes", "Shirt", this.d, 0);
            a.a("Clothes", "Pants", this.e, 0);
            a.a("Clothes", "Shoes", this.f, 0);
            a.a("Clothes", "Glasses", this.g, 0);
            a.a("Clothes", "Beard", this.h, 0);
            a.a("Accessories", "Hat", this.j, 0);
            a.a("Accessories", "Face", this.l, 0);
            a.a("Accessories", "Body", this.n, 0);
            a.a("Accessories", "Hand", this.p, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void d(float f) {
        this.t = f;
    }

    public void d(String str) {
        this.f = str;
    }

    public void d(String str, String str2) {
        this.o = str;
        this.p = str2;
    }

    public String e() {
        return this.c;
    }

    public void e(float f) {
        this.u = f;
    }

    public void e(String str) {
        this.g = str;
    }

    public String f() {
        return this.d;
    }

    public void f(float f) {
        this.v = f;
    }

    public void f(String str) {
        this.h = str;
    }

    public String g() {
        return this.e;
    }

    public void g(float f) {
        this.w = f;
    }

    public void g(String str) {
        this.b = str;
    }

    public String h() {
        return this.f;
    }

    public void h(float f) {
        this.x = f;
    }

    public String i() {
        return this.g;
    }

    public String j() {
        return this.h;
    }

    public float k() {
        return this.q;
    }

    public float l() {
        return this.r;
    }

    public float m() {
        return this.s;
    }

    public float n() {
        return this.t;
    }

    public float o() {
        return this.u;
    }

    public float p() {
        return this.v;
    }

    public float q() {
        return this.w;
    }

    public float r() {
        return this.x;
    }

    public int s() {
        return this.y;
    }

    public int t() {
        return this.z;
    }

    public int u() {
        return this.A;
    }

    public String v() {
        return this.j;
    }

    public String w() {
        return this.i;
    }

    public String x() {
        return this.l;
    }

    public String y() {
        return this.k;
    }

    public String z() {
        return this.n;
    }
}
