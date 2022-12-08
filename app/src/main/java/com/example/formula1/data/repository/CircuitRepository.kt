package com.example.formula1.data.repository

import com.example.formula1.data.model.CircuitSearchResponse

import com.example.formula1.utils.DataResult

interface CircuitRepository {
    suspend fun getCircuitResult(): DataResult<CircuitSearchResponse>
    suspend fun searchCircuitResult(searchKey: String): DataResult<CircuitSearchResponse>
}
