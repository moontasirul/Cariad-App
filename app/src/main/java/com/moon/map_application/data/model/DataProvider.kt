package com.moon.map_application.data.model

import com.google.gson.annotations.SerializedName


data class DataProvider (

    @SerializedName("WebsiteURL"             ) var WebsiteURL             : String?                 = null,
    @SerializedName("Comments"               ) var Comments               : String?                 = null,
    @SerializedName("DataProviderStatusType" ) var DataProviderStatusType : DataProviderStatusType? = DataProviderStatusType(),
    @SerializedName("IsRestrictedEdit"       ) var IsRestrictedEdit       : Boolean?                = null,
    @SerializedName("IsOpenDataLicensed"     ) var IsOpenDataLicensed     : Boolean?                = null,
    @SerializedName("IsApprovedImport"       ) var IsApprovedImport       : Boolean?                = null,
    @SerializedName("License"                ) var License                : String?                 = null,
    @SerializedName("DateLastImported"       ) var DateLastImported       : String?                 = null,
    @SerializedName("ID"                     ) var ID                     : Int?                    = null,
    @SerializedName("Title"                  ) var Title                  : String?                 = null

)