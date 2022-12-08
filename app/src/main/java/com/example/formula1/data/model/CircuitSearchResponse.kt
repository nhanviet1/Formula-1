package com.example.formula1.data.model

import com.example.formula1.data.model.circuitsearchitem.Response

data class CircuitSearchResponse(
    val get: String?,
    val response: List<Response>?,
    val results: Int?
)
