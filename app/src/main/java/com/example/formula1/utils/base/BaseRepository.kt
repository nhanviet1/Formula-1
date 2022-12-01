package com.example.formula1.utils.base

import com.example.formula1.utils.DataResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.withContext
import java.io.IOException

open class BaseRepository {

    suspend fun <T> getResult(dispatcher: CoroutineDispatcher, request: suspend CoroutineScope.() -> T): DataResult<T> {
        return withContext(dispatcher) {
            try {
                DataResult.Success(request())
            } catch (e: IOException) {
                DataResult.Error(e)
            }
        }
    }
}
