package android.support.v4.view;

import android.view.View;
import java.util.Comparator;

class br implements Comparator {
    br() {
    }

    public int m651a(View view, View view2) {
        bk bkVar = (bk) view.getLayoutParams();
        bk bkVar2 = (bk) view2.getLayoutParams();
        return bkVar.f307a != bkVar2.f307a ? bkVar.f307a ? 1 : -1 : bkVar.f311e - bkVar2.f311e;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m651a((View) obj, (View) obj2);
    }
}
