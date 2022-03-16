package com.moon.mapApplicationTest.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class POI (

    @SerializedName("DataProvider"           ) var DataProvider           : DataProvider?          = DataProvider(),
    @SerializedName("OperatorInfo"           ) var OperatorInfo           : OperatorInfo?          = OperatorInfo(),
    @SerializedName("UsageType"              ) var UsageType              : UsageType?             = UsageType(),
    @SerializedName("StatusType"             ) var StatusType             : StatusType?            = StatusType(),
    @SerializedName("SubmissionStatus"       ) var SubmissionStatus       : SubmissionStatus?      = SubmissionStatus(),
    @SerializedName("UserComments"           ) var UserComments           : UserCommentList? = UserCommentList(),
    @SerializedName("PercentageSimilarity"   ) var PercentageSimilarity   : String?                = null,
    @SerializedName("MediaItems"             ) var MediaItems             : MediaItemList? = MediaItemList(),
    @SerializedName("IsRecentlyVerified"     ) var IsRecentlyVerified     : Boolean?               = null,
    @SerializedName("DateLastVerified"       ) var DateLastVerified       : String?                = null,
    @SerializedName("ID"                     ) var ID                     : Int?                   = null,
    @SerializedName("UUID"                   ) var UUID                   : String?                = null,
    @SerializedName("ParentChargePointID"    ) var ParentChargePointID    : String?                = null,
    @SerializedName("DataProviderID"         ) var DataProviderID         : Int?                   = null,
    @SerializedName("DataProvidersReference" ) var DataProvidersReference : String?                = null,
    @SerializedName("OperatorID"             ) var OperatorID             : Int?                   = null,
    @SerializedName("OperatorsReference"     ) var OperatorsReference     : String?                = null,
    @SerializedName("UsageTypeID"            ) var UsageTypeID            : Int?                   = null,
    @SerializedName("UsageCost"              ) var UsageCost              : String?                = null,
    @SerializedName("AddressInfo"            ) var AddressInfo            : AddressInfo?           = AddressInfo(),
    @SerializedName("Connections"            ) var Connections            : ConnectionList? = ConnectionList(),
    @SerializedName("NumberOfPoints"         ) var NumberOfPoints         : Int?                   = null,
    @SerializedName("GeneralComments"        ) var GeneralComments        : String?                = null,
    @SerializedName("DatePlanned"            ) var DatePlanned            : String?                = null,
    @SerializedName("DateLastConfirmed"      ) var DateLastConfirmed      : String?                = null,
    @SerializedName("StatusTypeID"           ) var StatusTypeID           : Int?                   = null,
    @SerializedName("DateLastStatusUpdate"   ) var DateLastStatusUpdate   : String?                = null,
    @SerializedName("MetadataValues"         ) var MetadataValues         : MetadataValueList? = MetadataValueList(),
    @SerializedName("DataQualityLevel"       ) var DataQualityLevel       : Int?                   = null,
    @SerializedName("DateCreated"            ) var DateCreated            : String?                = null,
    @SerializedName("SubmissionStatusTypeID" ) var SubmissionStatusTypeID : Int?                   = null

):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(com.moon.mapApplicationTest.data.model.DataProvider::class.java.classLoader),
        parcel.readParcelable(com.moon.mapApplicationTest.data.model.OperatorInfo::class.java.classLoader),
        parcel.readParcelable(com.moon.mapApplicationTest.data.model.UsageType::class.java.classLoader),
        parcel.readParcelable(com.moon.mapApplicationTest.data.model.StatusType::class.java.classLoader),
        parcel.readParcelable(com.moon.mapApplicationTest.data.model.SubmissionStatus::class.java.classLoader),
        parcel.readParcelable(UserCommentList::class.java.classLoader),
        parcel.readString(),
        parcel.readParcelable(MediaItemList::class.java.classLoader),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readParcelable(com.moon.mapApplicationTest.data.model.AddressInfo::class.java.classLoader),
        parcel.readParcelable(ConnectionList::class.java.classLoader),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readParcelable(MetadataValueList::class.java.classLoader),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(DataProvider, flags)
        parcel.writeParcelable(OperatorInfo, flags)
        parcel.writeParcelable(UsageType, flags)
        parcel.writeParcelable(StatusType, flags)
        parcel.writeParcelable(SubmissionStatus, flags)
        parcel.writeParcelable(UserComments, flags)
        parcel.writeString(PercentageSimilarity)
        parcel.writeParcelable(MediaItems, flags)
        parcel.writeValue(IsRecentlyVerified)
        parcel.writeString(DateLastVerified)
        parcel.writeValue(ID)
        parcel.writeString(UUID)
        parcel.writeString(ParentChargePointID)
        parcel.writeValue(DataProviderID)
        parcel.writeString(DataProvidersReference)
        parcel.writeValue(OperatorID)
        parcel.writeString(OperatorsReference)
        parcel.writeValue(UsageTypeID)
        parcel.writeString(UsageCost)
        parcel.writeParcelable(AddressInfo, flags)
        parcel.writeParcelable(Connections, flags)
        parcel.writeValue(NumberOfPoints)
        parcel.writeString(GeneralComments)
        parcel.writeString(DatePlanned)
        parcel.writeString(DateLastConfirmed)
        parcel.writeValue(StatusTypeID)
        parcel.writeString(DateLastStatusUpdate)
        parcel.writeParcelable(MetadataValues, flags)
        parcel.writeValue(DataQualityLevel)
        parcel.writeString(DateCreated)
        parcel.writeValue(SubmissionStatusTypeID)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<POI> {
        override fun createFromParcel(parcel: Parcel): POI {
            return POI(parcel)
        }

        override fun newArray(size: Int): Array<POI?> {
            return arrayOfNulls(size)
        }
    }
}