package android.support.v4.app;

import android.support.v4.p002c.C0038d;
import android.support.v4.p002c.C0046n;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: android.support.v4.app.y */
class C0026y extends C0024w {
    static boolean f165a;
    final C0046n f166b;
    final C0046n f167c;
    final String f168d;
    C0011h f169e;
    boolean f170f;
    boolean f171g;

    static {
        f165a = false;
    }

    C0026y(String str, C0011h c0011h, boolean z) {
        this.f166b = new C0046n();
        this.f167c = new C0046n();
        this.f168d = str;
        this.f169e = c0011h;
        this.f170f = z;
    }

    void m182a(C0011h c0011h) {
        this.f169e = c0011h;
    }

    public void m183a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i = 0;
        if (this.f166b.m265b() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i2 = 0; i2 < this.f166b.m265b(); i2++) {
                C0027z c0027z = (C0027z) this.f166b.m268c(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f166b.m266b(i2));
                printWriter.print(": ");
                printWriter.println(c0027z.toString());
                c0027z.m194a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.f167c.m265b() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            while (i < this.f167c.m265b()) {
                c0027z = (C0027z) this.f167c.m268c(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f167c.m266b(i));
                printWriter.print(": ");
                printWriter.println(c0027z.toString());
                c0027z.m194a(str3, fileDescriptor, printWriter, strArr);
                i++;
            }
        }
    }

    public boolean m184a() {
        int b = this.f166b.m265b();
        boolean z = false;
        for (int i = 0; i < b; i++) {
            C0027z c0027z = (C0027z) this.f166b.m268c(i);
            int i2 = (!c0027z.f179h || c0027z.f177f) ? 0 : 1;
            z |= i2;
        }
        return z;
    }

    void m185b() {
        if (f165a) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.f170f) {
            Throwable runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
            return;
        }
        this.f170f = true;
        for (int b = this.f166b.m265b() - 1; b >= 0; b--) {
            ((C0027z) this.f166b.m268c(b)).m192a();
        }
    }

    void m186c() {
        if (f165a) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (this.f170f) {
            for (int b = this.f166b.m265b() - 1; b >= 0; b--) {
                ((C0027z) this.f166b.m268c(b)).m198e();
            }
            this.f170f = false;
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
    }

    void m187d() {
        if (f165a) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (this.f170f) {
            this.f171g = true;
            this.f170f = false;
            for (int b = this.f166b.m265b() - 1; b >= 0; b--) {
                ((C0027z) this.f166b.m268c(b)).m195b();
            }
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
    }

    void m188e() {
        if (this.f171g) {
            if (f165a) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.f171g = false;
            for (int b = this.f166b.m265b() - 1; b >= 0; b--) {
                ((C0027z) this.f166b.m268c(b)).m196c();
            }
        }
    }

    void m189f() {
        for (int b = this.f166b.m265b() - 1; b >= 0; b--) {
            ((C0027z) this.f166b.m268c(b)).f182k = true;
        }
    }

    void m190g() {
        for (int b = this.f166b.m265b() - 1; b >= 0; b--) {
            ((C0027z) this.f166b.m268c(b)).m197d();
        }
    }

    void m191h() {
        int b;
        if (!this.f171g) {
            if (f165a) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (b = this.f166b.m265b() - 1; b >= 0; b--) {
                ((C0027z) this.f166b.m268c(b)).m199f();
            }
            this.f166b.m269c();
        }
        if (f165a) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (b = this.f167c.m265b() - 1; b >= 0; b--) {
            ((C0027z) this.f167c.m268c(b)).m199f();
        }
        this.f167c.m269c();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        C0038d.m248a(this.f169e, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }
}
