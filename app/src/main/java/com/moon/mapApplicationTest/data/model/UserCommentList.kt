package com.moon.mapApplicationTest.data.model

import android.os.Parcel
import android.os.Parcelable

class UserCommentList() : ArrayList<UserComments>(), Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserCommentList> {
        override fun createFromParcel(parcel: Parcel): UserCommentList {
            return UserCommentList(parcel)
        }

        override fun newArray(size: Int): Array<UserCommentList?> {
            return arrayOfNulls(size)
        }
    }
}
