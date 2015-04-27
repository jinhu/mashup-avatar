package android.support.v4.view;

import android.os.Parcel;
import android.support.v4.p001b.C0030c;
import android.support.v4.view.ViewPager.SavedState;

final class bq implements C0030c {
    bq() {
    }

    public /* synthetic */ Object m647a(Parcel parcel, ClassLoader classLoader) {
        return m649b(parcel, classLoader);
    }

    public /* synthetic */ Object[] m648a(int i) {
        return m650b(i);
    }

    public SavedState m649b(Parcel parcel, ClassLoader classLoader) {
        return new SavedState(parcel, classLoader);
    }

    public SavedState[] m650b(int i) {
        return new SavedState[i];
    }
}
