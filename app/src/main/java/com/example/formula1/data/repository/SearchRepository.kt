package com.example.formula1.data.repository

import com.example.formula1.data.model.DriverSearchResponse
import com.example.formula1.data.model.DriverStandingList
import com.example.formula1.data.model.TeamSearchResponse
import com.example.formula1.data.model.TeamStandingList
import com.example.formula1.data.model.driverstanding.Driver
import com.example.formula1.utils.DataResult

interface SearchRepository {
    suspend fun getSearchResult(
        id: Int
    ): DataResult<DriverSearchResponse>

    suspend fun getDriverStandingResult(
        year: String
    ): DataResult<DriverStandingList>

    suspend fun getTeamStandingResult(
        year: String
    ): DataResult<TeamStandingList>

    suspend fun getDriver(): DataResult<List<Driver>>

    suspend fun insertDriver(driver: Driver): DataResult<Unit>

    suspend fun getTeamDetail(
        id: Int
    ): DataResult<TeamSearchResponse>

    suspend fun getSearchDriverByTeam(
        teamID: Int,
        season: String
    ): DataResult<DriverStandingList>
}
