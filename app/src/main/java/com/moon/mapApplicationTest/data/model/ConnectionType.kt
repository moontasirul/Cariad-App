package com.moon.mapApplicationTest.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class ConnectionType (

  @SerializedName("FormalName"     ) var FormalName     : String?  = null,
  @SerializedName("IsDiscontinued" ) var IsDiscontinued : Boolean? = null,
  @SerializedName("IsObsolete"     ) var IsObsolete     : Boolean? = null,
  @SerializedName("ID"             ) var ID             : Int?     = null,
  @SerializedName("Title"          ) var Title          : String?  = null

):Parcelable {
  constructor(parcel: Parcel) : this(
    parcel.readString(),
    parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
    parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
    parcel.readValue(Int::class.java.classLoader) as? Int,
    parcel.readString()
  ) {
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeString(FormalName)
    parcel.writeValue(IsDiscontinued)
    parcel.writeValue(IsObsolete)
    parcel.writeValue(ID)
    parcel.writeString(Title)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Parcelable.Creator<ConnectionType> {
    override fun createFromParcel(parcel: Parcel): ConnectionType {
      return ConnectionType(parcel)
    }

    override fun newArray(size: Int): Array<ConnectionType?> {
      return arrayOfNulls(size)
    }
  }
}