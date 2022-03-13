package com.moon.map_application.data.model

import com.google.gson.annotations.SerializedName


data class MetadataValues (

  @SerializedName("ID"                    ) var ID                    : Int?    = null,
  @SerializedName("MetadataFieldID"       ) var MetadataFieldID       : Int?    = null,
  @SerializedName("ItemValue"             ) var ItemValue             : String? = null,
  @SerializedName("MetadataFieldOption"   ) var MetadataFieldOption   : String? = null,
  @SerializedName("MetadataFieldOptionID" ) var MetadataFieldOptionID : String? = null

)