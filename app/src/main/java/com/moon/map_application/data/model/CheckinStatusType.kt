package com.moon.map_application.data.model

import com.google.gson.annotations.SerializedName


data class CheckinStatusType (

  @SerializedName("IsPositive"         ) var IsPositive         : Boolean? = null,
  @SerializedName("IsAutomatedCheckin" ) var IsAutomatedCheckin : Boolean? = null,
  @SerializedName("ID"                 ) var ID                 : Int?     = null,
  @SerializedName("Title"              ) var Title              : String?  = null

)