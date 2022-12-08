package com.example.formula1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.formula1.data.model.CircuitSearchResponse
import com.example.formula1.data.repository.CircuitRepository
import com.example.formula1.utils.base.BaseViewModel

class CircuitViewModel(private val repository: CircuitRepository) : BaseViewModel() {

    private val _searchResult = MutableLiveData<CircuitSearchResponse>()
    val searchResult: LiveData<CircuitSearchResponse> get() = _searchResult

    fun getCircuit() {
        launchAsync(
            request = { repository.getCircuitResult() },
            onSuccess = {
                _searchResult.value = it
            },
            onError = {
                it.message.toString()
            })
    }

    fun searchCircuit(searchKey: String) {
        launchAsync(
            request = { repository.searchCircuitResult(searchKey) },
            onSuccess = {
                _searchResult.value = it
            },
            onError = {
                it.message.toString()
            })
    }
}
