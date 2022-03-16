package com.moon.mapApplicationTest.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class MetadataValues (

  @SerializedName("ID"                    ) var ID                    : Int?    = null,
  @SerializedName("MetadataFieldID"       ) var MetadataFieldID       : Int?    = null,
  @SerializedName("ItemValue"             ) var ItemValue             : String? = null,
  @SerializedName("MetadataFieldOption"   ) var MetadataFieldOption   : String? = null,
  @SerializedName("MetadataFieldOptionID" ) var MetadataFieldOptionID : String? = null

):Parcelable {
  constructor(parcel: Parcel) : this(
    parcel.readValue(Int::class.java.classLoader) as? Int,
    parcel.readValue(Int::class.java.classLoader) as? Int,
    parcel.readString(),
    parcel.readString(),
    parcel.readString()
  ) {
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeValue(ID)
    parcel.writeValue(MetadataFieldID)
    parcel.writeString(ItemValue)
    parcel.writeString(MetadataFieldOption)
    parcel.writeString(MetadataFieldOptionID)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Parcelable.Creator<MetadataValues> {
    override fun createFromParcel(parcel: Parcel): MetadataValues {
      return MetadataValues(parcel)
    }

    override fun newArray(size: Int): Array<MetadataValues?> {
      return arrayOfNulls(size)
    }
  }
}