package com.moon.mapApplicationTest.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class CurrentType (

  @SerializedName("Description" ) var Description : String? = null,
  @SerializedName("ID"          ) var ID          : Int?    = null,
  @SerializedName("Title"       ) var Title       : String? = null

):Parcelable {
  constructor(parcel: Parcel) : this(
    parcel.readString(),
    parcel.readValue(Int::class.java.classLoader) as? Int,
    parcel.readString()
  ) {
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeString(Description)
    parcel.writeValue(ID)
    parcel.writeString(Title)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Parcelable.Creator<CurrentType> {
    override fun createFromParcel(parcel: Parcel): CurrentType {
      return CurrentType(parcel)
    }

    override fun newArray(size: Int): Array<CurrentType?> {
      return arrayOfNulls(size)
    }
  }
}