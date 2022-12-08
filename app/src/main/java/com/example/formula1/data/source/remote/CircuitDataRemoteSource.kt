package com.example.formula1.data.source.remote

import com.example.formula1.data.model.CircuitSearchResponse
import com.example.formula1.data.source.CircuitDataSource

class CircuitDataRemoteSource(private val apiService: APIService): CircuitDataSource.Remote {

    override suspend fun getCircuitResult(): CircuitSearchResponse {
       return apiService.getCircuits()
    }

    override suspend fun searchCircuitResult(searchKey: String): CircuitSearchResponse {
        return apiService.searchCircuits(searchKey)
    }
}
