package com.example.formula1.data.model.driverstanding

import androidx.recyclerview.widget.DiffUtil
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.formula1.data.source.local.DriverHistoryDatabase
import com.google.gson.annotations.SerializedName

@Entity(
    tableName = DriverHistoryDatabase.DRIVER_TABLE
)
data class Driver(
    val timeStamp: Long?,
    @SerializedName("abbr")
    val nameTag: String?,
    @PrimaryKey
    val id: Int?,
    val image: String?,
    val name: String?,
    val number: Int?
) {
    companion object {

        val diffUtil = object : DiffUtil.ItemCallback<Driver>() {
            override fun areItemsTheSame(oldItem: Driver, newItem: Driver) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Driver, newItem: Driver) =
                oldItem == newItem
        }
    }
}
