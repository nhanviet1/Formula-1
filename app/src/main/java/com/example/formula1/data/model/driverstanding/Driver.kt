package com.example.formula1.data.model.driverstanding

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.formula1.data.source.local.DriverHistoryDatabase
import com.google.gson.annotations.SerializedName

@Entity(
    tableName = DriverHistoryDatabase.DRIVER_TABLE
)
data class Driver(
    @SerializedName("abbr")
    val abbr: String?,
    @PrimaryKey
    val id: Int?,
    val image: String?,
    val name: String?,
    val number: Int?
)
