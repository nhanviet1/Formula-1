package com.example.formula1.data.source

import com.example.formula1.data.model.CircuitSearchResponse

interface CircuitDataSource {
    interface Remote {
        suspend fun getCircuitResult(): CircuitSearchResponse

        suspend fun searchCircuitResult(searchKey: String): CircuitSearchResponse
    }
}
