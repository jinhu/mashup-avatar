package android.support.v4.view.p003a;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.view.a.m */
class C0064m implements C0063s {
    final /* synthetic */ C0059j f285a;
    final /* synthetic */ C0062l f286b;

    C0064m(C0062l c0062l, C0059j c0059j) {
        this.f286b = c0062l;
        this.f285a = c0059j;
    }

    public Object m454a(int i) {
        C0047a a = this.f285a.m443a(i);
        return a == null ? null : a.m312a();
    }

    public List m455a(String str, int i) {
        List a = this.f285a.m445a(str, i);
        List arrayList = new ArrayList();
        int size = a.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(((C0047a) a.get(i2)).m312a());
        }
        return arrayList;
    }

    public boolean m456a(int i, int i2, Bundle bundle) {
        return this.f285a.m446a(i, i2, bundle);
    }
}
