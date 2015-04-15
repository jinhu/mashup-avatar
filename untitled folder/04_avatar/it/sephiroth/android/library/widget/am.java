package it.sephiroth.android.library.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class am implements Creator {
    am() {
    }

    public SavedState a(Parcel parcel) {
        return new SavedState(null);
    }

    public SavedState[] a(int i) {
        return new SavedState[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
