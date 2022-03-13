package com.moon.map_application.data.model

import com.google.gson.annotations.SerializedName


data class User (

  @SerializedName("ID"                          ) var ID                          : Int?    = null,
  @SerializedName("IdentityProvider"            ) var IdentityProvider            : String? = null,
  @SerializedName("Identifier"                  ) var Identifier                  : String? = null,
  @SerializedName("CurrentSessionToken"         ) var CurrentSessionToken         : String? = null,
  @SerializedName("Username"                    ) var Username                    : String? = null,
  @SerializedName("Profile"                     ) var Profile                     : String? = null,
  @SerializedName("Location"                    ) var Location                    : String? = null,
  @SerializedName("WebsiteURL"                  ) var WebsiteURL                  : String? = null,
  @SerializedName("ReputationPoints"            ) var ReputationPoints            : Int?    = null,
  @SerializedName("Permissions"                 ) var Permissions                 : String? = null,
  @SerializedName("PermissionsRequested"        ) var PermissionsRequested        : String? = null,
  @SerializedName("DateCreated"                 ) var DateCreated                 : String? = null,
  @SerializedName("DateLastLogin"               ) var DateLastLogin               : String? = null,
  @SerializedName("IsProfilePublic"             ) var IsProfilePublic             : String? = null,
  @SerializedName("IsEmergencyChargingProvider" ) var IsEmergencyChargingProvider : String? = null,
  @SerializedName("IsPublicChargingProvider"    ) var IsPublicChargingProvider    : String? = null,
  @SerializedName("Latitude"                    ) var Latitude                    : String? = null,
  @SerializedName("Longitude"                   ) var Longitude                   : String? = null,
  @SerializedName("EmailAddress"                ) var EmailAddress                : String? = null,
  @SerializedName("EmailHash"                   ) var EmailHash                   : String? = null,
  @SerializedName("ProfileImageURL"             ) var ProfileImageURL             : String? = null,
  @SerializedName("IsCurrentSessionTokenValid"  ) var IsCurrentSessionTokenValid  : String? = null,
  @SerializedName("APIKey"                      ) var APIKey                      : String? = null,
  @SerializedName("SyncedSettings"              ) var SyncedSettings              : String? = null

)