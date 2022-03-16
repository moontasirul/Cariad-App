package com.moon.mapApplicationTest.data.model

import android.os.Parcel
import android.os.Parcelable
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

):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readParcelable(com.moon.mapApplicationTest.data.model.ConnectionType::class.java.classLoader),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readParcelable(com.moon.mapApplicationTest.data.model.StatusType::class.java.classLoader),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readParcelable(com.moon.mapApplicationTest.data.model.Level::class.java.classLoader),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readParcelable(com.moon.mapApplicationTest.data.model.CurrentType::class.java.classLoader),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(ID)
        parcel.writeValue(ConnectionTypeID)
        parcel.writeParcelable(ConnectionType, flags)
        parcel.writeString(Reference)
        parcel.writeValue(StatusTypeID)
        parcel.writeParcelable(StatusType, flags)
        parcel.writeValue(LevelID)
        parcel.writeParcelable(Level, flags)
        parcel.writeValue(Amps)
        parcel.writeValue(Voltage)
        parcel.writeValue(PowerKW)
        parcel.writeValue(CurrentTypeID)
        parcel.writeParcelable(CurrentType, flags)
        parcel.writeValue(Quantity)
        parcel.writeString(Comments)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Connections> {
        override fun createFromParcel(parcel: Parcel): Connections {
            return Connections(parcel)
        }

        override fun newArray(size: Int): Array<Connections?> {
            return arrayOfNulls(size)
        }
    }
}