package com.moon.mapApplicationTest.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class AddressInfo (

    @SerializedName("ID"                ) var ID                : Int?     = null,
    @SerializedName("Title"             ) var Title             : String?  = null,
    @SerializedName("AddressLine1"      ) var AddressLine1      : String?  = null,
    @SerializedName("AddressLine2"      ) var AddressLine2      : String?  = null,
    @SerializedName("Town"              ) var Town              : String?  = null,
    @SerializedName("StateOrProvince"   ) var StateOrProvince   : String?  = null,
    @SerializedName("Postcode"          ) var Postcode          : String?  = null,
    @SerializedName("CountryID"         ) var CountryID         : Int?     = null,
    @SerializedName("Country"           ) var Country           : Country? = Country(),
    @SerializedName("Latitude"          ) var Latitude          : Double?  = null,
    @SerializedName("Longitude"         ) var Longitude         : Double?  = null,
    @SerializedName("ContactTelephone1" ) var ContactTelephone1 : String?  = null,
    @SerializedName("ContactTelephone2" ) var ContactTelephone2 : String?  = null,
    @SerializedName("ContactEmail"      ) var ContactEmail      : String?  = null,
    @SerializedName("AccessComments"    ) var AccessComments    : String?  = null,
    @SerializedName("RelatedURL"        ) var RelatedURL        : String?  = null,
    @SerializedName("Distance"          ) var Distance          : Double?  = null,
    @SerializedName("DistanceUnit"      ) var DistanceUnit      : Int?     = null

):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readParcelable(com.moon.mapApplicationTest.data.model.Country::class.java.classLoader),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Int::class.java.classLoader) as? Int
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(ID)
        parcel.writeString(Title)
        parcel.writeString(AddressLine1)
        parcel.writeString(AddressLine2)
        parcel.writeString(Town)
        parcel.writeString(StateOrProvince)
        parcel.writeString(Postcode)
        parcel.writeValue(CountryID)
        parcel.writeParcelable(Country, flags)
        parcel.writeValue(Latitude)
        parcel.writeValue(Longitude)
        parcel.writeString(ContactTelephone1)
        parcel.writeString(ContactTelephone2)
        parcel.writeString(ContactEmail)
        parcel.writeString(AccessComments)
        parcel.writeString(RelatedURL)
        parcel.writeValue(Distance)
        parcel.writeValue(DistanceUnit)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AddressInfo> {
        override fun createFromParcel(parcel: Parcel): AddressInfo {
            return AddressInfo(parcel)
        }

        override fun newArray(size: Int): Array<AddressInfo?> {
            return arrayOfNulls(size)
        }
    }
}