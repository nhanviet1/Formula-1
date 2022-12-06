package com.example.formula1.data.repository

import com.example.formula1.data.model.DriverSearchResponse
import com.example.formula1.data.model.DriverStandingList
import com.example.formula1.data.model.TeamSearchResponse
import com.example.formula1.data.model.TeamStandingList
import com.example.formula1.data.model.driverstanding.Driver
import com.example.formula1.data.source.SearchDataSource
import com.example.formula1.utils.DataResult
import com.example.formula1.utils.base.BaseRepository

class SearchRepositoryImplement(
    private val remote: SearchDataSource.Remote,
    private val local: SearchDataSource.Local
) :
    BaseRepository(),
    SearchRepository {

    override suspend fun getSearchResult(
        id: Int
    ): DataResult<DriverSearchResponse> {
        return getResult { remote.getSearchResult(id) }
    }

    override suspend fun getDriverStandingResult(
        year: String
    ): DataResult<DriverStandingList> {
        return getResult { remote.getDriverStanding(year) }
    }

    override suspend fun getTeamStandingResult(
        year: String
    ): DataResult<TeamStandingList> {
        return getResult { remote.getTeamStanding(year) }
    }

    override suspend fun getDriver(): DataResult<List<Driver>> {
        return getResult { local.getDriverHistory() }
    }

    override suspend fun insertDriver(
        driver: Driver
    ): DataResult<Unit> {
        return getResult {
            local.insertDriver(driver)
        }
    }

    override suspend fun getTeamDetail(
        id: Int
    ): DataResult<TeamSearchResponse> {
        return getResult {
            remote.getTeamSearchResult(id)
        }
    }

    override suspend fun getSearchDriverByTeam(
        teamID: Int,
        season: String
    ): DataResult<DriverStandingList> {
        return getResult {
            remote.getSearchByTeamResult(teamID, season)
        }
    }
}
