package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.app.t */
final class C0022t implements Creator {
    C0022t() {
    }

    public SavedState m171a(Parcel parcel) {
        return new SavedState(null);
    }

    public SavedState[] m172a(int i) {
        return new SavedState[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m171a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m172a(i);
    }
}
