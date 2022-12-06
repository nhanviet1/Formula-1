package com.example.formula1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.formula1.data.model.DriverStandingList
import com.example.formula1.data.model.TeamSearchResponse
import com.example.formula1.data.repository.SearchRepository
import com.example.formula1.utils.base.BaseViewModel

class TeamDetailViewModel(private val repository: SearchRepository) : BaseViewModel() {

    private val _driverSearchResult = MutableLiveData<DriverStandingList>()
    val driverSearchResult: LiveData<DriverStandingList> get() = _driverSearchResult

    private val _teamDetail = MutableLiveData<TeamSearchResponse>()
    val teamDetail: LiveData<TeamSearchResponse> get() = _teamDetail

    private val _carURL = MutableLiveData<Int>()
    val carURL: LiveData<Int> get() = _carURL

    fun searchDriverByTeam(id: Int, season: String) {
        launchAsync(
            request = { repository.getSearchDriverByTeam(id, season) },
            onSuccess = {
                _driverSearchResult.value = it
            },
            onError = {
                it.message.toString()
            })
    }

    fun getTeamDetail(id: Int) {
        launchAsync(
            request = { repository.getTeamDetail(id) },
            onSuccess = {
                _teamDetail.value = it
            },
            onError = {
                it.message.toString()
            })
    }

    fun setCarImg(id: Int) {
        _carURL.value = id
    }

}
