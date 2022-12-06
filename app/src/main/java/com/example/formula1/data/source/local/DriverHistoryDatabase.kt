package com.example.formula1.data.source.local

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.formula1.data.model.driverstanding.Driver

@Database(
    entities = [Driver::class],
    autoMigrations = [AutoMigration(
        from = DriverHistoryDatabase.ROOM_OLD_VERSION,
        to = DriverHistoryDatabase.ROOM_CURRENT_VERSION
    )],
    version = DriverHistoryDatabase.ROOM_CURRENT_VERSION,
    exportSchema = true
)
abstract class DriverHistoryDatabase : RoomDatabase() {

    abstract fun getDriverDAO(): DriverDAO

    companion object {
        const val ROOM_CURRENT_VERSION = 2
        const val ROOM_OLD_VERSION = 1
        const val DRIVER_TABLE = "Drivers"
    }
}
