package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.app.d */
final class C0006d implements Creator {
    C0006d() {
    }

    public BackStackState m86a(Parcel parcel) {
        return new BackStackState(parcel);
    }

    public BackStackState[] m87a(int i) {
        return new BackStackState[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m86a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m87a(i);
    }
}
