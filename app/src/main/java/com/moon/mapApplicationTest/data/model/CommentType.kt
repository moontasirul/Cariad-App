package com.moon.mapApplicationTest.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class CommentType (

  @SerializedName("ID"    ) var ID    : Int?    = null,
  @SerializedName("Title" ) var Title : String? = null

):Parcelable {
  constructor(parcel: Parcel) : this(
    parcel.readValue(Int::class.java.classLoader) as? Int,
    parcel.readString()
  ) {
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeValue(ID)
    parcel.writeString(Title)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Parcelable.Creator<CommentType> {
    override fun createFromParcel(parcel: Parcel): CommentType {
      return CommentType(parcel)
    }

    override fun newArray(size: Int): Array<CommentType?> {
      return arrayOfNulls(size)
    }
  }
}