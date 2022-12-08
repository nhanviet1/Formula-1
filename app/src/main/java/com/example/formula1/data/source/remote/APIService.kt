package com.example.formula1.data.source.remote

import com.example.formula1.data.model.DriverSearchResponse
import com.example.formula1.data.model.DriverStandingList
import com.example.formula1.data.model.TeamSearchResponse
import com.example.formula1.data.model.TeamStandingList
import com.example.formula1.data.model.CircuitSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    companion object {
        const val API_DRIVER_SEARCH = "drivers"
        const val API_DRIVER_STANDING = "rankings/drivers"
        const val API_TEAM_STANDING = "rankings/teams"
        const val API_TEAM_SEARCH = "teams"
        const val API_CIRCUITS_SEARCH = "circuits"
    }

    @GET(API_DRIVER_SEARCH)
    suspend fun getSearchDriver(
        @Query("id") id: Int
    ): DriverSearchResponse

    @GET(API_DRIVER_STANDING)
    suspend fun getDriverStanding(
        @Query("season") year: String,
    ): DriverStandingList

    @GET(API_TEAM_STANDING)
    suspend fun getTeamStanding(
        @Query("season") year: String
    ): TeamStandingList

    @GET(API_TEAM_SEARCH)
    suspend fun getSearchTeam(
        @Query("id") id: Int
    ): TeamSearchResponse

    @GET(API_DRIVER_STANDING)
    suspend fun getSearchDriverByTeam(
        @Query("team") teamID: Int,
        @Query("season") year: String
    ): DriverStandingList

    @GET(API_CIRCUITS_SEARCH)
    suspend fun getCircuits(): CircuitSearchResponse

    @GET(API_CIRCUITS_SEARCH)
    suspend fun searchCircuits(
        @Query("id") searchKey: String
    ): CircuitSearchResponse
}
