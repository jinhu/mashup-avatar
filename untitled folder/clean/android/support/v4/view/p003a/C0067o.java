package android.support.v4.view.p003a;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.view.a.o */
class C0067o implements C0066v {
    final /* synthetic */ C0059j f287a;
    final /* synthetic */ C0065n f288b;

    C0067o(C0065n c0065n, C0059j c0059j) {
        this.f288b = c0065n;
        this.f287a = c0059j;
    }

    public Object m462a(int i) {
        C0047a a = this.f287a.m443a(i);
        return a == null ? null : a.m312a();
    }

    public List m463a(String str, int i) {
        List a = this.f287a.m445a(str, i);
        List arrayList = new ArrayList();
        int size = a.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(((C0047a) a.get(i2)).m312a());
        }
        return arrayList;
    }

    public boolean m464a(int i, int i2, Bundle bundle) {
        return this.f287a.m446a(i, i2, bundle);
    }

    public Object m465b(int i) {
        C0047a b = this.f287a.m447b(i);
        return b == null ? null : b.m312a();
    }
}
