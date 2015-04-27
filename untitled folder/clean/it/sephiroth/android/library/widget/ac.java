package it.sephiroth.android.library.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ac implements Creator {
    ac() {
    }

    public GroupMetadata m2318a(Parcel parcel) {
        return GroupMetadata.m2231a(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
    }

    public GroupMetadata[] m2319a(int i) {
        return new GroupMetadata[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2318a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2319a(i);
    }
}
