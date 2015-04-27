package it.sephiroth.android.library.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class am implements Creator {
    am() {
    }

    public SavedState m2335a(Parcel parcel) {
        return new SavedState(null);
    }

    public SavedState[] m2336a(int i) {
        return new SavedState[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2335a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2336a(i);
    }
}
