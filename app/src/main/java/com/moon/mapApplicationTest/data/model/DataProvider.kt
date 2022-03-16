package com.moon.mapApplicationTest.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class DataProvider (

    @SerializedName("WebsiteURL"             ) var WebsiteURL             : String?                 = null,
    @SerializedName("Comments"               ) var Comments               : String?                 = null,
    @SerializedName("DataProviderStatusType" ) var DataProviderStatusType : DataProviderStatusType? = DataProviderStatusType(),
    @SerializedName("IsRestrictedEdit"       ) var IsRestrictedEdit       : Boolean?                = null,
    @SerializedName("IsOpenDataLicensed"     ) var IsOpenDataLicensed     : Boolean?                = null,
    @SerializedName("IsApprovedImport"       ) var IsApprovedImport       : Boolean?                = null,
    @SerializedName("License"                ) var License                : String?                 = null,
    @SerializedName("DateLastImported"       ) var DateLastImported       : String?                 = null,
    @SerializedName("ID"                     ) var ID                     : Int?                    = null,
    @SerializedName("Title"                  ) var Title                  : String?                 = null

):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(com.moon.mapApplicationTest.data.model.DataProviderStatusType::class.java.classLoader),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(WebsiteURL)
        parcel.writeString(Comments)
        parcel.writeParcelable(DataProviderStatusType, flags)
        parcel.writeValue(IsRestrictedEdit)
        parcel.writeValue(IsOpenDataLicensed)
        parcel.writeValue(IsApprovedImport)
        parcel.writeString(License)
        parcel.writeString(DateLastImported)
        parcel.writeValue(ID)
        parcel.writeString(Title)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DataProvider> {
        override fun createFromParcel(parcel: Parcel): DataProvider {
            return DataProvider(parcel)
        }

        override fun newArray(size: Int): Array<DataProvider?> {
            return arrayOfNulls(size)
        }
    }
}