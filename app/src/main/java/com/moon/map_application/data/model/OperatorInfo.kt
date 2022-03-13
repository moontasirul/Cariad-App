package com.moon.map_application.data.model

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

)