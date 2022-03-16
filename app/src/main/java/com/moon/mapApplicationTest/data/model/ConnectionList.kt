package com.moon.mapApplicationTest.data.model

import android.os.Parcel
import android.os.Parcelable

class ConnectionList() :ArrayList<Connections>(),Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ConnectionList> {
        override fun createFromParcel(parcel: Parcel): ConnectionList {
            return ConnectionList(parcel)
        }

        override fun newArray(size: Int): Array<ConnectionList?> {
            return arrayOfNulls(size)
        }
    }
}