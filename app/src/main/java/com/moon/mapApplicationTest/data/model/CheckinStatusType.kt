package com.moon.mapApplicationTest.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class CheckinStatusType (

  @SerializedName("IsPositive"         ) var IsPositive         : Boolean? = null,
  @SerializedName("IsAutomatedCheckin" ) var IsAutomatedCheckin : Boolean? = null,
  @SerializedName("ID"                 ) var ID                 : Int?     = null,
  @SerializedName("Title"              ) var Title              : String?  = null

):Parcelable {
  constructor(parcel: Parcel) : this(
    parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
    parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
    parcel.readValue(Int::class.java.classLoader) as? Int,
    parcel.readString()
  ) {
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeValue(IsPositive)
    parcel.writeValue(IsAutomatedCheckin)
    parcel.writeValue(ID)
    parcel.writeString(Title)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Parcelable.Creator<CheckinStatusType> {
    override fun createFromParcel(parcel: Parcel): CheckinStatusType {
      return CheckinStatusType(parcel)
    }

    override fun newArray(size: Int): Array<CheckinStatusType?> {
      return arrayOfNulls(size)
    }
  }
}