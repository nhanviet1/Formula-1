package com.example.formula1.data.repository

import com.example.formula1.data.model.CircuitSearchResponse
import com.example.formula1.data.source.CircuitDataSource
import com.example.formula1.utils.DataResult
import com.example.formula1.utils.base.BaseRepository

class CircuitRepositoryImplement(
    private val remote: CircuitDataSource.Remote,
) : BaseRepository(), CircuitRepository {

    override suspend fun getCircuitResult(): DataResult<CircuitSearchResponse> {
        return getResult { remote.getCircuitResult() }
    }

    override suspend fun searchCircuitResult(searchKey: String): DataResult<CircuitSearchResponse> {
        return getResult { remote.searchCircuitResult(searchKey) }
    }
}
