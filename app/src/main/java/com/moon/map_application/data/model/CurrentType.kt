package com.moon.map_application.data.model

import com.google.gson.annotations.SerializedName


data class CurrentType (

  @SerializedName("Description" ) var Description : String? = null,
  @SerializedName("ID"          ) var ID          : Int?    = null,
  @SerializedName("Title"       ) var Title       : String? = null

)