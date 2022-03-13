package com.moon.map_application.data.model

import com.google.gson.annotations.SerializedName


data class DataProviderStatusType (

  @SerializedName("IsProviderEnabled" ) var IsProviderEnabled : Boolean? = null,
  @SerializedName("ID"                ) var ID                : Int?     = null,
  @SerializedName("Title"             ) var Title             : String?  = null

)