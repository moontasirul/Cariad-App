package com.moon.mapApplicationTest.data.model

import android.os.Parcel
import android.os.Parcelable

class MediaItemList() :ArrayList<MediaItems>(), Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MediaItemList> {
        override fun createFromParcel(parcel: Parcel): MediaItemList {
            return MediaItemList(parcel)
        }

        override fun newArray(size: Int): Array<MediaItemList?> {
            return arrayOfNulls(size)
        }
    }
}