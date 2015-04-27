package android.support.v4.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.widget.DrawerLayout.SavedState;

/* renamed from: android.support.v4.widget.d */
final class C0102d implements Creator {
    C0102d() {
    }

    public SavedState m779a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m780a(int i) {
        return new SavedState[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m779a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m780a(i);
    }
}
