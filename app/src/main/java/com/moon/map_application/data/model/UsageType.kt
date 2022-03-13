package com.moon.map_application.data.model

import com.google.gson.annotations.SerializedName


data class UsageType (

  @SerializedName("IsPayAtLocation"      ) var IsPayAtLocation      : Boolean? = null,
  @SerializedName("IsMembershipRequired" ) var IsMembershipRequired : Boolean? = null,
  @SerializedName("IsAccessKeyRequired"  ) var IsAccessKeyRequired  : Boolean? = null,
  @SerializedName("ID"                   ) var ID                   : Int?     = null,
  @SerializedName("Title"                ) var Title                : String?  = null

)