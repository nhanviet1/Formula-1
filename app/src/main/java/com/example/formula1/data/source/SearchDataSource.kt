package com.example.formula1.data.source

import com.example.formula1.data.model.DriverSearchResponse
import com.example.formula1.data.model.DriverStandingList
import com.example.formula1.data.model.TeamSearchResponse
import com.example.formula1.data.model.TeamStandingList
import com.example.formula1.data.model.driverstanding.Driver

interface SearchDataSource {
    interface Remote {
        suspend fun getSearchResult(id: Int): DriverSearchResponse
        suspend fun getDriverStanding(year: String): DriverStandingList
        suspend fun getTeamStanding(year: String): TeamStandingList
        suspend fun getTeamSearchResult(id: Int): TeamSearchResponse
        suspend fun getSearchByTeamResult(teamID: Int, season: String): DriverStandingList
    }

    interface Local {
        suspend fun getDriverHistory() : List<Driver>
        suspend fun insertDriver(driver: Driver)
    }
}
