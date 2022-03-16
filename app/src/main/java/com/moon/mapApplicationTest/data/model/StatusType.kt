package com.moon.mapApplicationTest.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class StatusType (

  @SerializedName("IsOperational"    ) var IsOperational    : Boolean? = null,
  @SerializedName("IsUserSelectable" ) var IsUserSelectable : Boolean? = null,
  @SerializedName("ID"               ) var ID               : Int?     = null,
  @SerializedName("Title"            ) var Title            : String?  = null

):Parcelable {
  constructor(parcel: Parcel) : this(
    parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
    parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
    parcel.readValue(Int::class.java.classLoader) as? Int,
    parcel.readString()
  ) {
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeValue(IsOperational)
    parcel.writeValue(IsUserSelectable)
    parcel.writeValue(ID)
    parcel.writeString(Title)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Parcelable.Creator<StatusType> {
    override fun createFromParcel(parcel: Parcel): StatusType {
      return StatusType(parcel)
    }

    override fun newArray(size: Int): Array<StatusType?> {
      return arrayOfNulls(size)
    }
  }
}