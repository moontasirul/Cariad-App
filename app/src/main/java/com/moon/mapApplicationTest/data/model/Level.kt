package com.moon.mapApplicationTest.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class Level (

  @SerializedName("Comments"            ) var Comments            : String?  = null,
  @SerializedName("IsFastChargeCapable" ) var IsFastChargeCapable : Boolean? = null,
  @SerializedName("ID"                  ) var ID                  : Int?     = null,
  @SerializedName("Title"               ) var Title               : String?  = null

):Parcelable {
  constructor(parcel: Parcel) : this(
    parcel.readString(),
    parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
    parcel.readValue(Int::class.java.classLoader) as? Int,
    parcel.readString()
  ) {
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeString(Comments)
    parcel.writeValue(IsFastChargeCapable)
    parcel.writeValue(ID)
    parcel.writeString(Title)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Parcelable.Creator<Level> {
    override fun createFromParcel(parcel: Parcel): Level {
      return Level(parcel)
    }

    override fun newArray(size: Int): Array<Level?> {
      return arrayOfNulls(size)
    }
  }
}