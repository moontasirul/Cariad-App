package com.moon.mapApplicationTest.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class MediaItems (

    @SerializedName("ID"                 ) var ID                 : Int?     = null,
    @SerializedName("ChargePointID"      ) var ChargePointID      : Int?     = null,
    @SerializedName("ItemURL"            ) var ItemURL            : String?  = null,
    @SerializedName("ItemThumbnailURL"   ) var ItemThumbnailURL   : String?  = null,
    @SerializedName("Comment"            ) var Comment            : String?  = null,
    @SerializedName("IsEnabled"          ) var IsEnabled          : Boolean? = null,
    @SerializedName("IsVideo"            ) var IsVideo            : Boolean? = null,
    @SerializedName("IsFeaturedItem"     ) var IsFeaturedItem     : Boolean? = null,
    @SerializedName("IsExternalResource" ) var IsExternalResource : Boolean? = null,
    @SerializedName("MetadataValue"      ) var MetadataValue      : String?  = null,
    @SerializedName("User"               ) var User               : User?    = User(),
    @SerializedName("DateCreated"        ) var DateCreated        : String?  = null

):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readString(),
        parcel.readParcelable(com.moon.mapApplicationTest.data.model.User::class.java.classLoader),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(ID)
        parcel.writeValue(ChargePointID)
        parcel.writeString(ItemURL)
        parcel.writeString(ItemThumbnailURL)
        parcel.writeString(Comment)
        parcel.writeValue(IsEnabled)
        parcel.writeValue(IsVideo)
        parcel.writeValue(IsFeaturedItem)
        parcel.writeValue(IsExternalResource)
        parcel.writeString(MetadataValue)
        parcel.writeParcelable(User, flags)
        parcel.writeString(DateCreated)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MediaItems> {
        override fun createFromParcel(parcel: Parcel): MediaItems {
            return MediaItems(parcel)
        }

        override fun newArray(size: Int): Array<MediaItems?> {
            return arrayOfNulls(size)
        }
    }
}