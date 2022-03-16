package com.moon.mapApplicationTest.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class OperatorInfo (

  @SerializedName("WebsiteURL"            ) var WebsiteURL            : String?  = null,
  @SerializedName("Comments"              ) var Comments              : String?  = null,
  @SerializedName("PhonePrimaryContact"   ) var PhonePrimaryContact   : String?  = null,
  @SerializedName("PhoneSecondaryContact" ) var PhoneSecondaryContact : String?  = null,
  @SerializedName("IsPrivateIndividual"   ) var IsPrivateIndividual   : Boolean? = null,
  @SerializedName("AddressInfo"           ) var AddressInfo           : String?  = null,
  @SerializedName("BookingURL"            ) var BookingURL            : String?  = null,
  @SerializedName("ContactEmail"          ) var ContactEmail          : String?  = null,
  @SerializedName("FaultReportEmail"      ) var FaultReportEmail      : String?  = null,
  @SerializedName("IsRestrictedEdit"      ) var IsRestrictedEdit      : Boolean? = null,
  @SerializedName("ID"                    ) var ID                    : Int?     = null,
  @SerializedName("Title"                 ) var Title                 : String?  = null

):Parcelable {
  constructor(parcel: Parcel) : this(
    parcel.readString(),
    parcel.readString(),
    parcel.readString(),
    parcel.readString(),
    parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
    parcel.readString(),
    parcel.readString(),
    parcel.readString(),
    parcel.readString(),
    parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
    parcel.readValue(Int::class.java.classLoader) as? Int,
    parcel.readString()
  ) {
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeString(WebsiteURL)
    parcel.writeString(Comments)
    parcel.writeString(PhonePrimaryContact)
    parcel.writeString(PhoneSecondaryContact)
    parcel.writeValue(IsPrivateIndividual)
    parcel.writeString(AddressInfo)
    parcel.writeString(BookingURL)
    parcel.writeString(ContactEmail)
    parcel.writeString(FaultReportEmail)
    parcel.writeValue(IsRestrictedEdit)
    parcel.writeValue(ID)
    parcel.writeString(Title)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Parcelable.Creator<OperatorInfo> {
    override fun createFromParcel(parcel: Parcel): OperatorInfo {
      return OperatorInfo(parcel)
    }

    override fun newArray(size: Int): Array<OperatorInfo?> {
      return arrayOfNulls(size)
    }
  }
}