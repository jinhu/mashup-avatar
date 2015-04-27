package android.support.v4.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.widget.q */
final class C0116q implements Creator {
    C0116q() {
    }

    public SavedState m862a(Parcel parcel) {
        return new SavedState(null);
    }

    public SavedState[] m863a(int i) {
        return new SavedState[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m862a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m863a(i);
    }
}
