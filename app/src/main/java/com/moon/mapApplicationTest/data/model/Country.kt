package com.moon.mapApplicationTest.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class Country (

  @SerializedName("ISOCode"       ) var ISOCode       : String? = null,
  @SerializedName("ContinentCode" ) var ContinentCode : String? = null,
  @SerializedName("ID"            ) var ID            : Int?    = null,
  @SerializedName("Title"         ) var Title         : String? = null

):Parcelable {
  constructor(parcel: Parcel) : this(
    parcel.readString(),
    parcel.readString(),
    parcel.readValue(Int::class.java.classLoader) as? Int,
    parcel.readString()
  ) {
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeString(ISOCode)
    parcel.writeString(ContinentCode)
    parcel.writeValue(ID)
    parcel.writeString(Title)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Parcelable.Creator<Country> {
    override fun createFromParcel(parcel: Parcel): Country {
      return Country(parcel)
    }

    override fun newArray(size: Int): Array<Country?> {
      return arrayOfNulls(size)
    }
  }
}