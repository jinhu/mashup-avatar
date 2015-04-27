package android.support.v4.p002c;

import java.util.Map;

/* renamed from: android.support.v4.c.m */
public class C0033m {
    static Object[] f189b;
    static int f190c;
    static Object[] f191d;
    static int f192e;
    int[] f193f;
    Object[] f194g;
    int f195h;

    public C0033m() {
        this.f193f = C0037c.f201a;
        this.f194g = C0037c.f203c;
        this.f195h = 0;
    }

    private static void m204a(int[] iArr, Object[] objArr, int i) {
        int i2;
        if (iArr.length == 8) {
            synchronized (C0034a.class) {
                if (f192e < 10) {
                    objArr[0] = f191d;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f191d = objArr;
                    f192e++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (C0034a.class) {
                if (f190c < 10) {
                    objArr[0] = f189b;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f189b = objArr;
                    f190c++;
                }
            }
        }
    }

    private void m205e(int i) {
        Object[] objArr;
        if (i == 8) {
            synchronized (C0034a.class) {
                if (f191d != null) {
                    objArr = f191d;
                    this.f194g = objArr;
                    f191d = (Object[]) objArr[0];
                    this.f193f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f192e--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (C0034a.class) {
                if (f189b != null) {
                    objArr = f189b;
                    this.f194g = objArr;
                    f189b = (Object[]) objArr[0];
                    this.f193f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f190c--;
                    return;
                }
            }
        }
        this.f193f = new int[i];
        this.f194g = new Object[(i << 1)];
    }

    int m206a() {
        int i = this.f195h;
        if (i == 0) {
            return -1;
        }
        int a = C0037c.m243a(this.f193f, i, 0);
        if (a < 0 || this.f194g[a << 1] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.f193f[i2] == 0) {
            if (this.f194g[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        a--;
        while (a >= 0 && this.f193f[a] == 0) {
            if (this.f194g[a << 1] == null) {
                return a;
            }
            a--;
        }
        return i2 ^ -1;
    }

    int m207a(Object obj) {
        int i = 1;
        int i2 = this.f195h * 2;
        Object[] objArr = this.f194g;
        if (obj == null) {
            while (i < i2) {
                if (objArr[i] == null) {
                    return i >> 1;
                }
                i += 2;
            }
        } else {
            while (i < i2) {
                if (obj.equals(objArr[i])) {
                    return i >> 1;
                }
                i += 2;
            }
        }
        return -1;
    }

    int m208a(Object obj, int i) {
        int i2 = this.f195h;
        if (i2 == 0) {
            return -1;
        }
        int a = C0037c.m243a(this.f193f, i2, i);
        if (a < 0 || obj.equals(this.f194g[a << 1])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.f193f[i3] == i) {
            if (obj.equals(this.f194g[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        a--;
        while (a >= 0 && this.f193f[a] == i) {
            if (obj.equals(this.f194g[a << 1])) {
                return a;
            }
            a--;
        }
        return i3 ^ -1;
    }

    public Object m209a(int i, Object obj) {
        int i2 = (i << 1) + 1;
        Object obj2 = this.f194g[i2];
        this.f194g[i2] = obj;
        return obj2;
    }

    public void m210a(int i) {
        if (this.f193f.length < i) {
            Object obj = this.f193f;
            Object obj2 = this.f194g;
            m205e(i);
            if (this.f195h > 0) {
                System.arraycopy(obj, 0, this.f193f, 0, this.f195h);
                System.arraycopy(obj2, 0, this.f194g, 0, this.f195h << 1);
            }
            C0033m.m204a(obj, obj2, this.f195h);
        }
    }

    public Object m211b(int i) {
        return this.f194g[i << 1];
    }

    public Object m212c(int i) {
        return this.f194g[(i << 1) + 1];
    }

    public void clear() {
        if (this.f195h != 0) {
            C0033m.m204a(this.f193f, this.f194g, this.f195h);
            this.f193f = C0037c.f201a;
            this.f194g = C0037c.f203c;
            this.f195h = 0;
        }
    }

    public boolean containsKey(Object obj) {
        return obj == null ? m206a() >= 0 : m208a(obj, obj.hashCode()) >= 0;
    }

    public boolean containsValue(Object obj) {
        return m207a(obj) >= 0;
    }

    public Object m213d(int i) {
        int i2 = 8;
        Object obj = this.f194g[(i << 1) + 1];
        if (this.f195h <= 1) {
            C0033m.m204a(this.f193f, this.f194g, this.f195h);
            this.f193f = C0037c.f201a;
            this.f194g = C0037c.f203c;
            this.f195h = 0;
        } else if (this.f193f.length <= 8 || this.f195h >= this.f193f.length / 3) {
            this.f195h--;
            if (i < this.f195h) {
                System.arraycopy(this.f193f, i + 1, this.f193f, i, this.f195h - i);
                System.arraycopy(this.f194g, (i + 1) << 1, this.f194g, i << 1, (this.f195h - i) << 1);
            }
            this.f194g[this.f195h << 1] = null;
            this.f194g[(this.f195h << 1) + 1] = null;
        } else {
            if (this.f195h > 8) {
                i2 = this.f195h + (this.f195h >> 1);
            }
            Object obj2 = this.f193f;
            Object obj3 = this.f194g;
            m205e(i2);
            this.f195h--;
            if (i > 0) {
                System.arraycopy(obj2, 0, this.f193f, 0, i);
                System.arraycopy(obj3, 0, this.f194g, 0, i << 1);
            }
            if (i < this.f195h) {
                System.arraycopy(obj2, i + 1, this.f193f, i, this.f195h - i);
                System.arraycopy(obj3, (i + 1) << 1, this.f194g, i << 1, (this.f195h - i) << 1);
            }
        }
        return obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        int i = 0;
        while (i < this.f195h) {
            try {
                Object b = m211b(i);
                Object c = m212c(i);
                Object obj2 = map.get(b);
                if (c == null) {
                    if (obj2 != null || !map.containsKey(b)) {
                        return false;
                    }
                } else if (!c.equals(obj2)) {
                    return false;
                }
                i++;
            } catch (NullPointerException e) {
                return false;
            } catch (ClassCastException e2) {
                return false;
            }
        }
        return true;
    }

    public Object get(Object obj) {
        int a = obj == null ? m206a() : m208a(obj, obj.hashCode());
        return a >= 0 ? this.f194g[(a << 1) + 1] : null;
    }

    public int hashCode() {
        int[] iArr = this.f193f;
        Object[] objArr = this.f194g;
        int i = this.f195h;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public boolean isEmpty() {
        return this.f195h <= 0;
    }

    public Object put(Object obj, Object obj2) {
        int a;
        int i;
        int i2 = 8;
        if (obj == null) {
            a = m206a();
            i = 0;
        } else {
            i = obj.hashCode();
            a = m208a(obj, i);
        }
        if (a >= 0) {
            int i3 = (a << 1) + 1;
            Object obj3 = this.f194g[i3];
            this.f194g[i3] = obj2;
            return obj3;
        }
        a ^= -1;
        if (this.f195h >= this.f193f.length) {
            if (this.f195h >= 8) {
                i2 = this.f195h + (this.f195h >> 1);
            } else if (this.f195h < 4) {
                i2 = 4;
            }
            Object obj4 = this.f193f;
            Object obj5 = this.f194g;
            m205e(i2);
            if (this.f193f.length > 0) {
                System.arraycopy(obj4, 0, this.f193f, 0, obj4.length);
                System.arraycopy(obj5, 0, this.f194g, 0, obj5.length);
            }
            C0033m.m204a(obj4, obj5, this.f195h);
        }
        if (a < this.f195h) {
            System.arraycopy(this.f193f, a, this.f193f, a + 1, this.f195h - a);
            System.arraycopy(this.f194g, a << 1, this.f194g, (a + 1) << 1, (this.f195h - a) << 1);
        }
        this.f193f[a] = i;
        this.f194g[a << 1] = obj;
        this.f194g[(a << 1) + 1] = obj2;
        this.f195h++;
        return null;
    }

    public Object remove(Object obj) {
        int a = obj == null ? m206a() : m208a(obj, obj.hashCode());
        return a >= 0 ? m213d(a) : null;
    }

    public int size() {
        return this.f195h;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f195h * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f195h; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            C0033m b = m211b(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
            stringBuilder.append('=');
            b = m212c(i);
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
