package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.support.v4.p002c.C0033m;
import android.support.v4.p002c.C0038d;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class Fragment implements ComponentCallbacks, OnCreateContextMenuListener {
    private static final C0033m f17P;
    boolean f18A;
    boolean f19B;
    boolean f20C;
    boolean f21D;
    boolean f22E;
    boolean f23F;
    int f24G;
    ViewGroup f25H;
    View f26I;
    View f27J;
    boolean f28K;
    boolean f29L;
    C0026y f30M;
    boolean f31N;
    boolean f32O;
    int f33a;
    View f34b;
    int f35c;
    Bundle f36d;
    SparseArray f37e;
    int f38f;
    String f39g;
    Bundle f40h;
    Fragment f41i;
    int f42j;
    int f43k;
    boolean f44l;
    boolean f45m;
    boolean f46n;
    boolean f47o;
    boolean f48p;
    boolean f49q;
    int f50r;
    C0016n f51s;
    C0011h f52t;
    C0016n f53u;
    Fragment f54v;
    int f55w;
    int f56x;
    String f57y;
    boolean f58z;

    public class SavedState implements Parcelable {
        public static final Creator CREATOR;
        final Bundle f16a;

        static {
            CREATOR = new C0010g();
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            this.f16a = parcel.readBundle();
            if (classLoader != null && this.f16a != null) {
                this.f16a.setClassLoader(classLoader);
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.f16a);
        }
    }

    static {
        f17P = new C0033m();
    }

    public Fragment() {
        this.f33a = 0;
        this.f38f = -1;
        this.f42j = -1;
        this.f22E = true;
        this.f29L = true;
    }

    public static Fragment m11a(Context context, String str) {
        return m12a(context, str, null);
    }

    public static Fragment m12a(Context context, String str, Bundle bundle) {
        try {
            Class cls = (Class) f17P.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                f17P.put(str, cls);
            }
            Fragment fragment = (Fragment) cls.newInstance();
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.f40h = bundle;
            }
            return fragment;
        } catch (Exception e) {
            throw new C0009f("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e);
        } catch (Exception e2) {
            throw new C0009f("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e2);
        } catch (Exception e22) {
            throw new C0009f("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e22);
        }
    }

    static boolean m13b(Context context, String str) {
        try {
            Class cls = (Class) f17P.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                f17P.put(str, cls);
            }
            return Fragment.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public View m14a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return null;
    }

    public Animation m15a(int i, boolean z, int i2) {
        return null;
    }

    public void m16a(int i, int i2, Intent intent) {
    }

    final void m17a(int i, Fragment fragment) {
        this.f38f = i;
        if (fragment != null) {
            this.f39g = fragment.f39g + ":" + this.f38f;
        } else {
            this.f39g = "android:fragment:" + this.f38f;
        }
    }

    public void m18a(Activity activity) {
        this.f23F = true;
    }

    public void m19a(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.f23F = true;
    }

    void m20a(Configuration configuration) {
        onConfigurationChanged(configuration);
        if (this.f53u != null) {
            this.f53u.m122a(configuration);
        }
    }

    final void m21a(Bundle bundle) {
        if (this.f37e != null) {
            this.f27J.restoreHierarchyState(this.f37e);
            this.f37e = null;
        }
        this.f23F = false;
        m44e(bundle);
        if (!this.f23F) {
            throw new ab("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    public void m22a(Menu menu) {
    }

    public void m23a(Menu menu, MenuInflater menuInflater) {
    }

    public void m24a(View view, @Nullable Bundle bundle) {
    }

    public void m25a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.f55w));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.f56x));
        printWriter.print(" mTag=");
        printWriter.println(this.f57y);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f33a);
        printWriter.print(" mIndex=");
        printWriter.print(this.f38f);
        printWriter.print(" mWho=");
        printWriter.print(this.f39g);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.f50r);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f44l);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f45m);
        printWriter.print(" mResumed=");
        printWriter.print(this.f46n);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f47o);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f48p);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.f58z);
        printWriter.print(" mDetached=");
        printWriter.print(this.f18A);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.f22E);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.f21D);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.f19B);
        printWriter.print(" mRetaining=");
        printWriter.print(this.f20C);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.f29L);
        if (this.f51s != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.f51s);
        }
        if (this.f52t != null) {
            printWriter.print(str);
            printWriter.print("mActivity=");
            printWriter.println(this.f52t);
        }
        if (this.f54v != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.f54v);
        }
        if (this.f40h != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f40h);
        }
        if (this.f36d != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f36d);
        }
        if (this.f37e != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f37e);
        }
        if (this.f41i != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.f41i);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f43k);
        }
        if (this.f24G != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(this.f24G);
        }
        if (this.f25H != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.f25H);
        }
        if (this.f26I != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.f26I);
        }
        if (this.f27J != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.f26I);
        }
        if (this.f34b != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(this.f34b);
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(this.f35c);
        }
        if (this.f30M != null) {
            printWriter.print(str);
            printWriter.println("Loader Manager:");
            this.f30M.m183a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.f53u != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.f53u + ":");
            this.f53u.m131a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    public void m26a(boolean z) {
    }

    final boolean m27a() {
        return this.f50r > 0;
    }

    public boolean m28a(MenuItem menuItem) {
        return false;
    }

    public final C0011h m29b() {
        return this.f52t;
    }

    public LayoutInflater m30b(Bundle bundle) {
        return this.f52t.getLayoutInflater();
    }

    View m31b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f53u != null) {
            this.f53u.m156i();
        }
        return m14a(layoutInflater, viewGroup, bundle);
    }

    public void m32b(Menu menu) {
    }

    boolean m33b(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.f58z) {
            return false;
        }
        if (this.f21D && this.f22E) {
            z = true;
            m23a(menu, menuInflater);
        }
        return this.f53u != null ? z | this.f53u.m134a(menu, menuInflater) : z;
    }

    public boolean m34b(MenuItem menuItem) {
        return false;
    }

    public final Resources m35c() {
        if (this.f52t != null) {
            return this.f52t.getResources();
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void m36c(Bundle bundle) {
        this.f23F = true;
    }

    boolean m37c(Menu menu) {
        boolean z = false;
        if (this.f58z) {
            return false;
        }
        if (this.f21D && this.f22E) {
            z = true;
            m22a(menu);
        }
        return this.f53u != null ? z | this.f53u.m133a(menu) : z;
    }

    boolean m38c(MenuItem menuItem) {
        if (!this.f58z) {
            if (this.f21D && this.f22E && m28a(menuItem)) {
                return true;
            }
            if (this.f53u != null && this.f53u.m135a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void m39d(@Nullable Bundle bundle) {
        this.f23F = true;
    }

    void m40d(Menu menu) {
        if (!this.f58z) {
            if (this.f21D && this.f22E) {
                m32b(menu);
            }
            if (this.f53u != null) {
                this.f53u.m140b(menu);
            }
        }
    }

    public final boolean m41d() {
        return this.f18A;
    }

    boolean m42d(MenuItem menuItem) {
        if (!this.f58z) {
            if (m34b(menuItem)) {
                return true;
            }
            if (this.f53u != null && this.f53u.m142b(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void m43e() {
        this.f23F = true;
        if (!this.f31N) {
            this.f31N = true;
            if (!this.f32O) {
                this.f32O = true;
                this.f30M = this.f52t.m94a(this.f39g, this.f31N, false);
            }
            if (this.f30M != null) {
                this.f30M.m185b();
            }
        }
    }

    public void m44e(@Nullable Bundle bundle) {
        this.f23F = true;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void m45f() {
        this.f23F = true;
    }

    public void m46f(Bundle bundle) {
    }

    public void m47g() {
        this.f23F = true;
    }

    void m48g(Bundle bundle) {
        if (this.f53u != null) {
            this.f53u.m156i();
        }
        this.f23F = false;
        m36c(bundle);
        if (!this.f23F) {
            throw new ab("Fragment " + this + " did not call through to super.onCreate()");
        } else if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            if (parcelable != null) {
                if (this.f53u == null) {
                    m57n();
                }
                this.f53u.m124a(parcelable, null);
                this.f53u.m157j();
            }
        }
    }

    public void m49h() {
        this.f23F = true;
    }

    void m50h(Bundle bundle) {
        if (this.f53u != null) {
            this.f53u.m156i();
        }
        this.f23F = false;
        m39d(bundle);
        if (!this.f23F) {
            throw new ab("Fragment " + this + " did not call through to super.onActivityCreated()");
        } else if (this.f53u != null) {
            this.f53u.m158k();
        }
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public void m51i() {
        this.f23F = true;
    }

    void m52i(Bundle bundle) {
        m46f(bundle);
        if (this.f53u != null) {
            Parcelable h = this.f53u.m155h();
            if (h != null) {
                bundle.putParcelable("android:support:fragments", h);
            }
        }
    }

    public void m53j() {
        this.f23F = true;
        if (!this.f32O) {
            this.f32O = true;
            this.f30M = this.f52t.m94a(this.f39g, this.f31N, false);
        }
        if (this.f30M != null) {
            this.f30M.m191h();
        }
    }

    void m54k() {
        this.f38f = -1;
        this.f39g = null;
        this.f44l = false;
        this.f45m = false;
        this.f46n = false;
        this.f47o = false;
        this.f48p = false;
        this.f49q = false;
        this.f50r = 0;
        this.f51s = null;
        this.f53u = null;
        this.f52t = null;
        this.f55w = 0;
        this.f56x = 0;
        this.f57y = null;
        this.f58z = false;
        this.f18A = false;
        this.f20C = false;
        this.f30M = null;
        this.f31N = false;
        this.f32O = false;
    }

    public void m55l() {
        this.f23F = true;
    }

    public void m56m() {
    }

    void m57n() {
        this.f53u = new C0016n();
        this.f53u.m129a(this.f52t, new C0008e(this), this);
    }

    void m58o() {
        if (this.f53u != null) {
            this.f53u.m156i();
            this.f53u.m151e();
        }
        this.f23F = false;
        m43e();
        if (this.f23F) {
            if (this.f53u != null) {
                this.f53u.m159l();
            }
            if (this.f30M != null) {
                this.f30M.m190g();
                return;
            }
            return;
        }
        throw new ab("Fragment " + this + " did not call through to super.onStart()");
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.f23F = true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        m29b().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onLowMemory() {
        this.f23F = true;
    }

    void m59p() {
        if (this.f53u != null) {
            this.f53u.m156i();
            this.f53u.m151e();
        }
        this.f23F = false;
        m45f();
        if (!this.f23F) {
            throw new ab("Fragment " + this + " did not call through to super.onResume()");
        } else if (this.f53u != null) {
            this.f53u.m160m();
            this.f53u.m151e();
        }
    }

    void m60q() {
        onLowMemory();
        if (this.f53u != null) {
            this.f53u.m166s();
        }
    }

    void m61r() {
        if (this.f53u != null) {
            this.f53u.m161n();
        }
        this.f23F = false;
        m47g();
        if (!this.f23F) {
            throw new ab("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    void m62s() {
        if (this.f53u != null) {
            this.f53u.m162o();
        }
        this.f23F = false;
        m49h();
        if (!this.f23F) {
            throw new ab("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    void m63t() {
        if (this.f53u != null) {
            this.f53u.m163p();
        }
        if (this.f31N) {
            this.f31N = false;
            if (!this.f32O) {
                this.f32O = true;
                this.f30M = this.f52t.m94a(this.f39g, this.f31N, false);
            }
            if (this.f30M == null) {
                return;
            }
            if (this.f52t.f117h) {
                this.f30M.m187d();
            } else {
                this.f30M.m186c();
            }
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        C0038d.m248a(this, stringBuilder);
        if (this.f38f >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.f38f);
        }
        if (this.f55w != 0) {
            stringBuilder.append(" id=0x");
            stringBuilder.append(Integer.toHexString(this.f55w));
        }
        if (this.f57y != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.f57y);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    void m64u() {
        if (this.f53u != null) {
            this.f53u.m164q();
        }
        this.f23F = false;
        m51i();
        if (!this.f23F) {
            throw new ab("Fragment " + this + " did not call through to super.onDestroyView()");
        } else if (this.f30M != null) {
            this.f30M.m189f();
        }
    }

    void m65v() {
        if (this.f53u != null) {
            this.f53u.m165r();
        }
        this.f23F = false;
        m53j();
        if (!this.f23F) {
            throw new ab("Fragment " + this + " did not call through to super.onDestroy()");
        }
    }
}
