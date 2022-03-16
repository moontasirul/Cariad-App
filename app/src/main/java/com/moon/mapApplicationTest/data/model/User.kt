package com.moon.mapApplicationTest.data.model

import android.os.Parcel
import android.os.Parcelable
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

):Parcelable {
  constructor(parcel: Parcel) : this(
    parcel.readValue(Int::class.java.classLoader) as? Int,
    parcel.readString(),
    parcel.readString(),
    parcel.readString(),
    parcel.readString(),
    parcel.readString(),
    parcel.readString(),
    parcel.readString(),
    parcel.readValue(Int::class.java.classLoader) as? Int,
    parcel.readString(),
    parcel.readString(),
    parcel.readString(),
    parcel.readString(),
    parcel.readString(),
    parcel.readString(),
    parcel.readString(),
    parcel.readString(),
    parcel.readString(),
    parcel.readString(),
    parcel.readString(),
    parcel.readString(),
    parcel.readString(),
    parcel.readString(),
    parcel.readString()
  ) {
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeValue(ID)
    parcel.writeString(IdentityProvider)
    parcel.writeString(Identifier)
    parcel.writeString(CurrentSessionToken)
    parcel.writeString(Username)
    parcel.writeString(Profile)
    parcel.writeString(Location)
    parcel.writeString(WebsiteURL)
    parcel.writeValue(ReputationPoints)
    parcel.writeString(Permissions)
    parcel.writeString(PermissionsRequested)
    parcel.writeString(DateCreated)
    parcel.writeString(DateLastLogin)
    parcel.writeString(IsProfilePublic)
    parcel.writeString(IsEmergencyChargingProvider)
    parcel.writeString(IsPublicChargingProvider)
    parcel.writeString(Latitude)
    parcel.writeString(Longitude)
    parcel.writeString(EmailAddress)
    parcel.writeString(EmailHash)
    parcel.writeString(ProfileImageURL)
    parcel.writeString(IsCurrentSessionTokenValid)
    parcel.writeString(APIKey)
    parcel.writeString(SyncedSettings)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Parcelable.Creator<User> {
    override fun createFromParcel(parcel: Parcel): User {
      return User(parcel)
    }

    override fun newArray(size: Int): Array<User?> {
      return arrayOfNulls(size)
    }
  }
}