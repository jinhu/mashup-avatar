package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.p002c.C0038d;
import android.support.v4.p002c.C0039e;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import com.google.android.apps.androidify.cm;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

/* renamed from: android.support.v4.app.n */
final class C0016n extends C0014l {
    static final Interpolator f129A;
    static final Interpolator f130B;
    static final Interpolator f131C;
    static boolean f132a;
    static final boolean f133b;
    static final Interpolator f134z;
    ArrayList f135c;
    Runnable[] f136d;
    boolean f137e;
    ArrayList f138f;
    ArrayList f139g;
    ArrayList f140h;
    ArrayList f141i;
    ArrayList f142j;
    ArrayList f143k;
    ArrayList f144l;
    ArrayList f145m;
    int f146n;
    C0011h f147o;
    C0007k f148p;
    Fragment f149q;
    boolean f150r;
    boolean f151s;
    boolean f152t;
    String f153u;
    boolean f154v;
    Bundle f155w;
    SparseArray f156x;
    Runnable f157y;

    static {
        boolean z = false;
        f132a = false;
        if (VERSION.SDK_INT >= 11) {
            z = true;
        }
        f133b = z;
        f134z = new DecelerateInterpolator(2.5f);
        f129A = new DecelerateInterpolator(1.5f);
        f130B = new AccelerateInterpolator(2.5f);
        f131C = new AccelerateInterpolator(1.5f);
    }

    C0016n() {
        this.f146n = 0;
        this.f155w = null;
        this.f156x = null;
        this.f157y = new C0017o(this);
    }

    static Animation m107a(Context context, float f, float f2) {
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(f129A);
        alphaAnimation.setDuration(220);
        return alphaAnimation;
    }

    static Animation m108a(Context context, float f, float f2, float f3, float f4) {
        Animation animationSet = new AnimationSet(false);
        Animation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f134z);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        scaleAnimation = new AlphaAnimation(f3, f4);
        scaleAnimation.setInterpolator(f129A);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        return animationSet;
    }

    private void m109a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new C0039e("FragmentManager"));
        if (this.f147o != null) {
            try {
                this.f147o.dump("  ", null, printWriter, new String[0]);
            } catch (Throwable e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            try {
                m131a("  ", null, printWriter, new String[0]);
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    public static int m110b(int i, boolean z) {
        switch (i) {
            case 4097:
                return z ? 1 : 2;
            case 4099:
                return z ? 5 : 6;
            case 8194:
                return z ? 3 : 4;
            default:
                return -1;
        }
    }

    public static int m111c(int i) {
        switch (i) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    private void m112t() {
        if (this.f151s) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.f153u != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.f153u);
        }
    }

    public int m113a(C0004b c0004b) {
        int size;
        synchronized (this) {
            if (this.f144l == null || this.f144l.size() <= 0) {
                if (this.f143k == null) {
                    this.f143k = new ArrayList();
                }
                size = this.f143k.size();
                if (f132a) {
                    Log.v("FragmentManager", "Setting back stack index " + size + " to " + c0004b);
                }
                this.f143k.add(c0004b);
            } else {
                size = ((Integer) this.f144l.remove(this.f144l.size() - 1)).intValue();
                if (f132a) {
                    Log.v("FragmentManager", "Adding back stack index " + size + " with " + c0004b);
                }
                this.f143k.set(size, c0004b);
            }
        }
        return size;
    }

    public Fragment m114a(int i) {
        int size;
        Fragment fragment;
        if (this.f139g != null) {
            for (size = this.f139g.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f139g.get(size);
                if (fragment != null && fragment.f55w == i) {
                    return fragment;
                }
            }
        }
        if (this.f138f != null) {
            for (size = this.f138f.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f138f.get(size);
                if (fragment != null && fragment.f55w == i) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public Fragment m115a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        if (i >= this.f138f.size()) {
            m109a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        }
        Fragment fragment = (Fragment) this.f138f.get(i);
        if (fragment != null) {
            return fragment;
        }
        m109a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        return fragment;
    }

    public Fragment m116a(String str) {
        int size;
        Fragment fragment;
        if (!(this.f139g == null || str == null)) {
            for (size = this.f139g.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f139g.get(size);
                if (fragment != null && str.equals(fragment.f57y)) {
                    return fragment;
                }
            }
        }
        if (!(this.f138f == null || str == null)) {
            for (size = this.f138f.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f138f.get(size);
                if (fragment != null && str.equals(fragment.f57y)) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public C0003v m117a() {
        return new C0004b(this);
    }

    Animation m118a(Fragment fragment, int i, boolean z, int i2) {
        Animation a = fragment.m15a(i, z, fragment.f24G);
        if (a != null) {
            return a;
        }
        if (fragment.f24G != 0) {
            a = AnimationUtils.loadAnimation(this.f147o, fragment.f24G);
            if (a != null) {
                return a;
            }
        }
        if (i == 0) {
            return null;
        }
        int b = C0016n.m110b(i, z);
        if (b < 0) {
            return null;
        }
        switch (b) {
            case cm.HListView_android_divider /*1*/:
                return C0016n.m108a(this.f147o, 1.125f, 1.0f, 0.0f, 1.0f);
            case cm.HListView_hlv_dividerWidth /*2*/:
                return C0016n.m108a(this.f147o, 1.0f, 0.975f, 1.0f, 0.0f);
            case cm.HListView_hlv_headerDividersEnabled /*3*/:
                return C0016n.m108a(this.f147o, 0.975f, 1.0f, 0.0f, 1.0f);
            case cm.HListView_hlv_footerDividersEnabled /*4*/:
                return C0016n.m108a(this.f147o, 1.0f, 1.075f, 1.0f, 0.0f);
            case cm.HListView_hlv_overScrollHeader /*5*/:
                return C0016n.m107a(this.f147o, 0.0f, 1.0f);
            case cm.HListView_hlv_overScrollFooter /*6*/:
                return C0016n.m107a(this.f147o, 1.0f, 0.0f);
            default:
                if (i2 == 0 && this.f147o.getWindow() != null) {
                    i2 = this.f147o.getWindow().getAttributes().windowAnimations;
                }
                return i2 == 0 ? null : null;
        }
    }

    void m119a(int i, int i2, int i3, boolean z) {
        if (this.f147o == null && i != 0) {
            throw new IllegalStateException("No activity");
        } else if (z || this.f146n != i) {
            this.f146n = i;
            if (this.f138f != null) {
                int i4 = 0;
                int i5 = 0;
                while (i4 < this.f138f.size()) {
                    int a;
                    Fragment fragment = (Fragment) this.f138f.get(i4);
                    if (fragment != null) {
                        m127a(fragment, i, i2, i3, false);
                        if (fragment.f30M != null) {
                            a = i5 | fragment.f30M.m184a();
                            i4++;
                            i5 = a;
                        }
                    }
                    a = i5;
                    i4++;
                    i5 = a;
                }
                if (i5 == 0) {
                    m146d();
                }
                if (this.f150r && this.f147o != null && this.f146n == 5) {
                    this.f147o.m101c();
                    this.f150r = false;
                }
            }
        }
    }

    public void m120a(int i, C0004b c0004b) {
        synchronized (this) {
            if (this.f143k == null) {
                this.f143k = new ArrayList();
            }
            int size = this.f143k.size();
            if (i < size) {
                if (f132a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + c0004b);
                }
                this.f143k.set(i, c0004b);
            } else {
                while (size < i) {
                    this.f143k.add(null);
                    if (this.f144l == null) {
                        this.f144l = new ArrayList();
                    }
                    if (f132a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.f144l.add(Integer.valueOf(size));
                    size++;
                }
                if (f132a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + c0004b);
                }
                this.f143k.add(c0004b);
            }
        }
    }

    void m121a(int i, boolean z) {
        m119a(i, 0, 0, z);
    }

    public void m122a(Configuration configuration) {
        if (this.f139g != null) {
            for (int i = 0; i < this.f139g.size(); i++) {
                Fragment fragment = (Fragment) this.f139g.get(i);
                if (fragment != null) {
                    fragment.m20a(configuration);
                }
            }
        }
    }

    public void m123a(Bundle bundle, String str, Fragment fragment) {
        if (fragment.f38f < 0) {
            m109a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, fragment.f38f);
    }

    void m124a(Parcelable parcelable, ArrayList arrayList) {
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.f59a != null) {
                int i;
                Fragment fragment;
                int i2;
                if (arrayList != null) {
                    for (i = 0; i < arrayList.size(); i++) {
                        fragment = (Fragment) arrayList.get(i);
                        if (f132a) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + fragment);
                        }
                        FragmentState fragmentState = fragmentManagerState.f59a[fragment.f38f];
                        fragmentState.f72k = fragment;
                        fragment.f37e = null;
                        fragment.f50r = 0;
                        fragment.f48p = false;
                        fragment.f44l = false;
                        fragment.f41i = null;
                        if (fragmentState.f71j != null) {
                            fragmentState.f71j.setClassLoader(this.f147o.getClassLoader());
                            fragment.f37e = fragmentState.f71j.getSparseParcelableArray("android:view_state");
                        }
                    }
                }
                this.f138f = new ArrayList(fragmentManagerState.f59a.length);
                if (this.f140h != null) {
                    this.f140h.clear();
                }
                for (i2 = 0; i2 < fragmentManagerState.f59a.length; i2++) {
                    FragmentState fragmentState2 = fragmentManagerState.f59a[i2];
                    if (fragmentState2 != null) {
                        Fragment a = fragmentState2.m66a(this.f147o, this.f149q);
                        if (f132a) {
                            Log.v("FragmentManager", "restoreAllState: active #" + i2 + ": " + a);
                        }
                        this.f138f.add(a);
                        fragmentState2.f72k = null;
                    } else {
                        this.f138f.add(null);
                        if (this.f140h == null) {
                            this.f140h = new ArrayList();
                        }
                        if (f132a) {
                            Log.v("FragmentManager", "restoreAllState: avail #" + i2);
                        }
                        this.f140h.add(Integer.valueOf(i2));
                    }
                }
                if (arrayList != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        fragment = (Fragment) arrayList.get(i3);
                        if (fragment.f42j >= 0) {
                            if (fragment.f42j < this.f138f.size()) {
                                fragment.f41i = (Fragment) this.f138f.get(fragment.f42j);
                            } else {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + fragment + " target no longer exists: " + fragment.f42j);
                                fragment.f41i = null;
                            }
                        }
                    }
                }
                if (fragmentManagerState.f60b != null) {
                    this.f139g = new ArrayList(fragmentManagerState.f60b.length);
                    for (i = 0; i < fragmentManagerState.f60b.length; i++) {
                        fragment = (Fragment) this.f138f.get(fragmentManagerState.f60b[i]);
                        if (fragment == null) {
                            m109a(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.f60b[i]));
                        }
                        fragment.f44l = true;
                        if (f132a) {
                            Log.v("FragmentManager", "restoreAllState: added #" + i + ": " + fragment);
                        }
                        if (this.f139g.contains(fragment)) {
                            throw new IllegalStateException("Already added!");
                        }
                        this.f139g.add(fragment);
                    }
                } else {
                    this.f139g = null;
                }
                if (fragmentManagerState.f61c != null) {
                    this.f141i = new ArrayList(fragmentManagerState.f61c.length);
                    for (i2 = 0; i2 < fragmentManagerState.f61c.length; i2++) {
                        C0004b a2 = fragmentManagerState.f61c[i2].m10a(this);
                        if (f132a) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i2 + " (index " + a2.f95o + "): " + a2);
                            a2.m82a("  ", new PrintWriter(new C0039e("FragmentManager")), false);
                        }
                        this.f141i.add(a2);
                        if (a2.f95o >= 0) {
                            m120a(a2.f95o, a2);
                        }
                    }
                    return;
                }
                this.f141i = null;
            }
        }
    }

    public void m125a(Fragment fragment) {
        if (!fragment.f28K) {
            return;
        }
        if (this.f137e) {
            this.f154v = true;
            return;
        }
        fragment.f28K = false;
        m127a(fragment, this.f146n, 0, 0, false);
    }

    public void m126a(Fragment fragment, int i, int i2) {
        if (f132a) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.f50r);
        }
        boolean z = !fragment.m27a();
        if (!fragment.f18A || z) {
            if (this.f139g != null) {
                this.f139g.remove(fragment);
            }
            if (fragment.f21D && fragment.f22E) {
                this.f150r = true;
            }
            fragment.f44l = false;
            fragment.f45m = true;
            m127a(fragment, z ? 0 : 1, i, i2, false);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m127a(Fragment fragment, int i, int i2, int i3, boolean z) {
        if ((!fragment.f44l || fragment.f18A) && i > 1) {
            i = 1;
        }
        if (fragment.f45m && r11 > fragment.f33a) {
            i = fragment.f33a;
        }
        if (fragment.f28K && fragment.f33a < 4 && r11 > 3) {
            i = 3;
        }
        if (fragment.f33a >= i) {
            if (fragment.f33a > i) {
                switch (fragment.f33a) {
                    case cm.HListView_android_divider /*1*/:
                        break;
                    case cm.HListView_hlv_dividerWidth /*2*/:
                        break;
                    case cm.HListView_hlv_headerDividersEnabled /*3*/:
                        break;
                    case cm.HListView_hlv_footerDividersEnabled /*4*/:
                        break;
                    case cm.HListView_hlv_overScrollHeader /*5*/:
                        if (i < 5) {
                            if (f132a) {
                                Log.v("FragmentManager", "movefrom RESUMED: " + fragment);
                            }
                            fragment.m61r();
                            fragment.f46n = false;
                            break;
                        }
                        break;
                    default:
                        break;
                }
            }
        } else if (!fragment.f47o || fragment.f48p) {
            if (fragment.f34b != null) {
                fragment.f34b = null;
                m127a(fragment, fragment.f35c, 0, 0, true);
            }
            switch (fragment.f33a) {
                case cm.HListView_android_entries /*0*/:
                    if (f132a) {
                        Log.v("FragmentManager", "moveto CREATED: " + fragment);
                    }
                    if (fragment.f36d != null) {
                        fragment.f37e = fragment.f36d.getSparseParcelableArray("android:view_state");
                        fragment.f41i = m115a(fragment.f36d, "android:target_state");
                        if (fragment.f41i != null) {
                            fragment.f43k = fragment.f36d.getInt("android:target_req_state", 0);
                        }
                        fragment.f29L = fragment.f36d.getBoolean("android:user_visible_hint", true);
                        if (!fragment.f29L) {
                            fragment.f28K = true;
                            if (i > 3) {
                                i = 3;
                            }
                        }
                    }
                    fragment.f52t = this.f147o;
                    fragment.f54v = this.f149q;
                    fragment.f51s = this.f149q != null ? this.f149q.f53u : this.f147o.f111b;
                    fragment.f23F = false;
                    fragment.m18a(this.f147o);
                    if (fragment.f23F) {
                        if (fragment.f54v == null) {
                            this.f147o.m96a(fragment);
                        }
                        if (!fragment.f20C) {
                            fragment.m48g(fragment.f36d);
                        }
                        fragment.f20C = false;
                        if (fragment.f47o) {
                            fragment.f26I = fragment.m31b(fragment.m30b(fragment.f36d), null, fragment.f36d);
                            if (fragment.f26I == null) {
                                fragment.f27J = null;
                                break;
                            }
                            fragment.f27J = fragment.f26I;
                            fragment.f26I = aa.m69a(fragment.f26I);
                            if (fragment.f58z) {
                                fragment.f26I.setVisibility(8);
                            }
                            fragment.m24a(fragment.f26I, fragment.f36d);
                            break;
                        }
                    }
                    throw new ab("Fragment " + fragment + " did not call through to super.onAttach()");
                    break;
                case cm.HListView_android_divider /*1*/:
                    break;
                case cm.HListView_hlv_dividerWidth /*2*/:
                case cm.HListView_hlv_headerDividersEnabled /*3*/:
                    break;
                case cm.HListView_hlv_footerDividersEnabled /*4*/:
                    break;
            }
        } else {
            return;
        }
        fragment.f33a = i;
    }

    public void m128a(Fragment fragment, boolean z) {
        if (this.f139g == null) {
            this.f139g = new ArrayList();
        }
        if (f132a) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        m143c(fragment);
        if (!fragment.f18A) {
            if (this.f139g.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            this.f139g.add(fragment);
            fragment.f44l = true;
            fragment.f45m = false;
            if (fragment.f21D && fragment.f22E) {
                this.f150r = true;
            }
            if (z) {
                m137b(fragment);
            }
        }
    }

    public void m129a(C0011h c0011h, C0007k c0007k, Fragment fragment) {
        if (this.f147o != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f147o = c0011h;
        this.f148p = c0007k;
        this.f149q = fragment;
    }

    public void m130a(Runnable runnable, boolean z) {
        if (!z) {
            m112t();
        }
        synchronized (this) {
            if (this.f152t || this.f147o == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
            if (this.f135c == null) {
                this.f135c = new ArrayList();
            }
            this.f135c.add(runnable);
            if (this.f135c.size() == 1) {
                this.f147o.f110a.removeCallbacks(this.f157y);
                this.f147o.f110a.post(this.f157y);
            }
        }
    }

    public void m131a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int i;
        int i2 = 0;
        String str2 = str + "    ";
        if (this.f138f != null) {
            size = this.f138f.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (i = 0; i < size; i++) {
                    Fragment fragment;
                    fragment = (Fragment) this.f138f.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment);
                    if (fragment != null) {
                        fragment.m25a(str2, fileDescriptor, printWriter, strArr);
                    }
                }
            }
        }
        if (this.f139g != null) {
            size = this.f139g.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Added Fragments:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.f139g.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.f142j != null) {
            size = this.f142j.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.f142j.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.f141i != null) {
            size = this.f141i.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (i = 0; i < size; i++) {
                    C0004b c0004b = (C0004b) this.f141i.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(c0004b.toString());
                    c0004b.m81a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        synchronized (this) {
            if (this.f143k != null) {
                int size2 = this.f143k.size();
                if (size2 > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (i = 0; i < size2; i++) {
                        c0004b = (C0004b) this.f143k.get(i);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i);
                        printWriter.print(": ");
                        printWriter.println(c0004b);
                    }
                }
            }
            if (this.f144l != null && this.f144l.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.f144l.toArray()));
            }
        }
        if (this.f135c != null) {
            i = this.f135c.size();
            if (i > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                while (i2 < i) {
                    Runnable runnable = (Runnable) this.f135c.get(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(runnable);
                    i2++;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mActivity=");
        printWriter.println(this.f147o);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f148p);
        if (this.f149q != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f149q);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f146n);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f151s);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f152t);
        if (this.f150r) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f150r);
        }
        if (this.f153u != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.f153u);
        }
        if (this.f140h != null && this.f140h.size() > 0) {
            printWriter.print(str);
            printWriter.print("  mAvailIndices: ");
            printWriter.println(Arrays.toString(this.f140h.toArray()));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    boolean m132a(Handler handler, String str, int i, int i2) {
        if (this.f141i == null) {
            return false;
        }
        int size;
        if (str == null && i < 0 && (i2 & 1) == 0) {
            size = this.f141i.size() - 1;
            if (size < 0) {
                return false;
            }
            ((C0004b) this.f141i.remove(size)).m85b(true);
            m153f();
        } else {
            int size2;
            size = -1;
            if (str != null || i >= 0) {
                C0004b c0004b;
                size2 = this.f141i.size() - 1;
                while (size2 >= 0) {
                    c0004b = (C0004b) this.f141i.get(size2);
                    if ((str == null || !str.equals(c0004b.m84b())) && (i < 0 || i != c0004b.f95o)) {
                        size2--;
                    }
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    size2--;
                    while (size2 >= 0) {
                        c0004b = (C0004b) this.f141i.get(size2);
                        if ((str != null && str.equals(c0004b.m84b())) || (i >= 0 && i == c0004b.f95o)) {
                            size2--;
                        }
                    }
                }
                size = size2;
            }
            if (size == this.f141i.size() - 1) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (size2 = this.f141i.size() - 1; size2 > size; size2--) {
                arrayList.add(this.f141i.remove(size2));
            }
            int size3 = arrayList.size() - 1;
            int i3 = 0;
            while (i3 <= size3) {
                if (f132a) {
                    Log.v("FragmentManager", "Popping back stack state: " + arrayList.get(i3));
                }
                ((C0004b) arrayList.get(i3)).m85b(i3 == size3);
                i3++;
            }
            m153f();
        }
        return true;
    }

    public boolean m133a(Menu menu) {
        if (this.f139g == null) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.f139g.size(); i++) {
            Fragment fragment = (Fragment) this.f139g.get(i);
            if (fragment != null && fragment.m37c(menu)) {
                z = true;
            }
        }
        return z;
    }

    public boolean m134a(Menu menu, MenuInflater menuInflater) {
        boolean z;
        Fragment fragment;
        int i = 0;
        ArrayList arrayList = null;
        if (this.f139g != null) {
            int i2 = 0;
            z = false;
            while (i2 < this.f139g.size()) {
                fragment = (Fragment) this.f139g.get(i2);
                if (fragment != null && fragment.m33b(menu, menuInflater)) {
                    z = true;
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(fragment);
                }
                i2++;
                z = z;
            }
        } else {
            z = false;
        }
        if (this.f142j != null) {
            while (i < this.f142j.size()) {
                fragment = (Fragment) this.f142j.get(i);
                if (arrayList == null || !arrayList.contains(fragment)) {
                    fragment.m56m();
                }
                i++;
            }
        }
        this.f142j = arrayList;
        return z;
    }

    public boolean m135a(MenuItem menuItem) {
        if (this.f139g == null) {
            return false;
        }
        for (int i = 0; i < this.f139g.size(); i++) {
            Fragment fragment = (Fragment) this.f139g.get(i);
            if (fragment != null && fragment.m38c(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void m136b(int i) {
        synchronized (this) {
            this.f143k.set(i, null);
            if (this.f144l == null) {
                this.f144l = new ArrayList();
            }
            if (f132a) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.f144l.add(Integer.valueOf(i));
        }
    }

    void m137b(Fragment fragment) {
        m127a(fragment, this.f146n, 0, 0, false);
    }

    public void m138b(Fragment fragment, int i, int i2) {
        if (f132a) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.f58z) {
            fragment.f58z = true;
            if (fragment.f26I != null) {
                Animation a = m118a(fragment, i, false, i2);
                if (a != null) {
                    fragment.f26I.startAnimation(a);
                }
                fragment.f26I.setVisibility(8);
            }
            if (fragment.f44l && fragment.f21D && fragment.f22E) {
                this.f150r = true;
            }
            fragment.m26a(true);
        }
    }

    void m139b(C0004b c0004b) {
        if (this.f141i == null) {
            this.f141i = new ArrayList();
        }
        this.f141i.add(c0004b);
        m153f();
    }

    public void m140b(Menu menu) {
        if (this.f139g != null) {
            for (int i = 0; i < this.f139g.size(); i++) {
                Fragment fragment = (Fragment) this.f139g.get(i);
                if (fragment != null) {
                    fragment.m40d(menu);
                }
            }
        }
    }

    public boolean m141b() {
        return m151e();
    }

    public boolean m142b(MenuItem menuItem) {
        if (this.f139g == null) {
            return false;
        }
        for (int i = 0; i < this.f139g.size(); i++) {
            Fragment fragment = (Fragment) this.f139g.get(i);
            if (fragment != null && fragment.m42d(menuItem)) {
                return true;
            }
        }
        return false;
    }

    void m143c(Fragment fragment) {
        if (fragment.f38f < 0) {
            if (this.f140h == null || this.f140h.size() <= 0) {
                if (this.f138f == null) {
                    this.f138f = new ArrayList();
                }
                fragment.m17a(this.f138f.size(), this.f149q);
                this.f138f.add(fragment);
            } else {
                fragment.m17a(((Integer) this.f140h.remove(this.f140h.size() - 1)).intValue(), this.f149q);
                this.f138f.set(fragment.f38f, fragment);
            }
            if (f132a) {
                Log.v("FragmentManager", "Allocated fragment index " + fragment);
            }
        }
    }

    public void m144c(Fragment fragment, int i, int i2) {
        if (f132a) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.f58z) {
            fragment.f58z = false;
            if (fragment.f26I != null) {
                Animation a = m118a(fragment, i, true, i2);
                if (a != null) {
                    fragment.f26I.startAnimation(a);
                }
                fragment.f26I.setVisibility(0);
            }
            if (fragment.f44l && fragment.f21D && fragment.f22E) {
                this.f150r = true;
            }
            fragment.m26a(false);
        }
    }

    public boolean m145c() {
        m112t();
        m141b();
        return m132a(this.f147o.f110a, null, -1, 0);
    }

    void m146d() {
        if (this.f138f != null) {
            for (int i = 0; i < this.f138f.size(); i++) {
                Fragment fragment = (Fragment) this.f138f.get(i);
                if (fragment != null) {
                    m125a(fragment);
                }
            }
        }
    }

    void m147d(Fragment fragment) {
        if (fragment.f38f >= 0) {
            if (f132a) {
                Log.v("FragmentManager", "Freeing fragment index " + fragment);
            }
            this.f138f.set(fragment.f38f, null);
            if (this.f140h == null) {
                this.f140h = new ArrayList();
            }
            this.f140h.add(Integer.valueOf(fragment.f38f));
            this.f147o.m97a(fragment.f39g);
            fragment.m54k();
        }
    }

    public void m148d(Fragment fragment, int i, int i2) {
        if (f132a) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.f18A) {
            fragment.f18A = true;
            if (fragment.f44l) {
                if (this.f139g != null) {
                    if (f132a) {
                        Log.v("FragmentManager", "remove from detach: " + fragment);
                    }
                    this.f139g.remove(fragment);
                }
                if (fragment.f21D && fragment.f22E) {
                    this.f150r = true;
                }
                fragment.f44l = false;
                m127a(fragment, 1, i, i2, false);
            }
        }
    }

    void m149e(Fragment fragment) {
        if (fragment.f27J != null) {
            if (this.f156x == null) {
                this.f156x = new SparseArray();
            } else {
                this.f156x.clear();
            }
            fragment.f27J.saveHierarchyState(this.f156x);
            if (this.f156x.size() > 0) {
                fragment.f37e = this.f156x;
                this.f156x = null;
            }
        }
    }

    public void m150e(Fragment fragment, int i, int i2) {
        if (f132a) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.f18A) {
            fragment.f18A = false;
            if (!fragment.f44l) {
                if (this.f139g == null) {
                    this.f139g = new ArrayList();
                }
                if (this.f139g.contains(fragment)) {
                    throw new IllegalStateException("Fragment already added: " + fragment);
                }
                if (f132a) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                this.f139g.add(fragment);
                fragment.f44l = true;
                if (fragment.f21D && fragment.f22E) {
                    this.f150r = true;
                }
                m127a(fragment, this.f146n, i, i2, false);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m151e() {
        if (!this.f137e) {
            if (Looper.myLooper() == this.f147o.f110a.getLooper()) {
                boolean z = false;
                while (true) {
                    synchronized (this) {
                        if (this.f135c == null || this.f135c.size() == 0) {
                        } else {
                            int size = this.f135c.size();
                            if (this.f136d == null || this.f136d.length < size) {
                                this.f136d = new Runnable[size];
                            }
                            this.f135c.toArray(this.f136d);
                            this.f135c.clear();
                            this.f147o.f110a.removeCallbacks(this.f157y);
                            this.f137e = true;
                            for (int i = 0; i < size; i++) {
                                this.f136d[i].run();
                                this.f136d[i] = null;
                            }
                            this.f137e = false;
                            z = true;
                        }
                    }
                }
                while (true) {
                    break;
                }
            }
            throw new IllegalStateException("Must be called from main thread of process");
        }
        throw new IllegalStateException("Recursive entry to executePendingTransactions");
    }

    Bundle m152f(Fragment fragment) {
        Bundle bundle;
        if (this.f155w == null) {
            this.f155w = new Bundle();
        }
        fragment.m52i(this.f155w);
        if (this.f155w.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.f155w;
            this.f155w = null;
        }
        if (fragment.f26I != null) {
            m149e(fragment);
        }
        if (fragment.f37e != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.f37e);
        }
        if (!fragment.f29L) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.f29L);
        }
        return bundle;
    }

    void m153f() {
        if (this.f145m != null) {
            for (int i = 0; i < this.f145m.size(); i++) {
                ((C0015m) this.f145m.get(i)).m106a();
            }
        }
    }

    ArrayList m154g() {
        ArrayList arrayList = null;
        if (this.f138f != null) {
            for (int i = 0; i < this.f138f.size(); i++) {
                Fragment fragment = (Fragment) this.f138f.get(i);
                if (fragment != null && fragment.f19B) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(fragment);
                    fragment.f20C = true;
                    fragment.f42j = fragment.f41i != null ? fragment.f41i.f38f : -1;
                    if (f132a) {
                        Log.v("FragmentManager", "retainNonConfig: keeping retained " + fragment);
                    }
                }
            }
        }
        return arrayList;
    }

    Parcelable m155h() {
        BackStackState[] backStackStateArr = null;
        m151e();
        if (f133b) {
            this.f151s = true;
        }
        if (this.f138f == null || this.f138f.size() <= 0) {
            return null;
        }
        int size = this.f138f.size();
        FragmentState[] fragmentStateArr = new FragmentState[size];
        int i = 0;
        boolean z = false;
        while (i < size) {
            boolean z2;
            Fragment fragment = (Fragment) this.f138f.get(i);
            if (fragment != null) {
                if (fragment.f38f < 0) {
                    m109a(new IllegalStateException("Failure saving state: active " + fragment + " has cleared index: " + fragment.f38f));
                }
                FragmentState fragmentState = new FragmentState(fragment);
                fragmentStateArr[i] = fragmentState;
                if (fragment.f33a <= 0 || fragmentState.f71j != null) {
                    fragmentState.f71j = fragment.f36d;
                } else {
                    fragmentState.f71j = m152f(fragment);
                    if (fragment.f41i != null) {
                        if (fragment.f41i.f38f < 0) {
                            m109a(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.f41i));
                        }
                        if (fragmentState.f71j == null) {
                            fragmentState.f71j = new Bundle();
                        }
                        m123a(fragmentState.f71j, "android:target_state", fragment.f41i);
                        if (fragment.f43k != 0) {
                            fragmentState.f71j.putInt("android:target_req_state", fragment.f43k);
                        }
                    }
                }
                if (f132a) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + fragmentState.f71j);
                }
                z2 = true;
            } else {
                z2 = z;
            }
            i++;
            z = z2;
        }
        if (z) {
            int[] iArr;
            int i2;
            FragmentManagerState fragmentManagerState;
            if (this.f139g != null) {
                i = this.f139g.size();
                if (i > 0) {
                    iArr = new int[i];
                    for (i2 = 0; i2 < i; i2++) {
                        iArr[i2] = ((Fragment) this.f139g.get(i2)).f38f;
                        if (iArr[i2] < 0) {
                            m109a(new IllegalStateException("Failure saving state: active " + this.f139g.get(i2) + " has cleared index: " + iArr[i2]));
                        }
                        if (f132a) {
                            Log.v("FragmentManager", "saveAllState: adding fragment #" + i2 + ": " + this.f139g.get(i2));
                        }
                    }
                    if (this.f141i != null) {
                        i = this.f141i.size();
                        if (i > 0) {
                            backStackStateArr = new BackStackState[i];
                            for (i2 = 0; i2 < i; i2++) {
                                backStackStateArr[i2] = new BackStackState(this, (C0004b) this.f141i.get(i2));
                                if (f132a) {
                                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f141i.get(i2));
                                }
                            }
                        }
                    }
                    fragmentManagerState = new FragmentManagerState();
                    fragmentManagerState.f59a = fragmentStateArr;
                    fragmentManagerState.f60b = iArr;
                    fragmentManagerState.f61c = backStackStateArr;
                    return fragmentManagerState;
                }
            }
            iArr = null;
            if (this.f141i != null) {
                i = this.f141i.size();
                if (i > 0) {
                    backStackStateArr = new BackStackState[i];
                    for (i2 = 0; i2 < i; i2++) {
                        backStackStateArr[i2] = new BackStackState(this, (C0004b) this.f141i.get(i2));
                        if (f132a) {
                            Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f141i.get(i2));
                        }
                    }
                }
            }
            fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.f59a = fragmentStateArr;
            fragmentManagerState.f60b = iArr;
            fragmentManagerState.f61c = backStackStateArr;
            return fragmentManagerState;
        } else if (!f132a) {
            return null;
        } else {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return null;
        }
    }

    public void m156i() {
        this.f151s = false;
    }

    public void m157j() {
        this.f151s = false;
        m121a(1, false);
    }

    public void m158k() {
        this.f151s = false;
        m121a(2, false);
    }

    public void m159l() {
        this.f151s = false;
        m121a(4, false);
    }

    public void m160m() {
        this.f151s = false;
        m121a(5, false);
    }

    public void m161n() {
        m121a(4, false);
    }

    public void m162o() {
        this.f151s = true;
        m121a(3, false);
    }

    public void m163p() {
        m121a(2, false);
    }

    public void m164q() {
        m121a(1, false);
    }

    public void m165r() {
        this.f152t = true;
        m151e();
        m121a(0, false);
        this.f147o = null;
        this.f148p = null;
        this.f149q = null;
    }

    public void m166s() {
        if (this.f139g != null) {
            for (int i = 0; i < this.f139g.size(); i++) {
                Fragment fragment = (Fragment) this.f139g.get(i);
                if (fragment != null) {
                    fragment.m60q();
                }
            }
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        if (this.f149q != null) {
            C0038d.m248a(this.f149q, stringBuilder);
        } else {
            C0038d.m248a(this.f147o, stringBuilder);
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }
}
