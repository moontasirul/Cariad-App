package com.moon.map_application.data.model

import com.google.gson.annotations.SerializedName


data class UserComments (

    @SerializedName("ID"                  ) var ID                  : Int?               = null,
    @SerializedName("ChargePointID"       ) var ChargePointID       : Int?               = null,
    @SerializedName("CommentTypeID"       ) var CommentTypeID       : Int?               = null,
    @SerializedName("CommentType"         ) var CommentType         : CommentType?       = CommentType(),
    @SerializedName("UserName"            ) var UserName            : String?            = null,
    @SerializedName("Comment"             ) var Comment             : String?            = null,
    @SerializedName("Rating"              ) var Rating              : Int?               = null,
    @SerializedName("RelatedURL"          ) var RelatedURL          : String?            = null,
    @SerializedName("DateCreated"         ) var DateCreated         : String?            = null,
    @SerializedName("User"                ) var User                : User?              = User(),
    @SerializedName("CheckinStatusTypeID" ) var CheckinStatusTypeID : Int?               = null,
    @SerializedName("CheckinStatusType"   ) var CheckinStatusType   : CheckinStatusType? = CheckinStatusType(),
    @SerializedName("IsActionedByEditor"  ) var IsActionedByEditor  : String?            = null

)