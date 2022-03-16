package com.moon.mapApplicationTest.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class UsageType (

  @SerializedName("IsPayAtLocation"      ) var IsPayAtLocation      : Boolean? = null,
  @SerializedName("IsMembershipRequired" ) var IsMembershipRequired : Boolean? = null,
  @SerializedName("IsAccessKeyRequired"  ) var IsAccessKeyRequired  : Boolean? = null,
  @SerializedName("ID"                   ) var ID                   : Int?     = null,
  @SerializedName("Title"                ) var Title                : String?  = null

):Parcelable {
  constructor(parcel: Parcel) : this(
    parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
    parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
    parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
    parcel.readValue(Int::class.java.classLoader) as? Int,
    parcel.readString()
  ) {
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeValue(IsPayAtLocation)
    parcel.writeValue(IsMembershipRequired)
    parcel.writeValue(IsAccessKeyRequired)
    parcel.writeValue(ID)
    parcel.writeString(Title)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Parcelable.Creator<UsageType> {
    override fun createFromParcel(parcel: Parcel): UsageType {
      return UsageType(parcel)
    }

    override fun newArray(size: Int): Array<UsageType?> {
      return arrayOfNulls(size)
    }
  }
}