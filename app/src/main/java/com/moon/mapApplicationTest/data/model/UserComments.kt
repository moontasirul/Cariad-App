package com.moon.mapApplicationTest.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class UserComments (

    @SerializedName("ID"                  ) var ID                  : Int?               = null,
    @SerializedName("ChargePointID"       ) var ChargePointID       : Int?               = null,
    @SerializedName("CommentTypeID"       ) var CommentTypeID       : Int?               = null,
    @SerializedName("CommentType"         ) var CommentType         : CommentType?       = CommentType(),
    @SerializedName("UserName"            ) var UserName            : String?            = null,
    @SerializedName("Comment"             ) var Comment             : String?            = null,
    @SerializedName("Rating"              ) var Rating              : Int?               = null,
    @SerializedName("RelatedURL"          ) var RelatedURL          : String?            = null,
    @SerializedName("DateCreated"         ) var DateCreated         : String?            = null,
    @SerializedName("User"                ) var User                : User?              = User(),
    @SerializedName("CheckinStatusTypeID" ) var CheckinStatusTypeID : Int?               = null,
    @SerializedName("CheckinStatusType"   ) var CheckinStatusType   : CheckinStatusType? = CheckinStatusType(),
    @SerializedName("IsActionedByEditor"  ) var IsActionedByEditor  : String?            = null

):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readParcelable(com.moon.mapApplicationTest.data.model.CommentType::class.java.classLoader),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(com.moon.mapApplicationTest.data.model.User::class.java.classLoader),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readParcelable(com.moon.mapApplicationTest.data.model.CheckinStatusType::class.java.classLoader),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(ID)
        parcel.writeValue(ChargePointID)
        parcel.writeValue(CommentTypeID)
        parcel.writeParcelable(CommentType, flags)
        parcel.writeString(UserName)
        parcel.writeString(Comment)
        parcel.writeValue(Rating)
        parcel.writeString(RelatedURL)
        parcel.writeString(DateCreated)
        parcel.writeParcelable(User, flags)
        parcel.writeValue(CheckinStatusTypeID)
        parcel.writeParcelable(CheckinStatusType, flags)
        parcel.writeString(IsActionedByEditor)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserComments> {
        override fun createFromParcel(parcel: Parcel): UserComments {
            return UserComments(parcel)
        }

        override fun newArray(size: Int): Array<UserComments?> {
            return arrayOfNulls(size)
        }
    }
}