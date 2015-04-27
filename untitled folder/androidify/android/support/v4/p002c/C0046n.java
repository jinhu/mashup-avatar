package android.support.v4.p002c;

/* renamed from: android.support.v4.c.n */
public class C0046n implements Cloneable {
    private static final Object f223a;
    private boolean f224b;
    private int[] f225c;
    private Object[] f226d;
    private int f227e;

    static {
        f223a = new Object();
    }

    public C0046n() {
        this(10);
    }

    public C0046n(int i) {
        this.f224b = false;
        if (i == 0) {
            this.f225c = C0037c.f201a;
            this.f226d = C0037c.f203c;
        } else {
            int a = C0037c.m242a(i);
            this.f225c = new int[a];
            this.f226d = new Object[a];
        }
        this.f227e = 0;
    }

    private void m261d() {
        int i = this.f227e;
        int[] iArr = this.f225c;
        Object[] objArr = this.f226d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f223a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f224b = false;
        this.f227e = i2;
    }

    public C0046n m262a() {
        try {
            C0046n c0046n = (C0046n) super.clone();
            try {
                c0046n.f225c = (int[]) this.f225c.clone();
                c0046n.f226d = (Object[]) this.f226d.clone();
                return c0046n;
            } catch (CloneNotSupportedException e) {
                return c0046n;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public Object m263a(int i, Object obj) {
        int a = C0037c.m243a(this.f225c, this.f227e, i);
        return (a < 0 || this.f226d[a] == f223a) ? obj : this.f226d[a];
    }

    public void m264a(int i) {
        if (this.f226d[i] != f223a) {
            this.f226d[i] = f223a;
            this.f224b = true;
        }
    }

    public int m265b() {
        if (this.f224b) {
            m261d();
        }
        return this.f227e;
    }

    public int m266b(int i) {
        if (this.f224b) {
            m261d();
        }
        return this.f225c[i];
    }

    public void m267b(int i, Object obj) {
        int a = C0037c.m243a(this.f225c, this.f227e, i);
        if (a >= 0) {
            this.f226d[a] = obj;
            return;
        }
        a ^= -1;
        if (a >= this.f227e || this.f226d[a] != f223a) {
            if (this.f224b && this.f227e >= this.f225c.length) {
                m261d();
                a = C0037c.m243a(this.f225c, this.f227e, i) ^ -1;
            }
            if (this.f227e >= this.f225c.length) {
                int a2 = C0037c.m242a(this.f227e + 1);
                Object obj2 = new int[a2];
                Object obj3 = new Object[a2];
                System.arraycopy(this.f225c, 0, obj2, 0, this.f225c.length);
                System.arraycopy(this.f226d, 0, obj3, 0, this.f226d.length);
                this.f225c = obj2;
                this.f226d = obj3;
            }
            if (this.f227e - a != 0) {
                System.arraycopy(this.f225c, a, this.f225c, a + 1, this.f227e - a);
                System.arraycopy(this.f226d, a, this.f226d, a + 1, this.f227e - a);
            }
            this.f225c[a] = i;
            this.f226d[a] = obj;
            this.f227e++;
            return;
        }
        this.f225c[a] = i;
        this.f226d[a] = obj;
    }

    public Object m268c(int i) {
        if (this.f224b) {
            m261d();
        }
        return this.f226d[i];
    }

    public void m269c() {
        int i = this.f227e;
        Object[] objArr = this.f226d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f227e = 0;
        this.f224b = false;
    }

    public void m270c(int i, Object obj) {
        if (this.f227e == 0 || i > this.f225c[this.f227e - 1]) {
            if (this.f224b && this.f227e >= this.f225c.length) {
                m261d();
            }
            int i2 = this.f227e;
            if (i2 >= this.f225c.length) {
                int a = C0037c.m242a(i2 + 1);
                Object obj2 = new int[a];
                Object obj3 = new Object[a];
                System.arraycopy(this.f225c, 0, obj2, 0, this.f225c.length);
                System.arraycopy(this.f226d, 0, obj3, 0, this.f226d.length);
                this.f225c = obj2;
                this.f226d = obj3;
            }
            this.f225c[i2] = i;
            this.f226d[i2] = obj;
            this.f227e = i2 + 1;
            return;
        }
        m267b(i, obj);
    }

    public /* synthetic */ Object clone() {
        return m262a();
    }

    public int m271d(int i) {
        if (this.f224b) {
            m261d();
        }
        return C0037c.m243a(this.f225c, this.f227e, i);
    }

    public String toString() {
        if (m265b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f227e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f227e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(m266b(i));
            stringBuilder.append('=');
            C0046n c = m268c(i);
            if (c != this) {
                stringBuilder.append(c);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
