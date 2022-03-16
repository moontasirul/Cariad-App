package com.moon.mapApplicationTest.data.model

import android.os.Parcel
import android.os.Parcelable

class MetadataValueList() :ArrayList<MetadataValues>(), Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MetadataValueList> {
        override fun createFromParcel(parcel: Parcel): MetadataValueList {
            return MetadataValueList(parcel)
        }

        override fun newArray(size: Int): Array<MetadataValueList?> {
            return arrayOfNulls(size)
        }
    }
}