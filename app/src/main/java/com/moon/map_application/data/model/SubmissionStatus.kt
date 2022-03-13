package com.moon.map_application.data.model

import com.google.gson.annotations.SerializedName


data class SubmissionStatus (

  @SerializedName("IsLive" ) var IsLive : Boolean? = null,
  @SerializedName("ID"     ) var ID     : Int?     = null,
  @SerializedName("Title"  ) var Title  : String?  = null

)