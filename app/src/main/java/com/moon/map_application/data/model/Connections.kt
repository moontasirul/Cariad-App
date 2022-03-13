package com.moon.map_application.data.model

import com.google.gson.annotations.SerializedName


data class Connections (

    @SerializedName("ID"               ) var ID               : Int?            = null,
    @SerializedName("ConnectionTypeID" ) var ConnectionTypeID : Int?            = null,
    @SerializedName("ConnectionType"   ) var ConnectionType   : ConnectionType? = ConnectionType(),
    @SerializedName("Reference"        ) var Reference        : String?         = null,
    @SerializedName("StatusTypeID"     ) var StatusTypeID     : Int?            = null,
    @SerializedName("StatusType"       ) var StatusType       : StatusType?     = StatusType(),
    @SerializedName("LevelID"          ) var LevelID          : Int?            = null,
    @SerializedName("Level"            ) var Level            : Level?          = Level(),
    @SerializedName("Amps"             ) var Amps             : Int?            = null,
    @SerializedName("Voltage"          ) var Voltage          : Int?            = null,
    @SerializedName("PowerKW"          ) var PowerKW          : Double?            = null,
    @SerializedName("CurrentTypeID"    ) var CurrentTypeID    : Int?            = null,
    @SerializedName("CurrentType"      ) var CurrentType      : CurrentType?    = CurrentType(),
    @SerializedName("Quantity"         ) var Quantity         : Int?            = null,
    @SerializedName("Comments"         ) var Comments         : String?         = null

)