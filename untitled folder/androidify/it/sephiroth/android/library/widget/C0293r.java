package it.sephiroth.android.library.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: it.sephiroth.android.library.widget.r */
final class C0293r implements Creator {
    C0293r() {
    }

    public SavedState m2416a(Parcel parcel) {
        return new SavedState(null);
    }

    public SavedState[] m2417a(int i) {
        return new SavedState[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2416a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2417a(i);
    }
}
