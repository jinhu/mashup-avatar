package android.support.v4.p002c;

/* renamed from: android.support.v4.c.f */
public class C0040f implements Cloneable {
    private static final Object f206a;
    private boolean f207b;
    private long[] f208c;
    private Object[] f209d;
    private int f210e;

    static {
        f206a = new Object();
    }

    public C0040f() {
        this(10);
    }

    public C0040f(int i) {
        this.f207b = false;
        if (i == 0) {
            this.f208c = C0037c.f202b;
            this.f209d = C0037c.f203c;
        } else {
            int b = C0037c.m246b(i);
            this.f208c = new long[b];
            this.f209d = new Object[b];
        }
        this.f210e = 0;
    }

    private void m250d() {
        int i = this.f210e;
        long[] jArr = this.f208c;
        Object[] objArr = this.f209d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f206a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f207b = false;
        this.f210e = i2;
    }

    public long m251a(int i) {
        if (this.f207b) {
            m250d();
        }
        return this.f208c[i];
    }

    public C0040f m252a() {
        try {
            C0040f c0040f = (C0040f) super.clone();
            try {
                c0040f.f208c = (long[]) this.f208c.clone();
                c0040f.f209d = (Object[]) this.f209d.clone();
                return c0040f;
            } catch (CloneNotSupportedException e) {
                return c0040f;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public void m253a(int i, Object obj) {
        if (this.f207b) {
            m250d();
        }
        this.f209d[i] = obj;
    }

    public void m254a(long j) {
        int a = C0037c.m244a(this.f208c, this.f210e, j);
        if (a >= 0 && this.f209d[a] != f206a) {
            this.f209d[a] = f206a;
            this.f207b = true;
        }
    }

    public void m255a(long j, Object obj) {
        int a = C0037c.m244a(this.f208c, this.f210e, j);
        if (a >= 0) {
            this.f209d[a] = obj;
            return;
        }
        a ^= -1;
        if (a >= this.f210e || this.f209d[a] != f206a) {
            if (this.f207b && this.f210e >= this.f208c.length) {
                m250d();
                a = C0037c.m244a(this.f208c, this.f210e, j) ^ -1;
            }
            if (this.f210e >= this.f208c.length) {
                int b = C0037c.m246b(this.f210e + 1);
                Object obj2 = new long[b];
                Object obj3 = new Object[b];
                System.arraycopy(this.f208c, 0, obj2, 0, this.f208c.length);
                System.arraycopy(this.f209d, 0, obj3, 0, this.f209d.length);
                this.f208c = obj2;
                this.f209d = obj3;
            }
            if (this.f210e - a != 0) {
                System.arraycopy(this.f208c, a, this.f208c, a + 1, this.f210e - a);
                System.arraycopy(this.f209d, a, this.f209d, a + 1, this.f210e - a);
            }
            this.f208c[a] = j;
            this.f209d[a] = obj;
            this.f210e++;
            return;
        }
        this.f208c[a] = j;
        this.f209d[a] = obj;
    }

    public int m256b() {
        if (this.f207b) {
            m250d();
        }
        return this.f210e;
    }

    public Object m257b(int i) {
        if (this.f207b) {
            m250d();
        }
        return this.f209d[i];
    }

    public void m258c() {
        int i = this.f210e;
        Object[] objArr = this.f209d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f210e = 0;
        this.f207b = false;
    }

    public /* synthetic */ Object clone() {
        return m252a();
    }

    public String toString() {
        if (m256b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f210e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f210e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(m251a(i));
            stringBuilder.append('=');
            C0040f b = m257b(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
